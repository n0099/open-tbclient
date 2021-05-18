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
import com.baidu.down.request.taskmanager.HttpDNSInfo;
import com.baidu.down.request.taskmanager.OnFetchDataRequestListener;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.down.retry.HttpRetryStrategyHandler;
import com.baidu.down.retry.RetryRequestInfo;
import com.baidu.down.statistic.ThreadSpeedStat;
import com.baidu.down.utils.TrafficStatsUtils;
import com.baidu.searchbox.bddownload.core.Util;
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
/* loaded from: classes2.dex */
public class AsyncHttpRequest implements Runnable {
    public static final boolean DEBUG = false;
    public static final String TAG = "AsyncHttpRequest";
    public long curPos;
    public int executionCount;
    public int executionMaxCount;
    public boolean isBinaryRequest;
    public boolean isInterrupt;
    public final Object lock;
    public Thread mCurrentThread;
    public boolean mEncodeURl;
    public int mFailType;
    public HttpRetryStrategyHandler mHttpRetryStrategyHandler;
    public ICommonRequestHandler mICommonRequestHandler;
    public boolean mIsWaitingForRetry;
    public boolean mNeedAcquiredRetryStrategy;
    public long mRequestConnectedTime;
    public int mRequestStage;
    public int mRetryFrequency;
    public boolean mSkipHttpsCertificate;
    public ThreadSpeedStat mThreadSpeedStat;
    public HashSet<String> redirectUrls;
    public BinaryHttpResponseHandler responseHandler;

    /* loaded from: classes2.dex */
    public static class HandlerCdnRedirectException extends RuntimeException {
        public static final long serialVersionUID = -5562528406378234456L;

        public HandlerCdnRedirectException() {
        }
    }

    /* loaded from: classes2.dex */
    public static class HandlerRedirectException extends RuntimeException {
        public static final long serialVersionUID = -4422626752285372402L;

        public HandlerRedirectException(String str) {
            super(str);
        }
    }

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

