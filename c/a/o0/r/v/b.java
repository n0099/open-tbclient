package c.a.o0.r.v;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.elementsMaven.Direction;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes2.dex */
public class b extends Drawable implements Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnLayoutChangeListener A;
    public int B;
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public View f11098b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f11099c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f11100d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f11101e;

    /* renamed from: f  reason: collision with root package name */
    public float f11102f;

    /* renamed from: g  reason: collision with root package name */
    public int f11103g;

    /* renamed from: h  reason: collision with root package name */
    public float f11104h;
    public float i;
    public int j;
    public int k;
    public int l;
    public float[] m;
    public float[] n;
    public int o;
    public int p;
    public int[] q;
    public LinearGradient r;
    public float[] s;
    public float[] t;
    public Direction u;
    public RectF v;
    public RectF w;
    public Path x;
    public Path y;
    public Path z;

    /* loaded from: classes2.dex */
    public class a implements View.OnLayoutChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b a;

        /* renamed from: c.a.o0.r.v.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0845a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ View a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ViewGroup.MarginLayoutParams f11105b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ a f11106c;

            public RunnableC0845a(a aVar, View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, view, marginLayoutParams};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f11106c = aVar;
                this.a = view;
                this.f11105b = marginLayoutParams;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.setLayoutParams(this.f11105b);
                }
            }
        }

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{view, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)}) == null) {
                if (view.getBackground() instanceof b) {
                    b bVar = (b) view.getBackground();
                    this.a.j = bVar.j;
                    this.a.o = bVar.o;
                    this.a.p = bVar.p;
                    this.a.n = bVar.n;
                }
                float[] u = this.a.u();
                if (this.a.l == 1) {
                    u[0] = (this.a.B & 1) == 1 ? u[0] : 0.0f;
                    u[1] = (this.a.B & 16) == 16 ? u[1] : 0.0f;
                    u[2] = (this.a.B & 256) == 256 ? u[2] : 0.0f;
                    u[3] = (this.a.B & 4096) == 4096 ? u[3] : 0.0f;
                }
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    marginLayoutParams.leftMargin -= (int) u[0];
                    marginLayoutParams.topMargin -= (int) u[1];
                    marginLayoutParams.rightMargin -= (int) u[2];
                    marginLayoutParams.bottomMargin -= (int) u[3];
                    marginLayoutParams.width = (i3 - i) + ((int) u[0]) + ((int) u[2]);
                    marginLayoutParams.height = (i4 - i2) + ((int) u[1]) + ((int) u[3]);
                    view.post(new RunnableC0845a(this, view, marginLayoutParams));
                }
                view.removeOnLayoutChangeListener(this);
            }
        }
    }

    /* renamed from: c.a.o0.r.v.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0846b {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1380715353, "Lc/a/o0/r/v/b$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1380715353, "Lc/a/o0/r/v/b$b;");
                    return;
                }
            }
            int[] iArr = new int[Direction.values().length];
            a = iArr;
            try {
                iArr[Direction.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Direction.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Direction.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Direction.LEFT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public b() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 0;
        this.f11102f = 1.0f;
        this.f11103g = 0;
        this.f11104h = 1.0f;
        this.i = 0.0f;
        this.l = 1;
        this.m = new float[8];
        this.n = new float[8];
        this.q = new int[]{0};
        this.s = new float[]{0.0f, 1.0f};
        this.t = new float[]{0.0f, 1.0f};
        this.u = Direction.BOTTOM;
        this.v = new RectF();
        this.w = new RectF();
        this.x = new Path();
        this.y = new Path();
        this.z = new Path();
        this.A = new a(this);
        this.B = ShadowDrawable.ALL;
        Paint paint = new Paint();
        this.f11100d = paint;
        paint.setColor(0);
        this.f11100d.setAntiAlias(true);
        this.f11100d.setShadowLayer(this.j, this.o, this.p, this.k);
        this.f11100d.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        Paint paint2 = new Paint();
        this.f11099c = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f11101e = paint3;
        paint3.setColor(this.f11103g);
        this.f11101e.setAlpha((int) (this.f11104h * 255.0f));
        this.f11101e.setStrokeWidth(this.i);
        this.f11101e.setStyle(Paint.Style.STROKE);
        this.f11101e.setAntiAlias(true);
    }

    public static b y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65548, null)) == null) ? new b() : (b) invokeV.objValue;
    }

    public b A(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048576, this, f2)) == null) {
            if (this.f11102f != f2) {
                this.f11102f = f2;
            }
            return this;
        }
        return (b) invokeF.objValue;
    }

    public b B(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            int[] iArr = this.q;
            if (iArr.length == 1 && iArr[0] == i) {
                return this;
            }
            this.q = r0;
            int[] iArr2 = {i};
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b C(int[] iArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iArr)) == null) {
            if (Arrays.equals(this.q, iArr)) {
                return this;
            }
            this.q = iArr;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b D(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048579, this, f2)) == null) {
            if (this.f11104h == f2) {
                return this;
            }
            this.f11104h = f2;
            return this;
        }
        return (b) invokeF.objValue;
    }

    public b E(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (this.f11103g == i) {
                return this;
            }
            this.f11103g = i;
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b F(float f2) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048581, this, f2)) == null) {
            if (this.i == f2) {
                return this;
            }
            this.i = f2;
            return this;
        }
        return (b) invokeF.objValue;
    }

    public b G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            if (this.a == i) {
                return this;
            }
            this.a = i;
            Q();
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b H(Direction direction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, direction)) == null) {
            if (this.u.equals(direction)) {
                return this;
            }
            this.u = direction;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b I(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (this.o == i) {
                return this;
            }
            this.o = i;
            this.f11100d.setShadowLayer(this.j, i, this.p, this.k);
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b J(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048585, this, i)) == null) {
            int i2 = this.o;
            if (i2 == i) {
                return this;
            }
            this.p = i;
            this.f11100d.setShadowLayer(this.j, i2, i, this.k);
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b K(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048586, this, fArr)) == null) {
            if (Arrays.equals(this.s, fArr)) {
                return this;
            }
            this.s = fArr;
            return this;
        }
        return (b) invokeL.objValue;
    }

    public b L(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i)) == null) {
            if (this.k == i) {
                return this;
            }
            this.k = i;
            this.f11100d.setShadowLayer(this.j, this.o, this.p, i);
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b M(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048588, this, i)) == null) {
            if (this.j == i) {
                return this;
            }
            this.j = i;
            this.f11100d.setShadowLayer(i, this.o, this.p, this.k);
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b N(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048589, this, i)) == null) {
            if (this.B == i) {
                return this;
            }
            this.B = i;
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b O(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048590, this, i)) == null) {
            if (this.l == i) {
                return this;
            }
            this.l = i;
            return this;
        }
        return (b) invokeI.objValue;
    }

    public b P(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, fArr)) == null) {
            if (Arrays.equals(this.m, fArr)) {
                return this;
            }
            System.arraycopy(fArr, 0, this.m, 0, Math.min(fArr.length, 8));
            Q();
            return this;
        }
        return (b) invokeL.objValue;
    }

    public final void Q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            float[] fArr = this.m;
            float[] fArr2 = this.n;
            System.arraycopy(fArr, 0, fArr2, 0, Math.min(fArr2.length, 8));
            int i = this.a;
            if (i == 1) {
                for (int i2 = 4; i2 < 8; i2++) {
                    this.n[i2] = 0.0f;
                }
            } else if (i == 2) {
                for (int i3 = 0; i3 < 4; i3++) {
                    this.n[i3] = 0.0f;
                }
            }
        }
    }

    public Object clone() {
        b bVar;
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            try {
                bVar = (b) super.clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                bVar = null;
            }
            if (bVar == null) {
                return this;
            }
            bVar.O(this.l);
            bVar.N(this.B);
            bVar.G(this.a);
            bVar.P((float[]) this.m.clone());
            bVar.L(this.k);
            bVar.M(this.j);
            bVar.I(this.o);
            bVar.J(this.p);
            bVar.C((int[]) this.q.clone());
            bVar.K((float[]) this.s.clone());
            bVar.H(this.u);
            bVar.E(this.f11103g);
            bVar.D(this.f11104h);
            bVar.F(this.i);
            bVar.A(this.f11102f);
            return bVar;
        }
        return invokeV.objValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, canvas) == null) {
            int[] q = q();
            if (q != null) {
                if (q.length == 1) {
                    this.f11099c.setColor(q[0]);
                } else {
                    PointF w = w(this.v, this.u);
                    PointF v = v(this.v, this.u);
                    LinearGradient linearGradient = new LinearGradient(w.x, w.y, v.x, v.y, q, this.t, Shader.TileMode.CLAMP);
                    this.r = linearGradient;
                    this.f11099c.setShader(linearGradient);
                }
            }
            this.f11101e.setColor(c.a.p0.a4.c.a(this.f11103g, this.f11102f));
            this.f11101e.setAlpha((int) (this.f11104h * 255.0f));
            this.f11101e.setStrokeWidth(this.i);
            int i = this.l;
            if (i == 1) {
                p(canvas);
                canvas.drawPath(this.y, this.f11099c);
                o(canvas);
            } else if (i == 2) {
                canvas.drawCircle(this.v.centerX(), this.v.centerY(), Math.min(this.v.width(), this.v.height()) / 2.0f, this.f11100d);
                canvas.drawCircle(this.v.centerX(), this.v.centerY(), Math.min(this.v.width(), this.v.height()) / 2.0f, this.f11099c);
                canvas.drawCircle(this.v.centerX(), this.v.centerY(), (Math.min(this.v.width(), this.v.height()) / 2.0f) - (this.i * 0.5f), this.f11101e);
            } else {
                canvas.drawRect(this.v, this.f11099c);
            }
        }
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            return hashCode() == bVar.hashCode() && this.a == bVar.a && this.j == bVar.j && this.k == bVar.k && this.l == bVar.l && this.o == bVar.o && this.p == bVar.p && this.B == bVar.B && Arrays.equals(this.m, bVar.m) && Arrays.equals(this.n, bVar.n) && Arrays.equals(this.q, bVar.q) && Arrays.equals(this.s, bVar.s) && this.u.equals(bVar.u) && this.f11103g == bVar.f11103g && this.f11104h == bVar.f11104h && this.i == bVar.i && this.f11102f == bVar.f11102f;
        }
        return invokeL.booleanValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (((((((Objects.hash(Integer.valueOf(this.a), Integer.valueOf(this.j), Integer.valueOf(this.k), Integer.valueOf(this.l), Integer.valueOf(this.o), Integer.valueOf(this.p), this.u, Integer.valueOf(this.B), Integer.valueOf(this.f11103g), Float.valueOf(this.f11104h), Float.valueOf(this.i), Float.valueOf(this.f11102f)) * 31) + Arrays.hashCode(this.m)) * 31) + Arrays.hashCode(this.n)) * 31) + Arrays.hashCode(this.q)) * 31) + Arrays.hashCode(this.s) : invokeV.intValue;
    }

    public GradientDrawable l(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048598, this, i)) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            int length = this.n.length;
            for (int i2 = 0; i2 < length; i2++) {
                float[] fArr = this.n;
                if (fArr[i2] > 0.0f && fArr[i2] < 1.0f) {
                    fArr[i2] = fArr[i2] * i;
                }
            }
            gradientDrawable.setCornerRadii(this.n);
            gradientDrawable.setAlpha((int) (this.f11102f * 255.0f));
            return gradientDrawable;
        }
        return (GradientDrawable) invokeI.objValue;
    }

    public final void m(float[] fArr, float[] fArr2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, fArr, fArr2) == null) {
            int i = C0846b.a[this.u.ordinal()];
            if (i == 1) {
                RectF rectF = this.v;
                float f2 = rectF.top;
                float height = rectF.height();
                float[] fArr3 = this.s;
                rectF.bottom = f2 + (height * fArr3[fArr3.length - 1]);
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
            } else if (i == 2) {
                RectF rectF2 = this.v;
                float f3 = rectF2.bottom;
                float height2 = rectF2.height();
                float[] fArr4 = this.s;
                rectF2.top = f3 - (height2 * fArr4[fArr4.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
            } else if (i == 3) {
                RectF rectF3 = this.v;
                float f4 = rectF3.right;
                float width = rectF3.width();
                float[] fArr5 = this.s;
                rectF3.left = f4 - (width * fArr5[fArr5.length - 1]);
                fArr[0] = 0.0f;
                fArr[1] = 0.0f;
                fArr[6] = 0.0f;
                fArr[7] = 0.0f;
            } else if (i == 4) {
                RectF rectF4 = this.v;
                float f5 = rectF4.left;
                float width2 = rectF4.width();
                float[] fArr6 = this.s;
                rectF4.right = f5 + (width2 * fArr6[fArr6.length - 1]);
                fArr[2] = 0.0f;
                fArr[3] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
            }
            fArr2[fArr2.length - 1] = 1.0f;
        }
    }

    public b n(View view) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, view)) == null) {
            if (view == null) {
                return null;
            }
            this.f11098b = view;
            if (equals(view.getBackground())) {
                return null;
            }
            this.f11098b.removeOnLayoutChangeListener(this.A);
            this.f11098b.addOnLayoutChangeListener(this.A);
            return this;
        }
        return (b) invokeL.objValue;
    }

    public void o(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048601, this, canvas) == null) || this.i == 0.0f || this.f11104h == 0.0f || this.f11103g == 0) {
            return;
        }
        canvas.drawPath(this.z, this.f11101e);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, rect) == null) {
            super.onBoundsChange(rect);
            int length = this.n.length;
            for (int i = 0; i < length; i++) {
                float[] fArr = this.n;
                if (fArr[i] > 0.0f && fArr[i] < 1.0f) {
                    fArr[i] = fArr[i] * rect.height();
                }
            }
            float[] u = u();
            this.v = new RectF(rect.left + u[0], rect.top + u[1], rect.right - u[2], rect.bottom - u[3]);
            this.x.reset();
            this.x.addRoundRect(this.v, this.n, Path.Direction.CW);
            this.t = (float[]) this.s.clone();
            float[] fArr2 = (float[]) this.n.clone();
            int[] iArr = this.q;
            if (iArr != null && iArr.length > 1 && x()) {
                m(fArr2, this.t);
            }
            this.y.reset();
            this.y.addRoundRect(this.v, fArr2, Path.Direction.CW);
            float f2 = this.i * 0.5f;
            float[] fArr3 = (float[]) this.n.clone();
            for (int i2 = 0; i2 < fArr3.length; i2++) {
                fArr3[i2] = fArr3[i2] - this.i;
                if (fArr3[i2] < 0.0f) {
                    fArr3[i2] = 0.0f;
                }
            }
            RectF rectF = this.v;
            this.w = new RectF(rectF.left + f2, rectF.top + f2, rectF.right - f2, rectF.bottom - f2);
            this.z.reset();
            this.z.addRoundRect(this.w, fArr3, Path.Direction.CW);
        }
    }

    public void p(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, canvas) == null) {
            if (this.j == 0 && this.o == 0 && this.p == 0) {
                return;
            }
            canvas.drawPath(this.x, this.f11100d);
        }
    }

    public final int[] q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            int[] iArr = this.q;
            if (iArr == null) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length];
            for (int i = 0; i < length; i++) {
                iArr2[i] = c.a.p0.a4.c.a(this.q[i], this.f11102f);
            }
            return iArr2;
        }
        return (int[]) invokeV.objValue;
    }

    public float r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) ? this.f11104h : invokeV.floatValue;
    }

    public int s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) ? this.f11103g : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            this.f11100d.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, colorFilter) == null) {
            this.f11100d.setColorFilter(colorFilter);
        }
    }

    public float t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) ? this.i : invokeV.floatValue;
    }

    public final float[] u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            float[] fArr = new float[4];
            int i = this.l;
            if (i == 1) {
                fArr[0] = (this.B & 1) == 1 ? this.j - this.o : -this.n[0];
                fArr[1] = (this.B & 16) == 16 ? this.j - this.p : -this.n[2];
                fArr[2] = (this.B & 256) == 256 ? this.j + this.o : -this.n[4];
                fArr[3] = (this.B & 4096) == 4096 ? this.j + this.p : -this.n[6];
            } else if (i == 2) {
                Arrays.fill(fArr, this.j);
            }
            return fArr;
        }
        return (float[]) invokeV.objValue;
    }

    public final PointF v(RectF rectF, Direction direction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048611, this, rectF, direction)) == null) {
            int i = C0846b.a[direction.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new PointF();
                        }
                        return new PointF(rectF.right, rectF.height() / 2.0f);
                    }
                    return new PointF(rectF.left, rectF.height() / 2.0f);
                }
                return new PointF(rectF.width() / 2.0f, rectF.top);
            }
            return new PointF(rectF.width() / 2.0f, rectF.bottom);
        }
        return (PointF) invokeLL.objValue;
    }

    public final PointF w(RectF rectF, Direction direction) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048612, this, rectF, direction)) == null) {
            int i = C0846b.a[direction.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new PointF();
                        }
                        return new PointF(rectF.left, rectF.height() / 2.0f);
                    }
                    return new PointF(rectF.right, rectF.height() / 2.0f);
                }
                return new PointF(rectF.width() / 2.0f, rectF.bottom);
            }
            return new PointF(rectF.width() / 2.0f, rectF.top);
        }
        return (PointF) invokeLL.objValue;
    }

    public final boolean x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048613, this)) == null) {
            float[] fArr = this.s;
            return fArr != null && fArr.length >= 1 && fArr[fArr.length - 1] < 1.0f;
        }
        return invokeV.booleanValue;
    }

    public void z() {
        View view;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048614, this) == null) || (view = this.f11098b) == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.A);
        this.f11098b.setLayerType(0, null);
        this.f11098b = null;
    }
}
