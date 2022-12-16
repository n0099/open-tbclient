package com.baidu.searchbox.performance.speed.task;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class LaunchTaskConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ALL_PROCESS = -1;
    public static final int LIFE_CYCLE_APP_CREATE_FIRST = 1;
    public static final int LIFE_CYCLE_APP_CREATE_SECOND = 2;
    public static final int LIFE_CYCLE_PRIVACY_POLICY_GRANTED = 3;
    public static final int MAIN_PROCESS = 1;
    public static final int OTHER_PROCESS = 268435456;
    public static final int REMOTE_PROCESS = 16;
    public static final int TASK_TYPE_ASYNC = 2;
    public static final int TASK_TYPE_IDLE = 3;
    public static final int TASK_TYPE_SYNC = 1;
    public static final int VIEW_ACTIVITY = 5;
    public static final int VIEW_APP_CREATE = 4;
    public static final int YUNPUSH_PROCESS = 256;
    public transient /* synthetic */ FieldHolder $fh;

    public LaunchTaskConstants() {
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
