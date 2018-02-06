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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes2.dex */
public class RecordingAnimView extends View {
    private int aye;
    private int ayf;
    private boolean ayg;
    private boolean ayh;
    private int ayi;
    private int ayj;
    private RectF[] ayk;
    private int[] ayl;
    private int aym;
    private int ayn;
    private final Runnable ayo;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.aye = 0;
        this.ayf = 8;
        this.ayg = false;
        this.ayh = true;
        this.ayl = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aym = l.t(TbadkCoreApplication.getInst(), d.e.ds4);
        this.ayo = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.tl();
            }
        };
        initPaint();
        tl();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.aye = 0;
        this.ayf = 8;
        this.ayg = false;
        this.ayh = true;
        this.ayl = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aym = l.t(TbadkCoreApplication.getInst(), d.e.ds4);
        this.ayo = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.tl();
            }
        };
        initPaint();
        tl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tl() {
        if (this.ayg) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.ayo);
        if (!this.ayh) {
            com.baidu.adp.lib.g.e.ns().postDelayed(this.ayo, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.aye > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.ayi = this.aym * ((this.aye * 2) - 1);
            this.ayf = this.aye;
            i = View.MeasureSpec.makeMeasureSpec(this.ayi, mode);
        }
        super.onMeasure(i, i2);
        this.ayj = getMeasuredHeight();
        this.ayi = getMeasuredWidth();
        if (this.aye <= 0) {
            this.ayf = (this.ayi / this.aym) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ayg) {
            for (int i = 0; i < this.ayf; i++) {
                tm();
                if (i < this.ayk.length) {
                    canvas.drawRoundRect(this.ayk[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.ayn = dT(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.ayn));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.ayn = dT(i);
            this.mPaint.setColor(aj.getColor(this.ayn));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int dT(int i) {
        return i == 0 ? d.C0140d.white_alpha100 : d.C0140d.white_alpha70;
    }

    private void tm() {
        int nextInt;
        if (this.ayk == null || this.ayk.length != this.ayf) {
            this.ayk = new RectF[this.ayf];
        }
        for (int i = 0; i < this.ayf; i++) {
            int i2 = this.aym * i * 2;
            if (this.ayh) {
                nextInt = (int) ((1.0d - (this.ayl[i % 22] / 10.0d)) * this.ayj);
            } else {
                nextInt = this.ayj > 0 ? this.random.nextInt(this.ayj) : 0;
            }
            int i3 = this.aym + i2;
            int i4 = this.ayj;
            if (this.ayk[i] == null) {
                this.ayk[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.ayk[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.aym = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.ayn = i;
    }

    public void start() {
        this.ayg = true;
        this.ayh = false;
        tl();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.aye = i;
        }
    }

    public void tn() {
        this.ayg = true;
        this.ayh = true;
        tl();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.ns().removeCallbacks(this.ayo);
    }
}
