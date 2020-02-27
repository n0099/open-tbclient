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
    private int Gd;
    private int Ge;
    private boolean Gf;
    private boolean Gg;
    private RectF[] Gh;
    private int[] Gi;
    private int Gj;
    private int Gk;
    private final Runnable Gl;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Gd = 0;
        this.Ge = 8;
        this.Gf = false;
        this.Gg = true;
        this.Gi = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Gj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.Gl = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.lP();
            }
        };
        lQ();
        lP();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Gd = 0;
        this.Ge = 8;
        this.Gf = false;
        this.Gg = true;
        this.Gi = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Gj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.Gl = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.lP();
            }
        };
        lQ();
        lP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lP() {
        if (this.Gf) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.Gl);
        if (!this.Gg) {
            com.baidu.adp.lib.f.e.gx().postDelayed(this.Gl, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Gd > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.mCanvasWidth = this.Gj * ((this.Gd * 2) - 1);
            this.Ge = this.Gd;
            i = View.MeasureSpec.makeMeasureSpec(this.mCanvasWidth, mode);
        }
        super.onMeasure(i, i2);
        this.mCanvasHeight = getMeasuredHeight();
        this.mCanvasWidth = getMeasuredWidth();
        if (this.Gd <= 0) {
            this.Ge = (this.mCanvasWidth / this.Gj) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Gf) {
            for (int i = 0; i < this.Ge; i++) {
                lR();
                if (i < this.Gh.length) {
                    canvas.drawRoundRect(this.Gh[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void lQ() {
        this.Gk = aF(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(am.getColor(this.Gk));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.Gk = aF(i);
            this.mPaint.setColor(am.getColor(this.Gk));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int aF(int i) {
        return i == 0 ? R.color.white_alpha100 : R.color.white_alpha70;
    }

    private void lR() {
        int nextInt;
        if (this.Gh == null || this.Gh.length != this.Ge) {
            this.Gh = new RectF[this.Ge];
        }
        for (int i = 0; i < this.Ge; i++) {
            int i2 = this.Gj * i * 2;
            if (this.Gg) {
                nextInt = (int) ((1.0d - (this.Gi[i % 22] / 10.0d)) * this.mCanvasHeight);
            } else {
                nextInt = this.mCanvasHeight > 0 ? this.random.nextInt(this.mCanvasHeight) : 0;
            }
            int i3 = this.Gj + i2;
            int i4 = this.mCanvasHeight;
            if (this.Gh[i] == null) {
                this.Gh[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.Gh[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Gj = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(am.getColor(i));
        }
        this.Gk = i;
    }

    public void start() {
        this.Gf = true;
        this.Gg = false;
        lP();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Gd = i;
        }
    }

    public void lS() {
        this.Gf = true;
        this.Gg = true;
        lP();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.gx().removeCallbacks(this.Gl);
    }
}
