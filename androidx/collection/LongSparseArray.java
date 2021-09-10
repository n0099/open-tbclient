package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.alipay.sdk.encrypt.a;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
/* loaded from: classes.dex */
public class LongSparseArray<E> implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final Object DELETED;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mGarbage;
    public long[] mKeys;
    public int mSize;
    public Object[] mValues;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(523383925, "Landroidx/collection/LongSparseArray;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(523383925, "Landroidx/collection/LongSparseArray;");
                return;
            }
        }
        DELETED = new Object();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LongSparseArray() {
        this(10);
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

    private void gc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int i2 = this.mSize;
            long[] jArr = this.mKeys;
            Object[] objArr = this.mValues;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != DELETED) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.mGarbage = false;
            this.mSize = i3;
        }
    }

    public void append(long j2, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048576, this, j2, e2) == null) {
            int i2 = this.mSize;
            if (i2 != 0 && j2 <= this.mKeys[i2 - 1]) {
                put(j2, e2);
                return;
            }
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
            }
            int i3 = this.mSize;
            if (i3 >= this.mKeys.length) {
                int idealLongArraySize = ContainerHelpers.idealLongArraySize(i3 + 1);
                long[] jArr = new long[idealLongArraySize];
                Object[] objArr = new Object[idealLongArraySize];
                long[] jArr2 = this.mKeys;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.mValues;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.mKeys = jArr;
                this.mValues = objArr;
            }
            this.mKeys[i3] = j2;
            this.mValues[i3] = e2;
            this.mSize = i3 + 1;
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i2 = this.mSize;
            Object[] objArr = this.mValues;
            for (int i3 = 0; i3 < i2; i3++) {
                objArr[i3] = null;
            }
            this.mSize = 0;
            this.mGarbage = false;
        }
    }

    public boolean containsKey(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) ? indexOfKey(j2) >= 0 : invokeJ.booleanValue;
    }

    public boolean containsValue(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, e2)) == null) ? indexOfValue(e2) >= 0 : invokeL.booleanValue;
    }

    @Deprecated
    public void delete(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j2) == null) {
            remove(j2);
        }
    }

    @Nullable
    public E get(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeJ = interceptable.invokeJ(1048583, this, j2)) == null) ? get(j2, null) : (E) invokeJ.objValue;
    }

    public int indexOfKey(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048585, this, j2)) == null) {
            if (this.mGarbage) {
                gc();
            }
            return ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
        }
        return invokeJ.intValue;
    }

    public int indexOfValue(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, e2)) == null) {
            if (this.mGarbage) {
                gc();
            }
            for (int i2 = 0; i2 < this.mSize; i2++) {
                if (this.mValues[i2] == e2) {
                    return i2;
                }
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? size() == 0 : invokeV.booleanValue;
    }

    public long keyAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i2)) == null) {
            if (this.mGarbage) {
                gc();
            }
            return this.mKeys[i2];
        }
        return invokeI.longValue;
    }

    public void put(long j2, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048589, this, j2, e2) == null) {
            int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
            if (binarySearch >= 0) {
                this.mValues[binarySearch] = e2;
                return;
            }
            int i2 = ~binarySearch;
            if (i2 < this.mSize) {
                Object[] objArr = this.mValues;
                if (objArr[i2] == DELETED) {
                    this.mKeys[i2] = j2;
                    objArr[i2] = e2;
                    return;
                }
            }
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
                i2 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
            }
            int i3 = this.mSize;
            if (i3 >= this.mKeys.length) {
                int idealLongArraySize = ContainerHelpers.idealLongArraySize(i3 + 1);
                long[] jArr = new long[idealLongArraySize];
                Object[] objArr2 = new Object[idealLongArraySize];
                long[] jArr2 = this.mKeys;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr3 = this.mValues;
                System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                this.mKeys = jArr;
                this.mValues = objArr2;
            }
            int i4 = this.mSize;
            if (i4 - i2 != 0) {
                long[] jArr3 = this.mKeys;
                int i5 = i2 + 1;
                System.arraycopy(jArr3, i2, jArr3, i5, i4 - i2);
                Object[] objArr4 = this.mValues;
                System.arraycopy(objArr4, i2, objArr4, i5, this.mSize - i2);
            }
            this.mKeys[i2] = j2;
            this.mValues[i2] = e2;
            this.mSize++;
        }
    }

    public void putAll(@NonNull LongSparseArray<? extends E> longSparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, longSparseArray) == null) {
            int size = longSparseArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                put(longSparseArray.keyAt(i2), longSparseArray.valueAt(i2));
            }
        }
    }

    @Nullable
    public E putIfAbsent(long j2, E e2) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048591, this, j2, e2)) == null) {
            E e3 = get(j2);
            if (e3 == null) {
                put(j2, e2);
            }
            return e3;
        }
        return (E) invokeJL.objValue;
    }

    public void remove(long j2) {
        int binarySearch;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeJ(1048592, this, j2) == null) || (binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2)) < 0) {
            return;
        }
        Object[] objArr = this.mValues;
        Object obj = objArr[binarySearch];
        Object obj2 = DELETED;
        if (obj != obj2) {
            objArr[binarySearch] = obj2;
            this.mGarbage = true;
        }
    }

    public void removeAt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            Object[] objArr = this.mValues;
            Object obj = objArr[i2];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[i2] = obj2;
                this.mGarbage = true;
            }
        }
    }

    @Nullable
    public E replace(long j2, E e2) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048595, this, j2, e2)) == null) {
            int indexOfKey = indexOfKey(j2);
            if (indexOfKey >= 0) {
                Object[] objArr = this.mValues;
                E e3 = (E) objArr[indexOfKey];
                objArr[indexOfKey] = e2;
                return e3;
            }
            return null;
        }
        return (E) invokeJL.objValue;
    }

    public void setValueAt(int i2, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048597, this, i2, e2) == null) {
            if (this.mGarbage) {
                gc();
            }
            this.mValues[i2] = e2;
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            if (this.mGarbage) {
                gc();
            }
            return this.mSize;
        }
        return invokeV.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            if (size() <= 0) {
                return StringUtil.EMPTY_ARRAY;
            }
            StringBuilder sb = new StringBuilder(this.mSize * 28);
            sb.append(ExtendedMessageFormat.START_FE);
            for (int i2 = 0; i2 < this.mSize; i2++) {
                if (i2 > 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(keyAt(i2));
                sb.append(a.f35988h);
                E valueAt = valueAt(i2);
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

    public E valueAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048600, this, i2)) == null) {
            if (this.mGarbage) {
                gc();
            }
            return (E) this.mValues[i2];
        }
        return (E) invokeI.objValue;
    }

    public LongSparseArray(int i2) {
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
        this.mGarbage = false;
        if (i2 == 0) {
            this.mKeys = ContainerHelpers.EMPTY_LONGS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
            return;
        }
        int idealLongArraySize = ContainerHelpers.idealLongArraySize(i2);
        this.mKeys = new long[idealLongArraySize];
        this.mValues = new Object[idealLongArraySize];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public LongSparseArray<E> m0clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
                longSparseArray.mKeys = (long[]) this.mKeys.clone();
                longSparseArray.mValues = (Object[]) this.mValues.clone();
                return longSparseArray;
            } catch (CloneNotSupportedException e2) {
                throw new AssertionError(e2);
            }
        }
        return (LongSparseArray) invokeV.objValue;
    }

    public E get(long j2, E e2) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(InputDeviceCompat.SOURCE_TOUCHPAD, this, j2, e2)) == null) {
            int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, j2);
            if (binarySearch >= 0) {
                Object[] objArr = this.mValues;
                if (objArr[binarySearch] != DELETED) {
                    return (E) objArr[binarySearch];
                }
            }
            return e2;
        }
        return (E) invokeJL.objValue;
    }

    public boolean replace(long j2, E e2, E e3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Long.valueOf(j2), e2, e3})) == null) {
            int indexOfKey = indexOfKey(j2);
            if (indexOfKey >= 0) {
                Object obj = this.mValues[indexOfKey];
                if (obj == e2 || (e2 != null && e2.equals(obj))) {
                    this.mValues[indexOfKey] = e3;
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean remove(long j2, Object obj) {
        InterceptResult invokeJL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJL = interceptable.invokeJL(1048593, this, j2, obj)) == null) {
            int indexOfKey = indexOfKey(j2);
            if (indexOfKey >= 0) {
                E valueAt = valueAt(indexOfKey);
                if (obj == valueAt || (obj != null && obj.equals(valueAt))) {
                    removeAt(indexOfKey);
                    return true;
                }
                return false;
            }
            return false;
        }
        return invokeJL.booleanValue;
    }
}
