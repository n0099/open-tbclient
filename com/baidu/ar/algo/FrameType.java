package com.baidu.ar.algo;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes.dex */
public final class FrameType {
    public static final /* synthetic */ FrameType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final FrameType TYPE_BGR;
    public static final FrameType TYPE_GRAY;
    public static final FrameType TYPE_RGB;
    public static final FrameType TYPE_RGBA;
    public static final FrameType TYPE_YUV;
    public transient /* synthetic */ FieldHolder $fh;
    public int value;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-913125920, "Lcom/baidu/ar/algo/FrameType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-913125920, "Lcom/baidu/ar/algo/FrameType;");
                return;
            }
        }
        TYPE_YUV = new FrameType("TYPE_YUV", 0, 0);
        TYPE_RGB = new FrameType("TYPE_RGB", 1, 1);
        TYPE_BGR = new FrameType("TYPE_BGR", 2, 2);
        TYPE_RGBA = new FrameType("TYPE_RGBA", 3, 3);
        FrameType frameType = new FrameType("TYPE_GRAY", 4, 4);
        TYPE_GRAY = frameType;
        $VALUES = new FrameType[]{TYPE_YUV, TYPE_RGB, TYPE_BGR, TYPE_RGBA, frameType};
    }

    public FrameType(String str, int i, int i2) {
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
        this.value = i2;
    }

    public static FrameType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (FrameType) Enum.valueOf(FrameType.class, str) : (FrameType) invokeL.objValue;
    }

    public static FrameType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (FrameType[]) $VALUES.clone() : (FrameType[]) invokeV.objValue;
    }

    public int getValue() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.value : invokeV.intValue;
    }
}
