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
    private Paint aOC;
    private LinearGradient aVP;
    private RectF aoX;
    private Paint mShadowPaint;
    private int dCY = 4369;
    private int dCB = 1;
    private int dCW = 0;
    private int dCV = com.baidu.tbadk.core.util.e.c.a.dA("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.e.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] dCX = new int[1];

    private a() {
        this.dCX[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dCV);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.aOC = new Paint();
        this.aOC.setAntiAlias(true);
    }

    public static a aPE() {
        return new a();
    }

    public a kU(int i) {
        this.dCB = i;
        return this;
    }

    public a kV(int i) {
        this.dCY = i;
        return this;
    }

    public a kW(int i) {
        this.dCW = i;
        return this;
    }

    public a kX(@ColorRes int i) {
        this.dCV = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dCV);
        return this;
    }

    public a kY(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dCV);
        return this;
    }

    public a kZ(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dCV);
        return this;
    }

    public a la(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dCV);
        return this;
    }

    public a e(int i, float f) {
        this.dCV = com.baidu.tbadk.core.util.e.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dCV);
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
        this.dCX[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.dCB == 1) {
            this.aoX = new RectF(((this.dCY & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.dCW) + rect.left, ((this.dCY & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.dCW) + rect.top, rect.right - ((this.dCY & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.dCW), rect.bottom - ((this.dCY & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.dCW));
        } else {
            this.aoX = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.dCX != null && this.dCX.length > 1) {
            this.aVP = new LinearGradient(this.aoX.left, this.aoX.height() / 2.0f, this.aoX.right, this.aoX.height() / 2.0f, this.dCX, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.dCX != null) {
            if (this.dCX.length == 1 || this.aVP == null) {
                this.aOC.setColor(this.dCX[0]);
            } else if (this.aVP != null) {
                this.aOC.setShader(this.aVP);
            }
        }
        if (this.dCB == 1) {
            canvas.drawRoundRect(this.aoX, this.dCW, this.dCW, this.mShadowPaint);
            canvas.drawRoundRect(this.aoX, this.dCW, this.dCW, this.aOC);
            return;
        }
        canvas.drawCircle(this.aoX.centerX(), this.aoX.centerY(), Math.min(this.aoX.width(), this.aoX.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.aoX.centerX(), this.aoX.centerY(), Math.min(this.aoX.width(), this.aoX.height()) / 2.0f, this.aOC);
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
