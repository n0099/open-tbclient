package com.baidu.searchbox.launch.stats;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes7.dex */
public class SpeedStatsMainTable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTIVITY_STAGE = "activity";
    public static final String AD_SHOW = "adshow";
    public static final String APP_CREATE_STAGE = "appCreate";
    public static final String APP_ZYGOTE = "appZygote";
    public static final String ASYNC_TASK = "asyncTask";
    public static final String ATTACH_WINDOW_STAGE = "attachWindow";
    public static final String BEFORE_APP_CREATE_STAGE = "beforeAppCreate";
    public static final String DURATION = "duration";
    public static final String FIRST_FRAME_STAGE = "firstFrame";
    public static final String FRESCO_TASK = "fresco";
    public static final String LEAKCANARY_TASK = "leakcanary";
    public static final List<String> MAIN_THREAD_TASK_LIST;
    public static final String PART = "part";
    public static final String PLUGIN_TASK = "pluginInit";
    public static final String SKN_TASK = "skin";
    public static final long UBC_LAUNCH_DURATION_MAX = 60000;
    public static final long UBC_LAUNCH_DURATION_MIN = 50;
    public static final String WEBKIT_TASK = "webkit";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1690960976, "Lcom/baidu/searchbox/launch/stats/SpeedStatsMainTable;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1690960976, "Lcom/baidu/searchbox/launch/stats/SpeedStatsMainTable;");
                return;
            }
        }
        MAIN_THREAD_TASK_LIST = Arrays.asList(LEAKCANARY_TASK, "skin", PLUGIN_TASK, FRESCO_TASK, WEBKIT_TASK);
    }

    public SpeedStatsMainTable() {
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
}
