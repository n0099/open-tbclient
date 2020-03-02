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
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.u.a;
import java.util.Random;
/* loaded from: classes3.dex */
public class AudioAnimationView extends View {
    private int Gd;
    private int Ge;
    private boolean Gf;
    private boolean Gg;
    private int[] Gi;
    private int Gj;
    private int Gk;
    private final Runnable Gl;
    private Rect[] aBy;
    private int mCanvasHeight;
    private int mCanvasWidth;
    private Paint mPaint;
    private int mSkinType;
    private Random random;

    public AudioAnimationView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.random = new Random();
        this.Gd = 0;
        this.Ge = 8;
        this.Gf = false;
        this.Gg = true;
        this.Gi = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Gj = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.Gk = a.d.sdk_cp_link_tip_a;
        this.Gl = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.lP();
            }
        };
        lQ();
        lP();
    }

    public AudioAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.random = new Random();
        this.Gd = 0;
        this.Ge = 8;
        this.Gf = false;
        this.Gg = true;
        this.Gi = new int[]{6, 3, 5, 10, 8, 6, 5, 3, 5, 10, 8, 6, 5, 3, 6, 3, 5, 10, 8, 6, 5, 3};
        this.Gj = BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), a.e.sdk_ds4);
        this.Gk = a.d.sdk_cp_link_tip_a;
        this.Gl = new Runnable() { // from class: com.baidu.live.tieba.view.AudioAnimationView.1
            @Override // java.lang.Runnable
            public void run() {
                AudioAnimationView.this.lP();
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
        SafeHandler.getInst().removeCallbacks(this.Gl);
        if (!this.Gg) {
            SafeHandler.getInst().postDelayed(this.Gl, 250L);
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
                if (i < this.aBy.length) {
                    canvas.drawRect(this.aBy[i], this.mPaint);
                }
            }
        }
    }

    private void lQ() {
        this.mPaint = new Paint();
        this.mPaint.setDither(true);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(SkinManager.getColor(this.Gk));
    }

    private void lR() {
        int nextInt;
        if (this.aBy == null || this.aBy.length != this.Ge) {
            this.aBy = new Rect[this.Ge];
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
            if (this.aBy[i] == null) {
                this.aBy[i] = new Rect(i2, nextInt, i3, i4);
            } else {
                this.aBy[i].set(i2, nextInt, i3, i4);
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
            this.mPaint.setColor(SkinManager.getColor(i));
        }
        this.Gk = i;
    }

    public void setCertainColumnCount(int i) {
        if (i != 0) {
            this.Gd = i;
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SafeHandler.getInst().removeCallbacks(this.Gl);
    }
}
