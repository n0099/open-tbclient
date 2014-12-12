package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.R;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class ColumnLayout extends ViewGroup {
    private static final Pattern ul = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");
    private final List<View> um;
    private final List<View> uo;
    private final List<View> uq;
    private int[] ur;
    private int us;
    private int ut;
    private final int[] uu;

    public ColumnLayout(Context context) {
        this(context, null, 0);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.um = new ArrayList();
        this.uo = new ArrayList();
        this.uq = new ArrayList();
        this.ur = new int[3];
        this.uu = new int[3];
        b(context, attributeSet);
    }

    private void b(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColumnLayout);
        String string = obtainStyledAttributes.getString(0);
        if (string == null) {
            string = "vertical";
        }
        if (ul.matcher(string).matches()) {
            this.ur = new int[3];
            String[] split = string.split("\\|");
            if (split.length == 1) {
                int bz = bz(split[0]);
                for (int i = 0; i < this.ur.length; i++) {
                    this.ur[i] = bz;
                }
            } else if (split.length > 1) {
                if (this.ur.length != split.length) {
                    throw new RuntimeException("Column number doesn't equal orientation definition number.");
                }
                for (int i2 = 0; i2 < this.ur.length; i2++) {
                    this.ur[i2] = bz(split[i2]);
                }
            }
        }
        this.us = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.ut = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        obtainStyledAttributes.recycle();
    }

    private int bz(String str) {
        return "vertical".equals(str) ? 1 : 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        d dVar = (d) view.getLayoutParams();
        if (dVar == null) {
            dVar = generateDefaultLayoutParams();
        }
        a(view, dVar.column);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        b(view, ((d) view.getLayoutParams()).column);
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
        this.um.clear();
        this.uo.clear();
        this.uq.clear();
    }

    private void a(View view, int i) {
        switch (i) {
            case 1:
                if (!this.um.contains(view)) {
                    this.um.add(view);
                    return;
                }
                return;
            case 2:
                if (!this.uo.contains(view)) {
                    this.uo.add(view);
                    return;
                }
                return;
            case 3:
                if (!this.uq.contains(view)) {
                    this.uq.add(view);
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
                this.um.remove(view);
                return;
            case 2:
                this.uo.remove(view);
                return;
            case 3:
                this.uq.remove(view);
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
        int i9 = this.us + this.ut;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (View view : this.um) {
            if (view.getVisibility() != 8) {
                d dVar = (d) view.getLayoutParams();
                d generateDefaultLayoutParams = dVar == null ? generateDefaultLayoutParams() : dVar;
                measureChildWithMargins(view, i8, i14 + i9, i2, i11);
                int measuredWidth = view.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin;
                int measuredHeight = view.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin;
                int n = n(i14, measuredWidth, this.ur[0]);
                i11 = o(i11, measuredHeight, this.ur[0]);
                if ((i5 != 0 && n >= i4) || (i7 != 0 && i11 >= i6)) {
                    setMeasuredDimension(this.us + n, i11);
                    this.uu[0] = n;
                    this.uu[1] = -1;
                    this.uu[2] = -1;
                    return;
                }
                i14 = n;
            }
        }
        this.uu[0] = i14;
        int i15 = 0;
        for (View view2 : this.uq) {
            if (view2.getVisibility() != 8) {
                d dVar2 = (d) view2.getLayoutParams();
                if (dVar2 == null) {
                    dVar2 = generateDefaultLayoutParams();
                }
                measureChildWithMargins(view2, i8, i14 + i15 + i9, i2, i13);
                int measuredWidth2 = view2.getMeasuredWidth() + dVar2.leftMargin + dVar2.rightMargin;
                int measuredHeight2 = view2.getMeasuredHeight() + dVar2.topMargin + dVar2.bottomMargin;
                int n2 = n(i15, measuredWidth2, this.ur[2]);
                i13 = o(i13, measuredHeight2, this.ur[2]);
                if ((i5 != 0 && n2 > i4 - i14) || (i7 != 0 && i13 > i6)) {
                    setMeasuredDimension(i14 + n2 + this.us + this.ut, Math.max(i11, i13));
                    this.uu[2] = n2;
                    this.uu[1] = -1;
                    return;
                }
                i15 = n2;
            }
        }
        this.uu[2] = i15;
        switch (i5) {
            case ExploreByTouchHelper.INVALID_ID /* -2147483648 */:
                int i16 = (((i4 - i14) - i15) - this.us) - this.ut;
                i3 = 0;
                int i17 = 0;
                for (View view3 : this.uo) {
                    if (view3.getVisibility() != 8) {
                        d dVar3 = (d) view3.getLayoutParams();
                        if (dVar3 == null) {
                            dVar3 = generateDefaultLayoutParams();
                        }
                        measureChildWithMargins(view3, i8, i17 + i14 + i15 + i9, i2, 0);
                        int measuredWidth3 = view3.getMeasuredWidth() + dVar3.leftMargin + dVar3.rightMargin;
                        int measuredHeight3 = dVar3.bottomMargin + view3.getMeasuredHeight() + dVar3.topMargin;
                        i17 = n(i17, measuredWidth3, this.ur[1]);
                        i3 = o(i3, measuredHeight3, this.ur[1]);
                    }
                }
                i10 = Math.min(i17, i16);
                break;
            case 0:
                for (View view4 : this.uo) {
                    d dVar4 = (d) view4.getLayoutParams();
                    if (dVar4 == null) {
                        dVar4 = generateDefaultLayoutParams();
                    }
                    measureChild(view4, i4, i6);
                    int measuredWidth4 = view4.getMeasuredWidth() + dVar4.leftMargin + dVar4.rightMargin;
                    int measuredHeight4 = view4.getMeasuredHeight() + dVar4.topMargin + dVar4.bottomMargin;
                    i10 = n(i10, measuredWidth4, this.ur[1]);
                    i12 = o(i12, measuredHeight4, this.ur[1]);
                }
                i3 = i12;
                break;
            case 1073741824:
                int paddingLeft = ((((i4 - i14) - i15) - i9) - getPaddingLeft()) - getPaddingRight();
                i3 = 0;
                for (View view5 : this.uo) {
                    if (view5.getVisibility() != 8) {
                        d dVar5 = (d) view5.getLayoutParams();
                        if (dVar5 == null) {
                            dVar5 = generateDefaultLayoutParams();
                        }
                        measureChildWithMargins(view5, i8, i14 + i15 + i9, i2, 0);
                        i3 = o(i3, dVar5.bottomMargin + view5.getMeasuredHeight() + dVar5.topMargin, this.ur[1]);
                    }
                }
                i10 = paddingLeft;
                break;
            default:
                i3 = i12;
                break;
        }
        this.uu[1] = i10;
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
        setMeasuredDimension(i14 + i10 + i15 + this.us + this.ut + getPaddingLeft() + getPaddingRight(), max);
    }

    private int n(int i, int i2, int i3) {
        if (i3 == 1) {
            return Math.max(i2, i);
        }
        if (i3 == 0) {
            return i + i2;
        }
        return 0;
    }

    private int o(int i, int i2, int i3) {
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
        if (this.uu[0] != -1) {
            a(this.um, paddingLeft, paddingTop, this.uu[0]);
            int i5 = paddingLeft + this.uu[0] + this.us;
            if (this.uu[1] != -1) {
                a(this.uo, i5, paddingTop, this.uu[1]);
                int i6 = i5 + this.uu[1] + this.ut;
                if (this.uu[2] != -1) {
                    a(this.uq, i6, paddingTop, this.uu[2]);
                }
            }
        }
    }

    private void a(List<View> list, int i, int i2, int i3) {
        int i4;
        int i5 = this.ur[0];
        int measuredHeight = getMeasuredHeight();
        for (View view : list) {
            if (view.getVisibility() != 8) {
                d dVar = (d) view.getLayoutParams();
                d generateDefaultLayoutParams = dVar == null ? generateDefaultLayoutParams() : dVar;
                if (i5 == 1) {
                    i4 = generateDefaultLayoutParams.gravity & 7;
                } else {
                    i4 = generateDefaultLayoutParams.gravity & Constants.MEDIA_POSITION_UPDATE;
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

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: iN */
    public d generateDefaultLayoutParams() {
        return new d(-2, -2, 51, 1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new d(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new d(layoutParams);
    }
}
