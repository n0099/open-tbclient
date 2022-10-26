package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class FastSafeIterableMap<K, V> extends SafeIterableMap<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HashMap<K, SafeIterableMap.Entry<K, V>> mHashMap;

    public FastSafeIterableMap() {
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
        this.mHashMap = new HashMap<>();
    }

    public Map.Entry<K, V> ceil(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) {
            if (contains(k)) {
                return this.mHashMap.get(k).mPrevious;
            }
            return null;
        }
        return (Map.Entry) invokeL.objValue;
    }

    public boolean contains(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, k)) == null) {
            return this.mHashMap.containsKey(k);
        }
        return invokeL.booleanValue;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public SafeIterableMap.Entry<K, V> get(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k)) == null) {
            return this.mHashMap.get(k);
        }
        return (SafeIterableMap.Entry) invokeL.objValue;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V remove(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, k)) == null) {
            V v = (V) super.remove(k);
            this.mHashMap.remove(k);
            return v;
        }
        return (V) invokeL.objValue;
    }

    @Override // androidx.arch.core.internal.SafeIterableMap
    public V putIfAbsent(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, k, v)) == null) {
            SafeIterableMap.Entry<K, V> entry = get(k);
            if (entry != null) {
                return entry.mValue;
            }
            this.mHashMap.put(k, put(k, v));
            return null;
        }
        return (V) invokeLL.objValue;
    }
}
