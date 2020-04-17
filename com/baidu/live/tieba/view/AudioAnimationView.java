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
    private int Zo;
    private int Zp;
    private boolean Zq;
    private boolean Zr;
    private int[] Zt;
    private int Zu;
    private int Zv;
    private final Runnable Zw;
    private Rect[] aVu;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Zo = 0;
        this.Zp = 8;
        this.Zq = false;
        this.Zr = true;
        this.Zt = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Zu = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.Zv = a.d.sdk_cp_link_tip_a;
        this.Zw = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
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
        this.Zo = 0;
        this.Zp = 8;
        this.Zq = false;
        this.Zr = true;
        this.Zt = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Zu = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.Zv = a.d.sdk_cp_link_tip_a;
        this.Zw = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
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
        if (this.Zq) {
            invalidate();
        }
        SafeHandler.getInst().removeCallbacks(this.Zw);
        if (!this.Zr) {
            SafeHandler.getInst().postDelayed(this.Zw, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Zo > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.Zu * ((this.Zo * 2) - 1);
            this.Zp = this.Zo;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.Zo <= 0) {
            this.Zp = (this.mCanvasWidth / this.Zu) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Zq) {
            for (int i = 0; i < this.Zp; i++) {
                qt();
                if (i < this.aVu.length) {
                    canvas.drawRect(this.aVu[i], this.mPaint);
                }
            }
        }
    }

    private void qs() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.Zv));
    }

    private void qt() {
        int nextInt;
        if (this.aVu == null || this.aVu.length != this.Zp) {
            this.aVu = new Rect[this.Zp];
        }
        for (int i = 0; i < this.Zp; i++) {
            int i2 = this.Zu * i * 2;
            if (this.Zr) {
                nextInt = (int) ((1.0d - (this.Zt[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.Zu + i2;
            int i4 = this.mCanvasHeight;
            if (this.aVu[i] == null) {
                this.aVu[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.aVu[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Zu = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.Zv = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Zo = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.Zw);
    }
}
