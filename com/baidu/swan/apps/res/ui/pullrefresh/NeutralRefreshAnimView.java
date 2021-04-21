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
import d.b.h0.a.i2.h0;
import d.b.h0.a.i2.p;
import d.b.h0.a.k;
/* loaded from: classes3.dex */
public class NeutralRefreshAnimView extends View {
    public static final int A;
    public static final boolean w = k.f45772a;
    public static final int x = h0.f(3.5f);
    public static final int y = Color.parseColor("#000000");
    public static final int z;

    /* renamed from: e  reason: collision with root package name */
    public float f12207e;

    /* renamed from: f  reason: collision with root package name */
    public int f12208f;

    /* renamed from: g  reason: collision with root package name */
    public int f12209g;

    /* renamed from: h  reason: collision with root package name */
    public Bitmap f12210h;
    public Canvas i;
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
        public final /* synthetic */ int f12211e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f12212f;

        public a(int i, int i2) {
            this.f12211e = i;
            this.f12212f = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NeutralRefreshAnimView.this.f12210h = Bitmap.createBitmap(this.f12211e, this.f12212f, Bitmap.Config.ARGB_8888);
            NeutralRefreshAnimView.this.i = new Canvas(NeutralRefreshAnimView.this.f12210h);
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
        int f2 = h0.f(18.0f);
        z = f2;
        A = f2 >> 1;
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

    public final void n(int i) {
        this.m = i;
        if (w) {
            Log.i("NeutralRefreshAnimView", "curr state:" + this.m);
        }
    }

    public final int o(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int i = this.m;
        if (i == 1) {
            t(canvas);
        } else if (i == 2) {
            s(canvas);
        } else if (i == 3) {
            v(canvas);
        } else if (i == 4) {
            s(canvas);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f12208f = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.f12209g = measuredHeight;
        this.l.set(this.f12208f >> 1, measuredHeight >> 1);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i <= 0 || i2 <= 0) {
            return;
        }
        p.j(new a(i, i2), "CreateBitmapOnSizeChanged");
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
        Bitmap bitmap = this.f12210h;
        if (bitmap == null || this.i == null) {
            return;
        }
        bitmap.eraseColor(0);
        this.k.setAlpha(77);
        Canvas canvas2 = this.i;
        PointF pointF = this.l;
        canvas2.drawCircle(pointF.x + this.q, pointF.y, x, this.k);
        this.j.setAlpha(26);
        Canvas canvas3 = this.i;
        PointF pointF2 = this.l;
        canvas3.drawCircle(pointF2.x + this.r, pointF2.y, x, this.j);
        canvas.drawBitmap(this.f12210h, 0.0f, 0.0f, (Paint) null);
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
        this.f12207e = f2;
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
        Bitmap bitmap = this.f12210h;
        if (bitmap == null || this.i == null) {
            return;
        }
        bitmap.eraseColor(0);
        float f2 = this.f12207e;
        if (f2 == 0.0f) {
            this.k.setAlpha(0);
            Canvas canvas2 = this.i;
            PointF pointF = this.l;
            canvas2.drawCircle(pointF.x, pointF.y, x, this.k);
            canvas.drawBitmap(this.f12210h, 0.0f, 0.0f, (Paint) null);
        } else if (f2 <= 0.5f) {
            int i = (int) (f2 * 77.0f);
            this.k.setAlpha(i);
            Canvas canvas3 = this.i;
            PointF pointF2 = this.l;
            canvas3.drawCircle(pointF2.x, pointF2.y, x, this.k);
            canvas.drawBitmap(this.f12210h, 0.0f, 0.0f, (Paint) null);
            if (w) {
                Log.e("NeutralRefreshAnimView", "first level,alpha=" + i);
            }
        } else if (f2 >= 1.0f) {
            if (f2 == 1.0f) {
                this.j.setAlpha(26);
                this.k.setAlpha(77);
                Canvas canvas4 = this.i;
                PointF pointF3 = this.l;
                canvas4.drawCircle(pointF3.x + A, pointF3.y, x, this.k);
                Canvas canvas5 = this.i;
                PointF pointF4 = this.l;
                canvas5.drawCircle(pointF4.x - A, pointF4.y, x, this.j);
                canvas.drawBitmap(this.f12210h, 0.0f, 0.0f, (Paint) null);
                if (w) {
                    Log.e("NeutralRefreshAnimView", "third level,mAnimPercent=" + this.f12207e);
                }
            }
        } else {
            int o = o((int) (f2 * 77.0f));
            this.k.setAlpha(o);
            float f3 = (this.f12207e - 0.5f) * 2.0f;
            int o2 = o((int) (26.0f * f3));
            this.j.setAlpha(o2);
            Canvas canvas6 = this.i;
            PointF pointF5 = this.l;
            canvas6.drawCircle(pointF5.x + (A * f3), pointF5.y, x, this.k);
            Canvas canvas7 = this.i;
            PointF pointF6 = this.l;
            canvas7.drawCircle(pointF6.x - (A * f3), pointF6.y, x, this.j);
            canvas.drawBitmap(this.f12210h, 0.0f, 0.0f, (Paint) null);
            if (w) {
                Log.e("NeutralRefreshAnimView", "second level,mAnimPercent=" + this.f12207e);
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
        Bitmap bitmap = this.f12210h;
        if (bitmap == null || this.i == null) {
            return;
        }
        bitmap.eraseColor(0);
        this.u = o(this.u);
        int o = o(this.v);
        this.v = o;
        this.k.setAlpha(o);
        this.j.setAlpha(this.u);
        Canvas canvas2 = this.i;
        PointF pointF = this.l;
        canvas2.drawCircle(pointF.x + this.q, pointF.y, x, this.k);
        this.j.setAlpha(this.u);
        Canvas canvas3 = this.i;
        PointF pointF2 = this.l;
        canvas3.drawCircle(pointF2.x + this.r, pointF2.y, x, this.j);
        canvas.drawBitmap(this.f12210h, 0.0f, 0.0f, (Paint) null);
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

    public boolean z(int i) {
        Paint paint;
        if (this.k == null || (paint = this.j) == null) {
            return false;
        }
        paint.setColor(i);
        this.k.setColor(i);
        return true;
    }

    public NeutralRefreshAnimView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        p();
    }
}
