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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebChromeClient;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public float f23906b;

    /* renamed from: c  reason: collision with root package name */
    public float f23907c;

    /* renamed from: d  reason: collision with root package name */
    public int f23908d;

    /* renamed from: e  reason: collision with root package name */
    public final int f23909e;

    /* renamed from: f  reason: collision with root package name */
    public TrackDirection f23910f;

    /* renamed from: g  reason: collision with root package name */
    public int f23911g;

    /* renamed from: h  reason: collision with root package name */
    public final Rect f23912h;
    public final Rect i;
    public final Paint j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public final b o;
    public final c p;
    public final h q;
    public e r;
    public g s;
    public final List<f> t;
    public d u;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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
            left = new TrackDirection("left", 0);
            right = new TrackDirection("right", 1);
            horizontal = new TrackDirection("horizontal", 2);
            TrackDirection trackDirection = new TrackDirection("none", 3);
            none = trackDirection;
            $VALUES = new TrackDirection[]{left, right, horizontal, trackDirection};
        }

        public TrackDirection(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
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

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
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
            a = iArr;
            try {
                iArr[TrackDirection.left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TrackDirection.right.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TrackDirection.horizontal.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ HorizontalTranslateLayout a;

        public b(HorizontalTranslateLayout horizontalTranslateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTranslateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = horizontalTranslateLayout;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && this.a.p.f23918g) {
                int i = message.what;
                if (i == -105) {
                    this.a.p.i();
                } else if (i == -104) {
                    this.a.p.g();
                } else if (i == -101) {
                    this.a.p.h();
                } else if (i != -100) {
                } else {
                    this.a.p.f();
                }
            }
        }

        public /* synthetic */ b(HorizontalTranslateLayout horizontalTranslateLayout, a aVar) {
            this(horizontalTranslateLayout);
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public float f23913b;

        /* renamed from: c  reason: collision with root package name */
        public float f23914c;

        /* renamed from: d  reason: collision with root package name */
        public float f23915d;

        /* renamed from: e  reason: collision with root package name */
        public long f23916e;

        /* renamed from: f  reason: collision with root package name */
        public long f23917f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f23918g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ HorizontalTranslateLayout f23919h;

        public c(HorizontalTranslateLayout horizontalTranslateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTranslateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23919h = horizontalTranslateLayout;
            float f2 = horizontalTranslateLayout.getContext().getResources().getDisplayMetrics().density;
        }

        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                e eVar = this.f23919h.r;
                if (eVar != null) {
                    eVar.a();
                }
                this.f23918g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f23916e = uptimeMillis;
                this.f23917f = uptimeMillis + 16;
                this.f23913b = f2;
                this.a = 0.0f;
                this.f23914c = ((-this.f23919h.getMeasuredWidth()) + this.f23919h.f23906b) - this.f23919h.f23908d;
                this.f23915d = this.f23919h.f23908d;
                BdLog.d("Animator@animateTop " + this.f23914c);
                BdLog.d("Animator@animateTop " + f2);
                this.f23919h.o.removeMessages(-100);
                this.f23919h.o.sendEmptyMessageAtTime(-100, this.f23917f);
            }
        }

        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                for (f fVar : this.f23919h.t) {
                    if (fVar != null) {
                        fVar.a();
                    }
                }
                this.f23918g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f23916e = uptimeMillis;
                this.f23917f = uptimeMillis + 16;
                this.f23913b = f2;
                this.a = 0.0f;
                this.f23914c = 0 - this.f23919h.f23908d;
                this.f23915d = this.f23919h.f23908d;
                this.f23919h.o.removeMessages(-104);
                BdLog.d("Animator@animateTopOpen " + this.f23914c);
                BdLog.d("Animator@animateTopOpen " + f2);
                this.f23919h.o.sendEmptyMessageAtTime(-104, this.f23917f);
            }
        }

        public void c(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
                g gVar = this.f23919h.s;
                if (gVar != null) {
                    gVar.a();
                }
                this.f23918g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f23916e = uptimeMillis;
                this.f23917f = uptimeMillis + 16;
                this.f23913b = f2;
                this.a = 0.0f;
                this.f23914c = (this.f23919h.getMeasuredWidth() - this.f23919h.f23907c) - this.f23919h.f23908d;
                this.f23915d = this.f23919h.f23908d;
                BdLog.d("Animator@animateBottom " + this.f23914c);
                BdLog.d("Animator@animateBottom " + f2);
                this.f23919h.o.removeMessages(-101);
                this.f23919h.o.sendEmptyMessageAtTime(-101, this.f23917f);
            }
        }

        public void d(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
                for (f fVar : this.f23919h.t) {
                    if (fVar != null) {
                        fVar.a();
                    }
                }
                this.f23918g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f23916e = uptimeMillis;
                this.f23917f = uptimeMillis + 16;
                this.f23913b = f2;
                this.a = 0.0f;
                this.f23914c = 0 - this.f23919h.f23908d;
                this.f23915d = this.f23919h.f23908d;
                BdLog.d("Animator@animateBottomOpen " + this.f23914c);
                BdLog.d("Animator@animateBottomOpen " + f2);
                this.f23919h.o.removeMessages(-105);
                this.f23919h.o.sendEmptyMessageAtTime(-105, this.f23917f);
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.a += this.f23913b * (((float) (uptimeMillis - this.f23916e)) / 1000.0f);
                this.f23916e = uptimeMillis;
                this.f23917f += 16;
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                e();
                float f2 = this.a;
                float f3 = this.f23914c;
                if (f2 <= f3) {
                    e eVar = this.f23919h.r;
                    if (eVar != null) {
                        eVar.b();
                    }
                    this.f23918g = false;
                    this.f23919h.f23911g = 10000;
                    this.f23919h.p();
                    return;
                }
                this.f23919h.f23908d = (int) (c.a.d.o.h.a(f3, f2, false) + this.f23915d);
                this.f23919h.invalidate();
                this.f23919h.o.sendEmptyMessageAtTime(-100, this.f23917f);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                e();
                float f2 = this.a;
                float f3 = this.f23914c;
                if (f2 >= f3) {
                    for (f fVar : this.f23919h.t) {
                        if (fVar != null) {
                            fVar.b();
                        }
                    }
                    this.f23918g = false;
                    this.f23919h.f23911g = 10004;
                    this.f23919h.p();
                    return;
                }
                this.f23919h.f23908d = (int) (c.a.d.o.h.a(f3, f2, false) + this.f23915d);
                this.f23919h.invalidate();
                this.f23919h.o.sendEmptyMessageAtTime(-104, this.f23917f);
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                e();
                float f2 = this.a;
                float f3 = this.f23914c;
                if (f2 >= f3) {
                    g gVar = this.f23919h.s;
                    if (gVar != null) {
                        gVar.b();
                    }
                    this.f23918g = false;
                    this.f23919h.f23911g = 10001;
                    this.f23919h.p();
                    return;
                }
                this.f23919h.f23908d = (int) (c.a.d.o.h.a(f3, f2, false) + this.f23915d);
                this.f23919h.invalidate();
                this.f23919h.o.sendEmptyMessageAtTime(-101, this.f23917f);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                e();
                float f2 = this.a;
                float f3 = this.f23914c;
                if (f2 <= f3) {
                    for (f fVar : this.f23919h.t) {
                        if (fVar != null) {
                            fVar.b();
                        }
                    }
                    this.f23918g = false;
                    this.f23919h.f23911g = 10004;
                    this.f23919h.p();
                    return;
                }
                this.f23919h.f23908d = (int) (c.a.d.o.h.a(f3, f2, false) + this.f23915d);
                this.f23919h.invalidate();
                this.f23919h.o.sendEmptyMessageAtTime(-105, this.f23917f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a(int i);
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes3.dex */
    public interface f {
        void a();

        void b();
    }

    /* loaded from: classes3.dex */
    public interface g {
        void a();

        void b();
    }

    /* loaded from: classes3.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public VelocityTracker a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f23920b;

        /* renamed from: c  reason: collision with root package name */
        public final int f23921c;

        /* renamed from: d  reason: collision with root package name */
        public final int f23922d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalTranslateLayout f23923e;

        public h(HorizontalTranslateLayout horizontalTranslateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {horizontalTranslateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f23923e = horizontalTranslateLayout;
            float f2 = horizontalTranslateLayout.getContext().getResources().getDisplayMetrics().density;
            this.f23921c = (int) ((200.0f * f2) + 0.5f);
            this.f23922d = (int) ((f2 * 500.0f) + 0.5f);
        }

        public final void b() {
            float max;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.computeCurrentVelocity(this.f23921c);
                float xVelocity = this.a.getXVelocity();
                BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
                if (xVelocity < 0.0f) {
                    max = Math.min(xVelocity, -this.f23922d);
                } else {
                    max = Math.max(xVelocity, this.f23922d);
                }
                int i = a.a[this.f23923e.f23910f.ordinal()];
                if (i == 1) {
                    d(max);
                } else if (i == 2) {
                    g(max);
                } else if (i == 3) {
                    c(max);
                }
                this.a.recycle();
                this.a = null;
            }
        }

        public final void c(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                BdLog.d("HorizontalTranslateLayout@horizontalFling");
                int i = this.f23923e.f23908d;
                if (i <= 0 && i >= this.f23923e.f23906b - this.f23923e.getMeasuredWidth()) {
                    if (f2 < 0.0f) {
                        this.f23923e.p.a(f2);
                    } else {
                        this.f23923e.p.b(f2);
                    }
                } else if (i < 0 || i > this.f23923e.getMeasuredWidth() - this.f23923e.f23907c) {
                } else {
                    if (f2 < 0.0f) {
                        this.f23923e.p.d(f2);
                    } else {
                        this.f23923e.p.c(f2);
                    }
                }
            }
        }

        public final void d(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
                BdLog.d("HorizontalTranslateLayout@leftFling");
                if (f2 < 0.0f) {
                    this.f23923e.p.a(f2);
                } else {
                    this.f23923e.p.b(f2);
                }
            }
        }

        public void e(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048579, this, i) == null) && this.f23920b) {
                int i2 = this.f23923e.f23908d - i;
                int i3 = a.a[this.f23923e.f23910f.ordinal()];
                if (i3 == 1) {
                    BdLog.d("HorizontalTranslateLayout@move left");
                    if (i2 <= this.f23923e.f23906b - this.f23923e.getMeasuredWidth() || i2 >= 0) {
                        return;
                    }
                    this.f23923e.f23908d -= i;
                    this.f23923e.invalidate();
                } else if (i3 == 2) {
                    BdLog.d("HorizontalTranslateLayout@move right");
                    if (i2 >= this.f23923e.getMeasuredWidth() - this.f23923e.f23907c || i2 <= 0) {
                        return;
                    }
                    this.f23923e.f23908d -= i;
                    this.f23923e.invalidate();
                } else if (i3 != 3) {
                } else {
                    BdLog.d("HorizontalTranslateLayout@move horizontal");
                    float f2 = i2;
                    if (f2 < this.f23923e.f23906b - this.f23923e.getMeasuredWidth() || f2 > this.f23923e.getMeasuredWidth() - this.f23923e.f23907c) {
                        return;
                    }
                    this.f23923e.f23908d -= i;
                    this.f23923e.invalidate();
                }
            }
        }

        public boolean f(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                int i2 = a.a[this.f23923e.f23910f.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3 && this.f23923e.u != null) {
                            this.f23923e.u.a(i);
                        }
                    } else if (this.f23923e.f23911g != 10004 && this.f23923e.f23911g != 10001) {
                        return false;
                    }
                } else if (this.f23923e.f23911g != 10004 && this.f23923e.f23911g != 10000) {
                    return false;
                }
                this.a = VelocityTracker.obtain();
                this.f23920b = true;
                return true;
            }
            return invokeI.booleanValue;
        }

        public final void g(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
                BdLog.d("HorizontalTranslateLayout@rightFling");
                if (f2 < 0.0f) {
                    this.f23923e.p.d(f2);
                } else {
                    this.f23923e.p.c(f2);
                }
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f23920b = false;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f23912h = new Rect();
        this.i = new Rect();
        this.t = new ArrayList();
        this.o = new b(this, null);
        this.p = new c(this);
        this.q = new h(this);
        this.f23911g = 10004;
        Resources resources = getResources();
        Paint paint = new Paint();
        this.j = paint;
        paint.setColor(-1);
        this.f23909e = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        o(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            canvas.save();
            canvas.translate(this.f23908d, 0.0f);
            BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.f23908d);
            canvas.drawRect(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), this.j);
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    public int getLeftOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (int) this.f23906b : invokeV.intValue;
    }

    public int getLeftTranslate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f23908d : invokeV.intValue;
    }

    public int getRightOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (int) this.f23907c : invokeV.intValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f23911g : invokeV.intValue;
    }

    public final void o(AttributeSet attributeSet) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f04039a, R.attr.obfuscated_res_0x7f04039f, R.attr.obfuscated_res_0x7f0404fd, R.attr.obfuscated_res_0x7f040503, R.attr.obfuscated_res_0x7f0405d3, R.attr.obfuscated_res_0x7f040664, R.attr.obfuscated_res_0x7f040665});
            this.f23906b = obtainStyledAttributes.getDimension(0, -1.0f);
            this.f23907c = obtainStyledAttributes.getDimension(2, -1.0f);
            String string = obtainStyledAttributes.getString(6);
            if (string != null && string.length() > 0) {
                if (this.f23906b != -1.0f && this.f23907c != -1.0f && "horizontal".equals(string)) {
                    BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                    this.f23910f = TrackDirection.horizontal;
                } else if (this.f23907c != -1.0f && "right".equals(string)) {
                    BdLog.d("HorizontalTranslateLayout@parseTrack right");
                    this.f23910f = TrackDirection.right;
                } else if (this.f23906b != -1.0f && "left".equals(string)) {
                    BdLog.d("HorizontalTranslateLayout@parseTrack left");
                    this.f23910f = TrackDirection.left;
                } else {
                    this.f23910f = TrackDirection.none;
                    BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
                }
            }
            String string2 = obtainStyledAttributes.getString(4);
            if (string2 != null && string2.length() > 0) {
                for (String str : string2.split(WebChromeClient.PARAM_SEPARATOR)) {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                    if ((!"left".equals(str) || this.f23906b == -1.0f) && (!"right".equals(str) || this.f23907c == -1.0f)) {
                        BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                    }
                }
            }
            this.j.setColor(obtainStyledAttributes.getColor(5, 0));
            obtainStyledAttributes.recycle();
            setClickable(true);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, motionEvent)) == null) {
            if (this.f23910f == TrackDirection.none) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (this.f23911g != 10004) {
                BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
                return true;
            }
            if (action == 0) {
                this.k = x;
                this.l = y;
                this.o.removeMessages(-100);
                this.o.removeMessages(-104);
                this.o.removeMessages(-101);
                this.o.removeMessages(-105);
            } else if (action == 2) {
                BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                motionEvent.offsetLocation(-this.f23908d, 0.0f);
                return q(x, y);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                float f2 = this.f23906b;
                if (f2 != -1.0f) {
                    this.f23912h.set(i, i2, (int) (i + f2), i4);
                }
                float f3 = this.f23907c;
                if (f3 != -1.0f) {
                    this.i.set((int) (i3 - f3), i2, i3, i4);
                }
            }
            if (this.p.f23918g || this.q.f23920b) {
                return;
            }
            p();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.a = getMeasuredWidth();
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
            if (this.f23911g == 10004) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return false;
                        }
                    } else if (this.q.f23920b) {
                        if (!this.n) {
                            int i = this.k;
                            if (x > i) {
                                this.m = i + this.f23909e;
                                this.n = true;
                            } else {
                                this.m = i - this.f23909e;
                                this.n = true;
                            }
                        }
                        this.q.e(this.m - x);
                        this.m = x;
                        this.q.a.addMovement(motionEvent);
                    }
                }
                BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                this.n = false;
                if (this.q.f23920b) {
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                    this.q.h();
                    this.q.b();
                }
                return true;
            }
            BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
            BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.f23912h);
            BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.i);
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                    }
                }
                h hVar = this.q;
                if (hVar.f23920b) {
                    hVar.h();
                    this.q.b();
                }
            } else if ((this.f23911g != 10000 || !this.f23912h.contains(x, y)) && (this.f23911g != 10001 || !this.i.contains(x, y))) {
                return false;
            } else {
                h hVar2 = this.q;
                if (!hVar2.f23920b) {
                    this.m = x;
                    hVar2.f(x);
                }
            }
            h hVar3 = this.q;
            if (hVar3.f23920b) {
                hVar3.e(this.m - x);
                this.m = x;
                this.q.a.addMovement(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            int i = this.f23911g;
            if (i == 10000) {
                this.f23908d = (int) (this.f23906b - getMeasuredWidth());
                invalidate();
            } else if (i == 10001) {
                this.f23908d = (int) (getMeasuredWidth() - this.f23907c);
                invalidate();
            } else if (i != 10004) {
            } else {
                this.f23908d = 0;
                invalidate();
            }
        }
    }

    public final boolean q(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048587, this, i, i2)) == null) {
            int i3 = this.l;
            int i4 = this.f23909e;
            if (i2 >= i3 - i4 && i2 <= i3 + i4) {
                int i5 = this.k;
                if ((i < i5 - i4 || i > i5 + i4) && this.q.f(i - this.k)) {
                    return true;
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.j.setColor(i);
            invalidate();
        }
    }

    public void setHorizontalTrackListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dVar) == null) {
            this.u = dVar;
        }
    }

    public void setLeftAnimationListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, eVar) == null) {
            this.r = eVar;
        }
    }

    public void setLeftTapBack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
        }
    }

    public void setProportion(float f2) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048592, this, f2) == null) || f2 < -1.0f || f2 > 1.0f) {
            return;
        }
        if (f2 < 0.0f) {
            this.f23908d = (int) ((this.f23906b - this.a) * (-f2));
        } else {
            int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i2 > 0) {
                this.f23908d = (int) ((this.a - this.f23907c) * f2);
            } else if (i2 == 0) {
                this.f23908d = 0;
                this.f23911g = 10004;
            } else if (f2 == -1.0f) {
                this.f23906b -= getMeasuredWidth();
                this.f23911g = 10000;
            } else if (i == 0) {
                this.f23906b = getMeasuredWidth() - this.f23907c;
                this.f23911g = 10001;
            }
        }
        invalidate();
    }

    public void setRightAnimationListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, gVar) == null) {
            this.s = gVar;
        }
    }

    public void setRightTapBack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }
}
