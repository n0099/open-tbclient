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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

        public void clear(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                if (i2 >= 64) {
                    Bucket bucket = this.mNext;
                    if (bucket != null) {
                        bucket.clear(i2 - 64);
                        return;
                    }
                    return;
                }
                this.mData &= ~(1 << i2);
            }
        }

        public int countOnesBefore(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                Bucket bucket = this.mNext;
                if (bucket == null) {
                    if (i2 >= 64) {
                        return Long.bitCount(this.mData);
                    }
                    return Long.bitCount(this.mData & ((1 << i2) - 1));
                } else if (i2 < 64) {
                    return Long.bitCount(this.mData & ((1 << i2) - 1));
                } else {
                    return bucket.countOnesBefore(i2 - 64) + Long.bitCount(this.mData);
                }
            }
            return invokeI.intValue;
        }

        public boolean get(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
                if (i2 < 64) {
                    return (this.mData & (1 << i2)) != 0;
                }
                ensureNext();
                return this.mNext.get(i2 - 64);
            }
            return invokeI.booleanValue;
        }

        public void insert(int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
                if (i2 >= 64) {
                    ensureNext();
                    this.mNext.insert(i2 - 64, z);
                    return;
                }
                boolean z2 = (this.mData & Long.MIN_VALUE) != 0;
                long j = (1 << i2) - 1;
                long j2 = this.mData;
                this.mData = ((j2 & (~j)) << 1) | (j2 & j);
                if (z) {
                    set(i2);
                } else {
                    clear(i2);
                }
                if (z2 || this.mNext != null) {
                    ensureNext();
                    this.mNext.insert(0, z2);
                }
            }
        }

        public boolean remove(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                if (i2 >= 64) {
                    ensureNext();
                    return this.mNext.remove(i2 - 64);
                }
                long j = 1 << i2;
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

        public void set(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
                if (i2 >= 64) {
                    ensureNext();
                    this.mNext.set(i2 - 64);
                    return;
                }
                this.mData |= 1 << i2;
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
        void addView(View view, int i2);

        void attachViewToParent(View view, int i2, ViewGroup.LayoutParams layoutParams);

        void detachViewFromParent(int i2);

        View getChildAt(int i2);

        int getChildCount();

        RecyclerView.ViewHolder getChildViewHolder(View view);

        int indexOfChild(View view);

        void onEnteredHiddenState(View view);

        void onLeftHiddenState(View view);

        void removeAllViews();

        void removeViewAt(int i2);
    }

    public ChildHelper(Callback callback) {
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
        this.mCallback = callback;
        this.mBucket = new Bucket();
        this.mHiddenViews = new ArrayList();
    }

    private int getOffset(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65537, this, i2)) == null) {
            if (i2 < 0) {
                return -1;
            }
            int childCount = this.mCallback.getChildCount();
            int i3 = i2;
            while (i3 < childCount) {
                int countOnesBefore = i2 - (i3 - this.mBucket.countOnesBefore(i3));
                if (countOnesBefore == 0) {
                    while (this.mBucket.get(i3)) {
                        i3++;
                    }
                    return i3;
                }
                i3 += countOnesBefore;
            }
            return -1;
        }
        return invokeI.intValue;
    }

    private void hideViewInternal(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, view) == null) {
            this.mHiddenViews.add(view);
            this.mCallback.onEnteredHiddenState(view);
        }
    }

    private boolean unhideViewInternal(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, view)) == null) {
            if (this.mHiddenViews.remove(view)) {
                this.mCallback.onLeftHiddenState(view);
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void addView(View view, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, z) == null) {
            addView(view, -1, z);
        }
    }

    public void attachViewToParent(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        int offset;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{view, Integer.valueOf(i2), layoutParams, Boolean.valueOf(z)}) == null) {
            if (i2 < 0) {
                offset = this.mCallback.getChildCount();
            } else {
                offset = getOffset(i2);
            }
            this.mBucket.insert(offset, z);
            if (z) {
                hideViewInternal(view);
            }
            this.mCallback.attachViewToParent(view, offset, layoutParams);
        }
    }

    public void detachViewFromParent(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            int offset = getOffset(i2);
            this.mBucket.remove(offset);
            this.mCallback.detachViewFromParent(offset);
        }
    }

    public View findHiddenNonRemovedView(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
            int size = this.mHiddenViews.size();
            for (int i3 = 0; i3 < size; i3++) {
                View view = this.mHiddenViews.get(i3);
                RecyclerView.ViewHolder childViewHolder = this.mCallback.getChildViewHolder(view);
                if (childViewHolder.getLayoutPosition() == i2 && !childViewHolder.isInvalid() && !childViewHolder.isRemoved()) {
                    return view;
                }
            }
            return null;
        }
        return (View) invokeI.objValue;
    }

    public View getChildAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i2)) == null) ? this.mCallback.getChildAt(getOffset(i2)) : (View) invokeI.objValue;
    }

    public int getChildCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.mCallback.getChildCount() - this.mHiddenViews.size() : invokeV.intValue;
    }

    public View getUnfilteredChildAt(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) ? this.mCallback.getChildAt(i2) : (View) invokeI.objValue;
    }

    public int getUnfilteredChildCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mCallback.getChildCount() : invokeV.intValue;
    }

    public void hide(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, view) == null) {
            int indexOfChild = this.mCallback.indexOfChild(view);
            if (indexOfChild >= 0) {
                this.mBucket.set(indexOfChild);
                hideViewInternal(view);
                return;
            }
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public int indexOfChild(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, view)) == null) {
            int indexOfChild = this.mCallback.indexOfChild(view);
            if (indexOfChild == -1 || this.mBucket.get(indexOfChild)) {
                return -1;
            }
            return indexOfChild - this.mBucket.countOnesBefore(indexOfChild);
        }
        return invokeL.intValue;
    }

    public boolean isHidden(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, view)) == null) ? this.mHiddenViews.contains(view) : invokeL.booleanValue;
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

    public void removeView(View view) {
        int indexOfChild;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, view) == null) || (indexOfChild = this.mCallback.indexOfChild(view)) < 0) {
            return;
        }
        if (this.mBucket.remove(indexOfChild)) {
            unhideViewInternal(view);
        }
        this.mCallback.removeViewAt(indexOfChild);
    }

    public void removeViewAt(int i2) {
        int offset;
        View childAt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048590, this, i2) == null) || (childAt = this.mCallback.getChildAt((offset = getOffset(i2)))) == null) {
            return;
        }
        if (this.mBucket.remove(offset)) {
            unhideViewInternal(childAt);
        }
        this.mCallback.removeViewAt(offset);
    }

    public boolean removeViewIfHidden(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, view)) == null) {
            int indexOfChild = this.mCallback.indexOfChild(view);
            if (indexOfChild == -1) {
                unhideViewInternal(view);
                return true;
            } else if (this.mBucket.get(indexOfChild)) {
                this.mBucket.remove(indexOfChild);
                unhideViewInternal(view);
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

    public void unhide(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, view) == null) {
            int indexOfChild = this.mCallback.indexOfChild(view);
            if (indexOfChild >= 0) {
                if (this.mBucket.get(indexOfChild)) {
                    this.mBucket.clear(indexOfChild);
                    unhideViewInternal(view);
                    return;
                }
                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
            }
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public void addView(View view, int i2, boolean z) {
        int offset;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (i2 < 0) {
                offset = this.mCallback.getChildCount();
            } else {
                offset = getOffset(i2);
            }
            this.mBucket.insert(offset, z);
            if (z) {
                hideViewInternal(view);
            }
            this.mCallback.addView(view, offset);
        }
    }
}
