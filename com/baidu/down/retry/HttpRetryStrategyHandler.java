package com.baidu.down.retry;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.loopj.android.http.exp.RetryStrategyException;
import com.baidu.down.request.task.AbstractTask;
import com.baidu.down.request.taskmanager.HttpDNSCacheInfo;
import com.baidu.down.request.taskmanager.TaskFacade;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.down.utils.URLRegUtils;
import com.baidu.down.utils.Utils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.conn.ConnectTimeoutException;
/* loaded from: classes.dex */
public class HttpRetryStrategyHandler {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "HttpRetryStrategyHandler";
    public transient /* synthetic */ FieldHolder $fh;
    public Context mContext;
    public ConcurrentHashMap<Integer, String> mDownDetail;
    public boolean mHostIsMatch;
    public HttpDNSCacheInfo mHttpDNSCacheInfo;
    public List<OnFetchDataResultListener> mOnFetchDataRequestListener;
    public Exception mRetryException;
    public List<RetryRequestInfo> mRetryRequestInfoList;
    public int mRetryType;
    public AbstractTask mtask;
    public boolean requestRetryStrategyData;

    /* loaded from: classes.dex */
    public interface OnFetchDataResultListener {
        void onResult(boolean z);
    }

    public HttpRetryStrategyHandler(Context context, AbstractTask abstractTask) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, abstractTask};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mtask = null;
        this.requestRetryStrategyData = false;
        this.mDownDetail = new ConcurrentHashMap<>();
        this.mRetryType = 0;
        this.mContext = context;
        this.mtask = abstractTask;
        this.mHostIsMatch = URLRegUtils.matchRetryHostReg(abstractTask.mUri);
    }

    public boolean HttpDNSCacheAvailable() {
        InterceptResult invokeV;
        HttpDNSCacheInfo httpDNSCacheInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mHostIsMatch && (httpDNSCacheInfo = this.mHttpDNSCacheInfo) != null && httpDNSCacheInfo.isRetryStrategyCacheAvailable(this.mContext) && continueRetryStrategy(0) : invokeV.booleanValue;
    }

    @SuppressLint({"LongLogTag"})
    public void appendDownDetail(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str) == null) {
            if (this.mDownDetail.containsKey(Integer.valueOf(i))) {
                ConcurrentHashMap<Integer, String> concurrentHashMap = this.mDownDetail;
                Integer valueOf = Integer.valueOf(i);
                concurrentHashMap.put(valueOf, this.mDownDetail.get(Integer.valueOf(i)) + str);
                return;
            }
            this.mDownDetail.put(Integer.valueOf(i), str);
        }
    }

    public boolean continueRetryStrategy(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) ? !Utils.isEmpty(this.mRetryRequestInfoList) && i < this.mRetryRequestInfoList.size() : invokeI.booleanValue;
    }

    public ConcurrentHashMap<Integer, String> getDownDetail() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mDownDetail : (ConcurrentHashMap) invokeV.objValue;
    }

    public long getDownFlowCostTime() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            HttpDNSCacheInfo httpDNSCacheInfo = this.mHttpDNSCacheInfo;
            if (httpDNSCacheInfo != null) {
                return httpDNSCacheInfo.mDownFlowCostTime;
            }
            return -1L;
        }
        return invokeV.longValue;
    }

    public int getDownFlowMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            HttpDNSCacheInfo httpDNSCacheInfo = this.mHttpDNSCacheInfo;
            if (httpDNSCacheInfo != null) {
                return httpDNSCacheInfo.mMode;
            }
            return -1;
        }
        return invokeV.intValue;
    }

    public HttpDNSCacheInfo getHttpDNSCacheInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mHttpDNSCacheInfo : (HttpDNSCacheInfo) invokeV.objValue;
    }

    public String getRequestId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            HttpDNSCacheInfo httpDNSCacheInfo = this.mHttpDNSCacheInfo;
            return httpDNSCacheInfo != null ? httpDNSCacheInfo.mRequestId : "";
        }
        return (String) invokeV.objValue;
    }

    public String getRetryExceptionName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Exception exc = this.mRetryException;
            return exc != null ? exc.getClass().getName() : "";
        }
        return (String) invokeV.objValue;
    }

    public List<RetryRequestInfo> getRetryRequestInfoList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mRetryRequestInfoList : (List) invokeV.objValue;
    }

    public int getRetryType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mRetryType : invokeV.intValue;
    }

    public boolean isAcquireRetryStrategy(boolean z, Exception exc, int i) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Boolean.valueOf(z), exc, Integer.valueOf(i)})) == null) ? TaskFacade.getInstance(null).getBinaryTaskMng().getDownConfig().mHttpRetryStrategyEnable && ((z && this.mHostIsMatch && ((exc instanceof UnknownHostException) || (exc instanceof ConnectException) || (exc instanceof SocketException) || (exc instanceof SocketTimeoutException) || (exc instanceof ConnectTimeoutException) || (exc instanceof ProtocolException) || (exc instanceof RetryStrategyException))) || continueRetryStrategy(i)) : invokeCommon.booleanValue;
    }

    @SuppressLint({"LongLogTag"})
    public void retryStrategy(Exception exc, OnFetchDataResultListener onFetchDataResultListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, exc, onFetchDataResultListener) == null) {
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
                httpRetryStrategyDataParse.onFetchRetryDataRequest(abstractTask.mContext, abstractTask.mUri, new HttpRetryStrategyDataParse.OnFetchRetryDataRequestListener(this, exc) { // from class: com.baidu.down.retry.HttpRetryStrategyHandler.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ HttpRetryStrategyHandler this$0;
                    public final /* synthetic */ Exception val$exception;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, exc};
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
                        this.val$exception = exc;
                    }

                    @Override // com.baidu.down.retry.HttpRetryStrategyDataParse.OnFetchRetryDataRequestListener
                    public void afterRequest(boolean z, HttpDNSCacheInfo httpDNSCacheInfo, int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), httpDNSCacheInfo, Integer.valueOf(i)}) == null) {
                            this.this$0.requestRetryStrategyData = false;
                            if (z) {
                                this.this$0.mHttpDNSCacheInfo = httpDNSCacheInfo;
                                HttpRetryStrategyHandler httpRetryStrategyHandler = this.this$0;
                                httpRetryStrategyHandler.mRetryRequestInfoList = httpRetryStrategyHandler.mHttpDNSCacheInfo.getSequenceRetryRequest(this.this$0.mtask.mUri, this.val$exception);
                            }
                            if (Utils.isEmpty(this.this$0.mRetryRequestInfoList)) {
                                z = false;
                            }
                            if (z) {
                                this.this$0.mRetryType = 1;
                            } else {
                                this.this$0.mRetryType = i;
                            }
                            synchronized (this.this$0.mOnFetchDataRequestListener) {
                                for (int i2 = 0; i2 < this.this$0.mOnFetchDataRequestListener.size(); i2++) {
                                    ((OnFetchDataResultListener) this.this$0.mOnFetchDataRequestListener.get(i2)).onResult(z);
                                }
                                this.this$0.mOnFetchDataRequestListener.clear();
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
    }

    public void setHttpDNSCacheInfo(HttpDNSCacheInfo httpDNSCacheInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, httpDNSCacheInfo) == null) {
            this.mHttpDNSCacheInfo = httpDNSCacheInfo;
        }
    }

    public void setRetryException(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, exc) == null) {
            this.mRetryException = exc;
        }
    }

    public void setRetryType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.mRetryType = i;
        }
    }
}
