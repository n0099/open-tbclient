package com.baidu.mapapi;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class OpenLogUtil {
    public static /* synthetic */ Interceptable $ic;
    public static ModuleName a;
    public transient /* synthetic */ FieldHolder $fh;

    public OpenLogUtil() {
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

    public static void setModuleLogEnable(ModuleName moduleName, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65537, null, moduleName, z) == null) {
            a = moduleName;
            com.baidu.mapsdkplatform.comjni.tools.a.a(z, moduleName.ordinal());
        }
    }
}
