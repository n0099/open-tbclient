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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void doubleCapacity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            E[] eArr = this.mElements;
            int length = eArr.length;
            int i2 = this.mHead;
            int i3 = length - i2;
            int i4 = length << 1;
            if (i4 >= 0) {
                E[] eArr2 = (E[]) new Object[i4];
                System.arraycopy(eArr, i2, eArr2, 0, i3);
                System.arraycopy(this.mElements, 0, eArr2, i3, this.mHead);
                this.mElements = eArr2;
                this.mHead = 0;
                this.mTail = length;
                this.mCapacityBitmask = i4 - 1;
                return;
            }
            throw new RuntimeException("Max array capacity exceeded");
        }
    }

    public void addFirst(E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, e2) == null) {
            int i2 = (this.mHead - 1) & this.mCapacityBitmask;
            this.mHead = i2;
            this.mElements[i2] = e2;
            if (i2 == this.mTail) {
                doubleCapacity();
            }
        }
    }

    public void addLast(E e2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, e2) == null) {
            E[] eArr = this.mElements;
            int i2 = this.mTail;
            eArr[i2] = e2;
            int i3 = this.mCapacityBitmask & (i2 + 1);
            this.mTail = i3;
            if (i3 == this.mHead) {
                doubleCapacity();
            }
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            removeFromStart(size());
        }
    }

    public E get(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 < 0 || i2 >= size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return this.mElements[this.mCapacityBitmask & (this.mHead + i2)];
        }
        return (E) invokeI.objValue;
    }

    public E getFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i2 = this.mHead;
            if (i2 != this.mTail) {
                return this.mElements[i2];
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) invokeV.objValue;
    }

    public E getLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            int i2 = this.mHead;
            int i3 = this.mTail;
            if (i2 != i3) {
                return this.mElements[(i3 - 1) & this.mCapacityBitmask];
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) invokeV.objValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mHead == this.mTail : invokeV.booleanValue;
    }

    public E popFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i2 = this.mHead;
            if (i2 != this.mTail) {
                E[] eArr = this.mElements;
                E e2 = eArr[i2];
                eArr[i2] = null;
                this.mHead = (i2 + 1) & this.mCapacityBitmask;
                return e2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) invokeV.objValue;
    }

    public E popLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i2 = this.mHead;
            int i3 = this.mTail;
            if (i2 != i3) {
                int i4 = this.mCapacityBitmask & (i3 - 1);
                E[] eArr = this.mElements;
                E e2 = eArr[i4];
                eArr[i4] = null;
                this.mTail = i4;
                return e2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E) invokeV.objValue;
    }

    public void removeFromEnd(int i2) {
        int i3;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || i2 <= 0) {
            return;
        }
        if (i2 <= size()) {
            int i4 = this.mTail;
            int i5 = i2 < i4 ? i4 - i2 : 0;
            int i6 = i5;
            while (true) {
                i3 = this.mTail;
                if (i6 >= i3) {
                    break;
                }
                this.mElements[i6] = null;
                i6++;
            }
            int i7 = i3 - i5;
            int i8 = i2 - i7;
            this.mTail = i3 - i7;
            if (i8 > 0) {
                int length = this.mElements.length;
                this.mTail = length;
                int i9 = length - i8;
                for (int i10 = i9; i10 < this.mTail; i10++) {
                    this.mElements[i10] = null;
                }
                this.mTail = i9;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i2) == null) || i2 <= 0) {
            return;
        }
        if (i2 <= size()) {
            int length = this.mElements.length;
            int i3 = this.mHead;
            if (i2 < length - i3) {
                length = i3 + i2;
            }
            for (int i4 = this.mHead; i4 < length; i4++) {
                this.mElements[i4] = null;
            }
            int i5 = this.mHead;
            int i6 = length - i5;
            int i7 = i2 - i6;
            this.mHead = this.mCapacityBitmask & (i5 + i6);
            if (i7 > 0) {
                for (int i8 = 0; i8 < i7; i8++) {
                    this.mElements[i8] = null;
                }
                this.mHead = i7;
                return;
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (this.mTail - this.mHead) & this.mCapacityBitmask : invokeV.intValue;
    }

    public CircularArray(int i2) {
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
        if (i2 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i2 <= 1073741824) {
            i2 = Integer.bitCount(i2) != 1 ? Integer.highestOneBit(i2 - 1) << 1 : i2;
            this.mCapacityBitmask = i2 - 1;
            this.mElements = (E[]) new Object[i2];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }
}
