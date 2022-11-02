package androidx.collection;

import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class MapCollections<K, V> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public MapCollections<K, V>.EntrySet mEntrySet;
    @Nullable
    public MapCollections<K, V>.KeySet mKeySet;
    @Nullable
    public MapCollections<K, V>.ValuesCollection mValues;

    public abstract void colClear();

    public abstract Object colGetEntry(int i, int i2);

    public abstract Map<K, V> colGetMap();

    public abstract int colGetSize();

    public abstract int colIndexOfKey(Object obj);

    public abstract int colIndexOfValue(Object obj);

    public abstract void colPut(K k, V v);

    public abstract void colRemoveAt(int i);

    public abstract V colSetValue(int i, V v);

    /* loaded from: classes.dex */
    public final class ArrayIterator<T> implements Iterator<T> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mCanRemove;
        public int mIndex;
        public final int mOffset;
        public int mSize;
        public final /* synthetic */ MapCollections this$0;

        public ArrayIterator(MapCollections mapCollections, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapCollections, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mapCollections;
            this.mCanRemove = false;
            this.mOffset = i;
            this.mSize = mapCollections.colGetSize();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mIndex < this.mSize) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public T next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (hasNext()) {
                    T t = (T) this.this$0.colGetEntry(this.mIndex, this.mOffset);
                    this.mIndex++;
                    this.mCanRemove = true;
                    return t;
                }
                throw new NoSuchElementException();
            }
            return (T) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                if (this.mCanRemove) {
                    int i = this.mIndex - 1;
                    this.mIndex = i;
                    this.mSize--;
                    this.mCanRemove = false;
                    this.this$0.colRemoveAt(i);
                    return;
                }
                throw new IllegalStateException();
            }
        }
    }

    /* loaded from: classes.dex */
    public final class EntrySet implements Set<Map.Entry<K, V>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MapCollections this$0;

        public EntrySet(MapCollections mapCollections) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapCollections};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mapCollections;
        }

        @Override // java.util.Set, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            return add((Map.Entry) ((Map.Entry) obj));
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, collection)) == null) {
                Iterator<?> it = collection.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, obj)) == null) {
                return MapCollections.equalsSetHelper(this, obj);
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, obj)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, collection)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, collection)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, tArr)) == null) {
                throw new UnsupportedOperationException();
            }
            return (T[]) ((Object[]) invokeL.objValue);
        }

        public boolean add(Map.Entry<K, V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) {
                int colGetSize = this.this$0.colGetSize();
                for (Map.Entry<K, V> entry : collection) {
                    this.this$0.colPut(entry.getKey(), entry.getValue());
                }
                if (colGetSize != this.this$0.colGetSize()) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                int colIndexOfKey = this.this$0.colIndexOfKey(entry.getKey());
                if (colIndexOfKey < 0) {
                    return false;
                }
                return ContainerHelpers.equal(this.this$0.colGetEntry(colIndexOfKey, 1), entry.getValue());
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.this$0.colClear();
            }
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                if (this.this$0.colGetSize() == 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return new MapIterator(this.this$0);
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.this$0.colGetSize();
            }
            return invokeV.intValue;
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
                throw new UnsupportedOperationException();
            }
            return (Object[]) invokeV.objValue;
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            int hashCode2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                int i = 0;
                for (int colGetSize = this.this$0.colGetSize() - 1; colGetSize >= 0; colGetSize--) {
                    Object colGetEntry = this.this$0.colGetEntry(colGetSize, 0);
                    Object colGetEntry2 = this.this$0.colGetEntry(colGetSize, 1);
                    if (colGetEntry == null) {
                        hashCode = 0;
                    } else {
                        hashCode = colGetEntry.hashCode();
                    }
                    if (colGetEntry2 == null) {
                        hashCode2 = 0;
                    } else {
                        hashCode2 = colGetEntry2.hashCode();
                    }
                    i += hashCode ^ hashCode2;
                }
                return i;
            }
            return invokeV.intValue;
        }
    }

    /* loaded from: classes.dex */
    public final class KeySet implements Set<K> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MapCollections this$0;

        public KeySet(MapCollections mapCollections) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapCollections};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mapCollections;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, k)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this.this$0.colIndexOfKey(obj) >= 0) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, collection)) == null) {
                return MapCollections.containsAllHelper(this.this$0.colGetMap(), collection);
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
                return MapCollections.equalsSetHelper(this, obj);
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
                int colIndexOfKey = this.this$0.colIndexOfKey(obj);
                if (colIndexOfKey >= 0) {
                    this.this$0.colRemoveAt(colIndexOfKey);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, collection)) == null) {
                return MapCollections.removeAllHelper(this.this$0.colGetMap(), collection);
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, collection)) == null) {
                return MapCollections.retainAllHelper(this.this$0.colGetMap(), collection);
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, tArr)) == null) {
                return (T[]) this.this$0.toArrayHelper(tArr, 0);
            }
            return (T[]) ((Object[]) invokeL.objValue);
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.this$0.colClear();
            }
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                int i = 0;
                for (int colGetSize = this.this$0.colGetSize() - 1; colGetSize >= 0; colGetSize--) {
                    Object colGetEntry = this.this$0.colGetEntry(colGetSize, 0);
                    if (colGetEntry == null) {
                        hashCode = 0;
                    } else {
                        hashCode = colGetEntry.hashCode();
                    }
                    i += hashCode;
                }
                return i;
            }
            return invokeV.intValue;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.this$0.colGetSize() == 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
                return new ArrayIterator(this.this$0, 0);
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
                return this.this$0.colGetSize();
            }
            return invokeV.intValue;
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
                return this.this$0.toArrayHelper(0);
            }
            return (Object[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public final class MapIterator implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mEnd;
        public boolean mEntryValid;
        public int mIndex;
        public final /* synthetic */ MapCollections this$0;

        public MapIterator(MapCollections mapCollections) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapCollections};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mapCollections;
            this.mEntryValid = false;
            this.mEnd = mapCollections.colGetSize() - 1;
            this.mIndex = -1;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (this.mEntryValid) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    if (!ContainerHelpers.equal(entry.getKey(), this.this$0.colGetEntry(this.mIndex, 0)) || !ContainerHelpers.equal(entry.getValue(), this.this$0.colGetEntry(this.mIndex, 1))) {
                        return false;
                    }
                    return true;
                }
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.mEntryValid) {
                    return (K) this.this$0.colGetEntry(this.mIndex, 0);
                }
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (K) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.mEntryValid) {
                    return (V) this.this$0.colGetEntry(this.mIndex, 1);
                }
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) invokeV.objValue;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                if (this.mIndex < this.mEnd) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Iterator
        public void remove() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                if (this.mEntryValid) {
                    this.this$0.colRemoveAt(this.mIndex);
                    this.mIndex--;
                    this.mEnd--;
                    this.mEntryValid = false;
                    return;
                }
                throw new IllegalStateException();
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
                return getKey() + "=" + getValue();
            }
            return (String) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            InterceptResult invokeV;
            int hashCode;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                if (this.mEntryValid) {
                    int i = 0;
                    Object colGetEntry = this.this$0.colGetEntry(this.mIndex, 0);
                    Object colGetEntry2 = this.this$0.colGetEntry(this.mIndex, 1);
                    if (colGetEntry == null) {
                        hashCode = 0;
                    } else {
                        hashCode = colGetEntry.hashCode();
                    }
                    if (colGetEntry2 != null) {
                        i = colGetEntry2.hashCode();
                    }
                    return hashCode ^ i;
                }
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return invokeV.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                if (hasNext()) {
                    this.mIndex++;
                    this.mEntryValid = true;
                    return this;
                }
                throw new NoSuchElementException();
            }
            return (Map.Entry) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, v)) == null) {
                if (this.mEntryValid) {
                    return (V) this.this$0.colSetValue(this.mIndex, v);
                }
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            return (V) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public final class ValuesCollection implements Collection<V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MapCollections this$0;

        public ValuesCollection(MapCollections mapCollections) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {mapCollections};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = mapCollections;
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, v)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection)) == null) {
                throw new UnsupportedOperationException();
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
                if (this.this$0.colIndexOfValue(obj) >= 0) {
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, collection)) == null) {
                Iterator<?> it = collection.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        return false;
                    }
                }
                return true;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
                int colIndexOfValue = this.this$0.colIndexOfValue(obj);
                if (colIndexOfValue >= 0) {
                    this.this$0.colRemoveAt(colIndexOfValue);
                    return true;
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, tArr)) == null) {
                return (T[]) this.this$0.toArrayHelper(tArr, 1);
            }
            return (T[]) ((Object[]) invokeL.objValue);
        }

        @Override // java.util.Collection
        public void clear() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.this$0.colClear();
            }
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                if (this.this$0.colGetSize() == 0) {
                    return true;
                }
                return false;
            }
            return invokeV.booleanValue;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
                return new ArrayIterator(this.this$0, 1);
            }
            return (Iterator) invokeV.objValue;
        }

        @Override // java.util.Collection
        public int size() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
                return this.this$0.colGetSize();
            }
            return invokeV.intValue;
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
                return this.this$0.toArrayHelper(1);
            }
            return (Object[]) invokeV.objValue;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, collection)) == null) {
                int colGetSize = this.this$0.colGetSize();
                int i = 0;
                boolean z = false;
                while (i < colGetSize) {
                    if (collection.contains(this.this$0.colGetEntry(i, 1))) {
                        this.this$0.colRemoveAt(i);
                        i--;
                        colGetSize--;
                        z = true;
                    }
                    i++;
                }
                return z;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, collection)) == null) {
                int colGetSize = this.this$0.colGetSize();
                int i = 0;
                boolean z = false;
                while (i < colGetSize) {
                    if (!collection.contains(this.this$0.colGetEntry(i, 1))) {
                        this.this$0.colRemoveAt(i);
                        i--;
                        colGetSize--;
                        z = true;
                    }
                    i++;
                }
                return z;
            }
            return invokeL.booleanValue;
        }
    }

    public MapCollections() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public Set<Map.Entry<K, V>> getEntrySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (this.mEntrySet == null) {
                this.mEntrySet = new EntrySet(this);
            }
            return this.mEntrySet;
        }
        return (Set) invokeV.objValue;
    }

    public Set<K> getKeySet() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            if (this.mKeySet == null) {
                this.mKeySet = new KeySet(this);
            }
            return this.mKeySet;
        }
        return (Set) invokeV.objValue;
    }

    public Collection<V> getValues() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            if (this.mValues == null) {
                this.mValues = new ValuesCollection(this);
            }
            return this.mValues;
        }
        return (Collection) invokeV.objValue;
    }

    public static <K, V> boolean containsAllHelper(Map<K, V> map, Collection<?> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, map, collection)) == null) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!map.containsKey(it.next())) {
                    return false;
                }
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static <T> boolean equalsSetHelper(Set<T> set, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, set, obj)) == null) {
            if (set == obj) {
                return true;
            }
            if (obj instanceof Set) {
                Set set2 = (Set) obj;
                try {
                    if (set.size() == set2.size()) {
                        if (set.containsAll(set2)) {
                            return true;
                        }
                    }
                    return false;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static <K, V> boolean removeAllHelper(Map<K, V> map, Collection<?> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, map, collection)) == null) {
            int size = map.size();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                map.remove(it.next());
            }
            if (size != map.size()) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static <K, V> boolean retainAllHelper(Map<K, V> map, Collection<?> collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, map, collection)) == null) {
            int size = map.size();
            Iterator<K> it = map.keySet().iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                }
            }
            if (size != map.size()) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v9, resolved type: T[] */
    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] toArrayHelper(T[] tArr, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048589, this, tArr, i)) == null) {
            int colGetSize = colGetSize();
            if (tArr.length < colGetSize) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), colGetSize));
            }
            for (int i2 = 0; i2 < colGetSize; i2++) {
                tArr[i2] = colGetEntry(i2, i);
            }
            if (tArr.length > colGetSize) {
                tArr[colGetSize] = null;
            }
            return tArr;
        }
        return (T[]) ((Object[]) invokeLI.objValue);
    }

    public Object[] toArrayHelper(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            int colGetSize = colGetSize();
            Object[] objArr = new Object[colGetSize];
            for (int i2 = 0; i2 < colGetSize; i2++) {
                objArr[i2] = colGetEntry(i2, i);
            }
            return objArr;
        }
        return (Object[]) invokeI.objValue;
    }
}
