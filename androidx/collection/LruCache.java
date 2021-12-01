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

    public LruCache(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (i2 > 0) {
            this.maxSize = i2;
            this.map = new LinkedHashMap<>(0, 0.75f, true);
            return;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private int safeSizeOf(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, this, k2, v)) == null) {
            int sizeOf = sizeOf(k2, v);
            if (sizeOf >= 0) {
                return sizeOf;
            }
            throw new IllegalStateException("Negative size: " + k2 + "=" + v);
        }
        return invokeLL.intValue;
    }

    @Nullable
    public V create(@NonNull K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k2)) == null) {
            return null;
        }
        return (V) invokeL.objValue;
    }

    public final synchronized int createCount() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            synchronized (this) {
                i2 = this.createCount;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public void entryRemoved(boolean z, @NonNull K k2, @NonNull V v, @Nullable V v2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Boolean.valueOf(z), k2, v, v2}) == null) {
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            synchronized (this) {
                i2 = this.evictionCount;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Nullable
    public final V get(@NonNull K k2) {
        InterceptResult invokeL;
        V put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, k2)) == null) {
            if (k2 != null) {
                synchronized (this) {
                    V v = this.map.get(k2);
                    if (v != null) {
                        this.hitCount++;
                        return v;
                    }
                    this.missCount++;
                    V create = create(k2);
                    if (create == null) {
                        return null;
                    }
                    synchronized (this) {
                        this.createCount++;
                        put = this.map.put(k2, create);
                        if (put != null) {
                            this.map.put(k2, put);
                        } else {
                            this.size += safeSizeOf(k2, create);
                        }
                    }
                    if (put != null) {
                        entryRemoved(false, k2, create, put);
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            synchronized (this) {
                i2 = this.hitCount;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final synchronized int maxSize() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            synchronized (this) {
                i2 = this.maxSize;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public final synchronized int missCount() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            synchronized (this) {
                i2 = this.missCount;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Nullable
    public final V put(@NonNull K k2, @NonNull V v) {
        InterceptResult invokeLL;
        V put;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, k2, v)) == null) {
            if (k2 != null && v != null) {
                synchronized (this) {
                    this.putCount++;
                    this.size += safeSizeOf(k2, v);
                    put = this.map.put(k2, v);
                    if (put != null) {
                        this.size -= safeSizeOf(k2, put);
                    }
                }
                if (put != null) {
                    entryRemoved(false, k2, put, v);
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
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            synchronized (this) {
                i2 = this.putCount;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Nullable
    public final V remove(@NonNull K k2) {
        InterceptResult invokeL;
        V remove;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, k2)) == null) {
            if (k2 != null) {
                synchronized (this) {
                    remove = this.map.remove(k2);
                    if (remove != null) {
                        this.size -= safeSizeOf(k2, remove);
                    }
                }
                if (remove != null) {
                    entryRemoved(false, k2, remove, null);
                }
                return remove;
            }
            throw new NullPointerException("key == null");
        }
        return (V) invokeL.objValue;
    }

    public void resize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            if (i2 > 0) {
                synchronized (this) {
                    this.maxSize = i2;
                }
                trimToSize(i2);
                return;
            }
            throw new IllegalArgumentException("maxSize <= 0");
        }
    }

    public final synchronized int size() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            synchronized (this) {
                i2 = this.size;
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public int sizeOf(@NonNull K k2, @NonNull V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, k2, v)) == null) {
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
                int i2 = this.hitCount + this.missCount;
                format = String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i2 != 0 ? (this.hitCount * 100) / i2 : 0));
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
    public void trimToSize(int i2) {
        K key;
        V value;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i2) == null) {
            while (true) {
                synchronized (this) {
                    if (this.size >= 0 && (!this.map.isEmpty() || this.size == 0)) {
                        if (this.size <= i2 || this.map.isEmpty()) {
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
