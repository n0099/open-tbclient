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
    private int aaM;
    private int aaN;
    private boolean aaO;
    private boolean aaP;
    private RectF[] aaQ;
    private int[] aaR;
    private int aaS;
    private int aaT;
    private final Runnable aaU;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.aaM = 0;
        this.aaN = 8;
        this.aaO = false;
        this.aaP = true;
        this.aaR = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aaS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.aaU = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
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
        this.aaM = 0;
        this.aaN = 8;
        this.aaO = false;
        this.aaP = true;
        this.aaR = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aaS = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.aaU = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
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
        if (this.aaO) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.aaU);
        if (!this.aaP) {
            com.baidu.adp.lib.f.e.mS().postDelayed(this.aaU, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.aaM > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.aaS * ((this.aaM * 2) - 1);
            this.aaN = this.aaM;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.aaM <= 0) {
            this.aaN = (this.mCanvasWidth / this.aaS) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aaO) {
            for (int i = 0; i < this.aaN; i++) {
                ss();
                if (i < this.aaQ.length) {
                    canvas.drawRoundRect(this.aaQ[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void sr() {
        this.aaT = be(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ap.getColor(this.aaT));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.aaT = be(i);
            this.mPaint.setColor(ap.getColor(i, this.aaT));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int be(int i) {
        return i == 0 ? R.color.white_alpha100 : R.color.white_alpha70;
    }

    private void ss() {
        int nextInt;
        if (this.aaQ == null || this.aaQ.length != this.aaN) {
            this.aaQ = new RectF[this.aaN];
        }
        for (int i = 0; i < this.aaN; i++) {
            int i2 = this.aaS * i * 2;
            if (this.aaP) {
                nextInt = (int) ((1.0d - (this.aaR[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.aaS + i2;
            int i4 = this.mCanvasHeight;
            if (this.aaQ[i] == null) {
                this.aaQ[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.aaQ[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.aaS = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ap.getColor(i));
        }
        this.aaT = i;
    }

    public void start() {
        this.aaO = true;
        this.aaP = false;
        sq();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.aaM = i;
        }
    }

    public void st() {
        this.aaO = true;
        this.aaP = true;
        sq();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.mS().removeCallbacks(this.aaU);
    }
}
