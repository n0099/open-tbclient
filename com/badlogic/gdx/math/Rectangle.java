package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import com.badlogic.gdx.utils.GdxRuntimeException;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.h7;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes.dex */
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public float area() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.width * this.height;
        }
        return invokeV.floatValue;
    }

    public float getAspectRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            float f = this.height;
            if (f == 0.0f) {
                return Float.NaN;
            }
            return this.width / f;
        }
        return invokeV.floatValue;
    }

    public float getHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.height;
        }
        return invokeV.floatValue;
    }

    public float getWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return this.width;
        }
        return invokeV.floatValue;
    }

    public float getX() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return this.x;
        }
        return invokeV.floatValue;
    }

    public float getY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.y;
        }
        return invokeV.floatValue;
    }

    public float perimeter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return (this.width + this.height) * 2.0f;
        }
        return invokeV.floatValue;
    }

    public Rectangle(float f, float f2, float f3, float f4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    public Rectangle(Rectangle rectangle) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rectangle};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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

    public boolean contains(Circle circle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, circle)) == null) {
            float f = circle.x;
            float f2 = circle.radius;
            float f3 = this.x;
            if (f - f2 >= f3 && f + f2 <= f3 + this.width) {
                float f4 = circle.y;
                float f5 = this.y;
                if (f4 - f2 >= f5 && f4 + f2 <= f5 + this.height) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean overlaps(Rectangle rectangle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, rectangle)) == null) {
            float f = this.x;
            float f2 = rectangle.x;
            if (f < rectangle.width + f2 && f + this.width > f2) {
                float f3 = this.y;
                float f4 = rectangle.y;
                if (f3 < rectangle.height + f4 && f3 + this.height > f4) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean contains(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float f3 = this.x;
            if (f3 <= f && f3 + this.width >= f) {
                float f4 = this.y;
                if (f4 <= f2 && f4 + this.height >= f2) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public Rectangle setCenter(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048602, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            setPosition(f - (this.width / 2.0f), f2 - (this.height / 2.0f));
            return this;
        }
        return (Rectangle) invokeCommon.objValue;
    }

    public boolean contains(Rectangle rectangle) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, rectangle)) == null) {
            float f = rectangle.x;
            float f2 = rectangle.width + f;
            float f3 = rectangle.y;
            float f4 = rectangle.height + f3;
            float f5 = this.x;
            if (f > f5) {
                float f6 = this.width;
                if (f < f5 + f6 && f2 > f5 && f2 < f5 + f6) {
                    float f7 = this.y;
                    if (f3 > f7) {
                        float f8 = this.height;
                        if (f3 < f7 + f8 && f4 > f7 && f4 < f7 + f8) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Rectangle rectangle = (Rectangle) obj;
            if (h7.b(this.height) == h7.b(rectangle.height) && h7.b(this.width) == h7.b(rectangle.width) && h7.b(this.x) == h7.b(rectangle.x) && h7.b(this.y) == h7.b(rectangle.y)) {
                return true;
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
                float f = rectangle.height;
                setSize(aspectRatio * f, f);
            } else {
                float f2 = rectangle.width;
                setSize(f2, f2 / aspectRatio);
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
                float f = rectangle.height;
                setSize(aspectRatio * f, f);
            } else {
                float f2 = rectangle.width;
                setSize(f2, f2 / aspectRatio);
            }
            setPosition((rectangle.x + (rectangle.width / 2.0f)) - (this.width / 2.0f), (rectangle.y + (rectangle.height / 2.0f)) - (this.height / 2.0f));
            return this;
        }
        return (Rectangle) invokeL.objValue;
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

    public boolean contains(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, vector2)) == null) {
            return contains(vector2.x, vector2.y);
        }
        return invokeL.booleanValue;
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

    public Vector2 getPosition(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, vector2)) == null) {
            return vector2.set(this.x, this.y);
        }
        return (Vector2) invokeL.objValue;
    }

    public Vector2 getSize(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, vector2)) == null) {
            return vector2.set(this.width, this.height);
        }
        return (Vector2) invokeL.objValue;
    }

    public Rectangle merge(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, vector2)) == null) {
            return merge(vector2.x, vector2.y);
        }
        return (Rectangle) invokeL.objValue;
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

    public Rectangle setCenter(Vector2 vector2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, vector2)) == null) {
            setPosition(vector2.x - (this.width / 2.0f), vector2.y - (this.height / 2.0f));
            return this;
        }
        return (Rectangle) invokeL.objValue;
    }

    public Rectangle setHeight(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048604, this, f)) == null) {
            this.height = f;
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

    public Rectangle setSize(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048607, this, f)) == null) {
            this.width = f;
            this.height = f;
            return this;
        }
        return (Rectangle) invokeF.objValue;
    }

    public Rectangle setWidth(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048609, this, f)) == null) {
            this.width = f;
            return this;
        }
        return (Rectangle) invokeF.objValue;
    }

    public Rectangle setX(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048610, this, f)) == null) {
            this.x = f;
            return this;
        }
        return (Rectangle) invokeF.objValue;
    }

    public Rectangle setY(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048611, this, f)) == null) {
            this.y = f;
            return this;
        }
        return (Rectangle) invokeF.objValue;
    }

    public Rectangle fromString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            int indexOf = str.indexOf(44, 1);
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(44, i);
            int i2 = indexOf2 + 1;
            int indexOf3 = str.indexOf(44, i2);
            if (indexOf != -1 && indexOf2 != -1 && indexOf3 != -1 && str.charAt(0) == '[' && str.charAt(str.length() - 1) == ']') {
                try {
                    return set(Float.parseFloat(str.substring(1, indexOf)), Float.parseFloat(str.substring(i, indexOf2)), Float.parseFloat(str.substring(i2, indexOf3)), Float.parseFloat(str.substring(indexOf3 + 1, str.length() - 1)));
                } catch (NumberFormatException unused) {
                }
            }
            throw new GdxRuntimeException("Malformed Rectangle: " + str);
        }
        return (Rectangle) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return ((((((h7.b(this.height) + 31) * 31) + h7.b(this.width)) * 31) + h7.b(this.x)) * 31) + h7.b(this.y);
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return PreferencesUtil.LEFT_MOUNT + this.x + "," + this.y + "," + this.width + "," + this.height + PreferencesUtil.RIGHT_MOUNT;
        }
        return (String) invokeV.objValue;
    }

    public Rectangle merge(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            float min = Math.min(this.x, f);
            float max = Math.max(this.x + this.width, f);
            this.x = min;
            this.width = max - min;
            float min2 = Math.min(this.y, f2);
            float max2 = Math.max(this.y + this.height, f2);
            this.y = min2;
            this.height = max2 - min2;
            return this;
        }
        return (Rectangle) invokeCommon.objValue;
    }

    public Rectangle merge(Vector2[] vector2Arr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, vector2Arr)) == null) {
            float f = this.x;
            float f2 = this.width + f;
            float f3 = this.y;
            float f4 = this.height + f3;
            for (Vector2 vector2 : vector2Arr) {
                f = Math.min(f, vector2.x);
                f2 = Math.max(f2, vector2.x);
                f3 = Math.min(f3, vector2.y);
                f4 = Math.max(f4, vector2.y);
            }
            this.x = f;
            this.width = f2 - f;
            this.y = f3;
            this.height = f4 - f3;
            return this;
        }
        return (Rectangle) invokeL.objValue;
    }

    public Rectangle set(float f, float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048600, this, new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            this.x = f;
            this.y = f2;
            this.width = f3;
            this.height = f4;
            return this;
        }
        return (Rectangle) invokeCommon.objValue;
    }

    public Rectangle setPosition(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048605, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.x = f;
            this.y = f2;
            return this;
        }
        return (Rectangle) invokeCommon.objValue;
    }

    public Rectangle setSize(float f, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048608, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)})) == null) {
            this.width = f;
            this.height = f2;
            return this;
        }
        return (Rectangle) invokeCommon.objValue;
    }
}
