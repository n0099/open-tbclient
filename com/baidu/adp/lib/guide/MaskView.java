package com.baidu.adp.lib.guide;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MaskView extends ViewGroup {
    private final RectF mChildTmpRect;
    private boolean mCustomFullingRect;
    private final Paint mFullingPaint;
    private final RectF mFullingRect;
    private final Path mOutPath;
    private final Paint mPaint;
    private final Paint mTargetPaint;
    private final RectF mTargetRect;
    private boolean mUseDirectOffset;

    public MaskView(Context context) {
        this(context, null, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaskView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTargetRect = new RectF();
        this.mFullingRect = new RectF();
        this.mChildTmpRect = new RectF();
        this.mFullingPaint = new Paint();
        this.mOutPath = new Path();
        this.mUseDirectOffset = false;
        this.mTargetPaint = new Paint();
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mTargetPaint.setColor(SupportMenu.CATEGORY_MASK);
        this.mTargetPaint.setStrokeWidth(10.0f);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        this.mOutPath.setFillType(Path.FillType.EVEN_ODD);
        resetOutPath();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            clearFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = i & 1073741823;
        int i4 = i2 & 1073741823;
        setMeasuredDimension(i3, i4);
        if (!this.mCustomFullingRect) {
            this.mFullingRect.set(0.0f, 0.0f, i3, i4);
            resetOutPath();
        }
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams == null) {
                    childAt.setLayoutParams(layoutParams);
                }
                measureChild(childAt, i3 - 2147483648, i4 - 2147483648);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams;
        int childCount = getChildCount();
        float f = getResources().getDisplayMetrics().density;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null && (layoutParams = (LayoutParams) childAt.getLayoutParams()) != null) {
                switch (layoutParams.targetAnchor) {
                    case 1:
                        this.mChildTmpRect.right = this.mTargetRect.left;
                        this.mChildTmpRect.left = this.mChildTmpRect.right - childAt.getMeasuredWidth();
                        verticalChildPositionLayout(childAt, this.mChildTmpRect, layoutParams.targetParentPosition);
                        break;
                    case 2:
                        this.mChildTmpRect.bottom = this.mTargetRect.top;
                        this.mChildTmpRect.top = this.mChildTmpRect.bottom - childAt.getMeasuredHeight();
                        horizontalChildPositionLayout(childAt, this.mChildTmpRect, layoutParams.targetParentPosition);
                        break;
                    case 3:
                        this.mChildTmpRect.left = this.mTargetRect.right;
                        this.mChildTmpRect.right = this.mChildTmpRect.left + childAt.getMeasuredWidth();
                        verticalChildPositionLayout(childAt, this.mChildTmpRect, layoutParams.targetParentPosition);
                        break;
                    case 4:
                        this.mChildTmpRect.top = this.mTargetRect.bottom;
                        this.mChildTmpRect.bottom = this.mChildTmpRect.top + childAt.getMeasuredHeight();
                        horizontalChildPositionLayout(childAt, this.mChildTmpRect, layoutParams.targetParentPosition);
                        break;
                    case 5:
                        this.mChildTmpRect.left = (((int) this.mTargetRect.width()) - childAt.getMeasuredWidth()) >> 1;
                        this.mChildTmpRect.top = (((int) this.mTargetRect.height()) - childAt.getMeasuredHeight()) >> 1;
                        this.mChildTmpRect.right = (((int) this.mTargetRect.width()) + childAt.getMeasuredWidth()) >> 1;
                        this.mChildTmpRect.bottom = (((int) this.mTargetRect.height()) + childAt.getMeasuredHeight()) >> 1;
                        this.mChildTmpRect.offset(this.mTargetRect.left, this.mTargetRect.top);
                        break;
                }
                if (this.mUseDirectOffset) {
                    this.mChildTmpRect.offset(layoutParams.offsetX, layoutParams.offsetY);
                } else {
                    this.mChildTmpRect.offset((int) ((layoutParams.offsetX * f) + 0.5f), (int) ((layoutParams.offsetY * f) + 0.5f));
                }
                childAt.layout((int) this.mChildTmpRect.left, (int) this.mChildTmpRect.top, (int) this.mChildTmpRect.right, (int) this.mChildTmpRect.bottom);
            }
        }
    }

    public void setUseDirectOffset(boolean z) {
        this.mUseDirectOffset = z;
    }

    private void horizontalChildPositionLayout(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.left = this.mTargetRect.left;
                rectF.right = rectF.left + view.getMeasuredWidth();
                return;
            case 32:
                rectF.left = (this.mTargetRect.width() - view.getMeasuredWidth()) / 2.0f;
                rectF.right = (this.mTargetRect.width() + view.getMeasuredWidth()) / 2.0f;
                rectF.offset(this.mTargetRect.left, 0.0f);
                return;
            case 48:
                rectF.right = this.mTargetRect.right;
                rectF.left = rectF.right - view.getMeasuredWidth();
                return;
            default:
                return;
        }
    }

    private void verticalChildPositionLayout(View view, RectF rectF, int i) {
        switch (i) {
            case 16:
                rectF.top = this.mTargetRect.top;
                rectF.bottom = rectF.top + view.getMeasuredHeight();
                return;
            case 32:
                rectF.top = (this.mTargetRect.width() - view.getMeasuredHeight()) / 2.0f;
                rectF.bottom = (this.mTargetRect.width() + view.getMeasuredHeight()) / 2.0f;
                rectF.offset(0.0f, this.mTargetRect.top);
                return;
            case 48:
                rectF.bottom = this.mTargetRect.bottom;
                rectF.top = this.mTargetRect.bottom - view.getMeasuredHeight();
                return;
            default:
                return;
        }
    }

    private void resetOutPath() {
        this.mOutPath.reset();
        this.mOutPath.addRect(this.mTargetRect, Path.Direction.CW);
        this.mOutPath.addRect(this.mFullingRect, Path.Direction.CW);
    }

    public void setTargetRect(Rect rect) {
        this.mTargetRect.set(rect);
        resetOutPath();
        invalidate();
    }

    public void setFullingRect(Rect rect) {
        this.mFullingRect.set(rect);
        resetOutPath();
        this.mCustomFullingRect = true;
        invalidate();
    }

    public void setFullingAlpha(int i) {
        this.mFullingPaint.setAlpha(i);
        invalidate();
    }

    public void setFullingColor(int i) {
        this.mFullingPaint.setColor(i);
        invalidate();
    }

    public void setOverlayTarget(boolean z) {
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: me */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        long drawingTime = getDrawingTime();
        canvas.save();
        canvas.drawRect(this.mFullingRect, this.mFullingPaint);
        canvas.restore();
        for (int i = 0; i < getChildCount(); i++) {
            try {
                drawChild(canvas, getChildAt(i), drawingTime);
            } catch (NullPointerException e) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        public int offsetX;
        public int offsetY;
        public int targetAnchor;
        public int targetParentPosition;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.targetAnchor = 4;
            this.targetParentPosition = 32;
            this.offsetX = 0;
            this.offsetY = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.targetAnchor = 4;
            this.targetParentPosition = 32;
            this.offsetX = 0;
            this.offsetY = 0;
        }
    }
}
