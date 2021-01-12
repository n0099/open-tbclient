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
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import java.util.Arrays;
/* loaded from: classes10.dex */
public class RoundRectRelativeLayout extends RelativeLayout {
    private boolean bPD;
    private boolean bPE;
    private float[] bPQ;
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
        if (this.bPQ == null) {
            this.bPQ = new float[8];
        }
        Arrays.fill(this.bPQ, f);
        postInvalidate();
    }

    public void setCornerRadius(float f, float f2, float f3, float f4) {
        if (this.bPQ == null) {
            this.bPQ = new float[8];
        }
        this.bPQ[0] = f;
        this.bPQ[1] = f;
        this.bPQ[2] = f2;
        this.bPQ[3] = f2;
        this.bPQ[4] = f3;
        this.bPQ[5] = f3;
        this.bPQ[6] = f4;
        this.bPQ[7] = f4;
        postInvalidate();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.mRectF.set(0.0f, 0.0f, i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.bPE) {
            i(canvas);
        } else {
            j(canvas);
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.bPD) {
            if (this.bPE) {
                k(canvas);
                return;
            } else {
                l(canvas);
                return;
            }
        }
        super.draw(canvas);
    }

    private void init(AttributeSet attributeSet) {
        if (Build.VERSION.SDK_INT >= 30) {
            setLayerType(1, null);
        }
        initFields();
        initAttrs(attributeSet);
    }

    private void initFields() {
        this.mPaint = new Paint(1);
        this.mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.mPath = new Path();
        this.mRectF = new RectF();
        this.bPQ = new float[8];
        this.bPD = true;
        this.bPE = Build.VERSION.SDK_INT >= 28;
    }

    private void initAttrs(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, a.j.sdk_RoundRectRelativeLayout);
            this.bPD = obtainStyledAttributes.getBoolean(a.j.sdk_RoundRectRelativeLayout_sdk_rrrl_clip_background, true);
            int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(a.j.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius, 0);
            int dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(a.j.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_top_left, dimensionPixelOffset);
            int dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(a.j.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_top_right, dimensionPixelOffset);
            int dimensionPixelOffset4 = obtainStyledAttributes.getDimensionPixelOffset(a.j.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_bottom_left, dimensionPixelOffset);
            int dimensionPixelOffset5 = obtainStyledAttributes.getDimensionPixelOffset(a.j.sdk_RoundRectRelativeLayout_sdk_rrrl_corner_radius_bottom_right, dimensionPixelOffset);
            obtainStyledAttributes.recycle();
            this.bPQ[0] = dimensionPixelOffset2;
            this.bPQ[1] = dimensionPixelOffset2;
            this.bPQ[2] = dimensionPixelOffset3;
            this.bPQ[3] = dimensionPixelOffset3;
            this.bPQ[4] = dimensionPixelOffset5;
            this.bPQ[5] = dimensionPixelOffset5;
            this.bPQ[6] = dimensionPixelOffset4;
            this.bPQ[7] = dimensionPixelOffset4;
        }
    }

    private Path VM() {
        this.mPath.reset();
        this.mPath.addRoundRect(this.mRectF, this.bPQ, Path.Direction.CW);
        return this.mPath;
    }

    private void i(Canvas canvas) {
        canvas.save();
        canvas.clipPath(VM());
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private void j(Canvas canvas) {
        canvas.saveLayer(this.mRectF, null, 31);
        super.dispatchDraw(canvas);
        canvas.drawPath(VM(), this.mPaint);
        canvas.restore();
    }

    private void k(Canvas canvas) {
        canvas.save();
        canvas.clipPath(VM());
        super.draw(canvas);
        canvas.restore();
    }

    private void l(Canvas canvas) {
        canvas.saveLayer(this.mRectF, null, 31);
        super.draw(canvas);
        canvas.drawPath(VM(), this.mPaint);
        canvas.restore();
    }
}
