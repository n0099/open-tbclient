package com.baidu.pass.biometrics.base.armor;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes2.dex */
public class RimArmor {
    public static /* synthetic */ Interceptable $ic;
    public static RimArmor a;
    public transient /* synthetic */ FieldHolder $fh;

    public native String getToken();

    public RimArmor() {
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

    public static synchronized RimArmor getInstance() {
        InterceptResult invokeV;
        RimArmor rimArmor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (RimArmor.class) {
                if (a == null) {
                    a = new RimArmor();
                }
                rimArmor = a;
            }
            return rimArmor;
        }
        return (RimArmor) invokeV.objValue;
    }
}
