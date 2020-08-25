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
/* loaded from: classes2.dex */
public class a extends Drawable {
    private RectF aCa;
    private Paint bdK;
    private LinearGradient bop;
    private Paint mShadowPaint;
    private int enR = 4369;
    private int enu = 1;
    private int enP = 0;
    private int cLU = com.baidu.tbadk.core.util.e.c.a.fn("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.e.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] enQ = new int[1];

    private a() {
        this.enQ[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cLU);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.bdK = new Paint();
        this.bdK.setAntiAlias(true);
    }

    public static a bka() {
        return new a();
    }

    public a on(int i) {
        this.enu = i;
        return this;
    }

    public a oo(int i) {
        this.enR = i;
        return this;
    }

    public a op(int i) {
        this.enP = i;
        return this;
    }

    public a oq(@ColorRes int i) {
        this.cLU = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cLU);
        return this;
    }

    public a or(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cLU);
        return this;
    }

    public a os(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cLU);
        return this;
    }

    public a ot(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cLU);
        return this;
    }

    public a e(int i, float f) {
        this.cLU = com.baidu.tbadk.core.util.e.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cLU);
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
        this.enQ[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.enu == 1) {
            this.aCa = new RectF(((this.enR & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.enP) + rect.left, ((this.enR & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.enP) + rect.top, rect.right - ((this.enR & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.enP), rect.bottom - ((this.enR & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.enP));
        } else {
            this.aCa = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.enQ != null && this.enQ.length > 1) {
            this.bop = new LinearGradient(this.aCa.left, this.aCa.height() / 2.0f, this.aCa.right, this.aCa.height() / 2.0f, this.enQ, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.enQ != null) {
            if (this.enQ.length == 1 || this.bop == null) {
                this.bdK.setColor(this.enQ[0]);
            } else if (this.bop != null) {
                this.bdK.setShader(this.bop);
            }
        }
        if (this.enu == 1) {
            canvas.drawRoundRect(this.aCa, this.enP, this.enP, this.mShadowPaint);
            canvas.drawRoundRect(this.aCa, this.enP, this.enP, this.bdK);
            return;
        }
        canvas.drawCircle(this.aCa.centerX(), this.aCa.centerY(), Math.min(this.aCa.width(), this.aCa.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.aCa.centerX(), this.aCa.centerY(), Math.min(this.aCa.width(), this.aCa.height()) / 2.0f, this.bdK);
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
