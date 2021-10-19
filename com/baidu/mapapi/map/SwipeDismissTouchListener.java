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
/* loaded from: classes5.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f41647a;

    /* renamed from: b  reason: collision with root package name */
    public int f41648b;

    /* renamed from: c  reason: collision with root package name */
    public int f41649c;

    /* renamed from: d  reason: collision with root package name */
    public long f41650d;

    /* renamed from: e  reason: collision with root package name */
    public View f41651e;

    /* renamed from: f  reason: collision with root package name */
    public DismissCallbacks f41652f;

    /* renamed from: g  reason: collision with root package name */
    public int f41653g;

    /* renamed from: h  reason: collision with root package name */
    public float f41654h;

    /* renamed from: i  reason: collision with root package name */
    public float f41655i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f41656j;
    public int k;
    public Object l;
    public VelocityTracker m;
    public float n;
    public boolean o;
    public boolean p;

    /* loaded from: classes5.dex */
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
        this.f41653g = 1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.f41647a = viewConfiguration.getScaledTouchSlop();
        this.f41648b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f41649c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f41650d = view.getContext().getResources().getInteger(17694720);
        this.f41651e = view;
        view.getContext();
        this.l = obj;
        this.f41652f = dismissCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.f41651e.getLayoutParams();
            int height = this.f41651e.getHeight();
            ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.f41650d);
            duration.addListener(new q(this, layoutParams, height));
            duration.addUpdateListener(new r(this, layoutParams));
            duration.start();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r10.m == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        r10.f41651e.animate().translationX(0.0f).setDuration(r10.f41650d).setListener(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x018f, code lost:
        if (r10.f41656j != false) goto L14;
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
            if (this.f41653g < 2) {
                this.f41653g = this.f41651e.getWidth();
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f41654h = motionEvent.getRawX();
                this.f41655i = motionEvent.getRawY();
                if (this.f41652f.canDismiss(this.l)) {
                    this.o = false;
                    VelocityTracker obtain = VelocityTracker.obtain();
                    this.m = obtain;
                    obtain.addMovement(motionEvent);
                }
                return true;
            }
            if (actionMasked == 1) {
                if (this.m != null) {
                    float rawX = motionEvent.getRawX() - this.f41654h;
                    this.m.addMovement(motionEvent);
                    this.m.computeCurrentVelocity(1000);
                    float xVelocity = this.m.getXVelocity();
                    float abs = Math.abs(xVelocity);
                    float abs2 = Math.abs(this.m.getYVelocity());
                    if (Math.abs(rawX) > this.f41653g / 3 && this.f41656j) {
                        z = rawX > 0.0f;
                    } else if (this.f41648b > abs || abs > this.f41649c || abs2 >= abs || i2 >= 0 || !this.f41656j) {
                        z = false;
                        r3 = false;
                    } else {
                        r3 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX > 0.0f ? 1 : (rawX == 0.0f ? 0 : -1)) < 0);
                        z = this.m.getXVelocity() > 0.0f;
                    }
                    if (r3) {
                        this.f41651e.animate().translationX(z ? this.f41653g : -this.f41653g).setDuration(this.f41650d).setListener(new p(this));
                    }
                }
                return false;
            }
            if (actionMasked == 2) {
                VelocityTracker velocityTracker = this.m;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    float rawX2 = motionEvent.getRawX() - this.f41654h;
                    float rawY = motionEvent.getRawY() - this.f41655i;
                    if (Math.abs(rawX2) > this.f41647a && Math.abs(rawY) < Math.abs(rawX2) / 2.0f) {
                        this.f41656j = true;
                        this.k = rawX2 > 0.0f ? this.f41647a : -this.f41647a;
                        this.f41651e.getParent().requestDisallowInterceptTouchEvent(true);
                        if (!this.o) {
                            this.o = true;
                            this.f41652f.onNotify();
                        }
                        if (Math.abs(rawX2) <= this.f41653g / 3) {
                            this.p = false;
                        } else if (!this.p) {
                            this.p = true;
                            this.f41652f.onNotify();
                        }
                        MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                        obtain2.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.f41651e.onTouchEvent(obtain2);
                        obtain2.recycle();
                    }
                    if (this.f41656j) {
                        this.n = rawX2;
                        this.f41651e.setTranslationX(rawX2 - this.k);
                        return true;
                    }
                }
            } else if (actionMasked == 3) {
            }
            return false;
            this.m.recycle();
            this.m = null;
            this.n = 0.0f;
            this.f41654h = 0.0f;
            this.f41655i = 0.0f;
            this.f41656j = false;
            return false;
        }
        return invokeLL.booleanValue;
    }
}
