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
    private Paint blN;
    private LinearGradient bxD;
    private RectF mRect;
    private Paint mShadowPaint;
    private int eKU = 4369;
    private int eKy = 1;
    private int eKS = 0;
    private int diF = com.baidu.tbadk.core.util.e.c.a.fv("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.e.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] eKT = new int[1];

    private a() {
        this.eKT[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.diF);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.blN = new Paint();
        this.blN.setAntiAlias(true);
    }

    public static a bpy() {
        return new a();
    }

    public a pi(int i) {
        this.eKy = i;
        return this;
    }

    public a pj(int i) {
        this.eKU = i;
        return this;
    }

    public a pk(int i) {
        this.eKS = i;
        return this;
    }

    public a pl(@ColorRes int i) {
        this.diF = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.diF);
        return this;
    }

    public a pm(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.diF);
        return this;
    }

    public a po(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.diF);
        return this;
    }

    public a pp(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.diF);
        return this;
    }

    public a e(int i, float f) {
        this.diF = com.baidu.tbadk.core.util.e.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.diF);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        e(i, f);
        return this;
    }

    public a pq(@ColorRes int i) {
        this.eKT[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.eKy == 1) {
            this.mRect = new RectF(((this.eKU & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.eKS) + rect.left, ((this.eKU & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.eKS) + rect.top, rect.right - ((this.eKU & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.eKS), rect.bottom - ((this.eKU & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.eKS));
        } else {
            this.mRect = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.eKT != null && this.eKT.length > 1) {
            this.bxD = new LinearGradient(this.mRect.left, this.mRect.height() / 2.0f, this.mRect.right, this.mRect.height() / 2.0f, this.eKT, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.eKT != null) {
            if (this.eKT.length == 1 || this.bxD == null) {
                this.blN.setColor(this.eKT[0]);
            } else if (this.bxD != null) {
                this.blN.setShader(this.bxD);
            }
        }
        if (this.eKy == 1) {
            canvas.drawRoundRect(this.mRect, this.eKS, this.eKS, this.mShadowPaint);
            canvas.drawRoundRect(this.mRect, this.eKS, this.eKS, this.blN);
            return;
        }
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.blN);
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

    public void bg(View view) {
        if (view != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, this);
        }
    }
}
