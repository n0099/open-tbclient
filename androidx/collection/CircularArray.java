package androidx.collection;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class CircularArray<E> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCapacityBitmask;
    public E[] mElements;
    public int mHead;
    public int mTail;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircularArray() {
        this(8);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeFromStart(size());
        }
    }

    public E getFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.mHead;
            if (i != this.mTail) {
                return this.mElements[i];
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) invokeV.objValue;
    }

    public E getLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i = this.mHead;
            int i2 = this.mTail;
            if (i != i2) {
                return this.mElements[(i2 - 1) & this.mCapacityBitmask];
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) invokeV.objValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (this.mHead == this.mTail) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public E popFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = this.mHead;
            if (i != this.mTail) {
                E[] eArr = this.mElements;
                E e = eArr[i];
                eArr[i] = null;
                this.mHead = (i + 1) & this.mCapacityBitmask;
                return e;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) invokeV.objValue;
    }

    public E popLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.mHead;
            int i2 = this.mTail;
            if (i != i2) {
                int i3 = this.mCapacityBitmask & (i2 - 1);
                E[] eArr = this.mElements;
                E e = eArr[i3];
                eArr[i3] = null;
                this.mTail = i3;
                return e;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) invokeV.objValue;
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return (this.mTail - this.mHead) & this.mCapacityBitmask;
        }
        return invokeV.intValue;
    }

    public CircularArray(int i) {
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
        if (i >= 1) {
            if (i <= 1073741824) {
                i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
                this.mCapacityBitmask = i - 1;
                this.mElements = (E[]) new Object[i];
                return;
            }
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        throw new IllegalArgumentException("capacity must be >= 1");
    }

    public void removeFromEnd(int i) {
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048585, this, i) != null) || i <= 0) {
            return;
        }
        if (i <= size()) {
            int i3 = 0;
            int i4 = this.mTail;
            if (i < i4) {
                i3 = i4 - i;
            }
            int i5 = i3;
            while (true) {
                i2 = this.mTail;
                if (i5 >= i2) {
                    break;
                }
                this.mElements[i5] = null;
                i5++;
            }
            int i6 = i2 - i3;
            int i7 = i - i6;
            this.mTail = i2 - i6;
            if (i7 > 0) {
                int length = this.mElements.length;
                this.mTail = length;
                int i8 = length - i7;
                for (int i9 = i8; i9 < this.mTail; i9++) {
                    this.mElements[i9] = null;
                }
                this.mTail = i8;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048586, this, i) != null) || i <= 0) {
            return;
        }
        if (i <= size()) {
            int length = this.mElements.length;
            int i2 = this.mHead;
            if (i < length - i2) {
                length = i2 + i;
            }
            for (int i3 = this.mHead; i3 < length; i3++) {
                this.mElements[i3] = null;
            }
            int i4 = this.mHead;
            int i5 = length - i4;
            int i6 = i - i5;
            this.mHead = this.mCapacityBitmask & (i4 + i5);
            if (i6 > 0) {
                for (int i7 = 0; i7 < i6; i7++) {
                    this.mElements[i7] = null;
                }
                this.mHead = i6;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    private void doubleCapacity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            E[] eArr = this.mElements;
            int length = eArr.length;
            int i = this.mHead;
            int i2 = length - i;
            int i3 = length << 1;
            if (i3 >= 0) {
                E[] eArr2 = (E[]) new Object[i3];
                System.arraycopy(eArr, i, eArr2, 0, i2);
                System.arraycopy(this.mElements, 0, eArr2, i2, this.mHead);
                this.mElements = eArr2;
                this.mHead = 0;
                this.mTail = length;
                this.mCapacityBitmask = i3 - 1;
                return;
            }
            throw new RuntimeException("Max array capacity exceeded");
        }
    }

    public void addFirst(E e) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, e) == null) {
            int i = (this.mHead - 1) & this.mCapacityBitmask;
            this.mHead = i;
            this.mElements[i] = e;
            if (i == this.mTail) {
                doubleCapacity();
            }
        }
    }

    public void addLast(E e) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e) == null) {
            E[] eArr = this.mElements;
            int i = this.mTail;
            eArr[i] = e;
            int i2 = this.mCapacityBitmask & (i + 1);
            this.mTail = i2;
            if (i2 == this.mHead) {
                doubleCapacity();
            }
        }
    }

    public E get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i >= 0 && i < size()) {
                return this.mElements[this.mCapacityBitmask & (this.mHead + i)];
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) invokeI.objValue;
    }
}
