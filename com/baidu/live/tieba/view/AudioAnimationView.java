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
    private int abA;
    private boolean abB;
    private boolean abC;
    private int[] abE;
    private int abF;
    private int abG;
    private final Runnable abH;
    private int abz;
    private Rect[] bDn;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.abz = 0;
        this.abA = 8;
        this.abB = false;
        this.abC = true;
        this.abE = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abF = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.abG = a.c.sdk_cp_link_tip_a;
        this.abH = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
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
        this.abz = 0;
        this.abA = 8;
        this.abB = false;
        this.abC = true;
        this.abE = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abF = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.abG = a.c.sdk_cp_link_tip_a;
        this.abH = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
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
        if (this.abB) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.abH);
        if (!this.abC) {
            SafeHandler.getInst().postDelayed(this.abH, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.abz > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.abF * ((this.abz * 2) - 1);
            this.abA = this.abz;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.abz <= 0) {
            this.abA = (this.mCanvasWidth / this.abF) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.abB) {
            for (int i = 0; i < this.abA; i++) {
                sx();
                if (i < this.bDn.length) {
                    canvas.drawRect(this.bDn[i], this.mPaint);
                }
            }
        }
    }

    private void sw() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.abG));
    }

    private void sx() {
        int nextInt;
        if (this.bDn == null || this.bDn.length != this.abA) {
            this.bDn = new Rect[this.abA];
        }
        for (int i = 0; i < this.abA; i++) {
            int i2 = this.abF * i * 2;
            if (this.abC) {
                nextInt = (int) ((1.0d - (this.abE[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.abF + i2;
            int i4 = this.mCanvasHeight;
            if (this.bDn[i] == null) {
                this.bDn[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.bDn[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.abF = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.abG = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.abz = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.abH);
    }
}
