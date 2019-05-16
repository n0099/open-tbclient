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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.R;
import java.util.Random;
/* loaded from: classes6.dex */
public class RecordingAnimView extends View {
    private int TS;
    private int TT;
    private boolean TU;
    private boolean TV;
    private int TW;
    private int TX;
    private RectF[] TY;
    private int[] TZ;
    private int Ua;
    private int Ub;
    private final Runnable Uc;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.TS = 0;
        this.TT = 8;
        this.TU = false;
        this.TV = true;
        this.TZ = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Ua = l.g(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.Uc = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.pS();
            }
        };
        pT();
        pS();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.TS = 0;
        this.TT = 8;
        this.TU = false;
        this.TV = true;
        this.TZ = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Ua = l.g(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.Uc = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.pS();
            }
        };
        pT();
        pS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pS() {
        if (this.TU) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.Uc);
        if (!this.TV) {
            com.baidu.adp.lib.g.e.iB().postDelayed(this.Uc, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.TS > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.TW = this.Ua * ((this.TS * 2) - 1);
            this.TT = this.TS;
            i = View.MeasureSpec.makeMeasureSpec(this.TW, mode);
        }
        super.onMeasure(i, i2);
        this.TX = getMeasuredHeight();
        this.TW = getMeasuredWidth();
        if (this.TS <= 0) {
            this.TT = (this.TW / this.Ua) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.TU) {
            for (int i = 0; i < this.TT; i++) {
                pU();
                if (i < this.TY.length) {
                    canvas.drawRoundRect(this.TY[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void pT() {
        this.Ub = bk(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(al.getColor(this.Ub));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.Ub = bk(i);
            this.mPaint.setColor(al.getColor(this.Ub));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int bk(int i) {
        return i == 0 ? R.color.white_alpha100 : R.color.white_alpha70;
    }

    private void pU() {
        int nextInt;
        if (this.TY == null || this.TY.length != this.TT) {
            this.TY = new RectF[this.TT];
        }
        for (int i = 0; i < this.TT; i++) {
            int i2 = this.Ua * i * 2;
            if (this.TV) {
                nextInt = (int) ((1.0d - (this.TZ[i % 22] / 10.0d)) * this.TX);
            } else {
                nextInt = this.TX > 0 ? this.random.nextInt(this.TX) : 0;
            }
            int i3 = this.Ua + i2;
            int i4 = this.TX;
            if (this.TY[i] == null) {
                this.TY[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.TY[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Ua = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(al.getColor(i));
        }
        this.Ub = i;
    }

    public void start() {
        this.TU = true;
        this.TV = false;
        pS();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.TS = i;
        }
    }

    public void pV() {
        this.TU = true;
        this.TV = true;
        pS();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.iB().removeCallbacks(this.Uc);
    }
}
