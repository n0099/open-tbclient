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
/* loaded from: classes7.dex */
public class RecordingAnimView extends View {
    private int adn;
    private int ado;
    private boolean adp;
    private boolean adq;
    private int adr;
    private int ads;
    private RectF[] adt;
    private int[] adu;
    private int adv;
    private int adw;
    private final Runnable adx;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public RecordingAnimView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.adn = 0;
        this.ado = 8;
        this.adp = false;
        this.adq = true;
        this.adu = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.adv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.adx = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.rZ();
            }
        };
        sa();
        rZ();
    }

    public RecordingAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.adn = 0;
        this.ado = 8;
        this.adp = false;
        this.adq = true;
        this.adu = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.adv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds4);
        this.adx = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.RecordingAnimView.1
            @Override // java.lang.Runnable
            public void run() {
                RecordingAnimView.this.rZ();
            }
        };
        sa();
        rZ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rZ() {
        if (this.adp) {
            invalidate();
        }
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.adx);
        if (!this.adq) {
            com.baidu.adp.lib.f.e.mB().postDelayed(this.adx, 250L);
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onMeasure(int i, int i2) {
        if (this.adn > 0) {
            int mode = View.MeasureSpec.getMode(i);
            this.adr = this.adv * ((this.adn * 2) - 1);
            this.ado = this.adn;
            i = View.MeasureSpec.makeMeasureSpec(this.adr, mode);
        }
        super.onMeasure(i, i2);
        this.ads = getMeasuredHeight();
        this.adr = getMeasuredWidth();
        if (this.adn <= 0) {
            this.ado = (this.adr / this.adv) / 2;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.adp) {
            for (int i = 0; i < this.ado; i++) {
                sb();
                if (i < this.adt.length) {
                    canvas.drawRoundRect(this.adt[i], 10.0f, 10.0f, this.mPaint);
                }
            }
        }
    }

    private void sa() {
        this.adw = bm(TbadkCoreApplication.getInst().getSkinType());
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(ao.getColor(this.adw));
    }

    public void onChangeSkinType(int i) {
        if (i != this.mSkinType && this.mPaint != null) {
            this.adw = bm(i);
            this.mPaint.setColor(ao.getColor(i, this.adw));
            invalidate();
            this.mSkinType = i;
        }
    }

    public int bm(int i) {
        return i == 0 ? R.color.white_alpha100 : R.color.white_alpha70;
    }

    private void sb() {
        int nextInt;
        if (this.adt == null || this.adt.length != this.ado) {
            this.adt = new RectF[this.ado];
        }
        for (int i = 0; i < this.ado; i++) {
            int i2 = this.adv * i * 2;
            if (this.adq) {
                nextInt = (int) ((1.0d - (this.adu[i % 22] / 10.0d)) * this.ads);
            } else {
                nextInt = this.ads > 0 ? this.random.nextInt(this.ads) : 0;
            }
            int i3 = this.adv + i2;
            int i4 = this.ads;
            if (this.adt[i] == null) {
                this.adt[i] = new RectF(i2, nextInt, i3, i4);
            } else {
                this.adt[i].set(i2, nextInt, i3, i4);
            }
        }
    }

    public void setColumnWidth(int i) {
        if (i > 0) {
            this.adv = i;
        }
    }

    public void setColumnColor(int i) {
        if (this.mPaint != null) {
            this.mPaint.setColor(ao.getColor(i));
        }
        this.adw = i;
    }

    public void start() {
        this.adp = true;
        this.adq = false;
        rZ();
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.adn = i;
        }
    }

    public void sc() {
        this.adp = true;
        this.adq = true;
        rZ();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.baidu.adp.lib.f.e.mB().removeCallbacks(this.adx);
    }
}
