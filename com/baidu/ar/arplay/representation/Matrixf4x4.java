package com.baidu.ar.arplay.representation;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class Matrixf4x4 {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int[] MAT_IND_COL_IN16_WITH3X3;
    public static final int[] MAT_IND_COL_IN16_WITH4X4;
    public static final int[] MAT_IND_COL_IN9_WITH3X3;
    public static final int[] MAT_IND_ROW_IN16_WITH3X3;
    public static final int[] MAT_IND_ROW_IN16_WITH4X4;
    public static final int[] MAT_IND_ROW_IN9_WITH3X3;
    public static final String TAG = "Matrixf4x4";
    public transient /* synthetic */ FieldHolder $fh;
    public boolean colMaj;
    public float[] matrix;
    public boolean matrixValid;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1672732856, "Lcom/baidu/ar/arplay/representation/Matrixf4x4;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1672732856, "Lcom/baidu/ar/arplay/representation/Matrixf4x4;");
                return;
            }
        }
        MAT_IND_COL_IN9_WITH3X3 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        MAT_IND_COL_IN16_WITH3X3 = new int[]{0, 1, 2, 4, 5, 6, 8, 9, 10};
        MAT_IND_ROW_IN9_WITH3X3 = new int[]{0, 3, 6, 1, 4, 7, 3, 5, 8};
        MAT_IND_ROW_IN16_WITH3X3 = new int[]{0, 4, 8, 1, 5, 9, 2, 6, 10};
        MAT_IND_COL_IN16_WITH4X4 = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        MAT_IND_ROW_IN16_WITH4X4 = new int[]{0, 4, 8, 12, 1, 5, 9, 13, 2, 6, 10, 14, 3, 7, 11, 15};
    }

    public Matrixf4x4() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.colMaj = true;
        this.matrixValid = false;
        this.matrix = new float[16];
        loadIndentity();
    }

    public static Matrixf4x4 lookAtLH(Vector3f vector3f, Vector3f vector3f2, Vector3f vector3f3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, vector3f, vector3f2, vector3f3)) == null) {
            if (vector3f == null || vector3f2 == null || vector3f3 == null) {
                return null;
            }
            Vector3f vector3f4 = new Vector3f(vector3f2);
            vector3f4.subtract(vector3f);
            vector3f4.normalize();
            Vector3f vector3f5 = new Vector3f();
            new Vector3f(vector3f3).crossProduct(vector3f4, vector3f5);
            vector3f5.normalize();
            Vector3f vector3f6 = new Vector3f();
            new Vector3f(vector3f4).crossProduct(vector3f5, vector3f6);
            Matrixf4x4 matrixf4x4 = new Matrixf4x4();
            matrixf4x4.setX0(vector3f5.getX());
            matrixf4x4.setY0(vector3f5.getY());
            matrixf4x4.setZ0(vector3f5.getZ());
            matrixf4x4.setX1(vector3f6.getX());
            matrixf4x4.setY1(vector3f6.getY());
            matrixf4x4.setZ1(vector3f6.getZ());
            matrixf4x4.setX2(vector3f4.getX());
            matrixf4x4.setY2(vector3f4.getY());
            matrixf4x4.setZ2(vector3f4.getZ());
            matrixf4x4.setW0(-vector3f5.dotProduct(vector3f));
            matrixf4x4.setW1(-vector3f6.dotProduct(vector3f));
            matrixf4x4.setW2(-vector3f4.dotProduct(vector3f));
            return matrixf4x4;
        }
        return (Matrixf4x4) invokeLLL.objValue;
    }

    public float[] getMatrix() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.matrix : (float[]) invokeV.objValue;
    }

    public boolean isColumnMajor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.colMaj : invokeV.booleanValue;
    }

    public boolean isMatrixValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.matrixValid : invokeV.booleanValue;
    }

    public final void loadIndentity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Matrix.setIdentityM(this.matrix, 0);
            this.matrixValid = true;
        }
    }

    public void multiplyMatrix(float[] fArr, int i2, float[] fArr2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{fArr, Integer.valueOf(i2), fArr2, Integer.valueOf(i3)}) == null) {
            for (int i4 = 0; i4 < 4; i4++) {
                for (int i5 = 0; i5 < 4; i5++) {
                    int i6 = i3 + 0 + i5;
                    float f2 = fArr2[i6];
                    float[] fArr3 = this.matrix;
                    int i7 = (i4 * 4) + i5;
                    fArr2[i6] = f2 + (fArr3[i7] * fArr[i2 + 0 + i4]);
                    int i8 = i3 + 4 + i5;
                    fArr2[i8] = fArr2[i8] + (fArr3[i7] * fArr[i2 + 4 + i4]);
                    int i9 = i3 + 8 + i5;
                    fArr2[i9] = fArr2[i9] + (fArr3[i7] * fArr[i2 + 8 + i4]);
                    int i10 = i3 + 12 + i5;
                    fArr2[i10] = fArr2[i10] + (fArr3[i7] * fArr[i2 + 12 + i4]);
                }
            }
        }
    }

    public void multiplyMatrix4x4ByMatrix(Matrixf4x4 matrixf4x4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, matrixf4x4) == null) {
            if (this.matrixValid && matrixf4x4.isMatrixValid()) {
                float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                multiplyMatrix(matrixf4x4.getMatrix(), 0, fArr, 0);
                matrixf4x4.setMatrix(fArr);
                return;
            }
            String str = "matrixMatrix is invalid, internal is " + this.matrix.length + " long , input matrix is " + matrixf4x4.getMatrix().length + " long";
        }
    }

    @Deprecated
    public void multiplyVector3fByMatrix(Vector3f vector3f) {
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, vector3f) == null) {
            if (!this.matrixValid || this.matrix.length != 9) {
                String str = "matrixMatrix is invalid, is " + this.matrix.length + " long, this function expects the internal matrix to be of size 9";
                return;
            }
            float[] array = vector3f.toArray();
            float f4 = 0.0f;
            if (this.colMaj) {
                f2 = 0.0f;
                f3 = 0.0f;
                for (int i2 = 0; i2 < 3; i2++) {
                    float[] fArr = this.matrix;
                    f4 += fArr[i2 + 0] * array[i2];
                    f2 += fArr[i2 + 3] * array[i2];
                    f3 += fArr[i2 + 6] * array[i2];
                }
            } else {
                f2 = 0.0f;
                f3 = 0.0f;
                for (int i3 = 0; i3 < 3; i3++) {
                    int i4 = i3 * 3;
                    float[] fArr2 = this.matrix;
                    f4 += fArr2[i4 + 0] * array[i3];
                    f2 += fArr2[i4 + 1] * array[i3];
                    f3 += fArr2[i4 + 2] * array[i3];
                }
            }
            vector3f.setX(f4);
            vector3f.setY(f2);
            vector3f.setZ(f3);
        }
    }

    public void multiplyVector4fByMatrix(Vector4f vector4f) {
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, vector4f) == null) {
            if (!this.matrixValid || this.matrix.length != 16) {
                String str = "matrixMatrix is invalid, is " + this.matrix.length + " long, this equation expects a 16 value matrix";
                return;
            }
            float[] array = vector4f.toArray();
            int i2 = 0;
            float f5 = 0.0f;
            if (this.colMaj) {
                f2 = 0.0f;
                f3 = 0.0f;
                f4 = 0.0f;
                while (i2 < 4) {
                    int i3 = i2 * 4;
                    float[] fArr = this.matrix;
                    f5 += fArr[i3 + 0] * array[i2];
                    f2 += fArr[i3 + 1] * array[i2];
                    f3 += fArr[i3 + 2] * array[i2];
                    f4 += fArr[i3 + 3] * array[i2];
                    i2++;
                }
            } else {
                f2 = 0.0f;
                f3 = 0.0f;
                f4 = 0.0f;
                while (i2 < 4) {
                    float[] fArr2 = this.matrix;
                    f5 += fArr2[i2 + 0] * array[i2];
                    f2 += fArr2[i2 + 4] * array[i2];
                    f3 += fArr2[i2 + 8] * array[i2];
                    f4 += fArr2[i2 + 12] * array[i2];
                    i2++;
                }
            }
            vector4f.setX(f5);
            vector4f.setY(f2);
            vector4f.setZ(f3);
            vector4f.setW(f4);
        }
    }

    public void setColumnMajor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
            this.colMaj = z;
        }
    }

    public void setMatrix(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, fArr) == null) {
            this.matrix = fArr;
            if (fArr.length == 16 || fArr.length == 9) {
                this.matrixValid = true;
                return;
            }
            this.matrixValid = false;
            String str = "matrixMatrix set is invalid, size is " + fArr.length + " expected 9 or 16";
        }
    }

    public void setMatrixValues(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, fArr) == null) {
            if (this.matrix.length != fArr.length) {
                String str = "matrixMatrix set is invalid, size is " + fArr.length + " expected 9 or 16";
            }
            for (int i2 = 0; i2 < fArr.length; i2++) {
                this.matrix[i2] = fArr[i2];
            }
        }
    }

    public void setW0(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048587, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH4X4[12]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH4X4[12]] = f2;
                }
            }
        }
    }

    public void setW1(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048588, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH4X4[13]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH4X4[13]] = f2;
                }
            }
        }
    }

    public void setW2(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048589, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH4X4[14]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH4X4[14]] = f2;
                }
            }
        }
    }

    public void setW3(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048590, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH4X4[15]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH4X4[15]] = f2;
                }
            }
        }
    }

    public void setX0(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048591, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[0]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[0]] = f2;
                }
            } else if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[0]] = f2;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[0]] = f2;
            }
        }
    }

    public void setX1(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048592, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[1]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[1]] = f2;
                }
            } else if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[1]] = f2;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[1]] = f2;
            }
        }
    }

    public void setX2(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048593, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[2]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[2]] = f2;
                }
            } else if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[2]] = f2;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[2]] = f2;
            }
        }
    }

    public void setX3(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048594, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH4X4[3]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH4X4[3]] = f2;
                }
            }
        }
    }

    public void setY0(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048595, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[3]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[3]] = f2;
                }
            } else if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[3]] = f2;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[3]] = f2;
            }
        }
    }

    public void setY1(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048596, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[4]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[4]] = f2;
                }
            } else if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[4]] = f2;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[4]] = f2;
            }
        }
    }

    public void setY2(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048597, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[5]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[5]] = f2;
                }
            } else if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[5]] = f2;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[5]] = f2;
            }
        }
    }

    public void setY3(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048598, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH4X4[7]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH4X4[7]] = f2;
                }
            }
        }
    }

    public void setZ0(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048599, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[6]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[6]] = f2;
                }
            } else if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[6]] = f2;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[6]] = f2;
            }
        }
    }

    public void setZ1(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048600, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[7]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[7]] = f2;
                }
            } else if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[7]] = f2;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[7]] = f2;
            }
        }
    }

    public void setZ2(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048601, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH3X3[8]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH3X3[8]] = f2;
                }
            } else if (this.colMaj) {
                fArr[MAT_IND_COL_IN9_WITH3X3[8]] = f2;
            } else {
                fArr[MAT_IND_ROW_IN9_WITH3X3[8]] = f2;
            }
        }
    }

    public void setZ3(float f2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048602, this, f2) == null) && this.matrixValid) {
            float[] fArr = this.matrix;
            if (fArr.length == 16) {
                if (this.colMaj) {
                    fArr[MAT_IND_COL_IN16_WITH4X4[11]] = f2;
                } else {
                    fArr[MAT_IND_ROW_IN16_WITH4X4[11]] = f2;
                }
            }
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.matrix.length : invokeV.intValue;
    }

    public void transpose() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.matrixValid) {
            int i2 = 0;
            if (this.matrix.length != 16) {
                float[] fArr = new float[9];
                while (i2 < 3) {
                    int i3 = i2 * 3;
                    float[] fArr2 = this.matrix;
                    fArr[i3] = fArr2[i2];
                    fArr[i3 + 1] = fArr2[i2 + 3];
                    fArr[i3 + 2] = fArr2[i2 + 6];
                    i2++;
                }
                this.matrix = fArr;
                return;
            }
            float[] fArr3 = new float[16];
            while (i2 < 4) {
                int i4 = i2 * 4;
                float[] fArr4 = this.matrix;
                fArr3[i4] = fArr4[i2];
                fArr3[i4 + 1] = fArr4[i2 + 4];
                fArr3[i4 + 2] = fArr4[i2 + 8];
                fArr3[i4 + 3] = fArr4[i2 + 12];
                i2++;
            }
            this.matrix = fArr3;
        }
    }
}
