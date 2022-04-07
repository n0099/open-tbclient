package com.baidu.sapi2.utils;

import android.util.Base64;
import com.baidu.pass.http.ReqPriority;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class GetTplStokenStat {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String AUTO_STATISTIC = "auto_statistic";
    public static final String KEY_GET_STOKEN = "key_get_stoken";
    public static final String KEY_GET_STOKEN_RESULT_CODE = "get_stoken_result_code";
    public static final String KEY_GET_STOKEN_RESULT_MSG = "get_stoken_result_msg";
    public static final String KEY_GET_STOKEN_TIME_CONSUMING = "get_stoken_time_consuming";
    public transient /* synthetic */ FieldHolder $fh;

    public GetTplStokenStat() {
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

    public static String getEventTypeBase64Value(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            return "{eventType:" + str + "}";
        }
        return (String) invokeL.objValue;
    }

    public static void onEventAutoStat(String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, str, str2, str3) == null) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("auto_statistic", Base64.encodeToString(getEventTypeBase64Value(KEY_GET_STOKEN).getBytes(), 0));
            httpHashMapWrap.put("source", "native");
            httpHashMapWrap.put("data_source", "client");
            httpHashMapWrap.put("v", String.valueOf(System.currentTimeMillis()));
            httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
            httpHashMapWrap.put(KEY_GET_STOKEN_RESULT_CODE, str2);
            httpHashMapWrap.put(KEY_GET_STOKEN_RESULT_MSG, str3);
            httpHashMapWrap.put(KEY_GET_STOKEN_TIME_CONSUMING, str);
            try {
                sendRequest(httpHashMapWrap);
            } catch (Exception unused) {
            }
        }
    }

    public static void sendRequest(HttpHashMapWrap httpHashMapWrap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, httpHashMapWrap) == null) {
            new HttpClientWrap().get(SapiHost.getHost(SapiHost.DOMAIN_NSCLICK_URL), ReqPriority.LOW, httpHashMapWrap, null, null, new HttpHandlerWrap(true) { // from class: com.baidu.sapi2.utils.GetTplStokenStat.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r7);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {Boolean.valueOf(r7)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i, str) == null) {
                    }
                }
            });
        }
    }
}
