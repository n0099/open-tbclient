package android.support.design.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ScrollerCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
/* loaded from: classes2.dex */
abstract class k<V extends View> extends x<V> {
    private int mActivePointerId;
    private boolean mIsBeingDragged;
    private int mLastMotionY;
    ScrollerCompat mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private Runnable pi;

    public k() {
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
    }

    public k(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.mIsBeingDragged) {
            return true;
        }
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                this.mIsBeingDragged = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (q(v) && coordinatorLayout.isPointInChildBounds(v, x, y)) {
                    this.mLastMotionY = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    ca();
                    break;
                }
                break;
            case 1:
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
            case 2:
                int i = this.mActivePointerId;
                if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                    int y2 = (int) motionEvent.getY(findPointerIndex);
                    if (Math.abs(y2 - this.mLastMotionY) > this.mTouchSlop) {
                        this.mIsBeingDragged = true;
                        this.mLastMotionY = y2;
                        break;
                    }
                }
                break;
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(motionEvent);
        }
        return this.mIsBeingDragged;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ad  */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        switch (MotionEventCompat.getActionMasked(motionEvent)) {
            case 0:
                int y = (int) motionEvent.getY();
                if (coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), y) && q(v)) {
                    this.mLastMotionY = y;
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    ca();
                    break;
                } else {
                    return false;
                }
                break;
            case 1:
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    a(coordinatorLayout, (CoordinatorLayout) v, -o(v), 0, VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
                }
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                if (this.mVelocityTracker != null) {
                    this.mVelocityTracker.recycle();
                    this.mVelocityTracker = null;
                    break;
                }
                break;
            case 2:
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex == -1) {
                    return false;
                }
                int y2 = (int) motionEvent.getY(findPointerIndex);
                int i = this.mLastMotionY - y2;
                if (!this.mIsBeingDragged && Math.abs(i) > this.mTouchSlop) {
                    this.mIsBeingDragged = true;
                    i = i > 0 ? i - this.mTouchSlop : i + this.mTouchSlop;
                }
                if (this.mIsBeingDragged) {
                    this.mLastMotionY = y2;
                    b(coordinatorLayout, v, i, p(v), 0);
                    break;
                }
                break;
            case 3:
                this.mIsBeingDragged = false;
                this.mActivePointerId = -1;
                if (this.mVelocityTracker != null) {
                }
                break;
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.addMovement(motionEvent);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(CoordinatorLayout coordinatorLayout, V v, int i) {
        return a(coordinatorLayout, (CoordinatorLayout) v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int constrain;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i2 == 0 || topAndBottomOffset < i2 || topAndBottomOffset > i3 || topAndBottomOffset == (constrain = m.constrain(i, i2, i3))) {
            return 0;
        }
        setTopAndBottomOffset(constrain);
        return topAndBottomOffset - constrain;
    }

    int aX() {
        return getTopAndBottomOffset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return a(coordinatorLayout, (CoordinatorLayout) v, aX() - i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.pi != null) {
            v.removeCallbacks(this.pi);
            this.pi = null;
        }
        if (this.mScroller == null) {
            this.mScroller = ScrollerCompat.create(v.getContext());
        }
        this.mScroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f), 0, 0, i, i2);
        if (this.mScroller.computeScrollOffset()) {
            this.pi = new a(coordinatorLayout, v);
            ViewCompat.postOnAnimation(v, this.pi);
            return true;
        }
        a(coordinatorLayout, v);
        return false;
    }

    void a(CoordinatorLayout coordinatorLayout, V v) {
    }

    boolean q(V v) {
        return false;
    }

    int p(V v) {
        return -v.getHeight();
    }

    int o(V v) {
        return v.getHeight();
    }

    private void ca() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private final CoordinatorLayout pj;
        private final V pl;

        a(CoordinatorLayout coordinatorLayout, V v) {
            this.pj = coordinatorLayout;
            this.pl = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.pl != null && k.this.mScroller != null) {
                if (k.this.mScroller.computeScrollOffset()) {
                    k.this.a(this.pj, this.pl, k.this.mScroller.getCurrY());
                    ViewCompat.postOnAnimation(this.pl, this);
                    return;
                }
                k.this.a(this.pj, this.pl);
            }
        }
    }
}
