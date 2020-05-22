package com.baidu.live.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class ShadowContainer extends ViewGroup {
    private final float bjb;
    private final float bjc;
    private final float bjd;
    private final float bje;
    private final float bjf;
    private boolean bjg;
    private final Paint mShadowPaint;

    public ShadowContainer(Context context) {
        this(context, null);
    }

    public ShadowContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.k.ShadowContainer);
        this.bjb = obtainStyledAttributes.getDimension(a.k.ShadowContainer_topDeltaLength, 0.0f);
        this.bjc = obtainStyledAttributes.getDimension(a.k.ShadowContainer_bottomDeltaLength, 0.0f);
        this.bjd = obtainStyledAttributes.getDimension(a.k.ShadowContainer_leftDeltaLength, 0.0f);
        this.bje = obtainStyledAttributes.getDimension(a.k.ShadowContainer_rightDeltaLength, 0.0f);
        this.bjf = obtainStyledAttributes.getDimension(a.k.ShadowContainer_containerCornerRadius, 0.0f);
        this.bjg = obtainStyledAttributes.getBoolean(a.k.ShadowContainer_enable, true);
        float dimension = obtainStyledAttributes.getDimension(a.k.ShadowContainer_deltaX, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(a.k.ShadowContainer_deltaY, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(a.k.ShadowContainer_containerShadowRadius, 0.0f);
        int color = obtainStyledAttributes.getColor(a.k.ShadowContainer_containerShadowColor, SupportMenu.CATEGORY_MASK);
        obtainStyledAttributes.recycle();
        this.mShadowPaint = new Paint();
        this.mShadowPaint.setStyle(Paint.Style.FILL);
        this.mShadowPaint.setAntiAlias(true);
        this.mShadowPaint.setColor(color);
        this.mShadowPaint.setShadowLayer(dimension3, dimension, dimension2, color);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.bjg) {
            if (getLayerType() != 1) {
                setLayerType(1, null);
            }
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int top2 = childAt.getTop();
            int right = childAt.getRight();
            int bottom = childAt.getBottom();
            if (Build.VERSION.SDK_INT >= 21) {
                canvas.drawRoundRect(left, top2, right, bottom, this.bjf, this.bjf, this.mShadowPaint);
            } else {
                Path path = new Path();
                path.moveTo(left + this.bjf, top2);
                path.arcTo(new RectF(left, top2, left + (this.bjf * 2.0f), top2 + (this.bjf * 2.0f)), -90.0f, -90.0f, false);
                path.lineTo(left, bottom - this.bjf);
                path.arcTo(new RectF(left, bottom - (this.bjf * 2.0f), left + (this.bjf * 2.0f), bottom), 180.0f, -90.0f, false);
                path.lineTo(right - this.bjf, bottom);
                path.arcTo(new RectF(right - (this.bjf * 2.0f), bottom - (this.bjf * 2.0f), right, bottom), 90.0f, -90.0f, false);
                path.lineTo(right, top2 + this.bjf);
                path.arcTo(new RectF(right - (this.bjf * 2.0f), top2, right, top2 + (this.bjf * 2.0f)), 0.0f, -90.0f, false);
                path.close();
                canvas.drawPath(path, this.mShadowPaint);
            }
        }
        super.dispatchDraw(canvas);
    }

    public void setDrawShadow(boolean z) {
        if (this.bjg != z) {
            this.bjg = z;
            postInvalidate();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        super.onMeasure(i, i2);
        if (getChildCount() != 1) {
            throw new IllegalStateException("Child view must be ony one!");
        }
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        View childAt = getChildAt(0);
        ShadowLayoutParams shadowLayoutParams = (ShadowLayoutParams) childAt.getLayoutParams();
        int i7 = (int) this.bjc;
        int i8 = (int) this.bjd;
        int i9 = (int) this.bje;
        int i10 = (int) this.bjb;
        if (mode == 0) {
            i3 = 0;
            i4 = View.MeasureSpec.getSize(i);
        } else if (shadowLayoutParams.width == -1) {
            i3 = 1073741824;
            i4 = (measuredWidth - i8) - i9;
        } else if (-2 == shadowLayoutParams.width) {
            i3 = Integer.MIN_VALUE;
            i4 = (measuredWidth - i8) - i9;
        } else {
            i3 = 1073741824;
            i4 = shadowLayoutParams.width;
        }
        if (mode2 == 0) {
            i5 = 0;
            i6 = View.MeasureSpec.getSize(i2);
        } else if (shadowLayoutParams.height == -1) {
            i5 = 1073741824;
            i6 = (measuredHeight - i7) - i10;
        } else if (-2 == shadowLayoutParams.height) {
            i5 = Integer.MIN_VALUE;
            i6 = (measuredHeight - i7) - i10;
        } else {
            i5 = 1073741824;
            i6 = shadowLayoutParams.height;
        }
        measureChild(childAt, View.MeasureSpec.makeMeasureSpec(i4, i3), View.MeasureSpec.makeMeasureSpec(i6, i5));
        int mode3 = View.MeasureSpec.getMode(i);
        int mode4 = View.MeasureSpec.getMode(i2);
        int measuredHeight2 = childAt.getMeasuredHeight();
        int measuredWidth2 = childAt.getMeasuredWidth();
        int i11 = mode4 == Integer.MIN_VALUE ? measuredHeight2 + i10 + i7 : measuredHeight;
        int i12 = mode3 == Integer.MIN_VALUE ? measuredWidth2 + i9 + i8 : measuredWidth;
        if (i12 < measuredWidth2 + this.bjd + this.bje) {
            i12 = (int) (measuredWidth2 + this.bjd + this.bje);
        }
        if (i11 < measuredHeight2 + this.bjb + this.bjc) {
            i11 = (int) (measuredHeight2 + this.bjb + this.bjc);
        }
        if (i11 != measuredHeight || i12 != measuredWidth) {
            setMeasuredDimension(i12, i11);
        }
    }

    /* loaded from: classes3.dex */
    public static class ShadowLayoutParams extends ViewGroup.MarginLayoutParams {
        public ShadowLayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public ShadowLayoutParams(int i, int i2) {
            super(i, i2);
        }

        public ShadowLayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ShadowLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ShadowLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ShadowLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        int measuredWidth = childAt.getMeasuredWidth();
        childAt.layout((int) this.bjd, (int) this.bjb, (int) (measuredWidth + this.bjd), (int) (childAt.getMeasuredHeight() + this.bjb));
    }
}
