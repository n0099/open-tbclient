package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ChildHelper {
    public static /* synthetic */ Interceptable $ic = null;
    public static final boolean DEBUG = false;
    public static final String TAG = "ChildrenHelper";
    public transient /* synthetic */ FieldHolder $fh;
    public final Bucket mBucket;
    public final Callback mCallback;
    public final List<View> mHiddenViews;

    /* loaded from: classes.dex */
    public static class Bucket {
        public static /* synthetic */ Interceptable $ic = null;
        public static final int BITS_PER_WORD = 64;
        public static final long LAST_BIT = Long.MIN_VALUE;
        public transient /* synthetic */ FieldHolder $fh;
        public long mData;
        public Bucket mNext;

        public Bucket() {
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
            this.mData = 0L;
        }

        private void ensureNext() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(65537, this) == null) && this.mNext == null) {
                this.mNext = new Bucket();
            }
        }

        public void clear(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                if (i >= 64) {
                    Bucket bucket = this.mNext;
                    if (bucket != null) {
                        bucket.clear(i - 64);
                        return;
                    }
                    return;
                }
                this.mData &= ~(1 << i);
            }
        }

        public int countOnesBefore(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                Bucket bucket = this.mNext;
                if (bucket == null) {
                    if (i >= 64) {
                        return Long.bitCount(this.mData);
                    }
                    return Long.bitCount(this.mData & ((1 << i) - 1));
                } else if (i < 64) {
                    return Long.bitCount(this.mData & ((1 << i) - 1));
                } else {
                    return bucket.countOnesBefore(i - 64) + Long.bitCount(this.mData);
                }
            }
            return invokeI.intValue;
        }

        public boolean get(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                if (i < 64) {
                    return (this.mData & (1 << i)) != 0;
                }
                ensureNext();
                return this.mNext.get(i - 64);
            }
            return invokeI.booleanValue;
        }

        public void insert(int i, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
                if (i >= 64) {
                    ensureNext();
                    this.mNext.insert(i - 64, z);
                    return;
                }
                boolean z2 = (this.mData & Long.MIN_VALUE) != 0;
                long j = (1 << i) - 1;
                long j2 = this.mData;
                this.mData = ((j2 & (~j)) << 1) | (j2 & j);
                if (z) {
                    set(i);
                } else {
                    clear(i);
                }
                if (z2 || this.mNext != null) {
                    ensureNext();
                    this.mNext.insert(0, z2);
                }
            }
        }

        public boolean remove(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                if (i >= 64) {
                    ensureNext();
                    return this.mNext.remove(i - 64);
                }
                long j = 1 << i;
                boolean z = (this.mData & j) != 0;
                long j2 = this.mData & (~j);
                this.mData = j2;
                long j3 = j - 1;
                this.mData = (j2 & j3) | Long.rotateRight((~j3) & j2, 1);
                Bucket bucket = this.mNext;
                if (bucket != null) {
                    if (bucket.get(0)) {
                        set(63);
                    }
                    this.mNext.remove(0);
                }
                return z;
            }
            return invokeI.booleanValue;
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.mData = 0L;
                Bucket bucket = this.mNext;
                if (bucket != null) {
                    bucket.reset();
                }
            }
        }

        public void set(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
                if (i >= 64) {
                    ensureNext();
                    this.mNext.set(i - 64);
                    return;
                }
                this.mData |= 1 << i;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
                if (this.mNext == null) {
                    return Long.toBinaryString(this.mData);
                }
                return this.mNext.toString() + "xx" + Long.toBinaryString(this.mData);
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public interface Callback {
        void addView(View view2, int i);

        void attachViewToParent(View view2, int i, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i);

        View getChildAt(int i);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view2);

        int indexOfChild(View view2);

        void onEnteredHiddenState(View view2);

        void onLeftHiddenState(View view2);

        void removeAllViews();

        void removeViewAt(int i);
    }

    public ChildHelper(Callback callback) {
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
        this.mCallback = callback;
        this.mBucket = new Bucket();
        this.mHiddenViews = new ArrayList();
    }

    private int getOffset(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i)) == null) {
            if (i < 0) {
                return -1;
            }
            int childCount = this.mCallback.getChildCount();
            int i2 = i;
            while (i2 < childCount) {
                int countOnesBefore = i - (i2 - this.mBucket.countOnesBefore(i2));
                if (countOnesBefore == 0) {
                    while (this.mBucket.get(i2)) {
                        i2++;
                    }
                    return i2;
                }
                i2 += countOnesBefore;
            }
            return -1;
        }
        return invokeI.intValue;
    }

    private void hideViewInternal(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, view2) == null) {
            this.mHiddenViews.add(view2);
            this.mCallback.onEnteredHiddenState(view2);
        }
    }

    private boolean unhideViewInternal(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, view2)) == null) {
            if (this.mHiddenViews.remove(view2)) {
                this.mCallback.onLeftHiddenState(view2);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void addView(View view2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, z) == null) {
            addView(view2, -1, z);
        }
    }

    public void attachViewToParent(View view2, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int offset;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view2, Integer.valueOf(i), layoutParams, Boolean.valueOf(z)}) == null) {
            if (i < 0) {
                offset = this.mCallback.getChildCount();
            } else {
                offset = getOffset(i);
            }
            this.mBucket.insert(offset, z);
            if (z) {
                hideViewInternal(view2);
            }
            this.mCallback.attachViewToParent(view2, offset, layoutParams);
        }
    }

    public void detachViewFromParent(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            int offset = getOffset(i);
            this.mBucket.remove(offset);
            this.mCallback.detachViewFromParent(offset);
        }
    }

    public View findHiddenNonRemovedView(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            int size = this.mHiddenViews.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view2 = this.mHiddenViews.get(i2);
                RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view2);
                if (childViewHolder.getLayoutPosition() == i && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                    return view2;
                }
            }
            return null;
        }
        return (View) invokeI.objValue;
    }

    public View getChildAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) ? this.mCallback.getChildAt(getOffset(i)) : (View) invokeI.objValue;
    }

    public int getChildCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mCallback.getChildCount() - this.mHiddenViews.size() : invokeV.intValue;
    }

    public View getUnfilteredChildAt(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? this.mCallback.getChildAt(i) : (View) invokeI.objValue;
    }

    public int getUnfilteredChildCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mCallback.getChildCount() : invokeV.intValue;
    }

    public void hide(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view2) == null) {
            int indexOfChild = this.mCallback.indexOfChild(view2);
            if (indexOfChild >= 0) {
                this.mBucket.set(indexOfChild);
                hideViewInternal(view2);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot hide " + view2);
        }
    }

    public int indexOfChild(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view2)) == null) {
            int indexOfChild = this.mCallback.indexOfChild(view2);
            if (indexOfChild == -1 || this.mBucket.get(indexOfChild)) {
                return -1;
            }
            return indexOfChild - this.mBucket.countOnesBefore(indexOfChild);
        }
        return invokeL.intValue;
    }

    public boolean isHidden(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, view2)) == null) ? this.mHiddenViews.contains(view2) : invokeL.booleanValue;
    }

    public void removeAllViewsUnfiltered() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.mBucket.reset();
            for (int size = this.mHiddenViews.size() - 1; size >= 0; size--) {
                this.mCallback.onLeftHiddenState(this.mHiddenViews.get(size));
                this.mHiddenViews.remove(size);
            }
            this.mCallback.removeAllViews();
        }
    }

    public void removeView(View view2) {
        int indexOfChild;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view2) == null) || (indexOfChild = this.mCallback.indexOfChild(view2)) < 0) {
            return;
        }
        if (this.mBucket.remove(indexOfChild)) {
            unhideViewInternal(view2);
        }
        this.mCallback.removeViewAt(indexOfChild);
    }

    public void removeViewAt(int i) {
        int offset;
        View childAt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i) == null) || (childAt = this.mCallback.getChildAt((offset = getOffset(i)))) == null) {
            return;
        }
        if (this.mBucket.remove(offset)) {
            unhideViewInternal(childAt);
        }
        this.mCallback.removeViewAt(offset);
    }

    public boolean removeViewIfHidden(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, view2)) == null) {
            int indexOfChild = this.mCallback.indexOfChild(view2);
            if (indexOfChild == -1) {
                unhideViewInternal(view2);
                return true;
            } else if (this.mBucket.get(indexOfChild)) {
                this.mBucket.remove(indexOfChild);
                unhideViewInternal(view2);
                this.mCallback.removeViewAt(indexOfChild);
                return true;
            } else {
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.mBucket.toString() + ", hidden list:" + this.mHiddenViews.size();
        }
        return (String) invokeV.objValue;
    }

    public void unhide(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view2) == null) {
            int indexOfChild = this.mCallback.indexOfChild(view2);
            if (indexOfChild >= 0) {
                if (this.mBucket.get(indexOfChild)) {
                    this.mBucket.clear(indexOfChild);
                    unhideViewInternal(view2);
                    return;
                }
                throw new RuntimeException("trying to unhide a view that was not hidden" + view2);
            }
            throw new IllegalArgumentException("view is not a child, cannot hide " + view2);
        }
    }

    public void addView(View view2, int i, boolean z) {
        int offset;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view2, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (i < 0) {
                offset = this.mCallback.getChildCount();
            } else {
                offset = getOffset(i);
            }
            this.mBucket.insert(offset, z);
            if (z) {
                hideViewInternal(view2);
            }
            this.mCallback.addView(view2, offset);
        }
    }
}
