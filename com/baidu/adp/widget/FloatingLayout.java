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
    private int wF;
    private int wG;
    private int wH;
    private int wI;

    public FloatingLayout(Context context) {
        this(context, null);
    }

    public FloatingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.wF = 0;
        this.wG = 0;
        if (getOrientation() == 1) {
            f(i, i2);
        } else if (getOrientation() == 0) {
            g(i, i2);
        }
        setMeasuredDimension(this.wH + getPaddingLeft() + getPaddingRight(), this.wI + getPaddingTop() + getPaddingBottom());
    }

    private void f(int i, int i2) {
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
                a aVar = (a) childAt.getLayoutParams();
                a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                if (i4 <= this.wG || (generateDefaultLayoutParams.wJ & 1) == 1) {
                    this.wG = 0;
                }
                measureChildWithMargins(childAt, i, this.wF, i2, this.wG);
                i3 = Math.max(childAt.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin, i6);
                this.wF = i3;
                this.wG = childAt.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin + this.wG;
                this.wI = Math.max(this.wG, this.wI);
                if ((generateDefaultLayoutParams.wJ & 2) == 2) {
                    this.wG = 0;
                    this.wF = i3 + this.wF;
                    i3 = 0;
                } else if ((generateDefaultLayoutParams.wJ & 1) == 1) {
                    this.wF = i3 + this.wF;
                    i3 = 0;
                }
            }
            i5++;
            i6 = i3;
        }
        this.wH = this.wF;
    }

    private void g(int i, int i2) {
        int i3;
        this.wG = 0;
        int i4 = i & 1073741823;
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != null && childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                if (i4 <= this.wF || (generateDefaultLayoutParams.wJ & 1) == 1) {
                    this.wF = 0;
                }
                measureChildWithMargins(childAt, i, this.wF, i2, this.wG);
                int measuredWidth = generateDefaultLayoutParams.rightMargin + childAt.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin;
                int measuredHeight = generateDefaultLayoutParams.bottomMargin + childAt.getMeasuredHeight() + generateDefaultLayoutParams.topMargin;
                if ((generateDefaultLayoutParams.wJ & 1) == 1) {
                    this.wG += i5;
                    i3 = 0;
                } else {
                    i3 = i5;
                }
                i5 = Math.max(measuredHeight, i3);
                this.wF += measuredWidth;
                this.wH = Math.max(this.wH, this.wF);
                if ((generateDefaultLayoutParams.wJ & 2) == 2) {
                    this.wF = 0;
                    this.wG += i5;
                    i5 = 0;
                }
            }
        }
        this.wG += i5;
        this.wI = this.wG;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int orientation = getOrientation();
        if (orientation == 0) {
            iD();
        } else if (orientation == 1) {
            iE();
        }
    }

    private void iD() {
        int childCount = getChildCount();
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                if (aVar == null) {
                    aVar = generateDefaultLayoutParams();
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + aVar.leftMargin + aVar.rightMargin;
                int measuredHeight = aVar.topMargin + aVar.bottomMargin + childAt.getMeasuredHeight();
                if (measuredWidth - paddingLeft < measuredWidth2 || (aVar.wJ & 1) == 1) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += i;
                    i = 0;
                }
                childAt.layout(aVar.leftMargin + paddingLeft, aVar.topMargin + paddingTop, aVar.leftMargin + paddingLeft + childAt.getMeasuredWidth(), aVar.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingLeft += measuredWidth2;
                if (measuredHeight > i) {
                    i = measuredHeight;
                }
                if ((aVar.wJ & 2) == 2) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += i;
                    i = 0;
                }
            }
        }
    }

    private void iE() {
        a aVar;
        int childCount = getChildCount();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8 && (aVar = (a) childAt.getLayoutParams()) != null) {
                int measuredWidth = aVar.leftMargin + aVar.rightMargin + childAt.getMeasuredWidth();
                int measuredHeight2 = aVar.topMargin + aVar.bottomMargin + childAt.getMeasuredHeight();
                if (measuredHeight - paddingTop < measuredHeight2 || (aVar.wJ & 1) == 1) {
                    paddingLeft += i;
                    paddingTop = getPaddingTop();
                    i = 0;
                }
                childAt.layout(aVar.leftMargin + paddingLeft, aVar.topMargin + paddingTop, aVar.leftMargin + paddingLeft + childAt.getMeasuredWidth(), aVar.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingTop += measuredHeight2;
                if (measuredWidth > i) {
                    i = measuredWidth;
                }
                if ((aVar.wJ & 2) == 2) {
                    paddingLeft += i;
                    paddingTop = getPaddingTop();
                    i = 0;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout.LayoutParams {
        private int wJ;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.wJ = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingLayout_Layout);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                if ("before".equals(string)) {
                    this.wJ = 1;
                } else if ("after".equals(string)) {
                    this.wJ = 2;
                } else if ("both".equals(string)) {
                    this.wJ = 3;
                }
            }
            obtainStyledAttributes.recycle();
        }

        public a(int i, int i2, int i3) {
            super(i, i2);
            this.wJ = 0;
            this.wJ = i3;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.wJ = 0;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a */
    public a generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: c */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: iF */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2, 0);
    }
}
