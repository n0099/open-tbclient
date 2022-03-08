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
/* loaded from: classes3.dex */
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public void applyTo(Vector2 vector2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, vector2) == null) {
            float f2 = vector2.x;
            float f3 = vector2.y;
            vector2.x = (this.m00 * f2) + (this.m01 * f3) + this.m02;
            vector2.y = (this.m10 * f2) + (this.m11 * f3) + this.m12;
        }
    }

    public float det() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (this.m00 * this.m11) - (this.m01 * this.m10) : invokeV.floatValue;
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

    public Affine2 inv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float det = det();
            if (det != 0.0f) {
                float f2 = 1.0f / det;
                float f3 = this.m11;
                float f4 = this.m01;
                float f5 = this.m12;
                float f6 = this.m02;
                float f7 = this.m10;
                float f8 = this.m00;
                this.m00 = f3 * f2;
                this.m01 = (-f4) * f2;
                this.m02 = ((f4 * f5) - (f3 * f6)) * f2;
                this.m10 = (-f7) * f2;
                this.m11 = f8 * f2;
                this.m12 = f2 * ((f7 * f6) - (f5 * f8));
                return this;
            }
            throw new GdxRuntimeException("Can't invert a singular affine matrix");
        }
        return (Affine2) invokeV.objValue;
    }

    public boolean isIdt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.m00 == 1.0f && this.m02 == 0.0f && this.m12 == 0.0f && this.m11 == 1.0f && this.m01 == 0.0f && this.m10 == 0.0f : invokeV.booleanValue;
    }

    public boolean isTranslation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m00 == 1.0f && this.m11 == 1.0f && this.m01 == 0.0f && this.m10 == 0.0f : invokeV.booleanValue;
    }

    public Affine2 mul(Affine2 affine2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, affine2)) == null) {
            float f2 = this.m00;
            float f3 = affine2.m00;
            float f4 = this.m01;
            float f5 = affine2.m10;
            float f6 = (f2 * f3) + (f4 * f5);
            float f7 = affine2.m01;
            float f8 = affine2.m11;
            float f9 = (f2 * f7) + (f4 * f8);
            float f10 = affine2.m02;
            float f11 = affine2.m12;
            float f12 = (f2 * f10) + (f4 * f11) + this.m02;
            float f13 = this.m10;
            float f14 = this.m11;
            this.m00 = f6;
            this.m01 = f9;
            this.m02 = f12;
            this.m10 = (f3 * f13) + (f5 * f14);
            this.m11 = (f7 * f13) + (f8 * f14);
            this.m12 = (f13 * f10) + (f14 * f11) + this.m12;
            return this;
        }
        return (Affine2) invokeL.objValue;
    }

    public Affine2 preMul(Affine2 affine2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, affine2)) == null) {
            float f2 = affine2.m00;
            float f3 = this.m00;
            float f4 = affine2.m01;
            float f5 = this.m10;
            float f6 = (f2 * f3) + (f4 * f5);
            float f7 = this.m01;
            float f8 = this.m11;
            float f9 = (f2 * f7) + (f4 * f8);
            float f10 = this.m02;
            float f11 = this.m12;
            float f12 = (f2 * f10) + (f4 * f11) + affine2.m02;
            float f13 = affine2.m10;
            float f14 = affine2.m11;
            this.m00 = f6;
            this.m01 = f9;
            this.m02 = f12;
            this.m10 = (f3 * f13) + (f5 * f14);
            this.m11 = (f7 * f13) + (f8 * f14);
            this.m12 = (f13 * f10) + (f14 * f11) + affine2.m12;
            return this;
        }
        return (Affine2) invokeL.objValue;
    }

    public Affine2 preRotate(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048585, this, f2)) == null) {
            if (f2 == 0.0f) {
                return this;
            }
            float d2 = d.d(f2);
            float p = d.p(f2);
            float f3 = this.m00;
            float f4 = this.m10;
            float f5 = this.m01;
            float f6 = this.m11;
            float f7 = this.m02;
            float f8 = this.m12;
            this.m00 = (d2 * f3) - (p * f4);
            this.m01 = (d2 * f5) - (p * f6);
            this.m02 = (d2 * f7) - (p * f8);
            this.m10 = (f3 * p) + (f4 * d2);
            this.m11 = (f5 * p) + (f6 * d2);
            this.m12 = (p * f7) + (d2 * f8);
            return this;
        }
        return (Affine2) invokeF.objValue;
    }

    public Affine2 preRotateRad(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048586, this, f2)) == null) {
            if (f2 == 0.0f) {
                return this;
            }
            float c2 = d.c(f2);
            float o = d.o(f2);
            float f3 = this.m00;
            float f4 = this.m10;
            float f5 = this.m01;
            float f6 = this.m11;
            float f7 = this.m02;
            float f8 = this.m12;
            this.m00 = (c2 * f3) - (o * f4);
            this.m01 = (c2 * f5) - (o * f6);
            this.m02 = (c2 * f7) - (o * f8);
            this.m10 = (f3 * o) + (f4 * c2);
            this.m11 = (f5 * o) + (f6 * c2);
            this.m12 = (o * f7) + (c2 * f8);
            return this;
        }
        return (Affine2) invokeF.objValue;
    }

    public Affine2 preScale(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048587, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.m00 *= f2;
            this.m01 *= f2;
            this.m02 *= f2;
            this.m10 *= f3;
            this.m11 *= f3;
            this.m12 *= f3;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 preShear(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048589, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = this.m00;
            float f5 = this.m10;
            float f6 = this.m01;
            float f7 = this.m11;
            float f8 = this.m02;
            float f9 = this.m12;
            this.m00 = (f2 * f5) + f4;
            this.m01 = (f2 * f7) + f6;
            this.m02 = (f2 * f9) + f8;
            this.m10 = f5 + (f4 * f3);
            this.m11 = f7 + (f6 * f3);
            this.m12 = f9 + (f3 * f8);
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 preTranslate(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.m02 += f2;
            this.m12 += f3;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 rotate(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048593, this, f2)) == null) {
            if (f2 == 0.0f) {
                return this;
            }
            float d2 = d.d(f2);
            float p = d.p(f2);
            float f3 = this.m00;
            float f4 = this.m01;
            float f5 = (f3 * d2) + (f4 * p);
            float f6 = -p;
            float f7 = (f3 * f6) + (f4 * d2);
            float f8 = this.m10;
            float f9 = this.m11;
            this.m00 = f5;
            this.m01 = f7;
            this.m10 = (f8 * d2) + (p * f9);
            this.m11 = (f8 * f6) + (f9 * d2);
            return this;
        }
        return (Affine2) invokeF.objValue;
    }

    public Affine2 rotateRad(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048594, this, f2)) == null) {
            if (f2 == 0.0f) {
                return this;
            }
            float c2 = d.c(f2);
            float o = d.o(f2);
            float f3 = this.m00;
            float f4 = this.m01;
            float f5 = (f3 * c2) + (f4 * o);
            float f6 = -o;
            float f7 = (f3 * f6) + (f4 * c2);
            float f8 = this.m10;
            float f9 = this.m11;
            this.m00 = f5;
            this.m01 = f7;
            this.m10 = (f8 * c2) + (o * f9);
            this.m11 = (f8 * f6) + (f9 * c2);
            return this;
        }
        return (Affine2) invokeF.objValue;
    }

    public Affine2 scale(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048595, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.m00 *= f2;
            this.m01 *= f3;
            this.m10 *= f2;
            this.m11 *= f3;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
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

    public Affine2 setToProduct(Affine2 affine2, Affine2 affine22) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, affine2, affine22)) == null) {
            float f2 = affine2.m00 * affine22.m00;
            float f3 = affine2.m01;
            float f4 = affine22.m10;
            this.m00 = f2 + (f3 * f4);
            float f5 = affine2.m00;
            float f6 = affine22.m11;
            this.m01 = (affine22.m01 * f5) + (f3 * f6);
            float f7 = f5 * affine22.m02;
            float f8 = affine2.m01;
            float f9 = affine22.m12;
            this.m02 = f7 + (f8 * f9) + affine2.m02;
            float f10 = affine2.m10 * affine22.m00;
            float f11 = affine2.m11;
            this.m10 = f10 + (f4 * f11);
            float f12 = affine2.m10;
            this.m11 = (affine22.m01 * f12) + (f11 * f6);
            this.m12 = (f12 * affine22.m02) + (affine2.m11 * f9) + affine2.m12;
            return this;
        }
        return (Affine2) invokeLL.objValue;
    }

    public Affine2 setToRotation(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048601, this, f2)) == null) {
            float d2 = d.d(f2);
            float p = d.p(f2);
            this.m00 = d2;
            this.m01 = -p;
            this.m02 = 0.0f;
            this.m10 = p;
            this.m11 = d2;
            this.m12 = 0.0f;
            return this;
        }
        return (Affine2) invokeF.objValue;
    }

    public Affine2 setToRotationRad(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048603, this, f2)) == null) {
            float c2 = d.c(f2);
            float o = d.o(f2);
            this.m00 = c2;
            this.m01 = -o;
            this.m02 = 0.0f;
            this.m10 = o;
            this.m11 = c2;
            this.m12 = 0.0f;
            return this;
        }
        return (Affine2) invokeF.objValue;
    }

    public Affine2 setToScaling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.m00 = f2;
            this.m01 = 0.0f;
            this.m02 = 0.0f;
            this.m10 = 0.0f;
            this.m11 = f3;
            this.m12 = 0.0f;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 setToShearing(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.m00 = 1.0f;
            this.m01 = f2;
            this.m02 = 0.0f;
            this.m10 = f3;
            this.m11 = 1.0f;
            this.m12 = 0.0f;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 setToTranslation(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.m00 = 1.0f;
            this.m01 = 0.0f;
            this.m02 = f2;
            this.m10 = 0.0f;
            this.m11 = 1.0f;
            this.m12 = f3;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 setToTrnRotRadScl(float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            this.m02 = f2;
            this.m12 = f3;
            if (f4 == 0.0f) {
                this.m00 = f5;
                this.m01 = 0.0f;
                this.m10 = 0.0f;
                this.m11 = f6;
            } else {
                float o = d.o(f4);
                float c2 = d.c(f4);
                this.m00 = c2 * f5;
                this.m01 = (-o) * f6;
                this.m10 = o * f5;
                this.m11 = c2 * f6;
            }
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 setToTrnRotScl(float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            this.m02 = f2;
            this.m12 = f3;
            if (f4 == 0.0f) {
                this.m00 = f5;
                this.m01 = 0.0f;
                this.m10 = 0.0f;
                this.m11 = f6;
            } else {
                float p = d.p(f4);
                float d2 = d.d(f4);
                this.m00 = d2 * f5;
                this.m01 = (-p) * f6;
                this.m10 = p * f5;
                this.m11 = d2 * f6;
            }
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 setToTrnScl(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            this.m00 = f4;
            this.m01 = 0.0f;
            this.m02 = f2;
            this.m10 = 0.0f;
            this.m11 = f5;
            this.m12 = f3;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 shear(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048616, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = this.m00;
            float f5 = this.m01;
            this.m00 = (f3 * f5) + f4;
            this.m01 = f5 + (f4 * f2);
            float f6 = this.m10;
            float f7 = this.m11;
            this.m10 = (f3 * f7) + f6;
            this.m11 = f7 + (f2 * f6);
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + this.m00 + "|" + this.m01 + "|" + this.m02 + "]\n[" + this.m10 + "|" + this.m11 + "|" + this.m12 + "]\n[0.0|0.0|0.1]";
        }
        return (String) invokeV.objValue;
    }

    public Affine2 translate(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048619, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.m02 += (this.m00 * f2) + (this.m01 * f3);
            this.m12 += (this.m10 * f2) + (this.m11 * f3);
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 preTranslate(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, vector2)) == null) ? preTranslate(vector2.x, vector2.y) : (Affine2) invokeL.objValue;
    }

    public Affine2 translate(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048620, this, vector2)) == null) ? translate(vector2.x, vector2.y) : (Affine2) invokeL.objValue;
    }

    public Affine2(Affine2 affine2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {affine2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public Affine2 scale(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, vector2)) == null) ? scale(vector2.x, vector2.y) : (Affine2) invokeL.objValue;
    }

    public Affine2 preScale(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, vector2)) == null) ? preScale(vector2.x, vector2.y) : (Affine2) invokeL.objValue;
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

    public Affine2 setToScaling(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, vector2)) == null) ? setToScaling(vector2.x, vector2.y) : (Affine2) invokeL.objValue;
    }

    public Affine2 setToShearing(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, vector2)) == null) ? setToShearing(vector2.x, vector2.y) : (Affine2) invokeL.objValue;
    }

    public Affine2 setToTranslation(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, vector2)) == null) ? setToTranslation(vector2.x, vector2.y) : (Affine2) invokeL.objValue;
    }

    public Affine2 setToTrnScl(Vector2 vector2, Vector2 vector22) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048615, this, vector2, vector22)) == null) ? setToTrnScl(vector2.x, vector2.y, vector22.x, vector22.y) : (Affine2) invokeLL.objValue;
    }

    public Affine2 shear(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, vector2)) == null) ? shear(vector2.x, vector2.y) : (Affine2) invokeL.objValue;
    }

    public Affine2 setToRotation(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.m00 = f2;
            this.m01 = -f3;
            this.m02 = 0.0f;
            this.m10 = f3;
            this.m11 = f2;
            this.m12 = 0.0f;
            return this;
        }
        return (Affine2) invokeCommon.objValue;
    }

    public Affine2 preShear(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, vector2)) == null) ? preShear(vector2.x, vector2.y) : (Affine2) invokeL.objValue;
    }

    public Affine2 setToTrnRotRadScl(Vector2 vector2, float f2, Vector2 vector22) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{vector2, Float.valueOf(f2), vector22})) == null) ? setToTrnRotRadScl(vector2.x, vector2.y, f2, vector22.x, vector22.y) : (Affine2) invokeCommon.objValue;
    }

    public Affine2 setToTrnRotScl(Vector2 vector2, float f2, Vector2 vector22) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{vector2, Float.valueOf(f2), vector22})) == null) ? setToTrnRotScl(vector2.x, vector2.y, f2, vector22.x, vector22.y) : (Affine2) invokeCommon.objValue;
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
}
