package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class WrapLineLayout extends ViewGroup {

    /* renamed from: e  reason: collision with root package name */
    public List<List<View>> f13594e;

    /* renamed from: f  reason: collision with root package name */
    public List<Integer> f13595f;

    public WrapLineLayout(Context context) {
        super(context);
        this.f13594e = new ArrayList();
        this.f13595f = new ArrayList();
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f13594e.clear();
        this.f13595f.clear();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin + i6 > width) {
                this.f13595f.add(Integer.valueOf(i5));
                this.f13594e.add(arrayList);
                arrayList = new ArrayList();
                i6 = 0;
            }
            i6 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            i5 = Math.max(i5, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            arrayList.add(childAt);
        }
        this.f13595f.add(Integer.valueOf(i5));
        this.f13594e.add(arrayList);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f13594e.size();
        for (int i8 = 0; i8 < size; i8++) {
            List<View> list = this.f13594e.get(i8);
            int intValue = this.f13595f.get(i8).intValue();
            for (int i9 = 0; i9 < list.size(); i9++) {
                View view = list.get(i9);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i10 = marginLayoutParams2.leftMargin + paddingLeft;
                    int i11 = marginLayoutParams2.topMargin + paddingTop;
                    view.layout(i10, i11, view.getMeasuredWidth() + i10, view.getMeasuredHeight() + i11);
                    paddingLeft += view.getMeasuredWidth() + marginLayoutParams2.rightMargin + marginLayoutParams2.leftMargin;
                }
            }
            paddingLeft = getPaddingLeft();
            paddingTop += intValue;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i3 < childCount) {
            View childAt = getChildAt(i3);
            measureChild(childAt, i, i2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int i8 = size;
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int i9 = size2;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i10 = i4 + measuredWidth;
            if (i10 > paddingLeft) {
                i5 = Math.max(i4, measuredWidth);
                i7 += i6;
                i4 = measuredWidth;
                i6 = measuredHeight;
            } else {
                i6 = Math.max(i6, measuredHeight);
                i4 = i10;
            }
            if (i3 == childCount - 1) {
                i7 += i6;
                i5 = Math.max(i5, i4);
            }
            i7 = i7 + getPaddingTop() + getPaddingBottom();
            i3++;
            size2 = i9;
            size = i8;
        }
        int i11 = size;
        int i12 = size2;
        if (mode == 1073741824) {
            i5 = i11;
        }
        setMeasuredDimension(i5, mode2 == 1073741824 ? i12 : i7);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public WrapLineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13594e = new ArrayList();
        this.f13595f = new ArrayList();
    }
}
