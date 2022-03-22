package com.baidu.ar.bean;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class RotationType {
    public static final /* synthetic */ RotationType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final RotationType ROTATE_0;
    public static final RotationType ROTATE_180;
    public static final RotationType ROTATE_270;
    public static final RotationType ROTATE_90;
    public transient /* synthetic */ FieldHolder $fh;
    public final int mDegree;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(272821108, "Lcom/baidu/ar/bean/RotationType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(272821108, "Lcom/baidu/ar/bean/RotationType;");
                return;
            }
        }
        ROTATE_0 = new RotationType("ROTATE_0", 0, 0);
        ROTATE_90 = new RotationType("ROTATE_90", 1, 90);
        ROTATE_180 = new RotationType("ROTATE_180", 2, 180);
        RotationType rotationType = new RotationType("ROTATE_270", 3, 270);
        ROTATE_270 = rotationType;
        $VALUES = new RotationType[]{ROTATE_0, ROTATE_90, ROTATE_180, rotationType};
    }

    public RotationType(String str, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mDegree = i2;
    }

    public static RotationType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (RotationType) Enum.valueOf(RotationType.class, str) : (RotationType) invokeL.objValue;
    }

    public static RotationType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (RotationType[]) $VALUES.clone() : (RotationType[]) invokeV.objValue;
    }

    public int getDegree() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mDegree : invokeV.intValue;
    }
}
