package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class ColumnLayout extends ViewGroup {
    public static final Pattern l = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");

    /* renamed from: e  reason: collision with root package name */
    public final List<View> f2245e;

    /* renamed from: f  reason: collision with root package name */
    public final List<View> f2246f;

    /* renamed from: g  reason: collision with root package name */
    public final List<View> f2247g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f2248h;
    public int i;
    public int j;
    public final int[] k;

    public ColumnLayout(Context context) {
        this(context, null, 0);
    }

    public final void a(View view, int i) {
        if (i == 1) {
            if (this.f2245e.contains(view)) {
                return;
            }
            this.f2245e.add(view);
        } else if (i != 2) {
            if (i == 3 && !this.f2247g.contains(view)) {
                this.f2247g.add(view);
            }
        } else if (this.f2246f.contains(view)) {
        } else {
            this.f2246f.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = generateDefaultLayoutParams();
        }
        a(view, layoutParams2.f2249a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2, 51, 1);
    }

    public final void c(int i, List<View> list, int i2, int i3, int i4) {
        int measuredHeight;
        int i5;
        int measuredWidth;
        int i6;
        if (i < 1 || i > 3) {
            return;
        }
        int i7 = this.f2248h[i - 1];
        int measuredHeight2 = getMeasuredHeight();
        for (View view : list) {
            if (view.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                }
                int i8 = ((FrameLayout.LayoutParams) layoutParams).gravity;
                int i9 = i7 == 1 ? i8 & 7 : i8 & 112;
                if (i9 == 1) {
                    int i10 = i3 + ((FrameLayout.LayoutParams) layoutParams).topMargin;
                    measuredHeight = view.getMeasuredHeight() + i10;
                    view.layout(((((i4 - ((FrameLayout.LayoutParams) layoutParams).leftMargin) - ((FrameLayout.LayoutParams) layoutParams).rightMargin) - view.getMeasuredWidth()) + i2) >> 1, i10, ((((i4 - ((FrameLayout.LayoutParams) layoutParams).leftMargin) - ((FrameLayout.LayoutParams) layoutParams).rightMargin) + view.getMeasuredWidth()) + i2) >> 1, measuredHeight);
                    i5 = ((FrameLayout.LayoutParams) layoutParams).bottomMargin;
                } else if (i9 == 3) {
                    int i11 = ((FrameLayout.LayoutParams) layoutParams).leftMargin;
                    int i12 = i2 + i11;
                    int i13 = i3 + ((FrameLayout.LayoutParams) layoutParams).topMargin;
                    int measuredWidth2 = i11 + i2 + view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight() + i13;
                    view.layout(i12, i13, measuredWidth2, measuredHeight);
                    i5 = ((FrameLayout.LayoutParams) layoutParams).bottomMargin;
                } else if (i9 != 5) {
                    if (i9 == 16) {
                        int i14 = i2 + ((FrameLayout.LayoutParams) layoutParams).leftMargin;
                        measuredWidth = view.getMeasuredWidth() + i14;
                        view.layout(i14, ((((measuredHeight2 - ((FrameLayout.LayoutParams) layoutParams).topMargin) - ((FrameLayout.LayoutParams) layoutParams).bottomMargin) - view.getMeasuredHeight()) + i3) >> 1, measuredWidth, ((((measuredHeight2 - ((FrameLayout.LayoutParams) layoutParams).topMargin) - ((FrameLayout.LayoutParams) layoutParams).bottomMargin) + view.getMeasuredHeight()) + i3) >> 1);
                        i6 = ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                    } else if (i9 == 48) {
                        int i15 = i2 + ((FrameLayout.LayoutParams) layoutParams).leftMargin;
                        measuredWidth = view.getMeasuredWidth() + i15;
                        view.layout(i15, ((FrameLayout.LayoutParams) layoutParams).topMargin + i3, measuredWidth, ((FrameLayout.LayoutParams) layoutParams).topMargin + i3 + view.getMeasuredHeight());
                        i6 = ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                    } else if (i9 == 80) {
                        int i16 = i2 + ((FrameLayout.LayoutParams) layoutParams).leftMargin;
                        int i17 = i3 + measuredHeight2;
                        int measuredHeight3 = (i17 - ((FrameLayout.LayoutParams) layoutParams).bottomMargin) - view.getMeasuredHeight();
                        int measuredWidth3 = view.getMeasuredWidth() + i16;
                        view.layout(i16, measuredHeight3, measuredWidth3, i17 - ((FrameLayout.LayoutParams) layoutParams).bottomMargin);
                        i2 = measuredWidth3 + ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                    }
                    i2 = measuredWidth + i6;
                } else {
                    int i18 = i2 + i4;
                    int measuredWidth4 = (i18 - ((FrameLayout.LayoutParams) layoutParams).rightMargin) - view.getMeasuredWidth();
                    int i19 = i3 + ((FrameLayout.LayoutParams) layoutParams).topMargin;
                    int i20 = i18 - ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                    measuredHeight = view.getMeasuredHeight() + i19;
                    view.layout(measuredWidth4, i19, i20, measuredHeight);
                    i5 = ((FrameLayout.LayoutParams) layoutParams).bottomMargin;
                }
                i3 = measuredHeight + i5;
            }
        }
    }

    public final int d(String str) {
        return "vertical".equals(str) ? 1 : 0;
    }

    public final void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColumnLayout);
        String string = obtainStyledAttributes.getString(R.styleable.ColumnLayout_columnOrientation);
        if (string == null) {
            string = "vertical";
        }
        if (l.matcher(string).matches()) {
            this.f2248h = new int[3];
            String[] split = string.split("\\|");
            if (split.length == 1) {
                int d2 = d(split[0]);
                int i = 0;
                while (true) {
                    int[] iArr = this.f2248h;
                    if (i >= iArr.length) {
                        break;
                    }
                    iArr[i] = d2;
                    i++;
                }
            } else if (split.length > 1) {
                if (this.f2248h.length != split.length) {
                    throw new RuntimeException("Column number doesn't equal orientation definition number.");
                }
                int i2 = 0;
                while (true) {
                    int[] iArr2 = this.f2248h;
                    if (i2 >= iArr2.length) {
                        break;
                    }
                    iArr2[i2] = d(split[i2]);
                    i2++;
                }
            }
        }
        this.i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColumnLayout_spacingLeft, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColumnLayout_spacingRight, 0);
        obtainStyledAttributes.recycle();
    }

    public final int f(int i, int i2, int i3) {
        if (i3 == 1) {
            return i + i2;
        }
        if (i3 == 0) {
            return Math.max(i2, i);
        }
        return 0;
    }

    public final int g(int i, int i2, int i3) {
        if (i3 == 1) {
            return Math.max(i2, i);
        }
        if (i3 == 0) {
            return i + i2;
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final void h(View view, int i) {
        if (i == 1) {
            this.f2245e.remove(view);
        } else if (i == 2) {
            this.f2246f.remove(view);
        } else if (i != 3) {
        } else {
            this.f2247g.remove(view);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int[] iArr = this.k;
        if (iArr[0] == -1) {
            return;
        }
        c(1, this.f2245e, paddingLeft, paddingTop, iArr[0]);
        int[] iArr2 = this.k;
        int i5 = paddingLeft + iArr2[0] + this.i;
        if (iArr2[1] == -1) {
            return;
        }
        c(2, this.f2246f, i5, paddingTop, iArr2[1]);
        int[] iArr3 = this.k;
        int i6 = i5 + iArr3[1] + this.j;
        if (iArr3[2] == -1) {
            return;
        }
        c(3, this.f2247g, i6, paddingTop, iArr3[2]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0087, code lost:
        setMeasuredDimension(r25.i + r15, r5);
        r0 = r25.k;
        r0[0] = r15;
        r0[1] = -1;
        r0[2] = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0097, code lost:
        return;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onMeasure(int i, int i2) {
        int i3;
        int min;
        int i4;
        int max;
        int i5 = i & 1073741823;
        int i6 = i & (-1073741824);
        int i7 = i2 & 1073741823;
        int i8 = i2 & (-1073741824);
        int i9 = i5 + i6;
        int i10 = this.i + this.j;
        Iterator<View> it = this.f2245e.iterator();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = 8;
            if (it.hasNext()) {
                View next = it.next();
                if (next.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) next.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = generateDefaultLayoutParams();
                    }
                    LayoutParams layoutParams2 = layoutParams;
                    measureChildWithMargins(next, i9, i12 + i10, i2, i11);
                    int measuredWidth = next.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams2).leftMargin + ((FrameLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredHeight = next.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams2).topMargin + ((FrameLayout.LayoutParams) layoutParams2).bottomMargin;
                    i12 = g(i12, measuredWidth, this.f2248h[0]);
                    i11 = f(i11, measuredHeight, this.f2248h[0]);
                    if ((i6 == 0 || i12 < i5) && (i8 == 0 || i11 < i7)) {
                    }
                }
            } else {
                int i14 = i11;
                this.k[0] = i12;
                Iterator<View> it2 = this.f2247g.iterator();
                int i15 = 0;
                int i16 = 0;
                while (it2.hasNext()) {
                    View next2 = it2.next();
                    if (next2.getVisibility() != i13) {
                        LayoutParams layoutParams3 = (LayoutParams) next2.getLayoutParams();
                        if (layoutParams3 == null) {
                            layoutParams3 = generateDefaultLayoutParams();
                        }
                        LayoutParams layoutParams4 = layoutParams3;
                        Iterator<View> it3 = it2;
                        int i17 = i15;
                        int i18 = i9;
                        measureChildWithMargins(next2, i9, i12 + i16 + i10, i2, i17);
                        int measuredWidth2 = next2.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams4).leftMargin + ((FrameLayout.LayoutParams) layoutParams4).rightMargin;
                        int measuredHeight2 = next2.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams4).topMargin + ((FrameLayout.LayoutParams) layoutParams4).bottomMargin;
                        i16 = g(i16, measuredWidth2, this.f2248h[2]);
                        i15 = f(i17, measuredHeight2, this.f2248h[2]);
                        if ((i6 != 0 && i16 > i5 - i12) || (i8 != 0 && i15 > i7)) {
                            setMeasuredDimension(i12 + i16 + this.i + this.j, Math.max(i14, i15));
                            int[] iArr = this.k;
                            iArr[2] = i16;
                            iArr[1] = -1;
                            return;
                        }
                        it2 = it3;
                        i9 = i18;
                        i13 = 8;
                    }
                }
                int i19 = i15;
                int i20 = i9;
                int i21 = i16;
                this.k[2] = i21;
                if (i6 != Integer.MIN_VALUE) {
                    if (i6 == 0) {
                        i4 = 0;
                        min = 0;
                        for (View view : this.f2246f) {
                            LayoutParams layoutParams5 = (LayoutParams) view.getLayoutParams();
                            if (layoutParams5 == null) {
                                layoutParams5 = generateDefaultLayoutParams();
                            }
                            measureChild(view, i5, i7);
                            int measuredWidth3 = view.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams5).leftMargin + ((FrameLayout.LayoutParams) layoutParams5).rightMargin;
                            int measuredHeight3 = view.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams5).topMargin + ((FrameLayout.LayoutParams) layoutParams5).bottomMargin;
                            min = g(min, measuredWidth3, this.f2248h[1]);
                            i4 = f(i4, measuredHeight3, this.f2248h[1]);
                        }
                    } else if (i6 != 1073741824) {
                        i3 = i7;
                        i4 = 0;
                        min = 0;
                    } else {
                        int paddingLeft = ((((i5 - i12) - i21) - i10) - getPaddingLeft()) - getPaddingRight();
                        Iterator<View> it4 = this.f2246f.iterator();
                        int i22 = 0;
                        while (it4.hasNext()) {
                            View next3 = it4.next();
                            if (next3.getVisibility() != 8) {
                                LayoutParams layoutParams6 = (LayoutParams) next3.getLayoutParams();
                                if (layoutParams6 == null) {
                                    layoutParams6 = generateDefaultLayoutParams();
                                }
                                LayoutParams layoutParams7 = layoutParams6;
                                measureChildWithMargins(next3, i20, i12 + i21 + i10, i2, 0);
                                i22 = f(i22, next3.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams7).topMargin + ((FrameLayout.LayoutParams) layoutParams7).bottomMargin, this.f2248h[1]);
                                it4 = it4;
                            }
                        }
                        i4 = i22;
                        min = paddingLeft;
                    }
                    i3 = i7;
                } else {
                    int i23 = (((i5 - i12) - i21) - this.i) - this.j;
                    int i24 = 0;
                    int i25 = 0;
                    for (View view2 : this.f2246f) {
                        if (view2.getVisibility() != 8) {
                            LayoutParams layoutParams8 = (LayoutParams) view2.getLayoutParams();
                            if (layoutParams8 == null) {
                                layoutParams8 = generateDefaultLayoutParams();
                            }
                            LayoutParams layoutParams9 = layoutParams8;
                            measureChildWithMargins(view2, i20, i25 + i12 + i21 + i10, i2, 0);
                            int measuredWidth4 = view2.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams9).leftMargin + ((FrameLayout.LayoutParams) layoutParams9).rightMargin;
                            int measuredHeight4 = view2.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams9).topMargin + ((FrameLayout.LayoutParams) layoutParams9).bottomMargin;
                            i25 = g(i25, measuredWidth4, this.f2248h[1]);
                            i24 = f(i24, measuredHeight4, this.f2248h[1]);
                            i7 = i7;
                            i10 = i10;
                        }
                    }
                    i3 = i7;
                    min = Math.min(i25, i23);
                    i4 = i24;
                }
                this.k[1] = min;
                if (i8 == Integer.MIN_VALUE || i8 == 0) {
                    max = Math.max(Math.max(i14, i4), i19) + getPaddingTop() + getPaddingBottom();
                } else {
                    max = i8 != 1073741824 ? 0 : i3;
                }
                setMeasuredDimension(i12 + min + i21 + this.i + this.j + getPaddingLeft() + getPaddingRight(), max);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.f2245e.clear();
        this.f2246f.clear();
        this.f2247g.clear();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        h(view, ((LayoutParams) view.getLayoutParams()).f2249a);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        throw new RuntimeException("removeView with index is not supposed in ColumnLayout");
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        throw new RuntimeException("removeView in range is not supposed in ColumnLayout");
    }

    public void setSpacingRight(int i) {
        this.j = i;
    }

    public ColumnLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2245e = new ArrayList();
        this.f2246f = new ArrayList();
        this.f2247g = new ArrayList();
        this.f2248h = new int[]{0, 0, 0};
        this.k = new int[3];
        e(context, attributeSet);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f2249a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2249a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColumnLayout_Layout);
            this.f2249a = obtainStyledAttributes.getInt(R.styleable.ColumnLayout_Layout_layout_column, 1);
            obtainStyledAttributes.recycle();
            if (((FrameLayout.LayoutParams) this).gravity == -1) {
                ((FrameLayout.LayoutParams) this).gravity = 51;
            }
        }

        public LayoutParams(int i, int i2, int i3, int i4) {
            super(i, i2, i3);
            this.f2249a = 1;
            this.f2249a = i4;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2249a = 1;
        }
    }
}
