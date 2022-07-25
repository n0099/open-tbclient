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
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.spswitch.emotion.view.BDEmotionBagVerticalLayout;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.az2;
import com.repackage.bz2;
import com.repackage.cz2;
import com.repackage.dz2;
import com.repackage.i03;
import com.repackage.xy2;
import com.repackage.yy2;
import com.repackage.zy2;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class WheelView3d extends View {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] a0;
    public transient /* synthetic */ FieldHolder $fh;
    public float A;
    public float B;
    public float C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public float M;
    public long N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public float S;
    public Drawable T;
    public Drawable U;
    public Paint V;
    public int W;
    public DividerType a;
    public Context b;
    public Handler c;
    public GestureDetector d;
    public az2 e;
    public boolean f;
    public boolean g;
    public ScheduledExecutorService h;
    public ScheduledFuture<?> i;
    public Paint j;
    public Paint k;
    public Paint l;
    public xy2 m;
    public String n;
    public int o;
    public int p;
    public int q;
    public int r;
    public float s;
    public Typeface t;
    public int u;
    public int v;
    public int w;
    public float x;
    public boolean y;
    public float z;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
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

        public ACTION(String str, int i) {
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
    /* loaded from: classes2.dex */
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

        public DividerType(String str, int i) {
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

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WheelView3d a;

        public a(WheelView3d wheelView3d) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wheelView3d};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wheelView3d;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                az2 az2Var = this.a.e;
                WheelView3d wheelView3d = this.a;
                az2Var.a(wheelView3d, wheelView3d.getCurrentItem());
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
        a0 = new int[]{-1, 452984831};
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            synchronized (WheelView3d.class) {
                if (this.i != null && !this.i.isCancelled()) {
                    this.i.cancel(true);
                    this.i = null;
                }
            }
        }
    }

    public final void c(Drawable drawable, Canvas canvas, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, drawable, canvas, i, i2) == null) {
            drawable.setBounds(0, i, this.J, i2);
            drawable.draw(canvas);
        }
    }

    public final String d(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
            if (obj == null) {
                return "";
            }
            if (obj instanceof yy2) {
                return ((yy2) obj).a();
            }
            return obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
        }
        return (String) invokeL.objValue;
    }

    public final int e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            if (i < 0) {
                return e(i + this.m.a());
            }
            return i > this.m.a() + (-1) ? e(i - this.m.a()) : i;
        }
        return invokeI.intValue;
    }

    public int f(Paint paint, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048580, this, paint, str)) == null) {
            if (str == null || str.length() <= 0) {
                return 0;
            }
            int length = str.length();
            float[] fArr = new float[length];
            paint.getTextWidths(str, fArr);
            int i = 0;
            for (int i2 = 0; i2 < length; i2++) {
                i += (int) Math.ceil(fArr[i2]);
            }
            return i;
        }
        return invokeLL.intValue;
    }

    public final void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            this.b = context;
            this.c = new cz2(this);
            GestureDetector gestureDetector = new GestureDetector(context, new zy2(this));
            this.d = gestureDetector;
            gestureDetector.setIsLongpressEnabled(false);
            this.y = true;
            this.C = 0.0f;
            this.D = -1;
            this.T = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, a0);
            this.U = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, a0);
            h();
        }
    }

    public final xy2 getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.m : (xy2) invokeV.objValue;
    }

    public float getCenterContentOffset() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.S : invokeV.floatValue;
    }

    public final int getCurrentItem() {
        InterceptResult invokeV;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            xy2 xy2Var = this.m;
            if (xy2Var == null) {
                return 0;
            }
            if (this.y && ((i = this.E) < 0 || i >= xy2Var.a())) {
                return Math.max(0, Math.min(Math.abs(Math.abs(this.E) - this.m.a()), this.m.a() - 1));
            }
            return Math.max(0, Math.min(this.E, this.m.a() - 1));
        }
        return invokeV.intValue;
    }

    @Override // android.view.View
    public Handler getHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.c : (Handler) invokeV.objValue;
    }

    public int getInitPosition() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.D : invokeV.intValue;
    }

    public float getItemHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.s : invokeV.floatValue;
    }

    public int getItemsCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            xy2 xy2Var = this.m;
            if (xy2Var != null) {
                return xy2Var.a();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public float getTotalScrollY() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) ? this.C : invokeV.floatValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            Paint paint = new Paint();
            this.j = paint;
            paint.setColor(this.u);
            this.j.setAntiAlias(true);
            this.j.setTypeface(this.t);
            this.j.setTextSize(this.o);
            Paint paint2 = new Paint();
            this.k = paint2;
            paint2.setColor(this.v);
            this.k.setAntiAlias(true);
            this.k.setTextScaleX(1.1f);
            this.k.setTypeface(this.t);
            this.k.setTextSize(this.o);
            Paint paint3 = new Paint();
            this.l = paint3;
            paint3.setColor(this.w);
            this.l.setAntiAlias(true);
            Paint paint4 = new Paint();
            this.V = paint4;
            paint4.setColor(BDEmotionBagVerticalLayout.COLOR_EMOTION_BAG);
            setLayerType(1, null);
        }
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.y : invokeV.booleanValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            float f = this.x;
            if (f < 1.0f) {
                this.x = 1.0f;
            } else if (f > 4.0f) {
                this.x = 4.0f;
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            Rect rect = new Rect();
            for (int i = 0; i < this.m.a(); i++) {
                String d = d(this.m.getItem(i));
                this.k.getTextBounds(d, 0, d.length(), rect);
                int width = rect.width();
                if (width > this.p) {
                    this.p = width;
                }
                this.k.getTextBounds("星期", 0, 2, rect);
                this.q = rect.height() + 2;
            }
            this.s = this.x * this.q;
        }
    }

    public final void l(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            Rect rect = new Rect();
            this.k.getTextBounds(str, 0, str.length(), rect);
            int i = this.P;
            if (i == 3) {
                this.Q = this.W;
            } else if (i == 5) {
                this.Q = ((this.J - rect.width()) - ((int) this.S)) - this.W;
            } else if (i != 17) {
            } else {
                if (!this.f && (str2 = this.n) != null && !str2.equals("") && this.g) {
                    this.Q = (int) (((this.J - rect.width()) - this.W) * 0.25d);
                } else {
                    this.Q = (int) (((this.J - rect.width()) - this.W) * 0.5d);
                }
            }
        }
    }

    public final void m(String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, str) == null) {
            Rect rect = new Rect();
            this.j.getTextBounds(str, 0, str.length(), rect);
            int i = this.P;
            if (i == 3) {
                this.R = this.W;
            } else if (i == 5) {
                this.R = ((this.J - rect.width()) - ((int) this.S)) - this.W;
            } else if (i != 17) {
            } else {
                if (!this.f && (str2 = this.n) != null && !str2.equals("") && this.g) {
                    this.R = (int) (((this.J - rect.width()) - this.W) * 0.25d);
                } else {
                    this.R = (int) (((this.J - rect.width()) - this.W) * 0.5d);
                }
            }
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || this.e == null) {
            return;
        }
        postDelayed(new a(this), 200L);
    }

    public final String o(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, str)) == null) {
            float[] fArr = {0.0f};
            Rect rect = new Rect();
            this.k.getTextBounds(str, 0, str.length(), rect);
            if (rect.width() > this.J) {
                int breakText = this.k.breakText(str, 0, str.length(), true, this.J, fArr);
                return str.substring(0, breakText - 2) + StringHelper.STRING_MORE;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048598, this, canvas) == null) || this.m == null) {
            return;
        }
        int min = Math.min(Math.max(0, this.D), this.m.a() - 1);
        this.D = min;
        Object[] objArr = new Object[this.H];
        int i2 = (int) (this.C / this.s);
        this.G = i2;
        try {
            this.F = min + (i2 % this.m.a());
        } catch (ArithmeticException unused) {
            if (i03.v) {
                Log.e("WheelView", "出错了！adapter.getItemsCount() == 0，联动数据不匹配");
            }
        }
        if (!this.y) {
            if (this.F < 0) {
                this.F = 0;
            }
            if (this.F > this.m.a() - 1) {
                this.F = this.m.a() - 1;
            }
        } else {
            if (this.F < 0) {
                this.F = this.m.a() + this.F;
            }
            if (this.F > this.m.a() - 1) {
                this.F -= this.m.a();
            }
        }
        float f = this.C % this.s;
        int i3 = 0;
        while (true) {
            int i4 = this.H;
            if (i3 >= i4) {
                break;
            }
            int i5 = this.F - ((i4 / 2) - i3);
            if (this.y) {
                objArr[i3] = this.m.getItem(e(i5));
            } else if (i5 < 0) {
                objArr[i3] = "";
            } else if (i5 > this.m.a() - 1) {
                objArr[i3] = "";
            } else {
                objArr[i3] = this.m.getItem(i5);
            }
            i3++;
        }
        if (this.a == DividerType.WRAP) {
            if (TextUtils.isEmpty(this.n)) {
                i = (this.J - this.p) / 2;
            } else {
                i = (this.J - this.p) / 4;
            }
            float f2 = i - 12;
            float f3 = f2 <= 0.0f ? 10.0f : f2;
            float f4 = this.J - f3;
            float f5 = this.z;
            float f6 = f3;
            canvas.drawLine(f6, f5, f4, f5, this.l);
            float f7 = this.A;
            canvas.drawLine(f6, f7, f4, f7, this.l);
        } else {
            float f8 = this.z;
            canvas.drawLine(0.0f, f8, this.J, f8, this.l);
            float f9 = this.A;
            canvas.drawLine(0.0f, f9, this.J, f9, this.l);
        }
        canvas.drawRect(0.0f, this.z, this.J, this.A, this.V);
        if (!TextUtils.isEmpty(this.n) && this.g) {
            canvas.drawText(this.n, (this.J - f(this.k, this.n)) - this.S, this.B, this.k);
        }
        for (int i6 = 0; i6 < this.H; i6++) {
            canvas.save();
            double d = ((this.s * i6) - f) / this.K;
            float f10 = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
            if (f10 < 90.0f && f10 > -90.0f) {
                float pow = (float) Math.pow(Math.abs(f10) / 90.0f, 2.2d);
                String o = o((!this.g && !TextUtils.isEmpty(this.n) && !TextUtils.isEmpty(d(objArr[i6]))) ? d(objArr[i6]) + this.n : d(objArr[i6]));
                l(o);
                m(o);
                float cos = (float) ((this.K - (Math.cos(d) * this.K)) - ((Math.sin(d) * this.q) / 2.0d));
                canvas.translate(0.0f, cos);
                float f11 = this.z;
                if (cos <= f11 && this.q + cos >= f11) {
                    canvas.save();
                    canvas.clipRect(0.0f, 0.0f, this.J, this.z - cos);
                    canvas.drawText(o, this.R, this.q, this.j);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0.0f, this.z - cos, this.J, (int) this.s);
                    canvas.scale(1.0f, ((float) Math.sin(d)) * 1.0f);
                    canvas.drawText(o, this.Q, this.q - this.S, this.k);
                    canvas.restore();
                } else {
                    float f12 = this.A;
                    if (cos <= f12 && this.q + cos >= f12) {
                        canvas.save();
                        canvas.clipRect(0.0f, 0.0f, this.J, this.A - cos);
                        canvas.drawText(o, this.Q, this.q - this.S, this.k);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(0.0f, this.A - cos, this.J, (int) this.s);
                        canvas.drawText(o, this.R, this.q, this.j);
                        canvas.restore();
                    } else {
                        if (cos >= this.z) {
                            int i7 = this.q;
                            if (i7 + cos <= this.A) {
                                canvas.drawText(o, this.Q, i7 - this.S, this.k);
                                this.E = this.F - ((this.H / 2) - i6);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.J, (int) this.s);
                        Paint paint = this.j;
                        int i8 = this.r;
                        paint.setTextSkewX((i8 == 0 ? 0 : i8 > 0 ? 1 : -1) * (f10 <= 0.0f ? 1 : -1) * 0.0f * pow);
                        this.j.setAlpha((int) ((1.0f - pow) * 255.0f));
                        canvas.drawText(o, this.R + (this.r * pow), this.q, this.j);
                        canvas.restore();
                        canvas.restore();
                        this.k.setTextSize(this.o);
                    }
                }
                canvas.restore();
                this.k.setTextSize(this.o);
            } else {
                canvas.restore();
            }
        }
        c(this.T, canvas, 0, (int) this.z);
        c(this.U, canvas, (int) this.A, this.I);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048599, this, i, i2) == null) {
            this.O = i;
            p();
            setMeasuredDimension(this.J, this.I);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, motionEvent)) == null) {
            boolean onTouchEvent = this.d.onTouchEvent(motionEvent);
            float f = (-this.D) * this.s;
            float a2 = ((this.m.a() - 1) - this.D) * this.s;
            int action = motionEvent.getAction();
            boolean z = false;
            if (action == 0) {
                this.N = System.currentTimeMillis();
                b();
                this.M = motionEvent.getRawY();
            } else if (action == 2) {
                float rawY = this.M - motionEvent.getRawY();
                this.M = motionEvent.getRawY();
                float f2 = this.C + rawY;
                this.C = f2;
                if (!this.y && ((f2 - (this.s * 0.25f) < f && rawY < 0.0f) || (this.C + (this.s * 0.25f) > a2 && rawY > 0.0f))) {
                    this.C -= rawY;
                    z = true;
                }
            } else if (!onTouchEvent) {
                float y = motionEvent.getY();
                int i = this.K;
                float f3 = this.s;
                this.L = (int) (((((int) (((Math.acos((i - y) / i) * this.K) + (f3 / 2.0f)) / f3)) - (this.H / 2)) * f3) - (((this.C % f3) + f3) % f3));
                if (System.currentTimeMillis() - this.N > 120) {
                    r(ACTION.DAGGLE);
                } else {
                    r(ACTION.CLICK);
                }
            }
            if (!z && motionEvent.getAction() != 0) {
                invalidate();
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048601, this) == null) || this.m == null) {
            return;
        }
        k();
        int i = (int) (this.s * (this.H - 1));
        this.I = (int) ((i * 2) / 3.141592653589793d);
        this.K = (int) (i / 3.141592653589793d);
        this.J = View.MeasureSpec.getSize(this.O);
        int i2 = this.I;
        float f = this.s;
        this.z = (i2 - f) / 2.0f;
        float f2 = (i2 + f) / 2.0f;
        this.A = f2;
        this.B = (f2 - ((f - this.q) / 2.0f)) - this.S;
        if (this.D == -1) {
            if (this.y) {
                this.D = (this.m.a() + 1) / 2;
            } else {
                this.D = 0;
            }
        }
        this.F = this.D;
    }

    public final void q(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048602, this, f) == null) {
            b();
            synchronized (WheelView3d.class) {
                this.i = this.h.scheduleWithFixedDelay(new bz2(this, f), 0L, 5L, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void r(ACTION action) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, action) == null) {
            b();
            if (action == ACTION.FLING || action == ACTION.DAGGLE) {
                float f = this.C;
                float f2 = this.s;
                int i = (int) (((f % f2) + f2) % f2);
                this.L = i;
                if (i > f2 / 2.0f) {
                    this.L = (int) (f2 - i);
                } else {
                    this.L = -i;
                }
            }
            synchronized (WheelView3d.class) {
                this.i = this.h.scheduleWithFixedDelay(new dz2(this, this.L), 0L, 10L, TimeUnit.MILLISECONDS);
            }
        }
    }

    public final void setAdapter(xy2 xy2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, xy2Var) == null) {
            this.m = xy2Var;
            p();
            invalidate();
        }
    }

    public final void setCenterTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048605, this, i) == null) {
            float f = i;
            if (f > 0.0f) {
                this.o = i;
                this.k.setTextSize(f);
            }
        }
    }

    public final void setCurrentItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.E = i;
            this.D = i;
            this.C = 0.0f;
            invalidate();
        }
    }

    public final void setCyclic(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.y = z;
        }
    }

    public void setDividerColor(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.w = i;
            this.l.setColor(i);
        }
    }

    public void setDividerType(DividerType dividerType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, dividerType) == null) {
            this.a = dividerType;
        }
    }

    public void setGravity(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            this.P = i;
        }
    }

    public void setGravityOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048611, this, i) == null) {
            this.W = i;
        }
    }

    public void setIsOptions(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048612, this, z) == null) {
            this.f = z;
        }
    }

    public void setLabel(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048613, this, str) == null) {
            this.n = str;
        }
    }

    public void setLineSpacingMultiplier(float f) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeF(1048614, this, f) == null) || f == 0.0f) {
            return;
        }
        this.x = f;
        j();
    }

    public final void setOnItemSelectedListener(az2 az2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, az2Var) == null) {
            this.e = az2Var;
        }
    }

    public final void setOuterTextSize(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048616, this, i) == null) {
            float f = i;
            if (f > 0.0f) {
                this.j.setTextSize(f);
            }
        }
    }

    public void setTextColorCenter(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048617, this, i) == null) {
            this.v = i;
            this.k.setColor(i);
        }
    }

    public void setTextColorOut(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048618, this, i) == null) {
            this.u = i;
            this.j.setColor(i);
        }
    }

    public void setTextXOffset(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            this.r = i;
            if (i != 0) {
                this.k.setTextScaleX(1.0f);
            }
        }
    }

    public void setTotalScrollY(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048620, this, f) == null) {
            this.C = f;
        }
    }

    public final void setTypeface(Typeface typeface) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048621, this, typeface) == null) {
            this.t = typeface;
            this.j.setTypeface(typeface);
            this.k.setTypeface(this.t);
        }
    }

    public void setVisibleItem(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048622, this, i) == null) {
            this.H = i;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f = false;
        this.g = true;
        this.h = Executors.newSingleThreadScheduledExecutor();
        this.t = Typeface.SANS_SERIF;
        this.x = 1.6f;
        this.H = 5;
        this.L = 0;
        this.M = 0.0f;
        this.N = 0L;
        this.P = 17;
        this.Q = 0;
        this.R = 0;
        this.W = 0;
        this.o = 20;
        float f = getResources().getDisplayMetrics().density;
        if (f < 1.0f) {
            this.S = 2.4f;
        } else {
            int i3 = (1.0f > f ? 1 : (1.0f == f ? 0 : -1));
            if (i3 <= 0 && f < 2.0f) {
                this.S = 3.6f;
            } else if (i3 <= 0 && f < 2.0f) {
                this.S = 4.5f;
            } else if (2.0f <= f && f < 3.0f) {
                this.S = 6.0f;
            } else if (f >= 3.0f) {
                this.S = f * 2.5f;
            }
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0405ee, R.attr.obfuscated_res_0x7f0406d3, R.attr.obfuscated_res_0x7f0406d5, R.attr.obfuscated_res_0x7f0406d6, R.attr.obfuscated_res_0x7f0406d7, R.attr.obfuscated_res_0x7f0406d8}, 0, 0);
            this.P = obtainStyledAttributes.getInt(0, 17);
            this.u = obtainStyledAttributes.getColor(4, -5723992);
            this.v = obtainStyledAttributes.getColor(3, -14013910);
            this.w = obtainStyledAttributes.getColor(1, -2763307);
            this.o = obtainStyledAttributes.getDimensionPixelOffset(5, this.o);
            this.x = obtainStyledAttributes.getFloat(2, this.x);
            obtainStyledAttributes.recycle();
        }
        j();
        g(context);
    }
}
