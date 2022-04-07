package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class ArraySet<E> implements Collection<E>, Set<E> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BASE_SIZE = 4;
    public static final int CACHE_SIZE = 10;
    public static final boolean DEBUG = false;
    public static final int[] INT;
    public static final Object[] OBJECT;
    public static final String TAG = "ArraySet";
    @Nullable
    public static Object[] sBaseCache;
    public static int sBaseCacheSize;
    @Nullable
    public static Object[] sTwiceBaseCache;
    public static int sTwiceBaseCacheSize;
    public transient /* synthetic */ FieldHolder $fh;
    public Object[] mArray;
    public MapCollections<E, E> mCollections;
    public int[] mHashes;
    public int mSize;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2132668763, "Landroidx/collection/ArraySet;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2132668763, "Landroidx/collection/ArraySet;");
                return;
            }
        }
        INT = new int[0];
        OBJECT = new Object[0];
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ArraySet() {
        this(0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void allocArrays(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65541, this, i) == null) {
            if (i == 8) {
                synchronized (ArraySet.class) {
                    if (sTwiceBaseCache != null) {
                        Object[] objArr = sTwiceBaseCache;
                        this.mArray = objArr;
                        sTwiceBaseCache = (Object[]) objArr[0];
                        this.mHashes = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        sTwiceBaseCacheSize--;
                        return;
                    }
                }
            } else if (i == 4) {
                synchronized (ArraySet.class) {
                    if (sBaseCache != null) {
                        Object[] objArr2 = sBaseCache;
                        this.mArray = objArr2;
                        sBaseCache = (Object[]) objArr2[0];
                        this.mHashes = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        sBaseCacheSize--;
                        return;
                    }
                }
            }
            this.mHashes = new int[i];
            this.mArray = new Object[i];
        }
    }

    public static void freeArrays(int[] iArr, Object[] objArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65542, null, iArr, objArr, i) == null) {
            if (iArr.length == 8) {
                synchronized (ArraySet.class) {
                    if (sTwiceBaseCacheSize < 10) {
                        objArr[0] = sTwiceBaseCache;
                        objArr[1] = iArr;
                        for (int i2 = i - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        sTwiceBaseCache = objArr;
                        sTwiceBaseCacheSize++;
                    }
                }
            } else if (iArr.length == 4) {
                synchronized (ArraySet.class) {
                    if (sBaseCacheSize < 10) {
                        objArr[0] = sBaseCache;
                        objArr[1] = iArr;
                        for (int i3 = i - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        sBaseCache = objArr;
                        sBaseCacheSize++;
                    }
                }
            }
        }
    }

    private MapCollections<E, E> getCollection() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            if (this.mCollections == null) {
                this.mCollections = new MapCollections<E, E>(this) { // from class: androidx.collection.ArraySet.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ ArraySet this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // androidx.collection.MapCollections
                    public void colClear() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.clear();
                        }
                    }

                    @Override // androidx.collection.MapCollections
                    public Object colGetEntry(int i, int i2) {
                        InterceptResult invokeII;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeII = interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, i2)) == null) ? this.this$0.mArray[i] : invokeII.objValue;
                    }

                    @Override // androidx.collection.MapCollections
                    public Map<E, E> colGetMap() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV2 = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                            throw new UnsupportedOperationException("not a map");
                        }
                        return (Map) invokeV2.objValue;
                    }

                    @Override // androidx.collection.MapCollections
                    public int colGetSize() {
                        InterceptResult invokeV2;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV2 = interceptable2.invokeV(1048579, this)) == null) ? this.this$0.mSize : invokeV2.intValue;
                    }

                    @Override // androidx.collection.MapCollections
                    public int colIndexOfKey(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048580, this, obj)) == null) ? this.this$0.indexOf(obj) : invokeL.intValue;
                    }

                    @Override // androidx.collection.MapCollections
                    public int colIndexOfValue(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeL = interceptable2.invokeL(1048581, this, obj)) == null) ? this.this$0.indexOf(obj) : invokeL.intValue;
                    }

                    @Override // androidx.collection.MapCollections
                    public void colPut(E e, E e2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048582, this, e, e2) == null) {
                            this.this$0.add(e);
                        }
                    }

                    @Override // androidx.collection.MapCollections
                    public void colRemoveAt(int i) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048583, this, i) == null) {
                            this.this$0.removeAt(i);
                        }
                    }

                    @Override // androidx.collection.MapCollections
                    public E colSetValue(int i, E e) {
                        InterceptResult invokeIL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeIL = interceptable2.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, e)) == null) {
                            throw new UnsupportedOperationException("not a map");
                        }
                        return (E) invokeIL.objValue;
                    }
                };
            }
            return this.mCollections;
        }
        return (MapCollections) invokeV.objValue;
    }

    private int indexOf(Object obj, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, this, obj, i)) == null) {
            int i2 = this.mSize;
            if (i2 == 0) {
                return -1;
            }
            int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i2, i);
            if (binarySearch >= 0 && !obj.equals(this.mArray[binarySearch])) {
                int i3 = binarySearch + 1;
                while (i3 < i2 && this.mHashes[i3] == i) {
                    if (obj.equals(this.mArray[i3])) {
                        return i3;
                    }
                    i3++;
                }
                for (int i4 = binarySearch - 1; i4 >= 0 && this.mHashes[i4] == i; i4--) {
                    if (obj.equals(this.mArray[i4])) {
                        return i4;
                    }
                }
                return ~i3;
            }
            return binarySearch;
        }
        return invokeLI.intValue;
    }

    private int indexOfNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            int i = this.mSize;
            if (i == 0) {
                return -1;
            }
            int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i, 0);
            if (binarySearch >= 0 && this.mArray[binarySearch] != null) {
                int i2 = binarySearch + 1;
                while (i2 < i && this.mHashes[i2] == 0) {
                    if (this.mArray[i2] == null) {
                        return i2;
                    }
                    i2++;
                }
                for (int i3 = binarySearch - 1; i3 >= 0 && this.mHashes[i3] == 0; i3--) {
                    if (this.mArray[i3] == null) {
                        return i3;
                    }
                }
                return ~i2;
            }
            return binarySearch;
        }
        return invokeV.intValue;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(@Nullable E e) {
        InterceptResult invokeL;
        int i;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e)) == null) {
            if (e == null) {
                indexOf = indexOfNull();
                i = 0;
            } else {
                int hashCode = e.hashCode();
                i = hashCode;
                indexOf = indexOf(e, hashCode);
            }
            if (indexOf >= 0) {
                return false;
            }
            int i2 = ~indexOf;
            int i3 = this.mSize;
            if (i3 >= this.mHashes.length) {
                int i4 = 4;
                if (i3 >= 8) {
                    i4 = (i3 >> 1) + i3;
                } else if (i3 >= 4) {
                    i4 = 8;
                }
                int[] iArr = this.mHashes;
                Object[] objArr = this.mArray;
                allocArrays(i4);
                int[] iArr2 = this.mHashes;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
                }
                freeArrays(iArr, objArr, this.mSize);
            }
            int i5 = this.mSize;
            if (i2 < i5) {
                int[] iArr3 = this.mHashes;
                int i6 = i2 + 1;
                System.arraycopy(iArr3, i2, iArr3, i6, i5 - i2);
                Object[] objArr2 = this.mArray;
                System.arraycopy(objArr2, i2, objArr2, i6, this.mSize - i2);
            }
            this.mHashes[i2] = i;
            this.mArray[i2] = e;
            this.mSize++;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void addAll(@NonNull ArraySet<? extends E> arraySet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arraySet) == null) {
            int i = arraySet.mSize;
            ensureCapacity(this.mSize + i);
            if (this.mSize != 0) {
                for (int i2 = 0; i2 < i; i2++) {
                    add(arraySet.valueAt(i2));
                }
            } else if (i > 0) {
                System.arraycopy(arraySet.mHashes, 0, this.mHashes, 0, i);
                System.arraycopy(arraySet.mArray, 0, this.mArray, 0, i);
                this.mSize = i;
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (i = this.mSize) == 0) {
            return;
        }
        freeArrays(this.mHashes, this.mArray, i);
        this.mHashes = INT;
        this.mArray = OBJECT;
        this.mSize = 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) ? indexOf(obj) >= 0 : invokeL.booleanValue;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(@NonNull Collection<?> collection) {
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

    public void ensureCapacity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            int[] iArr = this.mHashes;
            if (iArr.length < i) {
                Object[] objArr = this.mArray;
                allocArrays(i);
                int i2 = this.mSize;
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i2);
                    System.arraycopy(objArr, 0, this.mArray, 0, this.mSize);
                }
                freeArrays(iArr, objArr, this.mSize);
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Set) {
                Set set = (Set) obj;
                if (size() != set.size()) {
                    return false;
                }
                for (int i = 0; i < this.mSize; i++) {
                    try {
                        if (!set.contains(valueAt(i))) {
                            return false;
                        }
                    } catch (ClassCastException | NullPointerException unused) {
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int[] iArr = this.mHashes;
            int i = this.mSize;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                i2 += iArr[i3];
            }
            return i2;
        }
        return invokeV.intValue;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mSize <= 0 : invokeV.booleanValue;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? getCollection().getKeySet().iterator() : (Iterator) invokeV.objValue;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, obj)) == null) {
            int indexOf = indexOf(obj);
            if (indexOf >= 0) {
                removeAt(indexOf);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean removeAll(@NonNull ArraySet<? extends E> arraySet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, arraySet)) == null) {
            int i = arraySet.mSize;
            int i2 = this.mSize;
            for (int i3 = 0; i3 < i; i3++) {
                remove(arraySet.valueAt(i3));
            }
            return i2 != this.mSize;
        }
        return invokeL.booleanValue;
    }

    public E removeAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i)) == null) {
            Object[] objArr = this.mArray;
            E e = (E) objArr[i];
            int i2 = this.mSize;
            if (i2 <= 1) {
                freeArrays(this.mHashes, objArr, i2);
                this.mHashes = INT;
                this.mArray = OBJECT;
                this.mSize = 0;
            } else {
                int[] iArr = this.mHashes;
                if (iArr.length > 8 && i2 < iArr.length / 3) {
                    int i3 = i2 > 8 ? i2 + (i2 >> 1) : 8;
                    int[] iArr2 = this.mHashes;
                    Object[] objArr2 = this.mArray;
                    allocArrays(i3);
                    this.mSize--;
                    if (i > 0) {
                        System.arraycopy(iArr2, 0, this.mHashes, 0, i);
                        System.arraycopy(objArr2, 0, this.mArray, 0, i);
                    }
                    int i4 = this.mSize;
                    if (i < i4) {
                        int i5 = i + 1;
                        System.arraycopy(iArr2, i5, this.mHashes, i, i4 - i);
                        System.arraycopy(objArr2, i5, this.mArray, i, this.mSize - i);
                    }
                } else {
                    int i6 = this.mSize - 1;
                    this.mSize = i6;
                    if (i < i6) {
                        int[] iArr3 = this.mHashes;
                        int i7 = i + 1;
                        System.arraycopy(iArr3, i7, iArr3, i, i6 - i);
                        Object[] objArr3 = this.mArray;
                        System.arraycopy(objArr3, i7, objArr3, i, this.mSize - i);
                    }
                    this.mArray[this.mSize] = null;
                }
            }
            return e;
        }
        return (E) invokeI.objValue;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@NonNull Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, collection)) == null) {
            boolean z = false;
            for (int i = this.mSize - 1; i >= 0; i--) {
                if (!collection.contains(this.mArray[i])) {
                    removeAt(i);
                    z = true;
                }
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mSize : invokeV.intValue;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public Object[] toArray() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            int i = this.mSize;
            Object[] objArr = new Object[i];
            System.arraycopy(this.mArray, 0, objArr, 0, i);
            return objArr;
        }
        return (Object[]) invokeV.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            if (isEmpty()) {
                return StringUtil.EMPTY_ARRAY;
            }
            StringBuilder sb = new StringBuilder(this.mSize * 14);
            sb.append('{');
            for (int i = 0; i < this.mSize; i++) {
                if (i > 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                E valueAt = valueAt(i);
                if (valueAt != this) {
                    sb.append(valueAt);
                } else {
                    sb.append("(this Set)");
                }
            }
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    @Nullable
    public E valueAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i)) == null) ? (E) this.mArray[i] : (E) invokeI.objValue;
    }

    public ArraySet(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (i == 0) {
            this.mHashes = INT;
            this.mArray = OBJECT;
        } else {
            allocArrays(i);
        }
        this.mSize = 0;
    }

    @Override // java.util.Collection, java.util.Set
    @NonNull
    public <T> T[] toArray(@NonNull T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, tArr)) == null) {
            if (tArr.length < this.mSize) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.mSize));
            }
            System.arraycopy(this.mArray, 0, tArr, 0, this.mSize);
            int length = tArr.length;
            int i = this.mSize;
            if (length > i) {
                tArr[i] = null;
            }
            return tArr;
        }
        return (T[]) ((Object[]) invokeL.objValue);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(@NonNull Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, collection)) == null) {
            Iterator<?> it = collection.iterator();
            boolean z = false;
            while (it.hasNext()) {
                z |= remove(it.next());
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ArraySet(@Nullable ArraySet<E> arraySet) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {arraySet};
            interceptable.invokeUnInit(65539, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        if (arraySet != 0) {
            addAll((ArraySet) arraySet);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, collection)) == null) {
            ensureCapacity(this.mSize + collection.size());
            boolean z = false;
            for (E e : collection) {
                z |= add(e);
            }
            return z;
        }
        return invokeL.booleanValue;
    }

    public int indexOf(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) ? obj == null ? indexOfNull() : indexOf(obj, obj.hashCode()) : invokeL.intValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ArraySet(@Nullable Collection<E> collection) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {collection};
            interceptable.invokeUnInit(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(InputDeviceCompat.SOURCE_TRACKBALL, newInitContext);
                return;
            }
        }
        if (collection != 0) {
            addAll(collection);
        }
    }
}
