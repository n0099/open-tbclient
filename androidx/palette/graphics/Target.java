package androidx.palette.graphics;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class Target {
    public static /* synthetic */ Interceptable $ic = null;
    public static final Target DARK_MUTED;
    public static final Target DARK_VIBRANT;
    public static final int INDEX_MAX = 2;
    public static final int INDEX_MIN = 0;
    public static final int INDEX_TARGET = 1;
    public static final int INDEX_WEIGHT_LUMA = 1;
    public static final int INDEX_WEIGHT_POP = 2;
    public static final int INDEX_WEIGHT_SAT = 0;
    public static final Target LIGHT_MUTED;
    public static final Target LIGHT_VIBRANT;
    public static final float MAX_DARK_LUMA = 0.45f;
    public static final float MAX_MUTED_SATURATION = 0.4f;
    public static final float MAX_NORMAL_LUMA = 0.7f;
    public static final float MIN_LIGHT_LUMA = 0.55f;
    public static final float MIN_NORMAL_LUMA = 0.3f;
    public static final float MIN_VIBRANT_SATURATION = 0.35f;
    public static final Target MUTED;
    public static final float TARGET_DARK_LUMA = 0.26f;
    public static final float TARGET_LIGHT_LUMA = 0.74f;
    public static final float TARGET_MUTED_SATURATION = 0.3f;
    public static final float TARGET_NORMAL_LUMA = 0.5f;
    public static final float TARGET_VIBRANT_SATURATION = 1.0f;
    public static final Target VIBRANT;
    public static final float WEIGHT_LUMA = 0.52f;
    public static final float WEIGHT_POPULATION = 0.24f;
    public static final float WEIGHT_SATURATION = 0.24f;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mIsExclusive;
    public final float[] mLightnessTargets;
    public final float[] mSaturationTargets;
    public final float[] mWeights;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1295686956, "Landroidx/palette/graphics/Target;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1295686956, "Landroidx/palette/graphics/Target;");
                return;
            }
        }
        Target target = new Target();
        LIGHT_VIBRANT = target;
        setDefaultLightLightnessValues(target);
        setDefaultVibrantSaturationValues(LIGHT_VIBRANT);
        Target target2 = new Target();
        VIBRANT = target2;
        setDefaultNormalLightnessValues(target2);
        setDefaultVibrantSaturationValues(VIBRANT);
        Target target3 = new Target();
        DARK_VIBRANT = target3;
        setDefaultDarkLightnessValues(target3);
        setDefaultVibrantSaturationValues(DARK_VIBRANT);
        Target target4 = new Target();
        LIGHT_MUTED = target4;
        setDefaultLightLightnessValues(target4);
        setDefaultMutedSaturationValues(LIGHT_MUTED);
        Target target5 = new Target();
        MUTED = target5;
        setDefaultNormalLightnessValues(target5);
        setDefaultMutedSaturationValues(MUTED);
        Target target6 = new Target();
        DARK_MUTED = target6;
        setDefaultDarkLightnessValues(target6);
        setDefaultMutedSaturationValues(DARK_MUTED);
    }

    public Target() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        float[] fArr = new float[3];
        this.mSaturationTargets = fArr;
        this.mLightnessTargets = new float[3];
        this.mWeights = new float[3];
        this.mIsExclusive = true;
        setTargetDefaultValues(fArr);
        setTargetDefaultValues(this.mLightnessTargets);
        setDefaultWeights();
    }

    public static void setDefaultDarkLightnessValues(Target target) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, null, target) == null) {
            float[] fArr = target.mLightnessTargets;
            fArr[1] = 0.26f;
            fArr[2] = 0.45f;
        }
    }

    public static void setDefaultLightLightnessValues(Target target) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, target) == null) {
            float[] fArr = target.mLightnessTargets;
            fArr[0] = 0.55f;
            fArr[1] = 0.74f;
        }
    }

    public static void setDefaultMutedSaturationValues(Target target) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65541, null, target) == null) {
            float[] fArr = target.mSaturationTargets;
            fArr[1] = 0.3f;
            fArr[2] = 0.4f;
        }
    }

    public static void setDefaultNormalLightnessValues(Target target) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, target) == null) {
            float[] fArr = target.mLightnessTargets;
            fArr[0] = 0.3f;
            fArr[1] = 0.5f;
            fArr[2] = 0.7f;
        }
    }

    public static void setDefaultVibrantSaturationValues(Target target) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, target) == null) {
            float[] fArr = target.mSaturationTargets;
            fArr[0] = 0.35f;
            fArr[1] = 1.0f;
        }
    }

    private void setDefaultWeights() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            float[] fArr = this.mWeights;
            fArr[0] = 0.24f;
            fArr[1] = 0.52f;
            fArr[2] = 0.24f;
        }
    }

    public static void setTargetDefaultValues(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, fArr) == null) {
            fArr[0] = 0.0f;
            fArr[1] = 0.5f;
            fArr[2] = 1.0f;
        }
    }

    public float getLightnessWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mWeights[1] : invokeV.floatValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getMaximumLightness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mLightnessTargets[2] : invokeV.floatValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getMaximumSaturation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mSaturationTargets[2] : invokeV.floatValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getMinimumLightness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mLightnessTargets[0] : invokeV.floatValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getMinimumSaturation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mSaturationTargets[0] : invokeV.floatValue;
    }

    public float getPopulationWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mWeights[2] : invokeV.floatValue;
    }

    public float getSaturationWeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mWeights[0] : invokeV.floatValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getTargetLightness() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mLightnessTargets[1] : invokeV.floatValue;
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float getTargetSaturation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSaturationTargets[1] : invokeV.floatValue;
    }

    public boolean isExclusive() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mIsExclusive : invokeV.booleanValue;
    }

    public void normalizeWeights() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int length = this.mWeights.length;
            float f = 0.0f;
            for (int i = 0; i < length; i++) {
                float f2 = this.mWeights[i];
                if (f2 > 0.0f) {
                    f += f2;
                }
            }
            if (f != 0.0f) {
                int length2 = this.mWeights.length;
                for (int i2 = 0; i2 < length2; i2++) {
                    float[] fArr = this.mWeights;
                    if (fArr[i2] > 0.0f) {
                        fArr[i2] = fArr[i2] / f;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Target mTarget;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mTarget = new Target();
        }

        @NonNull
        public Target build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mTarget : (Target) invokeV.objValue;
        }

        @NonNull
        public Builder setExclusive(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
                this.mTarget.mIsExclusive = z;
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        @NonNull
        public Builder setLightnessWeight(@FloatRange(from = 0.0d) float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f)) == null) {
                this.mTarget.mWeights[1] = f;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        @NonNull
        public Builder setMaximumLightness(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f)) == null) {
                this.mTarget.mLightnessTargets[2] = f;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        @NonNull
        public Builder setMaximumSaturation(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048580, this, f)) == null) {
                this.mTarget.mSaturationTargets[2] = f;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        @NonNull
        public Builder setMinimumLightness(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f)) == null) {
                this.mTarget.mLightnessTargets[0] = f;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        @NonNull
        public Builder setMinimumSaturation(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048582, this, f)) == null) {
                this.mTarget.mSaturationTargets[0] = f;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        @NonNull
        public Builder setPopulationWeight(@FloatRange(from = 0.0d) float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048583, this, f)) == null) {
                this.mTarget.mWeights[2] = f;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        @NonNull
        public Builder setSaturationWeight(@FloatRange(from = 0.0d) float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f)) == null) {
                this.mTarget.mWeights[0] = f;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        @NonNull
        public Builder setTargetLightness(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048585, this, f)) == null) {
                this.mTarget.mLightnessTargets[1] = f;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        @NonNull
        public Builder setTargetSaturation(@FloatRange(from = 0.0d, to = 1.0d) float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048586, this, f)) == null) {
                this.mTarget.mSaturationTargets[1] = f;
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder(@NonNull Target target) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {target};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.mTarget = new Target(target);
        }
    }

    public Target(@NonNull Target target) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {target};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        float[] fArr = new float[3];
        this.mSaturationTargets = fArr;
        this.mLightnessTargets = new float[3];
        this.mWeights = new float[3];
        this.mIsExclusive = true;
        System.arraycopy(target.mSaturationTargets, 0, fArr, 0, fArr.length);
        float[] fArr2 = target.mLightnessTargets;
        float[] fArr3 = this.mLightnessTargets;
        System.arraycopy(fArr2, 0, fArr3, 0, fArr3.length);
        float[] fArr4 = target.mWeights;
        float[] fArr5 = this.mWeights;
        System.arraycopy(fArr4, 0, fArr5, 0, fArr5.length);
    }
}
