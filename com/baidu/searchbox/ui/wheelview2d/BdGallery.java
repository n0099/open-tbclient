package com.baidu.searchbox.ui.wheelview2d;

import android.annotation.SuppressLint;
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
import com.baidu.searchbox.ui.wheelview2d.BdAdapterView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class BdGallery extends BdAbsSpinner implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    public static final int HORIZONTAL = 1;
    public static final int SCROLL_TO_FLING_UNCERTAINTY_TIMEOUT = 250;
    public static final String TAG = "BdGallery";
    public static final int VERTICAL = 2;
    public static final boolean localLOGV = false;
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

    /* loaded from: classes4.dex */
    public interface OnEndFlingListener {
        void onEndFling(BdGallery bdGallery);
    }

    public void Log(String str) {
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetSelected(boolean z) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    public float onStopFlingPosRatio() {
        return 0.0f;
    }

    /* loaded from: classes4.dex */
    public class FlingRunnable implements Runnable {
        public int mLastFlingX;
        public int mLastFlingY;
        public Scroller mScroller;

        public FlingRunnable() {
            this.mScroller = new Scroller(BdGallery.this.getContext());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void endFling(boolean z) {
            BdGallery.this.mScrolling = false;
            this.mScroller.forceFinished(true);
            if (z) {
                BdGallery.this.scrollIntoSlots();
            }
        }

        public void stop(boolean z) {
            BdGallery.this.removeCallbacks(this);
            endFling(z);
        }

        private void startCommon() {
            BdGallery.this.removeCallbacks(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            if (BdGallery.this.isOrientationVertical()) {
                runVertical();
                return;
            }
            BdGallery bdGallery = BdGallery.this;
            if (bdGallery.mItemCount == 0) {
                endFling(true);
                return;
            }
            boolean z = false;
            bdGallery.mShouldStopFling = false;
            Scroller scroller = this.mScroller;
            boolean computeScrollOffset = scroller.computeScrollOffset();
            int currX = scroller.getCurrX();
            int i = this.mLastFlingX - currX;
            if (i > 0) {
                BdGallery bdGallery2 = BdGallery.this;
                bdGallery2.mDownTouchPosition = bdGallery2.mFirstPosition;
                max = Math.min(((BdGallery.this.getWidth() - BdGallery.this.getPaddingLeft()) - BdGallery.this.getPaddingRight()) - 1, i);
            } else {
                BdGallery bdGallery3 = BdGallery.this;
                bdGallery3.mDownTouchPosition = bdGallery3.mFirstPosition + (BdGallery.this.getChildCount() - 1);
                max = Math.max(-(((BdGallery.this.getWidth() - BdGallery.this.getPaddingRight()) - BdGallery.this.getPaddingLeft()) - 1), i);
            }
            if (max <= 0) {
                z = true;
            }
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
        }

        public void runVertical() {
            int max;
            BdGallery bdGallery = BdGallery.this;
            if (bdGallery.mItemCount != 0) {
                bdGallery.mShouldStopFling = false;
                Scroller scroller = this.mScroller;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currY = scroller.getCurrY();
                int i = this.mLastFlingY - currY;
                if (i > 0) {
                    BdGallery bdGallery2 = BdGallery.this;
                    bdGallery2.mDownTouchPosition = bdGallery2.mFirstPosition;
                    max = Math.min(((BdGallery.this.getHeight() - BdGallery.this.getPaddingTop()) - BdGallery.this.getPaddingBottom()) - 1, i);
                } else {
                    BdGallery bdGallery3 = BdGallery.this;
                    bdGallery3.mDownTouchPosition = bdGallery3.mFirstPosition + (BdGallery.this.getChildCount() - 1);
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

        public void startUsingDistance(int i) {
            if (i == 0) {
                return;
            }
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

        public void startUsingVelocity(int i) {
            int i2;
            if (i == 0) {
                return;
            }
            startCommon();
            int i3 = Integer.MAX_VALUE;
            if (BdGallery.this.isOrientationVertical()) {
                if (i < 0) {
                    i2 = Integer.MAX_VALUE;
                } else {
                    i2 = 0;
                }
                this.mLastFlingY = i2;
                this.mScroller.fling(0, i2, 0, i, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                BdGallery.this.post(this);
                return;
            }
            if (i >= 0) {
                i3 = 0;
            }
            this.mLastFlingX = i3;
            this.mScroller.fling(i3, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
            BdGallery.this.post(this);
        }
    }

    /* loaded from: classes4.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public BdGallery(Context context) {
        this(context, null);
    }

    private void dispatchPress(View view2) {
        if (view2 != null) {
            view2.setPressed(true);
        }
        setPressed(true);
    }

    private int getCenterOfView(View view2) {
        int left;
        int width;
        if (isOrientationVertical()) {
            left = view2.getTop();
            width = view2.getHeight() / 2;
        } else {
            left = view2.getLeft();
            width = view2.getWidth() / 2;
        }
        return left + width;
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

    private boolean performItemSelect(int i) {
        if (i != this.mSelectedPosition) {
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            checkSelectionChanged();
            return true;
        }
        return false;
    }

    private boolean scrollToChild(int i) {
        View childAt = getChildAt(i);
        if (childAt != null) {
            this.mFlingRunnable.startUsingDistance(getCenterOfGallery() - getCenterOfView(childAt));
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return keyEvent.dispatch(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetPressed(boolean z) {
        View view2 = this.mSelectedChild;
        if (view2 != null) {
            view2.setPressed(z);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAbsSpinner
    public int getChildHeight(View view2) {
        return view2.getMeasuredHeight();
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        int i;
        if (1 == motionEvent.getAction() && (i = this.mDownTouchPosition) >= 0) {
            if (this.mShouldCallbackOnUnselectedItemClick || i == this.mSelectedPosition) {
                View view2 = this.mDownTouchView;
                int i2 = this.mDownTouchPosition;
                performItemDoubleClick(view2, i2, this.mAdapter.getItemId(i2));
            }
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
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

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.mDownTouchPosition < 0) {
            return;
        }
        performHapticFeedback(0);
        dispatchLongPress(this.mDownTouchView, this.mDownTouchPosition, getItemIdAtPosition(this.mDownTouchPosition));
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

    public int scrollGalleryItems(int i) {
        FlingRunnable flingRunnable = this.mFlingRunnable;
        if (flingRunnable != null) {
            flingRunnable.startUsingDistance(i * (-1));
        }
        return i * (-1);
    }

    public void setAnimationDuration(int i) {
        this.mAnimationDuration = i;
    }

    public void setCallbackDuringFling(boolean z) {
        this.mShouldCallbackDuringFling = z;
    }

    public void setCallbackOnUnselectedItemClick(boolean z) {
        this.mShouldCallbackOnUnselectedItemClick = z;
    }

    public void setDisableScroll(boolean z) {
        this.mIsDisableScroll = z;
    }

    public void setDisableScrollAnyway(boolean z) {
        this.mDisableScrollAnyway = z;
    }

    public void setFirstChildOffset(int i) {
        this.mFirstChildOffset = i;
    }

    public void setFirstPosition(int i) {
        this.mFirstPosition = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setMaxMoveOffset(int i) {
        this.mMaxMoveOffset = i;
    }

    public void setOnEndFlingListener(OnEndFlingListener onEndFlingListener) {
        this.mOnEndFlingListener = onEndFlingListener;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setScrollBarBottomMargin(int i) {
        this.mScrollBarBottomMargin = i;
    }

    @Override // android.view.View
    public void setScrollBarSize(int i) {
        this.mScrollBarSize = i;
    }

    public void setScrollCycle(boolean z) {
        this.mIsScrollCycle = z;
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public void setSelectedPositionInt(int i) {
        super.setSelectedPositionInt(i);
        updateSelectedItemMetadata();
    }

    public void setSlotInCenter(boolean z) {
        this.mIsSlotCenter = z;
    }

    public void setSpacing(int i) {
        this.mSpacing = i;
    }

    public void setUnselectedAlpha(float f) {
        this.mUnselectedAlpha = f;
    }

    public void setVelocityRatio(float f) {
        this.mVelocityRatio = f;
        if (f < 0.5f) {
            this.mVelocityRatio = 0.5f;
        } else if (f > 1.5f) {
            this.mVelocityRatio = 1.5f;
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view2) {
        int positionForView = getPositionForView(view2);
        if (positionForView < 0) {
            return false;
        }
        return dispatchLongPress(view2, positionForView, this.mAdapter.getItemId(positionForView));
    }

    public BdGallery(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.obfuscated_res_0x7f040306);
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i, int i2) {
        int i3 = this.mSelectedPosition - this.mFirstPosition;
        if (i3 < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return i3;
        }
        if (i2 >= i3) {
            return i2 + 1;
        }
        return i2;
    }

    public int getLimitedMotionScrollAmount(boolean z, int i) {
        int i2;
        if (z) {
            i2 = this.mItemCount - 1;
        } else {
            i2 = 0;
        }
        View childAt = getChildAt(i2 - this.mFirstPosition);
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
        int i3 = centerOfGallery - centerOfView;
        if (z) {
            return Math.max(i3, i);
        }
        return Math.min(i3, i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 66) {
            switch (i) {
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
            return super.onKeyDown(i, keyEvent);
        }
        this.mReceivedInvokeKeyDown = true;
        return super.onKeyDown(i, keyEvent);
    }

    @SuppressLint({"CustomViewStyleable"})
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
        GestureDetector gestureDetector = new GestureDetector(context, this);
        this.mGestureDetector = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.android.common.ui.style.R.styleable.Gallery, i, 0);
        int i2 = obtainStyledAttributes.getInt(1, -1);
        if (i2 >= 0) {
            setGravity(i2);
        }
        int i3 = obtainStyledAttributes.getInt(0, -1);
        if (i3 > 0) {
            setAnimationDuration(i3);
        }
        setSpacing(obtainStyledAttributes.getDimensionPixelOffset(2, 0));
        setUnselectedAlpha(obtainStyledAttributes.getFloat(4, 0.5f));
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

    private int calculateLeft(View view2, boolean z) {
        int width;
        int width2;
        if (z) {
            width = getMeasuredWidth();
        } else {
            width = getWidth();
        }
        if (z) {
            width2 = view2.getMeasuredWidth();
        } else {
            width2 = view2.getWidth();
        }
        int i = this.mGravity;
        if (i != 1) {
            if (i != 3) {
                if (i != 5) {
                    return 0;
                }
                return (width - this.mSpinnerPadding.right) - width2;
            }
            return this.mSpinnerPadding.left;
        }
        Rect rect = this.mSpinnerPadding;
        int i2 = rect.left;
        return i2 + ((((width - rect.right) - i2) - width2) / 2);
    }

    private int calculateTop(View view2, boolean z) {
        int height;
        int height2;
        if (z) {
            height = getMeasuredHeight();
        } else {
            height = getHeight();
        }
        if (z) {
            height2 = view2.getMeasuredHeight();
        } else {
            height2 = view2.getHeight();
        }
        int i = this.mGravity;
        if (i != 16) {
            if (i != 48) {
                if (i != 80) {
                    return 0;
                }
                return (height - this.mSpinnerPadding.bottom) - height2;
            }
            return this.mSpinnerPadding.top;
        }
        Rect rect = this.mSpinnerPadding;
        int i2 = rect.top;
        return i2 + ((((height - rect.bottom) - i2) - height2) / 2);
    }

    @Override // android.view.ViewGroup
    public boolean getChildStaticTransformation(View view2, Transformation transformation) {
        float f;
        transformation.clear();
        if (view2 == this.mSelectedChild) {
            f = 1.0f;
        } else {
            f = this.mUnselectedAlpha;
        }
        transformation.setAlpha(f);
        Log(" getChildStaticTransformation   mSelectedPosition =  " + this.mSelectedPosition + "   mFirstPosition = " + this.mFirstPosition + "     mSelectedChild = " + this.mSelectedChild);
        return true;
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

    public void layoutVertical(int i, boolean z) {
        boolean z2;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        if (this.mItemCount == 0) {
            resetList();
            return;
        }
        int i2 = this.mNextSelectedPosition;
        if (i2 >= 0) {
            setSelectedPositionInt(i2);
        }
        fillGallery();
        boolean z3 = this.mIsScrollCycleTemp;
        if (getChildCount() < this.mItemCount) {
            z2 = true;
        } else {
            z2 = false;
        }
        this.mIsScrollCycleTemp = z2;
        if (z3 != z2) {
            fillGallery();
        }
        this.mRecycler.clear();
        invalidate();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        updateSelectedItemMetadata();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 23 && i != 66) {
            return super.onKeyUp(i, keyEvent);
        }
        if (this.mReceivedInvokeKeyDown && this.mItemCount > 0) {
            dispatchPress(this.mSelectedChild);
            postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.wheelview2d.BdGallery.2
                @Override // java.lang.Runnable
                public void run() {
                    BdGallery.this.dispatchUnpress();
                }
            }, ViewConfiguration.getPressedStateDuration());
            View childAt = getChildAt(this.mSelectedPosition - this.mFirstPosition);
            int i2 = this.mSelectedPosition;
            performItemClick(childAt, i2, this.mAdapter.getItemId(i2));
        }
        this.mReceivedInvokeKeyDown = false;
        return true;
    }

    private void detachOffScreenChildren(boolean z) {
        int i;
        int childCount = getChildCount();
        int i2 = this.mFirstPosition;
        int i3 = 0;
        if (z) {
            int paddingLeft = getPaddingLeft();
            i = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getRight() >= paddingLeft) {
                    break;
                }
                i++;
                this.mRecycler.put(i2 + i4, childAt);
            }
            if (i == childCount) {
                i--;
            }
        } else {
            int width = getWidth() - getPaddingRight();
            int i5 = 0;
            int i6 = 0;
            for (int i7 = childCount - 1; i7 >= 0; i7--) {
                View childAt2 = getChildAt(i7);
                if (childAt2.getLeft() <= width) {
                    break;
                }
                i5++;
                this.mRecycler.put(i2 + i7, childAt2);
                i6 = i7;
            }
            if (i6 == 0) {
                i3 = i6 + 1;
                i = i5;
            } else {
                i = i5;
                i3 = i6;
            }
        }
        detachViewsFromParent(i3, i);
        if (z) {
            this.mFirstPosition += i;
            if (isScrollCycle()) {
                this.mFirstPosition %= this.mItemCount;
            }
        }
    }

    private void detachOffScreenChildrenVertical(boolean z) {
        int i;
        int childCount = getChildCount();
        int i2 = this.mFirstPosition;
        int i3 = 0;
        if (z) {
            int paddingTop = getPaddingTop();
            i = 0;
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (childAt.getBottom() >= paddingTop) {
                    break;
                }
                i++;
                this.mRecycler.put(i2 + i4, childAt);
            }
            if (i == childCount) {
                i--;
            }
        } else {
            int height = getHeight() - getPaddingBottom();
            int i5 = 0;
            int i6 = 0;
            for (int i7 = childCount - 1; i7 >= 0; i7--) {
                View childAt2 = getChildAt(i7);
                if (childAt2.getTop() <= height) {
                    break;
                }
                i5++;
                this.mRecycler.put(i2 + i7, childAt2);
                i6 = i7;
            }
            if (i6 == 0) {
                i3 = i6 + 1;
                i = i5;
            } else {
                i = i5;
                i3 = i6;
            }
        }
        detachViewsFromParent(i3, i);
        if (z) {
            this.mFirstPosition += i;
            if (isScrollCycle()) {
                this.mFirstPosition %= this.mItemCount;
            }
        }
    }

    public boolean canBeScrolled(boolean z) {
        int i;
        if (z) {
            i = this.mItemCount - 1;
        } else {
            i = 0;
        }
        View childAt = getChildAt(i - this.mFirstPosition);
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

    public int scrollGalleryItems(boolean z) {
        int i;
        int min;
        FlingRunnable flingRunnable;
        int i2;
        int i3 = 0;
        if (getChildCount() == 0) {
            return 0;
        }
        if (z) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt != null) {
                i2 = childAt.getRight();
            } else {
                i2 = 0;
            }
            min = Math.max((i2 - getRight()) + getPaddingRight(), 0);
            if (min == 0 && this.mFirstPosition + getChildCount() != this.mItemCount) {
                if (childAt != null) {
                    i3 = childAt.getWidth();
                }
                min += i3;
            }
        } else {
            View childAt2 = getChildAt(0);
            if (childAt2 != null) {
                i = childAt2.getLeft();
            } else {
                i = 0;
            }
            min = Math.min(i - getPaddingLeft(), 0);
            if (min == 0 && this.mFirstPosition != 0) {
                if (childAt2 != null) {
                    i3 = childAt2.getWidth();
                }
                min -= i3;
            }
        }
        if (min != 0 && (flingRunnable = this.mFlingRunnable) != null) {
            flingRunnable.startUsingDistance(min * (-1));
        }
        return min * (-1);
    }

    private boolean dispatchLongPress(View view2, int i, long j) {
        boolean z;
        BdAdapterView.OnItemLongClickListener onItemLongClickListener = this.mOnItemLongClickListener;
        if (onItemLongClickListener != null) {
            z = onItemLongClickListener.onItemLongClick(this, this.mDownTouchView, this.mDownTouchPosition, j);
        } else {
            z = false;
        }
        if (!z) {
            this.mContextMenuInfo = new BdAdapterView.AdapterContextMenuInfo(view2, i, j);
            z = super.showContextMenuForChild(this);
        }
        if (z) {
            performHapticFeedback(0);
        }
        return z;
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        View view2;
        super.onFocusChanged(z, i, rect);
        if (z && (view2 = this.mSelectedChild) != null) {
            view2.requestFocus(i);
        }
    }

    private void fillGallery() {
        int i = this.mSpinnerPadding.top + this.mFirstChildOffset;
        recycleAllViews();
        detachAllViewsFromParent();
        this.mRightMost = 0;
        this.mLeftMost = 0;
        int i2 = this.mSelectedPosition;
        this.mFirstPosition = i2;
        View makeAndAddViewVertical = makeAndAddViewVertical(i2, 0, 0, true);
        int i3 = this.mSpacing + i;
        if (isSlotInCenter()) {
            int bottom = getBottom() - getTop();
            Rect rect = this.mSpinnerPadding;
            i3 = (i + (((bottom - rect.top) - rect.bottom) / 2)) - (makeAndAddViewVertical.getHeight() / 2);
        }
        makeAndAddViewVertical.offsetTopAndBottom(i3);
        fillToGalleryBottom();
        fillToGalleryTop();
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

    private void updateSelectedItemMetadata() {
        int i;
        int i2;
        View view2 = this.mSelectedChild;
        Log(" updateSelectedItemMetadata   mSelectedPosition =  " + this.mSelectedPosition + "   mFirstPosition = " + this.mFirstPosition);
        int i3 = this.mSelectedPosition - this.mFirstPosition;
        if (isScrollCycle() && (i = this.mFirstPosition) > (i2 = this.mSelectedPosition)) {
            i3 = (this.mItemCount - i) + i2;
        }
        View childAt = getChildAt(i3);
        this.mSelectedChild = childAt;
        if (childAt == null) {
            return;
        }
        childAt.setSelected(true);
        childAt.setFocusable(true);
        if (hasFocus()) {
            childAt.requestFocus();
        }
        if (view2 != null) {
            view2.setSelected(false);
            view2.setFocusable(false);
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        boolean z;
        int childCount = getChildCount();
        boolean z2 = false;
        if (childCount <= 0) {
            return 0;
        }
        int i = childCount * 100;
        View childAt = getChildAt(0);
        int left = childAt.getLeft();
        int width = childAt.getWidth();
        if (width > 0) {
            if (this.mFirstPosition == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z || left <= 0) {
                i += (left * 100) / width;
            }
        }
        View childAt2 = getChildAt(childCount - 1);
        int right = childAt2.getRight();
        int width2 = childAt2.getWidth();
        if (width2 > 0) {
            if (this.mFirstPosition + childCount == this.mItemCount) {
                z2 = true;
            }
            if (!z2 || right >= getWidth()) {
                return i - (((right - getWidth()) * 100) / width2);
            }
            return i;
        }
        return i;
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

    private void setSelectionToCenterChild() {
        View view2 = this.mSelectedChild;
        if (view2 == null) {
            return;
        }
        int centerOfGallery = getCenterOfGallery();
        if (view2.getLeft() <= centerOfGallery && view2.getRight() >= centerOfGallery) {
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        int childCount = getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                break;
            }
            View childAt = getChildAt(childCount);
            if (childAt.getLeft() <= centerOfGallery && childAt.getRight() >= centerOfGallery) {
                i2 = childCount;
                break;
            }
            int min = Math.min(Math.abs(childAt.getLeft() - centerOfGallery), Math.abs(childAt.getRight() - centerOfGallery));
            if (min < i) {
                i2 = childCount;
                i = min;
            }
            childCount--;
        }
        int i3 = this.mFirstPosition + i2;
        if (isScrollCycle()) {
            i3 %= this.mItemCount;
        }
        if (i3 != this.mSelectedPosition) {
            setSelectedPositionInt(i3);
            setNextSelectedPositionInt(i3);
            checkSelectionChanged();
        }
    }

    private void setSelectionToCenterChildVertical() {
        View view2 = this.mSelectedChild;
        if (view2 == null) {
            return;
        }
        int centerOfGallery = getCenterOfGallery();
        if (view2 != null && view2.getTop() <= centerOfGallery && view2.getBottom() >= centerOfGallery) {
            return;
        }
        int i = Integer.MAX_VALUE;
        int i2 = 0;
        int childCount = getChildCount() - 1;
        while (true) {
            if (childCount < 0) {
                break;
            }
            View childAt = getChildAt(childCount);
            if (childAt.getTop() <= centerOfGallery && childAt.getBottom() >= centerOfGallery) {
                i2 = childCount;
                break;
            }
            int min = Math.min(Math.abs(childAt.getTop() - centerOfGallery), Math.abs(childAt.getBottom() - centerOfGallery));
            if (min < i) {
                i2 = childCount;
                i = min;
            }
            childCount--;
        }
        int i3 = this.mFirstPosition + i2;
        if (isScrollCycle()) {
            i3 %= this.mItemCount;
        }
        if (i3 != this.mSelectedPosition) {
            setSelectedPositionInt(i3);
            setNextSelectedPositionInt(i3);
            checkSelectionChanged();
        }
    }

    private long getMaxMoveOffset() {
        return this.mMaxMoveOffset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isOrientationVertical() {
        if (this.mOrientation == 2) {
            return true;
        }
        return false;
    }

    private void onFinishedMovement() {
        if (this.mSuppressSelectionChanged) {
            this.mSuppressSelectionChanged = false;
        }
        super.selectionChanged();
        invalidate();
        onEndFling();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
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
    public int computeHorizontalScrollRange() {
        return Math.max((((this.mItemCount + 1) - 1) / 1) * 100, 0);
    }

    public void dispatchUnpress() {
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
        return new LayoutParams(-2, -2);
    }

    public int getCenterOfGallery() {
        int width;
        int paddingLeft;
        if (isOrientationVertical()) {
            width = ((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2;
            paddingLeft = getPaddingTop();
        } else {
            width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2;
            paddingLeft = getPaddingLeft();
        }
        return width + paddingLeft;
    }

    @Override // android.view.View
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.mContextMenuInfo;
    }

    public int getFirstPosition() {
        return this.mFirstPosition;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getSpacing() {
        return this.mSpacing;
    }

    public float getVelocityRatio() {
        return this.mVelocityRatio;
    }

    public boolean isScrollCycle() {
        if (this.mIsScrollCycle && this.mIsScrollCycleTemp) {
            return true;
        }
        return false;
    }

    public boolean isScrolling() {
        return this.mScrolling;
    }

    public boolean isSlotInCenter() {
        return this.mIsSlotCenter;
    }

    public boolean moveNext() {
        int i = this.mItemCount;
        if (i > 0 && this.mSelectedPosition < i - 1) {
            return true;
        }
        return false;
    }

    public boolean movePrevious() {
        if (this.mItemCount > 0 && this.mSelectedPosition > 0) {
            return true;
        }
        return false;
    }

    public void onCancel() {
        onUp();
    }

    public void onEndFling() {
        OnEndFlingListener onEndFlingListener = this.mOnEndFlingListener;
        if (onEndFlingListener != null && !this.mInLayout && !((BdAbsSpinner) this).mBlockLayoutRequests) {
            onEndFlingListener.onEndFling(this);
        }
    }

    public void onUp() {
        if (this.mFlingRunnable.mScroller.isFinished()) {
            scrollIntoSlots();
        }
        dispatchUnpress();
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView
    public void selectionChanged() {
        if (!this.mSuppressSelectionChanged) {
            super.selectionChanged();
        }
    }

    @Override // android.view.View
    public boolean showContextMenu() {
        int i;
        if (isPressed() && (i = this.mSelectedPosition) >= 0) {
            return dispatchLongPress(getChildAt(i - this.mFirstPosition), this.mSelectedPosition, this.mSelectedRowId);
        }
        return false;
    }

    private float getStopFlingPosition() {
        float width;
        int paddingLeft;
        if (isOrientationVertical()) {
            width = ((getHeight() - getPaddingTop()) - getPaddingBottom()) * onStopFlingPosRatio();
            paddingLeft = getPaddingTop();
        } else {
            width = ((getWidth() - getPaddingLeft()) - getPaddingRight()) * onStopFlingPosRatio();
            paddingLeft = getPaddingLeft();
        }
        return width + paddingLeft;
    }

    public boolean shouldDisableScroll() {
        if (this.mDisableScrollAnyway) {
            return true;
        }
        if (!this.mIsDisableScroll || getChildCount() < this.mItemCount) {
            return false;
        }
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getLeft() < getLeft()) {
            return false;
        }
        View childAt2 = getChildAt(getChildCount() - 1);
        if (childAt2 == null || childAt2.getRight() <= getRight()) {
            return true;
        }
        return false;
    }

    private View makeAndAddView(int i, int i2, int i3, boolean z) {
        View view2;
        if (!this.mDataChanged && (view2 = this.mRecycler.get(i)) != null) {
            int left = view2.getLeft();
            this.mRightMost = Math.max(this.mRightMost, view2.getMeasuredWidth() + left);
            this.mLeftMost = Math.min(this.mLeftMost, left);
            setUpChild(view2, i2, i3, z);
            return view2;
        }
        View view3 = this.mAdapter.getView(i, null, this);
        setUpChild(view3, i2, i3, z);
        return view3;
    }

    private View makeAndAddViewVertical(int i, int i2, int i3, boolean z) {
        View view2;
        if (!this.mDataChanged && (view2 = this.mRecycler.get(i)) != null) {
            int top = view2.getTop();
            this.mRightMost = Math.max(this.mRightMost, view2.getMeasuredHeight() + top);
            this.mLeftMost = Math.min(this.mLeftMost, top);
            setUpChildVertical(view2, i2, i3, z);
            return view2;
        }
        View view3 = this.mAdapter.getView(i, null, this);
        setUpChildVertical(view3, i2, i3, z);
        return view3;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
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
            this.mFlingRunnable.startUsingVelocity((int) (-(f2 * getVelocityRatio())));
        } else {
            this.mFlingRunnable.startUsingVelocity((int) (-(f * getVelocityRatio())));
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void scrollIntoSlotsVertical() {
        int height;
        int bottom;
        int height2;
        int bottom2;
        View view2;
        if (isSlotInCenter()) {
            if (getChildCount() != 0 && (view2 = this.mSelectedChild) != null) {
                int centerOfGallery = getCenterOfGallery() - getCenterOfView(view2);
                if (centerOfGallery != 0) {
                    this.mFlingRunnable.startUsingDistance(centerOfGallery);
                } else {
                    onFinishedMovement();
                }
            }
        } else if (getChildCount() == 0) {
        } else {
            int i = this.mFirstPosition;
            int i2 = 0;
            if (i == 0) {
                View childAt = getChildAt(0);
                if (childAt.getTop() >= 0) {
                    height = getPaddingTop();
                    bottom = childAt.getTop();
                    i2 = height - bottom;
                    if (i2 == 0) {
                        this.mFlingRunnable.startUsingDistance(i2);
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
                    if (i2 == 0) {
                    }
                }
                i2 = height2 - bottom2;
                if (i2 == 0) {
                }
            } else {
                if (i + getChildCount() == this.mItemCount) {
                    View childAt3 = getChildAt(getChildCount() - 1);
                    if (childAt3.getBottom() < getBottom() - getPaddingBottom()) {
                        height = getHeight() - getPaddingBottom();
                        bottom = childAt3.getBottom();
                        i2 = height - bottom;
                    }
                }
                if (i2 == 0) {
                }
            }
        }
    }

    private void setUpChild(View view2, int i, int i2, boolean z) {
        int i3;
        int i4;
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LayoutParams) generateDefaultLayoutParams();
        }
        boolean z2 = false;
        if (z) {
            i3 = -1;
        } else {
            i3 = 0;
        }
        addViewInLayout(view2, i3, layoutParams);
        if (i == 0) {
            z2 = true;
        }
        view2.setSelected(z2);
        int i5 = this.mHeightMeasureSpec;
        Rect rect = this.mSpinnerPadding;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, rect.top + rect.bottom, ((ViewGroup.LayoutParams) layoutParams).height);
        int i6 = this.mWidthMeasureSpec;
        Rect rect2 = this.mSpinnerPadding;
        view2.measure(ViewGroup.getChildMeasureSpec(i6, rect2.left + rect2.right, ((ViewGroup.LayoutParams) layoutParams).width), childMeasureSpec);
        int calculateTop = calculateTop(view2, true);
        int measuredHeight = view2.getMeasuredHeight() + calculateTop;
        int measuredWidth = view2.getMeasuredWidth();
        if (z) {
            i4 = measuredWidth + i2;
        } else {
            int i7 = i2 - measuredWidth;
            i4 = i2;
            i2 = i7;
        }
        view2.layout(i2, calculateTop, i4, measuredHeight);
    }

    private void setUpChildVertical(View view2, int i, int i2, boolean z) {
        int i3;
        int i4;
        LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LayoutParams) generateDefaultLayoutParams();
        }
        boolean z2 = false;
        if (z) {
            i3 = -1;
        } else {
            i3 = 0;
        }
        addViewInLayout(view2, i3, layoutParams);
        if (i == 0) {
            z2 = true;
        }
        view2.setSelected(z2);
        int i5 = this.mHeightMeasureSpec;
        Rect rect = this.mSpinnerPadding;
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, rect.top + rect.bottom, ((ViewGroup.LayoutParams) layoutParams).height);
        int i6 = this.mWidthMeasureSpec;
        Rect rect2 = this.mSpinnerPadding;
        view2.measure(ViewGroup.getChildMeasureSpec(i6, rect2.left + rect2.right, ((ViewGroup.LayoutParams) layoutParams).width), childMeasureSpec);
        int calculateLeft = calculateLeft(view2, true);
        int measuredWidth = view2.getMeasuredWidth() + calculateLeft;
        int measuredHeight = view2.getMeasuredHeight();
        if (z) {
            i4 = measuredHeight + i2;
        } else {
            int i7 = i2 - measuredHeight;
            i4 = i2;
            i2 = i7;
        }
        view2.layout(calculateLeft, i2, measuredWidth, i4);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        boolean z;
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
            trackMotionScrollVertical(((int) f2) * (-1));
        } else {
            int i = ((int) f) * (-1);
            if (i < 0) {
                z = true;
            } else {
                z = false;
            }
            if (canBeScrolled(z)) {
                trackMotionScroll(i);
            }
        }
        this.mIsFirstScroll = false;
        return true;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
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
        if (i < 0) {
            return -1;
        }
        return i + this.mFirstPosition;
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
                View view2 = this.mDownTouchView;
                int i = this.mDownTouchPosition;
                performItemClick(view2, i, this.mAdapter.getItemId(i));
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // android.view.View
    public void invalidate(int i, int i2, int i3, int i4) {
        super.invalidate(i, i2 - (this.mScrollBarSize + this.mScrollBarBottomMargin), i3, i4);
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAbsSpinner
    public void layout(int i, boolean z) {
        if (isOrientationVertical()) {
            layoutVertical(i, z);
            return;
        }
        int i2 = this.mSpinnerPadding.left + this.mFirstChildOffset;
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
        recycleAllViews();
        detachAllViewsFromParent();
        boolean z2 = false;
        this.mRightMost = 0;
        this.mLeftMost = 0;
        int i4 = this.mSelectedPosition;
        this.mFirstPosition = i4;
        View makeAndAddView = makeAndAddView(i4, 0, 0, true);
        int i5 = this.mSpacing + i2;
        if (isSlotInCenter()) {
            int right = getRight() - getLeft();
            Rect rect = this.mSpinnerPadding;
            i5 = (i2 + (((right - rect.left) - rect.right) / 2)) - (makeAndAddView.getWidth() / 2);
        }
        makeAndAddView.offsetLeftAndRight(i5);
        fillToGalleryRight();
        fillToGalleryLeft();
        this.mRecycler.clear();
        invalidate();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        updateSelectedItemMetadata();
        if (getChildCount() < this.mItemCount) {
            z2 = true;
        }
        this.mIsScrollCycleTemp = z2;
    }

    public void onDrawHorizontalScrollBar(Canvas canvas, Drawable drawable, int i, int i2, int i3, int i4) {
        int i5 = i4 - this.mScrollBarBottomMargin;
        drawable.setBounds(i, i5 - this.mScrollBarSize, i3, i5);
        drawable.draw(canvas);
    }

    @Override // com.baidu.searchbox.ui.wheelview2d.BdAdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mInLayout = true;
        layout(0, false);
        this.mInLayout = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void scrollIntoSlots() {
        int width;
        int right;
        int width2;
        int right2;
        View view2;
        if (isOrientationVertical()) {
            scrollIntoSlotsVertical();
        } else if (isSlotInCenter()) {
            if (getChildCount() != 0 && (view2 = this.mSelectedChild) != null) {
                int centerOfGallery = getCenterOfGallery() - getCenterOfView(view2);
                if (centerOfGallery != 0) {
                    this.mFlingRunnable.startUsingDistance(centerOfGallery);
                } else {
                    onFinishedMovement();
                }
            }
        } else if (getChildCount() == 0) {
        } else {
            int i = this.mFirstPosition;
            int i2 = 0;
            if (i == 0) {
                View childAt = getChildAt(0);
                if (childAt.getLeft() >= 0) {
                    width = getPaddingLeft();
                    right = childAt.getLeft();
                    i2 = width - right;
                    if (i2 == 0) {
                        this.mFlingRunnable.startUsingDistance(i2);
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
                    if (i2 == 0) {
                    }
                }
                i2 = width2 - right2;
                if (i2 == 0) {
                }
            } else {
                if (i + getChildCount() == this.mItemCount) {
                    View childAt3 = getChildAt(getChildCount() - 1);
                    if (childAt3.getRight() < getRight() - getPaddingRight()) {
                        width = getWidth() - getPaddingRight();
                        right = childAt3.getRight();
                        i2 = width - right;
                    }
                }
                if (i2 == 0) {
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void trackMotionScroll(int i) {
        boolean z;
        if (getChildCount() == 0) {
            return;
        }
        if (i < 0) {
            z = true;
        } else {
            z = false;
        }
        if (isSlotInCenter()) {
            if ((!isScrollCycle() || getChildCount() >= this.mItemCount) && getLimitedMotionScrollAmount(z, i) != i) {
                this.mFlingRunnable.endFling(false);
                onFinishedMovement();
            }
            if (!canBeScrolled(z)) {
                return;
            }
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
        } else if (z) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt != null && childAt.getRight() < getStopFlingPosition()) {
                FlingRunnable flingRunnable = this.mFlingRunnable;
                if (flingRunnable != null) {
                    flingRunnable.stop(false);
                }
                i = 0;
            }
            offsetChildrenLeftAndRight(i);
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
                i = 0;
            }
            offsetChildrenLeftAndRight(i);
            detachOffScreenChildren(z);
            if (!z) {
            }
            this.mRecycler.clear();
            setSelectionToCenterChild();
            awakenScrollBars();
            invalidate();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void trackMotionScrollVertical(int i) {
        boolean z;
        if (getChildCount() == 0) {
            return;
        }
        if (i < 0) {
            z = true;
        } else {
            z = false;
        }
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
        } else if (z) {
            View childAt = getChildAt(getChildCount() - 1);
            if (childAt != null && childAt.getRight() < getStopFlingPosition()) {
                FlingRunnable flingRunnable = this.mFlingRunnable;
                if (flingRunnable != null) {
                    flingRunnable.stop(false);
                }
                i = 0;
            }
            offsetChildrenTopAndBottom(i);
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
                i = 0;
            }
            offsetChildrenTopAndBottom(i);
            detachOffScreenChildrenVertical(z);
            if (!z) {
            }
            this.mRecycler.clear();
            setSelectionToCenterChild();
            awakenScrollBars();
            invalidate();
        }
    }
}
