package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.fsg.face.base.d.h;
/* loaded from: classes2.dex */
public class DynamicWaveView extends View {

    /* renamed from: a  reason: collision with root package name */
    public static final int f6113a = 1715238655;

    /* renamed from: b  reason: collision with root package name */
    public static final float f6114b = 30.0f;

    /* renamed from: c  reason: collision with root package name */
    public static final int f6115c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f6116d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f6117e = 5;

    /* renamed from: f  reason: collision with root package name */
    public float f6118f;

    /* renamed from: g  reason: collision with root package name */
    public int f6119g;

    /* renamed from: h  reason: collision with root package name */
    public int f6120h;
    public int i;
    public int j;
    public int k;
    public float[] l;
    public float[] m;
    public float[] n;
    public int o;
    public int p;
    public int q;
    public int r;
    public Paint s;
    public DrawFilter t;
    public Thread u;
    public volatile boolean v;

    public DynamicWaveView(Context context) {
        this(context, null);
    }

    private void b() {
        float[] fArr = this.l;
        int length = fArr.length;
        int i = this.q;
        int i2 = length - i;
        System.arraycopy(fArr, i, this.m, 0, i2);
        System.arraycopy(this.l, 0, this.m, i2, this.q);
        float[] fArr2 = this.l;
        int length2 = fArr2.length;
        int i3 = this.r;
        int i4 = length2 - i3;
        System.arraycopy(fArr2, i3, this.n, 0, i4);
        System.arraycopy(this.l, 0, this.n, i4, this.r);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.setDrawFilter(this.t);
        b();
        int i = this.j;
        int i2 = this.f6119g - i;
        while (i < i2) {
            int i3 = (int) ((this.f6120h - this.m[i]) - this.k);
            int i4 = this.i;
            int sqrt = (int) (i4 + Math.sqrt(Math.pow(i4, 2.0d) - Math.pow(Math.abs(this.i - i), 2.0d)));
            if (sqrt >= i3) {
                float f2 = i;
                canvas.drawLine(f2, i3, f2, sqrt, this.s);
            }
            int i5 = (int) ((this.f6120h - this.n[i]) - this.k);
            if (sqrt >= i5) {
                float f3 = i;
                canvas.drawLine(f3, i5, f3, sqrt, this.s);
            }
            i++;
        }
        int i6 = this.q + this.o;
        this.q = i6;
        this.r += this.p;
        if (i6 >= this.f6119g) {
            this.q = 0;
        }
        if (this.r > this.f6119g) {
            this.r = 0;
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f6119g = i;
        this.f6120h = i2;
        this.i = i / 2;
        this.l = new float[i];
        this.m = new float[i];
        this.n = new float[i];
        this.f6118f = (float) (6.283185307179586d / i);
        for (int i5 = 0; i5 < this.f6119g; i5++) {
            this.l[i5] = (float) ((Math.sin(this.f6118f * i5) * 30.0d) + 0.0d);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8) {
            stopAnim();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.v = true;
            a();
            return;
        }
        this.v = false;
    }

    public void stopAnim() {
        this.v = false;
        Thread thread = this.u;
        if (thread != null) {
            thread.interrupt();
        }
    }

    public DynamicWaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    private void a() {
        Thread thread = new Thread(new Runnable() { // from class: com.baidu.fsg.face.liveness.view.DynamicWaveView.1
            @Override // java.lang.Runnable
            public void run() {
                while (DynamicWaveView.this.v) {
                    try {
                        Thread.sleep(20L);
                        DynamicWaveView.this.postInvalidate();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        this.u = thread;
        thread.start();
    }

    public DynamicWaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.v = true;
        this.o = h.a(context, 3.0f);
        this.p = h.a(context, 5.0f);
        Paint paint = new Paint();
        this.s = paint;
        paint.setAntiAlias(true);
        this.s.setStyle(Paint.Style.FILL);
        this.s.setColor(f6113a);
        this.t = new PaintFlagsDrawFilter(0, 3);
        this.j = h.a(context, 5.0f);
        this.k = h.a(context, 30.0f);
        a();
    }
}
