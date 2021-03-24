package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.tbadk.core.data.SmallTailInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    public static final int HORIZONTAL = 0;
    public static final int INDEX_BOTTOM = 2;
    public static final int INDEX_CENTER_VERTICAL = 0;
    public static final int INDEX_FILL = 3;
    public static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    public static final int VERTICAL_GRAVITY_COUNT = 4;
    public boolean mBaselineAligned;
    public int mBaselineAlignedChildIndex;
    public int mBaselineChildTop;
    public Drawable mDivider;
    public int mDividerHeight;
    public int mDividerPadding;
    public int mDividerWidth;
    public int mGravity;
    public int[] mMaxAscent;
    public int[] mMaxDescent;
    public int mOrientation;
    public int mShowDividers;
    public int mTotalLength;
    public boolean mUseLargestChild;
    public float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface DividerMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes.dex */
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                    int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = i4;
                }
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                    int i4 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = i4;
                }
            }
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int i;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View virtualChildAt = getVirtualChildAt(i2);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (isLayoutRtl) {
                    left2 = virtualChildAt.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                } else {
                    left2 = (virtualChildAt.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, left2);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (isLayoutRtl) {
                    left = virtualChildAt2.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin;
                    i = this.mDividerWidth;
                    right = left - i;
                } else {
                    right = virtualChildAt2.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                }
            } else if (isLayoutRtl) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.mDividerWidth;
                right = left - i;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    public void drawDividersVertical(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View virtualChildAt = getVirtualChildAt(i);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((ViewGroup.MarginLayoutParams) ((LayoutParams) virtualChildAt.getLayoutParams())).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                bottom = virtualChildAt2.getBottom() + ((ViewGroup.MarginLayoutParams) ((LayoutParams) virtualChildAt2.getLayoutParams())).bottomMargin;
            }
            drawHorizontalDivider(canvas, bottom);
        }
    }

    public void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    public void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount > i2) {
            View childAt = getChildAt(i2);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.mBaselineAlignedChildIndex == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i3 = this.mBaselineChildTop;
            if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
                if (i == 16) {
                    i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                } else if (i == 80) {
                    i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                }
            }
            return i3 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getLocationOffset(View view) {
        return 0;
    }

    public int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        } else if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        } else if ((this.mShowDividers & 2) != 0) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutHorizontal(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i14 = i4 - i2;
        int paddingBottom = i14 - getPaddingBottom();
        int paddingBottom2 = (i14 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i15 = this.mGravity;
        int i16 = i15 & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i15, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 1) {
            paddingLeft = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        } else if (absoluteGravity != 5) {
            paddingLeft = getPaddingLeft();
        } else {
            paddingLeft = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
        }
        if (isLayoutRtl) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i17 = 0;
        while (i17 < virtualChildCount) {
            int i18 = i5 + (i6 * i17);
            View virtualChildAt = getVirtualChildAt(i18);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i18);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i19 = i17;
                if (z) {
                    i7 = virtualChildCount;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                        i8 = virtualChildAt.getBaseline();
                        i9 = layoutParams.gravity;
                        if (i9 < 0) {
                            i9 = i16;
                        }
                        i10 = i9 & 112;
                        i11 = i16;
                        if (i10 != 16) {
                            i12 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        } else if (i10 == 48) {
                            i12 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                            if (i8 != -1) {
                                i12 += iArr[1] - i8;
                            }
                        } else if (i10 != 80) {
                            i12 = paddingTop;
                        } else {
                            i12 = (paddingBottom - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i8 != -1) {
                                i12 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i8);
                            }
                        }
                        if (hasDividerBeforeChildAt(i18)) {
                            paddingLeft += this.mDividerWidth;
                        }
                        int i20 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                        i13 = paddingTop;
                        setChildFrame(virtualChildAt, i20 + getLocationOffset(virtualChildAt), i12, measuredWidth, measuredHeight);
                        i17 = i19 + getChildrenSkipCount(virtualChildAt, i18);
                        paddingLeft = i20 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(virtualChildAt);
                        i17++;
                        virtualChildCount = i7;
                        i16 = i11;
                        paddingTop = i13;
                    }
                } else {
                    i7 = virtualChildCount;
                }
                i8 = -1;
                i9 = layoutParams.gravity;
                if (i9 < 0) {
                }
                i10 = i9 & 112;
                i11 = i16;
                if (i10 != 16) {
                }
                if (hasDividerBeforeChildAt(i18)) {
                }
                int i202 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                i13 = paddingTop;
                setChildFrame(virtualChildAt, i202 + getLocationOffset(virtualChildAt), i12, measuredWidth, measuredHeight);
                i17 = i19 + getChildrenSkipCount(virtualChildAt, i18);
                paddingLeft = i202 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(virtualChildAt);
                i17++;
                virtualChildCount = i7;
                i16 = i11;
                paddingTop = i13;
            }
            i13 = paddingTop;
            i7 = virtualChildCount;
            i11 = i16;
            i17++;
            virtualChildCount = i7;
            i16 = i11;
            paddingTop = i13;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutVertical(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int i6;
        int i7;
        int paddingLeft = getPaddingLeft();
        int i8 = i3 - i;
        int paddingRight = i8 - getPaddingRight();
        int paddingRight2 = (i8 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i9 = this.mGravity;
        int i10 = i9 & 112;
        int i11 = i9 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i10 == 16) {
            paddingTop = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
        } else if (i10 != 80) {
            paddingTop = getPaddingTop();
        } else {
            paddingTop = ((getPaddingTop() + i4) - i2) - this.mTotalLength;
        }
        int i12 = 0;
        while (i12 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i12);
            if (virtualChildAt == null) {
                paddingTop += measureNullChild(i12);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i13 = layoutParams.gravity;
                if (i13 < 0) {
                    i13 = i11;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i13, ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity == 1) {
                    i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    i6 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                } else if (absoluteGravity != 5) {
                    i7 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                    int i14 = i7;
                    if (hasDividerBeforeChildAt(i12)) {
                        paddingTop += this.mDividerHeight;
                    }
                    int i15 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    setChildFrame(virtualChildAt, i14, i15 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                    i12 += getChildrenSkipCount(virtualChildAt, i12);
                    paddingTop = i15 + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt);
                } else {
                    i5 = paddingRight - measuredWidth;
                    i6 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                i7 = i5 - i6;
                int i142 = i7;
                if (hasDividerBeforeChildAt(i12)) {
                }
                int i152 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                setChildFrame(virtualChildAt, i142, i152 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                i12 += getChildrenSkipCount(virtualChildAt, i12);
                paddingTop = i152 + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt);
            }
            i12++;
        }
    }

    public void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:197:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measureHorizontal(int i, int i2) {
        int[] iArr;
        int i3;
        int max;
        int i4;
        int i5;
        int max2;
        int i6;
        int i7;
        int i8;
        float f2;
        int i9;
        boolean z;
        int baseline;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z2;
        boolean z3;
        View view;
        int i15;
        boolean z4;
        int measuredHeight;
        int childrenSkipCount;
        int baseline2;
        int i16;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr2 = this.mMaxAscent;
        int[] iArr3 = this.mMaxDescent;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z5 = this.mBaselineAligned;
        boolean z6 = this.mUseLargestChild;
        int i17 = 1073741824;
        boolean z7 = mode == 1073741824;
        float f3 = 0.0f;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        boolean z8 = false;
        int i23 = 0;
        boolean z9 = true;
        boolean z10 = false;
        while (true) {
            iArr = iArr3;
            if (i18 >= virtualChildCount) {
                break;
            }
            View virtualChildAt = getVirtualChildAt(i18);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i18);
            } else if (virtualChildAt.getVisibility() == 8) {
                i18 += getChildrenSkipCount(virtualChildAt, i18);
            } else {
                if (hasDividerBeforeChildAt(i18)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                float f4 = layoutParams.weight;
                float f5 = f3 + f4;
                if (mode == i17 && ((ViewGroup.MarginLayoutParams) layoutParams).width == 0 && f4 > 0.0f) {
                    if (z7) {
                        this.mTotalLength += ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    } else {
                        int i24 = this.mTotalLength;
                        this.mTotalLength = Math.max(i24, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + i24 + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    }
                    if (z5) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                        i14 = i18;
                        z2 = z6;
                        z3 = z5;
                        view = virtualChildAt;
                    } else {
                        i14 = i18;
                        z2 = z6;
                        z3 = z5;
                        view = virtualChildAt;
                        i15 = 1073741824;
                        z8 = true;
                        if (mode2 == i15 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                            z4 = true;
                            z10 = true;
                        } else {
                            z4 = false;
                        }
                        int i25 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i25;
                        i23 = View.combineMeasuredStates(i23, view.getMeasuredState());
                        if (z3 && (baseline2 = view.getBaseline()) != -1) {
                            i16 = layoutParams.gravity;
                            if (i16 < 0) {
                                i16 = this.mGravity;
                            }
                            int i26 = (((i16 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i26] = Math.max(iArr2[i26], baseline2);
                            iArr[i26] = Math.max(iArr[i26], measuredHeight - baseline2);
                        }
                        i20 = Math.max(i20, measuredHeight);
                        z9 = !z9 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1;
                        if (layoutParams.weight <= 0.0f) {
                            if (!z4) {
                                i25 = measuredHeight;
                            }
                            i22 = Math.max(i22, i25);
                        } else {
                            int i27 = i22;
                            if (!z4) {
                                i25 = measuredHeight;
                            }
                            i21 = Math.max(i21, i25);
                            i22 = i27;
                        }
                        int i28 = i14;
                        childrenSkipCount = getChildrenSkipCount(view, i28) + i28;
                        f3 = f5;
                        i18 = childrenSkipCount + 1;
                        iArr3 = iArr;
                        z6 = z2;
                        z5 = z3;
                        i17 = 1073741824;
                    }
                } else {
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width != 0 || layoutParams.weight <= 0.0f) {
                        i13 = Integer.MIN_VALUE;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
                        i13 = 0;
                    }
                    i14 = i18;
                    int i29 = i13;
                    z2 = z6;
                    z3 = z5;
                    measureChildBeforeLayout(virtualChildAt, i14, i, f5 == 0.0f ? this.mTotalLength : 0, i2, 0);
                    if (i29 != Integer.MIN_VALUE) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = i29;
                    }
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    if (z7) {
                        view = virtualChildAt;
                        this.mTotalLength += ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(view);
                    } else {
                        view = virtualChildAt;
                        int i30 = this.mTotalLength;
                        this.mTotalLength = Math.max(i30, i30 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(view));
                    }
                    if (z2) {
                        i19 = Math.max(measuredWidth, i19);
                    }
                }
                i15 = 1073741824;
                if (mode2 == i15) {
                }
                z4 = false;
                int i252 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i252;
                i23 = View.combineMeasuredStates(i23, view.getMeasuredState());
                if (z3) {
                    i16 = layoutParams.gravity;
                    if (i16 < 0) {
                    }
                    int i262 = (((i16 & 112) >> 4) & (-2)) >> 1;
                    iArr2[i262] = Math.max(iArr2[i262], baseline2);
                    iArr[i262] = Math.max(iArr[i262], measuredHeight - baseline2);
                }
                i20 = Math.max(i20, measuredHeight);
                if (z9) {
                }
                if (layoutParams.weight <= 0.0f) {
                }
                int i282 = i14;
                childrenSkipCount = getChildrenSkipCount(view, i282) + i282;
                f3 = f5;
                i18 = childrenSkipCount + 1;
                iArr3 = iArr;
                z6 = z2;
                z5 = z3;
                i17 = 1073741824;
            }
            childrenSkipCount = i18;
            z2 = z6;
            z3 = z5;
            i18 = childrenSkipCount + 1;
            iArr3 = iArr;
            z6 = z2;
            z5 = z3;
            i17 = 1073741824;
        }
        boolean z11 = z6;
        boolean z12 = z5;
        int i31 = i20;
        int i32 = i21;
        int i33 = i22;
        int i34 = i23;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            max = i31;
            i3 = i34;
        } else {
            i3 = i34;
            max = Math.max(i31, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z11 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int i35 = 0;
            while (i35 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i35);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i35);
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i35 += getChildrenSkipCount(virtualChildAt2, i35);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (z7) {
                        this.mTotalLength += ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + i19 + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + getNextLocationOffset(virtualChildAt2);
                    } else {
                        int i36 = this.mTotalLength;
                        i12 = max;
                        this.mTotalLength = Math.max(i36, i36 + i19 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + getNextLocationOffset(virtualChildAt2));
                        i35++;
                        max = i12;
                    }
                }
                i12 = max;
                i35++;
                max = i12;
            }
        }
        int i37 = max;
        int paddingLeft = this.mTotalLength + getPaddingLeft() + getPaddingRight();
        this.mTotalLength = paddingLeft;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0);
        int i38 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (!z8 && (i38 == 0 || f3 <= 0.0f)) {
            i6 = Math.max(i32, i33);
            if (z11 && mode != 1073741824) {
                for (int i39 = 0; i39 < virtualChildCount; i39++) {
                    View virtualChildAt3 = getVirtualChildAt(i39);
                    if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LayoutParams) virtualChildAt3.getLayoutParams()).weight > 0.0f) {
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i19, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i4 = i2;
            i5 = virtualChildCount;
            max2 = i37;
        } else {
            float f6 = this.mWeightSum;
            if (f6 > 0.0f) {
                f3 = f6;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.mTotalLength = 0;
            int i40 = i32;
            int i41 = i3;
            int i42 = -1;
            int i43 = 0;
            while (i43 < virtualChildCount) {
                View virtualChildAt4 = getVirtualChildAt(i43);
                if (virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8) {
                    i7 = i38;
                    i8 = virtualChildCount;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt4.getLayoutParams();
                    float f7 = layoutParams3.weight;
                    if (f7 > 0.0f) {
                        int i44 = (int) ((i38 * f7) / f3);
                        float f8 = f3 - f7;
                        int i45 = i38 - i44;
                        i8 = virtualChildCount;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams3).height);
                        if (((ViewGroup.MarginLayoutParams) layoutParams3).width == 0) {
                            i11 = 1073741824;
                            if (mode == 1073741824) {
                                if (i44 <= 0) {
                                    i44 = 0;
                                }
                                virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i44, 1073741824), childMeasureSpec);
                                i41 = View.combineMeasuredStates(i41, virtualChildAt4.getMeasuredState() & (-16777216));
                                f3 = f8;
                                i7 = i45;
                            }
                        } else {
                            i11 = 1073741824;
                        }
                        int measuredWidth2 = virtualChildAt4.getMeasuredWidth() + i44;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i11), childMeasureSpec);
                        i41 = View.combineMeasuredStates(i41, virtualChildAt4.getMeasuredState() & (-16777216));
                        f3 = f8;
                        i7 = i45;
                    } else {
                        i7 = i38;
                        i8 = virtualChildCount;
                    }
                    if (z7) {
                        this.mTotalLength += virtualChildAt4.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin + getNextLocationOffset(virtualChildAt4);
                        f2 = f3;
                    } else {
                        int i46 = this.mTotalLength;
                        f2 = f3;
                        this.mTotalLength = Math.max(i46, virtualChildAt4.getMeasuredWidth() + i46 + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin + getNextLocationOffset(virtualChildAt4));
                    }
                    boolean z13 = mode2 != 1073741824 && ((ViewGroup.MarginLayoutParams) layoutParams3).height == -1;
                    int i47 = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
                    int measuredHeight2 = virtualChildAt4.getMeasuredHeight() + i47;
                    i42 = Math.max(i42, measuredHeight2);
                    if (!z13) {
                        i47 = measuredHeight2;
                    }
                    int max3 = Math.max(i40, i47);
                    if (z9) {
                        i9 = -1;
                        if (((ViewGroup.MarginLayoutParams) layoutParams3).height == -1) {
                            z = true;
                            if (z12 && (baseline = virtualChildAt4.getBaseline()) != i9) {
                                i10 = layoutParams3.gravity;
                                if (i10 < 0) {
                                    i10 = this.mGravity;
                                }
                                int i48 = (((i10 & 112) >> 4) & (-2)) >> 1;
                                iArr2[i48] = Math.max(iArr2[i48], baseline);
                                iArr[i48] = Math.max(iArr[i48], measuredHeight2 - baseline);
                            }
                            z9 = z;
                            i40 = max3;
                            f3 = f2;
                        }
                    } else {
                        i9 = -1;
                    }
                    z = false;
                    if (z12) {
                        i10 = layoutParams3.gravity;
                        if (i10 < 0) {
                        }
                        int i482 = (((i10 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i482] = Math.max(iArr2[i482], baseline);
                        iArr[i482] = Math.max(iArr[i482], measuredHeight2 - baseline);
                    }
                    z9 = z;
                    i40 = max3;
                    f3 = f2;
                }
                i43++;
                i38 = i7;
                virtualChildCount = i8;
            }
            i4 = i2;
            i5 = virtualChildCount;
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            max2 = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i42 : Math.max(i42, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            i6 = i40;
            i3 = i41;
        }
        if (z9 || mode2 == 1073741824) {
            i6 = max2;
        }
        setMeasuredDimension(resolveSizeAndState | (i3 & (-16777216)), View.resolveSizeAndState(Math.max(i6 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, i3 << 16));
        if (z10) {
            forceUniformHeight(i5, i);
        }
    }

    public int measureNullChild(int i) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0325  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        View view;
        int max;
        boolean z2;
        int max2;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i19 = this.mBaselineAlignedChildIndex;
        boolean z3 = this.mUseLargestChild;
        float f2 = 0.0f;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            int i26 = 8;
            int i27 = i23;
            if (i25 < virtualChildCount) {
                View virtualChildAt = getVirtualChildAt(i25);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(i25);
                    i14 = virtualChildCount;
                    i15 = mode2;
                    i23 = i27;
                } else {
                    int i28 = i20;
                    if (virtualChildAt.getVisibility() == 8) {
                        i25 += getChildrenSkipCount(virtualChildAt, i25);
                        i14 = virtualChildCount;
                        i23 = i27;
                        i20 = i28;
                        i15 = mode2;
                    } else {
                        if (hasDividerBeforeChildAt(i25)) {
                            this.mTotalLength += this.mDividerHeight;
                        }
                        LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                        float f3 = layoutParams.weight;
                        float f4 = f2 + f3;
                        if (mode2 == 1073741824 && ((ViewGroup.MarginLayoutParams) layoutParams).height == 0 && f3 > 0.0f) {
                            int i29 = this.mTotalLength;
                            this.mTotalLength = Math.max(i29, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + i29 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                            max = i22;
                            view = virtualChildAt;
                            i17 = i24;
                            i12 = i28;
                            i13 = i21;
                            z4 = true;
                            i14 = virtualChildCount;
                            i15 = mode2;
                            i16 = i27;
                            i18 = i25;
                        } else {
                            int i30 = i21;
                            if (((ViewGroup.MarginLayoutParams) layoutParams).height != 0 || layoutParams.weight <= 0.0f) {
                                i11 = Integer.MIN_VALUE;
                            } else {
                                ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
                                i11 = 0;
                            }
                            i12 = i28;
                            int i31 = i11;
                            i13 = i30;
                            int i32 = i22;
                            i14 = virtualChildCount;
                            i15 = mode2;
                            i16 = i27;
                            i17 = i24;
                            i18 = i25;
                            measureChildBeforeLayout(virtualChildAt, i25, i, 0, i2, f4 == 0.0f ? this.mTotalLength : 0);
                            if (i31 != Integer.MIN_VALUE) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).height = i31;
                            }
                            int measuredHeight = virtualChildAt.getMeasuredHeight();
                            int i33 = this.mTotalLength;
                            view = virtualChildAt;
                            this.mTotalLength = Math.max(i33, i33 + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + getNextLocationOffset(view));
                            max = z3 ? Math.max(measuredHeight, i32) : i32;
                        }
                        if (i19 >= 0 && i19 == i18 + 1) {
                            this.mBaselineChildTop = this.mTotalLength;
                        }
                        if (i18 < i19 && layoutParams.weight > 0.0f) {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                        if (mode == 1073741824 || ((ViewGroup.MarginLayoutParams) layoutParams).width != -1) {
                            z2 = false;
                        } else {
                            z2 = true;
                            z6 = true;
                        }
                        int i34 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        int measuredWidth = view.getMeasuredWidth() + i34;
                        int max3 = Math.max(i13, measuredWidth);
                        int combineMeasuredStates = View.combineMeasuredStates(i12, view.getMeasuredState());
                        z5 = z5 && ((ViewGroup.MarginLayoutParams) layoutParams).width == -1;
                        if (layoutParams.weight > 0.0f) {
                            if (!z2) {
                                i34 = measuredWidth;
                            }
                            i23 = Math.max(i16, i34);
                            max2 = i17;
                        } else {
                            if (!z2) {
                                i34 = measuredWidth;
                            }
                            max2 = Math.max(i17, i34);
                            i23 = i16;
                        }
                        i22 = max;
                        f2 = f4;
                        i24 = max2;
                        i20 = combineMeasuredStates;
                        i25 = getChildrenSkipCount(view, i18) + i18;
                        i21 = max3;
                    }
                }
                i25++;
                mode2 = i15;
                virtualChildCount = i14;
            } else {
                int i35 = i20;
                int i36 = i22;
                int i37 = i24;
                int i38 = virtualChildCount;
                int i39 = mode2;
                int i40 = i21;
                if (this.mTotalLength > 0) {
                    i3 = i38;
                    if (hasDividerBeforeChildAt(i3)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i3 = i38;
                }
                if (z3 && (i39 == Integer.MIN_VALUE || i39 == 0)) {
                    this.mTotalLength = 0;
                    int i41 = 0;
                    while (i41 < i3) {
                        View virtualChildAt2 = getVirtualChildAt(i41);
                        if (virtualChildAt2 == null) {
                            this.mTotalLength += measureNullChild(i41);
                        } else if (virtualChildAt2.getVisibility() == i26) {
                            i41 += getChildrenSkipCount(virtualChildAt2, i41);
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                            int i42 = this.mTotalLength;
                            this.mTotalLength = Math.max(i42, i42 + i36 + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + getNextLocationOffset(virtualChildAt2));
                        }
                        i41++;
                        i26 = 8;
                    }
                }
                int paddingTop = this.mTotalLength + getPaddingTop() + getPaddingBottom();
                this.mTotalLength = paddingTop;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0);
                int i43 = (16777215 & resolveSizeAndState) - this.mTotalLength;
                if (!z4 && (i43 == 0 || f2 <= 0.0f)) {
                    i6 = Math.max(i37, i27);
                    if (z3 && i39 != 1073741824) {
                        for (int i44 = 0; i44 < i3; i44++) {
                            View virtualChildAt3 = getVirtualChildAt(i44);
                            if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LayoutParams) virtualChildAt3.getLayoutParams()).weight > 0.0f) {
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i36, 1073741824));
                            }
                        }
                    }
                    i5 = i;
                    i4 = i35;
                } else {
                    float f5 = this.mWeightSum;
                    if (f5 > 0.0f) {
                        f2 = f5;
                    }
                    this.mTotalLength = 0;
                    int i45 = i43;
                    int i46 = i37;
                    i4 = i35;
                    int i47 = 0;
                    while (i47 < i3) {
                        View virtualChildAt4 = getVirtualChildAt(i47);
                        if (virtualChildAt4.getVisibility() == 8) {
                            i7 = i45;
                        } else {
                            LayoutParams layoutParams3 = (LayoutParams) virtualChildAt4.getLayoutParams();
                            float f6 = layoutParams3.weight;
                            if (f6 > 0.0f) {
                                int i48 = (int) ((i45 * f6) / f2);
                                float f7 = f2 - f6;
                                i7 = i45 - i48;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams3).width);
                                if (((ViewGroup.MarginLayoutParams) layoutParams3).height == 0) {
                                    i10 = 1073741824;
                                    if (i39 == 1073741824) {
                                        if (i48 <= 0) {
                                            i48 = 0;
                                        }
                                        virtualChildAt4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i48, 1073741824));
                                        i4 = View.combineMeasuredStates(i4, virtualChildAt4.getMeasuredState() & (-256));
                                        f2 = f7;
                                    }
                                } else {
                                    i10 = 1073741824;
                                }
                                int measuredHeight2 = virtualChildAt4.getMeasuredHeight() + i48;
                                if (measuredHeight2 < 0) {
                                    measuredHeight2 = 0;
                                }
                                virtualChildAt4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i10));
                                i4 = View.combineMeasuredStates(i4, virtualChildAt4.getMeasuredState() & (-256));
                                f2 = f7;
                            } else {
                                i7 = i45;
                            }
                            int i49 = ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin;
                            int measuredWidth2 = virtualChildAt4.getMeasuredWidth() + i49;
                            i40 = Math.max(i40, measuredWidth2);
                            float f8 = f2;
                            if (mode != 1073741824) {
                                i8 = i4;
                                i9 = -1;
                                if (((ViewGroup.MarginLayoutParams) layoutParams3).width == -1) {
                                    z = true;
                                    if (!z) {
                                        i49 = measuredWidth2;
                                    }
                                    int max4 = Math.max(i46, i49);
                                    boolean z7 = !z5 && ((ViewGroup.MarginLayoutParams) layoutParams3).width == i9;
                                    int i50 = this.mTotalLength;
                                    this.mTotalLength = Math.max(i50, virtualChildAt4.getMeasuredHeight() + i50 + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + getNextLocationOffset(virtualChildAt4));
                                    z5 = z7;
                                    i4 = i8;
                                    i46 = max4;
                                    f2 = f8;
                                }
                            } else {
                                i8 = i4;
                                i9 = -1;
                            }
                            z = false;
                            if (!z) {
                            }
                            int max42 = Math.max(i46, i49);
                            if (z5) {
                            }
                            int i502 = this.mTotalLength;
                            this.mTotalLength = Math.max(i502, virtualChildAt4.getMeasuredHeight() + i502 + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + getNextLocationOffset(virtualChildAt4));
                            z5 = z7;
                            i4 = i8;
                            i46 = max42;
                            f2 = f8;
                        }
                        i47++;
                        i45 = i7;
                    }
                    i5 = i;
                    this.mTotalLength += getPaddingTop() + getPaddingBottom();
                    i6 = i46;
                }
                if (z5 || mode == 1073741824) {
                    i6 = i40;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i6 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i5, i4), resolveSizeAndState);
                if (z6) {
                    forceUniformWidth(i3, i2);
                    return;
                }
                return;
            }
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(LinearLayoutCompat.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(LinearLayoutCompat.class.getName());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i >= 0 && i < getChildCount()) {
            this.mBaselineAlignedChildIndex = i;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + SmallTailInfo.EMOTION_SUFFIX);
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & OneKeyLoginResult.ONE_KEY_LOGIN_CODE_JSON_ERROR);
            requestLayout();
        }
    }

    public void setWeightSum(float f2) {
        this.mWeightSum = Math.max(0.0f, f2);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.LinearLayoutCompat, i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2, float f2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = f2;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }
    }
}