    private boolean isMultiSrcStageBeforeOrExe() {
        BinaryHttpResponseHandler binaryHttpResponseHandler = this.responseHandler;
        return (binaryHttpResponseHandler instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).isNeedMultiSrc() && ((MultiSrcBinaryTaskHandler) this.responseHandler).getTestSpeedStage() != 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f1, code lost:
        if (r0.retCode != 1) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f3, code lost:
        r12.responseHandler.mtask.pause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fa, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void makeRequest() throws IOException, HandlerRedirectException, HandlerCdnRedirectException, RedirectException {
        if (this.isInterrupt) {
            return;
        }
        try {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.mICommonRequestHandler.onExeHttpConnect(this.responseHandler, this.mThreadSpeedStat, this.mEncodeURl);
            this.mEncodeURl = false;
            this.mRequestConnectedTime = SystemClock.elapsedRealtime() - elapsedRealtime;
            if (this.mThreadSpeedStat != null) {
                this.mThreadSpeedStat.downStartConnectTime = elapsedRealtime;
                this.mThreadSpeedStat.downEndConnectTime = SystemClock.elapsedRealtime();
            }
            if (!isMultiSrcStageBeforeOrExe() && this.mICommonRequestHandler.getHttpStatus() == 403 && this.mICommonRequestHandler.onContainsRequestHeader("Range")) {
                this.mICommonRequestHandler.onRemoveRequestHeader("Range");
                throw new HandlerRetryException("403 with range");
            }
            if (this.mICommonRequestHandler.getHttpStatus() == 412 && this.mICommonRequestHandler.onContainsRequestHeader(Util.IF_MATCH)) {
                this.mICommonRequestHandler.onRemoveRequestHeader(Util.IF_MATCH);
                throw new HandlerRetryException("412 with If-Match");
            }
            if (this.mICommonRequestHandler.getHttpStatus() == 404 && Integer.parseInt(Build.VERSION.SDK) < 21 && this.executionCount == 0) {
                this.mEncodeURl = true;
                throw new HandlerRetryException("404 with path");
            }
            if (this.responseHandler.mtask.mIntercepters.containsKey("response")) {
                IIntercepter<?> iIntercepter = this.responseHandler.mtask.mIntercepters.get("response");
                if (iIntercepter instanceof AbstractResponseIntercept) {
                    InterceptResult process = ((AbstractResponseIntercept) iIntercepter).process(this.responseHandler.mtask.mContext, this.responseHandler.mtask.getTaskKey(), this.responseHandler.mtask.mDownloadId, this.mICommonRequestHandler.getResponseInfo());
                    if (process != null && process.retCode == 2) {
                        this.mFailType = 4;
                        throw new IntercepterException(process.interceptMsg);
                    }
                    if (process != null && process.retCode == 4 && this.mNeedAcquiredRetryStrategy) {
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
                String url = this.mICommonRequestHandler.getUrl();
                try {
                    this.mICommonRequestHandler.onHandleFollowRedirect(this.redirectUrls);
                    String url2 = this.mICommonRequestHandler.getUrl();
                    if (url2 != null && !url2.equals(url)) {
                        this.responseHandler.sendRedirectMessage(url2);
                    }
                } catch (RedirectException e2) {
                    throw e2;
                }
            }
            if (this.responseHandler != null) {
                if (this.mICommonRequestHandler.getHttpStatus() == 503 && isMultiSrcStageBeforeOrExe()) {
                    try {
                        ((MultiSrcBinaryTaskHandler) this.responseHandler).handlerCDNRedirectUrl(this.mICommonRequestHandler, this);
                        throw new HandlerCdnRedirectException();
                    } catch (IllegalArgumentException unused) {
                        throw new HandlerRedirectException("Invalid uri: " + this.mICommonRequestHandler.onGetHttpHeader(true));
                    }
                } else if (this.isInterrupt) {
                } else {
                    long sendResponseMessage = this.responseHandler.sendResponseMessage(this.mICommonRequestHandler, this);
                    if (sendResponseMessage > this.curPos) {
                        this.curPos = sendResponseMessage;
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

    /* JADX WARN: Code restructure failed: missing block: B:176:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
        if (r18.responseHandler == null) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0070, code lost:
        if (r18.responseHandler.mRunning != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        if (r18.isInterrupt == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0076, code lost:
        r18.responseHandler.sendPausedMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0080, code lost:
        if ((r18.responseHandler instanceof com.baidu.down.loopj.android.http.BinaryHttpResponseHandler) == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0082, code lost:
        r0 = com.baidu.down.request.taskmanager.TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().getByteArray();
        r0.mFilePos = r18.curPos;
        r0.mByteArrayLength = -1;
        r18.responseHandler.sendDownloadMessage(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x009e, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void makeRequestWithRetries() throws ConnectException, RedirectException {
        AbstractTask abstractTask;
        InterceptResult process;
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        loop0: while (true) {
            boolean z = true;
            while (z) {
                try {
                    abstractTask = this.responseHandler.mtask;
                } catch (HandlerCdnRedirectException unused) {
                    if (this.mICommonRequestHandler.isHttpRequestNull()) {
                        throw new HandlerCdnRedirectException();
                    }
                } catch (HandlerRetryException unused2) {
                } catch (IOException e2) {
                    this.mFailType = 0;
                    processRange(true);
                    e2.printStackTrace(printWriter);
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
                    } else if (skipHttpsCertificate(e2)) {
                        this.mSkipHttpsCertificate = false;
                        this.mICommonRequestHandler.setTlsCertSkip(true);
                    } else if (this.mHttpRetryStrategyHandler.isAcquireRetryStrategy(this.mNeedAcquiredRetryStrategy, e2, this.mRetryFrequency)) {
                        if (this.mNeedAcquiredRetryStrategy) {
                            this.mHttpRetryStrategyHandler.setRetryException(e2);
                        } else {
                            this.mHttpRetryStrategyHandler.appendDownDetail(hashCode(), HttpRetryStatistic.buildRetryStatistic(this.mICommonRequestHandler.getUrl(), "f", this.mICommonRequestHandler.onGetRequestHeader("host")));
                        }
                        this.mNeedAcquiredRetryStrategy = false;
                        this.mRequestStage = 2;
                        synchronized (this.responseHandler.mtask) {
                            this.mHttpRetryStrategyHandler.retryStrategy(e2, new HttpRetryStrategyHandler.OnFetchDataResultListener() { // from class: com.baidu.down.loopj.android.http.AsyncHttpRequest.1
                                @Override // com.baidu.down.retry.HttpRetryStrategyHandler.OnFetchDataResultListener
                                public void onResult(boolean z2) {
                                    if (z2) {
                                        AsyncHttpRequest.this.retryWithStrategy();
                                    } else {
                                        AsyncHttpRequest.this.mRequestStage = 3;
                                    }
                                    synchronized (AsyncHttpRequest.this.responseHandler.mtask) {
                                        AsyncHttpRequest.this.responseHandler.mtask.notify();
                                    }
                                }
                            });
                        }
                    } else if (URLUtil.isHttpsUrl(this.mICommonRequestHandler.getUrl())) {
                        ICommonRequestHandler iCommonRequestHandler = this.mICommonRequestHandler;
                        iCommonRequestHandler.cloneRequest(iCommonRequestHandler.getUrl().replaceFirst("https://", "http://"));
                        this.mICommonRequestHandler.restoreRequest();
                    } else {
                        if (this.mRequestStage == 2) {
                            this.mHttpRetryStrategyHandler.setRetryType(4);
                            this.mHttpRetryStrategyHandler.appendDownDetail(hashCode(), HttpRetryStatistic.buildRetryStatistic(this.mICommonRequestHandler.getUrl(), "f", this.mICommonRequestHandler.onGetRequestHeader("host")));
                        }
                        this.mICommonRequestHandler.restoreRequest();
                        this.mIsWaitingForRetry = true;
                        ICommonRequestHandler iCommonRequestHandler2 = this.mICommonRequestHandler;
                        int i2 = this.executionCount + 1;
                        this.executionCount = i2;
                        int i3 = this.executionMaxCount + 1;
                        this.executionMaxCount = i3;
                        z = iCommonRequestHandler2.onRetryRequest(e2, i2, i3);
                        ThreadSpeedStat threadSpeedStat = this.mThreadSpeedStat;
                        if (threadSpeedStat != null) {
                            threadSpeedStat.drnum++;
                        }
                        this.mIsWaitingForRetry = false;
                        this.mRequestStage = 3;
                        if (z) {
                            BinaryHttpResponseHandler binaryHttpResponseHandler = this.responseHandler;
                            if (!(binaryHttpResponseHandler instanceof MultiSrcBinaryTaskHandler)) {
                                continue;
                            } else if (((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).isNeedMultiSrc()) {
                                MultiSrcBinaryTaskHandler multiSrcBinaryTaskHandler = (MultiSrcBinaryTaskHandler) this.responseHandler;
                                if (!multiSrcBinaryTaskHandler.isReTryDownloadInfo()) {
                                    continue;
                                } else if (this.isInterrupt) {
                                    continue;
                                } else {
                                    ((MultiSrcBinaryTaskHandler) this.responseHandler).mMultiSrcStatData.dbtype = 3;
                                    multiSrcBinaryTaskHandler.retryDownloadInfo(new OnFetchDataRequestListener() { // from class: com.baidu.down.loopj.android.http.AsyncHttpRequest.2
                                        @Override // com.baidu.down.request.taskmanager.OnFetchDataRequestListener
                                        public void afterRequest(boolean z2, TreeSet<HttpDNSInfo> treeSet) {
                                            if (z2) {
                                                AsyncHttpRequest asyncHttpRequest = AsyncHttpRequest.this;
                                                ((MultiSrcBinaryTaskHandler) asyncHttpRequest.responseHandler).handlerReplaceUrl(asyncHttpRequest.mICommonRequestHandler, AsyncHttpRequest.this);
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
                                                break loop0;
                                            }
                                        }
                                    } catch (InterruptedException e3) {
                                        e3.printStackTrace();
                                    }
                                }
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                } catch (NullPointerException e4) {
                    this.mFailType = 0;
                    if (this.mRequestStage == 2) {
                        this.mHttpRetryStrategyHandler.setRetryType(4);
                        this.mHttpRetryStrategyHandler.appendDownDetail(hashCode(), HttpRetryStatistic.buildRetryStatistic(this.mICommonRequestHandler.getUrl(), "f", this.mICommonRequestHandler.onGetRequestHeader("host")));
                    }
                    this.mICommonRequestHandler.restoreRequest();
                    processRange(true);
                    IOException iOException = new IOException("NPE in HttpClient" + e4.getMessage());
                    iOException.printStackTrace(printWriter);
                    printWriter.append((CharSequence) ("-----" + SystemClock.elapsedRealtime() + "-----\n"));
                    if (!this.responseHandler.mSupportRange) {
                        printWriter.append((CharSequence) "\n### cannot support range!");
                        z = false;
                    } else if (isMultiSrcStageBeforeOrExe()) {
                        ((MultiSrcBinaryTaskHandler) this.responseHandler).handlerCDNRedirectUrl(this.mICommonRequestHandler, this);
                        if (this.mICommonRequestHandler.isHttpRequestNull()) {
                            throw new HandlerCdnRedirectException();
                        }
                    } else {
                        this.mIsWaitingForRetry = true;
                        ICommonRequestHandler iCommonRequestHandler3 = this.mICommonRequestHandler;
                        int i4 = this.executionCount + 1;
                        this.executionCount = i4;
                        int i5 = this.executionMaxCount + 1;
                        this.executionMaxCount = i5;
                        z = iCommonRequestHandler3.onRetryRequest(iOException, i4, i5);
                        ThreadSpeedStat threadSpeedStat2 = this.mThreadSpeedStat;
                        if (threadSpeedStat2 != null) {
                            threadSpeedStat2.drnum++;
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
                    break loop0;
                }
            }
            throw new ConnectException(stringWriter.toString());
        }
    }

    private boolean processRange(boolean z) {
        AbstractTask abstractTask;
        int i2;
        String onGetRequestHeader;
        String str;
        String str2;
        long j;
        BinaryHttpResponseHandler binaryHttpResponseHandler = this.responseHandler;
        if (!(binaryHttpResponseHandler instanceof BinaryHttpResponseHandler) || (i2 = (abstractTask = binaryHttpResponseHandler.mtask).mStatus) == 1004 || i2 == 1006 || (onGetRequestHeader = this.mICommonRequestHandler.onGetRequestHeader("Range")) == null) {
            return false;
        }
        String[] split = onGetRequestHeader.trim().split("[=-]");
        String str3 = "";
        if (split != null && split.length > 2) {
            String trim = split[1].trim();
            str2 = split[2].trim();
            str = trim;
        } else if (split == null || split.length <= 1) {
            str = "";
            str2 = str;
        } else {
            str = split[1].trim();
            str2 = "";
        }
        long j2 = 0;
        try {
            j2 = Long.valueOf(str).longValue();
            Long.valueOf(str2).longValue();
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
        if (z) {
            j = abstractTask.mProgressInfo.getSegCurrentByPos(j2);
        } else {
            j = this.curPos;
            if (j <= j2) {
                j = j2;
            }
        }
        long segEndByPos = abstractTask.mProgressInfo.getSegEndByPos(j2);
        int i3 = (segEndByPos > Long.MAX_VALUE ? 1 : (segEndByPos == Long.MAX_VALUE ? 0 : -1));
        if (i3 == 0) {
            j = abstractTask.mProgressInfo.getSegCurrentByPos(j2);
        } else {
            str3 = str2;
        }
        if (j < segEndByPos) {
            if (i3 != 0 && TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().isWap()) {
                long j3 = 307200 + j;
                str3 = String.valueOf(j3 - 1 < segEndByPos ? j3 - 2 : segEndByPos - 1);
            }
            ICommonRequestHandler iCommonRequestHandler = this.mICommonRequestHandler;
            iCommonRequestHandler.onSetRequestHeader("Range", "bytes=" + j + "-" + str3);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryWithStrategy() {
        if (this.mRetryFrequency == 0) {
            this.mICommonRequestHandler.saveRequest();
        }
        ICommonRequestHandler iCommonRequestHandler = this.mICommonRequestHandler;
        List<RetryRequestInfo> retryRequestInfoList = this.mHttpRetryStrategyHandler.getRetryRequestInfoList();
        int i2 = this.mRetryFrequency;
        this.mRetryFrequency = i2 + 1;
        iCommonRequestHandler.replaceRequest(retryRequestInfoList.get(i2));
        ThreadSpeedStat threadSpeedStat = this.mThreadSpeedStat;
        if (threadSpeedStat != null) {
            threadSpeedStat.drnum++;
        }
    }

    private boolean skipHttpsCertificate(Exception exc) {
        return ((exc instanceof SSLException) || (exc instanceof CertificateException)) && this.mSkipHttpsCertificate && (this.mICommonRequestHandler instanceof UrlConnectionRequestHandler);
    }

    public void cancelRequest() {
        ThreadSpeedStat threadSpeedStat = this.mThreadSpeedStat;
        if (threadSpeedStat != null && TextUtils.isEmpty(threadSpeedStat.drs)) {
            ThreadSpeedStat threadSpeedStat2 = this.mThreadSpeedStat;
            threadSpeedStat2.drs = "c";
            threadSpeedStat2.downEndTime = SystemClock.elapsedRealtime();
        }
        this.mICommonRequestHandler.cancelRequest();
    }

    public ThreadSpeedStat getThreadSpeedStat() {
        return this.mThreadSpeedStat;
    }

    public void interruptRetryWaiting() {
        Thread thread;
        if (!this.mIsWaitingForRetry || (thread = this.mCurrentThread) == null) {
            return;
        }
        thread.interrupt();
    }

    public void newThreadSpeedStat() {
        if (this.responseHandler.mtask.mTaskSpeedStat.speedStatEnable) {
            ThreadSpeedStat threadSpeedStat = new ThreadSpeedStat();
            this.mThreadSpeedStat = threadSpeedStat;
            this.responseHandler.mtask.mTaskSpeedStat.addThreadSpeedStat(threadSpeedStat);
            this.mThreadSpeedStat.downStartTime = SystemClock.elapsedRealtime();
            ThreadSpeedStat threadSpeedStat2 = this.mThreadSpeedStat;
            AbstractTask abstractTask = this.responseHandler.mtask;
            threadSpeedStat2.cqid = abstractTask.mTaskSpeedStat.generateCqid(abstractTask.mContext);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Override // java.lang.Runnable
    public void run() {
        Process.setThreadPriority(10);
        this.mCurrentThread = Thread.currentThread();
        int i2 = TaskFacade.getInstance(null).getBinaryTaskMng().getDownConfig().mTrafficStatsTag;
        try {
            if (i2 != 0) {
                try {
                    TrafficStatsUtils.setThreadStatsTag(i2);
                } catch (HandlerCdnRedirectException unused) {
                    if (isMultiSrcStageBeforeOrExe()) {
                        ((MultiSrcBinaryTaskHandler) this.responseHandler).multiSrcToNormal();
                    }
                    if (i2 == 0) {
                        return;
                    }
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
                    if (i2 == 0) {
                        return;
                    }
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
                if (this.responseHandler != null && !this.responseHandler.mRunning && this.isInterrupt) {
                    this.mThreadSpeedStat.drs = "c";
                } else {
                    this.mThreadSpeedStat.drs = "s";
                }
                this.mThreadSpeedStat.downEndTime = SystemClock.elapsedRealtime();
            }
            if (i2 == 0) {
                return;
            }
            TrafficStatsUtils.clearThreadStatsTag();
        } catch (Throwable th) {
            if (i2 != 0) {
                TrafficStatsUtils.clearThreadStatsTag();
            }
            throw th;
        }
    }

    public void setDownStartPos(long j) {
        ThreadSpeedStat threadSpeedStat = this.mThreadSpeedStat;
        if (threadSpeedStat.dstart == -1) {
            threadSpeedStat.dstart = j;
        }
    }

    public AsyncHttpRequest(ICommonRequestHandler iCommonRequestHandler, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        this(asyncHttpResponseHandler);
        HashSet<String> hashSet = new HashSet<>();
        this.redirectUrls = hashSet;
        hashSet.add(iCommonRequestHandler.getUrl());
        this.mICommonRequestHandler = iCommonRequestHandler;
        newThreadSpeedStat();
        if (this.mHttpRetryStrategyHandler.HttpDNSCacheAvailable()) {
            this.mNeedAcquiredRetryStrategy = false;
            this.mRequestStage = 2;
            retryWithStrategy();
        }
    }
}
