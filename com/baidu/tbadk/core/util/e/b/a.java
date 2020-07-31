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
    private Paint aYt;
    private RectF awY;
    private LinearGradient biK;
    private Paint mShadowPaint;
    private int eer = 4369;
    private int edU = 1;
    private int eep = 0;
    private int eeo = com.baidu.tbadk.core.util.e.c.a.dU("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.e.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] eeq = new int[1];

    private a() {
        this.eeq[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.eeo);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.aYt = new Paint();
        this.aYt.setAntiAlias(true);
    }

    public static a bbE() {
        return new a();
    }

    public a mj(int i) {
        this.edU = i;
        return this;
    }

    public a mk(int i) {
        this.eer = i;
        return this;
    }

    public a ml(int i) {
        this.eep = i;
        return this;
    }

    public a mm(@ColorRes int i) {
        this.eeo = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.eeo);
        return this;
    }

    public a mn(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.eeo);
        return this;
    }

    public a mo(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.eeo);
        return this;
    }

    public a mp(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.eeo);
        return this;
    }

    public a e(int i, float f) {
        this.eeo = com.baidu.tbadk.core.util.e.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.eeo);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.mOffsetX = i2;
        this.mOffsetY = i3;
        e(i, f);
        return this;
    }

    public a mq(@ColorRes int i) {
        this.eeq[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.edU == 1) {
            this.awY = new RectF(((this.eer & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.eep) + rect.left, ((this.eer & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.eep) + rect.top, rect.right - ((this.eer & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.eep), rect.bottom - ((this.eer & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.eep));
        } else {
            this.awY = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.eeq != null && this.eeq.length > 1) {
            this.biK = new LinearGradient(this.awY.left, this.awY.height() / 2.0f, this.awY.right, this.awY.height() / 2.0f, this.eeq, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.eeq != null) {
            if (this.eeq.length == 1 || this.biK == null) {
                this.aYt.setColor(this.eeq[0]);
            } else if (this.biK != null) {
                this.aYt.setShader(this.biK);
            }
        }
        if (this.edU == 1) {
            canvas.drawRoundRect(this.awY, this.eep, this.eep, this.mShadowPaint);
            canvas.drawRoundRect(this.awY, this.eep, this.eep, this.aYt);
            return;
        }
        canvas.drawCircle(this.awY.centerX(), this.awY.centerY(), Math.min(this.awY.width(), this.awY.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.awY.centerX(), this.awY.centerY(), Math.min(this.awY.width(), this.awY.height()) / 2.0f, this.aYt);
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

    public void aX(View view) {
        if (view != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, this);
        }
    }
}
