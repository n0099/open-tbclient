package com.baidu.live.framework.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.baidu.live.framework.coordinatorlayout.CoordinatorLayout;
/* loaded from: classes2.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {
    public Runnable d;
    public OverScroller e;
    public boolean f;
    public int g;
    public int h;
    public int i;
    public VelocityTracker j;

    public boolean H(V v) {
        return false;
    }

    public void N(CoordinatorLayout coordinatorLayout, V v) {
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final CoordinatorLayout a;
        public final V b;

        public a(CoordinatorLayout coordinatorLayout, V v) {
            this.a = coordinatorLayout;
            this.b = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.b != null && (overScroller = HeaderBehavior.this.e) != null) {
                if (overScroller.computeScrollOffset()) {
                    HeaderBehavior headerBehavior = HeaderBehavior.this;
                    headerBehavior.P(this.a, this.b, headerBehavior.e.getCurrY());
                    ViewCompat.postOnAnimation(this.b, this);
                    return;
                }
                HeaderBehavior.this.N(this.a, this.b);
            }
        }
    }

    public HeaderBehavior() {
        this.g = -1;
        this.i = -1;
    }

    public final void I() {
        if (this.j == null) {
            this.j = VelocityTracker.obtain();
        }
    }

    public int M() {
        return E();
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = -1;
        this.i = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (r0 != 3) goto L15;
     */
    @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean D(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.i < 0) {
            this.i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.g);
                    if (findPointerIndex == -1) {
                        return false;
                    }
                    int y = (int) motionEvent.getY(findPointerIndex);
                    int i = this.h - y;
                    if (!this.f) {
                        int abs = Math.abs(i);
                        int i2 = this.i;
                        if (abs > i2) {
                            this.f = true;
                            i = i > 0 ? i - i2 : i + i2;
                        }
                    }
                    int i3 = i;
                    if (this.f) {
                        this.h = y;
                        O(coordinatorLayout, v, i3, K(v), 0);
                    }
                }
            } else {
                VelocityTracker velocityTracker = this.j;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.j.computeCurrentVelocity(1000);
                    J(coordinatorLayout, v, -L(v), 0, this.j.getYVelocity(this.g));
                }
            }
            this.f = false;
            this.g = -1;
            VelocityTracker velocityTracker2 = this.j;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.j = null;
            }
        } else {
            int y2 = (int) motionEvent.getY();
            if (!coordinatorLayout.v(v, (int) motionEvent.getX(), y2) || !H(v)) {
                return false;
            }
            this.h = y2;
            this.g = motionEvent.getPointerId(0);
            I();
        }
        VelocityTracker velocityTracker3 = this.j;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return true;
    }

    public final boolean J(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        Runnable runnable = this.d;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.d = null;
        }
        if (this.e == null) {
            this.e = new OverScroller(v.getContext());
        }
        this.e.fling(0, E(), 0, Math.round(f), 0, 0, i, i2);
        if (this.e.computeScrollOffset()) {
            a aVar = new a(coordinatorLayout, v);
            this.d = aVar;
            ViewCompat.postOnAnimation(v, aVar);
            return true;
        }
        N(coordinatorLayout, v);
        return false;
    }

    public int K(V v) {
        return -v.getHeight();
    }

    public int L(V v) {
        return v.getHeight();
    }

    public final int O(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return Q(coordinatorLayout, v, M() - i, i2, i3);
    }

    public int Q(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int clamp;
        int E = E();
        if (i2 != 0 && E >= i2 && E <= i3 && E != (clamp = MathUtils.clamp(i, i2, i3))) {
            G(clamp);
            return E - clamp;
        }
        return 0;
    }

    public int P(CoordinatorLayout coordinatorLayout, V v, int i) {
        return Q(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002c, code lost:
        if (r0 != 3) goto L17;
     */
    @Override // com.baidu.live.framework.coordinatorlayout.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean k(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.i < 0) {
            this.i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.g;
                    if (i != -1 && (findPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                        int y = (int) motionEvent.getY(findPointerIndex);
                        if (Math.abs(y - this.h) > this.i) {
                            this.f = true;
                            this.h = y;
                        }
                    }
                }
            }
            this.f = false;
            this.g = -1;
            VelocityTracker velocityTracker = this.j;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.j = null;
            }
        } else {
            this.f = false;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (H(v) && coordinatorLayout.v(v, x, y2)) {
                this.h = y2;
                this.g = motionEvent.getPointerId(0);
                I();
            }
        }
        VelocityTracker velocityTracker2 = this.j;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return this.f;
    }
}
