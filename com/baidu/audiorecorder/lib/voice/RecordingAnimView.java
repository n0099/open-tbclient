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
/* loaded from: classes18.dex */
public class RecordingAnimView extends View {
    private int aah;
    private int aai;
    private boolean aaj;
    private boolean aak;
    private RectF[] aal;
    private int[] aam;
    private int aan;
    private int aao;
    private final Runnable aap;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.aah = 0;
        this.aai = 8;
        this.aaj = false;
        this.aak = true;
        this.aam = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aan = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.aap = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.qR();
            }
        };
        qS();
        qR();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.aah = 0;
        this.aai = 8;
        this.aaj = false;
        this.aak = true;
        this.aam = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.aan = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.aap = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.qR();
            }
        };
        qS();
        qR();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qR() {
        if (this.aaj) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.aap);
        if (!this.aak) {
            com.baidu.adp.lib.f.e.lt().postDelayed(this.aap, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.aah > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.aan * ((this.aah * 2) - 1);
            this.aai = this.aah;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.aah <= 0) {
            this.aai = (this.mCanvasWidth / this.aan) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.aaj) {
            for (int i = 0; i < this.aai; i++) {
                qT();
                if (i < this.aal.length) {
                    canvas.drawRoundRect(this.aal[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void qS() {
        this.aao = bb(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ao.getColor(this.aao));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.aao = bb(i);
            this.mPaint.setColor(ao.getColor(this.aao));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int bb(int i) {
        return i == 0 ? R.color.white_alpha100 : R.color.white_alpha70;
    }

    private void qT() {
        int nextInt;
        if (this.aal == null || this.aal.length != this.aai) {
            this.aal = new RectF[this.aai];
        }
        for (int i = 0; i < this.aai; i++) {
            int i2 = this.aan * i * 2;
            if (this.aak) {
                nextInt = (int) ((1.0d - (this.aam[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.aan + i2;
            int i4 = this.mCanvasHeight;
            if (this.aal[i] == null) {
                this.aal[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.aal[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.aan = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ao.getColor(i));
        }
        this.aao = i;
    }

    public void start() {
        this.aaj = true;
        this.aak = false;
        qR();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.aah = i;
        }
    }

    public void qU() {
        this.aaj = true;
        this.aak = true;
        qR();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.lt().removeCallbacks(this.aap);
    }
}
