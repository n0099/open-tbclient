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
import com.kwad.sdk.core.config.item.TipsConfigItem;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VerticalTranslateLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<e> A;
    public g B;

    /* renamed from: e  reason: collision with root package name */
    public int f2421e;

    /* renamed from: f  reason: collision with root package name */
    public int f2422f;

    /* renamed from: g  reason: collision with root package name */
    public float f2423g;

    /* renamed from: h  reason: collision with root package name */
    public float f2424h;

    /* renamed from: i  reason: collision with root package name */
    public float f2425i;
    public float j;
    public int k;
    public final int l;
    public TrackDirection m;
    public int n;
    public final Rect o;
    public final Rect p;
    public final Paint q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public final b v;
    public final c w;
    public final h x;
    public f y;
    public d z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
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
            bottom = new TrackDirection(TipsConfigItem.TipConfigData.BOTTOM, 1);
            vertical = new TrackDirection("vertical", 2);
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

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f2426a;
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
            f2426a = iArr;
            try {
                iArr[TrackDirection.top.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2426a[TrackDirection.bottom.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2426a[TrackDirection.vertical.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VerticalTranslateLayout f2427a;

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
            this.f2427a = verticalTranslateLayout;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && this.f2427a.w.f2434g) {
                int i2 = message.what;
                if (i2 == -105) {
                    this.f2427a.w.g();
                } else if (i2 == -104) {
                    this.f2427a.w.i();
                } else if (i2 == -101) {
                    this.f2427a.w.f();
                } else if (i2 != -100) {
                } else {
                    this.f2427a.w.h();
                }
            }
        }

        public /* synthetic */ b(VerticalTranslateLayout verticalTranslateLayout, a aVar) {
            this(verticalTranslateLayout);
        }
    }

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public float f2428a;

        /* renamed from: b  reason: collision with root package name */
        public float f2429b;

        /* renamed from: c  reason: collision with root package name */
        public float f2430c;

        /* renamed from: d  reason: collision with root package name */
        public float f2431d;

        /* renamed from: e  reason: collision with root package name */
        public long f2432e;

        /* renamed from: f  reason: collision with root package name */
        public long f2433f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f2434g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ VerticalTranslateLayout f2435h;

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
            this.f2435h = verticalTranslateLayout;
            float f2 = verticalTranslateLayout.getContext().getResources().getDisplayMetrics().density;
        }

        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                d dVar = this.f2435h.z;
                if (dVar != null) {
                    dVar.a();
                }
                this.f2434g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f2432e = uptimeMillis;
                this.f2433f = uptimeMillis + 16;
                this.f2429b = f2;
                this.f2428a = 0.0f;
                this.f2430c = (this.f2435h.f2422f - this.f2435h.f2425i) - this.f2435h.k;
                this.f2431d = this.f2435h.k;
                BdLog.d("Animator@animateBottom " + this.f2430c);
                BdLog.d("Animator@animateBottom " + f2);
                this.f2435h.v.removeMessages(-101);
                this.f2435h.v.sendEmptyMessageAtTime(-101, this.f2433f);
            }
        }

        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                for (e eVar : this.f2435h.A) {
                    if (eVar != null) {
                        eVar.a();
                    }
                }
                this.f2434g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f2432e = uptimeMillis;
                this.f2433f = uptimeMillis + 16;
                this.f2429b = f2;
                this.f2428a = 0.0f;
                this.f2430c = 0 - this.f2435h.k;
                this.f2431d = this.f2435h.k;
                BdLog.d("Animator@animateBottomOpen " + this.f2430c);
                BdLog.d("Animator@animateBottomOpen " + f2);
                this.f2435h.v.removeMessages(-105);
                this.f2435h.v.sendEmptyMessageAtTime(-105, this.f2433f);
            }
        }

        public void c(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
                f fVar = this.f2435h.y;
                if (fVar != null) {
                    fVar.a();
                }
                this.f2434g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f2432e = uptimeMillis;
                this.f2433f = uptimeMillis + 16;
                this.f2429b = f2;
                this.f2428a = 0.0f;
                this.f2430c = ((-this.f2435h.f2422f) + this.f2435h.f2423g) - this.f2435h.k;
                this.f2431d = this.f2435h.k;
                BdLog.d("Animator@animateTop " + this.f2430c);
                BdLog.d("Animator@animateTop " + f2);
                this.f2435h.v.removeMessages(-100);
                this.f2435h.v.sendEmptyMessageAtTime(-100, this.f2433f);
            }
        }

        public void d(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
                for (e eVar : this.f2435h.A) {
                    if (eVar != null) {
                        eVar.a();
                    }
                }
                this.f2434g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f2432e = uptimeMillis;
                this.f2433f = uptimeMillis + 16;
                this.f2429b = f2;
                this.f2428a = 0.0f;
                this.f2430c = 0 - this.f2435h.k;
                this.f2431d = this.f2435h.k;
                this.f2435h.v.removeMessages(-104);
                BdLog.d("Animator@animateTopOpen " + this.f2430c);
                BdLog.d("Animator@animateTopOpen " + f2);
                this.f2435h.v.sendEmptyMessageAtTime(-104, this.f2433f);
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f2428a += this.f2429b * (((float) (uptimeMillis - this.f2432e)) / 1000.0f);
                this.f2432e = uptimeMillis;
                this.f2433f += 16;
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                e();
                float f2 = this.f2428a;
                float f3 = this.f2430c;
                if (f2 >= f3) {
                    d dVar = this.f2435h.z;
                    if (dVar != null) {
                        dVar.b();
                    }
                    this.f2434g = false;
                    this.f2435h.n = 10001;
                    this.f2435h.s();
                    return;
                }
                this.f2435h.k = (int) (d.a.c.k.a.a(f3, f2, false) + this.f2431d);
                this.f2435h.invalidate();
                this.f2435h.v.sendEmptyMessageAtTime(-101, this.f2433f);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                e();
                float f2 = this.f2428a;
                float f3 = this.f2430c;
                if (f2 <= f3) {
                    for (e eVar : this.f2435h.A) {
                        if (eVar != null) {
                            eVar.b();
                        }
                    }
                    this.f2434g = false;
                    this.f2435h.n = 10004;
                    this.f2435h.s();
                    return;
                }
                this.f2435h.k = (int) (d.a.c.k.a.a(f3, f2, false) + this.f2431d);
                this.f2435h.invalidate();
                this.f2435h.v.sendEmptyMessageAtTime(-105, this.f2433f);
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                e();
                float f2 = this.f2428a;
                float f3 = this.f2430c;
                if (f2 <= f3) {
                    f fVar = this.f2435h.y;
                    if (fVar != null) {
                        fVar.b();
                    }
                    this.f2434g = false;
                    this.f2435h.n = 10000;
                    this.f2435h.s();
                    return;
                }
                this.f2435h.k = (int) (d.a.c.k.a.a(f3, f2, false) + this.f2431d);
                this.f2435h.invalidate();
                this.f2435h.v.sendEmptyMessageAtTime(-100, this.f2433f);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                e();
                float f2 = this.f2428a;
                float f3 = this.f2430c;
                if (f2 >= f3) {
                    for (e eVar : this.f2435h.A) {
                        if (eVar != null) {
                            eVar.b();
                        }
                    }
                    this.f2434g = false;
                    this.f2435h.n = 10004;
                    this.f2435h.s();
                    return;
                }
                this.f2435h.k = (int) (d.a.c.k.a.a(f3, f2, false) + this.f2431d);
                this.f2435h.invalidate();
                this.f2435h.v.sendEmptyMessageAtTime(-104, this.f2433f);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void a();

        void b();
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
        void a(int i2);
    }

    /* loaded from: classes.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public VelocityTracker f2436a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2437b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2438c;

        /* renamed from: d  reason: collision with root package name */
        public final int f2439d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VerticalTranslateLayout f2440e;

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
            this.f2440e = verticalTranslateLayout;
            float f2 = verticalTranslateLayout.getContext().getResources().getDisplayMetrics().density;
            this.f2438c = (int) ((200.0f * f2) + 0.5f);
            this.f2439d = (int) ((f2 * 500.0f) + 0.5f);
        }

        public final void b(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                BdLog.d("VerticalTranslateLayout@bottomFling");
                if (f2 < 0.0f) {
                    this.f2440e.w.b(f2);
                } else {
                    this.f2440e.w.a(f2);
                }
            }
        }

        public final void c() {
            float max;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f2436a.computeCurrentVelocity(this.f2438c);
                float yVelocity = this.f2436a.getYVelocity();
                BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
                if (yVelocity < 0.0f) {
                    max = Math.min(yVelocity, -this.f2439d);
                } else {
                    max = Math.max(yVelocity, this.f2439d);
                }
                int i2 = a.f2426a[this.f2440e.m.ordinal()];
                if (i2 == 1) {
                    g(max);
                } else if (i2 == 2) {
                    b(max);
                } else if (i2 == 3) {
                    h(max);
                }
                this.f2436a.recycle();
                this.f2436a = null;
            }
        }

        public void d(int i2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) && this.f2437b) {
                int i3 = this.f2440e.k - i2;
                int i4 = a.f2426a[this.f2440e.m.ordinal()];
                if (i4 == 1) {
                    BdLog.d("VerticalTranslateLayout@move top");
                    if (i3 <= this.f2440e.f2423g - this.f2440e.f2422f || i3 >= 0) {
                        return;
                    }
                    this.f2440e.k -= i2;
                    this.f2440e.invalidate();
                } else if (i4 == 2) {
                    BdLog.d("VerticalTranslateLayout@move bottom");
                    if (i3 >= this.f2440e.f2422f - this.f2440e.f2425i || i3 <= 0) {
                        return;
                    }
                    this.f2440e.k -= i2;
                    this.f2440e.invalidate();
                } else if (i4 != 3) {
                } else {
                    BdLog.d("VerticalTranslateLayout@move vertical");
                    float f2 = i3;
                    if (f2 < this.f2440e.f2423g - this.f2440e.f2422f || f2 > this.f2440e.f2422f - this.f2440e.f2425i) {
                        return;
                    }
                    this.f2440e.k -= i2;
                    this.f2440e.invalidate();
                }
            }
        }

        public boolean e(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
                int i3 = a.f2426a[this.f2440e.m.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3 && this.f2440e.B != null) {
                            this.f2440e.B.a(i2);
                        }
                    } else if (this.f2440e.n != 10004 && this.f2440e.n != 10001) {
                        return false;
                    }
                } else if (this.f2440e.n != 10004 && this.f2440e.n != 10000) {
                    return false;
                }
                this.f2436a = VelocityTracker.obtain();
                this.f2437b = true;
                return true;
            }
            return invokeI.booleanValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f2437b = false;
            }
        }

        public final void g(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
                BdLog.d("VerticalTranslateLayout@topFling");
                if (f2 < 0.0f) {
                    this.f2440e.w.c(f2);
                } else {
                    this.f2440e.w.d(f2);
                }
            }
        }

        public final void h(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
                BdLog.d("VerticalTranslateLayout@verticalFling");
                int i2 = this.f2440e.k;
                if (i2 <= 0 && i2 >= this.f2440e.f2423g - this.f2440e.f2422f) {
                    if (f2 < 0.0f) {
                        this.f2440e.w.c(f2);
                    } else {
                        this.f2440e.w.d(f2);
                    }
                } else if (i2 < 0 || i2 > this.f2440e.f2422f - this.f2440e.f2425i) {
                } else {
                    if (f2 < 0.0f) {
                        this.f2440e.w.b(f2);
                    } else {
                        this.f2440e.w.a(f2);
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
        this.o = new Rect();
        this.p = new Rect();
        this.A = new ArrayList();
        this.v = new b(this, null);
        this.w = new c(this);
        this.x = new h(this);
        this.n = 10004;
        Resources resources = getResources();
        Paint paint = new Paint();
        this.q = paint;
        paint.setColor(-1);
        this.l = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        r(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            canvas.save();
            canvas.translate(0.0f, this.k);
            BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.k);
            canvas.drawRect(0.0f, 0.0f, (float) this.f2421e, (float) this.f2422f, this.q);
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    public int getBottomOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (int) this.f2425i : invokeV.intValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.n : invokeV.intValue;
    }

    public int getTopOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (int) this.f2423g : invokeV.intValue;
    }

    public int getTopTranslate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.k : invokeV.intValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (this.m == TrackDirection.none) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (this.n != 10004) {
                BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
                return true;
            }
            if (action == 0) {
                this.r = x;
                this.s = y;
                this.v.removeMessages(-100);
                this.v.removeMessages(-104);
                this.v.removeMessages(-101);
                this.v.removeMessages(-105);
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
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                float f2 = this.f2423g;
                if (f2 != -1.0f) {
                    this.o.set(i2, i3, i4, (int) (i3 + f2));
                }
                float f3 = this.f2425i;
                if (f3 != -1.0f) {
                    this.p.set(i2, (int) (i5 - f3), i4, i5);
                }
            }
            if (this.w.f2434g || this.x.f2437b) {
                return;
            }
            s();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i2, i3) == null) {
            super.onMeasure(i2, i3);
            int i4 = 1073741823 & i3;
            if (this.f2424h != -1.0f) {
                this.f2423g = i4 - this.j;
            }
            if (this.j != -1.0f) {
                this.f2425i = i4 - this.f2424h;
            }
            this.f2421e = getMeasuredWidth();
            this.f2422f = getMeasuredHeight();
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
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction() & 255;
            int i2 = this.n;
            if (i2 == 10004) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return false;
                        }
                    } else if (this.x.f2437b) {
                        if (!this.u) {
                            int i3 = this.s;
                            if (y > i3) {
                                this.t = i3 + this.l;
                                this.u = true;
                            } else {
                                this.t = i3 - this.l;
                                this.u = true;
                            }
                        }
                        this.x.d(this.t - y);
                        this.t = y;
                        this.x.f2436a.addMovement(motionEvent);
                    }
                }
                BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                this.u = false;
                if (this.x.f2437b) {
                    BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                    this.x.f();
                    this.x.c();
                }
                return true;
            }
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                    }
                }
                h hVar = this.x;
                if (hVar.f2437b) {
                    hVar.f();
                    this.x.c();
                }
            } else if ((i2 != 10000 || !this.o.contains(x, y)) && (this.n != 10001 || !this.p.contains(x, y))) {
                return false;
            } else {
                h hVar2 = this.x;
                if (!hVar2.f2437b) {
                    this.t = y;
                    hVar2.e(y);
                }
            }
            h hVar3 = this.x;
            if (hVar3.f2437b) {
                hVar3.d(this.t - y);
                this.t = y;
                this.x.f2436a.addMovement(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.f2425i == -1.0f && this.f2424h == -1.0f) ? false : true : invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f2423g == -1.0f && this.j == -1.0f) ? false : true : invokeV.booleanValue;
    }

    public final void r(AttributeSet attributeSet) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.VerticalTranslateLayout);
            this.f2423g = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topOffset, -1.0f);
            this.f2425i = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomOffset, -1.0f);
            this.f2424h = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_topHeight, -1.0f);
            this.j = obtainStyledAttributes.getDimension(R.styleable.VerticalTranslateLayout_bottomHeight, -1.0f);
            String string = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_transTrack);
            if (string != null && string.length() > 0) {
                if (q() && p() && "vertical".equals(string)) {
                    BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                    this.m = TrackDirection.vertical;
                } else if (p() && TipsConfigItem.TipConfigData.BOTTOM.equals(string)) {
                    BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                    this.m = TrackDirection.bottom;
                } else if (q() && "top".equals(string)) {
                    BdLog.d("VerticalTranslateLayout@parseTrack top");
                    this.m = TrackDirection.top;
                } else {
                    this.m = TrackDirection.none;
                    BdLog.d("VerticalTranslateLayout@parseTrack no direction");
                }
            }
            String string2 = obtainStyledAttributes.getString(R.styleable.VerticalTranslateLayout_tapBack);
            if (string2 != null && string2.length() > 0) {
                for (String str : string2.split("\\|")) {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                    if ((!"top".equals(str) || this.f2423g == -1.0f) && (!TipsConfigItem.TipConfigData.BOTTOM.equals(str) || this.f2425i == -1.0f)) {
                        BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                    }
                }
            }
            this.q.setColor(obtainStyledAttributes.getColor(R.styleable.VerticalTranslateLayout_transBackground, 0));
            obtainStyledAttributes.recycle();
            setClickable(true);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int i2 = this.n;
            if (i2 == 10000) {
                this.k = (int) (this.f2423g - this.f2422f);
                invalidate();
            } else if (i2 == 10001) {
                this.k = (int) (this.f2422f - this.f2425i);
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
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.q.setColor(i2);
            invalidate();
        }
    }

    public void setBottomAnimationListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.z = dVar;
        }
    }

    public void setBottomTapBack(boolean z) {
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
            this.k = (int) ((this.f2423g - this.f2422f) * (-f2));
        } else {
            int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i3 > 0) {
                this.k = (int) ((this.f2422f - this.f2425i) * f2);
            } else if (i3 == 0) {
                this.k = 0;
                this.n = 10004;
            } else if (f2 == -1.0f) {
                this.f2423g -= this.f2422f;
                this.n = 10000;
            } else if (i2 == 0) {
                this.f2423g = this.f2422f - this.f2425i;
                this.n = 10001;
            }
        }
        invalidate();
    }

    public void setTopAnimationListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) {
            this.y = fVar;
        }
    }

    public void setTopTapBack(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
        }
    }

    public void setVerticalTrackListener(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, gVar) == null) {
            this.B = gVar;
        }
    }

    public final boolean t(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i2, i3)) == null) {
            int i4 = this.r;
            int i5 = this.l;
            if (i2 >= i4 - i5 && i2 <= i4 + i5) {
                int i6 = this.s;
                if ((i3 < i6 - i5 || i3 > i6 + i5) && this.x.e(i3 - this.s)) {
                    return true;
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }
}
