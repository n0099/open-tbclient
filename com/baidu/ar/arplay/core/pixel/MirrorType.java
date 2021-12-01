package com.baidu.ar.arplay.core.pixel;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class MirrorType {
    public static final /* synthetic */ MirrorType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final MirrorType HORIZONTALLY;
    public static final MirrorType NO_MIRROR;
    public static final MirrorType VERTICALLY;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(59255619, "Lcom/baidu/ar/arplay/core/pixel/MirrorType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(59255619, "Lcom/baidu/ar/arplay/core/pixel/MirrorType;");
                return;
            }
        }
        NO_MIRROR = new MirrorType("NO_MIRROR", 0);
        HORIZONTALLY = new MirrorType("HORIZONTALLY", 1);
        MirrorType mirrorType = new MirrorType("VERTICALLY", 2);
        VERTICALLY = mirrorType;
        $VALUES = new MirrorType[]{NO_MIRROR, HORIZONTALLY, mirrorType};
    }

    public MirrorType(String str, int i2) {
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

    public static MirrorType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MirrorType) Enum.valueOf(MirrorType.class, str) : (MirrorType) invokeL.objValue;
    }

    public static MirrorType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MirrorType[]) $VALUES.clone() : (MirrorType[]) invokeV.objValue;
    }
}
