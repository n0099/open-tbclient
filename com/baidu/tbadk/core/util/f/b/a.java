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
    private LinearGradient bKW;
    private Paint bhE;
    private RectF mRect;
    private Paint mShadowPaint;
    private int eWp = 4369;
    private int eWf = 1;
    private int feh = 0;
    private int dxk = com.baidu.tbadk.core.util.f.c.a.rM("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.f.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] eWi = new int[1];

    private a() {
        this.eWi[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dxk);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.bhE = new Paint();
        this.bhE.setAntiAlias(true);
    }

    public static a btF() {
        return new a();
    }

    public a oZ(int i) {
        this.eWf = i;
        return this;
    }

    public a pa(int i) {
        this.eWp = i;
        return this;
    }

    public a pb(int i) {
        this.feh = i;
        return this;
    }

    public a pc(@ColorRes int i) {
        this.dxk = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dxk);
        return this;
    }

    public a pd(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dxk);
        return this;
    }

    public a pe(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dxk);
        return this;
    }

    public a pf(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dxk);
        return this;
    }

    public a e(int i, float f) {
        this.dxk = com.baidu.tbadk.core.util.f.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dxk);
        return this;
    }

    public a x(int i, int i2, int i3, int i4) {
        this.dxk = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dxk);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        e(i, f);
        return this;
    }

    public a pg(@ColorRes int i) {
        this.eWi[0] = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.eWf == 1) {
            this.mRect = new RectF(((this.eWp & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.feh) + rect.left, ((this.eWp & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.feh) + rect.top, rect.right - ((this.eWp & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.feh), rect.bottom - ((this.eWp & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.feh));
        } else {
            this.mRect = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.eWi != null && this.eWi.length > 1) {
            this.bKW = new LinearGradient(this.mRect.left, this.mRect.height() / 2.0f, this.mRect.right, this.mRect.height() / 2.0f, this.eWi, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.eWi != null) {
            if (this.eWi.length == 1 || this.bKW == null) {
                this.bhE.setColor(this.eWi[0]);
            } else if (this.bKW != null) {
                this.bhE.setShader(this.bKW);
            }
        }
        if (this.eWf == 1) {
            canvas.drawRoundRect(this.mRect, this.feh, this.feh, this.mShadowPaint);
            canvas.drawRoundRect(this.mRect, this.feh, this.feh, this.bhE);
            return;
        }
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.bhE);
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
