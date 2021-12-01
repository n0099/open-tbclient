package com.badlogic.gdx.math.collision;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Vector3;
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
import java.util.List;
/* loaded from: classes8.dex */
public class BoundingBox implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -1286036817192127343L;
    public static final Vector3 tmpVector;
    public transient /* synthetic */ FieldHolder $fh;
    public final Vector3 cnt;
    public final Vector3 dim;
    public final Vector3 max;
    public final Vector3 min;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1438700808, "Lcom/badlogic/gdx/math/collision/BoundingBox;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1438700808, "Lcom/badlogic/gdx/math/collision/BoundingBox;");
                return;
            }
        }
        tmpVector = new Vector3();
    }

    public BoundingBox() {
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
        this.min = new Vector3();
        this.max = new Vector3();
        this.cnt = new Vector3();
        this.dim = new Vector3();
        clr();
    }

    public static final float max(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? f2 > f3 ? f2 : f3 : invokeCommon.floatValue;
    }

    public static final float min(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65541, null, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) ? f2 > f3 ? f3 : f2 : invokeCommon.floatValue;
    }

    public BoundingBox clr() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? set(this.min.set(0.0f, 0.0f, 0.0f), this.max.set(0.0f, 0.0f, 0.0f)) : (BoundingBox) invokeV.objValue;
    }

    public boolean contains(BoundingBox boundingBox) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, boundingBox)) == null) {
            if (isValid()) {
                Vector3 vector3 = this.min;
                float f2 = vector3.x;
                Vector3 vector32 = boundingBox.min;
                if (f2 <= vector32.x && vector3.y <= vector32.y && vector3.z <= vector32.z) {
                    Vector3 vector33 = this.max;
                    float f3 = vector33.x;
                    Vector3 vector34 = boundingBox.max;
                    if (f3 < vector34.x || vector33.y < vector34.y || vector33.z < vector34.z) {
                    }
                }
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public BoundingBox ext(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vector3)) == null) {
            Vector3 vector32 = this.min;
            Vector3 vector33 = vector32.set(min(vector32.x, vector3.x), min(this.min.y, vector3.y), min(this.min.z, vector3.z));
            Vector3 vector34 = this.max;
            return set(vector33, vector34.set(Math.max(vector34.x, vector3.x), Math.max(this.max.y, vector3.y), Math.max(this.max.z, vector3.z)));
        }
        return (BoundingBox) invokeL.objValue;
    }

    public Vector3 getCenter(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, vector3)) == null) ? vector3.set(this.cnt) : (Vector3) invokeL.objValue;
    }

    public float getCenterX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.cnt.x : invokeV.floatValue;
    }

    public float getCenterY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.cnt.y : invokeV.floatValue;
    }

    public float getCenterZ() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.cnt.z : invokeV.floatValue;
    }

    public Vector3 getCorner000(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, vector3)) == null) {
            Vector3 vector32 = this.min;
            return vector3.set(vector32.x, vector32.y, vector32.z);
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3 getCorner001(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, vector3)) == null) {
            Vector3 vector32 = this.min;
            return vector3.set(vector32.x, vector32.y, this.max.z);
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3 getCorner010(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, vector3)) == null) {
            Vector3 vector32 = this.min;
            return vector3.set(vector32.x, this.max.y, vector32.z);
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3 getCorner011(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, vector3)) == null) {
            float f2 = this.min.x;
            Vector3 vector32 = this.max;
            return vector3.set(f2, vector32.y, vector32.z);
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3 getCorner100(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, vector3)) == null) {
            float f2 = this.max.x;
            Vector3 vector32 = this.min;
            return vector3.set(f2, vector32.y, vector32.z);
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3 getCorner101(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, vector3)) == null) {
            Vector3 vector32 = this.max;
            return vector3.set(vector32.x, this.min.y, vector32.z);
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3 getCorner110(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, vector3)) == null) {
            Vector3 vector32 = this.max;
            return vector3.set(vector32.x, vector32.y, this.min.z);
        }
        return (Vector3) invokeL.objValue;
    }

    public Vector3 getCorner111(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, vector3)) == null) {
            Vector3 vector32 = this.max;
            return vector3.set(vector32.x, vector32.y, vector32.z);
        }
        return (Vector3) invokeL.objValue;
    }

    public float getDepth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.dim.z : invokeV.floatValue;
    }

    public Vector3 getDimensions(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, vector3)) == null) ? vector3.set(this.dim) : (Vector3) invokeL.objValue;
    }

    public float getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.dim.y : invokeV.floatValue;
    }

    public Vector3 getMax(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, vector3)) == null) ? vector3.set(this.max) : (Vector3) invokeL.objValue;
    }

    public Vector3 getMin(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, vector3)) == null) ? vector3.set(this.min) : (Vector3) invokeL.objValue;
    }

    public float getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.dim.x : invokeV.floatValue;
    }

    public BoundingBox inf() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            this.min.set(Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY, Float.POSITIVE_INFINITY);
            this.max.set(Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NEGATIVE_INFINITY);
            this.cnt.set(0.0f, 0.0f, 0.0f);
            this.dim.set(0.0f, 0.0f, 0.0f);
            return this;
        }
        return (BoundingBox) invokeV.objValue;
    }

    public boolean intersects(BoundingBox boundingBox) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, boundingBox)) == null) {
            if (isValid()) {
                return Math.abs(this.cnt.x - boundingBox.cnt.x) <= (this.dim.x / 2.0f) + (boundingBox.dim.x / 2.0f) && Math.abs(this.cnt.y - boundingBox.cnt.y) <= (this.dim.y / 2.0f) + (boundingBox.dim.y / 2.0f) && Math.abs(this.cnt.z - boundingBox.cnt.z) <= (this.dim.z / 2.0f) + (boundingBox.dim.z / 2.0f);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isValid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            Vector3 vector3 = this.min;
            float f2 = vector3.x;
            Vector3 vector32 = this.max;
            return f2 <= vector32.x && vector3.y <= vector32.y && vector3.z <= vector32.z;
        }
        return invokeV.booleanValue;
    }

    public BoundingBox mul(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, matrix4)) == null) {
            Vector3 vector3 = this.min;
            float f2 = vector3.x;
            float f3 = vector3.y;
            float f4 = vector3.z;
            Vector3 vector32 = this.max;
            float f5 = vector32.x;
            float f6 = vector32.y;
            float f7 = vector32.z;
            inf();
            ext(tmpVector.set(f2, f3, f4).mul(matrix4));
            ext(tmpVector.set(f2, f3, f7).mul(matrix4));
            ext(tmpVector.set(f2, f6, f4).mul(matrix4));
            ext(tmpVector.set(f2, f6, f7).mul(matrix4));
            ext(tmpVector.set(f5, f3, f4).mul(matrix4));
            ext(tmpVector.set(f5, f3, f7).mul(matrix4));
            ext(tmpVector.set(f5, f6, f4).mul(matrix4));
            ext(tmpVector.set(f5, f6, f7).mul(matrix4));
            return this;
        }
        return (BoundingBox) invokeL.objValue;
    }

    public BoundingBox set(BoundingBox boundingBox) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048607, this, boundingBox)) == null) ? set(boundingBox.min, boundingBox.max) : (BoundingBox) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + this.min + "|" + this.max + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public boolean contains(Vector3 vector3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vector3)) == null) {
            Vector3 vector32 = this.min;
            float f2 = vector32.x;
            float f3 = vector3.x;
            if (f2 <= f3) {
                Vector3 vector33 = this.max;
                if (vector33.x >= f3) {
                    float f4 = vector32.y;
                    float f5 = vector3.y;
                    if (f4 <= f5 && vector33.y >= f5) {
                        float f6 = vector32.z;
                        float f7 = vector3.z;
                        if (f6 <= f7 && vector33.z >= f7) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public BoundingBox set(Vector3 vector3, Vector3 vector32) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048606, this, vector3, vector32)) == null) {
            Vector3 vector33 = this.min;
            float f2 = vector3.x;
            float f3 = vector32.x;
            if (f2 >= f3) {
                f2 = f3;
            }
            float f4 = vector3.y;
            float f5 = vector32.y;
            if (f4 >= f5) {
                f4 = f5;
            }
            float f6 = vector3.z;
            float f7 = vector32.z;
            if (f6 >= f7) {
                f6 = f7;
            }
            vector33.set(f2, f4, f6);
            Vector3 vector34 = this.max;
            float f8 = vector3.x;
            float f9 = vector32.x;
            if (f8 <= f9) {
                f8 = f9;
            }
            float f10 = vector3.y;
            float f11 = vector32.y;
            if (f10 <= f11) {
                f10 = f11;
            }
            float f12 = vector3.z;
            float f13 = vector32.z;
            if (f12 <= f13) {
                f12 = f13;
            }
            vector34.set(f8, f10, f12);
            this.cnt.set(this.min).add(this.max).m23scl(0.5f);
            this.dim.set(this.max).sub(this.min);
            return this;
        }
        return (BoundingBox) invokeLL.objValue;
    }

    public BoundingBox ext(BoundingBox boundingBox) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, boundingBox)) == null) {
            Vector3 vector3 = this.min;
            Vector3 vector32 = vector3.set(min(vector3.x, boundingBox.min.x), min(this.min.y, boundingBox.min.y), min(this.min.z, boundingBox.min.z));
            Vector3 vector33 = this.max;
            return set(vector32, vector33.set(max(vector33.x, boundingBox.max.x), max(this.max.y, boundingBox.max.y), max(this.max.z, boundingBox.max.z)));
        }
        return (BoundingBox) invokeL.objValue;
    }

    public BoundingBox set(Vector3[] vector3Arr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048609, this, vector3Arr)) == null) {
            inf();
            for (Vector3 vector3 : vector3Arr) {
                ext(vector3);
            }
            return this;
        }
        return (BoundingBox) invokeL.objValue;
    }

    public BoundingBox(BoundingBox boundingBox) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {boundingBox};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.min = new Vector3();
        this.max = new Vector3();
        this.cnt = new Vector3();
        this.dim = new Vector3();
        set(boundingBox);
    }

    public BoundingBox ext(Vector3 vector3, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLF = interceptable.invokeLF(1048581, this, vector3, f2)) == null) {
            Vector3 vector32 = this.min;
            Vector3 vector33 = vector32.set(min(vector32.x, vector3.x - f2), min(this.min.y, vector3.y - f2), min(this.min.z, vector3.z - f2));
            Vector3 vector34 = this.max;
            return set(vector33, vector34.set(max(vector34.x, vector3.x + f2), max(this.max.y, vector3.y + f2), max(this.max.z, vector3.z + f2)));
        }
        return (BoundingBox) invokeLF.objValue;
    }

    public BoundingBox set(List<Vector3> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048608, this, list)) == null) {
            inf();
            for (Vector3 vector3 : list) {
                ext(vector3);
            }
            return this;
        }
        return (BoundingBox) invokeL.objValue;
    }

    public BoundingBox ext(BoundingBox boundingBox, Matrix4 matrix4) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048583, this, boundingBox, matrix4)) == null) {
            Vector3 vector3 = tmpVector;
            Vector3 vector32 = boundingBox.min;
            ext(vector3.set(vector32.x, vector32.y, vector32.z).mul(matrix4));
            Vector3 vector33 = tmpVector;
            Vector3 vector34 = boundingBox.min;
            ext(vector33.set(vector34.x, vector34.y, boundingBox.max.z).mul(matrix4));
            Vector3 vector35 = tmpVector;
            Vector3 vector36 = boundingBox.min;
            ext(vector35.set(vector36.x, boundingBox.max.y, vector36.z).mul(matrix4));
            Vector3 vector37 = tmpVector;
            float f2 = boundingBox.min.x;
            Vector3 vector38 = boundingBox.max;
            ext(vector37.set(f2, vector38.y, vector38.z).mul(matrix4));
            Vector3 vector39 = tmpVector;
            float f3 = boundingBox.max.x;
            Vector3 vector310 = boundingBox.min;
            ext(vector39.set(f3, vector310.y, vector310.z).mul(matrix4));
            Vector3 vector311 = tmpVector;
            Vector3 vector312 = boundingBox.max;
            ext(vector311.set(vector312.x, boundingBox.min.y, vector312.z).mul(matrix4));
            Vector3 vector313 = tmpVector;
            Vector3 vector314 = boundingBox.max;
            ext(vector313.set(vector314.x, vector314.y, boundingBox.min.z).mul(matrix4));
            Vector3 vector315 = tmpVector;
            Vector3 vector316 = boundingBox.max;
            ext(vector315.set(vector316.x, vector316.y, vector316.z).mul(matrix4));
            return this;
        }
        return (BoundingBox) invokeLL.objValue;
    }

    public BoundingBox(Vector3 vector3, Vector3 vector32) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector3, vector32};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.min = new Vector3();
        this.max = new Vector3();
        this.cnt = new Vector3();
        this.dim = new Vector3();
        set(vector3, vector32);
    }

    public BoundingBox ext(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            Vector3 vector3 = this.min;
            Vector3 vector32 = vector3.set(min(vector3.x, f2), min(this.min.y, f3), min(this.min.z, f4));
            Vector3 vector33 = this.max;
            return set(vector32, vector33.set(max(vector33.x, f2), max(this.max.y, f3), max(this.max.z, f4)));
        }
        return (BoundingBox) invokeCommon.objValue;
    }
}
