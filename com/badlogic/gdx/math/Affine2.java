package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes.dex */
public final class Affine2 implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1524569123485049187L;
    public transient /* synthetic */ FieldHolder $fh;
    public float m00;
    public float m01;
    public float m02;
    public float m10;
    public float m11;
    public float m12;

    public Affine2() {
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
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
    }

    public float det() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return (this.m00 * this.m11) - (this.m01 * this.m10);
        }
        return invokeV.floatValue;
    }

    public Affine2 idt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.m00 = 1.0f;
            this.m01 = 0.0f;
            this.m02 = 0.0f;
            this.m10 = 0.0f;
            this.m11 = 1.0f;
            this.m12 = 0.0f;
            return this;
        }
        return (Affine2) invokeV.objValue;
    }

    public boolean isTranslation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.m00 == 1.0f && this.m11 == 1.0f && this.m01 == 0.0f && this.m10 == 0.0f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Affine2(Affine2 affine2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {affine2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m00 = 1.0f;
        this.m01 = 0.0f;
        this.m02 = 0.0f;
        this.m10 = 0.0f;
        this.m11 = 1.0f;
        this.m12 = 0.0f;
        set(affine2);
    }

    public Affine2 set(Matrix3 matrix3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, matrix3)) == null) {
            float[] fArr = matrix3.val;
            this.m00 = fArr[0];
            this.m01 = fArr[3];
            this.m02 = fArr[6];
            this.m10 = fArr[1];
            this.m11 = fArr[4];
            this.m12 = fArr[7];
            return this;
        }
        return (Affine2) invokeL.objValue;
    }

    public void applyTo(Vector2 vector2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vector2) == null) {
            float f = vector2.x;
            float f2 = vector2.y;
            vector2.x = (this.m00 * f) + (this.m01 * f2) + this.m02;
            vector2.y = (this.m10 * f) + (this.m11 * f2) + this.m12;
        }
    }

    public Vector2 getTranslation(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vector2)) == null) {
            vector2.x = this.m02;
            vector2.y = this.m12;
            return vector2;
        }
        return (Vector2) invokeL.objValue;
    }

    public Affine2 preScale(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, vector2)) == null) {
            return preScale(vector2.x, vector2.y);
        }
        return (Affine2) invokeL.objValue;
    }

    public Affine2 preShear(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, vector2)) == null) {
            return preShear(vector2.x, vector2.y);
        }
        return (Affine2) invokeL.objValue;
    }

    public Affine2 preTranslate(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, vector2)) == null) {
            return preTranslate(vector2.x, vector2.y);
        }
        return (Affine2) invokeL.objValue;
    }

    public Affine2 scale(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, vector2)) == null) {
            return scale(vector2.x, vector2.y);
        }
        return (Affine2) invokeL.objValue;
    }

    public Affine2 set(Affine2 affine2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, affine2)) == null) {
            this.m00 = affine2.m00;
            this.m01 = affine2.m01;
            this.m02 = affine2.m02;
            this.m10 = affine2.m10;
            this.m11 = affine2.m11;
            this.m12 = affine2.m12;
            return this;
        }
        return (Affine2) invokeL.objValue;
    }

    public Affine2 setToRotation(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048601, this, f)) == null) {
            float d = b.d(f);
            float m = b.m(f);
            this.m00 = d;
            this.m01 = -m;
            this.m02 = 0.0f;
            this.m10 = m;
            this.m11 = d;
            this.m12 = 0.0f;
            return this;
        }
        return (Affine2) invokeF.objValue;
    }

    public Affine2 setToRotationRad(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048603, this, f)) == null) {
            float c = b.c(f);
            float l = b.l(f);
            this.m00 = c;
            this.m01 = -l;
            this.m02 = 0.0f;
            this.m10 = l;
            this.m11 = c;
            this.m12 = 0.0f;
            return this;
        }
        return (Affine2) invokeF.objValue;
    }

    public Affine2 setToScaling(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, vector2)) == null) {
            return setToScaling(vector2.x, vector2.y);
        }
        return (Affine2) invokeL.objValue;
    }

    public Affine2 setToShearing(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, vector2)) == null) {
            return setToShearing(vector2.x, vector2.y);
        }
        return (Affine2) invokeL.objValue;
    }

    public Affine2 setToTranslation(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, vector2)) == null) {
            return setToTranslation(vector2.x, vector2.y);
        }
        return (Affine2) invokeL.objValue;
    }

    public Affine2 shear(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, vector2)) == null) {
            return shear(vector2.x, vector2.y);
        }
        return (Affine2) invokeL.objValue;
    }

    public Affine2 translate(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, vector2)) == null) {
            return translate(vector2.x, vector2.y);
        }
        return (Affine2) invokeL.objValue;
    }

    public Affine2 inv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float det = det();
            if (det != 0.0f) {
                float f = 1.0f / det;
                float f2 = this.m11;
                float f3 = this.m01;
                float f4 = this.m12;
                float f5 = this.m02;
                float f6 = this.m10;
                float f7 = this.m00;
                this.m00 = f2 * f;
                this.m01 = (-f3) * f;
                this.m02 = ((f3 * f4) - (f2 * f5)) * f;
                this.m10 = (-f6) * f;
                this.m11 = f7 * f;
                this.m12 = f * ((f6 * f5) - (f4 * f7));
                return this;
            }
            throw new GdxRuntimeException("Can't invert a singular affine matrix");
        }
        return (Affine2) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + this.m00 + "|" + this.m01 + "|" + this.m02 + "]\n[" + this.m10 + "|" + this.m11 + "|" + this.m12 + "]\n[0.0|0.0|0.1]";
        }
        return (String) invokeV.objValue;
    }

    public boolean isIdt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.m00 == 1.0f && this.m02 == 0.0f && this.m12 == 0.0f && this.m11 == 1.0f && this.m01 == 0.0f && this.m10 == 0.0f) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public Affine2 mul(Affine2 affine2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, affine2)) == null) {
            float f = this.m00;
            float f2 = affine2.m00;
            float f3 = this.m01;
            float f4 = affine2.m10;
            float f5 = (f * f2) + (f3 * f4);
            float f6 = affine2.m01;
            float f7 = affine2.m11;
            float f8 = (f * f6) + (f3 * f7);
            float f9 = affine2.m02;
            float f10 = affine2.m12;
            float f11 = (f * f9) + (f3 * f10) + this.m02;
            float f12 = this.m10;
            float f13 = this.m11;
            this.m00 = f5;
            this.m01 = f8;
            this.m02 = f11;
            this.m10 = (f2 * f12) + (f4 * f13);
            this.m11 = (f6 * f12) + (f7 * f13);
            this.m12 = (f12 * f9) + (f13 * f10) + this.m12;
            return this;
        }
        return (Affine2) invokeL.objValue;
    }

    public Affine2 preMul(Affine2 affine2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, affine2)) == null) {
            float f = affine2.m00;
            float f2 = this.m00;
            float f3 = affine2.m01;
            float f4 = this.m10;
            float f5 = (f * f2) + (f3 * f4);
            float f6 = this.m01;
            float f7 = this.m11;
            float f8 = (f * f6) + (f3 * f7);
            float f9 = this.m02;
            float f10 = this.m12;
            float f11 = (f * f9) + (f3 * f10) + affine2.m02;
            float f12 = affine2.m10;
            float f13 = affine2.m11;
            this.m00 = f5;
            this.m01 = f8;
            this.m02 = f11;
            this.m10 = (f2 * f12) + (f4 * f13);
            this.m11 = (f6 * f12) + (f7 * f13);
            this.m12 = (f12 * f9) + (f13 * f10) + affine2.m12;
            return this;
        }
        return (Affine2) invokeL.objValue;
    }

    public Affine2 preRotate(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048585, this, f)) == null) {
            if (f == 0.0f) {
                return this;
            }
            float d = b.d(f);
            float m = b.m(f);
            float f2 = this.m00;
            float f3 = this.m10;
            float f4 = this.m01;
            float f5 = this.m11;
            float f6 = this.m02;
            float f7 = this.m12;
            this.m00 = (d * f2) - (m * f3);
            this.m01 = (d * f4) - (m * f5);
            this.m02 = (d * f6) - (m * f7);
            this.m10 = (f2 * m) + (f3 * d);
            this.m11 = (f4 * m) + (f5 * d);
            this.m12 = (m * f6) + (d * f7);
            return this;
        }
        return (Affine2) invokeF.objValue;
    }

    public Affine2 preRotateRad(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048586, this, f)) == null) {
            if (f == 0.0f) {
                return this;
            }
            float c = b.c(f);
            float l = b.l(f);
            float f2 = this.m00;
            float f3 = this.m10;
            float f4 = this.m01;
            float f5 = this.m11;
            float f6 = this.m02;
            float f7 = this.m12;
            this.m00 = (c * f2) - (l * f3);
            this.m01 = (c * f4) - (l * f5);
            this.m02 = (c * f6) - (l * f7);
            this.m10 = (f2 * l) + (f3 * c);
            this.m11 = (f4 * l) + (f5 * c);
            this.m12 = (l * f6) + (c * f7);
            return this;
        }
        return (Affine2) invokeF.objValue;
    }

    public Affine2 rotate(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048593, this, f)) == null) {
            if (f == 0.0f) {
                return this;
            }
            float d = b.d(f);
            float m = b.m(f);
            float f2 = this.m00;
            float f3 = this.m01;
            float f4 = (f2 * d) + (f3 * m);
            float f5 = -m;
            float f6 = (f2 * f5) + (f3 * d);
            float f7 = this.m10;
            float f8 = this.m11;
            this.m00 = f4;
            this.m01 = f6;
            this.m10 = (f7 * d) + (m * f8);
            this.m11 = (f7 * f5) + (f8 * d);
            return this;
        }
        return (Affine2) invokeF.objValue;
    }

    public Affine2 rotateRad(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048594, this, f)) == null) {
            if (f == 0.0f) {
                return this;
            }
            float c = b.c(f);
            float l = b.l(f);
            float f2 = this.m00;
            float f3 = this.m01;
            float f4 = (f2 * c) + (f3 * l);
            float f5 = -l;
            float f6 = (f2 * f5) + (f3 * c);
            float f7 = this.m10;
            float f8 = this.m11;
            this.m00 = f4;
            this.m01 = f6;
            this.m10 = (f7 * c) + (l * f8);
            this.m11 = (f7 * f5) + (f8 * c);
            return this;
        }
        return (Affine2) invokeF.objValue;
    }

    public Affine2 preScale(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.m00 *= f;
            this.m01 *= f;
            this.m02 *= f;
            this.m10 *= f2;
            this.m11 *= f2;
            this.m12 *= f2;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 preShear(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float f3 = this.m00;
            float f4 = this.m10;
            float f5 = this.m01;
            float f6 = this.m11;
            float f7 = this.m02;
            float f8 = this.m12;
            this.m00 = (f * f4) + f3;
            this.m01 = (f * f6) + f5;
            this.m02 = (f * f8) + f7;
            this.m10 = f4 + (f3 * f2);
            this.m11 = f6 + (f5 * f2);
            this.m12 = f8 + (f2 * f7);
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 preTranslate(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.m02 += f;
            this.m12 += f2;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 setToTrnScl(Vector2 vector2, Vector2 vector22) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048615, this, vector2, vector22)) == null) {
            return setToTrnScl(vector2.x, vector2.y, vector22.x, vector22.y);
        }
        return (Affine2) invokeLL.objValue;
    }

    public Affine2 scale(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.m00 *= f;
            this.m01 *= f2;
            this.m10 *= f;
            this.m11 *= f2;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 setToRotation(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.m00 = f;
            this.m01 = -f2;
            this.m02 = 0.0f;
            this.m10 = f2;
            this.m11 = f;
            this.m12 = 0.0f;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 setToScaling(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.m00 = f;
            this.m01 = 0.0f;
            this.m02 = 0.0f;
            this.m10 = 0.0f;
            this.m11 = f2;
            this.m12 = 0.0f;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 setToShearing(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.m00 = 1.0f;
            this.m01 = f;
            this.m02 = 0.0f;
            this.m10 = f2;
            this.m11 = 1.0f;
            this.m12 = 0.0f;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 setToTranslation(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.m00 = 1.0f;
            this.m01 = 0.0f;
            this.m02 = f;
            this.m10 = 0.0f;
            this.m11 = 1.0f;
            this.m12 = f2;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 shear(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048616, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float f3 = this.m00;
            float f4 = this.m01;
            this.m00 = (f2 * f4) + f3;
            this.m01 = f4 + (f3 * f);
            float f5 = this.m10;
            float f6 = this.m11;
            this.m10 = (f2 * f6) + f5;
            this.m11 = f6 + (f * f5);
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 translate(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048619, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.m02 += (this.m00 * f) + (this.m01 * f2);
            this.m12 += (this.m10 * f) + (this.m11 * f2);
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 set(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, matrix4)) == null) {
            float[] fArr = matrix4.val;
            this.m00 = fArr[0];
            this.m01 = fArr[4];
            this.m02 = fArr[12];
            this.m10 = fArr[1];
            this.m11 = fArr[5];
            this.m12 = fArr[13];
            return this;
        }
        return (Affine2) invokeL.objValue;
    }

    public Affine2 setToProduct(Affine2 affine2, Affine2 affine22) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, affine2, affine22)) == null) {
            float f = affine2.m00 * affine22.m00;
            float f2 = affine2.m01;
            float f3 = affine22.m10;
            this.m00 = f + (f2 * f3);
            float f4 = affine2.m00;
            float f5 = affine22.m11;
            this.m01 = (affine22.m01 * f4) + (f2 * f5);
            float f6 = f4 * affine22.m02;
            float f7 = affine2.m01;
            float f8 = affine22.m12;
            this.m02 = f6 + (f7 * f8) + affine2.m02;
            float f9 = affine2.m10 * affine22.m00;
            float f10 = affine2.m11;
            this.m10 = f9 + (f3 * f10);
            float f11 = affine2.m10;
            this.m11 = (affine22.m01 * f11) + (f10 * f5);
            this.m12 = (f11 * affine22.m02) + (affine2.m11 * f8) + affine2.m12;
            return this;
        }
        return (Affine2) invokeLL.objValue;
    }

    public Affine2 setToTrnRotRadScl(float f, float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            this.m02 = f;
            this.m12 = f2;
            if (f3 == 0.0f) {
                this.m00 = f4;
                this.m01 = 0.0f;
                this.m10 = 0.0f;
                this.m11 = f5;
            } else {
                float l = b.l(f3);
                float c = b.c(f3);
                this.m00 = c * f4;
                this.m01 = (-l) * f5;
                this.m10 = l * f4;
                this.m11 = c * f5;
            }
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 setToTrnRotScl(float f, float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            this.m02 = f;
            this.m12 = f2;
            if (f3 == 0.0f) {
                this.m00 = f4;
                this.m01 = 0.0f;
                this.m10 = 0.0f;
                this.m11 = f5;
            } else {
                float m = b.m(f3);
                float d = b.d(f3);
                this.m00 = d * f4;
                this.m01 = (-m) * f5;
                this.m10 = m * f4;
                this.m11 = d * f5;
            }
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 setToTrnRotRadScl(Vector2 vector2, float f, Vector2 vector22) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{vector2, Float.valueOf(f), vector22})) == null) {
            return setToTrnRotRadScl(vector2.x, vector2.y, f, vector22.x, vector22.y);
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 setToTrnRotScl(Vector2 vector2, float f, Vector2 vector22) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{vector2, Float.valueOf(f), vector22})) == null) {
            return setToTrnRotScl(vector2.x, vector2.y, f, vector22.x, vector22.y);
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 setToTrnScl(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            this.m00 = f3;
            this.m01 = 0.0f;
            this.m02 = f;
            this.m10 = 0.0f;
            this.m11 = f4;
            this.m12 = f2;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }
}
