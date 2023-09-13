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
    public static final int I = 1;
    public static final int J = 20;
    public static final int K = 4;
    public static final int L = -1;
    public static final int M = 1;
    public static final int N = 2;
    public static final int O = 3;
    public static final int P = 4;
    public static final int Q = 5;
    public static final int R = 6;
    public static final int S = 7;

    /* renamed from: T  reason: collision with root package name */
    public static final int f1056T = 8;
    public static final float U = 50.0f;
    public static final float V = 50.0f;
    public static final float W = 1.01f;
    public static final float a0 = 0.99f;
    public static ClipBoxView b0;
    public float A;
    public float B;
    public float C;
    public boolean D;
    public int E;
    public boolean F;
    public Paint a;
    public Paint b;
    public int c;
    public int d;
    public RectF e;
    public RectF f;
    public float g;
    public float h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public float n;
    public ValueAnimator o;
    public float p;
    public float q;
    public float r;
    public float s;
    public boolean t;
    public float u;
    public float v;
    public float w;
    public float x;
    public float y;
    public float z;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
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

    public ClipBoxView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
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

    @TargetApi(11)
    private void a() {
        int i;
        int i2;
        int width = getWidth() - (this.i * 2);
        RectF rectF = this.e;
        float f = rectF.right;
        float f2 = rectF.left;
        float f3 = f - f2;
        float f4 = width;
        if (f3 < f4) {
            float f5 = rectF.top;
            this.u = f5;
            float f6 = rectF.bottom;
            this.v = f6;
            this.w = f2;
            this.x = f;
            float f7 = (f - f2) / (f6 - f5);
            this.z = f4 / f3;
            RectF rectF2 = this.e;
            float height = (getHeight() - (this.m * 2)) / (rectF2.bottom - rectF2.top);
            this.A = height;
            float min = Math.min(this.z, height);
            this.y = min;
            float f8 = 1.0f;
            float f9 = min - 1.0f;
            if (f9 <= 1.0f) {
                f8 = f9;
            }
            RectF rectF3 = this.e;
            this.B = ((getWidth() / 2) - ((rectF3.left + rectF3.right) / 2.0f)) * f8;
            RectF rectF4 = this.e;
            float f10 = rectF4.top;
            float f11 = rectF4.bottom;
            this.C = ((getHeight() / 2) - ((f10 + f11) / 2.0f)) * f8;
            float f12 = rectF4.left;
            float f13 = this.y;
            float f14 = f12 / f13;
            rectF4.left = f14;
            float f15 = f10 / f13;
            rectF4.top = f15;
            float f16 = rectF4.right * f13;
            rectF4.right = f16;
            float f17 = f11 * f13;
            rectF4.bottom = f17;
            if (this.E == G) {
                a(f14, f15, f16, f17, f7);
            } else {
                a(this.i, this.j, i + width, i2 + width);
            }
            this.o.setDuration(500L).start();
            this.t = true;
            return;
        }
        this.D = false;
        invalidate();
    }

    @TargetApi(11)
    private void d() {
        setLayerType(1, null);
        this.a = new Paint();
        this.b = new Paint();
        this.a.setColor(-1);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(SapiUtils.dip2px(getContext(), 1.0f));
        this.a.setAntiAlias(true);
        this.b.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.b.setAntiAlias(true);
        this.c = SapiUtils.dip2px(getContext(), 20.0f);
        this.d = SapiUtils.dip2px(getContext(), 4.0f);
        this.i = SapiUtils.dip2px(getContext(), this.i);
        this.k = SapiUtils.dip2px(getContext(), this.k);
        this.m = SapiUtils.dip2px(getContext(), this.m);
        this.e = new RectF();
        this.f = new RectF();
        this.E = H;
        this.F = true;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.o = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.o.addUpdateListener(new a());
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
        ZoomImageView zoomImageView = ZoomImageView.getInstance();
        if (zoomImageView != null) {
            RectF matrixRectF = zoomImageView.getMatrixRectF();
            f = Math.max(Math.max(this.m, f), matrixRectF.left);
            f2 = Math.max(Math.max(this.m, f2), matrixRectF.top);
            f3 = Math.min(Math.min(getWidth() - this.m, f3), matrixRectF.right);
            f4 = Math.min(Math.min(getHeight() - this.m, f4), matrixRectF.bottom);
        }
        float f6 = f3 - f;
        float f7 = f4 - f2;
        float f8 = f6 / f7;
        if (f8 > f5) {
            while (f8 / f5 > 1.01f) {
                f3 -= 1.0f;
                f += 1.0f;
                f8 = (f3 - f) / f7;
            }
        } else {
            while (f8 / f5 < 0.99f) {
                f4 -= 1.0f;
                f2 += 1.0f;
                f8 = f6 / (f4 - f2);
            }
        }
        this.q = this.u - f2;
        this.s = f4 - this.v;
        this.p = this.w - f;
        this.r = f3 - this.x;
        this.e.set(f, f2, f3, f4);
    }

    private boolean a(MotionEvent motionEvent) {
        int width = getWidth() - (this.i * 2);
        RectF rectF = this.e;
        float f = width;
        if (rectF.right - rectF.left >= f && rectF.bottom - rectF.top >= f) {
            if (motionEvent.getX() < this.i || motionEvent.getX() > this.i + width || motionEvent.getY() < this.j || motionEvent.getY() > this.j + width) {
                return true;
            }
            return false;
        }
        return false;
    }

    public static void b() {
        b0 = null;
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

    private void b(float f, float f2, float f3, float f4) {
        if (f4 - f2 < 50.0f) {
            RectF rectF = this.e;
            float f5 = rectF.top;
            f4 = rectF.bottom;
            f2 = f5;
        }
        if (f3 - f < 50.0f) {
            RectF rectF2 = this.e;
            float f6 = rectF2.left;
            f3 = rectF2.right;
            f = f6;
        }
        a(f, f2, f3, f4);
        invalidate();
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int i5 = this.i;
        int i6 = i - (i5 * 2);
        int i7 = (i2 - i6) / 2;
        this.j = i7;
        RectF rectF = this.e;
        float f = i5;
        rectF.left = f;
        float f2 = i7;
        rectF.top = f2;
        float f3 = i6;
        rectF.right = f + f3;
        rectF.bottom = f2 + f3;
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
            canvas.drawRect(rectF, this.a);
            return;
        }
        canvas.drawRect(this.e, this.a);
    }

    public void a(Canvas canvas) {
        RectF rectF = this.e;
        float f = rectF.left;
        float f2 = rectF.top;
        float f3 = rectF.right;
        float f4 = rectF.bottom;
        float f5 = (f4 - f2) / 3.0f;
        float f6 = f2 + f5;
        canvas.drawLine(f, f6, f3, f6, this.a);
        float f7 = f2 + (f5 * 2.0f);
        canvas.drawLine(f, f7, f3, f7, this.a);
        float f8 = (f3 - f) / 3.0f;
        float f9 = f + f8;
        canvas.drawLine(f9, f2, f9, f4, this.a);
        float f10 = f + (f8 * 2.0f);
        canvas.drawLine(f10, f2, f10, f4, this.a);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int argb = Color.argb(180, 0, 0, 0);
        this.a.setStrokeWidth(SapiUtils.dip2px(getContext(), 1.0f));
        canvas.drawColor(argb);
        b(canvas);
        if (this.n == 1.0f) {
            this.t = false;
            this.D = false;
            this.n = 0.0f;
        }
        canvas.drawRect(this.e, this.b);
        if (this.D) {
            a(canvas);
        }
        c(canvas);
    }

    private boolean b(MotionEvent motionEvent) {
        switch (this.l) {
            case 1:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                RectF rectF = this.e;
                b(x, y, rectF.right, rectF.bottom);
                return true;
            case 2:
                b(this.e.left, motionEvent.getY(), motionEvent.getX(), this.e.bottom);
                return true;
            case 3:
                float x2 = motionEvent.getX();
                RectF rectF2 = this.e;
                b(x2, rectF2.top, rectF2.right, motionEvent.getY());
                return true;
            case 4:
                RectF rectF3 = this.e;
                b(rectF3.left, rectF3.top, motionEvent.getX(), motionEvent.getY());
                return true;
            case 5:
                float f = this.e.left;
                float y2 = motionEvent.getY();
                RectF rectF4 = this.e;
                b(f, y2, rectF4.right, rectF4.bottom);
                return true;
            case 6:
                float x3 = motionEvent.getX();
                RectF rectF5 = this.e;
                b(x3, rectF5.top, rectF5.right, rectF5.bottom);
                return true;
            case 7:
                RectF rectF6 = this.e;
                b(rectF6.left, rectF6.top, motionEvent.getX(), this.e.bottom);
                return true;
            case 8:
                RectF rectF7 = this.e;
                b(rectF7.left, rectF7.top, rectF7.right, motionEvent.getY());
                return true;
            default:
                return false;
        }
    }

    private void c(Canvas canvas) {
        this.a.setStrokeWidth(this.d);
        RectF rectF = this.e;
        float f = rectF.left;
        float f2 = rectF.top;
        canvas.drawLine(f - this.k, f2, f + this.c, f2, this.a);
        RectF rectF2 = this.e;
        float f3 = rectF2.left;
        float f4 = rectF2.top;
        canvas.drawLine(f3, f4, f3, f4 + this.c, this.a);
        RectF rectF3 = this.e;
        float f5 = rectF3.right;
        float f6 = rectF3.top;
        canvas.drawLine(f5 + this.k, f6, f5 - this.c, f6, this.a);
        RectF rectF4 = this.e;
        float f7 = rectF4.right;
        float f8 = rectF4.top;
        canvas.drawLine(f7, f8, f7, f8 + this.c, this.a);
        RectF rectF5 = this.e;
        float f9 = rectF5.left;
        float f10 = rectF5.bottom;
        canvas.drawLine(f9 - this.k, f10, f9 + this.c, f10, this.a);
        RectF rectF6 = this.e;
        float f11 = rectF6.left;
        float f12 = rectF6.bottom;
        canvas.drawLine(f11, f12, f11, f12 - this.c, this.a);
        RectF rectF7 = this.e;
        float f13 = rectF7.right;
        float f14 = rectF7.bottom;
        canvas.drawLine(f13 + this.k, f14, f13 - this.c, f14, this.a);
        RectF rectF8 = this.e;
        float f15 = rectF8.right;
        float f16 = rectF8.bottom;
        canvas.drawLine(f15, f16, f15, f16 - this.c, this.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        ZoomImageView zoomImageView = ZoomImageView.getInstance();
        if (this.t && zoomImageView != null && zoomImageView.getScale() <= 12.0f) {
            float f = ((this.y - 1.0f) / 20.0f) + 1.0f;
            zoomImageView.e.postTranslate(this.B / 20.0f, this.C / 20.0f);
            Matrix matrix = zoomImageView.e;
            RectF rectF = this.e;
            matrix.postScale(f, f, (rectF.left + rectF.right) / 2.0f, (rectF.top + rectF.bottom) / 2.0f);
            RectF rectF2 = this.e;
            zoomImageView.a((rectF2.left + rectF2.right) / 2.0f, (rectF2.top + rectF2.bottom) / 2.0f);
            zoomImageView.setImageMatrix(zoomImageView.e);
        }
    }

    private boolean c(MotionEvent motionEvent) {
        if (a(motionEvent)) {
            return true;
        }
        int i = this.l;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return false;
                    }
                    float x = ((this.e.right - motionEvent.getX()) + (this.e.bottom - motionEvent.getY())) / 2.0f;
                    RectF rectF = this.e;
                    b(rectF.left, rectF.top, rectF.right - x, rectF.bottom - x);
                } else {
                    float x2 = motionEvent.getX();
                    RectF rectF2 = this.e;
                    float y = ((x2 - rectF2.left) + (rectF2.bottom - motionEvent.getY())) / 2.0f;
                    RectF rectF3 = this.e;
                    b(rectF3.left + y, rectF3.top, rectF3.right, rectF3.bottom - y);
                }
            } else {
                float x3 = this.e.right - motionEvent.getX();
                float y2 = motionEvent.getY();
                RectF rectF4 = this.e;
                float f = rectF4.top;
                float f2 = (x3 + (y2 - f)) / 2.0f;
                b(rectF4.left, f + f2, rectF4.right - f2, rectF4.bottom);
            }
        } else {
            float x4 = motionEvent.getX() - this.e.left;
            float y3 = motionEvent.getY();
            RectF rectF5 = this.e;
            float f3 = rectF5.top;
            float f4 = (x4 + (y3 - f3)) / 2.0f;
            b(rectF5.left + f4, f3 + f4, rectF5.right, rectF5.bottom);
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000f, code lost:
        if (r0 != 3) goto L6;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.E == G) {
                        return b(motionEvent);
                    }
                    return c(motionEvent);
                }
            }
            int i = this.l;
            if (i >= 1 && i <= 4 && this.F) {
                a();
            } else {
                this.D = false;
                invalidate();
            }
            this.l = -1;
            return false;
        }
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
        if (!rectF15.intersect(f5, f6, rectF16.right, f6)) {
            return false;
        }
        this.l = 8;
        return true;
    }
}
