package com.baidu.audiorecorder.lib.voice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.Random;
/* loaded from: classes11.dex */
public class RecordingAnimView extends View {
    private int Zr;
    private int Zs;
    private boolean Zt;
    private boolean Zu;
    private RectF[] Zv;
    private int[] Zw;
    private int Zx;
    private int Zy;
    private final Runnable Zz;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Zr = 0;
        this.Zs = 8;
        this.Zt = false;
        this.Zu = true;
        this.Zw = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Zx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.Zz = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.qr();
            }
        };
        qs();
        qr();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Zr = 0;
        this.Zs = 8;
        this.Zt = false;
        this.Zu = true;
        this.Zw = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Zx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.Zz = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.qr();
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
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.Zz);
        if (!this.Zu) {
            com.baidu.adp.lib.f.e.lb().postDelayed(this.Zz, 250L);
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
                if (i < this.Zv.length) {
                    canvas.drawRoundRect(this.Zv[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void qs() {
        this.Zy = aR(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(am.getColor(this.Zy));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.Zy = aR(i);
            this.mPaint.setColor(am.getColor(this.Zy));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int aR(int i) {
        return i == 0 ? R.color.white_alpha100 : R.color.white_alpha70;
    }

    private void qt() {
        int nextInt;
        if (this.Zv == null || this.Zv.length != this.Zs) {
            this.Zv = new RectF[this.Zs];
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
            if (this.Zv[i] == null) {
                this.Zv[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.Zv[i].set(i2, nextInt, i3, i4);
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
            this.mPaint.setColor(am.getColor(i));
        }
        this.Zy = i;
    }

    public void start() {
        this.Zt = true;
        this.Zu = false;
        qr();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Zr = i;
        }
    }

    public void qu() {
        this.Zt = true;
        this.Zu = true;
        qr();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.lb().removeCallbacks(this.Zz);
    }
}
