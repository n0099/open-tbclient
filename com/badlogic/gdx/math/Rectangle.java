package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import c.b.b.q.t;
import com.badlogic.gdx.utils.GdxRuntimeException;
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
/* loaded from: classes8.dex */
public class Rectangle implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 5733252015138115702L;
    public static final Rectangle tmp;
    public static final Rectangle tmp2;
    public transient /* synthetic */ FieldHolder $fh;
    public float height;
    public float width;
    public float x;
    public float y;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1093871389, "Lcom/badlogic/gdx/math/Rectangle;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1093871389, "Lcom/badlogic/gdx/math/Rectangle;");
                return;
            }
        }
        tmp = new Rectangle();
        tmp2 = new Rectangle();
    }

    public Rectangle() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public float area() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.width * this.height : invokeV.floatValue;
    }

    public boolean contains(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float f4 = this.x;
            if (f4 <= f2 && f4 + this.width >= f2) {
                float f5 = this.y;
                if (f5 <= f3 && f5 + this.height >= f3) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                Rectangle rectangle = (Rectangle) obj;
                return t.b(this.height) == t.b(rectangle.height) && t.b(this.width) == t.b(rectangle.width) && t.b(this.x) == t.b(rectangle.x) && t.b(this.y) == t.b(rectangle.y);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Rectangle fitInside(Rectangle rectangle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, rectangle)) == null) {
            float aspectRatio = getAspectRatio();
            if (aspectRatio < rectangle.getAspectRatio()) {
                float f2 = rectangle.height;
                setSize(aspectRatio * f2, f2);
            } else {
                float f3 = rectangle.width;
                setSize(f3, f3 / aspectRatio);
            }
            setPosition((rectangle.x + (rectangle.width / 2.0f)) - (this.width / 2.0f), (rectangle.y + (rectangle.height / 2.0f)) - (this.height / 2.0f));
            return this;
        }
        return (Rectangle) invokeL.objValue;
    }

    public Rectangle fitOutside(Rectangle rectangle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, rectangle)) == null) {
            float aspectRatio = getAspectRatio();
            if (aspectRatio > rectangle.getAspectRatio()) {
                float f2 = rectangle.height;
                setSize(aspectRatio * f2, f2);
            } else {
                float f3 = rectangle.width;
                setSize(f3, f3 / aspectRatio);
            }
            setPosition((rectangle.x + (rectangle.width / 2.0f)) - (this.width / 2.0f), (rectangle.y + (rectangle.height / 2.0f)) - (this.height / 2.0f));
            return this;
        }
        return (Rectangle) invokeL.objValue;
    }

    public Rectangle fromString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            int indexOf = str.indexOf(44, 1);
            int i2 = indexOf + 1;
            int indexOf2 = str.indexOf(44, i2);
            int i3 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i3);
            if (indexOf != -1 && indexOf2 != -1 && indexOf3 != -1 && str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']') {
                try {
                    return set(Float.parseFloat(str.substring(1, indexOf)), Float.parseFloat(str.substring(i2, indexOf2)), Float.parseFloat(str.substring(i3, indexOf3)), Float.parseFloat(str.substring(indexOf3 + 1, str.length() - 1)));
                } catch (NumberFormatException unused) {
                }
            }
            throw new GdxRuntimeException("Malformed Rectangle: " + str);
        }
        return (Rectangle) invokeL.objValue;
    }

    public float getAspectRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            float f2 = this.height;
            if (f2 == 0.0f) {
                return Float.NaN;
            }
            return this.width / f2;
        }
        return invokeV.floatValue;
    }

    public Vector2 getCenter(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, vector2)) == null) {
            vector2.x = this.x + (this.width / 2.0f);
            vector2.y = this.y + (this.height / 2.0f);
            return vector2;
        }
        return (Vector2) invokeL.objValue;
    }

    public float getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.height : invokeV.floatValue;
    }

    public Vector2 getPosition(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, vector2)) == null) ? vector2.set(this.x, this.y) : (Vector2) invokeL.objValue;
    }

    public Vector2 getSize(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, vector2)) == null) ? vector2.set(this.width, this.height) : (Vector2) invokeL.objValue;
    }

    public float getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.width : invokeV.floatValue;
    }

    public float getX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.x : invokeV.floatValue;
    }

    public float getY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.y : invokeV.floatValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? ((((((t.b(this.height) + 31) * 31) + t.b(this.width)) * 31) + t.b(this.x)) * 31) + t.b(this.y) : invokeV.intValue;
    }

    public Rectangle merge(Rectangle rectangle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, rectangle)) == null) {
            float min = Math.min(this.x, rectangle.x);
            float max = Math.max(this.x + this.width, rectangle.x + rectangle.width);
            this.x = min;
            this.width = max - min;
            float min2 = Math.min(this.y, rectangle.y);
            float max2 = Math.max(this.y + this.height, rectangle.y + rectangle.height);
            this.y = min2;
            this.height = max2 - min2;
            return this;
        }
        return (Rectangle) invokeL.objValue;
    }

    public boolean overlaps(Rectangle rectangle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, rectangle)) == null) {
            float f2 = this.x;
            float f3 = rectangle.x;
            if (f2 < rectangle.width + f3 && f2 + this.width > f3) {
                float f4 = this.y;
                float f5 = rectangle.y;
                if (f4 < rectangle.height + f5 && f4 + this.height > f5) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public float perimeter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.width + this.height) * 2.0f : invokeV.floatValue;
    }

    public Rectangle set(float f2, float f3, float f4, float f5) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)})) == null) {
            this.x = f2;
            this.y = f3;
            this.width = f4;
            this.height = f5;
            return this;
        }
        return (Rectangle) invokeCommon.objValue;
    }

    public Rectangle setCenter(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            setPosition(f2 - (this.width / 2.0f), f3 - (this.height / 2.0f));
            return this;
        }
        return (Rectangle) invokeCommon.objValue;
    }

    public Rectangle setHeight(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048604, this, f2)) == null) {
            this.height = f2;
            return this;
        }
        return (Rectangle) invokeF.objValue;
    }

    public Rectangle setPosition(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, vector2)) == null) {
            this.x = vector2.x;
            this.y = vector2.y;
            return this;
        }
        return (Rectangle) invokeL.objValue;
    }

    public Rectangle setSize(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.width = f2;
            this.height = f3;
            return this;
        }
        return (Rectangle) invokeCommon.objValue;
    }

    public Rectangle setWidth(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048609, this, f2)) == null) {
            this.width = f2;
            return this;
        }
        return (Rectangle) invokeF.objValue;
    }

    public Rectangle setX(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048610, this, f2)) == null) {
            this.x = f2;
            return this;
        }
        return (Rectangle) invokeF.objValue;
    }

    public Rectangle setY(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048611, this, f2)) == null) {
            this.y = f2;
            return this;
        }
        return (Rectangle) invokeF.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + this.x + "," + this.y + "," + this.width + "," + this.height + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public Rectangle(float f2, float f3, float f4, float f5) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.x = f2;
        this.y = f3;
        this.width = f4;
        this.height = f5;
    }

    public boolean contains(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vector2)) == null) ? contains(vector2.x, vector2.y) : invokeL.booleanValue;
    }

    public Rectangle setCenter(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, vector2)) == null) {
            setPosition(vector2.x - (this.width / 2.0f), vector2.y - (this.height / 2.0f));
            return this;
        }
        return (Rectangle) invokeL.objValue;
    }

    public boolean contains(Circle circle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, circle)) == null) {
            float f2 = circle.x;
            float f3 = circle.radius;
            float f4 = this.x;
            if (f2 - f3 >= f4 && f2 + f3 <= f4 + this.width) {
                float f5 = circle.y;
                float f6 = this.y;
                if (f5 - f3 >= f6 && f5 + f3 <= f6 + this.height) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Rectangle setPosition(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            this.x = f2;
            this.y = f3;
            return this;
        }
        return (Rectangle) invokeCommon.objValue;
    }

    public Rectangle setSize(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048607, this, f2)) == null) {
            this.width = f2;
            this.height = f2;
            return this;
        }
        return (Rectangle) invokeF.objValue;
    }

    public boolean contains(Rectangle rectangle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rectangle)) == null) {
            float f2 = rectangle.x;
            float f3 = rectangle.width + f2;
            float f4 = rectangle.y;
            float f5 = rectangle.height + f4;
            float f6 = this.x;
            if (f2 > f6) {
                float f7 = this.width;
                if (f2 < f6 + f7 && f3 > f6 && f3 < f6 + f7) {
                    float f8 = this.y;
                    if (f4 > f8) {
                        float f9 = this.height;
                        if (f4 < f8 + f9 && f5 > f8 && f5 < f8 + f9) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Rectangle set(Rectangle rectangle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048601, this, rectangle)) == null) {
            this.x = rectangle.x;
            this.y = rectangle.y;
            this.width = rectangle.width;
            this.height = rectangle.height;
            return this;
        }
        return (Rectangle) invokeL.objValue;
    }

    public Rectangle(Rectangle rectangle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rectangle};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.x = rectangle.x;
        this.y = rectangle.y;
        this.width = rectangle.width;
        this.height = rectangle.height;
    }

    public Rectangle merge(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            float min = Math.min(this.x, f2);
            float max = Math.max(this.x + this.width, f2);
            this.x = min;
            this.width = max - min;
            float min2 = Math.min(this.y, f3);
            float max2 = Math.max(this.y + this.height, f3);
            this.y = min2;
            this.height = max2 - min2;
            return this;
        }
        return (Rectangle) invokeCommon.objValue;
    }

    public Rectangle merge(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, vector2)) == null) ? merge(vector2.x, vector2.y) : (Rectangle) invokeL.objValue;
    }

    public Rectangle merge(Vector2[] vector2Arr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, vector2Arr)) == null) {
            float f2 = this.x;
            float f3 = this.width + f2;
            float f4 = this.y;
            float f5 = this.height + f4;
            for (Vector2 vector2 : vector2Arr) {
                f2 = Math.min(f2, vector2.x);
                f3 = Math.max(f3, vector2.x);
                f4 = Math.min(f4, vector2.y);
                f5 = Math.max(f5, vector2.y);
            }
            this.x = f2;
            this.width = f3 - f2;
            this.y = f4;
            this.height = f5 - f4;
            return this;
        }
        return (Rectangle) invokeL.objValue;
    }
}
