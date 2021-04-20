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
import d.b.g0.a.i2.h0;
/* loaded from: classes3.dex */
public class RefreshingAnimView extends View {
    public static final double G = Math.sqrt(2.0d);
    public Bitmap A;
    public Canvas B;
    public Camera C;
    public Matrix D;
    public boolean E;
    public int F;

    /* renamed from: e  reason: collision with root package name */
    public float f12242e;

    /* renamed from: f  reason: collision with root package name */
    public float f12243f;

    /* renamed from: g  reason: collision with root package name */
    public float f12244g;

    /* renamed from: h  reason: collision with root package name */
    public float f12245h;
    public float i;
    public float j;
    public float k;
    public float l;
    public PointF m;
    public Paint n;
    public Paint o;
    public e p;
    public RectF q;
    public PointF r;
    public PointF s;
    public float t;
    public int u;
    public int v;
    public ValueAnimator w;
    public float x;
    public float y;
    public ValueAnimator z;

    /* loaded from: classes3.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RefreshingAnimView.this.o(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            RefreshingAnimView.this.n(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes3.dex */
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
            if (RefreshingAnimView.this.v <= RefreshingAnimView.this.u || RefreshingAnimView.this.p == null) {
                return;
            }
            RefreshingAnimView.this.p.a(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(boolean z);
    }

    public RefreshingAnimView(Context context) {
        super(context);
        this.f12242e = 0.0f;
        this.f12243f = 0.0f;
        this.f12244g = 0.0f;
        this.f12245h = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = new PointF();
        this.q = new RectF();
        new PointF();
        this.r = new PointF();
        this.s = new PointF();
        this.t = 0.0f;
        this.u = 0;
        this.v = 1;
        this.w = null;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = null;
        this.E = false;
        this.F = 0;
        m();
    }

    public static /* synthetic */ int e(RefreshingAnimView refreshingAnimView) {
        int i = refreshingAnimView.v;
        refreshingAnimView.v = i + 1;
        return i;
    }

    public final void h() {
        float f2 = this.f12242e;
        this.f12243f = f2;
        if (f2 < 0.5f) {
            this.f12244g = 0.0f;
            this.i = 0.0f;
            return;
        }
        this.i = ((f2 - 0.5f) / 0.5f) * this.j;
        if (f2 < 0.625f) {
            this.f12244g = 0.0f;
            return;
        }
        float f3 = (f2 - 0.625f) / 0.375f;
        this.f12244g = f3;
        PointF pointF = this.r;
        float f4 = pointF.x;
        float f5 = this.t;
        double d2 = G;
        float f6 = pointF.y + ((float) ((f5 * f3) / d2));
        this.s.set(f4 + ((float) ((f5 * f3) / d2)), f6);
    }

    public final void i(int i) {
        this.F = i;
    }

    public final void j(Canvas canvas) {
        Bitmap bitmap = this.A;
        if (bitmap == null || this.B == null) {
            return;
        }
        bitmap.eraseColor(0);
        this.n.setStyle(Paint.Style.FILL);
        int abs = (int) ((((1.0d - (Math.abs(this.x - 0.5d) * 2.0d)) * 0.3d) + 0.3d) * 255.0d);
        if (this.E) {
            abs = (int) ((((1.0d - (Math.abs(this.x - 0.5d) * 2.0d)) * 0.2d) + 0.1d) * 255.0d);
        }
        this.n.setAlpha(abs);
        Canvas canvas2 = this.B;
        PointF pointF = this.m;
        canvas2.drawCircle(pointF.x, pointF.y, this.k, this.n);
        this.D.reset();
        this.C.save();
        this.C.setLocation(0.0f, 0.0f, -100.0f);
        this.C.rotateY((this.x * 360.0f) + 90.0f);
        this.C.getMatrix(this.D);
        this.C.restore();
        Matrix matrix = this.D;
        PointF pointF2 = this.m;
        matrix.preTranslate(-pointF2.x, -pointF2.y);
        Matrix matrix2 = this.D;
        PointF pointF3 = this.m;
        matrix2.postTranslate(pointF3.x, pointF3.y);
        canvas.drawBitmap(this.A, this.D, null);
    }

