package com.baidu.adp.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class FloatingLayout extends LinearLayout {
    private int Fv;
    private int Fw;
    private int Fx;
    private int Fy;

    public FloatingLayout(Context context) {
        this(context, null);
    }

    public FloatingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.Fv = 0;
        this.Fw = 0;
        if (getOrientation() == 1) {
            d(i, i2);
        } else if (getOrientation() == 0) {
            e(i, i2);
        }
        setMeasuredDimension(this.Fx + getPaddingLeft() + getPaddingRight(), this.Fy + getPaddingTop() + getPaddingBottom());
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        if ((r0 & 1) == 1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(int i, int i2) {
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
                f fVar = (f) childAt.getLayoutParams();
                f generateDefaultLayoutParams = fVar == null ? generateDefaultLayoutParams() : fVar;
                if (i7 > this.Fw) {
                    i6 = generateDefaultLayoutParams.Fz;
                }
                this.Fw = 0;
                measureChildWithMargins(childAt, i, this.Fv, i2, this.Fw);
                i3 = Math.max(childAt.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin, i9);
                this.Fv = i3;
                this.Fw = childAt.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin + this.Fw;
                this.Fy = Math.max(this.Fw, this.Fy);
                i4 = generateDefaultLayoutParams.Fz;
                if ((i4 & 2) == 2) {
                    this.Fw = 0;
                    this.Fv = i3 + this.Fv;
                    i3 = 0;
                } else {
                    i5 = generateDefaultLayoutParams.Fz;
                    if ((i5 & 1) == 1) {
                        this.Fv = i3 + this.Fv;
                        i3 = 0;
                    }
                }
            }
            i8++;
            i9 = i3;
        }
        this.Fx = this.Fv;
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
                f fVar = (f) childAt.getLayoutParams();
                f generateDefaultLayoutParams = fVar == null ? generateDefaultLayoutParams() : fVar;
                if (i7 > this.Fv) {
                    i6 = generateDefaultLayoutParams.Fz;
                }
                this.Fv = 0;
                measureChildWithMargins(childAt, i, this.Fv, i2, this.Fw);
                int measuredWidth = generateDefaultLayoutParams.rightMargin + childAt.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin;
                i3 = Math.max(childAt.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin, i9);
                this.Fw = i3;
                this.Fv += measuredWidth;
                this.Fx = Math.max(this.Fx, this.Fv);
                i4 = generateDefaultLayoutParams.Fz;
                if ((i4 & 2) == 2) {
                    this.Fv = 0;
                    this.Fw = i3 + this.Fw;
                    i3 = 0;
                } else {
                    i5 = generateDefaultLayoutParams.Fz;
                    if ((i5 & 1) == 1) {
                        this.Fw = i3 + this.Fw;
                        i3 = 0;
                    }
                }
            }
            i8++;
            i9 = i3;
        }
        this.Fy = this.Fw;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int orientation = getOrientation();
        if (orientation == 0) {
            mf();
        } else if (orientation == 1) {
            mg();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x005a, code lost:
        if ((r10 & 1) == 1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void mf() {
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
                f fVar = (f) childAt.getLayoutParams();
                if (fVar == null) {
                    fVar = generateDefaultLayoutParams();
                }
                int measuredWidth2 = childAt.getMeasuredWidth() + fVar.leftMargin + fVar.rightMargin;
                int measuredHeight = fVar.topMargin + fVar.bottomMargin + childAt.getMeasuredHeight();
                if (measuredWidth - paddingLeft >= measuredWidth2) {
                    i2 = fVar.Fz;
                }
                paddingLeft = getPaddingLeft();
                paddingTop += i3;
                i3 = 0;
                childAt.layout(fVar.leftMargin + paddingLeft, fVar.topMargin + paddingTop, fVar.leftMargin + paddingLeft + childAt.getMeasuredWidth(), fVar.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingLeft += measuredWidth2;
                if (measuredHeight > i3) {
                    i3 = measuredHeight;
                }
                i = fVar.Fz;
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
    private void mg() {
        f fVar;
        int i;
        int i2;
        int childCount = getChildCount();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i3 = 0;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt != null && childAt.getVisibility() != 8 && (fVar = (f) childAt.getLayoutParams()) != null) {
                int measuredWidth = fVar.leftMargin + fVar.rightMargin + childAt.getMeasuredWidth();
                int measuredHeight2 = fVar.topMargin + fVar.bottomMargin + childAt.getMeasuredHeight();
                if (measuredHeight - paddingTop >= measuredHeight2) {
                    i2 = fVar.Fz;
                }
                paddingLeft += i3;
                paddingTop = getPaddingTop();
                i3 = 0;
                childAt.layout(fVar.leftMargin + paddingLeft, fVar.topMargin + paddingTop, fVar.leftMargin + paddingLeft + childAt.getMeasuredWidth(), fVar.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingTop += measuredHeight2;
                if (measuredWidth > i3) {
                    i3 = measuredWidth;
                }
                i = fVar.Fz;
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
    public f generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new f(layoutParams);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: b */
    public f generateLayoutParams(AttributeSet attributeSet) {
        return new f(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: mh */
    public f generateDefaultLayoutParams() {
        return new f(-2, -2, 0);
    }
}
