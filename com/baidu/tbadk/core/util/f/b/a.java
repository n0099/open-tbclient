package com.baidu.tbadk.core.util.f.b;

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
import android.view.View;
import androidx.annotation.ColorRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
/* loaded from: classes.dex */
public class a extends Drawable {
    private LinearGradient bMw;
    private Paint bjg;
    private RectF mRect;
    private Paint mShadowPaint;
    private int eXO = 4369;
    private int eXE = 1;
    private int ffG = 0;
    private int dyL = com.baidu.tbadk.core.util.f.c.a.rT("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.f.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] eXH = new int[1];

    private a() {
        this.eXH[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dyL);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.bjg = new Paint();
        this.bjg.setAntiAlias(true);
    }

    public static a btI() {
        return new a();
    }

    public a pa(int i) {
        this.eXE = i;
        return this;
    }

    public a pb(int i) {
        this.eXO = i;
        return this;
    }

    public a pc(int i) {
        this.ffG = i;
        return this;
    }

    public a pd(@ColorRes int i) {
        this.dyL = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dyL);
        return this;
    }

    public a pe(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dyL);
        return this;
    }

    public a pf(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dyL);
        return this;
    }

    public a pg(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dyL);
        return this;
    }

    public a e(int i, float f) {
        this.dyL = com.baidu.tbadk.core.util.f.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dyL);
        return this;
    }

    public a x(int i, int i2, int i3, int i4) {
        this.dyL = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dyL);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        e(i, f);
        return this;
    }

    public a ph(@ColorRes int i) {
        this.eXH[0] = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.eXE == 1) {
            this.mRect = new RectF(((this.eXO & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.ffG) + rect.left, ((this.eXO & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.ffG) + rect.top, rect.right - ((this.eXO & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.ffG), rect.bottom - ((this.eXO & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.ffG));
        } else {
            this.mRect = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.eXH != null && this.eXH.length > 1) {
            this.bMw = new LinearGradient(this.mRect.left, this.mRect.height() / 2.0f, this.mRect.right, this.mRect.height() / 2.0f, this.eXH, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.eXH != null) {
            if (this.eXH.length == 1 || this.bMw == null) {
                this.bjg.setColor(this.eXH[0]);
            } else if (this.bMw != null) {
                this.bjg.setShader(this.bMw);
            }
        }
        if (this.eXE == 1) {
            canvas.drawRoundRect(this.mRect, this.ffG, this.ffG, this.mShadowPaint);
            canvas.drawRoundRect(this.mRect, this.ffG, this.ffG, this.bjg);
            return;
        }
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.bjg);
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

    public void bv(View view) {
        if (view != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, this);
        }
    }
}
