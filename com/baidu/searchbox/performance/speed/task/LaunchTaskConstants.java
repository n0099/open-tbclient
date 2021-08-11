package com.baidu.searchbox.performance.speed.task;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class LaunchTaskConstants {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int AI_PROCESS = 2;
    public static final int ALL_PROCESS = -1;
    public static final int LIFE_CYCLE_APP_CREATE = 1;
    public static final int LIFE_CYCLE_MAIN_CREATE = 2;
    public static final int LIFE_CYCLE_UI_READY = 3;
    public static final int MAIN_PROCESS = 1;
    public static final int OTHER_PROCESS = 268435456;
    public transient /* synthetic */ FieldHolder $fh;

    public LaunchTaskConstants() {
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
