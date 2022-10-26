package androidx.collection;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ConcurrentModificationException;
import java.util.Map;
/* loaded from: classes.dex */
public class SimpleArrayMap<K, V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BASE_SIZE = 4;
    public static final int CACHE_SIZE = 10;
    public static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    public static final boolean DEBUG = false;
    public static final String TAG = "ArrayMap";
    public static Object[] mBaseCache;
    public static int mBaseCacheSize;
    public static Object[] mTwiceBaseCache;
    public static int mTwiceBaseCacheSize;
    public transient /* synthetic */ FieldHolder $fh;
    public Object[] mArray;
    public int[] mHashes;
    public int mSize;

    public SimpleArrayMap() {
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
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i = this.mSize;
            if (i > 0) {
                int[] iArr = this.mHashes;
                Object[] objArr = this.mArray;
                this.mHashes = ContainerHelpers.EMPTY_INTS;
                this.mArray = ContainerHelpers.EMPTY_OBJECTS;
                this.mSize = 0;
                freeArrays(iArr, objArr, i);
            }
            if (this.mSize <= 0) {
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        int hashCode;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            int i = this.mSize;
            int i2 = 1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                Object obj = objArr[i2];
                int i5 = iArr[i3];
                if (obj == null) {
                    hashCode = 0;
                } else {
                    hashCode = obj.hashCode();
                }
                i4 += hashCode ^ i5;
                i3++;
                i2 += 2;
            }
            return i4;
        }
        return invokeV.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            if (this.mSize <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.mSize;
        }
        return invokeV.intValue;
    }

    public SimpleArrayMap(int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (i == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(i);
        }
        this.mSize = 0;
    }

    public void ensureCapacity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            int i2 = this.mSize;
            int[] iArr = this.mHashes;
            if (iArr.length < i) {
                Object[] objArr = this.mArray;
                allocArrays(i);
                if (this.mSize > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i2);
                    System.arraycopy(objArr, 0, this.mArray, 0, i2 << 1);
                }
                freeArrays(iArr, objArr, i2);
            }
            if (this.mSize == i2) {
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public int indexOfValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            int i = this.mSize * 2;
            Object[] objArr = this.mArray;
            if (obj == null) {
                for (int i2 = 1; i2 < i; i2 += 2) {
                    if (objArr[i2] == null) {
                        return i2 >> 1;
                    }
                }
                return -1;
            }
            for (int i3 = 1; i3 < i; i3 += 2) {
                if (obj.equals(objArr[i3])) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, simpleArrayMap) == null) {
            int i = simpleArrayMap.mSize;
            ensureCapacity(this.mSize + i);
            if (this.mSize == 0) {
                if (i > 0) {
                    System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, i);
                    System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, i << 1);
                    this.mSize = i;
                    return;
                }
                return;
            }
            for (int i2 = 0; i2 < i; i2++) {
                put(simpleArrayMap.keyAt(i2), simpleArrayMap.valueAt(i2));
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {simpleArrayMap};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        if (simpleArrayMap != 0) {
            putAll(simpleArrayMap);
        }
    }

    private void allocArrays(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
            if (i == 8) {
                synchronized (SimpleArrayMap.class) {
                    if (mTwiceBaseCache != null) {
                        Object[] objArr = mTwiceBaseCache;
                        this.mArray = objArr;
                        mTwiceBaseCache = (Object[]) objArr[0];
                        this.mHashes = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        mTwiceBaseCacheSize--;
                        return;
                    }
                }
            } else if (i == 4) {
                synchronized (SimpleArrayMap.class) {
                    if (mBaseCache != null) {
                        Object[] objArr2 = mBaseCache;
                        this.mArray = objArr2;
                        mBaseCache = (Object[]) objArr2[0];
                        this.mHashes = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        mBaseCacheSize--;
                        return;
                    }
                }
            }
            this.mHashes = new int[i];
            this.mArray = new Object[i << 1];
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SimpleArrayMap) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                if (size() != simpleArrayMap.size()) {
                    return false;
                }
                for (int i = 0; i < this.mSize; i++) {
                    try {
                        K keyAt = keyAt(i);
                        V valueAt = valueAt(i);
                        Object obj2 = simpleArrayMap.get(keyAt);
                        if (valueAt == null) {
                            if (obj2 != null || !simpleArrayMap.containsKey(keyAt)) {
                                return false;
                            }
                        } else if (!valueAt.equals(obj2)) {
                            return false;
                        }
                    } catch (ClassCastException | NullPointerException unused) {
                        return false;
                    }
                }
                return true;
            }
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (size() != map.size()) {
                    return false;
                }
                for (int i2 = 0; i2 < this.mSize; i2++) {
                    try {
                        K keyAt2 = keyAt(i2);
                        V valueAt2 = valueAt(i2);
                        Object obj3 = map.get(keyAt2);
                        if (valueAt2 == null) {
                            if (obj3 != null || !map.containsKey(keyAt2)) {
                                return false;
                            }
                        } else if (!valueAt2.equals(obj3)) {
                            return false;
                        }
                    } catch (ClassCastException | NullPointerException unused2) {
                    }
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static int binarySearchHashes(int[] iArr, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, iArr, i, i2)) == null) {
            try {
                return ContainerHelpers.binarySearch(iArr, i, i2);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }
        return invokeLII.intValue;
    }

    public boolean replace(K k, V v, V v2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, k, v, v2)) == null) {
            int indexOfKey = indexOfKey(k);
            if (indexOfKey >= 0) {
                V valueAt = valueAt(indexOfKey);
                if (valueAt == v || (v != null && v.equals(valueAt))) {
                    setValueAt(indexOfKey, v2);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void freeArrays(int[] iArr, Object[] objArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65541, null, iArr, objArr, i) == null) {
            if (iArr.length == 8) {
                synchronized (SimpleArrayMap.class) {
                    if (mTwiceBaseCacheSize < 10) {
                        objArr[0] = mTwiceBaseCache;
                        objArr[1] = iArr;
                        for (int i2 = (i << 1) - 1; i2 >= 2; i2--) {
                            objArr[i2] = null;
                        }
                        mTwiceBaseCache = objArr;
                        mTwiceBaseCacheSize++;
                    }
                }
            } else if (iArr.length == 4) {
                synchronized (SimpleArrayMap.class) {
                    if (mBaseCacheSize < 10) {
                        objArr[0] = mBaseCache;
                        objArr[1] = iArr;
                        for (int i3 = (i << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        mBaseCache = objArr;
                        mBaseCacheSize++;
                    }
                }
            }
        }
    }

    public boolean containsKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (indexOfKey(obj) >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (indexOfValue(obj) >= 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public V get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) {
            return getOrDefault(obj, null);
        }
        return (V) invokeL.objValue;
    }

    public int indexOfKey(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) {
            if (obj == null) {
                return indexOfNull();
            }
            return indexOf(obj, obj.hashCode());
        }
        return invokeL.intValue;
    }

    public K keyAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            return (K) this.mArray[i << 1];
        }
        return (K) invokeI.objValue;
    }

    public V remove(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, obj)) == null) {
            int indexOfKey = indexOfKey(obj);
            if (indexOfKey >= 0) {
                return removeAt(indexOfKey);
            }
            return null;
        }
        return (V) invokeL.objValue;
    }

    public V valueAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            return (V) this.mArray[(i << 1) + 1];
        }
        return (V) invokeI.objValue;
    }

    public V getOrDefault(Object obj, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, obj, v)) == null) {
            int indexOfKey = indexOfKey(obj);
            if (indexOfKey >= 0) {
                return (V) this.mArray[(indexOfKey << 1) + 1];
            }
            return v;
        }
        return (V) invokeLL.objValue;
    }

    public V putIfAbsent(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, k, v)) == null) {
            V v2 = get(k);
            if (v2 == null) {
                return put(k, v);
            }
            return v2;
        }
        return (V) invokeLL.objValue;
    }

    public boolean remove(Object obj, Object obj2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048594, this, obj, obj2)) == null) {
            int indexOfKey = indexOfKey(obj);
            if (indexOfKey >= 0) {
                V valueAt = valueAt(indexOfKey);
                if (obj2 == valueAt || (obj2 != null && obj2.equals(valueAt))) {
                    removeAt(indexOfKey);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public V replace(K k, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, k, v)) == null) {
            int indexOfKey = indexOfKey(k);
            if (indexOfKey >= 0) {
                return setValueAt(indexOfKey, v);
            }
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public V setValueAt(int i, V v) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i, v)) == null) {
            int i2 = (i << 1) + 1;
            Object[] objArr = this.mArray;
            V v2 = (V) objArr[i2];
            objArr[i2] = v;
            return v2;
        }
        return (V) invokeIL.objValue;
    }

    public int indexOf(Object obj, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, i)) == null) {
            int i2 = this.mSize;
            if (i2 == 0) {
                return -1;
            }
            int binarySearchHashes = binarySearchHashes(this.mHashes, i2, i);
            if (binarySearchHashes < 0) {
                return binarySearchHashes;
            }
            if (obj.equals(this.mArray[binarySearchHashes << 1])) {
                return binarySearchHashes;
            }
            int i3 = binarySearchHashes + 1;
            while (i3 < i2 && this.mHashes[i3] == i) {
                if (obj.equals(this.mArray[i3 << 1])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = binarySearchHashes - 1; i4 >= 0 && this.mHashes[i4] == i; i4--) {
                if (obj.equals(this.mArray[i4 << 1])) {
                    return i4;
                }
            }
            return ~i3;
        }
        return invokeLI.intValue;
    }

    public int indexOfNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i = this.mSize;
            if (i == 0) {
                return -1;
            }
            int binarySearchHashes = binarySearchHashes(this.mHashes, i, 0);
            if (binarySearchHashes < 0) {
                return binarySearchHashes;
            }
            if (this.mArray[binarySearchHashes << 1] == null) {
                return binarySearchHashes;
            }
            int i2 = binarySearchHashes + 1;
            while (i2 < i && this.mHashes[i2] == 0) {
                if (this.mArray[i2 << 1] == null) {
                    return i2;
                }
                i2++;
            }
            for (int i3 = binarySearchHashes - 1; i3 >= 0 && this.mHashes[i3] == 0; i3--) {
                if (this.mArray[i3 << 1] == null) {
                    return i3;
                }
            }
            return ~i2;
        }
        return invokeV.intValue;
    }

    public V put(K k, V v) {
        InterceptResult invokeLL;
        int i;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, k, v)) == null) {
            int i2 = this.mSize;
            if (k == null) {
                indexOf = indexOfNull();
                i = 0;
            } else {
                int hashCode = k.hashCode();
                i = hashCode;
                indexOf = indexOf(k, hashCode);
            }
            if (indexOf >= 0) {
                int i3 = (indexOf << 1) + 1;
                Object[] objArr = this.mArray;
                V v2 = (V) objArr[i3];
                objArr[i3] = v;
                return v2;
            }
            int i4 = ~indexOf;
            if (i2 >= this.mHashes.length) {
                int i5 = 4;
                if (i2 >= 8) {
                    i5 = (i2 >> 1) + i2;
                } else if (i2 >= 4) {
                    i5 = 8;
                }
                int[] iArr = this.mHashes;
                Object[] objArr2 = this.mArray;
                allocArrays(i5);
                if (i2 == this.mSize) {
                    int[] iArr2 = this.mHashes;
                    if (iArr2.length > 0) {
                        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                        System.arraycopy(objArr2, 0, this.mArray, 0, objArr2.length);
                    }
                    freeArrays(iArr, objArr2, i2);
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            if (i4 < i2) {
                int[] iArr3 = this.mHashes;
                int i6 = i4 + 1;
                System.arraycopy(iArr3, i4, iArr3, i6, i2 - i4);
                Object[] objArr3 = this.mArray;
                System.arraycopy(objArr3, i4 << 1, objArr3, i6 << 1, (this.mSize - i4) << 1);
            }
            int i7 = this.mSize;
            if (i2 == i7) {
                int[] iArr4 = this.mHashes;
                if (i4 < iArr4.length) {
                    iArr4[i4] = i;
                    Object[] objArr4 = this.mArray;
                    int i8 = i4 << 1;
                    objArr4[i8] = k;
                    objArr4[i8 + 1] = v;
                    this.mSize = i7 + 1;
                    return null;
                }
            }
            throw new ConcurrentModificationException();
        }
        return (V) invokeLL.objValue;
    }

    public V removeAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i)) == null) {
            Object[] objArr = this.mArray;
            int i2 = i << 1;
            V v = (V) objArr[i2 + 1];
            int i3 = this.mSize;
            int i4 = 0;
            if (i3 <= 1) {
                freeArrays(this.mHashes, objArr, i3);
                this.mHashes = ContainerHelpers.EMPTY_INTS;
                this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            } else {
                int i5 = i3 - 1;
                int[] iArr = this.mHashes;
                int i6 = 8;
                if (iArr.length > 8 && i3 < iArr.length / 3) {
                    if (i3 > 8) {
                        i6 = i3 + (i3 >> 1);
                    }
                    int[] iArr2 = this.mHashes;
                    Object[] objArr2 = this.mArray;
                    allocArrays(i6);
                    if (i3 == this.mSize) {
                        if (i > 0) {
                            System.arraycopy(iArr2, 0, this.mHashes, 0, i);
                            System.arraycopy(objArr2, 0, this.mArray, 0, i2);
                        }
                        if (i < i5) {
                            int i7 = i + 1;
                            int i8 = i5 - i;
                            System.arraycopy(iArr2, i7, this.mHashes, i, i8);
                            System.arraycopy(objArr2, i7 << 1, this.mArray, i2, i8 << 1);
                        }
                    } else {
                        throw new ConcurrentModificationException();
                    }
                } else {
                    if (i < i5) {
                        int[] iArr3 = this.mHashes;
                        int i9 = i + 1;
                        int i10 = i5 - i;
                        System.arraycopy(iArr3, i9, iArr3, i, i10);
                        Object[] objArr3 = this.mArray;
                        System.arraycopy(objArr3, i9 << 1, objArr3, i2, i10 << 1);
                    }
                    Object[] objArr4 = this.mArray;
                    int i11 = i5 << 1;
                    objArr4[i11] = null;
                    objArr4[i11 + 1] = null;
                }
                i4 = i5;
            }
            if (i3 == this.mSize) {
                this.mSize = i4;
                return v;
            }
            throw new ConcurrentModificationException();
        }
        return (V) invokeI.objValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (isEmpty()) {
                return StringUtil.EMPTY_ARRAY;
            }
            StringBuilder sb = new StringBuilder(this.mSize * 28);
            sb.append('{');
            for (int i = 0; i < this.mSize; i++) {
                if (i > 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                K keyAt = keyAt(i);
                if (keyAt != this) {
                    sb.append(keyAt);
                } else {
                    sb.append("(this Map)");
                }
                sb.append('=');
                V valueAt = valueAt(i);
                if (valueAt != this) {
                    sb.append(valueAt);
                } else {
                    sb.append("(this Map)");
                }
            }
            sb.append('}');
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}
