package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.baidu.live.r.a;
/* loaded from: classes2.dex */
public class RoundRectRelativeLayout extends RelativeLayout {
    private float[] aBc;
    private boolean aBd;
    private boolean aBe;
    private Paint mPaint;
    private Path mPath;
    private RectF mRectF;

    public RoundRectRelativeLayout(@NonNull Context context) {
        this(context, null);
    }

    public RoundRectRelativeLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet);
    }

    public void setCornerRadius(float f) {
        if (this.aBc == null) {
            this.aBc = new float[8];
        }
        for (int i = 0; i < this.aBc.length; i++) {
            this.aBc[i] = f;
        }
        postInvalidate();
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        if (this.aBc == null) {
            this.aBc = new float[8];
        }
        this.aBc[0] = f;
        this.aBc[1] = f;
        this.aBc[2] = f2;
        this.aBc[3] = f2;
        this.aBc[4] = f3;
        this.aBc[5] = f3;
        this.aBc[6] = f4;
        this.aBc[7] = f4;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mRectF.set(0.0f, 0.0f, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.aBe) {
            h(canvas);
        } else {
            i(canvas);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.aBd) {
            if (this.aBe) {
                j(canvas);
                return;
            } else {
                k(canvas);
                return;
            }
        }
        super.draw(canvas);
    }

    private void init(AttributeSet attributeSet) {
        initFields();
        initAttrs(attributeSet);
    }

    private void initFields() {
        this.mPaint = new Paint(1);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.mPath = new Path();
        this.mRectF = new RectF();
        this.aBc = new float[8];
        this.aBd = true;
        this.aBe = Build.VERSION.SDK_INT >= 28;
    }

    private void initAttrs(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.sdk_RoundRectRelativeLayout);
            this.aBd = obtainStyledAttributes.getBoolean(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_clip_background, true);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius, 0);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_top_left, dimensionPixelOffset);
            int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_top_right, dimensionPixelOffset);
            int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_bottom_left, dimensionPixelOffset);
            int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_bottom_right, dimensionPixelOffset);
            obtainStyledAttributes.recycle();
            this.aBc[0] = dimensionPixelOffset2;
            this.aBc[1] = dimensionPixelOffset2;
            this.aBc[2] = dimensionPixelOffset3;
            this.aBc[3] = dimensionPixelOffset3;
            this.aBc[4] = dimensionPixelOffset5;
            this.aBc[5] = dimensionPixelOffset5;
            this.aBc[6] = dimensionPixelOffset4;
            this.aBc[7] = dimensionPixelOffset4;
        }
    }

    private Path yZ() {
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRectF, this.aBc, Path.Direction.CW);
        return this.mPath;
    }

    private void h(Canvas canvas) {
        canvas.save();
        canvas.clipPath(yZ());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private void i(Canvas canvas) {
        canvas.saveLayer(this.mRectF, null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(yZ(), this.mPaint);
        canvas.restore();
    }

    private void j(Canvas canvas) {
        canvas.save();
        canvas.clipPath(yZ());
        super.draw(canvas);
        canvas.restore();
    }

    private void k(Canvas canvas) {
        canvas.saveLayer(this.mRectF, null, 31);
        super.draw(canvas);
        canvas.drawPath(yZ(), this.mPaint);
        canvas.restore();
    }
}
