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
    private int ayc;
    private int ayd;
    private boolean aye;
    private boolean ayf;
    private int ayg;
    private int ayh;
    private RectF[] ayi;
    private int[] ayj;
    private int ayk;
    private int ayl;
    private final Runnable aym;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.ayc = 0;
        this.ayd = 8;
        this.aye = false;
        this.ayf = true;
        this.ayj = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ayk = l.s(TbadkCoreApplication.getInst(), d.e.ds4);
        this.aym = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
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
        this.ayc = 0;
        this.ayd = 8;
        this.aye = false;
        this.ayf = true;
        this.ayj = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ayk = l.s(TbadkCoreApplication.getInst(), d.e.ds4);
        this.aym = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
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
        if (this.aye) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.aym);
        if (!this.ayf) {
            com.baidu.adp.lib.g.e.nr().postDelayed(this.aym, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.ayc > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.ayg = this.ayk * ((this.ayc * 2) - 1);
            this.ayd = this.ayc;
            i = View.MeasureSpec.makeMeasureSpec(this.ayg, mode);
        }
        super.onMeasure(i, i2);
        this.ayh = getMeasuredHeight();
        this.ayg = getMeasuredWidth();
        if (this.ayc <= 0) {
            this.ayd = (this.ayg / this.ayk) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aye) {
            for (int i = 0; i < this.ayd; i++) {
                tm();
                if (i < this.ayi.length) {
                    canvas.drawRoundRect(this.ayi[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.ayl = dS(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.ayl));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.ayl = dS(i);
            this.mPaint.setColor(aj.getColor(this.ayl));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int dS(int i) {
        return i == 0 ? d.C0107d.white_alpha100 : d.C0107d.white_alpha70;
    }

    private void tm() {
        int nextInt;
        if (this.ayi == null || this.ayi.length != this.ayd) {
            this.ayi = new RectF[this.ayd];
        }
        for (int i = 0; i < this.ayd; i++) {
            int i2 = this.ayk * i * 2;
            if (this.ayf) {
                nextInt = (int) ((1.0d - (this.ayj[i % 22] / 10.0d)) * this.ayh);
            } else {
                nextInt = this.ayh > 0 ? this.random.nextInt(this.ayh) : 0;
            }
            int i3 = this.ayk + i2;
            int i4 = this.ayh;
            if (this.ayi[i] == null) {
                this.ayi[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.ayi[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.ayk = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.ayl = i;
    }

    public void start() {
        this.aye = true;
        this.ayf = false;
        tl();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.ayc = i;
        }
    }

    public void tn() {
        this.aye = true;
        this.ayf = true;
        tl();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.nr().removeCallbacks(this.aym);
    }
}
