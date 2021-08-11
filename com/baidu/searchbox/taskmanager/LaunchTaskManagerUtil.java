package com.baidu.searchbox.taskmanager;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class LaunchTaskManagerUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long DEFAULT_DELAY_SCHEDULE_TIME = 3000;
    public static final long FEED_AUTOFRESH_SCHEDULE_DELAY_TIME = 4000;
    public transient /* synthetic */ FieldHolder $fh;

    public LaunchTaskManagerUtil() {
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
