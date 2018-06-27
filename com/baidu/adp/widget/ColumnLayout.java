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
    private static final Pattern JH = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");
    private final List<View> JI;
    private final List<View> JJ;
    private final List<View> JK;
    private int[] JL;
    private int JM;
    private int JN;
    private final int[] JO;

    public ColumnLayout(Context context) {
        this(context, null, 0);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.JI = new ArrayList();
        this.JJ = new ArrayList();
        this.JK = new ArrayList();
        this.JL = new int[]{0, 0, 0};
        this.JO = new int[3];
        e(context, attributeSet);
    }

    private void e(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColumnLayout);
        String string = obtainStyledAttributes.getString(R.styleable.ColumnLayout_columnOrientation);
        if (string == null) {
            string = "vertical";
        }
        if (JH.matcher(string).matches()) {
            this.JL = new int[3];
            String[] split = string.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            if (split.length == 1) {
                int cb = cb(split[0]);
                for (int i = 0; i < this.JL.length; i++) {
                    this.JL[i] = cb;
                }
            } else if (split.length > 1) {
                if (this.JL.length != split.length) {
                    throw new RuntimeException("Column number doesn't equal orientation definition number.");
                }
                for (int i2 = 0; i2 < this.JL.length; i2++) {
                    this.JL[i2] = cb(split[i2]);
                }
            }
        }
        this.JM = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColumnLayout_spacingLeft, 0);
        this.JN = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColumnLayout_spacingRight, 0);
        obtainStyledAttributes.recycle();
    }

    private int cb(String str) {
        return "vertical".equals(str) ? 1 : 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        a aVar = (a) view.getLayoutParams();
        if (aVar == null) {
            aVar = generateDefaultLayoutParams();
        }
        c(view, aVar.column);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        d(view, ((a) view.getLayoutParams()).column);
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
        this.JI.clear();
        this.JJ.clear();
        this.JK.clear();
    }

    private void c(View view, int i) {
        switch (i) {
            case 1:
                if (!this.JI.contains(view)) {
                    this.JI.add(view);
                    return;
                }
                return;
            case 2:
                if (!this.JJ.contains(view)) {
                    this.JJ.add(view);
                    return;
                }
                return;
            case 3:
                if (!this.JK.contains(view)) {
                    this.JK.add(view);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void d(View view, int i) {
        switch (i) {
            case 1:
                this.JI.remove(view);
                return;
            case 2:
                this.JJ.remove(view);
                return;
            case 3:
                this.JK.remove(view);
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
        int i9 = this.JM + this.JN;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (View view : this.JI) {
            if (view.getVisibility() != 8) {
                a aVar = (a) view.getLayoutParams();
                a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                measureChildWithMargins(view, i8, i14 + i9, i2, i11);
                int measuredWidth = view.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin;
                int measuredHeight = view.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin;
                int h = h(i14, measuredWidth, this.JL[0]);
                i11 = i(i11, measuredHeight, this.JL[0]);
                if ((i5 != 0 && h >= i4) || (i7 != 0 && i11 >= i6)) {
                    setMeasuredDimension(this.JM + h, i11);
                    this.JO[0] = h;
                    this.JO[1] = -1;
                    this.JO[2] = -1;
                    return;
                }
                i14 = h;
            }
        }
        this.JO[0] = i14;
        int i15 = 0;
        for (View view2 : this.JK) {
            if (view2.getVisibility() != 8) {
                a aVar2 = (a) view2.getLayoutParams();
                if (aVar2 == null) {
                    aVar2 = generateDefaultLayoutParams();
                }
                measureChildWithMargins(view2, i8, i14 + i15 + i9, i2, i13);
                int measuredWidth2 = view2.getMeasuredWidth() + aVar2.leftMargin + aVar2.rightMargin;
                int measuredHeight2 = view2.getMeasuredHeight() + aVar2.topMargin + aVar2.bottomMargin;
                int h2 = h(i15, measuredWidth2, this.JL[2]);
                i13 = i(i13, measuredHeight2, this.JL[2]);
                if ((i5 != 0 && h2 > i4 - i14) || (i7 != 0 && i13 > i6)) {
                    setMeasuredDimension(i14 + h2 + this.JM + this.JN, Math.max(i11, i13));
                    this.JO[2] = h2;
                    this.JO[1] = -1;
                    return;
                }
                i15 = h2;
            }
        }
        this.JO[2] = i15;
        switch (i5) {
            case Integer.MIN_VALUE:
                int i16 = (((i4 - i14) - i15) - this.JM) - this.JN;
                i3 = 0;
                int i17 = 0;
                for (View view3 : this.JJ) {
                    if (view3.getVisibility() != 8) {
                        a aVar3 = (a) view3.getLayoutParams();
                        if (aVar3 == null) {
                            aVar3 = generateDefaultLayoutParams();
                        }
                        measureChildWithMargins(view3, i8, i17 + i14 + i15 + i9, i2, 0);
                        int measuredWidth3 = view3.getMeasuredWidth() + aVar3.leftMargin + aVar3.rightMargin;
                        int measuredHeight3 = aVar3.bottomMargin + view3.getMeasuredHeight() + aVar3.topMargin;
                        i17 = h(i17, measuredWidth3, this.JL[1]);
                        i3 = i(i3, measuredHeight3, this.JL[1]);
                    }
                }
                i10 = Math.min(i17, i16);
                break;
            case 0:
                for (View view4 : this.JJ) {
                    a aVar4 = (a) view4.getLayoutParams();
                    if (aVar4 == null) {
                        aVar4 = generateDefaultLayoutParams();
                    }
                    measureChild(view4, i4, i6);
                    int measuredWidth4 = view4.getMeasuredWidth() + aVar4.leftMargin + aVar4.rightMargin;
                    int measuredHeight4 = view4.getMeasuredHeight() + aVar4.topMargin + aVar4.bottomMargin;
                    i10 = h(i10, measuredWidth4, this.JL[1]);
                    i12 = i(i12, measuredHeight4, this.JL[1]);
                }
                i3 = i12;
                break;
            case 1073741824:
                int paddingLeft = ((((i4 - i14) - i15) - i9) - getPaddingLeft()) - getPaddingRight();
                i3 = 0;
                for (View view5 : this.JJ) {
                    if (view5.getVisibility() != 8) {
                        a aVar5 = (a) view5.getLayoutParams();
                        if (aVar5 == null) {
                            aVar5 = generateDefaultLayoutParams();
                        }
                        measureChildWithMargins(view5, i8, i14 + i15 + i9, i2, 0);
                        i3 = i(i3, aVar5.bottomMargin + view5.getMeasuredHeight() + aVar5.topMargin, this.JL[1]);
                    }
                }
                i10 = paddingLeft;
                break;
            default:
                i3 = i12;
                break;
        }
        this.JO[1] = i10;
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
        setMeasuredDimension(i14 + i10 + i15 + this.JM + this.JN + getPaddingLeft() + getPaddingRight(), max);
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
        if (this.JO[0] != -1) {
            a(1, this.JI, paddingLeft, paddingTop, this.JO[0]);
            int i5 = paddingLeft + this.JO[0] + this.JM;
            if (this.JO[1] != -1) {
                a(2, this.JJ, i5, paddingTop, this.JO[1]);
                int i6 = i5 + this.JO[1] + this.JN;
                if (this.JO[2] != -1) {
                    a(3, this.JK, i6, paddingTop, this.JO[2]);
                }
            }
        }
    }

    private void a(int i, List<View> list, int i2, int i3, int i4) {
        if (i >= 1 && i <= 3) {
            int i5 = this.JL[i - 1];
            int measuredHeight = getMeasuredHeight();
            for (View view : list) {
                if (view.getVisibility() != 8) {
                    a aVar = (a) view.getLayoutParams();
                    a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                    switch (i5 == 1 ? generateDefaultLayoutParams.gravity & 7 : generateDefaultLayoutParams.gravity & 112) {
                        case 1:
                            int i6 = generateDefaultLayoutParams.topMargin + i3;
                            int measuredHeight2 = view.getMeasuredHeight() + i6;
                            view.layout(((((i4 - generateDefaultLayoutParams.leftMargin) - generateDefaultLayoutParams.rightMargin) - view.getMeasuredWidth()) + i2) >> 1, i6, ((((i4 - generateDefaultLayoutParams.leftMargin) - generateDefaultLayoutParams.rightMargin) + view.getMeasuredWidth()) + i2) >> 1, measuredHeight2);
                            i3 = measuredHeight2 + generateDefaultLayoutParams.bottomMargin;
                            continue;
                        case 3:
                            int i7 = generateDefaultLayoutParams.topMargin + i3;
                            int measuredWidth = generateDefaultLayoutParams.leftMargin + i2 + view.getMeasuredWidth();
                            int measuredHeight3 = view.getMeasuredHeight() + i7;
                            view.layout(generateDefaultLayoutParams.leftMargin + i2, i7, measuredWidth, measuredHeight3);
                            i3 = measuredHeight3 + generateDefaultLayoutParams.bottomMargin;
                            continue;
                        case 5:
                            int measuredWidth2 = ((i2 + i4) - generateDefaultLayoutParams.rightMargin) - view.getMeasuredWidth();
                            int i8 = generateDefaultLayoutParams.topMargin + i3;
                            int i9 = (i2 + i4) - generateDefaultLayoutParams.rightMargin;
                            int measuredHeight4 = view.getMeasuredHeight() + i8;
                            view.layout(measuredWidth2, i8, i9, measuredHeight4);
                            i3 = measuredHeight4 + generateDefaultLayoutParams.bottomMargin;
                            continue;
                        case 16:
                            int i10 = generateDefaultLayoutParams.leftMargin + i2;
                            int measuredWidth3 = view.getMeasuredWidth() + i10;
                            view.layout(i10, ((((measuredHeight - generateDefaultLayoutParams.topMargin) - generateDefaultLayoutParams.bottomMargin) - view.getMeasuredHeight()) + i3) >> 1, measuredWidth3, ((((measuredHeight - generateDefaultLayoutParams.topMargin) - generateDefaultLayoutParams.bottomMargin) + view.getMeasuredHeight()) + i3) >> 1);
                            i2 = measuredWidth3 + generateDefaultLayoutParams.rightMargin;
                            continue;
                        case 48:
                            int i11 = generateDefaultLayoutParams.leftMargin + i2;
                            int measuredWidth4 = view.getMeasuredWidth() + i11;
                            view.layout(i11, generateDefaultLayoutParams.topMargin + i3, measuredWidth4, generateDefaultLayoutParams.topMargin + i3 + view.getMeasuredHeight());
                            i2 = measuredWidth4 + generateDefaultLayoutParams.rightMargin;
                            continue;
                        case 80:
                            int i12 = generateDefaultLayoutParams.leftMargin + i2;
                            int measuredHeight5 = ((i3 + measuredHeight) - generateDefaultLayoutParams.bottomMargin) - view.getMeasuredHeight();
                            int measuredWidth5 = view.getMeasuredWidth() + i12;
                            view.layout(i12, measuredHeight5, measuredWidth5, (i3 + measuredHeight) - generateDefaultLayoutParams.bottomMargin);
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
    /* renamed from: mF */
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
