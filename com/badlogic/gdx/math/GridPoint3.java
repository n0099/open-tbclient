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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
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

    public GridPoint3 cpy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? new GridPoint3(this) : (GridPoint3) invokeV.objValue;
    }

    public float dst(GridPoint3 gridPoint3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, gridPoint3)) == null) {
            int i2 = gridPoint3.x - this.x;
            int i3 = gridPoint3.y - this.y;
            int i4 = gridPoint3.z - this.z;
            return (float) Math.sqrt((i2 * i2) + (i3 * i3) + (i4 * i4));
        }
        return invokeL.floatValue;
    }

    public float dst2(GridPoint3 gridPoint3) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, gridPoint3)) == null) {
            int i2 = gridPoint3.x - this.x;
            int i3 = gridPoint3.y - this.y;
            int i4 = gridPoint3.z - this.z;
            return (i2 * i2) + (i3 * i3) + (i4 * i4);
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
            if (obj == null || obj.getClass() != GridPoint3.class) {
                return false;
            }
            GridPoint3 gridPoint3 = (GridPoint3) obj;
            return this.x == gridPoint3.x && this.y == gridPoint3.y && this.z == gridPoint3.z;
        }
        return invokeL.booleanValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? ((((this.x + 17) * 17) + this.y) * 17) + this.z : invokeV.intValue;
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

    public GridPoint3(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i5 = newInitContext.flag;
            if ((i5 & 1) != 0) {
                int i6 = i5 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.x = i2;
        this.y = i3;
        this.z = i4;
    }

    public GridPoint3 add(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048576, this, i2, i3, i4)) == null) {
            this.x += i2;
            this.y += i3;
            this.z += i4;
            return this;
        }
        return (GridPoint3) invokeIII.objValue;
    }

    public float dst2(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048581, this, i2, i3, i4)) == null) {
            int i5 = i2 - this.x;
            int i6 = i3 - this.y;
            int i7 = i4 - this.z;
            return (i5 * i5) + (i6 * i6) + (i7 * i7);
        }
        return invokeIII.floatValue;
    }

    public GridPoint3 set(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048585, this, i2, i3, i4)) == null) {
            this.x = i2;
            this.y = i3;
            this.z = i4;
            return this;
        }
        return (GridPoint3) invokeIII.objValue;
    }

    public GridPoint3 sub(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048587, this, i2, i3, i4)) == null) {
            this.x -= i2;
            this.y -= i3;
            this.z -= i4;
            return this;
        }
        return (GridPoint3) invokeIII.objValue;
    }

    public float dst(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048579, this, i2, i3, i4)) == null) {
            int i5 = i2 - this.x;
            int i6 = i3 - this.y;
            int i7 = i4 - this.z;
            return (float) Math.sqrt((i5 * i5) + (i6 * i6) + (i7 * i7));
        }
        return invokeIII.floatValue;
    }

    public GridPoint3(GridPoint3 gridPoint3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gridPoint3};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.x = gridPoint3.x;
        this.y = gridPoint3.y;
        this.z = gridPoint3.z;
    }
}
