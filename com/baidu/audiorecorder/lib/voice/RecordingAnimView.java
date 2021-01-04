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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.Random;
/* loaded from: classes8.dex */
public class RecordingAnimView extends View {
    private int adp;
    private int adq;
    private boolean adr;
    private boolean ads;
    private int adt;
    private int adu;
    private RectF[] adv;
    private int[] adw;
    private int adx;
    private int ady;
    private final Runnable adz;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.adp = 0;
        this.adq = 8;
        this.adr = false;
        this.ads = true;
        this.adw = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.adx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.adz = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.rZ();
            }
        };
        sa();
        rZ();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.adp = 0;
        this.adq = 8;
        this.adr = false;
        this.ads = true;
        this.adw = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.adx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.adz = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.rZ();
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
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.adz);
        if (!this.ads) {
            com.baidu.adp.lib.f.e.mB().postDelayed(this.adz, 250L);
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
                if (i < this.adv.length) {
                    canvas.drawRoundRect(this.adv[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void sa() {
        this.ady = bm(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ao.getColor(this.ady));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.ady = bm(i);
            this.mPaint.setColor(ao.getColor(i, this.ady));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int bm(int i) {
        return i == 0 ? R.color.white_alpha100 : R.color.white_alpha70;
    }

    private void sb() {
        int nextInt;
        if (this.adv == null || this.adv.length != this.adq) {
            this.adv = new RectF[this.adq];
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
            if (this.adv[i] == null) {
                this.adv[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.adv[i].set(i2, nextInt, i3, i4);
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
            this.mPaint.setColor(ao.getColor(i));
        }
        this.ady = i;
    }

    public void start() {
        this.adr = true;
        this.ads = false;
        rZ();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.adp = i;
        }
    }

    public void sc() {
        this.adr = true;
        this.ads = true;
        rZ();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.adz);
    }
}
