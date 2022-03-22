package c.a.v.b.g.c;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.view.smarttab.SmartTabLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
/* loaded from: classes3.dex */
public class b extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context A;
    public final int a;

    /* renamed from: b  reason: collision with root package name */
    public final int f21475b;

    /* renamed from: c  reason: collision with root package name */
    public final int f21476c;

    /* renamed from: d  reason: collision with root package name */
    public final int f21477d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f21478e;

    /* renamed from: f  reason: collision with root package name */
    public final RectF f21479f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f21480g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f21481h;
    public final boolean i;
    public final boolean j;
    public final int k;
    public int l;
    public int m;
    public final int n;
    public final float o;
    public final Paint p;
    public final int q;
    public final Paint r;
    public final float s;
    public final C1594b t;
    public final boolean u;
    public int v;
    public int w;
    public float x;
    public c.a.v.b.g.c.a y;
    public SmartTabLayout.g z;

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.v.b.g.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C1594b implements SmartTabLayout.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] a;

        /* renamed from: b  reason: collision with root package name */
        public int[] f21482b;

        public C1594b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.g
        public final int a(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
                int[] iArr = this.a;
                return iArr[i % iArr.length];
            }
            return invokeI.intValue;
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.g
        public final int b(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
                int[] iArr = this.f21482b;
                return iArr[i % iArr.length];
            }
            return invokeI.intValue;
        }

        public void c(int... iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iArr) == null) {
                this.f21482b = iArr;
            }
        }

        public void d(int... iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, iArr) == null) {
                this.a = iArr;
            }
        }

        public /* synthetic */ C1594b(a aVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet) {
        super(context);
        int i;
        int[] intArray;
        int[] intArray2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f21479f = new RectF();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.A = context;
        float f2 = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, typedValue, true);
        int i4 = typedValue.data;
        float f3 = 0.0f * f2;
        int k = k(i4, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS);
        int i5 = (int) f3;
        int k2 = k(i4, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS);
        int k3 = k(i4, (byte) 32);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.obfuscated_res_0x7f0403b9, R.attr.obfuscated_res_0x7f0403c0, R.attr.obfuscated_res_0x7f0403c1, R.attr.obfuscated_res_0x7f0403c2, R.attr.obfuscated_res_0x7f0403c3, R.attr.obfuscated_res_0x7f0403c4, R.attr.obfuscated_res_0x7f0403c5, R.attr.obfuscated_res_0x7f0403c6, R.attr.obfuscated_res_0x7f0403c7, R.attr.obfuscated_res_0x7f0403c8, R.attr.obfuscated_res_0x7f0403c9, R.attr.obfuscated_res_0x7f0403ca, R.attr.obfuscated_res_0x7f0403cb, R.attr.obfuscated_res_0x7f0403cc, R.attr.obfuscated_res_0x7f0403ce, R.attr.obfuscated_res_0x7f0403cf, R.attr.obfuscated_res_0x7f0403d0, R.attr.obfuscated_res_0x7f0403d1, R.attr.obfuscated_res_0x7f0403d2, R.attr.obfuscated_res_0x7f0403d4, R.attr.obfuscated_res_0x7f0403d5, R.attr.obfuscated_res_0x7f0403d6, R.attr.obfuscated_res_0x7f0403d7, R.attr.obfuscated_res_0x7f0403d8, R.attr.obfuscated_res_0x7f0403d9, R.attr.obfuscated_res_0x7f0403da, R.attr.obfuscated_res_0x7f0403db, R.attr.obfuscated_res_0x7f0403dc, R.attr.obfuscated_res_0x7f0403dd, R.attr.obfuscated_res_0x7f0403de, R.attr.obfuscated_res_0x7f0403df, R.attr.obfuscated_res_0x7f0403e1, R.attr.obfuscated_res_0x7f0403e2, R.attr.obfuscated_res_0x7f0403e4, R.attr.obfuscated_res_0x7f0403e9, R.attr.obfuscated_res_0x7f0403ea, R.attr.obfuscated_res_0x7f0403eb, R.attr.obfuscated_res_0x7f0403ec, R.attr.obfuscated_res_0x7f0403ed, R.attr.obfuscated_res_0x7f0403ee});
        boolean z = obtainStyledAttributes.getBoolean(19, false);
        boolean z2 = obtainStyledAttributes.getBoolean(20, false);
        boolean z3 = obtainStyledAttributes.getBoolean(30, false);
        boolean z4 = obtainStyledAttributes.getBoolean(25, false);
        int i6 = obtainStyledAttributes.getInt(26, 0);
        int i7 = obtainStyledAttributes.getInt(24, 0);
        int color = obtainStyledAttributes.getColor(21, -13388315);
        int resourceId = obtainStyledAttributes.getResourceId(22, -1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(28, (int) (8.0f * f2));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(27, (int) (6.0f * f2));
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(29, -1);
        float dimension = obtainStyledAttributes.getDimension(23, f3);
        int color2 = obtainStyledAttributes.getColor(31, k);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(32, i5);
        int color3 = obtainStyledAttributes.getColor(38, k2);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(39, (int) (2.0f * f2));
        int color4 = obtainStyledAttributes.getColor(15, k3);
        int resourceId2 = obtainStyledAttributes.getResourceId(16, -1);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(17, (int) (f2 * 1.0f));
        boolean z5 = obtainStyledAttributes.getBoolean(18, false);
        obtainStyledAttributes.recycle();
        if (resourceId == -1) {
            i = 1;
            intArray = new int[]{color};
        } else {
            i = 1;
            intArray = getResources().getIntArray(resourceId);
        }
        if (resourceId2 == -1) {
            intArray2 = new int[i];
            intArray2[0] = color4;
        } else {
            intArray2 = getResources().getIntArray(resourceId2);
        }
        C1594b c1594b = new C1594b(null);
        this.t = c1594b;
        c1594b.d(intArray);
        this.t.c(intArray2);
        this.a = dimensionPixelSize3;
        this.f21475b = color2;
        this.f21476c = dimensionPixelSize4;
        this.f21477d = color3;
        this.f21478e = new Paint(1);
        this.f21481h = z;
        this.i = z2;
        this.f21480g = z3;
        this.j = z4;
        this.k = dimensionPixelSize;
        this.l = dimensionPixelSize2;
        this.m = layoutDimension;
        this.p = new Paint(1);
        this.o = dimension;
        this.n = i7;
        this.s = 0.5f;
        Paint paint = new Paint(1);
        this.r = paint;
        paint.setStrokeWidth(dimensionPixelSize5);
        this.q = dimensionPixelSize5;
        this.u = z5;
        this.y = c.a.v.b.g.c.a.d(i6);
    }

    public static int a(int i, int i2, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f2)})) == null) {
            float f3 = 1.0f - f2;
            return Color.rgb((int) ((Color.red(i) * f2) + (Color.red(i2) * f3)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f3)), (int) ((Color.blue(i) * f2) + (Color.blue(i2) * f3)));
        }
        return invokeCommon.intValue;
    }

    public static int k(int i, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Byte.valueOf(b2)})) == null) ? Color.argb((int) b2, Color.red(i), Color.green(i), Color.blue(i)) : invokeCommon.intValue;
    }

    public final void b(Canvas canvas) {
        int i;
        int i2;
        int i3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            int height = getHeight();
            int width = getWidth();
            int childCount = getChildCount();
            SmartTabLayout.g g2 = g();
            boolean n = c.n(this);
            if (this.j) {
                d(canvas, 0, width);
                f(canvas, 0, width, height);
            }
            if (childCount > 0) {
                View childAt = getChildAt(this.w);
                int k = c.k(childAt, this.f21480g);
                int b2 = c.b(childAt, this.f21480g);
                if (n) {
                    k = b2;
                    b2 = k;
                }
                int a2 = g2.a(this.w);
                float f2 = this.k;
                if (this.x <= 0.0f || this.w >= getChildCount() - 1) {
                    i = a2;
                    int i4 = k;
                    i2 = b2;
                    i3 = i4;
                } else {
                    int a3 = g2.a(this.w + 1);
                    if (a2 != a3) {
                        a2 = a(a3, a2, this.x);
                    }
                    float a4 = this.y.a(this.x);
                    float b3 = this.y.b(this.x);
                    this.y.c(this.x);
                    View childAt2 = getChildAt(this.w + 1);
                    int k2 = c.k(childAt2, this.f21480g);
                    int b4 = c.b(childAt2, this.f21480g);
                    if (n) {
                        i2 = (int) ((k2 * a4) + ((1.0f - a4) * b2));
                        i3 = (int) ((b4 * b3) + ((1.0f - b3) * k));
                    } else {
                        i3 = (int) ((k2 * a4) + ((1.0f - a4) * k));
                        i2 = (int) ((b4 * b3) + ((1.0f - b3) * b2));
                    }
                    i = a2;
                }
                c(canvas, i3, i2, height, f2, i);
            }
            if (!this.j) {
                d(canvas, 0, width);
                f(canvas, 0, getWidth(), height);
            }
            e(canvas, height, childCount);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(Canvas canvas, int i, int i2, int i3, float f2, int i4) {
        int i5;
        float f3;
        float f4;
        float f5;
        float f6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2), Integer.valueOf(i4)}) == null) || (i5 = this.k) <= 0 || this.m == 0) {
            return;
        }
        int i6 = this.n;
        if (i6 == 1) {
            f3 = i5 * 2;
        } else if (i6 != 2) {
            float f7 = (i3 - i5) - this.l;
            f5 = f7 - (i5 / 2.0f);
            f4 = f7 + (i5 / 2.0f);
            this.p.setColor(i4);
            if (this.m != -1) {
                this.f21479f.set(i + c.a.v.b.f.a.a(this.A, 16.0f), f5, i2 - c.a.v.b.f.a.a(this.A, 16.0f), f4);
            } else {
                float abs = (Math.abs(i - i2) - this.m) / 2.0f;
                this.f21479f.set(i + abs, f5, i2 - abs, f4);
            }
            f6 = this.o;
            if (f6 <= 0.0f) {
                float d2 = c.a.v.b.f.a.d(this.A, f6);
                canvas.drawRoundRect(this.f21479f, d2, d2, this.p);
                return;
            }
            canvas.drawRect(this.f21479f, this.p);
            return;
        } else {
            f3 = i3 / 2.0f;
        }
        float f8 = f2 / 2.0f;
        float f9 = f3 - f8;
        f4 = f3 + f8;
        f5 = f9;
        this.p.setColor(i4);
        if (this.m != -1) {
        }
        f6 = this.o;
        if (f6 <= 0.0f) {
        }
    }

    public final void d(Canvas canvas, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, canvas, i, i2) == null) || this.a <= 0) {
            return;
        }
        this.f21478e.setColor(this.f21475b);
        canvas.drawRect(i, 0.0f, i2, this.a, this.f21478e);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.u) {
                b(canvas);
            }
        }
    }

    public final void e(Canvas canvas, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048580, this, canvas, i, i2) == null) || this.q <= 0) {
            return;
        }
        int min = (int) (Math.min(Math.max(0.0f, this.s), 1.0f) * i);
        SmartTabLayout.g g2 = g();
        int i3 = (i - min) / 2;
        int i4 = min + i3;
        boolean n = c.n(this);
        for (int i5 = 0; i5 < i2 - 1; i5++) {
            View childAt = getChildAt(i5);
            int a2 = c.a(childAt);
            int c2 = c.c(childAt);
            int i6 = n ? a2 - c2 : a2 + c2;
            this.r.setColor(g2.b(i5));
            float f2 = i6;
            canvas.drawLine(f2, i3, f2, i4, this.r);
        }
    }

    public final void f(Canvas canvas, int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048581, this, canvas, i, i2, i3) == null) || this.f21476c <= 0) {
            return;
        }
        this.f21478e.setColor(this.f21477d);
        canvas.drawRect(i, i3 - this.f21476c, i2, i3, this.f21478e);
    }

    public SmartTabLayout.g g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SmartTabLayout.g gVar = this.z;
            return gVar != null ? gVar : this.t;
        }
        return (SmartTabLayout.g) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f21481h : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.i : invokeV.booleanValue;
    }

    public void j(int i, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2)}) == null) {
            this.w = i;
            this.x = f2;
            if (f2 == 0.0f && this.v != i) {
                this.v = i;
            }
            invalidate();
        }
    }

    public void l(SmartTabLayout.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.z = gVar;
            invalidate();
        }
    }

    public void m(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iArr) == null) {
            this.z = null;
            this.t.c(iArr);
            invalidate();
        }
    }

    public void n(c.a.v.b.g.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.y = aVar;
            invalidate();
        }
    }

    public void o(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.l = i;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, canvas) == null) || this.u) {
            return;
        }
        b(canvas);
    }

    public void p(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.m = i;
        }
    }

    public void q(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iArr) == null) {
            this.z = null;
            this.t.d(iArr);
            invalidate();
        }
    }
}
