package com.airbnb.lottie.model.content;

import com.airbnb.lottie.model.animatable.AnimatableIntegerValue;
import com.airbnb.lottie.model.animatable.AnimatableShapeValue;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class Mask {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final boolean inverted;
    public final MaskMode maskMode;
    public final AnimatableShapeValue maskPath;
    public final AnimatableIntegerValue opacity;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
    public static final class MaskMode {
        public static final /* synthetic */ MaskMode[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final MaskMode MASK_MODE_ADD;
        public static final MaskMode MASK_MODE_INTERSECT;
        public static final MaskMode MASK_MODE_NONE;
        public static final MaskMode MASK_MODE_SUBTRACT;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-787365321, "Lcom/airbnb/lottie/model/content/Mask$MaskMode;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-787365321, "Lcom/airbnb/lottie/model/content/Mask$MaskMode;");
                    return;
                }
            }
            MASK_MODE_ADD = new MaskMode("MASK_MODE_ADD", 0);
            MASK_MODE_SUBTRACT = new MaskMode("MASK_MODE_SUBTRACT", 1);
            MASK_MODE_INTERSECT = new MaskMode("MASK_MODE_INTERSECT", 2);
            MaskMode maskMode = new MaskMode("MASK_MODE_NONE", 3);
            MASK_MODE_NONE = maskMode;
            $VALUES = new MaskMode[]{MASK_MODE_ADD, MASK_MODE_SUBTRACT, MASK_MODE_INTERSECT, maskMode};
        }

        public MaskMode(String str, int i2) {
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

        public static MaskMode valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MaskMode) Enum.valueOf(MaskMode.class, str) : (MaskMode) invokeL.objValue;
        }

        public static MaskMode[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MaskMode[]) $VALUES.clone() : (MaskMode[]) invokeV.objValue;
        }
    }

    public Mask(MaskMode maskMode, AnimatableShapeValue animatableShapeValue, AnimatableIntegerValue animatableIntegerValue, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {maskMode, animatableShapeValue, animatableIntegerValue, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.maskMode = maskMode;
        this.maskPath = animatableShapeValue;
        this.opacity = animatableIntegerValue;
        this.inverted = z;
    }

    public MaskMode getMaskMode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.maskMode : (MaskMode) invokeV.objValue;
    }

    public AnimatableShapeValue getMaskPath() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.maskPath : (AnimatableShapeValue) invokeV.objValue;
    }

    public AnimatableIntegerValue getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.opacity : (AnimatableIntegerValue) invokeV.objValue;
    }

    public boolean isInverted() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.inverted : invokeV.booleanValue;
    }
}
