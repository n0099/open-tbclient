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
    private int acC;
    private int acD;
    private boolean acE;
    private boolean acF;
    private int[] acH;
    private int acI;
    private int acJ;
    private final Runnable acK;
    private Rect[] bGK;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.acC = 0;
        this.acD = 8;
        this.acE = false;
        this.acF = true;
        this.acH = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.acI = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.acJ = a.c.sdk_cp_link_tip_a;
        this.acK = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.sy();
            }
        };
        sz();
        sy();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.acC = 0;
        this.acD = 8;
        this.acE = false;
        this.acF = true;
        this.acH = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.acI = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.acJ = a.c.sdk_cp_link_tip_a;
        this.acK = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.sy();
            }
        };
        sz();
        sy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sy() {
        if (this.acE) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.acK);
        if (!this.acF) {
            SafeHandler.getInst().postDelayed(this.acK, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.acC > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.acI * ((this.acC * 2) - 1);
            this.acD = this.acC;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.acC <= 0) {
            this.acD = (this.mCanvasWidth / this.acI) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.acE) {
            for (int i = 0; i < this.acD; i++) {
                sA();
                if (i < this.bGK.length) {
                    canvas.drawRect(this.bGK[i], this.mPaint);
                }
            }
        }
    }

    private void sz() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.acJ));
    }

    private void sA() {
        int nextInt;
        if (this.bGK == null || this.bGK.length != this.acD) {
            this.bGK = new Rect[this.acD];
        }
        for (int i = 0; i < this.acD; i++) {
            int i2 = this.acI * i * 2;
            if (this.acF) {
                nextInt = (int) ((1.0d - (this.acH[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.acI + i2;
            int i4 = this.mCanvasHeight;
            if (this.bGK[i] == null) {
                this.bGK[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.bGK[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.acI = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.acJ = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.acC = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.acK);
    }
}
