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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    public static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
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
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface DividerMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface OrientationMode {
    }

    public LinearLayoutCompat(@NonNull Context context) {
        this(context, null);
    }

    private void forceUniformHeight(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View virtualChildAt = getVirtualChildAt(i4);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                    int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).width;
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i3, 0, makeMeasureSpec, 0);
                    ((ViewGroup.MarginLayoutParams) layoutParams).width = i5;
                }
            }
        }
    }

    private void forceUniformWidth(int i2, int i3) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i4 = 0; i4 < i2; i4++) {
            View virtualChildAt = getVirtualChildAt(i4);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width == -1) {
                    int i5 = ((ViewGroup.MarginLayoutParams) layoutParams).height;
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i3, 0);
                    ((ViewGroup.MarginLayoutParams) layoutParams).height = i5;
                }
            }
        }
    }

    private void setChildFrame(View view, int i2, int i3, int i4, int i5) {
        view.layout(i2, i3, i4 + i2, i5 + i3);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int i2;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i3 = 0; i3 < virtualChildCount; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i3)) {
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
                    i2 = this.mDividerWidth;
                    right = left - i2;
                } else {
                    right = virtualChildAt2.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                }
            } else if (isLayoutRtl) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i2 = this.mDividerWidth;
                right = left - i2;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    public void drawDividersVertical(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View virtualChildAt = getVirtualChildAt(i2);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
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

    public void drawHorizontalDivider(Canvas canvas, int i2) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i2, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i2);
        this.mDivider.draw(canvas);
    }

    public void drawVerticalDivider(Canvas canvas, int i2) {
        this.mDivider.setBounds(i2, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i2, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i2;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i3 = this.mBaselineAlignedChildIndex;
        if (childCount > i3) {
            View childAt = getChildAt(i3);
            int baseline = childAt.getBaseline();
            if (baseline == -1) {
                if (this.mBaselineAlignedChildIndex == 0) {
                    return -1;
                }
                throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
            }
            int i4 = this.mBaselineChildTop;
            if (this.mOrientation == 1 && (i2 = this.mGravity & 112) != 48) {
                if (i2 == 16) {
                    i4 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
                } else if (i2 == 80) {
                    i4 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
                }
            }
            return i4 + ((ViewGroup.MarginLayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
        }
        throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public int getChildrenSkipCount(View view, int i2) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
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

    public View getVirtualChildAt(int i2) {
        return getChildAt(i2);
    }

    public int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean hasDividerBeforeChildAt(int i2) {
        if (i2 == 0) {
            return (this.mShowDividers & 1) != 0;
        } else if (i2 == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        } else if ((this.mShowDividers & 2) != 0) {
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                if (getChildAt(i3).getVisibility() != 8) {
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
    public void layoutHorizontal(int i2, int i3, int i4, int i5) {
        int paddingLeft;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i15 = i5 - i3;
        int paddingBottom = i15 - getPaddingBottom();
        int paddingBottom2 = (i15 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i16 = this.mGravity;
        int i17 = i16 & 112;
        boolean z = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i16, ViewCompat.getLayoutDirection(this));
        if (absoluteGravity == 1) {
            paddingLeft = getPaddingLeft() + (((i4 - i2) - this.mTotalLength) / 2);
        } else if (absoluteGravity != 5) {
            paddingLeft = getPaddingLeft();
        } else {
            paddingLeft = ((getPaddingLeft() + i4) - i2) - this.mTotalLength;
        }
        if (isLayoutRtl) {
            i6 = virtualChildCount - 1;
            i7 = -1;
        } else {
            i6 = 0;
            i7 = 1;
        }
        int i18 = 0;
        while (i18 < virtualChildCount) {
            int i19 = i6 + (i7 * i18);
            View virtualChildAt = getVirtualChildAt(i19);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i19);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i20 = i18;
                if (z) {
                    i8 = virtualChildCount;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                        i9 = virtualChildAt.getBaseline();
                        i10 = layoutParams.gravity;
                        if (i10 < 0) {
                            i10 = i17;
                        }
                        i11 = i10 & 112;
                        i12 = i17;
                        if (i11 != 16) {
                            i13 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        } else if (i11 == 48) {
                            i13 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + paddingTop;
                            if (i9 != -1) {
                                i13 += iArr[1] - i9;
                            }
                        } else if (i11 != 80) {
                            i13 = paddingTop;
                        } else {
                            i13 = (paddingBottom - measuredHeight) - ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                            if (i9 != -1) {
                                i13 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i9);
                            }
                        }
                        if (hasDividerBeforeChildAt(i19)) {
                            paddingLeft += this.mDividerWidth;
                        }
                        int i21 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                        i14 = paddingTop;
                        setChildFrame(virtualChildAt, i21 + getLocationOffset(virtualChildAt), i13, measuredWidth, measuredHeight);
                        i18 = i20 + getChildrenSkipCount(virtualChildAt, i19);
                        paddingLeft = i21 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(virtualChildAt);
                        i18++;
                        virtualChildCount = i8;
                        i17 = i12;
                        paddingTop = i14;
                    }
                } else {
                    i8 = virtualChildCount;
                }
                i9 = -1;
                i10 = layoutParams.gravity;
                if (i10 < 0) {
                }
                i11 = i10 & 112;
                i12 = i17;
                if (i11 != 16) {
                }
                if (hasDividerBeforeChildAt(i19)) {
                }
                int i212 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                i14 = paddingTop;
                setChildFrame(virtualChildAt, i212 + getLocationOffset(virtualChildAt), i13, measuredWidth, measuredHeight);
                i18 = i20 + getChildrenSkipCount(virtualChildAt, i19);
                paddingLeft = i212 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(virtualChildAt);
                i18++;
                virtualChildCount = i8;
                i17 = i12;
                paddingTop = i14;
            }
            i14 = paddingTop;
            i8 = virtualChildCount;
            i12 = i17;
            i18++;
            virtualChildCount = i8;
            i17 = i12;
            paddingTop = i14;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void layoutVertical(int i2, int i3, int i4, int i5) {
        int paddingTop;
        int i6;
        int i7;
        int i8;
        int paddingLeft = getPaddingLeft();
        int i9 = i4 - i2;
        int paddingRight = i9 - getPaddingRight();
        int paddingRight2 = (i9 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i10 = this.mGravity;
        int i11 = i10 & 112;
        int i12 = i10 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i11 == 16) {
            paddingTop = getPaddingTop() + (((i5 - i3) - this.mTotalLength) / 2);
        } else if (i11 != 80) {
            paddingTop = getPaddingTop();
        } else {
            paddingTop = ((getPaddingTop() + i5) - i3) - this.mTotalLength;
        }
        int i13 = 0;
        while (i13 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i13);
            if (virtualChildAt == null) {
                paddingTop += measureNullChild(i13);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i14 = layoutParams.gravity;
                if (i14 < 0) {
                    i14 = i12;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i14, ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity == 1) {
                    i6 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
                    i7 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                } else if (absoluteGravity != 5) {
                    i8 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + paddingLeft;
                    int i15 = i8;
                    if (hasDividerBeforeChildAt(i13)) {
                        paddingTop += this.mDividerHeight;
                    }
                    int i16 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                    setChildFrame(virtualChildAt, i15, i16 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                    i13 += getChildrenSkipCount(virtualChildAt, i13);
                    paddingTop = i16 + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt);
                } else {
                    i6 = paddingRight - measuredWidth;
                    i7 = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                }
                i8 = i6 - i7;
                int i152 = i8;
                if (hasDividerBeforeChildAt(i13)) {
                }
                int i162 = paddingTop + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
                setChildFrame(virtualChildAt, i152, i162 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                i13 += getChildrenSkipCount(virtualChildAt, i13);
                paddingTop = i162 + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt);
            }
            i13++;
        }
    }

    public void measureChildBeforeLayout(View view, int i2, int i3, int i4, int i5, int i6) {
        measureChildWithMargins(view, i3, i4, i5, i6);
    }

    /* JADX WARN: Removed duplicated region for block: B:197:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01d6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measureHorizontal(int i2, int i3) {
        int[] iArr;
        int i4;
        int max;
        int i5;
        int i6;
        int max2;
        int i7;
        int i8;
        int i9;
        float f2;
        int i10;
        boolean z;
        int baseline;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        boolean z2;
        boolean z3;
        View view;
        int i16;
        boolean z4;
        int measuredHeight;
        int childrenSkipCount;
        int baseline2;
        int i17;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
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
        int i18 = 1073741824;
        boolean z7 = mode == 1073741824;
        float f3 = 0.0f;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        boolean z8 = false;
        int i24 = 0;
        boolean z9 = true;
        boolean z10 = false;
        while (true) {
            iArr = iArr3;
            if (i19 >= virtualChildCount) {
                break;
            }
            View virtualChildAt = getVirtualChildAt(i19);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i19);
            } else if (virtualChildAt.getVisibility() == 8) {
                i19 += getChildrenSkipCount(virtualChildAt, i19);
            } else {
                if (hasDividerBeforeChildAt(i19)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                float f4 = layoutParams.weight;
                float f5 = f3 + f4;
                if (mode == i18 && ((ViewGroup.MarginLayoutParams) layoutParams).width == 0 && f4 > 0.0f) {
                    if (z7) {
                        this.mTotalLength += ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                    } else {
                        int i25 = this.mTotalLength;
                        this.mTotalLength = Math.max(i25, ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + i25 + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin);
                    }
                    if (z5) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                        i15 = i19;
                        z2 = z6;
                        z3 = z5;
                        view = virtualChildAt;
                    } else {
                        i15 = i19;
                        z2 = z6;
                        z3 = z5;
                        view = virtualChildAt;
                        i16 = 1073741824;
                        z8 = true;
                        if (mode2 == i16 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1) {
                            z4 = true;
                            z10 = true;
                        } else {
                            z4 = false;
                        }
                        int i26 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i26;
                        i24 = View.combineMeasuredStates(i24, view.getMeasuredState());
                        if (z3 && (baseline2 = view.getBaseline()) != -1) {
                            i17 = layoutParams.gravity;
                            if (i17 < 0) {
                                i17 = this.mGravity;
                            }
                            int i27 = (((i17 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i27] = Math.max(iArr2[i27], baseline2);
                            iArr[i27] = Math.max(iArr[i27], measuredHeight - baseline2);
                        }
                        i21 = Math.max(i21, measuredHeight);
                        z9 = !z9 && ((ViewGroup.MarginLayoutParams) layoutParams).height == -1;
                        if (layoutParams.weight <= 0.0f) {
                            if (!z4) {
                                i26 = measuredHeight;
                            }
                            i23 = Math.max(i23, i26);
                        } else {
                            int i28 = i23;
                            if (!z4) {
                                i26 = measuredHeight;
                            }
                            i22 = Math.max(i22, i26);
                            i23 = i28;
                        }
                        int i29 = i15;
                        childrenSkipCount = getChildrenSkipCount(view, i29) + i29;
                        f3 = f5;
                        i19 = childrenSkipCount + 1;
                        iArr3 = iArr;
                        z6 = z2;
                        z5 = z3;
                        i18 = 1073741824;
                    }
                } else {
                    if (((ViewGroup.MarginLayoutParams) layoutParams).width != 0 || layoutParams.weight <= 0.0f) {
                        i14 = Integer.MIN_VALUE;
                    } else {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = -2;
                        i14 = 0;
                    }
                    i15 = i19;
                    int i30 = i14;
                    z2 = z6;
                    z3 = z5;
                    measureChildBeforeLayout(virtualChildAt, i15, i2, f5 == 0.0f ? this.mTotalLength : 0, i3, 0);
                    if (i30 != Integer.MIN_VALUE) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).width = i30;
                    }
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    if (z7) {
                        view = virtualChildAt;
                        this.mTotalLength += ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(view);
                    } else {
                        view = virtualChildAt;
                        int i31 = this.mTotalLength;
                        this.mTotalLength = Math.max(i31, i31 + measuredWidth + ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin + getNextLocationOffset(view));
                    }
                    if (z2) {
                        i20 = Math.max(measuredWidth, i20);
                    }
                }
                i16 = 1073741824;
                if (mode2 == i16) {
                }
                z4 = false;
                int i262 = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i262;
                i24 = View.combineMeasuredStates(i24, view.getMeasuredState());
                if (z3) {
                    i17 = layoutParams.gravity;
                    if (i17 < 0) {
                    }
                    int i272 = (((i17 & 112) >> 4) & (-2)) >> 1;
                    iArr2[i272] = Math.max(iArr2[i272], baseline2);
                    iArr[i272] = Math.max(iArr[i272], measuredHeight - baseline2);
                }
                i21 = Math.max(i21, measuredHeight);
                if (z9) {
                }
                if (layoutParams.weight <= 0.0f) {
                }
                int i292 = i15;
                childrenSkipCount = getChildrenSkipCount(view, i292) + i292;
                f3 = f5;
                i19 = childrenSkipCount + 1;
                iArr3 = iArr;
                z6 = z2;
                z5 = z3;
                i18 = 1073741824;
            }
            childrenSkipCount = i19;
            z2 = z6;
            z3 = z5;
            i19 = childrenSkipCount + 1;
            iArr3 = iArr;
            z6 = z2;
            z5 = z3;
            i18 = 1073741824;
        }
        boolean z11 = z6;
        boolean z12 = z5;
        int i32 = i21;
        int i33 = i22;
        int i34 = i23;
        int i35 = i24;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            max = i32;
            i4 = i35;
        } else {
            i4 = i35;
            max = Math.max(i32, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z11 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int i36 = 0;
            while (i36 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i36);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i36);
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i36 += getChildrenSkipCount(virtualChildAt2, i36);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (z7) {
                        this.mTotalLength += ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + i20 + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + getNextLocationOffset(virtualChildAt2);
                    } else {
                        int i37 = this.mTotalLength;
                        i13 = max;
                        this.mTotalLength = Math.max(i37, i37 + i20 + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin + getNextLocationOffset(virtualChildAt2));
                        i36++;
                        max = i13;
                    }
                }
                i13 = max;
                i36++;
                max = i13;
            }
        }
        int i38 = max;
        int paddingLeft = this.mTotalLength + getPaddingLeft() + getPaddingRight();
        this.mTotalLength = paddingLeft;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, 0);
        int i39 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (!z8 && (i39 == 0 || f3 <= 0.0f)) {
            i7 = Math.max(i33, i34);
            if (z11 && mode != 1073741824) {
                for (int i40 = 0; i40 < virtualChildCount; i40++) {
                    View virtualChildAt3 = getVirtualChildAt(i40);
                    if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LayoutParams) virtualChildAt3.getLayoutParams()).weight > 0.0f) {
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i20, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i5 = i3;
            i6 = virtualChildCount;
            max2 = i38;
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
            int i41 = i33;
            int i42 = i4;
            int i43 = -1;
            int i44 = 0;
            while (i44 < virtualChildCount) {
                View virtualChildAt4 = getVirtualChildAt(i44);
                if (virtualChildAt4 == null || virtualChildAt4.getVisibility() == 8) {
                    i8 = i39;
                    i9 = virtualChildCount;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt4.getLayoutParams();
                    float f7 = layoutParams3.weight;
                    if (f7 > 0.0f) {
                        int i45 = (int) ((i39 * f7) / f3);
                        float f8 = f3 - f7;
                        int i46 = i39 - i45;
                        i9 = virtualChildCount;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin, ((ViewGroup.MarginLayoutParams) layoutParams3).height);
                        if (((ViewGroup.MarginLayoutParams) layoutParams3).width == 0) {
                            i12 = 1073741824;
                            if (mode == 1073741824) {
                                if (i45 <= 0) {
                                    i45 = 0;
                                }
                                virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i45, 1073741824), childMeasureSpec);
                                i42 = View.combineMeasuredStates(i42, virtualChildAt4.getMeasuredState() & (-16777216));
                                f3 = f8;
                                i8 = i46;
                            }
                        } else {
                            i12 = 1073741824;
                        }
                        int measuredWidth2 = virtualChildAt4.getMeasuredWidth() + i45;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i12), childMeasureSpec);
                        i42 = View.combineMeasuredStates(i42, virtualChildAt4.getMeasuredState() & (-16777216));
                        f3 = f8;
                        i8 = i46;
                    } else {
                        i8 = i39;
                        i9 = virtualChildCount;
                    }
                    if (z7) {
                        this.mTotalLength += virtualChildAt4.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin + getNextLocationOffset(virtualChildAt4);
                        f2 = f3;
                    } else {
                        int i47 = this.mTotalLength;
                        f2 = f3;
                        this.mTotalLength = Math.max(i47, virtualChildAt4.getMeasuredWidth() + i47 + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin + getNextLocationOffset(virtualChildAt4));
                    }
                    boolean z13 = mode2 != 1073741824 && ((ViewGroup.MarginLayoutParams) layoutParams3).height == -1;
                    int i48 = ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin;
                    int measuredHeight2 = virtualChildAt4.getMeasuredHeight() + i48;
                    i43 = Math.max(i43, measuredHeight2);
                    if (!z13) {
                        i48 = measuredHeight2;
                    }
                    int max3 = Math.max(i41, i48);
                    if (z9) {
                        i10 = -1;
                        if (((ViewGroup.MarginLayoutParams) layoutParams3).height == -1) {
                            z = true;
                            if (z12 && (baseline = virtualChildAt4.getBaseline()) != i10) {
                                i11 = layoutParams3.gravity;
                                if (i11 < 0) {
                                    i11 = this.mGravity;
                                }
                                int i49 = (((i11 & 112) >> 4) & (-2)) >> 1;
                                iArr2[i49] = Math.max(iArr2[i49], baseline);
                                iArr[i49] = Math.max(iArr[i49], measuredHeight2 - baseline);
                            }
                            z9 = z;
                            i41 = max3;
                            f3 = f2;
                        }
                    } else {
                        i10 = -1;
                    }
                    z = false;
                    if (z12) {
                        i11 = layoutParams3.gravity;
                        if (i11 < 0) {
                        }
                        int i492 = (((i11 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i492] = Math.max(iArr2[i492], baseline);
                        iArr[i492] = Math.max(iArr[i492], measuredHeight2 - baseline);
                    }
                    z9 = z;
                    i41 = max3;
                    f3 = f2;
                }
                i44++;
                i39 = i8;
                virtualChildCount = i9;
            }
            i5 = i3;
            i6 = virtualChildCount;
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            max2 = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i43 : Math.max(i43, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            i7 = i41;
            i4 = i42;
        }
        if (z9 || mode2 == 1073741824) {
            i7 = max2;
        }
        setMeasuredDimension(resolveSizeAndState | (i4 & (-16777216)), View.resolveSizeAndState(Math.max(i7 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i5, i4 << 16));
        if (z10) {
            forceUniformHeight(i6, i2);
        }
    }

    public int measureNullChild(int i2) {
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0325  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void measureVertical(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        View view;
        int max;
        boolean z2;
        int max2;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int i20 = this.mBaselineAlignedChildIndex;
        boolean z3 = this.mUseLargestChild;
        float f2 = 0.0f;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        boolean z4 = false;
        boolean z5 = true;
        boolean z6 = false;
        while (true) {
            int i27 = 8;
            int i28 = i24;
            if (i26 < virtualChildCount) {
                View virtualChildAt = getVirtualChildAt(i26);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(i26);
                    i15 = virtualChildCount;
                    i16 = mode2;
                    i24 = i28;
                } else {
                    int i29 = i21;
                    if (virtualChildAt.getVisibility() == 8) {
                        i26 += getChildrenSkipCount(virtualChildAt, i26);
                        i15 = virtualChildCount;
                        i24 = i28;
                        i21 = i29;
                        i16 = mode2;
                    } else {
                        if (hasDividerBeforeChildAt(i26)) {
                            this.mTotalLength += this.mDividerHeight;
                        }
                        LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                        float f3 = layoutParams.weight;
                        float f4 = f2 + f3;
                        if (mode2 == 1073741824 && ((ViewGroup.MarginLayoutParams) layoutParams).height == 0 && f3 > 0.0f) {
                            int i30 = this.mTotalLength;
                            this.mTotalLength = Math.max(i30, ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + i30 + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                            max = i23;
                            view = virtualChildAt;
                            i18 = i25;
                            i13 = i29;
                            i14 = i22;
                            z4 = true;
                            i15 = virtualChildCount;
                            i16 = mode2;
                            i17 = i28;
                            i19 = i26;
                        } else {
                            int i31 = i22;
                            if (((ViewGroup.MarginLayoutParams) layoutParams).height != 0 || layoutParams.weight <= 0.0f) {
                                i12 = Integer.MIN_VALUE;
                            } else {
                                ((ViewGroup.MarginLayoutParams) layoutParams).height = -2;
                                i12 = 0;
                            }
                            i13 = i29;
                            int i32 = i12;
                            i14 = i31;
                            int i33 = i23;
                            i15 = virtualChildCount;
                            i16 = mode2;
                            i17 = i28;
                            i18 = i25;
                            i19 = i26;
                            measureChildBeforeLayout(virtualChildAt, i26, i2, 0, i3, f4 == 0.0f ? this.mTotalLength : 0);
                            if (i32 != Integer.MIN_VALUE) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).height = i32;
                            }
                            int measuredHeight = virtualChildAt.getMeasuredHeight();
                            int i34 = this.mTotalLength;
                            view = virtualChildAt;
                            this.mTotalLength = Math.max(i34, i34 + measuredHeight + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin + getNextLocationOffset(view));
                            max = z3 ? Math.max(measuredHeight, i33) : i33;
                        }
                        if (i20 >= 0 && i20 == i19 + 1) {
                            this.mBaselineChildTop = this.mTotalLength;
                        }
                        if (i19 < i20 && layoutParams.weight > 0.0f) {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                        if (mode == 1073741824 || ((ViewGroup.MarginLayoutParams) layoutParams).width != -1) {
                            z2 = false;
                        } else {
                            z2 = true;
                            z6 = true;
                        }
                        int i35 = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        int measuredWidth = view.getMeasuredWidth() + i35;
                        int max3 = Math.max(i14, measuredWidth);
                        int combineMeasuredStates = View.combineMeasuredStates(i13, view.getMeasuredState());
                        z5 = z5 && ((ViewGroup.MarginLayoutParams) layoutParams).width == -1;
                        if (layoutParams.weight > 0.0f) {
                            if (!z2) {
                                i35 = measuredWidth;
                            }
                            i24 = Math.max(i17, i35);
                            max2 = i18;
                        } else {
                            if (!z2) {
                                i35 = measuredWidth;
                            }
                            max2 = Math.max(i18, i35);
                            i24 = i17;
                        }
                        i23 = max;
                        f2 = f4;
                        i25 = max2;
                        i21 = combineMeasuredStates;
                        i26 = getChildrenSkipCount(view, i19) + i19;
                        i22 = max3;
                    }
                }
                i26++;
                mode2 = i16;
                virtualChildCount = i15;
            } else {
                int i36 = i21;
                int i37 = i23;
                int i38 = i25;
                int i39 = virtualChildCount;
                int i40 = mode2;
                int i41 = i22;
                if (this.mTotalLength > 0) {
                    i4 = i39;
                    if (hasDividerBeforeChildAt(i4)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i4 = i39;
                }
                if (z3 && (i40 == Integer.MIN_VALUE || i40 == 0)) {
                    this.mTotalLength = 0;
                    int i42 = 0;
                    while (i42 < i4) {
                        View virtualChildAt2 = getVirtualChildAt(i42);
                        if (virtualChildAt2 == null) {
                            this.mTotalLength += measureNullChild(i42);
                        } else if (virtualChildAt2.getVisibility() == i27) {
                            i42 += getChildrenSkipCount(virtualChildAt2, i42);
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                            int i43 = this.mTotalLength;
                            this.mTotalLength = Math.max(i43, i43 + i37 + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + getNextLocationOffset(virtualChildAt2));
                        }
                        i42++;
                        i27 = 8;
                    }
                }
                int paddingTop = this.mTotalLength + getPaddingTop() + getPaddingBottom();
                this.mTotalLength = paddingTop;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, 0);
                int i44 = (16777215 & resolveSizeAndState) - this.mTotalLength;
                if (!z4 && (i44 == 0 || f2 <= 0.0f)) {
                    i7 = Math.max(i38, i28);
                    if (z3 && i40 != 1073741824) {
                        for (int i45 = 0; i45 < i4; i45++) {
                            View virtualChildAt3 = getVirtualChildAt(i45);
                            if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LayoutParams) virtualChildAt3.getLayoutParams()).weight > 0.0f) {
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i37, 1073741824));
                            }
                        }
                    }
                    i6 = i2;
                    i5 = i36;
                } else {
                    float f5 = this.mWeightSum;
                    if (f5 > 0.0f) {
                        f2 = f5;
                    }
                    this.mTotalLength = 0;
                    int i46 = i44;
                    int i47 = i38;
                    i5 = i36;
                    int i48 = 0;
                    while (i48 < i4) {
                        View virtualChildAt4 = getVirtualChildAt(i48);
                        if (virtualChildAt4.getVisibility() == 8) {
                            i8 = i46;
                        } else {
                            LayoutParams layoutParams3 = (LayoutParams) virtualChildAt4.getLayoutParams();
                            float f6 = layoutParams3.weight;
                            if (f6 > 0.0f) {
                                int i49 = (int) ((i46 * f6) / f2);
                                float f7 = f2 - f6;
                                i8 = i46 - i49;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin, ((ViewGroup.MarginLayoutParams) layoutParams3).width);
                                if (((ViewGroup.MarginLayoutParams) layoutParams3).height == 0) {
                                    i11 = 1073741824;
                                    if (i40 == 1073741824) {
                                        if (i49 <= 0) {
                                            i49 = 0;
                                        }
                                        virtualChildAt4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i49, 1073741824));
                                        i5 = View.combineMeasuredStates(i5, virtualChildAt4.getMeasuredState() & (-256));
                                        f2 = f7;
                                    }
                                } else {
                                    i11 = 1073741824;
                                }
                                int measuredHeight2 = virtualChildAt4.getMeasuredHeight() + i49;
                                if (measuredHeight2 < 0) {
                                    measuredHeight2 = 0;
                                }
                                virtualChildAt4.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i11));
                                i5 = View.combineMeasuredStates(i5, virtualChildAt4.getMeasuredState() & (-256));
                                f2 = f7;
                            } else {
                                i8 = i46;
                            }
                            int i50 = ((ViewGroup.MarginLayoutParams) layoutParams3).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).rightMargin;
                            int measuredWidth2 = virtualChildAt4.getMeasuredWidth() + i50;
                            i41 = Math.max(i41, measuredWidth2);
                            float f8 = f2;
                            if (mode != 1073741824) {
                                i9 = i5;
                                i10 = -1;
                                if (((ViewGroup.MarginLayoutParams) layoutParams3).width == -1) {
                                    z = true;
                                    if (!z) {
                                        i50 = measuredWidth2;
                                    }
                                    int max4 = Math.max(i47, i50);
                                    boolean z7 = !z5 && ((ViewGroup.MarginLayoutParams) layoutParams3).width == i10;
                                    int i51 = this.mTotalLength;
                                    this.mTotalLength = Math.max(i51, virtualChildAt4.getMeasuredHeight() + i51 + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + getNextLocationOffset(virtualChildAt4));
                                    z5 = z7;
                                    i5 = i9;
                                    i47 = max4;
                                    f2 = f8;
                                }
                            } else {
                                i9 = i5;
                                i10 = -1;
                            }
                            z = false;
                            if (!z) {
                            }
                            int max42 = Math.max(i47, i50);
                            if (z5) {
                            }
                            int i512 = this.mTotalLength;
                            this.mTotalLength = Math.max(i512, virtualChildAt4.getMeasuredHeight() + i512 + ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams3).bottomMargin + getNextLocationOffset(virtualChildAt4));
                            z5 = z7;
                            i5 = i9;
                            i47 = max42;
                            f2 = f8;
                        }
                        i48++;
                        i46 = i8;
                    }
                    i6 = i2;
                    this.mTotalLength += getPaddingTop() + getPaddingBottom();
                    i7 = i47;
                }
                if (z5 || mode == 1073741824) {
                    i7 = i41;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i7 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i6, i5), resolveSizeAndState);
                if (z6) {
                    forceUniformWidth(i4, i3);
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
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        if (this.mOrientation == 1) {
            layoutVertical(i2, i3, i4, i5);
        } else {
            layoutHorizontal(i2, i3, i4, i5);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.mOrientation == 1) {
            measureVertical(i2, i3);
        } else {
            measureHorizontal(i2, i3);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public void setBaselineAlignedChildIndex(int i2) {
        if (i2 >= 0 && i2 < getChildCount()) {
            this.mBaselineAlignedChildIndex = i2;
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

    public void setDividerPadding(int i2) {
        this.mDividerPadding = i2;
    }

    public void setGravity(int i2) {
        if (this.mGravity != i2) {
            if ((8388615 & i2) == 0) {
                i2 |= GravityCompat.START;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.mGravity = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i2) {
        int i3 = i2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i4 = this.mGravity;
        if ((8388615 & i4) != i3) {
            this.mGravity = i3 | ((-8388616) & i4);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    public void setOrientation(int i2) {
        if (this.mOrientation != i2) {
            this.mOrientation = i2;
            requestLayout();
        }
    }

    public void setShowDividers(int i2) {
        if (i2 != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i2;
    }

    public void setVerticalGravity(int i2) {
        int i3 = i2 & 112;
        int i4 = this.mGravity;
        if ((i4 & 112) != i3) {
            this.mGravity = i3 | (i4 & OneKeyLoginResult.ONE_KEY_LOGIN_CODE_JSON_ERROR);
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

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i2 = this.mOrientation;
        if (i2 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i2 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    public LinearLayoutCompat(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = BadgeDrawable.TOP_START;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.LinearLayoutCompat, i2, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.LinearLayoutCompat, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i2, 0);
        int i3 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i3 >= 0) {
            setOrientation(i3);
        }
        int i4 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i4 >= 0) {
            setGravity(i4);
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

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int i2, int i3, float f2) {
            super(i2, i3);
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
