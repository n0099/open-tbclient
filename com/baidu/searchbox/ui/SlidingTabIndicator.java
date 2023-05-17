package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.searchbox.ui.animview.base.BaseAnimatedElement;
/* loaded from: classes4.dex */
public class SlidingTabIndicator extends LinearLayout {
    public static final float DRAG_VISCOSITY_PARAM = 2.3f;
    public int mIndicatorColor;
    public int mIndicatorHeight;
    public int mIndicatorLeft;
    public int mIndicatorPadding;
    public int mIndicatorRight;
    public final Paint mSelectedIndicatorPaint;
    public int mSelectedPosition;
    public float mSelectionOffset;

    public SlidingTabIndicator(Context context) {
        this(context, null);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mSelectedIndicatorPaint.setColor(this.mIndicatorColor);
        int i = this.mIndicatorLeft;
        if (i >= 0 && this.mIndicatorRight > i) {
            canvas.drawRect(i, getHeight() - this.mIndicatorHeight, this.mIndicatorRight, getHeight(), this.mSelectedIndicatorPaint);
        }
    }

    public void setIndicatorColor(int i) {
        if (this.mIndicatorColor != i) {
            this.mIndicatorColor = i;
            invalidate();
        }
    }

    public void setIndicatorHeight(int i) {
        if (this.mIndicatorHeight != i) {
            this.mIndicatorHeight = i;
            invalidate();
        }
    }

    public void setIndicatorPadding(int i) {
        if (this.mIndicatorPadding != i) {
            this.mIndicatorPadding = i;
            invalidate();
        }
    }

    public SlidingTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIndicatorColor = BaseAnimatedElement.DEBUG_PAINT_COLOR;
        this.mIndicatorLeft = -1;
        this.mIndicatorRight = -1;
        setWillNotDraw(false);
        float f = getResources().getDisplayMetrics().density;
        this.mSelectedIndicatorPaint = new Paint();
    }

    private void setIndicatorPosition(int i, int i2) {
        if (i != this.mIndicatorLeft || i2 != this.mIndicatorRight) {
            this.mIndicatorLeft = i;
            this.mIndicatorRight = i2;
            invalidate();
        }
    }

    public void setIndicatorPositionFromTabPosition(int i, float f) {
        this.mSelectedPosition = i;
        this.mSelectionOffset = f;
        updateIndicatorPosition();
    }

    private void updateIndicatorPosition() {
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.mSelectedPosition >= childCount) {
                this.mSelectedPosition = childCount - 1;
            }
            View childAt = getChildAt(this.mSelectedPosition);
            int left = childAt.getLeft() + this.mIndicatorPadding;
            int right = childAt.getRight() - this.mIndicatorPadding;
            if (this.mSelectionOffset > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
                View childAt2 = getChildAt(this.mSelectedPosition + 1);
                int left2 = childAt2.getLeft() + this.mIndicatorPadding;
                float right2 = (childAt2.getRight() - this.mIndicatorPadding) - right;
                left += (int) (((float) Math.pow(this.mSelectionOffset, 2.299999952316284d)) * (left2 - left));
                right += (int) (right2 * (1.0f - ((float) Math.pow(1.0f - this.mSelectionOffset, 2.299999952316284d))));
            }
            setIndicatorPosition(left, right);
        }
    }
}
