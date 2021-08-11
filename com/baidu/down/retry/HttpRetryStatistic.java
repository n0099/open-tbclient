package com.baidu.down.retry;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.commons.lang3.StringUtils;
/* loaded from: classes5.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String buidTaskRetryStatistic(ConcurrentHashMap<Integer, String> concurrentHashMap, int i2, long j2, String str, String str2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{concurrentHashMap, Integer.valueOf(i2), Long.valueOf(j2), str, str2})) == null) {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Integer, String> entry : concurrentHashMap.entrySet()) {
                sb.append(THREAD + entry.getKey() + StringUtils.LF);
                sb.append(DATA + entry.getValue() + StringUtils.LF);
            }
            sb.append(RETYR_MODE + i2 + StringUtils.LF);
            sb.append(RETRY_DOWNLOAD_FLOW_TIME + j2 + StringUtils.LF);
            sb.append(RETRY_EXCEPTION_NAME + str + StringUtils.LF);
            sb.append(RETRY_REQUEST_ID + str2 + StringUtils.LF);
            sb.append("buid task time:" + System.currentTimeMillis() + StringUtils.LF);
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
            sb.append(RETRY_URL + str + StringUtils.LF);
            sb.append(RETRY_RESULT + str2 + StringUtils.LF);
            sb.append(RETRY_HOST + str3 + StringUtils.LF);
            return sb.toString();
        }
        return (String) invokeLLL.objValue;
    }
}
