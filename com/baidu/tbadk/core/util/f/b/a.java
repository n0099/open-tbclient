package com.baidu.tbadk.core.util.f.b;

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
    private RectF UY;
    private Paint arF;
    private LinearGradient axx;
    private Paint mShadowPaint;
    private int cYP = 4369;
    private int cYs = 1;
    private int cYN = 0;
    private int cYM = com.baidu.tbadk.core.util.f.c.a.cy("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.f.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] cYO = new int[1];

    private a() {
        this.cYO[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cYM);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.arF = new Paint();
        this.arF.setAntiAlias(true);
    }

    public static a aEW() {
        return new a();
    }

    public a kt(int i) {
        this.cYs = i;
        return this;
    }

    public a ku(int i) {
        this.cYP = i;
        return this;
    }

    public a kv(int i) {
        this.cYN = i;
        return this;
    }

    public a kw(@ColorRes int i) {
        this.cYM = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cYM);
        return this;
    }

    public a kx(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cYM);
        return this;
    }

    public a ky(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cYM);
        return this;
    }

    public a kz(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cYM);
        return this;
    }

    public a g(int i, float f) {
        this.cYM = com.baidu.tbadk.core.util.f.c.a.h(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cYM);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        g(i, f);
        return this;
    }

    public a kA(@ColorRes int i) {
        this.cYO[0] = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.cYs == 1) {
            this.UY = new RectF(((this.cYP & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.cYN) + rect.left, ((this.cYP & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.cYN) + rect.top, rect.right - ((this.cYP & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.cYN), rect.bottom - ((this.cYP & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.cYN));
        } else {
            this.UY = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.cYO != null && this.cYO.length > 1) {
            this.axx = new LinearGradient(this.UY.left, this.UY.height() / 2.0f, this.UY.right, this.UY.height() / 2.0f, this.cYO, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.cYO != null) {
            if (this.cYO.length == 1 || this.axx == null) {
                this.arF.setColor(this.cYO[0]);
            } else if (this.axx != null) {
                this.arF.setShader(this.axx);
            }
        }
        if (this.cYs == 1) {
            canvas.drawRoundRect(this.UY, this.cYN, this.cYN, this.mShadowPaint);
            canvas.drawRoundRect(this.UY, this.cYN, this.cYN, this.arF);
            return;
        }
        canvas.drawCircle(this.UY.centerX(), this.UY.centerY(), Math.min(this.UY.width(), this.UY.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.UY.centerX(), this.UY.centerY(), Math.min(this.UY.width(), this.UY.height()) / 2.0f, this.arF);
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

    public void aQ(View view) {
        if (view != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, this);
        }
    }
}
