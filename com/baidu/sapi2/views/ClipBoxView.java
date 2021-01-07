package com.baidu.sapi2.views;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes3.dex */
public class ClipBoxView extends View {
    public static int G = 0;
    public static int H = 1;
    private static final int I = 1;
    private static final int J = 20;
    private static final int K = 4;
    private static final int L = -1;
    private static final int M = 1;
    private static final int N = 2;
    private static final int O = 3;
    private static final int P = 4;
    private static final int Q = 5;
    private static final int R = 6;
    private static final int S = 7;
    private static final int T = 8;
    private static final float U = 50.0f;
    private static final float V = 50.0f;
    private static final float W = 1.01f;
    private static final float a0 = 0.99f;
    private static ClipBoxView b0;
    private float A;
    private float B;
    private float C;
    public boolean D;
    public int E;
    public boolean F;

    /* renamed from: a  reason: collision with root package name */
    private Paint f5426a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f5427b;
    private int c;
    private int d;
    private RectF e;
    private RectF f;
    private float g;
    private float h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private float n;
    private ValueAnimator o;
    private float p;
    private float q;
    private float r;
    private float s;
    private boolean t;
    private float u;
    private float v;
    private float w;
    private float x;
    private float y;
    private float z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClipBoxView.this.n = Float.parseFloat(String.valueOf(valueAnimator.getAnimatedValue()));
            ClipBoxView.this.invalidate();
            ClipBoxView.this.c();
        }
    }

    public ClipBoxView(Context context) {
        this(context, null);
    }

    public static void b() {
        b0 = null;
    }

    private boolean c(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        switch (this.l) {
            case 1:
                float x = motionEvent.getX() - this.e.left;
                float y = motionEvent.getY();
                RectF rectF = this.e;
                float f = rectF.top;
                float f2 = (x + (y - f)) / 2.0f;
                b(rectF.left + f2, f2 + f, rectF.right, rectF.bottom);
                return true;
            case 2:
                float x2 = this.e.right - motionEvent.getX();
                float y2 = motionEvent.getY();
                RectF rectF2 = this.e;
                float f3 = rectF2.top;
                float f4 = (x2 + (y2 - f3)) / 2.0f;
                b(rectF2.left, f3 + f4, rectF2.right - f4, rectF2.bottom);
                return true;
            case 3:
                float x3 = motionEvent.getX();
                RectF rectF3 = this.e;
                float y3 = ((x3 - rectF3.left) + (rectF3.bottom - motionEvent.getY())) / 2.0f;
                RectF rectF4 = this.e;
                b(rectF4.left + y3, rectF4.top, rectF4.right, rectF4.bottom - y3);
                return true;
            case 4:
                float x4 = ((this.e.right - motionEvent.getX()) + (this.e.bottom - motionEvent.getY())) / 2.0f;
                RectF rectF5 = this.e;
                b(rectF5.left, rectF5.top, rectF5.right - x4, rectF5.bottom - x4);
                return true;
            default:
                return false;
        }
    }

    @TargetApi(11)
    private void d() {
        setLayerType(1, null);
        this.f5426a = new Paint();
        this.f5427b = new Paint();
        this.f5426a.setColor(-1);
        this.f5426a.setStyle(Paint.Style.STROKE);
        this.f5426a.setStrokeWidth(SapiUtils.dip2px(getContext(), 1.0f));
        this.f5426a.setAntiAlias(true);
        this.f5427b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f5427b.setAntiAlias(true);
        this.c = SapiUtils.dip2px(getContext(), 20.0f);
        this.d = SapiUtils.dip2px(getContext(), 4.0f);
        this.i = SapiUtils.dip2px(getContext(), this.i);
        this.k = SapiUtils.dip2px(getContext(), this.k);
        this.m = SapiUtils.dip2px(getContext(), this.m);
        this.e = new RectF();
        this.f = new RectF();
        this.E = H;
        this.F = true;
        this.o = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.o.setInterpolator(new LinearInterpolator());
        this.o.addUpdateListener(new a());
    }

    public static ClipBoxView getInstance() {
        ClipBoxView clipBoxView = b0;
        if (clipBoxView != null) {
            return clipBoxView;
        }
        return null;
    }

    public Rect getmFrameRectF() {
        Rect rect = new Rect();
        RectF rectF = this.e;
        rect.left = (int) rectF.left;
        rect.right = (int) rectF.right;
        rect.top = (int) rectF.top;
        rect.bottom = (int) rectF.bottom;
        return rect;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int argb = Color.argb(180, 0, 0, 0);
        this.f5426a.setStrokeWidth(SapiUtils.dip2px(getContext(), 1.0f));
        canvas.drawColor(argb);
        b(canvas);
        if (this.n == 1.0f) {
            this.t = false;
            this.D = false;
            this.n = 0.0f;
        }
        canvas.drawRect(this.e, this.f5427b);
        if (this.D) {
            a(canvas);
        }
        c(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = this.i;
        this.j = (i2 - (i - (i5 * 2))) / 2;
        RectF rectF = this.e;
        rectF.left = i5;
        rectF.top = this.j;
        rectF.right = rectF.left + (i - (i5 * 2));
        rectF.bottom = (i - (i5 * 2)) + rectF.top;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.D = true;
                this.f.set(motionEvent.getX() - this.c, motionEvent.getY() - this.c, motionEvent.getX() + this.c, motionEvent.getY() + this.c);
                RectF rectF = this.f;
                RectF rectF2 = this.e;
                if (rectF.contains(rectF2.left, rectF2.top)) {
                    this.l = 1;
                    return true;
                }
                RectF rectF3 = this.f;
                RectF rectF4 = this.e;
                if (rectF3.contains(rectF4.right, rectF4.top)) {
                    this.l = 2;
                    return true;
                }
                RectF rectF5 = this.f;
                RectF rectF6 = this.e;
                if (rectF5.contains(rectF6.left, rectF6.bottom)) {
                    this.l = 3;
                    return true;
                }
                RectF rectF7 = this.f;
                RectF rectF8 = this.e;
                if (rectF7.contains(rectF8.right, rectF8.bottom)) {
                    this.l = 4;
                    return true;
                }
                RectF rectF9 = this.f;
                RectF rectF10 = this.e;
                float f = rectF10.left;
                float f2 = rectF10.top;
                if (rectF9.intersect(f, f2, rectF10.right, f2)) {
                    this.l = 5;
                    return true;
                }
                RectF rectF11 = this.f;
                RectF rectF12 = this.e;
                float f3 = rectF12.left;
                if (rectF11.intersect(f3, rectF12.top, f3, rectF12.bottom)) {
                    this.l = 6;
                    return true;
                }
                RectF rectF13 = this.f;
                RectF rectF14 = this.e;
                float f4 = rectF14.right;
                if (rectF13.intersect(f4, rectF14.top, f4, rectF14.bottom)) {
                    this.l = 7;
                    return true;
                }
                RectF rectF15 = this.f;
                RectF rectF16 = this.e;
                float f5 = rectF16.left;
                float f6 = rectF16.bottom;
                if (rectF15.intersect(f5, f6, rectF16.right, f6)) {
                    this.l = 8;
                    return true;
                }
                return false;
            case 1:
            case 3:
                int i = this.l;
                if (i >= 1 && i <= 4 && this.F) {
                    a();
                } else {
                    this.D = false;
                    invalidate();
                }
                this.l = -1;
                break;
            case 2:
                if (this.E == G) {
                    return b(motionEvent);
                }
                return c(motionEvent);
        }
        return false;
    }

    public ClipBoxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private boolean b(MotionEvent motionEvent) {
        switch (this.l) {
            case 1:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                RectF rectF = this.e;
                b(x, y, rectF.right, rectF.bottom);
                break;
            case 2:
                b(this.e.left, motionEvent.getY(), motionEvent.getX(), this.e.bottom);
                break;
            case 3:
                float x2 = motionEvent.getX();
                RectF rectF2 = this.e;
                b(x2, rectF2.top, rectF2.right, motionEvent.getY());
                break;
            case 4:
                RectF rectF3 = this.e;
                b(rectF3.left, rectF3.top, motionEvent.getX(), motionEvent.getY());
                break;
            case 5:
                float f = this.e.left;
                float y2 = motionEvent.getY();
                RectF rectF4 = this.e;
                b(f, y2, rectF4.right, rectF4.bottom);
                break;
            case 6:
                float x3 = motionEvent.getX();
                RectF rectF5 = this.e;
                b(x3, rectF5.top, rectF5.right, rectF5.bottom);
                break;
            case 7:
                RectF rectF6 = this.e;
                b(rectF6.left, rectF6.top, motionEvent.getX(), this.e.bottom);
                break;
            case 8:
                RectF rectF7 = this.e;
                b(rectF7.left, rectF7.top, rectF7.right, motionEvent.getY());
                break;
            default:
                return false;
        }
        return true;
    }

    public ClipBoxView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = 22;
        this.k = 2;
        this.l = -1;
        this.m = 20;
        this.n = 0.0f;
        this.p = 0.0f;
        this.q = 0.0f;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = false;
        this.u = 0.0f;
        this.v = 0.0f;
        this.w = 0.0f;
        this.x = 0.0f;
        this.D = false;
        if (b0 == null) {
            b0 = this;
        }
        d();
    }

    public void a(Canvas canvas) {
        RectF rectF = this.e;
        float f = rectF.left;
        float f2 = rectF.top;
        float f3 = rectF.right;
        float f4 = rectF.bottom;
        float f5 = (f4 - f2) / 3.0f;
        float f6 = f2 + f5;
        canvas.drawLine(f, f6, f3, f6, this.f5426a);
        float f7 = f2 + (f5 * 2.0f);
        canvas.drawLine(f, f7, f3, f7, this.f5426a);
        float f8 = (f3 - f) / 3.0f;
        float f9 = f + f8;
        canvas.drawLine(f9, f2, f9, f4, this.f5426a);
        float f10 = f + (f8 * 2.0f);
        canvas.drawLine(f10, f2, f10, f4, this.f5426a);
    }

    private void a(float f, float f2, float f3, float f4) {
        ZoomImageView zoomImageView = ZoomImageView.getInstance();
        if (zoomImageView != null) {
            RectF matrixRectF = zoomImageView.getMatrixRectF();
            f = Math.max(Math.max(this.m, f), matrixRectF.left);
            f2 = Math.max(Math.max(this.m, f2), matrixRectF.top);
            f3 = Math.min(Math.min(getWidth() - this.m, f3), matrixRectF.right);
            f4 = Math.min(Math.min(getHeight() - this.m, f4), matrixRectF.bottom);
        }
        this.q = this.u - f2;
        this.s = f4 - this.v;
        this.p = this.w - f;
        this.r = f3 - this.x;
        this.e.set(f, f2, f3, f4);
    }

    private void a(float f, float f2, float f3, float f4, float f5) {
        float f6;
        float f7;
        float f8;
        float f9;
        ZoomImageView zoomImageView = ZoomImageView.getInstance();
        if (zoomImageView != null) {
            RectF matrixRectF = zoomImageView.getMatrixRectF();
            f9 = Math.max(Math.max(this.m, f), matrixRectF.left);
            f8 = Math.max(Math.max(this.m, f2), matrixRectF.top);
            f7 = Math.min(Math.min(getWidth() - this.m, f3), matrixRectF.right);
            f6 = Math.min(Math.min(getHeight() - this.m, f4), matrixRectF.bottom);
        } else {
            f6 = f4;
            f7 = f3;
            f8 = f2;
            f9 = f;
        }
        float f10 = f7 - f9;
        float f11 = f6 - f8;
        float f12 = f10 / f11;
        if (f12 > f5) {
            while (f12 / f5 > W) {
                f7 -= 1.0f;
                f9 += 1.0f;
                f12 = (f7 - f9) / f11;
            }
        } else {
            while (f12 / f5 < a0) {
                f6 -= 1.0f;
                f8 += 1.0f;
                f12 = f10 / (f6 - f8);
            }
        }
        this.q = this.u - f8;
        this.s = f6 - this.v;
        this.p = this.w - f9;
        this.r = f7 - this.x;
        this.e.set(f9, f8, f7, f6);
    }

    private void b(float f, float f2, float f3, float f4) {
        if (f4 - f2 < 50.0f) {
            RectF rectF = this.e;
            f2 = rectF.top;
            f4 = rectF.bottom;
        }
        if (f3 - f < 50.0f) {
            RectF rectF2 = this.e;
            f = rectF2.left;
            f3 = rectF2.right;
        }
        a(f, f2, f3, f4);
        invalidate();
    }

    private void b(Canvas canvas) {
        if (this.t) {
            RectF rectF = this.e;
            float f = this.w;
            float f2 = this.n;
            rectF.left = f - (this.p * f2);
            rectF.top = this.u - (this.q * f2);
            rectF.right = this.x + (this.r * f2);
            rectF.bottom = this.v + (f2 * this.s);
            canvas.drawRect(rectF, this.f5426a);
            return;
        }
        canvas.drawRect(this.e, this.f5426a);
    }

    private void c(Canvas canvas) {
        this.f5426a.setStrokeWidth(this.d);
        RectF rectF = this.e;
        float f = rectF.left;
        float f2 = rectF.top;
        canvas.drawLine(f - this.k, f2, f + this.c, f2, this.f5426a);
        RectF rectF2 = this.e;
        float f3 = rectF2.left;
        float f4 = rectF2.top;
        canvas.drawLine(f3, f4, f3, f4 + this.c, this.f5426a);
        RectF rectF3 = this.e;
        float f5 = rectF3.right;
        float f6 = rectF3.top;
        canvas.drawLine(this.k + f5, f6, f5 - this.c, f6, this.f5426a);
        RectF rectF4 = this.e;
        float f7 = rectF4.right;
        float f8 = rectF4.top;
        canvas.drawLine(f7, f8, f7, f8 + this.c, this.f5426a);
        RectF rectF5 = this.e;
        float f9 = rectF5.left;
        float f10 = rectF5.bottom;
        canvas.drawLine(f9 - this.k, f10, f9 + this.c, f10, this.f5426a);
        RectF rectF6 = this.e;
        float f11 = rectF6.left;
        float f12 = rectF6.bottom;
        canvas.drawLine(f11, f12, f11, f12 - this.c, this.f5426a);
        RectF rectF7 = this.e;
        float f13 = rectF7.right;
        float f14 = rectF7.bottom;
        canvas.drawLine(this.k + f13, f14, f13 - this.c, f14, this.f5426a);
        RectF rectF8 = this.e;
        float f15 = rectF8.right;
        float f16 = rectF8.bottom;
        canvas.drawLine(f15, f16, f15, f16 - this.c, this.f5426a);
    }

    @TargetApi(11)
    private void a() {
        int i;
        int i2;
        int width = getWidth() - (this.i * 2);
        RectF rectF = this.e;
        float f = rectF.right;
        float f2 = rectF.left;
        float f3 = width;
        if (f - f2 < f3) {
            this.u = rectF.top;
            this.v = rectF.bottom;
            this.w = f2;
            this.x = f;
            float f4 = (this.x - this.w) / (this.v - this.u);
            this.z = f3 / (f - f2);
            RectF rectF2 = this.e;
            this.A = (getHeight() - (this.m * 2)) / (rectF2.bottom - rectF2.top);
            this.y = Math.min(this.z, this.A);
            float f5 = this.y;
            float f6 = f5 - 1.0f <= 1.0f ? f5 - 1.0f : 1.0f;
            RectF rectF3 = this.e;
            this.B = ((getWidth() / 2) - ((rectF3.right + rectF3.left) / 2.0f)) * f6;
            RectF rectF4 = this.e;
            float f7 = rectF4.top;
            float f8 = rectF4.bottom;
            this.C = f6 * ((getHeight() / 2) - ((f7 + f8) / 2.0f));
            float f9 = rectF4.left;
            float f10 = this.y;
            rectF4.left = f9 / f10;
            rectF4.top = f7 / f10;
            rectF4.right *= f10;
            rectF4.bottom = f8 * f10;
            if (this.E == G) {
                a(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom, f4);
            } else {
                a(this.i, this.j, i + width, width + i2);
            }
            this.o.setDuration(500L).start();
            this.t = true;
            return;
        }
        this.D = false;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ZoomImageView zoomImageView = ZoomImageView.getInstance();
        if (!this.t || zoomImageView == null || zoomImageView.getScale() > 12.0f) {
            return;
        }
        float f = ((this.y - 1.0f) / 20.0f) + 1.0f;
        zoomImageView.e.postTranslate(this.B / 20.0f, this.C / 20.0f);
        Matrix matrix = zoomImageView.e;
        RectF rectF = this.e;
        matrix.postScale(f, f, (rectF.left + rectF.right) / 2.0f, (rectF.bottom + rectF.top) / 2.0f);
        RectF rectF2 = this.e;
        zoomImageView.a((rectF2.left + rectF2.right) / 2.0f, (rectF2.bottom + rectF2.top) / 2.0f);
        zoomImageView.setImageMatrix(zoomImageView.e);
    }

    private boolean a(MotionEvent motionEvent) {
        int width = getWidth() - (this.i * 2);
        RectF rectF = this.e;
        float f = width;
        return rectF.right - rectF.left >= f && rectF.bottom - rectF.top >= f && (motionEvent.getX() < ((float) this.i) || motionEvent.getX() > ((float) (this.i + width)) || motionEvent.getY() < ((float) this.j) || motionEvent.getY() > ((float) (width + this.j)));
    }
}
