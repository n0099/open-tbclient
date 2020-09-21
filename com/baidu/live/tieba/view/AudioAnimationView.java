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
    private int abh;
    private int abi;
    private boolean abj;
    private boolean abk;
    private int[] abm;
    private int abn;
    private int abo;
    private final Runnable abp;
    private Rect[] bra;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.abh = 0;
        this.abi = 8;
        this.abj = false;
        this.abk = true;
        this.abm = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abn = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.abo = a.d.sdk_cp_link_tip_a;
        this.abp = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
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
        this.abh = 0;
        this.abi = 8;
        this.abj = false;
        this.abk = true;
        this.abm = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abn = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.abo = a.d.sdk_cp_link_tip_a;
        this.abp = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
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
        if (this.abj) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.abp);
        if (!this.abk) {
            SafeHandler.getInst().postDelayed(this.abp, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.abh > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.abn * ((this.abh * 2) - 1);
            this.abi = this.abh;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.abh <= 0) {
            this.abi = (this.mCanvasWidth / this.abn) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.abj) {
            for (int i = 0; i < this.abi; i++) {
                sx();
                if (i < this.bra.length) {
                    canvas.drawRect(this.bra[i], this.mPaint);
                }
            }
        }
    }

    private void sw() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.abo));
    }

    private void sx() {
        int nextInt;
        if (this.bra == null || this.bra.length != this.abi) {
            this.bra = new Rect[this.abi];
        }
        for (int i = 0; i < this.abi; i++) {
            int i2 = this.abn * i * 2;
            if (this.abk) {
                nextInt = (int) ((1.0d - (this.abm[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.abn + i2;
            int i4 = this.mCanvasHeight;
            if (this.bra[i] == null) {
                this.bra[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.bra[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.abn = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.abo = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.abh = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.abp);
    }
}
