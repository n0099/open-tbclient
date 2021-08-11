package com.baidu.mobads.sdk.api;

import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class RsplashType {
    public static final /* synthetic */ RsplashType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final RsplashType HTML;
    public static final RsplashType IMAGE;
    public static final RsplashType VIDEO;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-748231485, "Lcom/baidu/mobads/sdk/api/RsplashType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-748231485, "Lcom/baidu/mobads/sdk/api/RsplashType;");
                return;
            }
        }
        IMAGE = new RsplashType("IMAGE", 0);
        HTML = new RsplashType("HTML", 1);
        RsplashType rsplashType = new RsplashType(AdParamInfo.AdClickActionString.AD_CLICK_ACTION_VIDEO, 2);
        VIDEO = rsplashType;
        $VALUES = new RsplashType[]{IMAGE, HTML, rsplashType};
    }

    public RsplashType(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static RsplashType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RsplashType) Enum.valueOf(RsplashType.class, str) : (RsplashType) invokeL.objValue;
    }

    public static RsplashType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RsplashType[]) $VALUES.clone() : (RsplashType[]) invokeV.objValue;
    }
}
