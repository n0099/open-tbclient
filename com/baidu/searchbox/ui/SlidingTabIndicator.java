package com.baidu.searchbox.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class SlidingTabIndicator extends LinearLayout {
    private static final float DRAG_VISCOSITY_PARAM = 2.3f;
    private int mIndicatorColor;
    private int mIndicatorHeight;
    private int mIndicatorLeft;
    private int mIndicatorPadding;
    private int mIndicatorRight;
    private final Paint mSelectedIndicatorPaint;
    private int mSelectedPosition;
    private float mSelectionOffset;

    public SlidingTabIndicator(Context context) {
        this(context, null);
    }

    public SlidingTabIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIndicatorColor = -16776961;
        this.mIndicatorLeft = -1;
        this.mIndicatorRight = -1;
        setWillNotDraw(false);
        float f = getResources().getDisplayMetrics().density;
        this.mSelectedIndicatorPaint = new Paint();
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

    public void setIndicatorPositionFromTabPosition(int i, float f) {
        this.mSelectedPosition = i;
        this.mSelectionOffset = f;
        updateIndicatorPosition();
    }

    private void updateIndicatorPosition() {
        View childAt;
        int childCount = getChildCount();
        if (childCount > 0) {
            if (this.mSelectedPosition >= childCount) {
                this.mSelectedPosition = childCount - 1;
            }
            View childAt2 = getChildAt(this.mSelectedPosition);
            int left = childAt2.getLeft() + this.mIndicatorPadding;
            int right = childAt2.getRight() - this.mIndicatorPadding;
            if (this.mSelectionOffset > 0.0f && this.mSelectedPosition < getChildCount() - 1) {
                float right2 = (getChildAt(this.mSelectedPosition + 1).getRight() - this.mIndicatorPadding) - right;
                left += (int) (((childAt.getLeft() + this.mIndicatorPadding) - left) * ((float) Math.pow(this.mSelectionOffset, 2.299999952316284d)));
                right += (int) (right2 * (1.0f - ((float) Math.pow(1.0f - this.mSelectionOffset, 2.299999952316284d))));
            }
            setIndicatorPosition(left, right);
        }
    }

    private void setIndicatorPosition(int i, int i2) {
        if (i != this.mIndicatorLeft || i2 != this.mIndicatorRight) {
            this.mIndicatorLeft = i;
            this.mIndicatorRight = i2;
            invalidate();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mSelectedIndicatorPaint.setColor(this.mIndicatorColor);
        if (this.mIndicatorLeft >= 0 && this.mIndicatorRight > this.mIndicatorLeft) {
            canvas.drawRect(this.mIndicatorLeft, getHeight() - this.mIndicatorHeight, this.mIndicatorRight, getHeight(), this.mSelectedIndicatorPaint);
        }
    }
}
