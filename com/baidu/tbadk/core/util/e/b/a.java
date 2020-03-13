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
    private RectF WF;
    private LinearGradient aBP;
    private Paint auK;
    private Paint mShadowPaint;
    private int ddh = 4369;
    private int dcK = 1;
    private int ddf = 0;
    private int dde = com.baidu.tbadk.core.util.e.c.a.cG("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.e.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] ddg = new int[1];

    private a() {
        this.ddg[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dde);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.auK = new Paint();
        this.auK.setAntiAlias(true);
    }

    public static a aHl() {
        return new a();
    }

    public a kK(int i) {
        this.dcK = i;
        return this;
    }

    public a kL(int i) {
        this.ddh = i;
        return this;
    }

    public a kM(int i) {
        this.ddf = i;
        return this;
    }

    public a kN(@ColorRes int i) {
        this.dde = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dde);
        return this;
    }

    public a kO(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dde);
        return this;
    }

    public a kP(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dde);
        return this;
    }

    public a kQ(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dde);
        return this;
    }

    public a g(int i, float f) {
        this.dde = com.baidu.tbadk.core.util.e.c.a.h(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dde);
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
        this.ddg[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.dcK == 1) {
            this.WF = new RectF(((this.ddh & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.ddf) + rect.left, ((this.ddh & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.ddf) + rect.top, rect.right - ((this.ddh & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.ddf), rect.bottom - ((this.ddh & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.ddf));
        } else {
            this.WF = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.ddg != null && this.ddg.length > 1) {
            this.aBP = new LinearGradient(this.WF.left, this.WF.height() / 2.0f, this.WF.right, this.WF.height() / 2.0f, this.ddg, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.ddg != null) {
            if (this.ddg.length == 1 || this.aBP == null) {
                this.auK.setColor(this.ddg[0]);
            } else if (this.aBP != null) {
                this.auK.setShader(this.aBP);
            }
        }
        if (this.dcK == 1) {
            canvas.drawRoundRect(this.WF, this.ddf, this.ddf, this.mShadowPaint);
            canvas.drawRoundRect(this.WF, this.ddf, this.ddf, this.auK);
            return;
        }
        canvas.drawCircle(this.WF.centerX(), this.WF.centerY(), Math.min(this.WF.width(), this.WF.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.WF.centerX(), this.WF.centerY(), Math.min(this.WF.width(), this.WF.height()) / 2.0f, this.auK);
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
