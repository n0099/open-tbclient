package com.baidu.mapapi.map;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes10.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f35391b;

    /* renamed from: c  reason: collision with root package name */
    public int f35392c;

    /* renamed from: d  reason: collision with root package name */
    public long f35393d;

    /* renamed from: e  reason: collision with root package name */
    public View f35394e;

    /* renamed from: f  reason: collision with root package name */
    public DismissCallbacks f35395f;

    /* renamed from: g  reason: collision with root package name */
    public int f35396g;

    /* renamed from: h  reason: collision with root package name */
    public float f35397h;

    /* renamed from: i  reason: collision with root package name */
    public float f35398i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f35399j;
    public int k;
    public Object l;
    public VelocityTracker m;
    public float n;
    public boolean o;
    public boolean p;

    /* loaded from: classes10.dex */
    public interface DismissCallbacks {
        boolean canDismiss(Object obj);

        void onDismiss(View view, Object obj);

        void onNotify();
    }

    public SwipeDismissTouchListener(View view, Object obj, DismissCallbacks dismissCallbacks) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {view, obj, dismissCallbacks};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f35396g = 1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.a = viewConfiguration.getScaledTouchSlop();
        this.f35391b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f35392c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f35393d = view.getContext().getResources().getInteger(17694720);
        this.f35394e = view;
        view.getContext();
        this.l = obj;
        this.f35395f = dismissCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.f35394e.getLayoutParams();
            int height = this.f35394e.getHeight();
            ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.f35393d);
            duration.addListener(new q(this, layoutParams, height));
            duration.addUpdateListener(new r(this, layoutParams));
            duration.start();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r10.m == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        r10.f35394e.animate().translationX(0.0f).setDuration(r10.f35393d).setListener(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x018f, code lost:
        if (r10.f35399j != false) goto L14;
     */
    @Override // android.view.View.OnTouchListener
    @TargetApi(12)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        boolean z;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
            motionEvent.offsetLocation(this.n, 0.0f);
            if (this.f35396g < 2) {
                this.f35396g = this.f35394e.getWidth();
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f35397h = motionEvent.getRawX();
                this.f35398i = motionEvent.getRawY();
                if (this.f35395f.canDismiss(this.l)) {
                    this.o = false;
                    VelocityTracker obtain = VelocityTracker.obtain();
                    this.m = obtain;
                    obtain.addMovement(motionEvent);
                }
                return true;
            }
            if (actionMasked == 1) {
                if (this.m != null) {
                    float rawX = motionEvent.getRawX() - this.f35397h;
                    this.m.addMovement(motionEvent);
                    this.m.computeCurrentVelocity(1000);
                    float xVelocity = this.m.getXVelocity();
                    float abs = Math.abs(xVelocity);
                    float abs2 = Math.abs(this.m.getYVelocity());
                    if (Math.abs(rawX) > this.f35396g / 3 && this.f35399j) {
                        z = rawX > 0.0f;
                    } else if (this.f35391b > abs || abs > this.f35392c || abs2 >= abs || i2 >= 0 || !this.f35399j) {
                        z = false;
                        r3 = false;
                    } else {
                        r3 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX > 0.0f ? 1 : (rawX == 0.0f ? 0 : -1)) < 0);
                        z = this.m.getXVelocity() > 0.0f;
                    }
                    if (r3) {
                        this.f35394e.animate().translationX(z ? this.f35396g : -this.f35396g).setDuration(this.f35393d).setListener(new p(this));
                    }
                }
                return false;
            }
            if (actionMasked == 2) {
                VelocityTracker velocityTracker = this.m;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    float rawX2 = motionEvent.getRawX() - this.f35397h;
                    float rawY = motionEvent.getRawY() - this.f35398i;
                    if (Math.abs(rawX2) > this.a && Math.abs(rawY) < Math.abs(rawX2) / 2.0f) {
                        this.f35399j = true;
                        this.k = rawX2 > 0.0f ? this.a : -this.a;
                        this.f35394e.getParent().requestDisallowInterceptTouchEvent(true);
                        if (!this.o) {
                            this.o = true;
                            this.f35395f.onNotify();
                        }
                        if (Math.abs(rawX2) <= this.f35396g / 3) {
                            this.p = false;
                        } else if (!this.p) {
                            this.p = true;
                            this.f35395f.onNotify();
                        }
                        MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                        obtain2.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.f35394e.onTouchEvent(obtain2);
                        obtain2.recycle();
                    }
                    if (this.f35399j) {
                        this.n = rawX2;
                        this.f35394e.setTranslationX(rawX2 - this.k);
                        return true;
                    }
                }
            } else if (actionMasked == 3) {
            }
            return false;
            this.m.recycle();
            this.m = null;
            this.n = 0.0f;
            this.f35397h = 0.0f;
            this.f35398i = 0.0f;
            this.f35399j = false;
            return false;
        }
        return invokeLL.booleanValue;
    }
}
