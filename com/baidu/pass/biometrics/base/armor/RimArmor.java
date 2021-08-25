package com.baidu.pass.biometrics.base.armor;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class RimArmor {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static RimArmor f43858a;
    public transient /* synthetic */ FieldHolder $fh;

    public RimArmor() {
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

    public static synchronized RimArmor getInstance() {
        InterceptResult invokeV;
        RimArmor rimArmor;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (RimArmor.class) {
                if (f43858a == null) {
                    f43858a = new RimArmor();
                }
                rimArmor = f43858a;
            }
            return rimArmor;
        }
        return (RimArmor) invokeV.objValue;
    }

    public native String getToken();
}
