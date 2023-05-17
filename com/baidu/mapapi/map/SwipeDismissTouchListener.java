package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
/* loaded from: classes3.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {
    public int a;
    public int b;
    public int c;
    public long d;
    public View e;
    public DismissCallbacks f;
    public int g = 1;
    public float h;
    public float i;
    public boolean j;
    public int k;
    public Object l;
    public VelocityTracker m;
    public float n;
    public boolean o;
    public boolean p;

    /* loaded from: classes3.dex */
    public interface DismissCallbacks {
        boolean canDismiss(Object obj);

        void onDismiss(View view2, Object obj);

        void onNotify();
    }

    public SwipeDismissTouchListener(View view2, Object obj, DismissCallbacks dismissCallbacks) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view2.getContext());
        this.a = viewConfiguration.getScaledTouchSlop();
        this.b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.d = view2.getContext().getResources().getInteger(17694720);
        this.e = view2;
        view2.getContext();
        this.l = obj;
        this.f = dismissCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void a() {
        ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        int height = this.e.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.d);
        duration.addListener(new x(this, layoutParams, height));
        duration.addUpdateListener(new y(this, layoutParams));
        duration.start();
    }

    @Override // android.view.View.OnTouchListener
    @TargetApi(12)
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        boolean z;
        int i;
        boolean z2;
        boolean z3;
        boolean z4;
        int i2;
        int i3;
        motionEvent.offsetLocation(this.n, 0.0f);
        if (this.g < 2) {
            this.g = this.e.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        boolean z5 = true;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked == 3 && this.m != null) {
                        this.e.animate().translationX(0.0f).setDuration(this.d).setListener(null);
                        this.m.recycle();
                        this.m = null;
                        this.n = 0.0f;
                        this.h = 0.0f;
                        this.i = 0.0f;
                        this.j = false;
                    }
                } else {
                    VelocityTracker velocityTracker = this.m;
                    if (velocityTracker != null) {
                        velocityTracker.addMovement(motionEvent);
                        float rawX = motionEvent.getRawX() - this.h;
                        float rawY = motionEvent.getRawY() - this.i;
                        if (Math.abs(rawX) > this.a && Math.abs(rawY) < Math.abs(rawX) / 2.0f) {
                            this.j = true;
                            if (rawX > 0.0f) {
                                i3 = this.a;
                            } else {
                                i3 = -this.a;
                            }
                            this.k = i3;
                            this.e.getParent().requestDisallowInterceptTouchEvent(true);
                            if (!this.o) {
                                this.o = true;
                                this.f.onNotify();
                            }
                            if (Math.abs(rawX) > this.g / 3) {
                                if (!this.p) {
                                    this.p = true;
                                    this.f.onNotify();
                                }
                            } else {
                                this.p = false;
                            }
                            MotionEvent obtain = MotionEvent.obtain(motionEvent);
                            obtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                            this.e.onTouchEvent(obtain);
                            obtain.recycle();
                        }
                        if (this.j) {
                            this.n = rawX;
                            this.e.setTranslationX(rawX - this.k);
                            return true;
                        }
                    }
                }
            } else if (this.m != null) {
                float rawX2 = motionEvent.getRawX() - this.h;
                this.m.addMovement(motionEvent);
                this.m.computeCurrentVelocity(1000);
                float xVelocity = this.m.getXVelocity();
                float abs = Math.abs(xVelocity);
                float abs2 = Math.abs(this.m.getYVelocity());
                if (Math.abs(rawX2) > this.g / 3 && this.j) {
                    if (rawX2 > 0.0f) {
                        z = true;
                    } else {
                        z = false;
                    }
                } else if (this.b <= abs && abs <= this.c && abs2 < abs && i < 0 && this.j) {
                    if (xVelocity < 0.0f) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (rawX2 < 0.0f) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (z2 == z3) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (this.m.getXVelocity() <= 0.0f) {
                        z5 = false;
                    }
                    boolean z6 = z5;
                    z5 = z4;
                    z = z6;
                } else {
                    z = false;
                    z5 = false;
                }
                if (z5) {
                    ViewPropertyAnimator animate = this.e.animate();
                    if (z) {
                        i2 = this.g;
                    } else {
                        i2 = -this.g;
                    }
                    animate.translationX(i2).setDuration(this.d).setListener(new w(this));
                } else if (this.j) {
                    this.e.animate().translationX(0.0f).setDuration(this.d).setListener(null);
                }
                this.m.recycle();
                this.m = null;
                this.n = 0.0f;
                this.h = 0.0f;
                this.i = 0.0f;
                this.j = false;
            }
            return false;
        }
        this.h = motionEvent.getRawX();
        this.i = motionEvent.getRawY();
        if (this.f.canDismiss(this.l)) {
            this.o = false;
            VelocityTracker obtain2 = VelocityTracker.obtain();
            this.m = obtain2;
            obtain2.addMovement(motionEvent);
        }
        return true;
    }
}
