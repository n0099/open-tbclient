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
/* loaded from: classes5.dex */
public class HttpRetryStrategyHandler {
    private static final boolean DEBUG = false;
    private static final String TAG = "HttpRetryStrategyHandler";
    private Context mContext;
    private boolean mHostIsMatch;
    private HttpDNSCacheInfo mHttpDNSCacheInfo;
    private List<OnFetchDataResultListener> mOnFetchDataRequestListener;
    private Exception mRetryException;
    private List<RetryRequestInfo> mRetryRequestInfoList;
    public AbstractTask mtask;
    private boolean requestRetryStrategyData = false;
    private ConcurrentHashMap<Integer, String> mDownDetail = new ConcurrentHashMap<>();
    private int mRetryType = 0;

    /* loaded from: classes5.dex */
    public interface OnFetchDataResultListener {
        void onResult(boolean z);
    }

    public HttpRetryStrategyHandler(Context context, AbstractTask abstractTask) {
        this.mtask = null;
        this.mContext = context;
        this.mtask = abstractTask;
        this.mHostIsMatch = URLRegUtils.matchRetryHostReg(abstractTask.mUri);
    }

    @SuppressLint({"LongLogTag"})
    public void retryStrategy(final Exception exc, OnFetchDataResultListener onFetchDataResultListener) {
        if (HttpDNSCacheAvailable()) {
            onFetchDataResultListener.onResult(true);
            return;
        }
        if (!this.requestRetryStrategyData) {
            this.requestRetryStrategyData = true;
            this.mOnFetchDataRequestListener = new ArrayList();
            this.mOnFetchDataRequestListener.add(onFetchDataResultListener);
            new HttpRetryStrategyDataParse().onFetchRetryDataRequest(this.mtask.mContext, this.mtask.mUri, new HttpRetryStrategyDataParse.OnFetchRetryDataRequestListener() { // from class: com.baidu.down.retry.HttpRetryStrategyHandler.1
                @Override // com.baidu.down.retry.HttpRetryStrategyDataParse.OnFetchRetryDataRequestListener
                public void afterRequest(boolean z, HttpDNSCacheInfo httpDNSCacheInfo, int i) {
                    int i2 = 0;
                    HttpRetryStrategyHandler.this.requestRetryStrategyData = false;
                    if (z) {
                        HttpRetryStrategyHandler.this.mHttpDNSCacheInfo = httpDNSCacheInfo;
                        HttpRetryStrategyHandler.this.mRetryRequestInfoList = HttpRetryStrategyHandler.this.mHttpDNSCacheInfo.getSequenceRetryRequest(HttpRetryStrategyHandler.this.mtask.mUri, exc);
                    }
                    if (Utils.isEmpty(HttpRetryStrategyHandler.this.mRetryRequestInfoList)) {
                        z = false;
                    }
                    if (z) {
                        HttpRetryStrategyHandler.this.mRetryType = 1;
                    } else {
                        HttpRetryStrategyHandler.this.mRetryType = i;
                    }
                    synchronized (HttpRetryStrategyHandler.this.mOnFetchDataRequestListener) {
                        while (true) {
                            int i3 = i2;
                            if (i3 >= HttpRetryStrategyHandler.this.mOnFetchDataRequestListener.size()) {
                                HttpRetryStrategyHandler.this.mOnFetchDataRequestListener.clear();
                            } else {
                                ((OnFetchDataResultListener) HttpRetryStrategyHandler.this.mOnFetchDataRequestListener.get(i3)).onResult(z);
                                i2 = i3 + 1;
                            }
                        }
                    }
                }
            });
        } else {
            this.mOnFetchDataRequestListener.add(onFetchDataResultListener);
        }
        try {
            this.mtask.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setHttpDNSCacheInfo(HttpDNSCacheInfo httpDNSCacheInfo) {
        this.mHttpDNSCacheInfo = httpDNSCacheInfo;
    }

    public HttpDNSCacheInfo getHttpDNSCacheInfo() {
        return this.mHttpDNSCacheInfo;
    }

    public List<RetryRequestInfo> getRetryRequestInfoList() {
        return this.mRetryRequestInfoList;
    }

    public boolean HttpDNSCacheAvailable() {
        return this.mHostIsMatch && this.mHttpDNSCacheInfo != null && this.mHttpDNSCacheInfo.isRetryStrategyCacheAvailable(this.mContext) && continueRetryStrategy(0);
    }

    public boolean isAcquireRetryStrategy(boolean z, Exception exc, int i) {
        return TaskFacade.getInstance(null).getBinaryTaskMng().getDownConfig().mHttpRetryStrategyEnable && ((z && this.mHostIsMatch && ((exc instanceof UnknownHostException) || (exc instanceof ConnectException) || (exc instanceof SocketException) || (exc instanceof SocketTimeoutException) || (exc instanceof ConnectTimeoutException) || (exc instanceof ProtocolException) || (exc instanceof RetryStrategyException))) || continueRetryStrategy(i));
    }

    public boolean continueRetryStrategy(int i) {
        return !Utils.isEmpty(this.mRetryRequestInfoList) && i < this.mRetryRequestInfoList.size();
    }

    @SuppressLint({"LongLogTag"})
    public void appendDownDetail(int i, String str) {
        if (this.mDownDetail.containsKey(Integer.valueOf(i))) {
            this.mDownDetail.put(Integer.valueOf(i), this.mDownDetail.get(Integer.valueOf(i)) + str);
            return;
        }
        this.mDownDetail.put(Integer.valueOf(i), str);
    }

    public ConcurrentHashMap<Integer, String> getDownDetail() {
        return this.mDownDetail;
    }

    public long getDownFlowCostTime() {
        if (this.mHttpDNSCacheInfo != null) {
            return this.mHttpDNSCacheInfo.mDownFlowCostTime;
        }
        return -1L;
    }

    public int getDownFlowMode() {
        if (this.mHttpDNSCacheInfo != null) {
            return this.mHttpDNSCacheInfo.mMode;
        }
        return -1;
    }

    public String getRequestId() {
        return this.mHttpDNSCacheInfo != null ? this.mHttpDNSCacheInfo.mRequestId : "";
    }

    public int getRetryType() {
        return this.mRetryType;
    }

    public void setRetryType(int i) {
        this.mRetryType = i;
    }

    public String getRetryExceptionName() {
        return this.mRetryException != null ? this.mRetryException.getClass().getName() : "";
    }

    public void setRetryException(Exception exc) {
        this.mRetryException = exc;
    }
}
