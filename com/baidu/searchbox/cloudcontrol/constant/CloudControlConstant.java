package com.baidu.searchbox.cloudcontrol.constant;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class CloudControlConstant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONNECT_RUN_TYPE = "lcs";
    public static final String COOL_RUN_TIME = "0";
    public static final String HOT_RUN_TIME = "1";
    public static final String LOGIN_RUN_TYPE = "lcslogin";
    public static final String SP_KEY_BLACK_PUBPARAM = "pubparam_in_black";
    public static final String SP_KEY_DEGRADE_LIST = "degrade_list";
    public static final String SP_KEY_DEGRADE_LIST_VERSION = "degrade_list_version";
    public static final String SP_KEY_END_TIME = "et";
    public static final String SP_KEY_HOTRUNTIME_INTERVAL = "sp_hot_runtime_interval";
    public static final String SP_KEY_INTERVAL_VERSION = "interval_version";
    public static final String SP_KEY_LAST_REQUEST_TIME = "sp_last_request_time";
    public static final String SP_KEY_PUBPARAM = "sp_pubparam";
    public static final String SP_KEY_RUNTYPE_BLACK = "sp_runtype_black";
    public static final String SP_KEY_STRAT_TIME = "st";
    public transient /* synthetic */ FieldHolder $fh;

    public CloudControlConstant() {
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
