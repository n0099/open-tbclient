package com.baidu.down.loopj.android.http;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.common.intercepter.AbstractResponseIntercept;
import com.baidu.down.common.intercepter.IIntercepter;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "AsyncHttpRequest";
    public transient /* synthetic */ FieldHolder $fh;
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
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -5562528406378234456L;
        public transient /* synthetic */ FieldHolder $fh;

        public HandlerCdnRedirectException() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class HandlerRedirectException extends RuntimeException {
        public static /* synthetic */ Interceptable $ic = null;
        public static final long serialVersionUID = -4422626752285372402L;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HandlerRedirectException(String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public AsyncHttpRequest(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {asyncHttpResponseHandler};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
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
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            BinaryHttpResponseHandler binaryHttpResponseHandler = this.responseHandler;
            return (binaryHttpResponseHandler instanceof MultiSrcBinaryTaskHandler) && ((MultiSrcBinaryTaskHandler) binaryHttpResponseHandler).isNeedMultiSrc() && ((MultiSrcBinaryTaskHandler) this.responseHandler).getTestSpeedStage() != 2;
        }
        return invokeV.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f5, code lost:
        if (r0.retCode != 1) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f7, code lost:
        r12.responseHandler.mtask.pause();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fe, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void makeRequest() throws IOException, HandlerRedirectException, HandlerCdnRedirectException, RedirectException {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.isInterrupt) {
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
                    com.baidu.down.common.intercepter.InterceptResult process = ((AbstractResponseIntercept) iIntercepter).process(this.responseHandler.mtask.mContext, this.responseHandler.mtask.getTaskKey(), this.responseHandler.mtask.mDownloadId, this.mICommonRequestHandler.getResponseInfo());
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
                } catch (RedirectException e) {
                    throw e;
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
        } catch (IOException e2) {
            if (e2 instanceof ConnectTimeoutException) {
                this.mICommonRequestHandler.closeConnection();
            }
            if (!this.isInterrupt) {
                throw e2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:181:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
        if (r18.responseHandler == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0074, code lost:
        if (r18.responseHandler.mRunning != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0078, code lost:
        if (r18.isInterrupt == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x007a, code lost:
        r18.responseHandler.sendPausedMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0084, code lost:
        if ((r18.responseHandler instanceof com.baidu.down.loopj.android.http.BinaryHttpResponseHandler) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0086, code lost:
        r0 = com.baidu.down.request.taskmanager.TaskFacade.getInstance(null).getBinaryTaskMng().getByteArrayInfoMng().getByteArray();
        r0.mFilePos = r18.curPos;
        r0.mByteArrayLength = -1;
        r18.responseHandler.sendDownloadMessage(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00a2, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void makeRequestWithRetries() throws ConnectException, RedirectException {
        AbstractTask abstractTask;
        com.baidu.down.common.intercepter.InterceptResult process;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
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
                    } catch (IOException e) {
                        this.mFailType = 0;
                        processRange(true);
                        e.printStackTrace(printWriter);
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
                        } else if (skipHttpsCertificate(e)) {
                            this.mSkipHttpsCertificate = false;
                            this.mICommonRequestHandler.setTlsCertSkip(true);
                        } else if (this.mHttpRetryStrategyHandler.isAcquireRetryStrategy(this.mNeedAcquiredRetryStrategy, e, this.mRetryFrequency)) {
                            if (this.mNeedAcquiredRetryStrategy) {
                                this.mHttpRetryStrategyHandler.setRetryException(e);
                            } else {
                                this.mHttpRetryStrategyHandler.appendDownDetail(hashCode(), HttpRetryStatistic.buildRetryStatistic(this.mICommonRequestHandler.getUrl(), "f", this.mICommonRequestHandler.onGetRequestHeader("host")));
                            }
                            this.mNeedAcquiredRetryStrategy = false;
                            this.mRequestStage = 2;
                            synchronized (this.responseHandler.mtask) {
                                this.mHttpRetryStrategyHandler.retryStrategy(e, new HttpRetryStrategyHandler.OnFetchDataResultListener(this) { // from class: com.baidu.down.loopj.android.http.AsyncHttpRequest.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AsyncHttpRequest this$0;

                                    {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this};
                                            interceptable2.invokeUnInit(65536, newInitContext);
                                            int i = newInitContext.flag;
                                            if ((i & 1) != 0) {
                                                int i2 = i & 2;
                                                newInitContext.thisArg = this;
                                                interceptable2.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$0 = this;
                                    }

                                    @Override // com.baidu.down.retry.HttpRetryStrategyHandler.OnFetchDataResultListener
                                    public void onResult(boolean z2) {
                                        Interceptable interceptable2 = $ic;
                                        if (interceptable2 == null || interceptable2.invokeZ(1048576, this, z2) == null) {
                                            if (z2) {
                                                this.this$0.retryWithStrategy();
                                            } else {
                                                this.this$0.mRequestStage = 3;
                                            }
                                            synchronized (this.this$0.responseHandler.mtask) {
                                                this.this$0.responseHandler.mtask.notify();
                                            }
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
                            int i = this.executionCount + 1;
                            this.executionCount = i;
                            int i2 = this.executionMaxCount + 1;
                            this.executionMaxCount = i2;
                            z = iCommonRequestHandler2.onRetryRequest(e, i, i2);
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
                                        multiSrcBinaryTaskHandler.retryDownloadInfo(new OnFetchDataRequestListener(this) { // from class: com.baidu.down.loopj.android.http.AsyncHttpRequest.2
                                            public static /* synthetic */ Interceptable $ic;
                                            public transient /* synthetic */ FieldHolder $fh;
                                            public final /* synthetic */ AsyncHttpRequest this$0;

                                            {
                                                Interceptable interceptable2 = $ic;
                                                if (interceptable2 != null) {
                                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                                    newInitContext.initArgs = r2;
                                                    Object[] objArr = {this};
                                                    interceptable2.invokeUnInit(65536, newInitContext);
                                                    int i3 = newInitContext.flag;
                                                    if ((i3 & 1) != 0) {
                                                        int i4 = i3 & 2;
                                                        newInitContext.thisArg = this;
                                                        interceptable2.invokeInitBody(65536, newInitContext);
                                                        return;
                                                    }
                                                }
                                                this.this$0 = this;
                                            }

                                            @Override // com.baidu.down.request.taskmanager.OnFetchDataRequestListener
                                            public void afterRequest(boolean z2, TreeSet<HttpDNSInfo> treeSet) {
                                                Interceptable interceptable2 = $ic;
                                                if (interceptable2 == null || interceptable2.invokeZL(1048576, this, z2, treeSet) == null) {
                                                    if (z2) {
                                                        AsyncHttpRequest asyncHttpRequest = this.this$0;
                                                        ((MultiSrcBinaryTaskHandler) asyncHttpRequest.responseHandler).handlerReplaceUrl(asyncHttpRequest.mICommonRequestHandler, this.this$0);
                                                    }
                                                    synchronized (this.this$0.lock) {
                                                        this.this$0.lock.notify();
                                                    }
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
                                        } catch (InterruptedException e2) {
                                            e2.printStackTrace();
                                        }
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        }
                    } catch (NullPointerException e3) {
                        this.mFailType = 0;
                        if (this.mRequestStage == 2) {
                            this.mHttpRetryStrategyHandler.setRetryType(4);
                            this.mHttpRetryStrategyHandler.appendDownDetail(hashCode(), HttpRetryStatistic.buildRetryStatistic(this.mICommonRequestHandler.getUrl(), "f", this.mICommonRequestHandler.onGetRequestHeader("host")));
                        }
                        this.mICommonRequestHandler.restoreRequest();
                        processRange(true);
                        IOException iOException = new IOException("NPE in HttpClient" + e3.getMessage());
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
                            int i3 = this.executionCount + 1;
                            this.executionCount = i3;
                            int i4 = this.executionMaxCount + 1;
                            this.executionMaxCount = i4;
                            z = iCommonRequestHandler3.onRetryRequest(iOException, i3, i4);
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
    }

    private boolean processRange(boolean z) {
        InterceptResult invokeZ;
        AbstractTask abstractTask;
        int i;
        String onGetRequestHeader;
        String str;
        String str2;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65545, this, z)) == null) {
            BinaryHttpResponseHandler binaryHttpResponseHandler = this.responseHandler;
            if (!(binaryHttpResponseHandler instanceof BinaryHttpResponseHandler) || (i = (abstractTask = binaryHttpResponseHandler.mtask).mStatus) == 1004 || i == 1006 || (onGetRequestHeader = this.mICommonRequestHandler.onGetRequestHeader("Range")) == null) {
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
            } catch (NumberFormatException e) {
                e.printStackTrace();
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
            int i2 = (segEndByPos > Long.MAX_VALUE ? 1 : (segEndByPos == Long.MAX_VALUE ? 0 : -1));
            if (i2 == 0) {
                j = abstractTask.mProgressInfo.getSegCurrentByPos(j2);
            } else {
                str3 = str2;
            }
            if (j < segEndByPos) {
                if (i2 != 0 && TaskFacade.getInstance(null).getBinaryTaskMng().getHttpClient().isWap()) {
                    long j3 = 307200 + j;
                    str3 = String.valueOf(j3 - 1 < segEndByPos ? j3 - 2 : segEndByPos - 1);
                }
                ICommonRequestHandler iCommonRequestHandler = this.mICommonRequestHandler;
                iCommonRequestHandler.onSetRequestHeader("Range", "bytes=" + j + "-" + str3);
                return true;
            }
            return false;
        }
        return invokeZ.booleanValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void retryWithStrategy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            if (this.mRetryFrequency == 0) {
                this.mICommonRequestHandler.saveRequest();
            }
            ICommonRequestHandler iCommonRequestHandler = this.mICommonRequestHandler;
            List<RetryRequestInfo> retryRequestInfoList = this.mHttpRetryStrategyHandler.getRetryRequestInfoList();
            int i = this.mRetryFrequency;
            this.mRetryFrequency = i + 1;
            iCommonRequestHandler.replaceRequest(retryRequestInfoList.get(i));
            ThreadSpeedStat threadSpeedStat = this.mThreadSpeedStat;
            if (threadSpeedStat != null) {
                threadSpeedStat.drnum++;
            }
        }
    }

    private boolean skipHttpsCertificate(Exception exc) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65547, this, exc)) == null) ? ((exc instanceof SSLException) || (exc instanceof CertificateException)) && this.mSkipHttpsCertificate && (this.mICommonRequestHandler instanceof UrlConnectionRequestHandler) : invokeL.booleanValue;
    }

    public void cancelRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ThreadSpeedStat threadSpeedStat = this.mThreadSpeedStat;
            if (threadSpeedStat != null && TextUtils.isEmpty(threadSpeedStat.drs)) {
                ThreadSpeedStat threadSpeedStat2 = this.mThreadSpeedStat;
                threadSpeedStat2.drs = "c";
                threadSpeedStat2.downEndTime = SystemClock.elapsedRealtime();
            }
            this.mICommonRequestHandler.cancelRequest();
        }
    }

    public ThreadSpeedStat getThreadSpeedStat() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mThreadSpeedStat : (ThreadSpeedStat) invokeV.objValue;
    }

    public void interruptRetryWaiting() {
        Thread thread;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.mIsWaitingForRetry && (thread = this.mCurrentThread) != null) {
            thread.interrupt();
        }
    }

    public void newThreadSpeedStat() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && this.responseHandler.mtask.mTaskSpeedStat.speedStatEnable) {
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
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            Process.setThreadPriority(10);
            this.mCurrentThread = Thread.currentThread();
            int i = TaskFacade.getInstance(null).getBinaryTaskMng().getDownConfig().mTrafficStatsTag;
            try {
                if (i != 0) {
                    try {
                        try {
                            TrafficStatsUtils.setThreadStatsTag(i);
                        } catch (HandlerCdnRedirectException unused) {
                            if (isMultiSrcStageBeforeOrExe()) {
                                ((MultiSrcBinaryTaskHandler) this.responseHandler).multiSrcToNormal();
                            }
                            if (i == 0) {
                                return;
                            }
                        }
                    } catch (Exception e) {
                        if (this.mThreadSpeedStat != null) {
                            this.mThreadSpeedStat.drs = "f";
                            this.mThreadSpeedStat.downEndTime = SystemClock.elapsedRealtime();
                        }
                        if (this.responseHandler != null) {
                            this.responseHandler.sendFinishMessage();
                            if (this.isBinaryRequest) {
                                this.responseHandler.sendFailureMessage(e, null, this.mFailType);
                            } else {
                                this.responseHandler.sendFailureMessage(e, null);
                            }
                        }
                        if (i == 0) {
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
                if (i == 0) {
                    return;
                }
                TrafficStatsUtils.clearThreadStatsTag();
            } catch (Throwable th) {
                if (i != 0) {
                    TrafficStatsUtils.clearThreadStatsTag();
                }
                throw th;
            }
        }
    }

    public void setDownStartPos(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            ThreadSpeedStat threadSpeedStat = this.mThreadSpeedStat;
            if (threadSpeedStat.dstart == -1) {
                threadSpeedStat.dstart = j;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AsyncHttpRequest(ICommonRequestHandler iCommonRequestHandler, AsyncHttpResponseHandler asyncHttpResponseHandler) {
        this(asyncHttpResponseHandler);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iCommonRequestHandler, asyncHttpResponseHandler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((AsyncHttpResponseHandler) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
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
