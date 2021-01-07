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
    private static ZoomImageView p;

    /* renamed from: a  reason: collision with root package name */
    public float f5444a;

    /* renamed from: b  reason: collision with root package name */
    private final float[] f5445b;
    private boolean c;
    private ScaleGestureDetector d;
    public final Matrix e;
    private int f;
    private float g;
    private float h;
    private boolean i;
    private double j;
    private boolean k;
    private boolean l;
    private int m;
    private int n;

    public ZoomImageView(Context context) {
        this(context, null);
    }

    private void b() {
        Rect rect;
        float f = 0.0f;
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
        int i = rect.top;
        float f3 = (f2 <= ((float) i) || !this.l) ? 0.0f : -(f2 - i);
        float f4 = matrixRectF.bottom;
        int i2 = rect.bottom;
        if (f4 < i2 && this.l) {
            f3 = i2 - f4;
        }
        float f5 = matrixRectF.left;
        int i3 = rect.left;
        if (f5 > i3 && this.k) {
            f = -(f5 - i3);
        }
        float f6 = matrixRectF.right;
        int i4 = rect.right;
        if (f6 < i4 && this.k) {
            f = i4 - f6;
        }
        this.e.postTranslate(f, f3);
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
        if (matrixRectF.width() >= f4) {
            float f5 = matrixRectF.left;
            int i3 = rect.left;
            f3 = f5 > ((float) i3) ? -(f5 - i3) : 0.0f;
            float f6 = matrixRectF.right;
            int i4 = rect.right;
            if (f6 < i4) {
                f3 = i4 - f6;
            }
        } else {
            f3 = 0.0f;
        }
        float f7 = i2;
        if (matrixRectF.height() >= f7) {
            float f8 = matrixRectF.top;
            int i5 = rect.top;
            r2 = f8 > ((float) i5) ? -(f8 - i5) : 0.0f;
            float f9 = matrixRectF.bottom;
            int i6 = rect.bottom;
            if (f9 < i6) {
                r2 = i6 - f9;
            }
        }
        this.e.postTranslate(f3, r2);
        if (matrixRectF.width() < f4 || matrixRectF.height() < f7) {
            float max = Math.max(f4 / matrixRectF.width(), f7 / matrixRectF.height());
            this.e.postScale(max, max, f, f2);
        }
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
        this.e.getValues(this.f5445b);
        return this.f5445b[0];
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        Drawable drawable;
        float max;
        if (this.c && (drawable = getDrawable()) != null) {
            this.m = (int) TypedValue.applyDimension(1, this.m, getResources().getDisplayMetrics());
            this.n = (getHeight() - (getWidth() - (this.m * 2))) / 2;
            int width = getWidth();
            int height = getHeight();
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth < getWidth() - (this.m * 2) && intrinsicHeight > getHeight() - (this.n * 2)) {
                max = ((getWidth() * 1.0f) - (this.m * 2)) / intrinsicWidth;
            } else if (intrinsicHeight < getHeight() - (this.n * 2) && intrinsicWidth > getWidth() - (this.m * 2)) {
                max = ((getHeight() * 1.0f) - (this.n * 2)) / intrinsicHeight;
            } else {
                max = Math.max(((getWidth() * 1.0f) - (this.m * 2)) / intrinsicWidth, ((getHeight() * 1.0f) - (this.n * 2)) / intrinsicHeight);
            }
            this.f5444a = max;
            this.e.postTranslate((width - intrinsicWidth) / 2, (height - intrinsicHeight) / 2);
            this.e.postScale(max, max, width / 2, height / 2);
            setImageMatrix(this.e);
            this.c = false;
        }
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scale = getScale();
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        if (getDrawable() != null && ((scale < 12.0f && scaleFactor > 1.0f) || scaleFactor < 1.0f)) {
            if (scaleFactor * scale > 12.0f) {
                scaleFactor = 12.0f / scale;
            }
            this.e.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            a(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            setImageMatrix(this.e);
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

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Rect rect;
        float f;
        this.d.onTouchEvent(motionEvent);
        float f2 = 0.0f;
        float f3 = 0.0f;
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            f2 += motionEvent.getX(i);
            f3 += motionEvent.getY(i);
        }
        float f4 = pointerCount;
        float f5 = f2 / f4;
        float f6 = f3 / f4;
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
                            f7 = 0.0f;
                            this.k = false;
                        }
                        if (matrixRectF.height() < rect.bottom - rect.top) {
                            f = 0.0f;
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
                return true;
            } else if (action != 3) {
                return true;
            }
        }
        this.f = 0;
        return true;
    }

    public ZoomImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5444a = 1.0f;
        this.f5445b = new float[9];
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
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        draw(new Canvas(createBitmap));
        if (ClipBoxView.getInstance() != null) {
            Rect rect = ClipBoxView.getInstance().getmFrameRectF();
            return Bitmap.createBitmap(createBitmap, rect.left, rect.top, rect.width(), rect.height());
        }
        return null;
    }
}
