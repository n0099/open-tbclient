package com.baidu.nadcore.widget.bubble.shadow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tieba.fc1;
/* loaded from: classes3.dex */
public class MaskViewGroup extends ViewGroup {
    public float a;
    public float b;
    public float c;
    public Paint d;
    public boolean e;
    public Context f;
    public int g;
    public float h;
    public float i;
    public float j;
    public int k;

    /* loaded from: classes3.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public MaskViewGroup(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void setAlpha(int i) {
        this.k = i;
        a();
    }

    public void setDrawShadow(boolean z) {
        this.e = z;
    }

    public void setShadowColor(int i) {
        this.g = i;
        a();
    }

    public void setShadowRadius(float f) {
        this.h = f;
        a();
    }

    public MaskViewGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskViewGroup(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.k = 75;
        this.f = context;
        b(attributeSet);
    }

    public final void a() {
        c();
        Paint paint = new Paint();
        this.d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.d.setAntiAlias(true);
        this.d.setColor(this.g);
        this.d.setShadowLayer(this.h, this.i, this.j, this.g);
        this.d.setAlpha(this.k);
    }

    public final void c() {
        int i;
        int i2 = this.g;
        int i3 = (i2 >> 16) & 255;
        int i4 = (i2 >> 8) & 255;
        int i5 = (i2 >> 0) & 255;
        int i6 = (i2 >> 24) & 255;
        if (i6 == 0) {
            i = this.k;
        } else {
            i = (i6 * this.k) / 255;
        }
        this.g = (i << 24) + (i3 << 16) + (i4 << 8) + i5;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public float getDeltaHeight() {
        return this.a;
    }

    public float getDeltaWidth() {
        return this.b;
    }

    public int getShadowColorAlpha() {
        return (this.g >> 24) & 255;
    }

    public final void b(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = this.f.obtainStyledAttributes(attributeSet, fc1.NadShadowViewGroup);
        this.g = obtainStyledAttributes.getColor(3, -16777216);
        this.h = obtainStyledAttributes.getDimension(4, 0.0f);
        this.i = obtainStyledAttributes.getDimension(5, 0.0f);
        this.j = obtainStyledAttributes.getDimension(6, 0.0f);
        this.b = obtainStyledAttributes.getDimension(2, 0.0f);
        this.a = obtainStyledAttributes.getDimension(1, 0.0f);
        this.c = obtainStyledAttributes.getDimension(0, 0.0f);
        this.e = obtainStyledAttributes.getBoolean(7, true);
        this.k = obtainStyledAttributes.getInt(8, 127);
        obtainStyledAttributes.recycle();
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21 && this.e) {
            if (getLayerType() != 1) {
                setLayerType(1, null);
            }
            View childAt = getChildAt(0);
            RectF rectF = new RectF(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            this.d.setAlpha(this.k);
            float f = this.c;
            canvas.drawRoundRect(rectF, f, f, this.d);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int measuredWidth2 = childAt.getMeasuredWidth();
        int measuredHeight2 = childAt.getMeasuredHeight();
        childAt.layout((measuredWidth - measuredWidth2) / 2, (measuredHeight - measuredHeight2) / 2, (measuredWidth + measuredWidth2) / 2, (measuredHeight + measuredHeight2) / 2);
        int childCount = getChildCount();
        if (childCount > 1) {
            for (int i5 = 1; i5 < childCount; i5++) {
                View childAt2 = getChildAt(i5);
                if (childAt2.getVisibility() != 8) {
                    childAt2.layout(i, i2, i3, i4);
                }
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i7 = 0;
        View childAt = getChildAt(0);
        LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
        int max = (int) (Math.max(this.a, ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin) + 1.0f);
        int max2 = (int) (Math.max(this.b, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) + 1.0f);
        int max3 = (int) (Math.max(this.b, ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin) + 1.0f);
        int max4 = (int) (Math.max(this.a, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + 1.0f);
        int i8 = 1073741824;
        if (mode == 0) {
            i3 = View.MeasureSpec.getSize(i);
        } else {
            i3 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            if (i3 == -1) {
                i3 = (measuredWidth - max2) - max3;
            } else if (-2 == i3) {
                i3 = (measuredWidth - max2) - max3;
                i7 = Integer.MIN_VALUE;
            }
            i7 = 1073741824;
        }
        if (mode2 == 0) {
            i4 = View.MeasureSpec.getSize(i2);
            i8 = 0;
        } else {
            i4 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            if (i4 == -1) {
                i4 = (measuredHeight - max) - max4;
            } else if (-2 == i4) {
                i4 = (measuredHeight - max) - max4;
                i8 = Integer.MIN_VALUE;
            }
        }
        measureChild(childAt, View.MeasureSpec.makeMeasureSpec(i3, i7), View.MeasureSpec.makeMeasureSpec(i4, i8));
        int mode3 = View.MeasureSpec.getMode(i);
        int mode4 = View.MeasureSpec.getMode(i2);
        int measuredHeight2 = childAt.getMeasuredHeight();
        int measuredWidth2 = childAt.getMeasuredWidth();
        if (mode4 == Integer.MIN_VALUE) {
            i5 = max4 + measuredHeight2 + max;
        } else {
            i5 = measuredHeight;
        }
        if (mode3 == Integer.MIN_VALUE) {
            i6 = max3 + measuredWidth2 + max2;
        } else {
            i6 = measuredWidth;
        }
        float f = measuredWidth2;
        float f2 = this.b;
        if (i6 < (f2 * 2.0f) + f) {
            i6 = (int) (f + (f2 * 2.0f));
        }
        float f3 = measuredHeight2;
        float f4 = this.a;
        if (i5 < (f4 * 2.0f) + f3) {
            i5 = (int) (f3 + (f4 * 2.0f));
        }
        if (i5 != measuredHeight || i6 != measuredWidth) {
            setMeasuredDimension(i6, i5);
        }
        if (getChildCount() > 1) {
            for (int i9 = 1; i9 < getChildCount(); i9++) {
                measureChild(getChildAt(i9), i, i2);
            }
        }
    }
}
