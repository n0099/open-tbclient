package c.a.n0.a.s1.a;

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
import android.util.Log;
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
    public final RectF f6155b;

    /* renamed from: c  reason: collision with root package name */
    public final RectF f6156c;

    /* renamed from: d  reason: collision with root package name */
    public final BitmapShader f6157d;

    /* renamed from: e  reason: collision with root package name */
    public final Paint f6158e;

    /* renamed from: f  reason: collision with root package name */
    public final int f6159f;

    /* renamed from: g  reason: collision with root package name */
    public final int f6160g;

    /* renamed from: h  reason: collision with root package name */
    public final RectF f6161h;
    public final Paint i;
    public final Matrix j;
    public float k;
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
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(683760934, "Lc/a/n0/a/s1/a/b$a;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(683760934, "Lc/a/n0/a/s1/a/b$a;");
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

    public b(Bitmap bitmap, float f2, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bitmap, Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new RectF();
        this.f6155b = new RectF();
        this.f6156c = new RectF();
        this.f6161h = new RectF();
        this.j = new Matrix();
        this.n = ImageView.ScaleType.FIT_XY;
        this.l = i;
        this.m = i2;
        this.f6159f = bitmap.getWidth();
        int height = bitmap.getHeight();
        this.f6160g = height;
        this.f6156c.set(0.0f, 0.0f, this.f6159f, height);
        this.k = f2;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        this.f6157d = bitmapShader;
        bitmapShader.setLocalMatrix(this.j);
        Paint paint = new Paint();
        this.f6158e = paint;
        paint.setAntiAlias(true);
        this.f6158e.setShader(this.f6157d);
        Paint paint2 = new Paint();
        this.i = paint2;
        paint2.setAntiAlias(true);
        this.i.setColor(this.m);
        this.i.setStrokeWidth(i);
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

    @SuppressLint({"SwanDebugLog"})
    public static Drawable b(Drawable drawable, ImageView.ScaleType scaleType, float f2, int i, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{drawable, scaleType, Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(i2)})) == null) {
            if (drawable != null) {
                if (drawable instanceof TransitionDrawable) {
                    TransitionDrawable transitionDrawable = (TransitionDrawable) drawable;
                    int numberOfLayers = transitionDrawable.getNumberOfLayers();
                    Drawable[] drawableArr = new Drawable[numberOfLayers];
                    for (int i3 = 0; i3 < numberOfLayers; i3++) {
                        Drawable drawable2 = transitionDrawable.getDrawable(i3);
                        if (drawable2 instanceof ColorDrawable) {
                            drawableArr[i3] = drawable2;
                        } else if (drawable2 instanceof b) {
                            drawableArr[i3] = drawable2;
                        } else {
                            drawableArr[i3] = new b(a(drawable2), f2, i, i2);
                            if (scaleType != null) {
                                ((b) drawableArr[i3]).h(scaleType);
                            }
                        }
                    }
                    return new TransitionDrawable(drawableArr);
                }
                Bitmap a2 = a(drawable);
                if (a2 != null) {
                    b bVar = new b(a2, f2, i, i2);
                    if (scaleType != null) {
                        bVar.h(scaleType);
                    }
                    return bVar;
                }
                Log.w("RoundedDrawable", "Failed to create bitmap from drawable!");
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

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.m = i;
            this.i.setColor(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, canvas) == null) {
            if (this.l > 0) {
                RectF rectF = this.f6161h;
                float f2 = this.k;
                canvas.drawRoundRect(rectF, f2, f2, this.i);
                canvas.drawRoundRect(this.f6155b, Math.max(this.k - this.l, 0.0f), Math.max(this.k - this.l, 0.0f), this.f6158e);
                return;
            }
            RectF rectF2 = this.f6155b;
            float f3 = this.k;
            canvas.drawRoundRect(rectF2, f3, f3, this.f6158e);
        }
    }

    public void e(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.l = i;
            this.i.setStrokeWidth(i);
        }
    }

    public void f(float f2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048580, this, f2) == null) {
            this.k = f2;
        }
    }

    public final void g() {
        float width;
        float height;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f6161h.set(this.a);
            RectF rectF = this.f6155b;
            int i = this.l;
            rectF.set(i + 0, i + 0, this.f6161h.width() - this.l, this.f6161h.height() - this.l);
            switch (a.a[this.n.ordinal()]) {
                case 1:
                    this.f6161h.set(this.a);
                    RectF rectF2 = this.f6155b;
                    int i2 = this.l;
                    rectF2.set(i2 + 0, i2 + 0, this.f6161h.width() - this.l, this.f6161h.height() - this.l);
                    this.j.set(null);
                    this.j.setTranslate((int) (((this.f6155b.width() - this.f6159f) * 0.5f) + 0.5f), (int) (((this.f6155b.height() - this.f6160g) * 0.5f) + 0.5f));
                    break;
                case 2:
                    this.f6161h.set(this.a);
                    RectF rectF3 = this.f6155b;
                    int i3 = this.l;
                    rectF3.set(i3 + 0, i3 + 0, this.f6161h.width() - this.l, this.f6161h.height() - this.l);
                    this.j.set(null);
                    float f2 = 0.0f;
                    if (this.f6159f * this.f6155b.height() > this.f6155b.width() * this.f6160g) {
                        width = this.f6155b.height() / this.f6160g;
                        f2 = (this.f6155b.width() - (this.f6159f * width)) * 0.5f;
                        height = 0.0f;
                    } else {
                        width = this.f6155b.width() / this.f6159f;
                        height = (this.f6155b.height() - (this.f6160g * width)) * 0.5f;
                    }
                    this.j.setScale(width, width);
                    Matrix matrix = this.j;
                    int i4 = this.l;
                    matrix.postTranslate(((int) (f2 + 0.5f)) + i4, ((int) (height + 0.5f)) + i4);
                    break;
                case 3:
                    this.j.set(null);
                    float min = (((float) this.f6159f) > this.a.width() || ((float) this.f6160g) > this.a.height()) ? Math.min(this.a.width() / this.f6159f, this.a.height() / this.f6160g) : 1.0f;
                    this.j.setScale(min, min);
                    this.j.postTranslate((int) (((this.a.width() - (this.f6159f * min)) * 0.5f) + 0.5f), (int) (((this.a.height() - (this.f6160g * min)) * 0.5f) + 0.5f));
                    this.f6161h.set(this.f6156c);
                    this.j.mapRect(this.f6161h);
                    RectF rectF4 = this.f6155b;
                    RectF rectF5 = this.f6161h;
                    float f3 = rectF5.left;
                    int i5 = this.l;
                    rectF4.set(f3 + i5, rectF5.top + i5, rectF5.right - i5, rectF5.bottom - i5);
                    this.j.setRectToRect(this.f6156c, this.f6155b, Matrix.ScaleToFit.FILL);
                    break;
                case 4:
                    this.f6161h.set(this.f6156c);
                    this.j.setRectToRect(this.f6156c, this.a, Matrix.ScaleToFit.CENTER);
                    this.j.mapRect(this.f6161h);
                    RectF rectF6 = this.f6155b;
                    RectF rectF7 = this.f6161h;
                    float f4 = rectF7.left;
                    int i6 = this.l;
                    rectF6.set(f4 + i6, rectF7.top + i6, rectF7.right - i6, rectF7.bottom - i6);
                    this.j.setRectToRect(this.f6156c, this.f6155b, Matrix.ScaleToFit.FILL);
                    break;
                case 5:
                    this.f6161h.set(this.f6156c);
                    this.j.setRectToRect(this.f6156c, this.a, Matrix.ScaleToFit.END);
                    this.j.mapRect(this.f6161h);
                    RectF rectF8 = this.f6155b;
                    RectF rectF9 = this.f6161h;
                    float f5 = rectF9.left;
                    int i7 = this.l;
                    rectF8.set(f5 + i7, rectF9.top + i7, rectF9.right - i7, rectF9.bottom - i7);
                    this.j.setRectToRect(this.f6156c, this.f6155b, Matrix.ScaleToFit.FILL);
                    break;
                case 6:
                    this.f6161h.set(this.f6156c);
                    this.j.setRectToRect(this.f6156c, this.a, Matrix.ScaleToFit.START);
                    this.j.mapRect(this.f6161h);
                    RectF rectF10 = this.f6155b;
                    RectF rectF11 = this.f6161h;
                    float f6 = rectF11.left;
                    int i8 = this.l;
                    rectF10.set(f6 + i8, rectF11.top + i8, rectF11.right - i8, rectF11.bottom - i8);
                    this.j.setRectToRect(this.f6156c, this.f6155b, Matrix.ScaleToFit.FILL);
                    break;
                default:
                    this.f6161h.set(this.a);
                    RectF rectF12 = this.f6155b;
                    int i9 = this.l;
                    rectF12.set(i9 + 0, i9 + 0, this.f6161h.width() - this.l, this.f6161h.height() - this.l);
                    this.j.set(null);
                    this.j.setRectToRect(this.f6156c, this.f6155b, Matrix.ScaleToFit.FILL);
                    break;
            }
            this.f6157d.setLocalMatrix(this.j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f6160g : invokeV.intValue;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f6159f : invokeV.intValue;
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
    public void setAlpha(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f6158e.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, colorFilter) == null) {
            this.f6158e.setColorFilter(colorFilter);
        }
    }
}
