package c.a.x.b.g.c;

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
import c.a.x.c.a.f;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.live.business.view.smarttab.SmartTabLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int A;
    public float B;
    public c.a.x.b.g.c.a C;
    public SmartTabLayout.g D;
    public Context E;

    /* renamed from: e  reason: collision with root package name */
    public final int f26638e;

    /* renamed from: f  reason: collision with root package name */
    public final int f26639f;

    /* renamed from: g  reason: collision with root package name */
    public final int f26640g;

    /* renamed from: h  reason: collision with root package name */
    public final int f26641h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f26642i;

    /* renamed from: j  reason: collision with root package name */
    public final RectF f26643j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public final int o;
    public int p;
    public int q;
    public final int r;
    public final float s;
    public final Paint t;
    public final int u;
    public final Paint v;
    public final float w;
    public final C1597b x;
    public final boolean y;
    public int z;

    /* loaded from: classes9.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: c.a.x.b.g.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1597b implements SmartTabLayout.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int[] a;

        /* renamed from: b  reason: collision with root package name */
        public int[] f26644b;

        public C1597b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.g
        public final int a(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i2)) == null) {
                int[] iArr = this.a;
                return iArr[i2 % iArr.length];
            }
            return invokeI.intValue;
        }

        @Override // com.baidu.live.business.view.smarttab.SmartTabLayout.g
        public final int b(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) {
                int[] iArr = this.f26644b;
                return iArr[i2 % iArr.length];
            }
            return invokeI.intValue;
        }

        public void c(int... iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, iArr) == null) {
                this.f26644b = iArr;
            }
        }

        public void d(int... iArr) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, iArr) == null) {
                this.a = iArr;
            }
        }

        public /* synthetic */ C1597b(a aVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet) {
        super(context);
        int i2;
        int[] intArray;
        int[] intArray2;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f26643j = new RectF();
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.E = context;
        float f2 = getResources().getDisplayMetrics().density;
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842800, typedValue, true);
        int i5 = typedValue.data;
        float f3 = 0.0f * f2;
        int k = k(i5, (byte) 38);
        int i6 = (int) f3;
        int k2 = k(i5, (byte) 38);
        int k3 = k(i5, (byte) 32);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.LiveFeedPage_live_feed_page_SmartTabLayout);
        boolean z = obtainStyledAttributes.getBoolean(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorAlwaysInCenter, false);
        boolean z2 = obtainStyledAttributes.getBoolean(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorAlwaysInScreenCenter, false);
        boolean z3 = obtainStyledAttributes.getBoolean(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorWithoutPadding, false);
        boolean z4 = obtainStyledAttributes.getBoolean(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorInFront, false);
        int i7 = obtainStyledAttributes.getInt(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorInterpolation, 0);
        int i8 = obtainStyledAttributes.getInt(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorGravity, 0);
        int color = obtainStyledAttributes.getColor(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorColor, -13388315);
        int resourceId = obtainStyledAttributes.getResourceId(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorColors, -1);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorThickness, (int) (8.0f * f2));
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorMarginBottom, (int) (6.0f * f2));
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorWidth, -1);
        float dimension = obtainStyledAttributes.getDimension(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_indicatorCornerRadius, f3);
        int color2 = obtainStyledAttributes.getColor(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_overlineColor, k);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_overlineThickness, i6);
        int color3 = obtainStyledAttributes.getColor(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_underlineColor, k2);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_underlineThickness, (int) (2.0f * f2));
        int color4 = obtainStyledAttributes.getColor(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_dividerColor, k3);
        int resourceId2 = obtainStyledAttributes.getResourceId(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_dividerColors, -1);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_dividerThickness, (int) (f2 * 1.0f));
        boolean z5 = obtainStyledAttributes.getBoolean(f.LiveFeedPage_live_feed_page_SmartTabLayout_live_feed_page_drawDecorationAfterTab, false);
        obtainStyledAttributes.recycle();
        if (resourceId == -1) {
            i2 = 1;
            intArray = new int[]{color};
        } else {
            i2 = 1;
            intArray = getResources().getIntArray(resourceId);
        }
        if (resourceId2 == -1) {
            intArray2 = new int[i2];
            intArray2[0] = color4;
        } else {
            intArray2 = getResources().getIntArray(resourceId2);
        }
        C1597b c1597b = new C1597b(null);
        this.x = c1597b;
        c1597b.d(intArray);
        this.x.c(intArray2);
        this.f26638e = dimensionPixelSize3;
        this.f26639f = color2;
        this.f26640g = dimensionPixelSize4;
        this.f26641h = color3;
        this.f26642i = new Paint(1);
        this.l = z;
        this.m = z2;
        this.k = z3;
        this.n = z4;
        this.o = dimensionPixelSize;
        this.p = dimensionPixelSize2;
        this.q = layoutDimension;
        this.t = new Paint(1);
        this.s = dimension;
        this.r = i8;
        this.w = 0.5f;
        Paint paint = new Paint(1);
        this.v = paint;
        paint.setStrokeWidth(dimensionPixelSize5);
        this.u = dimensionPixelSize5;
        this.y = z5;
        this.C = c.a.x.b.g.c.a.d(i7);
    }

    public static int a(int i2, int i3, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Float.valueOf(f2)})) == null) {
            float f3 = 1.0f - f2;
            return Color.rgb((int) ((Color.red(i2) * f2) + (Color.red(i3) * f3)), (int) ((Color.green(i2) * f2) + (Color.green(i3) * f3)), (int) ((Color.blue(i2) * f2) + (Color.blue(i3) * f3)));
        }
        return invokeCommon.intValue;
    }

    public static int k(int i2, byte b2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i2), Byte.valueOf(b2)})) == null) ? Color.argb((int) b2, Color.red(i2), Color.green(i2), Color.blue(i2)) : invokeCommon.intValue;
    }

    public final void b(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            int height = getHeight();
            int width = getWidth();
            int childCount = getChildCount();
            SmartTabLayout.g g2 = g();
            boolean n = c.n(this);
            if (this.n) {
                d(canvas, 0, width);
                f(canvas, 0, width, height);
            }
            if (childCount > 0) {
                View childAt = getChildAt(this.A);
                int k = c.k(childAt, this.k);
                int b2 = c.b(childAt, this.k);
                if (n) {
                    k = b2;
                    b2 = k;
                }
                int a2 = g2.a(this.A);
                float f2 = this.o;
                if (this.B <= 0.0f || this.A >= getChildCount() - 1) {
                    i2 = a2;
                    int i5 = k;
                    i3 = b2;
                    i4 = i5;
                } else {
                    int a3 = g2.a(this.A + 1);
                    if (a2 != a3) {
                        a2 = a(a3, a2, this.B);
                    }
                    float a4 = this.C.a(this.B);
                    float b3 = this.C.b(this.B);
                    this.C.c(this.B);
                    View childAt2 = getChildAt(this.A + 1);
                    int k2 = c.k(childAt2, this.k);
                    int b4 = c.b(childAt2, this.k);
                    if (n) {
                        i3 = (int) ((k2 * a4) + ((1.0f - a4) * b2));
                        i4 = (int) ((b4 * b3) + ((1.0f - b3) * k));
                    } else {
                        i4 = (int) ((k2 * a4) + ((1.0f - a4) * k));
                        i3 = (int) ((b4 * b3) + ((1.0f - b3) * b2));
                    }
                    i2 = a2;
                }
                c(canvas, i4, i3, height, f2, i2);
            }
            if (!this.n) {
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
    public final void c(Canvas canvas, int i2, int i3, int i4, float f2, int i5) {
        int i6;
        float f3;
        float f4;
        float f5;
        float f6;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{canvas, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2), Integer.valueOf(i5)}) == null) || (i6 = this.o) <= 0 || this.q == 0) {
            return;
        }
        int i7 = this.r;
        if (i7 == 1) {
            f3 = i6 * 2;
        } else if (i7 != 2) {
            float f7 = (i4 - i6) - this.p;
            f5 = f7 - (i6 / 2.0f);
            f4 = f7 + (i6 / 2.0f);
            this.t.setColor(i5);
            if (this.q != -1) {
                this.f26643j.set(i2 + c.a.x.b.f.a.a(this.E, 16.0f), f5, i3 - c.a.x.b.f.a.a(this.E, 16.0f), f4);
            } else {
                float abs = (Math.abs(i2 - i3) - this.q) / 2.0f;
                this.f26643j.set(i2 + abs, f5, i3 - abs, f4);
            }
            f6 = this.s;
            if (f6 <= 0.0f) {
                float d2 = c.a.x.b.f.a.d(this.E, f6);
                canvas.drawRoundRect(this.f26643j, d2, d2, this.t);
                return;
            }
            canvas.drawRect(this.f26643j, this.t);
            return;
        } else {
            f3 = i4 / 2.0f;
        }
        float f8 = f2 / 2.0f;
        float f9 = f3 - f8;
        f4 = f3 + f8;
        f5 = f9;
        this.t.setColor(i5);
        if (this.q != -1) {
        }
        f6 = this.s;
        if (f6 <= 0.0f) {
        }
    }

    public final void d(Canvas canvas, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(Constants.METHOD_SEND_USER_MSG, this, canvas, i2, i3) == null) || this.f26638e <= 0) {
            return;
        }
        this.f26642i.setColor(this.f26639f);
        canvas.drawRect(i2, 0.0f, i3, this.f26638e, this.f26642i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, canvas) == null) {
            super.dispatchDraw(canvas);
            if (this.y) {
                b(canvas);
            }
        }
    }

    public final void e(Canvas canvas, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048580, this, canvas, i2, i3) == null) || this.u <= 0) {
            return;
        }
        int min = (int) (Math.min(Math.max(0.0f, this.w), 1.0f) * i2);
        SmartTabLayout.g g2 = g();
        int i4 = (i2 - min) / 2;
        int i5 = min + i4;
        boolean n = c.n(this);
        for (int i6 = 0; i6 < i3 - 1; i6++) {
            View childAt = getChildAt(i6);
            int a2 = c.a(childAt);
            int c2 = c.c(childAt);
            int i7 = n ? a2 - c2 : a2 + c2;
            this.v.setColor(g2.b(i6));
            float f2 = i7;
            canvas.drawLine(f2, i4, f2, i5, this.v);
        }
    }

    public final void f(Canvas canvas, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIII(1048581, this, canvas, i2, i3, i4) == null) || this.f26640g <= 0) {
            return;
        }
        this.f26642i.setColor(this.f26641h);
        canvas.drawRect(i2, i4 - this.f26640g, i3, i4, this.f26642i);
    }

    public SmartTabLayout.g g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            SmartTabLayout.g gVar = this.D;
            return gVar != null ? gVar : this.x;
        }
        return (SmartTabLayout.g) invokeV.objValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.l : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.m : invokeV.booleanValue;
    }

    public void j(int i2, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i2), Float.valueOf(f2)}) == null) {
            this.A = i2;
            this.B = f2;
            if (f2 == 0.0f && this.z != i2) {
                this.z = i2;
            }
            invalidate();
        }
    }

    public void l(SmartTabLayout.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, gVar) == null) {
            this.D = gVar;
            invalidate();
        }
    }

    public void m(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, iArr) == null) {
            this.D = null;
            this.x.c(iArr);
            invalidate();
        }
    }

    public void n(c.a.x.b.g.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, aVar) == null) {
            this.C = aVar;
            invalidate();
        }
    }

    public void o(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            this.p = i2;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, canvas) == null) || this.y) {
            return;
        }
        b(canvas);
    }

    public void p(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i2) == null) {
            this.q = i2;
        }
    }

    public void q(int... iArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, iArr) == null) {
            this.D = null;
            this.x.d(iArr);
            invalidate();
        }
    }
}
