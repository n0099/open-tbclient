package com.baidu.swan.apps.res.ui.pullrefresh;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.Nullable;
import d.a.m0.a.k;
import d.a.m0.a.v2.n0;
import d.a.m0.a.v2.q;
/* loaded from: classes3.dex */
public class NeutralRefreshAnimView extends View {
    public static final int A;
    public static final boolean w = k.f46983a;
    public static final int x = n0.g(3.5f);
    public static final int y = Color.parseColor("#000000");
    public static final int z;

    /* renamed from: e  reason: collision with root package name */
    public float f11303e;

    /* renamed from: f  reason: collision with root package name */
    public int f11304f;

    /* renamed from: g  reason: collision with root package name */
    public int f11305g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f11306h;

    /* renamed from: i  reason: collision with root package name */
    public Canvas f11307i;
    public Paint j;
    public Paint k;
    public PointF l;
    public int m;
    public ValueAnimator n;
    public ValueAnimator o;
    public AnimatorSet p;
    public float q;
    public float r;
    public ValueAnimator s;
    public ValueAnimator t;
    public int u;
    public int v;

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f11308e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f11309f;

        public a(int i2, int i3) {
            this.f11308e = i2;
            this.f11309f = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            NeutralRefreshAnimView.this.f11306h = Bitmap.createBitmap(this.f11308e, this.f11309f, Bitmap.Config.ARGB_8888);
            NeutralRefreshAnimView.this.f11307i = new Canvas(NeutralRefreshAnimView.this.f11306h);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            NeutralRefreshAnimView.this.q = NeutralRefreshAnimView.A * floatValue;
            if (NeutralRefreshAnimView.w) {
                Log.e("NeutralRefreshAnimView", "mRightBallXPosi=" + NeutralRefreshAnimView.this.q + ",anim value=" + floatValue);
            }
            NeutralRefreshAnimView.this.postInvalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            NeutralRefreshAnimView.this.r = NeutralRefreshAnimView.A * floatValue;
            if (NeutralRefreshAnimView.w) {
                Log.e("NeutralRefreshAnimView", "mLeftBallXPosi=" + NeutralRefreshAnimView.this.r + ",anim value=" + floatValue);
            }
            NeutralRefreshAnimView.this.postInvalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class d implements Animator.AnimatorListener {
        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            NeutralRefreshAnimView.this.n(4);
            NeutralRefreshAnimView.this.postInvalidate();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* loaded from: classes3.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NeutralRefreshAnimView.this.u = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (NeutralRefreshAnimView.w) {
                Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.u);
            }
            NeutralRefreshAnimView.this.postInvalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NeutralRefreshAnimView.this.v = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (NeutralRefreshAnimView.w) {
                Log.e("NeutralRefreshAnimView", "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.u);
            }
            NeutralRefreshAnimView.this.postInvalidate();
        }
    }

    static {
        int g2 = n0.g(18.0f);
        z = g2;
        A = g2 >> 1;
    }

    public NeutralRefreshAnimView(Context context) {
        super(context);
        p();
    }

    public void A() {
        x();
        clearAnimation();
        n(1);
        postInvalidate();
        if (w) {
            Log.e("NeutralRefreshAnimView", "stopAnim");
        }
    }

    public final void n(int i2) {
        this.m = i2;
        if (w) {
            Log.i("NeutralRefreshAnimView", "curr state:" + this.m);
        }
    }

