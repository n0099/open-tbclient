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
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import java.util.Random;
/* loaded from: classes6.dex */
public class AudioAnimationView extends View {
    private int DA;
    private int DC;
    private boolean DD;
    private boolean DE;
    private int DF;
    private int DG;
    private int[] DI;
    private int DJ;
    private int DK;
    private final Runnable DL;
    private Rect[] aoQ;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.DA = 0;
        this.DC = 8;
        this.DD = false;
        this.DE = true;
        this.DI = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.DJ = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.DK = a.d.sdk_cp_link_tip_a;
        this.DL = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.li();
            }
        };
        lj();
        li();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.DA = 0;
        this.DC = 8;
        this.DD = false;
        this.DE = true;
        this.DI = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.DJ = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.DK = a.d.sdk_cp_link_tip_a;
        this.DL = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.li();
            }
        };
        lj();
        li();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li() {
        if (this.DD) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.DL);
        if (!this.DE) {
            SafeHandler.getInst().postDelayed(this.DL, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.DA > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.DF = this.DJ * ((this.DA * 2) - 1);
            this.DC = this.DA;
            i = View.MeasureSpec.makeMeasureSpec(this.DF, mode);
        }
        super.onMeasure(i, i2);
        this.DG = getMeasuredHeight();
        this.DF = getMeasuredWidth();
        if (this.DA <= 0) {
            this.DC = (this.DF / this.DJ) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.DD) {
            for (int i = 0; i < this.DC; i++) {
                lk();
                if (i < this.aoQ.length) {
                    canvas.drawRect(this.aoQ[i], this.mPaint);
                }
            }
        }
    }

    private void lj() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.DK));
    }

    private void lk() {
        int nextInt;
        if (this.aoQ == null || this.aoQ.length != this.DC) {
            this.aoQ = new Rect[this.DC];
        }
        for (int i = 0; i < this.DC; i++) {
            int i2 = this.DJ * i * 2;
            if (this.DE) {
                nextInt = (int) ((1.0d - (this.DI[i % 22] / 10.0d)) * this.DG);
            } else {
                nextInt = this.DG > 0 ? this.random.nextInt(this.DG) : 0;
            }
            int i3 = this.DJ + i2;
            int i4 = this.DG;
            if (this.aoQ[i] == null) {
                this.aoQ[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.aoQ[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.DJ = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.DK = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.DA = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.DL);
    }
}
