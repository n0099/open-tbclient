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
    private int To;
    private int Tp;
    private boolean Tq;
    private boolean Tr;
    private int Ts;
    private int Tt;
    private RectF[] Tu;
    private int[] Tv;
    private int Tw;
    private int Tx;
    private final Runnable Ty;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.To = 0;
        this.Tp = 8;
        this.Tq = false;
        this.Tr = true;
        this.Tv = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Tw = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds4);
        this.Ty = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.pR();
            }
        };
        initPaint();
        pR();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.To = 0;
        this.Tp = 8;
        this.Tq = false;
        this.Tr = true;
        this.Tv = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Tw = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds4);
        this.Ty = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.pR();
            }
        };
        initPaint();
        pR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pR() {
        if (this.Tq) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.Ty);
        if (!this.Tr) {
            com.baidu.adp.lib.g.e.jG().postDelayed(this.Ty, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.To > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Ts = this.Tw * ((this.To * 2) - 1);
            this.Tp = this.To;
            i = View.MeasureSpec.makeMeasureSpec(this.Ts, mode);
        }
        super.onMeasure(i, i2);
        this.Tt = getMeasuredHeight();
        this.Ts = getMeasuredWidth();
        if (this.To <= 0) {
            this.Tp = (this.Ts / this.Tw) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Tq) {
            for (int i = 0; i < this.Tp; i++) {
                pS();
                if (i < this.Tu.length) {
                    canvas.drawRoundRect(this.Tu[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.Tx = by(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(al.getColor(this.Tx));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.Tx = by(i);
            this.mPaint.setColor(al.getColor(this.Tx));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int by(int i) {
        return i == 0 ? e.d.white_alpha100 : e.d.white_alpha70;
    }

    private void pS() {
        int nextInt;
        if (this.Tu == null || this.Tu.length != this.Tp) {
            this.Tu = new RectF[this.Tp];
        }
        for (int i = 0; i < this.Tp; i++) {
            int i2 = this.Tw * i * 2;
            if (this.Tr) {
                nextInt = (int) ((1.0d - (this.Tv[i % 22] / 10.0d)) * this.Tt);
            } else {
                nextInt = this.Tt > 0 ? this.random.nextInt(this.Tt) : 0;
            }
            int i3 = this.Tw + i2;
            int i4 = this.Tt;
            if (this.Tu[i] == null) {
                this.Tu[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.Tu[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Tw = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(al.getColor(i));
        }
        this.Tx = i;
    }

    public void start() {
        this.Tq = true;
        this.Tr = false;
        pR();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.To = i;
        }
    }

    public void pT() {
        this.Tq = true;
        this.Tr = true;
        pR();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.jG().removeCallbacks(this.Ty);
    }
}
