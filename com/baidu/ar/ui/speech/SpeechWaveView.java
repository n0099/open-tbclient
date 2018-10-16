package com.baidu.ar.ui.speech;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import java.lang.ref.WeakReference;
/* loaded from: classes3.dex */
public class SpeechWaveView extends View {
    private long A;
    private boolean B;
    private boolean C;
    private c D;
    private b E;
    private a F;
    private Bitmap G;
    private Canvas H;
    private int I;
    private PorterDuffXfermode J;
    private LinearInterpolator K;
    private boolean L;
    private float a;
    private float b;
    private long c;
    private Paint d;
    private Paint e;
    private Paint f;
    private Paint g;
    private Path h;
    private Path i;
    private Path j;
    private int k;
    private int l;
    private float m;
    private float n;
    private float o;
    private int p;
    private int q;
    private int r;
    private float s;
    private float t;
    private float u;
    private float v;
    private float w;
    private float x;
    private ValueAnimator y;
    private long z;

    /* loaded from: classes3.dex */
    private static class a extends Handler {
        private WeakReference<SpeechWaveView> a;

        public a(SpeechWaveView speechWaveView) {
            this.a = new WeakReference<>(speechWaveView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SpeechWaveView speechWaveView;
            if (message.what != 4097 || (speechWaveView = this.a.get()) == null) {
                return;
            }
            speechWaveView.g();
            speechWaveView.invalidate();
            speechWaveView.f();
        }
    }

    /* loaded from: classes3.dex */
    private static class b extends Thread {
        public SpeechWaveView a;
        private boolean b = false;

        public b(SpeechWaveView speechWaveView) {
            this.a = speechWaveView;
        }

        public synchronized void a(boolean z) {
            this.b = z;
        }

        public synchronized boolean a() {
            return this.b;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!a()) {
                if (this.a != null) {
                    this.a.F.sendEmptyMessage(4097);
                    try {
                        Thread.sleep(16L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
    }

    public SpeechWaveView(Context context) {
        this(context, null, 0);
    }

    public SpeechWaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SpeechWaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0L;
        this.k = 2;
        this.l = 2;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0.5f;
        this.p = 2;
        this.s = 2.0f;
        this.t = 1.6f;
        this.u = -0.2f;
        this.v = -0.1994f;
        this.w = 0.0f;
        this.x = 3.5f;
        this.z = 200L;
        this.A = 100L;
        this.B = false;
        this.C = false;
        this.I = 0;
        this.L = true;
        this.F = new a(this);
        d();
    }

    private float a(int i, float f, float f2, float f3, float f4, float f5, float f6) {
        return ((1.0f - ((float) Math.pow(((i * 2) / f) - 1.0f, 2.0d))) * f3 * f4 * ((float) Math.sin((6.283185307179586d * (i / f) * f5) + f6))) + (0.5f * f2);
    }

    private float a(Context context, float f) {
        return (context.getResources().getDisplayMetrics().density * f) + 0.5f;
    }

    private void d() {
        if (getContext().getResources().getDisplayMetrics().density <= 2.0f) {
            this.k = 1;
            this.l = 1;
        }
        this.d = new Paint();
        this.d.setAntiAlias(true);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeWidth(this.k);
        this.e = new Paint();
        this.e.setAntiAlias(true);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setStrokeWidth(this.l);
        this.e.setAlpha((int) (this.o * 255.0f));
        this.f = new Paint();
        this.g = new Paint();
        this.h = new Path();
        this.i = new Path();
        this.j = new Path();
        this.J = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.K = new LinearInterpolator();
    }

    private void e() {
        if (this.r <= 0 || this.q <= 0) {
            return;
        }
        this.m = (this.r - 4.0f) * 0.5f;
        this.d.setShader(new LinearGradient(0.0f, 0.0f, this.q, 0.0f, Color.parseColor("#00c6ff"), Color.parseColor("#00baff"), Shader.TileMode.MIRROR));
        this.e.setShader(new LinearGradient(0.0f, 0.0f, this.q, 0.0f, Color.parseColor("#00c6ff"), Color.parseColor("#00baff"), Shader.TileMode.MIRROR));
        this.f.setShader(new LinearGradient(0.0f, (this.r / 2) - this.m, 0.0f, this.m + (this.r / 2), Color.parseColor("#009ce6ff"), Color.parseColor("#809ce6ff"), Shader.TileMode.MIRROR));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.w += this.u;
        this.x += this.v;
        if (this.w < -3.4028235E38f) {
            this.w = 0.0f;
            this.x = 3.5f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.L) {
            return;
        }
        this.n = (this.b / 100.0f) * 0.8f;
        this.n = Math.max(0.05f, this.n);
        this.h.rewind();
        this.i.rewind();
        this.j.rewind();
        this.h.moveTo(0.0f, a(0, this.q, this.r, this.m, this.n, this.s, this.w));
        int i = 1;
        while (i <= this.q) {
            this.h.lineTo(i, a(i, this.q, this.r, this.m, this.n, this.s, this.w));
            i = (int) (i + a(getContext(), this.p));
        }
        this.h.lineTo(this.q, a(this.q, this.q, this.r, this.m, this.n, this.s, this.w));
        this.i.moveTo(this.q, a(this.q, this.q, this.r, this.m, this.n * 0.8f, this.t, this.x));
        int i2 = this.q - 1;
        while (i2 >= 0) {
            this.i.lineTo(i2, a(i2, this.q, this.r, this.m, this.n * 0.8f, this.t, this.x));
            i2 = (int) (i2 - a(getContext(), this.p));
        }
        this.i.lineTo(0.0f, a(0, this.q, this.r, this.m, this.n * 0.8f, this.t, this.x));
        this.j.addPath(this.h);
        this.j.addPath(this.i);
    }

    public void a() {
        if (this.B) {
            return;
        }
        this.B = true;
        this.C = false;
        this.E = new b(this);
        this.E.start();
    }

    public void a(float f) {
        if (this.B && f >= 0.0f && f <= 100.0f) {
            long currentTimeMillis = System.currentTimeMillis();
            if (0 == this.c) {
                this.c = currentTimeMillis - 100;
            }
            long j = currentTimeMillis - this.c;
            long j2 = j > 0 ? j : 100L;
            if (this.y != null) {
                this.y.cancel();
                this.y = null;
            }
            this.y = ValueAnimator.ofFloat(this.a, f);
            this.y.setDuration(j2);
            this.y.setInterpolator(this.K);
            this.y.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.ar.ui.speech.SpeechWaveView.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    SpeechWaveView.this.b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    SpeechWaveView.this.a = SpeechWaveView.this.b;
                }
            });
            this.y.start();
            this.c = currentTimeMillis;
        }
    }

