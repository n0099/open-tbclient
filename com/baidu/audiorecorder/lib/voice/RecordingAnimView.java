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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.Random;
/* loaded from: classes11.dex */
public class RecordingAnimView extends View {
    private int aam;
    private int aan;
    private boolean aao;
    private boolean aap;
    private RectF[] aaq;
    private int[] aar;
    private int aas;
    private int aat;
    private final Runnable aau;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.aam = 0;
        this.aan = 8;
        this.aao = false;
        this.aap = true;
        this.aar = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aas = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.aau = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.qO();
            }
        };
        qP();
        qO();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.aam = 0;
        this.aan = 8;
        this.aao = false;
        this.aap = true;
        this.aar = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aas = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.aau = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.qO();
            }
        };
        qP();
        qO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qO() {
        if (this.aao) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.aau);
        if (!this.aap) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.aau, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.aam > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.aas * ((this.aam * 2) - 1);
            this.aan = this.aam;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.aam <= 0) {
            this.aan = (this.mCanvasWidth / this.aas) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aao) {
            for (int i = 0; i < this.aan; i++) {
                qQ();
                if (i < this.aaq.length) {
                    canvas.drawRoundRect(this.aaq[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void qP() {
        this.aat = aY(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(an.getColor(this.aat));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.aat = aY(i);
            this.mPaint.setColor(an.getColor(this.aat));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int aY(int i) {
        return i == 0 ? R.color.white_alpha100 : R.color.white_alpha70;
    }

    private void qQ() {
        int nextInt;
        if (this.aaq == null || this.aaq.length != this.aan) {
            this.aaq = new RectF[this.aan];
        }
        for (int i = 0; i < this.aan; i++) {
            int i2 = this.aas * i * 2;
            if (this.aap) {
                nextInt = (int) ((1.0d - (this.aar[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.aas + i2;
            int i4 = this.mCanvasHeight;
            if (this.aaq[i] == null) {
                this.aaq[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.aaq[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.aas = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(an.getColor(i));
        }
        this.aat = i;
    }

    public void start() {
        this.aao = true;
        this.aap = false;
        qO();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.aam = i;
        }
    }

    public void qR() {
        this.aao = true;
        this.aap = true;
        qO();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.aau);
    }
}
