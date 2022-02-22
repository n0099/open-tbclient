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
public class Circle implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public float radius;
    public float x;
    public float y;

    public Circle() {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float f2 = this.radius;
            return f2 * f2 * 3.1415927f;
        }
        return invokeV.floatValue;
    }

    public float circumference() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.radius * 6.2831855f : invokeV.floatValue;
    }

    public boolean contains(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = this.x - f2;
            float f5 = this.y - f3;
            float f6 = (f4 * f4) + (f5 * f5);
            float f7 = this.radius;
            return f6 <= f7 * f7;
        }
        return invokeCommon.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj == null || obj.getClass() != Circle.class) {
                return false;
            }
            Circle circle = (Circle) obj;
            return this.x == circle.x && this.y == circle.y && this.radius == circle.radius;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? ((((t.b(this.radius) + 41) * 41) + t.b(this.x)) * 41) + t.b(this.y) : invokeV.intValue;
    }

    public boolean overlaps(Circle circle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, circle)) == null) {
            float f2 = this.x - circle.x;
            float f3 = this.y - circle.y;
            float f4 = (f2 * f2) + (f3 * f3);
            float f5 = this.radius + circle.radius;
            return f4 < f5 * f5;
        }
        return invokeL.booleanValue;
    }

    public void set(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.x = f2;
            this.y = f3;
            this.radius = f4;
        }
    }

    public void setPosition(Vector2 vector2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, vector2) == null) {
            this.x = vector2.x;
            this.y = vector2.y;
        }
    }

    public void setRadius(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f2) == null) {
            this.radius = f2;
        }
    }

    public void setX(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f2) == null) {
            this.x = f2;
        }
    }

    public void setY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f2) == null) {
            this.y = f2;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.x + "," + this.y + "," + this.radius;
        }
        return (String) invokeV.objValue;
    }

    public Circle(float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
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
        this.radius = f4;
    }

    public void setPosition(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.x = f2;
            this.y = f3;
        }
    }

    public boolean contains(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vector2)) == null) {
            float f2 = this.x - vector2.x;
            float f3 = this.y - vector2.y;
            float f4 = this.radius;
            return (f2 * f2) + (f3 * f3) <= f4 * f4;
        }
        return invokeL.booleanValue;
    }

    public void set(Vector2 vector2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048586, this, vector2, f2) == null) {
            this.x = vector2.x;
            this.y = vector2.y;
            this.radius = f2;
        }
    }

    public Circle(Vector2 vector2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector2, Float.valueOf(f2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.x = vector2.x;
        this.y = vector2.y;
        this.radius = f2;
    }

    public boolean contains(Circle circle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, circle)) == null) {
            float f2 = this.radius;
            float f3 = circle.radius;
            float f4 = f2 - f3;
            if (f4 < 0.0f) {
                return false;
            }
            float f5 = this.x - circle.x;
            float f6 = this.y - circle.y;
            float f7 = (f5 * f5) + (f6 * f6);
            float f8 = f2 + f3;
            return f4 * f4 >= f7 && f7 < f8 * f8;
        }
        return invokeL.booleanValue;
    }

    public void set(Circle circle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, circle) == null) {
            this.x = circle.x;
            this.y = circle.y;
            this.radius = circle.radius;
        }
    }

    public Circle(Circle circle) {
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
        this.radius = circle.radius;
    }

    public void set(Vector2 vector2, Vector2 vector22) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, vector2, vector22) == null) {
            float f2 = vector2.x;
            this.x = f2;
            float f3 = vector2.y;
            this.y = f3;
            this.radius = Vector2.len(f2 - vector22.x, f3 - vector22.y);
        }
    }

    public Circle(Vector2 vector2, Vector2 vector22) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector2, vector22};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        float f2 = vector2.x;
        this.x = f2;
        float f3 = vector2.y;
        this.y = f3;
        this.radius = Vector2.len(f2 - vector22.x, f3 - vector22.y);
    }
}
