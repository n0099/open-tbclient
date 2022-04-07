package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes.dex */
public class Matrix4 implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int M00 = 0;
    public static final int M01 = 4;
    public static final int M02 = 8;
    public static final int M03 = 12;
    public static final int M10 = 1;
    public static final int M11 = 5;
    public static final int M12 = 9;
    public static final int M13 = 13;
    public static final int M20 = 2;
    public static final int M21 = 6;
    public static final int M22 = 10;
    public static final int M23 = 14;
    public static final int M30 = 3;
    public static final int M31 = 7;
    public static final int M32 = 11;
    public static final int M33 = 15;
    public static final Vector3 l_vex;
    public static final Vector3 l_vey;
    public static final Vector3 l_vez;
    public static final Quaternion quat;
    public static final Quaternion quat2;
    public static final Vector3 right;
    public static final long serialVersionUID = -2717655254359579617L;
    public static final Vector3 tmpForward;
    public static final Matrix4 tmpMat;
    public static final Vector3 tmpUp;
    public static final Vector3 tmpVec;
    public transient /* synthetic */ FieldHolder $fh;
    public final float[] val;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1536545793, "Lcom/badlogic/gdx/math/Matrix4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1536545793, "Lcom/badlogic/gdx/math/Matrix4;");
                return;
            }
        }
        quat = new Quaternion();
        quat2 = new Quaternion();
        l_vez = new Vector3();
        l_vex = new Vector3();
        l_vey = new Vector3();
        tmpVec = new Vector3();
        tmpMat = new Matrix4();
        right = new Vector3();
        tmpForward = new Vector3();
        tmpUp = new Vector3();
    }

    public Matrix4() {
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
        float[] fArr = new float[16];
        this.val = fArr;
        fArr[0] = 1.0f;
        fArr[5] = 1.0f;
        fArr[10] = 1.0f;
        fArr[15] = 1.0f;
    }

    public static void mulVec(float[] fArr, float[] fArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65545, null, fArr, fArr2) == null) {
            float f = (fArr2[0] * fArr[0]) + (fArr2[1] * fArr[4]) + (fArr2[2] * fArr[8]) + fArr[12];
            float f2 = (fArr2[0] * fArr[1]) + (fArr2[1] * fArr[5]) + (fArr2[2] * fArr[9]) + fArr[13];
            fArr2[0] = f;
            fArr2[1] = f2;
            fArr2[2] = (fArr2[0] * fArr[2]) + (fArr2[1] * fArr[6]) + (fArr2[2] * fArr[10]) + fArr[14];
        }
    }

    public static native void mulVec(float[] fArr, float[] fArr2, int i, int i2, int i3);

    public static void prj(float[] fArr, float[] fArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, fArr, fArr2) == null) {
            float f = 1.0f / ((((fArr2[0] * fArr[3]) + (fArr2[1] * fArr[7])) + (fArr2[2] * fArr[11])) + fArr[15]);
            fArr2[0] = ((fArr2[0] * fArr[0]) + (fArr2[1] * fArr[4]) + (fArr2[2] * fArr[8]) + fArr[12]) * f;
            fArr2[1] = ((fArr2[0] * fArr[1]) + (fArr2[1] * fArr[5]) + (fArr2[2] * fArr[9]) + fArr[13]) * f;
            fArr2[2] = ((fArr2[0] * fArr[2]) + (fArr2[1] * fArr[6]) + (fArr2[2] * fArr[10]) + fArr[14]) * f;
        }
    }

    public static native void prj(float[] fArr, float[] fArr2, int i, int i2, int i3);

    public static void rot(float[] fArr, float[] fArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, fArr, fArr2) == null) {
            float f = (fArr2[0] * fArr[0]) + (fArr2[1] * fArr[4]) + (fArr2[2] * fArr[8]);
            float f2 = (fArr2[0] * fArr[1]) + (fArr2[1] * fArr[5]) + (fArr2[2] * fArr[9]);
            fArr2[0] = f;
            fArr2[1] = f2;
            fArr2[2] = (fArr2[0] * fArr[2]) + (fArr2[1] * fArr[6]) + (fArr2[2] * fArr[10]);
        }
    }

    public static native void rot(float[] fArr, float[] fArr2, int i, int i2, int i3);

    public Matrix4 avg(Matrix4 matrix4, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048576, this, matrix4, f)) == null) {
            getScale(tmpVec);
            matrix4.getScale(tmpForward);
            getRotation(quat);
            matrix4.getRotation(quat2);
            getTranslation(tmpUp);
            matrix4.getTranslation(right);
            float f2 = 1.0f - f;
            setToScaling(tmpVec.m21scl(f).add(tmpForward.m21scl(f2)));
            rotate(quat.slerp(quat2, f2));
            setTranslation(tmpUp.m21scl(f).add(right.m21scl(f2)));
            return this;
        }
        return (Matrix4) invokeLF.objValue;
    }

    public Matrix4 cpy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? new Matrix4(this) : (Matrix4) invokeV.objValue;
    }

    public float det() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float[] fArr = this.val;
            return (((((((((((((((((((((((((fArr[3] * fArr[6]) * fArr[9]) * fArr[12]) - (((fArr[2] * fArr[7]) * fArr[9]) * fArr[12])) - (((fArr[3] * fArr[5]) * fArr[10]) * fArr[12])) + (((fArr[1] * fArr[7]) * fArr[10]) * fArr[12])) + (((fArr[2] * fArr[5]) * fArr[11]) * fArr[12])) - (((fArr[1] * fArr[6]) * fArr[11]) * fArr[12])) - (((fArr[3] * fArr[6]) * fArr[8]) * fArr[13])) + (((fArr[2] * fArr[7]) * fArr[8]) * fArr[13])) + (((fArr[3] * fArr[4]) * fArr[10]) * fArr[13])) - (((fArr[0] * fArr[7]) * fArr[10]) * fArr[13])) - (((fArr[2] * fArr[4]) * fArr[11]) * fArr[13])) + (((fArr[0] * fArr[6]) * fArr[11]) * fArr[13])) + (((fArr[3] * fArr[5]) * fArr[8]) * fArr[14])) - (((fArr[1] * fArr[7]) * fArr[8]) * fArr[14])) - (((fArr[3] * fArr[4]) * fArr[9]) * fArr[14])) + (((fArr[0] * fArr[7]) * fArr[9]) * fArr[14])) + (((fArr[1] * fArr[4]) * fArr[11]) * fArr[14])) - (((fArr[0] * fArr[5]) * fArr[11]) * fArr[14])) - (((fArr[2] * fArr[5]) * fArr[8]) * fArr[15])) + (((fArr[1] * fArr[6]) * fArr[8]) * fArr[15])) + (((fArr[2] * fArr[4]) * fArr[9]) * fArr[15])) - (((fArr[0] * fArr[6]) * fArr[9]) * fArr[15])) - (((fArr[1] * fArr[4]) * fArr[10]) * fArr[15])) + (fArr[0] * fArr[5] * fArr[10] * fArr[15]);
        }
        return invokeV.floatValue;
    }

    public float det3x3() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            float[] fArr = this.val;
            return ((((((fArr[0] * fArr[5]) * fArr[10]) + ((fArr[4] * fArr[9]) * fArr[2])) + ((fArr[8] * fArr[1]) * fArr[6])) - ((fArr[0] * fArr[9]) * fArr[6])) - ((fArr[4] * fArr[1]) * fArr[10])) - ((fArr[8] * fArr[5]) * fArr[2]);
        }
        return invokeV.floatValue;
    }

    public void extract4x3Matrix(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, fArr) == null) {
            float[] fArr2 = this.val;
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[1];
            fArr[2] = fArr2[2];
            fArr[3] = fArr2[4];
            fArr[4] = fArr2[5];
            fArr[5] = fArr2[6];
            fArr[6] = fArr2[8];
            fArr[7] = fArr2[9];
            fArr[8] = fArr2[10];
            fArr[9] = fArr2[12];
            fArr[10] = fArr2[13];
            fArr[11] = fArr2[14];
        }
    }

    public Quaternion getRotation(Quaternion quaternion, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, quaternion, z)) == null) ? quaternion.setFromMatrix(z, this) : (Quaternion) invokeLZ.objValue;
    }

    public Vector3 getScale(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, vector3)) == null) ? vector3.set(getScaleX(), getScaleY(), getScaleZ()) : (Vector3) invokeL.objValue;
    }

    public float getScaleX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (d.h(this.val[4]) && d.h(this.val[8])) ? Math.abs(this.val[0]) : (float) Math.sqrt(getScaleXSquared()) : invokeV.floatValue;
    }

    public float getScaleXSquared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            float[] fArr = this.val;
            return (fArr[0] * fArr[0]) + (fArr[4] * fArr[4]) + (fArr[8] * fArr[8]);
        }
        return invokeV.floatValue;
    }

    public float getScaleY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? (d.h(this.val[1]) && d.h(this.val[9])) ? Math.abs(this.val[5]) : (float) Math.sqrt(getScaleYSquared()) : invokeV.floatValue;
    }

    public float getScaleYSquared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            float[] fArr = this.val;
            return (fArr[1] * fArr[1]) + (fArr[5] * fArr[5]) + (fArr[9] * fArr[9]);
        }
        return invokeV.floatValue;
    }

    public float getScaleZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? (d.h(this.val[2]) && d.h(this.val[6])) ? Math.abs(this.val[10]) : (float) Math.sqrt(getScaleZSquared()) : invokeV.floatValue;
    }

    public float getScaleZSquared() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            float[] fArr = this.val;
            return (fArr[2] * fArr[2]) + (fArr[6] * fArr[6]) + (fArr[10] * fArr[10]);
        }
        return invokeV.floatValue;
    }

    public Vector3 getTranslation(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, vector3)) == null) {
            float[] fArr = this.val;
            vector3.x = fArr[12];
            vector3.y = fArr[13];
            vector3.z = fArr[14];
            return vector3;
        }
        return (Vector3) invokeL.objValue;
    }

    public float[] getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.val : (float[]) invokeV.objValue;
    }

    public boolean hasRotationOrScaling() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (d.e(this.val[0], 1.0f) && d.e(this.val[5], 1.0f) && d.e(this.val[10], 1.0f) && d.h(this.val[4]) && d.h(this.val[8]) && d.h(this.val[1]) && d.h(this.val[9]) && d.h(this.val[2]) && d.h(this.val[6])) ? false : true : invokeV.booleanValue;
    }

    public Matrix4 idt() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            float[] fArr = this.val;
            fArr[0] = 1.0f;
            fArr[4] = 0.0f;
            fArr[8] = 0.0f;
            fArr[12] = 0.0f;
            fArr[1] = 0.0f;
            fArr[5] = 1.0f;
            fArr[9] = 0.0f;
            fArr[13] = 0.0f;
            fArr[2] = 0.0f;
            fArr[6] = 0.0f;
            fArr[10] = 1.0f;
            fArr[14] = 0.0f;
            fArr[3] = 0.0f;
            fArr[7] = 0.0f;
            fArr[11] = 0.0f;
            fArr[15] = 1.0f;
            return this;
        }
        return (Matrix4) invokeV.objValue;
    }

    public Matrix4 inv() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            float[] fArr = this.val;
            float f = (((((((((((((((((((((((((fArr[3] * fArr[6]) * fArr[9]) * fArr[12]) - (((fArr[2] * fArr[7]) * fArr[9]) * fArr[12])) - (((fArr[3] * fArr[5]) * fArr[10]) * fArr[12])) + (((fArr[1] * fArr[7]) * fArr[10]) * fArr[12])) + (((fArr[2] * fArr[5]) * fArr[11]) * fArr[12])) - (((fArr[1] * fArr[6]) * fArr[11]) * fArr[12])) - (((fArr[3] * fArr[6]) * fArr[8]) * fArr[13])) + (((fArr[2] * fArr[7]) * fArr[8]) * fArr[13])) + (((fArr[3] * fArr[4]) * fArr[10]) * fArr[13])) - (((fArr[0] * fArr[7]) * fArr[10]) * fArr[13])) - (((fArr[2] * fArr[4]) * fArr[11]) * fArr[13])) + (((fArr[0] * fArr[6]) * fArr[11]) * fArr[13])) + (((fArr[3] * fArr[5]) * fArr[8]) * fArr[14])) - (((fArr[1] * fArr[7]) * fArr[8]) * fArr[14])) - (((fArr[3] * fArr[4]) * fArr[9]) * fArr[14])) + (((fArr[0] * fArr[7]) * fArr[9]) * fArr[14])) + (((fArr[1] * fArr[4]) * fArr[11]) * fArr[14])) - (((fArr[0] * fArr[5]) * fArr[11]) * fArr[14])) - (((fArr[2] * fArr[5]) * fArr[8]) * fArr[15])) + (((fArr[1] * fArr[6]) * fArr[8]) * fArr[15])) + (((fArr[2] * fArr[4]) * fArr[9]) * fArr[15])) - (((fArr[0] * fArr[6]) * fArr[9]) * fArr[15])) - (((fArr[1] * fArr[4]) * fArr[10]) * fArr[15])) + (fArr[0] * fArr[5] * fArr[10] * fArr[15]);
            if (f != 0.0f) {
                float f2 = ((((((fArr[9] * fArr[14]) * fArr[7]) - ((fArr[13] * fArr[10]) * fArr[7])) + ((fArr[13] * fArr[6]) * fArr[11])) - ((fArr[5] * fArr[14]) * fArr[11])) - ((fArr[9] * fArr[6]) * fArr[15])) + (fArr[5] * fArr[10] * fArr[15]);
                float f3 = ((((((fArr[12] * fArr[10]) * fArr[7]) - ((fArr[8] * fArr[14]) * fArr[7])) - ((fArr[12] * fArr[6]) * fArr[11])) + ((fArr[4] * fArr[14]) * fArr[11])) + ((fArr[8] * fArr[6]) * fArr[15])) - ((fArr[4] * fArr[10]) * fArr[15]);
                float f4 = ((((((fArr[8] * fArr[13]) * fArr[7]) - ((fArr[12] * fArr[9]) * fArr[7])) + ((fArr[12] * fArr[5]) * fArr[11])) - ((fArr[4] * fArr[13]) * fArr[11])) - ((fArr[8] * fArr[5]) * fArr[15])) + (fArr[4] * fArr[9] * fArr[15]);
                float f5 = ((((((fArr[12] * fArr[9]) * fArr[6]) - ((fArr[8] * fArr[13]) * fArr[6])) - ((fArr[12] * fArr[5]) * fArr[10])) + ((fArr[4] * fArr[13]) * fArr[10])) + ((fArr[8] * fArr[5]) * fArr[14])) - ((fArr[4] * fArr[9]) * fArr[14]);
                float f6 = ((((((fArr[13] * fArr[10]) * fArr[3]) - ((fArr[9] * fArr[14]) * fArr[3])) - ((fArr[13] * fArr[2]) * fArr[11])) + ((fArr[1] * fArr[14]) * fArr[11])) + ((fArr[9] * fArr[2]) * fArr[15])) - ((fArr[1] * fArr[10]) * fArr[15]);
                float f7 = ((((((fArr[8] * fArr[14]) * fArr[3]) - ((fArr[12] * fArr[10]) * fArr[3])) + ((fArr[12] * fArr[2]) * fArr[11])) - ((fArr[0] * fArr[14]) * fArr[11])) - ((fArr[8] * fArr[2]) * fArr[15])) + (fArr[0] * fArr[10] * fArr[15]);
                float f8 = ((((((fArr[12] * fArr[9]) * fArr[3]) - ((fArr[8] * fArr[13]) * fArr[3])) - ((fArr[12] * fArr[1]) * fArr[11])) + ((fArr[0] * fArr[13]) * fArr[11])) + ((fArr[8] * fArr[1]) * fArr[15])) - ((fArr[0] * fArr[9]) * fArr[15]);
                float f9 = ((((((fArr[8] * fArr[13]) * fArr[2]) - ((fArr[12] * fArr[9]) * fArr[2])) + ((fArr[12] * fArr[1]) * fArr[10])) - ((fArr[0] * fArr[13]) * fArr[10])) - ((fArr[8] * fArr[1]) * fArr[14])) + (fArr[0] * fArr[9] * fArr[14]);
                float f10 = ((((((fArr[5] * fArr[14]) * fArr[3]) - ((fArr[13] * fArr[6]) * fArr[3])) + ((fArr[13] * fArr[2]) * fArr[7])) - ((fArr[1] * fArr[14]) * fArr[7])) - ((fArr[5] * fArr[2]) * fArr[15])) + (fArr[1] * fArr[6] * fArr[15]);
                float f11 = ((((((fArr[12] * fArr[6]) * fArr[3]) - ((fArr[4] * fArr[14]) * fArr[3])) - ((fArr[12] * fArr[2]) * fArr[7])) + ((fArr[0] * fArr[14]) * fArr[7])) + ((fArr[4] * fArr[2]) * fArr[15])) - ((fArr[0] * fArr[6]) * fArr[15]);
                float f12 = ((((((fArr[4] * fArr[13]) * fArr[3]) - ((fArr[12] * fArr[5]) * fArr[3])) + ((fArr[12] * fArr[1]) * fArr[7])) - ((fArr[0] * fArr[13]) * fArr[7])) - ((fArr[4] * fArr[1]) * fArr[15])) + (fArr[0] * fArr[5] * fArr[15]);
                float f13 = ((((((fArr[12] * fArr[5]) * fArr[2]) - ((fArr[4] * fArr[13]) * fArr[2])) - ((fArr[12] * fArr[1]) * fArr[6])) + ((fArr[0] * fArr[13]) * fArr[6])) + ((fArr[4] * fArr[1]) * fArr[14])) - ((fArr[0] * fArr[5]) * fArr[14]);
                float f14 = ((((((fArr[9] * fArr[6]) * fArr[3]) - ((fArr[5] * fArr[10]) * fArr[3])) - ((fArr[9] * fArr[2]) * fArr[7])) + ((fArr[1] * fArr[10]) * fArr[7])) + ((fArr[5] * fArr[2]) * fArr[11])) - ((fArr[1] * fArr[6]) * fArr[11]);
                float f15 = ((((((fArr[4] * fArr[10]) * fArr[3]) - ((fArr[8] * fArr[6]) * fArr[3])) + ((fArr[8] * fArr[2]) * fArr[7])) - ((fArr[0] * fArr[10]) * fArr[7])) - ((fArr[4] * fArr[2]) * fArr[11])) + (fArr[0] * fArr[6] * fArr[11]);
                float f16 = ((((((fArr[8] * fArr[5]) * fArr[3]) - ((fArr[4] * fArr[9]) * fArr[3])) - ((fArr[8] * fArr[1]) * fArr[7])) + ((fArr[0] * fArr[9]) * fArr[7])) + ((fArr[4] * fArr[1]) * fArr[11])) - ((fArr[0] * fArr[5]) * fArr[11]);
                float f17 = ((((((fArr[4] * fArr[9]) * fArr[2]) - ((fArr[8] * fArr[5]) * fArr[2])) + ((fArr[8] * fArr[1]) * fArr[6])) - ((fArr[0] * fArr[9]) * fArr[6])) - ((fArr[4] * fArr[1]) * fArr[10])) + (fArr[0] * fArr[5] * fArr[10]);
                float f18 = 1.0f / f;
                fArr[0] = f2 * f18;
                fArr[1] = f6 * f18;
                fArr[2] = f10 * f18;
                fArr[3] = f14 * f18;
                fArr[4] = f3 * f18;
                fArr[5] = f7 * f18;
                fArr[6] = f11 * f18;
                fArr[7] = f15 * f18;
                fArr[8] = f4 * f18;
                fArr[9] = f8 * f18;
                fArr[10] = f12 * f18;
                fArr[11] = f16 * f18;
                fArr[12] = f5 * f18;
                fArr[13] = f9 * f18;
                fArr[14] = f13 * f18;
                fArr[15] = f17 * f18;
                return this;
            }
            throw new RuntimeException("non-invertible matrix");
        }
        return (Matrix4) invokeV.objValue;
    }

    public Matrix4 lerp(Matrix4 matrix4, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048597, this, matrix4, f)) == null) {
            for (int i = 0; i < 16; i++) {
                float[] fArr = this.val;
                fArr[i] = (fArr[i] * (1.0f - f)) + (matrix4.val[i] * f);
            }
            return this;
        }
        return (Matrix4) invokeLF.objValue;
    }

    public Matrix4 mul(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, matrix4)) == null) {
            mul(this.val, matrix4.val);
            return this;
        }
        return (Matrix4) invokeL.objValue;
    }

    public Matrix4 mulLeft(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, matrix4)) == null) {
            tmpMat.set(matrix4);
            mul(tmpMat.val, this.val);
            return set(tmpMat);
        }
        return (Matrix4) invokeL.objValue;
    }

    public Matrix4 rotate(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048602, this, vector3, f)) == null) {
            if (f == 0.0f) {
                return this;
            }
            quat.set(vector3, f);
            return rotate(quat);
        }
        return (Matrix4) invokeLF.objValue;
    }

    public Matrix4 rotateRad(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048605, this, vector3, f)) == null) {
            if (f == 0.0f) {
                return this;
            }
            quat.setFromAxisRad(vector3, f);
            return rotate(quat);
        }
        return (Matrix4) invokeLF.objValue;
    }

    public Matrix4 rotateTowardDirection(Vector3 vector3, Vector3 vector32) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, vector3, vector32)) == null) {
            l_vez.set(vector3).m20nor();
            l_vex.set(vector3).crs(vector32).m20nor();
            l_vey.set(l_vex).crs(l_vez).m20nor();
            float[] fArr = this.val;
            float f = fArr[0];
            Vector3 vector33 = l_vex;
            float f2 = vector33.x;
            float f3 = fArr[4];
            float f4 = vector33.y;
            float f5 = fArr[8];
            float f6 = vector33.z;
            float f7 = (f * f2) + (f3 * f4) + (f5 * f6);
            float f8 = fArr[0];
            Vector3 vector34 = l_vey;
            float f9 = vector34.x;
            float f10 = fArr[4];
            float f11 = vector34.y;
            float f12 = (f8 * f9) + (f10 * f11);
            float f13 = fArr[8];
            float f14 = vector34.z;
            float f15 = f12 + (f13 * f14);
            float f16 = fArr[0];
            Vector3 vector35 = l_vez;
            float f17 = vector35.x;
            float f18 = fArr[4];
            float f19 = vector35.y;
            float f20 = (f16 * (-f17)) + (f18 * (-f19));
            float f21 = fArr[8];
            float f22 = vector35.z;
            float f23 = f20 + (f21 * (-f22));
            float f24 = (fArr[1] * f2) + (fArr[5] * f4) + (fArr[9] * f6);
            float f25 = (fArr[1] * f9) + (fArr[5] * f11) + (fArr[9] * f14);
            float f26 = (fArr[1] * (-f17)) + (fArr[5] * (-f19)) + (fArr[9] * (-f22));
            float f27 = (fArr[2] * f2) + (fArr[6] * f4) + (fArr[10] * f6);
            float f28 = (fArr[2] * f9) + (fArr[6] * f11) + (fArr[10] * f14);
            float f29 = (fArr[3] * f9) + (fArr[7] * f11) + (fArr[11] * f14);
            fArr[0] = f7;
            fArr[1] = f24;
            fArr[2] = f27;
            fArr[3] = (fArr[3] * f2) + (fArr[7] * f4) + (fArr[11] * f6);
            fArr[4] = f15;
            fArr[5] = f25;
            fArr[6] = f28;
            fArr[7] = f29;
            fArr[8] = f23;
            fArr[9] = f26;
            fArr[10] = (fArr[2] * (-f17)) + (fArr[6] * (-f19)) + (fArr[10] * (-f22));
            fArr[11] = (fArr[3] * (-f17)) + (fArr[7] * (-f19)) + (fArr[11] * (-f22));
            return this;
        }
        return (Matrix4) invokeLL.objValue;
    }

    public Matrix4 rotateTowardTarget(Vector3 vector3, Vector3 vector32) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048607, this, vector3, vector32)) == null) {
            Vector3 vector33 = tmpVec;
            float f = vector3.x;
            float[] fArr = this.val;
            vector33.set(f - fArr[12], vector3.y - fArr[13], vector3.z - fArr[14]);
            return rotateTowardDirection(tmpVec, vector32);
        }
        return (Matrix4) invokeLL.objValue;
    }

    public Matrix4 scale(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.val;
            fArr[0] = fArr[0] * f;
            fArr[4] = fArr[4] * f2;
            fArr[8] = fArr[8] * f3;
            fArr[1] = fArr[1] * f;
            fArr[5] = fArr[5] * f2;
            fArr[9] = fArr[9] * f3;
            fArr[2] = fArr[2] * f;
            fArr[6] = fArr[6] * f2;
            fArr[10] = fArr[10] * f3;
            fArr[3] = fArr[3] * f;
            fArr[7] = fArr[7] * f2;
            fArr[11] = fArr[11] * f3;
            return this;
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 scl(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, vector3)) == null) {
            float[] fArr = this.val;
            fArr[0] = fArr[0] * vector3.x;
            fArr[5] = fArr[5] * vector3.y;
            fArr[10] = fArr[10] * vector3.z;
            return this;
        }
        return (Matrix4) invokeL.objValue;
    }

    public Matrix4 set(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048617, this, matrix4)) == null) ? set(matrix4.val) : (Matrix4) invokeL.objValue;
    }

    public Matrix4 setAsAffine(Affine2 affine2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, affine2)) == null) {
            float[] fArr = this.val;
            fArr[0] = affine2.m00;
            fArr[1] = affine2.m10;
            fArr[4] = affine2.m01;
            fArr[5] = affine2.m11;
            fArr[12] = affine2.m02;
            fArr[13] = affine2.m12;
            return this;
        }
        return (Matrix4) invokeL.objValue;
    }

    public Matrix4 setFromEulerAngles(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048625, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            quat.setEulerAngles(f, f2, f3);
            return set(quat);
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 setFromEulerAnglesRad(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048626, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            quat.setEulerAnglesRad(f, f2, f3);
            return set(quat);
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 setToLookAt(Vector3 vector3, Vector3 vector32) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048627, this, vector3, vector32)) == null) {
            l_vez.set(vector3).m20nor();
            l_vex.set(vector3).crs(vector32).m20nor();
            l_vey.set(l_vex).crs(l_vez).m20nor();
            idt();
            float[] fArr = this.val;
            Vector3 vector33 = l_vex;
            fArr[0] = vector33.x;
            fArr[4] = vector33.y;
            fArr[8] = vector33.z;
            Vector3 vector34 = l_vey;
            fArr[1] = vector34.x;
            fArr[5] = vector34.y;
            fArr[9] = vector34.z;
            Vector3 vector35 = l_vez;
            fArr[2] = -vector35.x;
            fArr[6] = -vector35.y;
            fArr[10] = -vector35.z;
            return this;
        }
        return (Matrix4) invokeLL.objValue;
    }

    public Matrix4 setToOrtho(float f, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048629, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            float f7 = f2 - f;
            float f8 = f4 - f3;
            float f9 = f6 - f5;
            float[] fArr = this.val;
            fArr[0] = 2.0f / f7;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = 2.0f / f8;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = (-2.0f) / f9;
            fArr[11] = 0.0f;
            fArr[12] = (-(f2 + f)) / f7;
            fArr[13] = (-(f4 + f3)) / f8;
            fArr[14] = (-(f6 + f5)) / f9;
            fArr[15] = 1.0f;
            return this;
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 setToOrtho2D(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048630, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            setToOrtho(f, f + f3, f2, f2 + f4, 0.0f, 1.0f);
            return this;
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 setToProjection(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048632, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            idt();
            float tan = (float) (1.0d / Math.tan((f3 * 0.017453292519943295d) / 2.0d));
            float f5 = f - f2;
            float[] fArr = this.val;
            fArr[0] = tan / f4;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = tan;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = (f2 + f) / f5;
            fArr[11] = -1.0f;
            fArr[12] = 0.0f;
            fArr[13] = 0.0f;
            fArr[14] = ((f2 * 2.0f) * f) / f5;
            fArr[15] = 0.0f;
            return this;
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 setToRotation(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048636, this, vector3, f)) == null) {
            if (f == 0.0f) {
                idt();
                return this;
            }
            return set(quat.set(vector3, f));
        }
        return (Matrix4) invokeLF.objValue;
    }

    public Matrix4 setToRotationRad(Vector3 vector3, float f) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048639, this, vector3, f)) == null) {
            if (f == 0.0f) {
                idt();
                return this;
            }
            return set(quat.setFromAxisRad(vector3, f));
        }
        return (Matrix4) invokeLF.objValue;
    }

    public Matrix4 setToScaling(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048641, this, vector3)) == null) {
            idt();
            float[] fArr = this.val;
            fArr[0] = vector3.x;
            fArr[5] = vector3.y;
            fArr[10] = vector3.z;
            return this;
        }
        return (Matrix4) invokeL.objValue;
    }

    public Matrix4 setToTranslation(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048643, this, vector3)) == null) {
            idt();
            float[] fArr = this.val;
            fArr[12] = vector3.x;
            fArr[13] = vector3.y;
            fArr[14] = vector3.z;
            return this;
        }
        return (Matrix4) invokeL.objValue;
    }

    public Matrix4 setToTranslationAndScaling(Vector3 vector3, Vector3 vector32) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048645, this, vector3, vector32)) == null) {
            idt();
            float[] fArr = this.val;
            fArr[12] = vector3.x;
            fArr[13] = vector3.y;
            fArr[14] = vector3.z;
            fArr[0] = vector32.x;
            fArr[5] = vector32.y;
            fArr[10] = vector32.z;
            return this;
        }
        return (Matrix4) invokeLL.objValue;
    }

    public Matrix4 setToWorld(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048646, this, vector3, vector32, vector33)) == null) {
            tmpForward.set(vector32).m20nor();
            right.set(tmpForward).crs(vector33).m20nor();
            tmpUp.set(right).crs(tmpForward).m20nor();
            set(right, tmpUp, tmpForward.m21scl(-1.0f), vector3);
            return this;
        }
        return (Matrix4) invokeLLL.objValue;
    }

    public Matrix4 setTranslation(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048648, this, vector3)) == null) {
            float[] fArr = this.val;
            fArr[12] = vector3.x;
            fArr[13] = vector3.y;
            fArr[14] = vector3.z;
            return this;
        }
        return (Matrix4) invokeL.objValue;
    }

    public Matrix4 toNormalMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048649, this)) == null) {
            float[] fArr = this.val;
            fArr[12] = 0.0f;
            fArr[13] = 0.0f;
            fArr[14] = 0.0f;
            return inv().tra();
        }
        return (Matrix4) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048650, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + this.val[0] + "|" + this.val[4] + "|" + this.val[8] + "|" + this.val[12] + "]\n[" + this.val[1] + "|" + this.val[5] + "|" + this.val[9] + "|" + this.val[13] + "]\n[" + this.val[2] + "|" + this.val[6] + "|" + this.val[10] + "|" + this.val[14] + "]\n[" + this.val[3] + "|" + this.val[7] + "|" + this.val[11] + "|" + this.val[15] + "]\n";
        }
        return (String) invokeV.objValue;
    }

    public Matrix4 tra() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            float[] fArr = this.val;
            float f = fArr[4];
            float f2 = fArr[8];
            float f3 = fArr[12];
            float f4 = fArr[9];
            float f5 = fArr[13];
            float f6 = fArr[14];
            fArr[4] = fArr[1];
            fArr[8] = fArr[2];
            fArr[12] = fArr[3];
            fArr[1] = f;
            fArr[9] = fArr[6];
            fArr[13] = fArr[7];
            fArr[2] = f2;
            fArr[6] = f4;
            fArr[14] = fArr[11];
            fArr[3] = f3;
            fArr[7] = f5;
            fArr[11] = f6;
            return this;
        }
        return (Matrix4) invokeV.objValue;
    }

    public Matrix4 translate(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, vector3)) == null) ? translate(vector3.x, vector3.y, vector3.z) : (Matrix4) invokeL.objValue;
    }

    public Matrix4 trn(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048655, this, vector3)) == null) {
            float[] fArr = this.val;
            fArr[12] = fArr[12] + vector3.x;
            fArr[13] = fArr[13] + vector3.y;
            fArr[14] = fArr[14] + vector3.z;
            return this;
        }
        return (Matrix4) invokeL.objValue;
    }

    public static float det(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65542, null, fArr)) == null) ? (((((((((((((((((((((((((fArr[3] * fArr[6]) * fArr[9]) * fArr[12]) - (((fArr[2] * fArr[7]) * fArr[9]) * fArr[12])) - (((fArr[3] * fArr[5]) * fArr[10]) * fArr[12])) + (((fArr[1] * fArr[7]) * fArr[10]) * fArr[12])) + (((fArr[2] * fArr[5]) * fArr[11]) * fArr[12])) - (((fArr[1] * fArr[6]) * fArr[11]) * fArr[12])) - (((fArr[3] * fArr[6]) * fArr[8]) * fArr[13])) + (((fArr[2] * fArr[7]) * fArr[8]) * fArr[13])) + (((fArr[3] * fArr[4]) * fArr[10]) * fArr[13])) - (((fArr[0] * fArr[7]) * fArr[10]) * fArr[13])) - (((fArr[2] * fArr[4]) * fArr[11]) * fArr[13])) + (((fArr[0] * fArr[6]) * fArr[11]) * fArr[13])) + (((fArr[3] * fArr[5]) * fArr[8]) * fArr[14])) - (((fArr[1] * fArr[7]) * fArr[8]) * fArr[14])) - (((fArr[3] * fArr[4]) * fArr[9]) * fArr[14])) + (((fArr[0] * fArr[7]) * fArr[9]) * fArr[14])) + (((fArr[1] * fArr[4]) * fArr[11]) * fArr[14])) - (((fArr[0] * fArr[5]) * fArr[11]) * fArr[14])) - (((fArr[2] * fArr[5]) * fArr[8]) * fArr[15])) + (((fArr[1] * fArr[6]) * fArr[8]) * fArr[15])) + (((fArr[2] * fArr[4]) * fArr[9]) * fArr[15])) - (((fArr[0] * fArr[6]) * fArr[9]) * fArr[15])) - (((fArr[1] * fArr[4]) * fArr[10]) * fArr[15])) + (fArr[0] * fArr[5] * fArr[10] * fArr[15]) : invokeL.floatValue;
    }

    public static void mul(float[] fArr, float[] fArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, fArr, fArr2) == null) {
            float f = (fArr[0] * fArr2[0]) + (fArr[4] * fArr2[1]) + (fArr[8] * fArr2[2]) + (fArr[12] * fArr2[3]);
            float f2 = (fArr[0] * fArr2[4]) + (fArr[4] * fArr2[5]) + (fArr[8] * fArr2[6]) + (fArr[12] * fArr2[7]);
            float f3 = (fArr[0] * fArr2[8]) + (fArr[4] * fArr2[9]) + (fArr[8] * fArr2[10]) + (fArr[12] * fArr2[11]);
            float f4 = (fArr[0] * fArr2[12]) + (fArr[4] * fArr2[13]) + (fArr[8] * fArr2[14]) + (fArr[12] * fArr2[15]);
            float f5 = (fArr[1] * fArr2[0]) + (fArr[5] * fArr2[1]) + (fArr[9] * fArr2[2]) + (fArr[13] * fArr2[3]);
            float f6 = (fArr[1] * fArr2[4]) + (fArr[5] * fArr2[5]) + (fArr[9] * fArr2[6]) + (fArr[13] * fArr2[7]);
            float f7 = (fArr[1] * fArr2[8]) + (fArr[5] * fArr2[9]) + (fArr[9] * fArr2[10]) + (fArr[13] * fArr2[11]);
            float f8 = (fArr[1] * fArr2[12]) + (fArr[5] * fArr2[13]) + (fArr[9] * fArr2[14]) + (fArr[13] * fArr2[15]);
            float f9 = (fArr[2] * fArr2[0]) + (fArr[6] * fArr2[1]) + (fArr[10] * fArr2[2]) + (fArr[14] * fArr2[3]);
            float f10 = (fArr[2] * fArr2[4]) + (fArr[6] * fArr2[5]) + (fArr[10] * fArr2[6]) + (fArr[14] * fArr2[7]);
            float f11 = (fArr[2] * fArr2[8]) + (fArr[6] * fArr2[9]) + (fArr[10] * fArr2[10]) + (fArr[14] * fArr2[11]);
            float f12 = (fArr[2] * fArr2[12]) + (fArr[6] * fArr2[13]) + (fArr[10] * fArr2[14]) + (fArr[14] * fArr2[15]);
            float f13 = (fArr[3] * fArr2[0]) + (fArr[7] * fArr2[1]) + (fArr[11] * fArr2[2]) + (fArr[15] * fArr2[3]);
            float f14 = (fArr[3] * fArr2[4]) + (fArr[7] * fArr2[5]) + (fArr[11] * fArr2[6]) + (fArr[15] * fArr2[7]);
            float f15 = (fArr[3] * fArr2[8]) + (fArr[7] * fArr2[9]) + (fArr[11] * fArr2[10]) + (fArr[15] * fArr2[11]);
            fArr[0] = f;
            fArr[1] = f5;
            fArr[2] = f9;
            fArr[3] = f13;
            fArr[4] = f2;
            fArr[5] = f6;
            fArr[6] = f10;
            fArr[7] = f14;
            fArr[8] = f3;
            fArr[9] = f7;
            fArr[10] = f11;
            fArr[11] = f15;
            fArr[12] = f4;
            fArr[13] = f8;
            fArr[14] = f12;
            fArr[15] = (fArr[3] * fArr2[12]) + (fArr[7] * fArr2[13]) + (fArr[11] * fArr2[14]) + (fArr[15] * fArr2[15]);
        }
    }

    public Quaternion getRotation(Quaternion quaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, quaternion)) == null) ? quaternion.setFromMatrix(this) : (Quaternion) invokeL.objValue;
    }

    public Matrix4 set(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048622, this, fArr)) == null) {
            float[] fArr2 = this.val;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            return this;
        }
        return (Matrix4) invokeL.objValue;
    }

    public Matrix4 setToOrtho2D(float f, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048631, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            setToOrtho(f, f + f3, f2, f2 + f4, f5, f6);
            return this;
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 translate(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048652, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.val;
            fArr[12] = fArr[12] + (fArr[0] * f) + (fArr[4] * f2) + (fArr[8] * f3);
            fArr[13] = fArr[13] + (fArr[1] * f) + (fArr[5] * f2) + (fArr[9] * f3);
            fArr[14] = fArr[14] + (fArr[2] * f) + (fArr[6] * f2) + (fArr[10] * f3);
            fArr[15] = fArr[15] + (fArr[3] * f) + (fArr[7] * f2) + (fArr[11] * f3);
            return this;
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4(Matrix4 matrix4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {matrix4};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.val = new float[16];
        set(matrix4);
    }

    public Matrix4 rotate(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f4 == 0.0f) {
                return this;
            }
            quat.setFromAxis(f, f2, f3, f4);
            return rotate(quat);
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 rotateRad(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048604, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f4 == 0.0f) {
                return this;
            }
            quat.setFromAxisRad(f, f2, f3, f4);
            return rotate(quat);
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 set(Quaternion quaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048618, this, quaternion)) == null) ? set(quaternion.x, quaternion.y, quaternion.z, quaternion.w) : (Matrix4) invokeL.objValue;
    }

    public Matrix4 setToRotation(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048634, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f4 == 0.0f) {
                idt();
                return this;
            }
            return set(quat.setFromAxis(f, f2, f3, f4));
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 setToRotationRad(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048638, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            if (f4 == 0.0f) {
                idt();
                return this;
            }
            return set(quat.setFromAxisRad(f, f2, f3, f4));
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 scl(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048610, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.val;
            fArr[0] = fArr[0] * f;
            fArr[5] = fArr[5] * f2;
            fArr[10] = fArr[10] * f3;
            return this;
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 set(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048612, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) ? set(0.0f, 0.0f, 0.0f, f, f2, f3, f4) : (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 setTranslation(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048647, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.val;
            fArr[12] = f;
            fArr[13] = f2;
            fArr[14] = f3;
            return this;
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 trn(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048654, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float[] fArr = this.val;
            fArr[12] = fArr[12] + f;
            fArr[13] = fArr[13] + f2;
            fArr[14] = fArr[14] + f3;
            return this;
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 rotate(Quaternion quaternion) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, quaternion)) == null) {
            float f = quaternion.x;
            float f2 = quaternion.y;
            float f3 = quaternion.z;
            float f4 = quaternion.w;
            float f5 = f * f;
            float f6 = f * f2;
            float f7 = f * f3;
            float f8 = f * f4;
            float f9 = f2 * f2;
            float f10 = f2 * f3;
            float f11 = f2 * f4;
            float f12 = f3 * f3;
            float f13 = f3 * f4;
            float f14 = 1.0f - ((f9 + f12) * 2.0f);
            float f15 = (f6 - f13) * 2.0f;
            float f16 = (f7 + f11) * 2.0f;
            float f17 = (f6 + f13) * 2.0f;
            float f18 = 1.0f - ((f12 + f5) * 2.0f);
            float f19 = (f10 - f8) * 2.0f;
            float f20 = (f7 - f11) * 2.0f;
            float f21 = (f10 + f8) * 2.0f;
            float f22 = 1.0f - ((f5 + f9) * 2.0f);
            float[] fArr = this.val;
            float f23 = (fArr[0] * f14) + (fArr[4] * f17) + (fArr[8] * f20);
            float f24 = (fArr[0] * f15) + (fArr[4] * f18) + (fArr[8] * f21);
            float f25 = (fArr[1] * f14) + (fArr[5] * f17) + (fArr[9] * f20);
            float f26 = (fArr[1] * f15) + (fArr[5] * f18) + (fArr[9] * f21);
            float f27 = (fArr[2] * f14) + (fArr[6] * f17) + (fArr[10] * f20);
            float f28 = (fArr[2] * f15) + (fArr[6] * f18) + (fArr[10] * f21);
            float f29 = (fArr[3] * f15) + (fArr[7] * f18) + (fArr[11] * f21);
            fArr[0] = f23;
            fArr[1] = f25;
            fArr[2] = f27;
            fArr[3] = (fArr[3] * f14) + (fArr[7] * f17) + (fArr[11] * f20);
            fArr[4] = f24;
            fArr[5] = f26;
            fArr[6] = f28;
            fArr[7] = f29;
            fArr[8] = (fArr[0] * f16) + (fArr[4] * f19) + (fArr[8] * f22);
            fArr[9] = (fArr[1] * f16) + (fArr[5] * f19) + (fArr[9] * f22);
            fArr[10] = (fArr[2] * f16) + (fArr[6] * f19) + (fArr[10] * f22);
            fArr[11] = (fArr[3] * f16) + (fArr[7] * f19) + (fArr[11] * f22);
            return this;
        }
        return (Matrix4) invokeL.objValue;
    }

    public Matrix4 set(Vector3 vector3, Quaternion quaternion) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048619, this, vector3, quaternion)) == null) ? set(vector3.x, vector3.y, vector3.z, quaternion.x, quaternion.y, quaternion.z, quaternion.w) : (Matrix4) invokeLL.objValue;
    }

    public Matrix4 setToRotation(Vector3 vector3, Vector3 vector32) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048637, this, vector3, vector32)) == null) ? set(quat.setFromCross(vector3, vector32)) : (Matrix4) invokeLL.objValue;
    }

    public Matrix4 setToScaling(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048640, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            idt();
            float[] fArr = this.val;
            fArr[0] = f;
            fArr[5] = f2;
            fArr[10] = f3;
            return this;
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 setToTranslation(float f, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048642, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            idt();
            float[] fArr = this.val;
            fArr[12] = f;
            fArr[13] = f2;
            fArr[14] = f3;
            return this;
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fArr};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.val = new float[16];
        set(fArr);
    }

    public Matrix4 set(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048613, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)})) == null) {
            float f8 = f4 * 2.0f;
            float f9 = f5 * 2.0f;
            float f10 = 2.0f * f6;
            float f11 = f7 * f8;
            float f12 = f7 * f9;
            float f13 = f7 * f10;
            float f14 = f8 * f4;
            float f15 = f4 * f9;
            float f16 = f4 * f10;
            float f17 = f9 * f5;
            float f18 = f5 * f10;
            float f19 = f10 * f6;
            float[] fArr = this.val;
            fArr[0] = 1.0f - (f17 + f19);
            fArr[4] = f15 - f13;
            fArr[8] = f16 + f12;
            fArr[12] = f;
            fArr[1] = f15 + f13;
            fArr[5] = 1.0f - (f19 + f14);
            fArr[9] = f18 - f11;
            fArr[13] = f2;
            fArr[2] = f16 - f12;
            fArr[6] = f18 + f11;
            fArr[10] = 1.0f - (f14 + f17);
            fArr[14] = f3;
            fArr[3] = 0.0f;
            fArr[7] = 0.0f;
            fArr[11] = 0.0f;
            fArr[15] = 1.0f;
            return this;
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 setToRotation(float f, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048635, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) ? set(quat.setFromCross(f, f2, f3, f4, f5, f6)) : (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 scl(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048609, this, f)) == null) {
            float[] fArr = this.val;
            fArr[0] = fArr[0] * f;
            fArr[5] = fArr[5] * f;
            fArr[10] = fArr[10] * f;
            return this;
        }
        return (Matrix4) invokeF.objValue;
    }

    public Matrix4 setAsAffine(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, matrix4)) == null) {
            float[] fArr = this.val;
            float[] fArr2 = matrix4.val;
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[1];
            fArr[4] = fArr2[4];
            fArr[5] = fArr2[5];
            fArr[12] = fArr2[12];
            fArr[13] = fArr2[13];
            return this;
        }
        return (Matrix4) invokeL.objValue;
    }

    public Matrix4 setToTranslationAndScaling(float f, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048644, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            idt();
            float[] fArr = this.val;
            fArr[12] = f;
            fArr[13] = f2;
            fArr[14] = f3;
            fArr[0] = f4;
            fArr[5] = f5;
            fArr[10] = f6;
            return this;
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4(Quaternion quaternion) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {quaternion};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.val = new float[16];
        set(quaternion);
    }

    public Matrix4 avg(Matrix4[] matrix4Arr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, matrix4Arr)) == null) {
            float length = 1.0f / matrix4Arr.length;
            tmpVec.set(matrix4Arr[0].getScale(tmpUp).m21scl(length));
            quat.set(matrix4Arr[0].getRotation(quat2).exp(length));
            tmpForward.set(matrix4Arr[0].getTranslation(tmpUp).m21scl(length));
            for (int i = 1; i < matrix4Arr.length; i++) {
                tmpVec.add(matrix4Arr[i].getScale(tmpUp).m21scl(length));
                quat.mul(matrix4Arr[i].getRotation(quat2).exp(length));
                tmpForward.add(matrix4Arr[i].getTranslation(tmpUp).m21scl(length));
            }
            quat.nor();
            setToScaling(tmpVec);
            rotate(quat);
            setTranslation(tmpForward);
            return this;
        }
        return (Matrix4) invokeL.objValue;
    }

    public Matrix4(Vector3 vector3, Quaternion quaternion, Vector3 vector32) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector3, quaternion, vector32};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.val = new float[16];
        set(vector3, quaternion, vector32);
    }

    public Matrix4 setToLookAt(Vector3 vector3, Vector3 vector32, Vector3 vector33) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048628, this, vector3, vector32, vector33)) == null) {
            tmpVec.set(vector32).sub(vector3);
            setToLookAt(tmpVec, vector33);
            mul(tmpMat.setToTranslation(-vector3.x, -vector3.y, -vector3.z));
            return this;
        }
        return (Matrix4) invokeLLL.objValue;
    }

    public Matrix4 setToProjection(float f, float f2, float f3, float f4, float f5, float f6) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048633, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6)})) == null) {
            float f7 = f5 * 2.0f;
            float f8 = f2 - f;
            float f9 = f4 - f3;
            float f10 = f5 - f6;
            float f11 = (f6 + f5) / f10;
            float f12 = ((f6 * 2.0f) * f5) / f10;
            float[] fArr = this.val;
            fArr[0] = f7 / f8;
            fArr[1] = 0.0f;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = 0.0f;
            fArr[5] = f7 / f9;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = (f2 + f) / f8;
            fArr[9] = (f4 + f3) / f9;
            fArr[10] = f11;
            fArr[11] = -1.0f;
            fArr[12] = 0.0f;
            fArr[13] = 0.0f;
            fArr[14] = f12;
            fArr[15] = 0.0f;
            return this;
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 avg(Matrix4[] matrix4Arr, float[] fArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, matrix4Arr, fArr)) == null) {
            tmpVec.set(matrix4Arr[0].getScale(tmpUp).m21scl(fArr[0]));
            quat.set(matrix4Arr[0].getRotation(quat2).exp(fArr[0]));
            tmpForward.set(matrix4Arr[0].getTranslation(tmpUp).m21scl(fArr[0]));
            for (int i = 1; i < matrix4Arr.length; i++) {
                tmpVec.add(matrix4Arr[i].getScale(tmpUp).m21scl(fArr[i]));
                quat.mul(matrix4Arr[i].getRotation(quat2).exp(fArr[i]));
                tmpForward.add(matrix4Arr[i].getTranslation(tmpUp).m21scl(fArr[i]));
            }
            quat.nor();
            setToScaling(tmpVec);
            rotate(quat);
            setTranslation(tmpForward);
            return this;
        }
        return (Matrix4) invokeLL.objValue;
    }

    public Matrix4 set(Vector3 vector3, Quaternion quaternion, Vector3 vector32) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048620, this, vector3, quaternion, vector32)) == null) ? set(vector3.x, vector3.y, vector3.z, quaternion.x, quaternion.y, quaternion.z, quaternion.w, vector32.x, vector32.y, vector32.z) : (Matrix4) invokeLLL.objValue;
    }

    public Matrix4 set(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048614, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7), Float.valueOf(f8), Float.valueOf(f9), Float.valueOf(f10)})) == null) {
            float f11 = f4 * 2.0f;
            float f12 = f5 * 2.0f;
            float f13 = 2.0f * f6;
            float f14 = f7 * f11;
            float f15 = f7 * f12;
            float f16 = f7 * f13;
            float f17 = f11 * f4;
            float f18 = f4 * f12;
            float f19 = f4 * f13;
            float f20 = f12 * f5;
            float f21 = f5 * f13;
            float f22 = f13 * f6;
            float[] fArr = this.val;
            fArr[0] = (1.0f - (f20 + f22)) * f8;
            fArr[4] = (f18 - f16) * f9;
            fArr[8] = (f19 + f15) * f10;
            fArr[12] = f;
            fArr[1] = f8 * (f18 + f16);
            fArr[5] = (1.0f - (f22 + f17)) * f9;
            fArr[9] = (f21 - f14) * f10;
            fArr[13] = f2;
            fArr[2] = f8 * (f19 - f15);
            fArr[6] = f9 * (f21 + f14);
            fArr[10] = (1.0f - (f17 + f20)) * f10;
            fArr[14] = f3;
            fArr[3] = 0.0f;
            fArr[7] = 0.0f;
            fArr[11] = 0.0f;
            fArr[15] = 1.0f;
            return this;
        }
        return (Matrix4) invokeCommon.objValue;
    }

    public Matrix4 rotate(Vector3 vector3, Vector3 vector32) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048603, this, vector3, vector32)) == null) ? rotate(quat.setFromCross(vector3, vector32)) : (Matrix4) invokeLL.objValue;
    }

    public static boolean inv(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, fArr)) == null) {
            float det = det(fArr);
            if (det == 0.0f) {
                return false;
            }
            float f = ((((((fArr[12] * fArr[10]) * fArr[7]) - ((fArr[8] * fArr[14]) * fArr[7])) - ((fArr[12] * fArr[6]) * fArr[11])) + ((fArr[4] * fArr[14]) * fArr[11])) + ((fArr[8] * fArr[6]) * fArr[15])) - ((fArr[4] * fArr[10]) * fArr[15]);
            float f2 = ((((((fArr[8] * fArr[13]) * fArr[7]) - ((fArr[12] * fArr[9]) * fArr[7])) + ((fArr[12] * fArr[5]) * fArr[11])) - ((fArr[4] * fArr[13]) * fArr[11])) - ((fArr[8] * fArr[5]) * fArr[15])) + (fArr[4] * fArr[9] * fArr[15]);
            float f3 = ((((((fArr[12] * fArr[9]) * fArr[6]) - ((fArr[8] * fArr[13]) * fArr[6])) - ((fArr[12] * fArr[5]) * fArr[10])) + ((fArr[4] * fArr[13]) * fArr[10])) + ((fArr[8] * fArr[5]) * fArr[14])) - ((fArr[4] * fArr[9]) * fArr[14]);
            float f4 = ((((((fArr[13] * fArr[10]) * fArr[3]) - ((fArr[9] * fArr[14]) * fArr[3])) - ((fArr[13] * fArr[2]) * fArr[11])) + ((fArr[1] * fArr[14]) * fArr[11])) + ((fArr[9] * fArr[2]) * fArr[15])) - ((fArr[1] * fArr[10]) * fArr[15]);
            float f5 = ((((((fArr[8] * fArr[14]) * fArr[3]) - ((fArr[12] * fArr[10]) * fArr[3])) + ((fArr[12] * fArr[2]) * fArr[11])) - ((fArr[0] * fArr[14]) * fArr[11])) - ((fArr[8] * fArr[2]) * fArr[15])) + (fArr[0] * fArr[10] * fArr[15]);
            float f6 = ((((((fArr[12] * fArr[9]) * fArr[3]) - ((fArr[8] * fArr[13]) * fArr[3])) - ((fArr[12] * fArr[1]) * fArr[11])) + ((fArr[0] * fArr[13]) * fArr[11])) + ((fArr[8] * fArr[1]) * fArr[15])) - ((fArr[0] * fArr[9]) * fArr[15]);
            float f7 = ((((((fArr[8] * fArr[13]) * fArr[2]) - ((fArr[12] * fArr[9]) * fArr[2])) + ((fArr[12] * fArr[1]) * fArr[10])) - ((fArr[0] * fArr[13]) * fArr[10])) - ((fArr[8] * fArr[1]) * fArr[14])) + (fArr[0] * fArr[9] * fArr[14]);
            float f8 = ((((((fArr[5] * fArr[14]) * fArr[3]) - ((fArr[13] * fArr[6]) * fArr[3])) + ((fArr[13] * fArr[2]) * fArr[7])) - ((fArr[1] * fArr[14]) * fArr[7])) - ((fArr[5] * fArr[2]) * fArr[15])) + (fArr[1] * fArr[6] * fArr[15]);
            float f9 = ((((((fArr[12] * fArr[6]) * fArr[3]) - ((fArr[4] * fArr[14]) * fArr[3])) - ((fArr[12] * fArr[2]) * fArr[7])) + ((fArr[0] * fArr[14]) * fArr[7])) + ((fArr[4] * fArr[2]) * fArr[15])) - ((fArr[0] * fArr[6]) * fArr[15]);
            float f10 = ((((((fArr[4] * fArr[13]) * fArr[3]) - ((fArr[12] * fArr[5]) * fArr[3])) + ((fArr[12] * fArr[1]) * fArr[7])) - ((fArr[0] * fArr[13]) * fArr[7])) - ((fArr[4] * fArr[1]) * fArr[15])) + (fArr[0] * fArr[5] * fArr[15]);
            float f11 = ((((((fArr[12] * fArr[5]) * fArr[2]) - ((fArr[4] * fArr[13]) * fArr[2])) - ((fArr[12] * fArr[1]) * fArr[6])) + ((fArr[0] * fArr[13]) * fArr[6])) + ((fArr[4] * fArr[1]) * fArr[14])) - ((fArr[0] * fArr[5]) * fArr[14]);
            float f12 = ((((((fArr[9] * fArr[6]) * fArr[3]) - ((fArr[5] * fArr[10]) * fArr[3])) - ((fArr[9] * fArr[2]) * fArr[7])) + ((fArr[1] * fArr[10]) * fArr[7])) + ((fArr[5] * fArr[2]) * fArr[11])) - ((fArr[1] * fArr[6]) * fArr[11]);
            float f13 = ((((((fArr[4] * fArr[10]) * fArr[3]) - ((fArr[8] * fArr[6]) * fArr[3])) + ((fArr[8] * fArr[2]) * fArr[7])) - ((fArr[0] * fArr[10]) * fArr[7])) - ((fArr[4] * fArr[2]) * fArr[11])) + (fArr[0] * fArr[6] * fArr[11]);
            float f14 = ((((((fArr[8] * fArr[5]) * fArr[3]) - ((fArr[4] * fArr[9]) * fArr[3])) - ((fArr[8] * fArr[1]) * fArr[7])) + ((fArr[0] * fArr[9]) * fArr[7])) + ((fArr[4] * fArr[1]) * fArr[11])) - ((fArr[0] * fArr[5]) * fArr[11]);
            float f15 = ((((((fArr[4] * fArr[9]) * fArr[2]) - ((fArr[8] * fArr[5]) * fArr[2])) + ((fArr[8] * fArr[1]) * fArr[6])) - ((fArr[0] * fArr[9]) * fArr[6])) - ((fArr[4] * fArr[1]) * fArr[10])) + (fArr[0] * fArr[5] * fArr[10]);
            float f16 = 1.0f / det;
            fArr[0] = (((((((fArr[9] * fArr[14]) * fArr[7]) - ((fArr[13] * fArr[10]) * fArr[7])) + ((fArr[13] * fArr[6]) * fArr[11])) - ((fArr[5] * fArr[14]) * fArr[11])) - ((fArr[9] * fArr[6]) * fArr[15])) + (fArr[5] * fArr[10] * fArr[15])) * f16;
            fArr[1] = f4 * f16;
            fArr[2] = f8 * f16;
            fArr[3] = f12 * f16;
            fArr[4] = f * f16;
            fArr[5] = f5 * f16;
            fArr[6] = f9 * f16;
            fArr[7] = f13 * f16;
            fArr[8] = f2 * f16;
            fArr[9] = f6 * f16;
            fArr[10] = f10 * f16;
            fArr[11] = f14 * f16;
            fArr[12] = f3 * f16;
            fArr[13] = f7 * f16;
            fArr[14] = f11 * f16;
            fArr[15] = f15 * f16;
            return true;
        }
        return invokeL.booleanValue;
    }

    public Matrix4 set(Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048621, this, vector3, vector32, vector33, vector34)) == null) {
            float[] fArr = this.val;
            fArr[0] = vector3.x;
            fArr[4] = vector3.y;
            fArr[8] = vector3.z;
            fArr[1] = vector32.x;
            fArr[5] = vector32.y;
            fArr[9] = vector32.z;
            fArr[2] = vector33.x;
            fArr[6] = vector33.y;
            fArr[10] = vector33.z;
            fArr[12] = vector34.x;
            fArr[13] = vector34.y;
            fArr[14] = vector34.z;
            fArr[3] = 0.0f;
            fArr[7] = 0.0f;
            fArr[11] = 0.0f;
            fArr[15] = 1.0f;
            return this;
        }
        return (Matrix4) invokeLLLL.objValue;
    }

    public Matrix4 set(Matrix3 matrix3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048616, this, matrix3)) == null) {
            float[] fArr = this.val;
            float[] fArr2 = matrix3.val;
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[1];
            fArr[2] = fArr2[2];
            fArr[3] = 0.0f;
            fArr[4] = fArr2[3];
            fArr[5] = fArr2[4];
            fArr[6] = fArr2[5];
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 1.0f;
            fArr[11] = 0.0f;
            fArr[12] = fArr2[6];
            fArr[13] = fArr2[7];
            fArr[14] = 0.0f;
            fArr[15] = fArr2[8];
            return this;
        }
        return (Matrix4) invokeL.objValue;
    }

    public Matrix4 set(Affine2 affine2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048615, this, affine2)) == null) {
            float[] fArr = this.val;
            fArr[0] = affine2.m00;
            fArr[1] = affine2.m10;
            fArr[2] = 0.0f;
            fArr[3] = 0.0f;
            fArr[4] = affine2.m01;
            fArr[5] = affine2.m11;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 0.0f;
            fArr[9] = 0.0f;
            fArr[10] = 1.0f;
            fArr[11] = 0.0f;
            fArr[12] = affine2.m02;
            fArr[13] = affine2.m12;
            fArr[14] = 0.0f;
            fArr[15] = 1.0f;
            return this;
        }
        return (Matrix4) invokeL.objValue;
    }
}
