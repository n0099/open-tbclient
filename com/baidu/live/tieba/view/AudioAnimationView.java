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
    private boolean abA;
    private boolean abB;
    private int[] abD;
    private int abE;
    private int abF;
    private final Runnable abG;
    private int aby;
    private int abz;
    private Rect[] buO;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.aby = 0;
        this.abz = 8;
        this.abA = false;
        this.abB = true;
        this.abD = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abE = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.abF = a.d.sdk_cp_link_tip_a;
        this.abG = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
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
        this.aby = 0;
        this.abz = 8;
        this.abA = false;
        this.abB = true;
        this.abD = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abE = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.abF = a.d.sdk_cp_link_tip_a;
        this.abG = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
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
        if (this.abA) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.abG);
        if (!this.abB) {
            SafeHandler.getInst().postDelayed(this.abG, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.aby > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.abE * ((this.aby * 2) - 1);
            this.abz = this.aby;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.aby <= 0) {
            this.abz = (this.mCanvasWidth / this.abE) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.abA) {
            for (int i = 0; i < this.abz; i++) {
                sx();
                if (i < this.buO.length) {
                    canvas.drawRect(this.buO[i], this.mPaint);
                }
            }
        }
    }

    private void sw() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.abF));
    }

    private void sx() {
        int nextInt;
        if (this.buO == null || this.buO.length != this.abz) {
            this.buO = new Rect[this.abz];
        }
        for (int i = 0; i < this.abz; i++) {
            int i2 = this.abE * i * 2;
            if (this.abB) {
                nextInt = (int) ((1.0d - (this.abD[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.abE + i2;
            int i4 = this.mCanvasHeight;
            if (this.buO[i] == null) {
                this.buO[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.buO[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.abE = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.abF = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.aby = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.abG);
    }
}
