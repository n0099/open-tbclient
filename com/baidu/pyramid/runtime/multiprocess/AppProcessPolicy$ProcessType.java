package com.baidu.pyramid.runtime.multiprocess;

import com.baidu.searchbox.network.outback.EngineName;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.codec.language.bm.Rule;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
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
        ALL = new AppProcessPolicy$ProcessType(Rule.ALL, 0);
        DEFAULT = new AppProcessPolicy$ProcessType(EngineName.DEFAULT_ENGINE, 1);
        SERVER = new AppProcessPolicy$ProcessType("SERVER", 2);
        AppProcessPolicy$ProcessType appProcessPolicy$ProcessType = new AppProcessPolicy$ProcessType("OTHER", 3);
        OTHER = appProcessPolicy$ProcessType;
        $VALUES = new AppProcessPolicy$ProcessType[]{ALL, DEFAULT, SERVER, appProcessPolicy$ProcessType};
    }

    public AppProcessPolicy$ProcessType(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (AppProcessPolicy$ProcessType) Enum.valueOf(AppProcessPolicy$ProcessType.class, str);
        }
        return (AppProcessPolicy$ProcessType) invokeL.objValue;
    }

    public static AppProcessPolicy$ProcessType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (AppProcessPolicy$ProcessType[]) $VALUES.clone();
        }
        return (AppProcessPolicy$ProcessType[]) invokeV.objValue;
    }
}
