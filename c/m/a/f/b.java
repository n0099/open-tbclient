package c.m.a.f;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.media.SoundPool;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import c.m.a.c;
import c.m.a.f.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.opensource.svgaplayer.SVGAVideoEntity;
import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import java.util.HashMap;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* loaded from: classes9.dex */
public final class b extends c.m.a.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final C1672b f31124c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, Bitmap> f31125d;

    /* renamed from: e  reason: collision with root package name */
    public final a f31126e;

    /* renamed from: f  reason: collision with root package name */
    public final float[] f31127f;

    /* renamed from: g  reason: collision with root package name */
    public final c f31128g;

    /* loaded from: classes9.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f31129b;

        /* renamed from: c  reason: collision with root package name */
        public final HashMap<SVGAVideoShapeEntity, Path> f31130c;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f31130c = new HashMap<>();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sVGAVideoShapeEntity)) == null) {
                if (!this.f31130c.containsKey(sVGAVideoShapeEntity)) {
                    Path path = new Path();
                    path.set(sVGAVideoShapeEntity.b());
                    this.f31130c.put(sVGAVideoShapeEntity, path);
                }
                Path path2 = this.f31130c.get(sVGAVideoShapeEntity);
                if (path2 == null) {
                    Intrinsics.throwNpe();
                }
                return path2;
            }
            return (Path) invokeL.objValue;
        }

        public final void b(Canvas canvas) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) {
                if (this.a != canvas.getWidth() || this.f31129b != canvas.getHeight()) {
                    this.f31130c.clear();
                }
                this.a = canvas.getWidth();
                this.f31129b = canvas.getHeight();
            }
        }
    }

    /* renamed from: c.m.a.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static final class C1672b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final Paint a;

        /* renamed from: b  reason: collision with root package name */
        public final Path f31131b;

        /* renamed from: c  reason: collision with root package name */
        public final Path f31132c;

        /* renamed from: d  reason: collision with root package name */
        public final Matrix f31133d;

        /* renamed from: e  reason: collision with root package name */
        public final Matrix f31134e;

        public C1672b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = new Paint();
            this.f31131b = new Path();
            this.f31132c = new Path();
            this.f31133d = new Matrix();
            this.f31134e = new Matrix();
        }

        public final Matrix a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f31133d.reset();
                return this.f31133d;
            }
            return (Matrix) invokeV.objValue;
        }

        public final Matrix b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.f31134e.reset();
                return this.f31134e;
            }
            return (Matrix) invokeV.objValue;
        }

        public final Paint c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.a.reset();
                return this.a;
            }
            return (Paint) invokeV.objValue;
        }

        public final Path d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.f31131b.reset();
                return this.f31131b;
            }
            return (Path) invokeV.objValue;
        }

        public final Path e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.f31132c.reset();
                return this.f31132c;
            }
            return (Path) invokeV.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(SVGAVideoEntity sVGAVideoEntity, c cVar) {
        super(sVGAVideoEntity);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sVGAVideoEntity, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((SVGAVideoEntity) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f31128g = cVar;
        this.f31124c = new C1672b();
        this.f31125d = new HashMap<>();
        this.f31126e = new a();
        this.f31127f = new float[16];
    }

    @Override // c.m.a.f.a
    public void a(Canvas canvas, int i2, ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, canvas, i2, scaleType) == null) {
            super.a(canvas, i2, scaleType);
            this.f31126e.b(canvas);
            for (a.C1671a c1671a : d(i2)) {
                h(c1671a, canvas, i2);
            }
            k(i2);
        }
    }

    public final void e(a.C1671a c1671a, Canvas canvas, int i2) {
        String b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1671a, canvas, i2) == null) || (b2 = c1671a.b()) == null) {
            return;
        }
        Function2<Canvas, Integer, Boolean> function2 = this.f31128g.a().get(b2);
        if (function2 != null) {
            Matrix l = l(c1671a.a().e());
            canvas.save();
            canvas.concat(l);
            function2.invoke(canvas, Integer.valueOf(i2));
            canvas.restore();
        }
        Function4<Canvas, Integer, Integer, Integer, Boolean> function4 = this.f31128g.b().get(b2);
        if (function4 != null) {
            Matrix l2 = l(c1671a.a().e());
            canvas.save();
            canvas.concat(l2);
            function4.invoke(canvas, Integer.valueOf(i2), Integer.valueOf((int) c1671a.a().b().b()), Integer.valueOf((int) c1671a.a().b().a()));
            canvas.restore();
        }
    }

    public final void f(a.C1671a c1671a, Canvas canvas) {
        String b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, c1671a, canvas) == null) || (b2 = c1671a.b()) == null || Intrinsics.areEqual(this.f31128g.c().get(b2), Boolean.TRUE)) {
            return;
        }
        Bitmap bitmap = this.f31128g.d().get(b2);
        if (bitmap == null) {
            bitmap = c().e().get(b2);
        }
        if (bitmap != null) {
            Matrix l = l(c1671a.a().e());
            Paint c2 = this.f31124c.c();
            c2.setAntiAlias(c().a());
            c2.setFilterBitmap(c().a());
            c2.setAlpha((int) (c1671a.a().a() * 255));
            if (c1671a.a().c() != null) {
                c.m.a.g.b c3 = c1671a.a().c();
                if (c3 == null) {
                    return;
                }
                canvas.save();
                c2.reset();
                Path d2 = this.f31124c.d();
                c3.a(d2);
                d2.transform(l);
                canvas.clipPath(d2);
                l.preScale((float) (c1671a.a().b().b() / bitmap.getWidth()), (float) (c1671a.a().b().b() / bitmap.getWidth()));
                canvas.drawBitmap(bitmap, l, c2);
                canvas.restore();
            } else {
                l.preScale((float) (c1671a.a().b().b() / bitmap.getWidth()), (float) (c1671a.a().b().b() / bitmap.getWidth()));
                canvas.drawBitmap(bitmap, l, c2);
            }
            i(canvas, bitmap, c1671a, l);
        }
    }

    public final void g(a.C1671a c1671a, Canvas canvas) {
        SVGAVideoShapeEntity.a c2;
        float[] c3;
        String d2;
        String b2;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, c1671a, canvas) == null) {
            Matrix l = l(c1671a.a().e());
            for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c1671a.a().d()) {
                sVGAVideoShapeEntity.a();
                if (sVGAVideoShapeEntity.b() != null) {
                    Paint c4 = this.f31124c.c();
                    c4.reset();
                    c4.setAntiAlias(c().a());
                    double d3 = 255;
                    c4.setAlpha((int) (c1671a.a().a() * d3));
                    Path d4 = this.f31124c.d();
                    d4.reset();
                    d4.addPath(this.f31126e.a(sVGAVideoShapeEntity));
                    Matrix b3 = this.f31124c.b();
                    b3.reset();
                    Matrix d5 = sVGAVideoShapeEntity.d();
                    if (d5 != null) {
                        b3.postConcat(d5);
                    }
                    b3.postConcat(l);
                    d4.transform(b3);
                    SVGAVideoShapeEntity.a c5 = sVGAVideoShapeEntity.c();
                    if (c5 != null && (a2 = c5.a()) != 0) {
                        c4.setStyle(Paint.Style.FILL);
                        c4.setColor(a2);
                        c4.setAlpha(Math.min(255, Math.max(0, (int) (c1671a.a().a() * d3))));
                        if (c1671a.a().c() != null) {
                            canvas.save();
                        }
                        c.m.a.g.b c6 = c1671a.a().c();
                        if (c6 != null) {
                            Path e2 = this.f31124c.e();
                            c6.a(e2);
                            e2.transform(l);
                            canvas.clipPath(e2);
                        }
                        canvas.drawPath(d4, c4);
                        if (c1671a.a().c() != null) {
                            canvas.restore();
                        }
                    }
                    SVGAVideoShapeEntity.a c7 = sVGAVideoShapeEntity.c();
                    if (c7 != null) {
                        float f2 = 0;
                        if (c7.g() > f2) {
                            c4.setStyle(Paint.Style.STROKE);
                            SVGAVideoShapeEntity.a c8 = sVGAVideoShapeEntity.c();
                            if (c8 != null) {
                                c4.setColor(c8.f());
                                c4.setAlpha(Math.min(255, Math.max(0, (int) (c1671a.a().a() * d3))));
                            }
                            float j2 = j(l);
                            SVGAVideoShapeEntity.a c9 = sVGAVideoShapeEntity.c();
                            if (c9 != null) {
                                c4.setStrokeWidth(c9.g() * j2);
                            }
                            SVGAVideoShapeEntity.a c10 = sVGAVideoShapeEntity.c();
                            if (c10 != null && (b2 = c10.b()) != null) {
                                if (StringsKt__StringsJVMKt.equals(b2, "butt", true)) {
                                    c4.setStrokeCap(Paint.Cap.BUTT);
                                } else if (StringsKt__StringsJVMKt.equals(b2, "round", true)) {
                                    c4.setStrokeCap(Paint.Cap.ROUND);
                                } else if (StringsKt__StringsJVMKt.equals(b2, "square", true)) {
                                    c4.setStrokeCap(Paint.Cap.SQUARE);
                                }
                            }
                            SVGAVideoShapeEntity.a c11 = sVGAVideoShapeEntity.c();
                            if (c11 != null && (d2 = c11.d()) != null) {
                                if (StringsKt__StringsJVMKt.equals(d2, "miter", true)) {
                                    c4.setStrokeJoin(Paint.Join.MITER);
                                } else if (StringsKt__StringsJVMKt.equals(d2, "round", true)) {
                                    c4.setStrokeJoin(Paint.Join.ROUND);
                                } else if (StringsKt__StringsJVMKt.equals(d2, "bevel", true)) {
                                    c4.setStrokeJoin(Paint.Join.BEVEL);
                                }
                            }
                            if (sVGAVideoShapeEntity.c() != null) {
                                c4.setStrokeMiter(c2.e() * j2);
                            }
                            SVGAVideoShapeEntity.a c12 = sVGAVideoShapeEntity.c();
                            if (c12 != null && (c3 = c12.c()) != null && c3.length == 3 && (c3[0] > f2 || c3[1] > f2)) {
                                float[] fArr = new float[2];
                                fArr[0] = (c3[0] >= 1.0f ? c3[0] : 1.0f) * j2;
                                fArr[1] = (c3[1] >= 0.1f ? c3[1] : 0.1f) * j2;
                                c4.setPathEffect(new DashPathEffect(fArr, c3[2] * j2));
                            }
                            if (c1671a.a().c() != null) {
                                canvas.save();
                            }
                            c.m.a.g.b c13 = c1671a.a().c();
                            if (c13 != null) {
                                Path e3 = this.f31124c.e();
                                c13.a(e3);
                                e3.transform(l);
                                canvas.clipPath(e3);
                            }
                            canvas.drawPath(d4, c4);
                            if (c1671a.a().c() != null) {
                                canvas.restore();
                            }
                        }
                    }
                }
            }
        }
    }

    public final void h(a.C1671a c1671a, Canvas canvas, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, c1671a, canvas, i2) == null) {
            f(c1671a, canvas);
            g(c1671a, canvas);
            e(c1671a, canvas, i2);
        }
    }

    public final void i(Canvas canvas, Bitmap bitmap, a.C1671a c1671a, Matrix matrix) {
        TextPaint drawingTextPaint;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, canvas, bitmap, c1671a, matrix) == null) {
            if (this.f31128g.h()) {
                this.f31125d.clear();
                this.f31128g.i(false);
            }
            String b2 = c1671a.b();
            if (b2 != null) {
                Bitmap bitmap2 = null;
                String str = this.f31128g.f().get(b2);
                if (str != null && (drawingTextPaint = this.f31128g.g().get(b2)) != null && (bitmap2 = this.f31125d.get(b2)) == null) {
                    bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmap2);
                    Intrinsics.checkExpressionValueIsNotNull(drawingTextPaint, "drawingTextPaint");
                    drawingTextPaint.setAntiAlias(true);
                    Rect rect = new Rect();
                    drawingTextPaint.getTextBounds(str, 0, str.length(), rect);
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((bitmap.getHeight() + 0) - drawingTextPaint.getFontMetrics().bottom) - drawingTextPaint.getFontMetrics().top) / 2, drawingTextPaint);
                    HashMap<String, Bitmap> hashMap = this.f31125d;
                    if (bitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(b2, bitmap2);
                }
                StaticLayout it = this.f31128g.e().get(b2);
                if (it != null && (bitmap2 = this.f31125d.get(b2)) == null) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    TextPaint paint = it.getPaint();
                    Intrinsics.checkExpressionValueIsNotNull(paint, "it.paint");
                    paint.setAntiAlias(true);
                    StaticLayout staticLayout = new StaticLayout(it.getText(), 0, it.getText().length(), it.getPaint(), bitmap.getWidth(), it.getAlignment(), it.getSpacingMultiplier(), it.getSpacingAdd(), false);
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(createBitmap);
                    canvas3.translate(0.0f, (bitmap.getHeight() - staticLayout.getHeight()) / 2);
                    staticLayout.draw(canvas3);
                    HashMap<String, Bitmap> hashMap2 = this.f31125d;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(b2, createBitmap);
                    bitmap2 = createBitmap;
                }
                if (bitmap2 != null) {
                    Paint c2 = this.f31124c.c();
                    c2.setAntiAlias(c().a());
                    if (c1671a.a().c() != null) {
                        c.m.a.g.b c3 = c1671a.a().c();
                        if (c3 != null) {
                            canvas.save();
                            canvas.concat(matrix);
                            canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                            c2.setShader(new BitmapShader(bitmap2, tileMode, tileMode));
                            Path d2 = this.f31124c.d();
                            c3.a(d2);
                            canvas.drawPath(d2, c2);
                            canvas.restore();
                            return;
                        }
                        return;
                    }
                    c2.setFilterBitmap(c().a());
                    canvas.drawBitmap(bitmap2, matrix, c2);
                }
            }
        }
    }

    public final float j(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, matrix)) == null) {
            matrix.getValues(this.f31127f);
            float[] fArr = this.f31127f;
            if (fArr[0] == 0.0f) {
                return 0.0f;
            }
            double d2 = fArr[0];
            double d3 = fArr[3];
            double d4 = fArr[1];
            double d5 = fArr[4];
            if (d2 * d5 == d3 * d4) {
                return 0.0f;
            }
            double sqrt = Math.sqrt((d2 * d2) + (d3 * d3));
            double d6 = d2 / sqrt;
            double d7 = d3 / sqrt;
            double d8 = (d6 * d4) + (d7 * d5);
            double d9 = d4 - (d6 * d8);
            double d10 = d5 - (d8 * d7);
            double sqrt2 = Math.sqrt((d9 * d9) + (d10 * d10));
            if (d6 * (d10 / sqrt2) < d7 * (d9 / sqrt2)) {
                sqrt = -sqrt;
            }
            return Math.abs(b().a() ? (float) sqrt : (float) sqrt2);
        }
        return invokeL.floatValue;
    }

    public final void k(int i2) {
        SoundPool f2;
        Integer c2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i2) == null) {
            for (c.m.a.g.a aVar : c().b()) {
                if (aVar.d() == i2 && (f2 = c().f()) != null && (c2 = aVar.c()) != null) {
                    aVar.e(Integer.valueOf(f2.play(c2.intValue(), 1.0f, 1.0f, 1, 0, 1.0f)));
                }
                if (aVar.a() <= i2) {
                    Integer b2 = aVar.b();
                    if (b2 != null) {
                        int intValue = b2.intValue();
                        SoundPool f3 = c().f();
                        if (f3 != null) {
                            f3.stop(intValue);
                        }
                    }
                    aVar.e(null);
                }
            }
        }
    }

    public final Matrix l(Matrix matrix) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, matrix)) == null) {
            Matrix a2 = this.f31124c.a();
            a2.postScale(b().b(), b().c());
            a2.postTranslate(b().d(), b().e());
            a2.preConcat(matrix);
            return a2;
        }
        return (Matrix) invokeL.objValue;
    }
}
