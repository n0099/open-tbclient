package com.baidu.tbadk.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class WrapLineLayout extends ViewGroup {
    private List<List<View>> fmF;
    private List<Integer> fmG;

    public WrapLineLayout(Context context) {
        super(context);
        this.fmF = new ArrayList();
        this.fmG = new ArrayList();
    }

    public WrapLineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fmF = new ArrayList();
        this.fmG = new ArrayList();
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
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int childCount = getChildCount();
        int i8 = 0;
        while (true) {
            int i9 = i8;
            int i10 = i7;
            int i11 = i6;
            if (i9 >= childCount) {
                break;
            }
            View childAt = getChildAt(i9);
            measureChild(childAt, i, i2);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            i6 = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            i7 = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            if (i11 + i6 > paddingLeft) {
                i4 = Math.max(i11, i6);
                i3 = i5 + i10;
            } else {
                i6 += i11;
                i7 = Math.max(i10, i7);
                i3 = i5;
            }
            if (i9 == childCount - 1) {
                i4 = Math.max(i4, i6);
                i3 += i7;
            }
            i5 = getPaddingBottom() + i3 + getPaddingTop();
            i8 = i9 + 1;
        }
        if (mode == 1073741824) {
            i4 = size;
        }
        setMeasuredDimension(i4, mode2 == 1073741824 ? size2 : i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.fmF.clear();
        this.fmG.clear();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        int i5 = 0;
        int i6 = 0;
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin + i5 > width) {
                this.fmG.add(Integer.valueOf(i6));
                this.fmF.add(arrayList);
                i5 = 0;
                arrayList = new ArrayList();
            }
            i5 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            i6 = Math.max(i6, marginLayoutParams.bottomMargin + marginLayoutParams.topMargin + measuredHeight);
            arrayList.add(childAt);
        }
        this.fmG.add(Integer.valueOf(i6));
        this.fmF.add(arrayList);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.fmF.size();
        int i8 = 0;
        int i9 = paddingTop;
        while (i8 < size) {
            List<View> list = this.fmF.get(i8);
            int intValue = this.fmG.get(i8).intValue();
            int i10 = 0;
            while (true) {
                int i11 = i10;
                int i12 = paddingLeft;
                if (i11 < list.size()) {
                    View view = list.get(i11);
                    if (view.getVisibility() == 8) {
                        paddingLeft = i12;
                    } else {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i13 = marginLayoutParams2.leftMargin + i12;
                        int i14 = marginLayoutParams2.topMargin + i9;
                        view.layout(i13, i14, view.getMeasuredWidth() + i13, view.getMeasuredHeight() + i14);
                        paddingLeft = i12 + view.getMeasuredWidth() + marginLayoutParams2.rightMargin + marginLayoutParams2.leftMargin;
                    }
                    i10 = i11 + 1;
                }
            }
            paddingLeft = getPaddingLeft();
            i8++;
            i9 += intValue;
        }
    }
}
