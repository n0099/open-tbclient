package c.a.d.g.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.baidu.adp.newwidget.ImageView.DrawerArgs;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public abstract class a {
    public static /* synthetic */ Interceptable $ic;
    public static final Matrix.ScaleToFit[] o;
    public static final PorterDuffColorFilter p;
    public transient /* synthetic */ FieldHolder $fh;
    public b a;

    /* renamed from: b  reason: collision with root package name */
    public Paint f2745b;

    /* renamed from: c  reason: collision with root package name */
    public Paint f2746c;

    /* renamed from: d  reason: collision with root package name */
    public Paint f2747d;

    /* renamed from: e  reason: collision with root package name */
    public Matrix f2748e;

    /* renamed from: f  reason: collision with root package name */
    public RectF f2749f;

    /* renamed from: g  reason: collision with root package name */
    public RectF f2750g;

    /* renamed from: h  reason: collision with root package name */
    public RectF f2751h;

    /* renamed from: i  reason: collision with root package name */
    public RectF f2752i;

    /* renamed from: j  reason: collision with root package name */
    public RectF f2753j;

    /* renamed from: k  reason: collision with root package name */
    public DrawerArgs f2754k;
    public float[] l;
    public PointF m;
    public RectF n;

    /* renamed from: c.a.d.g.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class C0090a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-542457884, "Lc/a/d/g/a/a$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-542457884, "Lc/a/d/g/a/a$a;");
                    return;
                }
            }
            int[] iArr = new int[DrawerArgs.SkinType.values().length];
            a = iArr;
            try {
                iArr[DrawerArgs.SkinType.NIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[DrawerArgs.SkinType.DAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[DrawerArgs.SkinType.DARK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(Canvas canvas, Drawable drawable);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-474306943, "Lc/a/d/g/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-474306943, "Lc/a/d/g/a/a;");
                return;
            }
        }
        o = new Matrix.ScaleToFit[]{Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
        p = new PorterDuffColorFilter(Integer.MIN_VALUE, PorterDuff.Mode.SRC_ATOP);
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f2745b = new Paint(6);
        this.f2746c = new Paint();
        this.f2747d = new Paint();
        this.f2748e = new Matrix();
        this.f2749f = new RectF();
        this.f2750g = new RectF();
        this.f2751h = new RectF();
        this.f2752i = new RectF();
        this.f2753j = new RectF();
        this.f2754k = new DrawerArgs();
        this.l = new float[9];
        this.m = new PointF();
        this.n = new RectF();
        this.f2746c.setStyle(Paint.Style.STROKE);
        this.f2746c.setAntiAlias(true);
        this.f2745b.setAntiAlias(true);
        this.f2747d.setAntiAlias(true);
        this.f2747d.setStyle(Paint.Style.FILL);
    }

    public static Matrix.ScaleToFit m(ImageView.ScaleType scaleType) {
        InterceptResult invokeL;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, scaleType)) == null) {
            if (scaleType != ImageView.ScaleType.FIT_XY) {
                if (scaleType == ImageView.ScaleType.FIT_START) {
                    i2 = 2;
                } else if (scaleType == ImageView.ScaleType.FIT_CENTER) {
                    i2 = 3;
                } else if (scaleType == ImageView.ScaleType.FIT_END) {
                    i2 = 4;
                }
                return o[i2 - 1];
            }
            i2 = 1;
            return o[i2 - 1];
        }
        return (Matrix.ScaleToFit) invokeL.objValue;
    }

    public abstract void a(d dVar, ImageView imageView);

    public PointF b(float f2, float f3, Matrix matrix) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3), matrix})) == null) {
            matrix.getValues(this.l);
            float[] fArr = this.l;
            this.m.set((int) ((fArr[0] * f2) + (fArr[1] * f3) + fArr[2]), (int) ((f2 * fArr[3]) + (f3 * fArr[4]) + fArr[5]));
            return this.m;
        }
        return (PointF) invokeCommon.objValue;
    }

    public void c(d dVar, ImageView imageView, ImageView.ScaleType scaleType) {
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(Constants.METHOD_SEND_USER_MSG, this, dVar, imageView, scaleType) == null) || imageView.getWidth() == 0 || imageView.getHeight() == 0) {
            return;
        }
        int b2 = dVar.b();
        int a = dVar.a();
        int width = (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
        int height = (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
        if (scaleType == ImageView.ScaleType.MATRIX) {
            this.f2749f.set(0.0f, 0.0f, b2, a);
            a(dVar, imageView);
            return;
        }
        boolean z = (b2 <= 0 || width == b2) && (a <= 0 || height == a);
        this.f2748e.reset();
        if (ImageView.ScaleType.FIT_XY != scaleType && !z) {
            float f5 = b2;
            float f6 = a;
            this.f2749f.set(0.0f, 0.0f, f5, f6);
            if (ImageView.ScaleType.CENTER == scaleType) {
                this.f2748e.setTranslate((width - b2) * 0.5f, (height - a) * 0.5f);
            } else if (ImageView.ScaleType.CENTER_CROP == scaleType) {
                if (b2 * height > a * width) {
                    f2 = height / f6;
                    f4 = (width - (f5 * f2)) * 0.5f;
                    f3 = 0.0f;
                } else {
                    f2 = width / f5;
                    f3 = (height - (f6 * f2)) * 0.5f;
                    f4 = 0.0f;
                }
                this.f2748e.setScale(f2, f2);
                this.f2748e.postTranslate(f4, f3);
            } else if (ImageView.ScaleType.CENTER_INSIDE == scaleType) {
                float min = (b2 > width || a > height) ? Math.min(width / f5, height / f6) : 1.0f;
                this.f2748e.setScale(min, min);
                this.f2748e.postTranslate((width - (f5 * min)) * 0.5f, (height - (f6 * min)) * 0.5f);
            } else {
                this.f2751h.set(0.0f, 0.0f, f5, f6);
                this.f2752i.set(0.0f, 0.0f, width, height);
                this.f2748e.setRectToRect(this.f2751h, this.f2752i, m(scaleType));
            }
        } else {
            this.f2749f.set(0.0f, 0.0f, width, height);
        }
        int length = this.f2754k.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            float[] fArr = this.f2754k.a;
            if (fArr[i2] > 0.0f && fArr[i2] < 1.0f) {
                fArr[i2] = fArr[i2] * this.f2749f.height();
            }
        }
        a(dVar, imageView);
    }

    public void d(Canvas canvas, ImageView imageView, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048579, this, canvas, imageView, drawable) == null) || drawable == null) {
            return;
        }
        int scrollX = imageView.getScrollX();
        int scrollY = imageView.getScrollY();
        drawable.setBounds(0, 0, imageView.getWidth(), imageView.getHeight());
        if ((scrollX | scrollY) == 0) {
            e(canvas, drawable);
            return;
        }
        canvas.translate(scrollX, scrollY);
        e(canvas, drawable);
        canvas.translate(-scrollX, -scrollY);
    }

    public void e(Canvas canvas, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, canvas, drawable) == null) {
            b bVar = this.a;
            if (bVar == null || !bVar.a(canvas, drawable)) {
                drawable.draw(canvas);
            }
        }
    }

    public abstract void f(Canvas canvas, ImageView imageView);

    public void g(Canvas canvas, d dVar, ImageView imageView) {
        Matrix matrix;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, canvas, dVar, imageView) == null) {
            q();
            int save = canvas.save();
            int scrollX = imageView.getScrollX();
            int scrollY = imageView.getScrollY();
            int paddingLeft = imageView.getPaddingLeft();
            int paddingRight = imageView.getPaddingRight();
            int paddingTop = imageView.getPaddingTop();
            int paddingBottom = imageView.getPaddingBottom();
            canvas.clipRect(scrollX + paddingLeft, scrollY + paddingTop, ((scrollX + imageView.getRight()) - imageView.getLeft()) - paddingRight, ((scrollY + imageView.getBottom()) - imageView.getTop()) - paddingBottom);
            canvas.translate(paddingLeft, paddingTop);
            int save2 = canvas.save();
            Matrix matrix2 = this.f2754k.l;
            if (matrix2 != null) {
                canvas.concat(matrix2);
            }
            c.a.d.m.d.a aVar = dVar.f2757b;
            if (aVar != null && aVar.v()) {
                if ((dVar.f2757b.p().getWidth() + paddingLeft + paddingRight > imageView.getWidth() || dVar.f2757b.p().getHeight() + paddingTop + paddingBottom > imageView.getHeight()) && (matrix = this.f2748e) != null) {
                    canvas.concat(matrix);
                }
                this.f2753j.set(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
                dVar.f2757b.i(canvas, this.f2753j);
            } else {
                h(canvas, dVar, imageView);
            }
            if (save2 >= 1 && save2 <= canvas.getSaveCount()) {
                canvas.restoreToCount(save2);
            }
            f(canvas, imageView);
            if (save < 1 || save > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(save);
        }
    }

    public abstract void h(Canvas canvas, d dVar, ImageView imageView);

    public abstract void i(Canvas canvas, ImageView imageView);

    public RectF j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.f2749f : (RectF) invokeV.objValue;
    }

    public Matrix k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.f2748e : (Matrix) invokeV.objValue;
    }

    public Path l(RectF rectF, float[] fArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048587, this, rectF, fArr)) == null) {
            Path path = new Path();
            path.addRoundRect(rectF, fArr, Path.Direction.CCW);
            return path;
        }
        return (Path) invokeLL.objValue;
    }

    public void n(Matrix matrix) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, matrix) == null) {
            this.f2748e = matrix;
        }
    }

    public void o(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.a = bVar;
        }
    }

    public void p(DrawerArgs drawerArgs) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, drawerArgs) == null) {
            this.f2754k = drawerArgs;
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            this.f2745b.setAlpha((int) (this.f2754k.f31711k * 255.0f));
            if (C0090a.a[this.f2754k.f31706f.ordinal()] != 1) {
                this.f2745b.setColorFilter(null);
            } else {
                this.f2745b.setColorFilter(p);
            }
            this.f2746c.setColor(this.f2754k.f31705e);
            this.f2746c.setStrokeWidth(this.f2754k.f31704d);
        }
    }
}
