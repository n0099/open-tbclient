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
/* loaded from: classes19.dex */
public class ClipBoxView extends View {
    public static int a = 0;
    public static int b = 1;
    private static final int c = 1;
    private static final int d = 20;
    private static final int e = 4;
    private static final int f = -1;
    private static final int g = 1;
    private static final int h = 2;
    private static final int i = 3;
    private static final int j = 4;
    private static final int k = 5;
    private static final int l = 6;
    private static final int m = 7;
    private static final int n = 8;
    private static final float o = 50.0f;
    private static final float p = 50.0f;
    private static final float q = 1.01f;
    private static final float r = 0.99f;
    private static ClipBoxView s;
    private float A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private float G;
    private ValueAnimator H;
    private float I;
    private float J;
    private float K;
    private float L;
    private boolean M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private float V;
    public boolean W;
    public int aa;
    public boolean ba;
    private Paint t;
    private Paint u;
    private int v;
    private int w;
    private RectF x;
    private RectF y;
    private float z;

    public ClipBoxView(Context context) {
        this(context, null);
    }

    private boolean b(MotionEvent motionEvent) {
        switch (this.E) {
            case 1:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                RectF rectF = this.x;
                b(x, y, rectF.right, rectF.bottom);
                break;
            case 2:
                b(this.x.left, motionEvent.getY(), motionEvent.getX(), this.x.bottom);
                break;
            case 3:
                float x2 = motionEvent.getX();
                RectF rectF2 = this.x;
                b(x2, rectF2.top, rectF2.right, motionEvent.getY());
                break;
            case 4:
                RectF rectF3 = this.x;
                b(rectF3.left, rectF3.top, motionEvent.getX(), motionEvent.getY());
                break;
            case 5:
                float f2 = this.x.left;
                float y2 = motionEvent.getY();
                RectF rectF4 = this.x;
                b(f2, y2, rectF4.right, rectF4.bottom);
                break;
            case 6:
                float x3 = motionEvent.getX();
                RectF rectF5 = this.x;
                b(x3, rectF5.top, rectF5.right, rectF5.bottom);
                break;
            case 7:
                RectF rectF6 = this.x;
                b(rectF6.left, rectF6.top, motionEvent.getX(), this.x.bottom);
                break;
            case 8:
                RectF rectF7 = this.x;
                b(rectF7.left, rectF7.top, rectF7.right, motionEvent.getY());
                break;
            default:
                return false;
        }
        return true;
    }

    private boolean c(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        switch (this.E) {
            case 1:
                float x = motionEvent.getX() - this.x.left;
                float y = motionEvent.getY();
                RectF rectF = this.x;
                float f2 = rectF.top;
                float f3 = (x + (y - f2)) / 2.0f;
                b(rectF.left + f3, f3 + f2, rectF.right, rectF.bottom);
                return true;
            case 2:
                float x2 = this.x.right - motionEvent.getX();
                float y2 = motionEvent.getY();
                RectF rectF2 = this.x;
                float f4 = rectF2.top;
                float f5 = (x2 + (y2 - f4)) / 2.0f;
                b(rectF2.left, f4 + f5, rectF2.right - f5, rectF2.bottom);
                return true;
            case 3:
                float x3 = motionEvent.getX();
                RectF rectF3 = this.x;
                float y3 = ((x3 - rectF3.left) + (rectF3.bottom - motionEvent.getY())) / 2.0f;
                RectF rectF4 = this.x;
                b(rectF4.left + y3, rectF4.top, rectF4.right, rectF4.bottom - y3);
                return true;
            case 4:
                float x4 = ((this.x.right - motionEvent.getX()) + (this.x.bottom - motionEvent.getY())) / 2.0f;
                RectF rectF5 = this.x;
                b(rectF5.left, rectF5.top, rectF5.right - x4, rectF5.bottom - x4);
                return true;
            default:
                return false;
        }
    }

