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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes2.dex */
public class RecordingAnimView extends View {
    private int Ji;
    private int Jj;
    private boolean Jk;
    private boolean Jl;
    private int Jm;
    private int Jn;
    private RectF[] Jo;
    private int[] Jp;
    private int Jq;
    private int Jr;
    private final Runnable Js;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Ji = 0;
        this.Jj = 8;
        this.Jk = false;
        this.Jl = true;
        this.Jp = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Jq = l.f(TbadkCoreApplication.getInst(), d.e.ds4);
        this.Js = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.lI();
            }
        };
        initPaint();
        lI();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Ji = 0;
        this.Jj = 8;
        this.Jk = false;
        this.Jl = true;
        this.Jp = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Jq = l.f(TbadkCoreApplication.getInst(), d.e.ds4);
        this.Js = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.lI();
            }
        };
        initPaint();
        lI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lI() {
        if (this.Jk) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.Js);
        if (!this.Jl) {
            com.baidu.adp.lib.g.e.fP().postDelayed(this.Js, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Ji > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Jm = this.Jq * ((this.Ji * 2) - 1);
            this.Jj = this.Ji;
            i = View.MeasureSpec.makeMeasureSpec(this.Jm, mode);
        }
        super.onMeasure(i, i2);
        this.Jn = getMeasuredHeight();
        this.Jm = getMeasuredWidth();
        if (this.Ji <= 0) {
            this.Jj = (this.Jm / this.Jq) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Jk) {
            for (int i = 0; i < this.Jj; i++) {
                lJ();
                if (i < this.Jo.length) {
                    canvas.drawRoundRect(this.Jo[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void initPaint() {
        this.Jr = aR(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(aj.getColor(this.Jr));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.Jr = aR(i);
            this.mPaint.setColor(aj.getColor(this.Jr));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int aR(int i) {
        return i == 0 ? d.C0082d.white_alpha100 : d.C0082d.white_alpha70;
    }

    private void lJ() {
        int nextInt;
        if (this.Jo == null || this.Jo.length != this.Jj) {
            this.Jo = new RectF[this.Jj];
        }
        for (int i = 0; i < this.Jj; i++) {
            int i2 = this.Jq * i * 2;
            if (this.Jl) {
                nextInt = (int) ((1.0d - (this.Jp[i % 22] / 10.0d)) * this.Jn);
            } else {
                nextInt = this.Jn > 0 ? this.random.nextInt(this.Jn) : 0;
            }
            int i3 = this.Jq + i2;
            int i4 = this.Jn;
            if (this.Jo[i] == null) {
                this.Jo[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.Jo[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Jq = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(aj.getColor(i));
        }
        this.Jr = i;
    }

    public void start() {
        this.Jk = true;
        this.Jl = false;
        lI();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Ji = i;
        }
    }

    public void lK() {
        this.Jk = true;
        this.Jl = true;
        lI();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fP().removeCallbacks(this.Js);
    }
}
