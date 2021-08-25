package c.i.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
/* loaded from: classes4.dex */
public abstract class e<K, V> extends Maps.p<K, V> implements NavigableMap<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes4.dex */
    public final class b extends Maps.j<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f34084h;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34084h = eVar;
        }

        @Override // com.google.common.collect.Maps.j
        public Iterator<Map.Entry<K, V>> e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34084h.b() : (Iterator) invokeV.objValue;
        }

        @Override // com.google.common.collect.Maps.j
        public NavigableMap<K, V> f() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34084h : (NavigableMap) invokeV.objValue;
        }

        public /* synthetic */ b(e eVar, a aVar) {
            this(eVar);
        }
    }

    public e() {
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

    public abstract Iterator<Map.Entry<K, V>> b();

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> ceilingEntry(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) ? tailMap(k, true).firstEntry() : (Map.Entry) invokeL.objValue;
    }

    @Override // java.util.NavigableMap
    public K ceilingKey(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k)) == null) ? (K) Maps.p(ceilingEntry(k)) : (K) invokeL.objValue;
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? descendingMap().navigableKeySet() : (NavigableSet) invokeV.objValue;
    }

    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? new b(this, null) : (NavigableMap) invokeV.objValue;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> firstEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? (Map.Entry) Iterators.o(a(), null) : (Map.Entry) invokeV.objValue;
    }

    @Override // java.util.SortedMap
    public K firstKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            Map.Entry<K, V> firstEntry = firstEntry();
            if (firstEntry != null) {
                return firstEntry.getKey();
            }
            throw new NoSuchElementException();
        }
        return (K) invokeV.objValue;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> floorEntry(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, k)) == null) ? headMap(k, true).lastEntry() : (Map.Entry) invokeL.objValue;
    }

    @Override // java.util.NavigableMap
    public K floorKey(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k)) == null) ? (K) Maps.p(floorEntry(k)) : (K) invokeL.objValue;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> headMap(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, k)) == null) ? headMap(k, false) : (SortedMap) invokeL.objValue;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> higherEntry(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, k)) == null) ? tailMap(k, false).firstEntry() : (Map.Entry) invokeL.objValue;
    }

    @Override // java.util.NavigableMap
    public K higherKey(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, k)) == null) ? (K) Maps.p(higherEntry(k)) : (K) invokeL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map, java.util.SortedMap
    public Set<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? navigableKeySet() : (Set) invokeV.objValue;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lastEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? (Map.Entry) Iterators.o(b(), null) : (Map.Entry) invokeV.objValue;
    }

    @Override // java.util.SortedMap
    public K lastKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            Map.Entry<K, V> lastEntry = lastEntry();
            if (lastEntry != null) {
                return lastEntry.getKey();
            }
            throw new NoSuchElementException();
        }
        return (K) invokeV.objValue;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> lowerEntry(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, k)) == null) ? headMap(k, false).lastEntry() : (Map.Entry) invokeL.objValue;
    }

    @Override // java.util.NavigableMap
    public K lowerKey(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, k)) == null) ? (K) Maps.p(lowerEntry(k)) : (K) invokeL.objValue;
    }

    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? new Maps.r(this) : (NavigableSet) invokeV.objValue;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollFirstEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (Map.Entry) Iterators.t(a()) : (Map.Entry) invokeV.objValue;
    }

    @Override // java.util.NavigableMap
    public Map.Entry<K, V> pollLastEntry() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? (Map.Entry) Iterators.t(b()) : (Map.Entry) invokeV.objValue;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> subMap(K k, K k2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, k, k2)) == null) ? subMap(k, true, k2, false) : (SortedMap) invokeLL.objValue;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    public SortedMap<K, V> tailMap(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, k)) == null) ? tailMap(k, true) : (SortedMap) invokeL.objValue;
    }
}
