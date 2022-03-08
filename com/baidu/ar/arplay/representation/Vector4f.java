package com.baidu.ar.arplay.representation;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class Vector4f extends Renderable implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public float[] points;

    public Vector4f() {
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
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.points = fArr;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
    }

    public Vector4f(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.points = fArr;
        fArr[0] = f2;
        fArr[1] = f3;
        fArr[2] = f4;
        fArr[3] = f5;
    }

    public Vector4f(Vector3f vector3f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector3f, Float.valueOf(f2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        this.points = fArr;
        fArr[0] = vector3f.x();
        this.points[1] = vector3f.y();
        this.points[2] = vector3f.z();
        this.points[3] = f2;
    }

    public void add(Vector3f vector3f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048576, this, vector3f, f2) == null) {
            float[] fArr = this.points;
            fArr[0] = fArr[0] + vector3f.x();
            float[] fArr2 = this.points;
            fArr2[1] = fArr2[1] + vector3f.y();
            float[] fArr3 = this.points;
            fArr3[2] = fArr3[2] + vector3f.z();
            float[] fArr4 = this.points;
            fArr4[3] = fArr4[3] + f2;
        }
    }

    public void add(Vector4f vector4f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vector4f) == null) {
            float[] fArr = this.points;
            float f2 = fArr[0];
            float[] fArr2 = vector4f.points;
            fArr[0] = f2 + fArr2[0];
            fArr[1] = fArr[1] + fArr2[1];
            fArr[2] = fArr[2] + fArr2[2];
            fArr[3] = fArr[3] + fArr2[3];
        }
    }

    public boolean compareTo(Vector4f vector4f) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, vector4f)) == null) {
            float[] fArr = this.points;
            float f2 = fArr[0];
            float[] fArr2 = vector4f.points;
            return f2 == fArr2[0] && fArr[1] == fArr2[1] && fArr[2] == fArr2[2] && fArr[3] == fArr2[3];
        }
        return invokeL.booleanValue;
    }

    public void copyFromV3f(Vector3f vector3f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048579, this, vector3f, f2) == null) {
            this.points[0] = vector3f.x();
            this.points[1] = vector3f.y();
            this.points[2] = vector3f.z();
            this.points[3] = f2;
        }
    }

    public void copyVec4(Vector4f vector4f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, vector4f) == null) {
            float[] fArr = this.points;
            float[] fArr2 = vector4f.points;
            fArr[0] = fArr2[0];
            fArr[1] = fArr2[1];
            fArr[2] = fArr2[2];
            fArr[3] = fArr2[3];
        }
    }

    public float dotProduct(Vector4f vector4f) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, vector4f)) == null) {
            float[] fArr = this.points;
            float f2 = fArr[0];
            float[] fArr2 = vector4f.points;
            return (f2 * fArr2[0]) + (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]) + (fArr[3] * fArr2[3]);
        }
        return invokeL.floatValue;
    }

    public float getW() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.points[3] : invokeV.floatValue;
    }

    public float getX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.points[0] : invokeV.floatValue;
    }

    public float getY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.points[1] : invokeV.floatValue;
    }

    public float getZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.points[2] : invokeV.floatValue;
    }

    public void lerp(Vector4f vector4f, Vector4f vector4f2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{vector4f, vector4f2, Float.valueOf(f2)}) == null) {
            float[] fArr = vector4f2.points;
            float[] fArr2 = this.points;
            float f3 = 1.0f * f2;
            float[] fArr3 = vector4f.points;
            fArr[0] = (fArr2[0] * f3) + (fArr3[0] * f2);
            fArr[1] = (fArr2[1] * f3) + (fArr3[1] * f2);
            fArr[2] = (fArr2[2] * f3) + (fArr3[2] * f2);
            fArr[3] = (fArr2[3] * f3) + (fArr3[3] * f2);
        }
    }

    public void multiplyByScalar(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048587, this, f2) == null) {
            float[] fArr = this.points;
            fArr[0] = fArr[0] * f2;
            fArr[1] = fArr[1] * f2;
            fArr[2] = fArr[2] * f2;
            fArr[3] = fArr[3] * f2;
        }
    }

    public void normalize() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            float[] fArr = this.points;
            if (fArr[3] == 0.0f) {
                return;
            }
            fArr[0] = fArr[0] / fArr[3];
            fArr[1] = fArr[1] / fArr[3];
            fArr[2] = fArr[2] / fArr[3];
            double sqrt = Math.sqrt((fArr[0] * fArr[0]) + (fArr[1] * fArr[1]) + (fArr[2] * fArr[2]));
            float[] fArr2 = this.points;
            fArr2[0] = (float) (fArr2[0] / sqrt);
            fArr2[1] = (float) (fArr2[1] / sqrt);
            fArr2[2] = (float) (fArr2[2] / sqrt);
        }
    }

    public void setW(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048589, this, f2) == null) {
            this.points[3] = f2;
        }
    }

    public void setX(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            this.points[0] = f2;
        }
    }

    public void setXYZW(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            float[] fArr = this.points;
            fArr[0] = f2;
            fArr[1] = f3;
            fArr[2] = f4;
            fArr[3] = f5;
        }
    }

    public void setY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.points[1] = f2;
        }
    }

    public void setZ(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048593, this, f2) == null) {
            this.points[2] = f2;
        }
    }

    public void subdivide(Vector4f vector4f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, vector4f) == null) {
            float[] fArr = this.points;
            float f2 = fArr[0];
            float[] fArr2 = vector4f.points;
            fArr[0] = f2 / fArr2[0];
            fArr[1] = fArr[1] / fArr2[1];
            fArr[2] = fArr[2] / fArr2[2];
            fArr[3] = fArr[3] / fArr2[3];
        }
    }

    public void subtract(Vector4f vector4f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, vector4f) == null) {
            float[] fArr = this.points;
            float f2 = fArr[0];
            float[] fArr2 = vector4f.points;
            fArr[0] = f2 - fArr2[0];
            fArr[1] = fArr[1] - fArr2[1];
            fArr[2] = fArr[2] - fArr2[2];
            fArr[3] = fArr[3] - fArr2[3];
        }
    }

    public void subtract(Vector4f vector4f, Vector4f vector4f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048596, this, vector4f, vector4f2) == null) {
            float[] fArr = this.points;
            float f2 = fArr[0];
            float[] fArr2 = vector4f.points;
            vector4f2.setXYZW(f2 - fArr2[0], fArr[1] - fArr2[1], fArr[2] - fArr2[2], fArr[3] - fArr2[3]);
        }
    }

    public float[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.points : (float[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return "X:" + this.points[0] + " Y:" + this.points[1] + " Z:" + this.points[2] + " W:" + this.points[3];
        }
        return (String) invokeV.objValue;
    }

    public float w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.points[3] : invokeV.floatValue;
    }

    public void w(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048600, this, f2) == null) {
            this.points[3] = f2;
        }
    }

    public float x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.points[0] : invokeV.floatValue;
    }

    public void x(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048602, this, f2) == null) {
            this.points[0] = f2;
        }
    }

    public float y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.points[1] : invokeV.floatValue;
    }

    public void y(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048604, this, f2) == null) {
            this.points[1] = f2;
        }
    }

    public float z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.points[2] : invokeV.floatValue;
    }

    public void z(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048606, this, f2) == null) {
            this.points[2] = f2;
        }
    }
}
