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
    private RectF aCc;
    private Paint bdM;
    private LinearGradient bos;
    private Paint mShadowPaint;
    private int enV = 4369;
    private int enz = 1;
    private int enT = 0;
    private int cLY = com.baidu.tbadk.core.util.e.c.a.fo("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.e.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] enU = new int[1];

    private a() {
        this.enU[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cLY);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.bdM = new Paint();
        this.bdM.setAntiAlias(true);
    }

    public static a bka() {
        return new a();
    }

    public a on(int i) {
        this.enz = i;
        return this;
    }

    public a oo(int i) {
        this.enV = i;
        return this;
    }

    public a op(int i) {
        this.enT = i;
        return this;
    }

    public a oq(@ColorRes int i) {
        this.cLY = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cLY);
        return this;
    }

    public a or(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cLY);
        return this;
    }

    public a os(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cLY);
        return this;
    }

    public a ot(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cLY);
        return this;
    }

    public a e(int i, float f) {
        this.cLY = com.baidu.tbadk.core.util.e.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cLY);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        e(i, f);
        return this;
    }

    public a ou(@ColorRes int i) {
        this.enU[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.enz == 1) {
            this.aCc = new RectF(((this.enV & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.enT) + rect.left, ((this.enV & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.enT) + rect.top, rect.right - ((this.enV & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.enT), rect.bottom - ((this.enV & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.enT));
        } else {
            this.aCc = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.enU != null && this.enU.length > 1) {
            this.bos = new LinearGradient(this.aCc.left, this.aCc.height() / 2.0f, this.aCc.right, this.aCc.height() / 2.0f, this.enU, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.enU != null) {
            if (this.enU.length == 1 || this.bos == null) {
                this.bdM.setColor(this.enU[0]);
            } else if (this.bos != null) {
                this.bdM.setShader(this.bos);
            }
        }
        if (this.enz == 1) {
            canvas.drawRoundRect(this.aCc, this.enT, this.enT, this.mShadowPaint);
            canvas.drawRoundRect(this.aCc, this.enT, this.enT, this.bdM);
            return;
        }
        canvas.drawCircle(this.aCc.centerX(), this.aCc.centerY(), Math.min(this.aCc.width(), this.aCc.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.aCc.centerX(), this.aCc.centerY(), Math.min(this.aCc.width(), this.aCc.height()) / 2.0f, this.bdM);
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

    public void aZ(View view) {
        if (view != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, this);
        }
    }
}
