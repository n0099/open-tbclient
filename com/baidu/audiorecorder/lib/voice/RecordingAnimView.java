package com.baidu.audiorecorder.lib.voice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.e.m.e;
import d.a.c.e.p.l;
import java.util.Random;
/* loaded from: classes.dex */
public class RecordingAnimView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f4201e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f4202f;

    /* renamed from: g  reason: collision with root package name */
    public Random f4203g;

    /* renamed from: h  reason: collision with root package name */
    public int f4204h;

    /* renamed from: i  reason: collision with root package name */
    public int f4205i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public RectF[] n;
    public int[] o;
    public int p;
    public int q;
    public final Runnable r;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RecordingAnimView.this.b();
        }
    }

    public RecordingAnimView(Context context) {
        super(context);
        this.f4201e = 3;
        this.f4203g = new Random();
        this.f4204h = 0;
        this.f4205i = 8;
        this.j = false;
        this.k = true;
        this.o = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.p = l.g(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.r = new a();
        d();
        b();
    }

    public final void b() {
        if (this.j) {
            invalidate();
        }
        e.a().removeCallbacks(this.r);
        if (this.k) {
            return;
        }
        e.a().postDelayed(this.r, 250L);
    }

    public int c(int i2) {
        if (i2 == 0) {
            return R.color.white_alpha100;
        }
        return R.color.white_alpha70;
    }

    public final void d() {
        this.q = c(TbadkCoreApplication.getInst().getSkinType());
        Paint paint = new Paint();
        this.f4202f = paint;
        paint.setDither(true);
        this.f4202f.setAntiAlias(true);
        this.f4202f.setStyle(Paint.Style.FILL);
        this.f4202f.setColor(SkinManager.getColor(this.q));
    }

    public final void e() {
        int nextInt;
        RectF[] rectFArr = this.n;
        if (rectFArr == null || rectFArr.length != this.f4205i) {
            this.n = new RectF[this.f4205i];
        }
        for (int i2 = 0; i2 < this.f4205i; i2++) {
            int i3 = this.p * i2 * 2;
            if (this.k) {
                nextInt = (int) ((1.0d - (this.o[i2 % 22] / 10.0d)) * this.m);
            } else {
                int i4 = this.m;
                nextInt = i4 > 0 ? this.f4203g.nextInt(i4) : 0;
            }
            int i5 = this.p + i3;
            int i6 = this.m;
            RectF[] rectFArr2 = this.n;
            if (rectFArr2[i2] == null) {
                rectFArr2[i2] = new RectF(i3, nextInt, i5, i6);
            } else {
                rectFArr2[i2].set(i3, nextInt, i5, i6);
            }
        }
    }

    public void f(int i2) {
        if (i2 == this.f4201e || this.f4202f == null) {
            return;
        }
        int c2 = c(i2);
        this.q = c2;
        this.f4202f.setColor(SkinManager.getColor(i2, c2));
        invalidate();
        this.f4201e = i2;
    }

    public void g() {
        this.j = true;
        this.k = true;
        b();
    }

    public void h() {
        this.j = true;
        this.k = false;
        b();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        e.a().removeCallbacks(this.r);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.j) {
            for (int i2 = 0; i2 < this.f4205i; i2++) {
                e();
                RectF[] rectFArr = this.n;
                if (i2 < rectFArr.length) {
                    canvas.drawRoundRect(rectFArr[i2], 10.0f, 10.0f, this.f4202f);
                }
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i2, int i3) {
        if (this.f4204h > 0) {
            int mode = View.MeasureSpec.getMode(i2);
            int i4 = this.p;
            int i5 = this.f4204h;
            int i6 = i4 * ((i5 * 2) - 1);
            this.l = i6;
            this.f4205i = i5;
            i2 = View.MeasureSpec.makeMeasureSpec(i6, mode);
        }
        super.onMeasure(i2, i3);
        this.m = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        this.l = measuredWidth;
        if (this.f4204h <= 0) {
            this.f4205i = (measuredWidth / this.p) / 2;
        }
    }

    public void setCertainColumnCount(int i2) {
        if (i2 != 0) {
            this.f4204h = i2;
        }
    }

    public void setColumnColor(int i2) {
        Paint paint = this.f4202f;
        if (paint != null) {
            paint.setColor(SkinManager.getColor(i2));
        }
        this.q = i2;
    }

    public void setColumnWidth(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.p = i2;
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4201e = 3;
        this.f4203g = new Random();
        this.f4204h = 0;
        this.f4205i = 8;
        this.j = false;
        this.k = true;
        this.o = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.p = l.g(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.r = new a();
        d();
        b();
    }
}
