package b.a.r0.d4.i;

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
/* loaded from: classes4.dex */
public class a extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public RectF f17041a;

    /* renamed from: b  reason: collision with root package name */
    public Path f17042b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f17043c;

    /* renamed from: d  reason: collision with root package name */
    public Path f17044d;

    /* renamed from: e  reason: collision with root package name */
    public Paint f17045e;

    /* renamed from: f  reason: collision with root package name */
    public float f17046f;

    /* renamed from: g  reason: collision with root package name */
    public float f17047g;

    /* renamed from: h  reason: collision with root package name */
    public float f17048h;

    /* renamed from: i  reason: collision with root package name */
    public float f17049i;
    public float j;

    /* renamed from: b.a.r0.d4.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class C0853a {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f17050a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-859108008, "Lb/a/r0/d4/i/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-859108008, "Lb/a/r0/d4/i/a$a;");
                    return;
                }
            }
            int[] iArr = new int[ArrowDirection.values().length];
            f17050a = iArr;
            try {
                iArr[ArrowDirection.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17050a[ArrowDirection.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17050a[ArrowDirection.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17050a[ArrowDirection.BOTTOM.ordinal()] = 4;
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
        this.f17042b = new Path();
        Paint paint = new Paint(1);
        this.f17043c = paint;
        this.f17041a = rectF;
        this.f17046f = f2;
        this.f17047g = f3;
        this.f17048h = f4;
        this.f17049i = f5;
        this.j = f6;
        paint.setColor(i3);
        if (f6 > 0.0f) {
            Paint paint2 = new Paint(1);
            this.f17045e = paint2;
            paint2.setColor(i2);
            this.f17044d = new Path();
            e(arrowDirection, this.f17042b, f6);
            e(arrowDirection, this.f17044d, 0.0f);
            return;
        }
        e(arrowDirection, this.f17042b, 0.0f);
    }

    public final void a(RectF rectF, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{rectF, path, Float.valueOf(f2)}) == null) {
            path.moveTo(rectF.left + this.f17047g + f2, rectF.top + f2);
            path.lineTo((rectF.width() - this.f17047g) - f2, rectF.top + f2);
            float f3 = rectF.right;
            float f4 = this.f17047g;
            float f5 = rectF.top;
            path.arcTo(new RectF(f3 - f4, f5 + f2, f3 - f2, f4 + f5), 270.0f, 90.0f);
            path.lineTo(rectF.right - f2, ((rectF.bottom - this.f17048h) - this.f17047g) - f2);
            float f6 = rectF.right;
            float f7 = this.f17047g;
            float f8 = rectF.bottom;
            float f9 = this.f17048h;
            path.arcTo(new RectF(f6 - f7, (f8 - f7) - f9, f6 - f2, (f8 - f9) - f2), 0.0f, 90.0f);
            float f10 = f2 / 2.0f;
            path.lineTo(((rectF.left + this.f17046f) + this.f17049i) - f10, (rectF.bottom - this.f17048h) - f2);
            path.lineTo(rectF.left + this.f17049i + (this.f17046f / 2.0f), (rectF.bottom - f2) - f2);
            path.lineTo(rectF.left + this.f17049i + f10, (rectF.bottom - this.f17048h) - f2);
            path.lineTo(rectF.left + Math.min(this.f17047g, this.f17049i) + f2, (rectF.bottom - this.f17048h) - f2);
            float f11 = rectF.left;
            float f12 = rectF.bottom;
            float f13 = this.f17047g;
            float f14 = this.f17048h;
            path.arcTo(new RectF(f11 + f2, (f12 - f13) - f14, f13 + f11, (f12 - f14) - f2), 90.0f, 90.0f);
            path.lineTo(rectF.left + f2, rectF.top + this.f17047g + f2);
            float f15 = rectF.left;
            float f16 = rectF.top;
            float f17 = this.f17047g;
            path.arcTo(new RectF(f15 + f2, f2 + f16, f15 + f17, f17 + f16), 180.0f, 90.0f);
            path.close();
        }
    }

    public final void b(RectF rectF, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{rectF, path, Float.valueOf(f2)}) == null) {
            path.moveTo(rectF.left + f2, rectF.top + f2);
            path.lineTo(rectF.right - f2, rectF.top + f2);
            path.lineTo(rectF.right - f2, (rectF.bottom - this.f17048h) - f2);
            float f3 = f2 / 2.0f;
            path.lineTo(((rectF.left + this.f17046f) + this.f17049i) - f3, (rectF.bottom - this.f17048h) - f2);
            path.lineTo(rectF.left + this.f17049i + (this.f17046f / 2.0f), (rectF.bottom - f2) - f2);
            path.lineTo(rectF.left + this.f17049i + f3, (rectF.bottom - this.f17048h) - f2);
            path.lineTo(rectF.left + this.f17049i + f2, (rectF.bottom - this.f17048h) - f2);
            path.lineTo(rectF.left + f2, (rectF.bottom - this.f17048h) - f2);
            path.lineTo(rectF.left + f2, rectF.top + f2);
            path.close();
        }
    }

    public final void c(RectF rectF, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{rectF, path, Float.valueOf(f2)}) == null) {
            path.moveTo(this.f17046f + rectF.left + this.f17047g + f2, rectF.top + f2);
            path.lineTo((rectF.width() - this.f17047g) - f2, rectF.top + f2);
            float f3 = rectF.right;
            float f4 = this.f17047g;
            float f5 = rectF.top;
            path.arcTo(new RectF(f3 - f4, f5 + f2, f3 - f2, f4 + f5), 270.0f, 90.0f);
            path.lineTo(rectF.right - f2, (rectF.bottom - this.f17047g) - f2);
            float f6 = rectF.right;
            float f7 = this.f17047g;
            float f8 = rectF.bottom;
            path.arcTo(new RectF(f6 - f7, f8 - f7, f6 - f2, f8 - f2), 0.0f, 90.0f);
            path.lineTo(rectF.left + this.f17046f + this.f17047g + f2, rectF.bottom - f2);
            float f9 = rectF.left;
            float f10 = this.f17046f;
            float f11 = rectF.bottom;
            float f12 = this.f17047g;
            path.arcTo(new RectF(f9 + f10 + f2, f11 - f12, f12 + f9 + f10, f11 - f2), 90.0f, 90.0f);
            float f13 = f2 / 2.0f;
            path.lineTo(rectF.left + this.f17046f + f2, (this.f17048h + this.f17049i) - f13);
            path.lineTo(rectF.left + f2 + f2, this.f17049i + (this.f17048h / 2.0f));
            path.lineTo(rectF.left + this.f17046f + f2, this.f17049i + f13);
            path.lineTo(rectF.left + this.f17046f + f2, rectF.top + this.f17047g + f2);
            float f14 = rectF.left;
            float f15 = this.f17046f;
            float f16 = rectF.top;
            float f17 = this.f17047g;
            path.arcTo(new RectF(f14 + f15 + f2, f2 + f16, f14 + f17 + f15, f17 + f16), 180.0f, 90.0f);
            path.close();
        }
    }

    public final void d(RectF rectF, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{rectF, path, Float.valueOf(f2)}) == null) {
            path.moveTo(this.f17046f + rectF.left + f2, rectF.top + f2);
            path.lineTo(rectF.width() - f2, rectF.top + f2);
            path.lineTo(rectF.right - f2, rectF.bottom - f2);
            path.lineTo(rectF.left + this.f17046f + f2, rectF.bottom - f2);
            float f3 = f2 / 2.0f;
            path.lineTo(rectF.left + this.f17046f + f2, (this.f17048h + this.f17049i) - f3);
            path.lineTo(rectF.left + f2 + f2, this.f17049i + (this.f17048h / 2.0f));
            path.lineTo(rectF.left + this.f17046f + f2, this.f17049i + f3);
            path.lineTo(rectF.left + this.f17046f + f2, rectF.top + f2);
            path.close();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, canvas) == null) {
            if (this.j > 0.0f) {
                canvas.drawPath(this.f17044d, this.f17045e);
            }
            canvas.drawPath(this.f17042b, this.f17043c);
        }
    }

    public final void e(ArrowDirection arrowDirection, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{arrowDirection, path, Float.valueOf(f2)}) == null) {
            int i2 = C0853a.f17050a[arrowDirection.ordinal()];
            if (i2 == 1) {
                float f3 = this.f17047g;
                if (f3 <= 0.0f) {
                    d(this.f17041a, path, f2);
                } else if (f2 > 0.0f && f2 > f3) {
                    d(this.f17041a, path, f2);
                } else {
                    c(this.f17041a, path, f2);
                }
            } else if (i2 == 2) {
                float f4 = this.f17047g;
                if (f4 <= 0.0f) {
                    i(this.f17041a, path, f2);
                } else if (f2 > 0.0f && f2 > f4) {
                    i(this.f17041a, path, f2);
                } else {
                    h(this.f17041a, path, f2);
                }
            } else if (i2 == 3) {
                float f5 = this.f17047g;
                if (f5 <= 0.0f) {
                    g(this.f17041a, path, f2);
                } else if (f2 > 0.0f && f2 > f5) {
                    g(this.f17041a, path, f2);
                } else {
                    f(this.f17041a, path, f2);
                }
            } else if (i2 != 4) {
            } else {
                float f6 = this.f17047g;
                if (f6 <= 0.0f) {
                    b(this.f17041a, path, f2);
                } else if (f2 > 0.0f && f2 > f6) {
                    b(this.f17041a, path, f2);
                } else {
                    a(this.f17041a, path, f2);
                }
            }
        }
    }

    public final void f(RectF rectF, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048582, this, new Object[]{rectF, path, Float.valueOf(f2)}) == null) {
            path.moveTo(rectF.left + this.f17047g + f2, rectF.top + f2);
            path.lineTo(((rectF.width() - this.f17047g) - this.f17046f) - f2, rectF.top + f2);
            float f3 = rectF.right;
            float f4 = this.f17047g;
            float f5 = this.f17046f;
            float f6 = rectF.top;
            path.arcTo(new RectF((f3 - f4) - f5, f6 + f2, (f3 - f5) - f2, f4 + f6), 270.0f, 90.0f);
            float f7 = f2 / 2.0f;
            path.lineTo((rectF.right - this.f17046f) - f2, this.f17049i + f7);
            path.lineTo((rectF.right - f2) - f2, this.f17049i + (this.f17048h / 2.0f));
            path.lineTo((rectF.right - this.f17046f) - f2, (this.f17049i + this.f17048h) - f7);
            path.lineTo((rectF.right - this.f17046f) - f2, (rectF.bottom - this.f17047g) - f2);
            float f8 = rectF.right;
            float f9 = this.f17047g;
            float f10 = this.f17046f;
            float f11 = rectF.bottom;
            path.arcTo(new RectF((f8 - f9) - f10, f11 - f9, (f8 - f10) - f2, f11 - f2), 0.0f, 90.0f);
            path.lineTo(rectF.left + this.f17046f + f2, rectF.bottom - f2);
            float f12 = rectF.left;
            float f13 = rectF.bottom;
            float f14 = this.f17047g;
            path.arcTo(new RectF(f12 + f2, f13 - f14, f14 + f12, f13 - f2), 90.0f, 90.0f);
            float f15 = rectF.left;
            float f16 = rectF.top;
            float f17 = this.f17047g;
            path.arcTo(new RectF(f15 + f2, f2 + f16, f15 + f17, f17 + f16), 180.0f, 90.0f);
            path.close();
        }
    }

    public final void g(RectF rectF, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{rectF, path, Float.valueOf(f2)}) == null) {
            path.moveTo(rectF.left + f2, rectF.top + f2);
            path.lineTo((rectF.width() - this.f17046f) - f2, rectF.top + f2);
            float f3 = f2 / 2.0f;
            path.lineTo((rectF.right - this.f17046f) - f2, this.f17049i + f3);
            path.lineTo((rectF.right - f2) - f2, this.f17049i + (this.f17048h / 2.0f));
            path.lineTo((rectF.right - this.f17046f) - f2, (this.f17049i + this.f17048h) - f3);
            path.lineTo((rectF.right - this.f17046f) - f2, rectF.bottom - f2);
            path.lineTo(rectF.left + f2, rectF.bottom - f2);
            path.lineTo(rectF.left + f2, rectF.top + f2);
            path.close();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? (int) this.f17041a.height() : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? (int) this.f17041a.width() : invokeV.intValue;
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
            path.moveTo(rectF.left + Math.min(this.f17049i, this.f17047g) + f2, rectF.top + this.f17048h + f2);
            float f3 = f2 / 2.0f;
            path.lineTo(rectF.left + this.f17049i + f3, rectF.top + this.f17048h + f2);
            path.lineTo(rectF.left + (this.f17046f / 2.0f) + this.f17049i, rectF.top + f2 + f2);
            path.lineTo(((rectF.left + this.f17046f) + this.f17049i) - f3, rectF.top + this.f17048h + f2);
            path.lineTo((rectF.right - this.f17047g) - f2, rectF.top + this.f17048h + f2);
            float f4 = rectF.right;
            float f5 = this.f17047g;
            float f6 = rectF.top;
            float f7 = this.f17048h;
            path.arcTo(new RectF(f4 - f5, f6 + f7 + f2, f4 - f2, f5 + f6 + f7), 270.0f, 90.0f);
            path.lineTo(rectF.right - f2, (rectF.bottom - this.f17047g) - f2);
            float f8 = rectF.right;
            float f9 = this.f17047g;
            float f10 = rectF.bottom;
            path.arcTo(new RectF(f8 - f9, f10 - f9, f8 - f2, f10 - f2), 0.0f, 90.0f);
            path.lineTo(rectF.left + this.f17047g + f2, rectF.bottom - f2);
            float f11 = rectF.left;
            float f12 = rectF.bottom;
            float f13 = this.f17047g;
            path.arcTo(new RectF(f11 + f2, f12 - f13, f13 + f11, f12 - f2), 90.0f, 90.0f);
            path.lineTo(rectF.left + f2, rectF.top + this.f17048h + this.f17047g + f2);
            float f14 = rectF.left;
            float f15 = f14 + f2;
            float f16 = rectF.top;
            float f17 = this.f17048h;
            float f18 = f16 + f17 + f2;
            float f19 = this.f17047g;
            path.arcTo(new RectF(f15, f18, f14 + f19, f19 + f16 + f17), 180.0f, 90.0f);
            path.close();
        }
    }

    public final void i(RectF rectF, Path path, float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048588, this, new Object[]{rectF, path, Float.valueOf(f2)}) == null) {
            path.moveTo(rectF.left + this.f17049i + f2, rectF.top + this.f17048h + f2);
            float f3 = f2 / 2.0f;
            path.lineTo(rectF.left + this.f17049i + f3, rectF.top + this.f17048h + f2);
            path.lineTo(rectF.left + (this.f17046f / 2.0f) + this.f17049i, rectF.top + f2 + f2);
            path.lineTo(((rectF.left + this.f17046f) + this.f17049i) - f3, rectF.top + this.f17048h + f2);
            path.lineTo(rectF.right - f2, rectF.top + this.f17048h + f2);
            path.lineTo(rectF.right - f2, rectF.bottom - f2);
            path.lineTo(rectF.left + f2, rectF.bottom - f2);
            path.lineTo(rectF.left + f2, rectF.top + this.f17048h + f2);
            path.lineTo(rectF.left + this.f17049i + f2, rectF.top + this.f17048h + f2);
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
            this.f17043c.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, colorFilter) == null) {
            this.f17043c.setColorFilter(colorFilter);
        }
    }
}
