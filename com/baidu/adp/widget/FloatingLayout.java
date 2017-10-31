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
    private int Fl;
    private int Fm;
    private int Fn;
    private int Fo;

    public FloatingLayout(Context context) {
        this(context, null);
    }

    public FloatingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.Fl = 0;
        this.Fm = 0;
        if (getOrientation() == 1) {
            o(i, i2);
        } else if (getOrientation() == 0) {
            p(i, i2);
        }
        setMeasuredDimension(this.Fn + getPaddingLeft() + getPaddingRight(), this.Fo + getPaddingTop() + getPaddingBottom());
    }

    private void o(int i, int i2) {
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
                if (i4 <= this.Fm || (generateDefaultLayoutParams.clear & 1) == 1) {
                    this.Fm = 0;
                }
                measureChildWithMargins(childAt, i, this.Fl, i2, this.Fm);
                i3 = Math.max(childAt.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin, i6);
                this.Fl = i3;
                this.Fm = childAt.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin + this.Fm;
                this.Fo = Math.max(this.Fm, this.Fo);
                if ((generateDefaultLayoutParams.clear & 2) == 2) {
                    this.Fm = 0;
                    this.Fl = i3 + this.Fl;
                    i3 = 0;
                } else if ((generateDefaultLayoutParams.clear & 1) == 1) {
                    this.Fl = i3 + this.Fl;
                    i3 = 0;
                }
            }
            i5++;
            i6 = i3;
        }
        this.Fn = this.Fl;
    }

    private void p(int i, int i2) {
        int i3;
        this.Fm = 0;
        int i4 = i & 1073741823;
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != null && childAt.getVisibility() != 8) {
                a aVar = (a) childAt.getLayoutParams();
                a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                if (i4 <= this.Fl || (generateDefaultLayoutParams.clear & 1) == 1) {
                    this.Fl = 0;
                }
                measureChildWithMargins(childAt, i, this.Fl, i2, this.Fm);
                int measuredWidth = generateDefaultLayoutParams.rightMargin + childAt.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin;
                int measuredHeight = generateDefaultLayoutParams.bottomMargin + childAt.getMeasuredHeight() + generateDefaultLayoutParams.topMargin;
                if ((generateDefaultLayoutParams.clear & 1) == 1) {
                    this.Fm += i5;
                    i3 = 0;
                } else {
                    i3 = i5;
                }
                i5 = Math.max(measuredHeight, i3);
                this.Fl += measuredWidth;
                this.Fn = Math.max(this.Fn, this.Fl);
                if ((generateDefaultLayoutParams.clear & 2) == 2) {
                    this.Fl = 0;
                    this.Fm += i5;
                    i5 = 0;
                }
            }
        }
        this.Fm += i5;
        this.Fo = this.Fm;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int orientation = getOrientation();
        if (orientation == 0) {
            kq();
        } else if (orientation == 1) {
            kr();
        }
    }

    private void kq() {
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
                if (measuredWidth - paddingLeft < measuredWidth2 || (aVar.clear & 1) == 1) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += i;
                    i = 0;
                }
                childAt.layout(aVar.leftMargin + paddingLeft, aVar.topMargin + paddingTop, aVar.leftMargin + paddingLeft + childAt.getMeasuredWidth(), aVar.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingLeft += measuredWidth2;
                if (measuredHeight > i) {
                    i = measuredHeight;
                }
                if ((aVar.clear & 2) == 2) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += i;
                    i = 0;
                }
            }
        }
    }

    private void kr() {
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
                if (measuredHeight - paddingTop < measuredHeight2 || (aVar.clear & 1) == 1) {
                    paddingLeft += i;
                    paddingTop = getPaddingTop();
                    i = 0;
                }
                childAt.layout(aVar.leftMargin + paddingLeft, aVar.topMargin + paddingTop, aVar.leftMargin + paddingLeft + childAt.getMeasuredWidth(), aVar.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingTop += measuredHeight2;
                if (measuredWidth > i) {
                    i = measuredWidth;
                }
                if ((aVar.clear & 2) == 2) {
                    paddingLeft += i;
                    paddingTop = getPaddingTop();
                    i = 0;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout.LayoutParams {
        private int clear;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.clear = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingLayout_Layout);
            String string = obtainStyledAttributes.getString(R.styleable.FloatingLayout_Layout_layout_clear);
            if (string != null) {
                if ("before".equals(string)) {
                    this.clear = 1;
                } else if ("after".equals(string)) {
                    this.clear = 2;
                } else if ("both".equals(string)) {
                    this.clear = 3;
                }
            }
            obtainStyledAttributes.recycle();
        }

        public a(int i, int i2) {
            super(i, i2);
            this.clear = 0;
        }

        public a(int i, int i2, int i3) {
            super(i, i2);
            this.clear = 0;
            this.clear = i3;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.clear = 0;
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
    /* renamed from: a */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: ks */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2, 0);
    }
}
