package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.R;
import com.baidu.sapi2.utils.enums.a;
/* loaded from: classes.dex */
public class FloatingLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f2250e;

    /* renamed from: f  reason: collision with root package name */
    public int f2251f;

    /* renamed from: g  reason: collision with root package name */
    public int f2252g;

    /* renamed from: h  reason: collision with root package name */
    public int f2253h;

    public FloatingLayout(Context context) {
        this(context, null);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: c */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public final void d() {
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
                int measuredWidth2 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin + childAt.getMeasuredWidth();
                int measuredHeight = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + childAt.getMeasuredHeight();
                if (measuredWidth - paddingLeft < measuredWidth2 || (layoutParams.f2254a & 1) == 1) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += i;
                    i = 0;
                }
                int i3 = ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                childAt.layout(paddingLeft + i3, ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop, i3 + paddingLeft + childAt.getMeasuredWidth(), ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingLeft += measuredWidth2;
                if (measuredHeight > i) {
                    i = measuredHeight;
                }
                if ((layoutParams.f2254a & 2) == 2) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += i;
                    i = 0;
                }
            }
        }
    }

    public final void e() {
        LayoutParams layoutParams;
        int childCount = getChildCount();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt != null && childAt.getVisibility() != 8 && (layoutParams = (LayoutParams) childAt.getLayoutParams()) != null) {
                int measuredWidth = ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin + childAt.getMeasuredWidth();
                int measuredHeight2 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + childAt.getMeasuredHeight();
                if (measuredHeight - paddingTop < measuredHeight2 || (layoutParams.f2254a & 1) == 1) {
                    paddingLeft += i;
                    paddingTop = getPaddingTop();
                    i = 0;
                }
                int i3 = ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                childAt.layout(paddingLeft + i3, ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop, i3 + paddingLeft + childAt.getMeasuredWidth(), ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingTop += measuredHeight2;
                if (measuredWidth > i) {
                    i = measuredWidth;
                }
                if ((layoutParams.f2254a & 2) == 2) {
                    paddingLeft += i;
                    paddingTop = getPaddingTop();
                    i = 0;
                }
            }
        }
    }

    public final void f(int i, int i2) {
        this.f2251f = 0;
        int i3 = i & 1073741823;
        int childCount = getChildCount();
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null && childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                }
                LayoutParams layoutParams2 = layoutParams;
                if (i3 <= this.f2250e || (layoutParams2.f2254a & 1) == 1) {
                    this.f2250e = 0;
                }
                measureChildWithMargins(childAt, i, this.f2250e, i2, this.f2251f);
                int measuredWidth = childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                if ((layoutParams2.f2254a & 1) == 1) {
                    this.f2251f += i4;
                    i4 = 0;
                }
                i4 = Math.max(measuredHeight, i4);
                int i6 = this.f2250e + measuredWidth;
                this.f2250e = i6;
                this.f2252g = Math.max(this.f2252g, i6);
                if ((layoutParams2.f2254a & 2) == 2) {
                    this.f2250e = 0;
                    this.f2251f += i4;
                    i4 = 0;
                }
            }
        }
        int i7 = this.f2251f + i4;
        this.f2251f = i7;
        this.f2253h = i7;
    }

    public final void g(int i, int i2) {
        int i3 = i2 & 1073741823;
        int childCount = getChildCount();
        int i4 = 0;
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt != null && childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                }
                LayoutParams layoutParams2 = layoutParams;
                if (i3 <= this.f2251f || (layoutParams2.f2254a & 1) == 1) {
                    this.f2251f = 0;
                }
                measureChildWithMargins(childAt, i, this.f2250e, i2, this.f2251f);
                i4 = Math.max(childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin, i4);
                this.f2250e = i4;
                int measuredHeight = this.f2251f + childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                this.f2251f = measuredHeight;
                this.f2253h = Math.max(measuredHeight, this.f2253h);
                if ((layoutParams2.f2254a & 2) != 2) {
                    if ((layoutParams2.f2254a & 1) == 1) {
                        this.f2250e += i4;
                    }
                } else {
                    this.f2251f = 0;
                    this.f2250e += i4;
                }
                i4 = 0;
            }
        }
        this.f2252g = this.f2250e;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int orientation = getOrientation();
        if (orientation == 0) {
            d();
        } else if (orientation == 1) {
            e();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        this.f2250e = 0;
        this.f2251f = 0;
        if (getOrientation() == 1) {
            g(i, i2);
        } else if (getOrientation() == 0) {
            f(i, i2);
        }
        setMeasuredDimension(this.f2252g + getPaddingLeft() + getPaddingRight(), this.f2253h + getPaddingTop() + getPaddingBottom());
    }

    public FloatingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f2254a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2254a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingLayout_Layout);
            String string = obtainStyledAttributes.getString(R.styleable.FloatingLayout_Layout_layout_clear);
            if (string != null) {
                if ("before".equals(string)) {
                    this.f2254a = 1;
                } else if ("after".equals(string)) {
                    this.f2254a = 2;
                } else if (a.f11499c.equals(string)) {
                    this.f2254a = 3;
                }
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f2254a = 0;
        }

        public LayoutParams(int i, int i2, int i3) {
            super(i, i2);
            this.f2254a = 0;
            this.f2254a = i3;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2254a = 0;
        }
    }
}
