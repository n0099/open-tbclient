package com.baidu.swan.apps.res.ui.pullrefresh;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.baidu.tieba.R;
import com.baidu.tieba.np2;
import com.baidu.tieba.xj3;
/* loaded from: classes4.dex */
public class RefreshingAnimView extends View {
    public static final double C = Math.sqrt(2.0d);
    public boolean A;
    public int B;
    public float a;
    public float b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public PointF i;
    public Paint j;
    public Paint k;
    public e l;
    public RectF m;
    public PointF n;
    public PointF o;
    public float p;
    public int q;
    public int r;
    public ValueAnimator s;
    public float t;
    public float u;
    public ValueAnimator v;
    public Bitmap w;
    public Canvas x;
    public Camera y;
    public Matrix z;

    /* loaded from: classes4.dex */
    public interface e {
        void notifyAtLeastRoundsFinished(boolean z);
    }

    /* loaded from: classes4.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RefreshingAnimView.this.o(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes4.dex */
    public class b extends AnimatorListenerAdapter {
        public b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            RefreshingAnimView.this.q(750L);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RefreshingAnimView.this.n(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes4.dex */
    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            RefreshingAnimView.e(RefreshingAnimView.this);
            if (RefreshingAnimView.this.r > RefreshingAnimView.this.q && RefreshingAnimView.this.l != null) {
                RefreshingAnimView.this.l.notifyAtLeastRoundsFinished(true);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p();
    }

    public void r() {
        s(300L);
    }

    public void t() {
        p();
        clearAnimation();
        this.a = 0.0f;
        this.r = 1;
        i(1);
        postInvalidate();
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = new PointF();
        this.m = new RectF();
        new PointF();
        this.n = new PointF();
        this.o = new PointF();
        this.p = 0.0f;
        this.q = 0;
        this.r = 1;
        this.s = null;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = null;
        this.A = false;
        this.B = 0;
        m();
    }

    public final void s(long j) {
        i(2);
        if (this.v != null) {
            p();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.v = ofFloat;
        ofFloat.setDuration(j);
        this.v.setInterpolator(new LinearInterpolator());
        this.v.addUpdateListener(new a());
        this.v.addListener(new b());
        if (!this.v.isRunning()) {
            this.v.start();
        }
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = new PointF();
        this.m = new RectF();
        new PointF();
        this.n = new PointF();
        this.o = new PointF();
        this.p = 0.0f;
        this.q = 0;
        this.r = 1;
        this.s = null;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = null;
        this.A = false;
        this.B = 0;
        m();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0.0f;
        this.e = 0.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = new PointF();
        this.m = new RectF();
        new PointF();
        this.n = new PointF();
        this.o = new PointF();
        this.p = 0.0f;
        this.q = 0;
        this.r = 1;
        this.s = null;
        this.t = 0.0f;
        this.u = 0.0f;
        this.v = null;
        this.A = false;
        this.B = 0;
        m();
    }

    public static /* synthetic */ int e(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.r;
        refreshingAnimView.r = i + 1;
        return i;
    }

    public final void i(int i) {
        this.B = i;
    }

    public final void n(float f) {
        if (f < 0.2f) {
            this.t = (f / 0.2f) * 0.5f;
        } else {
            this.t = (((f - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    public final void o(float f) {
        this.u = f;
        postInvalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int i = this.B;
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    j(canvas);
                }
            } else {
                l(canvas);
            }
        } else {
            k(canvas);
        }
        canvas.restore();
    }

    public void setAnimPercent(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.a = f;
        h();
        postInvalidate();
    }

    public void setAtLeastRotateRounds(int i) {
        this.q = i;
    }

    public void setOnLoadingAnimationListener(e eVar) {
        this.l = eVar;
    }

    public final void h() {
        float f = this.a;
        this.b = f;
        if (f < 0.5f) {
            this.c = 0.0f;
            this.e = 0.0f;
            return;
        }
        this.e = ((f - 0.5f) / 0.5f) * this.f;
        if (f < 0.625f) {
            this.c = 0.0f;
            return;
        }
        float f2 = (f - 0.625f) / 0.375f;
        this.c = f2;
        PointF pointF = this.n;
        float f3 = pointF.x;
        float f4 = this.p;
        double d2 = C;
        float f5 = pointF.y + ((float) ((f4 * f2) / d2));
        this.o.set(f3 + ((float) ((f4 * f2) / d2)), f5);
    }

    public final void p() {
        ValueAnimator valueAnimator = this.v;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(0);
            this.v.removeAllUpdateListeners();
            this.v.removeAllListeners();
            this.v.end();
            this.v.cancel();
        }
        ValueAnimator valueAnimator2 = this.s;
        if (valueAnimator2 != null) {
            valueAnimator2.setRepeatCount(0);
            this.s.removeAllUpdateListeners();
            this.s.removeAllListeners();
            this.s.end();
            this.s.cancel();
        }
    }

    public final void j(Canvas canvas) {
        Bitmap bitmap = this.w;
        if (bitmap != null && this.x != null) {
            bitmap.eraseColor(0);
            this.j.setStyle(Paint.Style.FILL);
            int abs = (int) ((((1.0d - (Math.abs(this.t - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
            if (this.A) {
                abs = (int) ((((1.0d - (Math.abs(this.t - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
            }
            this.j.setAlpha(abs);
            Canvas canvas2 = this.x;
            PointF pointF = this.i;
            canvas2.drawCircle(pointF.x, pointF.y, this.g, this.j);
            this.z.reset();
            this.y.save();
            this.y.setLocation(0.0f, 0.0f, -100.0f);
            this.y.rotateY((this.t * 360.0f) + 90.0f);
            this.y.getMatrix(this.z);
            this.y.restore();
            Matrix matrix = this.z;
            PointF pointF2 = this.i;
            matrix.preTranslate(-pointF2.x, -pointF2.y);
            Matrix matrix2 = this.z;
            PointF pointF3 = this.i;
            matrix2.postTranslate(pointF3.x, pointF3.y);
            canvas.drawBitmap(this.w, this.z, null);
        }
    }

    public final void k(Canvas canvas) {
        Bitmap bitmap = this.w;
        if (bitmap != null && this.x != null) {
            bitmap.eraseColor(0);
            this.j.setStyle(Paint.Style.FILL);
            if (this.A != np2.M().a()) {
                this.j.setColor(getResources().getColor(R.color.obfuscated_res_0x7f06045c));
                this.A = np2.M().a();
            }
            this.j.setAlpha(76);
            RectF rectF = this.m;
            PointF pointF = this.i;
            float f = pointF.x;
            float f2 = this.d;
            float f3 = pointF.y;
            rectF.set(f - f2, f3 - f2, f + f2, f3 + f2);
            this.x.drawArc(this.m, -90.0f, this.b * (-360.0f), true, this.j);
            Canvas canvas2 = this.x;
            PointF pointF2 = this.i;
            canvas2.drawCircle(pointF2.x, pointF2.y, this.e, this.k);
            if (this.c > 0.0f) {
                Canvas canvas3 = this.x;
                PointF pointF3 = this.o;
                canvas3.drawCircle(pointF3.x, pointF3.y, 0.75f, this.j);
                this.j.setStyle(Paint.Style.STROKE);
                this.j.setStrokeWidth(xj3.f(getContext(), 1.5f));
                Canvas canvas4 = this.x;
                PointF pointF4 = this.n;
                float f4 = pointF4.x;
                float f5 = pointF4.y;
                PointF pointF5 = this.o;
                canvas4.drawLine(f4, f5, pointF5.x, pointF5.y, this.j);
            }
            canvas.drawBitmap(this.w, 0.0f, 0.0f, (Paint) null);
        }
    }

    public final void l(Canvas canvas) {
        Bitmap bitmap = this.w;
        if (bitmap != null && this.x != null) {
            bitmap.eraseColor(0);
            this.j.setStyle(Paint.Style.FILL);
            this.j.setAlpha((int) (((this.u * 0.3d) + 0.3d) * 255.0d));
            float f = this.n.x + ((float) (this.p / C));
            Canvas canvas2 = this.x;
            PointF pointF = this.i;
            canvas2.drawCircle(pointF.x, pointF.y, this.d, this.j);
            Canvas canvas3 = this.x;
            PointF pointF2 = this.i;
            canvas3.drawCircle(pointF2.x, pointF2.y, this.f, this.k);
            this.x.drawCircle(f, f, 0.75f, this.j);
            this.j.setStyle(Paint.Style.STROKE);
            this.j.setStrokeWidth(xj3.f(getContext(), 1.5f));
            Canvas canvas4 = this.x;
            PointF pointF3 = this.n;
            canvas4.drawLine(pointF3.x, pointF3.y, f, f, this.j);
            this.z.reset();
            this.y.save();
            this.y.setLocation(0.0f, 0.0f, -100.0f);
            this.y.rotateY(this.u * 90.0f);
            this.y.getMatrix(this.z);
            this.y.restore();
            Matrix matrix = this.z;
            PointF pointF4 = this.i;
            matrix.preTranslate(-pointF4.x, -pointF4.y);
            Matrix matrix2 = this.z;
            PointF pointF5 = this.i;
            matrix2.postTranslate(pointF5.x, pointF5.y);
            canvas.drawBitmap(this.w, this.z, null);
        }
    }

    public final void m() {
        this.A = np2.M().a();
        Paint paint = new Paint();
        this.j = paint;
        paint.setAntiAlias(true);
        this.j.setColor(getResources().getColor(R.color.obfuscated_res_0x7f06045c));
        Paint paint2 = new Paint();
        this.k = paint2;
        paint2.setAntiAlias(true);
        this.k.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.y = new Camera();
        this.z = new Matrix();
        i(1);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > getHeight()) {
            this.h = getMeasuredHeight();
        } else {
            this.h = getMeasuredWidth();
        }
        this.d = xj3.f(getContext(), 8.0f);
        this.f = xj3.f(getContext(), 6.5f);
        this.p = xj3.f(getContext(), 5.0f);
        this.g = xj3.f(getContext(), 7.5f);
        float f = this.h / 2.0f;
        this.i.set(f, f);
        float f2 = f + ((float) (this.d / C));
        this.n.set(f2, f2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            this.w = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            this.x = new Canvas(this.w);
        }
    }

    public final void q(long j) {
        i(3);
        if (this.s != null) {
            p();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.s = ofFloat;
        ofFloat.setDuration(j);
        this.s.setInterpolator(new LinearInterpolator());
        this.s.setRepeatCount(-1);
        this.s.setRepeatMode(1);
        this.s.addUpdateListener(new c());
        if (this.q > 0) {
            this.s.addListener(new d());
        } else {
            e eVar = this.l;
            if (eVar != null) {
                eVar.notifyAtLeastRoundsFinished(true);
            }
        }
        if (!this.s.isRunning()) {
            this.s.start();
        }
    }
}
