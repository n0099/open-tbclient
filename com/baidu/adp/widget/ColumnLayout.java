package com.baidu.adp.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.lightapp.plugin.videoplayer.coreplayer.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class ColumnLayout extends ViewGroup {
    private static final Pattern a = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");
    private final List<View> b;
    private final List<View> c;
    private final List<View> d;
    private int[] e;
    private int f;
    private int g;
    private final int[] h;

    public ColumnLayout(Context context) {
        this(context, null, 0);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new ArrayList();
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new int[3];
        this.h = new int[3];
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.baidu.adp.g.ColumnLayout);
        String string = obtainStyledAttributes.getString(0);
        if (string == null) {
            string = "vertical";
        }
        if (a.matcher(string).matches()) {
            this.e = new int[3];
            String[] split = string.split("\\|");
            if (split.length == 1) {
                int a2 = a(split[0]);
                for (int i = 0; i < this.e.length; i++) {
                    this.e[i] = a2;
                }
            } else if (split.length > 1) {
                if (this.e.length != split.length) {
                    throw new RuntimeException("Column number doesn't equal orientation definition number.");
                }
                for (int i2 = 0; i2 < this.e.length; i2++) {
                    this.e[i2] = a(split[i2]);
                }
            }
        }
        this.f = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.g = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        obtainStyledAttributes.recycle();
    }

    private int a(String str) {
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
        a(view, dVar.a);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        b(view, ((d) view.getLayoutParams()).a);
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
        this.b.clear();
        this.c.clear();
        this.d.clear();
    }

    private void a(View view, int i) {
        switch (i) {
            case 1:
                if (!this.b.contains(view)) {
                    this.b.add(view);
                    return;
                }
                return;
            case 2:
                if (!this.c.contains(view)) {
                    this.c.add(view);
                    return;
                }
                return;
            case 3:
                if (!this.d.contains(view)) {
                    this.d.add(view);
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
                this.b.remove(view);
                return;
            case 2:
                this.c.remove(view);
                return;
            case 3:
                this.d.remove(view);
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
        int i9 = this.f + this.g;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (View view : this.b) {
            if (view.getVisibility() != 8) {
                d dVar = (d) view.getLayoutParams();
                d generateDefaultLayoutParams = dVar == null ? generateDefaultLayoutParams() : dVar;
                measureChildWithMargins(view, i8, i14 + i9, i2, i11);
                int measuredWidth = view.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin;
                int measuredHeight = view.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin;
                int a2 = a(i14, measuredWidth, this.e[0]);
                i11 = b(i11, measuredHeight, this.e[0]);
                if ((i5 != 0 && a2 >= i4) || (i7 != 0 && i11 >= i6)) {
                    setMeasuredDimension(this.f + a2, i11);
                    this.h[0] = a2;
                    this.h[1] = -1;
                    this.h[2] = -1;
                    return;
                }
                i14 = a2;
            }
        }
        this.h[0] = i14;
        int i15 = 0;
        for (View view2 : this.d) {
            if (view2.getVisibility() != 8) {
                d dVar2 = (d) view2.getLayoutParams();
                if (dVar2 == null) {
                    dVar2 = generateDefaultLayoutParams();
                }
                measureChildWithMargins(view2, i8, i14 + i15 + i9, i2, i13);
                int measuredWidth2 = view2.getMeasuredWidth() + dVar2.leftMargin + dVar2.rightMargin;
                int measuredHeight2 = view2.getMeasuredHeight() + dVar2.topMargin + dVar2.bottomMargin;
                int a3 = a(i15, measuredWidth2, this.e[2]);
                i13 = b(i13, measuredHeight2, this.e[2]);
                if ((i5 != 0 && a3 > i4 - i14) || (i7 != 0 && i13 > i6)) {
                    setMeasuredDimension(i14 + a3 + this.f + this.g, Math.max(i11, i13));
                    this.h[2] = a3;
                    this.h[1] = -1;
                    return;
                }
                i15 = a3;
            }
        }
        this.h[2] = i15;
        switch (i5) {
            case Integer.MIN_VALUE:
                int i16 = (((i4 - i14) - i15) - this.f) - this.g;
                i3 = 0;
                int i17 = 0;
                for (View view3 : this.c) {
                    if (view3.getVisibility() != 8) {
                        d dVar3 = (d) view3.getLayoutParams();
                        if (dVar3 == null) {
                            dVar3 = generateDefaultLayoutParams();
                        }
                        measureChildWithMargins(view3, i8, i17 + i14 + i15 + i9, i2, 0);
                        int measuredWidth3 = view3.getMeasuredWidth() + dVar3.leftMargin + dVar3.rightMargin;
                        int measuredHeight3 = dVar3.bottomMargin + view3.getMeasuredHeight() + dVar3.topMargin;
                        i17 = a(i17, measuredWidth3, this.e[1]);
                        i3 = b(i3, measuredHeight3, this.e[1]);
                    }
                }
                i10 = Math.min(i17, i16);
                break;
            case 0:
                for (View view4 : this.c) {
                    d dVar4 = (d) view4.getLayoutParams();
                    if (dVar4 == null) {
                        dVar4 = generateDefaultLayoutParams();
                    }
                    measureChild(view4, i4, i6);
                    int measuredWidth4 = view4.getMeasuredWidth() + dVar4.leftMargin + dVar4.rightMargin;
                    int measuredHeight4 = view4.getMeasuredHeight() + dVar4.topMargin + dVar4.bottomMargin;
                    i10 = a(i10, measuredWidth4, this.e[1]);
                    i12 = b(i12, measuredHeight4, this.e[1]);
                }
                i3 = i12;
                break;
            case 1073741824:
                int paddingLeft = ((((i4 - i14) - i15) - i9) - getPaddingLeft()) - getPaddingRight();
                i3 = 0;
                for (View view5 : this.c) {
                    if (view5.getVisibility() != 8) {
                        d dVar5 = (d) view5.getLayoutParams();
                        if (dVar5 == null) {
                            dVar5 = generateDefaultLayoutParams();
                        }
                        measureChildWithMargins(view5, i8, i14 + i15 + i9, i2, 0);
                        i3 = b(i3, dVar5.bottomMargin + view5.getMeasuredHeight() + dVar5.topMargin, this.e[1]);
                    }
                }
                i10 = paddingLeft;
                break;
            default:
                i3 = i12;
                break;
        }
        this.h[1] = i10;
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
        setMeasuredDimension(i14 + i10 + i15 + this.f + this.g + getPaddingLeft() + getPaddingRight(), max);
    }

    private int a(int i, int i2, int i3) {
        if (i3 == 1) {
            return Math.max(i2, i);
        }
        if (i3 == 0) {
            return i + i2;
        }
        return 0;
    }

    private int b(int i, int i2, int i3) {
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
        if (this.h[0] != -1) {
            a(this.b, paddingLeft, paddingTop, this.h[0]);
            int i5 = paddingLeft + this.h[0] + this.f;
            if (this.h[1] != -1) {
                a(this.c, i5, paddingTop, this.h[1]);
                int i6 = i5 + this.h[1] + this.g;
                if (this.h[2] != -1) {
                    a(this.d, i6, paddingTop, this.h[2]);
                }
            }
        }
    }

    private void a(List<View> list, int i, int i2, int i3) {
        int i4;
        int i5 = this.e[0];
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
    /* renamed from: a */
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
