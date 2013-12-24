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

    public FloatingLayout(Context context) {
        this(context, null);
    }

    public FloatingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.a = 0;
        this.b = 0;
        if (getOrientation() == 1) {
            a(i, i2);
        } else if (getOrientation() == 0) {
            b(i, i2);
        }
        setMeasuredDimension(this.c + getPaddingLeft() + getPaddingRight(), this.d + getPaddingTop() + getPaddingBottom());
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
        if ((r0 & 1) == 1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(int i, int i2) {
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
                if (i7 > this.b) {
                    i6 = generateDefaultLayoutParams.a;
                }
                this.b = 0;
                measureChildWithMargins(childAt, i, this.a, i2, this.b);
                i3 = Math.max(childAt.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin, i9);
                this.a = i3;
                this.b = childAt.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin + this.b;
                this.d = Math.max(this.b, this.d);
                i4 = generateDefaultLayoutParams.a;
                if ((i4 & 2) == 2) {
                    this.b = 0;
                    this.a = i3 + this.a;
                    i3 = 0;
                } else {
                    i5 = generateDefaultLayoutParams.a;
                    if ((i5 & 1) == 1) {
                        this.a = i3 + this.a;
                        i3 = 0;
                    }
                }
            }
            i8++;
            i9 = i3;
        }
        this.c = this.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
        if ((r0 & 1) == 1) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(int i, int i2) {
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
                if (i7 > this.a) {
                    i6 = generateDefaultLayoutParams.a;
                }
                this.a = 0;
                measureChildWithMargins(childAt, i, this.a, i2, this.b);
                int measuredWidth = generateDefaultLayoutParams.rightMargin + childAt.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin;
                i3 = Math.max(childAt.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin, i9);
                this.b = i3;
                this.a += measuredWidth;
                this.c = Math.max(this.c, this.a);
                i4 = generateDefaultLayoutParams.a;
                if ((i4 & 2) == 2) {
                    this.a = 0;
                    this.b = i3 + this.b;
                    i3 = 0;
                } else {
                    i5 = generateDefaultLayoutParams.a;
                    if ((i5 & 1) == 1) {
                        this.b = i3 + this.b;
                        i3 = 0;
                    }
                }
            }
            i8++;
            i9 = i3;
        }
        this.d = this.b;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int orientation = getOrientation();
        if (orientation == 0) {
            b();
        } else if (orientation == 1) {
            c();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0059, code lost:
        if ((r10 & 1) == 1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b() {
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
                    i2 = eVar.a;
                }
                paddingLeft = getPaddingLeft();
                paddingTop += i3;
                i3 = 0;
                childAt.layout(eVar.leftMargin + paddingLeft, eVar.topMargin + paddingTop, eVar.leftMargin + paddingLeft + childAt.getMeasuredWidth(), eVar.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingLeft += measuredWidth2;
                if (measuredHeight > i3) {
                    i3 = measuredHeight;
                }
                i = eVar.a;
                if ((i & 2) == 2) {
                    paddingLeft = getPaddingLeft();
                    paddingTop += i3;
                    i3 = 0;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0055, code lost:
        if ((r10 & 1) == 1) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void c() {
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
                    i2 = eVar.a;
                }
                paddingLeft += i3;
                paddingTop = getPaddingTop();
                i3 = 0;
                childAt.layout(eVar.leftMargin + paddingLeft, eVar.topMargin + paddingTop, eVar.leftMargin + paddingLeft + childAt.getMeasuredWidth(), eVar.topMargin + paddingTop + childAt.getMeasuredHeight());
                paddingTop += measuredHeight2;
                if (measuredWidth > i3) {
                    i3 = measuredWidth;
                }
                i = eVar.a;
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
    /* renamed from: a */
    public e generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2, 0);
    }
}
