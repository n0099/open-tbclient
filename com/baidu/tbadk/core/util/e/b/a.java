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
    private LinearGradient bCd;
    private Paint blw;
    private RectF mRect;
    private Paint mShadowPaint;
    private int eHB = 4369;
    private int eHr = 1;
    private int ePK = 0;
    private int dmQ = com.baidu.tbadk.core.util.e.c.a.sa("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.e.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] eHu = new int[1];

    private a() {
        this.eHu[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dmQ);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.blw = new Paint();
        this.blw.setAntiAlias(true);
    }

    public static a brm() {
        return new a();
    }

    public a pQ(int i) {
        this.eHr = i;
        return this;
    }

    public a pR(int i) {
        this.eHB = i;
        return this;
    }

    public a pS(int i) {
        this.ePK = i;
        return this;
    }

    public a pT(@ColorRes int i) {
        this.dmQ = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dmQ);
        return this;
    }

    public a pU(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dmQ);
        return this;
    }

    public a pV(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dmQ);
        return this;
    }

    public a pW(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dmQ);
        return this;
    }

    public a e(int i, float f) {
        this.dmQ = com.baidu.tbadk.core.util.e.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dmQ);
        return this;
    }

    public a s(int i, int i2, int i3, int i4) {
        this.dmQ = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dmQ);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        e(i, f);
        return this;
    }

    public a pX(@ColorRes int i) {
        this.eHu[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.eHr == 1) {
            this.mRect = new RectF(((this.eHB & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.ePK) + rect.left, ((this.eHB & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.ePK) + rect.top, rect.right - ((this.eHB & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.ePK), rect.bottom - ((this.eHB & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.ePK));
        } else {
            this.mRect = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.eHu != null && this.eHu.length > 1) {
            this.bCd = new LinearGradient(this.mRect.left, this.mRect.height() / 2.0f, this.mRect.right, this.mRect.height() / 2.0f, this.eHu, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.eHu != null) {
            if (this.eHu.length == 1 || this.bCd == null) {
                this.blw.setColor(this.eHu[0]);
            } else if (this.bCd != null) {
                this.blw.setShader(this.bCd);
            }
        }
        if (this.eHr == 1) {
            canvas.drawRoundRect(this.mRect, this.ePK, this.ePK, this.mShadowPaint);
            canvas.drawRoundRect(this.mRect, this.ePK, this.ePK, this.blw);
            return;
        }
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.blw);
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

    public void bn(View view) {
        if (view != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, this);
        }
    }
}
