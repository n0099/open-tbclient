package com.baidu.adp.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.core.view.MotionEventCompat;
import com.baidu.adp.R;
import com.baidu.adp.lib.util.BdLog;
import d.b.b.e.p.l;
/* loaded from: classes.dex */
public class SwipeBackLayout extends FrameLayout {
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public b F;

    /* renamed from: e  reason: collision with root package name */
    public Activity f2368e;

    /* renamed from: f  reason: collision with root package name */
    public View f2369f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f2370g;

    /* renamed from: h  reason: collision with root package name */
    public Scroller f2371h;
    public int i;
    public float j;
    public float k;
    public float l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public Rect t;
    public VelocityTracker u;
    public int v;
    public int w;
    public int x;
    public int y;
    public float z;

    /* loaded from: classes.dex */
    public static class a implements Interpolator {

        /* renamed from: a  reason: collision with root package name */
        public final float f2372a;

        public a(float f2) {
            this.f2372a = f2;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            float f3 = f2 * this.f2372a;
            if (f3 > 0.9d) {
                return 1.0f;
            }
            return f3;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(boolean z);

        void b();
    }

    /* loaded from: classes.dex */
    public interface c {
        void disableSwipeBack();

        void enableSwipeBack();
    }

    public SwipeBackLayout(Context context) {
        super(context);
        this.n = -1;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = false;
        this.s = 0;
        this.t = new Rect();
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        i(context);
    }

    public void a(Activity activity) {
        try {
            this.f2368e = activity;
            Window window = activity.getWindow();
            window.setBackgroundDrawable(new ColorDrawable(0));
            ViewGroup viewGroup = (ViewGroup) window.getDecorView();
            ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
            this.f2370g = viewGroup2;
            viewGroup.removeView(viewGroup2);
            this.f2370g.setClickable(true);
            addView(this.f2370g);
            this.f2369f = (View) this.f2370g.getParent();
            viewGroup.addView(this);
        } catch (Exception e2) {
            this.q = false;
            BdLog.e(e2);
        }
    }

    public final void b() {
        if (this.r) {
            this.f2371h.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f2371h.getCurrX();
            int currY = this.f2371h.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.f2369f.scrollTo(currX, currY);
            }
        }
        this.r = false;
    }

    public final void c(MotionEvent motionEvent) {
        int i = this.n;
        int h2 = h(motionEvent, i);
        if (j(motionEvent, h2, i)) {
            return;
        }
        float x = MotionEventCompat.getX(motionEvent, h2);
        float f2 = x - this.j;
        float abs = Math.abs(f2);
        float y = MotionEventCompat.getY(motionEvent, h2);
        float abs2 = Math.abs(y - this.k);
        if (f2 <= 0.0f || abs <= this.y || abs <= abs2) {
            return;
        }
        this.o = true;
        b bVar = this.F;
        if (bVar != null) {
            bVar.b();
        }
        this.j = x;
        this.k = y;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (!this.f2371h.isFinished() && this.f2371h.computeScrollOffset()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f2371h.getCurrX();
            int currY = this.f2371h.getCurrY();
            if (scrollX != currX || scrollY != currY) {
                this.f2369f.scrollTo(currX, currY);
            }
            invalidate();
        }
        if (this.f2371h.isFinished() && this.p) {
            this.f2368e.finish();
            this.f2368e.overridePendingTransition(0, 0);
        }
        if (this.f2371h.isFinished()) {
            b();
        }
    }

