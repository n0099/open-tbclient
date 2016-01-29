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
    private int Gh;
    private int Gi;
    private int Gj;
    private int Gk;

    public FloatingLayout(Context context) {
        this(context, null);
    }

    public FloatingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.Gh = 0;
        this.Gi = 0;
        if (getOrientation() == 1) {
            f(i, i2);
        } else if (getOrientation() == 0) {
            g(i, i2);
        }
        setMeasuredDimension(this.Gj + getPaddingLeft() + getPaddingRight(), this.Gk + getPaddingTop() + getPaddingBottom());
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
                if (i4 <= this.Gi || (generateDefaultLayoutParams.Gl & 1) == 1) {
                    this.Gi = 0;
                }
                measureChildWithMargins(childAt, i, this.Gh, i2, this.Gi);
                i3 = Math.max(childAt.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin, i6);
                this.Gh = i3;
                this.Gi = childAt.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin + this.Gi;
                this.Gk = Math.max(this.Gi, this.Gk);
                if ((generateDefaultLayoutParams.Gl & 2) == 2) {
                    this.Gi = 0;
                    this.Gh = i3 + this.Gh;
                    i3 = 0;
                } else if ((generateDefaultLayoutParams.Gl & 1) == 1) {
                    this.Gh = i3 + this.Gh;
                    i3 = 0;
                }
            }
            i5++;
            i6 = i3;
        }
        this.Gj = this.Gh;
    }

    private void g(int i, int i2) {
        int i3;
        int i4 = i & 1073741823;
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
                if (i4 <= this.Gh || (generateDefaultLayoutParams.Gl & 1) == 1) {
                    this.Gh = 0;
                }
                measureChildWithMargins(childAt, i, this.Gh, i2, this.Gi);
                int measuredWidth = generateDefaultLayoutParams.rightMargin + childAt.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin;
                i3 = Math.max(childAt.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin, i6);
                this.Gi = i3;
                this.Gh += measuredWidth;
                this.Gj = Math.max(this.Gj, this.Gh);
                if ((generateDefaultLayoutParams.Gl & 2) == 2) {
                    this.Gh = 0;
                    this.Gi = i3 + this.Gi;
                    i3 = 0;
                } else if ((generateDefaultLayoutParams.Gl & 1) == 1) {
                    this.Gi = i3 + this.Gi;
                    i3 = 0;
                }
            }
            i5++;
            i6 = i3;
        }
        this.Gk = this.Gi;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int orientation = getOrientation();
        if (orientation == 0) {
            my();
        } else if (orientation == 1) {
            mz();
        }
    }

    private void my() {
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
                if (measuredWidth - paddingLeft < measuredWidth2 || (aVar.Gl & 1) == 1) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += i;
                    i = 0;
                }
                childAt.layout(aVar.leftMargin + paddingLeft, aVar.topMargin + paddingTop, aVar.leftMargin + paddingLeft + childAt.getMeasuredWidth(), aVar.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingLeft += measuredWidth2;
                if (measuredHeight > i) {
                    i = measuredHeight;
                }
                if ((aVar.Gl & 2) == 2) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += i;
                    i = 0;
                }
            }
        }
    }

    private void mz() {
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
                if (measuredHeight - paddingTop < measuredHeight2 || (aVar.Gl & 1) == 1) {
                    paddingLeft += i;
                    paddingTop = getPaddingTop();
                    i = 0;
                }
                childAt.layout(aVar.leftMargin + paddingLeft, aVar.topMargin + paddingTop, aVar.leftMargin + paddingLeft + childAt.getMeasuredWidth(), aVar.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingTop += measuredHeight2;
                if (measuredWidth > i) {
                    i = measuredWidth;
                }
                if ((aVar.Gl & 2) == 2) {
                    paddingLeft += i;
                    paddingTop = getPaddingTop();
                    i = 0;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends LinearLayout.LayoutParams {
        private int Gl;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.Gl = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingLayout_Layout);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                if ("before".equals(string)) {
                    this.Gl = 1;
                } else if ("after".equals(string)) {
                    this.Gl = 2;
                } else if ("both".equals(string)) {
                    this.Gl = 3;
                }
            }
            obtainStyledAttributes.recycle();
        }

        public a(int i, int i2, int i3) {
            super(i, i2);
            this.Gl = 0;
            this.Gl = i3;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.Gl = 0;
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
    /* renamed from: mA */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2, 0);
    }
}
