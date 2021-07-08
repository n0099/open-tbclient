package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void allocArrays(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, this, i2) == null) {
            if (i2 == 8) {
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
            } else if (i2 == 4) {
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
            this.mHashes = new int[i2];
            this.mArray = new Object[i2];
        }
    }

    public static void freeArrays(int[] iArr, Object[] objArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(AdIconUtil.BAIDU_LOGO_ID, null, iArr, objArr, i2) == null) {
            if (iArr.length == 8) {
                synchronized (ArraySet.class) {
                    if (sTwiceBaseCacheSize < 10) {
                        objArr[0] = sTwiceBaseCache;
                        objArr[1] = iArr;
                        for (int i3 = i2 - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
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
                        for (int i4 = i2 - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
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
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
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
                    public Object colGetEntry(int i2, int i3) {
                        InterceptResult invokeII;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeII = interceptable2.invokeII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3)) == null) ? this.this$0.mArray[i2] : invokeII.objValue;
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
                    public void colPut(E e2, E e3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLL(1048582, this, e2, e3) == null) {
                            this.this$0.add(e2);
                        }
                    }

                    @Override // androidx.collection.MapCollections
                    public void colRemoveAt(int i2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeI(1048583, this, i2) == null) {
                            this.this$0.removeAt(i2);
                        }
                    }

                    @Override // androidx.collection.MapCollections
                    public E colSetValue(int i2, E e2) {
                        InterceptResult invokeIL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeIL = interceptable2.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, e2)) == null) {
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

    private int indexOf(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, this, obj, i2)) == null) {
            int i3 = this.mSize;
            if (i3 == 0) {
                return -1;
            }
            int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i3, i2);
            if (binarySearch >= 0 && !obj.equals(this.mArray[binarySearch])) {
                int i4 = binarySearch + 1;
                while (i4 < i3 && this.mHashes[i4] == i2) {
                    if (obj.equals(this.mArray[i4])) {
                        return i4;
                    }
                    i4++;
                }
                for (int i5 = binarySearch - 1; i5 >= 0 && this.mHashes[i5] == i2; i5--) {
                    if (obj.equals(this.mArray[i5])) {
                        return i5;
                    }
                }
                return ~i4;
            }
            return binarySearch;
        }
        return invokeLI.intValue;
    }

    private int indexOfNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            int i2 = this.mSize;
            if (i2 == 0) {
                return -1;
            }
            int binarySearch = ContainerHelpers.binarySearch(this.mHashes, i2, 0);
            if (binarySearch >= 0 && this.mArray[binarySearch] != null) {
                int i3 = binarySearch + 1;
                while (i3 < i2 && this.mHashes[i3] == 0) {
                    if (this.mArray[i3] == null) {
                        return i3;
                    }
                    i3++;
                }
                for (int i4 = binarySearch - 1; i4 >= 0 && this.mHashes[i4] == 0; i4--) {
                    if (this.mArray[i4] == null) {
                        return i4;
                    }
                }
                return ~i3;
            }
            return binarySearch;
        }
        return invokeV.intValue;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(@Nullable E e2) {
        InterceptResult invokeL;
        int i2;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, e2)) == null) {
            if (e2 == null) {
                indexOf = indexOfNull();
                i2 = 0;
            } else {
                int hashCode = e2.hashCode();
                i2 = hashCode;
                indexOf = indexOf(e2, hashCode);
            }
            if (indexOf >= 0) {
                return false;
            }
            int i3 = ~indexOf;
            int i4 = this.mSize;
            if (i4 >= this.mHashes.length) {
                int i5 = 4;
                if (i4 >= 8) {
                    i5 = (i4 >> 1) + i4;
                } else if (i4 >= 4) {
                    i5 = 8;
                }
                int[] iArr = this.mHashes;
                Object[] objArr = this.mArray;
                allocArrays(i5);
                int[] iArr2 = this.mHashes;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.mArray, 0, objArr.length);
                }
                freeArrays(iArr, objArr, this.mSize);
            }
            int i6 = this.mSize;
            if (i3 < i6) {
                int[] iArr3 = this.mHashes;
                int i7 = i3 + 1;
                System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
                Object[] objArr2 = this.mArray;
                System.arraycopy(objArr2, i3, objArr2, i7, this.mSize - i3);
            }
            this.mHashes[i3] = i2;
            this.mArray[i3] = e2;
            this.mSize++;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void addAll(@NonNull ArraySet<? extends E> arraySet) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, arraySet) == null) {
            int i2 = arraySet.mSize;
            ensureCapacity(this.mSize + i2);
            if (this.mSize != 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    add(arraySet.valueAt(i3));
                }
            } else if (i2 > 0) {
                System.arraycopy(arraySet.mHashes, 0, this.mHashes, 0, i2);
                System.arraycopy(arraySet.mArray, 0, this.mArray, 0, i2);
                this.mSize = i2;
            }
        }
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (i2 = this.mSize) == 0) {
            return;
        }
        freeArrays(this.mHashes, this.mArray, i2);
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

    public void ensureCapacity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            int[] iArr = this.mHashes;
            if (iArr.length < i2) {
                Object[] objArr = this.mArray;
                allocArrays(i2);
                int i3 = this.mSize;
                if (i3 > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i3);
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
                for (int i2 = 0; i2 < this.mSize; i2++) {
                    try {
                        if (!set.contains(valueAt(i2))) {
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
            int i2 = this.mSize;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                i3 += iArr[i4];
            }
            return i3;
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
            int i2 = arraySet.mSize;
            int i3 = this.mSize;
            for (int i4 = 0; i4 < i2; i4++) {
                remove(arraySet.valueAt(i4));
            }
            return i3 != this.mSize;
        }
        return invokeL.booleanValue;
    }

    public E removeAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048591, this, i2)) == null) {
            Object[] objArr = this.mArray;
            E e2 = (E) objArr[i2];
            int i3 = this.mSize;
            if (i3 <= 1) {
                freeArrays(this.mHashes, objArr, i3);
                this.mHashes = INT;
                this.mArray = OBJECT;
                this.mSize = 0;
            } else {
                int[] iArr = this.mHashes;
                if (iArr.length > 8 && i3 < iArr.length / 3) {
                    int i4 = i3 > 8 ? i3 + (i3 >> 1) : 8;
                    int[] iArr2 = this.mHashes;
                    Object[] objArr2 = this.mArray;
                    allocArrays(i4);
                    this.mSize--;
                    if (i2 > 0) {
                        System.arraycopy(iArr2, 0, this.mHashes, 0, i2);
                        System.arraycopy(objArr2, 0, this.mArray, 0, i2);
                    }
                    int i5 = this.mSize;
                    if (i2 < i5) {
                        int i6 = i2 + 1;
                        System.arraycopy(iArr2, i6, this.mHashes, i2, i5 - i2);
                        System.arraycopy(objArr2, i6, this.mArray, i2, this.mSize - i2);
                    }
                } else {
                    int i7 = this.mSize - 1;
                    this.mSize = i7;
                    if (i2 < i7) {
                        int[] iArr3 = this.mHashes;
                        int i8 = i2 + 1;
                        System.arraycopy(iArr3, i8, iArr3, i2, i7 - i2);
                        Object[] objArr3 = this.mArray;
                        System.arraycopy(objArr3, i8, objArr3, i2, this.mSize - i2);
                    }
                    this.mArray[this.mSize] = null;
                }
            }
            return e2;
        }
        return (E) invokeI.objValue;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(@NonNull Collection<?> collection) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, collection)) == null) {
            boolean z = false;
            for (int i2 = this.mSize - 1; i2 >= 0; i2--) {
                if (!collection.contains(this.mArray[i2])) {
                    removeAt(i2);
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
            int i2 = this.mSize;
            Object[] objArr = new Object[i2];
            System.arraycopy(this.mArray, 0, objArr, 0, i2);
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
            for (int i2 = 0; i2 < this.mSize; i2++) {
                if (i2 > 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                E valueAt = valueAt(i2);
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
    public E valueAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048597, this, i2)) == null) ? (E) this.mArray[i2] : (E) invokeI.objValue;
    }

    public ArraySet(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (i2 == 0) {
            this.mHashes = INT;
            this.mArray = OBJECT;
        } else {
            allocArrays(i2);
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
            int i2 = this.mSize;
            if (length > i2) {
                tArr[i2] = null;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            for (E e2 : collection) {
                z |= add(e2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
