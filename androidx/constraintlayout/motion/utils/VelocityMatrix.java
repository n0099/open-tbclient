package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class VelocityMatrix {
    public static /* synthetic */ Interceptable $ic = null;
    public static String TAG = "VelocityMatrix";
    public transient /* synthetic */ FieldHolder $fh;
    public float mDRotate;
    public float mDScaleX;
    public float mDScaleY;
    public float mDTranslateX;
    public float mDTranslateY;
    public float mRotate;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1460379476, "Landroidx/constraintlayout/motion/utils/VelocityMatrix;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1460379476, "Landroidx/constraintlayout/motion/utils/VelocityMatrix;");
        }
    }

    public VelocityMatrix() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public void applyTransform(float f2, float f3, int i2, int i3, float[] fArr) {
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i3), fArr}) == null) {
            float f5 = fArr[0];
            float f6 = fArr[1];
            float f7 = (f3 - 0.5f) * 2.0f;
            float f8 = f5 + this.mDTranslateX;
            float f9 = f6 + this.mDTranslateY;
            float f10 = f8 + (this.mDScaleX * (f2 - 0.5f) * 2.0f);
            float f11 = f9 + (this.mDScaleY * f7);
            float radians = (float) Math.toRadians(this.mDRotate);
            double radians2 = (float) Math.toRadians(this.mRotate);
            double d2 = i3 * f7;
            fArr[0] = f10 + (((float) ((((-i2) * f4) * Math.sin(radians2)) - (Math.cos(radians2) * d2))) * radians);
            fArr[1] = f11 + (radians * ((float) (((i2 * f4) * Math.cos(radians2)) - (d2 * Math.sin(radians2)))));
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.mDRotate = 0.0f;
            this.mDTranslateY = 0.0f;
            this.mDTranslateX = 0.0f;
            this.mDScaleY = 0.0f;
            this.mDScaleX = 0.0f;
        }
    }

    public void setRotationVelocity(SplineSet splineSet, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(1048579, this, splineSet, f2) == null) || splineSet == null) {
            return;
        }
        this.mDRotate = splineSet.getSlope(f2);
        this.mRotate = splineSet.get(f2);
    }

    public void setScaleVelocity(SplineSet splineSet, SplineSet splineSet2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{splineSet, splineSet2, Float.valueOf(f2)}) == null) {
            if (splineSet != null) {
                this.mDScaleX = splineSet.getSlope(f2);
            }
            if (splineSet2 != null) {
                this.mDScaleY = splineSet2.getSlope(f2);
            }
        }
    }

    public void setTranslationVelocity(SplineSet splineSet, SplineSet splineSet2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{splineSet, splineSet2, Float.valueOf(f2)}) == null) {
            if (splineSet != null) {
                this.mDTranslateX = splineSet.getSlope(f2);
            }
            if (splineSet2 != null) {
                this.mDTranslateY = splineSet2.getSlope(f2);
            }
        }
    }

    public void setRotationVelocity(KeyCycleOscillator keyCycleOscillator, float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, keyCycleOscillator, f2) == null) || keyCycleOscillator == null) {
            return;
        }
        this.mDRotate = keyCycleOscillator.getSlope(f2);
    }

    public void setScaleVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{keyCycleOscillator, keyCycleOscillator2, Float.valueOf(f2)}) == null) {
            if (keyCycleOscillator == null && keyCycleOscillator2 == null) {
                return;
            }
            if (keyCycleOscillator == null) {
                this.mDScaleX = keyCycleOscillator.getSlope(f2);
            }
            if (keyCycleOscillator2 == null) {
                this.mDScaleY = keyCycleOscillator2.getSlope(f2);
            }
        }
    }

    public void setTranslationVelocity(KeyCycleOscillator keyCycleOscillator, KeyCycleOscillator keyCycleOscillator2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{keyCycleOscillator, keyCycleOscillator2, Float.valueOf(f2)}) == null) {
            if (keyCycleOscillator != null) {
                this.mDTranslateX = keyCycleOscillator.getSlope(f2);
            }
            if (keyCycleOscillator2 != null) {
                this.mDTranslateY = keyCycleOscillator2.getSlope(f2);
            }
        }
    }
}
