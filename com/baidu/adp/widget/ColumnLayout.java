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
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
/* loaded from: classes.dex */
public class ColumnLayout extends ViewGroup {
    public static final Pattern l = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");

    /* renamed from: e  reason: collision with root package name */
    public final List<View> f2253e;

    /* renamed from: f  reason: collision with root package name */
    public final List<View> f2254f;

    /* renamed from: g  reason: collision with root package name */
    public final List<View> f2255g;

    /* renamed from: h  reason: collision with root package name */
    public int[] f2256h;

    /* renamed from: i  reason: collision with root package name */
    public int f2257i;
    public int j;
    public final int[] k;

    public ColumnLayout(Context context) {
        this(context, null, 0);
    }

    public final void a(View view, int i2) {
        if (i2 == 1) {
            if (this.f2253e.contains(view)) {
                return;
            }
            this.f2253e.add(view);
        } else if (i2 != 2) {
            if (i2 == 3 && !this.f2255g.contains(view)) {
                this.f2255g.add(view);
            }
        } else if (this.f2254f.contains(view)) {
        } else {
            this.f2254f.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i2, layoutParams);
        LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = generateDefaultLayoutParams();
        }
        a(view, layoutParams2.f2258a);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    /* renamed from: b */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2, 51, 1);
    }

    public final void c(int i2, List<View> list, int i3, int i4, int i5) {
        int measuredHeight;
        int i6;
        int measuredWidth;
        int i7;
        if (i2 < 1 || i2 > 3) {
            return;
        }
        int i8 = this.f2256h[i2 - 1];
        int measuredHeight2 = getMeasuredHeight();
        for (View view : list) {
            if (view.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                if (layoutParams == null) {
                    layoutParams = generateDefaultLayoutParams();
                }
                int i9 = ((FrameLayout.LayoutParams) layoutParams).gravity;
                int i10 = i8 == 1 ? i9 & 7 : i9 & 112;
                if (i10 == 1) {
                    int i11 = i4 + ((FrameLayout.LayoutParams) layoutParams).topMargin;
                    measuredHeight = view.getMeasuredHeight() + i11;
                    view.layout(((((i5 - ((FrameLayout.LayoutParams) layoutParams).leftMargin) - ((FrameLayout.LayoutParams) layoutParams).rightMargin) - view.getMeasuredWidth()) + i3) >> 1, i11, ((((i5 - ((FrameLayout.LayoutParams) layoutParams).leftMargin) - ((FrameLayout.LayoutParams) layoutParams).rightMargin) + view.getMeasuredWidth()) + i3) >> 1, measuredHeight);
                    i6 = ((FrameLayout.LayoutParams) layoutParams).bottomMargin;
                } else if (i10 == 3) {
                    int i12 = ((FrameLayout.LayoutParams) layoutParams).leftMargin;
                    int i13 = i3 + i12;
                    int i14 = i4 + ((FrameLayout.LayoutParams) layoutParams).topMargin;
                    int measuredWidth2 = i12 + i3 + view.getMeasuredWidth();
                    measuredHeight = view.getMeasuredHeight() + i14;
                    view.layout(i13, i14, measuredWidth2, measuredHeight);
                    i6 = ((FrameLayout.LayoutParams) layoutParams).bottomMargin;
                } else if (i10 != 5) {
                    if (i10 == 16) {
                        int i15 = i3 + ((FrameLayout.LayoutParams) layoutParams).leftMargin;
                        measuredWidth = view.getMeasuredWidth() + i15;
                        view.layout(i15, ((((measuredHeight2 - ((FrameLayout.LayoutParams) layoutParams).topMargin) - ((FrameLayout.LayoutParams) layoutParams).bottomMargin) - view.getMeasuredHeight()) + i4) >> 1, measuredWidth, ((((measuredHeight2 - ((FrameLayout.LayoutParams) layoutParams).topMargin) - ((FrameLayout.LayoutParams) layoutParams).bottomMargin) + view.getMeasuredHeight()) + i4) >> 1);
                        i7 = ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                    } else if (i10 == 48) {
                        int i16 = i3 + ((FrameLayout.LayoutParams) layoutParams).leftMargin;
                        measuredWidth = view.getMeasuredWidth() + i16;
                        view.layout(i16, ((FrameLayout.LayoutParams) layoutParams).topMargin + i4, measuredWidth, ((FrameLayout.LayoutParams) layoutParams).topMargin + i4 + view.getMeasuredHeight());
                        i7 = ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                    } else if (i10 == 80) {
                        int i17 = i3 + ((FrameLayout.LayoutParams) layoutParams).leftMargin;
                        int i18 = i4 + measuredHeight2;
                        int measuredHeight3 = (i18 - ((FrameLayout.LayoutParams) layoutParams).bottomMargin) - view.getMeasuredHeight();
                        int measuredWidth3 = view.getMeasuredWidth() + i17;
                        view.layout(i17, measuredHeight3, measuredWidth3, i18 - ((FrameLayout.LayoutParams) layoutParams).bottomMargin);
                        i3 = measuredWidth3 + ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                    }
                    i3 = measuredWidth + i7;
                } else {
                    int i19 = i3 + i5;
                    int measuredWidth4 = (i19 - ((FrameLayout.LayoutParams) layoutParams).rightMargin) - view.getMeasuredWidth();
                    int i20 = i4 + ((FrameLayout.LayoutParams) layoutParams).topMargin;
                    int i21 = i19 - ((FrameLayout.LayoutParams) layoutParams).rightMargin;
                    measuredHeight = view.getMeasuredHeight() + i20;
                    view.layout(measuredWidth4, i20, i21, measuredHeight);
                    i6 = ((FrameLayout.LayoutParams) layoutParams).bottomMargin;
                }
                i4 = measuredHeight + i6;
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
            this.f2256h = new int[3];
            String[] split = string.split("\\|");
            if (split.length == 1) {
                int d2 = d(split[0]);
                int i2 = 0;
                while (true) {
                    int[] iArr = this.f2256h;
                    if (i2 >= iArr.length) {
                        break;
                    }
                    iArr[i2] = d2;
                    i2++;
                }
            } else if (split.length > 1) {
                if (this.f2256h.length != split.length) {
                    throw new RuntimeException("Column number doesn't equal orientation definition number.");
                }
                int i3 = 0;
                while (true) {
                    int[] iArr2 = this.f2256h;
                    if (i3 >= iArr2.length) {
                        break;
                    }
                    iArr2[i3] = d(split[i3]);
                    i3++;
                }
            }
        }
        this.f2257i = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColumnLayout_spacingLeft, 0);
        this.j = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColumnLayout_spacingRight, 0);
        obtainStyledAttributes.recycle();
    }

    public final int f(int i2, int i3, int i4) {
        if (i4 == 1) {
            return i2 + i3;
        }
        if (i4 == 0) {
            return Math.max(i3, i2);
        }
        return 0;
    }

    public final int g(int i2, int i3, int i4) {
        if (i4 == 1) {
            return Math.max(i3, i2);
        }
        if (i4 == 0) {
            return i2 + i3;
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public final void h(View view, int i2) {
        if (i2 == 1) {
            this.f2253e.remove(view);
        } else if (i2 == 2) {
            this.f2254f.remove(view);
        } else if (i2 != 3) {
        } else {
            this.f2255g.remove(view);
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int[] iArr = this.k;
        if (iArr[0] == -1) {
            return;
        }
        c(1, this.f2253e, paddingLeft, paddingTop, iArr[0]);
        int[] iArr2 = this.k;
        int i6 = paddingLeft + iArr2[0] + this.f2257i;
        if (iArr2[1] == -1) {
            return;
        }
        c(2, this.f2254f, i6, paddingTop, iArr2[1]);
        int[] iArr3 = this.k;
        int i7 = i6 + iArr3[1] + this.j;
        if (iArr3[2] == -1) {
            return;
        }
        c(3, this.f2255g, i7, paddingTop, iArr3[2]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0087, code lost:
        setMeasuredDimension(r25.f2257i + r15, r5);
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
    public void onMeasure(int i2, int i3) {
        int i4;
        int min;
        int i5;
        int max;
        int i6 = i2 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int i7 = i2 & (-1073741824);
        int i8 = i3 & LockFreeTaskQueueCore.MAX_CAPACITY_MASK;
        int i9 = i3 & (-1073741824);
        int i10 = i6 + i7;
        int i11 = this.f2257i + this.j;
        Iterator<View> it = this.f2253e.iterator();
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int i14 = 8;
            if (it.hasNext()) {
                View next = it.next();
                if (next.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) next.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = generateDefaultLayoutParams();
                    }
                    LayoutParams layoutParams2 = layoutParams;
                    measureChildWithMargins(next, i10, i13 + i11, i3, i12);
                    int measuredWidth = next.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams2).leftMargin + ((FrameLayout.LayoutParams) layoutParams2).rightMargin;
                    int measuredHeight = next.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams2).topMargin + ((FrameLayout.LayoutParams) layoutParams2).bottomMargin;
                    i13 = g(i13, measuredWidth, this.f2256h[0]);
                    i12 = f(i12, measuredHeight, this.f2256h[0]);
                    if ((i7 == 0 || i13 < i6) && (i9 == 0 || i12 < i8)) {
                    }
                }
            } else {
                int i15 = i12;
                this.k[0] = i13;
                Iterator<View> it2 = this.f2255g.iterator();
                int i16 = 0;
                int i17 = 0;
                while (it2.hasNext()) {
                    View next2 = it2.next();
                    if (next2.getVisibility() != i14) {
                        LayoutParams layoutParams3 = (LayoutParams) next2.getLayoutParams();
                        if (layoutParams3 == null) {
                            layoutParams3 = generateDefaultLayoutParams();
                        }
                        LayoutParams layoutParams4 = layoutParams3;
                        Iterator<View> it3 = it2;
                        int i18 = i16;
                        int i19 = i10;
                        measureChildWithMargins(next2, i10, i13 + i17 + i11, i3, i18);
                        int measuredWidth2 = next2.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams4).leftMargin + ((FrameLayout.LayoutParams) layoutParams4).rightMargin;
                        int measuredHeight2 = next2.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams4).topMargin + ((FrameLayout.LayoutParams) layoutParams4).bottomMargin;
                        i17 = g(i17, measuredWidth2, this.f2256h[2]);
                        i16 = f(i18, measuredHeight2, this.f2256h[2]);
                        if ((i7 != 0 && i17 > i6 - i13) || (i9 != 0 && i16 > i8)) {
                            setMeasuredDimension(i13 + i17 + this.f2257i + this.j, Math.max(i15, i16));
                            int[] iArr = this.k;
                            iArr[2] = i17;
                            iArr[1] = -1;
                            return;
                        }
                        it2 = it3;
                        i10 = i19;
                        i14 = 8;
                    }
                }
                int i20 = i16;
                int i21 = i10;
                int i22 = i17;
                this.k[2] = i22;
                if (i7 != Integer.MIN_VALUE) {
                    if (i7 == 0) {
                        i5 = 0;
                        min = 0;
                        for (View view : this.f2254f) {
                            LayoutParams layoutParams5 = (LayoutParams) view.getLayoutParams();
                            if (layoutParams5 == null) {
                                layoutParams5 = generateDefaultLayoutParams();
                            }
                            measureChild(view, i6, i8);
                            int measuredWidth3 = view.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams5).leftMargin + ((FrameLayout.LayoutParams) layoutParams5).rightMargin;
                            int measuredHeight3 = view.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams5).topMargin + ((FrameLayout.LayoutParams) layoutParams5).bottomMargin;
                            min = g(min, measuredWidth3, this.f2256h[1]);
                            i5 = f(i5, measuredHeight3, this.f2256h[1]);
                        }
                    } else if (i7 != 1073741824) {
                        i4 = i8;
                        i5 = 0;
                        min = 0;
                    } else {
                        int paddingLeft = ((((i6 - i13) - i22) - i11) - getPaddingLeft()) - getPaddingRight();
                        Iterator<View> it4 = this.f2254f.iterator();
                        int i23 = 0;
                        while (it4.hasNext()) {
                            View next3 = it4.next();
                            if (next3.getVisibility() != 8) {
                                LayoutParams layoutParams6 = (LayoutParams) next3.getLayoutParams();
                                if (layoutParams6 == null) {
                                    layoutParams6 = generateDefaultLayoutParams();
                                }
                                LayoutParams layoutParams7 = layoutParams6;
                                measureChildWithMargins(next3, i21, i13 + i22 + i11, i3, 0);
                                i23 = f(i23, next3.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams7).topMargin + ((FrameLayout.LayoutParams) layoutParams7).bottomMargin, this.f2256h[1]);
                                it4 = it4;
                            }
                        }
                        i5 = i23;
                        min = paddingLeft;
                    }
                    i4 = i8;
                } else {
                    int i24 = (((i6 - i13) - i22) - this.f2257i) - this.j;
                    int i25 = 0;
                    int i26 = 0;
                    for (View view2 : this.f2254f) {
                        if (view2.getVisibility() != 8) {
                            LayoutParams layoutParams8 = (LayoutParams) view2.getLayoutParams();
                            if (layoutParams8 == null) {
                                layoutParams8 = generateDefaultLayoutParams();
                            }
                            LayoutParams layoutParams9 = layoutParams8;
                            measureChildWithMargins(view2, i21, i26 + i13 + i22 + i11, i3, 0);
                            int measuredWidth4 = view2.getMeasuredWidth() + ((FrameLayout.LayoutParams) layoutParams9).leftMargin + ((FrameLayout.LayoutParams) layoutParams9).rightMargin;
                            int measuredHeight4 = view2.getMeasuredHeight() + ((FrameLayout.LayoutParams) layoutParams9).topMargin + ((FrameLayout.LayoutParams) layoutParams9).bottomMargin;
                            i26 = g(i26, measuredWidth4, this.f2256h[1]);
                            i25 = f(i25, measuredHeight4, this.f2256h[1]);
                            i8 = i8;
                            i11 = i11;
                        }
                    }
                    i4 = i8;
                    min = Math.min(i26, i24);
                    i5 = i25;
                }
                this.k[1] = min;
                if (i9 == Integer.MIN_VALUE || i9 == 0) {
                    max = Math.max(Math.max(i15, i5), i20) + getPaddingTop() + getPaddingBottom();
                } else {
                    max = i9 != 1073741824 ? 0 : i4;
                }
                setMeasuredDimension(i13 + min + i22 + this.f2257i + this.j + getPaddingLeft() + getPaddingRight(), max);
                return;
            }
        }
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.f2253e.clear();
        this.f2254f.clear();
        this.f2255g.clear();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        h(view, ((LayoutParams) view.getLayoutParams()).f2258a);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i2) {
        throw new RuntimeException("removeView with index is not supposed in ColumnLayout");
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i2, int i3) {
        throw new RuntimeException("removeView in range is not supposed in ColumnLayout");
    }

    public void setSpacingRight(int i2) {
        this.j = i2;
    }

    public ColumnLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2253e = new ArrayList();
        this.f2254f = new ArrayList();
        this.f2255g = new ArrayList();
        this.f2256h = new int[]{0, 0, 0};
        this.k = new int[3];
        e(context, attributeSet);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f2258a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2258a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColumnLayout_Layout);
            this.f2258a = obtainStyledAttributes.getInt(R.styleable.ColumnLayout_Layout_layout_column, 1);
            obtainStyledAttributes.recycle();
            if (((FrameLayout.LayoutParams) this).gravity == -1) {
                ((FrameLayout.LayoutParams) this).gravity = 51;
            }
        }

        public LayoutParams(int i2, int i3, int i4, int i5) {
            super(i2, i3, i4);
            this.f2258a = 1;
            this.f2258a = i5;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2258a = 1;
        }
    }
}
