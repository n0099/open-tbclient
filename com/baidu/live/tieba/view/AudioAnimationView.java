package com.baidu.live.tieba.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import java.util.Random;
/* loaded from: classes10.dex */
public class AudioAnimationView extends View {
    private int adn;
    private int ado;
    private boolean adp;
    private boolean adq;
    private int adr;
    private int ads;
    private int[] adu;
    private int adv;
    private int adw;
    private final Runnable adx;
    private Rect[] bGL;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.adn = 0;
        this.ado = 8;
        this.adp = false;
        this.adq = true;
        this.adu = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.adv = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.adw = a.c.sdk_cp_link_tip_a;
        this.adx = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.rZ();
            }
        };
        sa();
        rZ();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.adn = 0;
        this.ado = 8;
        this.adp = false;
        this.adq = true;
        this.adu = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.adv = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.d.sdk_ds4);
        this.adw = a.c.sdk_cp_link_tip_a;
        this.adx = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.rZ();
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
        SafeHandler.getInst().removeCallbacks(this.adx);
        if (!this.adq) {
            SafeHandler.getInst().postDelayed(this.adx, 250L);
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
                if (i < this.bGL.length) {
                    canvas.drawRect(this.bGL[i], this.mPaint);
                }
            }
        }
    }

    private void sa() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.adw));
    }

    private void sb() {
        int nextInt;
        if (this.bGL == null || this.bGL.length != this.ado) {
            this.bGL = new Rect[this.ado];
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
            if (this.bGL[i] == null) {
                this.bGL[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.bGL[i].set(i2, nextInt, i3, i4);
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
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.adw = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.adn = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.adx);
    }
}
