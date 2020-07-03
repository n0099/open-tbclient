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
/* loaded from: classes3.dex */
public class AudioAnimationView extends View {
    private int aam;
    private int aan;
    private boolean aao;
    private boolean aap;
    private int[] aar;
    private int aas;
    private int aat;
    private final Runnable aau;
    private Rect[] bhX;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.aam = 0;
        this.aan = 8;
        this.aao = false;
        this.aap = true;
        this.aar = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aas = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.aat = a.d.sdk_cp_link_tip_a;
        this.aau = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qO();
            }
        };
        qP();
        qO();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.aam = 0;
        this.aan = 8;
        this.aao = false;
        this.aap = true;
        this.aar = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aas = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.aat = a.d.sdk_cp_link_tip_a;
        this.aau = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qO();
            }
        };
        qP();
        qO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qO() {
        if (this.aao) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.aau);
        if (!this.aap) {
            SafeHandler.getInst().postDelayed(this.aau, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.aam > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.aas * ((this.aam * 2) - 1);
            this.aan = this.aam;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.aam <= 0) {
            this.aan = (this.mCanvasWidth / this.aas) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aao) {
            for (int i = 0; i < this.aan; i++) {
                qQ();
                if (i < this.bhX.length) {
                    canvas.drawRect(this.bhX[i], this.mPaint);
                }
            }
        }
    }

    private void qP() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.aat));
    }

    private void qQ() {
        int nextInt;
        if (this.bhX == null || this.bhX.length != this.aan) {
            this.bhX = new Rect[this.aan];
        }
        for (int i = 0; i < this.aan; i++) {
            int i2 = this.aas * i * 2;
            if (this.aap) {
                nextInt = (int) ((1.0d - (this.aar[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.aas + i2;
            int i4 = this.mCanvasHeight;
            if (this.bhX[i] == null) {
                this.bhX[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.bhX[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.aas = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.aat = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.aam = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.aau);
    }
}
