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
import com.baidu.tieba.ej;
import com.baidu.tieba.video.LiveConfig;
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
/* loaded from: classes.dex */
public class HorizontalTranslateLayout extends FrameLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public float b;
    public float c;
    public int d;
    public final int e;
    public TrackDirection f;
    public int g;
    public final Rect h;
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

    /* loaded from: classes.dex */
    public interface d {
        void a(int i);
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
            left = new TrackDirection("left", 0);
            right = new TrackDirection("right", 1);
            horizontal = new TrackDirection(LiveConfig.CUT_LIST_HORIZONTAL_KEY, 2);
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
            if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
                return (TrackDirection) Enum.valueOf(TrackDirection.class, str);
            }
            return (TrackDirection) invokeL.objValue;
        }

        public static TrackDirection[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
                return (TrackDirection[]) $VALUES.clone();
            }
            return (TrackDirection[]) invokeV.objValue;
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

    /* loaded from: classes.dex */
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

        public /* synthetic */ b(HorizontalTranslateLayout horizontalTranslateLayout, a aVar) {
            this(horizontalTranslateLayout);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, message) != null) || !this.a.p.g) {
                return;
            }
            int i = message.what;
            if (i != -105) {
                if (i != -104) {
                    if (i != -101) {
                        if (i == -100) {
                            this.a.p.f();
                            return;
                        }
                        return;
                    }
                    this.a.p.h();
                    return;
                }
                this.a.p.g();
                return;
            }
            this.a.p.i();
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
        public final /* synthetic */ HorizontalTranslateLayout h;

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
            this.h = horizontalTranslateLayout;
            float f = horizontalTranslateLayout.getContext().getResources().getDisplayMetrics().density;
        }

        public void a(float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeF(1048576, this, f) != null) {
                return;
            }
            e eVar = this.h.r;
            if (eVar != null) {
                eVar.a();
            }
            this.g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.e = uptimeMillis;
            this.f = uptimeMillis + 16;
            this.b = f;
            this.a = 0.0f;
            this.c = ((-this.h.getMeasuredWidth()) + this.h.b) - this.h.d;
            this.d = this.h.d;
            BdLog.d("Animator@animateTop " + this.c);
            BdLog.d("Animator@animateTop " + f);
            this.h.o.removeMessages(-100);
            this.h.o.sendEmptyMessageAtTime(-100, this.f);
        }

        public void b(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
                for (f fVar : this.h.t) {
                    if (fVar != null) {
                        fVar.a();
                    }
                }
                this.g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.e = uptimeMillis;
                this.f = uptimeMillis + 16;
                this.b = f;
                this.a = 0.0f;
                this.c = 0 - this.h.d;
                this.d = this.h.d;
                this.h.o.removeMessages(-104);
                BdLog.d("Animator@animateTopOpen " + this.c);
                BdLog.d("Animator@animateTopOpen " + f);
                this.h.o.sendEmptyMessageAtTime(-104, this.f);
            }
        }

        public void c(float f) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) != null) {
                return;
            }
            g gVar = this.h.s;
            if (gVar != null) {
                gVar.a();
            }
            this.g = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            this.e = uptimeMillis;
            this.f = uptimeMillis + 16;
            this.b = f;
            this.a = 0.0f;
            this.c = (this.h.getMeasuredWidth() - this.h.c) - this.h.d;
            this.d = this.h.d;
            BdLog.d("Animator@animateBottom " + this.c);
            BdLog.d("Animator@animateBottom " + f);
            this.h.o.removeMessages(-101);
            this.h.o.sendEmptyMessageAtTime(-101, this.f);
        }

        public void d(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048579, this, f) == null) {
                for (f fVar : this.h.t) {
                    if (fVar != null) {
                        fVar.a();
                    }
                }
                this.g = true;
                long uptimeMillis = SystemClock.uptimeMillis();
                this.e = uptimeMillis;
                this.f = uptimeMillis + 16;
                this.b = f;
                this.a = 0.0f;
                this.c = 0 - this.h.d;
                this.d = this.h.d;
                BdLog.d("Animator@animateBottomOpen " + this.c);
                BdLog.d("Animator@animateBottomOpen " + f);
                this.h.o.removeMessages(-105);
                this.h.o.sendEmptyMessageAtTime(-105, this.f);
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
                if (f <= f2) {
                    e eVar = this.h.r;
                    if (eVar != null) {
                        eVar.b();
                    }
                    this.g = false;
                    this.h.g = 10000;
                    this.h.q();
                    return;
                }
                this.h.d = (int) (ej.a(f2, f, false) + this.d);
                this.h.invalidate();
                this.h.o.sendEmptyMessageAtTime(-100, this.f);
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
                e();
                float f = this.a;
                float f2 = this.c;
                if (f >= f2) {
                    g gVar = this.h.s;
                    if (gVar != null) {
                        gVar.b();
                    }
                    this.g = false;
                    this.h.g = 10001;
                    this.h.q();
                    return;
                }
                this.h.d = (int) (ej.a(f2, f, false) + this.d);
                this.h.invalidate();
                this.h.o.sendEmptyMessageAtTime(-101, this.f);
            }
        }

        public void g() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                e();
                float f = this.a;
                float f2 = this.c;
                if (f >= f2) {
                    for (f fVar : this.h.t) {
                        if (fVar != null) {
                            fVar.b();
                        }
                    }
                    this.g = false;
                    this.h.g = 10004;
                    this.h.q();
                    return;
                }
                this.h.d = (int) (ej.a(f2, f, false) + this.d);
                this.h.invalidate();
                this.h.o.sendEmptyMessageAtTime(-104, this.f);
            }
        }

        public void i() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
                e();
                float f = this.a;
                float f2 = this.c;
                if (f <= f2) {
                    for (f fVar : this.h.t) {
                        if (fVar != null) {
                            fVar.b();
                        }
                    }
                    this.g = false;
                    this.h.g = 10004;
                    this.h.q();
                    return;
                }
                this.h.d = (int) (ej.a(f2, f, false) + this.d);
                this.h.invalidate();
                this.h.o.sendEmptyMessageAtTime(-105, this.f);
            }
        }
    }

    /* loaded from: classes.dex */
    public class h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public VelocityTracker a;
        public boolean b;
        public final int c;
        public final int d;
        public final /* synthetic */ HorizontalTranslateLayout e;

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
            this.e = horizontalTranslateLayout;
            float f = horizontalTranslateLayout.getContext().getResources().getDisplayMetrics().density;
            this.c = (int) ((200.0f * f) + 0.5f);
            this.d = (int) ((f * 500.0f) + 0.5f);
        }

        public final void d(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_SEND_USER_MSG, this, f) == null) {
                BdLog.d("HorizontalTranslateLayout@leftFling");
                if (f < 0.0f) {
                    this.e.p.a(f);
                } else {
                    this.e.p.b(f);
                }
            }
        }

        public final void g(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048581, this, f) == null) {
                BdLog.d("HorizontalTranslateLayout@rightFling");
                if (f < 0.0f) {
                    this.e.p.d(f);
                } else {
                    this.e.p.c(f);
                }
            }
        }

        public final void b() {
            float max;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.computeCurrentVelocity(this.c);
                float xVelocity = this.a.getXVelocity();
                BdLog.d("HorizontalTranslateLayout@fling x " + xVelocity);
                if (xVelocity < 0.0f) {
                    max = Math.min(xVelocity, -this.d);
                } else {
                    max = Math.max(xVelocity, this.d);
                }
                int i = a.a[this.e.f.ordinal()];
                if (i != 1) {
                    if (i != 2) {
                        if (i == 3) {
                            c(max);
                        }
                    } else {
                        g(max);
                    }
                } else {
                    d(max);
                }
                this.a.recycle();
                this.a = null;
            }
        }

        public final void c(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f) == null) {
                BdLog.d("HorizontalTranslateLayout@horizontalFling");
                int i = this.e.d;
                if (i <= 0 && i >= this.e.b - this.e.getMeasuredWidth()) {
                    if (f < 0.0f) {
                        this.e.p.a(f);
                    } else {
                        this.e.p.b(f);
                    }
                } else if (i >= 0 && i <= this.e.getMeasuredWidth() - this.e.c) {
                    if (f < 0.0f) {
                        this.e.p.d(f);
                    } else {
                        this.e.p.c(f);
                    }
                }
            }
        }

        public boolean f(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
                int i2 = a.a[this.e.f.ordinal()];
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3 && this.e.u != null) {
                            this.e.u.a(i);
                        }
                    } else if (this.e.g != 10004 && this.e.g != 10001) {
                        return false;
                    }
                } else if (this.e.g != 10004 && this.e.g != 10000) {
                    return false;
                }
                this.a = VelocityTracker.obtain();
                this.b = true;
                return true;
            }
            return invokeI.booleanValue;
        }

        public void e(int i) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeI(1048579, this, i) != null) || !this.b) {
                return;
            }
            int i2 = this.e.d - i;
            int i3 = a.a[this.e.f.ordinal()];
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3) {
                        BdLog.d("HorizontalTranslateLayout@move horizontal");
                        float f = i2;
                        if (f >= this.e.b - this.e.getMeasuredWidth() && f <= this.e.getMeasuredWidth() - this.e.c) {
                            HorizontalTranslateLayout.l(this.e, i);
                            this.e.invalidate();
                            return;
                        }
                        return;
                    }
                    return;
                }
                BdLog.d("HorizontalTranslateLayout@move right");
                if (i2 < this.e.getMeasuredWidth() - this.e.c && i2 > 0) {
                    HorizontalTranslateLayout.l(this.e, i);
                    this.e.invalidate();
                    return;
                }
                return;
            }
            BdLog.d("HorizontalTranslateLayout@move left");
            if (i2 > this.e.b - this.e.getMeasuredWidth() && i2 < 0) {
                HorizontalTranslateLayout.l(this.e, i);
                this.e.invalidate();
            }
        }

        public void h() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
                this.b = false;
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

    public int getState() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.g;
        }
        return invokeV.intValue;
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
        this.h = new Rect();
        this.i = new Rect();
        this.t = new ArrayList();
        this.o = new b(this, null);
        this.p = new c(this);
        this.q = new h(this);
        this.g = 10004;
        Resources resources = getResources();
        Paint paint = new Paint();
        this.j = paint;
        paint.setColor(-1);
        this.e = (int) ((resources.getDisplayMetrics().density * 35.0f) + 0.5d);
        p(attributeSet);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.j.setColor(i);
            invalidate();
        }
    }

    public static /* synthetic */ int l(HorizontalTranslateLayout horizontalTranslateLayout, int i) {
        int i2 = horizontalTranslateLayout.d - i;
        horizontalTranslateLayout.d = i2;
        return i2;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048580, this, i, i2) == null) {
            super.onMeasure(i, i2);
            this.a = getMeasuredWidth();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            canvas.save();
            canvas.translate(this.d, 0.0f);
            BdLog.d("HorizontalTranslateLayout@dispatchDraw " + this.d);
            canvas.drawRect(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight(), this.j);
            super.dispatchDraw(canvas);
            canvas.restore();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, motionEvent)) == null) {
            if (this.f == TrackDirection.none) {
                return false;
            }
            int action = motionEvent.getAction() & 255;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (this.g == 10004) {
                if (action != 0) {
                    if (action == 2) {
                        BdLog.d("HorizontalTranslateLayout@interceptInterceptTouchEvent");
                        motionEvent.offsetLocation(-this.d, 0.0f);
                        return r(x, y);
                    }
                } else {
                    this.k = x;
                    this.l = y;
                    this.o.removeMessages(-100);
                    this.o.removeMessages(-104);
                    this.o.removeMessages(-101);
                    this.o.removeMessages(-105);
                }
                return false;
            }
            BdLog.d("HorizontalTranslateLayoutIntercepted to onTouch()");
            return true;
        }
        return invokeL.booleanValue;
    }

    public void setProportion(float f2) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeF(1048586, this, f2) == null) && f2 >= -1.0f && f2 <= 1.0f) {
            if (f2 < 0.0f) {
                this.d = (int) ((this.b - this.a) * (-f2));
            } else {
                int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i2 > 0) {
                    this.d = (int) ((this.a - this.c) * f2);
                } else if (i2 == 0) {
                    this.d = 0;
                    this.g = 10004;
                } else if (f2 == -1.0f) {
                    this.b -= getMeasuredWidth();
                    this.g = 10000;
                } else if (i == 0) {
                    this.b = getMeasuredWidth() - this.c;
                    this.g = 10001;
                }
            }
            invalidate();
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                float f2 = this.b;
                if (f2 != -1.0f) {
                    this.h.set(i, i2, (int) (i + f2), i4);
                }
                float f3 = this.c;
                if (f3 != -1.0f) {
                    this.i.set((int) (i3 - f3), i2, i3, i4);
                }
            }
            if (!this.p.g && !this.q.b) {
                q();
            }
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
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, motionEvent)) == null) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            int action = motionEvent.getAction() & 255;
            if (this.g == 10004) {
                if (action != 1) {
                    if (action != 2) {
                        if (action != 3) {
                            return false;
                        }
                    } else if (this.q.b) {
                        if (!this.n) {
                            int i = this.k;
                            if (x > i) {
                                this.m = i + this.e;
                                this.n = true;
                            } else {
                                this.m = i - this.e;
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
                if (this.q.b) {
                    BdLog.d("HorizontalTranslateLayout@onTouchEvent tracking");
                    this.q.h();
                    this.q.b();
                }
                return true;
            }
            BdLog.d("HorizontalTranslateLayout" + String.format("collapse x=%d, y=%d", Integer.valueOf(x), Integer.valueOf(y)));
            BdLog.d("HorizontalTranslateLayoutleft tap back frame = " + this.h);
            BdLog.d("HorizontalTranslateLayoutright tap back frame = " + this.i);
            if (action != 0) {
                if (action != 1) {
                    if (action != 2) {
                    }
                }
                h hVar = this.q;
                if (hVar.b) {
                    hVar.h();
                    this.q.b();
                }
            } else if ((this.g != 10000 || !this.h.contains(x, y)) && (this.g != 10001 || !this.i.contains(x, y))) {
                return false;
            } else {
                h hVar2 = this.q;
                if (!hVar2.b) {
                    this.m = x;
                    hVar2.f(x);
                }
            }
            h hVar3 = this.q;
            if (hVar3.b) {
                hVar3.e(this.m - x);
                this.m = x;
                this.q.a.addMovement(motionEvent);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void p(AttributeSet attributeSet) {
        String[] split;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, attributeSet) == null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.HorizontalTranslateLayout);
            this.b = obtainStyledAttributes.getDimension(0, -1.0f);
            this.c = obtainStyledAttributes.getDimension(2, -1.0f);
            String string = obtainStyledAttributes.getString(6);
            if (string != null && string.length() > 0) {
                if (this.b != -1.0f && this.c != -1.0f && LiveConfig.CUT_LIST_HORIZONTAL_KEY.equals(string)) {
                    BdLog.d("HorizontalTranslateLayout@parseTrack horizontal");
                    this.f = TrackDirection.horizontal;
                } else if (this.c != -1.0f && "right".equals(string)) {
                    BdLog.d("HorizontalTranslateLayout@parseTrack right");
                    this.f = TrackDirection.right;
                } else if (this.b != -1.0f && "left".equals(string)) {
                    BdLog.d("HorizontalTranslateLayout@parseTrack left");
                    this.f = TrackDirection.left;
                } else {
                    this.f = TrackDirection.none;
                    BdLog.d("HorizontalTranslateLayout@loadAttrs no direction");
                }
            }
            String string2 = obtainStyledAttributes.getString(4);
            if (string2 != null && string2.length() > 0) {
                for (String str : string2.split(WebChromeClient.PARAM_SEPARATOR)) {
                    BdLog.d("HorizontalTranslateLayout@loadAttrs tap area " + str);
                    if ((!"left".equals(str) || this.b == -1.0f) && (!"right".equals(str) || this.c == -1.0f)) {
                        BdLog.d("HorizontalTranslateLayout@loadAttrs tap_back_area value illegal");
                    }
                }
            }
            this.j.setColor(obtainStyledAttributes.getColor(5, 0));
            obtainStyledAttributes.recycle();
            setClickable(true);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            int i = this.g;
            if (i != 10000) {
                if (i != 10001) {
                    if (i == 10004) {
                        this.d = 0;
                        invalidate();
                        return;
                    }
                    return;
                }
                this.d = (int) (getMeasuredWidth() - this.c);
                invalidate();
                return;
            }
            this.d = (int) (this.b - getMeasuredWidth());
            invalidate();
        }
    }

    public final boolean r(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, i2)) == null) {
            int i3 = this.l;
            int i4 = this.e;
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
}
