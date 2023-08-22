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
import com.baidu.tieba.nr1;
import com.baidu.tieba.uo3;
import com.baidu.tieba.xn3;
/* loaded from: classes4.dex */
public class NeutralRefreshAnimView extends View {
    public static final boolean s = nr1.a;
    public static final int t = uo3.g(3.5f);
    public static final int u = Color.parseColor("#000000");
    public static final int v;
    public static final int w;
    public float a;
    public int b;
    public int c;
    public Bitmap d;
    public Canvas e;
    public Paint f;
    public Paint g;
    public PointF h;
    public int i;
    public ValueAnimator j;
    public ValueAnimator k;
    public AnimatorSet l;
    public float m;
    public float n;
    public ValueAnimator o;
    public ValueAnimator p;
    public int q;
    public int r;

    public final int o(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 255) {
            return 255;
        }
        return i;
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;

        public a(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            NeutralRefreshAnimView.this.d = Bitmap.createBitmap(this.a, this.b, Bitmap.Config.ARGB_8888);
            NeutralRefreshAnimView.this.e = new Canvas(NeutralRefreshAnimView.this.d);
        }
    }

    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            NeutralRefreshAnimView.this.m = NeutralRefreshAnimView.w * floatValue;
            if (NeutralRefreshAnimView.s) {
                Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "mRightBallXPosi=" + NeutralRefreshAnimView.this.m + ",anim value=" + floatValue);
            }
            NeutralRefreshAnimView.this.postInvalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            NeutralRefreshAnimView.this.n = NeutralRefreshAnimView.w * floatValue;
            if (NeutralRefreshAnimView.s) {
                Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "mLeftBallXPosi=" + NeutralRefreshAnimView.this.n + ",anim value=" + floatValue);
            }
            NeutralRefreshAnimView.this.postInvalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Animator.AnimatorListener {
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        public d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            NeutralRefreshAnimView.this.n(4);
            NeutralRefreshAnimView.this.postInvalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NeutralRefreshAnimView.this.q = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (NeutralRefreshAnimView.s) {
                Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.q);
            }
            NeutralRefreshAnimView.this.postInvalidate();
        }
    }

    /* loaded from: classes4.dex */
    public class f implements ValueAnimator.AnimatorUpdateListener {
        public f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NeutralRefreshAnimView.this.r = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (NeutralRefreshAnimView.s) {
                Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "Complete anim: mAlpha=" + NeutralRefreshAnimView.this.q);
            }
            NeutralRefreshAnimView.this.postInvalidate();
        }
    }

    static {
        int g = uo3.g(18.0f);
        v = g;
        w = g >> 1;
    }

    public void A() {
        x();
        clearAnimation();
        n(1);
        postInvalidate();
        if (s) {
            Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "stopAnim");
        }
    }

    public final void p() {
        this.h = new PointF();
        this.f = new Paint(1);
        this.g = new Paint(1);
        this.f.setColor(u);
        this.g.setColor(u);
    }

    public void q() {
        if (s) {
            Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "onRefreshCompleteAnim");
        }
        A();
        n(3);
        u();
    }

    public void r() {
        if (s) {
            Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "onRefreshingAnim");
        }
        n(2);
        w();
    }

    public NeutralRefreshAnimView(Context context) {
        super(context);
        p();
    }

    public final void n(int i) {
        this.i = i;
        if (s) {
            Log.i(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "curr state:" + this.i);
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        int i = this.i;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        s(canvas);
                    }
                } else {
                    v(canvas);
                }
            } else {
                s(canvas);
            }
        } else {
            t(canvas);
        }
        canvas.restore();
    }

    public boolean z(int i) {
        Paint paint;
        if (this.g != null && (paint = this.f) != null) {
            paint.setColor(i);
            this.g.setColor(i);
            return true;
        }
        return false;
    }

    public NeutralRefreshAnimView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        p();
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.b = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.c = measuredHeight;
        this.h.set(this.b >> 1, measuredHeight >> 1);
    }

    public final void y(ValueAnimator valueAnimator, boolean z) {
        if (valueAnimator != null) {
            if (z) {
                valueAnimator.setRepeatCount(0);
            }
            valueAnimator.removeAllUpdateListeners();
            valueAnimator.removeAllListeners();
            valueAnimator.end();
            valueAnimator.cancel();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0) {
            xn3.j(new a(i, i2), com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.CREATEBITMAP_RUNNABLE_NAME);
        }
    }

    public final void s(Canvas canvas) {
        Bitmap bitmap = this.d;
        if (bitmap != null && this.e != null) {
            bitmap.eraseColor(0);
            this.g.setAlpha(77);
            Canvas canvas2 = this.e;
            PointF pointF = this.h;
            canvas2.drawCircle(pointF.x + this.m, pointF.y, t, this.g);
            this.f.setAlpha(26);
            Canvas canvas3 = this.e;
            PointF pointF2 = this.h;
            canvas3.drawCircle(pointF2.x + this.n, pointF2.y, t, this.f);
            canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint) null);
            if (s) {
                Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "performOnRefreshingAnim");
            }
        }
    }

    public void setAnimPercent(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.a = f2;
        n(1);
        postInvalidate();
        if (s) {
            Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "setAnimPercent, percent = " + f2);
        }
    }

    public final void t(Canvas canvas) {
        if (s) {
            Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "performPullToRefreshAnim");
        }
        Bitmap bitmap = this.d;
        if (bitmap != null && this.e != null) {
            bitmap.eraseColor(0);
            float f2 = this.a;
            if (f2 == 0.0f) {
                this.g.setAlpha(0);
                Canvas canvas2 = this.e;
                PointF pointF = this.h;
                canvas2.drawCircle(pointF.x, pointF.y, t, this.g);
                canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint) null);
            } else if (f2 <= 0.5f) {
                int i = (int) (f2 * 77.0f);
                this.g.setAlpha(i);
                Canvas canvas3 = this.e;
                PointF pointF2 = this.h;
                canvas3.drawCircle(pointF2.x, pointF2.y, t, this.g);
                canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint) null);
                if (s) {
                    Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "first level,alpha=" + i);
                }
            } else if (f2 < 1.0f) {
                int o = o((int) (f2 * 77.0f));
                this.g.setAlpha(o);
                float f3 = (this.a - 0.5f) * 2.0f;
                int o2 = o((int) (26.0f * f3));
                this.f.setAlpha(o2);
                Canvas canvas4 = this.e;
                PointF pointF3 = this.h;
                canvas4.drawCircle(pointF3.x + (w * f3), pointF3.y, t, this.g);
                Canvas canvas5 = this.e;
                PointF pointF4 = this.h;
                canvas5.drawCircle(pointF4.x - (w * f3), pointF4.y, t, this.f);
                canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint) null);
                if (s) {
                    Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "second level,mAnimPercent=" + this.a);
                    Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "second level,rightBallAlpha=" + o);
                    Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "second level,leftBallAlpha=" + o2);
                    Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "second level,fraction=" + f3);
                    Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "second level,HALF_MAX_DISTANCE * fraction=" + (((float) w) * f3));
                }
            } else if (f2 == 1.0f) {
                this.f.setAlpha(26);
                this.g.setAlpha(77);
                Canvas canvas6 = this.e;
                PointF pointF5 = this.h;
                canvas6.drawCircle(pointF5.x + w, pointF5.y, t, this.g);
                Canvas canvas7 = this.e;
                PointF pointF6 = this.h;
                canvas7.drawCircle(pointF6.x - w, pointF6.y, t, this.f);
                canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint) null);
                if (s) {
                    Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "third level,mAnimPercent=" + this.a);
                }
            }
        }
    }

    public final void u() {
        ValueAnimator ofInt = ValueAnimator.ofInt(26, 0);
        this.o = ofInt;
        ofInt.setDuration(300L);
        this.o.addUpdateListener(new e());
        if (!this.o.isRunning()) {
            this.o.start();
        }
        ValueAnimator ofInt2 = ValueAnimator.ofInt(77, 0);
        this.p = ofInt2;
        ofInt2.setDuration(300L);
        this.p.addUpdateListener(new f());
        if (!this.p.isRunning()) {
            this.p.start();
        }
    }

    public final void v(Canvas canvas) {
        if (s) {
            Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "performRefreshCompleteAnim");
        }
        Bitmap bitmap = this.d;
        if (bitmap != null && this.e != null) {
            bitmap.eraseColor(0);
            this.q = o(this.q);
            int o = o(this.r);
            this.r = o;
            this.g.setAlpha(o);
            this.f.setAlpha(this.q);
            Canvas canvas2 = this.e;
            PointF pointF = this.h;
            canvas2.drawCircle(pointF.x + this.m, pointF.y, t, this.g);
            this.f.setAlpha(this.q);
            Canvas canvas3 = this.e;
            PointF pointF2 = this.h;
            canvas3.drawCircle(pointF2.x + this.n, pointF2.y, t, this.f);
            canvas.drawBitmap(this.d, 0.0f, 0.0f, (Paint) null);
            if (s) {
                Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "Complete:mAlpha=" + this.q);
                Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "Complete:mRightBallXPosi=" + this.m);
                Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "Complete:mLeftBallXPosi=" + this.n);
            }
        }
    }

    public final void w() {
        x();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, -1.0f);
        this.k = ofFloat;
        ofFloat.setDuration(480L);
        this.k.setRepeatMode(2);
        this.k.setRepeatCount(-1);
        this.k.setInterpolator(new AccelerateDecelerateInterpolator());
        this.k.addUpdateListener(new b());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(-1.0f, 1.0f);
        this.j = ofFloat2;
        ofFloat2.setDuration(480L);
        this.j.setRepeatMode(2);
        this.j.setRepeatCount(-1);
        this.j.setInterpolator(new AccelerateDecelerateInterpolator());
        this.j.addUpdateListener(new c());
        AnimatorSet animatorSet = new AnimatorSet();
        this.l = animatorSet;
        animatorSet.playTogether(this.j, this.k);
        this.l.setDuration(480L);
        this.l.addListener(new d());
        if (!this.l.isRunning()) {
            this.l.start();
        }
    }

    public final void x() {
        y(this.j, true);
        y(this.k, true);
        y(this.o, false);
        y(this.p, false);
        AnimatorSet animatorSet = this.l;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
            this.l.end();
            this.l.cancel();
        }
        if (s) {
            Log.e(com.baidu.searchbox.ui.pullrefresh.NeutralRefreshAnimView.TAG, "resetAnimator");
        }
    }
}
