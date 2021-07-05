package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.R;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f2286e;

    /* renamed from: f  reason: collision with root package name */
    public float f2287f;

    /* renamed from: g  reason: collision with root package name */
    public float f2288g;

    /* renamed from: h  reason: collision with root package name */
    public int f2289h;

    /* renamed from: i  reason: collision with root package name */
    public final int f2290i;
    public TrackDirection j;
    public int k;
    public final Rect l;
    public final Rect m;
    public final Paint n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public final b s;
    public final c t;
    public final h u;
    public e v;
    public g w;
    public final List<f> x;
    public d y;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class TrackDirection {
        public static final /* synthetic */ TrackDirection[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TrackDirection horizontal;
        public static final TrackDirection left;
        public static final TrackDirection none;
        public static final TrackDirection right;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1682469924, "Lcom/baidu/adp/widget/HorizontalTranslateLayout$TrackDirection;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1682469924, "Lcom/baidu/adp/widget/HorizontalTranslateLayout$TrackDirection;");
                    return;
                }
            }
            left = new TrackDirection(CustomDialogData.POS_LEFT, 0);
            right = new TrackDirection("right", 1);
            horizontal = new TrackDirection("horizontal", 2);
            TrackDirection trackDirection = new TrackDirection("none", 3);
            none = trackDirection;
            $VALUES = new TrackDirection[]{left, right, horizontal, trackDirection};
        }

        public TrackDirection(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static TrackDirection valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (TrackDirection) Enum.valueOf(TrackDirection.class, str) : (TrackDirection) invokeL.objValue;
        }

        public static TrackDirection[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (TrackDirection[]) $VALUES.clone() : (TrackDirection[]) invokeV.objValue;
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2291a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1906223653, "Lcom/baidu/adp/widget/HorizontalTranslateLayout$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1906223653, "Lcom/baidu/adp/widget/HorizontalTranslateLayout$a;");
                    return;
                }
            }
            int[] iArr = new int[TrackDirection.values().length];
            f2291a = iArr;
            try {
                iArr[TrackDirection.left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2291a[TrackDirection.right.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2291a[TrackDirection.horizontal.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HorizontalTranslateLayout f2292a;

        public b(HorizontalTranslateLayout horizontalTranslateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTranslateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2292a = horizontalTranslateLayout;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && this.f2292a.t.f2299g) {
                int i2 = message.what;
                if (i2 == -105) {
                    this.f2292a.t.i();
                } else if (i2 == -104) {
                    this.f2292a.t.g();
                } else if (i2 == -101) {
                    this.f2292a.t.h();
                } else if (i2 != -100) {
                } else {
                    this.f2292a.t.f();
                }
            }
        }

        public /* synthetic */ b(HorizontalTranslateLayout horizontalTranslateLayout, a aVar) {
            this(horizontalTranslateLayout);
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f2293a;

        /* renamed from: b  reason: collision with root package name */
        public float f2294b;

        /* renamed from: c  reason: collision with root package name */
        public float f2295c;

        /* renamed from: d  reason: collision with root package name */
        public float f2296d;

        /* renamed from: e  reason: collision with root package name */
        public long f2297e;

        /* renamed from: f  reason: collision with root package name */
        public long f2298f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f2299g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ HorizontalTranslateLayout f2300h;

        public c(HorizontalTranslateLayout horizontalTranslateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTranslateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2300h = horizontalTranslateLayout;
            float f2 = horizontalTranslateLayout.getContext().getResources().getDisplayMetrics().density;
        }

        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                e eVar = this.f2300h.v;
                if (eVar != null) {
                    eVar.a();
                }
                this.f2299g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f2297e = uptimeMillis;
                this.f2298f = uptimeMillis + 16;
                this.f2294b = f2;
                this.f2293a = 0.0f;
                this.f2295c = ((-this.f2300h.getMeasuredWidth()) + this.f2300h.f2287f) - this.f2300h.f2289h;
                this.f2296d = this.f2300h.f2289h;
                BdLog.d("Animator@animateTop " + this.f2295c);
                BdLog.d("Animator@animateTop " + f2);
                this.f2300h.s.removeMessages(-100);
                this.f2300h.s.sendEmptyMessageAtTime(-100, this.f2298f);
            }
        }

        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                for (f fVar : this.f2300h.x) {
                    if (fVar != null) {
                        fVar.a();
                    }
                }
                this.f2299g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f2297e = uptimeMillis;
                this.f2298f = uptimeMillis + 16;
                this.f2294b = f2;
                this.f2293a = 0.0f;
                this.f2295c = 0 - this.f2300h.f2289h;
                this.f2296d = this.f2300h.f2289h;
                this.f2300h.s.removeMessages(-104);
                BdLog.d("Animator@animateTopOpen " + this.f2295c);
                BdLog.d("Animator@animateTopOpen " + f2);
                this.f2300h.s.sendEmptyMessageAtTime(-104, this.f2298f);
            }
        }

        public void c(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
                g gVar = this.f2300h.w;
                if (gVar != null) {
                    gVar.a();
                }
                this.f2299g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f2297e = uptimeMillis;
                this.f2298f = uptimeMillis + 16;
                this.f2294b = f2;
                this.f2293a = 0.0f;
                this.f2295c = (this.f2300h.getMeasuredWidth() - this.f2300h.f2288g) - this.f2300h.f2289h;
                this.f2296d = this.f2300h.f2289h;
                BdLog.d("Animator@animateBottom " + this.f2295c);
                BdLog.d("Animator@animateBottom " + f2);
                this.f2300h.s.removeMessages(-101);
                this.f2300h.s.sendEmptyMessageAtTime(-101, this.f2298f);
            }
        }

        public void d(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
                for (f fVar : this.f2300h.x) {
                    if (fVar != null) {
                        fVar.a();
                    }
                }
                this.f2299g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f2297e = uptimeMillis;
                this.f2298f = uptimeMillis + 16;
                this.f2294b = f2;
                this.f2293a = 0.0f;
                this.f2295c = 0 - this.f2300h.f2289h;
                this.f2296d = this.f2300h.f2289h;
                BdLog.d("Animator@animateBottomOpen " + this.f2295c);
                BdLog.d("Animator@animateBottomOpen " + f2);
                this.f2300h.s.removeMessages(-105);
                this.f2300h.s.sendEmptyMessageAtTime(-105, this.f2298f);
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f2293a += this.f2294b * (((float) (uptimeMillis - this.f2297e)) / 1000.0f);
                this.f2297e = uptimeMillis;
                this.f2298f += 16;
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                e();
                float f2 = this.f2293a;
                float f3 = this.f2295c;
                if (f2 <= f3) {
                    e eVar = this.f2300h.v;
                    if (eVar != null) {
                        eVar.b();
                    }
                    this.f2299g = false;
                    this.f2300h.k = 10000;
                    this.f2300h.p();
                    return;
                }
                this.f2300h.f2289h = (int) (d.a.c.k.h.a(f3, f2, false) + this.f2296d);
                this.f2300h.invalidate();
                this.f2300h.s.sendEmptyMessageAtTime(-100, this.f2298f);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                e();
                float f2 = this.f2293a;
                float f3 = this.f2295c;
                if (f2 >= f3) {
                    for (f fVar : this.f2300h.x) {
                        if (fVar != null) {
                            fVar.b();
                        }
                    }
                    this.f2299g = false;
                    this.f2300h.k = 10004;
                    this.f2300h.p();
                    return;
                }
                this.f2300h.f2289h = (int) (d.a.c.k.h.a(f3, f2, false) + this.f2296d);
                this.f2300h.invalidate();
                this.f2300h.s.sendEmptyMessageAtTime(-104, this.f2298f);
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                e();
                float f2 = this.f2293a;
                float f3 = this.f2295c;
                if (f2 >= f3) {
                    g gVar = this.f2300h.w;
                    if (gVar != null) {
                        gVar.b();
                    }
                    this.f2299g = false;
                    this.f2300h.k = 10001;
                    this.f2300h.p();
                    return;
                }
                this.f2300h.f2289h = (int) (d.a.c.k.h.a(f3, f2, false) + this.f2296d);
                this.f2300h.invalidate();
                this.f2300h.s.sendEmptyMessageAtTime(-101, this.f2298f);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                e();
                float f2 = this.f2293a;
                float f3 = this.f2295c;
                if (f2 <= f3) {
                    for (f fVar : this.f2300h.x) {
                        if (fVar != null) {
                            fVar.b();
                        }
                    }
                    this.f2299g = false;
                    this.f2300h.k = 10004;
                    this.f2300h.p();
                    return;
                }
                this.f2300h.f2289h = (int) (d.a.c.k.h.a(f3, f2, false) + this.f2296d);
                this.f2300h.invalidate();
                this.f2300h.s.sendEmptyMessageAtTime(-105, this.f2298f);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a(int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public interface f {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public interface g {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public VelocityTracker f2301a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2302b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2303c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2304d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalTranslateLayout f2305e;

        public h(HorizontalTranslateLayout horizontalTranslateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTranslateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f2305e = horizontalTranslateLayout;
            float f2 = horizontalTranslateLayout.getContext().getResources().getDisplayMetrics().density;
            this.f2303c = (int) ((200.0f * f2) + 0.5f);
            this.f2304d = (int) ((f2 * 500.0f) + 0.5f);
        }

        public final void b() {
            float max;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f2301a.computeCurrentVelocity(this.f2303c);
                float xVelocity = this.f2301a.getXVelocity();
                BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
                if (xVelocity < 0.0f) {
                    max = Math.min(xVelocity, -this.f2304d);
                } else {
                    max = Math.max(xVelocity, this.f2304d);
                }
                int i2 = a.f2291a[this.f2305e.j.ordinal()];
                if (i2 == 1) {
                    d(max);
                } else if (i2 == 2) {
                    g(max);
                } else if (i2 == 3) {
                    c(max);
                }
                this.f2301a.recycle();
                this.f2301a = null;
            }
        }

        public final void c(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                BdLog.d("HorizontalTranslateLayout@horizontalFling");
                int i2 = this.f2305e.f2289h;
                if (i2 <= 0 && i2 >= this.f2305e.f2287f - this.f2305e.getMeasuredWidth()) {
                    if (f2 < 0.0f) {
                        this.f2305e.t.a(f2);
                    } else {
                        this.f2305e.t.b(f2);
                    }
                } else if (i2 < 0 || i2 > this.f2305e.getMeasuredWidth() - this.f2305e.f2288g) {
                } else {
                    if (f2 < 0.0f) {
                        this.f2305e.t.d(f2);
                    } else {
                        this.f2305e.t.c(f2);
                    }
                }
            }
        }

        public final void d(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
                BdLog.d("HorizontalTranslateLayout@leftFling");
                if (f2 < 0.0f) {
                    this.f2305e.t.a(f2);
                } else {
                    this.f2305e.t.b(f2);
                }
            }
        }

        public void e(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && this.f2302b) {
                int i3 = this.f2305e.f2289h - i2;
                int i4 = a.f2291a[this.f2305e.j.ordinal()];
                if (i4 == 1) {
                    BdLog.d("HorizontalTranslateLayout@move left");
                    if (i3 <= this.f2305e.f2287f - this.f2305e.getMeasuredWidth() || i3 >= 0) {
                        return;
                    }
                    this.f2305e.f2289h -= i2;
                    this.f2305e.invalidate();
                } else if (i4 == 2) {
                    BdLog.d("HorizontalTranslateLayout@move right");
                    if (i3 >= this.f2305e.getMeasuredWidth() - this.f2305e.f2288g || i3 <= 0) {
                        return;
                    }
                    this.f2305e.f2289h -= i2;
                    this.f2305e.invalidate();
                } else if (i4 != 3) {
                } else {
                    BdLog.d("HorizontalTranslateLayout@move horizontal");
                    float f2 = i3;
                    if (f2 < this.f2305e.f2287f - this.f2305e.getMeasuredWidth() || f2 > this.f2305e.getMeasuredWidth() - this.f2305e.f2288g) {
                        return;
                    }
                    this.f2305e.f2289h -= i2;
                    this.f2305e.invalidate();
                }
            }
        }

        public boolean f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                int i3 = a.f2291a[this.f2305e.j.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3 && this.f2305e.y != null) {
                            this.f2305e.y.a(i2);
                        }
                    } else if (this.f2305e.k != 10004 && this.f2305e.k != 10001) {
                        return false;
                    }
                } else if (this.f2305e.k != 10004 && this.f2305e.k != 10000) {
                    return false;
                }
                this.f2301a = VelocityTracker.obtain();
                this.f2302b = true;
                return true;
            }
            return invokeI.booleanValue;
        }

        public final void g(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
                BdLog.d("HorizontalTranslateLayout@rightFling");
                if (f2 < 0.0f) {
                    this.f2305e.t.d(f2);
                } else {
                    this.f2305e.t.c(f2);
                }
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f2302b = false;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(913714434, "Lcom/baidu/adp/widget/HorizontalTranslateLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(913714434, "Lcom/baidu/adp/widget/HorizontalTranslateLayout;");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HorizontalTranslateLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
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
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.l = new Rect();
        this.m = new Rect();
        this.x = new ArrayList();
        this.s = new b(this, null);
        this.t = new c(this);
        this.u = new h(this);
        this.k = 10004;
        Resources resources = getResources();
        Paint paint = new Paint();
        this.n = paint;
        paint.setColor(-1);
        this.f2290i = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        o(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            canvas.save();
            canvas.translate(this.f2289h, 0.0f);
            BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.f2289h);
            canvas.drawRect(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), this.n);
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    public int getLeftOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (int) this.f2287f : invokeV.intValue;
    }

    public int getLeftTranslate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f2289h : invokeV.intValue;
    }

    public int getRightOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (int) this.f2288g : invokeV.intValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : invokeV.intValue;
    }

    public final void o(AttributeSet attributeSet) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
            this.f2287f = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
            this.f2288g = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
            String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
            if (string != null && string.length() > 0) {
                if (this.f2287f != -1.0f && this.f2288g != -1.0f && "horizontal".equals(string)) {
                    BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                    this.j = TrackDirection.horizontal;
                } else if (this.f2288g != -1.0f && "right".equals(string)) {
                    BdLog.d("HorizontalTranslateLayout@parseTrack right");
                    this.j = TrackDirection.right;
                } else if (this.f2287f != -1.0f && CustomDialogData.POS_LEFT.equals(string)) {
                    BdLog.d("HorizontalTranslateLayout@parseTrack left");
                    this.j = TrackDirection.left;
                } else {
                    this.j = TrackDirection.none;
                    BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
                }
            }
            String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
            if (string2 != null && string2.length() > 0) {
                for (String str : string2.split("\\|")) {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                    if ((!CustomDialogData.POS_LEFT.equals(str) || this.f2287f == -1.0f) && (!"right".equals(str) || this.f2288g == -1.0f)) {
                        BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                    }
                }
            }
            this.n.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
            obtainStyledAttributes.recycle();
            setClickable(true);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.j == TrackDirection.none) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (this.k != 10004) {
                BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
                return true;
            }
            if (action == 0) {
                this.o = x;
                this.p = y;
                this.s.removeMessages(-100);
                this.s.removeMessages(-104);
                this.s.removeMessages(-101);
                this.s.removeMessages(-105);
            } else if (action == 2) {
                BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                motionEvent.offsetLocation(-this.f2289h, 0.0f);
                return q(x, y);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                float f2 = this.f2287f;
                if (f2 != -1.0f) {
                    this.l.set(i2, i3, (int) (i2 + f2), i5);
                }
                float f3 = this.f2288g;
                if (f3 != -1.0f) {
                    this.m.set((int) (i4 - f3), i3, i4, i5);
                }
            }
            if (this.t.f2299g || this.u.f2302b) {
                return;
            }
            p();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.f2286e = getMeasuredWidth();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cc, code lost:
        if (r2 != 3) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction() & 255;
            if (this.k == 10004) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return false;
                        }
                    } else if (this.u.f2302b) {
                        if (!this.r) {
                            int i2 = this.o;
                            if (x > i2) {
                                this.q = i2 + this.f2290i;
                                this.r = true;
                            } else {
                                this.q = i2 - this.f2290i;
                                this.r = true;
                            }
                        }
                        this.u.e(this.q - x);
                        this.q = x;
                        this.u.f2301a.addMovement(motionEvent);
                    }
                }
                BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                this.r = false;
                if (this.u.f2302b) {
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                    this.u.h();
                    this.u.b();
                }
                return true;
            }
            BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
            BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.l);
            BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.m);
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                    }
                }
                h hVar = this.u;
                if (hVar.f2302b) {
                    hVar.h();
                    this.u.b();
                }
            } else if ((this.k != 10000 || !this.l.contains(x, y)) && (this.k != 10001 || !this.m.contains(x, y))) {
                return false;
            } else {
                h hVar2 = this.u;
                if (!hVar2.f2302b) {
                    this.q = x;
                    hVar2.f(x);
                }
            }
            h hVar3 = this.u;
            if (hVar3.f2302b) {
                hVar3.e(this.q - x);
                this.q = x;
                this.u.f2301a.addMovement(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int i2 = this.k;
            if (i2 == 10000) {
                this.f2289h = (int) (this.f2287f - getMeasuredWidth());
                invalidate();
            } else if (i2 == 10001) {
                this.f2289h = (int) (getMeasuredWidth() - this.f2288g);
                invalidate();
            } else if (i2 != 10004) {
            } else {
                this.f2289h = 0;
                invalidate();
            }
        }
    }

    public final boolean q(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i2, i3)) == null) {
            int i4 = this.p;
            int i5 = this.f2290i;
            if (i3 >= i4 - i5 && i3 <= i4 + i5) {
                int i6 = this.o;
                if ((i2 < i6 - i5 || i2 > i6 + i5) && this.u.f(i2 - this.o)) {
                    return true;
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i2) == null) {
            this.n.setColor(i2);
            invalidate();
        }
    }

    public void setHorizontalTrackListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.y = dVar;
        }
    }

    public void setLeftAnimationListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.v = eVar;
        }
    }

    public void setLeftTapBack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    public void setProportion(float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048592, this, f2) == null) || f2 < -1.0f || f2 > 1.0f) {
            return;
        }
        if (f2 < 0.0f) {
            this.f2289h = (int) ((this.f2287f - this.f2286e) * (-f2));
        } else {
            int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i3 > 0) {
                this.f2289h = (int) ((this.f2286e - this.f2288g) * f2);
            } else if (i3 == 0) {
                this.f2289h = 0;
                this.k = 10004;
            } else if (f2 == -1.0f) {
                this.f2287f -= getMeasuredWidth();
                this.k = 10000;
            } else if (i2 == 0) {
                this.f2287f = getMeasuredWidth() - this.f2288g;
                this.k = 10001;
            }
        }
        invalidate();
    }

    public void setRightAnimationListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, gVar) == null) {
            this.w = gVar;
        }
    }

    public void setRightTapBack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }
}
