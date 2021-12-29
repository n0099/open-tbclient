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
    public int f36595b;

    /* renamed from: c  reason: collision with root package name */
    public int f36596c;

    /* renamed from: d  reason: collision with root package name */
    public long f36597d;

    /* renamed from: e  reason: collision with root package name */
    public View f36598e;

    /* renamed from: f  reason: collision with root package name */
    public DismissCallbacks f36599f;

    /* renamed from: g  reason: collision with root package name */
    public int f36600g;

    /* renamed from: h  reason: collision with root package name */
    public float f36601h;

    /* renamed from: i  reason: collision with root package name */
    public float f36602i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f36603j;

    /* renamed from: k  reason: collision with root package name */
    public int f36604k;
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
        this.f36600g = 1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.a = viewConfiguration.getScaledTouchSlop();
        this.f36595b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f36596c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f36597d = view.getContext().getResources().getInteger(17694720);
        this.f36598e = view;
        view.getContext();
        this.l = obj;
        this.f36599f = dismissCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.f36598e.getLayoutParams();
            int height = this.f36598e.getHeight();
            ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.f36597d);
            duration.addListener(new q(this, layoutParams, height));
            duration.addUpdateListener(new r(this, layoutParams));
            duration.start();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r10.m == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        r10.f36598e.animate().translationX(0.0f).setDuration(r10.f36597d).setListener(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x018f, code lost:
        if (r10.f36603j != false) goto L14;
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
            if (this.f36600g < 2) {
                this.f36600g = this.f36598e.getWidth();
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f36601h = motionEvent.getRawX();
                this.f36602i = motionEvent.getRawY();
                if (this.f36599f.canDismiss(this.l)) {
                    this.o = false;
                    VelocityTracker obtain = VelocityTracker.obtain();
                    this.m = obtain;
                    obtain.addMovement(motionEvent);
                }
                return true;
            }
            if (actionMasked == 1) {
                if (this.m != null) {
                    float rawX = motionEvent.getRawX() - this.f36601h;
                    this.m.addMovement(motionEvent);
                    this.m.computeCurrentVelocity(1000);
                    float xVelocity = this.m.getXVelocity();
                    float abs = Math.abs(xVelocity);
                    float abs2 = Math.abs(this.m.getYVelocity());
                    if (Math.abs(rawX) > this.f36600g / 3 && this.f36603j) {
                        z = rawX > 0.0f;
                    } else if (this.f36595b > abs || abs > this.f36596c || abs2 >= abs || i2 >= 0 || !this.f36603j) {
                        z = false;
                        r3 = false;
                    } else {
                        r3 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX > 0.0f ? 1 : (rawX == 0.0f ? 0 : -1)) < 0);
                        z = this.m.getXVelocity() > 0.0f;
                    }
                    if (r3) {
                        this.f36598e.animate().translationX(z ? this.f36600g : -this.f36600g).setDuration(this.f36597d).setListener(new p(this));
                    }
                }
                return false;
            }
            if (actionMasked == 2) {
                VelocityTracker velocityTracker = this.m;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    float rawX2 = motionEvent.getRawX() - this.f36601h;
                    float rawY = motionEvent.getRawY() - this.f36602i;
                    if (Math.abs(rawX2) > this.a && Math.abs(rawY) < Math.abs(rawX2) / 2.0f) {
                        this.f36603j = true;
                        this.f36604k = rawX2 > 0.0f ? this.a : -this.a;
                        this.f36598e.getParent().requestDisallowInterceptTouchEvent(true);
                        if (!this.o) {
                            this.o = true;
                            this.f36599f.onNotify();
                        }
                        if (Math.abs(rawX2) <= this.f36600g / 3) {
                            this.p = false;
                        } else if (!this.p) {
                            this.p = true;
                            this.f36599f.onNotify();
                        }
                        MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                        obtain2.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.f36598e.onTouchEvent(obtain2);
                        obtain2.recycle();
                    }
                    if (this.f36603j) {
                        this.n = rawX2;
                        this.f36598e.setTranslationX(rawX2 - this.f36604k);
                        return true;
                    }
                }
            } else if (actionMasked == 3) {
            }
            return false;
            this.m.recycle();
            this.m = null;
            this.n = 0.0f;
            this.f36601h = 0.0f;
            this.f36602i = 0.0f;
            this.f36603j = false;
            return false;
        }
        return invokeLL.booleanValue;
    }
}
