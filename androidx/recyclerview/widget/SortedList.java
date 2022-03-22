package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
/* loaded from: classes.dex */
public class SortedList<T> {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CAPACITY_GROWTH = 10;
    public static final int DELETION = 2;
    public static final int INSERTION = 1;
    public static final int INVALID_POSITION = -1;
    public static final int LOOKUP = 4;
    public static final int MIN_CAPACITY = 10;
    public transient /* synthetic */ FieldHolder $fh;
    public BatchedCallback mBatchedCallback;
    public Callback mCallback;
    public T[] mData;
    public int mNewDataStart;
    public T[] mOldData;
    public int mOldDataSize;
    public int mOldDataStart;
    public int mSize;
    public final Class<T> mTClass;

    /* loaded from: classes.dex */
    public static class BatchedCallback<T2> extends Callback<T2> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final BatchingListUpdateCallback mBatchingListUpdateCallback;
        public final Callback<T2> mWrappedCallback;

        public BatchedCallback(Callback<T2> callback) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {callback};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.mWrappedCallback = callback;
            this.mBatchingListUpdateCallback = new BatchingListUpdateCallback(callback);
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areContentsTheSame(T2 t2, T2 t22) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, t2, t22)) == null) ? this.mWrappedCallback.areContentsTheSame(t2, t22) : invokeLL.booleanValue;
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public boolean areItemsTheSame(T2 t2, T2 t22) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, t2, t22)) == null) ? this.mWrappedCallback.areItemsTheSame(t2, t22) : invokeLL.booleanValue;
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, java.util.Comparator
        public int compare(T2 t2, T2 t22) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, t2, t22)) == null) ? this.mWrappedCallback.compare(t2, t22) : invokeLL.intValue;
        }

        public void dispatchLastEvent() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                this.mBatchingListUpdateCallback.dispatchLastEvent();
            }
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, t2, t22)) == null) ? this.mWrappedCallback.getChangePayload(t2, t22) : invokeLL.objValue;
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback
        public void onChanged(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i, i2) == null) {
                this.mBatchingListUpdateCallback.onChanged(i, i2, null);
            }
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
                this.mBatchingListUpdateCallback.onInserted(i, i2);
            }
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
                this.mBatchingListUpdateCallback.onMoved(i, i2);
            }
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048585, this, i, i2) == null) {
                this.mBatchingListUpdateCallback.onRemoved(i, i2);
            }
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, obj) == null) {
                this.mBatchingListUpdateCallback.onChanged(i, i2, obj);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public Callback() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract boolean areContentsTheSame(T2 t2, T2 t22);

        public abstract boolean areItemsTheSame(T2 t2, T2 t22);

        @Override // java.util.Comparator
        public abstract int compare(T2 t2, T2 t22);

        @Nullable
        public Object getChangePayload(T2 t2, T2 t22) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, t2, t22)) == null) {
                return null;
            }
            return invokeLL.objValue;
        }

        public abstract void onChanged(int i, int i2);

        public void onChanged(int i, int i2, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, obj) == null) {
                onChanged(i, i2);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, callback};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Class) objArr2[0], (Callback) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void addAllInternal(T[] tArr) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, this, tArr) == null) || tArr.length < 1) {
            return;
        }
        int sortAndDedup = sortAndDedup(tArr);
        if (this.mSize == 0) {
            this.mData = tArr;
            this.mSize = sortAndDedup;
            this.mCallback.onInserted(0, sortAndDedup);
            return;
        }
        merge(tArr, sortAndDedup);
    }

    private void addToData(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i, t) == null) {
            int i2 = this.mSize;
            if (i <= i2) {
                T[] tArr = this.mData;
                if (i2 == tArr.length) {
                    T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length + 10));
                    System.arraycopy(this.mData, 0, tArr2, 0, i);
                    tArr2[i] = t;
                    System.arraycopy(this.mData, i, tArr2, i + 1, this.mSize - i);
                    this.mData = tArr2;
                } else {
                    System.arraycopy(tArr, i, tArr, i + 1, i2 - i);
                    this.mData[i] = t;
                }
                this.mSize++;
                return;
            }
            throw new IndexOutOfBoundsException("cannot add item to " + i + " because size is " + this.mSize);
        }
    }

    private T[] copyArray(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, this, tArr)) == null) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length));
            System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
            return tArr2;
        }
        return (T[]) ((Object[]) invokeL.objValue);
    }

    private int findIndexOf(T t, T[] tArr, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65542, this, new Object[]{t, tArr, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            while (i < i2) {
                int i4 = (i + i2) / 2;
                T t2 = tArr[i4];
                int compare = this.mCallback.compare(t2, t);
                if (compare < 0) {
                    i = i4 + 1;
                } else if (compare == 0) {
                    if (this.mCallback.areItemsTheSame(t2, t)) {
                        return i4;
                    }
                    int linearEqualitySearch = linearEqualitySearch(t, i4, i, i2);
                    return (i3 == 1 && linearEqualitySearch == -1) ? i4 : linearEqualitySearch;
                } else {
                    i2 = i4;
                }
            }
            if (i3 == 1) {
                return i;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    private int findSameItem(T t, T[] tArr, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65543, this, t, tArr, i, i2)) == null) {
            while (i < i2) {
                if (this.mCallback.areItemsTheSame(tArr[i], t)) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        return invokeLLII.intValue;
    }

    private int linearEqualitySearch(T t, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65544, this, t, i, i2, i3)) == null) {
            for (int i4 = i - 1; i4 >= i2; i4--) {
                T t3 = this.mData[i4];
                if (this.mCallback.compare(t3, t) != 0) {
                    break;
                } else if (this.mCallback.areItemsTheSame(t3, t)) {
                    return i4;
                }
            }
            do {
                i++;
                if (i >= i3) {
                    return -1;
                }
                t2 = this.mData[i];
                if (this.mCallback.compare(t2, t) != 0) {
                    return -1;
                }
            } while (!this.mCallback.areItemsTheSame(t2, t));
            return i;
        }
        return invokeLIII.intValue;
    }

    private void merge(T[] tArr, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, this, tArr, i) == null) {
            boolean z = !(this.mCallback instanceof BatchedCallback);
            if (z) {
                beginBatchedUpdates();
            }
            this.mOldData = this.mData;
            int i2 = 0;
            this.mOldDataStart = 0;
            int i3 = this.mSize;
            this.mOldDataSize = i3;
            this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, i3 + i + 10));
            this.mNewDataStart = 0;
            while (true) {
                if (this.mOldDataStart >= this.mOldDataSize && i2 >= i) {
                    break;
                }
                int i4 = this.mOldDataStart;
                int i5 = this.mOldDataSize;
                if (i4 == i5) {
                    int i6 = i - i2;
                    System.arraycopy(tArr, i2, this.mData, this.mNewDataStart, i6);
                    int i7 = this.mNewDataStart + i6;
                    this.mNewDataStart = i7;
                    this.mSize += i6;
                    this.mCallback.onInserted(i7 - i6, i6);
                    break;
                } else if (i2 == i) {
                    int i8 = i5 - i4;
                    System.arraycopy(this.mOldData, i4, this.mData, this.mNewDataStart, i8);
                    this.mNewDataStart += i8;
                    break;
                } else {
                    T t = this.mOldData[i4];
                    T t2 = tArr[i2];
                    int compare = this.mCallback.compare(t, t2);
                    if (compare > 0) {
                        T[] tArr2 = this.mData;
                        int i9 = this.mNewDataStart;
                        int i10 = i9 + 1;
                        this.mNewDataStart = i10;
                        tArr2[i9] = t2;
                        this.mSize++;
                        i2++;
                        this.mCallback.onInserted(i10 - 1, 1);
                    } else if (compare == 0 && this.mCallback.areItemsTheSame(t, t2)) {
                        T[] tArr3 = this.mData;
                        int i11 = this.mNewDataStart;
                        this.mNewDataStart = i11 + 1;
                        tArr3[i11] = t2;
                        i2++;
                        this.mOldDataStart++;
                        if (!this.mCallback.areContentsTheSame(t, t2)) {
                            Callback callback = this.mCallback;
                            callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t, t2));
                        }
                    } else {
                        T[] tArr4 = this.mData;
                        int i12 = this.mNewDataStart;
                        this.mNewDataStart = i12 + 1;
                        tArr4[i12] = t;
                        this.mOldDataStart++;
                    }
                }
            }
            this.mOldData = null;
            if (z) {
                endBatchedUpdates();
            }
        }
    }

    private void removeItemAtIndex(int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            T[] tArr = this.mData;
            System.arraycopy(tArr, i + 1, tArr, i, (this.mSize - i) - 1);
            int i2 = this.mSize - 1;
            this.mSize = i2;
            this.mData[i2] = null;
            if (z) {
                this.mCallback.onRemoved(i, 1);
            }
        }
    }

    private void replaceAllInsert(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, t) == null) {
            T[] tArr = this.mData;
            int i = this.mNewDataStart;
            tArr[i] = t;
            int i2 = i + 1;
            this.mNewDataStart = i2;
            this.mSize++;
            this.mCallback.onInserted(i2 - 1, 1);
        }
    }

    private void replaceAllInternal(@NonNull T[] tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, tArr) == null) {
            boolean z = !(this.mCallback instanceof BatchedCallback);
            if (z) {
                beginBatchedUpdates();
            }
            this.mOldDataStart = 0;
            this.mOldDataSize = this.mSize;
            this.mOldData = this.mData;
            this.mNewDataStart = 0;
            int sortAndDedup = sortAndDedup(tArr);
            this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, sortAndDedup));
            while (true) {
                if (this.mNewDataStart >= sortAndDedup && this.mOldDataStart >= this.mOldDataSize) {
                    break;
                }
                int i = this.mOldDataStart;
                int i2 = this.mOldDataSize;
                if (i >= i2) {
                    int i3 = this.mNewDataStart;
                    int i4 = sortAndDedup - i3;
                    System.arraycopy(tArr, i3, this.mData, i3, i4);
                    this.mNewDataStart += i4;
                    this.mSize += i4;
                    this.mCallback.onInserted(i3, i4);
                    break;
                }
                int i5 = this.mNewDataStart;
                if (i5 >= sortAndDedup) {
                    int i6 = i2 - i;
                    this.mSize -= i6;
                    this.mCallback.onRemoved(i5, i6);
                    break;
                }
                T t = this.mOldData[i];
                T t2 = tArr[i5];
                int compare = this.mCallback.compare(t, t2);
                if (compare < 0) {
                    replaceAllRemove();
                } else if (compare > 0) {
                    replaceAllInsert(t2);
                } else if (!this.mCallback.areItemsTheSame(t, t2)) {
                    replaceAllRemove();
                    replaceAllInsert(t2);
                } else {
                    T[] tArr2 = this.mData;
                    int i7 = this.mNewDataStart;
                    tArr2[i7] = t2;
                    this.mOldDataStart++;
                    this.mNewDataStart = i7 + 1;
                    if (!this.mCallback.areContentsTheSame(t, t2)) {
                        Callback callback = this.mCallback;
                        callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t, t2));
                    }
                }
            }
            this.mOldData = null;
            if (z) {
                endBatchedUpdates();
            }
        }
    }

    private void replaceAllRemove() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            this.mSize--;
            this.mOldDataStart++;
            this.mCallback.onRemoved(this.mNewDataStart, 1);
        }
    }

    private int sortAndDedup(@NonNull T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, this, tArr)) == null) {
            if (tArr.length == 0) {
                return 0;
            }
            Arrays.sort(tArr, this.mCallback);
            int i = 1;
            int i2 = 0;
            for (int i3 = 1; i3 < tArr.length; i3++) {
                T t = tArr[i3];
                if (this.mCallback.compare(tArr[i2], t) == 0) {
                    int findSameItem = findSameItem(t, tArr, i2, i);
                    if (findSameItem != -1) {
                        tArr[findSameItem] = t;
                    } else {
                        if (i != i3) {
                            tArr[i] = t;
                        }
                        i++;
                    }
                } else {
                    if (i != i3) {
                        tArr[i] = t;
                    }
                    i2 = i;
                    i++;
                }
            }
            return i;
        }
        return invokeL.intValue;
    }

    private void throwIfInMutationOperation() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65552, this) == null) && this.mOldData != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    public int add(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, t)) == null) {
            throwIfInMutationOperation();
            return add(t, true);
        }
        return invokeL.intValue;
    }

    public void addAll(@NonNull T[] tArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, tArr, z) == null) {
            throwIfInMutationOperation();
            if (tArr.length == 0) {
                return;
            }
            if (z) {
                addAllInternal(tArr);
            } else {
                addAllInternal(copyArray(tArr));
            }
        }
    }

    public void beginBatchedUpdates() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            throwIfInMutationOperation();
            Callback callback = this.mCallback;
            if (callback instanceof BatchedCallback) {
                return;
            }
            if (this.mBatchedCallback == null) {
                this.mBatchedCallback = new BatchedCallback(callback);
            }
            this.mCallback = this.mBatchedCallback;
        }
    }

    public void clear() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            throwIfInMutationOperation();
            int i = this.mSize;
            if (i == 0) {
                return;
            }
            Arrays.fill(this.mData, 0, i, (Object) null);
            this.mSize = 0;
            this.mCallback.onRemoved(0, i);
        }
    }

    public void endBatchedUpdates() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            throwIfInMutationOperation();
            Callback callback = this.mCallback;
            if (callback instanceof BatchedCallback) {
                ((BatchedCallback) callback).dispatchLastEvent();
            }
            Callback callback2 = this.mCallback;
            BatchedCallback batchedCallback = this.mBatchedCallback;
            if (callback2 == batchedCallback) {
                this.mCallback = batchedCallback.mWrappedCallback;
            }
        }
    }

    public T get(int i) throws IndexOutOfBoundsException {
        InterceptResult invokeI;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            if (i < this.mSize && i >= 0) {
                T[] tArr = this.mOldData;
                if (tArr != null && i >= (i2 = this.mNewDataStart)) {
                    return tArr[(i - i2) + this.mOldDataStart];
                }
                return this.mData[i];
            }
            throw new IndexOutOfBoundsException("Asked to get item at " + i + " but size is " + this.mSize);
        }
        return (T) invokeI.objValue;
    }

    public int indexOf(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, t)) == null) {
            if (this.mOldData != null) {
                int findIndexOf = findIndexOf(t, this.mData, 0, this.mNewDataStart, 4);
                if (findIndexOf != -1) {
                    return findIndexOf;
                }
                int findIndexOf2 = findIndexOf(t, this.mOldData, this.mOldDataStart, this.mOldDataSize, 4);
                if (findIndexOf2 != -1) {
                    return (findIndexOf2 - this.mOldDataStart) + this.mNewDataStart;
                }
                return -1;
            }
            return findIndexOf(t, this.mData, 0, this.mSize, 4);
        }
        return invokeL.intValue;
    }

    public void recalculatePositionOfItemAt(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            throwIfInMutationOperation();
            T t = get(i);
            removeItemAtIndex(i, false);
            int add = add(t, false);
            if (i != add) {
                this.mCallback.onMoved(i, add);
            }
        }
    }

    public boolean remove(T t) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, t)) == null) {
            throwIfInMutationOperation();
            return remove(t, true);
        }
        return invokeL.booleanValue;
    }

    public T removeItemAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            throwIfInMutationOperation();
            T t = get(i);
            removeItemAtIndex(i, true);
            return t;
        }
        return (T) invokeI.objValue;
    }

    public void replaceAll(@NonNull T[] tArr, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048590, this, tArr, z) == null) {
            throwIfInMutationOperation();
            if (z) {
                replaceAllInternal(tArr);
            } else {
                replaceAllInternal(copyArray(tArr));
            }
        }
    }

    public int size() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.mSize : invokeV.intValue;
    }

    public void updateItemAt(int i, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i, t) == null) {
            throwIfInMutationOperation();
            T t2 = get(i);
            boolean z = t2 == t || !this.mCallback.areContentsTheSame(t2, t);
            if (t2 != t && this.mCallback.compare(t2, t) == 0) {
                this.mData[i] = t;
                if (z) {
                    Callback callback = this.mCallback;
                    callback.onChanged(i, 1, callback.getChangePayload(t2, t));
                    return;
                }
                return;
            }
            if (z) {
                Callback callback2 = this.mCallback;
                callback2.onChanged(i, 1, callback2.getChangePayload(t2, t));
            }
            removeItemAtIndex(i, false);
            int add = add(t, false);
            if (i != add) {
                this.mCallback.onMoved(i, add);
            }
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, callback, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTClass = cls;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i));
        this.mCallback = callback;
        this.mSize = 0;
    }

    private int add(T t, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65538, this, t, z)) == null) {
            int findIndexOf = findIndexOf(t, this.mData, 0, this.mSize, 1);
            if (findIndexOf == -1) {
                findIndexOf = 0;
            } else if (findIndexOf < this.mSize) {
                T t2 = this.mData[findIndexOf];
                if (this.mCallback.areItemsTheSame(t2, t)) {
                    if (this.mCallback.areContentsTheSame(t2, t)) {
                        this.mData[findIndexOf] = t;
                        return findIndexOf;
                    }
                    this.mData[findIndexOf] = t;
                    Callback callback = this.mCallback;
                    callback.onChanged(findIndexOf, 1, callback.getChangePayload(t2, t));
                    return findIndexOf;
                }
            }
            addToData(findIndexOf, t);
            if (z) {
                this.mCallback.onInserted(findIndexOf, 1);
            }
            return findIndexOf;
        }
        return invokeLZ.intValue;
    }

    private boolean remove(T t, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, this, t, z)) == null) {
            int findIndexOf = findIndexOf(t, this.mData, 0, this.mSize, 2);
            if (findIndexOf == -1) {
                return false;
            }
            removeItemAtIndex(findIndexOf, z);
            return true;
        }
        return invokeLZ.booleanValue;
    }

    public void replaceAll(@NonNull T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, tArr) == null) {
            replaceAll(tArr, false);
        }
    }

    public void addAll(@NonNull T... tArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tArr) == null) {
            addAll(tArr, false);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: androidx.recyclerview.widget.SortedList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void replaceAll(@NonNull Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, collection) == null) {
            replaceAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: androidx.recyclerview.widget.SortedList<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void addAll(@NonNull Collection<T> collection) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, collection) == null) {
            addAll(collection.toArray((Object[]) Array.newInstance((Class<?>) this.mTClass, collection.size())), true);
        }
    }
}
