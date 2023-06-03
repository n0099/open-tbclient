package com.baidu.searchbox.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.LinearLayout;
import com.baidu.searchbox.retrieve.debug.provider.DebugActiveUploadResult;
import com.baidu.searchbox.ui.multiwindow.EdgeEffect;
/* loaded from: classes4.dex */
public class HorizontalScrollLinearLayout extends LinearLayout {
    public static final int ANIMATED_SCROLL_GAP = 250;
    public static final boolean DEBUG = false;
    public static final int INVALID_POINTER = -1;
    public static final float MAX_SCROLL_FACTOR = 0.5f;
    public static final String TAG = "HorScrollLinearLayout";
    public int mActivePointerId;
    public EdgeEffect mEdgeGlowRight;
    public boolean mIsBeingDragged;
    public int mLastItemRightMargin;
    public int mLastMotionX;
    public int mMaximumVelocity;
    public int mMinimumVelocity;
    public OverScroller mScroller;
    public int mTouchSlop;
    public VelocityTracker mVelocityTracker;

    public static int clamp(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        return i2 + i > i3 ? i3 - i2 : i;
    }

    private boolean inChild(int i, int i2) {
        return true;
    }

    public HorizontalScrollLinearLayout(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        this.mLastItemRightMargin = 0;
        initScrollView();
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int i;
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.mActivePointerId) {
            if (action == 0) {
                i = 1;
            } else {
                i = 0;
            }
            this.mLastMotionX = (int) motionEvent.getX(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i) {
        return super.canScrollHorizontally(i);
    }

    public void setEdgeGlowBottom(EdgeEffect edgeEffect) {
        this.mEdgeGlowRight = edgeEffect;
    }

    public HorizontalScrollLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        this.mLastItemRightMargin = 0;
        initScrollView();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 0), i2);
        setMeasuredDimension(size, getMeasuredHeight());
    }

    @SuppressLint({"NewApi", "suppressNewApi"})
    public HorizontalScrollLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        this.mLastItemRightMargin = 0;
        initScrollView();
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        EdgeEffect edgeEffect = this.mEdgeGlowRight;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
        }
    }

    private int getChildrenRight() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt != null && childAt.getVisibility() != 8) {
                return childAt.getRight() + this.mLastItemRightMargin;
            }
        }
        return 0;
    }

    private int getContentWidth() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private int getScrollRange() {
        return Math.max(0, getChildrenRight() - getContentWidth());
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return Math.max(0, super.computeHorizontalScrollOffset());
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        if (getChildCount() == 0) {
            return (getWidth() - getPaddingRight()) - getPaddingLeft();
        }
        return getChildrenRight();
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.mScroller.getCurrX();
            int currY = this.mScroller.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                int scrollRange = getScrollRange();
                scrollBy(currX - scrollX, currY - scrollY);
                onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
                EdgeEffect edgeEffect = this.mEdgeGlowRight;
                if (edgeEffect != null && currX >= scrollRange && scrollX < scrollRange) {
                    edgeEffect.onAbsorb(((int) this.mScroller.getCurrVelocity()) / 2);
                }
            }
            if (!awakenScrollBars()) {
                postInvalidate();
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        EdgeEffect edgeEffect = this.mEdgeGlowRight;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int save = canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = getHeight();
            canvas.translate((-width) + getPaddingLeft(), Math.max(getScrollRange(), getScrollY()) + height);
            canvas.rotate(180.0f, width, 0.0f);
            this.mEdgeGlowRight.setSize(width, height);
            if (this.mEdgeGlowRight.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(save);
        }
    }

    public void fling(int i) {
        if (getChildCount() > 0) {
            int width = (getWidth() - getPaddingRight()) - getPaddingLeft();
            this.mScroller.fling(getScrollX(), getScrollY(), i, 0, 0, Math.max(0, getChildrenRight() - width), 0, 0);
            postInvalidate();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int findPointerIndex;
        int action = motionEvent.getAction();
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        if (getScrollX() == 0 && !canScrollHorizontally(1)) {
            return false;
        }
        int i = action & 255;
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i == 6) {
                            onSecondaryPointerUp(motionEvent);
                        }
                    }
                } else {
                    int i2 = this.mActivePointerId;
                    if (i2 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i2)) != -1) {
                        int x = (int) motionEvent.getX(findPointerIndex);
                        if (Math.abs(x - this.mLastMotionX) > this.mTouchSlop) {
                            this.mIsBeingDragged = true;
                            this.mLastMotionX = x;
                            initVelocityTrackerIfNotExists();
                            this.mVelocityTracker.addMovement(motionEvent);
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                            }
                        }
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            recycleVelocityTracker();
        } else {
            int x2 = (int) motionEvent.getX();
            if (!inChild(x2, (int) motionEvent.getY())) {
                this.mIsBeingDragged = false;
                recycleVelocityTracker();
            } else {
                this.mLastMotionX = x2;
                this.mActivePointerId = motionEvent.getPointerId(0);
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                this.mIsBeingDragged = !this.mScroller.isFinished();
            }
        }
        return this.mIsBeingDragged;
    }

    @Override // android.view.View
    @SuppressLint({"ObsoleteSdkInt"})
    @TargetApi(8)
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        EdgeEffect edgeEffect;
        float f;
        initVelocityTrackerIfNotExists();
        this.mVelocityTracker.addMovement(motionEvent);
        int action = motionEvent.getAction() & 255;
        int i = 0;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action == 6) {
                                onSecondaryPointerUp(motionEvent);
                                this.mLastMotionX = (int) motionEvent.getX(motionEvent.findPointerIndex(this.mActivePointerId));
                            }
                        } else {
                            if (Build.VERSION.SDK_INT > 5) {
                                i = motionEvent.getActionIndex();
                            }
                            this.mLastMotionX = (int) motionEvent.getX(i);
                            this.mActivePointerId = motionEvent.getPointerId(i);
                        }
                    } else if (this.mIsBeingDragged && getChildCount() > 0) {
                        this.mActivePointerId = -1;
                        endDrag();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex != -1) {
                        int x = (int) motionEvent.getX(findPointerIndex);
                        int i2 = this.mLastMotionX - x;
                        if (!this.mIsBeingDragged && Math.abs(i2) > this.mTouchSlop) {
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.mIsBeingDragged = true;
                            i2 = i2 > 0 ? i2 - this.mTouchSlop : i2 + this.mTouchSlop;
                        }
                        if (this.mIsBeingDragged) {
                            this.mLastMotionX = x;
                            int scrollX = getScrollX();
                            int scrollY = getScrollY();
                            int scrollRange = getScrollRange();
                            scrollBy(i2, 0);
                            onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
                            int i3 = scrollX + i2;
                            if (i3 < 0) {
                                EdgeEffect edgeEffect2 = this.mEdgeGlowRight;
                                if (edgeEffect2 != null && !edgeEffect2.isFinished()) {
                                    this.mEdgeGlowRight.onRelease();
                                }
                            } else if (i3 > scrollRange && (edgeEffect = this.mEdgeGlowRight) != null) {
                                edgeEffect.onPull(i2 / getWidth());
                                Log.e(DebugActiveUploadResult.SOURCE, "edge effect:" + (f / getWidth()));
                            }
                            EdgeEffect edgeEffect3 = this.mEdgeGlowRight;
                            if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
                                invalidate();
                            }
                        }
                    }
                }
            } else if (this.mIsBeingDragged) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int xVelocity = (int) velocityTracker.getXVelocity();
                if (getChildCount() > 0 && Math.abs(xVelocity) > this.mMinimumVelocity) {
                    fling(-xVelocity);
                }
                this.mActivePointerId = -1;
                endDrag();
            }
        } else if (getChildCount() == 0) {
            return false;
        } else {
            boolean z = !this.mScroller.isFinished();
            this.mIsBeingDragged = z;
            if (z && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.mScroller.isFinished()) {
                this.mScroller.abortAnimation();
            }
            this.mLastMotionX = (int) motionEvent.getX();
            this.mActivePointerId = motionEvent.getPointerId(0);
        }
        return true;
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            int clamp = clamp(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), computeHorizontalScrollRange());
            int clamp2 = clamp(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), getHeight());
            if (clamp != getScrollX() || clamp2 != getScrollY()) {
                super.scrollTo(clamp, clamp2);
            }
        }
    }
}
