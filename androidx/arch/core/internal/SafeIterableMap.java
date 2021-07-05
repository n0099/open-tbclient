package androidx.arch.core.internal;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class SafeIterableMap<K, V> implements Iterable<Map.Entry<K, V>> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Entry<K, V> mEnd;
    public WeakHashMap<SupportRemove<K, V>, Boolean> mIterators;
    public int mSize;
    public Entry<K, V> mStart;

    /* loaded from: classes.dex */
    public static class AscendingIterator<K, V> extends ListIterator<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AscendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {entry, entry2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Entry) objArr2[0], (Entry) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> backward(Entry<K, V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, entry)) == null) ? entry.mPrevious : (Entry) invokeL.objValue;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> forward(Entry<K, V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) ? entry.mNext : (Entry) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class DescendingIterator<K, V> extends ListIterator<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DescendingIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            super(entry, entry2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {entry, entry2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Entry) objArr2[0], (Entry) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> backward(Entry<K, V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, entry)) == null) ? entry.mNext : (Entry) invokeL.objValue;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.ListIterator
        public Entry<K, V> forward(Entry<K, V> entry) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, entry)) == null) ? entry.mPrevious : (Entry) invokeL.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static class Entry<K, V> implements Map.Entry<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public final K mKey;
        public Entry<K, V> mNext;
        public Entry<K, V> mPrevious;
        @NonNull
        public final V mValue;

        public Entry(@NonNull K k, @NonNull V v) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k, v};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mKey = k;
            this.mValue = v;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof Entry) {
                    Entry entry = (Entry) obj;
                    return this.mKey.equals(entry.mKey) && this.mValue.equals(entry.mValue);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public K getKey() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mKey : (K) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        @NonNull
        public V getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mValue : (V) invokeV.objValue;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mKey.hashCode() ^ this.mValue.hashCode() : invokeV.intValue;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, v)) == null) {
                throw new UnsupportedOperationException("An entry modification is not supported");
            }
            return (V) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
                return this.mKey + "=" + this.mValue;
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public class IteratorWithAdditions implements Iterator<Map.Entry<K, V>>, SupportRemove<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean mBeforeStart;
        public Entry<K, V> mCurrent;
        public final /* synthetic */ SafeIterableMap this$0;

        public IteratorWithAdditions(SafeIterableMap safeIterableMap) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {safeIterableMap};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = safeIterableMap;
            this.mBeforeStart = true;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                if (this.mBeforeStart) {
                    return this.this$0.mStart != null;
                }
                Entry<K, V> entry = this.mCurrent;
                return (entry == null || entry.mNext == null) ? false : true;
            }
            return invokeV.booleanValue;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(@NonNull Entry<K, V> entry) {
            Entry<K, V> entry2;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048579, this, entry) == null) && entry == (entry2 = this.mCurrent)) {
                Entry<K, V> entry3 = entry2.mPrevious;
                this.mCurrent = entry3;
                this.mBeforeStart = entry3 == null;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                if (this.mBeforeStart) {
                    this.mBeforeStart = false;
                    this.mCurrent = this.this$0.mStart;
                } else {
                    Entry<K, V> entry = this.mCurrent;
                    this.mCurrent = entry != null ? entry.mNext : null;
                }
                return this.mCurrent;
            }
            return (Map.Entry) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class ListIterator<K, V> implements Iterator<Map.Entry<K, V>>, SupportRemove<K, V> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Entry<K, V> mExpectedEnd;
        public Entry<K, V> mNext;

        public ListIterator(Entry<K, V> entry, Entry<K, V> entry2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {entry, entry2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mExpectedEnd = entry2;
            this.mNext = entry;
        }

        private Entry<K, V> nextNode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                Entry<K, V> entry = this.mNext;
                Entry<K, V> entry2 = this.mExpectedEnd;
                if (entry == entry2 || entry2 == null) {
                    return null;
                }
                return forward(entry);
            }
            return (Entry) invokeV.objValue;
        }

        public abstract Entry<K, V> backward(Entry<K, V> entry);

        public abstract Entry<K, V> forward(Entry<K, V> entry);

        @Override // java.util.Iterator
        public boolean hasNext() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mNext != null : invokeV.booleanValue;
        }

        @Override // androidx.arch.core.internal.SafeIterableMap.SupportRemove
        public void supportRemove(@NonNull Entry<K, V> entry) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048581, this, entry) == null) {
                if (this.mExpectedEnd == entry && entry == this.mNext) {
                    this.mNext = null;
                    this.mExpectedEnd = null;
                }
                Entry<K, V> entry2 = this.mExpectedEnd;
                if (entry2 == entry) {
                    this.mExpectedEnd = backward(entry2);
                }
                if (this.mNext == entry) {
                    this.mNext = nextNode();
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                Entry<K, V> entry = this.mNext;
                this.mNext = nextNode();
                return entry;
            }
            return (Map.Entry) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface SupportRemove<K, V> {
        void supportRemove(@NonNull Entry<K, V> entry);
    }

    public SafeIterableMap() {
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
        this.mIterators = new WeakHashMap<>();
        this.mSize = 0;
    }

    public Iterator<Map.Entry<K, V>> descendingIterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            DescendingIterator descendingIterator = new DescendingIterator(this.mEnd, this.mStart);
            this.mIterators.put(descendingIterator, Boolean.FALSE);
            return descendingIterator;
        }
        return (Iterator) invokeV.objValue;
    }

    public Map.Entry<K, V> eldest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mStart : (Map.Entry) invokeV.objValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof SafeIterableMap) {
                SafeIterableMap safeIterableMap = (SafeIterableMap) obj;
                if (size() != safeIterableMap.size()) {
                    return false;
                }
                Iterator<Map.Entry<K, V>> it = iterator();
                Iterator<Map.Entry<K, V>> it2 = safeIterableMap.iterator();
                while (it.hasNext() && it2.hasNext()) {
                    Map.Entry<K, V> next = it.next();
                    Map.Entry<K, V> next2 = it2.next();
                    if ((next == null && next2 != null) || (next != null && !next.equals(next2))) {
                        return false;
                    }
                }
                return (it.hasNext() || it2.hasNext()) ? false : true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public Entry<K, V> get(K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, k)) == null) {
            Entry<K, V> entry = this.mStart;
            while (entry != null && !entry.mKey.equals(k)) {
                entry = entry.mNext;
            }
            return entry;
        }
        return (Entry) invokeL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            Iterator<Map.Entry<K, V>> it = iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i2 += it.next().hashCode();
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // java.lang.Iterable
    @NonNull
    public Iterator<Map.Entry<K, V>> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            AscendingIterator ascendingIterator = new AscendingIterator(this.mStart, this.mEnd);
            this.mIterators.put(ascendingIterator, Boolean.FALSE);
            return ascendingIterator;
        }
        return (Iterator) invokeV.objValue;
    }

    public SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SafeIterableMap<K, V>.IteratorWithAdditions iteratorWithAdditions = new IteratorWithAdditions(this);
            this.mIterators.put(iteratorWithAdditions, Boolean.FALSE);
            return iteratorWithAdditions;
        }
        return (IteratorWithAdditions) invokeV.objValue;
    }

    public Map.Entry<K, V> newest() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.mEnd : (Map.Entry) invokeV.objValue;
    }

    public Entry<K, V> put(@NonNull K k, @NonNull V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, k, v)) == null) {
            Entry<K, V> entry = new Entry<>(k, v);
            this.mSize++;
            Entry<K, V> entry2 = this.mEnd;
            if (entry2 == null) {
                this.mStart = entry;
                this.mEnd = entry;
                return entry;
            }
            entry2.mNext = entry;
            entry.mPrevious = entry2;
            this.mEnd = entry;
            return entry;
        }
        return (Entry) invokeLL.objValue;
    }

    public V putIfAbsent(@NonNull K k, @NonNull V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048585, this, k, v)) == null) {
            Entry<K, V> entry = get(k);
            if (entry != null) {
                return entry.mValue;
            }
            put(k, v);
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public V remove(@NonNull K k) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, k)) == null) {
            Entry<K, V> entry = get(k);
            if (entry == null) {
                return null;
            }
            this.mSize--;
            if (!this.mIterators.isEmpty()) {
                for (SupportRemove<K, V> supportRemove : this.mIterators.keySet()) {
                    supportRemove.supportRemove(entry);
                }
            }
            Entry<K, V> entry2 = entry.mPrevious;
            if (entry2 != null) {
                entry2.mNext = entry.mNext;
            } else {
                this.mStart = entry.mNext;
            }
            Entry<K, V> entry3 = entry.mNext;
            if (entry3 != null) {
                entry3.mPrevious = entry.mPrevious;
            } else {
                this.mEnd = entry.mPrevious;
            }
            entry.mNext = null;
            entry.mPrevious = null;
            return entry.mValue;
        }
        return (V) invokeL.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.mSize : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(PreferencesUtil.LEFT_MOUNT);
            Iterator<Map.Entry<K, V>> it = iterator();
            while (it.hasNext()) {
                sb.append(it.next().toString());
                if (it.hasNext()) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
            }
            sb.append(PreferencesUtil.RIGHT_MOUNT);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
