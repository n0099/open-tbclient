package com.baidu.tbadk.core.util.e.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.View;
/* loaded from: classes.dex */
public class a extends Drawable {
    private Paint aXr;
    private RectF avT;
    private LinearGradient biq;
    private Paint mShadowPaint;
    private int dXX = 4369;
    private int dXA = 1;
    private int dXV = 0;
    private int dXU = com.baidu.tbadk.core.util.e.c.a.dV("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.e.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] dXW = new int[1];

    private a() {
        this.dXW[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dXU);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.aXr = new Paint();
        this.aXr.setAntiAlias(true);
    }

    public static a aXD() {
        return new a();
    }

    public a lP(int i) {
        this.dXA = i;
        return this;
    }

    public a lQ(int i) {
        this.dXX = i;
        return this;
    }

    public a lR(int i) {
        this.dXV = i;
        return this;
    }

    public a lS(@ColorRes int i) {
        this.dXU = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dXU);
        return this;
    }

    public a lT(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dXU);
        return this;
    }

    public a lU(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dXU);
        return this;
    }

    public a lV(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dXU);
        return this;
    }

    public a e(int i, float f) {
        this.dXU = com.baidu.tbadk.core.util.e.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dXU);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        e(i, f);
        return this;
    }

    public a lW(@ColorRes int i) {
        this.dXW[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.dXA == 1) {
            this.avT = new RectF(((this.dXX & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.dXV) + rect.left, ((this.dXX & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.dXV) + rect.top, rect.right - ((this.dXX & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.dXV), rect.bottom - ((this.dXX & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.dXV));
        } else {
            this.avT = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.dXW != null && this.dXW.length > 1) {
            this.biq = new LinearGradient(this.avT.left, this.avT.height() / 2.0f, this.avT.right, this.avT.height() / 2.0f, this.dXW, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.dXW != null) {
            if (this.dXW.length == 1 || this.biq == null) {
                this.aXr.setColor(this.dXW[0]);
            } else if (this.biq != null) {
                this.aXr.setShader(this.biq);
            }
        }
        if (this.dXA == 1) {
            canvas.drawRoundRect(this.avT, this.dXV, this.dXV, this.mShadowPaint);
            canvas.drawRoundRect(this.avT, this.dXV, this.dXV, this.aXr);
            return;
        }
        canvas.drawCircle(this.avT.centerX(), this.avT.centerY(), Math.min(this.avT.width(), this.avT.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.avT.centerX(), this.avT.centerY(), Math.min(this.avT.width(), this.avT.height()) / 2.0f, this.aXr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        this.mShadowPaint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mShadowPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void aR(View view) {
        if (view != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, this);
        }
    }
}
