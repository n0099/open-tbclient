package com.baidu.adp.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import c.a.e.e.p.l;
import com.baidu.adp.R;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class SwipeBackLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int SKIN_TYPE_DARK = 4;
    public static final int SKIN_TYPE_NIGHT = 1;
    public static final int SKIN_TYPE_NORMAL = 0;
    public static final int SKIN_TYPE_THEME = 2;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public boolean B;
    public boolean C;
    public boolean D;
    public boolean E;
    public b F;

    /* renamed from: e  reason: collision with root package name */
    public Activity f36524e;

    /* renamed from: f  reason: collision with root package name */
    public View f36525f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f36526g;

    /* renamed from: h  reason: collision with root package name */
    public Scroller f36527h;

    /* renamed from: i  reason: collision with root package name */
    public int f36528i;

    /* renamed from: j  reason: collision with root package name */
    public float f36529j;
    public float k;
    public float l;
    public int m;
    public int n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;
    public int s;
    public Rect t;
    public VelocityTracker u;
    public int v;
    public int w;
    public int x;
    public int y;
    public float z;

    /* loaded from: classes4.dex */
    public static class a implements Interpolator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final float f36530a;

        public a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Float.valueOf(f2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f36530a = f2;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                float f3 = f2 * this.f36530a;
                if (f3 > 0.9d) {
                    return 1.0f;
                }
                return f3;
            }
            return invokeF.floatValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z);

        void b();
    }

    /* loaded from: classes4.dex */
    public interface c {
        void disableSwipeBack();

        void enableSwipeBack();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeBackLayout(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = -1;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = false;
        this.s = 0;
        this.t = new Rect();
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        f(context);
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.r) {
                this.f36527h.abortAnimation();
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f36527h.getCurrX();
                int currY = this.f36527h.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    this.f36525f.scrollTo(currX, currY);
                }
            }
            this.r = false;
        }
    }

    public void attachToActivity(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity) == null) {
            try {
                this.f36524e = activity;
                Window window = activity.getWindow();
                window.setBackgroundDrawable(new ColorDrawable(0));
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(0);
                this.f36526g = viewGroup2;
                viewGroup.removeView(viewGroup2);
                this.f36526g.setClickable(true);
                addView(this.f36526g);
                this.f36525f = (View) this.f36526g.getParent();
                viewGroup.addView(this);
            } catch (Exception e2) {
                this.q = false;
                BdLog.e(e2);
            }
        }
    }

    public final void b(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent) == null) {
            int i2 = this.n;
            int e2 = e(motionEvent, i2);
            if (g(motionEvent, e2, i2)) {
                return;
            }
            float x = MotionEventCompat.getX(motionEvent, e2);
            float f2 = x - this.f36529j;
            float abs = Math.abs(f2);
            float y = MotionEventCompat.getY(motionEvent, e2);
            float abs2 = Math.abs(y - this.k);
            if (f2 <= 0.0f || abs <= this.y || abs <= abs2) {
                return;
            }
            this.o = true;
            b bVar = this.F;
            if (bVar != null) {
                bVar.b();
            }
            this.f36529j = x;
            this.k = y;
        }
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.o = false;
            this.n = -1;
            i();
        }
    }

    @Override // android.view.View
    public void computeScroll() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f36527h.isFinished() && this.f36527h.computeScrollOffset()) {
                int scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f36527h.getCurrX();
                int currY = this.f36527h.getCurrY();
                if (scrollX != currX || scrollY != currY) {
                    this.f36525f.scrollTo(currX, currY);
                }
                invalidate();
            }
            if (this.f36527h.isFinished() && this.p) {
                this.f36524e.finish();
                this.f36524e.overridePendingTransition(0, 0);
            }
            if (this.f36527h.isFinished()) {
                a();
            }
        }
    }

    public final int d(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            int i2 = this.n;
            int e2 = e(motionEvent, i2);
            if (g(motionEvent, e2, i2)) {
                return 0;
            }
            return (int) Math.abs(MotionEventCompat.getX(motionEvent, e2) - this.l);
        }
        return invokeL.intValue;
    }

    public void disableSwipeJustOnce() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.A = true;
            this.q = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, canvas) == null) {
            super.dispatchDraw(canvas);
            View view = this.f36525f;
            if (view != null) {
                int i2 = this.m;
                int bottom = view.getBottom();
                Rect rect = this.t;
                rect.top = 0;
                rect.bottom = bottom;
                rect.left = 0;
                rect.right = i2;
                canvas.clipRect(rect);
                int i3 = this.f36528i;
                if (i3 != 0) {
                    this.s = 100 - ((int) (((-this.m) / i3) * 120.0f));
                }
                if (this.s > 100) {
                    this.s = 100;
                }
                if (this.p) {
                    this.s = 0;
                }
                if (this.s < 0) {
                    this.s = 0;
                }
                canvas.drawARGB(this.s, 0, 0, 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            h(motionEvent);
            return dispatchTouchEvent;
        }
        return invokeL.booleanValue;
    }

    public final int e(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048585, this, motionEvent, i2)) == null) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
            if (findPointerIndex == -1) {
                this.n = -1;
            }
            return findPointerIndex;
        }
        return invokeLI.intValue;
    }

    public final void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, context) == null) {
            TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics());
            this.f36527h = new Scroller(context, new a(1.5f));
            ViewConfiguration.get(context.getApplicationContext()).getScaledTouchSlop();
            this.w = ViewConfiguration.getMaximumFlingVelocity();
            this.v = ViewConfiguration.getMinimumFlingVelocity();
            this.y = (int) (context.getResources().getDisplayMetrics().density * 24.0f);
            this.x = l.k(context) / 4;
        }
    }

    public void forceChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            if (this.B) {
                this.f36526g.setBackgroundResource(R.color.transparent);
            } else if (!this.E) {
                this.f36526g.setBackgroundResource(R.color.swipe_layout_normal_bg);
            } else if (i2 == 1) {
                this.f36526g.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else if (i2 == 4) {
                this.f36526g.setBackgroundResource(R.color.swipe_layout_dark_bg);
            } else {
                this.f36526g.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    public final boolean g(MotionEvent motionEvent, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048588, this, motionEvent, i2, i3)) == null) ? motionEvent == null || i3 == -1 || i2 == -1 || i2 >= motionEvent.getPointerCount() : invokeLII.booleanValue;
    }

    public final boolean h(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            int action = motionEvent.getAction() & 255;
            if (action == 1 || action == 3) {
                if (this.A) {
                    this.A = false;
                    this.q = true;
                    return true;
                } else if (this.C) {
                    this.C = false;
                    this.q = false;
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void i() {
        VelocityTracker velocityTracker;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048590, this) == null) || (velocityTracker = this.u) == null) {
            return;
        }
        velocityTracker.clear();
        this.u.recycle();
        this.u = null;
    }

    public boolean isIsSupportNight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.E : invokeV.booleanValue;
    }

    public boolean isSwipeBackEnabled() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.q : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            this.r = true;
            this.f36527h.startScroll(this.f36525f.getScrollX(), 0, -this.f36525f.getScrollX(), 0);
            postInvalidate();
        }
    }

    public final void k(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i2) == null) {
            this.r = true;
            this.f36527h.startScroll(this.f36525f.getScrollX(), 0, -this.f36525f.getScrollX(), 0, i2);
            postInvalidate();
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.r = true;
            this.f36527h.startScroll(this.f36525f.getScrollX(), 0, (-(this.f36528i + this.f36525f.getScrollX())) + 1, 0);
            postInvalidate();
        }
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048596, this, i2) == null) && this.q) {
            if (this.B) {
                this.f36526g.setBackgroundResource(R.color.transparent);
            } else if (!this.E) {
                this.f36526g.setBackgroundResource(R.color.swipe_layout_normal_bg);
            } else if (i2 == 1) {
                this.f36526g.setBackgroundResource(R.color.swipe_layout_night_bg);
            } else if (i2 == 4) {
                this.f36526g.setBackgroundResource(R.color.swipe_layout_dark_bg);
            } else {
                this.f36526g.setBackgroundResource(R.color.swipe_layout_normal_bg);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, motionEvent)) == null) {
            if (!this.q) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            if (!this.p && !this.r) {
                int action = motionEvent.getAction() & 255;
                if (action != 3 && action != 1) {
                    if (action == 0) {
                        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
                        int pointerId = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                        this.n = pointerId;
                        if (!g(motionEvent, actionIndex, pointerId)) {
                            this.f36529j = MotionEventCompat.getX(motionEvent, actionIndex);
                            this.k = MotionEventCompat.getY(motionEvent, actionIndex);
                            this.l = MotionEventCompat.getX(motionEvent, actionIndex);
                        }
                    } else if (action == 2) {
                        b(motionEvent);
                    }
                    return this.o;
                }
                c();
                return super.onInterceptTouchEvent(motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            try {
                super.onLayout(z, i2, i3, i4, i5);
            } catch (Throwable unused) {
            }
            if (z) {
                this.f36528i = getWidth();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, motionEvent)) == null) {
            if (!this.p && !this.r) {
                if (this.u == null) {
                    this.u = VelocityTracker.obtain();
                }
                this.u.addMovement(motionEvent);
                int action = motionEvent.getAction() & 255;
                if (action != 0) {
                    float f2 = 0.0f;
                    if (action == 1) {
                        VelocityTracker velocityTracker = this.u;
                        velocityTracker.computeCurrentVelocity(1000, this.w);
                        this.z = velocityTracker.getXVelocity();
                        int d2 = d(motionEvent);
                        c();
                        if (Math.abs(this.z) > this.v && d2 > this.x) {
                            if (this.z > 0.0f) {
                                this.p = true;
                                l();
                            } else {
                                j();
                                this.p = false;
                            }
                            b bVar = this.F;
                            if (bVar != null) {
                                bVar.a(this.p);
                            }
                            return true;
                        }
                        if (this.f36525f.getScrollX() <= (-this.f36528i) / 2) {
                            this.p = true;
                            l();
                        } else {
                            j();
                            this.p = false;
                        }
                        b bVar2 = this.F;
                        if (bVar2 != null) {
                            bVar2.a(this.p);
                        }
                    } else if (action == 2) {
                        if (this.D) {
                            a();
                            int actionIndex = motionEvent.getActionIndex();
                            this.n = motionEvent.getPointerId(actionIndex);
                            this.f36529j = (motionEvent.getX(actionIndex) - 1.0f) - this.y;
                            this.k = motionEvent.getY(actionIndex);
                            this.l = motionEvent.getX(actionIndex);
                            this.o = false;
                            this.D = false;
                        }
                        if (!this.o) {
                            b(motionEvent);
                        }
                        if (this.o) {
                            int e2 = e(motionEvent, this.n);
                            if (!g(motionEvent, e2, this.n)) {
                                float x = MotionEventCompat.getX(motionEvent, e2);
                                float f3 = this.f36529j - x;
                                this.f36529j = x;
                                float scrollX = getScrollX() + f3;
                                float f4 = -this.f36528i;
                                if (scrollX < f4) {
                                    f2 = f4;
                                } else if (scrollX <= 0.0f) {
                                    f2 = scrollX;
                                }
                                int i2 = (int) f2;
                                this.f36529j += f2 - i2;
                                this.m = i2;
                                this.f36525f.scrollTo(i2, getScrollY());
                            }
                        }
                    } else if (action == 3) {
                        c();
                        k(10);
                        this.p = false;
                        b bVar3 = this.F;
                        if (bVar3 != null) {
                            bVar3.a(false);
                        }
                    }
                } else {
                    a();
                    int actionIndex2 = MotionEventCompat.getActionIndex(motionEvent);
                    this.n = MotionEventCompat.getPointerId(motionEvent, actionIndex2);
                    this.f36529j = motionEvent.getX();
                    this.l = MotionEventCompat.getX(motionEvent, actionIndex2);
                }
                return super.onTouchEvent(motionEvent);
            }
            return super.onTouchEvent(motionEvent);
        }
        return invokeL.booleanValue;
    }

    public void setBgTransparent() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.B = true;
            ViewGroup viewGroup = this.f36526g;
            if (viewGroup != null) {
                viewGroup.setBackgroundResource(R.color.transparent);
            }
        }
    }

    public void setIsSupportNight(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048601, this, z) == null) {
            if (!z) {
                if (this.B) {
                    this.f36526g.setBackgroundResource(R.color.transparent);
                } else {
                    this.f36526g.setBackgroundResource(R.color.swipe_layout_normal_bg);
                }
            }
            this.E = z;
        }
    }

    public void setOnSlidingStateChangeListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, bVar) == null) {
            this.F = bVar;
        }
    }

    public void setSwipeBackEnabled(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.q = z;
        }
    }

    public void swipeBackControl(double d2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048604, this, new Object[]{Double.valueOf(d2)}) == null) {
            if (d2 != 1.0d) {
                if (d2 == 2.0d) {
                    this.p = true;
                    l();
                    return;
                }
                return;
            }
            if (!this.q) {
                this.C = true;
            }
            this.D = true;
            this.q = true;
            this.o = true;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = -1;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = false;
        this.s = 0;
        this.t = new Rect();
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.n = -1;
        this.o = false;
        this.p = false;
        this.q = true;
        this.r = false;
        this.s = 0;
        this.t = new Rect();
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.E = true;
        f(context);
    }
}
