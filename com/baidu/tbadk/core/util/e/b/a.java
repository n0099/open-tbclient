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
    private LinearGradient bHl;
    private Paint bhF;
    private RectF mRect;
    private Paint mShadowPaint;
    private int eOL = 4369;
    private int eOB = 1;
    private int eWZ = 0;
    private int dtT = com.baidu.tbadk.core.util.e.c.a.sI("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.e.c.a.dip2px(12.0f);
    private int cHY = 0;
    private int mOffsetY = 0;
    private int[] eOE = new int[1];

    private a() {
        this.eOE[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cHY, this.mOffsetY, this.dtT);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.bhF = new Paint();
        this.bhF.setAntiAlias(true);
    }

    public static a buJ() {
        return new a();
    }

    public a qq(int i) {
        this.eOB = i;
        return this;
    }

    public a qr(int i) {
        this.eOL = i;
        return this;
    }

    public a qs(int i) {
        this.eWZ = i;
        return this;
    }

    public a qt(@ColorRes int i) {
        this.dtT = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cHY, this.mOffsetY, this.dtT);
        return this;
    }

    public a qu(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cHY, this.mOffsetY, this.dtT);
        return this;
    }

    public a qv(int i) {
        this.cHY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cHY, this.mOffsetY, this.dtT);
        return this;
    }

    public a qw(int i) {
        this.mOffsetY = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cHY, this.mOffsetY, this.dtT);
        return this;
    }

    public a e(int i, float f) {
        this.dtT = com.baidu.tbadk.core.util.e.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cHY, this.mOffsetY, this.dtT);
        return this;
    }

    public a w(int i, int i2, int i3, int i4) {
        this.dtT = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        this.mShadowRadius = i4;
        this.cHY = i2;
        this.mOffsetY = i3;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cHY, this.mOffsetY, this.dtT);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.cHY = i2;
        this.mOffsetY = i3;
        e(i, f);
        return this;
    }

    public a qx(@ColorRes int i) {
        this.eOE[0] = com.baidu.tbadk.core.util.e.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.eOB == 1) {
            this.mRect = new RectF(((this.eOL & 1) == 1 ? this.mShadowRadius - this.cHY : -this.eWZ) + rect.left, ((this.eOL & 16) == 16 ? this.mShadowRadius - this.mOffsetY : -this.eWZ) + rect.top, rect.right - ((this.eOL & 256) == 256 ? this.mShadowRadius + this.cHY : -this.eWZ), rect.bottom - ((this.eOL & 4096) == 4096 ? this.mShadowRadius + this.mOffsetY : -this.eWZ));
        } else {
            this.mRect = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.eOE != null && this.eOE.length > 1) {
            this.bHl = new LinearGradient(this.mRect.left, this.mRect.height() / 2.0f, this.mRect.right, this.mRect.height() / 2.0f, this.eOE, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.eOE != null) {
            if (this.eOE.length == 1 || this.bHl == null) {
                this.bhF.setColor(this.eOE[0]);
            } else if (this.bHl != null) {
                this.bhF.setShader(this.bHl);
            }
        }
        if (this.eOB == 1) {
            canvas.drawRoundRect(this.mRect, this.eWZ, this.eWZ, this.mShadowPaint);
            canvas.drawRoundRect(this.mRect, this.eWZ, this.eWZ, this.bhF);
            return;
        }
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.bhF);
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

    public void bq(View view) {
        if (view != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, this);
        }
    }
}
