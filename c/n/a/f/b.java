package c.n.a.f;

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
import c.n.a.c;
import c.n.a.f.a;
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
/* loaded from: classes4.dex */
public final class b extends c.n.a.f.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final C1515b f34378c;

    /* renamed from: d  reason: collision with root package name */
    public final HashMap<String, Bitmap> f34379d;

    /* renamed from: e  reason: collision with root package name */
    public final a f34380e;

    /* renamed from: f  reason: collision with root package name */
    public final float[] f34381f;

    /* renamed from: g  reason: collision with root package name */
    public final c f34382g;

    /* loaded from: classes4.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f34383a;

        /* renamed from: b  reason: collision with root package name */
        public int f34384b;

        /* renamed from: c  reason: collision with root package name */
        public final HashMap<SVGAVideoShapeEntity, Path> f34385c;

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
            this.f34385c = new HashMap<>();
        }

        public final Path a(SVGAVideoShapeEntity sVGAVideoShapeEntity) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, sVGAVideoShapeEntity)) == null) {
                if (!this.f34385c.containsKey(sVGAVideoShapeEntity)) {
                    Path path = new Path();
                    path.set(sVGAVideoShapeEntity.b());
                    this.f34385c.put(sVGAVideoShapeEntity, path);
                }
                Path path2 = this.f34385c.get(sVGAVideoShapeEntity);
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
                if (this.f34383a != canvas.getWidth() || this.f34384b != canvas.getHeight()) {
                    this.f34385c.clear();
                }
                this.f34383a = canvas.getWidth();
                this.f34384b = canvas.getHeight();
            }
        }
    }

    /* renamed from: c.n.a.f.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static final class C1515b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Paint f34386a;

        /* renamed from: b  reason: collision with root package name */
        public final Path f34387b;

        /* renamed from: c  reason: collision with root package name */
        public final Path f34388c;

        /* renamed from: d  reason: collision with root package name */
        public final Matrix f34389d;

        /* renamed from: e  reason: collision with root package name */
        public final Matrix f34390e;

        public C1515b() {
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
            this.f34386a = new Paint();
            this.f34387b = new Path();
            this.f34388c = new Path();
            this.f34389d = new Matrix();
            this.f34390e = new Matrix();
        }

        public final Matrix a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                this.f34389d.reset();
                return this.f34389d;
            }
            return (Matrix) invokeV.objValue;
        }

        public final Matrix b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                this.f34390e.reset();
                return this.f34390e;
            }
            return (Matrix) invokeV.objValue;
        }

        public final Paint c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                this.f34386a.reset();
                return this.f34386a;
            }
            return (Paint) invokeV.objValue;
        }

        public final Path d() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                this.f34387b.reset();
                return this.f34387b;
            }
            return (Path) invokeV.objValue;
        }

        public final Path e() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
                this.f34388c.reset();
                return this.f34388c;
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
        this.f34382g = cVar;
        this.f34378c = new C1515b();
        this.f34379d = new HashMap<>();
        this.f34380e = new a();
        this.f34381f = new float[16];
    }

    @Override // c.n.a.f.a
    public void a(Canvas canvas, int i2, ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048576, this, canvas, i2, scaleType) == null) {
            super.a(canvas, i2, scaleType);
            this.f34380e.b(canvas);
            for (a.C1514a c1514a : d(i2)) {
                h(c1514a, canvas, i2);
            }
            k(i2);
        }
    }

    public final void e(a.C1514a c1514a, Canvas canvas, int i2) {
        String b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, c1514a, canvas, i2) == null) || (b2 = c1514a.b()) == null) {
            return;
        }
        Function2<Canvas, Integer, Boolean> function2 = this.f34382g.a().get(b2);
        if (function2 != null) {
            Matrix l = l(c1514a.a().e());
            canvas.save();
            canvas.concat(l);
            function2.invoke(canvas, Integer.valueOf(i2));
            canvas.restore();
        }
        Function4<Canvas, Integer, Integer, Integer, Boolean> function4 = this.f34382g.b().get(b2);
        if (function4 != null) {
            Matrix l2 = l(c1514a.a().e());
            canvas.save();
            canvas.concat(l2);
            function4.invoke(canvas, Integer.valueOf(i2), Integer.valueOf((int) c1514a.a().b().b()), Integer.valueOf((int) c1514a.a().b().a()));
            canvas.restore();
        }
    }

    public final void f(a.C1514a c1514a, Canvas canvas) {
        String b2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, c1514a, canvas) == null) || (b2 = c1514a.b()) == null || Intrinsics.areEqual(this.f34382g.c().get(b2), Boolean.TRUE)) {
            return;
        }
        Bitmap bitmap = this.f34382g.d().get(b2);
        if (bitmap == null) {
            bitmap = c().e().get(b2);
        }
        if (bitmap != null) {
            Matrix l = l(c1514a.a().e());
            Paint c2 = this.f34378c.c();
            c2.setAntiAlias(c().a());
            c2.setFilterBitmap(c().a());
            c2.setAlpha((int) (c1514a.a().a() * 255));
            if (c1514a.a().c() != null) {
                c.n.a.g.b c3 = c1514a.a().c();
                if (c3 == null) {
                    return;
                }
                canvas.save();
                c2.reset();
                Path d2 = this.f34378c.d();
                c3.a(d2);
                d2.transform(l);
                canvas.clipPath(d2);
                l.preScale((float) (c1514a.a().b().b() / bitmap.getWidth()), (float) (c1514a.a().b().b() / bitmap.getWidth()));
                canvas.drawBitmap(bitmap, l, c2);
                canvas.restore();
            } else {
                l.preScale((float) (c1514a.a().b().b() / bitmap.getWidth()), (float) (c1514a.a().b().b() / bitmap.getWidth()));
                canvas.drawBitmap(bitmap, l, c2);
            }
            i(canvas, bitmap, c1514a, l);
        }
    }

    public final void g(a.C1514a c1514a, Canvas canvas) {
        SVGAVideoShapeEntity.a c2;
        float[] c3;
        String d2;
        String b2;
        int a2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, c1514a, canvas) == null) {
            Matrix l = l(c1514a.a().e());
            for (SVGAVideoShapeEntity sVGAVideoShapeEntity : c1514a.a().d()) {
                sVGAVideoShapeEntity.a();
                if (sVGAVideoShapeEntity.b() != null) {
                    Paint c4 = this.f34378c.c();
                    c4.reset();
                    c4.setAntiAlias(c().a());
                    double d3 = 255;
                    c4.setAlpha((int) (c1514a.a().a() * d3));
                    Path d4 = this.f34378c.d();
                    d4.reset();
                    d4.addPath(this.f34380e.a(sVGAVideoShapeEntity));
                    Matrix b3 = this.f34378c.b();
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
                        c4.setAlpha(Math.min(255, Math.max(0, (int) (c1514a.a().a() * d3))));
                        if (c1514a.a().c() != null) {
                            canvas.save();
                        }
                        c.n.a.g.b c6 = c1514a.a().c();
                        if (c6 != null) {
                            Path e2 = this.f34378c.e();
                            c6.a(e2);
                            e2.transform(l);
                            canvas.clipPath(e2);
                        }
                        canvas.drawPath(d4, c4);
                        if (c1514a.a().c() != null) {
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
                                c4.setAlpha(Math.min(255, Math.max(0, (int) (c1514a.a().a() * d3))));
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
                            if (c1514a.a().c() != null) {
                                canvas.save();
                            }
                            c.n.a.g.b c13 = c1514a.a().c();
                            if (c13 != null) {
                                Path e3 = this.f34378c.e();
                                c13.a(e3);
                                e3.transform(l);
                                canvas.clipPath(e3);
                            }
                            canvas.drawPath(d4, c4);
                            if (c1514a.a().c() != null) {
                                canvas.restore();
                            }
                        }
                    }
                }
            }
        }
    }

    public final void h(a.C1514a c1514a, Canvas canvas, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, c1514a, canvas, i2) == null) {
            f(c1514a, canvas);
            g(c1514a, canvas);
            e(c1514a, canvas, i2);
        }
    }

    public final void i(Canvas canvas, Bitmap bitmap, a.C1514a c1514a, Matrix matrix) {
        TextPaint drawingTextPaint;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, canvas, bitmap, c1514a, matrix) == null) {
            if (this.f34382g.h()) {
                this.f34379d.clear();
                this.f34382g.i(false);
            }
            String b2 = c1514a.b();
            if (b2 != null) {
                Bitmap bitmap2 = null;
                String str = this.f34382g.f().get(b2);
                if (str != null && (drawingTextPaint = this.f34382g.g().get(b2)) != null && (bitmap2 = this.f34379d.get(b2)) == null) {
                    bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas2 = new Canvas(bitmap2);
                    Intrinsics.checkExpressionValueIsNotNull(drawingTextPaint, "drawingTextPaint");
                    drawingTextPaint.setAntiAlias(true);
                    Rect rect = new Rect();
                    drawingTextPaint.getTextBounds(str, 0, str.length(), rect);
                    canvas2.drawText(str, (float) ((bitmap.getWidth() - rect.width()) / 2.0d), (((bitmap.getHeight() + 0) - drawingTextPaint.getFontMetrics().bottom) - drawingTextPaint.getFontMetrics().top) / 2, drawingTextPaint);
                    HashMap<String, Bitmap> hashMap = this.f34379d;
                    if (bitmap2 == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap.put(b2, bitmap2);
                }
                StaticLayout it = this.f34382g.e().get(b2);
                if (it != null && (bitmap2 = this.f34379d.get(b2)) == null) {
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    TextPaint paint = it.getPaint();
                    Intrinsics.checkExpressionValueIsNotNull(paint, "it.paint");
                    paint.setAntiAlias(true);
                    StaticLayout staticLayout = new StaticLayout(it.getText(), 0, it.getText().length(), it.getPaint(), bitmap.getWidth(), it.getAlignment(), it.getSpacingMultiplier(), it.getSpacingAdd(), false);
                    Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(createBitmap);
                    canvas3.translate(0.0f, (bitmap.getHeight() - staticLayout.getHeight()) / 2);
                    staticLayout.draw(canvas3);
                    HashMap<String, Bitmap> hashMap2 = this.f34379d;
                    if (createBitmap == null) {
                        throw new TypeCastException("null cannot be cast to non-null type android.graphics.Bitmap");
                    }
                    hashMap2.put(b2, createBitmap);
                    bitmap2 = createBitmap;
                }
                if (bitmap2 != null) {
                    Paint c2 = this.f34378c.c();
                    c2.setAntiAlias(c().a());
                    if (c1514a.a().c() != null) {
                        c.n.a.g.b c3 = c1514a.a().c();
                        if (c3 != null) {
                            canvas.save();
                            canvas.concat(matrix);
                            canvas.clipRect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
                            c2.setShader(new BitmapShader(bitmap2, tileMode, tileMode));
                            Path d2 = this.f34378c.d();
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
            matrix.getValues(this.f34381f);
            float[] fArr = this.f34381f;
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
            for (c.n.a.g.a aVar : c().b()) {
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
            Matrix a2 = this.f34378c.a();
            a2.postScale(b().b(), b().c());
            a2.postTranslate(b().d(), b().e());
            a2.preConcat(matrix);
            return a2;
        }
        return (Matrix) invokeL.objValue;
    }
}
