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
import android.util.Log;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.facade.picture.widget.BdImageViewTouchBase;
import com.baidu.swan.facade.picture.widget.ZoomImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rg1;
/* loaded from: classes2.dex */
public class PictureCropView extends PictureView {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean o;
    public transient /* synthetic */ FieldHolder $fh;
    public Drawable j;
    public final Rect k;
    public int l;
    public Paint m;
    public boolean n;

    /* loaded from: classes2.dex */
    public class a implements ZoomImageView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ZoomImageView a;
        public final /* synthetic */ PictureCropView b;

        public a(PictureCropView pictureCropView, ZoomImageView zoomImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pictureCropView, zoomImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pictureCropView;
            this.a = zoomImageView;
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.a
        public void a(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
                this.b.n = drawable != null;
                if (drawable != null) {
                    this.b.q(this.a, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                }
            }
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.a
        public void b(Bitmap bitmap) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bitmap) == null) {
                this.b.n = bitmap != null;
                if (bitmap != null) {
                    this.b.q(this.a, bitmap.getWidth(), bitmap.getHeight());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements BdImageViewTouchBase.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ZoomImageView a;
        public final /* synthetic */ PictureCropView b;

        public b(PictureCropView pictureCropView, ZoomImageView zoomImageView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pictureCropView, zoomImageView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pictureCropView;
            this.a = zoomImageView;
        }

        @Override // com.baidu.swan.facade.picture.widget.BdImageViewTouchBase.f
        public void a(Drawable drawable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, drawable) == null) {
                this.b.o(this.a, drawable);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ZoomImageView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public RectF a;
        public final /* synthetic */ PictureCropView b;

        public c(PictureCropView pictureCropView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pictureCropView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = pictureCropView;
            this.a = new RectF();
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.b
        public boolean a(ZoomImageView zoomImageView, double d, double d2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{zoomImageView, Double.valueOf(d), Double.valueOf(d2)})) == null) {
                RectF bitmapRect = zoomImageView.getBitmapRect();
                this.a.set((float) d, (float) d2, 0.0f, 0.0f);
                this.b.t(bitmapRect, this.a);
                RectF rectF = this.a;
                zoomImageView.v(rectF.left, rectF.top);
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.b
        public boolean b(ZoomImageView zoomImageView, MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{zoomImageView, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
                zoomImageView.w(-f, -f2);
                zoomImageView.invalidate();
                return true;
            }
            return invokeCommon.booleanValue;
        }

        @Override // com.baidu.swan.facade.picture.widget.ZoomImageView.b
        public boolean c(ZoomImageView zoomImageView, MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{zoomImageView, motionEvent, motionEvent2, Float.valueOf(f), Float.valueOf(f2)})) == null) {
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
        o = rg1.a;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.j = null;
        this.k = new Rect();
        this.l = Color.argb(128, 0, 0, 0);
        this.m = new Paint();
        this.n = false;
        g(context);
    }