    public final void k(Canvas canvas) {
        Bitmap bitmap = this.A;
        if (bitmap == null || this.B == null) {
            return;
        }
        bitmap.eraseColor(0);
        this.n.setStyle(Paint.Style.FILL);
        if (this.E != d.b.g0.a.w0.a.z().a()) {
            this.n.setColor(getResources().getColor(d.b.g0.a.c.aiapps_pull_loading_refresh_anim_color));
            this.E = d.b.g0.a.w0.a.z().a();
        }
        this.n.setAlpha(76);
        RectF rectF = this.q;
        PointF pointF = this.m;
        float f2 = pointF.x;
        float f3 = this.f12245h;
        float f4 = pointF.y;
        rectF.set(f2 - f3, f4 - f3, f2 + f3, f4 + f3);
        this.B.drawArc(this.q, -90.0f, this.f12243f * (-360.0f), true, this.n);
        Canvas canvas2 = this.B;
        PointF pointF2 = this.m;
        canvas2.drawCircle(pointF2.x, pointF2.y, this.i, this.o);
        if (this.f12244g > 0.0f) {
            Canvas canvas3 = this.B;
            PointF pointF3 = this.s;
            canvas3.drawCircle(pointF3.x, pointF3.y, 0.75f, this.n);
            this.n.setStyle(Paint.Style.STROKE);
            this.n.setStrokeWidth(h0.e(getContext(), 1.5f));
            Canvas canvas4 = this.B;
            PointF pointF4 = this.r;
            float f5 = pointF4.x;
            float f6 = pointF4.y;
            PointF pointF5 = this.s;
            canvas4.drawLine(f5, f6, pointF5.x, pointF5.y, this.n);
        }
        canvas.drawBitmap(this.A, 0.0f, 0.0f, (Paint) null);
    }

    public final void l(Canvas canvas) {
        Bitmap bitmap = this.A;
        if (bitmap == null || this.B == null) {
            return;
        }
        bitmap.eraseColor(0);
        this.n.setStyle(Paint.Style.FILL);
        this.n.setAlpha((int) (((this.y * 0.3d) + 0.3d) * 255.0d));
        float f2 = this.r.x + ((float) (this.t / G));
        Canvas canvas2 = this.B;
        PointF pointF = this.m;
        canvas2.drawCircle(pointF.x, pointF.y, this.f12245h, this.n);
        Canvas canvas3 = this.B;
        PointF pointF2 = this.m;
        canvas3.drawCircle(pointF2.x, pointF2.y, this.j, this.o);
        this.B.drawCircle(f2, f2, 0.75f, this.n);
        this.n.setStyle(Paint.Style.STROKE);
        this.n.setStrokeWidth(h0.e(getContext(), 1.5f));
        Canvas canvas4 = this.B;
        PointF pointF3 = this.r;
        canvas4.drawLine(pointF3.x, pointF3.y, f2, f2, this.n);
        this.D.reset();
        this.C.save();
        this.C.setLocation(0.0f, 0.0f, -100.0f);
        this.C.rotateY(this.y * 90.0f);
        this.C.getMatrix(this.D);
        this.C.restore();
        Matrix matrix = this.D;
        PointF pointF4 = this.m;
        matrix.preTranslate(-pointF4.x, -pointF4.y);
        Matrix matrix2 = this.D;
        PointF pointF5 = this.m;
        matrix2.postTranslate(pointF5.x, pointF5.y);
        canvas.drawBitmap(this.A, this.D, null);
    }

    public final void m() {
        this.E = d.b.g0.a.w0.a.z().a();
        Paint paint = new Paint();
        this.n = paint;
        paint.setAntiAlias(true);
        this.n.setColor(getResources().getColor(d.b.g0.a.c.aiapps_pull_loading_refresh_anim_color));
        Paint paint2 = new Paint();
        this.o = paint2;
        paint2.setAntiAlias(true);
        this.o.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.C = new Camera();
        this.D = new Matrix();
        i(1);
    }

