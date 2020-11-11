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
    private LinearGradient bDO;
    private Paint bnh;
    private RectF mRect;
    private Paint mShadowPaint;
    private int eQJ = 4369;
    private int eQn = 1;
    private int eQH = 0;
    private int doA = com.baidu.tbadk.core.util.e.c.a.fv("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.e.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] eQI = new int[1];

    private a() {
        this.eQI[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.doA);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.bnh = new Paint();
        this.bnh.setAntiAlias(true);
    }

    public static a brY() {
        return new a();
    }

    public a pt(int i) {
        this.eQn = i;
        return this;
    }

    public a pu(int i) {
        this.eQJ = i;
        return this;
    }

    public a pv(int i) {
        this.eQH = i;
        return this;
    }

    public a pw(@ColorRes int i) {
        this.doA = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.doA);
        return this;
    }

    public a px(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.doA);
        return this;
    }

    public a py(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.doA);
        return this;
    }

    public a pz(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.doA);
        return this;
    }

    public a e(int i, float f) {
        this.doA = com.baidu.tbadk.core.util.e.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.doA);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        e(i, f);
        return this;
    }

    public a pA(@ColorRes int i) {
        this.eQI[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.eQn == 1) {
            this.mRect = new RectF(((this.eQJ & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.eQH) + rect.left, ((this.eQJ & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.eQH) + rect.top, rect.right - ((this.eQJ & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.eQH), rect.bottom - ((this.eQJ & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.eQH));
        } else {
            this.mRect = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.eQI != null && this.eQI.length > 1) {
            this.bDO = new LinearGradient(this.mRect.left, this.mRect.height() / 2.0f, this.mRect.right, this.mRect.height() / 2.0f, this.eQI, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.eQI != null) {
            if (this.eQI.length == 1 || this.bDO == null) {
                this.bnh.setColor(this.eQI[0]);
            } else if (this.bDO != null) {
                this.bnh.setShader(this.bDO);
            }
        }
        if (this.eQn == 1) {
            canvas.drawRoundRect(this.mRect, this.eQH, this.eQH, this.mShadowPaint);
            canvas.drawRoundRect(this.mRect, this.eQH, this.eQH, this.bnh);
            return;
        }
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.bnh);
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

    public void bk(View view) {
        if (view != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, this);
        }
    }
}
