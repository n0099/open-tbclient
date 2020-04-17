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
    private Paint aOw;
    private LinearGradient aVK;
    private RectF aoR;
    private Paint mShadowPaint;
    private int dCU = 4369;
    private int dCx = 1;
    private int dCS = 0;
    private int dCR = com.baidu.tbadk.core.util.e.c.a.dA("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.e.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] dCT = new int[1];

    private a() {
        this.dCT[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dCR);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.aOw = new Paint();
        this.aOw.setAntiAlias(true);
    }

    public static a aPH() {
        return new a();
    }

    public a kU(int i) {
        this.dCx = i;
        return this;
    }

    public a kV(int i) {
        this.dCU = i;
        return this;
    }

    public a kW(int i) {
        this.dCS = i;
        return this;
    }

    public a kX(@ColorRes int i) {
        this.dCR = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dCR);
        return this;
    }

    public a kY(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dCR);
        return this;
    }

    public a kZ(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dCR);
        return this;
    }

    public a la(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dCR);
        return this;
    }

    public a e(int i, float f) {
        this.dCR = com.baidu.tbadk.core.util.e.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dCR);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        e(i, f);
        return this;
    }

    public a lb(@ColorRes int i) {
        this.dCT[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.dCx == 1) {
            this.aoR = new RectF(((this.dCU & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.dCS) + rect.left, ((this.dCU & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.dCS) + rect.top, rect.right - ((this.dCU & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.dCS), rect.bottom - ((this.dCU & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.dCS));
        } else {
            this.aoR = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.dCT != null && this.dCT.length > 1) {
            this.aVK = new LinearGradient(this.aoR.left, this.aoR.height() / 2.0f, this.aoR.right, this.aoR.height() / 2.0f, this.dCT, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.dCT != null) {
            if (this.dCT.length == 1 || this.aVK == null) {
                this.aOw.setColor(this.dCT[0]);
            } else if (this.aVK != null) {
                this.aOw.setShader(this.aVK);
            }
        }
        if (this.dCx == 1) {
            canvas.drawRoundRect(this.aoR, this.dCS, this.dCS, this.mShadowPaint);
            canvas.drawRoundRect(this.aoR, this.dCS, this.dCS, this.aOw);
            return;
        }
        canvas.drawCircle(this.aoR.centerX(), this.aoR.centerY(), Math.min(this.aoR.width(), this.aoR.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.aoR.centerX(), this.aoR.centerY(), Math.min(this.aoR.width(), this.aoR.height()) / 2.0f, this.aOw);
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
