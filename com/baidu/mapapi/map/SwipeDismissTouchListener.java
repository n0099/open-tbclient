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
    public int f6994a;

    /* renamed from: b  reason: collision with root package name */
    public int f6995b;

    /* renamed from: c  reason: collision with root package name */
    public int f6996c;

    /* renamed from: d  reason: collision with root package name */
    public long f6997d;

    /* renamed from: e  reason: collision with root package name */
    public View f6998e;

    /* renamed from: f  reason: collision with root package name */
    public DismissCallbacks f6999f;

    /* renamed from: g  reason: collision with root package name */
    public int f7000g = 1;

    /* renamed from: h  reason: collision with root package name */
    public float f7001h;
    public float i;
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
        this.f6994a = viewConfiguration.getScaledTouchSlop();
        this.f6995b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f6996c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f6997d = view.getContext().getResources().getInteger(17694720);
        this.f6998e = view;
        view.getContext();
        this.l = obj;
        this.f6999f = dismissCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void a() {
        ViewGroup.LayoutParams layoutParams = this.f6998e.getLayoutParams();
        int height = this.f6998e.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.f6997d);
        duration.addListener(new p(this, layoutParams, height));
        duration.addUpdateListener(new q(this, layoutParams));
        duration.start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r10.m == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        r10.f6998e.animate().translationX(0.0f).setDuration(r10.f6997d).setListener(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x018d, code lost:
        if (r10.j != false) goto L12;
     */
    @Override // android.view.View.OnTouchListener
    @TargetApi(12)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        motionEvent.offsetLocation(this.n, 0.0f);
        if (this.f7000g < 2) {
            this.f7000g = this.f6998e.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f7001h = motionEvent.getRawX();
            this.i = motionEvent.getRawY();
            if (this.f6999f.canDismiss(this.l)) {
                this.o = false;
                VelocityTracker obtain = VelocityTracker.obtain();
                this.m = obtain;
                obtain.addMovement(motionEvent);
            }
            return true;
        }
        if (actionMasked == 1) {
            if (this.m != null) {
                float rawX = motionEvent.getRawX() - this.f7001h;
                this.m.addMovement(motionEvent);
                this.m.computeCurrentVelocity(1000);
                float xVelocity = this.m.getXVelocity();
                float abs = Math.abs(xVelocity);
                float abs2 = Math.abs(this.m.getYVelocity());
                if (Math.abs(rawX) > this.f7000g / 3 && this.j) {
                    z = rawX > 0.0f;
                } else if (this.f6995b > abs || abs > this.f6996c || abs2 >= abs || abs2 >= abs || !this.j) {
                    z = false;
                    r3 = false;
                } else {
                    r3 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX > 0.0f ? 1 : (rawX == 0.0f ? 0 : -1)) < 0);
                    z = this.m.getXVelocity() > 0.0f;
                }
                if (r3) {
                    this.f6998e.animate().translationX(z ? this.f7000g : -this.f7000g).setDuration(this.f6997d).setListener(new o(this));
                }
            }
            return false;
        }
        if (actionMasked == 2) {
            VelocityTracker velocityTracker = this.m;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
                float rawX2 = motionEvent.getRawX() - this.f7001h;
                float rawY = motionEvent.getRawY() - this.i;
                if (Math.abs(rawX2) > this.f6994a && Math.abs(rawY) < Math.abs(rawX2) / 2.0f) {
                    this.j = true;
                    this.k = rawX2 > 0.0f ? this.f6994a : -this.f6994a;
                    this.f6998e.getParent().requestDisallowInterceptTouchEvent(true);
                    if (!this.o) {
                        this.o = true;
                        this.f6999f.onNotify();
                    }
                    if (Math.abs(rawX2) <= this.f7000g / 3) {
                        this.p = false;
                    } else if (!this.p) {
                        this.p = true;
                        this.f6999f.onNotify();
                    }
                    MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                    obtain2.setAction((motionEvent.getActionIndex() << 8) | 3);
                    this.f6998e.onTouchEvent(obtain2);
                    obtain2.recycle();
                }
                if (this.j) {
                    this.n = rawX2;
                    this.f6998e.setTranslationX(rawX2 - this.k);
                    return true;
                }
            }
        } else if (actionMasked == 3) {
        }
        return false;
        this.m.recycle();
        this.m = null;
        this.n = 0.0f;
        this.f7001h = 0.0f;
        this.i = 0.0f;
        this.j = false;
        return false;
    }
}
