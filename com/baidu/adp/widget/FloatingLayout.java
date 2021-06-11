package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.R;
import com.baidu.sapi2.utils.enums.ShareDirectionType;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes.dex */
public class FloatingLayout extends LinearLayout {

    /* renamed from: e  reason: collision with root package name */
    public int f2283e;

    /* renamed from: f  reason: collision with root package name */
    public int f2284f;

    /* renamed from: g  reason: collision with root package name */
    public int f2285g;

    /* renamed from: h  reason: collision with root package name */
    public int f2286h;

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
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                }
                int measuredWidth2 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin + childAt.getMeasuredWidth();
                int measuredHeight = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + childAt.getMeasuredHeight();
                if (measuredWidth - paddingLeft < measuredWidth2 || (layoutParams.f2287a & 1) == 1) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += i2;
                    i2 = 0;
                }
                int i4 = ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                childAt.layout(paddingLeft + i4, ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop, i4 + paddingLeft + childAt.getMeasuredWidth(), ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingLeft += measuredWidth2;
                if (measuredHeight > i2) {
                    i2 = measuredHeight;
                }
                if ((layoutParams.f2287a & 2) == 2) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += i2;
                    i2 = 0;
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
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getVisibility() != 8 && (layoutParams = (LayoutParams) childAt.getLayoutParams()) != null) {
                int measuredWidth = ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin + childAt.getMeasuredWidth();
                int measuredHeight2 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + childAt.getMeasuredHeight();
                if (measuredHeight - paddingTop < measuredHeight2 || (layoutParams.f2287a & 1) == 1) {
                    paddingLeft += i2;
                    paddingTop = getPaddingTop();
                    i2 = 0;
                }
                int i4 = ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                childAt.layout(paddingLeft + i4, ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop, i4 + paddingLeft + childAt.getMeasuredWidth(), ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingTop += measuredHeight2;
                if (measuredWidth > i2) {
                    i2 = measuredWidth;
                }
                if ((layoutParams.f2287a & 2) == 2) {
                    paddingLeft += i2;
                    paddingTop = getPaddingTop();
                    i2 = 0;
                }
            }
        }
    }

    public final void f(int i2, int i3) {
        this.f2284f = 0;
        int i4 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != null && childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                }
                LayoutParams layoutParams2 = layoutParams;
                if (i4 <= this.f2283e || (layoutParams2.f2287a & 1) == 1) {
                    this.f2283e = 0;
                }
                measureChildWithMargins(childAt, i2, this.f2283e, i3, this.f2284f);
                int measuredWidth = childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                if ((layoutParams2.f2287a & 1) == 1) {
                    this.f2284f += i5;
                    i5 = 0;
                }
                i5 = Math.max(measuredHeight, i5);
                int i7 = this.f2283e + measuredWidth;
                this.f2283e = i7;
                this.f2285g = Math.max(this.f2285g, i7);
                if ((layoutParams2.f2287a & 2) == 2) {
                    this.f2283e = 0;
                    this.f2284f += i5;
                    i5 = 0;
                }
            }
        }
        int i8 = this.f2284f + i5;
        this.f2284f = i8;
        this.f2286h = i8;
    }

    public final void g(int i2, int i3) {
        int i4 = i3 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != null && childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                }
                LayoutParams layoutParams2 = layoutParams;
                if (i4 <= this.f2284f || (layoutParams2.f2287a & 1) == 1) {
                    this.f2284f = 0;
                }
                measureChildWithMargins(childAt, i2, this.f2283e, i3, this.f2284f);
                i5 = Math.max(childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin, i5);
                this.f2283e = i5;
                int measuredHeight = this.f2284f + childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin;
                this.f2284f = measuredHeight;
                this.f2286h = Math.max(measuredHeight, this.f2286h);
                if ((layoutParams2.f2287a & 2) != 2) {
                    if ((layoutParams2.f2287a & 1) == 1) {
                        this.f2283e += i5;
                    }
                } else {
                    this.f2284f = 0;
                    this.f2283e += i5;
                }
                i5 = 0;
            }
        }
        this.f2285g = this.f2283e;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int orientation = getOrientation();
        if (orientation == 0) {
            d();
        } else if (orientation == 1) {
            e();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        this.f2283e = 0;
        this.f2284f = 0;
        if (getOrientation() == 1) {
            g(i2, i3);
        } else if (getOrientation() == 0) {
            f(i2, i3);
        }
        setMeasuredDimension(this.f2285g + getPaddingLeft() + getPaddingRight(), this.f2286h + getPaddingTop() + getPaddingBottom());
    }

    public FloatingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f2287a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2287a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingLayout_Layout);
            String string = obtainStyledAttributes.getString(R.styleable.FloatingLayout_Layout_layout_clear);
            if (string != null) {
                if ("before".equals(string)) {
                    this.f2287a = 1;
                } else if ("after".equals(string)) {
                    this.f2287a = 2;
                } else if (ShareDirectionType.BOTH.equals(string)) {
                    this.f2287a = 3;
                }
            }
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.f2287a = 0;
        }

        public LayoutParams(int i2, int i3, int i4) {
            super(i2, i3);
            this.f2287a = 0;
            this.f2287a = i4;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2287a = 0;
        }
    }
}
