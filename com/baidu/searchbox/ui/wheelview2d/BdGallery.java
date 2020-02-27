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
import com.baidu.android.common.ui.R;
import com.baidu.searchbox.ui.wheelview2d.BdAdapterView;
/* loaded from: classes13.dex */
public class BdGallery extends BdAbsSpinner implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
    public static final int HORIZONTAL = 1;
    private static final int SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT = 250;
    private static final String TAG = "BdGallery";
    public static final int VERTICAL = 2;
    private static final boolean localLOGV = false;
    private int mAnimationDuration;
    private BdAdapterView.AdapterContextMenuInfo mContextMenuInfo;
    private boolean mDisableScrollAnyway;
    private Runnable mDisableSuppressSelectionChangedRunnable;
    private int mDownTouchPosition;
    private View mDownTouchView;
    private int mFirstChildOffset;
    private FlingRunnable mFlingRunnable;
    private GestureDetector mGestureDetector;
    private int mGravity;
    private boolean mIsDisableScroll;
    private boolean mIsFirstScroll;
    private boolean mIsScrollCycle;
    private boolean mIsScrollCycleTemp;
    private boolean mIsSlotCenter;
    private int mLeftMost;
    private long mMaxMoveOffset;
    private OnEndFlingListener mOnEndFlingListener;
    private int mOrientation;
    private boolean mReceivedInvokeKeyDown;
    private int mRightMost;
    private int mScrollBarBottomMargin;
    private int mScrollBarSize;
    private boolean mScrolling;
    private View mSelectedChild;
    private boolean mShouldCallbackDuringFling;
    private boolean mShouldCallbackOnUnselectedItemClick;
    private boolean mShouldStopFling;
    private int mSpacing;
    private boolean mSuppressSelectionChanged;
    private float mUnselectedAlpha;
    private float mVelocityRatio;

    /* loaded from: classes13.dex */
    public interface OnEndFlingListener {
        void onEndFling(BdGallery bdGallery);
    }

    public BdGallery(Context context) {
        this(context, null);
    }

    public BdGallery(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.galleryStyle);
    }

    public BdGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSpacing = 0;
        this.mAnimationDuration = 400;
        this.mFlingRunnable = new FlingRunnable();
        this.mMaxMoveOffset = 2147483646L;
        this.mDisableSuppressSelectionChangedRunnable = new Runnable() { // from class: com.baidu.searchbox.ui.wheelview2d.BdGallery.1
            @Override // java.lang.Runnable
            public void run() {
                BdGallery.this.mSuppressSelectionChanged = false;
                BdGallery.this.selectionChanged();
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
        this.mGestureDetector = new GestureDetector(context, this);
        this.mGestureDetector.setIsLongpressEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Gallery, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.Gallery_gravity, -1);
        if (i2 >= 0) {
            setGravity(i2);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.Gallery_animationDuration, -1);
        if (i3 > 0) {
            setAnimationDuration(i3);
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

    public void setCallbackDuringFling(boolean z) {
        this.mShouldCallbackDuringFling = z;
    }

    public void setCallbackOnUnselectedItemClick(boolean z) {
        this.mShouldCallbackOnUnselectedItemClick = z;
    }

    public void setAnimationDuration(int i) {
        this.mAnimationDuration = i;
    }

    public void setSpacing(int i) {
        this.mSpacing = i;
    }

    public void setUnselectedAlpha(float f) {
        this.mUnselectedAlpha = f;
    }

    @Override // android.view.ViewGroup
    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        transformation.clear();
        transformation.setAlpha(view == this.mSelectedChild ? 1.0f : this.mUnselectedAlpha);
        Log(" getChildStaticTransformation   mSelectedPosition =  " + this.mSelectedPosition + "   mFirstPosition = " + this.mFirstPosition + "     mSelectedChild = " + this.mSelectedChild);
        return true;
    }

    protected void onDrawHorizontalScrollBar(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4) {
        int i5 = i2 - this.mScrollBarBottomMargin;
        int i6 = i4 - this.mScrollBarBottomMargin;
        drawable.setBounds(i, i6 - this.mScrollBarSize, i3, i6);
        drawable.draw(canvas);
    }

    @Override // android.view.View
    public void invalidate(int i, int i2, int i3, int i4) {
        super.invalidate(i, i2 - (this.mScrollBarSize + this.mScrollBarBottomMargin), i3, i4);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i = childCount * 100;
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                if (!(this.mFirstPosition == 0) || left <= 0) {
                    i += (left * 100) / width;
                }
            }
            View childAt2 = getChildAt(childCount - 1);
            int right = childAt2.getRight();
            int width2 = childAt2.getWidth();
            if (width2 > 0) {
                if (!(childCount + this.mFirstPosition == this.mItemCount) || right >= getWidth()) {
                    return i - (((right - getWidth()) * 100) / width2);
                }
                return i;
            }
            return i;
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
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

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return Math.max((((this.mItemCount + 1) - 1) / 1) * 100, 0);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAbsSpinner, android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mInLayout = true;
        layout(0, false);
        this.mInLayout = false;
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAbsSpinner
    int getChildHeight(View view) {
        return view.getMeasuredHeight();
    }

    void trackMotionScroll(int i) {
        int i2 = 0;
        if (getChildCount() != 0) {
            boolean z = i < 0;
            if (isSlotInCenter()) {
                if ((!isScrollCycle() || getChildCount() >= this.mItemCount) && getLimitedMotionScrollAmount(z, i) != i) {
                    this.mFlingRunnable.endFling(false);
                    onFinishedMovement();
                }
                if (canBeScrolled(z)) {
                    offsetChildrenLeftAndRight(i);
                    detachOffScreenChildren(z);
                    if (z) {
                        fillToGalleryRight();
                    } else {
                        fillToGalleryLeft();
                    }
                    this.mRecycler.clear();
                    setSelectionToCenterChild();
                    invalidate();
                    return;
                }
                return;
            }
            if (z) {
                View childAt = getChildAt(getChildCount() - 1);
                if (childAt != null && childAt.getRight() < getStopFlingPosition()) {
                    if (this.mFlingRunnable != null) {
                        this.mFlingRunnable.stop(false);
                    }
                }
                i2 = i;
            } else {
                View childAt2 = getChildAt(0);
                if (childAt2 != null && childAt2.getLeft() > getWidth() - getStopFlingPosition()) {
                    if (this.mFlingRunnable != null) {
                        this.mFlingRunnable.stop(false);
                    }
                }
                i2 = i;
            }
            offsetChildrenLeftAndRight(i2);
            detachOffScreenChildren(z);
            if (z) {
                fillToGalleryRight();
            } else {
                fillToGalleryLeft();
            }
            this.mRecycler.clear();
            setSelectionToCenterChild();
            awakenScrollBars();
            invalidate();
        }
    }

    void trackMotionScrollVertical(int i) {
        int i2 = 0;
        if (getChildCount() != 0) {
            boolean z = i < 0;
            if (isSlotInCenter()) {
                if ((!isScrollCycle() || getChildCount() >= this.mItemCount) && getLimitedMotionScrollAmount(z, i) != i) {
                    this.mFlingRunnable.endFling(false);
                    onFinishedMovement();
                }
                offsetChildrenTopAndBottom(i);
                detachOffScreenChildrenVertical(z);
                if (z) {
                    fillToGalleryBottom();
                } else {
                    fillToGalleryTop();
                }
                this.mRecycler.clear();
                setSelectionToCenterChildVertical();
                invalidate();
                return;
            }
            if (z) {
                View childAt = getChildAt(getChildCount() - 1);
                if (childAt != null && childAt.getRight() < getStopFlingPosition()) {
                    if (this.mFlingRunnable != null) {
                        this.mFlingRunnable.stop(false);
                    }
                }
                i2 = i;
            } else {
                View childAt2 = getChildAt(0);
                if (childAt2 != null && childAt2.getLeft() > getWidth() - getStopFlingPosition()) {
                    if (this.mFlingRunnable != null) {
                        this.mFlingRunnable.stop(false);
                    }
                }
                i2 = i;
            }
            offsetChildrenTopAndBottom(i2);
            detachOffScreenChildrenVertical(z);
            if (z) {
                fillToGalleryBottom();
            } else {
                fillToGalleryTop();
            }
            this.mRecycler.clear();
            setSelectionToCenterChild();
            awakenScrollBars();
            invalidate();
        }
    }

    int getLimitedMotionScrollAmount(boolean z, int i) {
        View childAt = getChildAt((z ? this.mItemCount - 1 : 0) - this.mFirstPosition);
        if (childAt == null) {
            return i;
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
        int i2 = centerOfGallery - centerOfView;
        return z ? Math.max(i2, i) : Math.min(i2, i);
    }

    boolean canBeScrolled(boolean z) {
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

    private void offsetChildrenLeftAndRight(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount).offsetLeftAndRight(i);
        }
    }

    private void offsetChildrenTopAndBottom(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount).offsetTopAndBottom(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCenterOfGallery() {
        return isOrientationVertical() ? (((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2) + getPaddingTop() : (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
    }

    private float getStopFlingPosition() {
        return isOrientationVertical() ? (((getHeight() - getPaddingTop()) - getPaddingBottom()) * onStopFlingPosRatio()) + getPaddingTop() : (((getWidth() - getPaddingLeft()) - getPaddingRight()) * onStopFlingPosRatio()) + getPaddingLeft();
    }

    protected float onStopFlingPosRatio() {
        return 0.0f;
    }

    private int getCenterOfView(View view) {
        return isOrientationVertical() ? view.getTop() + (view.getHeight() / 2) : view.getLeft() + (view.getWidth() / 2);
    }

    private void detachOffScreenChildren(boolean z) {
        int i;
        int i2 = 0;
        int childCount = getChildCount();
        int i3 = this.mFirstPosition;
        if (z) {
            int paddingLeft = getPaddingLeft();
            int i4 = 0;
            i = 0;
            while (i4 < childCount) {
                View childAt = getChildAt(i4);
                if (childAt.getRight() >= paddingLeft) {
                    break;
                }
                this.mRecycler.put(i3 + i4, childAt);
                i4++;
                i++;
            }
            if (i == childCount) {
                i--;
            }
        } else {
            int width = getWidth() - getPaddingRight();
            i = 0;
            for (int i5 = childCount - 1; i5 >= 0; i5--) {
                View childAt2 = getChildAt(i5);
                if (childAt2.getLeft() <= width) {
                    break;
                }
                this.mRecycler.put(i3 + i5, childAt2);
                i++;
                i2 = i5;
            }
            if (i2 == 0) {
                i2++;
            }
        }
        detachViewsFromParent(i2, i);
        if (z) {
            this.mFirstPosition = i + this.mFirstPosition;
            if (isScrollCycle()) {
                this.mFirstPosition %= this.mItemCount;
            }
        }
    }

    private void detachOffScreenChildrenVertical(boolean z) {
        int i;
        int i2 = 0;
        int childCount = getChildCount();
        int i3 = this.mFirstPosition;
        if (z) {
            int paddingTop = getPaddingTop();
            int i4 = 0;
            i = 0;
            while (i4 < childCount) {
                View childAt = getChildAt(i4);
                if (childAt.getBottom() >= paddingTop) {
                    break;
                }
                this.mRecycler.put(i3 + i4, childAt);
                i4++;
                i++;
            }
            if (i == childCount) {
                i--;
            }
        } else {
            int height = getHeight() - getPaddingBottom();
            i = 0;
            for (int i5 = childCount - 1; i5 >= 0; i5--) {
                View childAt2 = getChildAt(i5);
                if (childAt2.getTop() <= height) {
                    break;
                }
                this.mRecycler.put(i3 + i5, childAt2);
                i++;
                i2 = i5;
            }
            if (i2 == 0) {
                i2++;
            }
        }
        detachViewsFromParent(i2, i);
        if (z) {
            this.mFirstPosition = i + this.mFirstPosition;
            if (isScrollCycle()) {
                this.mFirstPosition %= this.mItemCount;
            }
        }
    }

    public void scrollIntoSlots() {
        int i = 0;
        if (isOrientationVertical()) {
            scrollIntoSlotsVertical();
        } else if (isSlotInCenter()) {
            if (getChildCount() != 0 && this.mSelectedChild != null) {
                int centerOfGallery = getCenterOfGallery() - getCenterOfView(this.mSelectedChild);
                if (centerOfGallery != 0) {
                    this.mFlingRunnable.startUsingDistance(centerOfGallery);
                } else {
                    onFinishedMovement();
                }
            }
        } else if (getChildCount() != 0) {
            if (this.mFirstPosition == 0) {
                View childAt = getChildAt(0);
                if (childAt.getLeft() >= 0) {
                    i = getPaddingLeft() - childAt.getLeft();
                } else {
                    View childAt2 = getChildAt(getChildCount() - 1);
                    if (childAt2.getRight() - childAt.getLeft() < getRight() - getPaddingRight()) {
                        i = getPaddingLeft() - this.mFirstChildOffset;
                    } else if (childAt2.getRight() < getRight() - getPaddingRight()) {
                        i = (getWidth() - getPaddingRight()) - childAt2.getRight();
                    }
                }
            } else if (this.mFirstPosition + getChildCount() == this.mItemCount) {
                View childAt3 = getChildAt(getChildCount() - 1);
                if (childAt3.getRight() < getRight() - getPaddingRight()) {
                    i = (getWidth() - getPaddingRight()) - childAt3.getRight();
                }
            }
            if (i != 0) {
                this.mFlingRunnable.startUsingDistance(i);
            } else {
                onFinishedMovement();
            }
        }
    }

    private void scrollIntoSlotsVertical() {
        int i = 0;
        if (isSlotInCenter()) {
            if (getChildCount() != 0 && this.mSelectedChild != null) {
                int centerOfGallery = getCenterOfGallery() - getCenterOfView(this.mSelectedChild);
                if (centerOfGallery != 0) {
                    this.mFlingRunnable.startUsingDistance(centerOfGallery);
                } else {
                    onFinishedMovement();
                }
            }
        } else if (getChildCount() != 0) {
            if (this.mFirstPosition == 0) {
                View childAt = getChildAt(0);
                if (childAt.getTop() >= 0) {
                    i = getPaddingTop() - childAt.getTop();
                } else {
                    View childAt2 = getChildAt(getChildCount() - 1);
                    if (childAt2.getBottom() - childAt.getTop() < getBottom() - getPaddingBottom()) {
                        i = getPaddingLeft() - this.mFirstChildOffset;
                    } else if (childAt2.getBottom() < getBottom() - getPaddingBottom()) {
                        i = (getHeight() - getPaddingBottom()) - childAt2.getBottom();
                    }
                }
            } else if (this.mFirstPosition + getChildCount() == this.mItemCount) {
                View childAt3 = getChildAt(getChildCount() - 1);
                if (childAt3.getBottom() < getBottom() - getPaddingBottom()) {
                    i = (getHeight() - getPaddingBottom()) - childAt3.getBottom();
                }
            }
            if (i != 0) {
                this.mFlingRunnable.startUsingDistance(i);
            } else {
                onFinishedMovement();
            }
        }
    }

    private void onFinishedMovement() {
        if (this.mSuppressSelectionChanged) {
            this.mSuppressSelectionChanged = false;
        }
        super.selectionChanged();
        invalidate();
        onEndFling();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public void selectionChanged() {
        if (!this.mSuppressSelectionChanged) {
            super.selectionChanged();
        }
    }

    private void setSelectionToCenterChild() {
        View view = this.mSelectedChild;
        if (this.mSelectedChild != null) {
            int centerOfGallery = getCenterOfGallery();
            if (view.getLeft() > centerOfGallery || view.getRight() < centerOfGallery) {
                int i = Integer.MAX_VALUE;
                int i2 = 0;
                int childCount = getChildCount() - 1;
                while (true) {
                    if (childCount < 0) {
                        childCount = i2;
                        break;
                    }
                    View childAt = getChildAt(childCount);
                    if (childAt.getLeft() <= centerOfGallery && childAt.getRight() >= centerOfGallery) {
                        break;
                    }
                    int min = Math.min(Math.abs(childAt.getLeft() - centerOfGallery), Math.abs(childAt.getRight() - centerOfGallery));
                    if (min < i) {
                        i2 = childCount;
                    } else {
                        min = i;
                    }
                    childCount--;
                    i = min;
                }
                int i3 = this.mFirstPosition + childCount;
                if (isScrollCycle()) {
                    i3 %= this.mItemCount;
                }
                if (i3 != this.mSelectedPosition) {
                    setSelectedPositionInt(i3);
                    setNextSelectedPositionInt(i3);
                    checkSelectionChanged();
                }
            }
        }
    }

    private void setSelectionToCenterChildVertical() {
        View view = this.mSelectedChild;
        if (this.mSelectedChild != null) {
            int centerOfGallery = getCenterOfGallery();
            if (view == null || view.getTop() > centerOfGallery || view.getBottom() < centerOfGallery) {
                int i = Integer.MAX_VALUE;
                int i2 = 0;
                int childCount = getChildCount() - 1;
                while (true) {
                    if (childCount < 0) {
                        childCount = i2;
                        break;
                    }
                    View childAt = getChildAt(childCount);
                    if (childAt.getTop() <= centerOfGallery && childAt.getBottom() >= centerOfGallery) {
                        break;
                    }
                    int min = Math.min(Math.abs(childAt.getTop() - centerOfGallery), Math.abs(childAt.getBottom() - centerOfGallery));
                    if (min < i) {
                        i2 = childCount;
                    } else {
                        min = i;
                    }
                    childCount--;
                    i = min;
                }
                int i3 = this.mFirstPosition + childCount;
                if (isScrollCycle()) {
                    i3 %= this.mItemCount;
                }
                if (i3 != this.mSelectedPosition) {
                    setSelectedPositionInt(i3);
                    setNextSelectedPositionInt(i3);
                    checkSelectionChanged();
                }
            }
        }
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAbsSpinner
    void layout(int i, boolean z) {
        if (isOrientationVertical()) {
            layoutVertical(i, z);
            return;
        }
        int i2 = this.mFirstChildOffset + this.mSpinnerPadding.left;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        if (this.mItemCount == 0) {
            resetList();
            return;
        }
        if (this.mNextSelectedPosition >= 0) {
            setSelectedPositionInt(this.mNextSelectedPosition);
        }
        recycleAllViews();
        detachAllViewsFromParent();
        this.mRightMost = 0;
        this.mLeftMost = 0;
        this.mFirstPosition = this.mSelectedPosition;
        View makeAndAddView = makeAndAddView(this.mFirstPosition, 0, 0, true);
        int i3 = this.mSpacing + i2;
        if (isSlotInCenter()) {
            i3 = (((((getRight() - getLeft()) - this.mSpinnerPadding.left) - this.mSpinnerPadding.right) / 2) + i2) - (makeAndAddView.getWidth() / 2);
        }
        makeAndAddView.offsetLeftAndRight(i3);
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

    void layoutVertical(int i, boolean z) {
        if (this.mDataChanged) {
            handleDataChanged();
        }
        if (this.mItemCount == 0) {
            resetList();
            return;
        }
        if (this.mNextSelectedPosition >= 0) {
            setSelectedPositionInt(this.mNextSelectedPosition);
        }
        fillGallery();
        boolean z2 = this.mIsScrollCycleTemp;
        this.mIsScrollCycleTemp = getChildCount() < this.mItemCount;
        if (z2 != this.mIsScrollCycleTemp) {
            fillGallery();
        }
        this.mRecycler.clear();
        invalidate();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        updateSelectedItemMetadata();
    }

    private void fillGallery() {
        int i = this.mFirstChildOffset + this.mSpinnerPadding.top;
        recycleAllViews();
        detachAllViewsFromParent();
        this.mRightMost = 0;
        this.mLeftMost = 0;
        this.mFirstPosition = this.mSelectedPosition;
        View makeAndAddViewVertical = makeAndAddViewVertical(this.mFirstPosition, 0, 0, true);
        int i2 = this.mSpacing + i;
        if (isSlotInCenter()) {
            i2 = (((((getBottom() - getTop()) - this.mSpinnerPadding.top) - this.mSpinnerPadding.bottom) / 2) + i) - (makeAndAddViewVertical.getHeight() / 2);
        }
        makeAndAddViewVertical.offsetTopAndBottom(i2);
        fillToGalleryBottom();
        fillToGalleryTop();
    }

    private void fillToGalleryLeft() {
        int right;
        int i;
        if (isScrollCycle()) {
            fillToGalleryLeftCycle();
            return;
        }
        int i2 = this.mSpacing;
        int paddingLeft = getPaddingLeft();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.mFirstPosition - 1;
            right = childAt.getLeft() - i2;
        } else {
            right = (getRight() - getLeft()) - getPaddingRight();
            this.mShouldStopFling = true;
            i = 0;
        }
        while (right > paddingLeft && i >= 0) {
            View makeAndAddView = makeAndAddView(i, i - this.mSelectedPosition, right, false);
            this.mFirstPosition = i;
            right = makeAndAddView.getLeft() - i2;
            i--;
        }
    }

    private void fillToGalleryTop() {
        int bottom;
        int i;
        if (isScrollCycle()) {
            fillToGalleryTopCycle();
            return;
        }
        int i2 = this.mSpacing;
        int paddingTop = getPaddingTop();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.mFirstPosition - 1;
            bottom = childAt.getTop() - i2;
        } else {
            bottom = (getBottom() - getTop()) - getPaddingBottom();
            this.mShouldStopFling = true;
            i = 0;
        }
        while (bottom > paddingTop && i >= 0) {
            View makeAndAddViewVertical = makeAndAddViewVertical(i, i - this.mSelectedPosition, bottom, false);
            this.mFirstPosition = i;
            bottom = makeAndAddViewVertical.getTop() - i2;
            i--;
        }
    }

    private void fillToGalleryRight() {
        int i;
        int paddingLeft;
        if (isScrollCycle()) {
            fillToGalleryRightCycle();
            return;
        }
        int i2 = this.mSpacing;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i3 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i = this.mFirstPosition + childCount;
            paddingLeft = childAt.getRight() + i2;
        } else {
            i = this.mItemCount - 1;
            this.mFirstPosition = i;
            paddingLeft = getPaddingLeft();
            this.mShouldStopFling = true;
        }
        while (paddingLeft < right && i < i3) {
            paddingLeft = makeAndAddView(i, i - this.mSelectedPosition, paddingLeft, true).getRight() + i2;
            i++;
        }
    }

    private void fillToGalleryBottom() {
        int i;
        int paddingTop;
        if (isScrollCycle()) {
            fillToGalleryBottomCycle();
            return;
        }
        int i2 = this.mSpacing;
        int bottom = (getBottom() - getTop()) - getPaddingRight();
        int childCount = getChildCount();
        int i3 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i = this.mFirstPosition + childCount;
            paddingTop = childAt.getBottom() + i2;
        } else {
            i = this.mItemCount - 1;
            this.mFirstPosition = i;
            paddingTop = getPaddingTop();
            this.mShouldStopFling = true;
        }
        while (paddingTop < bottom && i < i3) {
            paddingTop = makeAndAddViewVertical(i, i - this.mSelectedPosition, paddingTop, true).getBottom() + i2;
            i++;
        }
    }

    private View makeAndAddView(int i, int i2, int i3, boolean z) {
        View view;
        if (!this.mDataChanged && (view = this.mRecycler.get(i)) != null) {
            int left = view.getLeft();
            this.mRightMost = Math.max(this.mRightMost, view.getMeasuredWidth() + left);
            this.mLeftMost = Math.min(this.mLeftMost, left);
            setUpChild(view, i2, i3, z);
            return view;
        }
        View view2 = this.mAdapter.getView(i, null, this);
        setUpChild(view2, i2, i3, z);
        return view2;
    }

    private View makeAndAddViewVertical(int i, int i2, int i3, boolean z) {
        View view;
        if (!this.mDataChanged && (view = this.mRecycler.get(i)) != null) {
            int top2 = view.getTop();
            this.mRightMost = Math.max(this.mRightMost, view.getMeasuredHeight() + top2);
            this.mLeftMost = Math.min(this.mLeftMost, top2);
            setUpChildVertical(view, i2, i3, z);
            return view;
        }
        View view2 = this.mAdapter.getView(i, null, this);
        setUpChildVertical(view2, i2, i3, z);
        return view2;
    }

    private void setUpChild(View view, int i, int i2, boolean z) {
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        LayoutParams layoutParams2 = layoutParams == null ? (LayoutParams) generateDefaultLayoutParams() : layoutParams;
        addViewInLayout(view, z ? -1 : 0, layoutParams2);
        view.setSelected(i == 0);
        view.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, layoutParams2.width), ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, layoutParams2.height));
        int calculateTop = calculateTop(view, true);
        int measuredHeight = calculateTop + view.getMeasuredHeight();
        int measuredWidth = view.getMeasuredWidth();
        if (z) {
            int i4 = measuredWidth + i2;
            i3 = i2;
            i2 = i4;
        } else {
            i3 = i2 - measuredWidth;
        }
        view.layout(i3, calculateTop, i2, measuredHeight);
    }

    private void setUpChildVertical(View view, int i, int i2, boolean z) {
        int i3;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        LayoutParams layoutParams2 = layoutParams == null ? (LayoutParams) generateDefaultLayoutParams() : layoutParams;
        addViewInLayout(view, z ? -1 : 0, layoutParams2);
        view.setSelected(i == 0);
        view.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.mSpinnerPadding.left + this.mSpinnerPadding.right, layoutParams2.width), ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.mSpinnerPadding.top + this.mSpinnerPadding.bottom, layoutParams2.height));
        int calculateLeft = calculateLeft(view, true);
        int measuredWidth = calculateLeft + view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (z) {
            int i4 = measuredHeight + i2;
            i3 = i2;
            i2 = i4;
        } else {
            i3 = i2 - measuredHeight;
        }
        view.layout(calculateLeft, i3, measuredWidth, i2);
    }

    private int calculateTop(View view, boolean z) {
        int measuredHeight = z ? getMeasuredHeight() : getHeight();
        int measuredHeight2 = z ? view.getMeasuredHeight() : view.getHeight();
        switch (this.mGravity) {
            case 16:
                return ((((measuredHeight - this.mSpinnerPadding.bottom) - this.mSpinnerPadding.top) - measuredHeight2) / 2) + this.mSpinnerPadding.top;
            case 48:
                return this.mSpinnerPadding.top;
            case 80:
                return (measuredHeight - this.mSpinnerPadding.bottom) - measuredHeight2;
            default:
                return 0;
        }
    }

    private int calculateLeft(View view, boolean z) {
        int measuredWidth = z ? getMeasuredWidth() : getWidth();
        int measuredWidth2 = z ? view.getMeasuredWidth() : view.getWidth();
        switch (this.mGravity) {
            case 1:
                return ((((measuredWidth - this.mSpinnerPadding.right) - this.mSpinnerPadding.left) - measuredWidth2) / 2) + this.mSpinnerPadding.left;
            case 2:
            case 4:
            default:
                return 0;
            case 3:
                return this.mSpinnerPadding.left;
            case 5:
                return (measuredWidth - this.mSpinnerPadding.right) - measuredWidth2;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.mGestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            onUp();
        } else if (action == 3) {
            onCancel();
        }
        return onTouchEvent;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.mDownTouchPosition >= 0) {
            if (isScrollCycle()) {
                this.mDownTouchPosition %= getCount();
            }
            if (isSlotInCenter()) {
                scrollToChild(this.mDownTouchPosition - this.mFirstPosition);
            }
            performItemSelect(this.mDownTouchPosition);
            if (this.mShouldCallbackOnUnselectedItemClick || this.mDownTouchPosition == this.mSelectedPosition) {
                performItemClick(this.mDownTouchView, this.mDownTouchPosition, this.mAdapter.getItemId(this.mDownTouchPosition));
            }
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!shouldDisableScroll()) {
            if (!this.mShouldCallbackDuringFling) {
                removeCallbacks(this.mDisableSuppressSelectionChangedRunnable);
                if (!this.mSuppressSelectionChanged) {
                    this.mSuppressSelectionChanged = true;
                }
            }
            if (isOrientationVertical()) {
                this.mFlingRunnable.startUsingVelocity((int) (-(getVelocityRatio() * f2)));
            } else {
                this.mFlingRunnable.startUsingVelocity((int) (-(getVelocityRatio() * f)));
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!shouldDisableScroll()) {
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
                trackMotionScrollVertical(((int) f2) * (-1));
            } else {
                int i = ((int) f) * (-1);
                if (canBeScrolled(i < 0)) {
                    trackMotionScroll(i);
                }
            }
            this.mIsFirstScroll = false;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.mFlingRunnable.stop(false);
        this.mDownTouchPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (this.mDownTouchPosition >= 0) {
            this.mDownTouchView = getChildAt(this.mDownTouchPosition - this.mFirstPosition);
            this.mDownTouchView.setPressed(true);
        }
        this.mIsFirstScroll = true;
        return true;
    }

    protected void onUp() {
        if (this.mFlingRunnable.mScroller.isFinished()) {
            scrollIntoSlots();
        }
        dispatchUnpress();
    }

    void onCancel() {
        onUp();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.mDownTouchPosition >= 0) {
            performHapticFeedback(0);
            dispatchLongPress(this.mDownTouchView, this.mDownTouchPosition, getItemIdAtPosition(this.mDownTouchPosition));
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    private void dispatchPress(View view) {
        if (view != null) {
            view.setPressed(true);
        }
        setPressed(true);
    }

    protected void dispatchUnpress() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount).setPressed(false);
        }
        setPressed(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetSelected(boolean z) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
        if (this.mSelectedChild != null) {
            this.mSelectedChild.setPressed(z);
        }
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.mContextMenuInfo;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView < 0) {
            return false;
        }
        return dispatchLongPress(view, positionForView, this.mAdapter.getItemId(positionForView));
    }

    @Override // android.view.View
    public boolean showContextMenu() {
        if (!isPressed() || this.mSelectedPosition < 0) {
            return false;
        }
        return dispatchLongPress(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mSelectedRowId);
    }

    private boolean dispatchLongPress(View view, int i, long j) {
        boolean onItemLongClick = this.mOnItemLongClickListener != null ? this.mOnItemLongClickListener.onItemLongClick(this, this.mDownTouchView, this.mDownTouchPosition, j) : false;
        if (!onItemLongClick) {
            this.mContextMenuInfo = new BdAdapterView.AdapterContextMenuInfo(view, i, j);
            onItemLongClick = super.showContextMenuForChild(this);
        }
        if (onItemLongClick) {
            performHapticFeedback(0);
        }
        return onItemLongClick;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return keyEvent.dispatch(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 21:
                if (movePrevious()) {
                    playSoundEffect(1);
                    return true;
                }
                return true;
            case 22:
                if (moveNext()) {
                    playSoundEffect(3);
                    return true;
                }
                return true;
            case 23:
            case 66:
                this.mReceivedInvokeKeyDown = true;
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        switch (i) {
            case 23:
            case 66:
                if (this.mReceivedInvokeKeyDown && this.mItemCount > 0) {
                    dispatchPress(this.mSelectedChild);
                    postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.wheelview2d.BdGallery.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BdGallery.this.dispatchUnpress();
                        }
                    }, ViewConfiguration.getPressedStateDuration());
                    performItemClick(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mAdapter.getItemId(this.mSelectedPosition));
                }
                this.mReceivedInvokeKeyDown = false;
                return true;
            default:
                return super.onKeyUp(i, keyEvent);
        }
    }

    boolean movePrevious() {
        return this.mItemCount > 0 && this.mSelectedPosition > 0;
    }

    boolean moveNext() {
        return this.mItemCount > 0 && this.mSelectedPosition < this.mItemCount + (-1);
    }

    private boolean scrollToChild(int i) {
        View childAt = getChildAt(i);
        if (childAt != null) {
            this.mFlingRunnable.startUsingDistance(getCenterOfGallery() - getCenterOfView(childAt));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public void setSelectedPositionInt(int i) {
        super.setSelectedPositionInt(i);
        updateSelectedItemMetadata();
    }

    private void updateSelectedItemMetadata() {
        View view = this.mSelectedChild;
        Log(" updateSelectedItemMetadata   mSelectedPosition =  " + this.mSelectedPosition + "   mFirstPosition = " + this.mFirstPosition);
        int i = this.mSelectedPosition - this.mFirstPosition;
        if (isScrollCycle() && this.mFirstPosition > this.mSelectedPosition) {
            i = (this.mItemCount - this.mFirstPosition) + this.mSelectedPosition;
        }
        View childAt = getChildAt(i);
        this.mSelectedChild = childAt;
        if (childAt != null) {
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

    public void setGravity(int i) {
        if (this.mGravity != i) {
            this.mGravity = i;
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        int i3 = this.mSelectedPosition - this.mFirstPosition;
        if (i3 >= 0) {
            if (i2 == i - 1) {
                return i3;
            }
            if (i2 >= i3) {
                return i2 + 1;
            }
            return i2;
        }
        return i2;
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z && this.mSelectedChild != null) {
            this.mSelectedChild.requestFocus(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class FlingRunnable implements Runnable {
        private int mLastFlingX;
        private int mLastFlingY;
        private Scroller mScroller;

        public FlingRunnable() {
            this.mScroller = new Scroller(BdGallery.this.getContext());
        }

        private void startCommon() {
            BdGallery.this.removeCallbacks(this);
        }

        public void startUsingVelocity(int i) {
            if (i != 0) {
                startCommon();
                if (BdGallery.this.isOrientationVertical()) {
                    int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                    this.mLastFlingY = i2;
                    this.mScroller.fling(0, i2, 0, i, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                    BdGallery.this.post(this);
                    return;
                }
                int i3 = i < 0 ? Integer.MAX_VALUE : 0;
                this.mLastFlingX = i3;
                this.mScroller.fling(i3, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                BdGallery.this.post(this);
            }
        }

        public void startUsingDistance(int i) {
            if (i != 0) {
                if (BdGallery.this.isOrientationVertical()) {
                    startCommon();
                    BdGallery.this.mScrolling = true;
                    this.mLastFlingY = 0;
                    this.mScroller.startScroll(0, 0, 0, -i, BdGallery.this.mAnimationDuration);
                    BdGallery.this.post(this);
                    return;
                }
                startCommon();
                BdGallery.this.mScrolling = true;
                this.mLastFlingX = 0;
                this.mScroller.startScroll(0, 0, -i, 0, BdGallery.this.mAnimationDuration);
                BdGallery.this.post(this);
            }
        }

        public void stop(boolean z) {
            BdGallery.this.removeCallbacks(this);
            endFling(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endFling(boolean z) {
            BdGallery.this.mScrolling = false;
            this.mScroller.forceFinished(true);
            if (z) {
                BdGallery.this.scrollIntoSlots();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            if (BdGallery.this.isOrientationVertical()) {
                runVertical();
            } else if (BdGallery.this.mItemCount != 0) {
                BdGallery.this.mShouldStopFling = false;
                Scroller scroller = this.mScroller;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = this.mLastFlingX - currX;
                if (i > 0) {
                    BdGallery.this.mDownTouchPosition = BdGallery.this.mFirstPosition;
                    max = Math.min(((BdGallery.this.getWidth() - BdGallery.this.getPaddingLeft()) - BdGallery.this.getPaddingRight()) - 1, i);
                } else {
                    BdGallery.this.mDownTouchPosition = (BdGallery.this.getChildCount() - 1) + BdGallery.this.mFirstPosition;
                    max = Math.max(-(((BdGallery.this.getWidth() - BdGallery.this.getPaddingRight()) - BdGallery.this.getPaddingLeft()) - 1), i);
                }
                boolean z = max <= 0;
                if (max != 0 && !BdGallery.this.canBeScrolled(z)) {
                    BdGallery.this.mShouldStopFling = true;
                } else {
                    BdGallery.this.trackMotionScroll(max);
                }
                if (computeScrollOffset && !BdGallery.this.mShouldStopFling) {
                    this.mLastFlingX = currX;
                    BdGallery.this.post(this);
                    return;
                }
                endFling(true);
            } else {
                endFling(true);
            }
        }

        public void runVertical() {
            int max;
            if (BdGallery.this.mItemCount != 0) {
                BdGallery.this.mShouldStopFling = false;
                Scroller scroller = this.mScroller;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currY = scroller.getCurrY();
                int i = this.mLastFlingY - currY;
                if (i > 0) {
                    BdGallery.this.mDownTouchPosition = BdGallery.this.mFirstPosition;
                    max = Math.min(((BdGallery.this.getHeight() - BdGallery.this.getPaddingTop()) - BdGallery.this.getPaddingBottom()) - 1, i);
                } else {
                    BdGallery.this.mDownTouchPosition = (BdGallery.this.getChildCount() - 1) + BdGallery.this.mFirstPosition;
                    max = Math.max(-(((BdGallery.this.getHeight() - BdGallery.this.getPaddingBottom()) - BdGallery.this.getPaddingTop()) - 1), i);
                }
                BdGallery.this.trackMotionScrollVertical(max);
                if (computeScrollOffset && !BdGallery.this.mShouldStopFling) {
                    this.mLastFlingY = currY;
                    BdGallery.this.post(this);
                    return;
                }
                endFling(true);
                return;
            }
            endFling(true);
        }
    }

    /* loaded from: classes13.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private boolean performItemSelect(int i) {
        if (i != this.mSelectedPosition) {
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            checkSelectionChanged();
            return true;
        }
        return false;
    }

    public void setFirstChildOffset(int i) {
        this.mFirstChildOffset = i;
    }

    public void setFirstPosition(int i) {
        this.mFirstPosition = i;
    }

    public void setSlotInCenter(boolean z) {
        this.mIsSlotCenter = z;
    }

    public boolean isSlotInCenter() {
        return this.mIsSlotCenter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOrientationVertical() {
        return this.mOrientation == 2;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setOnEndFlingListener(OnEndFlingListener onEndFlingListener) {
        this.mOnEndFlingListener = onEndFlingListener;
    }

    public void setDisableScroll(boolean z) {
        this.mIsDisableScroll = z;
    }

    public void setDisableScrollAnyway(boolean z) {
        this.mDisableScrollAnyway = z;
    }

    public void setScrollBarBottomMargin(int i) {
        this.mScrollBarBottomMargin = i;
    }

    @Override // android.view.View
    public void setScrollBarSize(int i) {
        this.mScrollBarSize = i;
    }

    public int getFirstPosition() {
        return this.mFirstPosition;
    }

    public int getSpacing() {
        return this.mSpacing;
    }

    public boolean isScrolling() {
        return this.mScrolling;
    }

    public int scrollGalleryItems(boolean z) {
        int min;
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
        if (min != 0 && this.mFlingRunnable != null) {
            this.mFlingRunnable.startUsingDistance(min * (-1));
        }
        return min * (-1);
    }

    public int scrollGalleryItems(int i) {
        if (this.mFlingRunnable != null) {
            this.mFlingRunnable.startUsingDistance(i * (-1));
        }
        return i * (-1);
    }

    public int getItemIndexFromPoint(Point point) {
        int i;
        int childCount = getChildCount();
        Rect rect = new Rect();
        getDrawingRect(rect);
        if (rect.contains(point.x, point.y)) {
            i = 0;
            while (i < childCount) {
                getChildAt(i).getHitRect(rect);
                if (rect.contains(point.x, point.y)) {
                    break;
                }
                i++;
            }
        }
        i = -1;
        if (i >= 0) {
            return this.mFirstPosition + i;
        }
        return -1;
    }

    protected void onEndFling() {
        if (this.mOnEndFlingListener != null && !this.mInLayout && !this.mBlockLayoutRequests) {
            this.mOnEndFlingListener.onEndFling(this);
        }
    }

    public float getVelocityRatio() {
        return this.mVelocityRatio;
    }

    public void setVelocityRatio(float f) {
        this.mVelocityRatio = f;
        if (this.mVelocityRatio < 0.5f) {
            this.mVelocityRatio = 0.5f;
        } else if (this.mVelocityRatio > 1.5f) {
            this.mVelocityRatio = 1.5f;
        }
    }

    protected boolean shouldDisableScroll() {
        if (this.mDisableScrollAnyway) {
            return true;
        }
        if (this.mIsDisableScroll && getChildCount() >= this.mItemCount) {
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getLeft() >= getLeft()) {
                View childAt2 = getChildAt(getChildCount() - 1);
                return childAt2 == null || childAt2.getRight() <= getRight();
            }
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        if (1 != motionEvent.getAction() || this.mDownTouchPosition < 0) {
            return false;
        }
        if (this.mShouldCallbackOnUnselectedItemClick || this.mDownTouchPosition == this.mSelectedPosition) {
            performItemDoubleClick(this.mDownTouchView, this.mDownTouchPosition, this.mAdapter.getItemId(this.mDownTouchPosition));
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    public boolean isPointInChild(float f, float f2) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (f >= childAt.getLeft() && f <= childAt.getRight() && f2 >= childAt.getTop() && f2 <= childAt.getBottom()) {
                return true;
            }
        }
        return false;
    }

    public void setScrollCycle(boolean z) {
        this.mIsScrollCycle = z;
    }

    public boolean isScrollCycle() {
        return this.mIsScrollCycle && this.mIsScrollCycleTemp;
    }

    public void setMaxMoveOffset(int i) {
        this.mMaxMoveOffset = i;
    }

    private long getMaxMoveOffset() {
        return this.mMaxMoveOffset;
    }

    protected void Log(String str) {
    }

    private void fillToGalleryLeftCycle() {
        int right;
        int i;
        int i2 = this.mSpacing;
        int paddingLeft = getPaddingLeft();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.mFirstPosition - 1;
            right = childAt.getLeft() - i2;
        } else {
            right = (getRight() - getLeft()) - getPaddingRight();
            this.mShouldStopFling = true;
            i = 0;
        }
        while (right > paddingLeft && i >= 0) {
            View makeAndAddView = makeAndAddView(i, i - this.mSelectedPosition, right, false);
            this.mFirstPosition = i;
            right = makeAndAddView.getLeft() - i2;
            i--;
        }
        int i3 = this.mItemCount - 1;
        while (right > paddingLeft && getChildCount() < this.mItemCount) {
            View makeAndAddView2 = makeAndAddView(i3, i3 - this.mSelectedPosition, right, false);
            this.mFirstPosition = i3;
            right = makeAndAddView2.getLeft() - i2;
            i3--;
        }
    }

    private void fillToGalleryTopCycle() {
        int bottom;
        int i;
        int i2 = this.mSpacing;
        int paddingTop = getPaddingTop();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.mFirstPosition - 1;
            bottom = childAt.getTop() - i2;
        } else {
            bottom = (getBottom() - getTop()) - getPaddingBottom();
            this.mShouldStopFling = true;
            i = 0;
        }
        while (bottom > paddingTop && i >= 0) {
            View makeAndAddViewVertical = makeAndAddViewVertical(i, i - this.mSelectedPosition, bottom, false);
            this.mFirstPosition = i;
            bottom = makeAndAddViewVertical.getTop() - i2;
            i--;
        }
        int i3 = this.mItemCount - 1;
        while (bottom > paddingTop && getChildCount() < this.mItemCount) {
            View makeAndAddViewVertical2 = makeAndAddViewVertical(i3, i3 - this.mSelectedPosition, bottom, false);
            this.mFirstPosition = i3;
            bottom = makeAndAddViewVertical2.getTop() - i2;
            i3--;
        }
    }

    private void fillToGalleryRightCycle() {
        int i;
        int paddingLeft;
        int i2 = this.mSpacing;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i3 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        Log("  fillToGalleryRightCycle mFirstPosition = " + this.mFirstPosition);
        if (childAt != null) {
            i = this.mFirstPosition + childCount;
            paddingLeft = childAt.getRight() + i2;
        } else {
            i = this.mItemCount - 1;
            this.mFirstPosition = i;
            paddingLeft = getPaddingLeft();
            this.mShouldStopFling = true;
        }
        while (paddingLeft < right && i < i3) {
            paddingLeft = makeAndAddView(i, i - this.mSelectedPosition, paddingLeft, true).getRight() + i2;
            i++;
        }
        int i4 = i % i3;
        while (paddingLeft <= right && getChildCount() < this.mItemCount) {
            paddingLeft = makeAndAddView(i4, i4 - this.mSelectedPosition, paddingLeft, true).getRight() + i2;
            i4++;
        }
    }

    private void fillToGalleryBottomCycle() {
        int i;
        int paddingTop;
        int i2 = this.mSpacing;
        int bottom = (getBottom() - getTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i3 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        Log("  fillToGalleryRightCycle mFirstPosition = " + this.mFirstPosition);
        if (childAt != null) {
            i = this.mFirstPosition + childCount;
            paddingTop = childAt.getBottom() + i2;
        } else {
            i = this.mItemCount - 1;
            this.mFirstPosition = i;
            paddingTop = getPaddingTop();
            this.mShouldStopFling = true;
        }
        while (paddingTop < bottom && i < i3) {
            paddingTop = makeAndAddViewVertical(i, i - this.mSelectedPosition, paddingTop, true).getBottom() + i2;
            i++;
        }
        int i4 = i % i3;
        while (paddingTop <= bottom && getChildCount() < this.mItemCount) {
            paddingTop = makeAndAddViewVertical(i4, i4 - this.mSelectedPosition, paddingTop, true).getBottom() + i2;
            i4++;
        }
    }
}
