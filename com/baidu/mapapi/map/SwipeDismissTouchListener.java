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
/* loaded from: classes2.dex */
public class SwipeDismissTouchListener implements View.OnTouchListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f7085a;

    /* renamed from: b  reason: collision with root package name */
    public int f7086b;

    /* renamed from: c  reason: collision with root package name */
    public int f7087c;

    /* renamed from: d  reason: collision with root package name */
    public long f7088d;

    /* renamed from: e  reason: collision with root package name */
    public View f7089e;

    /* renamed from: f  reason: collision with root package name */
    public DismissCallbacks f7090f;

    /* renamed from: g  reason: collision with root package name */
    public int f7091g;

    /* renamed from: h  reason: collision with root package name */
    public float f7092h;

    /* renamed from: i  reason: collision with root package name */
    public float f7093i;
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
        this.f7091g = 1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.f7085a = viewConfiguration.getScaledTouchSlop();
        this.f7086b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f7087c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f7088d = view.getContext().getResources().getInteger(17694720);
        this.f7089e = view;
        view.getContext();
        this.l = obj;
        this.f7090f = dismissCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.f7089e.getLayoutParams();
            int height = this.f7089e.getHeight();
            ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.f7088d);
            duration.addListener(new q(this, layoutParams, height));
            duration.addUpdateListener(new r(this, layoutParams));
            duration.start();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r10.m == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        r10.f7089e.animate().translationX(0.0f).setDuration(r10.f7088d).setListener(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x018f, code lost:
        if (r10.j != false) goto L14;
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
            if (this.f7091g < 2) {
                this.f7091g = this.f7089e.getWidth();
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f7092h = motionEvent.getRawX();
                this.f7093i = motionEvent.getRawY();
                if (this.f7090f.canDismiss(this.l)) {
                    this.o = false;
                    VelocityTracker obtain = VelocityTracker.obtain();
                    this.m = obtain;
                    obtain.addMovement(motionEvent);
                }
                return true;
            }
            if (actionMasked == 1) {
                if (this.m != null) {
                    float rawX = motionEvent.getRawX() - this.f7092h;
                    this.m.addMovement(motionEvent);
                    this.m.computeCurrentVelocity(1000);
                    float xVelocity = this.m.getXVelocity();
                    float abs = Math.abs(xVelocity);
                    float abs2 = Math.abs(this.m.getYVelocity());
                    if (Math.abs(rawX) > this.f7091g / 3 && this.j) {
                        z = rawX > 0.0f;
                    } else if (this.f7086b > abs || abs > this.f7087c || abs2 >= abs || i2 >= 0 || !this.j) {
                        z = false;
                        r3 = false;
                    } else {
                        r3 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX > 0.0f ? 1 : (rawX == 0.0f ? 0 : -1)) < 0);
                        z = this.m.getXVelocity() > 0.0f;
                    }
                    if (r3) {
                        this.f7089e.animate().translationX(z ? this.f7091g : -this.f7091g).setDuration(this.f7088d).setListener(new p(this));
                    }
                }
                return false;
            }
            if (actionMasked == 2) {
                VelocityTracker velocityTracker = this.m;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    float rawX2 = motionEvent.getRawX() - this.f7092h;
                    float rawY = motionEvent.getRawY() - this.f7093i;
                    if (Math.abs(rawX2) > this.f7085a && Math.abs(rawY) < Math.abs(rawX2) / 2.0f) {
                        this.j = true;
                        this.k = rawX2 > 0.0f ? this.f7085a : -this.f7085a;
                        this.f7089e.getParent().requestDisallowInterceptTouchEvent(true);
                        if (!this.o) {
                            this.o = true;
                            this.f7090f.onNotify();
                        }
                        if (Math.abs(rawX2) <= this.f7091g / 3) {
                            this.p = false;
                        } else if (!this.p) {
                            this.p = true;
                            this.f7090f.onNotify();
                        }
                        MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                        obtain2.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.f7089e.onTouchEvent(obtain2);
                        obtain2.recycle();
                    }
                    if (this.j) {
                        this.n = rawX2;
                        this.f7089e.setTranslationX(rawX2 - this.k);
                        return true;
                    }
                }
            } else if (actionMasked == 3) {
            }
            return false;
            this.m.recycle();
            this.m = null;
            this.n = 0.0f;
            this.f7092h = 0.0f;
            this.f7093i = 0.0f;
            this.j = false;
            return false;
        }
        return invokeLL.booleanValue;
    }
}
