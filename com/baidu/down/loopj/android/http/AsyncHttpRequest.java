package com.baidu.down.loopj.android.http;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.down.common.intercepter.AbstractResponseIntercept;
import com.baidu.down.common.intercepter.IIntercepter;
import com.baidu.down.common.intercepter.InterceptResult;
import com.baidu.down.loopj.android.http.exp.HandlerRetryException;
import com.baidu.down.loopj.android.http.exp.IntercepterException;
import com.baidu.down.loopj.android.http.exp.RetryStrategyException;
import com.baidu.down.loopj.android.request.handler.ICommonRequestHandler;
import com.baidu.down.loopj.android.request.handler.RedirectException;
import com.baidu.down.loopj.android.request.handler.UrlConnectionRequestHandler;
import com.baidu.down.request.task.AbstractTask;
import com.baidu.down.request.taskmanager.ByteArrayInfo;
import com.baidu.down.request.taskmanager.HttpDNSInfo;
import com.baidu.down.request.taskmanager.OnFetchDataRequestListener;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.down.retry.HttpRetryStrategyHandler;
import com.baidu.down.retry.RetryRequestInfo;
import com.baidu.down.statistic.ThreadSpeedStat;
import com.baidu.down.utils.TrafficStatsUtils;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidubce.http.Headers;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ConnectException;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;
import javax.net.ssl.SSLException;
import javax.security.cert.CertificateException;
import org.apache.http.conn.ConnectTimeoutException;
/* loaded from: classes3.dex */
public class AsyncHttpRequest implements Runnable {
    private static final boolean DEBUG = false;
    private static final String TAG = "AsyncHttpRequest";
    private long curPos;
    private int executionCount;
    private int executionMaxCount;
    private boolean isBinaryRequest;
    public boolean isInterrupt;
    private final Object lock;
    private Thread mCurrentThread;
    private boolean mEncodeURl;
    private int mFailType;
    public HttpRetryStrategyHandler mHttpRetryStrategyHandler;
    private ICommonRequestHandler mICommonRequestHandler;
    private boolean mIsWaitingForRetry;
    private boolean mNeedAcquiredRetryStrategy;
    public long mRequestConnectedTime;
    private int mRequestStage;
    private int mRetryFrequency;
    private boolean mSkipHttpsCertificate;
    private ThreadSpeedStat mThreadSpeedStat;
    private HashSet<String> redirectUrls;
    protected BinaryHttpResponseHandler responseHandler;

    public AsyncHttpRequest(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        this.isInterrupt = false;
        this.executionCount = 0;
        this.executionMaxCount = 0;
        this.lock = new Object();
        this.curPos = 0L;
        this.mIsWaitingForRetry = false;
        this.mCurrentThread = null;
        this.mFailType = -1;
        this.mNeedAcquiredRetryStrategy = true;
        this.mRetryFrequency = 0;
        this.mRequestStage = 1;
        this.mSkipHttpsCertificate = true;
        this.mThreadSpeedStat = null;
        this.mEncodeURl = false;
        this.responseHandler = (BinaryHttpResponseHandler) asyncHttpResponseHandler;
        if (asyncHttpResponseHandler instanceof BinaryHttpResponseHandler) {
            this.isBinaryRequest = true;
        }
        this.mHttpRetryStrategyHandler = this.responseHandler.mtask.mHttpRetryStrategyHandler;
    }

    public AsyncHttpRequest(ICommonRequestHandler iCommonRequestHandler, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        this(asyncHttpResponseHandler);
        this.redirectUrls = new HashSet<>();
        this.redirectUrls.add(iCommonRequestHandler.getUrl());
        this.mICommonRequestHandler = iCommonRequestHandler;
        newThreadSpeedStat();
        if (this.mHttpRetryStrategyHandler.HttpDNSCacheAvailable()) {
            this.mNeedAcquiredRetryStrategy = false;
            this.mRequestStage = 2;
            retryWithStrategy();
        }
    }

