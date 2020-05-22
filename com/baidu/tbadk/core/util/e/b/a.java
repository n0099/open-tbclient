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
    private Paint aUK;
    private RectF atR;
    private LinearGradient bdd;
    private Paint mShadowPaint;
    private int dRf = 4369;
    private int dQI = 1;
    private int dRd = 0;
    private int dRc = com.baidu.tbadk.core.util.e.c.a.dT("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.e.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] dRe = new int[1];

    private a() {
        this.dRe[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dRc);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.aUK = new Paint();
        this.aUK.setAntiAlias(true);
    }

    public static a aVI() {
        return new a();
    }

    public a lw(int i) {
        this.dQI = i;
        return this;
    }

    public a lx(int i) {
        this.dRf = i;
        return this;
    }

    public a ly(int i) {
        this.dRd = i;
        return this;
    }

    public a lz(@ColorRes int i) {
        this.dRc = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dRc);
        return this;
    }

    public a lA(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dRc);
        return this;
    }

    public a lB(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dRc);
        return this;
    }

    public a lC(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dRc);
        return this;
    }

    public a e(int i, float f) {
        this.dRc = com.baidu.tbadk.core.util.e.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dRc);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        e(i, f);
        return this;
    }

    public a lD(@ColorRes int i) {
        this.dRe[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.dQI == 1) {
            this.atR = new RectF(((this.dRf & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.dRd) + rect.left, ((this.dRf & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.dRd) + rect.top, rect.right - ((this.dRf & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.dRd), rect.bottom - ((this.dRf & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.dRd));
        } else {
            this.atR = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.dRe != null && this.dRe.length > 1) {
            this.bdd = new LinearGradient(this.atR.left, this.atR.height() / 2.0f, this.atR.right, this.atR.height() / 2.0f, this.dRe, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.dRe != null) {
            if (this.dRe.length == 1 || this.bdd == null) {
                this.aUK.setColor(this.dRe[0]);
            } else if (this.bdd != null) {
                this.aUK.setShader(this.bdd);
            }
        }
        if (this.dQI == 1) {
            canvas.drawRoundRect(this.atR, this.dRd, this.dRd, this.mShadowPaint);
            canvas.drawRoundRect(this.atR, this.dRd, this.dRd, this.aUK);
            return;
        }
        canvas.drawCircle(this.atR.centerX(), this.atR.centerY(), Math.min(this.atR.width(), this.atR.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.atR.centerX(), this.atR.centerY(), Math.min(this.atR.width(), this.atR.height()) / 2.0f, this.aUK);
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