    public final int o(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        if (i2 > 255) {
            return 255;
        }
        return i2;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int i2 = this.m;
        if (i2 == 1) {
            t(canvas);
        } else if (i2 == 2) {
            s(canvas);
        } else if (i2 == 3) {
            v(canvas);
        } else if (i2 == 4) {
            s(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f11304f = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f11305g = measuredHeight;
        this.l.set(this.f11304f >> 1, measuredHeight >> 1);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        q.i(new a(i2, i3), "CreateBitmapOnSizeChanged");
    }

    public final void p() {
        this.l = new PointF();
        this.j = new Paint(1);
        this.k = new Paint(1);
        this.j.setColor(y);
        this.k.setColor(y);
    }

    public void q() {
        if (w) {
            Log.e("NeutralRefreshAnimView", "onRefreshCompleteAnim");
        }
        A();
        n(3);
        u();
    }

    public void r() {
        if (w) {
            Log.e("NeutralRefreshAnimView", "onRefreshingAnim");
        }
        n(2);
        w();
    }

    public final void s(Canvas canvas) {
        Bitmap bitmap = this.f11306h;
        if (bitmap == null || this.f11307i == null) {
            return;
        }
        bitmap.eraseColor(0);
        this.k.setAlpha(77);
        Canvas canvas2 = this.f11307i;
        PointF pointF = this.l;
        canvas2.drawCircle(pointF.x + this.q, pointF.y, x, this.k);
        this.j.setAlpha(26);
        Canvas canvas3 = this.f11307i;
        PointF pointF2 = this.l;
        canvas3.drawCircle(pointF2.x + this.r, pointF2.y, x, this.j);
        canvas.drawBitmap(this.f11306h, 0.0f, 0.0f, (Paint) null);
        if (w) {
            Log.e("NeutralRefreshAnimView", "performOnRefreshingAnim");
        }
    }

    public void setAnimPercent(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.f11303e = f2;
        n(1);
        postInvalidate();
        if (w) {
            Log.e("NeutralRefreshAnimView", "setAnimPercent, percent = " + f2);
        }
    }

    public final void t(Canvas canvas) {
        if (w) {
            Log.e("NeutralRefreshAnimView", "performPullToRefreshAnim");
        }
        Bitmap bitmap = this.f11306h;
        if (bitmap == null || this.f11307i == null) {
            return;
        }
        bitmap.eraseColor(0);
        float f2 = this.f11303e;
        if (f2 == 0.0f) {
            this.k.setAlpha(0);
            Canvas canvas2 = this.f11307i;
            PointF pointF = this.l;
            canvas2.drawCircle(pointF.x, pointF.y, x, this.k);
            canvas.drawBitmap(this.f11306h, 0.0f, 0.0f, (Paint) null);
        } else if (f2 <= 0.5f) {
            int i2 = (int) (f2 * 77.0f);
            this.k.setAlpha(i2);
            Canvas canvas3 = this.f11307i;
            PointF pointF2 = this.l;
            canvas3.drawCircle(pointF2.x, pointF2.y, x, this.k);
            canvas.drawBitmap(this.f11306h, 0.0f, 0.0f, (Paint) null);
            if (w) {
                Log.e("NeutralRefreshAnimView", "first level,alpha=" + i2);
            }
        } else if (f2 >= 1.0f) {
            if (f2 == 1.0f) {
                this.j.setAlpha(26);
                this.k.setAlpha(77);
                Canvas canvas4 = this.f11307i;
                PointF pointF3 = this.l;
                canvas4.drawCircle(pointF3.x + A, pointF3.y, x, this.k);
                Canvas canvas5 = this.f11307i;
                PointF pointF4 = this.l;
                canvas5.drawCircle(pointF4.x - A, pointF4.y, x, this.j);
                canvas.drawBitmap(this.f11306h, 0.0f, 0.0f, (Paint) null);
                if (w) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.f11303e);
                }
            }
        } else {
            int o = o((int) (f2 * 77.0f));
            this.k.setAlpha(o);
            float f3 = (this.f11303e - 0.5f) * 2.0f;
            int o2 = o((int) (26.0f * f3));
            this.j.setAlpha(o2);
            Canvas canvas6 = this.f11307i;
            PointF pointF5 = this.l;
            canvas6.drawCircle(pointF5.x + (A * f3), pointF5.y, x, this.k);
            Canvas canvas7 = this.f11307i;
            PointF pointF6 = this.l;
            canvas7.drawCircle(pointF6.x - (A * f3), pointF6.y, x, this.j);
            canvas.drawBitmap(this.f11306h, 0.0f, 0.0f, (Paint) null);
            if (w) {
                Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.f11303e);
                Log.e("NeutralRefreshAnimView", "second level,rightBallAlpha=" + o);
                Log.e("NeutralRefreshAnimView", "second level,leftBallAlpha=" + o2);
                Log.e("NeutralRefreshAnimView", "second level,fraction=" + f3);
                Log.e("NeutralRefreshAnimView", "second level,HALF_MAX_DISTANCE * fraction=" + (((float) A) * f3));
            }
        }
    }

    public final void u() {
        ValueAnimator ofInt = ValueAnimator.ofInt(26, 0);
        this.s = ofInt;
        ofInt.setDuration(300L);
        this.s.addUpdateListener(new e());
        if (!this.s.isRunning()) {
            this.s.start();
        }
        ValueAnimator ofInt2 = ValueAnimator.ofInt(77, 0);
        this.t = ofInt2;
        ofInt2.setDuration(300L);
        this.t.addUpdateListener(new f());
        if (this.t.isRunning()) {
            return;
        }
        this.t.start();
    }

    public final void v(Canvas canvas) {
        if (w) {
            Log.e("NeutralRefreshAnimView", "performRefreshCompleteAnim");
        }
        Bitmap bitmap = this.f11306h;
        if (bitmap == null || this.f11307i == null) {
            return;
        }
        bitmap.eraseColor(0);
        this.u = o(this.u);
        int o = o(this.v);
        this.v = o;
        this.k.setAlpha(o);
        this.j.setAlpha(this.u);
        Canvas canvas2 = this.f11307i;
        PointF pointF = this.l;
        canvas2.drawCircle(pointF.x + this.q, pointF.y, x, this.k);
        this.j.setAlpha(this.u);
        Canvas canvas3 = this.f11307i;
        PointF pointF2 = this.l;
        canvas3.drawCircle(pointF2.x + this.r, pointF2.y, x, this.j);
        canvas.drawBitmap(this.f11306h, 0.0f, 0.0f, (Paint) null);
        if (w) {
            Log.e("NeutralRefreshAnimView", "Complete:mAlpha=" + this.u);
            Log.e("NeutralRefreshAnimView", "Complete:mRightBallXPosi=" + this.q);
            Log.e("NeutralRefreshAnimView", "Complete:mLeftBallXPosi=" + this.r);
        }
    }

    public final void w() {
        x();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.o = ofFloat;
        ofFloat.setDuration(480L);
        this.o.setRepeatMode(2);
        this.o.setRepeatCount(-1);
        this.o.setInterpolator(new AccelerateDecelerateInterpolator());
        this.o.addUpdateListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.n = ofFloat2;
        ofFloat2.setDuration(480L);
        this.n.setRepeatMode(2);
        this.n.setRepeatCount(-1);
        this.n.setInterpolator(new AccelerateDecelerateInterpolator());
        this.n.addUpdateListener(new c());
        AnimatorSet animatorSet = new AnimatorSet();
        this.p = animatorSet;
        animatorSet.playTogether(this.n, this.o);
        this.p.setDuration(480L);
        this.p.addListener(new d());
        if (this.p.isRunning()) {
            return;
        }
        this.p.start();
    }

    public final void x() {
        y(this.n, true);
        y(this.o, true);
        y(this.s, false);
        y(this.t, false);
        AnimatorSet animatorSet = this.p;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.p.end();
            this.p.cancel();
        }
        if (w) {
            Log.e("NeutralRefreshAnimView", "resetAnimator");
        }
    }

    public final void y(ValueAnimator valueAnimator, boolean z2) {
        if (valueAnimator != null) {
            if (z2) {
                valueAnimator.setRepeatCount(0);
            }
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.end();
            valueAnimator.cancel();
        }
    }

    public boolean z(int i2) {
        Paint paint;
        if (this.k == null || (paint = this.j) == null) {
            return false;
        }
        paint.setColor(i2);
        this.k.setColor(i2);
        return true;
    }

    public NeutralRefreshAnimView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        p();
    }
}
