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
    private Paint bks;
    private LinearGradient bvp;
    private RectF mRect;
    private Paint mShadowPaint;
    private int eCy = 4369;
    private int eCc = 1;
    private int eCw = 0;
    private int dab = com.baidu.tbadk.core.util.e.c.a.fv("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.e.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] eCx = new int[1];

    private a() {
        this.eCx[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dab);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.bks = new Paint();
        this.bks.setAntiAlias(true);
    }

    public static a bnF() {
        return new a();
    }

    public a oX(int i) {
        this.eCc = i;
        return this;
    }

    public a oY(int i) {
        this.eCy = i;
        return this;
    }

    public a oZ(int i) {
        this.eCw = i;
        return this;
    }

    public a pa(@ColorRes int i) {
        this.dab = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dab);
        return this;
    }

    public a pb(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dab);
        return this;
    }

    public a pc(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dab);
        return this;
    }

    public a pd(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dab);
        return this;
    }

    public a e(int i, float f) {
        this.dab = com.baidu.tbadk.core.util.e.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dab);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        e(i, f);
        return this;
    }

    public a pe(@ColorRes int i) {
        this.eCx[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.eCc == 1) {
            this.mRect = new RectF(((this.eCy & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.eCw) + rect.left, ((this.eCy & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.eCw) + rect.top, rect.right - ((this.eCy & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.eCw), rect.bottom - ((this.eCy & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.eCw));
        } else {
            this.mRect = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.eCx != null && this.eCx.length > 1) {
            this.bvp = new LinearGradient(this.mRect.left, this.mRect.height() / 2.0f, this.mRect.right, this.mRect.height() / 2.0f, this.eCx, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.eCx != null) {
            if (this.eCx.length == 1 || this.bvp == null) {
                this.bks.setColor(this.eCx[0]);
            } else if (this.bvp != null) {
                this.bks.setShader(this.bvp);
            }
        }
        if (this.eCc == 1) {
            canvas.drawRoundRect(this.mRect, this.eCw, this.eCw, this.mShadowPaint);
            canvas.drawRoundRect(this.mRect, this.eCw, this.eCw, this.bks);
            return;
        }
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.bks);
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

    public void bf(View view) {
        if (view != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, this);
        }
    }
}
