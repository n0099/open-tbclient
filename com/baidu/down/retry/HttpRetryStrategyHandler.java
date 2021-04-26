package com.baidu.down.retry;

import android.annotation.SuppressLint;
import android.content.Context;
import com.baidu.down.loopj.android.http.exp.RetryStrategyException;
import com.baidu.down.request.task.AbstractTask;
import com.baidu.down.request.taskmanager.HttpDNSCacheInfo;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.down.utils.URLRegUtils;
import com.baidu.down.utils.Utils;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.conn.ConnectTimeoutException;
/* loaded from: classes2.dex */
public class HttpRetryStrategyHandler {
    public static final boolean DEBUG = false;
    public static final String TAG = "HttpRetryStrategyHandler";
    public Context mContext;
    public boolean mHostIsMatch;
    public HttpDNSCacheInfo mHttpDNSCacheInfo;
    public List<OnFetchDataResultListener> mOnFetchDataRequestListener;
    public Exception mRetryException;
    public List<RetryRequestInfo> mRetryRequestInfoList;
    public AbstractTask mtask;
    public boolean requestRetryStrategyData = false;
    public ConcurrentHashMap<Integer, String> mDownDetail = new ConcurrentHashMap<>();
    public int mRetryType = 0;

    /* loaded from: classes2.dex */
    public interface OnFetchDataResultListener {
        void onResult(boolean z);
    }

    public HttpRetryStrategyHandler(Context context, AbstractTask abstractTask) {
        this.mtask = null;
        this.mContext = context;
        this.mtask = abstractTask;
        this.mHostIsMatch = URLRegUtils.matchRetryHostReg(abstractTask.mUri);
    }

    public boolean HttpDNSCacheAvailable() {
        HttpDNSCacheInfo httpDNSCacheInfo;
        return this.mHostIsMatch && (httpDNSCacheInfo = this.mHttpDNSCacheInfo) != null && httpDNSCacheInfo.isRetryStrategyCacheAvailable(this.mContext) && continueRetryStrategy(0);
    }

    @SuppressLint({"LongLogTag"})
    public void appendDownDetail(int i2, String str) {
        if (this.mDownDetail.containsKey(Integer.valueOf(i2))) {
            ConcurrentHashMap<Integer, String> concurrentHashMap = this.mDownDetail;
            Integer valueOf = Integer.valueOf(i2);
            concurrentHashMap.put(valueOf, this.mDownDetail.get(Integer.valueOf(i2)) + str);
            return;
        }
        this.mDownDetail.put(Integer.valueOf(i2), str);
    }

    public boolean continueRetryStrategy(int i2) {
        return !Utils.isEmpty(this.mRetryRequestInfoList) && i2 < this.mRetryRequestInfoList.size();
    }

    public ConcurrentHashMap<Integer, String> getDownDetail() {
        return this.mDownDetail;
    }

    public long getDownFlowCostTime() {
        HttpDNSCacheInfo httpDNSCacheInfo = this.mHttpDNSCacheInfo;
        if (httpDNSCacheInfo != null) {
            return httpDNSCacheInfo.mDownFlowCostTime;
        }
        return -1L;
    }

    public int getDownFlowMode() {
        HttpDNSCacheInfo httpDNSCacheInfo = this.mHttpDNSCacheInfo;
        if (httpDNSCacheInfo != null) {
            return httpDNSCacheInfo.mMode;
        }
        return -1;
    }

    public HttpDNSCacheInfo getHttpDNSCacheInfo() {
        return this.mHttpDNSCacheInfo;
    }

    public String getRequestId() {
        HttpDNSCacheInfo httpDNSCacheInfo = this.mHttpDNSCacheInfo;
        return httpDNSCacheInfo != null ? httpDNSCacheInfo.mRequestId : "";
    }

    public String getRetryExceptionName() {
        Exception exc = this.mRetryException;
        return exc != null ? exc.getClass().getName() : "";
    }