    public void a(int i, int i2) {
        this.q = i;
        this.r = i2;
    }

    public void b() {
        this.b = 0.0f;
        this.a = 0.0f;
        this.c = 0L;
        this.w = 0.0f;
        this.x = 3.5f;
        this.B = false;
        this.C = false;
        this.L = true;
        this.I = 0;
        if (this.G != null) {
            this.G.recycle();
            this.G = null;
            this.H = null;
        }
    }

    public void c() {
        if (this.E != null) {
            if (this.E.a != null) {
                this.E.a = null;
            }
            this.E.a(true);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.E != null) {
            if (this.E.a != null) {
                this.E.a = null;
            }
            this.E.a(true);
        }
        if (this.F != null) {
            this.F.removeMessages(4097);
        }
        b();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.L) {
            if (this.q <= 0 || this.r <= 0) {
                return;
            }
            if (this.G == null) {
                this.G = Bitmap.createBitmap(this.q, this.r, Bitmap.Config.ARGB_8888);
                this.H = new Canvas(this.G);
            }
            e();
            this.L = false;
        }
        if (this.B) {
            canvas.drawColor(0);
            canvas.drawPath(this.j, this.f);
            canvas.drawPath(this.i, this.e);
            canvas.drawPath(this.h, this.d);
            return;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, this.q, this.r, null, 31);
        canvas.drawRect(this.I, 0.0f, this.q - this.I, this.r, this.g);
        this.g.setXfermode(this.J);
        if (this.G != null) {
            this.H.drawColor(0, PorterDuff.Mode.CLEAR);
            this.H.drawPath(this.j, this.f);
            this.H.drawPath(this.i, this.e);
            this.H.drawPath(this.h, this.d);
            canvas.drawBitmap(this.G, 0.0f, 0.0f, this.g);
        }
        this.g.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setCallBack(c cVar) {
        this.D = cVar;
    }
}
