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
    private int aah;
    private int aai;
    private boolean aaj;
    private boolean aak;
    private int[] aam;
    private int aan;
    private int aao;
    private final Runnable aap;
    private Rect[] biu;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.aah = 0;
        this.aai = 8;
        this.aaj = false;
        this.aak = true;
        this.aam = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aan = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.aao = a.d.sdk_cp_link_tip_a;
        this.aap = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qR();
            }
        };
        qS();
        qR();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.aah = 0;
        this.aai = 8;
        this.aaj = false;
        this.aak = true;
        this.aam = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aan = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.aao = a.d.sdk_cp_link_tip_a;
        this.aap = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qR();
            }
        };
        qS();
        qR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qR() {
        if (this.aaj) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.aap);
        if (!this.aak) {
            SafeHandler.getInst().postDelayed(this.aap, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.aah > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.aan * ((this.aah * 2) - 1);
            this.aai = this.aah;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.aah <= 0) {
            this.aai = (this.mCanvasWidth / this.aan) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aaj) {
            for (int i = 0; i < this.aai; i++) {
                qT();
                if (i < this.biu.length) {
                    canvas.drawRect(this.biu[i], this.mPaint);
                }
            }
        }
    }

    private void qS() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.aao));
    }

    private void qT() {
        int nextInt;
        if (this.biu == null || this.biu.length != this.aai) {
            this.biu = new Rect[this.aai];
        }
        for (int i = 0; i < this.aai; i++) {
            int i2 = this.aan * i * 2;
            if (this.aak) {
                nextInt = (int) ((1.0d - (this.aam[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.aan + i2;
            int i4 = this.mCanvasHeight;
            if (this.biu[i] == null) {
                this.biu[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.biu[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.aan = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.aao = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.aah = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.aap);
    }
}
