package c.i.d.c;

import androidx.core.view.InputDeviceCompat;
import c.i.d.c.k1;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.common.collect.Maps;
import com.google.common.collect.Tables;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes4.dex */
public abstract class i<R, C, V> implements k1<R, C, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Set<k1.a<R, C, V>> cellSet;
    public transient Collection<V> values;

    /* loaded from: classes4.dex */
    public class a extends m1<k1.a<R, C, V>, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i iVar, Iterator it) {
            super(it);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar, it};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Iterator) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // c.i.d.c.m1
        /* renamed from: b */
        public V a(k1.a<R, C, V> aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar)) == null) ? aVar.getValue() : (V) invokeL.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends AbstractSet<k1.a<R, C, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f34223e;

        public b(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34223e = iVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34223e.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof k1.a) {
                    k1.a aVar = (k1.a) obj;
                    Map map = (Map) Maps.A(this.f34223e.rowMap(), aVar.getRowKey());
                    return map != null && n.e(map.entrySet(), Maps.l(aVar.getColumnKey(), aVar.getValue()));
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<k1.a<R, C, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34223e.cellIterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (obj instanceof k1.a) {
                    k1.a aVar = (k1.a) obj;
                    Map map = (Map) Maps.A(this.f34223e.rowMap(), aVar.getRowKey());
                    return map != null && n.f(map.entrySet(), Maps.l(aVar.getColumnKey(), aVar.getValue()));
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f34223e.size() : invokeV.intValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends AbstractCollection<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ i f34224e;

        public c(i iVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {iVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f34224e = iVar;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f34224e.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.f34224e.containsValue(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f34224e.valuesIterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f34224e.size() : invokeV.intValue;
        }
    }

    public i() {
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

    public abstract Iterator<k1.a<R, C, V>> cellIterator();

    @Override // c.i.d.c.k1
    public Set<k1.a<R, C, V>> cellSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Set<k1.a<R, C, V>> set = this.cellSet;
            if (set == null) {
                Set<k1.a<R, C, V>> createCellSet = createCellSet();
                this.cellSet = createCellSet;
                return createCellSet;
            }
            return set;
        }
        return (Set) invokeV.objValue;
    }

    @Override // c.i.d.c.k1
    public abstract void clear();

    @Override // c.i.d.c.k1
    public abstract Set<C> columnKeySet();

    @Override // c.i.d.c.k1
    public boolean contains(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, obj, obj2)) == null) {
            Map map = (Map) Maps.A(rowMap(), obj);
            return map != null && Maps.z(map, obj2);
        }
        return invokeLL.booleanValue;
    }

    @Override // c.i.d.c.k1
    public boolean containsColumn(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? Maps.z(columnMap(), obj) : invokeL.booleanValue;
    }

    @Override // c.i.d.c.k1
    public boolean containsRow(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) ? Maps.z(rowMap(), obj) : invokeL.booleanValue;
    }

    @Override // c.i.d.c.k1
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            for (Map<C, V> map : rowMap().values()) {
                if (map.containsValue(obj)) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Set<k1.a<R, C, V>> createCellSet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? new b(this) : (Set) invokeV.objValue;
    }

    public Collection<V> createValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? new c(this) : (Collection) invokeV.objValue;
    }

    @Override // c.i.d.c.k1
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) ? Tables.b(this, obj) : invokeL.booleanValue;
    }

    @Override // c.i.d.c.k1
    public V get(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, obj, obj2)) == null) {
            Map map = (Map) Maps.A(rowMap(), obj);
            if (map == null) {
                return null;
            }
            return (V) Maps.A(map, obj2);
        }
        return (V) invokeLL.objValue;
    }

    @Override // c.i.d.c.k1
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? cellSet().hashCode() : invokeV.intValue;
    }

    @Override // c.i.d.c.k1
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? size() == 0 : invokeV.booleanValue;
    }

    @Override // c.i.d.c.k1
    public abstract V put(R r, C c2, V v);

    @Override // c.i.d.c.k1
    public void putAll(k1<? extends R, ? extends C, ? extends V> k1Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, k1Var) == null) {
            for (k1.a<? extends R, ? extends C, ? extends V> aVar : k1Var.cellSet()) {
                put(aVar.getRowKey(), aVar.getColumnKey(), aVar.getValue());
            }
        }
    }

    @Override // c.i.d.c.k1
    public abstract V remove(Object obj, Object obj2);

    @Override // c.i.d.c.k1
    public abstract Set<R> rowKeySet();

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? rowMap().toString() : (String) invokeV.objValue;
    }

    @Override // c.i.d.c.k1
    public Collection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
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

    public Iterator<V> valuesIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? new a(this, cellSet().iterator()) : (Iterator) invokeV.objValue;
    }
}
