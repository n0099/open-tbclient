package com.baidu.ar.ui.speech;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;
/* loaded from: classes3.dex */
public class SpeechCircleView extends View {
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
    private TimerTask t;
    private a u;
    private boolean v;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a extends Handler {
        private WeakReference<SpeechCircleView> a;

        public a(SpeechCircleView speechCircleView) {
            this.a = new WeakReference<>(speechCircleView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SpeechCircleView speechCircleView;
            if (message.what != 4097 || (speechCircleView = this.a.get()) == null) {
                return;
            }
            speechCircleView.invalidate();
        }
    }

    public SpeechCircleView(Context context) {
        this(context, null);
    }

    public SpeechCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpeechCircleView(Context context, AttributeSet attributeSet, int i) {
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
        this.v = false;
        c();
    }

    public static float a(Context context, float f) {
        return (context.getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    private void c() {
        this.u = new a(this);
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
        if (this.v) {
            return;
        }
        this.v = true;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.ar.ui.speech.SpeechCircleView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SpeechCircleView.this.e = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                SpeechCircleView.this.a.setShader(new LinearGradient((SpeechCircleView.this.l / 2) - SpeechCircleView.this.e, 0.0f, (SpeechCircleView.this.l / 2) + SpeechCircleView.this.e, 0.0f, Color.parseColor("#00c6ff"), Color.parseColor("#00baff"), Shader.TileMode.MIRROR));
                SpeechCircleView.this.b.setShader(new LinearGradient((SpeechCircleView.this.l / 2) - SpeechCircleView.this.e, 0.0f, (SpeechCircleView.this.l / 2) + SpeechCircleView.this.e, 0.0f, Color.parseColor("#00c6ff"), Color.parseColor("#00baff"), Shader.TileMode.MIRROR));
            }
        };
        float f = (this.d * 23.0f) / 21.0f;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.d / 3.0f, f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.setDuration(this.o);
        ofFloat.addUpdateListener(animatorUpdateListener);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(f, this.d);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.setDuration(this.p);
        ofFloat2.addUpdateListener(animatorUpdateListener);
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat3.setInterpolator(new DecelerateInterpolator());
        ofFloat3.setDuration(this.q);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.ar.ui.speech.SpeechCircleView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SpeechCircleView.this.j = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                SpeechCircleView.this.a.setAlpha((int) (SpeechCircleView.this.j * 255.0f));
                SpeechCircleView.this.b.setAlpha((int) (SpeechCircleView.this.i * 255.0f * SpeechCircleView.this.j));
                SpeechCircleView.this.invalidate();
            }
        });
        this.r = new AnimatorSet();
        this.r.play(ofFloat3).with(ofFloat);
        this.r.play(ofFloat2).after(ofFloat);
        this.r.start();
        this.s = new Timer();
        this.t = new TimerTask() { // from class: com.baidu.ar.ui.speech.SpeechCircleView.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                SpeechCircleView.this.u.sendEmptyMessage(4097);
            }
        };
        this.r.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.ar.ui.speech.SpeechCircleView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (SpeechCircleView.this.s == null || SpeechCircleView.this.t == null) {
                    return;
                }
                SpeechCircleView.this.s.schedule(SpeechCircleView.this.t, 0L, 16L);
            }
        });
    }

    public void a(float f, int i) {
        this.d = f;
        this.k = i;
    }

    public void a(int i, int i2) {
        this.l = i;
        this.m = i2;
    }

    public void b() {
        if (this.v) {
            this.v = false;
            if (this.r != null) {
                this.r.cancel();
                this.r = null;
            }
            if (this.s != null) {
                this.s.cancel();
                this.s.purge();
                this.s = null;
            }
            if (this.t != null) {
                this.t.cancel();
                this.t = null;
            }
            this.u.removeMessages(4097);
            d();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        if (this.n == 0.0f && this.d >= (Math.min(this.l, this.m) / 2) * 0.8f) {
            this.d = (Math.min(this.l, this.m) / 2) * 0.8f;
        }
        this.n += 6.0f;
        if (this.n >= 360.0f) {
            this.n = 0.0f;
        }
        canvas.save();
        canvas.rotate(this.n, this.l / 2, (this.m / 2) + (a(getContext(), this.h) - 1.0f));
        if (this.k != -1) {
            canvas.drawCircle(this.l / 2, this.m / 2, this.e + a(getContext(), this.f), this.c);
        }
        canvas.drawCircle(this.l / 2, this.m / 2, this.e, this.a);
        canvas.restore();
        canvas.rotate(this.n, this.l / 2, (this.m / 2) - (a(getContext(), this.h) - 1.0f));
        canvas.drawCircle(this.l / 2, this.m / 2, this.e, this.b);
    }

    public void setMaskColor(int i) {
        this.k = i;
    }
}
