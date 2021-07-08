package com.baidu.down.utils;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class PatternConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int PATTERN_COMMON = 0;
    public static final int PATTERN_REMOTE_SERVER_HTTPDNS = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public int patternType;

    public PatternConfig() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.patternType = 1;
    }
}
