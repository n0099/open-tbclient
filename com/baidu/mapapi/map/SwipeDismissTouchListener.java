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
    public int f7095a;

    /* renamed from: b  reason: collision with root package name */
    public int f7096b;

    /* renamed from: c  reason: collision with root package name */
    public int f7097c;

    /* renamed from: d  reason: collision with root package name */
    public long f7098d;

    /* renamed from: e  reason: collision with root package name */
    public View f7099e;

    /* renamed from: f  reason: collision with root package name */
    public DismissCallbacks f7100f;

    /* renamed from: g  reason: collision with root package name */
    public int f7101g = 1;

    /* renamed from: h  reason: collision with root package name */
    public float f7102h;

    /* renamed from: i  reason: collision with root package name */
    public float f7103i;
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
        this.f7095a = viewConfiguration.getScaledTouchSlop();
        this.f7096b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f7097c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f7098d = view.getContext().getResources().getInteger(17694720);
        this.f7099e = view;
        view.getContext();
        this.l = obj;
        this.f7100f = dismissCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void a() {
        ViewGroup.LayoutParams layoutParams = this.f7099e.getLayoutParams();
        int height = this.f7099e.getHeight();
        ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.f7098d);
        duration.addListener(new q(this, layoutParams, height));
        duration.addUpdateListener(new r(this, layoutParams));
        duration.start();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r10.m == null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        r10.f7099e.animate().translationX(0.0f).setDuration(r10.f7098d).setListener(null);
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
        if (this.f7101g < 2) {
            this.f7101g = this.f7099e.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f7102h = motionEvent.getRawX();
            this.f7103i = motionEvent.getRawY();
            if (this.f7100f.canDismiss(this.l)) {
                this.o = false;
                VelocityTracker obtain = VelocityTracker.obtain();
                this.m = obtain;
                obtain.addMovement(motionEvent);
            }
            return true;
        }
        if (actionMasked == 1) {
            if (this.m != null) {
                float rawX = motionEvent.getRawX() - this.f7102h;
                this.m.addMovement(motionEvent);
                this.m.computeCurrentVelocity(1000);
                float xVelocity = this.m.getXVelocity();
                float abs = Math.abs(xVelocity);
                float abs2 = Math.abs(this.m.getYVelocity());
                if (Math.abs(rawX) > this.f7101g / 3 && this.j) {
                    z = rawX > 0.0f;
                } else if (this.f7096b > abs || abs > this.f7097c || abs2 >= abs || i2 >= 0 || !this.j) {
                    z = false;
                    r3 = false;
                } else {
                    r3 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX > 0.0f ? 1 : (rawX == 0.0f ? 0 : -1)) < 0);
                    z = this.m.getXVelocity() > 0.0f;
                }
                if (r3) {
                    this.f7099e.animate().translationX(z ? this.f7101g : -this.f7101g).setDuration(this.f7098d).setListener(new p(this));
                }
            }
            return false;
        }
        if (actionMasked == 2) {
            VelocityTracker velocityTracker = this.m;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
                float rawX2 = motionEvent.getRawX() - this.f7102h;
                float rawY = motionEvent.getRawY() - this.f7103i;
                if (Math.abs(rawX2) > this.f7095a && Math.abs(rawY) < Math.abs(rawX2) / 2.0f) {
                    this.j = true;
                    this.k = rawX2 > 0.0f ? this.f7095a : -this.f7095a;
                    this.f7099e.getParent().requestDisallowInterceptTouchEvent(true);
                    if (!this.o) {
                        this.o = true;
                        this.f7100f.onNotify();
                    }
                    if (Math.abs(rawX2) <= this.f7101g / 3) {
                        this.p = false;
                    } else if (!this.p) {
                        this.p = true;
                        this.f7100f.onNotify();
                    }
                    MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                    obtain2.setAction((motionEvent.getActionIndex() << 8) | 3);
                    this.f7099e.onTouchEvent(obtain2);
                    obtain2.recycle();
                }
                if (this.j) {
                    this.n = rawX2;
                    this.f7099e.setTranslationX(rawX2 - this.k);
                    return true;
                }
            }
        } else if (actionMasked == 3) {
        }
        return false;
        this.m.recycle();
        this.m = null;
        this.n = 0.0f;
        this.f7102h = 0.0f;
        this.f7103i = 0.0f;
        this.j = false;
        return false;
    }
}
