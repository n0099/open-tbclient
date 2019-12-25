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
import android.support.annotation.ColorRes;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.view.View;
import com.baidu.tbadk.core.util.tbselector.shadow.ShadowDrawable;
/* loaded from: classes.dex */
public class a extends Drawable {
    private RectF UG;
    private Paint aqT;
    private LinearGradient awO;
    private Paint mShadowPaint;
    private int cYF = 4369;
    private int cYi = 1;
    private int cYD = 0;
    private int cYC = com.baidu.tbadk.core.util.f.c.a.cy("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.f.c.a.dip2px(12.0f);
    private int bcg = 0;
    private int mOffsetY = 0;
    private int[] cYE = new int[1];

    private a() {
        this.cYE[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bcg, this.mOffsetY, this.cYC);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.aqT = new Paint();
        this.aqT.setAntiAlias(true);
    }

    public static a aED() {
        return new a();
    }

    public a kt(@ShadowDrawable.Shape int i) {
        this.cYi = i;
        return this;
    }

    public a ku(@ShadowDrawable.ShadowSide int i) {
        this.cYF = i;
        return this;
    }

    public a kv(int i) {
        this.cYD = i;
        return this;
    }

    public a kw(@ColorRes int i) {
        this.cYC = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bcg, this.mOffsetY, this.cYC);
        return this;
    }

    public a kx(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bcg, this.mOffsetY, this.cYC);
        return this;
    }

    public a ky(int i) {
        this.bcg = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bcg, this.mOffsetY, this.cYC);
        return this;
    }

    public a kz(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bcg, this.mOffsetY, this.cYC);
        return this;
    }

    public a g(int i, float f) {
        this.cYC = com.baidu.tbadk.core.util.f.c.a.h(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.bcg, this.mOffsetY, this.cYC);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.bcg = i2;
        this.mOffsetY = i3;
        g(i, f);
        return this;
    }

    public a kA(@ColorRes int i) {
        this.cYE[0] = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.cYi == 1) {
            this.UG = new RectF(((this.cYF & 1) == 1 ? this.mShadowRadius - this.bcg : -this.cYD) + rect.left, ((this.cYF & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.cYD) + rect.top, rect.right - ((this.cYF & 256) == 256 ? this.mShadowRadius + this.bcg : -this.cYD), rect.bottom - ((this.cYF & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.cYD));
        } else {
            this.UG = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.cYE != null && this.cYE.length > 1) {
            this.awO = new LinearGradient(this.UG.left, this.UG.height() / 2.0f, this.UG.right, this.UG.height() / 2.0f, this.cYE, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.cYE != null) {
            if (this.cYE.length == 1 || this.awO == null) {
                this.aqT.setColor(this.cYE[0]);
            } else if (this.awO != null) {
                this.aqT.setShader(this.awO);
            }
        }
        if (this.cYi == 1) {
            canvas.drawRoundRect(this.UG, this.cYD, this.cYD, this.mShadowPaint);
            canvas.drawRoundRect(this.UG, this.cYD, this.cYD, this.aqT);
            return;
        }
        canvas.drawCircle(this.UG.centerX(), this.UG.centerY(), Math.min(this.UG.width(), this.UG.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.UG.centerX(), this.UG.centerY(), Math.min(this.UG.width(), this.UG.height()) / 2.0f, this.aqT);
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

    public void aM(View view) {
        if (view != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, this);
        }
    }
}
