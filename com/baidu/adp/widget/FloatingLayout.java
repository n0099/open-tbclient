package com.baidu.adp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class FloatingLayout extends LinearLayout {
    private int uv;
    private int uw;
    private int ux;
    private int uy;

    public FloatingLayout(Context context) {
        this(context, null);
    }

    public FloatingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.uv = 0;
        this.uw = 0;
        if (getOrientation() == 1) {
            e(i, i2);
        } else if (getOrientation() == 0) {
            f(i, i2);
        }
        setMeasuredDimension(this.ux + getPaddingLeft() + getPaddingRight(), this.uy + getPaddingTop() + getPaddingBottom());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        if ((r0 & 1) == 1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void e(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i2 & 1073741823;
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt == null) {
                i3 = i9;
            } else if (childAt.getVisibility() == 8) {
                i3 = i9;
            } else {
                e eVar = (e) childAt.getLayoutParams();
                e generateDefaultLayoutParams = eVar == null ? generateDefaultLayoutParams() : eVar;
                if (i7 > this.uw) {
                    i6 = generateDefaultLayoutParams.uz;
                }
                this.uw = 0;
                measureChildWithMargins(childAt, i, this.uv, i2, this.uw);
                i3 = Math.max(childAt.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin, i9);
                this.uv = i3;
                this.uw = childAt.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin + this.uw;
                this.uy = Math.max(this.uw, this.uy);
                i4 = generateDefaultLayoutParams.uz;
                if ((i4 & 2) == 2) {
                    this.uw = 0;
                    this.uv = i3 + this.uv;
                    i3 = 0;
                } else {
                    i5 = generateDefaultLayoutParams.uz;
                    if ((i5 & 1) == 1) {
                        this.uv = i3 + this.uv;
                        i3 = 0;
                    }
                }
            }
            i8++;
            i9 = i3;
        }
        this.ux = this.uv;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        if ((r0 & 1) == 1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void f(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = i & 1073741823;
        int childCount = getChildCount();
        int i8 = 0;
        int i9 = 0;
        while (i8 < childCount) {
            View childAt = getChildAt(i8);
            if (childAt == null) {
                i3 = i9;
            } else if (childAt.getVisibility() == 8) {
                i3 = i9;
            } else {
                e eVar = (e) childAt.getLayoutParams();
                e generateDefaultLayoutParams = eVar == null ? generateDefaultLayoutParams() : eVar;
                if (i7 > this.uv) {
                    i6 = generateDefaultLayoutParams.uz;
                }
                this.uv = 0;
                measureChildWithMargins(childAt, i, this.uv, i2, this.uw);
                int measuredWidth = generateDefaultLayoutParams.rightMargin + childAt.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin;
                i3 = Math.max(childAt.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin, i9);
                this.uw = i3;
                this.uv += measuredWidth;
                this.ux = Math.max(this.ux, this.uv);
                i4 = generateDefaultLayoutParams.uz;
                if ((i4 & 2) == 2) {
                    this.uv = 0;
                    this.uw = i3 + this.uw;
                    i3 = 0;
                } else {
                    i5 = generateDefaultLayoutParams.uz;
                    if ((i5 & 1) == 1) {
                        this.uw = i3 + this.uw;
                        i3 = 0;
                    }
                }
            }
            i8++;
            i9 = i3;
        }
        this.uy = this.uw;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int orientation = getOrientation();
        if (orientation == 0) {
            iO();
        } else if (orientation == 1) {
            iP();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005a, code lost:
        if ((r10 & 1) == 1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void iO() {
        int i;
        int i2;
        int childCount = getChildCount();
        int measuredWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt != null && childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                if (eVar == null) {
                    eVar = generateDefaultLayoutParams();
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + eVar.leftMargin + eVar.rightMargin;
                int measuredHeight = eVar.topMargin + eVar.bottomMargin + childAt.getMeasuredHeight();
                if (measuredWidth - paddingLeft >= measuredWidth2) {
                    i2 = eVar.uz;
                }
                paddingLeft = getPaddingLeft();
                paddingTop += i3;
                i3 = 0;
                childAt.layout(eVar.leftMargin + paddingLeft, eVar.topMargin + paddingTop, eVar.leftMargin + paddingLeft + childAt.getMeasuredWidth(), eVar.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingLeft += measuredWidth2;
                if (measuredHeight > i3) {
                    i3 = measuredHeight;
                }
                i = eVar.uz;
                if ((i & 2) == 2) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += i3;
                    i3 = 0;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0056, code lost:
        if ((r10 & 1) == 1) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void iP() {
        e eVar;
        int i;
        int i2;
        int childCount = getChildCount();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt != null && childAt.getVisibility() != 8 && (eVar = (e) childAt.getLayoutParams()) != null) {
                int measuredWidth = eVar.leftMargin + eVar.rightMargin + childAt.getMeasuredWidth();
                int measuredHeight2 = eVar.topMargin + eVar.bottomMargin + childAt.getMeasuredHeight();
                if (measuredHeight - paddingTop >= measuredHeight2) {
                    i2 = eVar.uz;
                }
                paddingLeft += i3;
                paddingTop = getPaddingTop();
                i3 = 0;
                childAt.layout(eVar.leftMargin + paddingLeft, eVar.topMargin + paddingTop, eVar.leftMargin + paddingLeft + childAt.getMeasuredWidth(), eVar.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingTop += measuredHeight2;
                if (measuredWidth > i3) {
                    i3 = measuredWidth;
                }
                i = eVar.uz;
                if ((i & 2) == 2) {
                    paddingLeft += i3;
                    paddingTop = getPaddingTop();
                    i3 = 0;
                }
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: b */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: iQ */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2, 0);
    }
}
