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
/* loaded from: classes11.dex */
public class AudioAnimationView extends View {
    private int adp;
    private int adq;
    private boolean adr;
    private boolean ads;
    private int adt;
    private int adu;
    private int[] adw;
    private int adx;
    private int ady;
    private final Runnable adz;
    private Rect[] bLx;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.adp = 0;
        this.adq = 8;
        this.adr = false;
        this.ads = true;
        this.adw = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.adx = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.ady = a.c.sdk_cp_link_tip_a;
        this.adz = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.rZ();
            }
        };
        sa();
        rZ();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.adp = 0;
        this.adq = 8;
        this.adr = false;
        this.ads = true;
        this.adw = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.adx = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.ady = a.c.sdk_cp_link_tip_a;
        this.adz = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.rZ();
            }
        };
        sa();
        rZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ() {
        if (this.adr) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.adz);
        if (!this.ads) {
            SafeHandler.getInst().postDelayed(this.adz, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.adp > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.adt = this.adx * ((this.adp * 2) - 1);
            this.adq = this.adp;
            i = View.MeasureSpec.makeMeasureSpec(this.adt, mode);
        }
        super.onMeasure(i, i2);
        this.adu = getMeasuredHeight();
        this.adt = getMeasuredWidth();
        if (this.adp <= 0) {
            this.adq = (this.adt / this.adx) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.adr) {
            for (int i = 0; i < this.adq; i++) {
                sb();
                if (i < this.bLx.length) {
                    canvas.drawRect(this.bLx[i], this.mPaint);
                }
            }
        }
    }

    private void sa() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.ady));
    }

    private void sb() {
        int nextInt;
        if (this.bLx == null || this.bLx.length != this.adq) {
            this.bLx = new Rect[this.adq];
        }
        for (int i = 0; i < this.adq; i++) {
            int i2 = this.adx * i * 2;
            if (this.ads) {
                nextInt = (int) ((1.0d - (this.adw[i % 22] / 10.0d)) * this.adu);
            } else {
                nextInt = this.adu > 0 ? this.random.nextInt(this.adu) : 0;
            }
            int i3 = this.adx + i2;
            int i4 = this.adu;
            if (this.bLx[i] == null) {
                this.bLx[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.bLx[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.adx = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.ady = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.adp = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.adz);
    }
}
