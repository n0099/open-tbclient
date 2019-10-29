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
/* loaded from: classes6.dex */
public class RecordingAnimView extends View {
    private int DA;
    private int DC;
    private boolean DD;
    private boolean DE;
    private int DF;
    private int DG;
    private RectF[] DH;
    private int[] DI;
    private int DJ;
    private int DK;
    private final Runnable DL;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.DA = 0;
        this.DC = 8;
        this.DD = false;
        this.DE = true;
        this.DI = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.DJ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.DL = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.li();
            }
        };
        lj();
        li();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.DA = 0;
        this.DC = 8;
        this.DD = false;
        this.DE = true;
        this.DI = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.DJ = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.DL = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.li();
            }
        };
        lj();
        li();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void li() {
        if (this.DD) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.DL);
        if (!this.DE) {
            com.baidu.adp.lib.g.e.fZ().postDelayed(this.DL, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.DA > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.DF = this.DJ * ((this.DA * 2) - 1);
            this.DC = this.DA;
            i = View.MeasureSpec.makeMeasureSpec(this.DF, mode);
        }
        super.onMeasure(i, i2);
        this.DG = getMeasuredHeight();
        this.DF = getMeasuredWidth();
        if (this.DA <= 0) {
            this.DC = (this.DF / this.DJ) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.DD) {
            for (int i = 0; i < this.DC; i++) {
                lk();
                if (i < this.DH.length) {
                    canvas.drawRoundRect(this.DH[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void lj() {
        this.DK = az(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(am.getColor(this.DK));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.DK = az(i);
            this.mPaint.setColor(am.getColor(this.DK));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int az(int i) {
        return i == 0 ? R.color.white_alpha100 : R.color.white_alpha70;
    }

    private void lk() {
        int nextInt;
        if (this.DH == null || this.DH.length != this.DC) {
            this.DH = new RectF[this.DC];
        }
        for (int i = 0; i < this.DC; i++) {
            int i2 = this.DJ * i * 2;
            if (this.DE) {
                nextInt = (int) ((1.0d - (this.DI[i % 22] / 10.0d)) * this.DG);
            } else {
                nextInt = this.DG > 0 ? this.random.nextInt(this.DG) : 0;
            }
            int i3 = this.DJ + i2;
            int i4 = this.DG;
            if (this.DH[i] == null) {
                this.DH[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.DH[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.DJ = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(am.getColor(i));
        }
        this.DK = i;
    }

    public void start() {
        this.DD = true;
        this.DE = false;
        li();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.DA = i;
        }
    }

    public void ll() {
        this.DD = true;
        this.DE = true;
        li();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.fZ().removeCallbacks(this.DL);
    }
}