    private boolean processRange(boolean z) {
        long j;
        long j2;
        long j3;
        if (!(this.responseHandler instanceof BinaryHttpResponseHandler) || this.responseHandler.mtask.mStatus == 1004 || this.responseHandler.mtask.mStatus == 1006) {
            return false;
        }
        AbstractTask abstractTask = this.responseHandler.mtask;
        String onGetRequestHeader = this.mICommonRequestHandler.onGetRequestHeader(Headers.RANGE);
        if (onGetRequestHeader == null) {
            return false;
        }
        String[] split = onGetRequestHeader.trim().split("[=-]");
        String str = "";
        String str2 = "";
        if (split != null && split.length > 2) {
            str = split[1].trim();
            str2 = split[2].trim();
        } else if (split != null && split.length > 1) {
            str = split[1].trim();
        }
        long j4 = 0;
        try {
            j4 = Long.valueOf(str).longValue();
            Long.valueOf(str2).longValue();
            j = j4;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            j = j4;
        }
        if (z) {
            j2 = abstractTask.mProgressInfo.getSegCurrentByPos(j);
        } else {
            j2 = this.curPos > j ? this.curPos : j;
        }
        long segEndByPos = abstractTask.mProgressInfo.getSegEndByPos(j);
        if (segEndByPos == Long.MAX_VALUE) {
            j2 = abstractTask.mProgressInfo.getSegCurrentByPos(j);
            str2 = "";
        }
        if (j2 < segEndByPos) {
            if (segEndByPos != Long.MAX_VALUE && TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().isWap()) {
                if ((BdStatsConstant.MAX_WRITTING_FILE_SIZE_AFTER_RENAME_FAILED + j2) - 1 < segEndByPos) {
                    j3 = (BdStatsConstant.MAX_WRITTING_FILE_SIZE_AFTER_RENAME_FAILED + j2) - 2;
                } else {
                    j3 = segEndByPos - 1;
                }
                str2 = String.valueOf(j3);
            }
            this.mICommonRequestHandler.onSetRequestHeader(Headers.RANGE, "bytes=" + j2 + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2);
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [320=4, 319=4] */
    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.mCurrentThread = Thread.currentThread();
        int i = TaskFacade.getInstance(null).getBinaryTaskMng().getDownConfig().mTrafficStatsTag;
        try {
            if (i != 0) {
                try {
                    TrafficStatsUtils.setThreadStatsTag(i);
                } catch (HandlerCdnRedirectException e) {
                    if (isMultiSrcStageBeforeOrExe()) {
                        ((MultiSrcBinaryTaskHandler) this.responseHandler).multiSrcToNormal();
                    }
                    if (i != 0) {
                        TrafficStatsUtils.clearThreadStatsTag();
                        return;
                    }
                    return;
                } catch (Exception e2) {
                    if (this.mThreadSpeedStat != null) {
                        this.mThreadSpeedStat.drs = "f";
                        this.mThreadSpeedStat.downEndTime = SystemClock.elapsedRealtime();
                    }
                    if (this.responseHandler != null) {
                        this.responseHandler.sendFinishMessage();
                        if (this.isBinaryRequest) {
                            this.responseHandler.sendFailureMessage(e2, null, this.mFailType);
                        } else {
                            this.responseHandler.sendFailureMessage(e2, null);
                        }
                    }
                    if (i != 0) {
                        TrafficStatsUtils.clearThreadStatsTag();
                        return;
                    }
                    return;
                }
            }
            if (this.responseHandler != null) {
                this.responseHandler.sendStartMessage();
            }
            makeRequestWithRetries();
            if (this.responseHandler != null) {
                this.responseHandler.sendFinishMessage();
            }
            if (this.mThreadSpeedStat != null) {
                if (this.responseHandler == null || this.responseHandler.mRunning || !this.isInterrupt) {
                    this.mThreadSpeedStat.drs = "s";
                } else {
                    this.mThreadSpeedStat.drs = "c";
                }
                this.mThreadSpeedStat.downEndTime = SystemClock.elapsedRealtime();
            }
            if (i != 0) {
                TrafficStatsUtils.clearThreadStatsTag();
            }
        } catch (Throwable th) {
            if (i != 0) {
                TrafficStatsUtils.clearThreadStatsTag();
            }
            throw th;
        }
    }

    public void cancelRequest() {
        if (this.mThreadSpeedStat != null && TextUtils.isEmpty(this.mThreadSpeedStat.drs)) {
            this.mThreadSpeedStat.drs = "c";
            this.mThreadSpeedStat.downEndTime = SystemClock.elapsedRealtime();
        }
        this.mICommonRequestHandler.cancelRequest();
    }

    public void interruptRetryWaiting() {
        if (this.mIsWaitingForRetry && this.mCurrentThread != null) {
            this.mCurrentThread.interrupt();
        }
    }

    private void makeRequest() throws IOException, HandlerRedirectException, HandlerCdnRedirectException, RedirectException {
        if (!this.isInterrupt) {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                this.mICommonRequestHandler.onExeHttpConnect(this.responseHandler, this.mThreadSpeedStat, this.mEncodeURl);
                this.mEncodeURl = false;
                this.mRequestConnectedTime = SystemClock.elapsedRealtime() - elapsedRealtime;
                if (this.mThreadSpeedStat != null) {
                    this.mThreadSpeedStat.downStartConnectTime = elapsedRealtime;
                    this.mThreadSpeedStat.downEndConnectTime = SystemClock.elapsedRealtime();
                }
                if (!isMultiSrcStageBeforeOrExe() && this.mICommonRequestHandler.getHttpStatus() == 403 && this.mICommonRequestHandler.onContainsRequestHeader(Headers.RANGE)) {
                    this.mICommonRequestHandler.onRemoveRequestHeader(Headers.RANGE);
                    throw new HandlerRetryException("403 with range");
                } else if (this.mICommonRequestHandler.getHttpStatus() == 412 && this.mICommonRequestHandler.onContainsRequestHeader("If-Match")) {
                    this.mICommonRequestHandler.onRemoveRequestHeader("If-Match");
                    throw new HandlerRetryException("412 with If-Match");
                } else if (this.mICommonRequestHandler.getHttpStatus() == 404 && Integer.parseInt(Build.VERSION.SDK) < 21 && this.executionCount == 0) {
                    this.mEncodeURl = true;
                    throw new HandlerRetryException("404 with path");
                } else {
                    if (this.responseHandler.mtask.mIntercepters.containsKey(IIntercepter.TYPE_RESPONSE)) {
                        IIntercepter<?> iIntercepter = this.responseHandler.mtask.mIntercepters.get(IIntercepter.TYPE_RESPONSE);
                        if (iIntercepter instanceof AbstractResponseIntercept) {
                            InterceptResult process = ((AbstractResponseIntercept) iIntercepter).process(this.responseHandler.mtask.mContext, this.responseHandler.mtask.getTaskKey(), this.responseHandler.mtask.mDownloadId, this.mICommonRequestHandler.getResponseInfo());
                            if (process != null && process.retCode == 2) {
                                this.mFailType = 4;
                                throw new IntercepterException(process.interceptMsg);
                            } else if (process != null && process.retCode == 1) {
                                this.responseHandler.mtask.pause();
                                return;
                            } else if (process != null && process.retCode == 4 && this.mNeedAcquiredRetryStrategy) {
                                this.mFailType = 6;
                                throw new RetryStrategyException("302 hijack");
                            }
                        }
                    }
                    if (this.mICommonRequestHandler.getHttpStatus() == 200 || this.mICommonRequestHandler.getHttpStatus() == 206) {
                        this.executionCount = 0;
                        this.mNeedAcquiredRetryStrategy = false;
                        if (this.mRequestStage == 2) {
                            this.mRequestStage = 4;
                            this.mHttpRetryStrategyHandler.setRetryType(3);
                            this.mHttpRetryStrategyHandler.appendDownDetail(hashCode(), HttpRetryStatistic.buildRetryStatistic(this.mICommonRequestHandler.getUrl(), "s", this.mICommonRequestHandler.onGetRequestHeader("host")));
                        }
                        this.redirectUrls.clear();
                    }
                    if (this.mICommonRequestHandler.getHttpStatus() == 301 || this.mICommonRequestHandler.getHttpStatus() == 303 || this.mICommonRequestHandler.getHttpStatus() == 302) {
                        try {
                            this.mICommonRequestHandler.onHandleFollowRedirect(this.redirectUrls);
                        } catch (RedirectException e) {
                            throw e;
                        }
                    }
                    if (this.responseHandler != null) {
                        if (this.mICommonRequestHandler.getHttpStatus() == 503 && isMultiSrcStageBeforeOrExe()) {
                            try {
                                ((MultiSrcBinaryTaskHandler) this.responseHandler).handlerCDNRedirectUrl(this.mICommonRequestHandler, this);
                                throw new HandlerCdnRedirectException();
                            } catch (IllegalArgumentException e2) {
                                throw new HandlerRedirectException("Invalid uri: " + this.mICommonRequestHandler.onGetHttpHeader(true));
                            }
                        } else if (!this.isInterrupt) {
                            long sendResponseMessage = this.responseHandler.sendResponseMessage(this.mICommonRequestHandler, this);
                            if (sendResponseMessage > this.curPos) {
                                this.curPos = sendResponseMessage;
                            }
                        }
                    }
                }
            } catch (IOException e3) {
                if (e3 instanceof ConnectTimeoutException) {
                    this.mICommonRequestHandler.closeConnection();
                }
                if (!this.isInterrupt) {
                    throw e3;
                }
            }
        }
    }

