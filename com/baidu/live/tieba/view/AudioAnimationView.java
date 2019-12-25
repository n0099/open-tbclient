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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import java.util.Random;
/* loaded from: classes2.dex */
public class AudioAnimationView extends View {
    private int FE;
    private int FF;
    private boolean FG;
    private boolean FH;
    private int[] FJ;
    private int FK;
    private int FL;
    private final Runnable FM;
    private Rect[] awv;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.FE = 0;
        this.FF = 8;
        this.FG = false;
        this.FH = true;
        this.FJ = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.FK = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.FL = a.d.sdk_cp_link_tip_a;
        this.FM = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
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
        this.FE = 0;
        this.FF = 8;
        this.FG = false;
        this.FH = true;
        this.FJ = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.FK = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.FL = a.d.sdk_cp_link_tip_a;
        this.FM = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
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
        if (this.FG) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.FM);
        if (!this.FH) {
            SafeHandler.getInst().postDelayed(this.FM, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.FE > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.FK * ((this.FE * 2) - 1);
            this.FF = this.FE;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.FE <= 0) {
            this.FF = (this.mCanvasWidth / this.FK) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.FG) {
            for (int i = 0; i < this.FF; i++) {
                lC();
                if (i < this.awv.length) {
                    canvas.drawRect(this.awv[i], this.mPaint);
                }
            }
        }
    }

    private void lB() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.FL));
    }

    private void lC() {
        int nextInt;
        if (this.awv == null || this.awv.length != this.FF) {
            this.awv = new Rect[this.FF];
        }
        for (int i = 0; i < this.FF; i++) {
            int i2 = this.FK * i * 2;
            if (this.FH) {
                nextInt = (int) ((1.0d - (this.FJ[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.FK + i2;
            int i4 = this.mCanvasHeight;
            if (this.awv[i] == null) {
                this.awv[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.awv[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.FK = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.FL = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.FE = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.FM);
    }
}