    @TargetApi(11)
    private void d() {
        setLayerType(1, null);
        this.t = new Paint();
        this.u = new Paint();
        this.t.setColor(-1);
        this.t.setStyle(Paint.Style.STROKE);
        this.t.setStrokeWidth(SapiUtils.dip2px(getContext(), 1.0f));
        this.t.setAntiAlias(true);
        this.u.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.u.setAntiAlias(true);
        this.v = SapiUtils.dip2px(getContext(), 20.0f);
        this.w = SapiUtils.dip2px(getContext(), 4.0f);
        this.B = SapiUtils.dip2px(getContext(), this.B);
        this.D = SapiUtils.dip2px(getContext(), this.D);
        this.F = SapiUtils.dip2px(getContext(), this.F);
        this.x = new RectF();
        this.y = new RectF();
        this.aa = b;
        this.ba = true;
        this.H = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.H.setInterpolator(new LinearInterpolator());
        this.H.addUpdateListener(new a(this));
    }

    public static ClipBoxView getInstance() {
        ClipBoxView clipBoxView = s;
        if (clipBoxView != null) {
            return clipBoxView;
        }
        return null;
    }

    public Rect getmFrameRectF() {
        Rect rect = new Rect();
        RectF rectF = this.x;
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
        this.t.setStrokeWidth(SapiUtils.dip2px(getContext(), 1.0f));
        canvas.drawColor(argb);
        b(canvas);
        if (this.G == 1.0f) {
            this.M = false;
            this.W = false;
            this.G = 0.0f;
        }
        canvas.drawRect(this.x, this.u);
        if (this.W) {
            a(canvas);
        }
        c(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        int i6 = this.B;
        this.C = (i3 - (i2 - (i6 * 2))) / 2;
        RectF rectF = this.x;
        rectF.left = i6;
        rectF.top = this.C;
        rectF.right = rectF.left + (i2 - (i6 * 2));
        rectF.bottom = (i2 - (i6 * 2)) + rectF.top;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.W = true;
                this.y.set(motionEvent.getX() - this.v, motionEvent.getY() - this.v, motionEvent.getX() + this.v, motionEvent.getY() + this.v);
                RectF rectF = this.y;
                RectF rectF2 = this.x;
                if (rectF.contains(rectF2.left, rectF2.top)) {
                    this.E = 1;
                    return true;
                }
                RectF rectF3 = this.y;
                RectF rectF4 = this.x;
                if (rectF3.contains(rectF4.right, rectF4.top)) {
                    this.E = 2;
                    return true;
                }
                RectF rectF5 = this.y;
                RectF rectF6 = this.x;
                if (rectF5.contains(rectF6.left, rectF6.bottom)) {
                    this.E = 3;
                    return true;
                }
                RectF rectF7 = this.y;
                RectF rectF8 = this.x;
                if (rectF7.contains(rectF8.right, rectF8.bottom)) {
                    this.E = 4;
                    return true;
                }
                RectF rectF9 = this.y;
                RectF rectF10 = this.x;
                float f2 = rectF10.left;
                float f3 = rectF10.top;
                if (rectF9.intersect(f2, f3, rectF10.right, f3)) {
                    this.E = 5;
                    return true;
                }
                RectF rectF11 = this.y;
                RectF rectF12 = this.x;
                float f4 = rectF12.left;
                if (rectF11.intersect(f4, rectF12.top, f4, rectF12.bottom)) {
                    this.E = 6;
                    return true;
                }
                RectF rectF13 = this.y;
                RectF rectF14 = this.x;
                float f5 = rectF14.right;
                if (rectF13.intersect(f5, rectF14.top, f5, rectF14.bottom)) {
                    this.E = 7;
                    return true;
                }
                RectF rectF15 = this.y;
                RectF rectF16 = this.x;
                float f6 = rectF16.left;
                float f7 = rectF16.bottom;
                if (rectF15.intersect(f6, f7, rectF16.right, f7)) {
                    this.E = 8;
                    return true;
                }
                return false;
            case 1:
            case 3:
                int i2 = this.E;
                if (i2 >= 1 && i2 <= 4 && this.ba) {
                    b();
                } else {
                    this.W = false;
                    invalidate();
                }
                this.E = -1;
                break;
            case 2:
                if (this.aa == a) {
                    return b(motionEvent);
                }
                return c(motionEvent);
        }
        return false;
    }

