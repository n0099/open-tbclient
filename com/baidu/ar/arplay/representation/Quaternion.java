package com.baidu.ar.arplay.representation;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class Quaternion extends Vector4f {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -7148812599404359073L;
    public transient /* synthetic */ FieldHolder $fh;
    public Quaternion bufferQuaternion;
    public boolean dirty;
    public Matrixf4x4 matrix;

    public Quaternion() {
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
        this.dirty = false;
        this.matrix = new Matrixf4x4();
        loadIdentityQuat();
    }

    private void convertQuatToMatrix() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            float[] fArr = this.points;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            float f5 = fArr[3];
            float f6 = f3 * f3 * 2.0f;
            float f7 = f4 * f4 * 2.0f;
            this.matrix.setX0((1.0f - f6) - f7);
            float f8 = f2 * f3 * 2.0f;
            float f9 = f5 * f4 * 2.0f;
            this.matrix.setX1(f8 + f9);
            float f10 = f2 * f4 * 2.0f;
            float f11 = f5 * f3 * 2.0f;
            this.matrix.setX2(f10 - f11);
            this.matrix.setX3(0.0f);
            this.matrix.setY0(f8 - f9);
            float f12 = 1.0f - ((f2 * f2) * 2.0f);
            this.matrix.setY1(f12 - f7);
            float f13 = f3 * f4 * 2.0f;
            float f14 = f5 * f2 * 2.0f;
            this.matrix.setY2(f13 + f14);
            this.matrix.setY3(0.0f);
            this.matrix.setZ0(f10 + f11);
            this.matrix.setZ1(f13 - f14);
            this.matrix.setZ2(f12 - f6);
            this.matrix.setZ3(0.0f);
            this.matrix.setW0(0.0f);
            this.matrix.setW1(0.0f);
            this.matrix.setW2(0.0f);
            this.matrix.setW3(1.0f);
        }
    }

    private void generateQuaternionFromMatrix() {
        float f2;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            float[] matrix = this.matrix.getMatrix();
            int[] iArr = this.matrix.size() == 16 ? this.matrix.isColumnMajor() ? Matrixf4x4.MAT_IND_COL_IN16_WITH3X3 : Matrixf4x4.MAT_IND_ROW_IN16_WITH3X3 : this.matrix.isColumnMajor() ? Matrixf4x4.MAT_IND_COL_IN9_WITH3X3 : Matrixf4x4.MAT_IND_ROW_IN9_WITH3X3;
            int i2 = iArr[0];
            int i3 = iArr[1];
            int i4 = iArr[2];
            int i5 = iArr[3];
            int i6 = iArr[4];
            int i7 = iArr[5];
            int i8 = iArr[6];
            int i9 = iArr[7];
            int i10 = iArr[8];
            if (this.matrix.size() >= 9) {
                float f6 = matrix[i2] + matrix[i6] + matrix[i10];
                if (f6 > 0.0f) {
                    float sqrt = ((float) Math.sqrt(f6 + 1.0d)) * 2.0f;
                    f2 = 0.25f * sqrt;
                    f3 = (matrix[i9] - matrix[i7]) / sqrt;
                    f4 = (matrix[i4] - matrix[i8]) / sqrt;
                    f5 = (matrix[i5] - matrix[i3]) / sqrt;
                } else if (matrix[i2] > matrix[i6] && matrix[i2] > matrix[i10]) {
                    float sqrt2 = ((float) Math.sqrt(((matrix[i2] + 1.0d) - matrix[i6]) - matrix[i10])) * 2.0f;
                    f2 = (matrix[i9] - matrix[i7]) / sqrt2;
                    f3 = 0.25f * sqrt2;
                    f5 = (matrix[i4] + matrix[i8]) / sqrt2;
                    f4 = (matrix[i3] + matrix[i5]) / sqrt2;
                } else if (matrix[i6] > matrix[i10]) {
                    float sqrt3 = ((float) Math.sqrt(((matrix[i6] + 1.0d) - matrix[i2]) - matrix[i10])) * 2.0f;
                    f2 = (matrix[i4] - matrix[i8]) / sqrt3;
                    f3 = (matrix[i3] + matrix[i5]) / sqrt3;
                    f4 = sqrt3 * 0.25f;
                    f5 = (matrix[i7] + matrix[i9]) / sqrt3;
                } else {
                    float sqrt4 = ((float) Math.sqrt(((matrix[i10] + 1.0d) - matrix[i2]) - matrix[i6])) * 2.0f;
                    f2 = (matrix[i5] - matrix[i3]) / sqrt4;
                    f3 = (matrix[i4] + matrix[i8]) / sqrt4;
                    f4 = (matrix[i7] + matrix[i9]) / sqrt4;
                    f5 = sqrt4 * 0.25f;
                }
                setX(f3);
                setY(f4);
                setZ(f5);
                setW(f2);
            }
        }
    }

    public void addQuat(Quaternion quaternion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, quaternion) == null) {
            this.dirty = true;
            addQuat(quaternion, this);
        }
    }

    public void addQuat(Quaternion quaternion, Quaternion quaternion2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, quaternion, quaternion2) == null) {
            quaternion2.setX(getX() + quaternion.getX());
            quaternion2.setY(getY() + quaternion.getY());
            quaternion2.setZ(getZ() + quaternion.getZ());
            quaternion2.setW(getW() + quaternion.getW());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public Quaternion m33clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Quaternion quaternion = new Quaternion();
            quaternion.copyVec4(this);
            return quaternion;
        }
        return (Quaternion) invokeV.objValue;
    }

    public void copyFromVec3(Vector3f vector3f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048580, this, vector3f, f2) == null) {
            copyFromV3f(vector3f, f2);
        }
    }

    public Matrixf4x4 getMatrix4x4() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.dirty) {
                convertQuatToMatrix();
                this.dirty = false;
            }
            return this.matrix;
        }
        return (Matrixf4x4) invokeV.objValue;
    }

    public final void loadIdentityQuat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.dirty = true;
            setX(0.0f);
            setY(0.0f);
            setZ(0.0f);
            setW(1.0f);
        }
    }

    public void multiplyByQuat(Quaternion quaternion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, quaternion) == null) {
            if (this.bufferQuaternion == null) {
                this.bufferQuaternion = new Quaternion();
            }
            this.dirty = true;
            this.bufferQuaternion.copyVec4(this);
            multiplyByQuat(quaternion, this.bufferQuaternion);
            copyVec4(this.bufferQuaternion);
        }
    }

    public void multiplyByQuat(Quaternion quaternion, Quaternion quaternion2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, quaternion, quaternion2) == null) {
            Vector4f vector4f = new Vector4f();
            if (quaternion != quaternion2) {
                float[] fArr = quaternion2.points;
                float[] fArr2 = this.points;
                float f2 = fArr2[3];
                float[] fArr3 = quaternion.points;
                fArr[3] = (((f2 * fArr3[3]) - (fArr2[0] * fArr3[0])) - (fArr2[1] * fArr3[1])) - (fArr2[2] * fArr3[2]);
                fArr[0] = (((fArr2[3] * fArr3[0]) + (fArr2[0] * fArr3[3])) + (fArr2[1] * fArr3[2])) - (fArr2[2] * fArr3[1]);
                fArr[1] = (((fArr2[3] * fArr3[1]) + (fArr2[1] * fArr3[3])) + (fArr2[2] * fArr3[0])) - (fArr2[0] * fArr3[2]);
                fArr[2] = (((fArr2[3] * fArr3[2]) + (fArr2[2] * fArr3[3])) + (fArr2[0] * fArr3[1])) - (fArr2[1] * fArr3[0]);
                return;
            }
            float[] fArr4 = vector4f.points;
            float[] fArr5 = quaternion.points;
            fArr4[0] = fArr5[0];
            fArr4[1] = fArr5[1];
            fArr4[2] = fArr5[2];
            fArr4[3] = fArr5[3];
            float[] fArr6 = quaternion2.points;
            float[] fArr7 = this.points;
            fArr6[3] = (((fArr7[3] * fArr4[3]) - (fArr7[0] * fArr4[0])) - (fArr7[1] * fArr4[1])) - (fArr7[2] * fArr4[2]);
            fArr6[0] = (((fArr7[3] * fArr4[0]) + (fArr7[0] * fArr4[3])) + (fArr7[1] * fArr4[2])) - (fArr7[2] * fArr4[1]);
            fArr6[1] = (((fArr7[3] * fArr4[1]) + (fArr7[1] * fArr4[3])) + (fArr7[2] * fArr4[0])) - (fArr7[0] * fArr4[2]);
            fArr6[2] = (((fArr7[3] * fArr4[2]) + (fArr7[2] * fArr4[3])) + (fArr7[0] * fArr4[1])) - (fArr7[1] * fArr4[0]);
        }
    }

    public void normalise() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.dirty = true;
            float[] fArr = this.points;
            float sqrt = (float) Math.sqrt((fArr[3] * fArr[3]) + (fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]));
            float[] fArr2 = this.points;
            fArr2[3] = fArr2[3] / sqrt;
            fArr2[0] = fArr2[0] / sqrt;
            fArr2[1] = fArr2[1] / sqrt;
            fArr2[2] = fArr2[2] / sqrt;
        }
    }

    @Override // com.baidu.ar.arplay.representation.Vector4f
    public void normalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            normalise();
        }
    }

    public void set(Quaternion quaternion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, quaternion) == null) {
            this.dirty = true;
            copyVec4(quaternion);
        }
    }

    public void setAxisAngle(Vector3f vector3f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048588, this, vector3f, f2) == null) {
            double d2 = f2 / 2.0f;
            float sin = (float) Math.sin(Math.toRadians(d2));
            setX(vector3f.getX() * sin);
            setY(vector3f.getY() * sin);
            setZ(vector3f.getZ() * sin);
            setW((float) Math.cos(Math.toRadians(d2)));
            this.dirty = true;
        }
    }

    public void setAxisAngleRad(Vector3f vector3f, double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048589, this, new Object[]{vector3f, Double.valueOf(d2)}) == null) {
            setAxisAngle(vector3f, (float) Math.toDegrees(d2));
        }
    }

    public void setColumnMajor(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, fArr) == null) {
            this.matrix.setMatrix(fArr);
            this.matrix.setColumnMajor(true);
            generateQuaternionFromMatrix();
        }
    }

    public void setEulerAngle(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            double radians = Math.toRadians(f4);
            double radians2 = Math.toRadians(f3);
            double radians3 = Math.toRadians(f2);
            double d2 = radians / 2.0d;
            double cos = Math.cos(d2);
            double sin = Math.sin(d2);
            double d3 = radians2 / 2.0d;
            double cos2 = Math.cos(d3);
            double sin2 = Math.sin(d3);
            double d4 = radians3 / 2.0d;
            double cos3 = Math.cos(d4);
            double sin3 = Math.sin(d4);
            double d5 = cos * cos2;
            double d6 = sin * sin2;
            setW((float) ((d5 * cos3) - (d6 * sin3)));
            setX((float) ((d5 * sin3) + (d6 * cos3)));
            double d7 = sin * cos2;
            double d8 = cos * sin2;
            setY((float) ((d7 * cos3) + (d8 * sin3)));
            setZ((float) ((d8 * cos3) - (d7 * sin3)));
            this.dirty = true;
        }
    }

    public void setRowMajor(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, fArr) == null) {
            this.matrix.setMatrix(fArr);
            this.matrix.setColumnMajor(false);
            generateQuaternionFromMatrix();
        }
    }

    public void slerp(Quaternion quaternion, Quaternion quaternion2, float f2) {
        Quaternion quaternion3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048593, this, new Object[]{quaternion, quaternion2, Float.valueOf(f2)}) == null) {
            float dotProduct = dotProduct(quaternion);
            if (dotProduct < 0.0f) {
                quaternion3 = new Quaternion();
                dotProduct = -dotProduct;
                float[] fArr = quaternion3.points;
                float[] fArr2 = quaternion.points;
                fArr[0] = -fArr2[0];
                fArr[1] = -fArr2[1];
                fArr[2] = -fArr2[2];
                fArr[3] = -fArr2[3];
            } else {
                quaternion3 = quaternion;
            }
            if (Math.abs(dotProduct) >= 1.0d) {
                float[] fArr3 = quaternion2.points;
                float[] fArr4 = this.points;
                fArr3[0] = fArr4[0];
                fArr3[1] = fArr4[1];
                fArr3[2] = fArr4[2];
                fArr3[3] = fArr4[3];
                return;
            }
            double sqrt = Math.sqrt(1.0d - (dotProduct * dotProduct));
            double acos = Math.acos(dotProduct);
            double sin = Math.sin((1.0f - f2) * acos) / sqrt;
            double sin2 = Math.sin(f2 * acos) / sqrt;
            float[] fArr5 = quaternion2.points;
            float[] fArr6 = this.points;
            float[] fArr7 = quaternion3.points;
            fArr5[3] = (float) ((fArr6[3] * sin) + (fArr7[3] * sin2));
            fArr5[0] = (float) ((fArr6[0] * sin) + (fArr7[0] * sin2));
            fArr5[1] = (float) ((fArr6[1] * sin) + (fArr7[1] * sin2));
            fArr5[2] = (float) ((fArr6[2] * sin) + (fArr7[2] * sin2));
        }
    }

    public void subQuat(Quaternion quaternion) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, quaternion) == null) {
            this.dirty = true;
            subQuat(quaternion, this);
        }
    }

    public void subQuat(Quaternion quaternion, Quaternion quaternion2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, quaternion, quaternion2) == null) {
            quaternion2.setX(getX() - quaternion.getX());
            quaternion2.setY(getY() - quaternion.getY());
            quaternion2.setZ(getZ() - quaternion.getZ());
            quaternion2.setW(getW() - quaternion.getW());
        }
    }

    public void toAxisAngle(Vector4f vector4f) {
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, vector4f) == null) {
            if (getW() > 1.0f) {
                normalise();
            }
            float degrees = ((float) Math.toDegrees(Math.acos(getW()))) * 2.0f;
            float sqrt = (float) Math.sqrt(1.0f - (getW() * getW()));
            if (sqrt < 0.001d) {
                float[] fArr = this.points;
                f3 = fArr[0];
                f4 = fArr[1];
                f2 = fArr[2];
            } else {
                float[] fArr2 = this.points;
                float f5 = fArr2[0] / sqrt;
                float f6 = fArr2[1] / sqrt;
                f2 = fArr2[2] / sqrt;
                f3 = f5;
                f4 = f6;
            }
            float[] fArr3 = vector4f.points;
            fArr3[0] = f3;
            fArr3[1] = f4;
            fArr3[2] = f2;
            fArr3[3] = degrees;
        }
    }

    public double[] toEulerAngles() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            float w = this.points[1] * 2.0f * getW();
            float[] fArr = this.points;
            float[] fArr2 = this.points;
            float w2 = this.points[0] * 2.0f * getW();
            float[] fArr3 = this.points;
            return new double[]{Math.atan2(w - ((fArr[0] * 2.0f) * fArr[2]), (1.0f - ((fArr[1] * fArr[1]) * 2.0f)) - ((fArr[2] * fArr[2]) * 2.0f)), Math.asin((fArr2[0] * 2.0f * fArr2[1]) + (fArr2[2] * 2.0f * getW())), Math.atan2(w2 - ((fArr3[1] * 2.0f) * fArr3[2]), (1.0f - ((fArr3[0] * fArr3[0]) * 2.0f)) - ((fArr3[2] * fArr3[2]) * 2.0f))};
        }
        return (double[]) invokeV.objValue;
    }

    @Override // com.baidu.ar.arplay.representation.Vector4f
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "{X: " + getX() + ", Y:" + getY() + ", Z:" + getZ() + ", W:" + getW() + "}";
        }
        return (String) invokeV.objValue;
    }
}
