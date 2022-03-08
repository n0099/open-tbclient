package com.badlogic.gdx.math.collision;

import c.b.b.q.t;
import com.badlogic.gdx.math.Vector3;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class Sphere implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float PI_4_3 = 4.1887903f;
    public static final long serialVersionUID = -6487336868908521596L;
    public transient /* synthetic */ FieldHolder $fh;
    public final Vector3 center;
    public float radius;

    public Sphere(Vector3 vector3, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector3, Float.valueOf(f2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.center = new Vector3(vector3);
        this.radius = f2;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != Sphere.class) {
                return false;
            }
            Sphere sphere = (Sphere) obj;
            return this.radius == sphere.radius && this.center.equals(sphere.center);
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ((this.center.hashCode() + 71) * 71) + t.b(this.radius) : invokeV.intValue;
    }

    public boolean overlaps(Sphere sphere) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sphere)) == null) {
            float dst2 = this.center.dst2(sphere.center);
            float f2 = this.radius;
            float f3 = sphere.radius;
            return dst2 < (f2 + f3) * (f2 + f3);
        }
        return invokeL.booleanValue;
    }

    public float surfaceArea() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            float f2 = this.radius;
            return 12.566371f * f2 * f2;
        }
        return invokeV.floatValue;
    }

    public float volume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float f2 = this.radius;
            return 4.1887903f * f2 * f2 * f2;
        }
        return invokeV.floatValue;
    }
}
