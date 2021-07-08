package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
        public void onChanged(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048581, this, i2, i3) == null) {
                this.mBatchingListUpdateCallback.onChanged(i2, i3, null);
            }
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
                this.mBatchingListUpdateCallback.onInserted(i2, i3);
            }
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
                this.mBatchingListUpdateCallback.onMoved(i2, i3);
            }
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048585, this, i2, i3) == null) {
                this.mBatchingListUpdateCallback.onRemoved(i2, i3);
            }
        }

        @Override // androidx.recyclerview.widget.SortedList.Callback, androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i2, int i3, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048582, this, i2, i3, obj) == null) {
                this.mBatchingListUpdateCallback.onChanged(i2, i3, obj);
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        public abstract void onChanged(int i2, int i3);

        public void onChanged(int i2, int i3, Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, obj) == null) {
                onChanged(i2, i3);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    private void addToData(int i2, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(InputDeviceCompat.SOURCE_TRACKBALL, this, i2, t) == null) {
            int i3 = this.mSize;
            if (i2 <= i3) {
                T[] tArr = this.mData;
                if (i3 == tArr.length) {
                    T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length + 10));
                    System.arraycopy(this.mData, 0, tArr2, 0, i2);
                    tArr2[i2] = t;
                    System.arraycopy(this.mData, i2, tArr2, i2 + 1, this.mSize - i2);
                    this.mData = tArr2;
                } else {
                    System.arraycopy(tArr, i2, tArr, i2 + 1, i3 - i2);
                    this.mData[i2] = t;
                }
                this.mSize++;
                return;
            }
            throw new IndexOutOfBoundsException("cannot add item to " + i2 + " because size is " + this.mSize);
        }
    }

    private T[] copyArray(T[] tArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, this, tArr)) == null) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, tArr.length));
            System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
            return tArr2;
        }
        return (T[]) ((Object[]) invokeL.objValue);
    }

    private int findIndexOf(T t, T[] tArr, int i2, int i3, int i4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, this, new Object[]{t, tArr, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)})) == null) {
            while (i2 < i3) {
                int i5 = (i2 + i3) / 2;
                T t2 = tArr[i5];
                int compare = this.mCallback.compare(t2, t);
                if (compare < 0) {
                    i2 = i5 + 1;
                } else if (compare == 0) {
                    if (this.mCallback.areItemsTheSame(t2, t)) {
                        return i5;
                    }
                    int linearEqualitySearch = linearEqualitySearch(t, i5, i2, i3);
                    return (i4 == 1 && linearEqualitySearch == -1) ? i5 : linearEqualitySearch;
                } else {
                    i3 = i5;
                }
            }
            if (i4 == 1) {
                return i2;
            }
            return -1;
        }
        return invokeCommon.intValue;
    }

    private int findSameItem(T t, T[] tArr, int i2, int i3) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65543, this, t, tArr, i2, i3)) == null) {
            while (i2 < i3) {
                if (this.mCallback.areItemsTheSame(tArr[i2], t)) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        return invokeLLII.intValue;
    }

    private int linearEqualitySearch(T t, int i2, int i3, int i4) {
        InterceptResult invokeLIII;
        T t2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65544, this, t, i2, i3, i4)) == null) {
            for (int i5 = i2 - 1; i5 >= i3; i5--) {
                T t3 = this.mData[i5];
                if (this.mCallback.compare(t3, t) != 0) {
                    break;
                } else if (this.mCallback.areItemsTheSame(t3, t)) {
                    return i5;
                }
            }
            do {
                i2++;
                if (i2 >= i4) {
                    return -1;
                }
                t2 = this.mData[i2];
                if (this.mCallback.compare(t2, t) != 0) {
                    return -1;
                }
            } while (!this.mCallback.areItemsTheSame(t2, t));
            return i2;
        }
        return invokeLIII.intValue;
    }

    private void merge(T[] tArr, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65545, this, tArr, i2) == null) {
            boolean z = !(this.mCallback instanceof BatchedCallback);
            if (z) {
                beginBatchedUpdates();
            }
            this.mOldData = this.mData;
            int i3 = 0;
            this.mOldDataStart = 0;
            int i4 = this.mSize;
            this.mOldDataSize = i4;
            this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) this.mTClass, i4 + i2 + 10));
            this.mNewDataStart = 0;
            while (true) {
                if (this.mOldDataStart >= this.mOldDataSize && i3 >= i2) {
                    break;
                }
                int i5 = this.mOldDataStart;
                int i6 = this.mOldDataSize;
                if (i5 == i6) {
                    int i7 = i2 - i3;
                    System.arraycopy(tArr, i3, this.mData, this.mNewDataStart, i7);
                    int i8 = this.mNewDataStart + i7;
                    this.mNewDataStart = i8;
                    this.mSize += i7;
                    this.mCallback.onInserted(i8 - i7, i7);
                    break;
                } else if (i3 == i2) {
                    int i9 = i6 - i5;
                    System.arraycopy(this.mOldData, i5, this.mData, this.mNewDataStart, i9);
                    this.mNewDataStart += i9;
                    break;
                } else {
                    T t = this.mOldData[i5];
                    T t2 = tArr[i3];
                    int compare = this.mCallback.compare(t, t2);
                    if (compare > 0) {
                        T[] tArr2 = this.mData;
                        int i10 = this.mNewDataStart;
                        int i11 = i10 + 1;
                        this.mNewDataStart = i11;
                        tArr2[i10] = t2;
                        this.mSize++;
                        i3++;
                        this.mCallback.onInserted(i11 - 1, 1);
                    } else if (compare == 0 && this.mCallback.areItemsTheSame(t, t2)) {
                        T[] tArr3 = this.mData;
                        int i12 = this.mNewDataStart;
                        this.mNewDataStart = i12 + 1;
                        tArr3[i12] = t2;
                        i3++;
                        this.mOldDataStart++;
                        if (!this.mCallback.areContentsTheSame(t, t2)) {
                            Callback callback = this.mCallback;
                            callback.onChanged(this.mNewDataStart - 1, 1, callback.getChangePayload(t, t2));
                        }
                    } else {
                        T[] tArr4 = this.mData;
                        int i13 = this.mNewDataStart;
                        this.mNewDataStart = i13 + 1;
                        tArr4[i13] = t;
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

    private void removeItemAtIndex(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65547, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            T[] tArr = this.mData;
            System.arraycopy(tArr, i2 + 1, tArr, i2, (this.mSize - i2) - 1);
            int i3 = this.mSize - 1;
            this.mSize = i3;
            this.mData[i3] = null;
            if (z) {
                this.mCallback.onRemoved(i2, 1);
            }
        }
    }

    private void replaceAllInsert(T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, t) == null) {
            T[] tArr = this.mData;
            int i2 = this.mNewDataStart;
            tArr[i2] = t;
            int i3 = i2 + 1;
            this.mNewDataStart = i3;
            this.mSize++;
            this.mCallback.onInserted(i3 - 1, 1);
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
                int i2 = this.mOldDataStart;
                int i3 = this.mOldDataSize;
                if (i2 >= i3) {
                    int i4 = this.mNewDataStart;
                    int i5 = sortAndDedup - i4;
                    System.arraycopy(tArr, i4, this.mData, i4, i5);
                    this.mNewDataStart += i5;
                    this.mSize += i5;
                    this.mCallback.onInserted(i4, i5);
                    break;
                }
                int i6 = this.mNewDataStart;
                if (i6 >= sortAndDedup) {
                    int i7 = i3 - i2;
                    this.mSize -= i7;
                    this.mCallback.onRemoved(i6, i7);
                    break;
                }
                T t = this.mOldData[i2];
                T t2 = tArr[i6];
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
                    int i8 = this.mNewDataStart;
                    tArr2[i8] = t2;
                    this.mOldDataStart++;
                    this.mNewDataStart = i8 + 1;
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
            int i2 = 1;
            int i3 = 0;
            for (int i4 = 1; i4 < tArr.length; i4++) {
                T t = tArr[i4];
                if (this.mCallback.compare(tArr[i3], t) == 0) {
                    int findSameItem = findSameItem(t, tArr, i3, i2);
                    if (findSameItem != -1) {
                        tArr[findSameItem] = t;
                    } else {
                        if (i2 != i4) {
                            tArr[i2] = t;
                        }
                        i2++;
                    }
                } else {
                    if (i2 != i4) {
                        tArr[i2] = t;
                    }
                    i3 = i2;
                    i2++;
                }
            }
            return i2;
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
            int i2 = this.mSize;
            if (i2 == 0) {
                return;
            }
            Arrays.fill(this.mData, 0, i2, (Object) null);
            this.mSize = 0;
            this.mCallback.onRemoved(0, i2);
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

    public T get(int i2) throws IndexOutOfBoundsException {
        InterceptResult invokeI;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
            if (i2 < this.mSize && i2 >= 0) {
                T[] tArr = this.mOldData;
                if (tArr != null && i2 >= (i3 = this.mNewDataStart)) {
                    return tArr[(i2 - i3) + this.mOldDataStart];
                }
                return this.mData[i2];
            }
            throw new IndexOutOfBoundsException("Asked to get item at " + i2 + " but size is " + this.mSize);
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

    public void recalculatePositionOfItemAt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            throwIfInMutationOperation();
            T t = get(i2);
            removeItemAtIndex(i2, false);
            int add = add(t, false);
            if (i2 != add) {
                this.mCallback.onMoved(i2, add);
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

    public T removeItemAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) {
            throwIfInMutationOperation();
            T t = get(i2);
            removeItemAtIndex(i2, true);
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

    public void updateItemAt(int i2, T t) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048592, this, i2, t) == null) {
            throwIfInMutationOperation();
            T t2 = get(i2);
            boolean z = t2 == t || !this.mCallback.areContentsTheSame(t2, t);
            if (t2 != t && this.mCallback.compare(t2, t) == 0) {
                this.mData[i2] = t;
                if (z) {
                    Callback callback = this.mCallback;
                    callback.onChanged(i2, 1, callback.getChangePayload(t2, t));
                    return;
                }
                return;
            }
            if (z) {
                Callback callback2 = this.mCallback;
                callback2.onChanged(i2, 1, callback2.getChangePayload(t2, t));
            }
            removeItemAtIndex(i2, false);
            int add = add(t, false);
            if (i2 != add) {
                this.mCallback.onMoved(i2, add);
            }
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {cls, callback, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.mTClass = cls;
        this.mData = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, i2));
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
