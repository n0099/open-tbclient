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
@TargetApi(8)
/* loaded from: classes3.dex */
public class ZoomImageView extends ImageView implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    public static final float o = 12.0f;
    public static ZoomImageView p;
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

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    public ZoomImageView(Context context) {
        this(context, null);
    }

    public ZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
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

    private void b() {
        Rect rect;
        float f;
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
        if (f2 > f3 && this.l) {
            f = -(f2 - f3);
        } else {
            f = 0.0f;
        }
        float f5 = matrixRectF.bottom;
        float f6 = rect.bottom;
        if (f5 < f6 && this.l) {
            f = f6 - f5;
        }
        float f7 = matrixRectF.left;
        float f8 = rect.left;
        if (f7 > f8 && this.k) {
            f4 = -(f7 - f8);
        }
        float f9 = matrixRectF.right;
        float f10 = rect.right;
        if (f9 < f10 && this.k) {
            f4 = f10 - f9;
        }
        this.e.postTranslate(f4, f);
    }

    public static void c() {
        p = null;
    }

    public static ZoomImageView getInstance() {
        ZoomImageView zoomImageView = p;
        if (zoomImageView != null) {
            return zoomImageView;
        }
        return null;
    }

    public RectF getMatrixRectF() {
        Matrix matrix = this.e;
        RectF rectF = new RectF();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    public final float getScale() {
        this.e.getValues(this.b);
        return this.b[0];
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    public Bitmap a() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        draw(new Canvas(createBitmap));
        if (ClipBoxView.getInstance() != null) {
            Rect rect = ClipBoxView.getInstance().getmFrameRectF();
            return Bitmap.createBitmap(createBitmap, rect.left, rect.top, rect.width(), rect.height());
        }
        return null;
    }

    public void a(float f, float f2) {
        Rect rect;
        float f3;
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
        float f5 = 0.0f;
        if (matrixRectF.width() >= f4) {
            float f6 = matrixRectF.left;
            float f7 = rect.left;
            if (f6 > f7) {
                f3 = -(f6 - f7);
            } else {
                f3 = 0.0f;
            }
            float f8 = matrixRectF.right;
            float f9 = rect.right;
            if (f8 < f9) {
                f3 = f9 - f8;
            }
        } else {
            f3 = 0.0f;
        }
        float f10 = i2;
        if (matrixRectF.height() >= f10) {
            float f11 = matrixRectF.top;
            float f12 = rect.top;
            if (f11 > f12) {
                f5 = -(f11 - f12);
            }
            float f13 = matrixRectF.bottom;
            float f14 = rect.bottom;
            if (f13 < f14) {
                f5 = f14 - f13;
            }
        }
        this.e.postTranslate(f3, f5);
        if (matrixRectF.width() < f4 || matrixRectF.height() < f10) {
            float max = Math.max(f4 / matrixRectF.width(), f10 / matrixRectF.height());
            this.e.postScale(max, max, f, f2);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Drawable drawable;
        float max;
        float height;
        float f;
        if (!this.c || (drawable = getDrawable()) == null) {
            return;
        }
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

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
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

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        if (r11 != 3) goto L14;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view2, MotionEvent motionEvent) {
        Rect rect;
        boolean z;
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
                    if (Math.sqrt((f7 * f7) + (f8 * f8)) >= this.j) {
                        z = true;
                    } else {
                        z = false;
                    }
                    this.i = z;
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
}
