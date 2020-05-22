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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.u.a;
import java.util.Random;
/* loaded from: classes3.dex */
public class AudioAnimationView extends View {
    private int ZH;
    private int ZI;
    private boolean ZJ;
    private boolean ZK;
    private int[] ZM;
    private int ZN;
    private int ZO;
    private final Runnable ZP;
    private Rect[] bcN;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.ZH = 0;
        this.ZI = 8;
        this.ZJ = false;
        this.ZK = true;
        this.ZM = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ZN = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.ZO = a.d.sdk_cp_link_tip_a;
        this.ZP = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qx();
            }
        };
        qy();
        qx();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.ZH = 0;
        this.ZI = 8;
        this.ZJ = false;
        this.ZK = true;
        this.ZM = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.ZN = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.ZO = a.d.sdk_cp_link_tip_a;
        this.ZP = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qx();
            }
        };
        qy();
        qx();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qx() {
        if (this.ZJ) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.ZP);
        if (!this.ZK) {
            SafeHandler.getInst().postDelayed(this.ZP, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.ZH > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.ZN * ((this.ZH * 2) - 1);
            this.ZI = this.ZH;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.ZH <= 0) {
            this.ZI = (this.mCanvasWidth / this.ZN) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.ZJ) {
            for (int i = 0; i < this.ZI; i++) {
                qz();
                if (i < this.bcN.length) {
                    canvas.drawRect(this.bcN[i], this.mPaint);
                }
            }
        }
    }

    private void qy() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.ZO));
    }

    private void qz() {
        int nextInt;
        if (this.bcN == null || this.bcN.length != this.ZI) {
            this.bcN = new Rect[this.ZI];
        }
        for (int i = 0; i < this.ZI; i++) {
            int i2 = this.ZN * i * 2;
            if (this.ZK) {
                nextInt = (int) ((1.0d - (this.ZM[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.ZN + i2;
            int i4 = this.mCanvasHeight;
            if (this.bcN[i] == null) {
                this.bcN[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.bcN[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.ZN = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.ZO = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.ZH = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.ZP);
    }
}
