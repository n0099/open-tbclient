package com.baidu.adp.framework.cmdRouter;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes9.dex */
public class LinkedMultiValueMap<K, V> implements MultiValueMap<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Map<K, List<V>> mSource;

    public LinkedMultiValueMap() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mSource = new LinkedHashMap();
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public void add(K k2, V v) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, k2, v) == null) || k2 == null) {
            return;
        }
        if (!this.mSource.containsKey(k2)) {
            this.mSource.put(k2, new ArrayList(2));
        }
        this.mSource.get(k2).add(v);
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public void addAll(Map<K, V> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, map) == null) {
            for (K k2 : map.keySet()) {
                add((LinkedMultiValueMap<K, V>) k2, (K) map.get(k2));
            }
        }
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mSource.clear();
        }
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public boolean containsKey(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k2)) == null) ? this.mSource.containsKey(k2) : invokeL.booleanValue;
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public V getValue(K k2, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048581, this, k2, i2)) == null) {
            List<V> list = this.mSource.get(k2);
            if (list == null || i2 >= list.size()) {
                return null;
            }
            return list.get(i2);
        }
        return (V) invokeLI.objValue;
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public List<V> getValues(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, k2)) == null) ? this.mSource.get(k2) : (List) invokeL.objValue;
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mSource.isEmpty() : invokeV.booleanValue;
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public Set<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mSource.keySet() : (Set) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public List<V> remove(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, k2)) == null) ? this.mSource.remove(k2) : (List) invokeL.objValue;
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public void set(K k2, V v) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, k2, v) == null) {
            this.mSource.remove(k2);
            add((LinkedMultiValueMap<K, V>) k2, (K) v);
        }
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.mSource.size() : invokeV.intValue;
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public List<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            ArrayList arrayList = new ArrayList();
            for (K k2 : this.mSource.keySet()) {
                arrayList.addAll(this.mSource.get(k2));
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public void set(K k2, List<V> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, k2, list) == null) {
            this.mSource.remove(k2);
            add((LinkedMultiValueMap<K, V>) k2, (List) list);
        }
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public void add(K k2, List<V> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k2, list) == null) {
            for (V v : list) {
                add((LinkedMultiValueMap<K, V>) k2, (K) v);
            }
        }
    }

    @Override // com.baidu.adp.framework.cmdRouter.MultiValueMap
    public void set(Map<K, List<V>> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, map) == null) {
            this.mSource.clear();
            this.mSource.putAll(map);
        }
    }
}
