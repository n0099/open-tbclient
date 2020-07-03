package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.R;
/* loaded from: classes.dex */
public class FloatingLayout extends LinearLayout {
    private int mMeasuredHeight;
    private int mMeasuredWidth;
    private int mUsedHeight;
    private int mUsedWidth;

    public FloatingLayout(Context context) {
        this(context, null);
    }

    public FloatingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mUsedWidth = 0;
        this.mUsedHeight = 0;
        if (getOrientation() == 1) {
            measureVertical(i, i2);
        } else if (getOrientation() == 0) {
            measureHorizontal(i, i2);
        }
        setMeasuredDimension(this.mMeasuredWidth + getPaddingLeft() + getPaddingRight(), this.mMeasuredHeight + getPaddingTop() + getPaddingBottom());
    }

    private void measureVertical(int i, int i2) {
        int i3;
        int i4 = i2 & 1073741823;
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt == null) {
                i3 = i6;
            } else if (childAt.getVisibility() == 8) {
                i3 = i6;
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                LayoutParams generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : layoutParams;
                if (i4 <= this.mUsedHeight || (generateDefaultLayoutParams.clear & 1) == 1) {
                    this.mUsedHeight = 0;
                }
                measureChildWithMargins(childAt, i, this.mUsedWidth, i2, this.mUsedHeight);
                i3 = Math.max(childAt.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin, i6);
                this.mUsedWidth = i3;
                this.mUsedHeight = childAt.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin + this.mUsedHeight;
                this.mMeasuredHeight = Math.max(this.mUsedHeight, this.mMeasuredHeight);
                if ((generateDefaultLayoutParams.clear & 2) == 2) {
                    this.mUsedHeight = 0;
                    this.mUsedWidth = i3 + this.mUsedWidth;
                    i3 = 0;
                } else if ((generateDefaultLayoutParams.clear & 1) == 1) {
                    this.mUsedWidth = i3 + this.mUsedWidth;
                    i3 = 0;
                }
            }
            i5++;
            i6 = i3;
        }
        this.mMeasuredWidth = this.mUsedWidth;
    }

    private void measureHorizontal(int i, int i2) {
        int i3;
        this.mUsedHeight = 0;
        int i4 = i & 1073741823;
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != null && childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                LayoutParams generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : layoutParams;
                if (i4 <= this.mUsedWidth || (generateDefaultLayoutParams.clear & 1) == 1) {
                    this.mUsedWidth = 0;
                }
                measureChildWithMargins(childAt, i, this.mUsedWidth, i2, this.mUsedHeight);
                int measuredWidth = generateDefaultLayoutParams.rightMargin + childAt.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin;
                int measuredHeight = generateDefaultLayoutParams.bottomMargin + childAt.getMeasuredHeight() + generateDefaultLayoutParams.topMargin;
                if ((generateDefaultLayoutParams.clear & 1) == 1) {
                    this.mUsedHeight += i5;
                    i3 = 0;
                } else {
                    i3 = i5;
                }
                i5 = Math.max(measuredHeight, i3);
                this.mUsedWidth += measuredWidth;
                this.mMeasuredWidth = Math.max(this.mMeasuredWidth, this.mUsedWidth);
                if ((generateDefaultLayoutParams.clear & 2) == 2) {
                    this.mUsedWidth = 0;
                    this.mUsedHeight += i5;
                    i5 = 0;
                }
            }
        }
        this.mUsedHeight += i5;
        this.mMeasuredHeight = this.mUsedHeight;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int orientation = getOrientation();
        if (orientation == 0) {
            layoutHorizontal();
        } else if (orientation == 1) {
            layoutVertical();
        }
    }

    private void layoutHorizontal() {
        int childCount = getChildCount();
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
                int measuredHeight = layoutParams.topMargin + layoutParams.bottomMargin + childAt.getMeasuredHeight();
                if (measuredWidth - paddingLeft < measuredWidth2 || (layoutParams.clear & 1) == 1) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += i;
                    i = 0;
                }
                childAt.layout(layoutParams.leftMargin + paddingLeft, layoutParams.topMargin + paddingTop, layoutParams.leftMargin + paddingLeft + childAt.getMeasuredWidth(), layoutParams.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingLeft += measuredWidth2;
                if (measuredHeight > i) {
                    i = measuredHeight;
                }
                if ((layoutParams.clear & 2) == 2) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += i;
                    i = 0;
                }
            }
        }
    }

    private void layoutVertical() {
        LayoutParams layoutParams;
        int childCount = getChildCount();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8 && (layoutParams = (LayoutParams) childAt.getLayoutParams()) != null) {
                int measuredWidth = layoutParams.leftMargin + layoutParams.rightMargin + childAt.getMeasuredWidth();
                int measuredHeight2 = layoutParams.topMargin + layoutParams.bottomMargin + childAt.getMeasuredHeight();
                if (measuredHeight - paddingTop < measuredHeight2 || (layoutParams.clear & 1) == 1) {
                    paddingLeft += i;
                    paddingTop = getPaddingTop();
                    i = 0;
                }
                childAt.layout(layoutParams.leftMargin + paddingLeft, layoutParams.topMargin + paddingTop, layoutParams.leftMargin + paddingLeft + childAt.getMeasuredWidth(), layoutParams.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingTop += measuredHeight2;
                if (measuredWidth > i) {
                    i = measuredWidth;
                }
                if ((layoutParams.clear & 2) == 2) {
                    paddingLeft += i;
                    paddingTop = getPaddingTop();
                    i = 0;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        private int clear;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.clear = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingLayout_Layout);
            String string = obtainStyledAttributes.getString(R.styleable.FloatingLayout_Layout_layout_clear);
            if (string != null) {
                if ("before".equals(string)) {
                    this.clear = 1;
                } else if ("after".equals(string)) {
                    this.clear = 2;
                } else if (com.baidu.sapi2.utils.enums.a.c.equals(string)) {
                    this.clear = 3;
                }
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.clear = 0;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.clear = 0;
            this.clear = i3;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.clear = 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: pd */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2, 0);
    }
}
