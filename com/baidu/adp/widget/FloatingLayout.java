package com.baidu.adp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class FloatingLayout extends LinearLayout {
    private int a;
    private int b;
    private int c;
    private int d;

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* synthetic */ LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return a();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public FloatingLayout(Context context) {
        this(context, null);
    }

    public FloatingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
        if ((r0 & 1) == 1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0101, code lost:
        if ((r0 & 1) == 1) goto L60;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        this.a = 0;
        this.b = 0;
        if (getOrientation() == 1) {
            int i11 = 0;
            int i12 = i2 & 1073741823;
            int childCount = getChildCount();
            int i13 = 0;
            while (i13 < childCount) {
                View childAt = getChildAt(i13);
                if (childAt == null || childAt.getVisibility() == 8) {
                    i7 = i11;
                } else {
                    e eVar = (e) childAt.getLayoutParams();
                    e a = eVar == null ? a() : eVar;
                    if (i12 > this.b) {
                        i10 = a.a;
                    }
                    this.b = 0;
                    measureChildWithMargins(childAt, i, this.a, i2, this.b);
                    i7 = Math.max(childAt.getMeasuredWidth() + a.leftMargin + a.rightMargin, i11);
                    this.a = i7;
                    this.b = childAt.getMeasuredHeight() + a.topMargin + a.bottomMargin + this.b;
                    this.d = Math.max(this.b, this.d);
                    i8 = a.a;
                    if ((i8 & 2) == 2) {
                        this.b = 0;
                        this.a = i7 + this.a;
                        i7 = 0;
                    } else {
                        i9 = a.a;
                        if ((i9 & 1) == 1) {
                            this.a = i7 + this.a;
                            i7 = 0;
                        }
                    }
                }
                i13++;
                i11 = i7;
            }
            this.c = this.a;
        } else if (getOrientation() == 0) {
            int i14 = 0;
            int i15 = i & 1073741823;
            int childCount2 = getChildCount();
            int i16 = 0;
            while (i16 < childCount2) {
                View childAt2 = getChildAt(i16);
                if (childAt2 == null || childAt2.getVisibility() == 8) {
                    i3 = i14;
                } else {
                    e eVar2 = (e) childAt2.getLayoutParams();
                    e a2 = eVar2 == null ? a() : eVar2;
                    if (i15 > this.a) {
                        i6 = a2.a;
                    }
                    this.a = 0;
                    measureChildWithMargins(childAt2, i, this.a, i2, this.b);
                    int measuredWidth = a2.rightMargin + childAt2.getMeasuredWidth() + a2.leftMargin;
                    i3 = Math.max(childAt2.getMeasuredHeight() + a2.topMargin + a2.bottomMargin, i14);
                    this.b = i3;
                    this.a += measuredWidth;
                    this.c = Math.max(this.c, this.a);
                    i4 = a2.a;
                    if ((i4 & 2) == 2) {
                        this.a = 0;
                        this.b = i3 + this.b;
                        i3 = 0;
                    } else {
                        i5 = a2.a;
                        if ((i5 & 1) == 1) {
                            this.b = i3 + this.b;
                            i3 = 0;
                        }
                    }
                }
                i16++;
                i14 = i3;
            }
            this.d = this.b;
        }
        setMeasuredDimension(this.c + getPaddingLeft() + getPaddingRight(), this.d + getPaddingTop() + getPaddingBottom());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
        if ((r10 & 1) == 1) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00f0, code lost:
        if ((r10 & 1) == 1) goto L55;
     */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        e eVar;
        int i5;
        int i6;
        int i7;
        int i8;
        int orientation = getOrientation();
        if (orientation == 0) {
            int childCount = getChildCount();
            int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int i9 = 0;
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (childAt != null && childAt.getVisibility() != 8) {
                    e eVar2 = (e) childAt.getLayoutParams();
                    if (eVar2 == null) {
                        eVar2 = a();
                    }
                    int measuredWidth2 = childAt.getMeasuredWidth() + eVar2.leftMargin + eVar2.rightMargin;
                    int measuredHeight = eVar2.topMargin + eVar2.bottomMargin + childAt.getMeasuredHeight();
                    if (measuredWidth - paddingLeft >= measuredWidth2) {
                        i8 = eVar2.a;
                    }
                    paddingLeft = getPaddingLeft();
                    paddingTop += i9;
                    i9 = 0;
                    childAt.layout(eVar2.leftMargin + paddingLeft, eVar2.topMargin + paddingTop, eVar2.leftMargin + paddingLeft + childAt.getMeasuredWidth(), eVar2.topMargin + paddingTop + childAt.getMeasuredHeight());
                    paddingLeft += measuredWidth2;
                    if (measuredHeight > i9) {
                        i9 = measuredHeight;
                    }
                    i7 = eVar2.a;
                    if ((i7 & 2) == 2) {
                        paddingLeft = getPaddingLeft();
                        paddingTop += i9;
                        i9 = 0;
                    }
                }
            }
        } else if (orientation == 1) {
            int childCount2 = getChildCount();
            int measuredHeight2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            int paddingLeft2 = getPaddingLeft();
            int paddingTop2 = getPaddingTop();
            int i11 = 0;
            for (int i12 = 0; i12 < childCount2; i12++) {
                View childAt2 = getChildAt(i12);
                if (childAt2 != null && childAt2.getVisibility() != 8 && (eVar = (e) childAt2.getLayoutParams()) != null) {
                    int measuredWidth3 = eVar.leftMargin + eVar.rightMargin + childAt2.getMeasuredWidth();
                    int measuredHeight3 = eVar.topMargin + eVar.bottomMargin + childAt2.getMeasuredHeight();
                    if (measuredHeight2 - paddingTop2 >= measuredHeight3) {
                        i6 = eVar.a;
                    }
                    paddingLeft2 += i11;
                    paddingTop2 = getPaddingTop();
                    i11 = 0;
                    childAt2.layout(eVar.leftMargin + paddingLeft2, eVar.topMargin + paddingTop2, eVar.leftMargin + paddingLeft2 + childAt2.getMeasuredWidth(), eVar.topMargin + paddingTop2 + childAt2.getMeasuredHeight());
                    paddingTop2 += measuredHeight3;
                    if (measuredWidth3 > i11) {
                        i11 = measuredWidth3;
                    }
                    i5 = eVar.a;
                    if ((i5 & 2) == 2) {
                        paddingLeft2 += i11;
                        paddingTop2 = getPaddingTop();
                        i11 = 0;
                    }
                }
            }
        }
    }

    private static e a() {
        return new e(-2, -2, 0);
    }
}
