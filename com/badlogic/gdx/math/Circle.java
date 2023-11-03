package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.p3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public float area() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float f = this.radius;
            return f * f * 3.1415927f;
        }
        return invokeV.floatValue;
    }

    public float circumference() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.radius * 6.2831855f;
        }
        return invokeV.floatValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return ((((p3.b(this.radius) + 41) * 41) + p3.b(this.x)) * 41) + p3.b(this.y);
        }
        return invokeV.intValue;
    }

    public Circle(float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.x = f;
        this.y = f2;
        this.radius = f3;
    }

    public Circle(Circle circle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {circle};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.x = circle.x;
        this.y = circle.y;
        this.radius = circle.radius;
    }

    public boolean contains(Circle circle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, circle)) == null) {
            float f = this.radius;
            float f2 = circle.radius;
            float f3 = f - f2;
            if (f3 < 0.0f) {
                return false;
            }
            float f4 = this.x - circle.x;
            float f5 = this.y - circle.y;
            float f6 = (f4 * f4) + (f5 * f5);
            float f7 = f + f2;
            if (f3 * f3 < f6 || f6 >= f7 * f7) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
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
            if (this.x == circle.x && this.y == circle.y && this.radius == circle.radius) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Circle(Vector2 vector2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector2, Float.valueOf(f)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.x = vector2.x;
        this.y = vector2.y;
        this.radius = f;
    }

    public boolean contains(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float f3 = this.x - f;
            float f4 = this.y - f2;
            float f5 = (f3 * f3) + (f4 * f4);
            float f6 = this.radius;
            if (f5 <= f6 * f6) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public Circle(Vector2 vector2, Vector2 vector22) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector2, vector22};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        float f = vector2.x;
        this.x = f;
        float f2 = vector2.y;
        this.y = f2;
        this.radius = Vector2.len(f - vector22.x, f2 - vector22.y);
    }

    public boolean contains(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vector2)) == null) {
            float f = this.x - vector2.x;
            float f2 = this.y - vector2.y;
            float f3 = this.radius;
            if ((f * f) + (f2 * f2) <= f3 * f3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean overlaps(Circle circle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, circle)) == null) {
            float f = this.x - circle.x;
            float f2 = this.y - circle.y;
            float f3 = (f * f) + (f2 * f2);
            float f4 = this.radius + circle.radius;
            if (f3 < f4 * f4) {
                return true;
            }
            return false;
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

    public void setPosition(Vector2 vector2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, vector2) == null) {
            this.x = vector2.x;
            this.y = vector2.y;
        }
    }

    public void setRadius(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048590, this, f) == null) {
            this.radius = f;
        }
    }

    public void setX(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048591, this, f) == null) {
            this.x = f;
        }
    }

    public void setY(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048592, this, f) == null) {
            this.y = f;
        }
    }

    public void set(float f, float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.x = f;
            this.y = f2;
            this.radius = f3;
        }
    }

    public void set(Vector2 vector2, float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLF(1048586, this, vector2, f) == null) {
            this.x = vector2.x;
            this.y = vector2.y;
            this.radius = f;
        }
    }

    public void setPosition(float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            this.x = f;
            this.y = f2;
        }
    }

    public void set(Vector2 vector2, Vector2 vector22) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, vector2, vector22) == null) {
            float f = vector2.x;
            this.x = f;
            float f2 = vector2.y;
            this.y = f2;
            this.radius = Vector2.len(f - vector22.x, f2 - vector22.y);
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
}
