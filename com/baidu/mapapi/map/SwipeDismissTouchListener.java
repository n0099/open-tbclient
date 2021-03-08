package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
/* loaded from: classes4.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private int f2046a;
    private int b;
    private int c;
    private long d;
    private View e;
    private DismissCallbacks f;
    private int g = 1;
    private float h;
    private float i;
    private boolean j;
    private int k;
    private Object l;
    private VelocityTracker m;
    private float n;
    private boolean o;
    private boolean p;

    /* loaded from: classes4.dex */
    public interface DismissCallbacks {
        boolean canDismiss(Object obj);

        void onDismiss(View view, Object obj);

        void onNotify();
    }

    public SwipeDismissTouchListener(View view, Object obj, DismissCallbacks dismissCallbacks) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.f2046a = viewConfiguration.getScaledTouchSlop();
        this.b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.d = view.getContext().getResources().getInteger(17694720);
        this.e = view;
        this.e.getContext();
        this.l = obj;
        this.f = dismissCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void a() {
        ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
        int height = this.e.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.d);
        duration.addListener(new p(this, layoutParams, height));
        duration.addUpdateListener(new q(this, layoutParams));
        duration.start();
    }

    @Override // android.view.View.OnTouchListener
    @TargetApi(12)
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        motionEvent.offsetLocation(this.n, 0.0f);
        if (this.g < 2) {
            this.g = this.e.getWidth();
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.h = motionEvent.getRawX();
                this.i = motionEvent.getRawY();
                if (this.f.canDismiss(this.l)) {
                    this.o = false;
                    this.m = VelocityTracker.obtain();
                    this.m.addMovement(motionEvent);
                    return true;
                }
                return true;
            case 1:
                if (this.m != null) {
                    float rawX = motionEvent.getRawX() - this.h;
                    this.m.addMovement(motionEvent);
                    this.m.computeCurrentVelocity(1000);
                    float xVelocity = this.m.getXVelocity();
                    float abs = Math.abs(xVelocity);
                    float abs2 = Math.abs(this.m.getYVelocity());
                    if (Math.abs(rawX) > this.g / 3 && this.j) {
                        z = rawX > 0.0f;
                        z2 = true;
                    } else if (this.b > abs || abs > this.c || abs2 >= abs || abs2 >= abs || !this.j) {
                        z = false;
                        z2 = false;
                    } else {
                        boolean z3 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX > 0.0f ? 1 : (rawX == 0.0f ? 0 : -1)) < 0);
                        z = this.m.getXVelocity() > 0.0f;
                        z2 = z3;
                    }
                    if (z2) {
                        this.e.animate().translationX(z ? this.g : -this.g).setDuration(this.d).setListener(new o(this));
                    } else if (this.j) {
                        this.e.animate().translationX(0.0f).setDuration(this.d).setListener(null);
                    }
                    this.m.recycle();
                    this.m = null;
                    this.n = 0.0f;
                    this.h = 0.0f;
                    this.i = 0.0f;
                    this.j = false;
                    break;
                }
                break;
            case 2:
                if (this.m != null) {
                    this.m.addMovement(motionEvent);
                    float rawX2 = motionEvent.getRawX() - this.h;
                    float rawY = motionEvent.getRawY() - this.i;
                    if (Math.abs(rawX2) > this.f2046a && Math.abs(rawY) < Math.abs(rawX2) / 2.0f) {
                        this.j = true;
                        this.k = rawX2 > 0.0f ? this.f2046a : -this.f2046a;
                        this.e.getParent().requestDisallowInterceptTouchEvent(true);
                        if (!this.o) {
                            this.o = true;
                            this.f.onNotify();
                        }
                        if (Math.abs(rawX2) <= this.g / 3) {
                            this.p = false;
                        } else if (!this.p) {
                            this.p = true;
                            this.f.onNotify();
                        }
                        MotionEvent obtain = MotionEvent.obtain(motionEvent);
                        obtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.e.onTouchEvent(obtain);
                        obtain.recycle();
                    }
                    if (this.j) {
                        this.n = rawX2;
                        this.e.setTranslationX(rawX2 - this.k);
                        return true;
                    }
                }
                break;
            case 3:
                if (this.m != null) {
                    this.e.animate().translationX(0.0f).setDuration(this.d).setListener(null);
                    this.m.recycle();
                    this.m = null;
                    this.n = 0.0f;
                    this.h = 0.0f;
                    this.i = 0.0f;
                    this.j = false;
                    break;
                }
                break;
        }
        return false;
    }
}
