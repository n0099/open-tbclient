package com.baidu.pyramid.runtime.multiprocess;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes5.dex */
public final class AppProcessPolicy$ProcessType {
    public static final /* synthetic */ AppProcessPolicy$ProcessType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final AppProcessPolicy$ProcessType ALL;
    public static final AppProcessPolicy$ProcessType DEFAULT;
    public static final AppProcessPolicy$ProcessType OTHER;
    public static final AppProcessPolicy$ProcessType SERVER;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(797298529, "Lcom/baidu/pyramid/runtime/multiprocess/AppProcessPolicy$ProcessType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(797298529, "Lcom/baidu/pyramid/runtime/multiprocess/AppProcessPolicy$ProcessType;");
                return;
            }
        }
        ALL = new AppProcessPolicy$ProcessType("ALL", 0);
        DEFAULT = new AppProcessPolicy$ProcessType("DEFAULT", 1);
        SERVER = new AppProcessPolicy$ProcessType("SERVER", 2);
        AppProcessPolicy$ProcessType appProcessPolicy$ProcessType = new AppProcessPolicy$ProcessType("OTHER", 3);
        OTHER = appProcessPolicy$ProcessType;
        $VALUES = new AppProcessPolicy$ProcessType[]{ALL, DEFAULT, SERVER, appProcessPolicy$ProcessType};
    }

    public AppProcessPolicy$ProcessType(String str, int i2) {
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

    public static AppProcessPolicy$ProcessType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (AppProcessPolicy$ProcessType) Enum.valueOf(AppProcessPolicy$ProcessType.class, str) : (AppProcessPolicy$ProcessType) invokeL.objValue;
    }

    public static AppProcessPolicy$ProcessType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (AppProcessPolicy$ProcessType[]) $VALUES.clone() : (AppProcessPolicy$ProcessType[]) invokeV.objValue;
    }
}
