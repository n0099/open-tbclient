package com.baidu.pass.face.platform;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes8.dex */
public final class LivenessTypeEnum {
    public static final /* synthetic */ LivenessTypeEnum[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final LivenessTypeEnum Eye;
    public static final LivenessTypeEnum HeadDown;
    public static final LivenessTypeEnum HeadLeft;
    public static final LivenessTypeEnum HeadRight;
    public static final LivenessTypeEnum HeadUp;
    public static final LivenessTypeEnum Mouth;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1581671555, "Lcom/baidu/pass/face/platform/LivenessTypeEnum;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1581671555, "Lcom/baidu/pass/face/platform/LivenessTypeEnum;");
                return;
            }
        }
        Eye = new LivenessTypeEnum("Eye", 0);
        Mouth = new LivenessTypeEnum("Mouth", 1);
        HeadRight = new LivenessTypeEnum("HeadRight", 2);
        HeadLeft = new LivenessTypeEnum("HeadLeft", 3);
        HeadUp = new LivenessTypeEnum("HeadUp", 4);
        LivenessTypeEnum livenessTypeEnum = new LivenessTypeEnum("HeadDown", 5);
        HeadDown = livenessTypeEnum;
        $VALUES = new LivenessTypeEnum[]{Eye, Mouth, HeadRight, HeadLeft, HeadUp, livenessTypeEnum};
    }

    public LivenessTypeEnum(String str, int i2) {
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

    public static LivenessTypeEnum valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (LivenessTypeEnum) Enum.valueOf(LivenessTypeEnum.class, str) : (LivenessTypeEnum) invokeL.objValue;
    }

    public static LivenessTypeEnum[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (LivenessTypeEnum[]) $VALUES.clone() : (LivenessTypeEnum[]) invokeV.objValue;
    }
}
