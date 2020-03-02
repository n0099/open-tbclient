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
/* loaded from: classes.dex */
public class a extends Drawable {
    private RectF WF;
    private LinearGradient aBO;
    private Paint auJ;
    private Paint mShadowPaint;
    private int dcU = 4369;
    private int dcx = 1;
    private int dcS = 0;
    private int dcR = com.baidu.tbadk.core.util.f.c.a.cG("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.f.c.a.dip2px(12.0f);
    private int mOffsetX = 0;
    private int mOffsetY = 0;
    private int[] dcT = new int[1];

    private a() {
        this.dcT[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dcR);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.auJ = new Paint();
        this.auJ.setAntiAlias(true);
    }

    public static a aHk() {
        return new a();
    }

    public a kK(int i) {
        this.dcx = i;
        return this;
    }

    public a kL(int i) {
        this.dcU = i;
        return this;
    }

    public a kM(int i) {
        this.dcS = i;
        return this;
    }

    public a kN(@ColorRes int i) {
        this.dcR = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dcR);
        return this;
    }

    public a kO(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dcR);
        return this;
    }

    public a kP(int i) {
        this.mOffsetX = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dcR);
        return this;
    }

    public a kQ(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dcR);
        return this;
    }

    public a g(int i, float f) {
        this.dcR = com.baidu.tbadk.core.util.f.c.a.h(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.mOffsetX, this.mOffsetY, this.dcR);
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
        this.dcT[0] = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.dcx == 1) {
            this.WF = new RectF(((this.dcU & 1) == 1 ? this.mShadowRadius - this.mOffsetX : -this.dcS) + rect.left, ((this.dcU & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.dcS) + rect.top, rect.right - ((this.dcU & 256) == 256 ? this.mShadowRadius + this.mOffsetX : -this.dcS), rect.bottom - ((this.dcU & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.dcS));
        } else {
            this.WF = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.dcT != null && this.dcT.length > 1) {
            this.aBO = new LinearGradient(this.WF.left, this.WF.height() / 2.0f, this.WF.right, this.WF.height() / 2.0f, this.dcT, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.dcT != null) {
            if (this.dcT.length == 1 || this.aBO == null) {
                this.auJ.setColor(this.dcT[0]);
            } else if (this.aBO != null) {
                this.auJ.setShader(this.aBO);
            }
        }
        if (this.dcx == 1) {
            canvas.drawRoundRect(this.WF, this.dcS, this.dcS, this.mShadowPaint);
            canvas.drawRoundRect(this.WF, this.dcS, this.dcS, this.auJ);
            return;
        }
        canvas.drawCircle(this.WF.centerX(), this.WF.centerY(), Math.min(this.WF.width(), this.WF.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.WF.centerX(), this.WF.centerY(), Math.min(this.WF.width(), this.WF.height()) / 2.0f, this.auJ);
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
