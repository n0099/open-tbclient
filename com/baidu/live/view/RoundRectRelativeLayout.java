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
import com.baidu.live.k.a;
/* loaded from: classes6.dex */
public class RoundRectRelativeLayout extends RelativeLayout {
    private float[] asU;
    private boolean asV;
    private boolean asW;
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
        if (this.asU == null) {
            this.asU = new float[8];
        }
        for (int i = 0; i < this.asU.length; i++) {
            this.asU[i] = f;
        }
        postInvalidate();
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        if (this.asU == null) {
            this.asU = new float[8];
        }
        this.asU[0] = f;
        this.asU[1] = f;
        this.asU[2] = f2;
        this.asU[3] = f2;
        this.asU[4] = f3;
        this.asU[5] = f3;
        this.asU[6] = f4;
        this.asU[7] = f4;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mRectF.set(0.0f, 0.0f, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.asW) {
            g(canvas);
        } else {
            h(canvas);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.asV) {
            if (this.asW) {
                i(canvas);
                return;
            } else {
                j(canvas);
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
        this.asU = new float[8];
        this.asV = true;
        this.asW = Build.VERSION.SDK_INT >= 28;
    }

    private void initAttrs(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.sdk_RoundRectRelativeLayout);
            this.asV = obtainStyledAttributes.getBoolean(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_clip_background, true);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius, 0);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_top_left, dimensionPixelOffset);
            int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_top_right, dimensionPixelOffset);
            int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_bottom_left, dimensionPixelOffset);
            int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_bottom_right, dimensionPixelOffset);
            obtainStyledAttributes.recycle();
            this.asU[0] = dimensionPixelOffset2;
            this.asU[1] = dimensionPixelOffset2;
            this.asU[2] = dimensionPixelOffset3;
            this.asU[3] = dimensionPixelOffset3;
            this.asU[4] = dimensionPixelOffset5;
            this.asU[5] = dimensionPixelOffset5;
            this.asU[6] = dimensionPixelOffset4;
            this.asU[7] = dimensionPixelOffset4;
        }
    }

    private Path wF() {
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRectF, this.asU, Path.Direction.CW);
        return this.mPath;
    }

    private void g(Canvas canvas) {
        canvas.save();
        canvas.clipPath(wF());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private void h(Canvas canvas) {
        canvas.saveLayer(this.mRectF, null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(wF(), this.mPaint);
        canvas.restore();
    }

    private void i(Canvas canvas) {
        canvas.save();
        canvas.clipPath(wF());
        super.draw(canvas);
        canvas.restore();
    }

    private void j(Canvas canvas) {
        canvas.saveLayer(this.mRectF, null, 31);
        super.draw(canvas);
        canvas.drawPath(wF(), this.mPaint);
        canvas.restore();
    }
}
