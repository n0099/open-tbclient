package com.baidu.swan.apps.res.ui.wheelview3d;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import c.a.p0.a.s1.a.e.a.c;
import c.a.p0.a.s1.a.e.c.b;
import c.a.p0.a.t1.e;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public class WheelView3d extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] e0;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public float B;
    public boolean C;
    public float D;
    public float E;
    public float F;
    public float G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public float Q;
    public long R;
    public int S;
    public int T;
    public int U;
    public int V;
    public float W;
    public Drawable a0;
    public Drawable b0;
    public Paint c0;
    public int d0;

    /* renamed from: e  reason: collision with root package name */
    public DividerType f37881e;

    /* renamed from: f  reason: collision with root package name */
    public Context f37882f;

    /* renamed from: g  reason: collision with root package name */
    public Handler f37883g;

    /* renamed from: h  reason: collision with root package name */
    public GestureDetector f37884h;

    /* renamed from: i  reason: collision with root package name */
    public b f37885i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f37886j;
    public boolean k;
    public ScheduledExecutorService l;
    public ScheduledFuture<?> m;
    public Paint n;
    public Paint o;
    public Paint p;
    public c q;
    public String r;
    public int s;
    public int t;
    public int u;
    public int v;
    public float w;
    public Typeface x;
    public int y;
    public int z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class ACTION {
        public static final /* synthetic */ ACTION[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final ACTION CLICK;
        public static final ACTION DAGGLE;
        public static final ACTION FLING;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1586495403, "Lcom/baidu/swan/apps/res/ui/wheelview3d/WheelView3d$ACTION;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1586495403, "Lcom/baidu/swan/apps/res/ui/wheelview3d/WheelView3d$ACTION;");
                    return;
                }
            }
            CLICK = new ACTION("CLICK", 0);
            FLING = new ACTION("FLING", 1);
            ACTION action = new ACTION("DAGGLE", 2);
            DAGGLE = action;
            $VALUES = new ACTION[]{CLICK, FLING, action};
        }

        public ACTION(String str, int i2) {
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

        public static ACTION valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (ACTION) Enum.valueOf(ACTION.class, str) : (ACTION) invokeL.objValue;
        }

        public static ACTION[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (ACTION[]) $VALUES.clone() : (ACTION[]) invokeV.objValue;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes5.dex */
    public static final class DividerType {
        public static final /* synthetic */ DividerType[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final DividerType FILL;
        public static final DividerType WRAP;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(701316920, "Lcom/baidu/swan/apps/res/ui/wheelview3d/WheelView3d$DividerType;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(701316920, "Lcom/baidu/swan/apps/res/ui/wheelview3d/WheelView3d$DividerType;");
                    return;
                }
            }
            FILL = new DividerType("FILL", 0);
            DividerType dividerType = new DividerType("WRAP", 1);
            WRAP = dividerType;
            $VALUES = new DividerType[]{FILL, dividerType};
        }

        public DividerType(String str, int i2) {
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

        public static DividerType valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (DividerType) Enum.valueOf(DividerType.class, str) : (DividerType) invokeL.objValue;
        }

        public static DividerType[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (DividerType[]) $VALUES.clone() : (DividerType[]) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ WheelView3d f37887e;

        public a(WheelView3d wheelView3d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wheelView3d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f37887e = wheelView3d;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                b bVar = this.f37887e.f37885i;
                WheelView3d wheelView3d = this.f37887e;
                bVar.a(wheelView3d, wheelView3d.getCurrentItem());
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1640412807, "Lcom/baidu/swan/apps/res/ui/wheelview3d/WheelView3d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1640412807, "Lcom/baidu/swan/apps/res/ui/wheelview3d/WheelView3d;");
                return;
            }
        }
        e0 = new int[]{-1, 452984831};
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WheelView3d(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public final void b(Drawable drawable, Canvas canvas, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(1048576, this, drawable, canvas, i2, i3) == null) {
            drawable.setBounds(0, i2, this.N, i3);
            drawable.draw(canvas);
        }
    }

    public final String c(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (obj == null) {
                return "";
            }
            if (obj instanceof c.a.p0.a.s1.a.e.b.a) {
                return ((c.a.p0.a.s1.a.e.b.a) obj).a();
            }
            return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
        }
        return (String) invokeL.objValue;
    }

    public void cancelFuture() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            synchronized (WheelView3d.class) {
                if (this.m != null && !this.m.isCancelled()) {
                    this.m.cancel(true);
                    this.m = null;
                }
            }
        }
    }

    public final int d(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            if (i2 < 0) {
                return d(i2 + this.q.a());
            }
            return i2 > this.q.a() + (-1) ? d(i2 - this.q.a()) : i2;
        }
        return invokeI.intValue;
    }

    public final void e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.f37882f = context;
            this.f37883g = new c.a.p0.a.s1.a.e.d.b(this);
            GestureDetector gestureDetector = new GestureDetector(context, new c.a.p0.a.s1.a.e.c.a(this));
            this.f37884h = gestureDetector;
            gestureDetector.setIsLongpressEnabled(false);
            this.C = true;
            this.G = 0.0f;
            this.H = -1;
            this.a0 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, e0);
            this.b0 = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, e0);
            f();
        }
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            Paint paint = new Paint();
            this.n = paint;
            paint.setColor(this.y);
            this.n.setAntiAlias(true);
            this.n.setTypeface(this.x);
            this.n.setTextSize(this.s);
            Paint paint2 = new Paint();
            this.o = paint2;
            paint2.setColor(this.z);
            this.o.setAntiAlias(true);
            this.o.setTextScaleX(1.1f);
            this.o.setTypeface(this.x);
            this.o.setTextSize(this.s);
            Paint paint3 = new Paint();
            this.p = paint3;
            paint3.setColor(this.A);
            this.p.setAntiAlias(true);
            Paint paint4 = new Paint();
            this.c0 = paint4;
            paint4.setColor(BDEmotionBagVerticalLayout.COLOR_EMOTION_BAG);
            setLayerType(1, null);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            float f2 = this.B;
            if (f2 < 1.0f) {
                this.B = 1.0f;
            } else if (f2 > 4.0f) {
                this.B = 4.0f;
            }
        }
    }

    public final c getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.q : (c) invokeV.objValue;
    }

    public float getCenterContentOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.W : invokeV.floatValue;
    }

    public final int getCurrentItem() {
        InterceptResult invokeV;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            c cVar = this.q;
            if (cVar == null) {
                return 0;
            }
            if (this.C && ((i2 = this.I) < 0 || i2 >= cVar.a())) {
                return Math.max(0, Math.min(Math.abs(Math.abs(this.I) - this.q.a()), this.q.a() - 1));
            }
            return Math.max(0, Math.min(this.I, this.q.a() - 1));
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f37883g : (Handler) invokeV.objValue;
    }

    public int getInitPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.H : invokeV.intValue;
    }

    public float getItemHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.w : invokeV.floatValue;
    }

    public int getItemsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            c cVar = this.q;
            if (cVar != null) {
                return cVar.a();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public int getTextWidth(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048590, this, paint, str)) == null) {
            if (str == null || str.length() <= 0) {
                return 0;
            }
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                i2 += (int) Math.ceil(fArr[i3]);
            }
            return i2;
        }
        return invokeLL.intValue;
    }

    public float getTotalScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.G : invokeV.floatValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            Rect rect = new Rect();
            for (int i2 = 0; i2 < this.q.a(); i2++) {
                String c2 = c(this.q.getItem(i2));
                this.o.getTextBounds(c2, 0, c2.length(), rect);
                int width = rect.width();
                if (width > this.t) {
                    this.t = width;
                }
                this.o.getTextBounds("星期", 0, 2, rect);
                this.u = rect.height() + 2;
            }
            this.w = this.B * this.u;
        }
    }

    public final void i(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, str) == null) {
            Rect rect = new Rect();
            this.o.getTextBounds(str, 0, str.length(), rect);
            int i2 = this.T;
            if (i2 == 3) {
                this.U = this.d0;
            } else if (i2 == 5) {
                this.U = ((this.N - rect.width()) - ((int) this.W)) - this.d0;
            } else if (i2 != 17) {
            } else {
                if (!this.f37886j && (str2 = this.r) != null && !str2.equals("") && this.k) {
                    this.U = (int) (((this.N - rect.width()) - this.d0) * 0.25d);
                } else {
                    this.U = (int) (((this.N - rect.width()) - this.d0) * 0.5d);
                }
            }
        }
    }

    public void isCenterLabel(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048594, this, z) == null) {
            this.k = z;
        }
    }

    public boolean isLoop() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.C : invokeV.booleanValue;
    }

    public final void j(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, str) == null) {
            Rect rect = new Rect();
            this.n.getTextBounds(str, 0, str.length(), rect);
            int i2 = this.T;
            if (i2 == 3) {
                this.V = this.d0;
            } else if (i2 == 5) {
                this.V = ((this.N - rect.width()) - ((int) this.W)) - this.d0;
            } else if (i2 != 17) {
            } else {
                if (!this.f37886j && (str2 = this.r) != null && !str2.equals("") && this.k) {
                    this.V = (int) (((this.N - rect.width()) - this.d0) * 0.25d);
                } else {
                    this.V = (int) (((this.N - rect.width()) - this.d0) * 0.5d);
                }
            }
        }
    }

    public final String k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            float[] fArr = {0.0f};
            Rect rect = new Rect();
            this.o.getTextBounds(str, 0, str.length(), rect);
            if (rect.width() > this.N) {
                int breakText = this.o.breakText(str, 0, str.length(), true, this.N, fArr);
                return str.substring(0, breakText - 2) + "...";
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048598, this) == null) || this.q == null) {
            return;
        }
        h();
        int i2 = (int) (this.w * (this.L - 1));
        this.M = (int) ((i2 * 2) / 3.141592653589793d);
        this.O = (int) (i2 / 3.141592653589793d);
        this.N = View.MeasureSpec.getSize(this.S);
        int i3 = this.M;
        float f2 = this.w;
        this.D = (i3 - f2) / 2.0f;
        float f3 = (i3 + f2) / 2.0f;
        this.E = f3;
        this.F = (f3 - ((f2 - this.u) / 2.0f)) - this.W;
        if (this.H == -1) {
            if (this.C) {
                this.H = (this.q.a() + 1) / 2;
            } else {
                this.H = 0;
            }
        }
        this.J = this.H;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048599, this, canvas) == null) || this.q == null) {
            return;
        }
        int min = Math.min(Math.max(0, this.H), this.q.a() - 1);
        this.H = min;
        Object[] objArr = new Object[this.L];
        int i3 = (int) (this.G / this.w);
        this.K = i3;
        try {
            this.J = min + (i3 % this.q.a());
        } catch (ArithmeticException unused) {
            boolean z = e.z;
        }
        if (!this.C) {
            if (this.J < 0) {
                this.J = 0;
            }
            if (this.J > this.q.a() - 1) {
                this.J = this.q.a() - 1;
            }
        } else {
            if (this.J < 0) {
                this.J = this.q.a() + this.J;
            }
            if (this.J > this.q.a() - 1) {
                this.J -= this.q.a();
            }
        }
        float f2 = this.G % this.w;
        int i4 = 0;
        while (true) {
            int i5 = this.L;
            if (i4 >= i5) {
                break;
            }
            int i6 = this.J - ((i5 / 2) - i4);
            if (this.C) {
                objArr[i4] = this.q.getItem(d(i6));
            } else if (i6 < 0) {
                objArr[i4] = "";
            } else if (i6 > this.q.a() - 1) {
                objArr[i4] = "";
            } else {
                objArr[i4] = this.q.getItem(i6);
            }
            i4++;
        }
        if (this.f37881e == DividerType.WRAP) {
            if (TextUtils.isEmpty(this.r)) {
                i2 = (this.N - this.t) / 2;
            } else {
                i2 = (this.N - this.t) / 4;
            }
            float f3 = i2 - 12;
            float f4 = f3 <= 0.0f ? 10.0f : f3;
            float f5 = this.N - f4;
            float f6 = this.D;
            float f7 = f4;
            canvas.drawLine(f7, f6, f5, f6, this.p);
            float f8 = this.E;
            canvas.drawLine(f7, f8, f5, f8, this.p);
        } else {
            float f9 = this.D;
            canvas.drawLine(0.0f, f9, this.N, f9, this.p);
            float f10 = this.E;
            canvas.drawLine(0.0f, f10, this.N, f10, this.p);
        }
        canvas.drawRect(0.0f, this.D, this.N, this.E, this.c0);
        if (!TextUtils.isEmpty(this.r) && this.k) {
            canvas.drawText(this.r, (this.N - getTextWidth(this.o, this.r)) - this.W, this.F, this.o);
        }
        for (int i7 = 0; i7 < this.L; i7++) {
            canvas.save();
            double d2 = ((this.w * i7) - f2) / this.O;
            float f11 = (float) (90.0d - ((d2 / 3.141592653589793d) * 180.0d));
            if (f11 < 90.0f && f11 > -90.0f) {
                float pow = (float) Math.pow(Math.abs(f11) / 90.0f, 2.2d);
                String k = k((!this.k && !TextUtils.isEmpty(this.r) && !TextUtils.isEmpty(c(objArr[i7]))) ? c(objArr[i7]) + this.r : c(objArr[i7]));
                i(k);
                j(k);
                float cos = (float) ((this.O - (Math.cos(d2) * this.O)) - ((Math.sin(d2) * this.u) / 2.0d));
                canvas.translate(0.0f, cos);
                float f12 = this.D;
                if (cos <= f12 && this.u + cos >= f12) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.N, this.D - cos);
                    canvas.drawText(k, this.V, this.u, this.n);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.D - cos, this.N, (int) this.w);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                    canvas.drawText(k, this.U, this.u - this.W, this.o);
                    canvas.restore();
                } else {
                    float f13 = this.E;
                    if (cos <= f13 && this.u + cos >= f13) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.N, this.E - cos);
                        canvas.drawText(k, this.U, this.u - this.W, this.o);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.E - cos, this.N, (int) this.w);
                        canvas.drawText(k, this.V, this.u, this.n);
                        canvas.restore();
                    } else {
                        if (cos >= this.D) {
                            int i8 = this.u;
                            if (i8 + cos <= this.E) {
                                canvas.drawText(k, this.U, i8 - this.W, this.o);
                                this.I = this.J - ((this.L / 2) - i7);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.N, (int) this.w);
                        Paint paint = this.n;
                        int i9 = this.v;
                        paint.setTextSkewX((i9 == 0 ? 0 : i9 > 0 ? 1 : -1) * (f11 <= 0.0f ? 1 : -1) * 0.0f * pow);
                        this.n.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(k, this.V + (this.v * pow), this.u, this.n);
                        canvas.restore();
                        canvas.restore();
                        this.o.setTextSize(this.s);
                    }
                }
                canvas.restore();
                this.o.setTextSize(this.s);
            } else {
                canvas.restore();
            }
        }
        b(this.a0, canvas, 0, (int) this.D);
        b(this.b0, canvas, (int) this.E, this.M);
    }

    public final void onItemSelected() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || this.f37885i == null) {
            return;
        }
        postDelayed(new a(this), 200L);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048601, this, i2, i3) == null) {
            this.S = i2;
            l();
            setMeasuredDimension(this.N, this.M);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, motionEvent)) == null) {
            boolean onTouchEvent = this.f37884h.onTouchEvent(motionEvent);
            float f2 = (-this.H) * this.w;
            float a2 = ((this.q.a() - 1) - this.H) * this.w;
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                this.R = System.currentTimeMillis();
                cancelFuture();
                this.Q = motionEvent.getRawY();
            } else if (action == 2) {
                float rawY = this.Q - motionEvent.getRawY();
                this.Q = motionEvent.getRawY();
                float f3 = this.G + rawY;
                this.G = f3;
                if (!this.C && ((f3 - (this.w * 0.25f) < f2 && rawY < 0.0f) || (this.G + (this.w * 0.25f) > a2 && rawY > 0.0f))) {
                    this.G -= rawY;
                    z = true;
                }
            } else if (!onTouchEvent) {
                float y = motionEvent.getY();
                int i2 = this.O;
                float f4 = this.w;
                this.P = (int) (((((int) (((Math.acos((i2 - y) / i2) * this.O) + (f4 / 2.0f)) / f4)) - (this.L / 2)) * f4) - (((this.G % f4) + f4) % f4));
                if (System.currentTimeMillis() - this.R > 120) {
                    smoothScroll(ACTION.DAGGLE);
                } else {
                    smoothScroll(ACTION.CLICK);
                }
            }
            if (!z && motionEvent.getAction() != 0) {
                invalidate();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void scrollBy(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048603, this, f2) == null) {
            cancelFuture();
            synchronized (WheelView3d.class) {
                this.m = this.l.scheduleWithFixedDelay(new c.a.p0.a.s1.a.e.d.a(this, f2), 0L, 5L, TimeUnit.MILLISECONDS);
            }
        }
    }

    public final void setAdapter(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, cVar) == null) {
            this.q = cVar;
            l();
            invalidate();
        }
    }

    public final void setCenterTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i2) == null) {
            float f2 = i2;
            if (f2 > 0.0f) {
                this.s = i2;
                this.o.setTextSize(f2);
            }
        }
    }

    public final void setCurrentItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i2) == null) {
            this.I = i2;
            this.H = i2;
            this.G = 0.0f;
            invalidate();
        }
    }

    public final void setCyclic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.C = z;
        }
    }

    public void setDividerColor(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i2) == null) {
            this.A = i2;
            this.p.setColor(i2);
        }
    }

    public void setDividerType(DividerType dividerType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, dividerType) == null) {
            this.f37881e = dividerType;
        }
    }

    public void setGravity(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i2) == null) {
            this.T = i2;
        }
    }

    public void setGravityOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i2) == null) {
            this.d0 = i2;
        }
    }

    public void setIsOptions(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.f37886j = z;
        }
    }

    public void setLabel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.r = str;
        }
    }

    public void setLineSpacingMultiplier(float f2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048614, this, f2) == null) || f2 == 0.0f) {
            return;
        }
        this.B = f2;
        g();
    }

    public final void setOnItemSelectedListener(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, bVar) == null) {
            this.f37885i = bVar;
        }
    }

    public final void setOuterTextSize(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i2) == null) {
            float f2 = i2;
            if (f2 > 0.0f) {
                this.n.setTextSize(f2);
            }
        }
    }

    public void setTextColorCenter(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i2) == null) {
            this.z = i2;
            this.o.setColor(i2);
        }
    }

    public void setTextColorOut(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i2) == null) {
            this.y = i2;
            this.n.setColor(i2);
        }
    }

    public void setTextXOffset(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i2) == null) {
            this.v = i2;
            if (i2 != 0) {
                this.o.setTextScaleX(1.0f);
            }
        }
    }

    public void setTotalScrollY(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048620, this, f2) == null) {
            this.G = f2;
        }
    }

    public final void setTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, typeface) == null) {
            this.x = typeface;
            this.n.setTypeface(typeface);
            this.o.setTypeface(this.x);
        }
    }

    public void setVisibleItem(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i2) == null) {
            this.L = i2;
        }
    }

    public void smoothScroll(ACTION action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, action) == null) {
            cancelFuture();
            if (action == ACTION.FLING || action == ACTION.DAGGLE) {
                float f2 = this.G;
                float f3 = this.w;
                int i2 = (int) (((f2 % f3) + f3) % f3);
                this.P = i2;
                if (i2 > f3 / 2.0f) {
                    this.P = (int) (f3 - i2);
                } else {
                    this.P = -i2;
                }
            }
            synchronized (WheelView3d.class) {
                this.m = this.l.scheduleWithFixedDelay(new c.a.p0.a.s1.a.e.d.c(this, this.P), 0L, 10L, TimeUnit.MILLISECONDS);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WheelView3d(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f37886j = false;
        this.k = true;
        this.l = Executors.newSingleThreadScheduledExecutor();
        this.x = Typeface.SANS_SERIF;
        this.B = 1.6f;
        this.L = 5;
        this.P = 0;
        this.Q = 0.0f;
        this.R = 0L;
        this.T = 17;
        this.U = 0;
        this.V = 0;
        this.d0 = 0;
        this.s = 20;
        float f2 = getResources().getDisplayMetrics().density;
        if (f2 < 1.0f) {
            this.W = 2.4f;
        } else {
            int i4 = (1.0f > f2 ? 1 : (1.0f == f2 ? 0 : -1));
            if (i4 <= 0 && f2 < 2.0f) {
                this.W = 3.6f;
            } else if (i4 <= 0 && f2 < 2.0f) {
                this.W = 4.5f;
            } else if (2.0f <= f2 && f2 < 3.0f) {
                this.W = 6.0f;
            } else if (f2 >= 3.0f) {
                this.W = f2 * 2.5f;
            }
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.swan_wheelview_gravity, R.attr.wheelview_dividerColor, R.attr.wheelview_lineSpacingMultiplier, R.attr.wheelview_textColorCenter, R.attr.wheelview_textColorOut, R.attr.wheelview_textSize}, 0, 0);
            this.T = obtainStyledAttributes.getInt(0, 17);
            this.y = obtainStyledAttributes.getColor(4, -5723992);
            this.z = obtainStyledAttributes.getColor(3, -14013910);
            this.A = obtainStyledAttributes.getColor(1, -2763307);
            this.s = obtainStyledAttributes.getDimensionPixelOffset(5, this.s);
            this.B = obtainStyledAttributes.getFloat(2, this.B);
            obtainStyledAttributes.recycle();
        }
        g();
        e(context);
    }
}
