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
    private int Ui;
    private int Uj;
    private boolean Uk;
    private boolean Ul;
    private int Um;
    private int Un;
    private RectF[] Uo;
    private int[] Up;
    private int Uq;
    private int Ur;
    private final Runnable Us;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Ui = 0;
        this.Uj = 8;
        this.Uk = false;
        this.Ul = true;
        this.Up = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Uq = l.g(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.Us = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.qp();
            }
        };
        qq();
        qp();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Ui = 0;
        this.Uj = 8;
        this.Uk = false;
        this.Ul = true;
        this.Up = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Uq = l.g(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.Us = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.qp();
            }
        };
        qq();
        qp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qp() {
        if (this.Uk) {
            invalidate();
        }
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.Us);
        if (!this.Ul) {
            com.baidu.adp.lib.g.e.iK().postDelayed(this.Us, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.Ui > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.Um = this.Uq * ((this.Ui * 2) - 1);
            this.Uj = this.Ui;
            i = View.MeasureSpec.makeMeasureSpec(this.Um, mode);
        }
        super.onMeasure(i, i2);
        this.Un = getMeasuredHeight();
        this.Um = getMeasuredWidth();
        if (this.Ui <= 0) {
            this.Uj = (this.Um / this.Uq) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.Uk) {
            for (int i = 0; i < this.Uj; i++) {
                qr();
                if (i < this.Uo.length) {
                    canvas.drawRoundRect(this.Uo[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void qq() {
        this.Ur = bk(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(am.getColor(this.Ur));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.Ur = bk(i);
            this.mPaint.setColor(am.getColor(this.Ur));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int bk(int i) {
        return i == 0 ? R.color.white_alpha100 : R.color.white_alpha70;
    }

    private void qr() {
        int nextInt;
        if (this.Uo == null || this.Uo.length != this.Uj) {
            this.Uo = new RectF[this.Uj];
        }
        for (int i = 0; i < this.Uj; i++) {
            int i2 = this.Uq * i * 2;
            if (this.Ul) {
                nextInt = (int) ((1.0d - (this.Up[i % 22] / 10.0d)) * this.Un);
            } else {
                nextInt = this.Un > 0 ? this.random.nextInt(this.Un) : 0;
            }
            int i3 = this.Uq + i2;
            int i4 = this.Un;
            if (this.Uo[i] == null) {
                this.Uo[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.Uo[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.Uq = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(am.getColor(i));
        }
        this.Ur = i;
    }

    public void start() {
        this.Uk = true;
        this.Ul = false;
        qp();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Ui = i;
        }
    }

    public void qs() {
        this.Uk = true;
        this.Ul = true;
        qp();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.g.e.iK().removeCallbacks(this.Us);
    }
}
