package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.n7;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes.dex */
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
            return ((this.width * this.height) * 3.1415927f) / 4.0f;
        }
        return invokeV.floatValue;
    }

    public Ellipse(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
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
        this.width = f3;
        this.height = f4;
    }

    public Ellipse(Circle circle) {
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
        float f = circle.radius;
        this.width = f * 2.0f;
        this.height = f * 2.0f;
    }

    public Ellipse(Ellipse ellipse) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {ellipse};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public Ellipse(Vector2 vector2, float f, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector2, Float.valueOf(f), Float.valueOf(f2)};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        this.x = vector2.x;
        this.y = vector2.y;
        this.width = f;
        this.height = f2;
    }

    public Ellipse(Vector2 vector2, Vector2 vector22) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {vector2, vector22};
            interceptable.invokeUnInit(65541, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public float circumference() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            float f = this.width / 2.0f;
            float f2 = this.height / 2.0f;
            float f3 = f * 3.0f;
            if (f3 <= f2 && f2 * 3.0f <= f) {
                return (float) (Math.sqrt(((f * f) + (f2 * f2)) / 2.0f) * 6.2831854820251465d);
            }
            return (float) ((((f + f2) * 3.0f) - Math.sqrt((f3 + f2) * (f + (f2 * 3.0f)))) * 3.1415927410125732d);
        }
        return invokeV.floatValue;
    }

    public boolean contains(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float f3 = f - this.x;
            float f4 = f2 - this.y;
            float f5 = this.width;
            float f6 = this.height;
            if (((f3 * f3) / (((f5 * 0.5f) * f5) * 0.5f)) + ((f4 * f4) / (((f6 * 0.5f) * f6) * 0.5f)) <= 1.0f) {
                return true;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean contains(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, vector2)) == null) {
            return contains(vector2.x, vector2.y);
        }
        return invokeL.booleanValue;
    }

    public void set(Circle circle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, circle) == null) {
            this.x = circle.x;
            this.y = circle.y;
            float f = circle.radius;
            this.width = f * 2.0f;
            this.height = f * 2.0f;
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
            if (this.x == ellipse.x && this.y == ellipse.y && this.width == ellipse.width && this.height == ellipse.height) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return ((((((n7.b(this.height) + 53) * 53) + n7.b(this.width)) * 53) + n7.b(this.x)) * 53) + n7.b(this.y);
        }
        return invokeV.intValue;
    }

    public void set(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
            this.x = f;
            this.y = f2;
            this.width = f3;
            this.height = f4;
        }
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

    public void set(Vector2 vector2, Vector2 vector22) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048585, this, vector2, vector22) == null) {
            this.x = vector2.x;
            this.y = vector2.y;
            this.width = vector22.x;
            this.height = vector22.y;
        }
    }

    public Ellipse setPosition(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.x = f;
            this.y = f2;
            return this;
        }
        return (Ellipse) invokeCommon.objValue;
    }

    public Ellipse setSize(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.width = f;
            this.height = f2;
            return this;
        }
        return (Ellipse) invokeCommon.objValue;
    }
}
