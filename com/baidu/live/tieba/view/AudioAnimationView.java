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
    private int aaM;
    private int aaN;
    private boolean aaO;
    private boolean aaP;
    private int[] aaR;
    private int aaS;
    private int aaT;
    private final Runnable aaU;
    private Rect[] bnZ;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.aaM = 0;
        this.aaN = 8;
        this.aaO = false;
        this.aaP = true;
        this.aaR = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aaS = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.aaT = a.d.sdk_cp_link_tip_a;
        this.aaU = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
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
        this.aaM = 0;
        this.aaN = 8;
        this.aaO = false;
        this.aaP = true;
        this.aaR = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aaS = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.aaT = a.d.sdk_cp_link_tip_a;
        this.aaU = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
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
        if (this.aaO) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.aaU);
        if (!this.aaP) {
            SafeHandler.getInst().postDelayed(this.aaU, 250L);
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
                if (i < this.bnZ.length) {
                    canvas.drawRect(this.bnZ[i], this.mPaint);
                }
            }
        }
    }

    private void sr() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.aaT));
    }

    private void ss() {
        int nextInt;
        if (this.bnZ == null || this.bnZ.length != this.aaN) {
            this.bnZ = new Rect[this.aaN];
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
            if (this.bnZ[i] == null) {
                this.bnZ[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.bnZ[i].set(i2, nextInt, i3, i4);
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
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.aaT = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.aaM = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.aaU);
    }
}
