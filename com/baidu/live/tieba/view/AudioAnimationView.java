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
/* loaded from: classes10.dex */
public class AudioAnimationView extends View {
    private int aeA;
    private int aeB;
    private boolean aeC;
    private boolean aeD;
    private int aeE;
    private int aeF;
    private int[] aeH;
    private int aeI;
    private int aeJ;
    private final Runnable aeK;
    private Rect[] bLV;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.aeA = 0;
        this.aeB = 8;
        this.aeC = false;
        this.aeD = true;
        this.aeH = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aeI = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.aeJ = a.c.sdk_cp_link_tip_a;
        this.aeK = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.rW();
            }
        };
        rX();
        rW();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.aeA = 0;
        this.aeB = 8;
        this.aeC = false;
        this.aeD = true;
        this.aeH = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aeI = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.aeJ = a.c.sdk_cp_link_tip_a;
        this.aeK = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.rW();
            }
        };
        rX();
        rW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rW() {
        if (this.aeC) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.aeK);
        if (!this.aeD) {
            SafeHandler.getInst().postDelayed(this.aeK, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.aeA > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.aeE = this.aeI * ((this.aeA * 2) - 1);
            this.aeB = this.aeA;
            i = View.MeasureSpec.makeMeasureSpec(this.aeE, mode);
        }
        super.onMeasure(i, i2);
        this.aeF = getMeasuredHeight();
        this.aeE = getMeasuredWidth();
        if (this.aeA <= 0) {
            this.aeB = (this.aeE / this.aeI) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aeC) {
            for (int i = 0; i < this.aeB; i++) {
                rY();
                if (i < this.bLV.length) {
                    canvas.drawRect(this.bLV[i], this.mPaint);
                }
            }
        }
    }

    private void rX() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.aeJ));
    }

    private void rY() {
        int nextInt;
        if (this.bLV == null || this.bLV.length != this.aeB) {
            this.bLV = new Rect[this.aeB];
        }
        for (int i = 0; i < this.aeB; i++) {
            int i2 = this.aeI * i * 2;
            if (this.aeD) {
                nextInt = (int) ((1.0d - (this.aeH[i % 22] / 10.0d)) * this.aeF);
            } else {
                nextInt = this.aeF > 0 ? this.random.nextInt(this.aeF) : 0;
            }
            int i3 = this.aeI + i2;
            int i4 = this.aeF;
            if (this.bLV[i] == null) {
                this.bLV[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.bLV[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.aeI = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.aeJ = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.aeA = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.aeK);
    }
}
