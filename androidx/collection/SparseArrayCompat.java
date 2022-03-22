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
/* loaded from: classes.dex */
public class SparseArrayCompat<E> implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public static final Object DELETED;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean mGarbage;
    public int[] mKeys;
    public int mSize;
    public Object[] mValues;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-214999689, "Landroidx/collection/SparseArrayCompat;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-214999689, "Landroidx/collection/SparseArrayCompat;");
                return;
            }
        }
        DELETED = new Object();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SparseArrayCompat() {
        this(10);
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

    private void gc() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            int i = this.mSize;
            int[] iArr = this.mKeys;
            Object[] objArr = this.mValues;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != DELETED) {
                    if (i3 != i2) {
                        iArr[i2] = iArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.mGarbage = false;
            this.mSize = i2;
        }
    }

    public void append(int i, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i, e2) == null) {
            int i2 = this.mSize;
            if (i2 != 0 && i <= this.mKeys[i2 - 1]) {
                put(i, e2);
                return;
            }
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
            }
            int i3 = this.mSize;
            if (i3 >= this.mKeys.length) {
                int idealIntArraySize = ContainerHelpers.idealIntArraySize(i3 + 1);
                int[] iArr = new int[idealIntArraySize];
                Object[] objArr = new Object[idealIntArraySize];
                int[] iArr2 = this.mKeys;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.mValues;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.mKeys = iArr;
                this.mValues = objArr;
            }
            this.mKeys[i3] = i;
            this.mValues[i3] = e2;
            this.mSize = i3 + 1;
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int i = this.mSize;
            Object[] objArr = this.mValues;
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = null;
            }
            this.mSize = 0;
            this.mGarbage = false;
        }
    }

    public boolean containsKey(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) ? indexOfKey(i) >= 0 : invokeI.booleanValue;
    }

    public boolean containsValue(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, e2)) == null) ? indexOfValue(e2) >= 0 : invokeL.booleanValue;
    }

    @Deprecated
    public void delete(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            remove(i);
        }
    }

    @Nullable
    public E get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? get(i, null) : (E) invokeI.objValue;
    }

    public int indexOfKey(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            if (this.mGarbage) {
                gc();
            }
            return ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
        }
        return invokeI.intValue;
    }

    public int indexOfValue(E e2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, e2)) == null) {
            if (this.mGarbage) {
                gc();
            }
            for (int i = 0; i < this.mSize; i++) {
                if (this.mValues[i] == e2) {
                    return i;
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

    public int keyAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (this.mGarbage) {
                gc();
            }
            return this.mKeys[i];
        }
        return invokeI.intValue;
    }

    public void put(int i, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048589, this, i, e2) == null) {
            int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
            if (binarySearch >= 0) {
                this.mValues[binarySearch] = e2;
                return;
            }
            int i2 = ~binarySearch;
            if (i2 < this.mSize) {
                Object[] objArr = this.mValues;
                if (objArr[i2] == DELETED) {
                    this.mKeys[i2] = i;
                    objArr[i2] = e2;
                    return;
                }
            }
            if (this.mGarbage && this.mSize >= this.mKeys.length) {
                gc();
                i2 = ~ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
            }
            int i3 = this.mSize;
            if (i3 >= this.mKeys.length) {
                int idealIntArraySize = ContainerHelpers.idealIntArraySize(i3 + 1);
                int[] iArr = new int[idealIntArraySize];
                Object[] objArr2 = new Object[idealIntArraySize];
                int[] iArr2 = this.mKeys;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr3 = this.mValues;
                System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
                this.mKeys = iArr;
                this.mValues = objArr2;
            }
            int i4 = this.mSize;
            if (i4 - i2 != 0) {
                int[] iArr3 = this.mKeys;
                int i5 = i2 + 1;
                System.arraycopy(iArr3, i2, iArr3, i5, i4 - i2);
                Object[] objArr4 = this.mValues;
                System.arraycopy(objArr4, i2, objArr4, i5, this.mSize - i2);
            }
            this.mKeys[i2] = i;
            this.mValues[i2] = e2;
            this.mSize++;
        }
    }

    public void putAll(@NonNull SparseArrayCompat<? extends E> sparseArrayCompat) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, sparseArrayCompat) == null) {
            int size = sparseArrayCompat.size();
            for (int i = 0; i < size; i++) {
                put(sparseArrayCompat.keyAt(i), sparseArrayCompat.valueAt(i));
            }
        }
    }

    @Nullable
    public E putIfAbsent(int i, E e2) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048591, this, i, e2)) == null) {
            E e3 = get(i);
            if (e3 == null) {
                put(i, e2);
            }
            return e3;
        }
        return (E) invokeIL.objValue;
    }

    public void remove(int i) {
        int binarySearch;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048592, this, i) == null) || (binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i)) < 0) {
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

    public void removeAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            Object[] objArr = this.mValues;
            Object obj = objArr[i];
            Object obj2 = DELETED;
            if (obj != obj2) {
                objArr[i] = obj2;
                this.mGarbage = true;
            }
        }
    }

    public void removeAtRange(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048595, this, i, i2) == null) {
            int min = Math.min(this.mSize, i2 + i);
            while (i < min) {
                removeAt(i);
                i++;
            }
        }
    }

    @Nullable
    public E replace(int i, E e2) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048596, this, i, e2)) == null) {
            int indexOfKey = indexOfKey(i);
            if (indexOfKey >= 0) {
                Object[] objArr = this.mValues;
                E e3 = (E) objArr[indexOfKey];
                objArr[indexOfKey] = e2;
                return e3;
            }
            return null;
        }
        return (E) invokeIL.objValue;
    }

    public void setValueAt(int i, E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048598, this, i, e2) == null) {
            if (this.mGarbage) {
                gc();
            }
            this.mValues[i] = e2;
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
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
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            if (size() <= 0) {
                return StringUtil.EMPTY_ARRAY;
            }
            StringBuilder sb = new StringBuilder(this.mSize * 28);
            sb.append('{');
            for (int i = 0; i < this.mSize; i++) {
                if (i > 0) {
                    sb.append(StringUtil.ARRAY_ELEMENT_SEPARATOR);
                }
                sb.append(keyAt(i));
                sb.append('=');
                E valueAt = valueAt(i);
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

    public E valueAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048601, this, i)) == null) {
            if (this.mGarbage) {
                gc();
            }
            return (E) this.mValues[i];
        }
        return (E) invokeI.objValue;
    }

    public SparseArrayCompat(int i) {
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
        this.mGarbage = false;
        if (i == 0) {
            this.mKeys = ContainerHelpers.EMPTY_INTS;
            this.mValues = ContainerHelpers.EMPTY_OBJECTS;
            return;
        }
        int idealIntArraySize = ContainerHelpers.idealIntArraySize(i);
        this.mKeys = new int[idealIntArraySize];
        this.mValues = new Object[idealIntArraySize];
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: clone */
    public SparseArrayCompat<E> m1clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            try {
                SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
                sparseArrayCompat.mKeys = (int[]) this.mKeys.clone();
                sparseArrayCompat.mValues = (Object[]) this.mValues.clone();
                return sparseArrayCompat;
            } catch (CloneNotSupportedException e2) {
                throw new AssertionError(e2);
            }
        }
        return (SparseArrayCompat) invokeV.objValue;
    }

    public E get(int i, E e2) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, e2)) == null) {
            int binarySearch = ContainerHelpers.binarySearch(this.mKeys, this.mSize, i);
            if (binarySearch >= 0) {
                Object[] objArr = this.mValues;
                if (objArr[binarySearch] != DELETED) {
                    return (E) objArr[binarySearch];
                }
            }
            return e2;
        }
        return (E) invokeIL.objValue;
    }

    public boolean replace(int i, E e2, E e3) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048597, this, i, e2, e3)) == null) {
            int indexOfKey = indexOfKey(i);
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
        return invokeILL.booleanValue;
    }

    public boolean remove(int i, Object obj) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048593, this, i, obj)) == null) {
            int indexOfKey = indexOfKey(i);
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
        return invokeIL.booleanValue;
    }
}
