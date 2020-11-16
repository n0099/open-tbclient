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
/* loaded from: classes4.dex */
public class AudioAnimationView extends View {
    private int abE;
    private int abF;
    private boolean abG;
    private boolean abH;
    private int[] abJ;
    private int abK;
    private int abL;
    private final Runnable abM;
    private Rect[] bBC;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.abE = 0;
        this.abF = 8;
        this.abG = false;
        this.abH = true;
        this.abJ = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abK = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.abL = a.c.sdk_cp_link_tip_a;
        this.abM = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.sv();
            }
        };
        sw();
        sv();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.abE = 0;
        this.abF = 8;
        this.abG = false;
        this.abH = true;
        this.abJ = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abK = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.abL = a.c.sdk_cp_link_tip_a;
        this.abM = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.sv();
            }
        };
        sw();
        sv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sv() {
        if (this.abG) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.abM);
        if (!this.abH) {
            SafeHandler.getInst().postDelayed(this.abM, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.abE > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.abK * ((this.abE * 2) - 1);
            this.abF = this.abE;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.abE <= 0) {
            this.abF = (this.mCanvasWidth / this.abK) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.abG) {
            for (int i = 0; i < this.abF; i++) {
                sx();
                if (i < this.bBC.length) {
                    canvas.drawRect(this.bBC[i], this.mPaint);
                }
            }
        }
    }

    private void sw() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.abL));
    }

    private void sx() {
        int nextInt;
        if (this.bBC == null || this.bBC.length != this.abF) {
            this.bBC = new Rect[this.abF];
        }
        for (int i = 0; i < this.abF; i++) {
            int i2 = this.abK * i * 2;
            if (this.abH) {
                nextInt = (int) ((1.0d - (this.abJ[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.abK + i2;
            int i4 = this.mCanvasHeight;
            if (this.bBC[i] == null) {
                this.bBC[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.bBC[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.abK = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.abL = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.abE = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.abM);
    }
}
