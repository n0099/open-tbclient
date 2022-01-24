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
/* loaded from: classes9.dex */
public class VerticalTranslateLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String BOTTOM = "bottom";
    public static final int STATE_COLLAPSE_BOTTOM = 10001;
    public static final int STATE_COLLAPSE_TOP = 10000;
    public static final int STATE_EXPAND = 10004;
    public static final String TOP = "top";
    public static final String VERTICAL = "vertical";
    public transient /* synthetic */ FieldHolder $fh;
    public f A;
    public d B;
    public final List<e> C;
    public g D;

    /* renamed from: e  reason: collision with root package name */
    public int f31418e;

    /* renamed from: f  reason: collision with root package name */
    public int f31419f;

    /* renamed from: g  reason: collision with root package name */
    public float f31420g;

    /* renamed from: h  reason: collision with root package name */
    public float f31421h;

    /* renamed from: i  reason: collision with root package name */
    public float f31422i;

    /* renamed from: j  reason: collision with root package name */
    public float f31423j;
    public int k;
    public final int l;
    public boolean m;
    public boolean n;
    public TrackDirection o;
    public int p;
    public final Rect q;
    public final Rect r;
    public final Paint s;
    public int t;
    public int u;
    public int v;
    public boolean w;
    public final b x;
    public final c y;
    public final h z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes9.dex */
    public static final class TrackDirection {
        public static final /* synthetic */ TrackDirection[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final TrackDirection bottom;
        public static final TrackDirection none;
        public static final TrackDirection top;
        public static final TrackDirection vertical;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1658045322, "Lcom/baidu/adp/widget/VerticalTranslateLayout$TrackDirection;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1658045322, "Lcom/baidu/adp/widget/VerticalTranslateLayout$TrackDirection;");
                    return;
                }
            }
            top = new TrackDirection("top", 0);
            bottom = new TrackDirection("bottom", 1);
            vertical = new TrackDirection(VerticalTranslateLayout.VERTICAL, 2);
            TrackDirection trackDirection = new TrackDirection("none", 3);
            none = trackDirection;
            $VALUES = new TrackDirection[]{top, bottom, vertical, trackDirection};
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

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(568037303, "Lcom/baidu/adp/widget/VerticalTranslateLayout$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(568037303, "Lcom/baidu/adp/widget/VerticalTranslateLayout$a;");
                    return;
                }
            }
            int[] iArr = new int[TrackDirection.values().length];
            a = iArr;
            try {
                iArr[TrackDirection.top.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[TrackDirection.bottom.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[TrackDirection.vertical.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VerticalTranslateLayout a;

        public b(VerticalTranslateLayout verticalTranslateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {verticalTranslateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = verticalTranslateLayout;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && this.a.y.f31430h) {
                int i2 = message.what;
                if (i2 == -105) {
                    this.a.y.g();
                } else if (i2 == -104) {
                    this.a.y.i();
                } else if (i2 == -101) {
                    this.a.y.f();
                } else if (i2 != -100) {
                } else {
                    this.a.y.h();
                }
            }
        }

        public /* synthetic */ b(VerticalTranslateLayout verticalTranslateLayout, a aVar) {
            this(verticalTranslateLayout);
        }
    }

    /* loaded from: classes9.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final float a;

        /* renamed from: b  reason: collision with root package name */
        public float f31424b;

        /* renamed from: c  reason: collision with root package name */
        public float f31425c;

        /* renamed from: d  reason: collision with root package name */
        public float f31426d;

        /* renamed from: e  reason: collision with root package name */
        public float f31427e;

        /* renamed from: f  reason: collision with root package name */
        public long f31428f;

        /* renamed from: g  reason: collision with root package name */
        public long f31429g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f31430h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ VerticalTranslateLayout f31431i;

        public c(VerticalTranslateLayout verticalTranslateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {verticalTranslateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31431i = verticalTranslateLayout;
            this.a = verticalTranslateLayout.getContext().getResources().getDisplayMetrics().density * 600.0f;
        }

        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                d dVar = this.f31431i.B;
                if (dVar != null) {
                    dVar.a();
                }
                this.f31430h = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f31428f = uptimeMillis;
                this.f31429g = uptimeMillis + 16;
                this.f31425c = f2;
                this.f31424b = 0.0f;
                this.f31426d = (this.f31431i.f31419f - this.f31431i.f31422i) - this.f31431i.k;
                this.f31427e = this.f31431i.k;
                BdLog.d("Animator@animateBottom " + this.f31426d);
                BdLog.d("Animator@animateBottom " + f2);
                this.f31431i.x.removeMessages(-101);
                this.f31431i.x.sendEmptyMessageAtTime(-101, this.f31429g);
            }
        }

        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                for (e eVar : this.f31431i.C) {
                    if (eVar != null) {
                        eVar.a();
                    }
                }
                this.f31430h = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f31428f = uptimeMillis;
                this.f31429g = uptimeMillis + 16;
                this.f31425c = f2;
                this.f31424b = 0.0f;
                this.f31426d = 0 - this.f31431i.k;
                this.f31427e = this.f31431i.k;
                BdLog.d("Animator@animateBottomOpen " + this.f31426d);
                BdLog.d("Animator@animateBottomOpen " + f2);
                this.f31431i.x.removeMessages(-105);
                this.f31431i.x.sendEmptyMessageAtTime(-105, this.f31429g);
            }
        }

        public void c(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
                f fVar = this.f31431i.A;
                if (fVar != null) {
                    fVar.a();
                }
                this.f31430h = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f31428f = uptimeMillis;
                this.f31429g = uptimeMillis + 16;
                this.f31425c = f2;
                this.f31424b = 0.0f;
                this.f31426d = ((-this.f31431i.f31419f) + this.f31431i.f31420g) - this.f31431i.k;
                this.f31427e = this.f31431i.k;
                BdLog.d("Animator@animateTop " + this.f31426d);
                BdLog.d("Animator@animateTop " + f2);
                this.f31431i.x.removeMessages(-100);
                this.f31431i.x.sendEmptyMessageAtTime(-100, this.f31429g);
            }
        }

        public void d(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
                for (e eVar : this.f31431i.C) {
                    if (eVar != null) {
                        eVar.a();
                    }
                }
                this.f31430h = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f31428f = uptimeMillis;
                this.f31429g = uptimeMillis + 16;
                this.f31425c = f2;
                this.f31424b = 0.0f;
                this.f31426d = 0 - this.f31431i.k;
                this.f31427e = this.f31431i.k;
                this.f31431i.x.removeMessages(-104);
                BdLog.d("Animator@animateTopOpen " + this.f31426d);
                BdLog.d("Animator@animateTopOpen " + f2);
                this.f31431i.x.sendEmptyMessageAtTime(-104, this.f31429g);
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f31424b += this.f31425c * (((float) (uptimeMillis - this.f31428f)) / 1000.0f);
                this.f31428f = uptimeMillis;
                this.f31429g += 16;
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                e();
                float f2 = this.f31424b;
                float f3 = this.f31426d;
                if (f2 >= f3) {
                    d dVar = this.f31431i.B;
                    if (dVar != null) {
                        dVar.b();
                    }
                    this.f31430h = false;
                    this.f31431i.p = 10001;
                    this.f31431i.s();
                    return;
                }
                this.f31431i.k = (int) (c.a.d.n.a.a(f3, f2, false) + this.f31427e);
                this.f31431i.invalidate();
                this.f31431i.x.sendEmptyMessageAtTime(-101, this.f31429g);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                e();
                float f2 = this.f31424b;
                float f3 = this.f31426d;
                if (f2 <= f3) {
                    for (e eVar : this.f31431i.C) {
                        if (eVar != null) {
                            eVar.b();
                        }
                    }
                    this.f31430h = false;
                    this.f31431i.p = 10004;
                    this.f31431i.s();
                    return;
                }
                this.f31431i.k = (int) (c.a.d.n.a.a(f3, f2, false) + this.f31427e);
                this.f31431i.invalidate();
                this.f31431i.x.sendEmptyMessageAtTime(-105, this.f31429g);
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                e();
                float f2 = this.f31424b;
                float f3 = this.f31426d;
                if (f2 <= f3) {
                    f fVar = this.f31431i.A;
                    if (fVar != null) {
                        fVar.b();
                    }
                    this.f31430h = false;
                    this.f31431i.p = 10000;
                    this.f31431i.s();
                    return;
                }
                this.f31431i.k = (int) (c.a.d.n.a.a(f3, f2, false) + this.f31427e);
                this.f31431i.invalidate();
                this.f31431i.x.sendEmptyMessageAtTime(-100, this.f31429g);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                e();
                float f2 = this.f31424b;
                float f3 = this.f31426d;
                if (f2 >= f3) {
                    for (e eVar : this.f31431i.C) {
                        if (eVar != null) {
                            eVar.b();
                        }
                    }
                    this.f31430h = false;
                    this.f31431i.p = 10004;
                    this.f31431i.s();
                    return;
                }
                this.f31431i.k = (int) (c.a.d.n.a.a(f3, f2, false) + this.f31427e);
                this.f31431i.invalidate();
                this.f31431i.x.sendEmptyMessageAtTime(-104, this.f31429g);
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface d {
        void a();

        void b();
    }

    /* loaded from: classes9.dex */
    public interface e {
        void a();

        void b();
    }

    /* loaded from: classes9.dex */
    public interface f {
        void a();

        void b();
    }

    /* loaded from: classes9.dex */
    public interface g {
        void a(int i2);
    }

    /* loaded from: classes9.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public VelocityTracker a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f31432b;

        /* renamed from: c  reason: collision with root package name */
        public final int f31433c;

        /* renamed from: d  reason: collision with root package name */
        public final int f31434d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VerticalTranslateLayout f31435e;

        public h(VerticalTranslateLayout verticalTranslateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {verticalTranslateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31435e = verticalTranslateLayout;
            float f2 = verticalTranslateLayout.getContext().getResources().getDisplayMetrics().density;
            this.f31433c = (int) ((200.0f * f2) + 0.5f);
            this.f31434d = (int) ((f2 * 500.0f) + 0.5f);
        }

        public final void b(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                BdLog.d("VerticalTranslateLayout@bottomFling");
                if (f2 < 0.0f) {
                    this.f31435e.y.b(f2);
                } else {
                    this.f31435e.y.a(f2);
                }
            }
        }

        public final void c() {
            float max;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.computeCurrentVelocity(this.f31433c);
                float yVelocity = this.a.getYVelocity();
                BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
                if (yVelocity < 0.0f) {
                    max = Math.min(yVelocity, -this.f31434d);
                } else {
                    max = Math.max(yVelocity, this.f31434d);
                }
                int i2 = a.a[this.f31435e.o.ordinal()];
                if (i2 == 1) {
                    g(max);
                } else if (i2 == 2) {
                    b(max);
                } else if (i2 == 3) {
                    h(max);
                }
                this.a.recycle();
                this.a = null;
            }
        }

        public void d(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f31432b) {
                int i3 = this.f31435e.k - i2;
                int i4 = a.a[this.f31435e.o.ordinal()];
                if (i4 == 1) {
                    BdLog.d("VerticalTranslateLayout@move top");
                    if (i3 <= this.f31435e.f31420g - this.f31435e.f31419f || i3 >= 0) {
                        return;
                    }
                    this.f31435e.k -= i2;
                    this.f31435e.invalidate();
                } else if (i4 == 2) {
                    BdLog.d("VerticalTranslateLayout@move bottom");
                    if (i3 >= this.f31435e.f31419f - this.f31435e.f31422i || i3 <= 0) {
                        return;
                    }
                    this.f31435e.k -= i2;
                    this.f31435e.invalidate();
                } else if (i4 != 3) {
                } else {
                    BdLog.d("VerticalTranslateLayout@move vertical");
                    float f2 = i3;
                    if (f2 < this.f31435e.f31420g - this.f31435e.f31419f || f2 > this.f31435e.f31419f - this.f31435e.f31422i) {
                        return;
                    }
                    this.f31435e.k -= i2;
                    this.f31435e.invalidate();
                }
            }
        }

        public boolean e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int i3 = a.a[this.f31435e.o.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3 && this.f31435e.D != null) {
                            this.f31435e.D.a(i2);
                        }
                    } else if (this.f31435e.p != 10004 && this.f31435e.p != 10001) {
                        return false;
                    }
                } else if (this.f31435e.p != 10004 && this.f31435e.p != 10000) {
                    return false;
                }
                this.a = VelocityTracker.obtain();
                this.f31432b = true;
                return true;
            }
            return invokeI.booleanValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f31432b = false;
            }
        }

        public final void g(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
                BdLog.d("VerticalTranslateLayout@topFling");
                if (f2 < 0.0f) {
                    this.f31435e.y.c(f2);
                } else {
                    this.f31435e.y.d(f2);
                }
            }
        }

        public final void h(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
                BdLog.d("VerticalTranslateLayout@verticalFling");
                int i2 = this.f31435e.k;
                if (i2 <= 0 && i2 >= this.f31435e.f31420g - this.f31435e.f31419f) {
                    if (f2 < 0.0f) {
                        this.f31435e.y.c(f2);
                    } else {
                        this.f31435e.y.d(f2);
                    }
                } else if (i2 < 0 || i2 > this.f31435e.f31419f - this.f31435e.f31422i) {
                } else {
                    if (f2 < 0.0f) {
                        this.f31435e.y.b(f2);
                    } else {
                        this.f31435e.y.a(f2);
                    }
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1317843180, "Lcom/baidu/adp/widget/VerticalTranslateLayout;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1317843180, "Lcom/baidu/adp/widget/VerticalTranslateLayout;");
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VerticalTranslateLayout(Context context, AttributeSet attributeSet) {
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
        this.q = new Rect();
        this.r = new Rect();
        this.C = new ArrayList();
        this.x = new b(this, null);
        this.y = new c(this);
        this.z = new h(this);
        this.p = 10004;
        Resources resources = getResources();
        Paint paint = new Paint();
        this.s = paint;
        paint.setColor(-1);
        this.l = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        r(attributeSet);
    }

    public void addOpenAnimationListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.C.add(eVar);
        }
    }

    public void collapseBottom(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) && p()) {
            if (z) {
                c cVar = this.y;
                cVar.a(cVar.a);
                return;
            }
            this.k = (int) (this.f31419f - this.f31422i);
            this.p = 10001;
            invalidate();
        }
    }

    public void collapseTop(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) && q()) {
            if (z) {
                c cVar = this.y;
                cVar.c(-cVar.a);
                return;
            }
            this.k = (int) (this.f31420g - this.f31419f);
            this.p = 10000;
            invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            canvas.save();
            canvas.translate(0.0f, this.k);
            BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.k);
            canvas.drawRect(0.0f, 0.0f, (float) this.f31418e, (float) this.f31419f, this.s);
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    public void dump() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            BdLog.d("VerticalTranslateLayout@dump top offset " + this.f31420g);
            BdLog.d("VerticalTranslateLayout@dump bottom offset " + this.f31422i);
            BdLog.d("VerticalTranslateLayout@dump track " + this.o);
            BdLog.d("VerticalTranslateLayout@dump top tap " + this.m);
            BdLog.d("VerticalTranslateLayout@dump bottom tap " + this.f31422i);
        }
    }

    public void expand(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            if (z) {
                int i2 = this.p;
                if (i2 == 10000) {
                    c cVar = this.y;
                    cVar.d(cVar.a);
                    return;
                } else if (i2 != 10001) {
                    return;
                } else {
                    c cVar2 = this.y;
                    cVar2.b(-cVar2.a);
                    return;
                }
            }
            this.k = 0;
            this.p = 10004;
            invalidate();
        }
    }

    public int getBottomOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? (int) this.f31422i : invokeV.intValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.p : invokeV.intValue;
    }

    public int getTopOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (int) this.f31420g : invokeV.intValue;
    }

    public int getTopTranslate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.k : invokeV.intValue;
    }

    public boolean isAnimating() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.y.f31430h : invokeV.booleanValue;
    }

    public boolean isBottomTapBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.n : invokeV.booleanValue;
    }

    public boolean isTopTapBack() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.m : invokeV.booleanValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, motionEvent)) == null) {
            if (this.o == TrackDirection.none) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (this.p != 10004) {
                BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
                return true;
            }
            if (action == 0) {
                this.t = x;
                this.u = y;
                this.x.removeMessages(-100);
                this.x.removeMessages(-104);
                this.x.removeMessages(-101);
                this.x.removeMessages(-105);
            } else if (action == 2) {
                BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                motionEvent.offsetLocation(0.0f, -this.k);
                return t(x, y);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                float f2 = this.f31420g;
                if (f2 != -1.0f) {
                    this.q.set(i2, i3, i4, (int) (i3 + f2));
                }
                float f3 = this.f31422i;
                if (f3 != -1.0f) {
                    this.r.set(i2, (int) (i5 - f3), i4, i5);
                }
            }
            if (this.y.f31430h || this.z.f31432b) {
                return;
            }
            s();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048591, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int i4 = 1073741823 & i3;
            if (this.f31421h != -1.0f) {
                this.f31420g = i4 - this.f31423j;
            }
            if (this.f31423j != -1.0f) {
                this.f31422i = i4 - this.f31421h;
            }
            this.f31418e = getMeasuredWidth();
            this.f31419f = getMeasuredHeight();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0078, code lost:
        if (r2 != 3) goto L19;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction() & 255;
            int i2 = this.p;
            if (i2 == 10004) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return false;
                        }
                    } else if (this.z.f31432b) {
                        if (!this.w) {
                            int i3 = this.u;
                            if (y > i3) {
                                this.v = i3 + this.l;
                                this.w = true;
                            } else {
                                this.v = i3 - this.l;
                                this.w = true;
                            }
                        }
                        this.z.d(this.v - y);
                        this.v = y;
                        this.z.a.addMovement(motionEvent);
                    }
                }
                BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                this.w = false;
                if (this.z.f31432b) {
                    BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                    this.z.f();
                    this.z.c();
                }
                return true;
            }
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                    }
                }
                h hVar = this.z;
                if (hVar.f31432b) {
                    hVar.f();
                    this.z.c();
                }
            } else if ((i2 != 10000 || !this.q.contains(x, y)) && (this.p != 10001 || !this.r.contains(x, y))) {
                return false;
            } else {
                h hVar2 = this.z;
                if (!hVar2.f31432b) {
                    this.v = y;
                    hVar2.e(y);
                }
            }
            h hVar3 = this.z;
            if (hVar3.f31432b) {
                hVar3.d(this.v - y);
                this.v = y;
                this.z.a.addMovement(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? (this.f31422i == -1.0f && this.f31421h == -1.0f) ? false : true : invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? (this.f31420g == -1.0f && this.f31423j == -1.0f) ? false : true : invokeV.booleanValue;
    }

    public final void r(AttributeSet attributeSet) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
            this.f31420g = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
            this.f31422i = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
            this.f31421h = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
            this.f31423j = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
            String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
            if (string != null && string.length() > 0) {
                if (q() && p() && VERTICAL.equals(string)) {
                    BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                    this.o = TrackDirection.vertical;
                } else if (p() && "bottom".equals(string)) {
                    BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                    this.o = TrackDirection.bottom;
                } else if (q() && "top".equals(string)) {
                    BdLog.d("VerticalTranslateLayout@parseTrack top");
                    this.o = TrackDirection.top;
                } else {
                    this.o = TrackDirection.none;
                    BdLog.d("VerticalTranslateLayout@parseTrack no direction");
                }
            }
            String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
            if (string2 != null && string2.length() > 0) {
                for (String str : string2.split("\\|")) {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                    if ("top".equals(str) && this.f31420g != -1.0f) {
                        this.m = true;
                    } else if ("bottom".equals(str) && this.f31422i != -1.0f) {
                        this.n = true;
                    } else {
                        BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                    }
                }
            }
            this.s.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
            obtainStyledAttributes.recycle();
            setClickable(true);
        }
    }

    public void removeOpenAnimationListener(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, eVar) == null) {
            this.C.remove(eVar);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            int i2 = this.p;
            if (i2 == 10000) {
                this.k = (int) (this.f31420g - this.f31419f);
                invalidate();
            } else if (i2 == 10001) {
                this.k = (int) (this.f31419f - this.f31422i);
                invalidate();
            } else if (i2 != 10004) {
            } else {
                this.k = 0;
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i2) == null) {
            this.s.setColor(i2);
            invalidate();
        }
    }

    public void setBottomAnimationListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, dVar) == null) {
            this.B = dVar;
        }
    }

    public void setBottomTapBack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048600, this, z) == null) {
            this.n = z;
        }
    }

    public void setProportion(float f2) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048601, this, f2) == null) || f2 < -1.0f || f2 > 1.0f) {
            return;
        }
        if (f2 < 0.0f) {
            this.k = (int) ((this.f31420g - this.f31419f) * (-f2));
        } else {
            int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i3 > 0) {
                this.k = (int) ((this.f31419f - this.f31422i) * f2);
            } else if (i3 == 0) {
                this.k = 0;
                this.p = 10004;
            } else if (f2 == -1.0f) {
                this.f31420g -= this.f31419f;
                this.p = 10000;
            } else if (i2 == 0) {
                this.f31420g = this.f31419f - this.f31422i;
                this.p = 10001;
            }
        }
        invalidate();
    }

    public void setTopAnimationListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, fVar) == null) {
            this.A = fVar;
        }
    }

    public void setTopTapBack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.m = z;
        }
    }

    public void setVerticalTrackListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, gVar) == null) {
            this.D = gVar;
        }
    }

    public final boolean t(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048605, this, i2, i3)) == null) {
            int i4 = this.t;
            int i5 = this.l;
            if (i2 >= i4 - i5 && i2 <= i4 + i5) {
                int i6 = this.u;
                if ((i3 < i6 - i5 || i3 > i6 + i5) && this.z.e(i3 - this.u)) {
                    return true;
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }
}
