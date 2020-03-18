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
    private RectF WP;
    private LinearGradient aCd;
    private Paint auU;
    private Paint mShadowPaint;
    private int ddv = 4369;
    private int dcX = 1;
    private int dds = 0;
    private int ddr = com.baidu.tbadk.core.util.e.c.a.cF("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.e.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] ddt = new int[1];

    private a() {
        this.ddt[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.ddr);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.auU = new Paint();
        this.auU.setAntiAlias(true);
    }

    public static a aHp() {
        return new a();
    }

    public a kK(int i) {
        this.dcX = i;
        return this;
    }

    public a kL(int i) {
        this.ddv = i;
        return this;
    }

    public a kM(int i) {
        this.dds = i;
        return this;
    }

    public a kN(@ColorRes int i) {
        this.ddr = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.ddr);
        return this;
    }

    public a kO(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.ddr);
        return this;
    }

    public a kP(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.ddr);
        return this;
    }

    public a kQ(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.ddr);
        return this;
    }

    public a g(int i, float f) {
        this.ddr = com.baidu.tbadk.core.util.e.c.a.h(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.ddr);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        g(i, f);
        return this;
    }

    public a kR(@ColorRes int i) {
        this.ddt[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.dcX == 1) {
            this.WP = new RectF(((this.ddv & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.dds) + rect.left, ((this.ddv & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.dds) + rect.top, rect.right - ((this.ddv & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.dds), rect.bottom - ((this.ddv & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.dds));
        } else {
            this.WP = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.ddt != null && this.ddt.length > 1) {
            this.aCd = new LinearGradient(this.WP.left, this.WP.height() / 2.0f, this.WP.right, this.WP.height() / 2.0f, this.ddt, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.ddt != null) {
            if (this.ddt.length == 1 || this.aCd == null) {
                this.auU.setColor(this.ddt[0]);
            } else if (this.aCd != null) {
                this.auU.setShader(this.aCd);
            }
        }
        if (this.dcX == 1) {
            canvas.drawRoundRect(this.WP, this.dds, this.dds, this.mShadowPaint);
            canvas.drawRoundRect(this.WP, this.dds, this.dds, this.auU);
            return;
        }
        canvas.drawCircle(this.WP.centerX(), this.WP.centerY(), Math.min(this.WP.width(), this.WP.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.WP.centerX(), this.WP.centerY(), Math.min(this.WP.width(), this.WP.height()) / 2.0f, this.auU);
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
