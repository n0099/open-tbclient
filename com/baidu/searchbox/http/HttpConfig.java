package com.baidu.searchbox.http;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class HttpConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final boolean HTTP_DNS_BACKUPIPENABLE_DEFAULT = true;
    public static final String HTTP_DNS_BACKUPIPENABLE_SWITCH = "httpdns_backupip_enable";
    public static final boolean HTTP_DNS_IDC_DEFAULT = true;
    public static final boolean HTTP_DNS_IDC_IPV6_TEST_DEFAULT = false;
    public static final String HTTP_DNS_IDC_IPV6_TEST_SWITCH = "httpdns_enable_idc_ipv6";
    public static final String HTTP_DNS_IDC_SWITCH = "HTTP_DNS_IDC_ENABLE";
    public static final String HTTP_DNS_LOG_SWITCH = "HTTP_DNS_NEW_LOG";
    public static final boolean HTTP_DNS_LOG_SWITCH_DEFAULT = false;
    public static final String HTTP_DNS_SWITCH = "HTTP_DNS_NEW_ENABLE";
    public static final boolean HTTP_DNS_SWITCH_DEFAULT = true;
    public static final boolean HTTP_DNS_USEEXPIRE_DEFAULT = true;
    public static final String HTTP_DNS_USEEXPIRE_SWITCH = "httpdns_use_expire";
    public static final String HTTP_EXCEPTION_MONITOR_LOG = "http_exception_monitor_log";
    public static final boolean HTTP_EXCEPTION_MONITOR_LOG_DEFAULT = false;
    public static final int HTTP_IPV6_HAPPY_EYEBALL_TEST_DEFAULT = 300;
    public static final String HTTP_IPV6_HAPPY_EYEBALL_TEST_SWITCH = "okhttp_use_happyeyeball";
    public static final String TAG = "baidu_network";
    public static final int TIME_THRESHOLD_TO_STORE_LOG_DEFAULT = 1500;
    public static final String TIME_THRESHOLD_TO_STORE_LOG_SWITCH = "threshold_to_store_log";
    public static final String UBC_HTTP_EXCEPTION_ID = "850";
    public static final String UBC_HTTP_EXCEPTION_MONITOR_ID = "1217";
    public static final String UBC_HTTP_ID = "94";
    public transient /* synthetic */ FieldHolder $fh;

    public HttpConfig() {
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
}
