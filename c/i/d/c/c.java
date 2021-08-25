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
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public abstract class c<K, V> implements q0<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Map<K, Collection<V>> asMap;
    public transient Collection<Map.Entry<K, V>> entries;
    public transient Set<K> keySet;
    public transient s0<K> keys;
    public transient Collection<V> values;

    /* loaded from: classes4.dex */
    public class a extends Multimaps.b<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f34079e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34079e = cVar;
        }

        @Override // com.google.common.collect.Multimaps.b
        public q0<K, V> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34079e : (q0) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34079e.entryIterator() : (Iterator) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends c<K, V>.a implements Set<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar) {
            super(cVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((c) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) ? Sets.a(this, obj) : invokeL.booleanValue;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? Sets.d(this) : invokeV.intValue;
        }
    }

    /* renamed from: c.i.d.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1506c extends AbstractCollection<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f34080e;

        public C1506c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34080e = cVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34080e.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.f34080e.containsValue(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34080e.valueIterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34080e.size() : invokeV.intValue;
        }
    }

    public c() {
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

    @Override // c.i.d.c.q0
    public Map<K, Collection<V>> asMap() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Map<K, Collection<V>> map = this.asMap;
            if (map == null) {
                Map<K, Collection<V>> createAsMap = createAsMap();
                this.asMap = createAsMap;
                return createAsMap;
            }
            return map;
        }
        return (Map) invokeV.objValue;
    }

    @Override // c.i.d.c.q0
    public boolean containsEntry(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj, obj2)) == null) {
            Collection<V> collection = asMap().get(obj);
            return collection != null && collection.contains(obj2);
        }
        return invokeLL.booleanValue;
    }

    @Override // c.i.d.c.q0
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            for (Collection<V> collection : asMap().values()) {
                if (collection.contains(obj)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public abstract Map<K, Collection<V>> createAsMap();

    public abstract Collection<Map.Entry<K, V>> createEntries();

    public abstract Set<K> createKeySet();

    public abstract s0<K> createKeys();

    public abstract Collection<V> createValues();

    @Override // c.i.d.c.q0
    public Collection<Map.Entry<K, V>> entries() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            Collection<Map.Entry<K, V>> collection = this.entries;
            if (collection == null) {
                Collection<Map.Entry<K, V>> createEntries = createEntries();
                this.entries = createEntries;
                return createEntries;
            }
            return collection;
        }
        return (Collection) invokeV.objValue;
    }

    public abstract Iterator<Map.Entry<K, V>> entryIterator();

    @Override // c.i.d.c.q0
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) ? Multimaps.c(this, obj) : invokeL.booleanValue;
    }

    @Override // c.i.d.c.q0
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? asMap().hashCode() : invokeV.intValue;
    }

    @Override // c.i.d.c.q0
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? size() == 0 : invokeV.booleanValue;
    }

    @Override // c.i.d.c.q0
    public Set<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Set<K> set = this.keySet;
            if (set == null) {
                Set<K> createKeySet = createKeySet();
                this.keySet = createKeySet;
                return createKeySet;
            }
            return set;
        }
        return (Set) invokeV.objValue;
    }

    @Override // c.i.d.c.q0
    public s0<K> keys() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            s0<K> s0Var = this.keys;
            if (s0Var == null) {
                s0<K> createKeys = createKeys();
                this.keys = createKeys;
                return createKeys;
            }
            return s0Var;
        }
        return (s0) invokeV.objValue;
    }

    @Override // c.i.d.c.q0
    public boolean put(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, k, v)) == null) ? get(k).add(v) : invokeLL.booleanValue;
    }

    @Override // c.i.d.c.q0
    public boolean putAll(K k, Iterable<? extends V> iterable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, k, iterable)) == null) {
            c.i.d.a.n.p(iterable);
            if (iterable instanceof Collection) {
                Collection<? extends V> collection = (Collection) iterable;
                return !collection.isEmpty() && get(k).addAll(collection);
            }
            Iterator<? extends V> it = iterable.iterator();
            return it.hasNext() && Iterators.a(get(k), it);
        }
        return invokeLL.booleanValue;
    }

    @Override // c.i.d.c.q0
    public boolean remove(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, obj, obj2)) == null) {
            Collection<V> collection = asMap().get(obj);
            return collection != null && collection.remove(obj2);
        }
        return invokeLL.booleanValue;
    }

    @Override // c.i.d.c.q0
    public Collection<V> replaceValues(K k, Iterable<? extends V> iterable) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048595, this, k, iterable)) == null) {
            c.i.d.a.n.p(iterable);
            Collection<V> removeAll = removeAll(k);
            putAll(k, iterable);
            return removeAll;
        }
        return (Collection) invokeLL.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? asMap().toString() : (String) invokeV.objValue;
    }

    public Iterator<V> valueIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? Maps.O(entries().iterator()) : (Iterator) invokeV.objValue;
    }

    @Override // c.i.d.c.q0
    public Collection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            Collection<V> collection = this.values;
            if (collection == null) {
                Collection<V> createValues = createValues();
                this.values = createValues;
                return createValues;
            }
            return collection;
        }
        return (Collection) invokeV.objValue;
    }

    @Override // c.i.d.c.q0
    public boolean putAll(q0<? extends K, ? extends V> q0Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, q0Var)) == null) {
            boolean z = false;
            for (Map.Entry<? extends K, ? extends V> entry : q0Var.entries()) {
                z |= put(entry.getKey(), entry.getValue());
            }
            return z;
        }
        return invokeL.booleanValue;
    }
}
