package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    private void dispatchScrolled(int i2, float f2, int i3) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3)}) == null) || (onPageChangeCallback = this.mCallback) == null) {
            return;
        }
        onPageChangeCallback.onPageScrolled(i2, f2, i3);
    }

    private void dispatchSelected(int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(65538, this, i2) == null) || (onPageChangeCallback = this.mCallback) == null) {
            return;
        }
        onPageChangeCallback.onPageSelected(i2);
    }

    private void dispatchStateChanged(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65539, this, i2) == null) {
            if ((this.mAdapterState == 3 && this.mScrollState == 0) || this.mScrollState == i2) {
                return;
            }
            this.mScrollState = i2;
            ViewPager2.OnPageChangeCallback onPageChangeCallback = this.mCallback;
            if (onPageChangeCallback != null) {
                onPageChangeCallback.onPageScrollStateChanged(i2);
            }
        }
    }

    private int getPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this)) == null) ? this.mLayoutManager.findFirstVisibleItemPosition() : invokeV.intValue;
    }

    private boolean isInAnyDraggingState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            int i2 = this.mAdapterState;
            return i2 == 1 || i2 == 4;
        }
        return invokeV.booleanValue;
    }

    private void resetState() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
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

    private void startDrag(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65543, this, z) == null) {
            this.mFakeDragging = z;
            this.mAdapterState = z ? 4 : 1;
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

    private void updateScrollEventValues() {
        int top;
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
                top = (findViewByPosition.getLeft() - leftDecorationWidth) - this.mRecyclerView.getPaddingLeft();
                if (this.mViewPager.isRtl()) {
                    top = -top;
                }
                height = width;
            } else {
                top = (findViewByPosition.getTop() - topDecorationHeight) - this.mRecyclerView.getPaddingTop();
            }
            int i2 = -top;
            scrollEventValues.mOffsetPx = i2;
            if (i2 < 0) {
                if (new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations()) {
                    throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
                }
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.mOffsetPx)));
            }
            scrollEventValues.mOffset = height == 0 ? 0.0f : i2 / height;
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
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mScrollState : invokeV.intValue;
    }

    public boolean isDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mScrollState == 1 : invokeV.booleanValue;
    }

    public boolean isFakeDragging() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFakeDragging : invokeV.booleanValue;
    }

    public boolean isIdle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mScrollState == 0 : invokeV.booleanValue;
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

    public void notifyEndFakeDrag() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            if (!isDragging() || this.mFakeDragging) {
                this.mFakeDragging = false;
                updateScrollEventValues();
                ScrollEventValues scrollEventValues = this.mScrollValues;
                if (scrollEventValues.mOffsetPx == 0) {
                    int i2 = scrollEventValues.mPosition;
                    if (i2 != this.mDragStartPosition) {
                        dispatchSelected(i2);
                    }
                    dispatchStateChanged(0);
                    resetState();
                    return;
                }
                dispatchStateChanged(2);
            }
        }
    }

    public void notifyProgrammaticScroll(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            this.mAdapterState = z ? 2 : 3;
            this.mFakeDragging = false;
            boolean z2 = this.mTarget != i2;
            this.mTarget = i2;
            dispatchStateChanged(2);
            if (z2) {
                dispatchSelected(i2);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048585, this, recyclerView, i2) == null) {
            boolean z = true;
            if ((this.mAdapterState != 1 || this.mScrollState != 1) && i2 == 1) {
                startDrag(false);
            } else if (isInAnyDraggingState() && i2 == 2) {
                if (this.mScrollHappened) {
                    dispatchStateChanged(2);
                    this.mDispatchSelected = true;
                }
            } else {
                if (isInAnyDraggingState() && i2 == 0) {
                    updateScrollEventValues();
                    if (!this.mScrollHappened) {
                        int i3 = this.mScrollValues.mPosition;
                        if (i3 != -1) {
                            dispatchScrolled(i3, 0.0f, 0);
                        }
                    } else {
                        ScrollEventValues scrollEventValues = this.mScrollValues;
                        if (scrollEventValues.mOffsetPx == 0) {
                            int i4 = this.mDragStartPosition;
                            int i5 = scrollEventValues.mPosition;
                            if (i4 != i5) {
                                dispatchSelected(i5);
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
                if (this.mAdapterState == 2 && i2 == 0 && this.mDataSetChangeHappened) {
                    updateScrollEventValues();
                    ScrollEventValues scrollEventValues2 = this.mScrollValues;
                    if (scrollEventValues2.mOffsetPx == 0) {
                        int i6 = this.mTarget;
                        int i7 = scrollEventValues2.mPosition;
                        if (i6 != i7) {
                            if (i7 == -1) {
                                i7 = 0;
                            }
                            dispatchSelected(i7);
                        }
                        dispatchStateChanged(0);
                        resetState();
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0021, code lost:
        if ((r6 < 0) == r4.mViewPager.isRtl()) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x003d  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onScrolled(@NonNull RecyclerView recyclerView, int i2, int i3) {
        boolean z;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLII(1048586, this, recyclerView, i2, i3) == null) {
            this.mScrollHappened = true;
            updateScrollEventValues();
            if (this.mDispatchSelected) {
                this.mDispatchSelected = false;
                if (i3 <= 0) {
                    if (i3 == 0) {
                    }
                    z = false;
                    if (z) {
                        ScrollEventValues scrollEventValues = this.mScrollValues;
                        if (scrollEventValues.mOffsetPx != 0) {
                            i4 = scrollEventValues.mPosition + 1;
                            this.mTarget = i4;
                            if (this.mDragStartPosition != i4) {
                                dispatchSelected(i4);
                            }
                        }
                    }
                    i4 = this.mScrollValues.mPosition;
                    this.mTarget = i4;
                    if (this.mDragStartPosition != i4) {
                    }
                }
                z = true;
                if (z) {
                }
                i4 = this.mScrollValues.mPosition;
                this.mTarget = i4;
                if (this.mDragStartPosition != i4) {
                }
            } else if (this.mAdapterState == 0) {
                int i5 = this.mScrollValues.mPosition;
                if (i5 == -1) {
                    i5 = 0;
                }
                dispatchSelected(i5);
            }
            int i6 = this.mScrollValues.mPosition;
            if (i6 == -1) {
                i6 = 0;
            }
            ScrollEventValues scrollEventValues2 = this.mScrollValues;
            dispatchScrolled(i6, scrollEventValues2.mOffset, scrollEventValues2.mOffsetPx);
            int i7 = this.mScrollValues.mPosition;
            int i8 = this.mTarget;
            if ((i7 == i8 || i8 == -1) && this.mScrollValues.mOffsetPx == 0 && this.mScrollState != 1) {
                dispatchStateChanged(0);
                resetState();
            }
        }
    }

    public void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, onPageChangeCallback) == null) {
            this.mCallback = onPageChangeCallback;
        }
    }
}
