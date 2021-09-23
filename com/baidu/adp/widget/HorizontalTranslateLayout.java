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
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String HORIZONTAL = "horizontal";
    public static final String LEFT = "left";
    public static final String RIGHT = "right";
    public static final int STATE_COLLAPSE_LEFT = 10000;
    public static final int STATE_COLLAPSE_RIGHT = 10001;
    public static final int STATE_EXPAND = 10004;
    public transient /* synthetic */ FieldHolder $fh;
    public d A;

    /* renamed from: e  reason: collision with root package name */
    public int f36438e;

    /* renamed from: f  reason: collision with root package name */
    public float f36439f;

    /* renamed from: g  reason: collision with root package name */
    public float f36440g;

    /* renamed from: h  reason: collision with root package name */
    public int f36441h;

    /* renamed from: i  reason: collision with root package name */
    public final int f36442i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f36443j;
    public boolean k;
    public TrackDirection l;
    public int m;
    public final Rect n;
    public final Rect o;
    public final Paint p;
    public int q;
    public int r;
    public int s;
    public boolean t;
    public final b u;
    public final c v;
    public final h w;
    public e x;
    public g y;
    public final List<f> z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes4.dex */
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
            right = new TrackDirection(HorizontalTranslateLayout.RIGHT, 1);
            horizontal = new TrackDirection(HorizontalTranslateLayout.HORIZONTAL, 2);
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

    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36444a;
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
            f36444a = iArr;
            try {
                iArr[TrackDirection.left.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f36444a[TrackDirection.right.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f36444a[TrackDirection.horizontal.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HorizontalTranslateLayout f36445a;

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
            this.f36445a = horizontalTranslateLayout;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && this.f36445a.v.f36453h) {
                int i2 = message.what;
                if (i2 == -105) {
                    this.f36445a.v.i();
                } else if (i2 == -104) {
                    this.f36445a.v.g();
                } else if (i2 == -101) {
                    this.f36445a.v.h();
                } else if (i2 != -100) {
                } else {
                    this.f36445a.v.f();
                }
            }
        }

        public /* synthetic */ b(HorizontalTranslateLayout horizontalTranslateLayout, a aVar) {
            this(horizontalTranslateLayout);
        }
    }

    /* loaded from: classes4.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final float f36446a;

        /* renamed from: b  reason: collision with root package name */
        public float f36447b;

        /* renamed from: c  reason: collision with root package name */
        public float f36448c;

        /* renamed from: d  reason: collision with root package name */
        public float f36449d;

        /* renamed from: e  reason: collision with root package name */
        public float f36450e;

        /* renamed from: f  reason: collision with root package name */
        public long f36451f;

        /* renamed from: g  reason: collision with root package name */
        public long f36452g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f36453h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ HorizontalTranslateLayout f36454i;

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
            this.f36454i = horizontalTranslateLayout;
            this.f36446a = horizontalTranslateLayout.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                e eVar = this.f36454i.x;
                if (eVar != null) {
                    eVar.a();
                }
                this.f36453h = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f36451f = uptimeMillis;
                this.f36452g = uptimeMillis + 16;
                this.f36448c = f2;
                this.f36447b = 0.0f;
                this.f36449d = ((-this.f36454i.getMeasuredWidth()) + this.f36454i.f36439f) - this.f36454i.f36441h;
                this.f36450e = this.f36454i.f36441h;
                BdLog.d("Animator@animateTop " + this.f36449d);
                BdLog.d("Animator@animateTop " + f2);
                this.f36454i.u.removeMessages(-100);
                this.f36454i.u.sendEmptyMessageAtTime(-100, this.f36452g);
            }
        }

        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                for (f fVar : this.f36454i.z) {
                    if (fVar != null) {
                        fVar.a();
                    }
                }
                this.f36453h = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f36451f = uptimeMillis;
                this.f36452g = uptimeMillis + 16;
                this.f36448c = f2;
                this.f36447b = 0.0f;
                this.f36449d = 0 - this.f36454i.f36441h;
                this.f36450e = this.f36454i.f36441h;
                this.f36454i.u.removeMessages(-104);
                BdLog.d("Animator@animateTopOpen " + this.f36449d);
                BdLog.d("Animator@animateTopOpen " + f2);
                this.f36454i.u.sendEmptyMessageAtTime(-104, this.f36452g);
            }
        }

        public void c(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
                g gVar = this.f36454i.y;
                if (gVar != null) {
                    gVar.a();
                }
                this.f36453h = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f36451f = uptimeMillis;
                this.f36452g = uptimeMillis + 16;
                this.f36448c = f2;
                this.f36447b = 0.0f;
                this.f36449d = (this.f36454i.getMeasuredWidth() - this.f36454i.f36440g) - this.f36454i.f36441h;
                this.f36450e = this.f36454i.f36441h;
                BdLog.d("Animator@animateBottom " + this.f36449d);
                BdLog.d("Animator@animateBottom " + f2);
                this.f36454i.u.removeMessages(-101);
                this.f36454i.u.sendEmptyMessageAtTime(-101, this.f36452g);
            }
        }

        public void d(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
                for (f fVar : this.f36454i.z) {
                    if (fVar != null) {
                        fVar.a();
                    }
                }
                this.f36453h = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f36451f = uptimeMillis;
                this.f36452g = uptimeMillis + 16;
                this.f36448c = f2;
                this.f36447b = 0.0f;
                this.f36449d = 0 - this.f36454i.f36441h;
                this.f36450e = this.f36454i.f36441h;
                BdLog.d("Animator@animateBottomOpen " + this.f36449d);
                BdLog.d("Animator@animateBottomOpen " + f2);
                this.f36454i.u.removeMessages(-105);
                this.f36454i.u.sendEmptyMessageAtTime(-105, this.f36452g);
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f36447b += this.f36448c * (((float) (uptimeMillis - this.f36451f)) / 1000.0f);
                this.f36451f = uptimeMillis;
                this.f36452g += 16;
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                e();
                float f2 = this.f36447b;
                float f3 = this.f36449d;
                if (f2 <= f3) {
                    e eVar = this.f36454i.x;
                    if (eVar != null) {
                        eVar.b();
                    }
                    this.f36453h = false;
                    this.f36454i.m = 10000;
                    this.f36454i.r();
                    return;
                }
                this.f36454i.f36441h = (int) (c.a.e.l.h.a(f3, f2, false) + this.f36450e);
                this.f36454i.invalidate();
                this.f36454i.u.sendEmptyMessageAtTime(-100, this.f36452g);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                e();
                float f2 = this.f36447b;
                float f3 = this.f36449d;
                if (f2 >= f3) {
                    for (f fVar : this.f36454i.z) {
                        if (fVar != null) {
                            fVar.b();
                        }
                    }
                    this.f36453h = false;
                    this.f36454i.m = 10004;
                    this.f36454i.r();
                    return;
                }
                this.f36454i.f36441h = (int) (c.a.e.l.h.a(f3, f2, false) + this.f36450e);
                this.f36454i.invalidate();
                this.f36454i.u.sendEmptyMessageAtTime(-104, this.f36452g);
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                e();
                float f2 = this.f36447b;
                float f3 = this.f36449d;
                if (f2 >= f3) {
                    g gVar = this.f36454i.y;
                    if (gVar != null) {
                        gVar.b();
                    }
                    this.f36453h = false;
                    this.f36454i.m = 10001;
                    this.f36454i.r();
                    return;
                }
                this.f36454i.f36441h = (int) (c.a.e.l.h.a(f3, f2, false) + this.f36450e);
                this.f36454i.invalidate();
                this.f36454i.u.sendEmptyMessageAtTime(-101, this.f36452g);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                e();
                float f2 = this.f36447b;
                float f3 = this.f36449d;
                if (f2 <= f3) {
                    for (f fVar : this.f36454i.z) {
                        if (fVar != null) {
                            fVar.b();
                        }
                    }
                    this.f36453h = false;
                    this.f36454i.m = 10004;
                    this.f36454i.r();
                    return;
                }
                this.f36454i.f36441h = (int) (c.a.e.l.h.a(f3, f2, false) + this.f36450e);
                this.f36454i.invalidate();
                this.f36454i.u.sendEmptyMessageAtTime(-105, this.f36452g);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(int i2);
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a();

        void b();
    }

    /* loaded from: classes4.dex */
    public interface g {
        void a();

        void b();
    }

    /* loaded from: classes4.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public VelocityTracker f36455a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f36456b;

        /* renamed from: c  reason: collision with root package name */
        public final int f36457c;

        /* renamed from: d  reason: collision with root package name */
        public final int f36458d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HorizontalTranslateLayout f36459e;

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
            this.f36459e = horizontalTranslateLayout;
            float f2 = horizontalTranslateLayout.getContext().getResources().getDisplayMetrics().density;
            this.f36457c = (int) ((200.0f * f2) + 0.5f);
            this.f36458d = (int) ((f2 * 500.0f) + 0.5f);
        }

        public final void b() {
            float max;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f36455a.computeCurrentVelocity(this.f36457c);
                float xVelocity = this.f36455a.getXVelocity();
                BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
                if (xVelocity < 0.0f) {
                    max = Math.min(xVelocity, -this.f36458d);
                } else {
                    max = Math.max(xVelocity, this.f36458d);
                }
                int i2 = a.f36444a[this.f36459e.l.ordinal()];
                if (i2 == 1) {
                    d(max);
                } else if (i2 == 2) {
                    g(max);
                } else if (i2 == 3) {
                    c(max);
                }
                this.f36455a.recycle();
                this.f36455a = null;
            }
        }

        public final void c(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                BdLog.d("HorizontalTranslateLayout@horizontalFling");
                int i2 = this.f36459e.f36441h;
                if (i2 <= 0 && i2 >= this.f36459e.f36439f - this.f36459e.getMeasuredWidth()) {
                    if (f2 < 0.0f) {
                        this.f36459e.v.a(f2);
                    } else {
                        this.f36459e.v.b(f2);
                    }
                } else if (i2 < 0 || i2 > this.f36459e.getMeasuredWidth() - this.f36459e.f36440g) {
                } else {
                    if (f2 < 0.0f) {
                        this.f36459e.v.d(f2);
                    } else {
                        this.f36459e.v.c(f2);
                    }
                }
            }
        }

        public final void d(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
                BdLog.d("HorizontalTranslateLayout@leftFling");
                if (f2 < 0.0f) {
                    this.f36459e.v.a(f2);
                } else {
                    this.f36459e.v.b(f2);
                }
            }
        }

        public void e(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(1048579, this, i2) == null) && this.f36456b) {
                int i3 = this.f36459e.f36441h - i2;
                int i4 = a.f36444a[this.f36459e.l.ordinal()];
                if (i4 == 1) {
                    BdLog.d("HorizontalTranslateLayout@move left");
                    if (i3 <= this.f36459e.f36439f - this.f36459e.getMeasuredWidth() || i3 >= 0) {
                        return;
                    }
                    this.f36459e.f36441h -= i2;
                    this.f36459e.invalidate();
                } else if (i4 == 2) {
                    BdLog.d("HorizontalTranslateLayout@move right");
                    if (i3 >= this.f36459e.getMeasuredWidth() - this.f36459e.f36440g || i3 <= 0) {
                        return;
                    }
                    this.f36459e.f36441h -= i2;
                    this.f36459e.invalidate();
                } else if (i4 != 3) {
                } else {
                    BdLog.d("HorizontalTranslateLayout@move horizontal");
                    float f2 = i3;
                    if (f2 < this.f36459e.f36439f - this.f36459e.getMeasuredWidth() || f2 > this.f36459e.getMeasuredWidth() - this.f36459e.f36440g) {
                        return;
                    }
                    this.f36459e.f36441h -= i2;
                    this.f36459e.invalidate();
                }
            }
        }

        public boolean f(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                int i3 = a.f36444a[this.f36459e.l.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3 && this.f36459e.A != null) {
                            this.f36459e.A.a(i2);
                        }
                    } else if (this.f36459e.m != 10004 && this.f36459e.m != 10001) {
                        return false;
                    }
                } else if (this.f36459e.m != 10004 && this.f36459e.m != 10000) {
                    return false;
                }
                this.f36455a = VelocityTracker.obtain();
                this.f36456b = true;
                return true;
            }
            return invokeI.booleanValue;
        }

        public final void g(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
                BdLog.d("HorizontalTranslateLayout@rightFling");
                if (f2 < 0.0f) {
                    this.f36459e.v.d(f2);
                } else {
                    this.f36459e.v.c(f2);
                }
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.f36456b = false;
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
        this.n = new Rect();
        this.o = new Rect();
        this.z = new ArrayList();
        this.u = new b(this, null);
        this.v = new c(this);
        this.w = new h(this);
        this.m = 10004;
        Resources resources = getResources();
        Paint paint = new Paint();
        this.p = paint;
        paint.setColor(-1);
        this.f36442i = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        q(attributeSet);
    }

    public void addOpenAnimationListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, fVar) == null) {
            this.z.add(fVar);
        }
    }

    public void animateLeft() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && o()) {
            c cVar = this.v;
            cVar.a(-cVar.f36446a);
        }
    }

    public void animateOpen() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int i2 = this.m;
            if (i2 == 10000) {
                c cVar = this.v;
                cVar.b(cVar.f36446a);
            } else if (i2 != 10001) {
            } else {
                c cVar2 = this.v;
                cVar2.d(-cVar2.f36446a);
            }
        }
    }

    public void animateRight() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && p()) {
            c cVar = this.v;
            cVar.c(cVar.f36446a);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            canvas.save();
            canvas.translate(this.f36441h, 0.0f);
            BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.f36441h);
            canvas.drawRect(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), this.p);
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    public void dump() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            BdLog.d("HorizontalTranslateLayout@dump top offset " + this.f36439f);
            BdLog.d("HorizontalTranslateLayout@dump bottom offset " + this.f36440g);
            BdLog.d("HorizontalTranslateLayout@dump track " + this.l);
            BdLog.d("HorizontalTranslateLayout@dump top tap " + this.f36443j);
            BdLog.d("HorizontalTranslateLayout@dump bottom tap " + this.f36440g);
        }
    }

    public int getLeftOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (int) this.f36439f : invokeV.intValue;
    }

    public int getLeftTranslate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f36441h : invokeV.intValue;
    }

    public int getRightOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (int) this.f36440g : invokeV.intValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.m : invokeV.intValue;
    }

    public boolean isAnimating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.v.f36453h : invokeV.booleanValue;
    }

    public boolean isLeftTapBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f36443j : invokeV.booleanValue;
    }

    public boolean isRightTapBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.k : invokeV.booleanValue;
    }

    public void left() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f36441h = (int) (this.f36439f - getMeasuredWidth());
            this.m = 10000;
            invalidate();
        }
    }

    public final boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? this.f36439f != -1.0f && this.m == 10004 : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, motionEvent)) == null) {
            if (this.l == TrackDirection.none) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (this.m != 10004) {
                BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
                return true;
            }
            if (action == 0) {
                this.q = x;
                this.r = y;
                this.u.removeMessages(-100);
                this.u.removeMessages(-104);
                this.u.removeMessages(-101);
                this.u.removeMessages(-105);
            } else if (action == 2) {
                BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                motionEvent.offsetLocation(-this.f36441h, 0.0f);
                return s(x, y);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                float f2 = this.f36439f;
                if (f2 != -1.0f) {
                    this.n.set(i2, i3, (int) (i2 + f2), i5);
                }
                float f3 = this.f36440g;
                if (f3 != -1.0f) {
                    this.o.set((int) (i4 - f3), i3, i4, i5);
                }
            }
            if (this.v.f36453h || this.w.f36456b) {
                return;
            }
            r();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048593, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            this.f36438e = getMeasuredWidth();
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction() & 255;
            if (this.m == 10004) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return false;
                        }
                    } else if (this.w.f36456b) {
                        if (!this.t) {
                            int i2 = this.q;
                            if (x > i2) {
                                this.s = i2 + this.f36442i;
                                this.t = true;
                            } else {
                                this.s = i2 - this.f36442i;
                                this.t = true;
                            }
                        }
                        this.w.e(this.s - x);
                        this.s = x;
                        this.w.f36455a.addMovement(motionEvent);
                    }
                }
                BdLog.d("HorizontalTranslateLayout@onTouchEvent up");
                this.t = false;
                if (this.w.f36456b) {
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                    this.w.h();
                    this.w.b();
                }
                return true;
            }
            BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
            BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.n);
            BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.o);
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                    }
                }
                h hVar = this.w;
                if (hVar.f36456b) {
                    hVar.h();
                    this.w.b();
                }
            } else if ((this.m != 10000 || !this.n.contains(x, y)) && (this.m != 10001 || !this.o.contains(x, y))) {
                return false;
            } else {
                h hVar2 = this.w;
                if (!hVar2.f36456b) {
                    this.s = x;
                    hVar2.f(x);
                }
            }
            h hVar3 = this.w;
            if (hVar3.f36456b) {
                hVar3.e(this.s - x);
                this.s = x;
                this.w.f36455a.addMovement(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public void open() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048595, this) == null) {
            this.f36441h = 0;
            this.m = 10004;
            invalidate();
        }
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) ? this.f36440g != -1.0f && this.m == 10004 : invokeV.booleanValue;
    }

    public final void q(AttributeSet attributeSet) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
            this.f36439f = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_leftOffset, -1.0f);
            this.f36440g = obtainStyledAttributes.getDimension(R.styleable.HorizontalTranslateLayout_rightOffset, -1.0f);
            String string = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_transTrack);
            if (string != null && string.length() > 0) {
                if (this.f36439f != -1.0f && this.f36440g != -1.0f && HORIZONTAL.equals(string)) {
                    BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                    this.l = TrackDirection.horizontal;
                } else if (this.f36440g != -1.0f && RIGHT.equals(string)) {
                    BdLog.d("HorizontalTranslateLayout@parseTrack right");
                    this.l = TrackDirection.right;
                } else if (this.f36439f != -1.0f && "left".equals(string)) {
                    BdLog.d("HorizontalTranslateLayout@parseTrack left");
                    this.l = TrackDirection.left;
                } else {
                    this.l = TrackDirection.none;
                    BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
                }
            }
            String string2 = obtainStyledAttributes.getString(R.styleable.HorizontalTranslateLayout_tapBack);
            if (string2 != null && string2.length() > 0) {
                for (String str : string2.split("\\|")) {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                    if ("left".equals(str) && this.f36439f != -1.0f) {
                        this.f36443j = true;
                    } else if (RIGHT.equals(str) && this.f36440g != -1.0f) {
                        this.k = true;
                    } else {
                        BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                    }
                }
            }
            this.p.setColor(obtainStyledAttributes.getColor(R.styleable.HorizontalTranslateLayout_transBackground, 0));
            obtainStyledAttributes.recycle();
            setClickable(true);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048598, this) == null) {
            int i2 = this.m;
            if (i2 == 10000) {
                this.f36441h = (int) (this.f36439f - getMeasuredWidth());
                invalidate();
            } else if (i2 == 10001) {
                this.f36441h = (int) (getMeasuredWidth() - this.f36440g);
                invalidate();
            } else if (i2 != 10004) {
            } else {
                this.f36441h = 0;
                invalidate();
            }
        }
    }

    public void removeOpenAnimationListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, fVar) == null) {
            this.z.remove(fVar);
        }
    }

    public void right() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.f36441h = (int) (getMeasuredWidth() - this.f36440g);
            this.m = 10001;
            invalidate();
        }
    }

    public final boolean s(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048601, this, i2, i3)) == null) {
            int i4 = this.r;
            int i5 = this.f36442i;
            if (i3 >= i4 - i5 && i3 <= i4 + i5) {
                int i6 = this.q;
                if ((i2 < i6 - i5 || i2 > i6 + i5) && this.w.f(i2 - this.q)) {
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
        if (interceptable == null || interceptable.invokeI(1048602, this, i2) == null) {
            this.p.setColor(i2);
            invalidate();
        }
    }

    public void setHorizontalTrackListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, dVar) == null) {
            this.A = dVar;
        }
    }

    public void setLeftAnimationListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, eVar) == null) {
            this.x = eVar;
        }
    }

    public void setLeftTapBack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048605, this, z) == null) {
            this.f36443j = z;
        }
    }

    public void setProportion(float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048606, this, f2) == null) || f2 < -1.0f || f2 > 1.0f) {
            return;
        }
        if (f2 < 0.0f) {
            this.f36441h = (int) ((this.f36439f - this.f36438e) * (-f2));
        } else {
            int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i3 > 0) {
                this.f36441h = (int) ((this.f36438e - this.f36440g) * f2);
            } else if (i3 == 0) {
                this.f36441h = 0;
                this.m = 10004;
            } else if (f2 == -1.0f) {
                this.f36439f -= getMeasuredWidth();
                this.m = 10000;
            } else if (i2 == 0) {
                this.f36439f = getMeasuredWidth() - this.f36440g;
                this.m = 10001;
            }
        }
        invalidate();
    }

    public void setRightAnimationListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, gVar) == null) {
            this.y = gVar;
        }
    }

    public void setRightTapBack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048608, this, z) == null) {
            this.k = z;
        }
    }
}
