package com.baidu.searchbox.launch.stats;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SpeedStatsMainTable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ACTIVITY_STAGE = "activity";
    public static final String AD_FLAG = "Ad_";
    public static final String AD_SHOW = "adshow";
    public static final String APP_CREATE_FLAG = "AppCreate_";
    public static final String APP_CREATE_STAGE = "appCreate";
    public static final String APP_END_2_ACTIVITY_GAP = "onAppEnd2ActivityStartGap";
    public static final String APP_ZYGOTE = "appZygote";
    public static final String ASYNC_TASK = "asyncTask";
    public static final String ATTACH_WINDOW_STAGE = "attachWindow";
    public static final String BEFORE_APP_CREATE_STAGE = "beforeAppCreate";
    public static final String DURATION = "duration";
    public static final String FIRST_FRAME_STAGE = "firstFrame";
    public static final String PART = "part";
    public static final long UBC_LAUNCH_DURATION_MAX = 60000;
    public static final long UBC_LAUNCH_DURATION_MIN = 50;
    public transient /* synthetic */ FieldHolder $fh;

    public SpeedStatsMainTable() {
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
