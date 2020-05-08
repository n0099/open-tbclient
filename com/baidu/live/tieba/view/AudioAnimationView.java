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
    private int Zr;
    private int Zs;
    private boolean Zt;
    private boolean Zu;
    private int[] Zw;
    private int Zx;
    private int Zy;
    private final Runnable Zz;
    private Rect[] aVz;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Zr = 0;
        this.Zs = 8;
        this.Zt = false;
        this.Zu = true;
        this.Zw = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Zx = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.Zy = a.d.sdk_cp_link_tip_a;
        this.Zz = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qr();
            }
        };
        qs();
        qr();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Zr = 0;
        this.Zs = 8;
        this.Zt = false;
        this.Zu = true;
        this.Zw = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Zx = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.Zy = a.d.sdk_cp_link_tip_a;
        this.Zz = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.qr();
            }
        };
        qs();
        qr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qr() {
        if (this.Zt) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.Zz);
        if (!this.Zu) {
            SafeHandler.getInst().postDelayed(this.Zz, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Zr > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.Zx * ((this.Zr * 2) - 1);
            this.Zs = this.Zr;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.Zr <= 0) {
            this.Zs = (this.mCanvasWidth / this.Zx) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Zt) {
            for (int i = 0; i < this.Zs; i++) {
                qt();
                if (i < this.aVz.length) {
                    canvas.drawRect(this.aVz[i], this.mPaint);
                }
            }
        }
    }

    private void qs() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.Zy));
    }

    private void qt() {
        int nextInt;
        if (this.aVz == null || this.aVz.length != this.Zs) {
            this.aVz = new Rect[this.Zs];
        }
        for (int i = 0; i < this.Zs; i++) {
            int i2 = this.Zx * i * 2;
            if (this.Zu) {
                nextInt = (int) ((1.0d - (this.Zw[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.Zx + i2;
            int i4 = this.mCanvasHeight;
            if (this.aVz[i] == null) {
                this.aVz[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.aVz[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Zx = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.Zy = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Zr = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.Zz);
    }
}
