package com.baidu.adp.widget.refresh;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.NestedScrollingParentHelper;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
/* loaded from: classes.dex */
public class BdSwipeRefreshLayout extends ViewGroup implements NestedScrollingChild, NestedScrollingParent {
    d axb;
    b axc;
    private c axd;
    private int mActivePointerId;
    private final Animation mAnimateToCorrectPosition;
    private final Animation mAnimateToStartPosition;
    private int mCircleDiameter;
    private int mCircleViewIndex;
    int mCurrentTargetOffsetTop;
    private final DecelerateInterpolator mDecelerateInterpolator;
    protected int mFrom;
    private float mInitialDownY;
    private float mInitialMotionY;
    private boolean mIsBeingDragged;
    private int mMediumAnimationDuration;
    private boolean mNestedScrollInProgress;
    private final NestedScrollingChildHelper mNestedScrollingChildHelper;
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;
    boolean mNotify;
    protected int mOriginalOffsetTop;
    private final int[] mParentOffsetInWindow;
    private final int[] mParentScrollConsumed;
    private Animation.AnimationListener mRefreshListener;
    boolean mRefreshing;
    private boolean mReturningToStart;
    boolean mScale;
    private Animation mScaleDownAnimation;
    private Animation mScaleDownToStartAnimation;
    int mSpinnerOffsetEnd;
    float mStartingScale;
    private int mState;
    private View mTarget;
    private float mTotalDragDistance;
    private float mTotalUnconsumed;
    private int mTouchSlop;
    boolean mUsingCustomStart;
    private static final String LOG_TAG = BdSwipeRefreshLayout.class.getSimpleName();
    private static final int[] LAYOUT_ATTRS = {16842766};

    /* loaded from: classes.dex */
    public interface b {
        View getView();

        void k(float f, float f2);

        void onFinish();

        void onPullToRefresh();

        void onRefreshing();

        void onReleaseToRefresh();

        void sB();

        long sC();
    }

    /* loaded from: classes.dex */
    public interface c {
        boolean a(BdSwipeRefreshLayout bdSwipeRefreshLayout, View view);
    }

    /* loaded from: classes.dex */
    public interface d {
        void onRefresh();
    }

    void reset() {
        finish();
        this.axc.getView().setVisibility(8);
        setColorViewAlpha(255);
        if (this.mScale) {
            setAnimationProgress(0.0f);
        } else {
            a(this.mOriginalOffsetTop - this.mCurrentTargetOffsetTop, true, "reset");
        }
        this.mCurrentTargetOffsetTop = this.axc.getView().getTop();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!z) {
            reset();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        reset();
    }

    @SuppressLint({"NewApi"})
    private void setColorViewAlpha(int i) {
        if (this.axc != null && this.axc.getView() != null && this.axc.getView().getBackground() != null) {
            this.axc.getView().getBackground().setAlpha(i);
        }
    }

    public int getProgressViewStartOffset() {
        return this.mOriginalOffsetTop;
    }

    public int getProgressViewEndOffset() {
        return this.mSpinnerOffsetEnd;
    }

