package com.baidu.tbadk.core.util;

import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class StatisticItem {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String key;
    public List<Object> params;
    public int position;

    public StatisticItem() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.params = new ArrayList();
    }

    public static StatisticItem make(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? new StatisticItem(str) : (StatisticItem) invokeL.objValue;
    }

    private void setParams(List<Object> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65539, this, list) == null) {
            this.params = list;
        }
    }

    public StatisticItem addParam(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, str, str2)) == null) {
            int index = getIndex(str);
            if (index > 0) {
                this.params.set(index, str2);
                return this;
            }
            return param(str, str2);
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public StatisticItem copy() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            StatisticItem statisticItem = new StatisticItem(getKey());
            statisticItem.setParams(getParams());
            return statisticItem;
        }
        return (StatisticItem) invokeV.objValue;
    }

    public void delete(String str) {
        int indexOf;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || m.isEmpty(str) || (indexOf = this.params.indexOf(str)) < 0 || this.params.size() <= indexOf + 1) {
            return;
        }
        this.params.remove(indexOf);
        this.params.remove(indexOf);
    }

    public void eventStat() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TiebaStatic.log(this);
        }
    }

    public int getContentHashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.params.hashCode() : invokeV.intValue;
    }

    public int getIndex(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str)) == null) {
            if (hasParam(str)) {
                return this.params.indexOf(str) + 1;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public String getKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.key : (String) invokeV.objValue;
    }

    public List<Object> getParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.params : (List) invokeV.objValue;
    }

    public int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.position : invokeV.intValue;
    }

    public boolean hasParam(String str) {
        InterceptResult invokeL;
        int indexOf;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, str)) == null) ? !m.isEmpty(str) && (indexOf = this.params.indexOf(str)) >= 0 && this.params.size() > indexOf + 1 : invokeL.booleanValue;
    }

    public StatisticItem key(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, str)) == null) {
            this.key = str;
            return this;
        }
        return (StatisticItem) invokeL.objValue;
    }

    public StatisticItem param(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, str, str2)) == null) {
            this.params.add(str);
            this.params.add(str2);
            return this;
        }
        return (StatisticItem) invokeLL.objValue;
    }

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.position = i;
        }
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return "StatisticItem{key='" + this.key + "', position=" + this.position + ", params=" + this.params + '}';
        }
        return (String) invokeV.objValue;
    }

    public StatisticItem(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.params = new ArrayList();
        this.key = str;
    }

    public StatisticItem param(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048591, this, str, i)) == null) {
            this.params.add(str);
            this.params.add(Integer.valueOf(i));
            return this;
        }
        return (StatisticItem) invokeLI.objValue;
    }

    public StatisticItem addParam(String str, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i)) == null) {
            int index = getIndex(str);
            if (index > 0) {
                this.params.set(index, Integer.valueOf(i));
                return this;
            }
            return param(str, i);
        }
        return (StatisticItem) invokeLI.objValue;
    }

    public StatisticItem param(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(1048592, this, str, j)) == null) {
            this.params.add(str);
            this.params.add(Long.valueOf(j));
            return this;
        }
        return (StatisticItem) invokeLJ.objValue;
    }

    public StatisticItem addParam(String str, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, str, j)) == null) {
            int index = getIndex(str);
            if (index > 0) {
                this.params.set(index, Long.valueOf(j));
                return this;
            }
            return param(str, j);
        }
        return (StatisticItem) invokeLJ.objValue;
    }

    public StatisticItem param(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048590, this, new Object[]{str, Double.valueOf(d2)})) == null) {
            this.params.add(str);
            this.params.add(Double.valueOf(d2));
            return this;
        }
        return (StatisticItem) invokeCommon.objValue;
    }

    public StatisticItem addParam(String str, double d2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{str, Double.valueOf(d2)})) == null) {
            int index = getIndex(str);
            if (index > 0) {
                this.params.set(index, Double.valueOf(d2));
                return this;
            }
            return param(str, d2);
        }
        return (StatisticItem) invokeCommon.objValue;
    }
}
