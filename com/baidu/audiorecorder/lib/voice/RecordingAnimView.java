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
import com.baidu.tieba.d;
import java.util.Random;
/* loaded from: classes3.dex */
public class RecordingAnimView extends View {
    private int QA;
    private RectF[] QB;
    private int[] QC;
    private int QD;
    private int QE;
    private final Runnable QF;
    private int Qv;
    private int Qw;
    private boolean Qx;
    private boolean Qy;
    private int Qz;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Qv = 0;
        this.Qw = 8;
        this.Qx = false;
        this.Qy = true;
        this.QC = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.QD = l.f(TbadkCoreApplication.getInst(), d.e.ds4);
        this.QF = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.oJ();
            }
        };
        oK();
        oJ();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Qv = 0;
        this.Qw = 8;
        this.Qx = false;
        this.Qy = true;
        this.QC = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.QD = l.f(TbadkCoreApplication.getInst(), d.e.ds4);
        this.QF = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.oJ();
            }
        };
        oK();
        oJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void oJ() {
        if (this.Qx) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.QF);
        if (!this.Qy) {
            com.baidu.adp.lib.g.e.in().postDelayed(this.QF, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Qv > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Qz = this.QD * ((this.Qv * 2) - 1);
            this.Qw = this.Qv;
            i = View.MeasureSpec.makeMeasureSpec(this.Qz, mode);
        }
        super.onMeasure(i, i2);
        this.QA = getMeasuredHeight();
        this.Qz = getMeasuredWidth();
        if (this.Qv <= 0) {
            this.Qw = (this.Qz / this.QD) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Qx) {
            for (int i = 0; i < this.Qw; i++) {
                oL();
                if (i < this.QB.length) {
                    canvas.drawRoundRect(this.QB[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void oK() {
        this.QE = aZ(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(am.getColor(this.QE));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.QE = aZ(i);
            this.mPaint.setColor(am.getColor(this.QE));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int aZ(int i) {
        return i == 0 ? d.C0140d.white_alpha100 : d.C0140d.white_alpha70;
    }

    private void oL() {
        int nextInt;
        if (this.QB == null || this.QB.length != this.Qw) {
            this.QB = new RectF[this.Qw];
        }
        for (int i = 0; i < this.Qw; i++) {
            int i2 = this.QD * i * 2;
            if (this.Qy) {
                nextInt = (int) ((1.0d - (this.QC[i % 22] / 10.0d)) * this.QA);
            } else {
                nextInt = this.QA > 0 ? this.random.nextInt(this.QA) : 0;
            }
            int i3 = this.QD + i2;
            int i4 = this.QA;
            if (this.QB[i] == null) {
                this.QB[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.QB[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.QD = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(am.getColor(i));
        }
        this.QE = i;
    }

    public void start() {
        this.Qx = true;
        this.Qy = false;
        oJ();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Qv = i;
        }
    }

    public void oM() {
        this.Qx = true;
        this.Qy = true;
        oJ();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.in().removeCallbacks(this.QF);
    }
}
