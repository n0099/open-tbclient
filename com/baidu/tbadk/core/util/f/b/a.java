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
    private LinearGradient bLY;
    private Paint bjn;
    private RectF mRect;
    private Paint mShadowPaint;
    private int eYK = 4369;
    private int eYA = 1;
    private int fgA = 0;
    private int dzP = com.baidu.tbadk.core.util.f.c.a.sF("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.f.c.a.dip2px(12.0f);
    private int cMO = 0;
    private int cMP = 0;
    private int[] eYD = new int[1];

    private a() {
        this.eYD[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cMO, this.cMP, this.dzP);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.bjn = new Paint();
        this.bjn.setAntiAlias(true);
    }

    public static a bxe() {
        return new a();
    }

    public a qB(int i) {
        this.eYA = i;
        return this;
    }

    public a qC(int i) {
        this.eYK = i;
        return this;
    }

    public a qD(int i) {
        this.fgA = i;
        return this;
    }

    public a qE(@ColorRes int i) {
        this.dzP = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cMO, this.cMP, this.dzP);
        return this;
    }

    public a qF(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cMO, this.cMP, this.dzP);
        return this;
    }

    public a qG(int i) {
        this.cMO = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cMO, this.cMP, this.dzP);
        return this;
    }

    public a qH(int i) {
        this.cMP = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cMO, this.cMP, this.dzP);
        return this;
    }

    public a e(int i, float f) {
        this.dzP = com.baidu.tbadk.core.util.f.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cMO, this.cMP, this.dzP);
        return this;
    }

    public a x(int i, int i2, int i3, int i4) {
        this.dzP = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.mShadowRadius = i4;
        this.cMO = i2;
        this.cMP = i3;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cMO, this.cMP, this.dzP);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.cMO = i2;
        this.cMP = i3;
        e(i, f);
        return this;
    }

    public a qI(@ColorRes int i) {
        this.eYD[0] = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.eYA == 1) {
            this.mRect = new RectF(((this.eYK & 1) == 1 ? this.mShadowRadius - this.cMO : -this.fgA) + rect.left, ((this.eYK & 16) == 16 ? this.mShadowRadius - this.cMP : -this.fgA) + rect.top, rect.right - ((this.eYK & 256) == 256 ? this.mShadowRadius + this.cMO : -this.fgA), rect.bottom - ((this.eYK & 4096) == 4096 ? this.mShadowRadius + this.cMP : -this.fgA));
        } else {
            this.mRect = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.eYD != null && this.eYD.length > 1) {
            this.bLY = new LinearGradient(this.mRect.left, this.mRect.height() / 2.0f, this.mRect.right, this.mRect.height() / 2.0f, this.eYD, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.eYD != null) {
            if (this.eYD.length == 1 || this.bLY == null) {
                this.bjn.setColor(this.eYD[0]);
            } else if (this.bLY != null) {
                this.bjn.setShader(this.bLY);
            }
        }
        if (this.eYA == 1) {
            canvas.drawRoundRect(this.mRect, this.fgA, this.fgA, this.mShadowPaint);
            canvas.drawRoundRect(this.mRect, this.fgA, this.fgA, this.bjn);
            return;
        }
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.bjn);
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

    public void bz(View view) {
        if (view != null) {
            view.setLayerType(1, null);
            ViewCompat.setBackground(view, this);
        }
    }
}