    public ClipBoxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ClipBoxView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.B = 22;
        this.D = 2;
        this.E = -1;
        this.F = 20;
        this.G = 0.0f;
        this.I = 0.0f;
        this.J = 0.0f;
        this.K = 0.0f;
        this.L = 0.0f;
        this.M = false;
        this.N = 0.0f;
        this.O = 0.0f;
        this.P = 0.0f;
        this.Q = 0.0f;
        this.W = false;
        if (s == null) {
            s = this;
        }
        d();
    }

    public static void a() {
        s = null;
    }

    public void a(Canvas canvas) {
        RectF rectF = this.x;
        float f2 = rectF.left;
        float f3 = rectF.top;
        float f4 = rectF.right;
        float f5 = rectF.bottom;
        float f6 = (f5 - f3) / 3.0f;
        float f7 = f3 + f6;
        canvas.drawLine(f2, f7, f4, f7, this.t);
        float f8 = f3 + (f6 * 2.0f);
        canvas.drawLine(f2, f8, f4, f8, this.t);
        float f9 = (f4 - f2) / 3.0f;
        float f10 = f2 + f9;
        canvas.drawLine(f10, f3, f10, f5, this.t);
        float f11 = f2 + (f9 * 2.0f);
        canvas.drawLine(f11, f3, f11, f5, this.t);
    }

    private void b(float f2, float f3, float f4, float f5) {
        if (f5 - f3 < 50.0f) {
            RectF rectF = this.x;
            f3 = rectF.top;
            f5 = rectF.bottom;
        }
        if (f4 - f2 < 50.0f) {
            RectF rectF2 = this.x;
            f2 = rectF2.left;
            f4 = rectF2.right;
        }
        a(f2, f3, f4, f5);
        invalidate();
    }

    private void a(float f2, float f3, float f4, float f5) {
        ZoomImageView zoomImageView = ZoomImageView.getInstance();
        if (zoomImageView != null) {
            RectF matrixRectF = zoomImageView.getMatrixRectF();
            f2 = Math.max(Math.max(this.F, f2), matrixRectF.left);
            f3 = Math.max(Math.max(this.F, f3), matrixRectF.top);
            f4 = Math.min(Math.min(getWidth() - this.F, f4), matrixRectF.right);
            f5 = Math.min(Math.min(getHeight() - this.F, f5), matrixRectF.bottom);
        }
        this.J = this.N - f3;
        this.L = f5 - this.O;
        this.I = this.P - f2;
        this.K = f4 - this.Q;
        this.x.set(f2, f3, f4, f5);
    }

    private void c(Canvas canvas) {
        this.t.setStrokeWidth(this.w);
        RectF rectF = this.x;
        float f2 = rectF.left;
        float f3 = rectF.top;
        canvas.drawLine(f2 - this.D, f3, f2 + this.v, f3, this.t);
        RectF rectF2 = this.x;
        float f4 = rectF2.left;
        float f5 = rectF2.top;
        canvas.drawLine(f4, f5, f4, f5 + this.v, this.t);
        RectF rectF3 = this.x;
        float f6 = rectF3.right;
        float f7 = rectF3.top;
        canvas.drawLine(this.D + f6, f7, f6 - this.v, f7, this.t);
        RectF rectF4 = this.x;
        float f8 = rectF4.right;
        float f9 = rectF4.top;
        canvas.drawLine(f8, f9, f8, f9 + this.v, this.t);
        RectF rectF5 = this.x;
        float f10 = rectF5.left;
        float f11 = rectF5.bottom;
        canvas.drawLine(f10 - this.D, f11, f10 + this.v, f11, this.t);
        RectF rectF6 = this.x;
        float f12 = rectF6.left;
        float f13 = rectF6.bottom;
        canvas.drawLine(f12, f13, f12, f13 - this.v, this.t);
        RectF rectF7 = this.x;
        float f14 = rectF7.right;
        float f15 = rectF7.bottom;
        canvas.drawLine(this.D + f14, f15, f14 - this.v, f15, this.t);
        RectF rectF8 = this.x;
        float f16 = rectF8.right;
        float f17 = rectF8.bottom;
        canvas.drawLine(f16, f17, f16, f17 - this.v, this.t);
    }

    private void b(Canvas canvas) {
        if (this.M) {
            RectF rectF = this.x;
            float f2 = this.P;
            float f3 = this.G;
            rectF.left = f2 - (this.I * f3);
            rectF.top = this.N - (this.J * f3);
            rectF.right = this.Q + (this.K * f3);
            rectF.bottom = this.O + (f3 * this.L);
            canvas.drawRect(rectF, this.t);
            return;
        }
        canvas.drawRect(this.x, this.t);
    }

    private void a(float f2, float f3, float f4, float f5, float f6) {
        float f7;
        float f8;
        float f9;
        float f10;
        ZoomImageView zoomImageView = ZoomImageView.getInstance();
        if (zoomImageView != null) {
            RectF matrixRectF = zoomImageView.getMatrixRectF();
            f10 = Math.max(Math.max(this.F, f2), matrixRectF.left);
            f9 = Math.max(Math.max(this.F, f3), matrixRectF.top);
            f8 = Math.min(Math.min(getWidth() - this.F, f4), matrixRectF.right);
            f7 = Math.min(Math.min(getHeight() - this.F, f5), matrixRectF.bottom);
        } else {
            f7 = f5;
            f8 = f4;
            f9 = f3;
            f10 = f2;
        }
        float f11 = f8 - f10;
        float f12 = f7 - f9;
        float f13 = f11 / f12;
        if (f13 > f6) {
            while (f13 / f6 > q) {
                f8 -= 1.0f;
                f10 += 1.0f;
                f13 = (f8 - f10) / f12;
            }
        } else {
            while (f13 / f6 < r) {
                float f14 = f7 - 1.0f;
                f9 += 1.0f;
                f7 = f14;
                f13 = f11 / (f14 - f9);
            }
        }
        this.J = this.N - f9;
        this.L = f7 - this.O;
        this.I = this.P - f10;
        this.K = f8 - this.Q;
        this.x.set(f10, f9, f8, f7);
    }

    @TargetApi(11)
    private void b() {
        int i2;
        int i3;
        int width = getWidth() - (this.B * 2);
        RectF rectF = this.x;
        float f2 = rectF.right;
        float f3 = rectF.left;
        float f4 = width;
        if (f2 - f3 < f4) {
            this.N = rectF.top;
            this.O = rectF.bottom;
            this.P = f3;
            this.Q = f2;
            float f5 = (this.Q - this.P) / (this.O - this.N);
            this.S = f4 / (f2 - f3);
            RectF rectF2 = this.x;
            this.T = (getHeight() - (this.F * 2)) / (rectF2.bottom - rectF2.top);
            this.R = Math.min(this.S, this.T);
            float f6 = this.R;
            float f7 = f6 - 1.0f <= 1.0f ? f6 - 1.0f : 1.0f;
            RectF rectF3 = this.x;
            this.U = ((getWidth() / 2) - ((rectF3.right + rectF3.left) / 2.0f)) * f7;
            RectF rectF4 = this.x;
            float f8 = rectF4.top;
            float f9 = rectF4.bottom;
            this.V = f7 * ((getHeight() / 2) - ((f8 + f9) / 2.0f));
            float f10 = rectF4.left;
            float f11 = this.R;
            rectF4.left = f10 / f11;
            rectF4.top = f8 / f11;
            rectF4.right *= f11;
            rectF4.bottom = f9 * f11;
            if (this.aa == a) {
                a(rectF4.left, rectF4.top, rectF4.right, rectF4.bottom, f5);
            } else {
                a(this.B, this.C, i2 + width, width + i3);
            }
            this.H.setDuration(500L).start();
            this.M = true;
            return;
        }
        this.W = false;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ZoomImageView zoomImageView = ZoomImageView.getInstance();
        if (!this.M || zoomImageView == null || zoomImageView.getScale() > 12.0f) {
            return;
        }
        float f2 = ((this.R - 1.0f) / 20.0f) + 1.0f;
        zoomImageView.g.postTranslate(this.U / 20.0f, this.V / 20.0f);
        Matrix matrix = zoomImageView.g;
        RectF rectF = this.x;
        matrix.postScale(f2, f2, (rectF.left + rectF.right) / 2.0f, (rectF.bottom + rectF.top) / 2.0f);
        RectF rectF2 = this.x;
        zoomImageView.a((rectF2.left + rectF2.right) / 2.0f, (rectF2.bottom + rectF2.top) / 2.0f);
        zoomImageView.setImageMatrix(zoomImageView.g);
    }

    private boolean a(MotionEvent motionEvent) {
        int width = getWidth() - (this.B * 2);
        RectF rectF = this.x;
        float f2 = width;
        return rectF.right - rectF.left >= f2 && rectF.bottom - rectF.top >= f2 && (motionEvent.getX() < ((float) this.B) || motionEvent.getX() > ((float) (this.B + width)) || motionEvent.getY() < ((float) this.C) || motionEvent.getY() > ((float) (width + this.C)));
    }
}
