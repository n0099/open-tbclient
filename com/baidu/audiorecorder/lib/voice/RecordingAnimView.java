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
import d.b.b.e.m.e;
import d.b.b.e.p.l;
import java.util.Random;
/* loaded from: classes.dex */
public class RecordingAnimView extends View {

    /* renamed from: e  reason: collision with root package name */
    public int f4247e;

    /* renamed from: f  reason: collision with root package name */
    public Paint f4248f;

    /* renamed from: g  reason: collision with root package name */
    public Random f4249g;

    /* renamed from: h  reason: collision with root package name */
    public int f4250h;
    public int i;
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
        this.f4247e = 3;
        this.f4249g = new Random();
        this.f4250h = 0;
        this.i = 8;
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

    public int c(int i) {
        if (i == 0) {
            return R.color.white_alpha100;
        }
        return R.color.white_alpha70;
    }

    public final void d() {
        this.q = c(TbadkCoreApplication.getInst().getSkinType());
        Paint paint = new Paint();
        this.f4248f = paint;
        paint.setDither(true);
        this.f4248f.setAntiAlias(true);
        this.f4248f.setStyle(Paint.Style.FILL);
        this.f4248f.setColor(SkinManager.getColor(this.q));
    }

    public final void e() {
        int nextInt;
        RectF[] rectFArr = this.n;
        if (rectFArr == null || rectFArr.length != this.i) {
            this.n = new RectF[this.i];
        }
        for (int i = 0; i < this.i; i++) {
            int i2 = this.p * i * 2;
            if (this.k) {
                nextInt = (int) ((1.0d - (this.o[i % 22] / 10.0d)) * this.m);
            } else {
                int i3 = this.m;
                nextInt = i3 > 0 ? this.f4249g.nextInt(i3) : 0;
            }
            int i4 = this.p + i2;
            int i5 = this.m;
            RectF[] rectFArr2 = this.n;
            if (rectFArr2[i] == null) {
                rectFArr2[i] = new RectF(i2, nextInt, i4, i5);
            } else {
                rectFArr2[i].set(i2, nextInt, i4, i5);
            }
        }
    }

    public void f(int i) {
        if (i == this.f4247e || this.f4248f == null) {
            return;
        }
        int c2 = c(i);
        this.q = c2;
        this.f4248f.setColor(SkinManager.getColor(i, c2));
        invalidate();
        this.f4247e = i;
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
            for (int i = 0; i < this.i; i++) {
                e();
                RectF[] rectFArr = this.n;
                if (i < rectFArr.length) {
                    canvas.drawRoundRect(rectFArr[i], 10.0f, 10.0f, this.f4248f);
                }
            }
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    public void onMeasure(int i, int i2) {
        if (this.f4250h > 0) {
            int mode = View.MeasureSpec.getMode(i);
            int i3 = this.p;
            int i4 = this.f4250h;
            int i5 = i3 * ((i4 * 2) - 1);
            this.l = i5;
            this.i = i4;
            i = View.MeasureSpec.makeMeasureSpec(i5, mode);
        }
        super.onMeasure(i, i2);
        this.m = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        this.l = measuredWidth;
        if (this.f4250h <= 0) {
            this.i = (measuredWidth / this.p) / 2;
        }
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.f4250h = i;
        }
    }

    public void setColumnColor(int i) {
        Paint paint = this.f4248f;
        if (paint != null) {
            paint.setColor(SkinManager.getColor(i));
        }
        this.q = i;
    }

    public void setColumnWidth(int i) {
        if (i <= 0) {
            return;
        }
        this.p = i;
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4247e = 3;
        this.f4249g = new Random();
        this.f4250h = 0;
        this.i = 8;
        this.j = false;
        this.k = true;
        this.o = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.p = l.g(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.r = new a();
        d();
        b();
    }
}
