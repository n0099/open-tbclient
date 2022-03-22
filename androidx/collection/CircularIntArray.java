package androidx.collection;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public final class CircularIntArray {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int mCapacityBitmask;
    public int[] mElements;
    public int mHead;
    public int mTail;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CircularIntArray() {
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

    private void doubleCapacity() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            int[] iArr = this.mElements;
            int length = iArr.length;
            int i = this.mHead;
            int i2 = length - i;
            int i3 = length << 1;
            if (i3 >= 0) {
                int[] iArr2 = new int[i3];
                System.arraycopy(iArr, i, iArr2, 0, i2);
                System.arraycopy(this.mElements, 0, iArr2, i2, this.mHead);
                this.mElements = iArr2;
                this.mHead = 0;
                this.mTail = length;
                this.mCapacityBitmask = i3 - 1;
                return;
            }
            throw new RuntimeException("Max array capacity exceeded");
        }
    }

    public void addFirst(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            int i2 = (this.mHead - 1) & this.mCapacityBitmask;
            this.mHead = i2;
            this.mElements[i2] = i;
            if (i2 == this.mTail) {
                doubleCapacity();
            }
        }
    }

    public void addLast(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            int[] iArr = this.mElements;
            int i2 = this.mTail;
            iArr[i2] = i;
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
            this.mTail = this.mHead;
        }
    }

    public int get(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i < 0 || i >= size()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return this.mElements[this.mCapacityBitmask & (this.mHead + i)];
        }
        return invokeI.intValue;
    }

    public int getFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            int i = this.mHead;
            if (i != this.mTail) {
                return this.mElements[i];
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        return invokeV.intValue;
    }

    public int getLast() {
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
        return invokeV.intValue;
    }

    public boolean isEmpty() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mHead == this.mTail : invokeV.booleanValue;
    }

    public int popFirst() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            int i = this.mHead;
            if (i != this.mTail) {
                int i2 = this.mElements[i];
                this.mHead = (i + 1) & this.mCapacityBitmask;
                return i2;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        return invokeV.intValue;
    }

    public int popLast() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            int i = this.mHead;
            int i2 = this.mTail;
            if (i != i2) {
                int i3 = this.mCapacityBitmask & (i2 - 1);
                int i4 = this.mElements[i3];
                this.mTail = i3;
                return i4;
            }
            throw new ArrayIndexOutOfBoundsException();
        }
        return invokeV.intValue;
    }

    public void removeFromEnd(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i) == null) || i <= 0) {
            return;
        }
        if (i <= size()) {
            this.mTail = this.mCapacityBitmask & (this.mTail - i);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public void removeFromStart(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048586, this, i) == null) || i <= 0) {
            return;
        }
        if (i <= size()) {
            this.mHead = this.mCapacityBitmask & (this.mHead + i);
            return;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? (this.mTail - this.mHead) & this.mCapacityBitmask : invokeV.intValue;
    }

    public CircularIntArray(int i) {
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
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i <= 1073741824) {
            i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
            this.mCapacityBitmask = i - 1;
            this.mElements = new int[i];
            return;
        }
        throw new IllegalArgumentException("capacity must be <= 2^30");
    }
}
