package c.a.c0.h0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.widget.ScrollerCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
/* loaded from: classes.dex */
public class y {
    public static /* synthetic */ Interceptable $ic;
    public static final Interpolator w;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f1746b;

    /* renamed from: c  reason: collision with root package name */
    public int f1747c;

    /* renamed from: d  reason: collision with root package name */
    public float[] f1748d;

    /* renamed from: e  reason: collision with root package name */
    public float[] f1749e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f1750f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f1751g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f1752h;

    /* renamed from: i  reason: collision with root package name */
    public int[] f1753i;

    /* renamed from: j  reason: collision with root package name */
    public int[] f1754j;

    /* renamed from: k  reason: collision with root package name */
    public int f1755k;
    public VelocityTracker l;
    public float m;
    public float n;
    public int o;
    public int p;
    public ScrollerCompat q;
    public final c r;
    public View s;
    public boolean t;
    public final ViewGroup u;
    public final Runnable v;

    /* loaded from: classes.dex */
    public static class a implements Interpolator {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
            return invokeF.floatValue;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ y f1756e;

        public b(y yVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {yVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f1756e = yVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f1756e.G(0);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public abstract int a(View view, int i2, int i3);

        public int b(View view, int i2, int i3) {
            InterceptResult invokeLII;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLII = interceptable.invokeLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, i2, i3)) == null) {
                return 0;
            }
            return invokeLII.intValue;
        }

