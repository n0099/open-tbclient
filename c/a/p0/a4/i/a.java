package c.a.p0.a4.i;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.view.bubbleView.ArrowDirection;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class a extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RectF f15403a;

    /* renamed from: b  reason: collision with root package name */
    public Path f15404b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f15405c;

    /* renamed from: d  reason: collision with root package name */
    public Path f15406d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f15407e;

    /* renamed from: f  reason: collision with root package name */
    public float f15408f;

    /* renamed from: g  reason: collision with root package name */
    public float f15409g;

    /* renamed from: h  reason: collision with root package name */
    public float f15410h;

    /* renamed from: i  reason: collision with root package name */
    public float f15411i;

    /* renamed from: j  reason: collision with root package name */
    public float f15412j;

    /* renamed from: c.a.p0.a4.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class C0729a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f15413a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-500411530, "Lc/a/p0/a4/i/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-500411530, "Lc/a/p0/a4/i/a$a;");
                    return;
                }
            }
            int[] iArr = new int[ArrowDirection.values().length];
            f15413a = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15413a[ArrowDirection.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f15413a[ArrowDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f15413a[ArrowDirection.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a(RectF rectF, float f2, float f3, float f4, float f5, float f6, int i2, int i3, ArrowDirection arrowDirection) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {rectF, Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f5), Float.valueOf(f6), Integer.valueOf(i2), Integer.valueOf(i3), arrowDirection};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f15404b = new Path();
        Paint paint = new Paint(1);
        this.f15405c = paint;
        this.f15403a = rectF;
        this.f15408f = f2;
        this.f15409g = f3;
        this.f15410h = f4;
        this.f15411i = f5;
        this.f15412j = f6;
        paint.setColor(i3);
        if (f6 > 0.0f) {
            Paint paint2 = new Paint(1);
            this.f15407e = paint2;
            paint2.setColor(i2);
            this.f15406d = new Path();
            e(arrowDirection, this.f15404b, f6);
            e(arrowDirection, this.f15406d, 0.0f);
            return;
        }
        e(arrowDirection, this.f15404b, 0.0f);
    }

    public final void a(RectF rectF, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{rectF, path, Float.valueOf(f2)}) == null) {
            path.moveTo(rectF.left + this.f15409g + f2, rectF.top + f2);
            path.lineTo((rectF.width() - this.f15409g) - f2, rectF.top + f2);
            float f3 = rectF.right;
            float f4 = this.f15409g;
            float f5 = rectF.top;
            path.arcTo(new RectF(f3 - f4, f5 + f2, f3 - f2, f4 + f5), 270.0f, 90.0f);
            path.lineTo(rectF.right - f2, ((rectF.bottom - this.f15410h) - this.f15409g) - f2);
            float f6 = rectF.right;
            float f7 = this.f15409g;
            float f8 = rectF.bottom;
            float f9 = this.f15410h;
            path.arcTo(new RectF(f6 - f7, (f8 - f7) - f9, f6 - f2, (f8 - f9) - f2), 0.0f, 90.0f);
            float f10 = f2 / 2.0f;
            path.lineTo(((rectF.left + this.f15408f) + this.f15411i) - f10, (rectF.bottom - this.f15410h) - f2);
            path.lineTo(rectF.left + this.f15411i + (this.f15408f / 2.0f), (rectF.bottom - f2) - f2);
            path.lineTo(rectF.left + this.f15411i + f10, (rectF.bottom - this.f15410h) - f2);
            path.lineTo(rectF.left + Math.min(this.f15409g, this.f15411i) + f2, (rectF.bottom - this.f15410h) - f2);
            float f11 = rectF.left;
            float f12 = rectF.bottom;
            float f13 = this.f15409g;
            float f14 = this.f15410h;
            path.arcTo(new RectF(f11 + f2, (f12 - f13) - f14, f13 + f11, (f12 - f14) - f2), 90.0f, 90.0f);
            path.lineTo(rectF.left + f2, rectF.top + this.f15409g + f2);
            float f15 = rectF.left;
            float f16 = rectF.top;
            float f17 = this.f15409g;
            path.arcTo(new RectF(f15 + f2, f2 + f16, f15 + f17, f17 + f16), 180.0f, 90.0f);
            path.close();
        }
    }

    public final void b(RectF rectF, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{rectF, path, Float.valueOf(f2)}) == null) {
            path.moveTo(rectF.left + f2, rectF.top + f2);
            path.lineTo(rectF.right - f2, rectF.top + f2);
            path.lineTo(rectF.right - f2, (rectF.bottom - this.f15410h) - f2);
            float f3 = f2 / 2.0f;
            path.lineTo(((rectF.left + this.f15408f) + this.f15411i) - f3, (rectF.bottom - this.f15410h) - f2);
            path.lineTo(rectF.left + this.f15411i + (this.f15408f / 2.0f), (rectF.bottom - f2) - f2);
            path.lineTo(rectF.left + this.f15411i + f3, (rectF.bottom - this.f15410h) - f2);
            path.lineTo(rectF.left + this.f15411i + f2, (rectF.bottom - this.f15410h) - f2);
            path.lineTo(rectF.left + f2, (rectF.bottom - this.f15410h) - f2);
            path.lineTo(rectF.left + f2, rectF.top + f2);
            path.close();
        }
    }

    public final void c(RectF rectF, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{rectF, path, Float.valueOf(f2)}) == null) {
            path.moveTo(this.f15408f + rectF.left + this.f15409g + f2, rectF.top + f2);
            path.lineTo((rectF.width() - this.f15409g) - f2, rectF.top + f2);
            float f3 = rectF.right;
            float f4 = this.f15409g;
            float f5 = rectF.top;
            path.arcTo(new RectF(f3 - f4, f5 + f2, f3 - f2, f4 + f5), 270.0f, 90.0f);
            path.lineTo(rectF.right - f2, (rectF.bottom - this.f15409g) - f2);
            float f6 = rectF.right;
            float f7 = this.f15409g;
            float f8 = rectF.bottom;
            path.arcTo(new RectF(f6 - f7, f8 - f7, f6 - f2, f8 - f2), 0.0f, 90.0f);
            path.lineTo(rectF.left + this.f15408f + this.f15409g + f2, rectF.bottom - f2);
            float f9 = rectF.left;
            float f10 = this.f15408f;
            float f11 = rectF.bottom;
            float f12 = this.f15409g;
            path.arcTo(new RectF(f9 + f10 + f2, f11 - f12, f12 + f9 + f10, f11 - f2), 90.0f, 90.0f);
            float f13 = f2 / 2.0f;
            path.lineTo(rectF.left + this.f15408f + f2, (this.f15410h + this.f15411i) - f13);
            path.lineTo(rectF.left + f2 + f2, this.f15411i + (this.f15410h / 2.0f));
            path.lineTo(rectF.left + this.f15408f + f2, this.f15411i + f13);
            path.lineTo(rectF.left + this.f15408f + f2, rectF.top + this.f15409g + f2);
            float f14 = rectF.left;
            float f15 = this.f15408f;
            float f16 = rectF.top;
            float f17 = this.f15409g;
            path.arcTo(new RectF(f14 + f15 + f2, f2 + f16, f14 + f17 + f15, f17 + f16), 180.0f, 90.0f);
            path.close();
        }
    }

    public final void d(RectF rectF, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{rectF, path, Float.valueOf(f2)}) == null) {
            path.moveTo(this.f15408f + rectF.left + f2, rectF.top + f2);
            path.lineTo(rectF.width() - f2, rectF.top + f2);
            path.lineTo(rectF.right - f2, rectF.bottom - f2);
            path.lineTo(rectF.left + this.f15408f + f2, rectF.bottom - f2);
            float f3 = f2 / 2.0f;
            path.lineTo(rectF.left + this.f15408f + f2, (this.f15410h + this.f15411i) - f3);
            path.lineTo(rectF.left + f2 + f2, this.f15411i + (this.f15410h / 2.0f));
            path.lineTo(rectF.left + this.f15408f + f2, this.f15411i + f3);
            path.lineTo(rectF.left + this.f15408f + f2, rectF.top + f2);
            path.close();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            if (this.f15412j > 0.0f) {
                canvas.drawPath(this.f15406d, this.f15407e);
            }
            canvas.drawPath(this.f15404b, this.f15405c);
        }
    }

    public final void e(ArrowDirection arrowDirection, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{arrowDirection, path, Float.valueOf(f2)}) == null) {
            int i2 = C0729a.f15413a[arrowDirection.ordinal()];
            if (i2 == 1) {
                float f3 = this.f15409g;
                if (f3 <= 0.0f) {
                    d(this.f15403a, path, f2);
                } else if (f2 > 0.0f && f2 > f3) {
                    d(this.f15403a, path, f2);
                } else {
                    c(this.f15403a, path, f2);
                }
            } else if (i2 == 2) {
                float f4 = this.f15409g;
                if (f4 <= 0.0f) {
                    i(this.f15403a, path, f2);
                } else if (f2 > 0.0f && f2 > f4) {
                    i(this.f15403a, path, f2);
                } else {
                    h(this.f15403a, path, f2);
                }
            } else if (i2 == 3) {
                float f5 = this.f15409g;
                if (f5 <= 0.0f) {
                    g(this.f15403a, path, f2);
                } else if (f2 > 0.0f && f2 > f5) {
                    g(this.f15403a, path, f2);
                } else {
                    f(this.f15403a, path, f2);
                }
            } else if (i2 != 4) {
            } else {
                float f6 = this.f15409g;
                if (f6 <= 0.0f) {
                    b(this.f15403a, path, f2);
                } else if (f2 > 0.0f && f2 > f6) {
                    b(this.f15403a, path, f2);
                } else {
                    a(this.f15403a, path, f2);
                }
            }
        }
    }

    public final void f(RectF rectF, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{rectF, path, Float.valueOf(f2)}) == null) {
            path.moveTo(rectF.left + this.f15409g + f2, rectF.top + f2);
            path.lineTo(((rectF.width() - this.f15409g) - this.f15408f) - f2, rectF.top + f2);
            float f3 = rectF.right;
            float f4 = this.f15409g;
            float f5 = this.f15408f;
            float f6 = rectF.top;
            path.arcTo(new RectF((f3 - f4) - f5, f6 + f2, (f3 - f5) - f2, f4 + f6), 270.0f, 90.0f);
            float f7 = f2 / 2.0f;
            path.lineTo((rectF.right - this.f15408f) - f2, this.f15411i + f7);
            path.lineTo((rectF.right - f2) - f2, this.f15411i + (this.f15410h / 2.0f));
            path.lineTo((rectF.right - this.f15408f) - f2, (this.f15411i + this.f15410h) - f7);
            path.lineTo((rectF.right - this.f15408f) - f2, (rectF.bottom - this.f15409g) - f2);
            float f8 = rectF.right;
            float f9 = this.f15409g;
            float f10 = this.f15408f;
            float f11 = rectF.bottom;
            path.arcTo(new RectF((f8 - f9) - f10, f11 - f9, (f8 - f10) - f2, f11 - f2), 0.0f, 90.0f);
            path.lineTo(rectF.left + this.f15408f + f2, rectF.bottom - f2);
            float f12 = rectF.left;
            float f13 = rectF.bottom;
            float f14 = this.f15409g;
            path.arcTo(new RectF(f12 + f2, f13 - f14, f14 + f12, f13 - f2), 90.0f, 90.0f);
            float f15 = rectF.left;
            float f16 = rectF.top;
            float f17 = this.f15409g;
            path.arcTo(new RectF(f15 + f2, f2 + f16, f15 + f17, f17 + f16), 180.0f, 90.0f);
            path.close();
        }
    }

    public final void g(RectF rectF, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{rectF, path, Float.valueOf(f2)}) == null) {
            path.moveTo(rectF.left + f2, rectF.top + f2);
            path.lineTo((rectF.width() - this.f15408f) - f2, rectF.top + f2);
            float f3 = f2 / 2.0f;
            path.lineTo((rectF.right - this.f15408f) - f2, this.f15411i + f3);
            path.lineTo((rectF.right - f2) - f2, this.f15411i + (this.f15410h / 2.0f));
            path.lineTo((rectF.right - this.f15408f) - f2, (this.f15411i + this.f15410h) - f3);
            path.lineTo((rectF.right - this.f15408f) - f2, rectF.bottom - f2);
            path.lineTo(rectF.left + f2, rectF.bottom - f2);
            path.lineTo(rectF.left + f2, rectF.top + f2);
            path.close();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (int) this.f15403a.height() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (int) this.f15403a.width() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    public final void h(RectF rectF, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{rectF, path, Float.valueOf(f2)}) == null) {
            path.moveTo(rectF.left + Math.min(this.f15411i, this.f15409g) + f2, rectF.top + this.f15410h + f2);
            float f3 = f2 / 2.0f;
            path.lineTo(rectF.left + this.f15411i + f3, rectF.top + this.f15410h + f2);
            path.lineTo(rectF.left + (this.f15408f / 2.0f) + this.f15411i, rectF.top + f2 + f2);
            path.lineTo(((rectF.left + this.f15408f) + this.f15411i) - f3, rectF.top + this.f15410h + f2);
            path.lineTo((rectF.right - this.f15409g) - f2, rectF.top + this.f15410h + f2);
            float f4 = rectF.right;
            float f5 = this.f15409g;
            float f6 = rectF.top;
            float f7 = this.f15410h;
            path.arcTo(new RectF(f4 - f5, f6 + f7 + f2, f4 - f2, f5 + f6 + f7), 270.0f, 90.0f);
            path.lineTo(rectF.right - f2, (rectF.bottom - this.f15409g) - f2);
            float f8 = rectF.right;
            float f9 = this.f15409g;
            float f10 = rectF.bottom;
            path.arcTo(new RectF(f8 - f9, f10 - f9, f8 - f2, f10 - f2), 0.0f, 90.0f);
            path.lineTo(rectF.left + this.f15409g + f2, rectF.bottom - f2);
            float f11 = rectF.left;
            float f12 = rectF.bottom;
            float f13 = this.f15409g;
            path.arcTo(new RectF(f11 + f2, f12 - f13, f13 + f11, f12 - f2), 90.0f, 90.0f);
            path.lineTo(rectF.left + f2, rectF.top + this.f15410h + this.f15409g + f2);
            float f14 = rectF.left;
            float f15 = f14 + f2;
            float f16 = rectF.top;
            float f17 = this.f15410h;
            float f18 = f16 + f17 + f2;
            float f19 = this.f15409g;
            path.arcTo(new RectF(f15, f18, f14 + f19, f19 + f16 + f17), 180.0f, 90.0f);
            path.close();
        }
    }

    public final void i(RectF rectF, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{rectF, path, Float.valueOf(f2)}) == null) {
            path.moveTo(rectF.left + this.f15411i + f2, rectF.top + this.f15410h + f2);
            float f3 = f2 / 2.0f;
            path.lineTo(rectF.left + this.f15411i + f3, rectF.top + this.f15410h + f2);
            path.lineTo(rectF.left + (this.f15408f / 2.0f) + this.f15411i, rectF.top + f2 + f2);
            path.lineTo(((rectF.left + this.f15408f) + this.f15411i) - f3, rectF.top + this.f15410h + f2);
            path.lineTo(rectF.right - f2, rectF.top + this.f15410h + f2);
            path.lineTo(rectF.right - f2, rectF.bottom - f2);
            path.lineTo(rectF.left + f2, rectF.bottom - f2);
            path.lineTo(rectF.left + f2, rectF.top + this.f15410h + f2);
            path.lineTo(rectF.left + this.f15411i + f2, rectF.top + this.f15410h + f2);
            path.close();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, rect) == null) {
            super.onBoundsChange(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            this.f15405c.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, colorFilter) == null) {
            this.f15405c.setColorFilter(colorFilter);
        }
    }
}