    public void setSize(int i) {
        if ((i == 0 || i == 1) && (this.axc instanceof a)) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.mCircleDiameter = (int) (displayMetrics.density * 56.0f);
            } else {
                this.mCircleDiameter = (int) (displayMetrics.density * 61.0f);
            }
            ((a) this.axc).setSize(i);
        }
    }

    public BdSwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public BdSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mState = 4;
        this.mRefreshing = false;
        this.mTotalDragDistance = -1.0f;
        this.mParentScrollConsumed = new int[2];
        this.mParentOffsetInWindow = new int[2];
        this.mActivePointerId = -1;
        this.mCircleViewIndex = -1;
        this.mRefreshListener = new Animation.AnimationListener() { // from class: com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            @SuppressLint({"NewApi"})
            public void onAnimationEnd(Animation animation) {
                if (BdSwipeRefreshLayout.this.mRefreshing) {
                    BdSwipeRefreshLayout.this.sx();
                    BdSwipeRefreshLayout.this.mCurrentTargetOffsetTop = BdSwipeRefreshLayout.this.axc.getView().getTop();
                    return;
                }
                BdSwipeRefreshLayout.this.reset();
            }
        };
        this.mAnimateToCorrectPosition = new Animation() { // from class: com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.4
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                int i;
                if (!BdSwipeRefreshLayout.this.mUsingCustomStart) {
                    i = BdSwipeRefreshLayout.this.mSpinnerOffsetEnd - Math.abs(BdSwipeRefreshLayout.this.mOriginalOffsetTop);
                } else {
                    i = BdSwipeRefreshLayout.this.mSpinnerOffsetEnd;
                }
                BdSwipeRefreshLayout.this.a((((int) ((i - BdSwipeRefreshLayout.this.mFrom) * f)) + BdSwipeRefreshLayout.this.mFrom) - BdSwipeRefreshLayout.this.axc.getView().getTop(), false, "AnimateToCorrectPosition");
            }
        };
        this.mAnimateToStartPosition = new Animation() { // from class: com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.5
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                BdSwipeRefreshLayout.this.moveToStart(f);
            }
        };
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.mMediumAnimationDuration = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.mDecelerateInterpolator = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mCircleDiameter = (int) (displayMetrics.density * 61.0f);
        createProgressView();
        ViewCompat.setChildrenDrawingOrderEnabled(this, true);
        this.mSpinnerOffsetEnd = (int) (displayMetrics.density * 61.0f);
        this.mTotalDragDistance = this.mSpinnerOffsetEnd;
        this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
        this.mNestedScrollingChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        int i = -this.mCircleDiameter;
        this.mCurrentTargetOffsetTop = i;
        this.mOriginalOffsetTop = i;
        moveToStart(1.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, LAYOUT_ATTRS);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.mCircleViewIndex >= 0) {
            if (i2 == i - 1) {
                return this.mCircleViewIndex;
            }
            if (i2 >= this.mCircleViewIndex) {
                return i2 + 1;
            }
            return i2;
        }
        return i2;
    }

    private void createProgressView() {
        this.axc = new a(getContext());
        addView(this.axc.getView());
    }

    public void setProgressView(b bVar) {
        if (bVar != null && bVar.getView() != null && bVar != this.axc && this.mState == 4) {
            removeView(this.axc.getView());
            this.axc = bVar;
            this.axc.getView().setVisibility(8);
            addView(this.axc.getView(), 0);
        }
    }

    public void setOnRefreshListener(d dVar) {
        this.axb = dVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAlphaUsedForScale() {
        return Build.VERSION.SDK_INT < 11;
    }

    public void setRefreshing(boolean z) {
        if (z && this.mRefreshing != z) {
            setRefreshing(z, false);
        } else {
            setRefreshing(z, false);
        }
    }

    void setAnimationProgress(float f) {
        if (isAlphaUsedForScale()) {
            setColorViewAlpha((int) (255.0f * f));
            return;
        }
        ViewCompat.setScaleX(this.axc.getView(), f);
        ViewCompat.setScaleY(this.axc.getView(), f);
    }

    private void setRefreshing(boolean z, boolean z2) {
        if (this.mRefreshing != z) {
            this.mNotify = z2;
            ensureTarget();
            this.mRefreshing = z;
            if (this.mRefreshing) {
                animateOffsetToCorrectPosition(this.mCurrentTargetOffsetTop, this.mRefreshListener);
            } else {
                sW();
            }
        }
    }

    void startScaleDownAnimation(Animation.AnimationListener animationListener) {
        this.mScaleDownAnimation = new Animation() { // from class: com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                BdSwipeRefreshLayout.this.setAnimationProgress(1.0f - f);
            }
        };
        this.mScaleDownAnimation.setDuration(150L);
        this.mScaleDownAnimation.setAnimationListener(animationListener);
        this.axc.getView().clearAnimation();
        this.axc.getView().startAnimation(this.mScaleDownAnimation);
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(getContext().getResources().getColor(i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        if (this.axc instanceof a) {
            ((a) this.axc).dP(i);
        }
    }

    public void setColorSchemeResources(int... iArr) {
        getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = getContext().getResources().getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        ensureTarget();
        if (this.axc instanceof a) {
            ((a) this.axc).setColorSchemeColors(iArr);
        }
    }

    public boolean isRefreshing() {
        return this.mRefreshing;
    }

    private void ensureTarget() {
        if (this.mTarget == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.axc.getView())) {
                    this.mTarget = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.mTotalDragDistance = i;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.mTarget == null) {
                ensureTarget();
            }
            if (this.mTarget != null) {
                View view = this.mTarget;
                int paddingLeft = getPaddingLeft();
                int paddingTop = (getPaddingTop() + this.mCurrentTargetOffsetTop) - this.mOriginalOffsetTop;
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                int measuredWidth2 = this.axc.getView().getMeasuredWidth();
                this.axc.getView().layout((measuredWidth / 2) - (measuredWidth2 / 2), this.mCurrentTargetOffsetTop, (measuredWidth / 2) + (measuredWidth2 / 2), this.mCurrentTargetOffsetTop + this.axc.getView().getMeasuredHeight());
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.mTarget == null) {
            ensureTarget();
        }
        if (this.mTarget != null) {
            this.mTarget.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.axc.getView().measure(View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mCircleDiameter, 1073741824));
            this.mCircleViewIndex = -1;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.axc.getView()) {
                    this.mCircleViewIndex = i3;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.mCircleDiameter;
    }

    public boolean canChildScrollUp() {
        boolean z = false;
        if (this.axd != null) {
            return this.axd.a(this, this.mTarget);
        }
        if (Build.VERSION.SDK_INT < 14) {
            if (this.mTarget instanceof AbsListView) {
                AbsListView absListView = (AbsListView) this.mTarget;
                return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
            }
            if (ViewCompat.canScrollVertically(this.mTarget, -1) || this.mTarget.getScrollY() > 0) {
                z = true;
            }
            return z;
        }
        return ViewCompat.canScrollVertically(this.mTarget, -1);
    }

    public void setOnChildScrollUpCallback(c cVar) {
        this.axd = cVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        ensureTarget();
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mNestedScrollInProgress) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsBeingDragged = false;
                int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex2 >= 0) {
                    this.mInitialDownY = motionEvent.getY(findPointerIndex2);
                    break;
                } else {
                    return false;
                }
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                break;
            case 2:
                if (this.mActivePointerId != -1 && (findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId)) >= 0) {
                    c(motionEvent.getY(findPointerIndex), "onInterceptTouchEvent");
                    break;
                } else {
                    return false;
                }
                break;
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        return this.mIsBeingDragged;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (Build.VERSION.SDK_INT >= 21 || !(this.mTarget instanceof AbsListView)) {
            if (this.mTarget == null || ViewCompat.isNestedScrollingEnabled(this.mTarget)) {
                super.requestDisallowInterceptTouchEvent(z);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.mReturningToStart || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(view, view2, i);
        startNestedScroll(i & 2);
        this.mTotalUnconsumed = 0.0f;
        this.mNestedScrollInProgress = true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.mTotalUnconsumed > 0.0f) {
            if (i2 > this.mTotalUnconsumed) {
                iArr[1] = i2 - ((int) this.mTotalUnconsumed);
                this.mTotalUnconsumed = 0.0f;
            } else {
                this.mTotalUnconsumed -= i2;
                iArr[1] = i2;
            }
            a(this.mTotalUnconsumed, "onNestedPreScroll-2");
        }
        if (this.mUsingCustomStart && i2 > 0 && this.mTotalUnconsumed == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.axc.getView().setVisibility(8);
        }
        int[] iArr2 = this.mParentScrollConsumed;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
        int i3 = i2 - iArr[1];
        if ((isRefreshing() || this.mState == 3) && Math.abs(i3) > 0) {
            if ((i3 > 0 && this.mCurrentTargetOffsetTop > this.mOriginalOffsetTop) || (i3 < 0 && this.mCurrentTargetOffsetTop < this.mOriginalOffsetTop + this.mSpinnerOffsetEnd && !canChildScrollUp())) {
                a(Math.max(Math.min(this.mSpinnerOffsetEnd, (this.mCurrentTargetOffsetTop - this.mOriginalOffsetTop) - i3), 0.0f), "onNestedPreScroll-1");
                iArr[1] = i3 + iArr[1];
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.mParentOffsetInWindow);
        int i5 = this.mParentOffsetInWindow[1] + i4;
        if (i5 < 0 && !canChildScrollUp() && !this.mRefreshing) {
            this.mTotalUnconsumed = Math.abs(i5) + this.mTotalUnconsumed;
            a(this.mTotalUnconsumed, "onNestedScroll");
        }
    }

    @Override // android.view.ViewGroup, android.support.v4.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public void onStopNestedScroll(View view) {
        this.mNestedScrollingParentHelper.onStopNestedScroll(view);
        this.mNestedScrollInProgress = false;
        if (this.mTotalUnconsumed > 0.0f) {
            b(this.mTotalUnconsumed, "onStopNestedScroll");
            this.mTotalUnconsumed = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        if (this.mState == 3 || this.mState == 2 || this.axc.getView() == null || this.axc.getView().getBottom() <= 0) {
            return dispatchNestedPreFling(f, f2);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, android.support.v4.view.NestedScrollingParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if ((this.mState == 3 || this.mState == 2) && f2 > 0.0f && this.mCurrentTargetOffsetTop > this.mOriginalOffsetTop) {
            animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, null);
        }
        return dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.mNestedScrollingChildHelper.setNestedScrollingEnabled(z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.mNestedScrollingChildHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.mNestedScrollingChildHelper.startNestedScroll(i);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.mNestedScrollingChildHelper.stopNestedScroll();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.mNestedScrollingChildHelper.hasNestedScrollingParent();
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mNestedScrollingChildHelper.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.mNestedScrollingChildHelper.dispatchNestedFling(f, f2, z);
    }

    @Override // android.view.View, android.support.v4.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.mNestedScrollingChildHelper.dispatchNestedPreFling(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isAnimationRunning(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    @SuppressLint({"NewApi"})
    private void a(float f, String str) {
        float min = Math.min(1.0f, Math.abs(f / this.mTotalDragDistance));
        float max = (((float) Math.max(min - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.mTotalDragDistance;
        float f2 = this.mUsingCustomStart ? this.mSpinnerOffsetEnd - this.mOriginalOffsetTop : this.mSpinnerOffsetEnd;
        float max2 = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        float pow = ((float) ((max2 / 4.0f) - Math.pow(max2 / 4.0f, 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + (f2 * pow * 2.0f))) + this.mOriginalOffsetTop;
        if (this.axc.getView().getVisibility() != 0) {
            this.axc.getView().setVisibility(0);
        }
        if (!this.mScale) {
            ViewCompat.setScaleX(this.axc.getView(), 1.0f);
            ViewCompat.setScaleY(this.axc.getView(), 1.0f);
        }
        if (this.mScale) {
            setAnimationProgress(Math.min(1.0f, f / this.mTotalDragDistance));
        }
        if (!this.mRefreshing && this.mState != 3) {
            if (this.mOriginalOffsetTop < this.mCurrentTargetOffsetTop && this.mCurrentTargetOffsetTop < this.mOriginalOffsetTop + this.mSpinnerOffsetEnd) {
                if (this.mState != 0) {
                    sV();
                }
            } else if (this.mCurrentTargetOffsetTop >= this.mOriginalOffsetTop + this.mSpinnerOffsetEnd && this.mState != 1) {
                sw();
            }
            this.axc.k(max, pow);
        }
        a(i - this.mCurrentTargetOffsetTop, true, "moveSpinner");
    }

    private void b(float f, String str) {
        if (f > this.mTotalDragDistance) {
            setRefreshing(true, true);
            return;
        }
        this.mRefreshing = false;
        Animation.AnimationListener animationListener = null;
        if (!this.mScale) {
            animationListener = new Animation.AnimationListener() { // from class: com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.3
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (!BdSwipeRefreshLayout.this.mScale) {
                        BdSwipeRefreshLayout.this.startScaleDownAnimation(null);
                    }
                    BdSwipeRefreshLayout.this.finish();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            };
        }
        animateOffsetToStartPosition(this.mCurrentTargetOffsetTop, animationListener);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (this.mReturningToStart && actionMasked == 0) {
            this.mReturningToStart = false;
        }
        if (!isEnabled() || this.mReturningToStart || canChildScrollUp() || this.mRefreshing || this.mNestedScrollInProgress) {
            return false;
        }
        switch (actionMasked) {
            case 0:
                this.mActivePointerId = motionEvent.getPointerId(0);
                this.mIsBeingDragged = false;
                break;
            case 1:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex >= 0) {
                    if (this.mIsBeingDragged) {
                        this.mIsBeingDragged = false;
                        b((motionEvent.getY(findPointerIndex) - this.mInitialMotionY) * 0.5f, "onTouchEvent(ACTION_UP)");
                    }
                    this.mActivePointerId = -1;
                    return false;
                }
                return false;
            case 2:
                int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex2 < 0) {
                    return false;
                }
                float y = motionEvent.getY(findPointerIndex2);
                c(y, "onTouchEvent");
                if (this.mIsBeingDragged) {
                    float f = (y - this.mInitialMotionY) * 0.5f;
                    if (f > 0.0f) {
                        a(f, "onTouchEvent(ACTION_MOVE)");
                        break;
                    } else {
                        return false;
                    }
                }
                break;
            case 3:
                return false;
            case 5:
                int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                if (actionIndex >= 0) {
                    this.mActivePointerId = motionEvent.getPointerId(actionIndex);
                    break;
                } else {
                    return false;
                }
            case 6:
                onSecondaryPointerUp(motionEvent);
                break;
        }
        return true;
    }

    @SuppressLint({"NewApi"})
    private void c(float f, String str) {
        if (f - this.mInitialDownY > this.mTouchSlop && !this.mIsBeingDragged) {
            this.mInitialMotionY = this.mInitialDownY + this.mTouchSlop;
            this.mIsBeingDragged = true;
        }
    }

    private void animateOffsetToCorrectPosition(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.mAnimateToCorrectPosition.reset();
        this.mAnimateToCorrectPosition.setDuration(200L);
        this.mAnimateToCorrectPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mAnimateToCorrectPosition.setAnimationListener(animationListener);
        }
        if (this.axc.getView().getVisibility() != 0) {
            this.axc.getView().setVisibility(0);
        }
        this.axc.getView().clearAnimation();
        this.axc.getView().startAnimation(this.mAnimateToCorrectPosition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void animateOffsetToStartPosition(int i, Animation.AnimationListener animationListener) {
        if (this.mScale) {
            startScaleDownReturnToStartAnimation(i, animationListener);
            return;
        }
        this.mFrom = i;
        this.mAnimateToStartPosition.reset();
        this.mAnimateToStartPosition.setDuration(200L);
        this.mAnimateToStartPosition.setInterpolator(this.mDecelerateInterpolator);
        if (animationListener != null) {
            this.mAnimateToStartPosition.setAnimationListener(animationListener);
        }
        this.axc.getView().clearAnimation();
        this.axc.getView().startAnimation(this.mAnimateToStartPosition);
    }

    void moveToStart(float f) {
        a((this.mFrom + ((int) ((this.mOriginalOffsetTop - this.mFrom) * f))) - this.axc.getView().getTop(), false, "moveToStart");
    }

    @SuppressLint({"NewApi"})
    private void startScaleDownReturnToStartAnimation(int i, Animation.AnimationListener animationListener) {
        this.mFrom = i;
        this.mStartingScale = ViewCompat.getScaleX(this.axc.getView());
        this.mScaleDownToStartAnimation = new Animation() { // from class: com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.6
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                BdSwipeRefreshLayout.this.setAnimationProgress(BdSwipeRefreshLayout.this.mStartingScale + ((-BdSwipeRefreshLayout.this.mStartingScale) * f));
                BdSwipeRefreshLayout.this.moveToStart(f);
            }
        };
        this.mScaleDownToStartAnimation.setDuration(150L);
        if (animationListener != null) {
            this.mScaleDownToStartAnimation.setAnimationListener(animationListener);
        }
        this.axc.getView().clearAnimation();
        this.axc.getView().startAnimation(this.mScaleDownToStartAnimation);
    }

    void a(int i, boolean z, String str) {
        this.axc.getView().bringToFront();
        ViewCompat.offsetTopAndBottom(this.axc.getView(), i);
        if (this.mTarget != null) {
            ViewCompat.offsetTopAndBottom(this.mTarget, i);
        }
        this.mCurrentTargetOffsetTop = this.axc.getView().getTop();
        if (z && Build.VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            this.mActivePointerId = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private void sV() {
        this.mState = 0;
        this.axc.onPullToRefresh();
    }

    private void sw() {
        this.mState = 1;
        this.axc.onReleaseToRefresh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sx() {
        this.mState = 2;
        this.axc.onRefreshing();
        if (this.mNotify && this.axb != null) {
            this.axb.onRefresh();
        }
    }

    private void sW() {
        this.mState = 3;
        this.axc.sB();
        postDelayed(new Runnable() { // from class: com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.7
            @Override // java.lang.Runnable
            public void run() {
                BdSwipeRefreshLayout.this.animateOffsetToStartPosition(BdSwipeRefreshLayout.this.mCurrentTargetOffsetTop, BdSwipeRefreshLayout.this.mRefreshListener);
            }
        }, this.axc.sC());
    }

    public void sX() {
        ensureTarget();
        this.mRefreshing = false;
        moveToStart(1.0f);
        reset();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finish() {
        this.mState = 4;
        this.axc.getView().clearAnimation();
        this.axc.onFinish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a implements b {
        com.baidu.adp.widget.refresh.a axf;
        com.baidu.adp.widget.refresh.b axg;
        private Animation mAlphaMaxAnimation;
        private Animation mAlphaStartAnimation;

        public a(Context context) {
            this.axf = new com.baidu.adp.widget.refresh.a(BdSwipeRefreshLayout.this.getContext(), -328966);
            this.axg = new com.baidu.adp.widget.refresh.b(context, this.axf);
            this.axg.setBackgroundColor(-328966);
            this.axf.setImageDrawable(this.axg);
            this.axf.setVisibility(8);
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
        public void onPullToRefresh() {
            this.axg.setAlpha(76);
            this.axg.showArrow(true);
            if (this.axg.getAlpha() > 76 && !BdSwipeRefreshLayout.this.isAnimationRunning(this.mAlphaStartAnimation)) {
                startProgressAlphaStartAnimation();
            }
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
        public void onReleaseToRefresh() {
            if (this.axg.getAlpha() < 255 && !BdSwipeRefreshLayout.this.isAnimationRunning(this.mAlphaMaxAnimation)) {
                startProgressAlphaMaxAnimation();
            }
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
        public void onRefreshing() {
            if (Build.VERSION.SDK_INT >= 11) {
                this.axg.setAlpha(255);
            }
            this.axg.setArrowScale(0.0f);
            this.axg.setAlpha(255);
            this.axg.start();
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
        public void sB() {
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
        public void onFinish() {
            this.axg.setStartEndTrim(0.0f, 0.0f);
            this.axg.stop();
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
        public void k(float f, float f2) {
            this.axg.setStartEndTrim(0.0f, Math.min(0.8f, f * 0.8f));
            this.axg.setArrowScale(Math.min(1.0f, f));
            this.axg.setProgressRotation(((-0.25f) + (0.4f * f) + (2.0f * f2)) * 0.5f);
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
        public long sC() {
            return 0L;
        }

        @Override // com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.b
        public View getView() {
            return this.axf;
        }

        public void setSize(int i) {
            this.axf.setImageDrawable(null);
            this.axg.updateSizes(i);
            this.axf.setImageDrawable(this.axg);
        }

        public void dP(int i) {
            this.axf.setBackgroundColor(i);
            this.axg.setBackgroundColor(i);
        }

        public void setColorSchemeColors(int... iArr) {
            this.axg.setColorSchemeColors(iArr);
        }

        @SuppressLint({"NewApi"})
        private void startProgressAlphaStartAnimation() {
            this.mAlphaStartAnimation = startAlphaAnimation(this.axg.getAlpha(), 76);
        }

        @SuppressLint({"NewApi"})
        private void startProgressAlphaMaxAnimation() {
            this.mAlphaMaxAnimation = startAlphaAnimation(this.axg.getAlpha(), 255);
        }

        @SuppressLint({"NewApi"})
        private Animation startAlphaAnimation(final int i, final int i2) {
            if (BdSwipeRefreshLayout.this.isAlphaUsedForScale()) {
                return null;
            }
            Animation animation = new Animation() { // from class: com.baidu.adp.widget.refresh.BdSwipeRefreshLayout.a.1
                @Override // android.view.animation.Animation
                public void applyTransformation(float f, Transformation transformation) {
                    a.this.axg.setAlpha((int) (i + ((i2 - i) * f)));
                }
            };
            animation.setDuration(300L);
            this.axf.setAnimationListener(null);
            this.axf.clearAnimation();
            this.axf.startAnimation(animation);
            return animation;
        }
    }
}
