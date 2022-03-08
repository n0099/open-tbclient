package com.alibaba.fastjson.util;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
/* loaded from: classes3.dex */
public class AntiCollisionHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int DEFAULT_INITIAL_CAPACITY = 16;
    public static final float DEFAULT_LOAD_FACTOR = 0.75f;
    public static final int KEY = 16777619;
    public static final int MAXIMUM_CAPACITY = 1073741824;
    public static final int M_MASK = -2023358765;
    public static final int SEED = -2128831035;
    public static final long serialVersionUID = 362498820763181265L;
    public transient /* synthetic */ FieldHolder $fh;
    public transient Set<Map.Entry<K, V>> entrySet;
    public volatile transient Set<K> keySet;
    public final float loadFactor;
    public volatile transient int modCount;
    public final int random;
    public transient int size;
    public transient Entry<K, V>[] table;
    public int threshold;
    public volatile transient Collection<V> values;

    /* renamed from: com.alibaba.fastjson.util.AntiCollisionHashMap$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes3.dex */
    public static class Entry<K, V> implements Map.Entry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final int hash;
        public final K key;
        public Entry<K, V> next;
        public V value;

        public Entry(int i2, K k, V v, Entry<K, V> entry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), k, v, entry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = v;
            this.next = entry;
            this.key = k;
            this.hash = i2;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    K key = getKey();
                    Object key2 = entry.getKey();
                    if (key == key2 || (key != null && key.equals(key2))) {
                        V value = getValue();
                        Object value2 = entry.getValue();
                        if (value == value2) {
                            return true;
                        }
                        if (value != null && value.equals(value2)) {
                            return true;
                        }
                    }
                    return false;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Map.Entry
        public final K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.key : (K) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public final V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.value : (V) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                K k = this.key;
                int hashCode = k == null ? 0 : k.hashCode();
                V v = this.value;
                return hashCode ^ (v != null ? v.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        @Override // java.util.Map.Entry
        public final V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, v)) == null) {
                V v2 = this.value;
                this.value = v;
                return v2;
            }
            return (V) invokeL.objValue;
        }

        public final String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return getKey() + "=" + getValue();
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public final class EntryIterator extends AntiCollisionHashMap<K, V>.HashIterator<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AntiCollisionHashMap this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EntryIterator(AntiCollisionHashMap antiCollisionHashMap) {
            super(antiCollisionHashMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {antiCollisionHashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AntiCollisionHashMap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = antiCollisionHashMap;
        }

        public /* synthetic */ EntryIterator(AntiCollisionHashMap antiCollisionHashMap, AnonymousClass1 anonymousClass1) {
            this(antiCollisionHashMap);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? nextEntry() : (Map.Entry) invokeV.objValue;
        }
    }

    /* loaded from: classes3.dex */
    public final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AntiCollisionHashMap this$0;

        public EntrySet(AntiCollisionHashMap antiCollisionHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {antiCollisionHashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = antiCollisionHashMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    Entry<K, V> entry2 = this.this$0.getEntry(entry.getKey());
                    return entry2 != null && entry2.equals(entry);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.newEntryIterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? this.this$0.removeMapping(obj) != null : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.this$0.size : invokeV.intValue;
        }

        public /* synthetic */ EntrySet(AntiCollisionHashMap antiCollisionHashMap, AnonymousClass1 anonymousClass1) {
            this(antiCollisionHashMap);
        }
    }

    /* loaded from: classes3.dex */
    public abstract class HashIterator<E> implements Iterator<E> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Entry<K, V> current;
        public int expectedModCount;
        public int index;
        public Entry<K, V> next;
        public final /* synthetic */ AntiCollisionHashMap this$0;

        public HashIterator(AntiCollisionHashMap antiCollisionHashMap) {
            Entry<K, V> entry;
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {antiCollisionHashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = antiCollisionHashMap;
            this.expectedModCount = antiCollisionHashMap.modCount;
            if (antiCollisionHashMap.size > 0) {
                Entry<K, V>[] entryArr = antiCollisionHashMap.table;
                do {
                    int i4 = this.index;
                    if (i4 >= entryArr.length) {
                        return;
                    }
                    this.index = i4 + 1;
                    entry = entryArr[i4];
                    this.next = entry;
                } while (entry == null);
            }
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.next != null : invokeV.booleanValue;
        }

        public final Entry<K, V> nextEntry() {
            InterceptResult invokeV;
            Entry<K, V> entry;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.this$0.modCount == this.expectedModCount) {
                    Entry<K, V> entry2 = this.next;
                    if (entry2 != null) {
                        Entry<K, V> entry3 = entry2.next;
                        this.next = entry3;
                        if (entry3 == null) {
                            Entry<K, V>[] entryArr = this.this$0.table;
                            do {
                                int i2 = this.index;
                                if (i2 >= entryArr.length) {
                                    break;
                                }
                                this.index = i2 + 1;
                                entry = entryArr[i2];
                                this.next = entry;
                            } while (entry == null);
                        }
                        this.current = entry2;
                        return entry2;
                    }
                    throw new NoSuchElementException();
                }
                throw new ConcurrentModificationException();
            }
            return (Entry) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.current != null) {
                    if (this.this$0.modCount == this.expectedModCount) {
                        K k = this.current.key;
                        this.current = null;
                        this.this$0.removeEntryForKey(k);
                        this.expectedModCount = this.this$0.modCount;
                        return;
                    }
                    throw new ConcurrentModificationException();
                }
                throw new IllegalStateException();
            }
        }
    }

    /* loaded from: classes3.dex */
    public final class KeyIterator extends AntiCollisionHashMap<K, V>.HashIterator<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AntiCollisionHashMap this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public KeyIterator(AntiCollisionHashMap antiCollisionHashMap) {
            super(antiCollisionHashMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {antiCollisionHashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AntiCollisionHashMap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = antiCollisionHashMap;
        }

        @Override // java.util.Iterator
        public K next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? nextEntry().getKey() : (K) invokeV.objValue;
        }

        public /* synthetic */ KeyIterator(AntiCollisionHashMap antiCollisionHashMap, AnonymousClass1 anonymousClass1) {
            this(antiCollisionHashMap);
        }
    }

    /* loaded from: classes3.dex */
    public final class KeySet extends AbstractSet<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AntiCollisionHashMap this$0;

        public KeySet(AntiCollisionHashMap antiCollisionHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {antiCollisionHashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = antiCollisionHashMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.this$0.containsKey(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.newKeyIterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? this.this$0.removeEntryForKey(obj) != null : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.this$0.size : invokeV.intValue;
        }

        public /* synthetic */ KeySet(AntiCollisionHashMap antiCollisionHashMap, AnonymousClass1 anonymousClass1) {
            this(antiCollisionHashMap);
        }
    }

    /* loaded from: classes3.dex */
    public final class ValueIterator extends AntiCollisionHashMap<K, V>.HashIterator<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AntiCollisionHashMap this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ValueIterator(AntiCollisionHashMap antiCollisionHashMap) {
            super(antiCollisionHashMap);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {antiCollisionHashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((AntiCollisionHashMap) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = antiCollisionHashMap;
        }

        @Override // java.util.Iterator
        public V next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? nextEntry().value : (V) invokeV.objValue;
        }

        public /* synthetic */ ValueIterator(AntiCollisionHashMap antiCollisionHashMap, AnonymousClass1 anonymousClass1) {
            this(antiCollisionHashMap);
        }
    }

    /* loaded from: classes3.dex */
    public final class Values extends AbstractCollection<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AntiCollisionHashMap this$0;

        public Values(AntiCollisionHashMap antiCollisionHashMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {antiCollisionHashMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = antiCollisionHashMap;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.this$0.clear();
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? this.this$0.containsValue(obj) : invokeL.booleanValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.this$0.newValueIterator() : (Iterator) invokeV.objValue;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.this$0.size : invokeV.intValue;
        }

        public /* synthetic */ Values(AntiCollisionHashMap antiCollisionHashMap, AnonymousClass1 anonymousClass1) {
            this(antiCollisionHashMap);
        }
    }

    public AntiCollisionHashMap(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2), Float.valueOf(f2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(VideoItemModel.TYPE_LOADING);
        this.entrySet = null;
        if (i2 >= 0) {
            i2 = i2 > 1073741824 ? 1073741824 : i2;
            if (f2 > 0.0f && !Float.isNaN(f2)) {
                int i5 = 1;
                while (i5 < i2) {
                    i5 <<= 1;
                }
                this.loadFactor = f2;
                this.threshold = (int) (i5 * f2);
                this.table = new Entry[i5];
                init();
                return;
            }
            throw new IllegalArgumentException("Illegal load factor: " + f2);
        }
        throw new IllegalArgumentException("Illegal initial capacity: " + i2);
    }

    private boolean containsNullValue() {
        InterceptResult invokeV;
        Entry<K, V>[] entryArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            for (Entry<K, V> entry : this.table) {
                for (; entry != null; entry = entry.next) {
                    if (entry.value == null) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private Set<Map.Entry<K, V>> entrySet0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            Set<Map.Entry<K, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            EntrySet entrySet = new EntrySet(this, null);
            this.entrySet = entrySet;
            return entrySet;
        }
        return (Set) invokeV.objValue;
    }

    private V getForNullKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            for (Entry<K, V> entry = this.table[0]; entry != null; entry = entry.next) {
                if (entry.key == null) {
                    return entry.value;
                }
            }
            return null;
        }
        return (V) invokeV.objValue;
    }

    public static int hash(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65543, null, i2)) == null) {
            int i3 = i2 * i2;
            int i4 = i3 ^ ((i3 >>> 20) ^ (i3 >>> 12));
            return (i4 >>> 4) ^ ((i4 >>> 7) ^ i4);
        }
        return invokeI.intValue;
    }

    private int hashString(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, this, str)) == null) {
            int i2 = this.random * SEED;
            for (int i3 = 0; i3 < str.length(); i3++) {
                i2 = (i2 * KEY) ^ str.charAt(i3);
            }
            return ((i2 >> 1) ^ i2) & M_MASK;
        }
        return invokeL.intValue;
    }

    public static int indexFor(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(65545, null, i2, i3)) == null) ? i2 & (i3 - 1) : invokeII.intValue;
    }

    private void putAllForCreate(Map<? extends K, ? extends V> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, this, map) == null) {
            for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
                putForCreate(entry.getKey(), entry.getValue());
            }
        }
    }

    private void putForCreate(K k, V v) {
        int hash;
        K k2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, this, k, v) == null) {
            if (k == null) {
                hash = 0;
            } else if (k instanceof String) {
                hash = hash(hashString((String) k));
            } else {
                hash = hash(k.hashCode());
            }
            int indexFor = indexFor(hash, this.table.length);
            for (Entry<K, V> entry = this.table[indexFor]; entry != null; entry = entry.next) {
                if (entry.hash == hash && ((k2 = entry.key) == k || (k != null && k.equals(k2)))) {
                    entry.value = v;
                    return;
                }
            }
            createEntry(hash, k, v, indexFor);
        }
    }

    private V putForNullKey(V v) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65548, this, v)) == null) {
            for (Entry<K, V> entry = this.table[0]; entry != null; entry = entry.next) {
                if (entry.key == null) {
                    V v2 = entry.value;
                    entry.value = v;
                    return v2;
                }
            }
            this.modCount++;
            addEntry(0, null, v, 0);
            return null;
        }
        return (V) invokeL.objValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.alibaba.fastjson.util.AntiCollisionHashMap<K, V> */
    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, objectInputStream) == null) {
            objectInputStream.defaultReadObject();
            this.table = new Entry[objectInputStream.readInt()];
            init();
            int readInt = objectInputStream.readInt();
            for (int i2 = 0; i2 < readInt; i2++) {
                putForCreate(objectInputStream.readObject(), objectInputStream.readObject());
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, objectOutputStream) == null) {
            Iterator<Map.Entry<K, V>> it = this.size > 0 ? entrySet0().iterator() : null;
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeInt(this.table.length);
            objectOutputStream.writeInt(this.size);
            if (it != null) {
                while (it.hasNext()) {
                    Map.Entry<K, V> next = it.next();
                    objectOutputStream.writeObject(next.getKey());
                    objectOutputStream.writeObject(next.getValue());
                }
            }
        }
    }

    public void addEntry(int i2, K k, V v, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), k, v, Integer.valueOf(i3)}) == null) {
            Entry<K, V>[] entryArr = this.table;
            entryArr[i3] = new Entry<>(i2, k, v, entryArr[i3]);
            int i4 = this.size;
            this.size = i4 + 1;
            if (i4 >= this.threshold) {
                resize(this.table.length * 2);
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.modCount++;
            Entry<K, V>[] entryArr = this.table;
            for (int i2 = 0; i2 < entryArr.length; i2++) {
                entryArr[i2] = null;
            }
            this.size = 0;
        }
    }

    @Override // java.util.AbstractMap
    public Object clone() {
        InterceptResult invokeV;
        AntiCollisionHashMap antiCollisionHashMap;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                antiCollisionHashMap = (AntiCollisionHashMap) super.clone();
            } catch (CloneNotSupportedException unused) {
                antiCollisionHashMap = null;
            }
            antiCollisionHashMap.table = new Entry[this.table.length];
            antiCollisionHashMap.entrySet = null;
            antiCollisionHashMap.modCount = 0;
            antiCollisionHashMap.size = 0;
            antiCollisionHashMap.init();
            antiCollisionHashMap.putAllForCreate(this);
            return antiCollisionHashMap;
        }
        return invokeV.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) ? getEntry(obj) != null : invokeL.booleanValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Entry<K, V>[] entryArr;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (obj == null) {
                return containsNullValue();
            }
            for (Entry<K, V> entry : this.table) {
                for (; entry != null; entry = entry.next) {
                    if (obj.equals(entry.value)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void createEntry(int i2, K k, V v, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{Integer.valueOf(i2), k, v, Integer.valueOf(i3)}) == null) {
            Entry<K, V>[] entryArr = this.table;
            entryArr[i3] = new Entry<>(i2, k, v, entryArr[i3]);
            this.size++;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? entrySet0() : (Set) invokeV.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        InterceptResult invokeL;
        int hash;
        K k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (obj == null) {
                return getForNullKey();
            }
            if (obj instanceof String) {
                hash = hash(hashString((String) obj));
            } else {
                hash = hash(obj.hashCode());
            }
            Entry<K, V>[] entryArr = this.table;
            for (Entry<K, V> entry = entryArr[indexFor(hash, entryArr.length)]; entry != null; entry = entry.next) {
                if (entry.hash == hash && ((k = entry.key) == obj || obj.equals(k))) {
                    return entry.value;
                }
            }
            return null;
        }
        return (V) invokeL.objValue;
    }

    public final Entry<K, V> getEntry(Object obj) {
        InterceptResult invokeL;
        int hash;
        K k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj)) == null) {
            if (obj == null) {
                hash = 0;
            } else if (obj instanceof String) {
                hash = hash(hashString((String) obj));
            } else {
                hash = hash(obj.hashCode());
            }
            Entry<K, V>[] entryArr = this.table;
            for (Entry<K, V> entry = entryArr[indexFor(hash, entryArr.length)]; entry != null; entry = entry.next) {
                if (entry.hash == hash && ((k = entry.key) == obj || (obj != null && obj.equals(k)))) {
                    return entry;
                }
            }
            return null;
        }
        return (Entry) invokeL.objValue;
    }

    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.size == 0 : invokeV.booleanValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            KeySet keySet = new KeySet(this, null);
            this.keySet = keySet;
            return keySet;
        }
        return (Set) invokeV.objValue;
    }

    public Iterator<Map.Entry<K, V>> newEntryIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? new EntryIterator(this, null) : (Iterator) invokeV.objValue;
    }

    public Iterator<K> newKeyIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? new KeyIterator(this, null) : (Iterator) invokeV.objValue;
    }

    public Iterator<V> newValueIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? new ValueIterator(this, null) : (Iterator) invokeV.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        InterceptResult invokeLL;
        int hash;
        K k2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048591, this, k, v)) == null) {
            if (k == null) {
                return putForNullKey(v);
            }
            if (k instanceof String) {
                hash = hash(hashString((String) k));
            } else {
                hash = hash(k.hashCode());
            }
            int indexFor = indexFor(hash, this.table.length);
            for (Entry<K, V> entry = this.table[indexFor]; entry != null; entry = entry.next) {
                if (entry.hash == hash && ((k2 = entry.key) == k || k.equals(k2))) {
                    V v2 = entry.value;
                    entry.value = v;
                    return v2;
                }
            }
            this.modCount++;
            addEntry(hash, k, v, indexFor);
            return null;
        }
        return (V) invokeLL.objValue;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        int size;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048592, this, map) == null) || (size = map.size()) == 0) {
            return;
        }
        if (size > this.threshold) {
            int i2 = (int) ((size / this.loadFactor) + 1.0f);
            if (i2 > 1073741824) {
                i2 = 1073741824;
            }
            int length = this.table.length;
            while (length < i2) {
                length <<= 1;
            }
            if (length > this.table.length) {
                resize(length);
            }
        }
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, obj)) == null) {
            Entry<K, V> removeEntryForKey = removeEntryForKey(obj);
            if (removeEntryForKey == null) {
                return null;
            }
            return removeEntryForKey.value;
        }
        return (V) invokeL.objValue;
    }

    public final Entry<K, V> removeEntryForKey(Object obj) {
        InterceptResult invokeL;
        int hash;
        K k;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, obj)) == null) {
            if (obj == null) {
                hash = 0;
            } else if (obj instanceof String) {
                hash = hash(hashString((String) obj));
            } else {
                hash = hash(obj.hashCode());
            }
            int indexFor = indexFor(hash, this.table.length);
            Entry<K, V> entry = this.table[indexFor];
            Entry<K, V> entry2 = entry;
            while (entry != null) {
                Entry<K, V> entry3 = entry.next;
                if (entry.hash == hash && ((k = entry.key) == obj || (obj != null && obj.equals(k)))) {
                    this.modCount++;
                    this.size--;
                    if (entry2 == entry) {
                        this.table[indexFor] = entry3;
                    } else {
                        entry2.next = entry3;
                    }
                    return entry;
                }
                entry2 = entry;
                entry = entry3;
            }
            return entry;
        }
        return (Entry) invokeL.objValue;
    }

    public final Entry<K, V> removeMapping(Object obj) {
        InterceptResult invokeL;
        int hash;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                if (key == null) {
                    hash = 0;
                } else if (key instanceof String) {
                    hash = hash(hashString((String) key));
                } else {
                    hash = hash(key.hashCode());
                }
                int indexFor = indexFor(hash, this.table.length);
                Entry<K, V> entry2 = this.table[indexFor];
                Entry<K, V> entry3 = entry2;
                while (entry2 != null) {
                    Entry<K, V> entry4 = entry2.next;
                    if (entry2.hash == hash && entry2.equals(entry)) {
                        this.modCount++;
                        this.size--;
                        if (entry3 == entry2) {
                            this.table[indexFor] = entry4;
                        } else {
                            entry3.next = entry4;
                        }
                        return entry2;
                    }
                    entry3 = entry2;
                    entry2 = entry4;
                }
                return entry2;
            }
            return null;
        }
        return (Entry) invokeL.objValue;
    }

    public void resize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            if (this.table.length == 1073741824) {
                this.threshold = Integer.MAX_VALUE;
                return;
            }
            Entry<K, V>[] entryArr = new Entry[i2];
            transfer(entryArr);
            this.table = entryArr;
            this.threshold = (int) (i2 * this.loadFactor);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.size : invokeV.intValue;
    }

    public void transfer(Entry[] entryArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, entryArr) == null) {
            Entry<K, V>[] entryArr2 = this.table;
            int length = entryArr.length;
            for (int i2 = 0; i2 < entryArr2.length; i2++) {
                Entry<K, V> entry = entryArr2[i2];
                if (entry != null) {
                    entryArr2[i2] = null;
                    while (true) {
                        Entry<K, V> entry2 = entry.next;
                        int indexFor = indexFor(entry.hash, length);
                        entry.next = entryArr[indexFor];
                        entryArr[indexFor] = entry;
                        if (entry2 == null) {
                            break;
                        }
                        entry = entry2;
                    }
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            Values values = new Values(this, null);
            this.values = values;
            return values;
        }
        return (Collection) invokeV.objValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AntiCollisionHashMap(int i2) {
        this(i2, 0.75f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public AntiCollisionHashMap() {
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
        this.keySet = null;
        this.values = null;
        this.random = new Random().nextInt(VideoItemModel.TYPE_LOADING);
        this.entrySet = null;
        this.loadFactor = 0.75f;
        this.threshold = 12;
        this.table = new Entry[16];
        init();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AntiCollisionHashMap(Map<? extends K, ? extends V> map) {
        this(Math.max(((int) (map.size() / 0.75f)) + 1, 16), 0.75f);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {map};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Integer) objArr2[0]).intValue(), ((Float) objArr2[1]).floatValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        putAllForCreate(map);
    }
}
