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
/* loaded from: classes8.dex */
public class RecordingAnimView extends View {
    private int adh;
    private int adi;
    private boolean adj;
    private boolean adk;
    private int adl;
    private int adm;
    private RectF[] adn;
    private int[] ado;
    private int adp;
    private int adq;
    private final Runnable adr;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.adh = 0;
        this.adi = 8;
        this.adj = false;
        this.adk = true;
        this.ado = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.adp = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.adr = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.rW();
            }
        };
        rX();
        rW();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.adh = 0;
        this.adi = 8;
        this.adj = false;
        this.adk = true;
        this.ado = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.adp = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.adr = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.rW();
            }
        };
        rX();
        rW();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rW() {
        if (this.adj) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.adr);
        if (!this.adk) {
            com.baidu.adp.lib.f.e.mA().postDelayed(this.adr, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.adh > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.adl = this.adp * ((this.adh * 2) - 1);
            this.adi = this.adh;
            i = View.MeasureSpec.makeMeasureSpec(this.adl, mode);
        }
        super.onMeasure(i, i2);
        this.adm = getMeasuredHeight();
        this.adl = getMeasuredWidth();
        if (this.adh <= 0) {
            this.adi = (this.adl / this.adp) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.adj) {
            for (int i = 0; i < this.adi; i++) {
                rY();
                if (i < this.adn.length) {
                    canvas.drawRoundRect(this.adn[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void rX() {
        this.adq = bm(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ap.getColor(this.adq));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.adq = bm(i);
            this.mPaint.setColor(ap.getColor(i, this.adq));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int bm(int i) {
        return i == 0 ? R.color.white_alpha100 : R.color.white_alpha70;
    }

    private void rY() {
        int nextInt;
        if (this.adn == null || this.adn.length != this.adi) {
            this.adn = new RectF[this.adi];
        }
        for (int i = 0; i < this.adi; i++) {
            int i2 = this.adp * i * 2;
            if (this.adk) {
                nextInt = (int) ((1.0d - (this.ado[i % 22] / 10.0d)) * this.adm);
            } else {
                nextInt = this.adm > 0 ? this.random.nextInt(this.adm) : 0;
            }
            int i3 = this.adp + i2;
            int i4 = this.adm;
            if (this.adn[i] == null) {
                this.adn[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.adn[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.adp = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ap.getColor(i));
        }
        this.adq = i;
    }

    public void start() {
        this.adj = true;
        this.adk = false;
        rW();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.adh = i;
        }
    }

    public void rZ() {
        this.adj = true;
        this.adk = true;
        rW();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.mA().removeCallbacks(this.adr);
    }
}
