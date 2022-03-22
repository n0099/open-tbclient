package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes.dex */
public class LruCache<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int createCount;
    public int evictionCount;
    public int hitCount;
    public final LinkedHashMap<K, V> map;
    public int maxSize;
    public int missCount;
    public int putCount;
    public int size;

    public LruCache(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i > 0) {
            this.maxSize = i;
            this.map = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int safeSizeOf(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, k, v)) == null) {
            int sizeOf = sizeOf(k, v);
            if (sizeOf >= 0) {
                return sizeOf;
            }
            throw new IllegalStateException("Negative size: " + k + "=" + v);
        }
        return invokeLL.intValue;
    }

    @Nullable
    public V create(@NonNull K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) {
            return null;
        }
        return (V) invokeL.objValue;
    }

    public final synchronized int createCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                i = this.createCount;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public void entryRemoved(boolean z, @NonNull K k, @NonNull V v, @Nullable V v2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), k, v, v2}) == null) {
        }
    }

    public final void evictAll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            trimToSize(-1);
        }
    }

    public final synchronized int evictionCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                i = this.evictionCount;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Nullable
    public final V get(@NonNull K k) {
        InterceptResult invokeL;
        V put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k)) == null) {
            if (k != null) {
                synchronized (this) {
                    V v = this.map.get(k);
                    if (v != null) {
                        this.hitCount++;
                        return v;
                    }
                    this.missCount++;
                    V create = create(k);
                    if (create == null) {
                        return null;
                    }
                    synchronized (this) {
                        this.createCount++;
                        put = this.map.put(k, create);
                        if (put != null) {
                            this.map.put(k, put);
                        } else {
                            this.size += safeSizeOf(k, create);
                        }
                    }
                    if (put != null) {
                        entryRemoved(false, k, create, put);
                        return put;
                    }
                    trimToSize(this.maxSize);
                    return create;
                }
            }
            throw new NullPointerException("key == null");
        }
        return (V) invokeL.objValue;
    }

    public final synchronized int hitCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                i = this.hitCount;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final synchronized int maxSize() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                i = this.maxSize;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public final synchronized int missCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                i = this.missCount;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Nullable
    public final V put(@NonNull K k, @NonNull V v) {
        InterceptResult invokeLL;
        V put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, k, v)) == null) {
            if (k != null && v != null) {
                synchronized (this) {
                    this.putCount++;
                    this.size += safeSizeOf(k, v);
                    put = this.map.put(k, v);
                    if (put != null) {
                        this.size -= safeSizeOf(k, put);
                    }
                }
                if (put != null) {
                    entryRemoved(false, k, put, v);
                }
                trimToSize(this.maxSize);
                return put;
            }
            throw new NullPointerException("key == null || value == null");
        }
        return (V) invokeLL.objValue;
    }

    public final synchronized int putCount() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                i = this.putCount;
            }
            return i;
        }
        return invokeV.intValue;
    }

    @Nullable
    public final V remove(@NonNull K k) {
        InterceptResult invokeL;
        V remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, k)) == null) {
            if (k != null) {
                synchronized (this) {
                    remove = this.map.remove(k);
                    if (remove != null) {
                        this.size -= safeSizeOf(k, remove);
                    }
                }
                if (remove != null) {
                    entryRemoved(false, k, remove, null);
                }
                return remove;
            }
            throw new NullPointerException("key == null");
        }
        return (V) invokeL.objValue;
    }

    public void resize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            if (i > 0) {
                synchronized (this) {
                    this.maxSize = i;
                }
                trimToSize(i);
                return;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    public final synchronized int size() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this) {
                i = this.size;
            }
            return i;
        }
        return invokeV.intValue;
    }

    public int sizeOf(@NonNull K k, @NonNull V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, k, v)) == null) {
            return 1;
        }
        return invokeLL.intValue;
    }

    public final synchronized Map<K, V> snapshot() {
        InterceptResult invokeV;
        LinkedHashMap linkedHashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            synchronized (this) {
                linkedHashMap = new LinkedHashMap(this.map);
            }
            return linkedHashMap;
        }
        return (Map) invokeV.objValue;
    }

    public final synchronized String toString() {
        InterceptResult invokeV;
        String format;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            synchronized (this) {
                int i = this.hitCount + this.missCount;
                format = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i != 0 ? (this.hitCount * 100) / i : 0));
            }
            return format;
        }
        return (String) invokeV.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0074, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void trimToSize(int i) {
        K key;
        V value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            while (true) {
                synchronized (this) {
                    if (this.size >= 0 && (!this.map.isEmpty() || this.size == 0)) {
                        if (this.size <= i || this.map.isEmpty()) {
                            break;
                        }
                        Map.Entry<K, V> next = this.map.entrySet().iterator().next();
                        key = next.getKey();
                        value = next.getValue();
                        this.map.remove(key);
                        this.size -= safeSizeOf(key, value);
                        this.evictionCount++;
                    } else {
                        break;
                    }
                }
                entryRemoved(true, key, value, null);
            }
        }
    }
}
