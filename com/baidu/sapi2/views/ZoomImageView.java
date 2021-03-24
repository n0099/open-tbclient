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
/* loaded from: classes2.dex */
public class ZoomImageView extends ImageView implements ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener, ViewTreeObserver.OnGlobalLayoutListener {
    public static final float o = 12.0f;
    public static ZoomImageView p;

    /* renamed from: a  reason: collision with root package name */
    public float f11584a;

    /* renamed from: b  reason: collision with root package name */
    public final float[] f11585b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f11586c;

    /* renamed from: d  reason: collision with root package name */
    public ScaleGestureDetector f11587d;

    /* renamed from: e  reason: collision with root package name */
    public final Matrix f11588e;

    /* renamed from: f  reason: collision with root package name */
    public int f11589f;

    /* renamed from: g  reason: collision with root package name */
    public float f11590g;

    /* renamed from: h  reason: collision with root package name */
    public float f11591h;
    public boolean i;
    public double j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;

    public ZoomImageView(Context context) {
        this(context, null);
    }

    private void b() {
        Rect rect;
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
        this.f11588e.postTranslate(f4, f5);
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

    public void a(float f2, float f3) {
        Rect rect;
        float f4;
        RectF matrixRectF = getMatrixRectF();
        ClipBoxView clipBoxView = ClipBoxView.getInstance();
        if (clipBoxView != null) {
            rect = clipBoxView.getmFrameRectF();
        } else {
            rect = new Rect();
        }
        int i = rect.right - rect.left;
        int i2 = rect.bottom - rect.top;
        float f5 = i;
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
        float f10 = i2;
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
        this.f11588e.postTranslate(f4, r5);
        if (matrixRectF.width() < f5 || matrixRectF.height() < f10) {
            float max = Math.max(f5 / matrixRectF.width(), f10 / matrixRectF.height());
            this.f11588e.postScale(max, max, f2, f3);
        }
    }

    public RectF getMatrixRectF() {
        Matrix matrix = this.f11588e;
        RectF rectF = new RectF();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(rectF);
        }
        return rectF;
    }

    public final float getScale() {
        this.f11588e.getValues(this.f11585b);
        return this.f11585b[0];
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

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Drawable drawable;
        float max;
        float height;
        float f2;
        if (!this.f11586c || (drawable = getDrawable()) == null) {
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
            f2 = intrinsicWidth;
        } else if (intrinsicHeight < getHeight() - (this.n * 2) && intrinsicWidth > getWidth() - (this.m * 2)) {
            height = (getHeight() * 1.0f) - (this.n * 2);
            f2 = intrinsicHeight;
        } else {
            max = Math.max(((getWidth() * 1.0f) - (this.m * 2)) / intrinsicWidth, ((getHeight() * 1.0f) - (this.n * 2)) / intrinsicHeight);
            this.f11584a = max;
            this.f11588e.postTranslate((width - intrinsicWidth) / 2, (height2 - intrinsicHeight) / 2);
            this.f11588e.postScale(max, max, width / 2, height2 / 2);
            setImageMatrix(this.f11588e);
            this.f11586c = false;
        }
        max = height / f2;
        this.f11584a = max;
        this.f11588e.postTranslate((width - intrinsicWidth) / 2, (height2 - intrinsicHeight) / 2);
        this.f11588e.postScale(max, max, width / 2, height2 / 2);
        setImageMatrix(this.f11588e);
        this.f11586c = false;
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
            this.f11588e.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            a(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            setImageMatrix(this.f11588e);
        }
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
        if (r11 != 3) goto L14;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Rect rect;
        this.f11587d.onTouchEvent(motionEvent);
        int pointerCount = motionEvent.getPointerCount();
        float f2 = 0.0f;
        float f3 = 0.0f;
        float f4 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            f4 += motionEvent.getX(i);
            f3 += motionEvent.getY(i);
        }
        float f5 = pointerCount;
        float f6 = f4 / f5;
        float f7 = f3 / f5;
        if (pointerCount != this.f11589f) {
            this.i = false;
            this.f11590g = f6;
            this.f11591h = f7;
        }
        this.f11589f = pointerCount;
        int action = motionEvent.getAction();
        if (action != 1) {
            if (action == 2) {
                float f8 = f6 - this.f11590g;
                float f9 = f7 - this.f11591h;
                if (!this.i) {
                    this.i = Math.sqrt((double) ((f8 * f8) + (f9 * f9))) >= this.j;
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
                            f8 = 0.0f;
                        }
                        if (matrixRectF.height() < rect.bottom - rect.top) {
                            this.l = false;
                        } else {
                            f2 = f9;
                        }
                        this.f11588e.postTranslate(f8, f2);
                        b();
                        setImageMatrix(this.f11588e);
                    }
                }
                this.f11590g = f6;
                this.f11591h = f7;
            }
            return true;
        }
        this.f11589f = 0;
        return true;
    }

    public ZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11584a = 1.0f;
        this.f11585b = new float[9];
        this.f11586c = true;
        this.f11588e = new Matrix();
        this.f11589f = 0;
        this.f11590g = 0.0f;
        this.f11591h = 0.0f;
        this.m = 22;
        super.setScaleType(ImageView.ScaleType.MATRIX);
        this.f11587d = new ScaleGestureDetector(context, this);
        this.j = ViewConfiguration.get(context).getScaledTouchSlop();
        setOnTouchListener(this);
        if (p == null) {
            p = this;
        }
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
}
