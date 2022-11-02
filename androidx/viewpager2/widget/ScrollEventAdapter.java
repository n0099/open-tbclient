package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
/* loaded from: classes.dex */
public final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int NO_POSITION = -1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_IN_PROGRESS_FAKE_DRAG = 4;
    public static final int STATE_IN_PROGRESS_IMMEDIATE_SCROLL = 3;
    public static final int STATE_IN_PROGRESS_MANUAL_DRAG = 1;
    public static final int STATE_IN_PROGRESS_SMOOTH_SCROLL = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAdapterState;
    public ViewPager2.OnPageChangeCallback mCallback;
    public boolean mDataSetChangeHappened;
    public boolean mDispatchSelected;
    public int mDragStartPosition;
    public boolean mFakeDragging;
    @NonNull
    public final LinearLayoutManager mLayoutManager;
    @NonNull
    public final RecyclerView mRecyclerView;
    public boolean mScrollHappened;
    public int mScrollState;
    public ScrollEventValues mScrollValues;
    public int mTarget;
    @NonNull
    public final ViewPager2 mViewPager;

    /* loaded from: classes.dex */
    public static final class ScrollEventValues {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float mOffset;
        public int mOffsetPx;
        public int mPosition;

        public ScrollEventValues() {
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

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.mPosition = -1;
                this.mOffset = 0.0f;
                this.mOffsetPx = 0;
            }
        }
    }

    public ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {viewPager2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mViewPager = viewPager2;
        RecyclerView recyclerView = viewPager2.mRecyclerView;
        this.mRecyclerView = recyclerView;
        this.mLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.mScrollValues = new ScrollEventValues();
        resetState();
    }

    private void dispatchScrolled(int i, float f, int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i), Float.valueOf(f), Integer.valueOf(i2)}) == null) && (onPageChangeCallback = this.mCallback) != null) {
            onPageChangeCallback.onPageScrolled(i, f, i2);
        }
    }

    private void dispatchSelected(int i) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(65538, this, i) == null) && (onPageChangeCallback = this.mCallback) != null) {
            onPageChangeCallback.onPageSelected(i);
        }
    }

    private void dispatchStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i) == null) {
            if ((this.mAdapterState == 3 && this.mScrollState == 0) || this.mScrollState == i) {
                return;
            }
            this.mScrollState = i;
            ViewPager2.OnPageChangeCallback onPageChangeCallback = this.mCallback;
            if (onPageChangeCallback != null) {
                onPageChangeCallback.onPageScrollStateChanged(i);
            }
        }
    }

    private void startDrag(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, this, z) == null) {
            this.mFakeDragging = z;
            if (z) {
                i = 4;
            } else {
                i = 1;
            }
            this.mAdapterState = i;
            int i2 = this.mTarget;
            if (i2 != -1) {
                this.mDragStartPosition = i2;
                this.mTarget = -1;
            } else if (this.mDragStartPosition == -1) {
                this.mDragStartPosition = getPosition();
            }
            dispatchStateChanged(1);
        }
    }

    public void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onPageChangeCallback) == null) {
            this.mCallback = onPageChangeCallback;
        }
    }

    private int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) {
            return this.mLayoutManager.findFirstVisibleItemPosition();
        }
        return invokeV.intValue;
    }

    private boolean isInAnyDraggingState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            int i = this.mAdapterState;
            if (i == 1 || i == 4) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    private void resetState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            this.mAdapterState = 0;
            this.mScrollState = 0;
            this.mScrollValues.reset();
            this.mDragStartPosition = -1;
            this.mTarget = -1;
            this.mDispatchSelected = false;
            this.mScrollHappened = false;
            this.mFakeDragging = false;
            this.mDataSetChangeHappened = false;
        }
    }

    public double getRelativeScrollPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            updateScrollEventValues();
            ScrollEventValues scrollEventValues = this.mScrollValues;
            return scrollEventValues.mPosition + scrollEventValues.mOffset;
        }
        return invokeV.doubleValue;
    }

    public int getScrollState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.mScrollState;
        }
        return invokeV.intValue;
    }

    public boolean isDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.mScrollState == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean isFakeDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.mFakeDragging;
        }
        return invokeV.booleanValue;
    }

    public boolean isIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mScrollState == 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void notifyBeginFakeDrag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.mAdapterState = 4;
            startDrag(true);
        }
    }

    public void notifyDataSetChangeHappened() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.mDataSetChangeHappened = true;
        }
    }

    private void updateScrollEventValues() {
        boolean z;
        int top;
        float f;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            ScrollEventValues scrollEventValues = this.mScrollValues;
            int findFirstVisibleItemPosition = this.mLayoutManager.findFirstVisibleItemPosition();
            scrollEventValues.mPosition = findFirstVisibleItemPosition;
            if (findFirstVisibleItemPosition == -1) {
                scrollEventValues.reset();
                return;
            }
            View findViewByPosition = this.mLayoutManager.findViewByPosition(findFirstVisibleItemPosition);
            if (findViewByPosition == null) {
                scrollEventValues.reset();
                return;
            }
            int leftDecorationWidth = this.mLayoutManager.getLeftDecorationWidth(findViewByPosition);
            int rightDecorationWidth = this.mLayoutManager.getRightDecorationWidth(findViewByPosition);
            int topDecorationHeight = this.mLayoutManager.getTopDecorationHeight(findViewByPosition);
            int bottomDecorationHeight = this.mLayoutManager.getBottomDecorationHeight(findViewByPosition);
            ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                leftDecorationWidth += marginLayoutParams.leftMargin;
                rightDecorationWidth += marginLayoutParams.rightMargin;
                topDecorationHeight += marginLayoutParams.topMargin;
                bottomDecorationHeight += marginLayoutParams.bottomMargin;
            }
            int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
            int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
            if (this.mLayoutManager.getOrientation() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                top = (findViewByPosition.getLeft() - leftDecorationWidth) - this.mRecyclerView.getPaddingLeft();
                if (this.mViewPager.isRtl()) {
                    top = -top;
                }
                height = width;
            } else {
                top = (findViewByPosition.getTop() - topDecorationHeight) - this.mRecyclerView.getPaddingTop();
            }
            int i = -top;
            scrollEventValues.mOffsetPx = i;
            if (i < 0) {
                if (new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations()) {
                    throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
                }
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.mOffsetPx)));
            }
            if (height == 0) {
                f = 0.0f;
            } else {
                f = i / height;
            }
            scrollEventValues.mOffset = f;
        }
    }

    public void notifyEndFakeDrag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (isDragging() && !this.mFakeDragging) {
                return;
            }
            this.mFakeDragging = false;
            updateScrollEventValues();
            ScrollEventValues scrollEventValues = this.mScrollValues;
            if (scrollEventValues.mOffsetPx == 0) {
                int i = scrollEventValues.mPosition;
                if (i != this.mDragStartPosition) {
                    dispatchSelected(i);
                }
                dispatchStateChanged(0);
                resetState();
                return;
            }
            dispatchStateChanged(2);
        }
    }

    public void notifyProgrammaticScroll(int i, boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            if (z) {
                i2 = 2;
            } else {
                i2 = 3;
            }
            this.mAdapterState = i2;
            boolean z2 = false;
            this.mFakeDragging = false;
            if (this.mTarget != i) {
                z2 = true;
            }
            this.mTarget = i;
            dispatchStateChanged(2);
            if (z2) {
                dispatchSelected(i);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, recyclerView, i) == null) {
            boolean z = true;
            if ((this.mAdapterState != 1 || this.mScrollState != 1) && i == 1) {
                startDrag(false);
            } else if (isInAnyDraggingState() && i == 2) {
                if (this.mScrollHappened) {
                    dispatchStateChanged(2);
                    this.mDispatchSelected = true;
                }
            } else {
                if (isInAnyDraggingState() && i == 0) {
                    updateScrollEventValues();
                    if (!this.mScrollHappened) {
                        int i2 = this.mScrollValues.mPosition;
                        if (i2 != -1) {
                            dispatchScrolled(i2, 0.0f, 0);
                        }
                    } else {
                        ScrollEventValues scrollEventValues = this.mScrollValues;
                        if (scrollEventValues.mOffsetPx == 0) {
                            int i3 = this.mDragStartPosition;
                            int i4 = scrollEventValues.mPosition;
                            if (i3 != i4) {
                                dispatchSelected(i4);
                            }
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        dispatchStateChanged(0);
                        resetState();
                    }
                }
                if (this.mAdapterState == 2 && i == 0 && this.mDataSetChangeHappened) {
                    updateScrollEventValues();
                    ScrollEventValues scrollEventValues2 = this.mScrollValues;
                    if (scrollEventValues2.mOffsetPx == 0) {
                        int i5 = this.mTarget;
                        int i6 = scrollEventValues2.mPosition;
                        if (i5 != i6) {
                            if (i6 == -1) {
                                i6 = 0;
                            }
                            dispatchSelected(i6);
                        }
                        dispatchStateChanged(0);
                        resetState();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        if (r6 == r4.mViewPager.isRtl()) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        boolean z;
        int i3;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, recyclerView, i, i2) == null) {
            this.mScrollHappened = true;
            updateScrollEventValues();
            if (this.mDispatchSelected) {
                this.mDispatchSelected = false;
                if (i2 <= 0) {
                    if (i2 == 0) {
                        if (i < 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    }
                    z = false;
                    if (z) {
                        ScrollEventValues scrollEventValues = this.mScrollValues;
                        if (scrollEventValues.mOffsetPx != 0) {
                            i3 = scrollEventValues.mPosition + 1;
                            this.mTarget = i3;
                            if (this.mDragStartPosition != i3) {
                                dispatchSelected(i3);
                            }
                        }
                    }
                    i3 = this.mScrollValues.mPosition;
                    this.mTarget = i3;
                    if (this.mDragStartPosition != i3) {
                    }
                }
                z = true;
                if (z) {
                }
                i3 = this.mScrollValues.mPosition;
                this.mTarget = i3;
                if (this.mDragStartPosition != i3) {
                }
            } else if (this.mAdapterState == 0) {
                int i4 = this.mScrollValues.mPosition;
                if (i4 == -1) {
                    i4 = 0;
                }
                dispatchSelected(i4);
            }
            int i5 = this.mScrollValues.mPosition;
            if (i5 == -1) {
                i5 = 0;
            }
            ScrollEventValues scrollEventValues2 = this.mScrollValues;
            dispatchScrolled(i5, scrollEventValues2.mOffset, scrollEventValues2.mOffsetPx);
            int i6 = this.mScrollValues.mPosition;
            int i7 = this.mTarget;
            if ((i6 == i7 || i7 == -1) && this.mScrollValues.mOffsetPx == 0 && this.mScrollState != 1) {
                dispatchStateChanged(0);
                resetState();
            }
        }
    }
}
