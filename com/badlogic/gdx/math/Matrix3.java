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
/* loaded from: classes9.dex */
public class Matrix3 implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int M00 = 0;
    public static final int M01 = 3;
    public static final int M02 = 6;
    public static final int M10 = 1;
    public static final int M11 = 4;
    public static final int M12 = 7;
    public static final int M20 = 2;
    public static final int M21 = 5;
    public static final int M22 = 8;
    public static final long serialVersionUID = 7907569533774959788L;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] tmp;
    public float[] val;

    public Matrix3() {
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
        this.val = new float[9];
        this.tmp = new float[9];
        idt();
    }

    public float det() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float[] fArr = this.val;
            return ((((((fArr[0] * fArr[4]) * fArr[8]) + ((fArr[3] * fArr[7]) * fArr[2])) + ((fArr[6] * fArr[1]) * fArr[5])) - ((fArr[0] * fArr[7]) * fArr[5])) - ((fArr[3] * fArr[1]) * fArr[8])) - ((fArr[6] * fArr[4]) * fArr[2]);
        }
        return invokeV.floatValue;
    }

    public float getRotation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            float[] fArr = this.val;
            return ((float) Math.atan2(fArr[1], fArr[0])) * 57.295776f;
        }
        return invokeV.floatValue;
    }

    public float getRotationRad() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            float[] fArr = this.val;
            return (float) Math.atan2(fArr[1], fArr[0]);
        }
        return invokeV.floatValue;
    }

    public Vector2 getScale(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, vector2)) == null) {
            float[] fArr = this.val;
            vector2.x = (float) Math.sqrt((fArr[0] * fArr[0]) + (fArr[3] * fArr[3]));
            vector2.y = (float) Math.sqrt((fArr[1] * fArr[1]) + (fArr[4] * fArr[4]));
            return vector2;
        }
        return (Vector2) invokeL.objValue;
    }

    public Vector2 getTranslation(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vector2)) == null) {
            float[] fArr = this.val;
            vector2.x = fArr[6];
            vector2.y = fArr[7];
            return vector2;
        }
        return (Vector2) invokeL.objValue;
    }

    public float[] getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.val : (float[]) invokeV.objValue;
    }

    public Matrix3 idt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            float[] fArr = this.val;
            fArr[0] = 1.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 1.0f;
            fArr[5] = 0.0f;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            return this;
        }
        return (Matrix3) invokeV.objValue;
    }

    public Matrix3 inv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            float det = det();
            if (det != 0.0f) {
                float f2 = 1.0f / det;
                float[] fArr = this.tmp;
                float[] fArr2 = this.val;
                fArr[0] = (fArr2[4] * fArr2[8]) - (fArr2[5] * fArr2[7]);
                fArr[1] = (fArr2[2] * fArr2[7]) - (fArr2[1] * fArr2[8]);
                fArr[2] = (fArr2[1] * fArr2[5]) - (fArr2[2] * fArr2[4]);
                fArr[3] = (fArr2[5] * fArr2[6]) - (fArr2[3] * fArr2[8]);
                fArr[4] = (fArr2[0] * fArr2[8]) - (fArr2[2] * fArr2[6]);
                fArr[5] = (fArr2[2] * fArr2[3]) - (fArr2[0] * fArr2[5]);
                fArr[6] = (fArr2[3] * fArr2[7]) - (fArr2[4] * fArr2[6]);
                fArr[7] = (fArr2[1] * fArr2[6]) - (fArr2[0] * fArr2[7]);
                fArr[8] = (fArr2[0] * fArr2[4]) - (fArr2[1] * fArr2[3]);
                fArr2[0] = fArr[0] * f2;
                fArr2[1] = fArr[1] * f2;
                fArr2[2] = fArr[2] * f2;
                fArr2[3] = fArr[3] * f2;
                fArr2[4] = fArr[4] * f2;
                fArr2[5] = fArr[5] * f2;
                fArr2[6] = fArr[6] * f2;
                fArr2[7] = fArr[7] * f2;
                fArr2[8] = f2 * fArr[8];
                return this;
            }
            throw new GdxRuntimeException("Can't invert a singular matrix");
        }
        return (Matrix3) invokeV.objValue;
    }

    public Matrix3 mul(Matrix3 matrix3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, matrix3)) == null) {
            float[] fArr = this.val;
            float f2 = fArr[0];
            float[] fArr2 = matrix3.val;
            float f3 = (f2 * fArr2[0]) + (fArr[3] * fArr2[1]) + (fArr[6] * fArr2[2]);
            float f4 = (fArr[0] * fArr2[3]) + (fArr[3] * fArr2[4]) + (fArr[6] * fArr2[5]);
            float f5 = (fArr[0] * fArr2[6]) + (fArr[3] * fArr2[7]) + (fArr[6] * fArr2[8]);
            float f6 = (fArr[1] * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[7] * fArr2[2]);
            float f7 = (fArr[1] * fArr2[3]) + (fArr[4] * fArr2[4]) + (fArr[7] * fArr2[5]);
            float f8 = (fArr[1] * fArr2[6]) + (fArr[4] * fArr2[7]) + (fArr[7] * fArr2[8]);
            float f9 = (fArr[2] * fArr2[0]) + (fArr[5] * fArr2[1]) + (fArr[8] * fArr2[2]);
            float f10 = (fArr[2] * fArr2[3]) + (fArr[5] * fArr2[4]) + (fArr[8] * fArr2[5]);
            fArr[0] = f3;
            fArr[1] = f6;
            fArr[2] = f9;
            fArr[3] = f4;
            fArr[4] = f7;
            fArr[5] = f10;
            fArr[6] = f5;
            fArr[7] = f8;
            fArr[8] = (fArr[2] * fArr2[6]) + (fArr[5] * fArr2[7]) + (fArr[8] * fArr2[8]);
            return this;
        }
        return (Matrix3) invokeL.objValue;
    }

    public Matrix3 mulLeft(Matrix3 matrix3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, matrix3)) == null) {
            float[] fArr = this.val;
            float[] fArr2 = matrix3.val;
            float f2 = (fArr2[0] * fArr[0]) + (fArr2[3] * fArr[1]) + (fArr2[6] * fArr[2]);
            float f3 = (fArr2[0] * fArr[3]) + (fArr2[3] * fArr[4]) + (fArr2[6] * fArr[5]);
            float f4 = (fArr2[0] * fArr[6]) + (fArr2[3] * fArr[7]) + (fArr2[6] * fArr[8]);
            float f5 = (fArr2[1] * fArr[0]) + (fArr2[4] * fArr[1]) + (fArr2[7] * fArr[2]);
            float f6 = (fArr2[1] * fArr[3]) + (fArr2[4] * fArr[4]) + (fArr2[7] * fArr[5]);
            float f7 = (fArr2[1] * fArr[6]) + (fArr2[4] * fArr[7]) + (fArr2[7] * fArr[8]);
            float f8 = (fArr2[2] * fArr[0]) + (fArr2[5] * fArr[1]) + (fArr2[8] * fArr[2]);
            float f9 = (fArr2[2] * fArr[3]) + (fArr2[5] * fArr[4]) + (fArr2[8] * fArr[5]);
            fArr[0] = f2;
            fArr[1] = f5;
            fArr[2] = f8;
            fArr[3] = f3;
            fArr[4] = f6;
            fArr[5] = f9;
            fArr[6] = f4;
            fArr[7] = f7;
            fArr[8] = (fArr2[2] * fArr[6]) + (fArr2[5] * fArr[7]) + (fArr2[8] * fArr[8]);
            return this;
        }
        return (Matrix3) invokeL.objValue;
    }

    public Matrix3 rotate(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048586, this, f2)) == null) ? rotateRad(f2 * 0.017453292f) : (Matrix3) invokeF.objValue;
    }

    public Matrix3 rotateRad(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048587, this, f2)) == null) {
            if (f2 == 0.0f) {
                return this;
            }
            double d2 = f2;
            float cos = (float) Math.cos(d2);
            float sin = (float) Math.sin(d2);
            float[] fArr = this.tmp;
            fArr[0] = cos;
            fArr[1] = sin;
            fArr[2] = 0.0f;
            fArr[3] = -sin;
            fArr[4] = cos;
            fArr[5] = 0.0f;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            mul(this.val, fArr);
            return this;
        }
        return (Matrix3) invokeF.objValue;
    }

    public Matrix3 scale(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.tmp;
            fArr[0] = f2;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = f3;
            fArr[5] = 0.0f;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            mul(this.val, fArr);
            return this;
        }
        return (Matrix3) invokeCommon.objValue;
    }

    public Matrix3 scl(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048590, this, f2)) == null) {
            float[] fArr = this.val;
            fArr[0] = fArr[0] * f2;
            fArr[4] = fArr[4] * f2;
            return this;
        }
        return (Matrix3) invokeF.objValue;
    }

    public Matrix3 set(Matrix3 matrix3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, matrix3)) == null) {
            float[] fArr = matrix3.val;
            float[] fArr2 = this.val;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            return this;
        }
        return (Matrix3) invokeL.objValue;
    }

    public Matrix3 setToRotation(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048597, this, f2)) == null) ? setToRotationRad(f2 * 0.017453292f) : (Matrix3) invokeF.objValue;
    }

    public Matrix3 setToRotationRad(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048600, this, f2)) == null) {
            double d2 = f2;
            float cos = (float) Math.cos(d2);
            float sin = (float) Math.sin(d2);
            float[] fArr = this.val;
            fArr[0] = cos;
            fArr[1] = sin;
            fArr[2] = 0.0f;
            fArr[3] = -sin;
            fArr[4] = cos;
            fArr[5] = 0.0f;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            return this;
        }
        return (Matrix3) invokeF.objValue;
    }

    public Matrix3 setToScaling(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.val;
            fArr[0] = f2;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = f3;
            fArr[5] = 0.0f;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            return this;
        }
        return (Matrix3) invokeCommon.objValue;
    }

    public Matrix3 setToTranslation(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048603, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.val;
            fArr[0] = 1.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 1.0f;
            fArr[5] = 0.0f;
            fArr[6] = f2;
            fArr[7] = f3;
            fArr[8] = 1.0f;
            return this;
        }
        return (Matrix3) invokeCommon.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            float[] fArr = this.val;
            return PreferencesUtil.LEFT_MOUNT + fArr[0] + "|" + fArr[3] + "|" + fArr[6] + "]\n[" + fArr[1] + "|" + fArr[4] + "|" + fArr[7] + "]\n[" + fArr[2] + "|" + fArr[5] + "|" + fArr[8] + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public Matrix3 translate(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048606, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.val;
            float[] fArr2 = this.tmp;
            fArr2[0] = 1.0f;
            fArr2[1] = 0.0f;
            fArr2[2] = 0.0f;
            fArr2[3] = 0.0f;
            fArr2[4] = 1.0f;
            fArr2[5] = 0.0f;
            fArr2[6] = f2;
            fArr2[7] = f3;
            fArr2[8] = 1.0f;
            mul(fArr, fArr2);
            return this;
        }
        return (Matrix3) invokeCommon.objValue;
    }

    public Matrix3 transpose() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) {
            float[] fArr = this.val;
            float f2 = fArr[1];
            float f3 = fArr[2];
            float f4 = fArr[3];
            float f5 = fArr[5];
            float f6 = fArr[6];
            float f7 = fArr[7];
            fArr[3] = f2;
            fArr[6] = f3;
            fArr[1] = f4;
            fArr[7] = f5;
            fArr[2] = f6;
            fArr[5] = f7;
            return this;
        }
        return (Matrix3) invokeV.objValue;
    }

    public Matrix3 trn(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, vector2)) == null) {
            float[] fArr = this.val;
            fArr[6] = fArr[6] + vector2.x;
            fArr[7] = fArr[7] + vector2.y;
            return this;
        }
        return (Matrix3) invokeL.objValue;
    }

    public Matrix3 set(Affine2 affine2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, affine2)) == null) {
            float[] fArr = this.val;
            fArr[0] = affine2.m00;
            fArr[1] = affine2.m10;
            fArr[2] = 0.0f;
            fArr[3] = affine2.m01;
            fArr[4] = affine2.m11;
            fArr[5] = 0.0f;
            fArr[6] = affine2.m02;
            fArr[7] = affine2.m12;
            fArr[8] = 1.0f;
            return this;
        }
        return (Matrix3) invokeL.objValue;
    }

    public Matrix3 setToRotation(Vector3 vector3, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(1048598, this, vector3, f2)) == null) ? setToRotation(vector3, d.d(f2), d.p(f2)) : (Matrix3) invokeLF.objValue;
    }

    public Matrix3 scl(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, vector2)) == null) {
            float[] fArr = this.val;
            fArr[0] = fArr[0] * vector2.x;
            fArr[4] = fArr[4] * vector2.y;
            return this;
        }
        return (Matrix3) invokeL.objValue;
    }

    public Matrix3 setToRotation(Vector3 vector3, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{vector3, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.val;
            float f4 = 1.0f - f2;
            float f5 = vector3.x;
            fArr[0] = (f4 * f5 * f5) + f2;
            float f6 = vector3.y;
            float f7 = vector3.z;
            fArr[3] = ((f4 * f5) * f6) - (f7 * f3);
            fArr[6] = (f4 * f7 * f5) + (f6 * f3);
            fArr[1] = (f4 * f5 * f6) + (f7 * f3);
            fArr[4] = (f4 * f6 * f6) + f2;
            fArr[7] = ((f4 * f6) * f7) - (f5 * f3);
            fArr[2] = ((f4 * f7) * f5) - (f6 * f3);
            fArr[5] = (f6 * f4 * f7) + (f5 * f3);
            fArr[8] = (f4 * f7 * f7) + f2;
            return this;
        }
        return (Matrix3) invokeCommon.objValue;
    }

    public Matrix3 trn(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048609, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.val;
            fArr[6] = fArr[6] + f2;
            fArr[7] = fArr[7] + f3;
            return this;
        }
        return (Matrix3) invokeCommon.objValue;
    }

    public Matrix3(Matrix3 matrix3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {matrix3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.val = new float[9];
        this.tmp = new float[9];
        set(matrix3);
    }

    public Matrix3 scl(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, vector3)) == null) {
            float[] fArr = this.val;
            fArr[0] = fArr[0] * vector3.x;
            fArr[4] = fArr[4] * vector3.y;
            return this;
        }
        return (Matrix3) invokeL.objValue;
    }

    public Matrix3 trn(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, vector3)) == null) {
            float[] fArr = this.val;
            fArr[6] = fArr[6] + vector3.x;
            fArr[7] = fArr[7] + vector3.y;
            return this;
        }
        return (Matrix3) invokeL.objValue;
    }

    public Matrix3(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fArr};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.val = new float[9];
        this.tmp = new float[9];
        set(fArr);
    }

    public Matrix3 setToScaling(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, vector2)) == null) {
            float[] fArr = this.val;
            fArr[0] = vector2.x;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = vector2.y;
            fArr[5] = 0.0f;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            return this;
        }
        return (Matrix3) invokeL.objValue;
    }

    public Matrix3 setToTranslation(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048604, this, vector2)) == null) {
            float[] fArr = this.val;
            fArr[0] = 1.0f;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 1.0f;
            fArr[5] = 0.0f;
            fArr[6] = vector2.x;
            fArr[7] = vector2.y;
            fArr[8] = 1.0f;
            return this;
        }
        return (Matrix3) invokeL.objValue;
    }

    public Matrix3 scale(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, vector2)) == null) {
            float[] fArr = this.tmp;
            fArr[0] = vector2.x;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = vector2.y;
            fArr[5] = 0.0f;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
            mul(this.val, fArr);
            return this;
        }
        return (Matrix3) invokeL.objValue;
    }

    public Matrix3 set(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, matrix4)) == null) {
            float[] fArr = this.val;
            float[] fArr2 = matrix4.val;
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[1];
            fArr[2] = fArr2[2];
            fArr[3] = fArr2[4];
            fArr[4] = fArr2[5];
            fArr[5] = fArr2[6];
            fArr[6] = fArr2[8];
            fArr[7] = fArr2[9];
            fArr[8] = fArr2[10];
            return this;
        }
        return (Matrix3) invokeL.objValue;
    }

    public Matrix3 translate(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, vector2)) == null) {
            float[] fArr = this.val;
            float[] fArr2 = this.tmp;
            fArr2[0] = 1.0f;
            fArr2[1] = 0.0f;
            fArr2[2] = 0.0f;
            fArr2[3] = 0.0f;
            fArr2[4] = 1.0f;
            fArr2[5] = 0.0f;
            fArr2[6] = vector2.x;
            fArr2[7] = vector2.y;
            fArr2[8] = 1.0f;
            mul(fArr, fArr2);
            return this;
        }
        return (Matrix3) invokeL.objValue;
    }

    public static void mul(float[] fArr, float[] fArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, fArr, fArr2) == null) {
            float f2 = (fArr[0] * fArr2[0]) + (fArr[3] * fArr2[1]) + (fArr[6] * fArr2[2]);
            float f3 = (fArr[0] * fArr2[3]) + (fArr[3] * fArr2[4]) + (fArr[6] * fArr2[5]);
            float f4 = (fArr[0] * fArr2[6]) + (fArr[3] * fArr2[7]) + (fArr[6] * fArr2[8]);
            float f5 = (fArr[1] * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[7] * fArr2[2]);
            float f6 = (fArr[1] * fArr2[3]) + (fArr[4] * fArr2[4]) + (fArr[7] * fArr2[5]);
            float f7 = (fArr[1] * fArr2[6]) + (fArr[4] * fArr2[7]) + (fArr[7] * fArr2[8]);
            float f8 = (fArr[2] * fArr2[0]) + (fArr[5] * fArr2[1]) + (fArr[8] * fArr2[2]);
            float f9 = (fArr[2] * fArr2[3]) + (fArr[5] * fArr2[4]) + (fArr[8] * fArr2[5]);
            fArr[0] = f2;
            fArr[1] = f5;
            fArr[2] = f8;
            fArr[3] = f3;
            fArr[4] = f6;
            fArr[5] = f9;
            fArr[6] = f4;
            fArr[7] = f7;
            fArr[8] = (fArr[2] * fArr2[6]) + (fArr[5] * fArr2[7]) + (fArr[8] * fArr2[8]);
        }
    }

    public Matrix3 set(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, fArr)) == null) {
            float[] fArr2 = this.val;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            return this;
        }
        return (Matrix3) invokeL.objValue;
    }
}
