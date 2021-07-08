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

    /* renamed from: a  reason: collision with root package name */
    public float f10074a;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f10075b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f10076c;

    /* renamed from: d  reason: collision with root package name */
    public ScaleGestureDetector f10077d;

    /* renamed from: e  reason: collision with root package name */
    public final Matrix f10078e;

    /* renamed from: f  reason: collision with root package name */
    public int f10079f;

    /* renamed from: g  reason: collision with root package name */
    public float f10080g;

    /* renamed from: h  reason: collision with root package name */
    public float f10081h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f10082i;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            float f2 = matrixRectF.top;
            float f3 = rect.top;
            float f4 = 0.0f;
            float f5 = (f2 <= f3 || !this.l) ? 0.0f : -(f2 - f3);
            float f6 = matrixRectF.bottom;
            float f7 = rect.bottom;
            if (f6 < f7 && this.l) {
                f5 = f7 - f6;
            }
            float f8 = matrixRectF.left;
            float f9 = rect.left;
            if (f8 > f9 && this.k) {
                f4 = -(f8 - f9);
            }
            float f10 = matrixRectF.right;
            float f11 = rect.right;
            if (f10 < f11 && this.k) {
                f4 = f11 - f10;
            }
            this.f10078e.postTranslate(f4, f5);
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

    public void a(float f2, float f3) {
        Rect rect;
        float f4;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Float.valueOf(f2), Float.valueOf(f3)}) == null) {
            RectF matrixRectF = getMatrixRectF();
            ClipBoxView clipBoxView = ClipBoxView.getInstance();
            if (clipBoxView != null) {
                rect = clipBoxView.getmFrameRectF();
            } else {
                rect = new Rect();
            }
            int i2 = rect.right - rect.left;
            int i3 = rect.bottom - rect.top;
            float f5 = i2;
            if (matrixRectF.width() >= f5) {
                float f6 = matrixRectF.left;
                float f7 = rect.left;
                f4 = f6 > f7 ? -(f6 - f7) : 0.0f;
                float f8 = matrixRectF.right;
                float f9 = rect.right;
                if (f8 < f9) {
                    f4 = f9 - f8;
                }
            } else {
                f4 = 0.0f;
            }
            float f10 = i3;
            if (matrixRectF.height() >= f10) {
                float f11 = matrixRectF.top;
                float f12 = rect.top;
                r5 = f11 > f12 ? -(f11 - f12) : 0.0f;
                float f13 = matrixRectF.bottom;
                float f14 = rect.bottom;
                if (f13 < f14) {
                    r5 = f14 - f13;
                }
            }
            this.f10078e.postTranslate(f4, r5);
            if (matrixRectF.width() < f5 || matrixRectF.height() < f10) {
                float max = Math.max(f5 / matrixRectF.width(), f10 / matrixRectF.height());
                this.f10078e.postScale(max, max, f2, f3);
            }
        }
    }

    public RectF getMatrixRectF() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            Matrix matrix = this.f10078e;
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
            this.f10078e.getValues(this.f10075b);
            return this.f10075b[0];
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
        float f2;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.f10076c && (drawable = getDrawable()) != null) {
            this.m = (int) TypedValue.applyDimension(1, this.m, getResources().getDisplayMetrics());
            this.n = (getHeight() - (getWidth() - (this.m * 2))) / 2;
            int width = getWidth();
            int height2 = getHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth < getWidth() - (this.m * 2) && intrinsicHeight > getHeight() - (this.n * 2)) {
                height = (getWidth() * 1.0f) - (this.m * 2);
                f2 = intrinsicWidth;
            } else if (intrinsicHeight < getHeight() - (this.n * 2) && intrinsicWidth > getWidth() - (this.m * 2)) {
                height = (getHeight() * 1.0f) - (this.n * 2);
                f2 = intrinsicHeight;
            } else {
                max = Math.max(((getWidth() * 1.0f) - (this.m * 2)) / intrinsicWidth, ((getHeight() * 1.0f) - (this.n * 2)) / intrinsicHeight);
                this.f10074a = max;
                this.f10078e.postTranslate((width - intrinsicWidth) / 2, (height2 - intrinsicHeight) / 2);
                this.f10078e.postScale(max, max, width / 2, height2 / 2);
                setImageMatrix(this.f10078e);
                this.f10076c = false;
            }
            max = height / f2;
            this.f10074a = max;
            this.f10078e.postTranslate((width - intrinsicWidth) / 2, (height2 - intrinsicHeight) / 2);
            this.f10078e.postScale(max, max, width / 2, height2 / 2);
            setImageMatrix(this.f10078e);
            this.f10076c = false;
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
                this.f10078e.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                a(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                setImageMatrix(this.f10078e);
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
    public boolean onTouch(View view, MotionEvent motionEvent) {
        InterceptResult invokeLL;
        Rect rect;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048586, this, view, motionEvent)) == null) {
            this.f10077d.onTouchEvent(motionEvent);
            int pointerCount = motionEvent.getPointerCount();
            float f2 = 0.0f;
            float f3 = 0.0f;
            float f4 = 0.0f;
            for (int i2 = 0; i2 < pointerCount; i2++) {
                f4 += motionEvent.getX(i2);
                f3 += motionEvent.getY(i2);
            }
            float f5 = pointerCount;
            float f6 = f4 / f5;
            float f7 = f3 / f5;
            if (pointerCount != this.f10079f) {
                this.f10082i = false;
                this.f10080g = f6;
                this.f10081h = f7;
            }
            this.f10079f = pointerCount;
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    float f8 = f6 - this.f10080g;
                    float f9 = f7 - this.f10081h;
                    if (!this.f10082i) {
                        this.f10082i = Math.sqrt((double) ((f8 * f8) + (f9 * f9))) >= this.j;
                    }
                    if (this.f10082i) {
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
                                f8 = 0.0f;
                            }
                            if (matrixRectF.height() < rect.bottom - rect.top) {
                                this.l = false;
                            } else {
                                f2 = f9;
                            }
                            this.f10078e.postTranslate(f8, f2);
                            b();
                            setImageMatrix(this.f10078e);
                        }
                    }
                    this.f10080g = f6;
                    this.f10081h = f7;
                }
                return true;
            }
            this.f10079f = 0;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f10074a = 1.0f;
        this.f10075b = new float[9];
        this.f10076c = true;
        this.f10078e = new Matrix();
        this.f10079f = 0;
        this.f10080g = 0.0f;
        this.f10081h = 0.0f;
        this.m = 22;
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.f10077d = new ScaleGestureDetector(context, this);
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
