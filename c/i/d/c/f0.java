package c.i.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
/* loaded from: classes7.dex */
public abstract class f0<K, V> extends h0 implements q0<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public f0() {
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
    public abstract Map<K, Collection<V>> asMap();

    @Override // c.i.d.c.q0
    public abstract void clear();

    @Override // c.i.d.c.q0
    public boolean containsEntry(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, obj, obj2)) == null) ? delegate().containsEntry(obj, obj2) : invokeLL.booleanValue;
    }

    @Override // c.i.d.c.q0
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? delegate().containsKey(obj) : invokeL.booleanValue;
    }

    @Override // c.i.d.c.q0
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) ? delegate().containsValue(obj) : invokeL.booleanValue;
    }

    @Override // c.i.d.c.h0
    public abstract q0<K, V> delegate();

    @Override // c.i.d.c.h0
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // c.i.d.c.q0
    public abstract Collection<Map.Entry<K, V>> entries();

    @Override // c.i.d.c.q0
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) ? obj == this || delegate().equals(obj) : invokeL.booleanValue;
    }

    @Override // c.i.d.c.q0
    public abstract Collection<V> get(K k2);

    @Override // c.i.d.c.q0
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? delegate().hashCode() : invokeV.intValue;
    }

    @Override // c.i.d.c.q0
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? delegate().isEmpty() : invokeV.booleanValue;
    }

    @Override // c.i.d.c.q0
    public abstract Set<K> keySet();

    @Override // c.i.d.c.q0
    public abstract s0<K> keys();

    @Override // c.i.d.c.q0
    public abstract boolean put(K k2, V v);

    @Override // c.i.d.c.q0
    public abstract boolean putAll(q0<? extends K, ? extends V> q0Var);

    @Override // c.i.d.c.q0
    public abstract boolean putAll(K k2, Iterable<? extends V> iterable);

    @Override // c.i.d.c.q0
    public abstract boolean remove(Object obj, Object obj2);

    @Override // c.i.d.c.q0
    public abstract Collection<V> removeAll(Object obj);

    @Override // c.i.d.c.q0
    public abstract Collection<V> replaceValues(K k2, Iterable<? extends V> iterable);

    @Override // c.i.d.c.q0
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? delegate().size() : invokeV.intValue;
    }

    @Override // c.i.d.c.q0
    public abstract Collection<V> values();
}
