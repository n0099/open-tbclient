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
    private int adh;
    private int adi;
    private boolean adj;
    private boolean adk;
    private int adl;
    private int adm;
    private int[] ado;
    private int adp;
    private int adq;
    private final Runnable adr;
    private Rect[] bKv;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.adh = 0;
        this.adi = 8;
        this.adj = false;
        this.adk = true;
        this.ado = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.adp = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.adq = a.c.sdk_cp_link_tip_a;
        this.adr = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.rW();
            }
        };
        rX();
        rW();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.adh = 0;
        this.adi = 8;
        this.adj = false;
        this.adk = true;
        this.ado = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.adp = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.adq = a.c.sdk_cp_link_tip_a;
        this.adr = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.rW();
            }
        };
        rX();
        rW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rW() {
        if (this.adj) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.adr);
        if (!this.adk) {
            SafeHandler.getInst().postDelayed(this.adr, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.adh > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.adl = this.adp * ((this.adh * 2) - 1);
            this.adi = this.adh;
            i = View.MeasureSpec.makeMeasureSpec(this.adl, mode);
        }
        super.onMeasure(i, i2);
        this.adm = getMeasuredHeight();
        this.adl = getMeasuredWidth();
        if (this.adh <= 0) {
            this.adi = (this.adl / this.adp) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.adj) {
            for (int i = 0; i < this.adi; i++) {
                rY();
                if (i < this.bKv.length) {
                    canvas.drawRect(this.bKv[i], this.mPaint);
                }
            }
        }
    }

    private void rX() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.adq));
    }

    private void rY() {
        int nextInt;
        if (this.bKv == null || this.bKv.length != this.adi) {
            this.bKv = new Rect[this.adi];
        }
        for (int i = 0; i < this.adi; i++) {
            int i2 = this.adp * i * 2;
            if (this.adk) {
                nextInt = (int) ((1.0d - (this.ado[i % 22] / 10.0d)) * this.adm);
            } else {
                nextInt = this.adm > 0 ? this.random.nextInt(this.adm) : 0;
            }
            int i3 = this.adp + i2;
            int i4 = this.adm;
            if (this.bKv[i] == null) {
                this.bKv[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.bKv[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.adp = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.adq = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.adh = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.adr);
    }
}
