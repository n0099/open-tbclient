package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ConcurrentModificationException;
import java.util.Map;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public class SimpleArrayMap<K, V> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int BASE_SIZE = 4;
    public static final int CACHE_SIZE = 10;
    public static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    public static final boolean DEBUG = false;
    public static final String TAG = "ArrayMap";
    @Nullable
    public static Object[] mBaseCache;
    public static int mBaseCacheSize;
    @Nullable
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mHashes = ContainerHelpers.EMPTY_INTS;
        this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mSize = 0;
    }

    private void allocArrays(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            if (i2 == 8) {
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
            } else if (i2 == 4) {
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
            this.mHashes = new int[i2];
            this.mArray = new Object[i2 << 1];
        }
    }

    public static int binarySearchHashes(int[] iArr, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(InputDeviceCompat.SOURCE_TRACKBALL, null, iArr, i2, i3)) == null) {
            try {
                return ContainerHelpers.binarySearch(iArr, i2, i3);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }
        return invokeLII.intValue;
    }

    public static void freeArrays(int[] iArr, Object[] objArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65541, null, iArr, objArr, i2) == null) {
            if (iArr.length == 8) {
                synchronized (SimpleArrayMap.class) {
                    if (mTwiceBaseCacheSize < 10) {
                        objArr[0] = mTwiceBaseCache;
                        objArr[1] = iArr;
                        for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
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
                        for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        mBaseCache = objArr;
                        mBaseCacheSize++;
                    }
                }
            }
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int i2 = this.mSize;
            if (i2 > 0) {
                int[] iArr = this.mHashes;
                Object[] objArr = this.mArray;
                this.mHashes = ContainerHelpers.EMPTY_INTS;
                this.mArray = ContainerHelpers.EMPTY_OBJECTS;
                this.mSize = 0;
                freeArrays(iArr, objArr, i2);
            }
            if (this.mSize > 0) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public boolean containsKey(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) ? indexOfKey(obj) >= 0 : invokeL.booleanValue;
    }

    public boolean containsValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) ? indexOfValue(obj) >= 0 : invokeL.booleanValue;
    }

    public void ensureCapacity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            int i3 = this.mSize;
            int[] iArr = this.mHashes;
            if (iArr.length < i2) {
                Object[] objArr = this.mArray;
                allocArrays(i2);
                if (this.mSize > 0) {
                    System.arraycopy(iArr, 0, this.mHashes, 0, i3);
                    System.arraycopy(objArr, 0, this.mArray, 0, i3 << 1);
                }
                freeArrays(iArr, objArr, i3);
            }
            if (this.mSize != i3) {
                throw new ConcurrentModificationException();
            }
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
                for (int i2 = 0; i2 < this.mSize; i2++) {
                    try {
                        K keyAt = keyAt(i2);
                        V valueAt = valueAt(i2);
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
                for (int i3 = 0; i3 < this.mSize; i3++) {
                    try {
                        K keyAt2 = keyAt(i3);
                        V valueAt2 = valueAt(i3);
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

    @Nullable
    public V get(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, obj)) == null) ? getOrDefault(obj, null) : (V) invokeL.objValue;
    }

    public V getOrDefault(Object obj, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, obj, v)) == null) {
            int indexOfKey = indexOfKey(obj);
            return indexOfKey >= 0 ? (V) this.mArray[(indexOfKey << 1) + 1] : v;
        }
        return (V) invokeLL.objValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int[] iArr = this.mHashes;
            Object[] objArr = this.mArray;
            int i2 = this.mSize;
            int i3 = 1;
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2) {
                Object obj = objArr[i3];
                i5 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
                i4++;
                i3 += 2;
            }
            return i5;
        }
        return invokeV.intValue;
    }

    public int indexOf(Object obj, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, obj, i2)) == null) {
            int i3 = this.mSize;
            if (i3 == 0) {
                return -1;
            }
            int binarySearchHashes = binarySearchHashes(this.mHashes, i3, i2);
            if (binarySearchHashes >= 0 && !obj.equals(this.mArray[binarySearchHashes << 1])) {
                int i4 = binarySearchHashes + 1;
                while (i4 < i3 && this.mHashes[i4] == i2) {
                    if (obj.equals(this.mArray[i4 << 1])) {
                        return i4;
                    }
                    i4++;
                }
                for (int i5 = binarySearchHashes - 1; i5 >= 0 && this.mHashes[i5] == i2; i5--) {
                    if (obj.equals(this.mArray[i5 << 1])) {
                        return i5;
                    }
                }
                return ~i4;
            }
            return binarySearchHashes;
        }
        return invokeLI.intValue;
    }

    public int indexOfKey(@Nullable Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, obj)) == null) ? obj == null ? indexOfNull() : indexOf(obj, obj.hashCode()) : invokeL.intValue;
    }

    public int indexOfNull() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            int i2 = this.mSize;
            if (i2 == 0) {
                return -1;
            }
            int binarySearchHashes = binarySearchHashes(this.mHashes, i2, 0);
            if (binarySearchHashes >= 0 && this.mArray[binarySearchHashes << 1] != null) {
                int i3 = binarySearchHashes + 1;
                while (i3 < i2 && this.mHashes[i3] == 0) {
                    if (this.mArray[i3 << 1] == null) {
                        return i3;
                    }
                    i3++;
                }
                for (int i4 = binarySearchHashes - 1; i4 >= 0 && this.mHashes[i4] == 0; i4--) {
                    if (this.mArray[i4 << 1] == null) {
                        return i4;
                    }
                }
                return ~i3;
            }
            return binarySearchHashes;
        }
        return invokeV.intValue;
    }

    public int indexOfValue(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, obj)) == null) {
            int i2 = this.mSize * 2;
            Object[] objArr = this.mArray;
            if (obj == null) {
                for (int i3 = 1; i3 < i2; i3 += 2) {
                    if (objArr[i3] == null) {
                        return i3 >> 1;
                    }
                }
                return -1;
            }
            for (int i4 = 1; i4 < i2; i4 += 2) {
                if (obj.equals(objArr[i4])) {
                    return i4 >> 1;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.mSize <= 0 : invokeV.booleanValue;
    }

    public K keyAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i2)) == null) ? (K) this.mArray[i2 << 1] : (K) invokeI.objValue;
    }

    @Nullable
    public V put(K k2, V v) {
        InterceptResult invokeLL;
        int i2;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, k2, v)) == null) {
            int i3 = this.mSize;
            if (k2 == null) {
                indexOf = indexOfNull();
                i2 = 0;
            } else {
                int hashCode = k2.hashCode();
                i2 = hashCode;
                indexOf = indexOf(k2, hashCode);
            }
            if (indexOf >= 0) {
                int i4 = (indexOf << 1) + 1;
                Object[] objArr = this.mArray;
                V v2 = (V) objArr[i4];
                objArr[i4] = v;
                return v2;
            }
            int i5 = ~indexOf;
            if (i3 >= this.mHashes.length) {
                int i6 = 4;
                if (i3 >= 8) {
                    i6 = (i3 >> 1) + i3;
                } else if (i3 >= 4) {
                    i6 = 8;
                }
                int[] iArr = this.mHashes;
                Object[] objArr2 = this.mArray;
                allocArrays(i6);
                if (i3 == this.mSize) {
                    int[] iArr2 = this.mHashes;
                    if (iArr2.length > 0) {
                        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                        System.arraycopy(objArr2, 0, this.mArray, 0, objArr2.length);
                    }
                    freeArrays(iArr, objArr2, i3);
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            if (i5 < i3) {
                int[] iArr3 = this.mHashes;
                int i7 = i5 + 1;
                System.arraycopy(iArr3, i5, iArr3, i7, i3 - i5);
                Object[] objArr3 = this.mArray;
                System.arraycopy(objArr3, i5 << 1, objArr3, i7 << 1, (this.mSize - i5) << 1);
            }
            int i8 = this.mSize;
            if (i3 == i8) {
                int[] iArr4 = this.mHashes;
                if (i5 < iArr4.length) {
                    iArr4[i5] = i2;
                    Object[] objArr4 = this.mArray;
                    int i9 = i5 << 1;
                    objArr4[i9] = k2;
                    objArr4[i9 + 1] = v;
                    this.mSize = i8 + 1;
                    return null;
                }
            }
            throw new ConcurrentModificationException();
        }
        return (V) invokeLL.objValue;
    }

    public void putAll(@NonNull SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, simpleArrayMap) == null) {
            int i2 = simpleArrayMap.mSize;
            ensureCapacity(this.mSize + i2);
            if (this.mSize != 0) {
                for (int i3 = 0; i3 < i2; i3++) {
                    put(simpleArrayMap.keyAt(i3), simpleArrayMap.valueAt(i3));
                }
            } else if (i2 > 0) {
                System.arraycopy(simpleArrayMap.mHashes, 0, this.mHashes, 0, i2);
                System.arraycopy(simpleArrayMap.mArray, 0, this.mArray, 0, i2 << 1);
                this.mSize = i2;
            }
        }
    }

    @Nullable
    public V putIfAbsent(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, k2, v)) == null) {
            V v2 = get(k2);
            return v2 == null ? put(k2, v) : v2;
        }
        return (V) invokeLL.objValue;
    }

    @Nullable
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

    public V removeAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048595, this, i2)) == null) {
            Object[] objArr = this.mArray;
            int i3 = i2 << 1;
            V v = (V) objArr[i3 + 1];
            int i4 = this.mSize;
            int i5 = 0;
            if (i4 <= 1) {
                freeArrays(this.mHashes, objArr, i4);
                this.mHashes = ContainerHelpers.EMPTY_INTS;
                this.mArray = ContainerHelpers.EMPTY_OBJECTS;
            } else {
                int i6 = i4 - 1;
                int[] iArr = this.mHashes;
                if (iArr.length > 8 && i4 < iArr.length / 3) {
                    int i7 = i4 > 8 ? i4 + (i4 >> 1) : 8;
                    int[] iArr2 = this.mHashes;
                    Object[] objArr2 = this.mArray;
                    allocArrays(i7);
                    if (i4 != this.mSize) {
                        throw new ConcurrentModificationException();
                    }
                    if (i2 > 0) {
                        System.arraycopy(iArr2, 0, this.mHashes, 0, i2);
                        System.arraycopy(objArr2, 0, this.mArray, 0, i3);
                    }
                    if (i2 < i6) {
                        int i8 = i2 + 1;
                        int i9 = i6 - i2;
                        System.arraycopy(iArr2, i8, this.mHashes, i2, i9);
                        System.arraycopy(objArr2, i8 << 1, this.mArray, i3, i9 << 1);
                    }
                } else {
                    if (i2 < i6) {
                        int[] iArr3 = this.mHashes;
                        int i10 = i2 + 1;
                        int i11 = i6 - i2;
                        System.arraycopy(iArr3, i10, iArr3, i2, i11);
                        Object[] objArr3 = this.mArray;
                        System.arraycopy(objArr3, i10 << 1, objArr3, i3, i11 << 1);
                    }
                    Object[] objArr4 = this.mArray;
                    int i12 = i6 << 1;
                    objArr4[i12] = null;
                    objArr4[i12 + 1] = null;
                }
                i5 = i6;
            }
            if (i4 == this.mSize) {
                this.mSize = i5;
                return v;
            }
            throw new ConcurrentModificationException();
        }
        return (V) invokeI.objValue;
    }

    @Nullable
    public V replace(K k2, V v) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048596, this, k2, v)) == null) {
            int indexOfKey = indexOfKey(k2);
            if (indexOfKey >= 0) {
                return setValueAt(indexOfKey, v);
            }
            return null;
        }
        return (V) invokeLL.objValue;
    }

    public V setValueAt(int i2, V v) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048598, this, i2, v)) == null) {
            int i3 = (i2 << 1) + 1;
            Object[] objArr = this.mArray;
            V v2 = (V) objArr[i3];
            objArr[i3] = v;
            return v2;
        }
        return (V) invokeIL.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mSize : invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (isEmpty()) {
                return StringUtil.EMPTY_ARRAY;
            }
            StringBuilder sb = new StringBuilder(this.mSize * 28);
            sb.append(ExtendedMessageFormat.START_FE);
            for (int i2 = 0; i2 < this.mSize; i2++) {
                if (i2 > 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                K keyAt = keyAt(i2);
                if (keyAt != this) {
                    sb.append(keyAt);
                } else {
                    sb.append("(this Map)");
                }
                sb.append(a.f31351h);
                V valueAt = valueAt(i2);
                if (valueAt != this) {
                    sb.append(valueAt);
                } else {
                    sb.append("(this Map)");
                }
            }
            sb.append(ExtendedMessageFormat.END_FE);
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }

    public V valueAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i2)) == null) ? (V) this.mArray[(i2 << 1) + 1] : (V) invokeI.objValue;
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

    public boolean replace(K k2, V v, V v2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048597, this, k2, v, v2)) == null) {
            int indexOfKey = indexOfKey(k2);
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

    public SimpleArrayMap(int i2) {
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
        if (i2 == 0) {
            this.mHashes = ContainerHelpers.EMPTY_INTS;
            this.mArray = ContainerHelpers.EMPTY_OBJECTS;
        } else {
            allocArrays(i2);
        }
        this.mSize = 0;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
}
