package com.baidu.audiorecorder.lib.voice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import java.util.Random;
/* loaded from: classes3.dex */
public class RecordingAnimView extends View {
    private int Tm;
    private int Tn;
    private boolean To;
    private boolean Tp;
    private int Tq;
    private int Tr;
    private RectF[] Ts;
    private int[] Tt;
    private int Tu;
    private int Tv;
    private final Runnable Tw;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Tm = 0;
        this.Tn = 8;
        this.To = false;
        this.Tp = true;
        this.Tt = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Tu = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds4);
        this.Tw = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.pU();
            }
        };
        initPaint();
        pU();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Tm = 0;
        this.Tn = 8;
        this.To = false;
        this.Tp = true;
        this.Tt = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Tu = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds4);
        this.Tw = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.pU();
            }
        };
        initPaint();
        pU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pU() {
        if (this.To) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.Tw);
        if (!this.Tp) {
            com.baidu.adp.lib.g.e.jI().postDelayed(this.Tw, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Tm > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Tq = this.Tu * ((this.Tm * 2) - 1);
            this.Tn = this.Tm;
            i = View.MeasureSpec.makeMeasureSpec(this.Tq, mode);
        }
        super.onMeasure(i, i2);
        this.Tr = getMeasuredHeight();
        this.Tq = getMeasuredWidth();
        if (this.Tm <= 0) {
            this.Tn = (this.Tq / this.Tu) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.To) {
            for (int i = 0; i < this.Tn; i++) {
                pV();
                if (i < this.Ts.length) {
                    canvas.drawRoundRect(this.Ts[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.Tv = bj(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(al.getColor(this.Tv));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.Tv = bj(i);
            this.mPaint.setColor(al.getColor(this.Tv));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int bj(int i) {
        return i == 0 ? e.d.white_alpha100 : e.d.white_alpha70;
    }

    private void pV() {
        int nextInt;
        if (this.Ts == null || this.Ts.length != this.Tn) {
            this.Ts = new RectF[this.Tn];
        }
        for (int i = 0; i < this.Tn; i++) {
            int i2 = this.Tu * i * 2;
            if (this.Tp) {
                nextInt = (int) ((1.0d - (this.Tt[i % 22] / 10.0d)) * this.Tr);
            } else {
                nextInt = this.Tr > 0 ? this.random.nextInt(this.Tr) : 0;
            }
            int i3 = this.Tu + i2;
            int i4 = this.Tr;
            if (this.Ts[i] == null) {
                this.Ts[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.Ts[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Tu = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(al.getColor(i));
        }
        this.Tv = i;
    }

    public void start() {
        this.To = true;
        this.Tp = false;
        pU();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Tm = i;
        }
    }

    public void pW() {
        this.To = true;
        this.Tp = true;
        pU();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.jI().removeCallbacks(this.Tw);
    }
}
