package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.t;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes10.dex */
public class Ellipse implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 7381533206532032099L;
    public transient /* synthetic */ FieldHolder $fh;
    public float height;
    public float width;
    public float x;
    public float y;

    public Ellipse() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public float area() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ((this.width * this.height) * 3.1415927f) / 4.0f : invokeV.floatValue;
    }

    public float circumference() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            float f2 = this.width / 2.0f;
            float f3 = this.height / 2.0f;
            float f4 = f2 * 3.0f;
            if (f4 <= f3 && f3 * 3.0f <= f2) {
                return (float) (Math.sqrt(((f2 * f2) + (f3 * f3)) / 2.0f) * 6.2831854820251465d);
            }
            return (float) ((((f2 + f3) * 3.0f) - Math.sqrt((f4 + f3) * (f2 + (f3 * 3.0f)))) * 3.1415927410125732d);
        }
        return invokeV.floatValue;
    }

    public boolean contains(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = f2 - this.x;
            float f5 = f3 - this.y;
            float f6 = this.width;
            float f7 = this.height;
            return ((f4 * f4) / (((f6 * 0.5f) * f6) * 0.5f)) + ((f5 * f5) / (((f7 * 0.5f) * f7) * 0.5f)) <= 1.0f;
        }
        return invokeCommon.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != Ellipse.class) {
                return false;
            }
            Ellipse ellipse = (Ellipse) obj;
            return this.x == ellipse.x && this.y == ellipse.y && this.width == ellipse.width && this.height == ellipse.height;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? ((((((t.b(this.height) + 53) * 53) + t.b(this.width)) * 53) + t.b(this.x)) * 53) + t.b(this.y) : invokeV.intValue;
    }

    public void set(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)}) == null) {
            this.x = f2;
            this.y = f3;
            this.width = f4;
            this.height = f5;
        }
    }

    public Ellipse setPosition(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, vector2)) == null) {
            this.x = vector2.x;
            this.y = vector2.y;
            return this;
        }
        return (Ellipse) invokeL.objValue;
    }

    public Ellipse setSize(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.width = f2;
            this.height = f3;
            return this;
        }
        return (Ellipse) invokeCommon.objValue;
    }

    public Ellipse(Ellipse ellipse) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ellipse};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.x = ellipse.x;
        this.y = ellipse.y;
        this.width = ellipse.width;
        this.height = ellipse.height;
    }

    public Ellipse setPosition(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.x = f2;
            this.y = f3;
            return this;
        }
        return (Ellipse) invokeCommon.objValue;
    }

    public boolean contains(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, vector2)) == null) ? contains(vector2.x, vector2.y) : invokeL.booleanValue;
    }

    public void set(Ellipse ellipse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ellipse) == null) {
            this.x = ellipse.x;
            this.y = ellipse.y;
            this.width = ellipse.width;
            this.height = ellipse.height;
        }
    }

    public Ellipse(float f2, float f3, float f4, float f5) {
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
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
    }

    public void set(Circle circle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, circle) == null) {
            this.x = circle.x;
            this.y = circle.y;
            float f2 = circle.radius;
            this.width = f2 * 2.0f;
            this.height = f2 * 2.0f;
        }
    }

    public Ellipse(Vector2 vector2, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector2, Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.x = vector2.x;
        this.y = vector2.y;
        this.width = f2;
        this.height = f3;
    }

    public void set(Vector2 vector2, Vector2 vector22) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, vector2, vector22) == null) {
            this.x = vector2.x;
            this.y = vector2.y;
            this.width = vector22.x;
            this.height = vector22.y;
        }
    }

    public Ellipse(Vector2 vector2, Vector2 vector22) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector2, vector22};
            interceptable.invokeUnInit(65541, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65541, newInitContext);
                return;
            }
        }
        this.x = vector2.x;
        this.y = vector2.y;
        this.width = vector22.x;
        this.height = vector22.y;
    }

    public Ellipse(Circle circle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {circle};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.x = circle.x;
        this.y = circle.y;
        float f2 = circle.radius;
        this.width = f2 * 2.0f;
        this.height = f2 * 2.0f;
    }
}
