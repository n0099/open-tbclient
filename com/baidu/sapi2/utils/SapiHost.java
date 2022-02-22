package com.baidu.sapi2.utils;

import android.util.Base64;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes11.dex */
public class SapiHost {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTION_INTERCEPT_URL = "aHR0cHM6Ly93YXAuYmFpZHUuY29tL2FjdGlvbl9pbnRlcmNlcHRfYW5kcm9pZA==";
    public static final String DOMAIN_BAIDU_HTTPS_URL = "aHR0cHM6Ly93d3cuYmFpZHUuY29t";
    public static final String DOMAIN_NSCLICK_URL = "aHR0cHM6Ly9uc2NsaWNrLmJhaWR1LmNvbS92LmdpZg==";
    public static final String DOMAIN_ONLINE_CONFIG_HTTPS_URL = "aHR0cHM6Ly93YXBwYXNzLmJkaW1nLmNvbQ==";
    public static final String DOMAIN_ONLINE_DEVICE_URL = "aHR0cHM6Ly9vcGVuYXBpLmJhaWR1LmNvbQ==";
    public static final String DOMAIN_ONLINE_PASSPORT_URL = "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==";
    public static final String DOMAIN_ONLINE_PORTRAIT_URL = "aHR0cHM6Ly9wYXNzcG9ydC5iYWlkdS5jb20=";
    public static final String DOMAIN_ONLINE_WAPPASS_URL = "aHR0cDovL3dhcHBhc3MuYmFpZHUuY29t";
    public static final String DOMAIN_QA_CONFIG_HTTPS_URL = "aHR0cDovL3dhcHBhc3MucWF0ZXN0LmJhaWR1LmNvbQ==";
    public static final String DOMAIN_QA_DEVICE_URL = "aHR0cDovL2RiLWluZmJrLW9ubGluZS0xNy5kYjAxLmJhaWR1LmNvbTo4MDgw";
    public static final String DOMAIN_QA_PASSPORT_URL = "aHR0cDovL3Bhc3Nwb3J0LnFhdGVzdC5iYWlkdS5jb20=";
    public static final String DOMAIN_QA_PORTRAIT_URL = "aHR0cDovL3Bhc3Nwb3J0LmJhaWR1LmNvbQ==";
    public static String DOMAIN_QA_WAPPASS_URL = "aHR0cDovL3dhcHBhc3MucWF0ZXN0LmJhaWR1LmNvbQ==";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(977284860, "Lcom/baidu/sapi2/utils/SapiHost;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(977284860, "Lcom/baidu/sapi2/utils/SapiHost;");
        }
    }

    public SapiHost() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static String getHost(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            try {
                return new String(Base64.decode(str.getBytes(), 0));
            } catch (Exception unused) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }
}
