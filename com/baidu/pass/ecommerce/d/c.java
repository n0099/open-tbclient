package com.baidu.pass.ecommerce.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
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
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import com.baidu.j.a.a;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiUtils;
import java.lang.ref.WeakReference;
/* loaded from: classes14.dex */
public class c extends View implements com.baidu.pass.ecommerce.d.d {
    private static final String O = "VoiceSinWaveView";
    private static final int P = 4097;
    private static final int Q = 255;
    private long A;
    private long B;
    private boolean C;
    private boolean D;
    private ViewGroup E;
    private g F;
    private f G;
    private e H;
    private Bitmap I;
    private Canvas J;
    private int K;
    private PorterDuffXfermode L;
    private LinearInterpolator M;
    private boolean N;

    /* renamed from: a  reason: collision with root package name */
    private float f4082a;

    /* renamed from: b  reason: collision with root package name */
    private float f4083b;
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
    private ValueAnimator z;

    /* loaded from: classes14.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.f4083b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        }
    }

    /* loaded from: classes14.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int[] f4085a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float[] f4086b;

        b(int[] iArr, float[] fArr) {
            this.f4085a = iArr;
            this.f4086b = fArr;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.K = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            if (!c.this.D && c.this.K > (c.this.q * 5) / 14) {
                if (c.this.F != null) {
                    c.this.F.a();
                }
                c.this.D = true;
            }
            c.this.g.setShader(new LinearGradient(c.this.K, 0.0f, c.this.q - c.this.K, 0.0f, this.f4085a, this.f4086b, Shader.TileMode.MIRROR));
        }
    }

    /* renamed from: com.baidu.pass.ecommerce.d.c$c  reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    class C0275c extends AnimatorListenerAdapter {
        C0275c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (c.this.F != null) {
                c.this.F.b();
            }
        }
    }

    /* loaded from: classes14.dex */
    class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            c.this.f4083b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            c cVar = c.this;
            cVar.f4082a = cVar.f4083b;
        }
    }

    /* loaded from: classes14.dex */
    private static class e extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<c> f4089a;

        public e(c cVar) {
            this.f4089a = new WeakReference<>(cVar);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c cVar;
            if (message.what != 4097 || (cVar = this.f4089a.get()) == null) {
                return;
            }
            cVar.g();
            cVar.invalidate();
            cVar.f();
        }
    }

    /* loaded from: classes14.dex */
    private static class f extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private boolean f4090a = false;

        /* renamed from: b  reason: collision with root package name */
        private WeakReference<c> f4091b;

        public f(c cVar) {
            this.f4091b = new WeakReference<>(cVar);
        }

        public synchronized void a(boolean z) {
            this.f4090a = z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (!a()) {
                c cVar = this.f4091b.get();
                if (cVar != null) {
                    cVar.H.sendEmptyMessage(4097);
                    try {
                        Thread.sleep(16L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public synchronized boolean a() {
            return this.f4090a;
        }
    }

    /* loaded from: classes14.dex */
    public interface g {
        void a();

        void b();
    }

    public c(Context context) {
        this(context, null, 0);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        Log.d(O, "onDetachedFromWindow.");
        super.onDetachedFromWindow();
        f fVar = this.G;
        if (fVar != null) {
            fVar.a(true);
        }
        e eVar = this.H;
        if (eVar != null) {
            eVar.removeMessages(4097);
            Log.d(O, "remove change phase message.");
        }
        c();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        if (this.N) {
            ViewGroup viewGroup = this.E;
            if (viewGroup != null) {
                this.q = viewGroup.getWidth();
                this.r = this.E.getHeight();
            }
            int i2 = this.q;
            if (i2 > 0 && (i = this.r) > 0) {
                if (this.I == null) {
                    this.I = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
                    this.J = new Canvas(this.I);
                }
                i();
                this.N = false;
            } else {
                return;
            }
        }
        if (this.C) {
            canvas.drawColor(0);
            canvas.drawPath(this.j, this.f);
            canvas.drawPath(this.i, this.e);
            canvas.drawPath(this.h, this.d);
            return;
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, this.q, this.r, null, 31);
        int i3 = this.K;
        canvas.drawRect(i3, 0.0f, this.q - i3, this.r, this.g);
        this.g.setXfermode(this.L);
        if (this.I != null) {
            this.J.drawColor(0, PorterDuff.Mode.CLEAR);
            this.J.drawPath(this.j, this.f);
            this.J.drawPath(this.i, this.e);
            this.J.drawPath(this.h, this.d);
            canvas.drawBitmap(this.I, 0.0f, 0.0f, this.g);
        }
        this.g.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    public void setCallBack(g gVar) {
        this.F = gVar;
    }

    public c(Context context, g gVar) {
        this(context, null, 0);
        this.F = gVar;
    }

    private void e() {
        Log.d(O, "cancel.");
        ValueAnimator valueAnimator = this.y;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.y = null;
        }
        ValueAnimator valueAnimator2 = this.z;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.z = null;
        }
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
        int i;
        if (!this.N) {
            this.n = (this.f4083b / 100.0f) * 0.8f;
            this.n = Math.max(0.05f, this.n);
            this.h.rewind();
            this.i.rewind();
            this.j.rewind();
            this.h.moveTo(0.0f, a(0, this.q, this.r, this.m, this.n, this.s, this.w));
            int i2 = 1;
            while (true) {
                i = this.q;
                if (i2 > i) {
                    break;
                }
                this.h.lineTo(i2, a(i2, i, this.r, this.m, this.n, this.s, this.w));
                i2 += SapiUtils.dip2px(getContext(), this.p);
            }
            this.h.lineTo(this.q, a(i, i, this.r, this.m, this.n, this.s, this.w));
            int i3 = this.q;
            this.i.moveTo(this.q, a(i3, i3, this.r, this.m, this.n * 0.8f, this.t, this.x));
            int i4 = this.q - 1;
            while (i4 >= 0) {
                this.i.lineTo(i4, a(i4, this.q, this.r, this.m, this.n * 0.8f, this.t, this.x));
                i4 -= SapiUtils.dip2px(getContext(), this.p);
            }
            this.i.lineTo(0.0f, a(0, this.q, this.r, this.m, this.n * 0.8f, this.t, this.x));
            this.j.addPath(this.h);
            this.j.addPath(this.i);
        }
    }

    private void h() {
        Log.d(O, "initialize.");
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
        this.L = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
        this.M = new LinearInterpolator();
    }

    private void i() {
        Log.d(O, "setPaintShader.");
        int i = this.r;
        if (i > 0 && this.q > 0) {
            this.m = (i - 4.0f) * 0.5f;
            this.d.setShader(new LinearGradient(0.0f, 0.0f, this.q, 0.0f, getResources().getColor(a.b.sapi_sdk_mms_voice_primary_start), getResources().getColor(a.b.sapi_sdk_mms_voice_primary_end), Shader.TileMode.MIRROR));
            this.e.setShader(new LinearGradient(0.0f, 0.0f, this.q, 0.0f, getResources().getColor(a.b.sapi_sdk_mms_voice_secondary_start), getResources().getColor(a.b.sapi_sdk_mms_voice_secondary_end), Shader.TileMode.MIRROR));
            int color = getResources().getColor(a.b.sapi_sdk_mms_voice_fill_top);
            int color2 = getResources().getColor(a.b.sapi_sdk_mms_voice_fill_bottom);
            int i2 = this.r;
            float f2 = this.m;
            this.f.setShader(new LinearGradient(0.0f, (i2 / 2) - f2, 0.0f, f2 + (i2 / 2), color, color2, Shader.TileMode.MIRROR));
        }
    }

    @Override // com.baidu.pass.ecommerce.d.d
    public void c() {
        Log.d(O, "reset.");
        this.f4083b = 0.0f;
        this.f4082a = 0.0f;
        this.c = 0L;
        this.w = 0.0f;
        this.x = 3.5f;
        this.C = false;
        this.D = false;
        this.N = true;
        this.K = 0;
        Bitmap bitmap = this.I;
        if (bitmap != null) {
            bitmap.recycle();
            this.I = null;
            this.J = null;
        }
    }

    @Override // com.baidu.pass.ecommerce.d.d
    public void d() {
        Log.d(O, "removeFromParent.");
        ViewGroup viewGroup = this.E;
        if (viewGroup != null) {
            viewGroup.removeView(this);
            this.E = null;
            e();
        }
    }

    @Override // com.baidu.pass.ecommerce.d.d
    public void b() {
        Log.d(O, "start.");
        if (!this.C) {
            this.C = true;
            this.D = false;
            this.G = new f(this);
            this.G.start();
        }
    }

    public c(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4082a = 0.0f;
        this.f4083b = 0.0f;
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
        this.A = 200L;
        this.B = 250L;
        this.C = false;
        this.D = false;
        this.K = 0;
        this.N = true;
        this.H = new e(this);
        h();
    }

    @Override // com.baidu.pass.ecommerce.d.d
    public void a(ViewGroup viewGroup) {
        Log.d(O, "showInParentView.");
        if (viewGroup != null && this.E == null) {
            this.N = true;
            viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
            this.E = viewGroup;
        }
    }

    @Override // com.baidu.pass.ecommerce.d.d
    public void a() {
        Log.d(O, "stop.");
        if (this.C) {
            this.C = false;
            ValueAnimator valueAnimator = this.y;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.y = null;
            }
            float f2 = this.f4083b;
            if (f2 > 10.0f) {
                this.y = ValueAnimator.ofFloat(f2, 10.0f);
                this.y.setDuration(this.A);
                this.y.setInterpolator(this.M);
                this.y.addUpdateListener(new a());
                this.y.start();
            }
            this.z = ValueAnimator.ofInt(0, this.q / 2);
            this.z.setDuration(this.B);
            this.z.setInterpolator(new AccelerateInterpolator());
            this.z.addUpdateListener(new b(new int[]{0, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, ViewCompat.MEASURED_STATE_MASK, 0}, new float[]{0.0f, 0.2f, 0.5f, 0.8f, 1.0f}));
            this.z.addListener(new C0275c());
            this.z.start();
        }
    }

    @Override // com.baidu.pass.ecommerce.d.d
    public void a(float f2) {
        if (this.C && f2 >= 0.0f && f2 <= 100.0f) {
            long currentTimeMillis = System.currentTimeMillis();
            if (0 == this.c) {
                this.c = currentTimeMillis - 100;
            }
            long j = currentTimeMillis - this.c;
            long j2 = j > 0 ? j : 100L;
            ValueAnimator valueAnimator = this.y;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.y = null;
            }
            this.y = ValueAnimator.ofFloat(this.f4082a, f2);
            this.y.setDuration(j2);
            this.y.setInterpolator(this.M);
            this.y.addUpdateListener(new d());
            this.y.start();
            this.c = currentTimeMillis;
        }
    }

    private float a(int i, float f2, float f3, float f4, float f5, float f6, float f7) {
        return ((1.0f - ((float) Math.pow(((i * 2) / f2) - 1.0f, 2.0d))) * f4 * f5 * ((float) Math.sin(((i / f2) * 6.283185307179586d * f6) + f7))) + (0.5f * f3);
    }
}
