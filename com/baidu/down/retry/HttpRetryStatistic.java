package com.baidu.down.retry;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes2.dex */
public class HttpRetryStatistic {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DATA = "DATA:";
    public static final boolean DEBUG = false;
    public static final String RETRY_DOWNLOAD_FLOW_TIME = "dft:";
    public static final String RETRY_EXCEPTION_NAME = "expn:";
    public static final String RETRY_HOST = "h:";
    public static final String RETRY_REQUEST_ID = "qid:";
    public static final String RETRY_RESULT = "rs:";
    public static final String RETRY_RESULT_FAIL = "f";
    public static final String RETRY_RESULT_SUCCESS = "s";
    public static final String RETRY_URL = "url:";
    public static final String RETYR_MODE = "md:";
    public static final String TAG = "HttpRetryStatistic";
    public static final String THREAD = "THREAD:";
    public transient /* synthetic */ FieldHolder $fh;

    public HttpRetryStatistic() {
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

    public static String buidTaskRetryStatistic(ConcurrentHashMap<Integer, String> concurrentHashMap, int i, long j, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{concurrentHashMap, Integer.valueOf(i), Long.valueOf(j), str, str2})) == null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, String> entry : concurrentHashMap.entrySet()) {
                sb.append(THREAD + entry.getKey() + "\n");
                sb.append(DATA + entry.getValue() + "\n");
            }
            sb.append(RETYR_MODE + i + "\n");
            sb.append(RETRY_DOWNLOAD_FLOW_TIME + j + "\n");
            sb.append(RETRY_EXCEPTION_NAME + str + "\n");
            sb.append(RETRY_REQUEST_ID + str2 + "\n");
            sb.append("buid task time:" + System.currentTimeMillis() + "\n");
            return sb.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static String buildRetryStatistic(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n retrytag: \n");
            sb.append(RETRY_URL + str + "\n");
            sb.append(RETRY_RESULT + str2 + "\n");
            sb.append(RETRY_HOST + str3 + "\n");
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }
}