    public final void n(float f2) {
        if (f2 < 0.2f) {
            this.x = (f2 / 0.2f) * 0.5f;
        } else {
            this.x = (((f2 - 0.2f) / 0.8f) * 0.5f) + 0.5f;
        }
        postInvalidate();
    }

    public final void o(float f2) {
        this.y = f2;
        postInvalidate();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        p();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int i = this.F;
        if (i == 1) {
            k(canvas);
        } else if (i == 2) {
            l(canvas);
        } else if (i == 3) {
            j(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (getMeasuredWidth() > getHeight()) {
            this.l = getMeasuredHeight();
        } else {
            this.l = getMeasuredWidth();
        }
        this.f12245h = h0.e(getContext(), 8.0f);
        this.j = h0.e(getContext(), 6.5f);
        this.t = h0.e(getContext(), 5.0f);
        this.k = h0.e(getContext(), 7.5f);
        float f2 = this.l / 2.0f;
        this.m.set(f2, f2);
        float f3 = f2 + ((float) (this.f12245h / G));
        this.r.set(f3, f3);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.A = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.B = new Canvas(this.A);
    }

    public final void p() {
        ValueAnimator valueAnimator = this.z;
        if (valueAnimator != null) {
            valueAnimator.setRepeatCount(0);
            this.z.removeAllUpdateListeners();
            this.z.removeAllListeners();
            this.z.end();
            this.z.cancel();
        }
        ValueAnimator valueAnimator2 = this.w;
        if (valueAnimator2 != null) {
            valueAnimator2.setRepeatCount(0);
            this.w.removeAllUpdateListeners();
            this.w.removeAllListeners();
            this.w.end();
            this.w.cancel();
        }
    }

    public final void q(long j) {
        i(3);
        if (this.w != null) {
            p();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.w = ofFloat;
        ofFloat.setDuration(j);
        this.w.setInterpolator(new LinearInterpolator());
        this.w.setRepeatCount(-1);
        this.w.setRepeatMode(1);
        this.w.addUpdateListener(new c());
        if (this.u > 0) {
            this.w.addListener(new d());
        } else {
            e eVar = this.p;
            if (eVar != null) {
                eVar.a(true);
            }
        }
        if (this.w.isRunning()) {
            return;
        }
        this.w.start();
    }

    public void r() {
        s(300L);
    }

    public final void s(long j) {
        i(2);
        if (this.z != null) {
            p();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.z = ofFloat;
        ofFloat.setDuration(j);
        this.z.setInterpolator(new LinearInterpolator());
        this.z.addUpdateListener(new a());
        this.z.addListener(new b());
        if (this.z.isRunning()) {
            return;
        }
        this.z.start();
    }

    public void setAnimPercent(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.f12242e = f2;
        h();
        postInvalidate();
    }

    public void setAtLeastRotateRounds(int i) {
        this.u = i;
    }

    public void setOnLoadingAnimationListener(e eVar) {
        this.p = eVar;
    }

    public void t() {
        p();
        clearAnimation();
        this.f12242e = 0.0f;
        this.v = 1;
        i(1);
        postInvalidate();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12242e = 0.0f;
        this.f12243f = 0.0f;
        this.f12244g = 0.0f;
        this.f12245h = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = new PointF();
        this.q = new RectF();
        new PointF();
        this.r = new PointF();
        this.s = new PointF();
        this.t = 0.0f;
        this.u = 0;
        this.v = 1;
        this.w = null;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = null;
        this.E = false;
        this.F = 0;
        m();
    }

    public RefreshingAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12242e = 0.0f;
        this.f12243f = 0.0f;
        this.f12244g = 0.0f;
        this.f12245h = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = 0.0f;
        this.m = new PointF();
        this.q = new RectF();
        new PointF();
        this.r = new PointF();
        this.s = new PointF();
        this.t = 0.0f;
        this.u = 0;
        this.v = 1;
        this.w = null;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = null;
        this.E = false;
        this.F = 0;
        m();
    }
}
