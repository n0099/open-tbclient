package com.badlogic.gdx.math;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes3.dex */
public class GridPoint2 implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = -4019969926331717380L;
    public transient /* synthetic */ FieldHolder $fh;
    public int x;
    public int y;

    public GridPoint2() {
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

    public GridPoint2 add(GridPoint2 gridPoint2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gridPoint2)) == null) {
            this.x += gridPoint2.x;
            this.y += gridPoint2.y;
            return this;
        }
        return (GridPoint2) invokeL.objValue;
    }

    public GridPoint2 cpy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new GridPoint2(this) : (GridPoint2) invokeV.objValue;
    }

    public float dst(GridPoint2 gridPoint2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gridPoint2)) == null) {
            int i = gridPoint2.x - this.x;
            int i2 = gridPoint2.y - this.y;
            return (float) Math.sqrt((i * i) + (i2 * i2));
        }
        return invokeL.floatValue;
    }

    public float dst2(GridPoint2 gridPoint2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gridPoint2)) == null) {
            int i = gridPoint2.x - this.x;
            int i2 = gridPoint2.y - this.y;
            return (i * i) + (i2 * i2);
        }
        return invokeL.floatValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != GridPoint2.class) {
                return false;
            }
            GridPoint2 gridPoint2 = (GridPoint2) obj;
            return this.x == gridPoint2.x && this.y == gridPoint2.y;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? ((this.x + 53) * 53) + this.y : invokeV.intValue;
    }

    public GridPoint2 set(GridPoint2 gridPoint2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, gridPoint2)) == null) {
            this.x = gridPoint2.x;
            this.y = gridPoint2.y;
            return this;
        }
        return (GridPoint2) invokeL.objValue;
    }

    public GridPoint2 sub(GridPoint2 gridPoint2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, gridPoint2)) == null) {
            this.x -= gridPoint2.x;
            this.y -= gridPoint2.y;
            return this;
        }
        return (GridPoint2) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "(" + this.x + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.y + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }

    public GridPoint2(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.x = i;
        this.y = i2;
    }

    public GridPoint2 add(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048576, this, i, i2)) == null) {
            this.x += i;
            this.y += i2;
            return this;
        }
        return (GridPoint2) invokeII.objValue;
    }

    public float dst2(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048581, this, i, i2)) == null) {
            int i3 = i - this.x;
            int i4 = i2 - this.y;
            return (i3 * i3) + (i4 * i4);
        }
        return invokeII.floatValue;
    }

    public GridPoint2 set(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i, i2)) == null) {
            this.x = i;
            this.y = i2;
            return this;
        }
        return (GridPoint2) invokeII.objValue;
    }

    public GridPoint2 sub(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i, i2)) == null) {
            this.x -= i;
            this.y -= i2;
            return this;
        }
        return (GridPoint2) invokeII.objValue;
    }

    public float dst(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048579, this, i, i2)) == null) {
            int i3 = i - this.x;
            int i4 = i2 - this.y;
            return (float) Math.sqrt((i3 * i3) + (i4 * i4));
        }
        return invokeII.floatValue;
    }

    public GridPoint2(GridPoint2 gridPoint2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gridPoint2};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.x = gridPoint2.x;
        this.y = gridPoint2.y;
    }
}
