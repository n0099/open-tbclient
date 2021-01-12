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
    private LinearGradient bHm;
    private Paint bew;
    private RectF mRect;
    private Paint mShadowPaint;
    private int eTZ = 4369;
    private int eTP = 1;
    private int fbR = 0;
    private int dvd = com.baidu.tbadk.core.util.f.c.a.rt("#4d000000");
    private int mShadowRadius = com.baidu.tbadk.core.util.f.c.a.dip2px(12.0f);
    private int cIc = 0;
    private int cId = 0;
    private int[] eTS = new int[1];

    private a() {
        this.eTS[0] = 0;
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setColor(0);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cIc, this.cId, this.dvd);
        this.mShadowPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        this.bew = new Paint();
        this.bew.setAntiAlias(true);
    }

    public static a btl() {
        return new a();
    }

    public a oU(int i) {
        this.eTP = i;
        return this;
    }

    public a oV(int i) {
        this.eTZ = i;
        return this;
    }

    public a oW(int i) {
        this.fbR = i;
        return this;
    }

    public a oX(@ColorRes int i) {
        this.dvd = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cIc, this.cId, this.dvd);
        return this;
    }

    public a oY(int i) {
        this.mShadowRadius = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cIc, this.cId, this.dvd);
        return this;
    }

    public a oZ(int i) {
        this.cIc = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cIc, this.cId, this.dvd);
        return this;
    }

    public a pa(int i) {
        this.cId = i;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cIc, this.cId, this.dvd);
        return this;
    }

    public a e(int i, float f) {
        this.dvd = com.baidu.tbadk.core.util.f.c.a.f(i, f);
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cIc, this.cId, this.dvd);
        return this;
    }

    public a x(int i, int i2, int i3, int i4) {
        this.dvd = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        this.mShadowRadius = i4;
        this.cIc = i2;
        this.cId = i3;
        this.mShadowPaint.setShadowLayer(this.mShadowRadius, this.cIc, this.cId, this.dvd);
        return this;
    }

    public a a(int i, float f, int i2, int i3, int i4) {
        this.mShadowRadius = i4;
        this.cIc = i2;
        this.cId = i3;
        e(i, f);
        return this;
    }

    public a pb(@ColorRes int i) {
        this.eTS[0] = com.baidu.tbadk.core.util.f.c.a.getColor(i);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (this.eTP == 1) {
            this.mRect = new RectF(((this.eTZ & 1) == 1 ? this.mShadowRadius - this.cIc : -this.fbR) + rect.left, ((this.eTZ & 16) == 16 ? this.mShadowRadius - this.cId : -this.fbR) + rect.top, rect.right - ((this.eTZ & 256) == 256 ? this.mShadowRadius + this.cIc : -this.fbR), rect.bottom - ((this.eTZ & 4096) == 4096 ? this.mShadowRadius + this.cId : -this.fbR));
        } else {
            this.mRect = new RectF(this.mShadowRadius + rect.left, this.mShadowRadius + rect.top, rect.right - this.mShadowRadius, rect.bottom - this.mShadowRadius);
        }
        if (this.eTS != null && this.eTS.length > 1) {
            this.bHm = new LinearGradient(this.mRect.left, this.mRect.height() / 2.0f, this.mRect.right, this.mRect.height() / 2.0f, this.eTS, (float[]) null, Shader.TileMode.CLAMP);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        if (this.eTS != null) {
            if (this.eTS.length == 1 || this.bHm == null) {
                this.bew.setColor(this.eTS[0]);
            } else if (this.bHm != null) {
                this.bew.setShader(this.bHm);
            }
        }
        if (this.eTP == 1) {
            canvas.drawRoundRect(this.mRect, this.fbR, this.fbR, this.mShadowPaint);
            canvas.drawRoundRect(this.mRect, this.fbR, this.fbR, this.bew);
            return;
        }
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.mShadowPaint);
        canvas.drawCircle(this.mRect.centerX(), this.mRect.centerY(), Math.min(this.mRect.width(), this.mRect.height()) / 2.0f, this.bew);
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
