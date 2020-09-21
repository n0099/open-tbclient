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
import com.baidu.live.sdk.a;
import java.util.Arrays;
/* loaded from: classes4.dex */
public class RoundRectRelativeLayout extends RelativeLayout {
    private boolean bwJ;
    private boolean bwK;
    private float[] bxA;
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
        if (this.bxA == null) {
            this.bxA = new float[8];
        }
        Arrays.fill(this.bxA, f);
        postInvalidate();
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        if (this.bxA == null) {
            this.bxA = new float[8];
        }
        this.bxA[0] = f;
        this.bxA[1] = f;
        this.bxA[2] = f2;
        this.bxA[3] = f2;
        this.bxA[4] = f3;
        this.bxA[5] = f3;
        this.bxA[6] = f4;
        this.bxA[7] = f4;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mRectF.set(0.0f, 0.0f, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.bwK) {
            h(canvas);
        } else {
            i(canvas);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.bwJ) {
            if (this.bwK) {
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
        this.bxA = new float[8];
        this.bwJ = true;
        this.bwK = Build.VERSION.SDK_INT >= 28;
    }

    private void initAttrs(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.k.sdk_RoundRectRelativeLayout);
            this.bwJ = obtainStyledAttributes.getBoolean(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_clip_background, true);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius, 0);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_top_left, dimensionPixelOffset);
            int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_top_right, dimensionPixelOffset);
            int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_bottom_left, dimensionPixelOffset);
            int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(a.k.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_bottom_right, dimensionPixelOffset);
            obtainStyledAttributes.recycle();
            this.bxA[0] = dimensionPixelOffset2;
            this.bxA[1] = dimensionPixelOffset2;
            this.bxA[2] = dimensionPixelOffset3;
            this.bxA[3] = dimensionPixelOffset3;
            this.bxA[4] = dimensionPixelOffset5;
            this.bxA[5] = dimensionPixelOffset5;
            this.bxA[6] = dimensionPixelOffset4;
            this.bxA[7] = dimensionPixelOffset4;
        }
    }

    private Path Rl() {
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRectF, this.bxA, Path.Direction.CW);
        return this.mPath;
    }

    private void h(Canvas canvas) {
        canvas.save();
        canvas.clipPath(Rl());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private void i(Canvas canvas) {
        canvas.saveLayer(this.mRectF, null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(Rl(), this.mPaint);
        canvas.restore();
    }

    private void j(Canvas canvas) {
        canvas.save();
        canvas.clipPath(Rl());
        super.draw(canvas);
        canvas.restore();
    }

    private void k(Canvas canvas) {
        canvas.saveLayer(this.mRectF, null, 31);
        super.draw(canvas);
        canvas.drawPath(Rl(), this.mPaint);
        canvas.restore();
    }
}
