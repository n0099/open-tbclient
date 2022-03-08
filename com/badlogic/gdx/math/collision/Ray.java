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
/* loaded from: classes3.dex */
public class Ray implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -620692054835390878L;
    public static Vector3 tmp;
    public transient /* synthetic */ FieldHolder $fh;
    public final Vector3 direction;
    public final Vector3 origin;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1560384197, "Lcom/badlogic/gdx/math/collision/Ray;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1560384197, "Lcom/badlogic/gdx/math/collision/Ray;");
                return;
            }
        }
        tmp = new Vector3();
    }

    public Ray() {
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
        this.origin = new Vector3();
        this.direction = new Vector3();
    }

    public Ray cpy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new Ray(this.origin, this.direction) : (Ray) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != Ray.class) {
                return false;
            }
            Ray ray = (Ray) obj;
            return this.direction.equals(ray.direction) && this.origin.equals(ray.origin);
        }
        return invokeL.booleanValue;
    }

    public Vector3 getEndPoint(Vector3 vector3, float f2) {
        InterceptResult invokeLF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLF = interceptable.invokeLF(Constants.METHOD_SEND_USER_MSG, this, vector3, f2)) == null) ? vector3.set(this.direction).m23scl(f2).add(this.origin) : (Vector3) invokeLF.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? ((this.direction.hashCode() + 73) * 73) + this.origin.hashCode() : invokeV.intValue;
    }

    public Ray mul(Matrix4 matrix4) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, matrix4)) == null) {
            tmp.set(this.origin).add(this.direction);
            tmp.mul(matrix4);
            this.origin.mul(matrix4);
            this.direction.set(tmp.sub(this.origin)).m22nor();
            return this;
        }
        return (Ray) invokeL.objValue;
    }

    public Ray set(Vector3 vector3, Vector3 vector32) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, vector3, vector32)) == null) {
            this.origin.set(vector3);
            this.direction.set(vector32).m22nor();
            return this;
        }
        return (Ray) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return "ray [" + this.origin + ":" + this.direction + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public Ray set(float f2, float f3, float f4, float f5, float f6, float f7) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048581, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Float.valueOf(f7)})) == null) {
            this.origin.set(f2, f3, f4);
            this.direction.set(f5, f6, f7).m22nor();
            return this;
        }
        return (Ray) invokeCommon.objValue;
    }

    public Ray(Vector3 vector3, Vector3 vector32) {
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
        this.origin = new Vector3();
        this.direction = new Vector3();
        this.origin.set(vector3);
        this.direction.set(vector32).m22nor();
    }

    public Ray set(Ray ray) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, ray)) == null) {
            this.origin.set(ray.origin);
            this.direction.set(ray.direction).m22nor();
            return this;
        }
        return (Ray) invokeL.objValue;
    }
}
