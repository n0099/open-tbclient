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
import com.repackage.um;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class VerticalTranslateLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int b;
    public float c;
    public float d;
    public float e;
    public float f;
    public int g;
    public final int h;
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
            bottom = new TrackDirection("bottom", 1);
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

    /* loaded from: classes.dex */
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

    /* loaded from: classes.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, message) == null) && this.a.s.g) {
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

    /* loaded from: classes.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public float a;
        public float b;
        public float c;
        public float d;
        public long e;
        public long f;
        public boolean g;
        public final /* synthetic */ VerticalTranslateLayout h;

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
            this.h = verticalTranslateLayout;
            float f = verticalTranslateLayout.getContext().getResources().getDisplayMetrics().density;
        }

        public void a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                d dVar = this.h.v;
                if (dVar != null) {
                    dVar.a();
                }
                this.g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.e = uptimeMillis;
                this.f = uptimeMillis + 16;
                this.b = f;
                this.a = 0.0f;
                this.c = (this.h.b - this.h.e) - this.h.g;
                this.d = this.h.g;
                BdLog.d("Animator@animateBottom " + this.c);
                BdLog.d("Animator@animateBottom " + f);
                this.h.r.removeMessages(-101);
                this.h.r.sendEmptyMessageAtTime(-101, this.f);
            }
        }

        public void b(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
                for (e eVar : this.h.w) {
                    if (eVar != null) {
                        eVar.a();
                    }
                }
                this.g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.e = uptimeMillis;
                this.f = uptimeMillis + 16;
                this.b = f;
                this.a = 0.0f;
                this.c = 0 - this.h.g;
                this.d = this.h.g;
                BdLog.d("Animator@animateBottomOpen " + this.c);
                BdLog.d("Animator@animateBottomOpen " + f);
                this.h.r.removeMessages(-105);
                this.h.r.sendEmptyMessageAtTime(-105, this.f);
            }
        }

        public void c(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
                f fVar = this.h.u;
                if (fVar != null) {
                    fVar.a();
                }
                this.g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.e = uptimeMillis;
                this.f = uptimeMillis + 16;
                this.b = f;
                this.a = 0.0f;
                this.c = ((-this.h.b) + this.h.c) - this.h.g;
                this.d = this.h.g;
                BdLog.d("Animator@animateTop " + this.c);
                BdLog.d("Animator@animateTop " + f);
                this.h.r.removeMessages(-100);
                this.h.r.sendEmptyMessageAtTime(-100, this.f);
            }
        }

        public void d(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
                for (e eVar : this.h.w) {
                    if (eVar != null) {
                        eVar.a();
                    }
                }
                this.g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.e = uptimeMillis;
                this.f = uptimeMillis + 16;
                this.b = f;
                this.a = 0.0f;
                this.c = 0 - this.h.g;
                this.d = this.h.g;
                this.h.r.removeMessages(-104);
                BdLog.d("Animator@animateTopOpen " + this.c);
                BdLog.d("Animator@animateTopOpen " + f);
                this.h.r.sendEmptyMessageAtTime(-104, this.f);
            }
        }

        public final void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                this.a += this.b * (((float) (uptimeMillis - this.e)) / 1000.0f);
                this.e = uptimeMillis;
                this.f += 16;
            }
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                e();
                float f = this.a;
                float f2 = this.c;
                if (f >= f2) {
                    d dVar = this.h.v;
                    if (dVar != null) {
                        dVar.b();
                    }
                    this.g = false;
                    this.h.j = 10001;
                    this.h.s();
                    return;
                }
                this.h.g = (int) (um.a(f2, f, false) + this.d);
                this.h.invalidate();
                this.h.r.sendEmptyMessageAtTime(-101, this.f);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                e();
                float f = this.a;
                float f2 = this.c;
                if (f <= f2) {
                    for (e eVar : this.h.w) {
                        if (eVar != null) {
                            eVar.b();
                        }
                    }
                    this.g = false;
                    this.h.j = 10004;
                    this.h.s();
                    return;
                }
                this.h.g = (int) (um.a(f2, f, false) + this.d);
                this.h.invalidate();
                this.h.r.sendEmptyMessageAtTime(-105, this.f);
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                e();
                float f = this.a;
                float f2 = this.c;
                if (f <= f2) {
                    f fVar = this.h.u;
                    if (fVar != null) {
                        fVar.b();
                    }
                    this.g = false;
                    this.h.j = 10000;
                    this.h.s();
                    return;
                }
                this.h.g = (int) (um.a(f2, f, false) + this.d);
                this.h.invalidate();
                this.h.r.sendEmptyMessageAtTime(-100, this.f);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                e();
                float f = this.a;
                float f2 = this.c;
                if (f >= f2) {
                    for (e eVar : this.h.w) {
                        if (eVar != null) {
                            eVar.b();
                        }
                    }
                    this.g = false;
                    this.h.j = 10004;
                    this.h.s();
                    return;
                }
                this.h.g = (int) (um.a(f2, f, false) + this.d);
                this.h.invalidate();
                this.h.r.sendEmptyMessageAtTime(-104, this.f);
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
        void a(int i);
    }

    /* loaded from: classes.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public VelocityTracker a;
        public boolean b;
        public final int c;
        public final int d;
        public final /* synthetic */ VerticalTranslateLayout e;

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
            this.e = verticalTranslateLayout;
            float f = verticalTranslateLayout.getContext().getResources().getDisplayMetrics().density;
            this.c = (int) ((200.0f * f) + 0.5f);
            this.d = (int) ((f * 500.0f) + 0.5f);
        }

        public final void b(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048576, this, f) == null) {
                BdLog.d("VerticalTranslateLayout@bottomFling");
                if (f < 0.0f) {
                    this.e.s.b(f);
                } else {
                    this.e.s.a(f);
                }
            }
        }

        public final void c() {
            float max;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.computeCurrentVelocity(this.c);
                float yVelocity = this.a.getYVelocity();
                BdLog.d("VerticalTranslateLayout@fling y " + yVelocity);
                if (yVelocity < 0.0f) {
                    max = Math.min(yVelocity, -this.d);
                } else {
                    max = Math.max(yVelocity, this.d);
                }
                int i = a.a[this.e.i.ordinal()];
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
            if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.b) {
                int i2 = this.e.g - i;
                int i3 = a.a[this.e.i.ordinal()];
                if (i3 == 1) {
                    BdLog.d("VerticalTranslateLayout@move top");
                    if (i2 <= this.e.c - this.e.b || i2 >= 0) {
                        return;
                    }
                    this.e.g -= i;
                    this.e.invalidate();
                } else if (i3 == 2) {
                    BdLog.d("VerticalTranslateLayout@move bottom");
                    if (i2 >= this.e.b - this.e.e || i2 <= 0) {
                        return;
                    }
                    this.e.g -= i;
                    this.e.invalidate();
                } else if (i3 != 3) {
                } else {
                    BdLog.d("VerticalTranslateLayout@move vertical");
                    float f = i2;
                    if (f < this.e.c - this.e.b || f > this.e.b - this.e.e) {
                        return;
                    }
                    this.e.g -= i;
                    this.e.invalidate();
                }
            }
        }

        public boolean e(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
                int i2 = a.a[this.e.i.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3 && this.e.x != null) {
                            this.e.x.a(i);
                        }
                    } else if (this.e.j != 10004 && this.e.j != 10001) {
                        return false;
                    }
                } else if (this.e.j != 10004 && this.e.j != 10000) {
                    return false;
                }
                this.a = VelocityTracker.obtain();
                this.b = true;
                return true;
            }
            return invokeI.booleanValue;
        }

        public void f() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                this.b = false;
            }
        }

        public final void g(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
                BdLog.d("VerticalTranslateLayout@topFling");
                if (f < 0.0f) {
                    this.e.s.c(f);
                } else {
                    this.e.s.d(f);
                }
            }
        }

        public final void h(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048582, this, f) == null) {
                BdLog.d("VerticalTranslateLayout@verticalFling");
                int i = this.e.g;
                if (i <= 0 && i >= this.e.c - this.e.b) {
                    if (f < 0.0f) {
                        this.e.s.c(f);
                    } else {
                        this.e.s.d(f);
                    }
                } else if (i < 0 || i > this.e.b - this.e.e) {
                } else {
                    if (f < 0.0f) {
                        this.e.s.b(f);
                    } else {
                        this.e.s.a(f);
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
        this.h = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        r(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            canvas.save();
            canvas.translate(0.0f, this.g);
            BdLog.d("VerticalTranslateLayout@dispatchDraw " + this.g);
            canvas.drawRect(0.0f, 0.0f, (float) this.a, (float) this.b, this.m);
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    public int getBottomOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? (int) this.e : invokeV.intValue;
    }

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.j : invokeV.intValue;
    }

    public int getTopOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? (int) this.c : invokeV.intValue;
    }

    public int getTopTranslate() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : invokeV.intValue;
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
                motionEvent.offsetLocation(0.0f, -this.g);
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
                float f2 = this.c;
                if (f2 != -1.0f) {
                    this.k.set(i, i2, i3, (int) (i2 + f2));
                }
                float f3 = this.e;
                if (f3 != -1.0f) {
                    this.l.set(i, (int) (i4 - f3), i3, i4);
                }
            }
            if (this.s.g || this.t.b) {
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
            if (this.d != -1.0f) {
                this.c = i3 - this.f;
            }
            if (this.f != -1.0f) {
                this.e = i3 - this.d;
            }
            this.a = getMeasuredWidth();
            this.b = getMeasuredHeight();
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
                    } else if (this.t.b) {
                        if (!this.q) {
                            int i2 = this.o;
                            if (y > i2) {
                                this.p = i2 + this.h;
                                this.q = true;
                            } else {
                                this.p = i2 - this.h;
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
                if (this.t.b) {
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
                if (hVar.b) {
                    hVar.f();
                    this.t.c();
                }
            } else if ((i != 10000 || !this.k.contains(x, y)) && (this.j != 10001 || !this.l.contains(x, y))) {
                return false;
            } else {
                h hVar2 = this.t;
                if (!hVar2.b) {
                    this.p = y;
                    hVar2.e(y);
                }
            }
            h hVar3 = this.t;
            if (hVar3.b) {
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
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (this.e == -1.0f && this.d == -1.0f) ? false : true : invokeV.booleanValue;
    }

    public final boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? (this.c == -1.0f && this.f == -1.0f) ? false : true : invokeV.booleanValue;
    }

    public final void r(AttributeSet attributeSet) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0400f2, R.attr.obfuscated_res_0x7f0400f4, R.attr.obfuscated_res_0x7f0406a2, R.attr.obfuscated_res_0x7f04072c, R.attr.obfuscated_res_0x7f04072d, R.attr.obfuscated_res_0x7f04073a, R.attr.obfuscated_res_0x7f04073b});
            this.c = obtainStyledAttributes.getDimension(4, -1.0f);
            this.e = obtainStyledAttributes.getDimension(1, -1.0f);
            this.d = obtainStyledAttributes.getDimension(3, -1.0f);
            this.f = obtainStyledAttributes.getDimension(0, -1.0f);
            String string = obtainStyledAttributes.getString(6);
            if (string != null && string.length() > 0) {
                if (q() && p() && "vertical".equals(string)) {
                    BdLog.d("VerticalTranslateLayout@parseTrack vertical");
                    this.i = TrackDirection.vertical;
                } else if (p() && "bottom".equals(string)) {
                    BdLog.d("VerticalTranslateLayout@parseTrack bottom");
                    this.i = TrackDirection.bottom;
                } else if (q() && "top".equals(string)) {
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
                    if ((!"top".equals(str) || this.c == -1.0f) && (!"bottom".equals(str) || this.e == -1.0f)) {
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
                this.g = (int) (this.c - this.b);
                invalidate();
            } else if (i == 10001) {
                this.g = (int) (this.b - this.e);
                invalidate();
            } else if (i != 10004) {
            } else {
                this.g = 0;
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
            this.g = (int) ((this.c - this.b) * (-f2));
        } else {
            int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i2 > 0) {
                this.g = (int) ((this.b - this.e) * f2);
            } else if (i2 == 0) {
                this.g = 0;
                this.j = 10004;
            } else if (f2 == -1.0f) {
                this.c -= this.b;
                this.j = 10000;
            } else if (i == 0) {
                this.c = this.b - this.e;
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
            int i4 = this.h;
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
