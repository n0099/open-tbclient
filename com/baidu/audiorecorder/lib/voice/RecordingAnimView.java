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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Random;
/* loaded from: classes18.dex */
public class RecordingAnimView extends View {
    private int aaO;
    private int aaP;
    private boolean aaQ;
    private boolean aaR;
    private RectF[] aaS;
    private int[] aaT;
    private int aaU;
    private int aaV;
    private final Runnable aaW;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.aaO = 0;
        this.aaP = 8;
        this.aaQ = false;
        this.aaR = true;
        this.aaT = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aaU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.aaW = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.sq();
            }
        };
        sr();
        sq();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.aaO = 0;
        this.aaP = 8;
        this.aaQ = false;
        this.aaR = true;
        this.aaT = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aaU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.aaW = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.sq();
            }
        };
        sr();
        sq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sq() {
        if (this.aaQ) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.aaW);
        if (!this.aaR) {
            com.baidu.adp.lib.f.e.mS().postDelayed(this.aaW, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.aaO > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.aaU * ((this.aaO * 2) - 1);
            this.aaP = this.aaO;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.aaO <= 0) {
            this.aaP = (this.mCanvasWidth / this.aaU) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aaQ) {
            for (int i = 0; i < this.aaP; i++) {
                ss();
                if (i < this.aaS.length) {
                    canvas.drawRoundRect(this.aaS[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void sr() {
        this.aaV = be(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ap.getColor(this.aaV));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.aaV = be(i);
            this.mPaint.setColor(ap.getColor(i, this.aaV));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int be(int i) {
        return i == 0 ? R.color.white_alpha100 : R.color.white_alpha70;
    }

    private void ss() {
        int nextInt;
        if (this.aaS == null || this.aaS.length != this.aaP) {
            this.aaS = new RectF[this.aaP];
        }
        for (int i = 0; i < this.aaP; i++) {
            int i2 = this.aaU * i * 2;
            if (this.aaR) {
                nextInt = (int) ((1.0d - (this.aaT[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.aaU + i2;
            int i4 = this.mCanvasHeight;
            if (this.aaS[i] == null) {
                this.aaS[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.aaS[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.aaU = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ap.getColor(i));
        }
        this.aaV = i;
    }

    public void start() {
        this.aaQ = true;
        this.aaR = false;
        sq();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.aaO = i;
        }
    }

    public void st() {
        this.aaQ = true;
        this.aaR = true;
        sq();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.aaW);
    }
}
