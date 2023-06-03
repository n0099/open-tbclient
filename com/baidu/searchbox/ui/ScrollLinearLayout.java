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
public class ScrollLinearLayout extends LinearLayout {
    public static final int ANIMATED_SCROLL_GAP = 250;
    public static final boolean DEBUG = false;
    public static final int INVALID_POINTER = -1;
    public static final float MAX_SCROLL_FACTOR = 0.5f;
    public static final String TAG = "ScrollLinearLayout";
    public int mActivePointerId;
    public EdgeEffect mEdgeGlowBottom;
    public boolean mIsBeingDragged;
    public int mLastItemBottomMargin;
    public int mLastMotionY;
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

    public ScrollLinearLayout(Context context) {
        super(context);
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        this.mLastItemBottomMargin = 0;
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
            this.mLastMotionY = (int) motionEvent.getY(i);
            this.mActivePointerId = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i) {
        int computeVerticalScrollOffset = computeVerticalScrollOffset();
        int computeVerticalScrollRange = computeVerticalScrollRange() - computeVerticalScrollExtent();
        if (computeVerticalScrollRange == 0) {
            return false;
        }
        if (i < 0) {
            if (computeVerticalScrollOffset <= 0) {
                return false;
            }
            return true;
        } else if (computeVerticalScrollOffset >= computeVerticalScrollRange - 0.5d) {
            return false;
        } else {
            return true;
        }
    }

    public void setEdgeGlowBottom(EdgeEffect edgeEffect) {
        this.mEdgeGlowBottom = edgeEffect;
    }

    public ScrollLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        this.mLastItemBottomMargin = 0;
        initScrollView();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, 0));
        setMeasuredDimension(getMeasuredWidth(), size);
    }

    @SuppressLint({"NewApi", "suppressNewApi"})
    public ScrollLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsBeingDragged = false;
        this.mActivePointerId = -1;
        this.mLastItemBottomMargin = 0;
        initScrollView();
    }

    private void endDrag() {
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        EdgeEffect edgeEffect = this.mEdgeGlowBottom;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
        }
    }

    private int getChildrenBottom() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt != null && childAt.getVisibility() != 8) {
                return childAt.getBottom() + this.mLastItemBottomMargin;
            }
        }
        return 0;
    }

    private int getContentHeight() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private int getScrollRange() {
        return Math.max(0, getChildrenBottom() - getContentHeight());
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
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        if (getChildCount() == 0) {
            return (getHeight() - getPaddingBottom()) - getPaddingTop();
        }
        return getChildrenBottom();
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
                EdgeEffect edgeEffect = this.mEdgeGlowBottom;
                if (edgeEffect != null && currY >= scrollRange && scrollY < scrollRange) {
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
        EdgeEffect edgeEffect = this.mEdgeGlowBottom;
        if (edgeEffect != null && !edgeEffect.isFinished()) {
            int save = canvas.save();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int height = getHeight();
            canvas.translate((-width) + getPaddingLeft(), Math.max(getScrollRange(), getScrollY()) + height);
            canvas.rotate(180.0f, width, 0.0f);
            this.mEdgeGlowBottom.setSize(width, height);
            if (this.mEdgeGlowBottom.draw(canvas)) {
                invalidate();
            }
            canvas.restoreToCount(save);
        }
    }

    public void fling(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            this.mScroller.fling(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, getChildrenBottom() - height));
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
        if (getScrollY() == 0 && !canScrollVertically(1)) {
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
                        int y = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(y - this.mLastMotionY) > this.mTouchSlop) {
                            this.mIsBeingDragged = true;
                            this.mLastMotionY = y;
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
            int y2 = (int) motionEvent.getY();
            if (!inChild((int) motionEvent.getX(), y2)) {
                this.mIsBeingDragged = false;
                recycleVelocityTracker();
            } else {
                this.mLastMotionY = y2;
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
                                this.mLastMotionY = (int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
                            }
                        } else {
                            if (Build.VERSION.SDK_INT > 5) {
                                i = motionEvent.getActionIndex();
                            }
                            this.mLastMotionY = (int) motionEvent.getY(i);
                            this.mActivePointerId = motionEvent.getPointerId(i);
                        }
                    } else if (this.mIsBeingDragged && getChildCount() > 0) {
                        this.mActivePointerId = -1;
                        endDrag();
                    }
                } else {
                    int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                    if (findPointerIndex != -1) {
                        int y = (int) motionEvent.getY(findPointerIndex);
                        int i2 = this.mLastMotionY - y;
                        if (!this.mIsBeingDragged && Math.abs(i2) > this.mTouchSlop) {
                            ViewParent parent2 = getParent();
                            if (parent2 != null) {
                                parent2.requestDisallowInterceptTouchEvent(true);
                            }
                            this.mIsBeingDragged = true;
                            i2 = i2 > 0 ? i2 - this.mTouchSlop : i2 + this.mTouchSlop;
                        }
                        if (this.mIsBeingDragged) {
                            this.mLastMotionY = y;
                            int scrollX = getScrollX();
                            int scrollY = getScrollY();
                            int scrollRange = getScrollRange();
                            scrollBy(0, i2);
                            onScrollChanged(getScrollX(), getScrollY(), scrollX, scrollY);
                            int i3 = scrollY + i2;
                            if (i3 < 0) {
                                EdgeEffect edgeEffect2 = this.mEdgeGlowBottom;
                                if (edgeEffect2 != null && !edgeEffect2.isFinished()) {
                                    this.mEdgeGlowBottom.onRelease();
                                }
                            } else if (i3 > scrollRange && (edgeEffect = this.mEdgeGlowBottom) != null) {
                                edgeEffect.onPull(i2 / getHeight());
                                Log.e(DebugActiveUploadResult.SOURCE, "edge effect:" + (f / getHeight()));
                            }
                            EdgeEffect edgeEffect3 = this.mEdgeGlowBottom;
                            if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
                                invalidate();
                            }
                        }
                    }
                }
            } else if (this.mIsBeingDragged) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                int yVelocity = (int) velocityTracker.getYVelocity();
                if (getChildCount() > 0 && Math.abs(yVelocity) > this.mMinimumVelocity) {
                    fling(-yVelocity);
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
            this.mLastMotionY = (int) motionEvent.getY();
            this.mActivePointerId = motionEvent.getPointerId(0);
        }
        return true;
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            int clamp = clamp(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), getWidth());
            int clamp2 = clamp(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), computeVerticalScrollRange());
            if (clamp != getScrollX() || clamp2 != getScrollY()) {
                super.scrollTo(clamp, clamp2);
            }
        }
    }
}
