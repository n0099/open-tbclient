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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.Random;
/* loaded from: classes24.dex */
public class RecordingAnimView extends View {
    private boolean abA;
    private boolean abB;
    private RectF[] abC;
    private int[] abD;
    private int abE;
    private int abF;
    private final Runnable abG;
    private int aby;
    private int abz;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.aby = 0;
        this.abz = 8;
        this.abA = false;
        this.abB = true;
        this.abD = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.abG = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.sv();
            }
        };
        sw();
        sv();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.aby = 0;
        this.abz = 8;
        this.abA = false;
        this.abB = true;
        this.abD = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.abE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.abG = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.sv();
            }
        };
        sw();
        sv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sv() {
        if (this.abA) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.abG);
        if (!this.abB) {
            com.baidu.adp.lib.f.e.mY().postDelayed(this.abG, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.aby > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.abE * ((this.aby * 2) - 1);
            this.abz = this.aby;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.aby <= 0) {
            this.abz = (this.mCanvasWidth / this.abE) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.abA) {
            for (int i = 0; i < this.abz; i++) {
                sx();
                if (i < this.abC.length) {
                    canvas.drawRoundRect(this.abC[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void sw() {
        this.abF = bi(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ap.getColor(this.abF));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.abF = bi(i);
            this.mPaint.setColor(ap.getColor(i, this.abF));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int bi(int i) {
        return i == 0 ? R.color.white_alpha100 : R.color.white_alpha70;
    }

    private void sx() {
        int nextInt;
        if (this.abC == null || this.abC.length != this.abz) {
            this.abC = new RectF[this.abz];
        }
        for (int i = 0; i < this.abz; i++) {
            int i2 = this.abE * i * 2;
            if (this.abB) {
                nextInt = (int) ((1.0d - (this.abD[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.abE + i2;
            int i4 = this.mCanvasHeight;
            if (this.abC[i] == null) {
                this.abC[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.abC[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.abE = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ap.getColor(i));
        }
        this.abF = i;
    }

    public void start() {
        this.abA = true;
        this.abB = false;
        sv();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.aby = i;
        }
    }

    public void sy() {
        this.abA = true;
        this.abB = true;
        sv();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.mY().removeCallbacks(this.abG);
    }
}
