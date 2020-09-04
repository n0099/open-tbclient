package com.baidu.live.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import java.util.Random;
/* loaded from: classes7.dex */
public class AudioAnimationView extends View {
    private int aaO;
    private int aaP;
    private boolean aaQ;
    private boolean aaR;
    private int[] aaT;
    private int aaU;
    private int aaV;
    private final Runnable aaW;
    private Rect[] boc;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.aaO = 0;
        this.aaP = 8;
        this.aaQ = false;
        this.aaR = true;
        this.aaT = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aaU = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.aaV = a.d.sdk_cp_link_tip_a;
        this.aaW = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.sq();
            }
        };
        sr();
        sq();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.aaO = 0;
        this.aaP = 8;
        this.aaQ = false;
        this.aaR = true;
        this.aaT = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aaU = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.aaV = a.d.sdk_cp_link_tip_a;
        this.aaW = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.sq();
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
        SafeHandler.getInst().removeCallbacks(this.aaW);
        if (!this.aaR) {
            SafeHandler.getInst().postDelayed(this.aaW, 250L);
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
                if (i < this.boc.length) {
                    canvas.drawRect(this.boc[i], this.mPaint);
                }
            }
        }
    }

    private void sr() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.aaV));
    }

    private void ss() {
        int nextInt;
        if (this.boc == null || this.boc.length != this.aaP) {
            this.boc = new Rect[this.aaP];
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
            if (this.boc[i] == null) {
                this.boc[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.boc[i].set(i2, nextInt, i3, i4);
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
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.aaV = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.aaO = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.aaW);
    }
}
