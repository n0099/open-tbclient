package com.baidu.searchbox.v8engine.util;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MarioDebug {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean DEBUG_ALTERNATIVE_PATH = false;
    public static final boolean DEBUG_PERFORMANCE = false;
    public static final boolean DEBUG_RENDER = false;
    public static final boolean DEBUG_STUCK_SCREEN = false;
    public transient /* synthetic */ FieldHolder $fh;

    public MarioDebug() {
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
