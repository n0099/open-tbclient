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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import java.util.Random;
/* loaded from: classes2.dex */
public class AudioAnimationView extends View {
    private int FJ;
    private int FK;
    private boolean FL;
    private boolean FM;
    private int[] FO;
    private int FP;
    private int FQ;
    private final Runnable FR;
    private Rect[] axh;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.FJ = 0;
        this.FK = 8;
        this.FL = false;
        this.FM = true;
        this.FO = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.FP = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.FQ = a.d.sdk_cp_link_tip_a;
        this.FR = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.lA();
            }
        };
        lB();
        lA();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.FJ = 0;
        this.FK = 8;
        this.FL = false;
        this.FM = true;
        this.FO = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.FP = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.FQ = a.d.sdk_cp_link_tip_a;
        this.FR = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.lA();
            }
        };
        lB();
        lA();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lA() {
        if (this.FL) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.FR);
        if (!this.FM) {
            SafeHandler.getInst().postDelayed(this.FR, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.FJ > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.FP * ((this.FJ * 2) - 1);
            this.FK = this.FJ;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.FJ <= 0) {
            this.FK = (this.mCanvasWidth / this.FP) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.FL) {
            for (int i = 0; i < this.FK; i++) {
                lC();
                if (i < this.axh.length) {
                    canvas.drawRect(this.axh[i], this.mPaint);
                }
            }
        }
    }

    private void lB() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.FQ));
    }

    private void lC() {
        int nextInt;
        if (this.axh == null || this.axh.length != this.FK) {
            this.axh = new Rect[this.FK];
        }
        for (int i = 0; i < this.FK; i++) {
            int i2 = this.FP * i * 2;
            if (this.FM) {
                nextInt = (int) ((1.0d - (this.FO[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.FP + i2;
            int i4 = this.mCanvasHeight;
            if (this.axh[i] == null) {
                this.axh[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.axh[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.FP = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.FQ = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.FJ = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.FR);
    }
}
