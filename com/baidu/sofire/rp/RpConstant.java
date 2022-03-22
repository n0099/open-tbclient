package com.baidu.sofire.rp;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class RpConstant {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String CONFIG_NAME = "re_po_rt";
    public static final String CONFIG_NAME_2 = "leroadcfg";
    public static final String DATABASE_REPORT_NAME = "d.db";
    public static final int DAY = 86400000;
    public static final int EVENT_FREQUENCY_NOW = 0;
    public static final int EVENT_NETWORK_NONE = 0;
    public static final int EVENT_NETWORK_TYPE_3G = 1;
    public static final int EVENT_NETWORK_TYPE_WIFI = 2;
    public static final int EVENT_TYPE_ALIVE_INFO = 2;
    public static final int EVENT_TYPE_APPLIST_INFO = 4;
    public static final int EVENT_TYPE_BEHAVIOR_INFO = 3;
    public static final int EVENT_TYPE_INSTALL_INFO = 1;
    public static final int HOUR = 3600000;
    public static final int M = 1048576;
    public static final String METHOD_CALL_ERROR_LOGID = "1003141";
    public static final String METHOD_CALL_LOGID = "1003139";
    public static final int MINUTE = 60000;
    public static final String REFLECT_CLASS_F_NAME = "com.baidu.sofire.ac.F";
    public static final String REQUEST_PLUGIN_REPORT = "p/1/r";
    public static final String TABLE_REPORT = "r";
    public static final String ZID_CHANGE_LOGID = "1003142";
    public transient /* synthetic */ FieldHolder $fh;

    public RpConstant() {
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
