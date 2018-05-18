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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes3.dex */
public class RecordingAnimView extends View {
    private int Kd;
    private int Ke;
    private boolean Kf;
    private boolean Kg;
    private int Kh;
    private int Ki;
    private RectF[] Kj;
    private int[] Kk;
    private int Kl;
    private int Km;
    private final Runnable Kn;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Kd = 0;
        this.Ke = 8;
        this.Kf = false;
        this.Kg = true;
        this.Kk = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Kl = l.e(TbadkCoreApplication.getInst(), d.e.ds4);
        this.Kn = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.lQ();
            }
        };
        initPaint();
        lQ();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Kd = 0;
        this.Ke = 8;
        this.Kf = false;
        this.Kg = true;
        this.Kk = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Kl = l.e(TbadkCoreApplication.getInst(), d.e.ds4);
        this.Kn = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.lQ();
            }
        };
        initPaint();
        lQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lQ() {
        if (this.Kf) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.Kn);
        if (!this.Kg) {
            com.baidu.adp.lib.g.e.fw().postDelayed(this.Kn, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Kd > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Kh = this.Kl * ((this.Kd * 2) - 1);
            this.Ke = this.Kd;
            i = View.MeasureSpec.makeMeasureSpec(this.Kh, mode);
        }
        super.onMeasure(i, i2);
        this.Ki = getMeasuredHeight();
        this.Kh = getMeasuredWidth();
        if (this.Kd <= 0) {
            this.Ke = (this.Kh / this.Kl) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Kf) {
            for (int i = 0; i < this.Ke; i++) {
                lR();
                if (i < this.Kj.length) {
                    canvas.drawRoundRect(this.Kj[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.Km = aW(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ak.getColor(this.Km));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.Km = aW(i);
            this.mPaint.setColor(ak.getColor(this.Km));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int aW(int i) {
        return i == 0 ? d.C0126d.white_alpha100 : d.C0126d.white_alpha70;
    }

    private void lR() {
        int nextInt;
        if (this.Kj == null || this.Kj.length != this.Ke) {
            this.Kj = new RectF[this.Ke];
        }
        for (int i = 0; i < this.Ke; i++) {
            int i2 = this.Kl * i * 2;
            if (this.Kg) {
                nextInt = (int) ((1.0d - (this.Kk[i % 22] / 10.0d)) * this.Ki);
            } else {
                nextInt = this.Ki > 0 ? this.random.nextInt(this.Ki) : 0;
            }
            int i3 = this.Kl + i2;
            int i4 = this.Ki;
            if (this.Kj[i] == null) {
                this.Kj[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.Kj[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Kl = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ak.getColor(i));
        }
        this.Km = i;
    }

    public void start() {
        this.Kf = true;
        this.Kg = false;
        lQ();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Kd = i;
        }
    }

    public void lS() {
        this.Kf = true;
        this.Kg = true;
        lQ();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fw().removeCallbacks(this.Kn);
    }
}
