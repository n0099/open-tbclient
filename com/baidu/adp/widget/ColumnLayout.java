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
    private static final Pattern xa = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");
    private final List<View> xb;
    private final List<View> xc;
    private final List<View> xd;
    private int[] xe;
    private int xf;
    private int xg;
    private final int[] xh;

    public ColumnLayout(Context context) {
        this(context, null, 0);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.xb = new ArrayList();
        this.xc = new ArrayList();
        this.xd = new ArrayList();
        this.xe = new int[3];
        this.xh = new int[3];
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColumnLayout);
        String string = obtainStyledAttributes.getString(0);
        if (string == null) {
            string = "vertical";
        }
        if (xa.matcher(string).matches()) {
            this.xe = new int[3];
            String[] split = string.split("\\|");
            if (split.length == 1) {
                int bK = bK(split[0]);
                for (int i = 0; i < this.xe.length; i++) {
                    this.xe[i] = bK;
                }
            } else if (split.length > 1) {
                if (this.xe.length != split.length) {
                    throw new RuntimeException("Column number doesn't equal orientation definition number.");
                }
                for (int i2 = 0; i2 < this.xe.length; i2++) {
                    this.xe[i2] = bK(split[i2]);
                }
            }
        }
        this.xf = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.xg = obtainStyledAttributes.getDimensionPixelSize(2, 0);
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
        this.xb.clear();
        this.xc.clear();
        this.xd.clear();
    }

    private void c(View view, int i) {
        switch (i) {
            case 1:
                if (!this.xb.contains(view)) {
                    this.xb.add(view);
                    return;
                }
                return;
            case 2:
                if (!this.xc.contains(view)) {
                    this.xc.add(view);
                    return;
                }
                return;
            case 3:
                if (!this.xd.contains(view)) {
                    this.xd.add(view);
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
                this.xb.remove(view);
                return;
            case 2:
                this.xc.remove(view);
                return;
            case 3:
                this.xd.remove(view);
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
        int i9 = this.xf + this.xg;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (View view : this.xb) {
            if (view.getVisibility() != 8) {
                a aVar = (a) view.getLayoutParams();
                a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                measureChildWithMargins(view, i8, i14 + i9, i2, i11);
                int measuredWidth = view.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin;
                int measuredHeight = view.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin;
                int j = j(i14, measuredWidth, this.xe[0]);
                i11 = k(i11, measuredHeight, this.xe[0]);
                if ((i5 != 0 && j >= i4) || (i7 != 0 && i11 >= i6)) {
                    setMeasuredDimension(this.xf + j, i11);
                    this.xh[0] = j;
                    this.xh[1] = -1;
                    this.xh[2] = -1;
                    return;
                }
                i14 = j;
            }
        }
        this.xh[0] = i14;
        int i15 = 0;
        for (View view2 : this.xd) {
            if (view2.getVisibility() != 8) {
                a aVar2 = (a) view2.getLayoutParams();
                if (aVar2 == null) {
                    aVar2 = generateDefaultLayoutParams();
                }
                measureChildWithMargins(view2, i8, i14 + i15 + i9, i2, i13);
                int measuredWidth2 = view2.getMeasuredWidth() + aVar2.leftMargin + aVar2.rightMargin;
                int measuredHeight2 = view2.getMeasuredHeight() + aVar2.topMargin + aVar2.bottomMargin;
                int j2 = j(i15, measuredWidth2, this.xe[2]);
                i13 = k(i13, measuredHeight2, this.xe[2]);
                if ((i5 != 0 && j2 > i4 - i14) || (i7 != 0 && i13 > i6)) {
                    setMeasuredDimension(i14 + j2 + this.xf + this.xg, Math.max(i11, i13));
                    this.xh[2] = j2;
                    this.xh[1] = -1;
                    return;
                }
                i15 = j2;
            }
        }
        this.xh[2] = i15;
        switch (i5) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int i16 = (((i4 - i14) - i15) - this.xf) - this.xg;
                i3 = 0;
                int i17 = 0;
                for (View view3 : this.xc) {
                    if (view3.getVisibility() != 8) {
                        a aVar3 = (a) view3.getLayoutParams();
                        if (aVar3 == null) {
                            aVar3 = generateDefaultLayoutParams();
                        }
                        measureChildWithMargins(view3, i8, i17 + i14 + i15 + i9, i2, 0);
                        int measuredWidth3 = view3.getMeasuredWidth() + aVar3.leftMargin + aVar3.rightMargin;
                        int measuredHeight3 = aVar3.bottomMargin + view3.getMeasuredHeight() + aVar3.topMargin;
                        i17 = j(i17, measuredWidth3, this.xe[1]);
                        i3 = k(i3, measuredHeight3, this.xe[1]);
                    }
                }
                i10 = Math.min(i17, i16);
                break;
            case 0:
                for (View view4 : this.xc) {
                    a aVar4 = (a) view4.getLayoutParams();
                    if (aVar4 == null) {
                        aVar4 = generateDefaultLayoutParams();
                    }
                    measureChild(view4, i4, i6);
                    int measuredWidth4 = view4.getMeasuredWidth() + aVar4.leftMargin + aVar4.rightMargin;
                    int measuredHeight4 = view4.getMeasuredHeight() + aVar4.topMargin + aVar4.bottomMargin;
                    i10 = j(i10, measuredWidth4, this.xe[1]);
                    i12 = k(i12, measuredHeight4, this.xe[1]);
                }
                i3 = i12;
                break;
            case 1073741824:
                int paddingLeft = ((((i4 - i14) - i15) - i9) - getPaddingLeft()) - getPaddingRight();
                i3 = 0;
                for (View view5 : this.xc) {
                    if (view5.getVisibility() != 8) {
                        a aVar5 = (a) view5.getLayoutParams();
                        if (aVar5 == null) {
                            aVar5 = generateDefaultLayoutParams();
                        }
                        measureChildWithMargins(view5, i8, i14 + i15 + i9, i2, 0);
                        i3 = k(i3, aVar5.bottomMargin + view5.getMeasuredHeight() + aVar5.topMargin, this.xe[1]);
                    }
                }
                i10 = paddingLeft;
                break;
            default:
                i3 = i12;
                break;
        }
        this.xh[1] = i10;
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
        setMeasuredDimension(i14 + i10 + i15 + this.xf + this.xg + getPaddingLeft() + getPaddingRight(), max);
    }

    private int j(int i, int i2, int i3) {
        if (i3 == 1) {
            return Math.max(i2, i);
        }
        if (i3 == 0) {
            return i + i2;
        }
        return 0;
    }

    private int k(int i, int i2, int i3) {
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
        if (this.xh[0] != -1) {
            a(1, this.xb, paddingLeft, paddingTop, this.xh[0]);
            int i5 = paddingLeft + this.xh[0] + this.xf;
            if (this.xh[1] != -1) {
                a(2, this.xc, i5, paddingTop, this.xh[1]);
                int i6 = i5 + this.xh[1] + this.xg;
                if (this.xh[2] != -1) {
                    a(3, this.xd, i6, paddingTop, this.xh[2]);
                }
            }
        }
    }

    private void a(int i, List<View> list, int i2, int i3, int i4) {
        int i5;
        if (i >= 1 && i <= 3) {
            int i6 = this.xe[i - 1];
            int measuredHeight = getMeasuredHeight();
            for (View view : list) {
                if (view.getVisibility() != 8) {
                    a aVar = (a) view.getLayoutParams();
                    a generateDefaultLayoutParams = aVar == null ? generateDefaultLayoutParams() : aVar;
                    if (i6 == 1) {
                        i5 = generateDefaultLayoutParams.gravity & 7;
                    } else {
                        i5 = generateDefaultLayoutParams.gravity & SocialAPIErrorCodes.ERROR_EXPIRED_SESSION_KEY;
                    }
                    switch (i5) {
                        case 1:
                            int i7 = generateDefaultLayoutParams.topMargin + i3;
                            int measuredHeight2 = view.getMeasuredHeight() + i7;
                            view.layout(((((i4 - generateDefaultLayoutParams.leftMargin) - generateDefaultLayoutParams.rightMargin) - view.getMeasuredWidth()) + i2) >> 1, i7, ((((i4 - generateDefaultLayoutParams.leftMargin) - generateDefaultLayoutParams.rightMargin) + view.getMeasuredWidth()) + i2) >> 1, measuredHeight2);
                            i3 = measuredHeight2 + generateDefaultLayoutParams.bottomMargin;
                            continue;
                        case 3:
                            int i8 = generateDefaultLayoutParams.topMargin + i3;
                            int measuredWidth = generateDefaultLayoutParams.leftMargin + i2 + view.getMeasuredWidth();
                            int measuredHeight3 = view.getMeasuredHeight() + i8;
                            view.layout(generateDefaultLayoutParams.leftMargin + i2, i8, measuredWidth, measuredHeight3);
                            i3 = measuredHeight3 + generateDefaultLayoutParams.bottomMargin;
                            continue;
                        case 5:
                            int measuredWidth2 = ((i2 + i4) - generateDefaultLayoutParams.rightMargin) - view.getMeasuredWidth();
                            int i9 = generateDefaultLayoutParams.topMargin + i3;
                            int i10 = (i2 + i4) - generateDefaultLayoutParams.rightMargin;
                            int measuredHeight4 = view.getMeasuredHeight() + i9;
                            view.layout(measuredWidth2, i9, i10, measuredHeight4);
                            i3 = measuredHeight4 + generateDefaultLayoutParams.bottomMargin;
                            continue;
                        case 16:
                            int i11 = generateDefaultLayoutParams.leftMargin + i2;
                            int measuredWidth3 = view.getMeasuredWidth() + i11;
                            view.layout(i11, ((((measuredHeight - generateDefaultLayoutParams.topMargin) - generateDefaultLayoutParams.bottomMargin) - view.getMeasuredHeight()) + i3) >> 1, measuredWidth3, ((((measuredHeight - generateDefaultLayoutParams.topMargin) - generateDefaultLayoutParams.bottomMargin) + view.getMeasuredHeight()) + i3) >> 1);
                            i2 = measuredWidth3 + generateDefaultLayoutParams.rightMargin;
                            continue;
                        case 48:
                            int i12 = generateDefaultLayoutParams.leftMargin + i2;
                            int measuredWidth4 = view.getMeasuredWidth() + i12;
                            view.layout(i12, generateDefaultLayoutParams.topMargin + i3, measuredWidth4, generateDefaultLayoutParams.topMargin + i3 + view.getMeasuredHeight());
                            i2 = measuredWidth4 + generateDefaultLayoutParams.rightMargin;
                            continue;
                        case 80:
                            int i13 = generateDefaultLayoutParams.leftMargin + i2;
                            int measuredHeight5 = ((i3 + measuredHeight) - generateDefaultLayoutParams.bottomMargin) - view.getMeasuredHeight();
                            int measuredWidth5 = view.getMeasuredWidth() + i13;
                            view.layout(i13, measuredHeight5, measuredWidth5, (i3 + measuredHeight) - generateDefaultLayoutParams.bottomMargin);
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
    /* renamed from: iE */
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