    public void d() {
        this.A = true;
        this.q = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        View view = this.f2369f;
        if (view != null) {
            int i = this.m;
            int bottom = view.getBottom();
            Rect rect = this.t;
            rect.top = 0;
            rect.bottom = bottom;
            rect.left = 0;
            rect.right = i;
            canvas.clipRect(rect);
            int i2 = this.i;
            if (i2 != 0) {
                this.s = 100 - ((int) (((-this.m) / i2) * 120.0f));
            }
            if (this.s > 100) {
                this.s = 100;
            }
            if (this.p) {
                this.s = 0;
            }
            if (this.s < 0) {
                this.s = 0;
            }
            canvas.drawARGB(this.s, 0, 0, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        m(motionEvent);
        return dispatchTouchEvent;
    }

    public final void e() {
        this.o = false;
        this.n = -1;
        n();
    }

    public void f(int i) {
        if (this.B) {
            this.f2370g.setBackgroundResource(R.color.transparent);
        } else if (!this.E) {
            this.f2370g.setBackgroundResource(R.color.swipe_layout_normal_bg);
        } else if (i == 1) {
            this.f2370g.setBackgroundResource(R.color.swipe_layout_night_bg);
        } else if (i == 4) {
            this.f2370g.setBackgroundResource(R.color.swipe_layout_dark_bg);
        } else {
            this.f2370g.setBackgroundResource(R.color.swipe_layout_normal_bg);
        }
    }

    public final int g(MotionEvent motionEvent) {
        int i = this.n;
        int h2 = h(motionEvent, i);
        if (j(motionEvent, h2, i)) {
            return 0;
        }
        return (int) Math.abs(MotionEventCompat.getX(motionEvent, h2) - this.l);
    }

    public final int h(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex == -1) {
            this.n = -1;
        }
        return findPointerIndex;
    }

    public final void i(Context context) {
        TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
        this.f2371h = new Scroller(context, new a(1.5f));
        ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop();
        this.w = ViewConfiguration.getMaximumFlingVelocity();
        this.v = ViewConfiguration.getMinimumFlingVelocity();
        this.y = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
        this.x = l.k(context) / 4;
    }

    public final boolean j(MotionEvent motionEvent, int i, int i2) {
        return motionEvent == null || i2 == -1 || i == -1 || i >= motionEvent.getPointerCount();
    }

    public boolean k() {
        return this.q;
    }

    public void l(int i) {
        if (this.q) {
            if (this.B) {
                this.f2370g.setBackgroundResource(R.color.transparent);
            } else if (!this.E) {
                this.f2370g.setBackgroundResource(R.color.swipe_layout_normal_bg);
            } else if (i == 1) {
                this.f2370g.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else if (i == 4) {
                this.f2370g.setBackgroundResource(R.color.swipe_layout_dark_bg);
            } else {
                this.f2370g.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public final boolean m(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 1 || action == 3) {
            if (this.A) {
                this.A = false;
                this.q = true;
                return true;
            } else if (this.C) {
                this.C = false;
                this.q = false;
                return true;
            }
        }
        return false;
    }

    public final void n() {
        VelocityTracker velocityTracker = this.u;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.u.recycle();
            this.u = null;
        }
    }

    public final void o() {
        this.r = true;
        this.f2371h.startScroll(this.f2369f.getScrollX(), 0, -this.f2369f.getScrollX(), 0);
        postInvalidate();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.q) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (!this.p && !this.r) {
            int action = motionEvent.getAction() & 255;
            if (action != 3 && action != 1) {
                if (action == 0) {
                    int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                    int pointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    this.n = pointerId;
                    if (!j(motionEvent, actionIndex, pointerId)) {
                        this.j = MotionEventCompat.getX(motionEvent, actionIndex);
                        this.k = MotionEventCompat.getY(motionEvent, actionIndex);
                        this.l = MotionEventCompat.getX(motionEvent, actionIndex);
                    }
                } else if (action == 2) {
                    c(motionEvent);
                }
                return this.o;
            }
            e();
            return super.onInterceptTouchEvent(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            super.onLayout(z, i, i2, i3, i4);
        } catch (Throwable unused) {
        }
        if (z) {
            this.i = getWidth();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.p && !this.r) {
            if (this.u == null) {
                this.u = VelocityTracker.obtain();
            }
            this.u.addMovement(motionEvent);
            int action = motionEvent.getAction() & 255;
            if (action != 0) {
                float f2 = 0.0f;
                if (action == 1) {
                    VelocityTracker velocityTracker = this.u;
                    velocityTracker.computeCurrentVelocity(1000, this.w);
                    this.z = velocityTracker.getXVelocity();
                    int g2 = g(motionEvent);
                    e();
                    if (Math.abs(this.z) > this.v && g2 > this.x) {
                        if (this.z > 0.0f) {
                            this.p = true;
                            q();
                        } else {
                            o();
                            this.p = false;
                        }
                        b bVar = this.F;
                        if (bVar != null) {
                            bVar.a(this.p);
                        }
                        return true;
                    }
                    if (this.f2369f.getScrollX() <= (-this.i) / 2) {
                        this.p = true;
                        q();
                    } else {
                        o();
                        this.p = false;
                    }
                    b bVar2 = this.F;
                    if (bVar2 != null) {
                        bVar2.a(this.p);
                    }
                } else if (action == 2) {
                    if (this.D) {
                        b();
                        int actionIndex = motionEvent.getActionIndex();
                        this.n = motionEvent.getPointerId(actionIndex);
                        this.j = (motionEvent.getX(actionIndex) - 1.0f) - this.y;
                        this.k = motionEvent.getY(actionIndex);
                        this.l = motionEvent.getX(actionIndex);
                        this.o = false;
                        this.D = false;
                    }
                    if (!this.o) {
                        c(motionEvent);
                    }
                    if (this.o) {
                        int h2 = h(motionEvent, this.n);
                        if (!j(motionEvent, h2, this.n)) {
                            float x = MotionEventCompat.getX(motionEvent, h2);
                            float f3 = this.j - x;
                            this.j = x;
                            float scrollX = getScrollX() + f3;
                            float f4 = -this.i;
                            if (scrollX < f4) {
                                f2 = f4;
                            } else if (scrollX <= 0.0f) {
                                f2 = scrollX;
                            }
                            int i = (int) f2;
                            this.j += f2 - i;
                            this.m = i;
                            this.f2369f.scrollTo(i, getScrollY());
                        }
                    }
                } else if (action == 3) {
                    e();
                    p(10);
                    this.p = false;
                    b bVar3 = this.F;
                    if (bVar3 != null) {
                        bVar3.a(false);
                    }
                }
            } else {
                b();
                int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                this.n = MotionEventCompat.getPointerId(motionEvent, actionIndex2);
                this.j = motionEvent.getX();
                this.l = MotionEventCompat.getX(motionEvent, actionIndex2);
            }
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void p(int i) {
        this.r = true;
        this.f2371h.startScroll(this.f2369f.getScrollX(), 0, -this.f2369f.getScrollX(), 0, i);
        postInvalidate();
    }

    public final void q() {
        this.r = true;
        this.f2371h.startScroll(this.f2369f.getScrollX(), 0, (-(this.i + this.f2369f.getScrollX())) + 1, 0);
        postInvalidate();
    }

    public void r(double d2) {
        if (d2 != 1.0d) {
            if (d2 == 2.0d) {
                this.p = true;
                q();
                return;
            }
            return;
        }
        if (!this.q) {
            this.C = true;
        }
        this.D = true;
        this.q = true;
        this.o = true;
    }

    public void setBgTransparent() {
        this.B = true;
        ViewGroup viewGroup = this.f2370g;
        if (viewGroup != null) {
            viewGroup.setBackgroundResource(R.color.transparent);
        }
    }

    public void setIsSupportNight(boolean z) {
        if (!z) {
            if (this.B) {
                this.f2370g.setBackgroundResource(R.color.transparent);
            } else {
                this.f2370g.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
        this.E = z;
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        this.F = bVar;
    }

    public void setSwipeBackEnabled(boolean z) {
        this.q = z;
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.n = -1;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = false;
        this.s = 0;
        this.t = new Rect();
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        i(context);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = -1;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = false;
        this.s = 0;
        this.t = new Rect();
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        i(context);
    }
}
