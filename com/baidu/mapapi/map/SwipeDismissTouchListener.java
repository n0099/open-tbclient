package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
/* loaded from: classes2.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    public int f7038a;

    /* renamed from: b  reason: collision with root package name */
    public int f7039b;

    /* renamed from: c  reason: collision with root package name */
    public int f7040c;

    /* renamed from: d  reason: collision with root package name */
    public long f7041d;

    /* renamed from: e  reason: collision with root package name */
    public View f7042e;

    /* renamed from: f  reason: collision with root package name */
    public DismissCallbacks f7043f;

    /* renamed from: g  reason: collision with root package name */
    public int f7044g = 1;

    /* renamed from: h  reason: collision with root package name */
    public float f7045h;

    /* renamed from: i  reason: collision with root package name */
    public float f7046i;
    public boolean j;
    public int k;
    public Object l;
    public VelocityTracker m;
    public float n;
    public boolean o;
    public boolean p;

    /* loaded from: classes2.dex */
    public interface DismissCallbacks {
        boolean canDismiss(Object obj);

        void onDismiss(View view, Object obj);

        void onNotify();
    }

    public SwipeDismissTouchListener(View view, Object obj, DismissCallbacks dismissCallbacks) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.f7038a = viewConfiguration.getScaledTouchSlop();
        this.f7039b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f7040c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f7041d = view.getContext().getResources().getInteger(17694720);
        this.f7042e = view;
        view.getContext();
        this.l = obj;
        this.f7043f = dismissCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void a() {
        ViewGroup.LayoutParams layoutParams = this.f7042e.getLayoutParams();
        int height = this.f7042e.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.f7041d);
        duration.addListener(new q(this, layoutParams, height));
        duration.addUpdateListener(new r(this, layoutParams));
        duration.start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r10.m == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        r10.f7042e.animate().translationX(0.0f).setDuration(r10.f7041d).setListener(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x018b, code lost:
        if (r10.j != false) goto L12;
     */
    @Override // android.view.View.OnTouchListener
    @TargetApi(12)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        int i2;
        motionEvent.offsetLocation(this.n, 0.0f);
        if (this.f7044g < 2) {
            this.f7044g = this.f7042e.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f7045h = motionEvent.getRawX();
            this.f7046i = motionEvent.getRawY();
            if (this.f7043f.canDismiss(this.l)) {
                this.o = false;
                VelocityTracker obtain = VelocityTracker.obtain();
                this.m = obtain;
                obtain.addMovement(motionEvent);
            }
            return true;
        }
        if (actionMasked == 1) {
            if (this.m != null) {
                float rawX = motionEvent.getRawX() - this.f7045h;
                this.m.addMovement(motionEvent);
                this.m.computeCurrentVelocity(1000);
                float xVelocity = this.m.getXVelocity();
                float abs = Math.abs(xVelocity);
                float abs2 = Math.abs(this.m.getYVelocity());
                if (Math.abs(rawX) > this.f7044g / 3 && this.j) {
                    z = rawX > 0.0f;
                } else if (this.f7039b > abs || abs > this.f7040c || abs2 >= abs || i2 >= 0 || !this.j) {
                    z = false;
                    r3 = false;
                } else {
                    r3 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX > 0.0f ? 1 : (rawX == 0.0f ? 0 : -1)) < 0);
                    z = this.m.getXVelocity() > 0.0f;
                }
                if (r3) {
                    this.f7042e.animate().translationX(z ? this.f7044g : -this.f7044g).setDuration(this.f7041d).setListener(new p(this));
                }
            }
            return false;
        }
        if (actionMasked == 2) {
            VelocityTracker velocityTracker = this.m;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
                float rawX2 = motionEvent.getRawX() - this.f7045h;
                float rawY = motionEvent.getRawY() - this.f7046i;
                if (Math.abs(rawX2) > this.f7038a && Math.abs(rawY) < Math.abs(rawX2) / 2.0f) {
                    this.j = true;
                    this.k = rawX2 > 0.0f ? this.f7038a : -this.f7038a;
                    this.f7042e.getParent().requestDisallowInterceptTouchEvent(true);
                    if (!this.o) {
                        this.o = true;
                        this.f7043f.onNotify();
                    }
                    if (Math.abs(rawX2) <= this.f7044g / 3) {
                        this.p = false;
                    } else if (!this.p) {
                        this.p = true;
                        this.f7043f.onNotify();
                    }
                    MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                    obtain2.setAction((motionEvent.getActionIndex() << 8) | 3);
                    this.f7042e.onTouchEvent(obtain2);
                    obtain2.recycle();
                }
                if (this.j) {
                    this.n = rawX2;
                    this.f7042e.setTranslationX(rawX2 - this.k);
                    return true;
                }
            }
        } else if (actionMasked == 3) {
        }
        return false;
        this.m.recycle();
        this.m = null;
        this.n = 0.0f;
        this.f7045h = 0.0f;
        this.f7046i = 0.0f;
        this.j = false;
        return false;
    }
}