    public List<RetryRequestInfo> getRetryRequestInfoList() {
        return this.mRetryRequestInfoList;
    }

    public int getRetryType() {
        return this.mRetryType;
    }

    public boolean isAcquireRetryStrategy(boolean z, Exception exc, int i2) {
        return TaskFacade.getInstance(null).getBinaryTaskMng().getDownConfig().mHttpRetryStrategyEnable && ((z && this.mHostIsMatch && ((exc instanceof UnknownHostException) || (exc instanceof ConnectException) || (exc instanceof SocketException) || (exc instanceof SocketTimeoutException) || (exc instanceof ConnectTimeoutException) || (exc instanceof ProtocolException) || (exc instanceof RetryStrategyException))) || continueRetryStrategy(i2));
    }

    @SuppressLint({"LongLogTag"})
    public void retryStrategy(final Exception exc, OnFetchDataResultListener onFetchDataResultListener) {
        if (HttpDNSCacheAvailable()) {
            onFetchDataResultListener.onResult(true);
            return;
        }
        if (!this.requestRetryStrategyData) {
            this.requestRetryStrategyData = true;
            ArrayList arrayList = new ArrayList();
            this.mOnFetchDataRequestListener = arrayList;
            arrayList.add(onFetchDataResultListener);
            HttpRetryStrategyDataParse httpRetryStrategyDataParse = new HttpRetryStrategyDataParse();
            AbstractTask abstractTask = this.mtask;
            httpRetryStrategyDataParse.onFetchRetryDataRequest(abstractTask.mContext, abstractTask.mUri, new HttpRetryStrategyDataParse.OnFetchRetryDataRequestListener() { // from class: com.baidu.down.retry.HttpRetryStrategyHandler.1
                @Override // com.baidu.down.retry.HttpRetryStrategyDataParse.OnFetchRetryDataRequestListener
                public void afterRequest(boolean z, HttpDNSCacheInfo httpDNSCacheInfo, int i2) {
                    HttpRetryStrategyHandler.this.requestRetryStrategyData = false;
                    if (z) {
                        HttpRetryStrategyHandler.this.mHttpDNSCacheInfo = httpDNSCacheInfo;
                        HttpRetryStrategyHandler httpRetryStrategyHandler = HttpRetryStrategyHandler.this;
                        httpRetryStrategyHandler.mRetryRequestInfoList = httpRetryStrategyHandler.mHttpDNSCacheInfo.getSequenceRetryRequest(HttpRetryStrategyHandler.this.mtask.mUri, exc);
                    }
                    if (Utils.isEmpty(HttpRetryStrategyHandler.this.mRetryRequestInfoList)) {
                        z = false;
                    }
                    if (z) {
                        HttpRetryStrategyHandler.this.mRetryType = 1;
                    } else {
                        HttpRetryStrategyHandler.this.mRetryType = i2;
                    }
                    synchronized (HttpRetryStrategyHandler.this.mOnFetchDataRequestListener) {
                        for (int i3 = 0; i3 < HttpRetryStrategyHandler.this.mOnFetchDataRequestListener.size(); i3++) {
                            ((OnFetchDataResultListener) HttpRetryStrategyHandler.this.mOnFetchDataRequestListener.get(i3)).onResult(z);
                        }
                        HttpRetryStrategyHandler.this.mOnFetchDataRequestListener.clear();
                    }
                }
            });
        } else {
            this.mOnFetchDataRequestListener.add(onFetchDataResultListener);
        }
        try {
            this.mtask.wait();
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
    }

    public void setHttpDNSCacheInfo(HttpDNSCacheInfo httpDNSCacheInfo) {
        this.mHttpDNSCacheInfo = httpDNSCacheInfo;
    }

    public void setRetryException(Exception exc) {
        this.mRetryException = exc;
    }

    public void setRetryType(int i2) {
        this.mRetryType = i2;
    }
}
