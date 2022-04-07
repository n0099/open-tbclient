package com.baidu.sapi2.views;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@TargetApi(8)
/* loaded from: classes2.dex */
public class ZoomImageView extends ImageView implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final float o = 12.0f;
    public static ZoomImageView p;
    public transient /* synthetic */ FieldHolder $fh;
    public float a;
    public final float[] b;
    public boolean c;
    public ScaleGestureDetector d;
    public final Matrix e;
    public int f;
    public float g;
    public float h;
    public boolean i;
    public double j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZoomImageView(Context context) {
        this(context, null);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    private void b() {
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            RectF matrixRectF = getMatrixRectF();
            ClipBoxView clipBoxView = ClipBoxView.getInstance();
            if (clipBoxView != null) {
                rect = clipBoxView.getmFrameRectF();
            } else {
                rect = new Rect();
            }
            getWidth();
            getHeight();
            float f = matrixRectF.top;
            float f2 = rect.top;
            float f3 = 0.0f;
            float f4 = (f <= f2 || !this.l) ? 0.0f : -(f - f2);
            float f5 = matrixRectF.bottom;
            float f6 = rect.bottom;
            if (f5 < f6 && this.l) {
                f4 = f6 - f5;
            }
            float f7 = matrixRectF.left;
            float f8 = rect.left;
            if (f7 > f8 && this.k) {
                f3 = -(f7 - f8);
            }
            float f9 = matrixRectF.right;
            float f10 = rect.right;
            if (f9 < f10 && this.k) {
                f3 = f10 - f9;
            }
            this.e.postTranslate(f3, f4);
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, null) == null) {
            p = null;
        }
    }

    public static ZoomImageView getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            ZoomImageView zoomImageView = p;
            if (zoomImageView != null) {
                return zoomImageView;
            }
            return null;
        }
        return (ZoomImageView) invokeV.objValue;
    }

    public void a(float f, float f2) {
        Rect rect;
        float f3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f), Float.valueOf(f2)}) == null) {
            RectF matrixRectF = getMatrixRectF();
            ClipBoxView clipBoxView = ClipBoxView.getInstance();
            if (clipBoxView != null) {
                rect = clipBoxView.getmFrameRectF();
            } else {
                rect = new Rect();
            }
            int i = rect.right - rect.left;
            int i2 = rect.bottom - rect.top;
            float f4 = i;
            if (matrixRectF.width() >= f4) {
                float f5 = matrixRectF.left;
                float f6 = rect.left;
                f3 = f5 > f6 ? -(f5 - f6) : 0.0f;
                float f7 = matrixRectF.right;
                float f8 = rect.right;
                if (f7 < f8) {
                    f3 = f8 - f7;
                }
            } else {
                f3 = 0.0f;
            }
            float f9 = i2;
            if (matrixRectF.height() >= f9) {
                float f10 = matrixRectF.top;
                float f11 = rect.top;
                r5 = f10 > f11 ? -(f10 - f11) : 0.0f;
                float f12 = matrixRectF.bottom;
                float f13 = rect.bottom;
                if (f12 < f13) {
                    r5 = f13 - f12;
                }
            }
            this.e.postTranslate(f3, r5);
            if (matrixRectF.width() < f4 || matrixRectF.height() < f9) {
                float max = Math.max(f4 / matrixRectF.width(), f9 / matrixRectF.height());
                this.e.postScale(max, max, f, f2);
            }
        }
    }

    public RectF getMatrixRectF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Matrix matrix = this.e;
            RectF rectF = new RectF();
            Drawable drawable = getDrawable();
            if (drawable != null) {
                rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                matrix.mapRect(rectF);
            }
            return rectF;
        }
        return (RectF) invokeV.objValue;
    }

    public final float getScale() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            this.e.getValues(this.b);
            return this.b[0];
        }
        return invokeV.floatValue;
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            getViewTreeObserver().addOnGlobalLayoutListener(this);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Drawable drawable;
        float max;
        float height;
        float f;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.c && (drawable = getDrawable()) != null) {
            this.m = (int) TypedValue.applyDimension(1, this.m, getResources().getDisplayMetrics());
            this.n = (getHeight() - (getWidth() - (this.m * 2))) / 2;
            int width = getWidth();
            int height2 = getHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth < getWidth() - (this.m * 2) && intrinsicHeight > getHeight() - (this.n * 2)) {
                height = (getWidth() * 1.0f) - (this.m * 2);
                f = intrinsicWidth;
            } else if (intrinsicHeight < getHeight() - (this.n * 2) && intrinsicWidth > getWidth() - (this.m * 2)) {
                height = (getHeight() * 1.0f) - (this.n * 2);
                f = intrinsicHeight;
            } else {
                max = Math.max(((getWidth() * 1.0f) - (this.m * 2)) / intrinsicWidth, ((getHeight() * 1.0f) - (this.n * 2)) / intrinsicHeight);
                this.a = max;
                this.e.postTranslate((width - intrinsicWidth) / 2, (height2 - intrinsicHeight) / 2);
                this.e.postScale(max, max, width / 2, height2 / 2);
                setImageMatrix(this.e);
                this.c = false;
            }
            max = height / f;
            this.a = max;
            this.e.postTranslate((width - intrinsicWidth) / 2, (height2 - intrinsicHeight) / 2);
            this.e.postScale(max, max, width / 2, height2 / 2);
            setImageMatrix(this.e);
            this.c = false;
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, scaleGestureDetector)) == null) {
            float scale = getScale();
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (getDrawable() == null) {
                return true;
            }
            if ((scale < 12.0f && scaleFactor > 1.0f) || scaleFactor < 1.0f) {
                if (scaleFactor * scale > 12.0f) {
                    scaleFactor = 12.0f / scale;
                }
                this.e.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                a(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                setImageMatrix(this.e);
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, scaleGestureDetector)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, scaleGestureDetector) == null) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003b, code lost:
        if (r11 != 3) goto L16;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, view2, motionEvent)) == null) {
            this.d.onTouchEvent(motionEvent);
            int pointerCount = motionEvent.getPointerCount();
            float f = 0.0f;
            float f2 = 0.0f;
            float f3 = 0.0f;
            for (int i = 0; i < pointerCount; i++) {
                f3 += motionEvent.getX(i);
                f2 += motionEvent.getY(i);
            }
            float f4 = pointerCount;
            float f5 = f3 / f4;
            float f6 = f2 / f4;
            if (pointerCount != this.f) {
                this.i = false;
                this.g = f5;
                this.h = f6;
            }
            this.f = pointerCount;
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    float f7 = f5 - this.g;
                    float f8 = f6 - this.h;
                    if (!this.i) {
                        this.i = Math.sqrt((double) ((f7 * f7) + (f8 * f8))) >= this.j;
                    }
                    if (this.i) {
                        RectF matrixRectF = getMatrixRectF();
                        if (getDrawable() != null) {
                            this.k = true;
                            this.l = true;
                            ClipBoxView clipBoxView = ClipBoxView.getInstance();
                            if (clipBoxView != null) {
                                rect = clipBoxView.getmFrameRectF();
                            } else {
                                rect = new Rect();
                            }
                            if (matrixRectF.width() < rect.right - rect.left) {
                                this.k = false;
                                f7 = 0.0f;
                            }
                            if (matrixRectF.height() < rect.bottom - rect.top) {
                                this.l = false;
                            } else {
                                f = f8;
                            }
                            this.e.postTranslate(f7, f);
                            b();
                            setImageMatrix(this.e);
                        }
                    }
                    this.g = f5;
                    this.h = f6;
                }
                return true;
            }
            this.f = 0;
            return true;
        }
        return invokeLL.booleanValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = 1.0f;
        this.b = new float[9];
        this.c = true;
        this.e = new Matrix();
        this.f = 0;
        this.g = 0.0f;
        this.h = 0.0f;
        this.m = 22;
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.d = new ScaleGestureDetector(context, this);
        this.j = ViewConfiguration.get(context).getScaledTouchSlop();
        setOnTouchListener(this);
        if (p == null) {
            p = this;
        }
    }

    public Bitmap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            draw(new Canvas(createBitmap));
            if (ClipBoxView.getInstance() != null) {
                Rect rect = ClipBoxView.getInstance().getmFrameRectF();
                return Bitmap.createBitmap(createBitmap, rect.left, rect.top, rect.width(), rect.height());
            }
            return null;
        }
        return (Bitmap) invokeV.objValue;
    }
}
