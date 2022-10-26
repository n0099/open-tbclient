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
/* loaded from: classes.dex */
public class GridPoint3 implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final long serialVersionUID = 5922187982746752830L;
    public transient /* synthetic */ FieldHolder $fh;
    public int x;
    public int y;
    public int z;

    public GridPoint3() {
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

    public GridPoint3 cpy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return new GridPoint3(this);
        }
        return (GridPoint3) invokeV.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return ((((this.x + 17) * 17) + this.y) * 17) + this.z;
        }
        return invokeV.intValue;
    }

    public GridPoint3(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.x = i;
        this.y = i2;
        this.z = i3;
    }

    public GridPoint3(GridPoint3 gridPoint3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gridPoint3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.x = gridPoint3.x;
        this.y = gridPoint3.y;
        this.z = gridPoint3.z;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != GridPoint3.class) {
                return false;
            }
            GridPoint3 gridPoint3 = (GridPoint3) obj;
            if (this.x == gridPoint3.x && this.y == gridPoint3.y && this.z == gridPoint3.z) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public GridPoint3 add(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i, i2, i3)) == null) {
            this.x += i;
            this.y += i2;
            this.z += i3;
            return this;
        }
        return (GridPoint3) invokeIII.objValue;
    }

    public float dst(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048579, this, i, i2, i3)) == null) {
            int i4 = i - this.x;
            int i5 = i2 - this.y;
            int i6 = i3 - this.z;
            return (float) Math.sqrt((i4 * i4) + (i5 * i5) + (i6 * i6));
        }
        return invokeIII.floatValue;
    }

    public float dst2(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048581, this, i, i2, i3)) == null) {
            int i4 = i - this.x;
            int i5 = i2 - this.y;
            int i6 = i3 - this.z;
            return (i4 * i4) + (i5 * i5) + (i6 * i6);
        }
        return invokeIII.floatValue;
    }

    public GridPoint3 set(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i, i2, i3)) == null) {
            this.x = i;
            this.y = i2;
            this.z = i3;
            return this;
        }
        return (GridPoint3) invokeIII.objValue;
    }

    public GridPoint3 sub(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048587, this, i, i2, i3)) == null) {
            this.x -= i;
            this.y -= i2;
            this.z -= i3;
            return this;
        }
        return (GridPoint3) invokeIII.objValue;
    }

    public GridPoint3 add(GridPoint3 gridPoint3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gridPoint3)) == null) {
            this.x += gridPoint3.x;
            this.y += gridPoint3.y;
            this.z += gridPoint3.z;
            return this;
        }
        return (GridPoint3) invokeL.objValue;
    }

    public float dst(GridPoint3 gridPoint3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gridPoint3)) == null) {
            int i = gridPoint3.x - this.x;
            int i2 = gridPoint3.y - this.y;
            int i3 = gridPoint3.z - this.z;
            return (float) Math.sqrt((i * i) + (i2 * i2) + (i3 * i3));
        }
        return invokeL.floatValue;
    }

    public float dst2(GridPoint3 gridPoint3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gridPoint3)) == null) {
            int i = gridPoint3.x - this.x;
            int i2 = gridPoint3.y - this.y;
            int i3 = gridPoint3.z - this.z;
            return (i * i) + (i2 * i2) + (i3 * i3);
        }
        return invokeL.floatValue;
    }

    public GridPoint3 set(GridPoint3 gridPoint3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, gridPoint3)) == null) {
            this.x = gridPoint3.x;
            this.y = gridPoint3.y;
            this.z = gridPoint3.z;
            return this;
        }
        return (GridPoint3) invokeL.objValue;
    }

    public GridPoint3 sub(GridPoint3 gridPoint3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, gridPoint3)) == null) {
            this.x -= gridPoint3.x;
            this.y -= gridPoint3.y;
            this.z -= gridPoint3.z;
            return this;
        }
        return (GridPoint3) invokeL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return "(" + this.x + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.y + StringUtil.ARRAY_ELEMENT_SEPARATOR + this.z + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeV.objValue;
    }
}
