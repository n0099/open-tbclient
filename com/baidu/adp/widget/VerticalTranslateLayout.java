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
import com.kwad.sdk.core.config.item.TipsConfigItem;
import com.tachikoma.core.component.anim.AnimationProperty;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class VerticalTranslateLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public int f23999b;

    /* renamed from: c  reason: collision with root package name */
    public float f24000c;

    /* renamed from: d  reason: collision with root package name */
    public float f24001d;

    /* renamed from: e  reason: collision with root package name */
    public float f24002e;

    /* renamed from: f  reason: collision with root package name */
    public float f24003f;

    /* renamed from: g  reason: collision with root package name */
    public int f24004g;

    /* renamed from: h  reason: collision with root package name */
    public final int f24005h;
    public TrackDirection i;
    public int j;
    public final Rect k;
    public final Rect l;
    public final Paint m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public final b r;
    public final c s;
    public final h t;
    public f u;
    public d v;
    public final List<e> w;
    public g x;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
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
            top = new TrackDirection(AnimationProperty.TOP, 0);
            bottom = new TrackDirection(TipsConfigItem.TipConfigData.BOTTOM, 1);
            vertical = new TrackDirection("vertical", 2);
            TrackDirection trackDirection = new TrackDirection("none", 3);
            none = trackDirection;
            $VALUES = new TrackDirection[]{top, bottom, vertical, trackDirection};
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

    /* loaded from: classes3.dex */
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && this.a.s.f24011g) {
                int i = message.what;
                if (i == -105) {
                    this.a.s.g();
                } else if (i == -104) {
                    this.a.s.i();
                } else if (i == -101) {
                    this.a.s.f();
                } else if (i != -100) {
                } else {
                    this.a.s.h();
                }
            }
        }

        public /* synthetic */ b(VerticalTranslateLayout verticalTranslateLayout, a aVar) {
            this(verticalTranslateLayout);
        }
    }

    /* loaded from: classes3.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;

        /* renamed from: b  reason: collision with root package name */
        public float f24006b;

        /* renamed from: c  reason: collision with root package name */
        public float f24007c;

        /* renamed from: d  reason: collision with root package name */
        public float f24008d;

        /* renamed from: e  reason: collision with root package name */
        public long f24009e;

        /* renamed from: f  reason: collision with root package name */
        public long f24010f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f24011g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ VerticalTranslateLayout f24012h;

        public c(VerticalTranslateLayout verticalTranslateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {verticalTranslateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24012h = verticalTranslateLayout;
            float f2 = verticalTranslateLayout.getContext().getResources().getDisplayMetrics().density;
        }

        public void a(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                d dVar = this.f24012h.v;
                if (dVar != null) {
                    dVar.a();
                }
                this.f24011g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f24009e = uptimeMillis;
                this.f24010f = uptimeMillis + 16;
                this.f24006b = f2;
                this.a = 0.0f;
                this.f24007c = (this.f24012h.f23999b - this.f24012h.f24002e) - this.f24012h.f24004g;
                this.f24008d = this.f24012h.f24004g;
                BdLog.d("Animator@animateBottom " + this.f24007c);
                BdLog.d("Animator@animateBottom " + f2);
                this.f24012h.r.removeMessages(-101);
                this.f24012h.r.sendEmptyMessageAtTime(-101, this.f24010f);
            }
        }

        public void b(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f2) == null) {
                for (e eVar : this.f24012h.w) {
                    if (eVar != null) {
                        eVar.a();
                    }
                }
                this.f24011g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f24009e = uptimeMillis;
                this.f24010f = uptimeMillis + 16;
                this.f24006b = f2;
                this.a = 0.0f;
                this.f24007c = 0 - this.f24012h.f24004g;
                this.f24008d = this.f24012h.f24004g;
                BdLog.d("Animator@animateBottomOpen " + this.f24007c);
                BdLog.d("Animator@animateBottomOpen " + f2);
                this.f24012h.r.removeMessages(-105);
                this.f24012h.r.sendEmptyMessageAtTime(-105, this.f24010f);
            }
        }

        public void c(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f2) == null) {
                f fVar = this.f24012h.u;
                if (fVar != null) {
                    fVar.a();
                }
                this.f24011g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f24009e = uptimeMillis;
                this.f24010f = uptimeMillis + 16;
                this.f24006b = f2;
                this.a = 0.0f;
                this.f24007c = ((-this.f24012h.f23999b) + this.f24012h.f24000c) - this.f24012h.f24004g;
                this.f24008d = this.f24012h.f24004g;
                BdLog.d("Animator@animateTop " + this.f24007c);
                BdLog.d("Animator@animateTop " + f2);
                this.f24012h.r.removeMessages(-100);
                this.f24012h.r.sendEmptyMessageAtTime(-100, this.f24010f);
            }
        }

        public void d(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f2) == null) {
                for (e eVar : this.f24012h.w) {
                    if (eVar != null) {
                        eVar.a();
                    }
                }
                this.f24011g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.f24009e = uptimeMillis;
                this.f24010f = uptimeMillis + 16;
                this.f24006b = f2;
                this.a = 0.0f;
                this.f24007c = 0 - this.f24012h.f24004g;
                this.f24008d = this.f24012h.f24004g;
                this.f24012h.r.removeMessages(-104);
                BdLog.d("Animator@animateTopOpen " + this.f24007c);
                BdLog.d("Animator@animateTopOpen " + f2);
                this.f24012h.r.sendEmptyMessageAtTime(-104, this.f24010f);
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.a += this.f24006b * (((float) (uptimeMillis - this.f24009e)) / 1000.0f);
                this.f24009e = uptimeMillis;
                this.f24010f += 16;
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                e();
                float f2 = this.a;
                float f3 = this.f24007c;
                if (f2 >= f3) {
                    d dVar = this.f24012h.v;
                    if (dVar != null) {
                        dVar.b();
                    }
                    this.f24011g = false;
                    this.f24012h.j = 10001;
                    this.f24012h.s();
                    return;
                }
                this.f24012h.f24004g = (int) (c.a.d.o.a.a(f3, f2, false) + this.f24008d);
                this.f24012h.invalidate();
                this.f24012h.r.sendEmptyMessageAtTime(-101, this.f24010f);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                e();
                float f2 = this.a;
                float f3 = this.f24007c;
                if (f2 <= f3) {
                    for (e eVar : this.f24012h.w) {
                        if (eVar != null) {
                            eVar.b();
                        }
                    }
                    this.f24011g = false;
                    this.f24012h.j = 10004;
                    this.f24012h.s();
                    return;
                }
                this.f24012h.f24004g = (int) (c.a.d.o.a.a(f3, f2, false) + this.f24008d);
                this.f24012h.invalidate();
                this.f24012h.r.sendEmptyMessageAtTime(-105, this.f24010f);
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                e();
                float f2 = this.a;
                float f3 = this.f24007c;
                if (f2 <= f3) {
                    f fVar = this.f24012h.u;
                    if (fVar != null) {
                        fVar.b();
                    }
                    this.f24011g = false;
                    this.f24012h.j = 10000;
                    this.f24012h.s();
                    return;
                }
                this.f24012h.f24004g = (int) (c.a.d.o.a.a(f3, f2, false) + this.f24008d);
                this.f24012h.invalidate();
                this.f24012h.r.sendEmptyMessageAtTime(-100, this.f24010f);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                e();
                float f2 = this.a;
                float f3 = this.f24007c;
                if (f2 >= f3) {
                    for (e eVar : this.f24012h.w) {
                        if (eVar != null) {
                            eVar.b();
                        }
                    }
                    this.f24011g = false;
                    this.f24012h.j = 10004;
                    this.f24012h.s();
                    return;
                }
                this.f24012h.f24004g = (int) (c.a.d.o.a.a(f3, f2, false) + this.f24008d);
                this.f24012h.invalidate();
                this.f24012h.r.sendEmptyMessageAtTime(-104, this.f24010f);
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface d {
        void a();

        void b();
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
        void a(int i);
    }

    /* loaded from: classes3.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public VelocityTracker a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f24013b;

        /* renamed from: c  reason: collision with root package name */
        public final int f24014c;

        /* renamed from: d  reason: collision with root package name */
        public final int f24015d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ VerticalTranslateLayout f24016e;

        public h(VerticalTranslateLayout verticalTranslateLayout) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {verticalTranslateLayout};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f24016e = verticalTranslateLayout;
            float f2 = verticalTranslateLayout.getContext().getResources().getDisplayMetrics().density;
            this.f24014c = (int) ((200.0f * f2) + 0.5f);
            this.f24015d = (int) ((f2 * 500.0f) + 0.5f);
        }

        public final void b(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f2) == null) {
                BdLog.d("VerticalTranslateLayout@bottomFling");
                if (f2 < 0.0f) {
                    this.f24016e.s.b(f2);
                } else {
                    this.f24016e.s.a(f2);
                }
            }
        }

        public final void c() {
            float max;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.computeCurrentVelocity(this.f24014c);
                float yVelocity = this.a.getYVelocity();
                BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
                if (yVelocity < 0.0f) {
                    max = Math.min(yVelocity, -this.f24015d);
                } else {
                    max = Math.max(yVelocity, this.f24015d);
                }
                int i = a.a[this.f24016e.i.ordinal()];
                if (i == 1) {
                    g(max);
                } else if (i == 2) {
                    b(max);
                } else if (i == 3) {
                    h(max);
                }
                this.a.recycle();
                this.a = null;
            }
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.f24013b) {
                int i2 = this.f24016e.f24004g - i;
                int i3 = a.a[this.f24016e.i.ordinal()];
                if (i3 == 1) {
                    BdLog.d("VerticalTranslateLayout@move top");
                    if (i2 <= this.f24016e.f24000c - this.f24016e.f23999b || i2 >= 0) {
                        return;
                    }
                    this.f24016e.f24004g -= i;
                    this.f24016e.invalidate();
                } else if (i3 == 2) {
                    BdLog.d("VerticalTranslateLayout@move bottom");
                    if (i2 >= this.f24016e.f23999b - this.f24016e.f24002e || i2 <= 0) {
                        return;
                    }
                    this.f24016e.f24004g -= i;
                    this.f24016e.invalidate();
                } else if (i3 != 3) {
                } else {
                    BdLog.d("VerticalTranslateLayout@move vertical");
                    float f2 = i2;
                    if (f2 < this.f24016e.f24000c - this.f24016e.f23999b || f2 > this.f24016e.f23999b - this.f24016e.f24002e) {
                        return;
                    }
                    this.f24016e.f24004g -= i;
                    this.f24016e.invalidate();
                }
            }
        }

        public boolean e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                int i2 = a.a[this.f24016e.i.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3 && this.f24016e.x != null) {
                            this.f24016e.x.a(i);
                        }
                    } else if (this.f24016e.j != 10004 && this.f24016e.j != 10001) {
                        return false;
                    }
                } else if (this.f24016e.j != 10004 && this.f24016e.j != 10000) {
                    return false;
                }
                this.a = VelocityTracker.obtain();
                this.f24013b = true;
                return true;
            }
            return invokeI.booleanValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.f24013b = false;
            }
        }

        public final void g(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048581, this, f2) == null) {
                BdLog.d("VerticalTranslateLayout@topFling");
                if (f2 < 0.0f) {
                    this.f24016e.s.c(f2);
                } else {
                    this.f24016e.s.d(f2);
                }
            }
        }

        public final void h(float f2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048582, this, f2) == null) {
                BdLog.d("VerticalTranslateLayout@verticalFling");
                int i = this.f24016e.f24004g;
                if (i <= 0 && i >= this.f24016e.f24000c - this.f24016e.f23999b) {
                    if (f2 < 0.0f) {
                        this.f24016e.s.c(f2);
                    } else {
                        this.f24016e.s.d(f2);
                    }
                } else if (i < 0 || i > this.f24016e.f23999b - this.f24016e.f24002e) {
                } else {
                    if (f2 < 0.0f) {
                        this.f24016e.s.b(f2);
                    } else {
                        this.f24016e.s.a(f2);
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
        this.k = new Rect();
        this.l = new Rect();
        this.w = new ArrayList();
        this.r = new b(this, null);
        this.s = new c(this);
        this.t = new h(this);
        this.j = 10004;
        Resources resources = getResources();
        Paint paint = new Paint();
        this.m = paint;
        paint.setColor(-1);
        this.f24005h = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        r(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            canvas.save();
            canvas.translate(0.0f, this.f24004g);
            BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.f24004g);
            canvas.drawRect(0.0f, 0.0f, (float) this.a, (float) this.f23999b, this.m);
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    public int getBottomOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (int) this.f24002e : invokeV.intValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : invokeV.intValue;
    }

    public int getTopOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (int) this.f24000c : invokeV.intValue;
    }

    public int getTopTranslate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f24004g : invokeV.intValue;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            if (this.i == TrackDirection.none) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (this.j != 10004) {
                BdLog.d("VerticalTranslateLayoutIntercepted to onTouch()");
                return true;
            }
            if (action == 0) {
                this.n = x;
                this.o = y;
                this.r.removeMessages(-100);
                this.r.removeMessages(-104);
                this.r.removeMessages(-101);
                this.r.removeMessages(-105);
            } else if (action == 2) {
                BdLog.d("VerticalTranslateLayout@interceptInterceptTouchEvent");
                motionEvent.offsetLocation(0.0f, -this.f24004g);
                return t(x, y);
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                float f2 = this.f24000c;
                if (f2 != -1.0f) {
                    this.k.set(i, i2, i3, (int) (i2 + f2));
                }
                float f3 = this.f24002e;
                if (f3 != -1.0f) {
                    this.l.set(i, (int) (i4 - f3), i3, i4);
                }
            }
            if (this.s.f24011g || this.t.f24013b) {
                return;
            }
            s();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048583, this, i, i2) == null) {
            super.onMeasure(i, i2);
            int i3 = 1073741823 & i2;
            if (this.f24001d != -1.0f) {
                this.f24000c = i3 - this.f24003f;
            }
            if (this.f24003f != -1.0f) {
                this.f24002e = i3 - this.f24001d;
            }
            this.a = getMeasuredWidth();
            this.f23999b = getMeasuredHeight();
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
            int i = this.j;
            if (i == 10004) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return false;
                        }
                    } else if (this.t.f24013b) {
                        if (!this.q) {
                            int i2 = this.o;
                            if (y > i2) {
                                this.p = i2 + this.f24005h;
                                this.q = true;
                            } else {
                                this.p = i2 - this.f24005h;
                                this.q = true;
                            }
                        }
                        this.t.d(this.p - y);
                        this.p = y;
                        this.t.a.addMovement(motionEvent);
                    }
                }
                BdLog.d("VerticalTranslateLayout@onTouchEvent up");
                this.q = false;
                if (this.t.f24013b) {
                    BdLog.d("VerticalTranslateLayout@onTouchEvent tracking");
                    this.t.f();
                    this.t.c();
                }
                return true;
            }
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                    }
                }
                h hVar = this.t;
                if (hVar.f24013b) {
                    hVar.f();
                    this.t.c();
                }
            } else if ((i != 10000 || !this.k.contains(x, y)) && (this.j != 10001 || !this.l.contains(x, y))) {
                return false;
            } else {
                h hVar2 = this.t;
                if (!hVar2.f24013b) {
                    this.p = y;
                    hVar2.e(y);
                }
            }
            h hVar3 = this.t;
            if (hVar3.f24013b) {
                hVar3.d(this.p - y);
                this.p = y;
                this.t.a.addMovement(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final boolean p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.f24002e == -1.0f && this.f24001d == -1.0f) ? false : true : invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.f24000c == -1.0f && this.f24003f == -1.0f) ? false : true : invokeV.booleanValue;
    }

    public final void r(AttributeSet attributeSet) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400e5, R.attr.obfuscated_res_0x7f0400e7, R.attr.obfuscated_res_0x7f0405d3, R.attr.obfuscated_res_0x7f040659, R.attr.obfuscated_res_0x7f04065a, R.attr.obfuscated_res_0x7f040664, R.attr.obfuscated_res_0x7f040665});
            this.f24000c = obtainStyledAttributes.getDimension(4, -1.0f);
            this.f24002e = obtainStyledAttributes.getDimension(1, -1.0f);
            this.f24001d = obtainStyledAttributes.getDimension(3, -1.0f);
            this.f24003f = obtainStyledAttributes.getDimension(0, -1.0f);
            String string = obtainStyledAttributes.getString(6);
            if (string != null && string.length() > 0) {
                if (q() && p() && "vertical".equals(string)) {
                    BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                    this.i = TrackDirection.vertical;
                } else if (p() && TipsConfigItem.TipConfigData.BOTTOM.equals(string)) {
                    BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                    this.i = TrackDirection.bottom;
                } else if (q() && AnimationProperty.TOP.equals(string)) {
                    BdLog.d("VerticalTranslateLayout@parseTrack top");
                    this.i = TrackDirection.top;
                } else {
                    this.i = TrackDirection.none;
                    BdLog.d("VerticalTranslateLayout@parseTrack no direction");
                }
            }
            String string2 = obtainStyledAttributes.getString(2);
            if (string2 != null && string2.length() > 0) {
                for (String str : string2.split(WebChromeClient.PARAM_SEPARATOR)) {
                    BdLog.d("VerticalTranslateLayout@loadAttrs tap area " + str);
                    if ((!AnimationProperty.TOP.equals(str) || this.f24000c == -1.0f) && (!TipsConfigItem.TipConfigData.BOTTOM.equals(str) || this.f24002e == -1.0f)) {
                        BdLog.d("VerticalTranslateLayout@loadAttrs tap_back_area value illegal");
                    }
                }
            }
            this.m.setColor(obtainStyledAttributes.getColor(5, 0));
            obtainStyledAttributes.recycle();
            setClickable(true);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            int i = this.j;
            if (i == 10000) {
                this.f24004g = (int) (this.f24000c - this.f23999b);
                invalidate();
            } else if (i == 10001) {
                this.f24004g = (int) (this.f23999b - this.f24002e);
                invalidate();
            } else if (i != 10004) {
            } else {
                this.f24004g = 0;
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.m.setColor(i);
            invalidate();
        }
    }

    public void setBottomAnimationListener(d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, dVar) == null) {
            this.v = dVar;
        }
    }

    public void setBottomTapBack(boolean z) {
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
            this.f24004g = (int) ((this.f24000c - this.f23999b) * (-f2));
        } else {
            int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i2 > 0) {
                this.f24004g = (int) ((this.f23999b - this.f24002e) * f2);
            } else if (i2 == 0) {
                this.f24004g = 0;
                this.j = 10004;
            } else if (f2 == -1.0f) {
                this.f24000c -= this.f23999b;
                this.j = 10000;
            } else if (i == 0) {
                this.f24000c = this.f23999b - this.f24002e;
                this.j = 10001;
            }
        }
        invalidate();
    }

    public void setTopAnimationListener(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fVar) == null) {
            this.u = fVar;
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
            this.x = gVar;
        }
    }

    public final boolean t(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(1048596, this, i, i2)) == null) {
            int i3 = this.n;
            int i4 = this.f24005h;
            if (i >= i3 - i4 && i <= i3 + i4) {
                int i5 = this.o;
                if ((i2 < i5 - i4 || i2 > i5 + i4) && this.t.e(i2 - this.o)) {
                    return true;
                }
            }
            return false;
        }
        return invokeII.booleanValue;
    }
}
