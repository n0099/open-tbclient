package c.a.p0.a.c2.a;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes.dex */
public class b extends Drawable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final RectF a;

    /* renamed from: b  reason: collision with root package name */
    public final RectF f4460b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f4461c;

    /* renamed from: d  reason: collision with root package name */
    public final BitmapShader f4462d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f4463e;

    /* renamed from: f  reason: collision with root package name */
    public final int f4464f;

    /* renamed from: g  reason: collision with root package name */
    public final int f4465g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f4466h;

    /* renamed from: i  reason: collision with root package name */
    public final Paint f4467i;

    /* renamed from: j  reason: collision with root package name */
    public final Matrix f4468j;

    /* renamed from: k  reason: collision with root package name */
    public float f4469k;
    public int l;
    public int m;
    public ImageView.ScaleType n;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(269954355, "Lc/a/p0/a/c2/a/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(269954355, "Lc/a/p0/a/c2/a/b$a;");
                    return;
                }
            }
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public b(Bitmap bitmap, float f2, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new RectF();
        this.f4460b = new RectF();
        this.f4461c = new RectF();
        this.f4466h = new RectF();
        this.f4468j = new Matrix();
        this.n = ImageView.ScaleType.FIT_XY;
        this.l = i2;
        this.m = i3;
        this.f4464f = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.f4465g = height;
        this.f4461c.set(0.0f, 0.0f, this.f4464f, height);
        this.f4469k = f2;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f4462d = bitmapShader;
        bitmapShader.setLocalMatrix(this.f4468j);
        Paint paint = new Paint();
        this.f4463e = paint;
        paint.setAntiAlias(true);
        this.f4463e.setShader(this.f4462d);
        Paint paint2 = new Paint();
        this.f4467i = paint2;
        paint2.setAntiAlias(true);
        this.f4467i.setColor(this.m);
        this.f4467i.setStrokeWidth(i2);
    }

    public static Bitmap a(Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, drawable)) == null) {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:4:0x0004 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r5v2, types: [c.a.p0.a.c2.a.b] */
    @SuppressLint({"SwanDebugLog"})
    public static Drawable b(Drawable drawable, ImageView.ScaleType scaleType, float f2, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{drawable, scaleType, Float.valueOf(f2), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            if (drawable != 0) {
                if (drawable instanceof TransitionDrawable) {
                    TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
                    int numberOfLayers = transitionDrawable.getNumberOfLayers();
                    Drawable[] drawableArr = new Drawable[numberOfLayers];
                    for (int i4 = 0; i4 < numberOfLayers; i4++) {
                        Drawable drawable2 = transitionDrawable.getDrawable(i4);
                        if (drawable2 instanceof ColorDrawable) {
                            drawableArr[i4] = drawable2;
                        } else if (drawable2 instanceof b) {
                            drawableArr[i4] = drawable2;
                        } else {
                            drawableArr[i4] = new b(a(drawable2), f2, i2, i3);
                            if (scaleType != null) {
                                ((b) drawableArr[i4]).h(scaleType);
                            }
                        }
                    }
                    return new TransitionDrawable(drawableArr);
                }
                Bitmap a2 = a(drawable);
                if (a2 != null) {
                    drawable = new b(a2, f2, i2, i3);
                    if (scaleType != null) {
                        drawable.h(scaleType);
                    }
                }
            }
            return drawable;
        }
        return (Drawable) invokeCommon.objValue;
    }

    public ImageView.ScaleType c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.n : (ImageView.ScaleType) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.m = i2;
            this.f4467i.setColor(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (this.l > 0) {
                RectF rectF = this.f4466h;
                float f2 = this.f4469k;
                canvas.drawRoundRect(rectF, f2, f2, this.f4467i);
                canvas.drawRoundRect(this.f4460b, Math.max(this.f4469k - this.l, 0.0f), Math.max(this.f4469k - this.l, 0.0f), this.f4463e);
                return;
            }
            RectF rectF2 = this.f4460b;
            float f3 = this.f4469k;
            canvas.drawRoundRect(rectF2, f3, f3, this.f4463e);
        }
    }

    public void e(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.l = i2;
            this.f4467i.setStrokeWidth(i2);
        }
    }

    public void f(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            this.f4469k = f2;
        }
    }

    public final void g() {
        float width;
        float height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f4466h.set(this.a);
            RectF rectF = this.f4460b;
            int i2 = this.l;
            rectF.set(i2 + 0, i2 + 0, this.f4466h.width() - this.l, this.f4466h.height() - this.l);
            switch (a.a[this.n.ordinal()]) {
                case 1:
                    this.f4466h.set(this.a);
                    RectF rectF2 = this.f4460b;
                    int i3 = this.l;
                    rectF2.set(i3 + 0, i3 + 0, this.f4466h.width() - this.l, this.f4466h.height() - this.l);
                    this.f4468j.set(null);
                    this.f4468j.setTranslate((int) (((this.f4460b.width() - this.f4464f) * 0.5f) + 0.5f), (int) (((this.f4460b.height() - this.f4465g) * 0.5f) + 0.5f));
                    break;
                case 2:
                    this.f4466h.set(this.a);
                    RectF rectF3 = this.f4460b;
                    int i4 = this.l;
                    rectF3.set(i4 + 0, i4 + 0, this.f4466h.width() - this.l, this.f4466h.height() - this.l);
                    this.f4468j.set(null);
                    float f2 = 0.0f;
                    if (this.f4464f * this.f4460b.height() > this.f4460b.width() * this.f4465g) {
                        width = this.f4460b.height() / this.f4465g;
                        f2 = (this.f4460b.width() - (this.f4464f * width)) * 0.5f;
                        height = 0.0f;
                    } else {
                        width = this.f4460b.width() / this.f4464f;
                        height = (this.f4460b.height() - (this.f4465g * width)) * 0.5f;
                    }
                    this.f4468j.setScale(width, width);
                    Matrix matrix = this.f4468j;
                    int i5 = this.l;
                    matrix.postTranslate(((int) (f2 + 0.5f)) + i5, ((int) (height + 0.5f)) + i5);
                    break;
                case 3:
                    this.f4468j.set(null);
                    float min = (((float) this.f4464f) > this.a.width() || ((float) this.f4465g) > this.a.height()) ? Math.min(this.a.width() / this.f4464f, this.a.height() / this.f4465g) : 1.0f;
                    this.f4468j.setScale(min, min);
                    this.f4468j.postTranslate((int) (((this.a.width() - (this.f4464f * min)) * 0.5f) + 0.5f), (int) (((this.a.height() - (this.f4465g * min)) * 0.5f) + 0.5f));
                    this.f4466h.set(this.f4461c);
                    this.f4468j.mapRect(this.f4466h);
                    RectF rectF4 = this.f4460b;
                    RectF rectF5 = this.f4466h;
                    float f3 = rectF5.left;
                    int i6 = this.l;
                    rectF4.set(f3 + i6, rectF5.top + i6, rectF5.right - i6, rectF5.bottom - i6);
                    this.f4468j.setRectToRect(this.f4461c, this.f4460b, Matrix.ScaleToFit.FILL);
                    break;
                case 4:
                    this.f4466h.set(this.f4461c);
                    this.f4468j.setRectToRect(this.f4461c, this.a, Matrix.ScaleToFit.CENTER);
                    this.f4468j.mapRect(this.f4466h);
                    RectF rectF6 = this.f4460b;
                    RectF rectF7 = this.f4466h;
                    float f4 = rectF7.left;
                    int i7 = this.l;
                    rectF6.set(f4 + i7, rectF7.top + i7, rectF7.right - i7, rectF7.bottom - i7);
                    this.f4468j.setRectToRect(this.f4461c, this.f4460b, Matrix.ScaleToFit.FILL);
                    break;
                case 5:
                    this.f4466h.set(this.f4461c);
                    this.f4468j.setRectToRect(this.f4461c, this.a, Matrix.ScaleToFit.END);
                    this.f4468j.mapRect(this.f4466h);
                    RectF rectF8 = this.f4460b;
                    RectF rectF9 = this.f4466h;
                    float f5 = rectF9.left;
                    int i8 = this.l;
                    rectF8.set(f5 + i8, rectF9.top + i8, rectF9.right - i8, rectF9.bottom - i8);
                    this.f4468j.setRectToRect(this.f4461c, this.f4460b, Matrix.ScaleToFit.FILL);
                    break;
                case 6:
                    this.f4466h.set(this.f4461c);
                    this.f4468j.setRectToRect(this.f4461c, this.a, Matrix.ScaleToFit.START);
                    this.f4468j.mapRect(this.f4466h);
                    RectF rectF10 = this.f4460b;
                    RectF rectF11 = this.f4466h;
                    float f6 = rectF11.left;
                    int i9 = this.l;
                    rectF10.set(f6 + i9, rectF11.top + i9, rectF11.right - i9, rectF11.bottom - i9);
                    this.f4468j.setRectToRect(this.f4461c, this.f4460b, Matrix.ScaleToFit.FILL);
                    break;
                default:
                    this.f4466h.set(this.a);
                    RectF rectF12 = this.f4460b;
                    int i10 = this.l;
                    rectF12.set(i10 + 0, i10 + 0, this.f4466h.width() - this.l, this.f4466h.height() - this.l);
                    this.f4468j.set(null);
                    this.f4468j.setRectToRect(this.f4461c, this.f4460b, Matrix.ScaleToFit.FILL);
                    break;
            }
            this.f4462d.setLocalMatrix(this.f4468j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f4465g : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f4464f : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return -3;
        }
        return invokeV.intValue;
    }

    public void h(ImageView.ScaleType scaleType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, scaleType) == null) {
            if (scaleType == null) {
                scaleType = ImageView.ScaleType.FIT_XY;
            }
            if (this.n != scaleType) {
                this.n = scaleType;
                g();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, rect) == null) {
            super.onBoundsChange(rect);
            this.a.set(rect);
            g();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.f4463e.setAlpha(i2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, colorFilter) == null) {
            this.f4463e.setColorFilter(colorFilter);
        }
    }
}
