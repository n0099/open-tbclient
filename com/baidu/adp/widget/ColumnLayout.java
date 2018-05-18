package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.R;
import com.baidu.fsg.base.widget.textfilter.EditTextPasteFilterUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class ColumnLayout extends ViewGroup {
    private static final Pattern Dv = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");
    private int DA;
    private int DB;
    private final int[] DC;
    private final List<View> Dw;
    private final List<View> Dx;
    private final List<View> Dy;
    private int[] Dz;

    public ColumnLayout(Context context) {
        this(context, null, 0);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Dw = new ArrayList();
        this.Dx = new ArrayList();
        this.Dy = new ArrayList();
        this.Dz = new int[]{0, 0, 0};
        this.DC = new int[3];
        e(context, attributeSet);
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColumnLayout);
        String string = obtainStyledAttributes.getString(R.styleable.ColumnLayout_columnOrientation);
        if (string == null) {
            string = "vertical";
        }
        if (Dv.matcher(string).matches()) {
            this.Dz = new int[3];
            String[] split = string.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            if (split.length == 1) {
                int bN = bN(split[0]);
                for (int i = 0; i < this.Dz.length; i++) {
                    this.Dz[i] = bN;
                }
            } else if (split.length > 1) {
                if (this.Dz.length != split.length) {
                    throw new RuntimeException("Column number doesn't equal orientation definition number.");
                }
                for (int i2 = 0; i2 < this.Dz.length; i2++) {
                    this.Dz[i2] = bN(split[i2]);
                }
            }
        }
        this.DA = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColumnLayout_spacingLeft, 0);
        this.DB = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColumnLayout_spacingRight, 0);
        obtainStyledAttributes.recycle();
    }

    private int bN(String str) {
        return "vertical".equals(str) ? 1 : 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup
    public void addView(View view2, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view2, i, layoutParams);
        a aVar = (a) view2.getLayoutParams();
        if (aVar == null) {
            aVar = generateDefaultLayoutParams();
        }
        c(view2, aVar.column);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view2) {
        super.removeView(view2);
        d(view2, ((a) view2.getLayoutParams()).column);
    }

    @Override // android.view.ViewGroup
    public void removeViewAt(int i) {
        throw new RuntimeException("removeView with index is not supposed in ColumnLayout");
    }

    @Override // android.view.ViewGroup
    public void removeViews(int i, int i2) {
        throw new RuntimeException("removeView in range is not supposed in ColumnLayout");
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        super.removeAllViews();
        this.Dw.clear();
        this.Dx.clear();
        this.Dy.clear();
    }

    private void c(View view2, int i) {
        switch (i) {
            case 1:
                if (!this.Dw.contains(view2)) {
                    this.Dw.add(view2);
                    return;
                }
                return;
            case 2:
                if (!this.Dx.contains(view2)) {
                    this.Dx.add(view2);
                    return;
                }
                return;
            case 3:
                if (!this.Dy.contains(view2)) {
                    this.Dy.add(view2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void d(View view2, int i) {
        switch (i) {
            case 1:
                this.Dw.remove(view2);
                return;
            case 2:
                this.Dx.remove(view2);
                return;
            case 3:
                this.Dy.remove(view2);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int max;
        int i4 = i & 1073741823;
        int i5 = i & (-1073741824);
        int i6 = i2 & 1073741823;
        int i7 = i2 & (-1073741824);
        int i8 = i4 + i5;
        int i9 = this.DA + this.DB;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (View view2 : this.Dw) {
            if (view2.getVisibility() != 8) {
                a aVar = (a) view2.getLayoutParams();
                a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                measureChildWithMargins(view2, i8, i14 + i9, i2, i11);
                int measuredWidth = view2.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin;
                int measuredHeight = view2.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin;
                int h = h(i14, measuredWidth, this.Dz[0]);
                i11 = i(i11, measuredHeight, this.Dz[0]);
                if ((i5 != 0 && h >= i4) || (i7 != 0 && i11 >= i6)) {
                    setMeasuredDimension(this.DA + h, i11);
                    this.DC[0] = h;
                    this.DC[1] = -1;
                    this.DC[2] = -1;
                    return;
                }
                i14 = h;
            }
        }
        this.DC[0] = i14;
        int i15 = 0;
        for (View view3 : this.Dy) {
            if (view3.getVisibility() != 8) {
                a aVar2 = (a) view3.getLayoutParams();
                if (aVar2 == null) {
                    aVar2 = generateDefaultLayoutParams();
                }
                measureChildWithMargins(view3, i8, i14 + i15 + i9, i2, i13);
                int measuredWidth2 = view3.getMeasuredWidth() + aVar2.leftMargin + aVar2.rightMargin;
                int measuredHeight2 = view3.getMeasuredHeight() + aVar2.topMargin + aVar2.bottomMargin;
                int h2 = h(i15, measuredWidth2, this.Dz[2]);
                i13 = i(i13, measuredHeight2, this.Dz[2]);
                if ((i5 != 0 && h2 > i4 - i14) || (i7 != 0 && i13 > i6)) {
                    setMeasuredDimension(i14 + h2 + this.DA + this.DB, Math.max(i11, i13));
                    this.DC[2] = h2;
                    this.DC[1] = -1;
                    return;
                }
                i15 = h2;
            }
        }
        this.DC[2] = i15;
        switch (i5) {
            case Integer.MIN_VALUE:
                int i16 = (((i4 - i14) - i15) - this.DA) - this.DB;
                i3 = 0;
                int i17 = 0;
                for (View view4 : this.Dx) {
                    if (view4.getVisibility() != 8) {
                        a aVar3 = (a) view4.getLayoutParams();
                        if (aVar3 == null) {
                            aVar3 = generateDefaultLayoutParams();
                        }
                        measureChildWithMargins(view4, i8, i17 + i14 + i15 + i9, i2, 0);
                        int measuredWidth3 = view4.getMeasuredWidth() + aVar3.leftMargin + aVar3.rightMargin;
                        int measuredHeight3 = aVar3.bottomMargin + view4.getMeasuredHeight() + aVar3.topMargin;
                        i17 = h(i17, measuredWidth3, this.Dz[1]);
                        i3 = i(i3, measuredHeight3, this.Dz[1]);
                    }
                }
                i10 = Math.min(i17, i16);
                break;
            case 0:
                for (View view5 : this.Dx) {
                    a aVar4 = (a) view5.getLayoutParams();
                    if (aVar4 == null) {
                        aVar4 = generateDefaultLayoutParams();
                    }
                    measureChild(view5, i4, i6);
                    int measuredWidth4 = view5.getMeasuredWidth() + aVar4.leftMargin + aVar4.rightMargin;
                    int measuredHeight4 = view5.getMeasuredHeight() + aVar4.topMargin + aVar4.bottomMargin;
                    i10 = h(i10, measuredWidth4, this.Dz[1]);
                    i12 = i(i12, measuredHeight4, this.Dz[1]);
                }
                i3 = i12;
                break;
            case 1073741824:
                int paddingLeft = ((((i4 - i14) - i15) - i9) - getPaddingLeft()) - getPaddingRight();
                i3 = 0;
                for (View view6 : this.Dx) {
                    if (view6.getVisibility() != 8) {
                        a aVar5 = (a) view6.getLayoutParams();
                        if (aVar5 == null) {
                            aVar5 = generateDefaultLayoutParams();
                        }
                        measureChildWithMargins(view6, i8, i14 + i15 + i9, i2, 0);
                        i3 = i(i3, aVar5.bottomMargin + view6.getMeasuredHeight() + aVar5.topMargin, this.Dz[1]);
                    }
                }
                i10 = paddingLeft;
                break;
            default:
                i3 = i12;
                break;
        }
        this.DC[1] = i10;
        switch (i7) {
            case Integer.MIN_VALUE:
            case 0:
                max = Math.max(Math.max(i11, i3), i13) + getPaddingTop() + getPaddingBottom();
                break;
            case 1073741824:
                max = i6;
                break;
            default:
                max = 0;
                break;
        }
        setMeasuredDimension(i14 + i10 + i15 + this.DA + this.DB + getPaddingLeft() + getPaddingRight(), max);
    }

    private int h(int i, int i2, int i3) {
        if (i3 == 1) {
            return Math.max(i2, i);
        }
        if (i3 == 0) {
            return i + i2;
        }
        return 0;
    }

    private int i(int i, int i2, int i3) {
        if (i3 == 1) {
            return i + i2;
        }
        if (i3 == 0) {
            return Math.max(i2, i);
        }
        return 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (this.DC[0] != -1) {
            a(1, this.Dw, paddingLeft, paddingTop, this.DC[0]);
            int i5 = paddingLeft + this.DC[0] + this.DA;
            if (this.DC[1] != -1) {
                a(2, this.Dx, i5, paddingTop, this.DC[1]);
                int i6 = i5 + this.DC[1] + this.DB;
                if (this.DC[2] != -1) {
                    a(3, this.Dy, i6, paddingTop, this.DC[2]);
                }
            }
        }
    }

    private void a(int i, List<View> list, int i2, int i3, int i4) {
        if (i >= 1 && i <= 3) {
            int i5 = this.Dz[i - 1];
            int measuredHeight = getMeasuredHeight();
            for (View view2 : list) {
                if (view2.getVisibility() != 8) {
                    a aVar = (a) view2.getLayoutParams();
                    a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                    switch (i5 == 1 ? generateDefaultLayoutParams.gravity & 7 : generateDefaultLayoutParams.gravity & 112) {
                        case 1:
                            int i6 = generateDefaultLayoutParams.topMargin + i3;
                            int measuredHeight2 = view2.getMeasuredHeight() + i6;
                            view2.layout(((((i4 - generateDefaultLayoutParams.leftMargin) - generateDefaultLayoutParams.rightMargin) - view2.getMeasuredWidth()) + i2) >> 1, i6, ((((i4 - generateDefaultLayoutParams.leftMargin) - generateDefaultLayoutParams.rightMargin) + view2.getMeasuredWidth()) + i2) >> 1, measuredHeight2);
                            i3 = measuredHeight2 + generateDefaultLayoutParams.bottomMargin;
                            continue;
                        case 3:
                            int i7 = generateDefaultLayoutParams.topMargin + i3;
                            int measuredWidth = generateDefaultLayoutParams.leftMargin + i2 + view2.getMeasuredWidth();
                            int measuredHeight3 = view2.getMeasuredHeight() + i7;
                            view2.layout(generateDefaultLayoutParams.leftMargin + i2, i7, measuredWidth, measuredHeight3);
                            i3 = measuredHeight3 + generateDefaultLayoutParams.bottomMargin;
                            continue;
                        case 5:
                            int measuredWidth2 = ((i2 + i4) - generateDefaultLayoutParams.rightMargin) - view2.getMeasuredWidth();
                            int i8 = generateDefaultLayoutParams.topMargin + i3;
                            int i9 = (i2 + i4) - generateDefaultLayoutParams.rightMargin;
                            int measuredHeight4 = view2.getMeasuredHeight() + i8;
                            view2.layout(measuredWidth2, i8, i9, measuredHeight4);
                            i3 = measuredHeight4 + generateDefaultLayoutParams.bottomMargin;
                            continue;
                        case 16:
                            int i10 = generateDefaultLayoutParams.leftMargin + i2;
                            int measuredWidth3 = view2.getMeasuredWidth() + i10;
                            view2.layout(i10, ((((measuredHeight - generateDefaultLayoutParams.topMargin) - generateDefaultLayoutParams.bottomMargin) - view2.getMeasuredHeight()) + i3) >> 1, measuredWidth3, ((((measuredHeight - generateDefaultLayoutParams.topMargin) - generateDefaultLayoutParams.bottomMargin) + view2.getMeasuredHeight()) + i3) >> 1);
                            i2 = measuredWidth3 + generateDefaultLayoutParams.rightMargin;
                            continue;
                        case 48:
                            int i11 = generateDefaultLayoutParams.leftMargin + i2;
                            int measuredWidth4 = view2.getMeasuredWidth() + i11;
                            view2.layout(i11, generateDefaultLayoutParams.topMargin + i3, measuredWidth4, generateDefaultLayoutParams.topMargin + i3 + view2.getMeasuredHeight());
                            i2 = measuredWidth4 + generateDefaultLayoutParams.rightMargin;
                            continue;
                        case 80:
                            int i12 = generateDefaultLayoutParams.leftMargin + i2;
                            int measuredHeight5 = ((i3 + measuredHeight) - generateDefaultLayoutParams.bottomMargin) - view2.getMeasuredHeight();
                            int measuredWidth5 = view2.getMeasuredWidth() + i12;
                            view2.layout(i12, measuredHeight5, measuredWidth5, (i3 + measuredHeight) - generateDefaultLayoutParams.bottomMargin);
                            i2 = measuredWidth5 + generateDefaultLayoutParams.rightMargin;
                            continue;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends FrameLayout.LayoutParams {
        public int column;

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.column = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColumnLayout_Layout);
            this.column = obtainStyledAttributes.getInt(R.styleable.ColumnLayout_Layout_layout_column, 1);
            obtainStyledAttributes.recycle();
            if (this.gravity == -1) {
                this.gravity = 51;
            }
        }

        public a(int i, int i2, int i3, int i4) {
            super(i, i2, i3);
            this.column = 1;
            this.column = i4;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.column = 1;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: jR */
    public a generateDefaultLayoutParams() {
        return new a(-2, -2, 51, 1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }
}
