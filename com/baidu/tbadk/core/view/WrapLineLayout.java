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
    public List<List<View>> f12528e;

    /* renamed from: f  reason: collision with root package name */
    public List<Integer> f12529f;

    public WrapLineLayout(Context context) {
        super(context);
        this.f12528e = new ArrayList();
        this.f12529f = new ArrayList();
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
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        this.f12528e.clear();
        this.f12529f.clear();
        int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
        ArrayList arrayList = new ArrayList();
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            if (marginLayoutParams.leftMargin + measuredWidth + marginLayoutParams.rightMargin + i7 > width) {
                this.f12529f.add(Integer.valueOf(i6));
                this.f12528e.add(arrayList);
                arrayList = new ArrayList();
                i7 = 0;
            }
            i7 += measuredWidth + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            i6 = Math.max(i6, measuredHeight + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            arrayList.add(childAt);
        }
        this.f12529f.add(Integer.valueOf(i6));
        this.f12528e.add(arrayList);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int size = this.f12528e.size();
        for (int i9 = 0; i9 < size; i9++) {
            List<View> list = this.f12528e.get(i9);
            int intValue = this.f12529f.get(i9).intValue();
            for (int i10 = 0; i10 < list.size(); i10++) {
                View view = list.get(i10);
                if (view.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                    int i11 = marginLayoutParams2.leftMargin + paddingLeft;
                    int i12 = marginLayoutParams2.topMargin + paddingTop;
                    view.layout(i11, i12, view.getMeasuredWidth() + i11, view.getMeasuredHeight() + i12);
                    paddingLeft += view.getMeasuredWidth() + marginLayoutParams2.rightMargin + marginLayoutParams2.leftMargin;
                }
            }
            paddingLeft = getPaddingLeft();
            paddingTop += intValue;
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int childCount = getChildCount();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i4 < childCount) {
            View childAt = getChildAt(i4);
            measureChild(childAt, i2, i3);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int i9 = size;
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int i10 = size2;
            int measuredHeight = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            int i11 = i5 + measuredWidth;
            if (i11 > paddingLeft) {
                i6 = Math.max(i5, measuredWidth);
                i8 += i7;
                i5 = measuredWidth;
                i7 = measuredHeight;
            } else {
                i7 = Math.max(i7, measuredHeight);
                i5 = i11;
            }
            if (i4 == childCount - 1) {
                i8 += i7;
                i6 = Math.max(i6, i5);
            }
            i8 = i8 + getPaddingTop() + getPaddingBottom();
            i4++;
            size2 = i10;
            size = i9;
        }
        int i12 = size;
        int i13 = size2;
        if (mode == 1073741824) {
            i6 = i12;
        }
        setMeasuredDimension(i6, mode2 == 1073741824 ? i13 : i8);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public WrapLineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f12528e = new ArrayList();
        this.f12529f = new ArrayList();
    }
}
