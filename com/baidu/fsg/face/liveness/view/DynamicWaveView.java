package com.baidu.fsg.face.liveness.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.fsg.face.base.d.h;
/* loaded from: classes17.dex */
public class DynamicWaveView extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final int f1748a = 1715238655;
    private static final float b = 30.0f;
    private static final int c = 0;
    private static final int d = 3;
    private static final int e = 5;
    private float f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private float[] l;
    private float[] m;
    private float[] n;
    private int o;
    private int p;
    private int q;
    private int r;
    private Paint s;
    private DrawFilter t;
    private Thread u;
    private volatile boolean v;

    public DynamicWaveView(Context context) {
        this(context, null);
    }

    public DynamicWaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public DynamicWaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.v = true;
        this.o = h.a(context, 3.0f);
        this.p = h.a(context, 5.0f);
        this.s = new Paint();
        this.s.setAntiAlias(true);
        this.s.setStyle(Paint.Style.FILL);
        this.s.setColor(f1748a);
        this.t = new PaintFlagsDrawFilter(0, 3);
        this.j = h.a(context, 5.0f);
        this.k = h.a(context, (float) b);
        a();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.setDrawFilter(this.t);
        b();
        int i = this.j;
        int i2 = this.g - this.j;
        for (int i3 = i; i3 < i2; i3++) {
            int i4 = (int) ((this.h - this.m[i3]) - this.k);
            int sqrt = (int) (this.i + Math.sqrt(Math.pow(this.i, 2.0d) - Math.pow(Math.abs(this.i - i3), 2.0d)));
            if (sqrt >= i4) {
                canvas.drawLine(i3, i4, i3, sqrt, this.s);
            }
            int i5 = (int) ((this.h - this.n[i3]) - this.k);
            if (sqrt >= i5) {
                canvas.drawLine(i3, i5, i3, sqrt, this.s);
            }
        }
        this.q += this.o;
        this.r += this.p;
        if (this.q >= this.g) {
            this.q = 0;
        }
        if (this.r > this.g) {
            this.r = 0;
        }
    }

    private void a() {
        this.u = new Thread(new Runnable() { // from class: com.baidu.fsg.face.liveness.view.DynamicWaveView.1
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
        this.u.start();
    }

    public void stopAnim() {
        this.v = false;
        if (this.u != null) {
            this.u.interrupt();
        }
    }

    private void b() {
        int length = this.l.length - this.q;
        System.arraycopy(this.l, this.q, this.m, 0, length);
        System.arraycopy(this.l, 0, this.m, length, this.q);
        int length2 = this.l.length - this.r;
        System.arraycopy(this.l, this.r, this.n, 0, length2);
        System.arraycopy(this.l, 0, this.n, length2, this.r);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.g = i;
        this.h = i2;
        this.i = this.g / 2;
        this.l = new float[this.g];
        this.m = new float[this.g];
        this.n = new float[this.g];
        this.f = (float) (6.283185307179586d / this.g);
        for (int i5 = 0; i5 < this.g; i5++) {
            this.l[i5] = (float) ((30.0d * Math.sin(this.f * i5)) + 0.0d);
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

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 8) {
            stopAnim();
        }
    }
}
