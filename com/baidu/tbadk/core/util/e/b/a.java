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
    private Paint bgC;
    private LinearGradient brB;
    private RectF mRect;
    private Paint mShadowPaint;
    private int eqm = 4369;
    private int epQ = 1;
    private int eqk = 0;
    private int cNY = com.baidu.tbadk.core.util.e.c.a.fq("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.e.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] eql = new int[1];

    private a() {
        this.eql[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cNY);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.bgC = new Paint();
        this.bgC.setAntiAlias(true);
    }

    public static a bkV() {
        return new a();
    }

    public a oz(int i) {
        this.epQ = i;
        return this;
    }

    public a oA(int i) {
        this.eqm = i;
        return this;
    }

    public a oB(int i) {
        this.eqk = i;
        return this;
    }

    public a oC(@ColorRes int i) {
        this.cNY = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cNY);
        return this;
    }

    public a oD(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cNY);
        return this;
    }

    public a oE(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cNY);
        return this;
    }

    public a oF(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cNY);
        return this;
    }

    public a e(int i, float f) {
        this.cNY = com.baidu.tbadk.core.util.e.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.cNY);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        e(i, f);
        return this;
    }

    public a oG(@ColorRes int i) {
        this.eql[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.epQ == 1) {
            this.mRect = new RectF(((this.eqm & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.eqk) + rect.left, ((this.eqm & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.eqk) + rect.top, rect.right - ((this.eqm & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.eqk), rect.bottom - ((this.eqm & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.eqk));
        } else {
            this.mRect = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.eql != null && this.eql.length > 1) {
            this.brB = new LinearGradient(this.mRect.left, this.mRect.height() / 2.0f, this.mRect.right, this.mRect.height() / 2.0f, this.eql, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.eql != null) {
            if (this.eql.length == 1 || this.brB == null) {
                this.bgC.setColor(this.eql[0]);
            } else if (this.brB != null) {
                this.bgC.setShader(this.brB);
            }
        }
        if (this.epQ == 1) {
            canvas.drawRoundRect(this.mRect, this.eqk, this.eqk, this.mShadowPaint);
            canvas.drawRoundRect(this.mRect, this.eqk, this.eqk, this.bgC);
            return;
        }
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.bgC);
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

    public void bb(View view) {
        if (view != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, this);
        }
    }
}