    private void g(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context) == null) {
            this.m.setColor(this.l);
            this.m.setStyle(Paint.Style.FILL);
            this.j = context.getResources().getDrawable(R.drawable.obfuscated_res_0x7f0810c4);
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
            r(canvas);
        }
    }

    public Bitmap getCroppedImage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            Bitmap imageViewBitmap = getImageViewBitmap();
            if (imageViewBitmap == null) {
                return null;
            }
            try {
                ZoomImageView zoomImageView = (ZoomImageView) getImageView();
                RectF rectF = new RectF(this.k);
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
            } catch (Exception e) {
                if (o) {
                    e.printStackTrace();
                    return null;
                }
                return null;
            } catch (OutOfMemoryError e2) {
                if (o) {
                    e2.printStackTrace();
                    return null;
                }
                return null;
            }
        }
        return (Bitmap) invokeV.objValue;
    }

    public final void o(ZoomImageView zoomImageView, Drawable drawable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, zoomImageView, drawable) == null) || zoomImageView == null || drawable == null) {
            return;
        }
        Matrix imageViewMatrix = zoomImageView.getImageViewMatrix();
        RectF rectF = new RectF();
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        imageViewMatrix.mapRect(rectF);
        float width = rectF.width();
        float width2 = zoomImageView.getWidth();
        zoomImageView.v(width > width2 ? ((width2 - width) / 2.0f) - rectF.left : 0.0f, 0.0f);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                p();
            }
        }
    }

    public final void p() {
        float f;
        float f2;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            WallpaperManager wallpaperManager = WallpaperManager.getInstance(getContext());
            int desiredMinimumWidth = wallpaperManager.getDesiredMinimumWidth();
            int desiredMinimumHeight = wallpaperManager.getDesiredMinimumHeight();
            if (o) {
                Log.d("PictureCropView", "PictureCropView#configureBounds, desiredMinWidth = " + desiredMinimumWidth + ", desiredMinHeight = " + desiredMinimumHeight);
            }
            float f4 = desiredMinimumWidth;
            float f5 = desiredMinimumHeight;
            int width = getWidth();
            float height = getHeight();
            float f6 = width;
            if (f4 * height > f6 * f5) {
                f3 = f6 / f4;
                f = (height - (f5 * f3)) * 0.5f;
                f2 = 0.0f;
            } else {
                float f7 = height / f5;
                f = 0.0f;
                f2 = (f6 - (f4 * f7)) * 0.5f;
                f3 = f7;
            }
            Matrix matrix = new Matrix();
            matrix.setScale(f3, f3);
            matrix.postTranslate((int) (f2 + 0.5f), (int) (f + 0.5f));
            RectF rectF = new RectF(0.0f, 0.0f, f4, f5);
            boolean mapRect = matrix.mapRect(rectF);
            rectF.round(this.k);
            if (o) {
                Log.d("PictureCropView", "PictureCropView#configureBounds: calculate the crop size ======  , mCropBoundRect = " + this.k + ", mapRectVal = " + mapRect);
            }
        }
    }

    public final void q(ZoomImageView zoomImageView, int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLII(1048581, this, zoomImageView, i, i2) == null) || zoomImageView == null || i <= 0 || i2 <= 0) {
            return;
        }
        int width = (zoomImageView.getWidth() - zoomImageView.getPaddingLeft()) - zoomImageView.getPaddingRight();
        int height = (zoomImageView.getHeight() - zoomImageView.getPaddingTop()) - zoomImageView.getPaddingBottom();
        if (!this.k.isEmpty()) {
            width = this.k.width();
            height = this.k.height();
        }
        float f = i * height > width * i2 ? height / i2 : width / i;
        if (o) {
            Log.d("PictureCropView", "PictureCropView#configureZoomRange() scale = " + f);
        }
        if (f > 0.0f) {
            zoomImageView.setZoomRange(f, 3.0f + f);
        }
    }

    public void r(Canvas canvas) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, canvas) == null) && this.n) {
            s(canvas, this.k);
            if (this.j == null || this.k.isEmpty()) {
                return;
            }
            this.j.setBounds(this.k);
            this.j.draw(canvas);
        }
    }

    public void s(Canvas canvas, Rect rect) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, canvas, rect) == null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            Paint paint = this.m;
            float f = width;
            canvas.drawRect(0.0f, 0.0f, f, rect.top, paint);
            float f2 = height;
            canvas.drawRect(0.0f, rect.top, rect.left, f2, paint);
            canvas.drawRect(rect.left, rect.bottom, f, f2, paint);
            canvas.drawRect(rect.right, rect.top, f, rect.bottom, paint);
        }
    }

    public final boolean t(RectF rectF, RectF rectF2) {
        InterceptResult invokeLL;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, rectF, rectF2)) == null) {
            if (rectF == null) {
                return false;
            }
            Rect rect = this.k;
            int i = rect.top;
            int i2 = rect.left;
            int i3 = rect.right;
            int i4 = rect.bottom;
            float f7 = rectF2.left;
            float f8 = rectF2.top;
            float f9 = i;
            if (rectF.top >= f9 && rectF.bottom <= i4) {
                rectF2.top = f9;
            }
            float f10 = i2;
            if (rectF.left >= f10 && rectF.right <= i3) {
                rectF2.left = f10;
            }
            if (rectF.top + f8 >= f9) {
                rectF2.top = (int) (f9 - f);
            }
            if (f8 + rectF.bottom <= i4) {
                rectF2.top = (int) (f3 - f2);
            }
            if (rectF.left + f7 >= f10) {
                rectF2.left = (int) (f10 - f4);
            }
            if (f7 + rectF.right <= i3) {
                rectF2.left = (int) (f6 - f5);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.j = null;
        this.k = new Rect();
        this.l = Color.argb(128, 0, 0, 0);
        this.m = new Paint();
        this.n = false;
        g(context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PictureCropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet, Integer.valueOf(i)};
            interceptable.invokeUnInit(65539, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65539, newInitContext);
                return;
            }
        }
        this.j = null;
        this.k = new Rect();
        this.l = Color.argb(128, 0, 0, 0);
        this.m = new Paint();
        this.n = false;
        g(context);
    }
}
