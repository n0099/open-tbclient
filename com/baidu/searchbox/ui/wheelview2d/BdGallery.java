package com.baidu.searchbox.ui.wheelview2d;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import android.widget.Scroller;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.ui.wheelview2d.BdAdapterView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class BdGallery extends BdAbsSpinner implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int HORIZONTAL = 1;
    public static final int SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT = 250;
    public static final String TAG = "BdGallery";
    public static final int VERTICAL = 2;
    public static final boolean localLOGV = false;
    public transient /* synthetic */ FieldHolder $fh;
    public int mAnimationDuration;
    public BdAdapterView.AdapterContextMenuInfo mContextMenuInfo;
    public boolean mDisableScrollAnyway;
    public Runnable mDisableSuppressSelectionChangedRunnable;
    public int mDownTouchPosition;
    public View mDownTouchView;
    public int mFirstChildOffset;
    public FlingRunnable mFlingRunnable;
    public GestureDetector mGestureDetector;
    public int mGravity;
    public boolean mIsDisableScroll;
    public boolean mIsFirstScroll;
    public boolean mIsScrollCycle;
    public boolean mIsScrollCycleTemp;
    public boolean mIsSlotCenter;
    public int mLeftMost;
    public long mMaxMoveOffset;
    public OnEndFlingListener mOnEndFlingListener;
    public int mOrientation;
    public boolean mReceivedInvokeKeyDown;
    public int mRightMost;
    public int mScrollBarBottomMargin;
    public int mScrollBarSize;
    public boolean mScrolling;
    public View mSelectedChild;
    public boolean mShouldCallbackDuringFling;
    public boolean mShouldCallbackOnUnselectedItemClick;
    public boolean mShouldStopFling;
    public int mSpacing;
    public boolean mSuppressSelectionChanged;
    public float mUnselectedAlpha;
    public float mVelocityRatio;

    /* loaded from: classes7.dex */
    public class FlingRunnable implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int mLastFlingX;
        public int mLastFlingY;
        public Scroller mScroller;
        public final /* synthetic */ BdGallery this$0;

        public FlingRunnable(BdGallery bdGallery) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bdGallery};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = bdGallery;
            this.mScroller = new Scroller(bdGallery.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endFling(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(65539, this, z) == null) {
                this.this$0.mScrolling = false;
                this.mScroller.forceFinished(true);
                if (z) {
                    this.this$0.scrollIntoSlots();
                }
            }
        }

        private void startCommon() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
                this.this$0.removeCallbacks(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.this$0.isOrientationVertical()) {
                    runVertical();
                    return;
                }
                BdGallery bdGallery = this.this$0;
                if (bdGallery.mItemCount != 0) {
                    bdGallery.mShouldStopFling = false;
                    Scroller scroller = this.mScroller;
                    boolean computeScrollOffset = scroller.computeScrollOffset();
                    int currX = scroller.getCurrX();
                    int i2 = this.mLastFlingX - currX;
                    if (i2 > 0) {
                        BdGallery bdGallery2 = this.this$0;
                        bdGallery2.mDownTouchPosition = bdGallery2.mFirstPosition;
                        max = Math.min(((this.this$0.getWidth() - this.this$0.getPaddingLeft()) - this.this$0.getPaddingRight()) - 1, i2);
                    } else {
                        BdGallery bdGallery3 = this.this$0;
                        bdGallery3.mDownTouchPosition = bdGallery3.mFirstPosition + (this.this$0.getChildCount() - 1);
                        max = Math.max(-(((this.this$0.getWidth() - this.this$0.getPaddingRight()) - this.this$0.getPaddingLeft()) - 1), i2);
                    }
                    boolean z = max <= 0;
                    if (max != 0 && !this.this$0.canBeScrolled(z)) {
                        this.this$0.mShouldStopFling = true;
                    } else {
                        this.this$0.trackMotionScroll(max);
                    }
                    if (computeScrollOffset && !this.this$0.mShouldStopFling) {
                        this.mLastFlingX = currX;
                        this.this$0.post(this);
                        return;
                    }
                    endFling(true);
                    return;
                }
                endFling(true);
            }
        }

        public void runVertical() {
            int max;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                BdGallery bdGallery = this.this$0;
                if (bdGallery.mItemCount != 0) {
                    bdGallery.mShouldStopFling = false;
                    Scroller scroller = this.mScroller;
                    boolean computeScrollOffset = scroller.computeScrollOffset();
                    int currY = scroller.getCurrY();
                    int i2 = this.mLastFlingY - currY;
                    if (i2 > 0) {
                        BdGallery bdGallery2 = this.this$0;
                        bdGallery2.mDownTouchPosition = bdGallery2.mFirstPosition;
                        max = Math.min(((this.this$0.getHeight() - this.this$0.getPaddingTop()) - this.this$0.getPaddingBottom()) - 1, i2);
                    } else {
                        BdGallery bdGallery3 = this.this$0;
                        bdGallery3.mDownTouchPosition = bdGallery3.mFirstPosition + (this.this$0.getChildCount() - 1);
                        max = Math.max(-(((this.this$0.getHeight() - this.this$0.getPaddingBottom()) - this.this$0.getPaddingTop()) - 1), i2);
                    }
                    this.this$0.trackMotionScrollVertical(max);
                    if (computeScrollOffset && !this.this$0.mShouldStopFling) {
                        this.mLastFlingY = currY;
                        this.this$0.post(this);
                        return;
                    }
                    endFling(true);
                    return;
                }
                endFling(true);
            }
        }

        public void startUsingDistance(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) || i2 == 0) {
                return;
            }
            if (this.this$0.isOrientationVertical()) {
                startCommon();
                this.this$0.mScrolling = true;
                this.mLastFlingY = 0;
                this.mScroller.startScroll(0, 0, 0, -i2, this.this$0.mAnimationDuration);
                this.this$0.post(this);
                return;
            }
            startCommon();
            this.this$0.mScrolling = true;
            this.mLastFlingX = 0;
            this.mScroller.startScroll(0, 0, -i2, 0, this.this$0.mAnimationDuration);
            this.this$0.post(this);
        }

        public void startUsingVelocity(int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || i2 == 0) {
                return;
            }
            startCommon();
            if (this.this$0.isOrientationVertical()) {
                int i3 = i2 < 0 ? Integer.MAX_VALUE : 0;
                this.mLastFlingY = i3;
                this.mScroller.fling(0, i3, 0, i2, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                this.this$0.post(this);
                return;
            }
            int i4 = i2 >= 0 ? 0 : Integer.MAX_VALUE;
            this.mLastFlingX = i4;
            this.mScroller.fling(i4, 0, i2, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            this.this$0.post(this);
        }

        public void stop(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
                this.this$0.removeCallbacks(this);
                endFling(z);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, attributeSet};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {layoutParams};
                interceptable.invokeUnInit(65538, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((ViewGroup.LayoutParams) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface OnEndFlingListener {
        void onEndFling(BdGallery bdGallery);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdGallery(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private int calculateLeft(View view, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65546, this, view, z)) == null) {
            int measuredWidth = z ? getMeasuredWidth() : getWidth();
            int measuredWidth2 = z ? view.getMeasuredWidth() : view.getWidth();
            int i2 = this.mGravity;
            if (i2 == 1) {
                Rect rect = this.mSpinnerPadding;
                int i3 = rect.left;
                return i3 + ((((measuredWidth - rect.right) - i3) - measuredWidth2) / 2);
            } else if (i2 != 3) {
                if (i2 != 5) {
                    return 0;
                }
                return (measuredWidth - this.mSpinnerPadding.right) - measuredWidth2;
            } else {
                return this.mSpinnerPadding.left;
            }
        }
        return invokeLZ.intValue;
    }

    private int calculateTop(View view, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65547, this, view, z)) == null) {
            int measuredHeight = z ? getMeasuredHeight() : getHeight();
            int measuredHeight2 = z ? view.getMeasuredHeight() : view.getHeight();
            int i2 = this.mGravity;
            if (i2 == 16) {
                Rect rect = this.mSpinnerPadding;
                int i3 = rect.top;
                return i3 + ((((measuredHeight - rect.bottom) - i3) - measuredHeight2) / 2);
            } else if (i2 != 48) {
                if (i2 != 80) {
                    return 0;
                }
                return (measuredHeight - this.mSpinnerPadding.bottom) - measuredHeight2;
            } else {
                return this.mSpinnerPadding.top;
            }
        }
        return invokeLZ.intValue;
    }

    private void detachOffScreenChildren(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65548, this, z) == null) {
            int childCount = getChildCount();
            int i3 = this.mFirstPosition;
            int i4 = 0;
            if (z) {
                int paddingLeft = getPaddingLeft();
                i2 = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    if (childAt.getRight() >= paddingLeft) {
                        break;
                    }
                    i2++;
                    this.mRecycler.put(i3 + i5, childAt);
                }
                if (i2 == childCount) {
                    i2--;
                }
            } else {
                int width = getWidth() - getPaddingRight();
                int i6 = 0;
                int i7 = 0;
                for (int i8 = childCount - 1; i8 >= 0; i8--) {
                    View childAt2 = getChildAt(i8);
                    if (childAt2.getLeft() <= width) {
                        break;
                    }
                    i6++;
                    this.mRecycler.put(i3 + i8, childAt2);
                    i7 = i8;
                }
                if (i7 == 0) {
                    i4 = i7 + 1;
                    i2 = i6;
                } else {
                    i2 = i6;
                    i4 = i7;
                }
            }
            detachViewsFromParent(i4, i2);
            if (z) {
                this.mFirstPosition += i2;
                if (isScrollCycle()) {
                    this.mFirstPosition %= this.mItemCount;
                }
            }
        }
    }

    private void detachOffScreenChildrenVertical(boolean z) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65549, this, z) == null) {
            int childCount = getChildCount();
            int i3 = this.mFirstPosition;
            int i4 = 0;
            if (z) {
                int paddingTop = getPaddingTop();
                i2 = 0;
                for (int i5 = 0; i5 < childCount; i5++) {
                    View childAt = getChildAt(i5);
                    if (childAt.getBottom() >= paddingTop) {
                        break;
                    }
                    i2++;
                    this.mRecycler.put(i3 + i5, childAt);
                }
                if (i2 == childCount) {
                    i2--;
                }
            } else {
                int height = getHeight() - getPaddingBottom();
                int i6 = 0;
                int i7 = 0;
                for (int i8 = childCount - 1; i8 >= 0; i8--) {
                    View childAt2 = getChildAt(i8);
                    if (childAt2.getTop() <= height) {
                        break;
                    }
                    i6++;
                    this.mRecycler.put(i3 + i8, childAt2);
                    i7 = i8;
                }
                if (i7 == 0) {
                    i4 = i7 + 1;
                    i2 = i6;
                } else {
                    i2 = i6;
                    i4 = i7;
                }
            }
            detachViewsFromParent(i4, i2);
            if (z) {
                this.mFirstPosition += i2;
                if (isScrollCycle()) {
                    this.mFirstPosition %= this.mItemCount;
                }
            }
        }
    }

    private boolean dispatchLongPress(View view, int i2, long j) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65550, this, new Object[]{view, Integer.valueOf(i2), Long.valueOf(j)})) == null) {
            BdAdapterView.OnItemLongClickListener onItemLongClickListener = this.mOnItemLongClickListener;
            boolean onItemLongClick = onItemLongClickListener != null ? onItemLongClickListener.onItemLongClick(this, this.mDownTouchView, this.mDownTouchPosition, j) : false;
            if (!onItemLongClick) {
                this.mContextMenuInfo = new BdAdapterView.AdapterContextMenuInfo(view, i2, j);
                onItemLongClick = super.showContextMenuForChild(this);
            }
            if (onItemLongClick) {
                performHapticFeedback(0);
            }
            return onItemLongClick;
        }
        return invokeCommon.booleanValue;
    }

    private void dispatchPress(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65551, this, view) == null) {
            if (view != null) {
                view.setPressed(true);
            }
            setPressed(true);
        }
    }

    private void fillGallery() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65552, this) == null) {
            int i2 = this.mSpinnerPadding.top + this.mFirstChildOffset;
            recycleAllViews();
            detachAllViewsFromParent();
            this.mRightMost = 0;
            this.mLeftMost = 0;
            int i3 = this.mSelectedPosition;
            this.mFirstPosition = i3;
            View makeAndAddViewVertical = makeAndAddViewVertical(i3, 0, 0, true);
            int i4 = this.mSpacing + i2;
            if (isSlotInCenter()) {
                int bottom = getBottom() - getTop();
                Rect rect = this.mSpinnerPadding;
                i4 = (i2 + (((bottom - rect.top) - rect.bottom) / 2)) - (makeAndAddViewVertical.getHeight() / 2);
            }
            makeAndAddViewVertical.offsetTopAndBottom(i4);
            fillToGalleryBottom();
            fillToGalleryTop();
        }
    }

    private void fillToGalleryBottom() {
        int i2;
        int paddingTop;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65553, this) == null) {
            if (isScrollCycle()) {
                fillToGalleryBottomCycle();
                return;
            }
            int i3 = this.mSpacing;
            int bottom = (getBottom() - getTop()) - getPaddingRight();
            int childCount = getChildCount();
            int i4 = this.mItemCount;
            View childAt = getChildAt(childCount - 1);
            if (childAt != null) {
                i2 = this.mFirstPosition + childCount;
                paddingTop = childAt.getBottom() + i3;
            } else {
                i2 = this.mItemCount - 1;
                this.mFirstPosition = i2;
                paddingTop = getPaddingTop();
                this.mShouldStopFling = true;
            }
            while (paddingTop < bottom && i2 < i4) {
                paddingTop = makeAndAddViewVertical(i2, i2 - this.mSelectedPosition, paddingTop, true).getBottom() + i3;
                i2++;
            }
        }
    }

    private void fillToGalleryBottomCycle() {
        int i2;
        int paddingTop;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65554, this) == null) {
            int i3 = this.mSpacing;
            int bottom = (getBottom() - getTop()) - getPaddingBottom();
            int childCount = getChildCount();
            int i4 = this.mItemCount;
            View childAt = getChildAt(childCount - 1);
            Log("  fillToGalleryRightCycle mFirstPosition = " + this.mFirstPosition);
            if (childAt != null) {
                i2 = this.mFirstPosition + childCount;
                paddingTop = childAt.getBottom() + i3;
            } else {
                i2 = this.mItemCount - 1;
                this.mFirstPosition = i2;
                paddingTop = getPaddingTop();
                this.mShouldStopFling = true;
            }
            while (paddingTop < bottom && i2 < i4) {
                paddingTop = makeAndAddViewVertical(i2, i2 - this.mSelectedPosition, paddingTop, true).getBottom() + i3;
                i2++;
            }
            int i5 = i2 % i4;
            while (paddingTop <= bottom && getChildCount() < this.mItemCount) {
                paddingTop = makeAndAddViewVertical(i5, i5 - this.mSelectedPosition, paddingTop, true).getBottom() + i3;
                i5++;
            }
        }
    }

    private void fillToGalleryLeft() {
        int right;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65555, this) == null) {
            if (isScrollCycle()) {
                fillToGalleryLeftCycle();
                return;
            }
            int i3 = this.mSpacing;
            int paddingLeft = getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt != null) {
                i2 = this.mFirstPosition - 1;
                right = childAt.getLeft() - i3;
            } else {
                right = (getRight() - getLeft()) - getPaddingRight();
                this.mShouldStopFling = true;
                i2 = 0;
            }
            while (right > paddingLeft && i2 >= 0) {
                View makeAndAddView = makeAndAddView(i2, i2 - this.mSelectedPosition, right, false);
                this.mFirstPosition = i2;
                right = makeAndAddView.getLeft() - i3;
                i2--;
            }
        }
    }

    private void fillToGalleryLeftCycle() {
        int right;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65556, this) == null) {
            int i3 = this.mSpacing;
            int paddingLeft = getPaddingLeft();
            View childAt = getChildAt(0);
            if (childAt != null) {
                i2 = this.mFirstPosition - 1;
                right = childAt.getLeft() - i3;
            } else {
                right = (getRight() - getLeft()) - getPaddingRight();
                this.mShouldStopFling = true;
                i2 = 0;
            }
            while (right > paddingLeft && i2 >= 0) {
                View makeAndAddView = makeAndAddView(i2, i2 - this.mSelectedPosition, right, false);
                this.mFirstPosition = i2;
                right = makeAndAddView.getLeft() - i3;
                i2--;
            }
            int i4 = this.mItemCount - 1;
            while (right > paddingLeft && getChildCount() < this.mItemCount) {
                View makeAndAddView2 = makeAndAddView(i4, i4 - this.mSelectedPosition, right, false);
                this.mFirstPosition = i4;
                right = makeAndAddView2.getLeft() - i3;
                i4--;
            }
        }
    }

    private void fillToGalleryRight() {
        int i2;
        int paddingLeft;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            if (isScrollCycle()) {
                fillToGalleryRightCycle();
                return;
            }
            int i3 = this.mSpacing;
            int right = (getRight() - getLeft()) - getPaddingRight();
            int childCount = getChildCount();
            int i4 = this.mItemCount;
            View childAt = getChildAt(childCount - 1);
            if (childAt != null) {
                i2 = this.mFirstPosition + childCount;
                paddingLeft = childAt.getRight() + i3;
            } else {
                i2 = this.mItemCount - 1;
                this.mFirstPosition = i2;
                paddingLeft = getPaddingLeft();
                this.mShouldStopFling = true;
            }
            while (paddingLeft < right && i2 < i4) {
                paddingLeft = makeAndAddView(i2, i2 - this.mSelectedPosition, paddingLeft, true).getRight() + i3;
                i2++;
            }
        }
    }

    private void fillToGalleryRightCycle() {
        int i2;
        int paddingLeft;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            int i3 = this.mSpacing;
            int right = (getRight() - getLeft()) - getPaddingRight();
            int childCount = getChildCount();
            int i4 = this.mItemCount;
            View childAt = getChildAt(childCount - 1);
            Log("  fillToGalleryRightCycle mFirstPosition = " + this.mFirstPosition);
            if (childAt != null) {
                i2 = this.mFirstPosition + childCount;
                paddingLeft = childAt.getRight() + i3;
            } else {
                i2 = this.mItemCount - 1;
                this.mFirstPosition = i2;
                paddingLeft = getPaddingLeft();
                this.mShouldStopFling = true;
            }
            while (paddingLeft < right && i2 < i4) {
                paddingLeft = makeAndAddView(i2, i2 - this.mSelectedPosition, paddingLeft, true).getRight() + i3;
                i2++;
            }
            int i5 = i2 % i4;
            while (paddingLeft <= right && getChildCount() < this.mItemCount) {
                paddingLeft = makeAndAddView(i5, i5 - this.mSelectedPosition, paddingLeft, true).getRight() + i3;
                i5++;
            }
        }
    }

    private void fillToGalleryTop() {
        int bottom;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65559, this) == null) {
            if (isScrollCycle()) {
                fillToGalleryTopCycle();
                return;
            }
            int i3 = this.mSpacing;
            int paddingTop = getPaddingTop();
            View childAt = getChildAt(0);
            if (childAt != null) {
                i2 = this.mFirstPosition - 1;
                bottom = childAt.getTop() - i3;
            } else {
                bottom = (getBottom() - getTop()) - getPaddingBottom();
                this.mShouldStopFling = true;
                i2 = 0;
            }
            while (bottom > paddingTop && i2 >= 0) {
                View makeAndAddViewVertical = makeAndAddViewVertical(i2, i2 - this.mSelectedPosition, bottom, false);
                this.mFirstPosition = i2;
                bottom = makeAndAddViewVertical.getTop() - i3;
                i2--;
            }
        }
    }

    private void fillToGalleryTopCycle() {
        int bottom;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            int i3 = this.mSpacing;
            int paddingTop = getPaddingTop();
            View childAt = getChildAt(0);
            if (childAt != null) {
                i2 = this.mFirstPosition - 1;
                bottom = childAt.getTop() - i3;
            } else {
                bottom = (getBottom() - getTop()) - getPaddingBottom();
                this.mShouldStopFling = true;
                i2 = 0;
            }
            while (bottom > paddingTop && i2 >= 0) {
                View makeAndAddViewVertical = makeAndAddViewVertical(i2, i2 - this.mSelectedPosition, bottom, false);
                this.mFirstPosition = i2;
                bottom = makeAndAddViewVertical.getTop() - i3;
                i2--;
            }
            int i4 = this.mItemCount - 1;
            while (bottom > paddingTop && getChildCount() < this.mItemCount) {
                View makeAndAddViewVertical2 = makeAndAddViewVertical(i4, i4 - this.mSelectedPosition, bottom, false);
                this.mFirstPosition = i4;
                bottom = makeAndAddViewVertical2.getTop() - i3;
                i4--;
            }
        }
    }

    private int getCenterOfView(View view) {
        InterceptResult invokeL;
        int left;
        int width;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65561, this, view)) == null) {
            if (isOrientationVertical()) {
                left = view.getTop();
                width = view.getHeight() / 2;
            } else {
                left = view.getLeft();
                width = view.getWidth() / 2;
            }
            return left + width;
        }
        return invokeL.intValue;
    }

    private long getMaxMoveOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65562, this)) == null) ? this.mMaxMoveOffset : invokeV.longValue;
    }

    private float getStopFlingPosition() {
        InterceptResult invokeV;
        float width;
        int paddingLeft;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65563, this)) == null) {
            if (isOrientationVertical()) {
                width = ((getHeight() - getPaddingTop()) - getPaddingBottom()) * onStopFlingPosRatio();
                paddingLeft = getPaddingTop();
            } else {
                width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) * onStopFlingPosRatio();
                paddingLeft = getPaddingLeft();
            }
            return width + paddingLeft;
        }
        return invokeV.floatValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOrientationVertical() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65564, this)) == null) ? this.mOrientation == 2 : invokeV.booleanValue;
    }

    private View makeAndAddView(int i2, int i3, int i4, boolean z) {
        InterceptResult invokeCommon;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65565, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) {
            if (!this.mDataChanged && (view = this.mRecycler.get(i2)) != null) {
                int left = view.getLeft();
                this.mRightMost = Math.max(this.mRightMost, view.getMeasuredWidth() + left);
                this.mLeftMost = Math.min(this.mLeftMost, left);
                setUpChild(view, i3, i4, z);
                return view;
            }
            View view2 = this.mAdapter.getView(i2, null, this);
            setUpChild(view2, i3, i4, z);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    private View makeAndAddViewVertical(int i2, int i3, int i4, boolean z) {
        InterceptResult invokeCommon;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65566, this, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z)})) == null) {
            if (!this.mDataChanged && (view = this.mRecycler.get(i2)) != null) {
                int top = view.getTop();
                this.mRightMost = Math.max(this.mRightMost, view.getMeasuredHeight() + top);
                this.mLeftMost = Math.min(this.mLeftMost, top);
                setUpChildVertical(view, i3, i4, z);
                return view;
            }
            View view2 = this.mAdapter.getView(i2, null, this);
            setUpChildVertical(view2, i3, i4, z);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    private void offsetChildrenLeftAndRight(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65567, this, i2) == null) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                getChildAt(childCount).offsetLeftAndRight(i2);
            }
        }
    }

    private void offsetChildrenTopAndBottom(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(65568, this, i2) == null) {
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                getChildAt(childCount).offsetTopAndBottom(i2);
            }
        }
    }

    private void onFinishedMovement() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65569, this) == null) {
            if (this.mSuppressSelectionChanged) {
                this.mSuppressSelectionChanged = false;
            }
            super.selectionChanged();
            invalidate();
            onEndFling();
        }
    }

    private boolean performItemSelect(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65570, this, i2)) == null) {
            if (i2 != this.mSelectedPosition) {
                setSelectedPositionInt(i2);
                setNextSelectedPositionInt(i2);
                checkSelectionChanged();
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void scrollIntoSlotsVertical() {
        int height;
        int bottom;
        int height2;
        int bottom2;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65571, this) != null) {
            return;
        }
        if (isSlotInCenter()) {
            if (getChildCount() == 0 || (view = this.mSelectedChild) == null) {
                return;
            }
            int centerOfGallery = getCenterOfGallery() - getCenterOfView(view);
            if (centerOfGallery != 0) {
                this.mFlingRunnable.startUsingDistance(centerOfGallery);
            } else {
                onFinishedMovement();
            }
        } else if (getChildCount() == 0) {
        } else {
            int i2 = this.mFirstPosition;
            int i3 = 0;
            if (i2 == 0) {
                View childAt = getChildAt(0);
                if (childAt.getTop() >= 0) {
                    height = getPaddingTop();
                    bottom = childAt.getTop();
                    i3 = height - bottom;
                    if (i3 == 0) {
                        this.mFlingRunnable.startUsingDistance(i3);
                        return;
                    } else {
                        onFinishedMovement();
                        return;
                    }
                }
                View childAt2 = getChildAt(getChildCount() - 1);
                if (childAt2.getBottom() - childAt.getTop() < getBottom() - getPaddingBottom()) {
                    height2 = getPaddingLeft();
                    bottom2 = this.mFirstChildOffset;
                } else {
                    if (childAt2.getBottom() < getBottom() - getPaddingBottom()) {
                        height2 = getHeight() - getPaddingBottom();
                        bottom2 = childAt2.getBottom();
                    }
                    if (i3 == 0) {
                    }
                }
                i3 = height2 - bottom2;
                if (i3 == 0) {
                }
            } else {
                if (i2 + getChildCount() == this.mItemCount) {
                    View childAt3 = getChildAt(getChildCount() - 1);
                    if (childAt3.getBottom() < getBottom() - getPaddingBottom()) {
                        height = getHeight() - getPaddingBottom();
                        bottom = childAt3.getBottom();
                        i3 = height - bottom;
                    }
                }
                if (i3 == 0) {
                }
            }
        }
    }

    private boolean scrollToChild(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65572, this, i2)) == null) {
            View childAt = getChildAt(i2);
            if (childAt != null) {
                this.mFlingRunnable.startUsingDistance(getCenterOfGallery() - getCenterOfView(childAt));
                return true;
            }
            return false;
        }
        return invokeI.booleanValue;
    }

    private void setSelectionToCenterChild() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65573, this) == null) || (view = this.mSelectedChild) == null) {
            return;
        }
        int centerOfGallery = getCenterOfGallery();
        if (view.getLeft() > centerOfGallery || view.getRight() < centerOfGallery) {
            int i2 = Integer.MAX_VALUE;
            int i3 = 0;
            int childCount = getChildCount() - 1;
            while (true) {
                if (childCount < 0) {
                    break;
                }
                View childAt = getChildAt(childCount);
                if (childAt.getLeft() <= centerOfGallery && childAt.getRight() >= centerOfGallery) {
                    i3 = childCount;
                    break;
                }
                int min = Math.min(Math.abs(childAt.getLeft() - centerOfGallery), Math.abs(childAt.getRight() - centerOfGallery));
                if (min < i2) {
                    i3 = childCount;
                    i2 = min;
                }
                childCount--;
            }
            int i4 = this.mFirstPosition + i3;
            if (isScrollCycle()) {
                i4 %= this.mItemCount;
            }
            if (i4 != this.mSelectedPosition) {
                setSelectedPositionInt(i4);
                setNextSelectedPositionInt(i4);
                checkSelectionChanged();
            }
        }
    }

    private void setSelectionToCenterChildVertical() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65574, this) == null) || (view = this.mSelectedChild) == null) {
            return;
        }
        int centerOfGallery = getCenterOfGallery();
        if (view == null || view.getTop() > centerOfGallery || view.getBottom() < centerOfGallery) {
            int i2 = Integer.MAX_VALUE;
            int i3 = 0;
            int childCount = getChildCount() - 1;
            while (true) {
                if (childCount < 0) {
                    break;
                }
                View childAt = getChildAt(childCount);
                if (childAt.getTop() <= centerOfGallery && childAt.getBottom() >= centerOfGallery) {
                    i3 = childCount;
                    break;
                }
                int min = Math.min(Math.abs(childAt.getTop() - centerOfGallery), Math.abs(childAt.getBottom() - centerOfGallery));
                if (min < i2) {
                    i3 = childCount;
                    i2 = min;
                }
                childCount--;
            }
            int i4 = this.mFirstPosition + i3;
            if (isScrollCycle()) {
                i4 %= this.mItemCount;
            }
            if (i4 != this.mSelectedPosition) {
                setSelectedPositionInt(i4);
                setNextSelectedPositionInt(i4);
                checkSelectionChanged();
            }
        }
    }

    private void setUpChild(View view, int i2, int i3, boolean z) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65575, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = (LayoutParams) generateDefaultLayoutParams();
            }
            addViewInLayout(view, z ? -1 : 0, layoutParams);
            view.setSelected(i2 == 0);
            int i5 = this.mHeightMeasureSpec;
            Rect rect = this.mSpinnerPadding;
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, rect.top + rect.bottom, ((ViewGroup.LayoutParams) layoutParams).height);
            int i6 = this.mWidthMeasureSpec;
            Rect rect2 = this.mSpinnerPadding;
            view.measure(ViewGroup.getChildMeasureSpec(i6, rect2.left + rect2.right, ((ViewGroup.LayoutParams) layoutParams).width), childMeasureSpec);
            int calculateTop = calculateTop(view, true);
            int measuredHeight = view.getMeasuredHeight() + calculateTop;
            int measuredWidth = view.getMeasuredWidth();
            if (z) {
                i4 = measuredWidth + i3;
            } else {
                int i7 = i3 - measuredWidth;
                i4 = i3;
                i3 = i7;
            }
            view.layout(i3, calculateTop, i4, measuredHeight);
        }
    }

    private void setUpChildVertical(View view, int i2, int i3, boolean z) {
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65576, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z)}) == null) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = (LayoutParams) generateDefaultLayoutParams();
            }
            addViewInLayout(view, z ? -1 : 0, layoutParams);
            view.setSelected(i2 == 0);
            int i5 = this.mHeightMeasureSpec;
            Rect rect = this.mSpinnerPadding;
            int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, rect.top + rect.bottom, ((ViewGroup.LayoutParams) layoutParams).height);
            int i6 = this.mWidthMeasureSpec;
            Rect rect2 = this.mSpinnerPadding;
            view.measure(ViewGroup.getChildMeasureSpec(i6, rect2.left + rect2.right, ((ViewGroup.LayoutParams) layoutParams).width), childMeasureSpec);
            int calculateLeft = calculateLeft(view, true);
            int measuredWidth = view.getMeasuredWidth() + calculateLeft;
            int measuredHeight = view.getMeasuredHeight();
            if (z) {
                i4 = measuredHeight + i3;
            } else {
                int i7 = i3 - measuredHeight;
                i4 = i3;
                i3 = i7;
            }
            view.layout(calculateLeft, i3, measuredWidth, i4);
        }
    }

    private void updateSelectedItemMetadata() {
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65577, this) == null) {
            View view = this.mSelectedChild;
            Log(" updateSelectedItemMetadata   mSelectedPosition =  " + this.mSelectedPosition + "   mFirstPosition = " + this.mFirstPosition);
            int i4 = this.mSelectedPosition - this.mFirstPosition;
            if (isScrollCycle() && (i2 = this.mFirstPosition) > (i3 = this.mSelectedPosition)) {
                i4 = (this.mItemCount - i2) + i3;
            }
            View childAt = getChildAt(i4);
            this.mSelectedChild = childAt;
            if (childAt == null) {
                return;
            }
            childAt.setSelected(true);
            childAt.setFocusable(true);
            if (hasFocus()) {
                childAt.requestFocus();
            }
            if (view != null) {
                view.setSelected(false);
                view.setFocusable(false);
            }
        }
    }

    public void Log(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public boolean canBeScrolled(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            View childAt = getChildAt((z ? this.mItemCount - 1 : 0) - this.mFirstPosition);
            if (childAt == null) {
                return true;
            }
            int centerOfView = getCenterOfView(childAt);
            int centerOfGallery = getCenterOfGallery();
            if (isSlotInCenter()) {
                if (z) {
                    if (centerOfView < centerOfGallery - getMaxMoveOffset()) {
                        return false;
                    }
                } else if (centerOfView > centerOfGallery + getMaxMoveOffset()) {
                    return false;
                }
            } else if (z) {
                if (centerOfView < ((getRight() - getLeft()) - getPaddingRight()) - getMaxMoveOffset()) {
                    return false;
                }
            } else if (centerOfView > getPaddingLeft() + getMaxMoveOffset()) {
                return false;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, layoutParams)) == null) ? layoutParams instanceof LayoutParams : invokeL.booleanValue;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            int childCount = getChildCount();
            if (childCount > 0) {
                int i2 = childCount * 100;
                View childAt = getChildAt(0);
                int left = childAt.getLeft();
                int width = childAt.getWidth();
                if (width > 0) {
                    if (!(this.mFirstPosition == 0) || left <= 0) {
                        i2 += (left * 100) / width;
                    }
                }
                View childAt2 = getChildAt(childCount - 1);
                int right = childAt2.getRight();
                int width2 = childAt2.getWidth();
                if (width2 > 0) {
                    return (!(this.mFirstPosition + childCount == this.mItemCount) || right >= getWidth()) ? i2 - (((right - getWidth()) * 100) / width2) : i2;
                }
                return i2;
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.mFirstPosition >= 0 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                int left = childAt.getLeft();
                int width = childAt.getWidth();
                if (width > 0) {
                    return Math.max(((this.mFirstPosition / 1) * 100) - ((left * 100) / width), 0);
                }
            }
            return this.mSelectedPosition;
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? Math.max((((this.mItemCount + 1) - 1) / 1) * 100, 0) : invokeV.intValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, keyEvent)) == null) ? keyEvent.dispatch(this) : invokeL.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (view = this.mSelectedChild) == null) {
            return;
        }
        view.setPressed(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetSelected(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) {
        }
    }

    public void dispatchUnpress() {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048585, this) != null) {
            return;
        }
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (childCount >= 0) {
                getChildAt(childCount).setPressed(false);
            } else {
                setPressed(false);
                return;
            }
        }
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAbsSpinner, android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? new LayoutParams(-2, -2) : (ViewGroup.LayoutParams) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, layoutParams)) == null) ? new LayoutParams(layoutParams) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    public int getCenterOfGallery() {
        InterceptResult invokeV;
        int width;
        int paddingLeft;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (isOrientationVertical()) {
                width = ((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2;
                paddingLeft = getPaddingTop();
            } else {
                width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2;
                paddingLeft = getPaddingLeft();
            }
            return width + paddingLeft;
        }
        return invokeV.intValue;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048590, this, i2, i3)) == null) {
            int i4 = this.mSelectedPosition - this.mFirstPosition;
            return i4 < 0 ? i3 : i3 == i2 + (-1) ? i4 : i3 >= i4 ? i3 + 1 : i3;
        }
        return invokeII.intValue;
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAbsSpinner
    public int getChildHeight(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, view)) == null) ? view.getMeasuredHeight() : invokeL.intValue;
    }

    @Override // android.view.ViewGroup
    public boolean getChildStaticTransformation(View view, Transformation transformation) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048592, this, view, transformation)) == null) {
            transformation.clear();
            transformation.setAlpha(view == this.mSelectedChild ? 1.0f : this.mUnselectedAlpha);
            Log(" getChildStaticTransformation   mSelectedPosition =  " + this.mSelectedPosition + "   mFirstPosition = " + this.mFirstPosition + "     mSelectedChild = " + this.mSelectedChild);
            return true;
        }
        return invokeLL.booleanValue;
    }

    @Override // android.view.View
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.mContextMenuInfo : (ContextMenu.ContextMenuInfo) invokeV.objValue;
    }

    public int getFirstPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.mFirstPosition : invokeV.intValue;
    }

    public int getItemIndexFromPoint(Point point) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, point)) == null) {
            int childCount = getChildCount();
            Rect rect = new Rect();
            getDrawingRect(rect);
            if (rect.contains(point.x, point.y)) {
                i2 = 0;
                while (i2 < childCount) {
                    getChildAt(i2).getHitRect(rect);
                    if (rect.contains(point.x, point.y)) {
                        break;
                    }
                    i2++;
                }
            }
            i2 = -1;
            if (i2 >= 0) {
                return i2 + this.mFirstPosition;
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public int getLimitedMotionScrollAmount(boolean z, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2)})) == null) {
            View childAt = getChildAt((z ? this.mItemCount - 1 : 0) - this.mFirstPosition);
            if (childAt == null) {
                return i2;
            }
            int centerOfView = getCenterOfView(childAt);
            int centerOfGallery = getCenterOfGallery();
            if (z) {
                if (centerOfView <= centerOfGallery) {
                    return 0;
                }
            } else if (centerOfView >= centerOfGallery) {
                return 0;
            }
            int i3 = centerOfGallery - centerOfView;
            return z ? Math.max(i3, i2) : Math.min(i3, i2);
        }
        return invokeCommon.intValue;
    }

    public int getOrientation() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? this.mOrientation : invokeV.intValue;
    }

    public int getSpacing() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.mSpacing : invokeV.intValue;
    }

    public float getVelocityRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.mVelocityRatio : invokeV.floatValue;
    }

    @Override // android.view.View
    public void invalidate(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048600, this, i2, i3, i4, i5) == null) {
            super.invalidate(i2, i3 - (this.mScrollBarSize + this.mScrollBarBottomMargin), i4, i5);
        }
    }

    public boolean isPointInChild(float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (f2 >= childAt.getLeft() && f2 <= childAt.getRight() && f3 >= childAt.getTop() && f3 <= childAt.getBottom()) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public boolean isScrollCycle() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.mIsScrollCycle && this.mIsScrollCycleTemp : invokeV.booleanValue;
    }

    public boolean isScrolling() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) ? this.mScrolling : invokeV.booleanValue;
    }

    public boolean isSlotInCenter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.mIsSlotCenter : invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAbsSpinner
    public void layout(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (isOrientationVertical()) {
                layoutVertical(i2, z);
                return;
            }
            int i3 = this.mSpinnerPadding.left + this.mFirstChildOffset;
            if (this.mDataChanged) {
                handleDataChanged();
            }
            if (this.mItemCount == 0) {
                resetList();
                return;
            }
            int i4 = this.mNextSelectedPosition;
            if (i4 >= 0) {
                setSelectedPositionInt(i4);
            }
            recycleAllViews();
            detachAllViewsFromParent();
            this.mRightMost = 0;
            this.mLeftMost = 0;
            int i5 = this.mSelectedPosition;
            this.mFirstPosition = i5;
            View makeAndAddView = makeAndAddView(i5, 0, 0, true);
            int i6 = this.mSpacing + i3;
            if (isSlotInCenter()) {
                int right = getRight() - getLeft();
                Rect rect = this.mSpinnerPadding;
                i6 = (i3 + (((right - rect.left) - rect.right) / 2)) - (makeAndAddView.getWidth() / 2);
            }
            makeAndAddView.offsetLeftAndRight(i6);
            fillToGalleryRight();
            fillToGalleryLeft();
            this.mRecycler.clear();
            invalidate();
            this.mDataChanged = false;
            this.mNeedSync = false;
            setNextSelectedPositionInt(this.mSelectedPosition);
            updateSelectedItemMetadata();
            this.mIsScrollCycleTemp = getChildCount() < this.mItemCount;
        }
    }

    public void layoutVertical(int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (this.mDataChanged) {
                handleDataChanged();
            }
            if (this.mItemCount == 0) {
                resetList();
                return;
            }
            int i3 = this.mNextSelectedPosition;
            if (i3 >= 0) {
                setSelectedPositionInt(i3);
            }
            fillGallery();
            boolean z2 = this.mIsScrollCycleTemp;
            boolean z3 = getChildCount() < this.mItemCount;
            this.mIsScrollCycleTemp = z3;
            if (z2 != z3) {
                fillGallery();
            }
            this.mRecycler.clear();
            invalidate();
            this.mDataChanged = false;
            this.mNeedSync = false;
            setNextSelectedPositionInt(this.mSelectedPosition);
            updateSelectedItemMetadata();
        }
    }

    public boolean moveNext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            int i2 = this.mItemCount;
            return i2 > 0 && this.mSelectedPosition < i2 - 1;
        }
        return invokeV.booleanValue;
    }

    public boolean movePrevious() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.mItemCount > 0 && this.mSelectedPosition > 0 : invokeV.booleanValue;
    }

    public void onCancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            onUp();
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048610, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, motionEvent)) == null) {
            if (1 != motionEvent.getAction() || (i2 = this.mDownTouchPosition) < 0) {
                return false;
            }
            if (this.mShouldCallbackOnUnselectedItemClick || i2 == this.mSelectedPosition) {
                View view = this.mDownTouchView;
                int i3 = this.mDownTouchPosition;
                performItemDoubleClick(view, i3, this.mAdapter.getItemId(i3));
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048612, this, motionEvent)) == null) {
            this.mFlingRunnable.stop(false);
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            this.mDownTouchPosition = pointToPosition;
            if (pointToPosition >= 0) {
                View childAt = getChildAt(pointToPosition - this.mFirstPosition);
                this.mDownTouchView = childAt;
                childAt.setPressed(true);
            }
            this.mIsFirstScroll = true;
            return true;
        }
        return invokeL.booleanValue;
    }

    public void onDrawHorizontalScrollBar(Canvas canvas, Drawable drawable, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{canvas, drawable, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            int i6 = i5 - this.mScrollBarBottomMargin;
            drawable.setBounds(i2, i6 - this.mScrollBarSize, i4, i6);
            drawable.draw(canvas);
        }
    }

    public void onEndFling() {
        OnEndFlingListener onEndFlingListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (onEndFlingListener = this.mOnEndFlingListener) == null || this.mInLayout || ((BdAbsSpinner) this).mBlockLayoutRequests) {
            return;
        }
        onEndFlingListener.onEndFling(this);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048615, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (shouldDisableScroll()) {
                return true;
            }
            if (!this.mShouldCallbackDuringFling) {
                removeCallbacks(this.mDisableSuppressSelectionChangedRunnable);
                if (!this.mSuppressSelectionChanged) {
                    this.mSuppressSelectionChanged = true;
                }
            }
            if (isOrientationVertical()) {
                this.mFlingRunnable.startUsingVelocity((int) (-(f3 * getVelocityRatio())));
            } else {
                this.mFlingRunnable.startUsingVelocity((int) (-(f2 * getVelocityRatio())));
            }
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i2, Rect rect) {
        View view;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048616, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), rect}) == null) {
            super.onFocusChanged(z, i2, rect);
            if (!z || (view = this.mSelectedChild) == null) {
                return;
            }
            view.requestFocus(i2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048617, this, i2, keyEvent)) == null) {
            if (i2 != 66) {
                switch (i2) {
                    case 21:
                        if (movePrevious()) {
                            playSoundEffect(1);
                        }
                        return true;
                    case 22:
                        if (moveNext()) {
                            playSoundEffect(3);
                        }
                        return true;
                }
                return super.onKeyDown(i2, keyEvent);
            }
            this.mReceivedInvokeKeyDown = true;
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048618, this, i2, keyEvent)) == null) {
            if (i2 != 23 && i2 != 66) {
                return super.onKeyUp(i2, keyEvent);
            }
            if (this.mReceivedInvokeKeyDown && this.mItemCount > 0) {
                dispatchPress(this.mSelectedChild);
                postDelayed(new Runnable(this) { // from class: com.baidu.searchbox.ui.wheelview2d.BdGallery.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ BdGallery this$0;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            this.this$0.dispatchUnpress();
                        }
                    }
                }, ViewConfiguration.getPressedStateDuration());
                View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
                int i3 = this.mSelectedPosition;
                performItemClick(childAt, i3, this.mAdapter.getItemId(i3));
            }
            this.mReceivedInvokeKeyDown = false;
            return true;
        }
        return invokeIL.booleanValue;
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048619, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            this.mInLayout = true;
            layout(0, false);
            this.mInLayout = false;
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048620, this, motionEvent) == null) || this.mDownTouchPosition < 0) {
            return;
        }
        performHapticFeedback(0);
        dispatchLongPress(this.mDownTouchView, this.mDownTouchPosition, getItemIdAtPosition(this.mDownTouchPosition));
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048621, this, new Object[]{motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (shouldDisableScroll()) {
                return true;
            }
            this.mScrolling = true;
            getParent().requestDisallowInterceptTouchEvent(true);
            if (!this.mShouldCallbackDuringFling) {
                if (this.mIsFirstScroll) {
                    if (!this.mSuppressSelectionChanged) {
                        this.mSuppressSelectionChanged = true;
                    }
                    postDelayed(this.mDisableSuppressSelectionChangedRunnable, 250L);
                }
            } else if (this.mSuppressSelectionChanged) {
                this.mSuppressSelectionChanged = false;
            }
            if (isOrientationVertical()) {
                trackMotionScrollVertical(((int) f3) * (-1));
            } else {
                int i2 = ((int) f2) * (-1);
                if (canBeScrolled(i2 < 0)) {
                    trackMotionScroll(i2);
                }
            }
            this.mIsFirstScroll = false;
            return true;
        }
        return invokeCommon.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048622, this, motionEvent) == null) {
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048623, this, motionEvent)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048624, this, motionEvent)) == null) {
            if (this.mDownTouchPosition >= 0) {
                if (isScrollCycle()) {
                    this.mDownTouchPosition %= getCount();
                }
                if (isSlotInCenter()) {
                    scrollToChild(this.mDownTouchPosition - this.mFirstPosition);
                }
                performItemSelect(this.mDownTouchPosition);
                if (this.mShouldCallbackOnUnselectedItemClick || this.mDownTouchPosition == this.mSelectedPosition) {
                    View view = this.mDownTouchView;
                    int i2 = this.mDownTouchPosition;
                    performItemClick(view, i2, this.mAdapter.getItemId(i2));
                    return true;
                }
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public float onStopFlingPosRatio() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            return 0.0f;
        }
        return invokeV.floatValue;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, motionEvent)) == null) {
            boolean onTouchEvent = this.mGestureDetector.onTouchEvent(motionEvent);
            int action = motionEvent.getAction();
            if (action == 1) {
                onUp();
            } else if (action == 3) {
                onCancel();
            }
            return onTouchEvent;
        }
        return invokeL.booleanValue;
    }

    public void onUp() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            if (this.mFlingRunnable.mScroller.isFinished()) {
                scrollIntoSlots();
            }
            dispatchUnpress();
        }
    }

    public int scrollGalleryItems(boolean z) {
        InterceptResult invokeZ;
        int min;
        FlingRunnable flingRunnable;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048629, this, z)) == null) {
            if (getChildCount() == 0) {
                return 0;
            }
            if (z) {
                View childAt = getChildAt(getChildCount() - 1);
                min = Math.max(((childAt != null ? childAt.getRight() : 0) - getRight()) + getPaddingRight(), 0);
                if (min == 0 && this.mFirstPosition + getChildCount() != this.mItemCount) {
                    min += childAt != null ? childAt.getWidth() : 0;
                }
            } else {
                View childAt2 = getChildAt(0);
                min = Math.min((childAt2 != null ? childAt2.getLeft() : 0) - getPaddingLeft(), 0);
                if (min == 0 && this.mFirstPosition != 0) {
                    min -= childAt2 != null ? childAt2.getWidth() : 0;
                }
            }
            if (min != 0 && (flingRunnable = this.mFlingRunnable) != null) {
                flingRunnable.startUsingDistance(min * (-1));
            }
            return min * (-1);
        }
        return invokeZ.intValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void scrollIntoSlots() {
        int width;
        int right;
        int width2;
        int right2;
        View view;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(1048630, this) != null) {
            return;
        }
        if (isOrientationVertical()) {
            scrollIntoSlotsVertical();
        } else if (isSlotInCenter()) {
            if (getChildCount() == 0 || (view = this.mSelectedChild) == null) {
                return;
            }
            int centerOfGallery = getCenterOfGallery() - getCenterOfView(view);
            if (centerOfGallery != 0) {
                this.mFlingRunnable.startUsingDistance(centerOfGallery);
            } else {
                onFinishedMovement();
            }
        } else if (getChildCount() == 0) {
        } else {
            int i2 = this.mFirstPosition;
            int i3 = 0;
            if (i2 == 0) {
                View childAt = getChildAt(0);
                if (childAt.getLeft() >= 0) {
                    width = getPaddingLeft();
                    right = childAt.getLeft();
                    i3 = width - right;
                    if (i3 == 0) {
                        this.mFlingRunnable.startUsingDistance(i3);
                        return;
                    } else {
                        onFinishedMovement();
                        return;
                    }
                }
                View childAt2 = getChildAt(getChildCount() - 1);
                if (childAt2.getRight() - childAt.getLeft() < getRight() - getPaddingRight()) {
                    width2 = getPaddingLeft();
                    right2 = this.mFirstChildOffset;
                } else {
                    if (childAt2.getRight() < getRight() - getPaddingRight()) {
                        width2 = getWidth() - getPaddingRight();
                        right2 = childAt2.getRight();
                    }
                    if (i3 == 0) {
                    }
                }
                i3 = width2 - right2;
                if (i3 == 0) {
                }
            } else {
                if (i2 + getChildCount() == this.mItemCount) {
                    View childAt3 = getChildAt(getChildCount() - 1);
                    if (childAt3.getRight() < getRight() - getPaddingRight()) {
                        width = getWidth() - getPaddingRight();
                        right = childAt3.getRight();
                        i3 = width - right;
                    }
                }
                if (i3 == 0) {
                }
            }
        }
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public void selectionChanged() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048631, this) == null) || this.mSuppressSelectionChanged) {
            return;
        }
        super.selectionChanged();
    }

    public void setAnimationDuration(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048632, this, i2) == null) {
            this.mAnimationDuration = i2;
        }
    }

    public void setCallbackDuringFling(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048633, this, z) == null) {
            this.mShouldCallbackDuringFling = z;
        }
    }

    public void setCallbackOnUnselectedItemClick(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048634, this, z) == null) {
            this.mShouldCallbackOnUnselectedItemClick = z;
        }
    }

    public void setDisableScroll(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048635, this, z) == null) {
            this.mIsDisableScroll = z;
        }
    }

    public void setDisableScrollAnyway(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048636, this, z) == null) {
            this.mDisableScrollAnyway = z;
        }
    }

    public void setFirstChildOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048637, this, i2) == null) {
            this.mFirstChildOffset = i2;
        }
    }

    public void setFirstPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048638, this, i2) == null) {
            this.mFirstPosition = i2;
        }
    }

    public void setGravity(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048639, this, i2) == null) || this.mGravity == i2) {
            return;
        }
        this.mGravity = i2;
        requestLayout();
    }

    public void setMaxMoveOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048640, this, i2) == null) {
            this.mMaxMoveOffset = i2;
        }
    }

    public void setOnEndFlingListener(OnEndFlingListener onEndFlingListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048641, this, onEndFlingListener) == null) {
            this.mOnEndFlingListener = onEndFlingListener;
        }
    }

    public void setOrientation(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048642, this, i2) == null) {
            this.mOrientation = i2;
        }
    }

    public void setScrollBarBottomMargin(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048643, this, i2) == null) {
            this.mScrollBarBottomMargin = i2;
        }
    }

    @Override // android.view.View
    public void setScrollBarSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048644, this, i2) == null) {
            this.mScrollBarSize = i2;
        }
    }

    public void setScrollCycle(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048645, this, z) == null) {
            this.mIsScrollCycle = z;
        }
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public void setSelectedPositionInt(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048646, this, i2) == null) {
            super.setSelectedPositionInt(i2);
            updateSelectedItemMetadata();
        }
    }

    public void setSlotInCenter(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048647, this, z) == null) {
            this.mIsSlotCenter = z;
        }
    }

    public void setSpacing(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048648, this, i2) == null) {
            this.mSpacing = i2;
        }
    }

    public void setUnselectedAlpha(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048649, this, f2) == null) {
            this.mUnselectedAlpha = f2;
        }
    }

    public void setVelocityRatio(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048650, this, f2) == null) {
            this.mVelocityRatio = f2;
            if (f2 < 0.5f) {
                this.mVelocityRatio = 0.5f;
            } else if (f2 > 1.5f) {
                this.mVelocityRatio = 1.5f;
            }
        }
    }

    public boolean shouldDisableScroll() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048651, this)) == null) {
            if (this.mDisableScrollAnyway) {
                return true;
            }
            if (!this.mIsDisableScroll || getChildCount() < this.mItemCount) {
                return false;
            }
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getLeft() >= getLeft()) {
                View childAt2 = getChildAt(getChildCount() - 1);
                return childAt2 == null || childAt2.getRight() <= getRight();
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.View
    public boolean showContextMenu() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048652, this)) == null) {
            if (!isPressed() || (i2 = this.mSelectedPosition) < 0) {
                return false;
            }
            return dispatchLongPress(getChildAt(i2 - this.mFirstPosition), this.mSelectedPosition, this.mSelectedRowId);
        }
        return invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048653, this, view)) == null) {
            int positionForView = getPositionForView(view);
            if (positionForView < 0) {
                return false;
            }
            return dispatchLongPress(view, positionForView, this.mAdapter.getItemId(positionForView));
        }
        return invokeL.booleanValue;
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void trackMotionScroll(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048654, this, i2) == null) || getChildCount() == 0) {
            return;
        }
        boolean z = i2 < 0;
        if (isSlotInCenter()) {
            if ((!isScrollCycle() || getChildCount() >= this.mItemCount) && getLimitedMotionScrollAmount(z, i2) != i2) {
                this.mFlingRunnable.endFling(false);
                onFinishedMovement();
            }
            if (canBeScrolled(z)) {
                offsetChildrenLeftAndRight(i2);
                detachOffScreenChildren(z);
                if (z) {
                    fillToGalleryRight();
                } else {
                    fillToGalleryLeft();
                }
                this.mRecycler.clear();
                setSelectionToCenterChild();
                invalidate();
            }
        } else if (z) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt != null && childAt.getRight() < getStopFlingPosition()) {
                FlingRunnable flingRunnable = this.mFlingRunnable;
                if (flingRunnable != null) {
                    flingRunnable.stop(false);
                }
                i2 = 0;
            }
            offsetChildrenLeftAndRight(i2);
            detachOffScreenChildren(z);
            if (!z) {
                fillToGalleryRight();
            } else {
                fillToGalleryLeft();
            }
            this.mRecycler.clear();
            setSelectionToCenterChild();
            awakenScrollBars();
            invalidate();
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 != null && childAt2.getLeft() > getWidth() - getStopFlingPosition()) {
                FlingRunnable flingRunnable2 = this.mFlingRunnable;
                if (flingRunnable2 != null) {
                    flingRunnable2.stop(false);
                }
                i2 = 0;
            }
            offsetChildrenLeftAndRight(i2);
            detachOffScreenChildren(z);
            if (!z) {
            }
            this.mRecycler.clear();
            setSelectionToCenterChild();
            awakenScrollBars();
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void trackMotionScrollVertical(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048655, this, i2) == null) || getChildCount() == 0) {
            return;
        }
        boolean z = i2 < 0;
        if (isSlotInCenter()) {
            if ((!isScrollCycle() || getChildCount() >= this.mItemCount) && getLimitedMotionScrollAmount(z, i2) != i2) {
                this.mFlingRunnable.endFling(false);
                onFinishedMovement();
            }
            offsetChildrenTopAndBottom(i2);
            detachOffScreenChildrenVertical(z);
            if (z) {
                fillToGalleryBottom();
            } else {
                fillToGalleryTop();
            }
            this.mRecycler.clear();
            setSelectionToCenterChildVertical();
            invalidate();
        } else if (z) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt != null && childAt.getRight() < getStopFlingPosition()) {
                FlingRunnable flingRunnable = this.mFlingRunnable;
                if (flingRunnable != null) {
                    flingRunnable.stop(false);
                }
                i2 = 0;
            }
            offsetChildrenTopAndBottom(i2);
            detachOffScreenChildrenVertical(z);
            if (!z) {
                fillToGalleryBottom();
            } else {
                fillToGalleryTop();
            }
            this.mRecycler.clear();
            setSelectionToCenterChild();
            awakenScrollBars();
            invalidate();
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 != null && childAt2.getLeft() > getWidth() - getStopFlingPosition()) {
                FlingRunnable flingRunnable2 = this.mFlingRunnable;
                if (flingRunnable2 != null) {
                    flingRunnable2.stop(false);
                }
                i2 = 0;
            }
            offsetChildrenTopAndBottom(i2);
            detachOffScreenChildrenVertical(z);
            if (!z) {
            }
            this.mRecycler.clear();
            setSelectionToCenterChild();
            awakenScrollBars();
            invalidate();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BdGallery(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.galleryStyle);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, attributeSet)) == null) ? new LayoutParams(getContext(), attributeSet) : (ViewGroup.LayoutParams) invokeL.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BdGallery(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.mSpacing = 0;
        this.mAnimationDuration = 400;
        this.mFlingRunnable = new FlingRunnable(this);
        this.mMaxMoveOffset = 2147483646L;
        this.mDisableSuppressSelectionChangedRunnable = new Runnable(this) { // from class: com.baidu.searchbox.ui.wheelview2d.BdGallery.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BdGallery this$0;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr3 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.this$0.mSuppressSelectionChanged = false;
                    this.this$0.selectionChanged();
                }
            }
        };
        this.mShouldCallbackDuringFling = true;
        this.mShouldCallbackOnUnselectedItemClick = true;
        this.mIsDisableScroll = false;
        this.mDisableScrollAnyway = false;
        this.mScrolling = false;
        this.mFirstChildOffset = 0;
        this.mScrollBarBottomMargin = 0;
        this.mScrollBarSize = 5;
        this.mVelocityRatio = 1.0f;
        this.mIsScrollCycle = false;
        this.mIsScrollCycleTemp = true;
        this.mIsSlotCenter = false;
        this.mOrientation = 1;
        this.mOnEndFlingListener = null;
        GestureDetector gestureDetector = new GestureDetector(context, this);
        this.mGestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Gallery, i2, 0);
        int i5 = obtainStyledAttributes.getInt(R.styleable.Gallery_gravity, -1);
        if (i5 >= 0) {
            setGravity(i5);
        }
        int i6 = obtainStyledAttributes.getInt(R.styleable.Gallery_animationDuration, -1);
        if (i6 > 0) {
            setAnimationDuration(i6);
        }
        setSpacing(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.Gallery_spacing, 0));
        setUnselectedAlpha(obtainStyledAttributes.getFloat(R.styleable.Gallery_unselectedAlpha, 0.5f));
        obtainStyledAttributes.recycle();
        setChildrenDrawingOrderEnabled(true);
        setStaticTransformationsEnabled(true);
        this.mScrollBarSize = ViewConfiguration.get(context).getScaledScrollBarSize();
        if (isOrientationVertical()) {
            this.mGravity = 1;
        } else {
            this.mGravity = 16;
        }
    }

    public int scrollGalleryItems(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048628, this, i2)) == null) {
            FlingRunnable flingRunnable = this.mFlingRunnable;
            if (flingRunnable != null) {
                flingRunnable.startUsingDistance(i2 * (-1));
            }
            return i2 * (-1);
        }
        return invokeI.intValue;
    }
}
