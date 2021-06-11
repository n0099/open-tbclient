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
    public static final int f6084a = 1715238655;

    /* renamed from: b  reason: collision with root package name */
    public static final float f6085b = 30.0f;

    /* renamed from: c  reason: collision with root package name */
    public static final int f6086c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f6087d = 3;

    /* renamed from: e  reason: collision with root package name */
    public static final int f6088e = 5;

    /* renamed from: f  reason: collision with root package name */
    public float f6089f;

    /* renamed from: g  reason: collision with root package name */
    public int f6090g;

    /* renamed from: h  reason: collision with root package name */
    public int f6091h;

    /* renamed from: i  reason: collision with root package name */
    public int f6092i;
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
        int i2 = this.q;
        int i3 = length - i2;
        System.arraycopy(fArr, i2, this.m, 0, i3);
        System.arraycopy(this.l, 0, this.m, i3, this.q);
        float[] fArr2 = this.l;
        int length2 = fArr2.length;
        int i4 = this.r;
        int i5 = length2 - i4;
        System.arraycopy(fArr2, i4, this.n, 0, i5);
        System.arraycopy(this.l, 0, this.n, i5, this.r);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.setDrawFilter(this.t);
        b();
        int i2 = this.j;
        int i3 = this.f6090g - i2;
        while (i2 < i3) {
            int i4 = (int) ((this.f6091h - this.m[i2]) - this.k);
            int i5 = this.f6092i;
            int sqrt = (int) (i5 + Math.sqrt(Math.pow(i5, 2.0d) - Math.pow(Math.abs(this.f6092i - i2), 2.0d)));
            if (sqrt >= i4) {
                float f2 = i2;
                canvas.drawLine(f2, i4, f2, sqrt, this.s);
            }
            int i6 = (int) ((this.f6091h - this.n[i2]) - this.k);
            if (sqrt >= i6) {
                float f3 = i2;
                canvas.drawLine(f3, i6, f3, sqrt, this.s);
            }
            i2++;
        }
        int i7 = this.q + this.o;
        this.q = i7;
        this.r += this.p;
        if (i7 >= this.f6090g) {
            this.q = 0;
        }
        if (this.r > this.f6090g) {
            this.r = 0;
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f6090g = i2;
        this.f6091h = i3;
        this.f6092i = i2 / 2;
        this.l = new float[i2];
        this.m = new float[i2];
        this.n = new float[i2];
        this.f6089f = (float) (6.283185307179586d / i2);
        for (int i6 = 0; i6 < this.f6090g; i6++) {
            this.l[i6] = (float) ((Math.sin(this.f6089f * i6) * 30.0d) + 0.0d);
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        if (i2 == 8) {
            stopAnim();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 0) {
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

    public DynamicWaveView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.v = true;
        this.o = h.a(context, 3.0f);
        this.p = h.a(context, 5.0f);
        Paint paint = new Paint();
        this.s = paint;
        paint.setAntiAlias(true);
        this.s.setStyle(Paint.Style.FILL);
        this.s.setColor(f6084a);
        this.t = new PaintFlagsDrawFilter(0, 3);
        this.j = h.a(context, 5.0f);
        this.k = h.a(context, 30.0f);
        a();
    }
}
