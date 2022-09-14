package com.badlogic.gdx.math.collision;

import com.badlogic.gdx.math.Vector3;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.u7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes.dex */
public class Sphere implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float PI_4_3 = 4.1887903f;
    public static final long serialVersionUID = -6487336868908521596L;
    public transient /* synthetic */ FieldHolder $fh;
    public final Vector3 center;
    public float radius;

    public Sphere(Vector3 vector3, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector3, Float.valueOf(f)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.center = new Vector3(vector3);
        this.radius = f;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? ((this.center.hashCode() + 71) * 71) + u7.b(this.radius) : invokeV.intValue;
    }

    public boolean overlaps(Sphere sphere) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, sphere)) == null) {
            float dst2 = this.center.dst2(sphere.center);
            float f = this.radius;
            float f2 = sphere.radius;
            return dst2 < (f + f2) * (f + f2);
        }
        return invokeL.booleanValue;
    }

    public float surfaceArea() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            float f = this.radius;
            return 12.566371f * f * f;
        }
        return invokeV.floatValue;
    }

    public float volume() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            float f = this.radius;
            return 4.1887903f * f * f * f;
        }
        return invokeV.floatValue;
    }
}
