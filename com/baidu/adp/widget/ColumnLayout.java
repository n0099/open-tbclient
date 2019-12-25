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
    private static final Pattern COLUMN_ORIENTATION_PATTERN = Pattern.compile("(vertical|horizontal)(\\|(vertical|horizontal))*");
    private int[] mColumnOrientation;
    private final int[] mColumnWidth;
    private final List<View> mLeftGroup;
    private final List<View> mMiddleGroup;
    private final List<View> mRightGroup;
    private int mSpacingLeft;
    private int mSpacingRight;

    public ColumnLayout(Context context) {
        this(context, null, 0);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ColumnLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLeftGroup = new ArrayList();
        this.mMiddleGroup = new ArrayList();
        this.mRightGroup = new ArrayList();
        this.mColumnOrientation = new int[]{0, 0, 0};
        this.mColumnWidth = new int[3];
        parseAttrs(context, attributeSet);
    }

    private void parseAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColumnLayout);
        String string = obtainStyledAttributes.getString(R.styleable.ColumnLayout_columnOrientation);
        if (string == null) {
            string = com.baidu.live.adp.widget.VerticalTranslateLayout.VERTICAL;
        }
        if (COLUMN_ORIENTATION_PATTERN.matcher(string).matches()) {
            this.mColumnOrientation = new int[3];
            String[] split = string.split(EditTextPasteFilterUtils.EDITTEXT_PASTE_INTERCEPTOR_SEPERATOR);
            if (split.length == 1) {
                int orientationStrToI = orientationStrToI(split[0]);
                for (int i = 0; i < this.mColumnOrientation.length; i++) {
                    this.mColumnOrientation[i] = orientationStrToI;
                }
            } else if (split.length > 1) {
                if (this.mColumnOrientation.length != split.length) {
                    throw new RuntimeException("Column number doesn't equal orientation definition number.");
                }
                for (int i2 = 0; i2 < this.mColumnOrientation.length; i2++) {
                    this.mColumnOrientation[i2] = orientationStrToI(split[i2]);
                }
            }
        }
        this.mSpacingLeft = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColumnLayout_spacingLeft, 0);
        this.mSpacingRight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ColumnLayout_spacingRight, 0);
        obtainStyledAttributes.recycle();
    }

    private int orientationStrToI(String str) {
        return com.baidu.live.adp.widget.VerticalTranslateLayout.VERTICAL.equals(str) ? 1 : 0;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = generateDefaultLayoutParams();
        }
        addViewToGroup(view, layoutParams2.column);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        super.removeView(view);
        removeViewFromGroup(view, ((LayoutParams) view.getLayoutParams()).column);
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
        this.mLeftGroup.clear();
        this.mMiddleGroup.clear();
        this.mRightGroup.clear();
    }

    private void addViewToGroup(View view, int i) {
        switch (i) {
            case 1:
                if (!this.mLeftGroup.contains(view)) {
                    this.mLeftGroup.add(view);
                    return;
                }
                return;
            case 2:
                if (!this.mMiddleGroup.contains(view)) {
                    this.mMiddleGroup.add(view);
                    return;
                }
                return;
            case 3:
                if (!this.mRightGroup.contains(view)) {
                    this.mRightGroup.add(view);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void removeViewFromGroup(View view, int i) {
        switch (i) {
            case 1:
                this.mLeftGroup.remove(view);
                return;
            case 2:
                this.mMiddleGroup.remove(view);
                return;
            case 3:
                this.mRightGroup.remove(view);
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
        int i9 = this.mSpacingLeft + this.mSpacingRight;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (View view : this.mLeftGroup) {
            if (view.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                LayoutParams generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : layoutParams;
                measureChildWithMargins(view, i8, i14 + i9, i2, i11);
                int measuredWidth = view.getMeasuredWidth() + generateDefaultLayoutParams.leftMargin + generateDefaultLayoutParams.rightMargin;
                int measuredHeight = view.getMeasuredHeight() + generateDefaultLayoutParams.topMargin + generateDefaultLayoutParams.bottomMargin;
                int populateWidthByOrientation = populateWidthByOrientation(i14, measuredWidth, this.mColumnOrientation[0]);
                i11 = populateHeightByOrientation(i11, measuredHeight, this.mColumnOrientation[0]);
                if ((i5 != 0 && populateWidthByOrientation >= i4) || (i7 != 0 && i11 >= i6)) {
                    setMeasuredDimension(this.mSpacingLeft + populateWidthByOrientation, i11);
                    this.mColumnWidth[0] = populateWidthByOrientation;
                    this.mColumnWidth[1] = -1;
                    this.mColumnWidth[2] = -1;
                    return;
                }
                i14 = populateWidthByOrientation;
            }
        }
        this.mColumnWidth[0] = i14;
        int i15 = 0;
        for (View view2 : this.mRightGroup) {
            if (view2.getVisibility() != 8) {
                LayoutParams layoutParams2 = (LayoutParams) view2.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = generateDefaultLayoutParams();
                }
                measureChildWithMargins(view2, i8, i14 + i15 + i9, i2, i13);
                int measuredWidth2 = view2.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin;
                int measuredHeight2 = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                int populateWidthByOrientation2 = populateWidthByOrientation(i15, measuredWidth2, this.mColumnOrientation[2]);
                i13 = populateHeightByOrientation(i13, measuredHeight2, this.mColumnOrientation[2]);
                if ((i5 != 0 && populateWidthByOrientation2 > i4 - i14) || (i7 != 0 && i13 > i6)) {
                    setMeasuredDimension(i14 + populateWidthByOrientation2 + this.mSpacingLeft + this.mSpacingRight, Math.max(i11, i13));
                    this.mColumnWidth[2] = populateWidthByOrientation2;
                    this.mColumnWidth[1] = -1;
                    return;
                }
                i15 = populateWidthByOrientation2;
            }
        }
        this.mColumnWidth[2] = i15;
        switch (i5) {
            case Integer.MIN_VALUE:
                int i16 = (((i4 - i14) - i15) - this.mSpacingLeft) - this.mSpacingRight;
                i3 = 0;
                int i17 = 0;
                for (View view3 : this.mMiddleGroup) {
                    if (view3.getVisibility() != 8) {
                        LayoutParams layoutParams3 = (LayoutParams) view3.getLayoutParams();
                        if (layoutParams3 == null) {
                            layoutParams3 = generateDefaultLayoutParams();
                        }
                        measureChildWithMargins(view3, i8, i17 + i14 + i15 + i9, i2, 0);
                        int measuredWidth3 = view3.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin;
                        int measuredHeight3 = layoutParams3.bottomMargin + view3.getMeasuredHeight() + layoutParams3.topMargin;
                        i17 = populateWidthByOrientation(i17, measuredWidth3, this.mColumnOrientation[1]);
                        i3 = populateHeightByOrientation(i3, measuredHeight3, this.mColumnOrientation[1]);
                    }
                }
                i10 = Math.min(i17, i16);
                break;
            case 0:
                for (View view4 : this.mMiddleGroup) {
                    LayoutParams layoutParams4 = (LayoutParams) view4.getLayoutParams();
                    if (layoutParams4 == null) {
                        layoutParams4 = generateDefaultLayoutParams();
                    }
                    measureChild(view4, i4, i6);
                    int measuredWidth4 = view4.getMeasuredWidth() + layoutParams4.leftMargin + layoutParams4.rightMargin;
                    int measuredHeight4 = view4.getMeasuredHeight() + layoutParams4.topMargin + layoutParams4.bottomMargin;
                    i10 = populateWidthByOrientation(i10, measuredWidth4, this.mColumnOrientation[1]);
                    i12 = populateHeightByOrientation(i12, measuredHeight4, this.mColumnOrientation[1]);
                }
                i3 = i12;
                break;
            case 1073741824:
                int paddingLeft = ((((i4 - i14) - i15) - i9) - getPaddingLeft()) - getPaddingRight();
                i3 = 0;
                for (View view5 : this.mMiddleGroup) {
                    if (view5.getVisibility() != 8) {
                        LayoutParams layoutParams5 = (LayoutParams) view5.getLayoutParams();
                        if (layoutParams5 == null) {
                            layoutParams5 = generateDefaultLayoutParams();
                        }
                        measureChildWithMargins(view5, i8, i14 + i15 + i9, i2, 0);
                        i3 = populateHeightByOrientation(i3, layoutParams5.bottomMargin + view5.getMeasuredHeight() + layoutParams5.topMargin, this.mColumnOrientation[1]);
                    }
                }
                i10 = paddingLeft;
                break;
            default:
                i3 = i12;
                break;
        }
        this.mColumnWidth[1] = i10;
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
        setMeasuredDimension(i14 + i10 + i15 + this.mSpacingLeft + this.mSpacingRight + getPaddingLeft() + getPaddingRight(), max);
    }

    private int populateWidthByOrientation(int i, int i2, int i3) {
        if (i3 == 1) {
            return Math.max(i2, i);
        }
        if (i3 == 0) {
            return i + i2;
        }
        return 0;
    }

    private int populateHeightByOrientation(int i, int i2, int i3) {
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
        if (this.mColumnWidth[0] != -1) {
            layoutGroup(1, this.mLeftGroup, paddingLeft, paddingTop, this.mColumnWidth[0]);
            int i5 = paddingLeft + this.mColumnWidth[0] + this.mSpacingLeft;
            if (this.mColumnWidth[1] != -1) {
                layoutGroup(2, this.mMiddleGroup, i5, paddingTop, this.mColumnWidth[1]);
                int i6 = i5 + this.mColumnWidth[1] + this.mSpacingRight;
                if (this.mColumnWidth[2] != -1) {
                    layoutGroup(3, this.mRightGroup, i6, paddingTop, this.mColumnWidth[2]);
                }
            }
        }
    }

    private void layoutGroup(int i, List<View> list, int i2, int i3, int i4) {
        if (i >= 1 && i <= 3) {
            int i5 = this.mColumnOrientation[i - 1];
            int measuredHeight = getMeasuredHeight();
            for (View view : list) {
                if (view.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    LayoutParams generateDefaultLayoutParams = layoutParams == null ? generateDefaultLayoutParams() : layoutParams;
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

    public void setSpacingRight(int i) {
        this.mSpacingRight = i;
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends FrameLayout.LayoutParams {
        public int column;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.column = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ColumnLayout_Layout);
            this.column = obtainStyledAttributes.getInt(R.styleable.ColumnLayout_Layout_layout_column, 1);
            obtainStyledAttributes.recycle();
            if (this.gravity == -1) {
                this.gravity = 51;
            }
        }

        public LayoutParams(int i, int i2, int i3, int i4) {
            super(i, i2, i3);
            this.column = 1;
            this.column = i4;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.column = 1;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    /* renamed from: jT */
    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2, 51, 1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
