package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.adp.R;
import com.baidu.cloudsdk.social.core.util.SocialAPIErrorCodes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class ColumnLayout extends ViewGroup {
    private static final Pattern Ff = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");
    private final List<View> Fg;
    private final List<View> Fh;
    private final List<View> Fi;
    private int[] Fj;
    private int Fk;
    private int Fl;
    private final int[] Fm;

    public ColumnLayout(Context context) {
        this(context, null, 0);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Fg = new ArrayList();
        this.Fh = new ArrayList();
        this.Fi = new ArrayList();
        this.Fj = new int[3];
        this.Fm = new int[3];
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColumnLayout);
        String string = obtainStyledAttributes.getString(0);
        if (string == null) {
            string = "vertical";
        }
        if (Ff.matcher(string).matches()) {
            this.Fj = new int[3];
            String[] split = string.split("\\|");
            if (split.length == 1) {
                int bK = bK(split[0]);
                for (int i = 0; i < this.Fj.length; i++) {
                    this.Fj[i] = bK;
                }
            } else if (split.length > 1) {
                if (this.Fj.length != split.length) {
                    throw new RuntimeException("Column number doesn't equal orientation definition number.");
                }
                for (int i2 = 0; i2 < this.Fj.length; i2++) {
                    this.Fj[i2] = bK(split[i2]);
                }
            }
        }
        this.Fk = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.Fl = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        obtainStyledAttributes.recycle();
    }

    private int bK(String str) {
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
        a(view, aVar.column);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        b(view, ((a) view.getLayoutParams()).column);
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
        this.Fg.clear();
        this.Fh.clear();
        this.Fi.clear();
    }

    private void a(View view, int i) {
        switch (i) {
            case 1:
                if (!this.Fg.contains(view)) {
                    this.Fg.add(view);
                    return;
                }
                return;
            case 2:
                if (!this.Fh.contains(view)) {
                    this.Fh.add(view);
                    return;
                }
                return;
            case 3:
                if (!this.Fi.contains(view)) {
                    this.Fi.add(view);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void b(View view, int i) {
        switch (i) {
            case 1:
                this.Fg.remove(view);
                return;
            case 2:
                this.Fh.remove(view);
                return;
            case 3:
                this.Fi.remove(view);
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
        int i9 = this.Fk + this.Fl;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (View view : this.Fg) {
            if (view.getVisibility() != 8) {
                a aVar = (a) view.getLayoutParams();
                a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                measureChildWithMargins(view, i8, i14 + i9, i2, i11);
                int measuredWidth = view.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin;
                int measuredHeight = view.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin;
                int k = k(i14, measuredWidth, this.Fj[0]);
                i11 = l(i11, measuredHeight, this.Fj[0]);
                if ((i5 != 0 && k >= i4) || (i7 != 0 && i11 >= i6)) {
                    setMeasuredDimension(this.Fk + k, i11);
                    this.Fm[0] = k;
                    this.Fm[1] = -1;
                    this.Fm[2] = -1;
                    return;
                }
                i14 = k;
            }
        }
        this.Fm[0] = i14;
        int i15 = 0;
        for (View view2 : this.Fi) {
            if (view2.getVisibility() != 8) {
                a aVar2 = (a) view2.getLayoutParams();
                if (aVar2 == null) {
                    aVar2 = generateDefaultLayoutParams();
                }
                measureChildWithMargins(view2, i8, i14 + i15 + i9, i2, i13);
                int measuredWidth2 = view2.getMeasuredWidth() + aVar2.leftMargin + aVar2.rightMargin;
                int measuredHeight2 = view2.getMeasuredHeight() + aVar2.topMargin + aVar2.bottomMargin;
                int k2 = k(i15, measuredWidth2, this.Fj[2]);
                i13 = l(i13, measuredHeight2, this.Fj[2]);
                if ((i5 != 0 && k2 > i4 - i14) || (i7 != 0 && i13 > i6)) {
                    setMeasuredDimension(i14 + k2 + this.Fk + this.Fl, Math.max(i11, i13));
                    this.Fm[2] = k2;
                    this.Fm[1] = -1;
                    return;
                }
                i15 = k2;
            }
        }
        this.Fm[2] = i15;
        switch (i5) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int i16 = (((i4 - i14) - i15) - this.Fk) - this.Fl;
                i3 = 0;
                int i17 = 0;
                for (View view3 : this.Fh) {
                    if (view3.getVisibility() != 8) {
                        a aVar3 = (a) view3.getLayoutParams();
                        if (aVar3 == null) {
                            aVar3 = generateDefaultLayoutParams();
                        }
                        measureChildWithMargins(view3, i8, i17 + i14 + i15 + i9, i2, 0);
                        int measuredWidth3 = view3.getMeasuredWidth() + aVar3.leftMargin + aVar3.rightMargin;
                        int measuredHeight3 = aVar3.bottomMargin + view3.getMeasuredHeight() + aVar3.topMargin;
                        i17 = k(i17, measuredWidth3, this.Fj[1]);
                        i3 = l(i3, measuredHeight3, this.Fj[1]);
                    }
                }
                i10 = Math.min(i17, i16);
                break;
            case 0:
                for (View view4 : this.Fh) {
                    a aVar4 = (a) view4.getLayoutParams();
                    if (aVar4 == null) {
                        aVar4 = generateDefaultLayoutParams();
                    }
                    measureChild(view4, i4, i6);
                    int measuredWidth4 = view4.getMeasuredWidth() + aVar4.leftMargin + aVar4.rightMargin;
                    int measuredHeight4 = view4.getMeasuredHeight() + aVar4.topMargin + aVar4.bottomMargin;
                    i10 = k(i10, measuredWidth4, this.Fj[1]);
                    i12 = l(i12, measuredHeight4, this.Fj[1]);
                }
                i3 = i12;
                break;
            case 1073741824:
                int paddingLeft = ((((i4 - i14) - i15) - i9) - getPaddingLeft()) - getPaddingRight();
                i3 = 0;
                for (View view5 : this.Fh) {
                    if (view5.getVisibility() != 8) {
                        a aVar5 = (a) view5.getLayoutParams();
                        if (aVar5 == null) {
                            aVar5 = generateDefaultLayoutParams();
                        }
                        measureChildWithMargins(view5, i8, i14 + i15 + i9, i2, 0);
                        i3 = l(i3, aVar5.bottomMargin + view5.getMeasuredHeight() + aVar5.topMargin, this.Fj[1]);
                    }
                }
                i10 = paddingLeft;
                break;
            default:
                i3 = i12;
                break;
        }
        this.Fm[1] = i10;
        switch (i7) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
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
        setMeasuredDimension(i14 + i10 + i15 + this.Fk + this.Fl + getPaddingLeft() + getPaddingRight(), max);
    }

    private int k(int i, int i2, int i3) {
        if (i3 == 1) {
            return Math.max(i2, i);
        }
        if (i3 == 0) {
            return i + i2;
        }
        return 0;
    }

    private int l(int i, int i2, int i3) {
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
        if (this.Fm[0] != -1) {
            a(this.Fg, paddingLeft, paddingTop, this.Fm[0]);
            int i5 = paddingLeft + this.Fm[0] + this.Fk;
            if (this.Fm[1] != -1) {
                a(this.Fh, i5, paddingTop, this.Fm[1]);
                int i6 = i5 + this.Fm[1] + this.Fl;
                if (this.Fm[2] != -1) {
                    a(this.Fi, i6, paddingTop, this.Fm[2]);
                }
            }
        }
    }

    private void a(List<View> list, int i, int i2, int i3) {
        int i4;
        int i5 = this.Fj[0];
        int measuredHeight = getMeasuredHeight();
        for (View view : list) {
            if (view.getVisibility() != 8) {
                a aVar = (a) view.getLayoutParams();
                a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                if (i5 == 1) {
                    i4 = generateDefaultLayoutParams.gravity & 7;
                } else {
                    i4 = generateDefaultLayoutParams.gravity & SocialAPIErrorCodes.ERROR_EXPIRED_SESSION_KEY;
                }
                switch (i4) {
                    case 1:
                        int i6 = generateDefaultLayoutParams.topMargin + i2;
                        int measuredHeight2 = view.getMeasuredHeight() + i6;
                        view.layout(((((i3 - generateDefaultLayoutParams.leftMargin) - generateDefaultLayoutParams.rightMargin) - view.getMeasuredWidth()) + i) >> 1, i6, ((((i3 - generateDefaultLayoutParams.leftMargin) - generateDefaultLayoutParams.rightMargin) + view.getMeasuredWidth()) + i) >> 1, measuredHeight2);
                        i2 = measuredHeight2 + generateDefaultLayoutParams.bottomMargin;
                        continue;
                    case 3:
                        int i7 = generateDefaultLayoutParams.topMargin + i2;
                        int measuredWidth = generateDefaultLayoutParams.leftMargin + i + view.getMeasuredWidth();
                        int measuredHeight3 = view.getMeasuredHeight() + i7;
                        view.layout(generateDefaultLayoutParams.leftMargin + i, i7, measuredWidth, measuredHeight3);
                        i2 = measuredHeight3 + generateDefaultLayoutParams.bottomMargin;
                        continue;
                    case 5:
                        int measuredWidth2 = ((i + i3) - generateDefaultLayoutParams.rightMargin) - view.getMeasuredWidth();
                        int i8 = generateDefaultLayoutParams.topMargin + i2;
                        int i9 = (i + i3) - generateDefaultLayoutParams.rightMargin;
                        int measuredHeight4 = view.getMeasuredHeight() + i8;
                        view.layout(measuredWidth2, i8, i9, measuredHeight4);
                        i2 = measuredHeight4 + generateDefaultLayoutParams.bottomMargin;
                        continue;
                    case 16:
                        int i10 = generateDefaultLayoutParams.leftMargin + i;
                        int measuredWidth3 = view.getMeasuredWidth() + i10;
                        view.layout(i10, ((((measuredHeight - generateDefaultLayoutParams.topMargin) - generateDefaultLayoutParams.bottomMargin) - view.getMeasuredHeight()) + i2) >> 1, measuredWidth3, ((((measuredHeight - generateDefaultLayoutParams.topMargin) - generateDefaultLayoutParams.bottomMargin) + view.getMeasuredHeight()) + i2) >> 1);
                        i = measuredWidth3 + generateDefaultLayoutParams.rightMargin;
                        continue;
                    case 48:
                        int i11 = generateDefaultLayoutParams.leftMargin + i;
                        int measuredWidth4 = view.getMeasuredWidth() + i11;
                        view.layout(i11, generateDefaultLayoutParams.topMargin + i2, measuredWidth4, generateDefaultLayoutParams.topMargin + i2 + view.getMeasuredHeight());
                        i = measuredWidth4 + generateDefaultLayoutParams.rightMargin;
                        continue;
                    case 80:
                        int i12 = generateDefaultLayoutParams.leftMargin + i;
                        int measuredHeight5 = ((i2 + measuredHeight) - generateDefaultLayoutParams.bottomMargin) - view.getMeasuredHeight();
                        int measuredWidth5 = view.getMeasuredWidth() + i12;
                        view.layout(i12, measuredHeight5, measuredWidth5, (i2 + measuredHeight) - generateDefaultLayoutParams.bottomMargin);
                        i = measuredWidth5 + generateDefaultLayoutParams.rightMargin;
                        continue;
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
            this.column = obtainStyledAttributes.getInt(0, 1);
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
    /* renamed from: mH */
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
