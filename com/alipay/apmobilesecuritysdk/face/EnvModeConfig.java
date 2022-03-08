package com.alipay.apmobilesecuritysdk.face;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class EnvModeConfig {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int ENVIRONMENT_AAA = 4;
    public static final int ENVIRONMENT_DAILY = 1;
    public static final int ENVIRONMENT_ONLINE = 0;
    public static final int ENVIRONMENT_PRE = 2;
    public static final int ENVIRONMENT_SIT = 3;
    public transient /* synthetic */ FieldHolder $fh;

    public EnvModeConfig() {
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
