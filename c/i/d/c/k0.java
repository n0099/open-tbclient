package c.i.d.c;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
/* loaded from: classes7.dex */
public abstract class k0<K, V> extends d0<K, V> implements SortedMap<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public k0() {
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

    private int unsafeCompare(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, obj, obj2)) == null) {
            Comparator<? super K> comparator = comparator();
            if (comparator == null) {
                return ((Comparable) obj).compareTo(obj2);
            }
            return comparator.compare(obj, obj2);
        }
        return invokeLL.intValue;
    }

    @Override // java.util.SortedMap
    public Comparator<? super K> comparator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? delegate().comparator() : (Comparator) invokeV.objValue;
    }

    @Override // c.i.d.c.d0, c.i.d.c.h0
    public abstract /* bridge */ /* synthetic */ Object delegate();

    @Override // c.i.d.c.d0, c.i.d.c.h0
    public abstract /* bridge */ /* synthetic */ Map delegate();

    @Override // c.i.d.c.d0, c.i.d.c.h0
    public abstract SortedMap<K, V> delegate();

    @Override // java.util.SortedMap
    public K firstKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? delegate().firstKey() : (K) invokeV.objValue;
    }

    @Override // java.util.SortedMap
    public abstract SortedMap<K, V> headMap(K k2);

    @Override // java.util.SortedMap
    public K lastKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? delegate().lastKey() : (K) invokeV.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // c.i.d.c.d0
    public boolean standardContainsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            try {
                return unsafeCompare(tailMap(obj).firstKey(), obj) == 0;
            } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public SortedMap<K, V> standardSubMap(K k2, K k3) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k2, k3)) == null) {
            c.i.d.a.n.e(unsafeCompare(k2, k3) <= 0, "fromKey must be <= toKey");
            return tailMap(k2).headMap(k3);
        }
        return (SortedMap) invokeLL.objValue;
    }

    @Override // java.util.SortedMap
    public abstract SortedMap<K, V> subMap(K k2, K k3);

    @Override // java.util.SortedMap
    public abstract SortedMap<K, V> tailMap(K k2);
}
