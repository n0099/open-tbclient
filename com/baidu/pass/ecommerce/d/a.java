package com.baidu.pass.ecommerce.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.baidu.k.a.a;
import com.baidu.sapi2.utils.SapiUtils;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes6.dex */
public class a extends View {
    private static final String v = "LoadCircleView";
    private static final int w = 4097;
    private static final int x = 255;
    private Paint a;
    private Paint b;
    private Paint c;
    private float d;
    private float e;
    private int f;
    private int g;
    private float h;
    private float i;
    private float j;
    private int k;
    private int l;
    private int m;
    private float n;
    private long o;
    private long p;
    private long q;
    private AnimatorSet r;
    private Timer s;
    private d t;
    private boolean u;

    /* renamed from: com.baidu.pass.ecommerce.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    class C0234a implements ValueAnimator.AnimatorUpdateListener {
        C0234a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.a.setShader(new LinearGradient((a.this.l / 2) - a.this.e, 0.0f, (a.this.l / 2) + a.this.e, 0.0f, a.this.getResources().getColor(a.b.sapi_sdk_mms_voice_primary_start), a.this.getResources().getColor(a.b.sapi_sdk_mms_voice_primary_end), Shader.TileMode.MIRROR));
            a.this.b.setShader(new LinearGradient((a.this.l / 2) - a.this.e, 0.0f, (a.this.l / 2) + a.this.e, 0.0f, a.this.getResources().getColor(a.b.sapi_sdk_mms_voice_secondary_start), a.this.getResources().getColor(a.b.sapi_sdk_mms_voice_secondary_end), Shader.TileMode.MIRROR));
        }
    }

    /* loaded from: classes6.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            a.this.j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            a.this.a.setAlpha((int) (a.this.j * 255.0f));
            a.this.b.setAlpha((int) (a.this.i * 255.0f * a.this.j));
            a.this.invalidate();
        }
    }

    /* loaded from: classes6.dex */
    class c extends AnimatorListenerAdapter {

        /* renamed from: com.baidu.pass.ecommerce.d.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        class C0235a extends TimerTask {
            C0235a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                a.this.t.sendEmptyMessage(4097);
            }
        }

        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (a.this.s != null) {
                a.this.s.schedule(new C0235a(), 0L, 16L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class d extends Handler {
        private WeakReference<a> a;

        public d(a aVar) {
            this.a = new WeakReference<>(aVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar;
            if (message.what != 4097 || (aVar = this.a.get()) == null) {
                return;
            }
            aVar.invalidate();
        }
    }

    public a(Context context, float f, int i) {
        this(context, null);
        this.d = f;
        this.k = i;
        c();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        if (this.n == 0.0f) {
            this.l = ((ViewGroup) getParent()).getWidth();
            this.m = ((ViewGroup) getParent()).getHeight();
            if (this.d >= (Math.min(this.l, this.m) / 2) * 0.8f) {
                this.d = (Math.min(this.l, this.m) / 2) * 0.8f;
            }
        }
        this.n += 6.0f;
        if (this.n >= 360.0f) {
            this.n = 0.0f;
        }
        canvas.save();
        canvas.rotate(this.n, this.l / 2, (this.m / 2) + (SapiUtils.dip2px(getContext(), this.h) - 1.0f));
        if (this.k != -1) {
            canvas.drawCircle(this.l / 2, this.m / 2, this.e + SapiUtils.dip2px(getContext(), this.f), this.c);
        }
        canvas.drawCircle(this.l / 2, this.m / 2, this.e, this.a);
        canvas.restore();
        canvas.rotate(this.n, this.l / 2, (this.m / 2) - (SapiUtils.dip2px(getContext(), this.h) - 1.0f));
        canvas.drawCircle(this.l / 2, this.m / 2, this.e, this.b);
    }

    public void setMaskColor(int i) {
        this.k = i;
    }

    private void c() {
        this.t = new d(this);
        if (getContext().getResources().getDisplayMetrics().density <= 2.0f) {
            this.f = 1;
            this.g = 1;
        }
        this.a = new Paint();
        this.a.setAntiAlias(true);
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(this.f);
        this.b = new Paint();
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.STROKE);
        this.b.setStrokeWidth(this.g);
        if (this.k != -1) {
            this.c = new Paint();
            this.c.setAntiAlias(true);
            this.c.setStyle(Paint.Style.FILL);
            this.c.setColor(this.k);
        }
    }

    private void d() {
        this.e = 0.0f;
        this.n = 0.0f;
        this.j = 0.0f;
    }

    public void a() {
        if (!this.u) {
            this.u = true;
            C0234a c0234a = new C0234a();
            float f = this.d;
            float f2 = f / 3.0f;
            float f3 = (f * 23.0f) / 21.0f;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f3);
            ofFloat.setInterpolator(new LinearInterpolator());
            ofFloat.setDuration(this.o);
            ofFloat.addUpdateListener(c0234a);
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f3, this.d);
            ofFloat2.setInterpolator(new LinearInterpolator());
            ofFloat2.setDuration(this.p);
            ofFloat2.addUpdateListener(c0234a);
            ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat3.setInterpolator(new DecelerateInterpolator());
            ofFloat3.setDuration(this.q);
            ofFloat3.addUpdateListener(new b());
            this.r = new AnimatorSet();
            this.r.play(ofFloat3).with(ofFloat);
            this.r.play(ofFloat2).after(ofFloat);
            this.r.start();
            if (this.s == null) {
                try {
                    this.s = new Timer();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            this.r.addListener(new c());
        }
    }

    public void b() {
        if (this.u) {
            this.u = false;
            AnimatorSet animatorSet = this.r;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.r = null;
            }
            Timer timer = this.s;
            if (timer != null) {
                timer.cancel();
                this.s = null;
            }
            this.t.removeMessages(4097);
            d();
        }
    }

    public a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = 2;
        this.g = 2;
        this.h = 1.0f;
        this.i = 0.25f;
        this.j = 0.0f;
        this.n = 0.0f;
        this.o = 175L;
        this.p = 105L;
        this.q = 280L;
        this.u = false;
    }
}
