package com.baidu.swan.facade.picture.widget;

import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import c.a.o0.a.k;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.facade.picture.widget.BdImageViewTouchBase;
import com.baidu.swan.facade.picture.widget.ZoomImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class PictureCropView extends PictureView {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean s;
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable n;
    public final Rect o;
    public int p;
    public Paint q;
    public boolean r;

    /* loaded from: classes6.dex */
    public class a implements ZoomImageView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ZoomImageView f46720a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PictureCropView f46721b;

        public a(PictureCropView pictureCropView, ZoomImageView zoomImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pictureCropView, zoomImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46721b = pictureCropView;
            this.f46720a = zoomImageView;
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.a
        public void a(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
                this.f46721b.r = drawable != null;
                if (drawable != null) {
                    this.f46721b.o(this.f46720a, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                }
            }
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.a
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.f46721b.r = bitmap != null;
                if (bitmap != null) {
                    this.f46721b.o(this.f46720a, bitmap.getWidth(), bitmap.getHeight());
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BdImageViewTouchBase.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ZoomImageView f46722a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PictureCropView f46723b;

        public b(PictureCropView pictureCropView, ZoomImageView zoomImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pictureCropView, zoomImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46723b = pictureCropView;
            this.f46722a = zoomImageView;
        }

        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase.f
        public void a(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
                this.f46723b.m(this.f46722a, drawable);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements ZoomImageView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public RectF f46724a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ PictureCropView f46725b;

        public c(PictureCropView pictureCropView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pictureCropView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46725b = pictureCropView;
            this.f46724a = new RectF();
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.b
        public boolean a(ZoomImageView zoomImageView, double d2, double d3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{zoomImageView, Double.valueOf(d2), Double.valueOf(d3)})) == null) {
                RectF bitmapRect = zoomImageView.getBitmapRect();
                this.f46724a.set((float) d2, (float) d3, 0.0f, 0.0f);
                this.f46725b.p(bitmapRect, this.f46724a);
                RectF rectF = this.f46724a;
                zoomImageView.postTranslate(rectF.left, rectF.top);
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.b
        public boolean b(ZoomImageView zoomImageView, MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{zoomImageView, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                zoomImageView.scrollBy(-f2, -f3);
                zoomImageView.invalidate();
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.b
        public boolean c(ZoomImageView zoomImageView, MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{zoomImageView, motionEvent, motionEvent2, Float.valueOf(f2), Float.valueOf(f3)})) == null) {
                return true;
            }
            return invokeCommon.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1701710237, "Lcom/baidu/swan/facade/picture/widget/PictureCropView;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1701710237, "Lcom/baidu/swan/facade/picture/widget/PictureCropView;");
                return;
            }
        }
        s = k.f7049a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureCropView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = null;
        this.o = new Rect();
        this.p = Color.argb(128, 0, 0, 0);
        this.q = new Paint();
        this.r = false;
        f(context);
    }

    private void f(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            this.q.setColor(this.p);
            this.q.setStyle(Paint.Style.FILL);
            this.n = context.getResources().getDrawable(c.a.o0.e.b.swan_app_picture_crop_bounds);
            ZoomImageView zoomImageView = (ZoomImageView) getImageView();
            zoomImageView.setDoubleTapEnabled(true);
            zoomImageView.setCalcBaseMatrix(false);
            zoomImageView.setOnSetImageBitmapListener(new a(this, zoomImageView));
            zoomImageView.setOnDrawableChangedListener(new b(this, zoomImageView));
            zoomImageView.setOnUpdateRectListener(new c(this));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, canvas) == null) {
            super.dispatchDraw(canvas);
            drawCropRect(canvas);
        }
    }

    public void drawCropRect(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, canvas) == null) && this.r) {
            drawShade(canvas, this.o);
            if (this.n == null || this.o.isEmpty()) {
                return;
            }
            this.n.setBounds(this.o);
            this.n.draw(canvas);
        }
    }

    public void drawShade(Canvas canvas, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, canvas, rect) == null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            Paint paint = this.q;
            float f2 = width;
            canvas.drawRect(0.0f, 0.0f, f2, rect.top, paint);
            float f3 = height;
            canvas.drawRect(0.0f, rect.top, rect.left, f3, paint);
            canvas.drawRect(rect.left, rect.bottom, f2, f3, paint);
            canvas.drawRect(rect.right, rect.top, f2, rect.bottom, paint);
        }
    }

    public Bitmap getCroppedImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            Bitmap imageViewBitmap = getImageViewBitmap();
            if (imageViewBitmap == null) {
                return null;
            }
            try {
                ZoomImageView zoomImageView = (ZoomImageView) getImageView();
                RectF rectF = new RectF(this.o);
                if (rectF.isEmpty()) {
                    rectF.set(0.0f, 0.0f, getWidth(), getHeight());
                }
                Matrix imageViewMatrix = zoomImageView.getImageViewMatrix();
                Matrix matrix = new Matrix();
                if (imageViewMatrix.invert(matrix)) {
                    RectF rectF2 = new RectF(rectF);
                    matrix.mapRect(rectF2);
                    Rect rect = new Rect();
                    rectF2.round(rect);
                    rect.right = Math.min(rect.right, imageViewBitmap.getWidth());
                    rect.bottom = Math.min(rect.bottom, imageViewBitmap.getHeight());
                    return Bitmap.createBitmap(imageViewBitmap, rect.left, rect.top, rect.width(), rect.height());
                }
                return null;
            } catch (Exception e2) {
                if (s) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            } catch (OutOfMemoryError e3) {
                if (s) {
                    e3.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void m(ZoomImageView zoomImageView, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, zoomImageView, drawable) == null) || zoomImageView == null || drawable == null) {
            return;
        }
        Matrix imageViewMatrix = zoomImageView.getImageViewMatrix();
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        imageViewMatrix.mapRect(rectF);
        float width = rectF.width();
        float width2 = zoomImageView.getWidth();
        zoomImageView.postTranslate(width > width2 ? ((width2 - width) / 2.0f) - rectF.left : 0.0f, 0.0f);
    }

    public final void n() {
        float f2;
        float f3;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getContext());
            int desiredMinimumWidth = wallpaperManager.getDesiredMinimumWidth();
            int desiredMinimumHeight = wallpaperManager.getDesiredMinimumHeight();
            if (s) {
                String str = "PictureCropView#configureBounds, desiredMinWidth = " + desiredMinimumWidth + ", desiredMinHeight = " + desiredMinimumHeight;
            }
            float f5 = desiredMinimumWidth;
            float f6 = desiredMinimumHeight;
            int width = getWidth();
            float height = getHeight();
            float f7 = width;
            if (f5 * height > f7 * f6) {
                f4 = f7 / f5;
                f2 = (height - (f6 * f4)) * 0.5f;
                f3 = 0.0f;
            } else {
                float f8 = height / f6;
                f2 = 0.0f;
                f3 = (f7 - (f5 * f8)) * 0.5f;
                f4 = f8;
            }
            Matrix matrix = new Matrix();
            matrix.setScale(f4, f4);
            matrix.postTranslate((int) (f3 + 0.5f), (int) (f2 + 0.5f));
            RectF rectF = new RectF(0.0f, 0.0f, f5, f6);
            boolean mapRect = matrix.mapRect(rectF);
            rectF.round(this.o);
            if (s) {
                String str2 = "PictureCropView#configureBounds: calculate the crop size ======  , mCropBoundRect = " + this.o + ", mapRectVal = " + mapRect;
            }
        }
    }

    public final void o(ZoomImageView zoomImageView, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048582, this, zoomImageView, i2, i3) == null) || zoomImageView == null || i2 <= 0 || i3 <= 0) {
            return;
        }
        int width = (zoomImageView.getWidth() - zoomImageView.getPaddingLeft()) - zoomImageView.getPaddingRight();
        int height = (zoomImageView.getHeight() - zoomImageView.getPaddingTop()) - zoomImageView.getPaddingBottom();
        if (!this.o.isEmpty()) {
            width = this.o.width();
            height = this.o.height();
        }
        float f2 = i2 * height > width * i3 ? height / i3 : width / i2;
        if (s) {
            String str = "PictureCropView#configureZoomRange() scale = " + f2;
        }
        if (f2 > 0.0f) {
            zoomImageView.setZoomRange(f2, 3.0f + f2);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            super.onLayout(z, i2, i3, i4, i5);
            if (z) {
                n();
            }
        }
    }

    public final boolean p(RectF rectF, RectF rectF2) {
        InterceptResult invokeLL;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rectF, rectF2)) == null) {
            if (rectF == null) {
                return false;
            }
            Rect rect = this.o;
            int i2 = rect.top;
            int i3 = rect.left;
            int i4 = rect.right;
            int i5 = rect.bottom;
            float f8 = rectF2.left;
            float f9 = rectF2.top;
            float f10 = i2;
            if (rectF.top >= f10 && rectF.bottom <= i5) {
                rectF2.top = f10;
            }
            float f11 = i3;
            if (rectF.left >= f11 && rectF.right <= i4) {
                rectF2.left = f11;
            }
            if (rectF.top + f9 >= f10) {
                rectF2.top = (int) (f10 - f2);
            }
            if (f9 + rectF.bottom <= i5) {
                rectF2.top = (int) (f4 - f3);
            }
            if (rectF.left + f8 >= f11) {
                rectF2.left = (int) (f11 - f5);
            }
            if (f8 + rectF.right <= i4) {
                rectF2.left = (int) (f7 - f6);
                return true;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureCropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.n = null;
        this.o = new Rect();
        this.p = Color.argb(128, 0, 0, 0);
        this.q = new Paint();
        this.r = false;
        f(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureCropView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.n = null;
        this.o = new Rect();
        this.p = Color.argb(128, 0, 0, 0);
        this.q = new Paint();
        this.r = false;
        f(context);
    }
}