    private void makeRequestWithRetries() throws ConnectException, RedirectException {
        boolean z;
        AbstractTask abstractTask;
        InterceptResult process;
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        boolean z2 = true;
        while (z2) {
            try {
                abstractTask = this.responseHandler.mtask;
            } catch (HandlerCdnRedirectException e) {
                if (this.mICommonRequestHandler.isHttpRequestNull()) {
                    throw new HandlerCdnRedirectException();
                }
            } catch (HandlerRetryException e2) {
                z2 = true;
            } catch (IOException e3) {
                this.mFailType = 0;
                processRange(true);
                e3.printStackTrace(printWriter);
                printWriter.append((CharSequence) ("-----" + SystemClock.elapsedRealtime() + "-----\n"));
                if (!this.responseHandler.mSupportRange) {
                    printWriter.append((CharSequence) "\n### cannot support range!");
                    z = false;
                } else if (isMultiSrcStageBeforeOrExe()) {
                    this.mICommonRequestHandler.restoreRequest();
                    ((MultiSrcBinaryTaskHandler) this.responseHandler).handlerCDNRedirectUrl(this.mICommonRequestHandler, this);
                    if (this.mICommonRequestHandler.isHttpRequestNull()) {
                        throw new HandlerCdnRedirectException();
                    }
                    z = z2;
                } else if (skipHttpsCertificate(e3)) {
                    this.mSkipHttpsCertificate = false;
                    this.mICommonRequestHandler.setTlsCertSkip(true);
                    z = true;
                } else if (this.mHttpRetryStrategyHandler.isAcquireRetryStrategy(this.mNeedAcquiredRetryStrategy, e3, this.mRetryFrequency)) {
                    if (this.mNeedAcquiredRetryStrategy) {
                        this.mHttpRetryStrategyHandler.setRetryException(e3);
                    } else {
                        this.mHttpRetryStrategyHandler.appendDownDetail(hashCode(), HttpRetryStatistic.buildRetryStatistic(this.mICommonRequestHandler.getUrl(), "f", this.mICommonRequestHandler.onGetRequestHeader("host")));
                    }
                    this.mNeedAcquiredRetryStrategy = false;
                    this.mRequestStage = 2;
                    synchronized (this.responseHandler.mtask) {
                        this.mHttpRetryStrategyHandler.retryStrategy(e3, new HttpRetryStrategyHandler.OnFetchDataResultListener() { // from class: com.baidu.down.loopj.android.http.AsyncHttpRequest.1
                            @Override // com.baidu.down.retry.HttpRetryStrategyHandler.OnFetchDataResultListener
                            public void onResult(boolean z3) {
                                if (z3) {
                                    AsyncHttpRequest.this.retryWithStrategy();
                                } else {
                                    AsyncHttpRequest.this.mRequestStage = 3;
                                }
                                synchronized (AsyncHttpRequest.this.responseHandler.mtask) {
                                    AsyncHttpRequest.this.responseHandler.mtask.notify();
                                }
                            }
                        });
                        z = true;
                    }
                } else if (URLUtil.isHttpsUrl(this.mICommonRequestHandler.getUrl())) {
                    this.mICommonRequestHandler.cloneRequest(this.mICommonRequestHandler.getUrl().replaceFirst(SapiUtils.COOKIE_HTTPS_URL_PREFIX, "http://"));
                    this.mICommonRequestHandler.restoreRequest();
                    z = true;
                } else {
                    if (this.mRequestStage == 2) {
                        this.mHttpRetryStrategyHandler.setRetryType(4);
                        this.mHttpRetryStrategyHandler.appendDownDetail(hashCode(), HttpRetryStatistic.buildRetryStatistic(this.mICommonRequestHandler.getUrl(), "f", this.mICommonRequestHandler.onGetRequestHeader("host")));
                    }
                    this.mICommonRequestHandler.restoreRequest();
                    this.mIsWaitingForRetry = true;
                    ICommonRequestHandler iCommonRequestHandler = this.mICommonRequestHandler;
                    int i = this.executionCount + 1;
                    this.executionCount = i;
                    int i2 = this.executionMaxCount + 1;
                    this.executionMaxCount = i2;
                    boolean onRetryRequest = iCommonRequestHandler.onRetryRequest(e3, i, i2);
                    if (this.mThreadSpeedStat != null) {
                        this.mThreadSpeedStat.drnum++;
                    }
                    this.mIsWaitingForRetry = false;
                    this.mRequestStage = 3;
                    if (onRetryRequest && (this.responseHandler instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) this.responseHandler).isNeedMultiSrc()) {
                        MultiSrcBinaryTaskHandler multiSrcBinaryTaskHandler = (MultiSrcBinaryTaskHandler) this.responseHandler;
                        if (multiSrcBinaryTaskHandler.isReTryDownloadInfo() && !this.isInterrupt) {
                            ((MultiSrcBinaryTaskHandler) this.responseHandler).mMultiSrcStatData.dbtype = 3;
                            multiSrcBinaryTaskHandler.retryDownloadInfo(new OnFetchDataRequestListener() { // from class: com.baidu.down.loopj.android.http.AsyncHttpRequest.2
                                @Override // com.baidu.down.request.taskmanager.OnFetchDataRequestListener
                                public void afterRequest(boolean z3, TreeSet<HttpDNSInfo> treeSet) {
                                    if (z3) {
                                        ((MultiSrcBinaryTaskHandler) AsyncHttpRequest.this.responseHandler).handlerReplaceUrl(AsyncHttpRequest.this.mICommonRequestHandler, AsyncHttpRequest.this);
                                    }
                                    synchronized (AsyncHttpRequest.this.lock) {
                                        AsyncHttpRequest.this.lock.notify();
                                    }
                                }
                            });
                            try {
                                synchronized (this.lock) {
                                    this.lock.wait();
                                    if (this.mICommonRequestHandler.isHttpRequestNull()) {
                                        throw new HandlerCdnRedirectException();
                                        break;
                                    }
                                    z = onRetryRequest;
                                }
                            } catch (InterruptedException e4) {
                                e4.printStackTrace();
                                z = onRetryRequest;
                                z2 = z;
                            }
                        }
                    }
                    z = onRetryRequest;
                }
                z2 = z;
            } catch (NullPointerException e5) {
                this.mFailType = 0;
                if (this.mRequestStage == 2) {
                    this.mHttpRetryStrategyHandler.setRetryType(4);
                    this.mHttpRetryStrategyHandler.appendDownDetail(hashCode(), HttpRetryStatistic.buildRetryStatistic(this.mICommonRequestHandler.getUrl(), "f", this.mICommonRequestHandler.onGetRequestHeader("host")));
                }
                this.mICommonRequestHandler.restoreRequest();
                processRange(true);
                IOException iOException = new IOException("NPE in HttpClient" + e5.getMessage());
                iOException.printStackTrace(printWriter);
                printWriter.append((CharSequence) ("-----" + SystemClock.elapsedRealtime() + "-----\n"));
                if (!this.responseHandler.mSupportRange) {
                    printWriter.append((CharSequence) "\n### cannot support range!");
                    z2 = false;
                } else if (isMultiSrcStageBeforeOrExe()) {
                    ((MultiSrcBinaryTaskHandler) this.responseHandler).handlerCDNRedirectUrl(this.mICommonRequestHandler, this);
                    if (this.mICommonRequestHandler.isHttpRequestNull()) {
                        throw new HandlerCdnRedirectException();
                    }
                } else {
                    this.mIsWaitingForRetry = true;
                    ICommonRequestHandler iCommonRequestHandler2 = this.mICommonRequestHandler;
                    int i3 = this.executionCount + 1;
                    this.executionCount = i3;
                    int i4 = this.executionMaxCount + 1;
                    this.executionMaxCount = i4;
                    z2 = iCommonRequestHandler2.onRetryRequest(iOException, i3, i4);
                    if (this.mThreadSpeedStat != null) {
                        this.mThreadSpeedStat.drnum++;
                    }
                    this.mIsWaitingForRetry = false;
                    this.mRequestStage = 3;
                }
            }
            if (this.executionCount > 0 && abstractTask.mIntercepters != null && abstractTask.mIntercepters.containsKey("network") && (process = abstractTask.mIntercepters.get("network").process(this.responseHandler.mtask.mContext, abstractTask.getTaskKey(), abstractTask.mDownloadId, null)) != null && process.retCode == 1) {
                abstractTask.pause();
                return;
            }
            makeRequest();
            if (this.isInterrupt || ((this.responseHandler != null && !this.responseHandler.mRunning) || !processRange(false))) {
                if (this.responseHandler != null && !this.responseHandler.mRunning && this.isInterrupt) {
                    this.responseHandler.sendPausedMessage();
                    return;
                } else if (this.responseHandler instanceof BinaryHttpResponseHandler) {
                    ByteArrayInfo byteArray = TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().getByteArray();
                    byteArray.mFilePos = this.curPos;
                    byteArray.mByteArrayLength = -1;
                    this.responseHandler.sendDownloadMessage(byteArray);
                    return;
                } else {
                    return;
                }
            }
        }
        throw new ConnectException(stringWriter.toString());
    }

    private boolean isMultiSrcStageBeforeOrExe() {
        return (this.responseHandler instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) this.responseHandler).isNeedMultiSrc() && ((MultiSrcBinaryTaskHandler) this.responseHandler).getTestSpeedStage() != 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryWithStrategy() {
        if (this.mRetryFrequency == 0) {
            this.mICommonRequestHandler.saveRequest();
        }
        ICommonRequestHandler iCommonRequestHandler = this.mICommonRequestHandler;
        List<RetryRequestInfo> retryRequestInfoList = this.mHttpRetryStrategyHandler.getRetryRequestInfoList();
        int i = this.mRetryFrequency;
        this.mRetryFrequency = i + 1;
        iCommonRequestHandler.replaceRequest(retryRequestInfoList.get(i));
        if (this.mThreadSpeedStat != null) {
            this.mThreadSpeedStat.drnum++;
        }
    }

    private boolean skipHttpsCertificate(Exception exc) {
        return ((exc instanceof SSLException) || (exc instanceof CertificateException)) && this.mSkipHttpsCertificate && (this.mICommonRequestHandler instanceof UrlConnectionRequestHandler);
    }

    public ThreadSpeedStat getThreadSpeedStat() {
        return this.mThreadSpeedStat;
    }

    public void newThreadSpeedStat() {
        if (this.responseHandler.mtask.mTaskSpeedStat.speedStatEnable) {
            this.mThreadSpeedStat = new ThreadSpeedStat();
            this.responseHandler.mtask.mTaskSpeedStat.addThreadSpeedStat(this.mThreadSpeedStat);
            this.mThreadSpeedStat.downStartTime = SystemClock.elapsedRealtime();
            this.mThreadSpeedStat.cqid = this.responseHandler.mtask.mTaskSpeedStat.generateCqid(this.responseHandler.mtask.mContext);
        }
    }

    public void setDownStartPos(long j) {
        if (this.mThreadSpeedStat.dstart == -1) {
            this.mThreadSpeedStat.dstart = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class HandlerRedirectException extends RuntimeException {
        private static final long serialVersionUID = -4422626752285372402L;

        public HandlerRedirectException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class HandlerCdnRedirectException extends RuntimeException {
        private static final long serialVersionUID = -5562528406378234456L;

        private HandlerCdnRedirectException() {
        }
    }
}
