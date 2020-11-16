package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class WrapLineLayout extends ViewGroup {
    private List<List<View>> eXR;
    private List<Integer> eXS;

    public WrapLineLayout(Context context) {
        super(context);
        this.eXR = new ArrayList();
        this.eXS = new ArrayList();
    }

    public WrapLineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eXR = new ArrayList();
        this.eXS = new ArrayList();
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -1);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i6 = 0;
        int childCount = getChildCount();
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i10 < childCount) {
            View childAt = getChildAt(i10);
            measureChild(childAt, i, i2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int measuredHeight = marginLayoutParams.bottomMargin + childAt.getMeasuredHeight() + marginLayoutParams.topMargin;
            if (i8 + measuredWidth > paddingLeft) {
                i3 = i6 + i7;
                i4 = Math.max(i8, measuredWidth);
                i5 = measuredHeight;
            } else {
                measuredWidth += i8;
                int max = Math.max(i7, measuredHeight);
                i3 = i6;
                i4 = i9;
                i5 = max;
            }
            if (i10 == childCount - 1) {
                i4 = Math.max(i4, measuredWidth);
                i3 += i5;
            }
            i10++;
            i8 = measuredWidth;
            int i11 = i5;
            i9 = i4;
            i6 = getPaddingBottom() + i3 + getPaddingTop();
            i7 = i11;
        }
        if (mode != 1073741824) {
            size = i9;
        }
        setMeasuredDimension(size, mode2 == 1073741824 ? size2 : i6);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.eXR.clear();
        this.eXS.clear();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin + i6 > width) {
                this.eXS.add(Integer.valueOf(i5));
                this.eXR.add(arrayList);
                i6 = 0;
                arrayList = new ArrayList();
            }
            int i8 = measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6;
            int max = Math.max(i5, marginLayoutParams.bottomMargin + marginLayoutParams.topMargin + measuredHeight);
            arrayList.add(childAt);
            i7++;
            i5 = max;
            i6 = i8;
        }
        this.eXS.add(Integer.valueOf(i5));
        this.eXR.add(arrayList);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.eXR.size();
        int i9 = 0;
        int i10 = paddingTop;
        int i11 = paddingLeft;
        while (i9 < size) {
            List<View> list = this.eXR.get(i9);
            int intValue = this.eXS.get(i9).intValue();
            int i12 = 0;
            while (true) {
                int i13 = i12;
                int i14 = i11;
                if (i13 < list.size()) {
                    View view = list.get(i13);
                    if (view.getVisibility() == 8) {
                        i11 = i14;
                    } else {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i15 = marginLayoutParams2.leftMargin + i14;
                        int i16 = marginLayoutParams2.topMargin + i10;
                        view.layout(i15, i16, view.getMeasuredWidth() + i15, view.getMeasuredHeight() + i16);
                        i11 = i14 + view.getMeasuredWidth() + marginLayoutParams2.rightMargin + marginLayoutParams2.leftMargin;
                    }
                    i12 = i13 + 1;
                }
            }
            i9++;
            i10 += intValue;
            i11 = getPaddingLeft();
        }
    }
}