        public int c(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) ? i2 : invokeI.intValue;
        }

        public abstract int d(View view);

        public int e(View view) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, view)) == null) {
                return 0;
            }
            return invokeL.intValue;
        }

        public abstract boolean f();

        public abstract void g(int i2, int i3);

        public boolean h(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i2)) == null) {
                return false;
            }
            return invokeI.booleanValue;
        }

        public void i(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            }
        }

        public abstract void j(View view, int i2);

        public abstract void k(int i2);

        public abstract void l(View view, int i2, int i3, int i4, int i5);

        public abstract void m(View view, float f2, float f3);

        public abstract boolean n(View view, int i2);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1413302925, "Lc/a/c0/h0/y;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1413302925, "Lc/a/c0/h0/y;");
                return;
            }
        }
        w = new a();
    }

    @SuppressLint({"BDThrowableCheck"})
    public y(Context context, ViewGroup viewGroup, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, viewGroup, cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f1747c = -1;
        this.v = new b(this);
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (cVar != null) {
            this.u = viewGroup;
            this.r = cVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f1746b = viewConfiguration.getScaledTouchSlop();
            this.m = viewConfiguration.getScaledMaximumFlingVelocity();
            this.n = viewConfiguration.getScaledMinimumFlingVelocity();
            this.q = ScrollerCompat.create(context, w);
            return;
        }
        throw new IllegalArgumentException("Callback may not be null");
    }

    public static y m(ViewGroup viewGroup, float f2, c cVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{viewGroup, Float.valueOf(f2), cVar})) == null) {
            y n = n(viewGroup, cVar);
            n.f1746b = (int) (n.f1746b * (1.0f / f2));
            return n;
        }
        return (y) invokeCommon.objValue;
    }

    public static y n(ViewGroup viewGroup, c cVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, viewGroup, cVar)) == null) ? new y(viewGroup.getContext(), viewGroup, cVar) : (y) invokeLL.objValue;
    }

    public boolean A(View view, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLII = interceptable.invokeLII(1048576, this, view, i2, i3)) == null) ? view != null && i2 >= view.getLeft() && i2 < view.getRight() && i3 >= view.getTop() && i3 < view.getBottom() : invokeLII.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x007b, code lost:
        if (r11 != (-1)) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x007d, code lost:
        C();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void B(MotionEvent motionEvent) {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, motionEvent) == null) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (actionMasked == 0) {
                b();
            }
            if (this.l == null) {
                this.l = VelocityTracker.obtain();
            }
            this.l.addMovement(motionEvent);
            int i3 = 0;
            if (actionMasked == 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                View s = s((int) x, (int) y);
                E(x, y, pointerId);
                M(s, pointerId);
                int i4 = this.f1752h[pointerId];
                int i5 = this.p;
                if ((i4 & i5) != 0) {
                    this.r.i(i4 & i5, pointerId);
                }
            } else if (actionMasked == 1) {
                if (this.a == 1) {
                    C();
                }
                b();
            } else if (actionMasked == 2) {
                if (this.a == 1) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.f1747c);
                    float v = v(motionEvent, findPointerIndex);
                    float w2 = w(motionEvent, findPointerIndex);
                    if (v == -1.0f || w2 == -1.0f) {
                        return;
                    }
                    float[] fArr = this.f1750f;
                    int i6 = this.f1747c;
                    int i7 = (int) (v - fArr[i6]);
                    int i8 = (int) (w2 - this.f1751g[i6]);
                    q(this.s.getLeft() + i7, this.s.getTop() + i8, i7, i8);
                    F(motionEvent);
                    return;
                }
                int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                while (i3 < pointerCount) {
                    int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i3);
                    float v2 = v(motionEvent, i3);
                    float w3 = w(motionEvent, i3);
                    if (v2 != -1.0f && w3 != -1.0f) {
                        float f2 = v2 - this.f1748d[pointerId2];
                        float f3 = w3 - this.f1749e[pointerId2];
                        D(f2, f3, pointerId2);
                        if (this.a != 1) {
                            View s2 = s((int) v2, (int) w3);
                            if (e(s2, f2, f3) && M(s2, pointerId2)) {
                                break;
                            }
                            i3++;
                        } else {
                            break;
                        }
                    } else {
                        return;
                    }
                }
                F(motionEvent);
            } else if (actionMasked == 3) {
                if (this.a == 1) {
                    o(0.0f, 0.0f);
                }
                b();
            } else if (actionMasked == 5) {
                int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                float v3 = v(motionEvent, actionIndex);
                float w4 = w(motionEvent, actionIndex);
                if (v3 == -1.0f || w4 == -1.0f) {
                    return;
                }
                E(v3, w4, pointerId3);
                if (this.a == 0) {
                    M(s((int) v3, (int) w4), pointerId3);
                    int i9 = this.f1752h[pointerId3];
                    int i10 = this.p;
                    if ((i9 & i10) != 0) {
                        this.r.i(i9 & i10, pointerId3);
                    }
                } else if (z((int) v3, (int) w4)) {
                    M(this.s, pointerId3);
                }
            } else if (actionMasked != 6) {
            } else {
                int pointerId4 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                if (this.a == 1 && pointerId4 == this.f1747c) {
                    int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
                    while (true) {
                        if (i3 >= pointerCount2) {
                            i2 = -1;
                            break;
                        }
                        int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i3);
                        if (pointerId5 != this.f1747c) {
                            float v4 = v(motionEvent, i3);
                            float w5 = w(motionEvent, i3);
                            if (v4 != -1.0f && w5 != -1.0f) {
                                View s3 = s((int) v4, (int) w5);
                                View view = this.s;
                                if (s3 == view && M(view, pointerId5)) {
                                    i2 = this.f1747c;
                                    break;
                                }
                            } else {
                                return;
                            }
                        }
                        i3++;
                    }
                }
                i(pointerId4);
            }
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.l.computeCurrentVelocity(1000, this.m);
            o(f(VelocityTrackerCompat.getXVelocity(this.l, this.f1747c), this.n, this.m), f(VelocityTrackerCompat.getYVelocity(this.l, this.f1747c), this.n, this.m));
        }
    }

    public final void D(float f2, float f3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2)}) == null) {
            int i3 = d(f2, f3, i2, 1) ? 1 : 0;
            if (d(f3, f2, i2, 4)) {
                i3 |= 4;
            }
            if (d(f2, f3, i2, 2)) {
                i3 |= 2;
            }
            if (d(f3, f2, i2, 8)) {
                i3 |= 8;
            }
            if (i3 != 0) {
                int[] iArr = this.f1753i;
                iArr[i2] = iArr[i2] | i3;
                this.r.g(i3, i2);
            }
        }
    }

    public final void E(float f2, float f3, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2)}) == null) {
            r(i2);
            float[] fArr = this.f1748d;
            this.f1750f[i2] = f2;
            fArr[i2] = f2;
            float[] fArr2 = this.f1749e;
            this.f1751g[i2] = f3;
            fArr2[i2] = f3;
            this.f1752h[i2] = u((int) f2, (int) f3);
            this.f1755k |= 1 << i2;
        }
    }

    public final void F(MotionEvent motionEvent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, motionEvent) == null) {
            int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
            for (int i2 = 0; i2 < pointerCount; i2++) {
                int pointerId = MotionEventCompat.getPointerId(motionEvent, i2);
                float v = v(motionEvent, i2);
                float w2 = w(motionEvent, i2);
                if (v == -1.0f || w2 == -1.0f) {
                    return;
                }
                this.f1750f[pointerId] = v;
                this.f1751g[pointerId] = w2;
            }
        }
    }

    public void G(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048582, this, i2) == null) || this.a == i2) {
            return;
        }
        this.a = i2;
        this.r.k(i2);
        if (this.a == 0) {
            this.s = null;
        }
    }

    public void H(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            this.p = i2;
        }
    }

    public void I(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(InputDeviceCompat.SOURCE_TOUCHPAD, this, f2) == null) {
            this.n = f2;
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public boolean J(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048585, this, i2, i3)) == null) {
            if (this.t) {
                return t(i2, i3, (int) VelocityTrackerCompat.getXVelocity(this.l, this.f1747c), (int) VelocityTrackerCompat.getYVelocity(this.l, this.f1747c));
            }
            throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
        }
        return invokeII.booleanValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00ee, code lost:
        if (r13 != r12) goto L65;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean K(MotionEvent motionEvent) {
        InterceptResult invokeL;
        View s;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, motionEvent)) == null) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
            if (actionMasked == 0) {
                b();
            }
            if (this.l == null) {
                this.l = VelocityTracker.obtain();
            }
            this.l.addMovement(motionEvent);
            boolean z = false;
            if (actionMasked == 0) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
                E(x, y, pointerId);
                View s2 = s((int) x, (int) y);
                if (s2 == this.s && this.a == 2) {
                    M(s2, pointerId);
                }
                int i2 = this.f1752h[pointerId];
                int i3 = this.p;
                if ((i2 & i3) != 0) {
                    this.r.i(i2 & i3, pointerId);
                }
            } else if (actionMasked != 1) {
                float f2 = -1.0f;
                if (actionMasked == 2) {
                    int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
                    int i4 = 0;
                    while (i4 < pointerCount) {
                        int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i4);
                        float v = v(motionEvent, i4);
                        float w2 = w(motionEvent, i4);
                        if (v != f2 && w2 != f2) {
                            float f3 = v - this.f1748d[pointerId2];
                            float f4 = w2 - this.f1749e[pointerId2];
                            View s3 = s((int) v, (int) w2);
                            boolean z2 = s3 != null && e(s3, f3, f4);
                            if (z2) {
                                int left = s3.getLeft();
                                int i5 = (int) f3;
                                int a2 = this.r.a(s3, left + i5, i5);
                                int top = s3.getTop();
                                int i6 = (int) f4;
                                int b2 = this.r.b(s3, top + i6, i6);
                                int d2 = this.r.d(s3);
                                int e2 = this.r.e(s3);
                                if (d2 != 0) {
                                    if (d2 > 0) {
                                    }
                                }
                                if (e2 != 0) {
                                    if (e2 > 0 && b2 == top) {
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            D(f3, f4, pointerId2);
                            if (this.a == 1 || (z2 && M(s3, pointerId2))) {
                                break;
                            }
                            i4++;
                            z = false;
                            f2 = -1.0f;
                        } else {
                            return z;
                        }
                    }
                    F(motionEvent);
                } else if (actionMasked == 3) {
                    b();
                } else if (actionMasked == 5) {
                    int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                    float v2 = v(motionEvent, actionIndex);
                    float w3 = w(motionEvent, actionIndex);
                    if (v2 == -1.0f || w3 == -1.0f) {
                        return false;
                    }
                    E(v2, w3, pointerId3);
                    int i7 = this.a;
                    if (i7 == 0) {
                        int i8 = this.f1752h[pointerId3];
                        int i9 = this.p;
                        if ((i8 & i9) != 0) {
                            this.r.i(i8 & i9, pointerId3);
                        }
                    } else if (i7 == 2 && (s = s((int) v2, (int) w3)) == this.s) {
                        M(s, pointerId3);
                    }
                } else if (actionMasked == 6) {
                    i(MotionEventCompat.getPointerId(motionEvent, actionIndex));
                }
            } else {
                b();
            }
            return this.a == 1;
        }
        return invokeL.booleanValue;
    }

    public boolean L(View view, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048587, this, view, i2, i3)) == null) {
            this.s = view;
            this.f1747c = -1;
            boolean t = t(i2, i3, 0, 0);
            if (!t && this.a == 0 && this.s != null) {
                this.s = null;
            }
            return t;
        }
        return invokeLII.booleanValue;
    }

    public boolean M(View view, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048588, this, view, i2)) == null) {
            if (view == this.s && this.f1747c == i2) {
                return true;
            }
            if (view == null || !this.r.n(view, i2)) {
                return false;
            }
            this.f1747c = i2;
            c(view, i2);
            return true;
        }
        return invokeLI.booleanValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            b();
            if (this.a == 2) {
                int currX = this.q.getCurrX();
                int currY = this.q.getCurrY();
                this.q.abortAnimation();
                int currX2 = this.q.getCurrX();
                int currY2 = this.q.getCurrY();
                this.r.l(this.s, currX2, currY2, currX2 - currX, currY2 - currY);
            }
            G(0);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f1747c = -1;
            h();
            VelocityTracker velocityTracker = this.l;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.l = null;
            }
        }
    }

    @SuppressLint({"BDThrowableCheck"})
    public void c(View view, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048591, this, view, i2) == null) {
            if (view.getParent() == this.u) {
                this.s = view;
                this.f1747c = i2;
                this.r.j(view, i2);
                G(1);
                return;
            }
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.u + SmallTailInfo.EMOTION_SUFFIX);
        }
    }

    public final boolean d(float f2, float f3, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048592, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            float abs = Math.abs(f2);
            float abs2 = Math.abs(f3);
            if ((this.f1752h[i2] & i3) != i3 || (this.p & i3) == 0 || (this.f1754j[i2] & i3) == i3 || (this.f1753i[i2] & i3) == i3) {
                return false;
            }
            int i4 = this.f1746b;
            if (abs > i4 || abs2 > i4) {
                if (abs >= abs2 * 0.5f || !this.r.h(i3)) {
                    return (this.f1753i[i2] & i3) == 0 && abs > ((float) this.f1746b);
                }
                int[] iArr = this.f1754j;
                iArr[i2] = iArr[i2] | i3;
                return false;
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public final boolean e(View view, float f2, float f3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048593, this, new Object[]{view, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
            if (view == null) {
                return false;
            }
            boolean z = this.r.d(view) > 0;
            boolean z2 = this.r.e(view) > 0;
            if (!z || !z2) {
                return z ? Math.abs(f2) > ((float) this.f1746b) : z2 && Math.abs(f3) > ((float) this.f1746b);
            }
            int i2 = this.f1746b;
            return (f2 * f2) + (f3 * f3) > ((float) (i2 * i2));
        }
        return invokeCommon.booleanValue;
    }

    public final float f(float f2, float f3, float f4) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)})) == null) {
            float abs = Math.abs(f2);
            if (abs < f3) {
                return 0.0f;
            }
            return abs > f4 ? f2 > 0.0f ? f4 : -f4 : f2;
        }
        return invokeCommon.floatValue;
    }

    public final int g(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048595, this, i2, i3, i4)) == null) {
            int abs = Math.abs(i2);
            if (abs < i3) {
                return 0;
            }
            return abs > i4 ? i2 > 0 ? i4 : -i4 : i2;
        }
        return invokeIII.intValue;
    }

    public final void h() {
        float[] fArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (fArr = this.f1748d) == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.f1749e, 0.0f);
        Arrays.fill(this.f1750f, 0.0f);
        Arrays.fill(this.f1751g, 0.0f);
        Arrays.fill(this.f1752h, 0);
        Arrays.fill(this.f1753i, 0);
        Arrays.fill(this.f1754j, 0);
        this.f1755k = 0;
    }

    public final void i(int i2) {
        float[] fArr;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048597, this, i2) == null) || (fArr = this.f1748d) == null) {
            return;
        }
        fArr[i2] = 0.0f;
        this.f1749e[i2] = 0.0f;
        this.f1750f[i2] = 0.0f;
        this.f1751g[i2] = 0.0f;
        this.f1752h[i2] = 0;
        this.f1753i[i2] = 0;
        this.f1754j[i2] = 0;
        this.f1755k = (~(1 << i2)) & this.f1755k;
    }

    public final int j(int i2, int i3, int i4) {
        InterceptResult invokeIII;
        int abs;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048598, this, i2, i3, i4)) == null) {
            if (i2 == 0) {
                return 0;
            }
            int width = this.u.getWidth();
            float f2 = width / 2;
            float p = f2 + (p(Math.min(1.0f, Math.abs(i2) / width)) * f2);
            int abs2 = Math.abs(i3);
            if (abs2 > 0) {
                abs = Math.round(Math.abs(p / abs2) * 1000.0f) * 4;
            } else {
                abs = (int) (((Math.abs(i2) / i4) + 1.0f) * 256.0f);
            }
            return Math.min(abs, 600);
        }
        return invokeIII.intValue;
    }

    public final int k(View view, int i2, int i3, int i4, int i5) {
        InterceptResult invokeCommon;
        float f2;
        float f3;
        float f4;
        float f5;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048599, this, new Object[]{view, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)})) == null) {
            int g2 = g(i4, (int) this.n, (int) this.m);
            int g3 = g(i5, (int) this.n, (int) this.m);
            int abs = Math.abs(i2);
            int abs2 = Math.abs(i3);
            int abs3 = Math.abs(g2);
            int abs4 = Math.abs(g3);
            int i6 = abs3 + abs4;
            int i7 = abs + abs2;
            if (g2 != 0) {
                f2 = abs3;
                f3 = i6;
            } else {
                f2 = abs;
                f3 = i7;
            }
            float f6 = f2 / f3;
            if (g3 != 0) {
                f4 = abs4;
                f5 = i6;
            } else {
                f4 = abs2;
                f5 = i7;
            }
            return (int) ((j(i2, g2, this.r.d(view)) * f6) + (j(i3, g3, this.r.e(view)) * (f4 / f5)));
        }
        return invokeCommon.intValue;
    }

    public boolean l(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(1048600, this, z)) == null) {
            if (this.a == 2) {
                boolean computeScrollOffset = this.q.computeScrollOffset();
                int currX = this.q.getCurrX();
                int currY = this.q.getCurrY();
                int left = currX - this.s.getLeft();
                int top = currY - this.s.getTop();
                if (left != 0) {
                    this.s.offsetLeftAndRight(left);
                }
                if (top != 0) {
                    this.s.offsetTopAndBottom(top);
                }
                if (left != 0 || top != 0) {
                    this.r.l(this.s, currX, currY, left, top);
                }
                if (computeScrollOffset && currX == this.q.getFinalX() && currY == this.q.getFinalY()) {
                    this.q.abortAnimation();
                    computeScrollOffset = false;
                }
                if (!computeScrollOffset) {
                    if (z) {
                        this.u.post(this.v);
                    } else {
                        G(0);
                    }
                }
            }
            return this.a == 2;
        }
        return invokeZ.booleanValue;
    }

    public final void o(float f2, float f3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048601, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            this.t = true;
            this.r.m(this.s, f2, f3);
            this.t = false;
            if (this.a == 1) {
                G(0);
            }
        }
    }

    public final float p(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeF = interceptable.invokeF(1048602, this, f2)) == null) ? (float) Math.sin((float) ((f2 - 0.5f) * 0.4712389167638204d)) : invokeF.floatValue;
    }

    public final void q(int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIII(1048603, this, i2, i3, i4, i5) == null) {
            int left = this.s.getLeft();
            int top = this.s.getTop();
            if (i4 != 0) {
                i2 = this.r.a(this.s, i2, i4);
                if (this.r.f()) {
                    this.s.offsetLeftAndRight(i2 - left);
                }
            }
            int i6 = i2;
            if (i5 != 0) {
                i3 = this.r.b(this.s, i3, i5);
                this.s.offsetTopAndBottom(i3 - top);
            }
            int i7 = i3;
            if (i4 == 0 && i5 == 0) {
                return;
            }
            int i8 = i6 - left;
            int i9 = i7 - top;
            if (this.r.f()) {
                this.r.l(this.s, i6, i7, i8, i9);
            }
        }
    }

    public final void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048604, this, i2) == null) {
            float[] fArr = this.f1748d;
            if (fArr == null || fArr.length <= i2) {
                int i3 = i2 + 1;
                float[] fArr2 = new float[i3];
                float[] fArr3 = new float[i3];
                float[] fArr4 = new float[i3];
                float[] fArr5 = new float[i3];
                int[] iArr = new int[i3];
                int[] iArr2 = new int[i3];
                int[] iArr3 = new int[i3];
                float[] fArr6 = this.f1748d;
                if (fArr6 != null) {
                    System.arraycopy(fArr6, 0, fArr2, 0, fArr6.length);
                    float[] fArr7 = this.f1749e;
                    System.arraycopy(fArr7, 0, fArr3, 0, fArr7.length);
                    float[] fArr8 = this.f1750f;
                    System.arraycopy(fArr8, 0, fArr4, 0, fArr8.length);
                    float[] fArr9 = this.f1751g;
                    System.arraycopy(fArr9, 0, fArr5, 0, fArr9.length);
                    int[] iArr4 = this.f1752h;
                    System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                    int[] iArr5 = this.f1753i;
                    System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                    int[] iArr6 = this.f1754j;
                    System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
                }
                this.f1748d = fArr2;
                this.f1749e = fArr3;
                this.f1750f = fArr4;
                this.f1751g = fArr5;
                this.f1752h = iArr;
                this.f1753i = iArr2;
                this.f1754j = iArr3;
            }
        }
    }

    public View s(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048605, this, i2, i3)) == null) {
            for (int childCount = this.u.getChildCount() - 1; childCount >= 0; childCount--) {
                ViewGroup viewGroup = this.u;
                this.r.c(childCount);
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 >= childAt.getLeft() && i2 < childAt.getRight() && i3 >= childAt.getTop() && i3 < childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }
        return (View) invokeII.objValue;
    }

    public final boolean t(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(1048606, this, i2, i3, i4, i5)) == null) {
            int left = this.s.getLeft();
            int top = this.s.getTop();
            int i6 = i2 - left;
            int i7 = i3 - top;
            if (i6 == 0 && i7 == 0) {
                this.q.abortAnimation();
                G(0);
                return false;
            }
            this.q.startScroll(left, top, i6, i7, k(this.s, i6, i7, i4, i5));
            G(2);
            return true;
        }
        return invokeIIII.booleanValue;
    }

    public final int u(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048607, this, i2, i3)) == null) {
            int i4 = i2 < this.u.getLeft() + this.o ? 1 : 0;
            if (i3 < this.u.getTop() + this.o) {
                i4 |= 4;
            }
            if (i2 > this.u.getRight() - this.o) {
                i4 |= 2;
            }
            return i3 > this.u.getBottom() - this.o ? i4 | 8 : i4;
        }
        return invokeII.intValue;
    }

    public final float v(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048608, this, motionEvent, i2)) == null) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
            if (findPointerIndex < 0) {
                return -1.0f;
            }
            return MotionEventCompat.getX(motionEvent, findPointerIndex);
        }
        return invokeLI.floatValue;
    }

    public final float w(MotionEvent motionEvent, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048609, this, motionEvent, i2)) == null) {
            int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i2);
            if (findPointerIndex < 0) {
                return -1.0f;
            }
            return MotionEventCompat.getY(motionEvent, findPointerIndex);
        }
        return invokeLI.floatValue;
    }

    public int x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) ? this.f1746b : invokeV.intValue;
    }

    public int y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048611, this)) == null) ? this.a : invokeV.intValue;
    }

    public boolean z(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeII = interceptable.invokeII(1048612, this, i2, i3)) == null) ? A(this.s, i2, i3) : invokeII.booleanValue;
    }
}
