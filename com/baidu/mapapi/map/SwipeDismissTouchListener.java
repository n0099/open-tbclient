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
    public int f41581a;

    /* renamed from: b  reason: collision with root package name */
    public int f41582b;

    /* renamed from: c  reason: collision with root package name */
    public int f41583c;

    /* renamed from: d  reason: collision with root package name */
    public long f41584d;

    /* renamed from: e  reason: collision with root package name */
    public View f41585e;

    /* renamed from: f  reason: collision with root package name */
    public DismissCallbacks f41586f;

    /* renamed from: g  reason: collision with root package name */
    public int f41587g;

    /* renamed from: h  reason: collision with root package name */
    public float f41588h;

    /* renamed from: i  reason: collision with root package name */
    public float f41589i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f41590j;
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
        this.f41587g = 1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        this.f41581a = viewConfiguration.getScaledTouchSlop();
        this.f41582b = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f41583c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f41584d = view.getContext().getResources().getInteger(17694720);
        this.f41585e = view;
        view.getContext();
        this.l = obj;
        this.f41586f = dismissCallbacks;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            ViewGroup.LayoutParams layoutParams = this.f41585e.getLayoutParams();
            int height = this.f41585e.getHeight();
            ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(this.f41584d);
            duration.addListener(new q(this, layoutParams, height));
            duration.addUpdateListener(new r(this, layoutParams));
            duration.start();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        if (r10.m == null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        r10.f41585e.animate().translationX(0.0f).setDuration(r10.f41584d).setListener(null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x018f, code lost:
        if (r10.f41590j != false) goto L14;
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
            if (this.f41587g < 2) {
                this.f41587g = this.f41585e.getWidth();
            }
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                this.f41588h = motionEvent.getRawX();
                this.f41589i = motionEvent.getRawY();
                if (this.f41586f.canDismiss(this.l)) {
                    this.o = false;
                    VelocityTracker obtain = VelocityTracker.obtain();
                    this.m = obtain;
                    obtain.addMovement(motionEvent);
                }
                return true;
            }
            if (actionMasked == 1) {
                if (this.m != null) {
                    float rawX = motionEvent.getRawX() - this.f41588h;
                    this.m.addMovement(motionEvent);
                    this.m.computeCurrentVelocity(1000);
                    float xVelocity = this.m.getXVelocity();
                    float abs = Math.abs(xVelocity);
                    float abs2 = Math.abs(this.m.getYVelocity());
                    if (Math.abs(rawX) > this.f41587g / 3 && this.f41590j) {
                        z = rawX > 0.0f;
                    } else if (this.f41582b > abs || abs > this.f41583c || abs2 >= abs || i2 >= 0 || !this.f41590j) {
                        z = false;
                        r3 = false;
                    } else {
                        r3 = ((xVelocity > 0.0f ? 1 : (xVelocity == 0.0f ? 0 : -1)) < 0) == ((rawX > 0.0f ? 1 : (rawX == 0.0f ? 0 : -1)) < 0);
                        z = this.m.getXVelocity() > 0.0f;
                    }
                    if (r3) {
                        this.f41585e.animate().translationX(z ? this.f41587g : -this.f41587g).setDuration(this.f41584d).setListener(new p(this));
                    }
                }
                return false;
            }
            if (actionMasked == 2) {
                VelocityTracker velocityTracker = this.m;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    float rawX2 = motionEvent.getRawX() - this.f41588h;
                    float rawY = motionEvent.getRawY() - this.f41589i;
                    if (Math.abs(rawX2) > this.f41581a && Math.abs(rawY) < Math.abs(rawX2) / 2.0f) {
                        this.f41590j = true;
                        this.k = rawX2 > 0.0f ? this.f41581a : -this.f41581a;
                        this.f41585e.getParent().requestDisallowInterceptTouchEvent(true);
                        if (!this.o) {
                            this.o = true;
                            this.f41586f.onNotify();
                        }
                        if (Math.abs(rawX2) <= this.f41587g / 3) {
                            this.p = false;
                        } else if (!this.p) {
                            this.p = true;
                            this.f41586f.onNotify();
                        }
                        MotionEvent obtain2 = MotionEvent.obtain(motionEvent);
                        obtain2.setAction((motionEvent.getActionIndex() << 8) | 3);
                        this.f41585e.onTouchEvent(obtain2);
                        obtain2.recycle();
                    }
                    if (this.f41590j) {
                        this.n = rawX2;
                        this.f41585e.setTranslationX(rawX2 - this.k);
                        return true;
                    }
                }
            } else if (actionMasked == 3) {
            }
            return false;
            this.m.recycle();
            this.m = null;
            this.n = 0.0f;
            this.f41588h = 0.0f;
            this.f41589i = 0.0f;
            this.f41590j = false;
            return false;
        }
        return invokeLL.booleanValue;
    }
}
