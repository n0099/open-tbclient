package com.baidu.ar.arplay.representation;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class Vector3f extends Renderable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4565578579900616220L;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] points;

    public Vector3f() {
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
        this.points = new float[3];
    }

    public Vector3f(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.points = r0;
        float[] fArr = {f2, f2, f2};
    }

    public Vector3f(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.points = r0;
        float[] fArr = {f2, f3, f4};
    }

    public Vector3f(Vector3f vector3f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector3f};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.points = r0;
        float[] fArr = vector3f.points;
        float[] fArr2 = {fArr[0], fArr[1], fArr[2]};
    }

    public Vector3f(Vector4f vector4f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector4f};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.points = new float[3];
        if (vector4f.w() != 0.0f) {
            this.points[0] = vector4f.x() / vector4f.w();
            this.points[1] = vector4f.y() / vector4f.w();
            this.points[2] = vector4f.z() / vector4f.w();
            return;
        }
        this.points[0] = vector4f.x();
        this.points[1] = vector4f.y();
        this.points[2] = vector4f.z();
    }

    public void add(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
            float[] fArr = this.points;
            fArr[0] = fArr[0] + f2;
            fArr[1] = fArr[1] + f2;
            fArr[2] = fArr[2] + f2;
        }
    }

    public void add(Vector3f vector3f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vector3f) == null) {
            float[] fArr = this.points;
            float f2 = fArr[0];
            float[] fArr2 = vector3f.points;
            fArr[0] = f2 + fArr2[0];
            fArr[1] = fArr[1] + fArr2[1];
            fArr[2] = fArr[2] + fArr2[2];
        }
    }

    public void clone(Vector3f vector3f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vector3f) == null) {
            System.arraycopy(vector3f.points, 0, this.points, 0, 3);
        }
    }

    public void clone(float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fArr) == null) {
            System.arraycopy(fArr, 0, this.points, 0, 3);
        }
    }

    public Vector3f crossProduct(Vector3f vector3f) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vector3f)) == null) {
            Vector3f vector3f2 = new Vector3f();
            crossProduct(vector3f, vector3f2);
            return vector3f2;
        }
        return (Vector3f) invokeL.objValue;
    }

    public void crossProduct(Vector3f vector3f, Vector3f vector3f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, vector3f, vector3f2) == null) {
            float[] fArr = this.points;
            float f2 = fArr[1];
            float[] fArr2 = vector3f.points;
            vector3f2.setX((f2 * fArr2[2]) - (fArr[2] * fArr2[1]));
            float[] fArr3 = this.points;
            float f3 = fArr3[2];
            float[] fArr4 = vector3f.points;
            vector3f2.setY((f3 * fArr4[0]) - (fArr3[0] * fArr4[2]));
            float[] fArr5 = this.points;
            float f4 = fArr5[0];
            float[] fArr6 = vector3f.points;
            vector3f2.setZ((f4 * fArr6[1]) - (fArr5[1] * fArr6[0]));
        }
    }

    public float dotProduct(Vector3f vector3f) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, vector3f)) == null) {
            float[] fArr = this.points;
            float f2 = fArr[0];
            float[] fArr2 = vector3f.points;
            return (f2 * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]);
        }
        return invokeL.floatValue;
    }

    public float getLength() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            float[] fArr = this.points;
            return (float) Math.sqrt((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]));
        }
        return invokeV.floatValue;
    }

    public float getX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.points[0] : invokeV.floatValue;
    }

    public float getY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.points[1] : invokeV.floatValue;
    }

    public float getZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.points[2] : invokeV.floatValue;
    }

    public void multiplyByScalar(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            float[] fArr = this.points;
            fArr[0] = fArr[0] * f2;
            fArr[1] = fArr[1] * f2;
            fArr[2] = fArr[2] * f2;
        }
    }

    public void normalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            float[] fArr = this.points;
            double sqrt = Math.sqrt((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]));
            float[] fArr2 = this.points;
            fArr2[0] = (float) (fArr2[0] / sqrt);
            fArr2[1] = (float) (fArr2[1] / sqrt);
            fArr2[2] = (float) (fArr2[2] / sqrt);
        }
    }

    public void setX(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.points[0] = f2;
        }
    }

    public void setXYZ(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            float[] fArr = this.points;
            fArr[0] = f2;
            fArr[1] = f3;
            fArr[2] = f4;
        }
    }

    public void setY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f2) == null) {
            this.points[1] = f2;
        }
    }

    public void setZ(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.points[2] = f2;
        }
    }

    public void subtract(Vector3f vector3f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, vector3f) == null) {
            float[] fArr = this.points;
            float f2 = fArr[0];
            float[] fArr2 = vector3f.points;
            fArr[0] = f2 - fArr2[0];
            fArr[1] = fArr[1] - fArr2[1];
            fArr[2] = fArr[2] - fArr2[2];
        }
    }

    public float[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.points : (float[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return "X:" + this.points[0] + " Y:" + this.points[1] + " Z:" + this.points[2];
        }
        return (String) invokeV.objValue;
    }

    public float x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.points[0] : invokeV.floatValue;
    }

    public void x(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048597, this, f2) == null) {
            this.points[0] = f2;
        }
    }

    public float y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.points[1] : invokeV.floatValue;
    }

    public void y(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048599, this, f2) == null) {
            this.points[1] = f2;
        }
    }

    public float z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.points[2] : invokeV.floatValue;
    }

    public void z(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048601, this, f2) == null) {
            this.points[2] = f2;
        }
    }
}
