package com.alibaba.fastjson.util;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes7.dex */
public class IdentityHashMap<K, V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_SIZE = 8192;
    public transient /* synthetic */ FieldHolder $fh;
    public final Entry<K, V>[] buckets;
    public final int indexMask;

    /* loaded from: classes7.dex */
    public static final class Entry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int hashCode;
        public final K key;
        public final Entry<K, V> next;
        public V value;

        public Entry(K k2, V v, int i2, Entry<K, V> entry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k2, v, Integer.valueOf(i2), entry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.key = k2;
            this.value = v;
            this.next = entry;
            this.hashCode = i2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public IdentityHashMap() {
        this(8192);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            Arrays.fill(this.buckets, (Object) null);
        }
    }

    public Class findClass(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) != null) {
            return (Class) invokeL.objValue;
        }
        int i2 = 0;
        while (true) {
            Entry<K, V>[] entryArr = this.buckets;
            if (i2 >= entryArr.length) {
                return null;
            }
            Entry<K, V> entry = entryArr[i2];
            if (entry != null) {
                for (Entry<K, V> entry2 = entry; entry2 != null; entry2 = entry2.next) {
                    K k2 = entry.key;
                    if (k2 instanceof Class) {
                        Class cls = (Class) k2;
                        if (cls.getName().equals(str)) {
                            return cls;
                        }
                    }
                }
                continue;
            }
            i2++;
        }
    }

    public final V get(K k2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, k2)) == null) {
            for (Entry<K, V> entry = this.buckets[System.identityHashCode(k2) & this.indexMask]; entry != null; entry = entry.next) {
                if (k2 == entry.key) {
                    return entry.value;
                }
            }
            return null;
        }
        return (V) invokeL.objValue;
    }

    public boolean put(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, k2, v)) == null) {
            int identityHashCode = System.identityHashCode(k2);
            int i2 = this.indexMask & identityHashCode;
            for (Entry<K, V> entry = this.buckets[i2]; entry != null; entry = entry.next) {
                if (k2 == entry.key) {
                    entry.value = v;
                    return true;
                }
            }
            this.buckets[i2] = new Entry<>(k2, v, identityHashCode, this.buckets[i2]);
            return false;
        }
        return invokeLL.booleanValue;
    }

    public int size() {
        InterceptResult invokeV;
        Entry<K, V>[] entryArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = 0;
            for (Entry<K, V> entry : this.buckets) {
                for (; entry != null; entry = entry.next) {
                    i2++;
                }
            }
            return i2;
        }
        return invokeV.intValue;
    }

    public IdentityHashMap(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.indexMask = i2 - 1;
        this.buckets = new Entry[i2];
    }
}
