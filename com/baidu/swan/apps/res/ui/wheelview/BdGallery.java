package com.baidu.swan.apps.res.ui.wheelview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.support.v7.widget.ActivityChooserView;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Transformation;
import android.widget.Scroller;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.res.ui.wheelview.BdAdapterView;
/* loaded from: classes2.dex */
public class BdGallery extends BdAbsSpinner implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
    private int Ot;
    private BdAdapterView.a aKA;
    private boolean aKB;
    private boolean aKC;
    private boolean aKD;
    private boolean aKE;
    private int aKF;
    private int aKG;
    private int aKH;
    private float aKI;
    private boolean aKJ;
    private boolean aKK;
    private boolean aKL;
    private c aKM;
    private int aKl;
    private float aKm;
    private int aKn;
    private int aKo;
    private int aKp;
    private View aKq;
    private a aKr;
    private long aKs;
    private Runnable aKt;
    private boolean aKu;
    private View aKv;
    private boolean aKw;
    private boolean aKx;
    private boolean aKy;
    private boolean aKz;
    private GestureDetector mGestureDetector;
    private int mGravity;
    private int mOrientation;

    /* loaded from: classes2.dex */
    public interface c {
        void a(BdGallery bdGallery);
    }

    public BdGallery(Context context) {
        this(context, null);
    }

    public BdGallery(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.b.galleryStyle);
    }

    public BdGallery(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ot = 0;
        this.aKl = 400;
        this.aKr = new a();
        this.aKs = 2147483646L;
        this.aKt = new Runnable() { // from class: com.baidu.swan.apps.res.ui.wheelview.BdGallery.1
            @Override // java.lang.Runnable
            public void run() {
                BdGallery.this.aKy = false;
                BdGallery.this.selectionChanged();
            }
        };
        this.aKw = true;
        this.aKx = true;
        this.aKC = false;
        this.aKD = false;
        this.aKE = false;
        this.aKF = 0;
        this.aKG = 0;
        this.aKH = 5;
        this.aKI = 1.0f;
        this.aKJ = false;
        this.aKK = true;
        this.aKL = false;
        this.mOrientation = 1;
        this.aKM = null;
        this.mGestureDetector = new GestureDetector(context, this);
        this.mGestureDetector.setIsLongpressEnabled(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, a.j.Gallery, i, 0);
        int i2 = obtainStyledAttributes.getInt(a.j.Gallery_gravity, -1);
        if (i2 >= 0) {
            setGravity(i2);
        }
        int i3 = obtainStyledAttributes.getInt(a.j.Gallery_animationDuration, -1);
        if (i3 > 0) {
            setAnimationDuration(i3);
        }
        setSpacing(obtainStyledAttributes.getDimensionPixelOffset(a.j.Gallery_spacing, 0));
        setUnselectedAlpha(obtainStyledAttributes.getFloat(a.j.Gallery_unselectedAlpha, 0.5f));
        obtainStyledAttributes.recycle();
        setChildrenDrawingOrderEnabled(true);
        setStaticTransformationsEnabled(true);
        this.aKH = ViewConfiguration.get(context).getScaledScrollBarSize();
        if (Ia()) {
            this.mGravity = 1;
        } else {
            this.mGravity = 16;
        }
    }

    public void setCallbackDuringFling(boolean z) {
        this.aKw = z;
    }

    public void setCallbackOnUnselectedItemClick(boolean z) {
        this.aKx = z;
    }

    public void setAnimationDuration(int i) {
        this.aKl = i;
    }

    public void setSpacing(int i) {
        this.Ot = i;
    }

    public void setUnselectedAlpha(float f) {
        this.aKm = f;
    }

    @Override // android.view.ViewGroup
    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        transformation.clear();
        transformation.setAlpha(view == this.aKv ? 1.0f : this.aKm);
        fW(" getChildStaticTransformation   mSelectedPosition =  " + this.mSelectedPosition + "   mFirstPosition = " + this.mFirstPosition + "     mSelectedChild = " + this.aKv);
        return true;
    }

    @Override // android.view.View
    public void invalidate(int i, int i2, int i3, int i4) {
        super.invalidate(i, i2 - (this.aKH + this.aKG), i3, i4);
    }

    @Override // android.view.View
    protected int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount > 0) {
            int i = childCount * 100;
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                if (!(this.mFirstPosition == 0) || left <= 0) {
                    i += (left * 100) / width;
                }
            }
            View childAt2 = getChildAt(childCount - 1);
            int right = childAt2.getRight();
            int width2 = childAt2.getWidth();
            if (width2 > 0) {
                if (!(childCount + this.mFirstPosition == this.mItemCount) || right >= getWidth()) {
                    return i - (((right - getWidth()) * 100) / width2);
                }
                return i;
            }
            return i;
        }
        return 0;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollOffset() {
        if (this.mFirstPosition >= 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int left = childAt.getLeft();
            int width = childAt.getWidth();
            if (width > 0) {
                return Math.max(((this.mFirstPosition / 1) * 100) - ((left * 100) / width), 0);
            }
        }
        return this.mSelectedPosition;
    }

    @Override // android.view.View
    protected int computeHorizontalScrollRange() {
        return Math.max((((this.mItemCount + 1) - 1) / 1) * 100, 0);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new b(layoutParams);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAbsSpinner, android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new b(-2, -2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.mInLayout = true;
        k(0, false);
        this.mInLayout = false;
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAbsSpinner
    int Z(View view) {
        return view.getMeasuredHeight();
    }

    void da(int i) {
        int i2 = 0;
        if (getChildCount() != 0) {
            boolean z = i < 0;
            if (HZ()) {
                if ((!Id() || getChildCount() >= this.mItemCount) && b(z, i) != i) {
                    this.aKr.bJ(false);
                    HM();
                }
                if (bF(z)) {
                    offsetChildrenLeftAndRight(i);
                    bG(z);
                    if (z) {
                        HS();
                    } else {
                        HQ();
                    }
                    this.aJZ.clear();
                    HN();
                    invalidate();
                    return;
                }
                return;
            }
            if (z) {
                View childAt = getChildAt(getChildCount() - 1);
                if (childAt != null && childAt.getRight() < getStopFlingPosition()) {
                    if (this.aKr != null) {
                        this.aKr.bI(false);
                    }
                }
                i2 = i;
            } else {
                View childAt2 = getChildAt(0);
                if (childAt2 != null && childAt2.getLeft() > getWidth() - getStopFlingPosition()) {
                    if (this.aKr != null) {
                        this.aKr.bI(false);
                    }
                }
                i2 = i;
            }
            offsetChildrenLeftAndRight(i2);
            bG(z);
            if (z) {
                HS();
            } else {
                HQ();
            }
            this.aJZ.clear();
            HN();
            awakenScrollBars();
            invalidate();
        }
    }

    void db(int i) {
        int i2 = 0;
        if (getChildCount() != 0) {
            boolean z = i < 0;
            if (HZ()) {
                if ((!Id() || getChildCount() >= this.mItemCount) && b(z, i) != i) {
                    this.aKr.bJ(false);
                    HM();
                }
                dc(i);
                bH(z);
                if (z) {
                    HT();
                } else {
                    HR();
                }
                this.aJZ.clear();
                HO();
                invalidate();
                return;
            }
            if (z) {
                View childAt = getChildAt(getChildCount() - 1);
                if (childAt != null && childAt.getRight() < getStopFlingPosition()) {
                    if (this.aKr != null) {
                        this.aKr.bI(false);
                    }
                }
                i2 = i;
            } else {
                View childAt2 = getChildAt(0);
                if (childAt2 != null && childAt2.getLeft() > getWidth() - getStopFlingPosition()) {
                    if (this.aKr != null) {
                        this.aKr.bI(false);
                    }
                }
                i2 = i;
            }
            dc(i2);
            bH(z);
            if (z) {
                HT();
            } else {
                HR();
            }
            this.aJZ.clear();
            HN();
            awakenScrollBars();
            invalidate();
        }
    }

    int b(boolean z, int i) {
        View childAt = getChildAt((z ? this.mItemCount - 1 : 0) - this.mFirstPosition);
        if (childAt == null) {
            return i;
        }
        int ab = ab(childAt);
        int centerOfGallery = getCenterOfGallery();
        if (z) {
            if (ab <= centerOfGallery) {
                return 0;
            }
        } else if (ab >= centerOfGallery) {
            return 0;
        }
        int i2 = centerOfGallery - ab;
        return z ? Math.max(i2, i) : Math.min(i2, i);
    }

    boolean bF(boolean z) {
        View childAt = getChildAt((z ? this.mItemCount - 1 : 0) - this.mFirstPosition);
        if (childAt == null) {
            return true;
        }
        int ab = ab(childAt);
        int centerOfGallery = getCenterOfGallery();
        if (HZ()) {
            if (z) {
                if (ab < centerOfGallery - getMaxMoveOffset()) {
                    return false;
                }
            } else if (ab > centerOfGallery + getMaxMoveOffset()) {
                return false;
            }
        } else if (z) {
            if (ab < ((getRight() - getLeft()) - getPaddingRight()) - getMaxMoveOffset()) {
                return false;
            }
        } else if (ab > getPaddingLeft() + getMaxMoveOffset()) {
            return false;
        }
        return true;
    }

    private void offsetChildrenLeftAndRight(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount).offsetLeftAndRight(i);
        }
    }

    private void dc(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount).offsetTopAndBottom(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCenterOfGallery() {
        return Ia() ? (((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2) + getPaddingTop() : (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
    }

    private float getStopFlingPosition() {
        return Ia() ? (((getHeight() - getPaddingTop()) - getPaddingBottom()) * HJ()) + getPaddingTop() : (((getWidth() - getPaddingLeft()) - getPaddingRight()) * HJ()) + getPaddingLeft();
    }

    protected float HJ() {
        return 0.0f;
    }

    private int ab(View view) {
        return Ia() ? view.getTop() + (view.getHeight() / 2) : view.getLeft() + (view.getWidth() / 2);
    }

    private void bG(boolean z) {
        int i;
        int i2 = 0;
        int childCount = getChildCount();
        int i3 = this.mFirstPosition;
        if (z) {
            int paddingLeft = getPaddingLeft();
            int i4 = 0;
            i = 0;
            while (i4 < childCount) {
                View childAt = getChildAt(i4);
                if (childAt.getRight() >= paddingLeft) {
                    break;
                }
                this.aJZ.c(i3 + i4, childAt);
                i4++;
                i++;
            }
            if (i == childCount) {
                i--;
            }
        } else {
            int width = getWidth() - getPaddingRight();
            i = 0;
            for (int i5 = childCount - 1; i5 >= 0; i5--) {
                View childAt2 = getChildAt(i5);
                if (childAt2.getLeft() <= width) {
                    break;
                }
                this.aJZ.c(i3 + i5, childAt2);
                i++;
                i2 = i5;
            }
            if (i2 == 0) {
                i2++;
            }
        }
        detachViewsFromParent(i2, i);
        if (z) {
            this.mFirstPosition = i + this.mFirstPosition;
            if (Id()) {
                this.mFirstPosition %= this.mItemCount;
            }
        }
    }

    private void bH(boolean z) {
        int i;
        int i2 = 0;
        int childCount = getChildCount();
        int i3 = this.mFirstPosition;
        if (z) {
            int paddingTop = getPaddingTop();
            int i4 = 0;
            i = 0;
            while (i4 < childCount) {
                View childAt = getChildAt(i4);
                if (childAt.getBottom() >= paddingTop) {
                    break;
                }
                this.aJZ.c(i3 + i4, childAt);
                i4++;
                i++;
            }
            if (i == childCount) {
                i--;
            }
        } else {
            int height = getHeight() - getPaddingBottom();
            i = 0;
            for (int i5 = childCount - 1; i5 >= 0; i5--) {
                View childAt2 = getChildAt(i5);
                if (childAt2.getTop() <= height) {
                    break;
                }
                this.aJZ.c(i3 + i5, childAt2);
                i++;
                i2 = i5;
            }
            if (i2 == 0) {
                i2++;
            }
        }
        detachViewsFromParent(i2, i);
        if (z) {
            this.mFirstPosition = i + this.mFirstPosition;
            if (Id()) {
                this.mFirstPosition %= this.mItemCount;
            }
        }
    }

    public void HK() {
        int i = 0;
        if (Ia()) {
            HL();
        } else if (HZ()) {
            if (getChildCount() != 0 && this.aKv != null) {
                int centerOfGallery = getCenterOfGallery() - ab(this.aKv);
                if (centerOfGallery != 0) {
                    this.aKr.dg(centerOfGallery);
                } else {
                    HM();
                }
            }
        } else if (getChildCount() != 0) {
            if (this.mFirstPosition == 0) {
                View childAt = getChildAt(0);
                if (childAt.getLeft() >= 0) {
                    i = getPaddingLeft() - childAt.getLeft();
                } else {
                    View childAt2 = getChildAt(getChildCount() - 1);
                    if (childAt2.getRight() - childAt.getLeft() < getRight() - getPaddingRight()) {
                        i = getPaddingLeft() - this.aKF;
                    } else if (childAt2.getRight() < getRight() - getPaddingRight()) {
                        i = (getWidth() - getPaddingRight()) - childAt2.getRight();
                    }
                }
            } else if (this.mFirstPosition + getChildCount() == this.mItemCount) {
                View childAt3 = getChildAt(getChildCount() - 1);
                if (childAt3.getRight() < getRight() - getPaddingRight()) {
                    i = (getWidth() - getPaddingRight()) - childAt3.getRight();
                }
            }
            if (i != 0) {
                this.aKr.dg(i);
            } else {
                HM();
            }
        }
    }

    private void HL() {
        int i = 0;
        if (HZ()) {
            if (getChildCount() != 0 && this.aKv != null) {
                int centerOfGallery = getCenterOfGallery() - ab(this.aKv);
                if (centerOfGallery != 0) {
                    this.aKr.dg(centerOfGallery);
                } else {
                    HM();
                }
            }
        } else if (getChildCount() != 0) {
            if (this.mFirstPosition == 0) {
                View childAt = getChildAt(0);
                if (childAt.getTop() >= 0) {
                    i = getPaddingTop() - childAt.getTop();
                } else {
                    View childAt2 = getChildAt(getChildCount() - 1);
                    if (childAt2.getBottom() - childAt.getTop() < getBottom() - getPaddingBottom()) {
                        i = getPaddingLeft() - this.aKF;
                    } else if (childAt2.getBottom() < getBottom() - getPaddingBottom()) {
                        i = (getHeight() - getPaddingBottom()) - childAt2.getBottom();
                    }
                }
            } else if (this.mFirstPosition + getChildCount() == this.mItemCount) {
                View childAt3 = getChildAt(getChildCount() - 1);
                if (childAt3.getBottom() < getBottom() - getPaddingBottom()) {
                    i = (getHeight() - getPaddingBottom()) - childAt3.getBottom();
                }
            }
            if (i != 0) {
                this.aKr.dg(i);
            } else {
                HM();
            }
        }
    }

    private void HM() {
        if (this.aKy) {
            this.aKy = false;
        }
        super.selectionChanged();
        invalidate();
        Ib();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public void selectionChanged() {
        if (!this.aKy) {
            super.selectionChanged();
        }
    }

    private void HN() {
        View view = this.aKv;
        if (this.aKv != null) {
            int centerOfGallery = getCenterOfGallery();
            if (view.getLeft() > centerOfGallery || view.getRight() < centerOfGallery) {
                int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                int i2 = 0;
                int childCount = getChildCount() - 1;
                while (true) {
                    if (childCount < 0) {
                        childCount = i2;
                        break;
                    }
                    View childAt = getChildAt(childCount);
                    if (childAt.getLeft() <= centerOfGallery && childAt.getRight() >= centerOfGallery) {
                        break;
                    }
                    int min = Math.min(Math.abs(childAt.getLeft() - centerOfGallery), Math.abs(childAt.getRight() - centerOfGallery));
                    if (min < i) {
                        i2 = childCount;
                    } else {
                        min = i;
                    }
                    childCount--;
                    i = min;
                }
                int i3 = this.mFirstPosition + childCount;
                if (Id()) {
                    i3 %= this.mItemCount;
                }
                if (i3 != this.mSelectedPosition) {
                    setSelectedPositionInt(i3);
                    setNextSelectedPositionInt(i3);
                    checkSelectionChanged();
                }
            }
        }
    }

    private void HO() {
        View view = this.aKv;
        if (this.aKv != null) {
            int centerOfGallery = getCenterOfGallery();
            if (view == null || view.getTop() > centerOfGallery || view.getBottom() < centerOfGallery) {
                int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                int i2 = 0;
                int childCount = getChildCount() - 1;
                while (true) {
                    if (childCount < 0) {
                        childCount = i2;
                        break;
                    }
                    View childAt = getChildAt(childCount);
                    if (childAt.getTop() <= centerOfGallery && childAt.getBottom() >= centerOfGallery) {
                        break;
                    }
                    int min = Math.min(Math.abs(childAt.getTop() - centerOfGallery), Math.abs(childAt.getBottom() - centerOfGallery));
                    if (min < i) {
                        i2 = childCount;
                    } else {
                        min = i;
                    }
                    childCount--;
                    i = min;
                }
                int i3 = this.mFirstPosition + childCount;
                if (Id()) {
                    i3 %= this.mItemCount;
                }
                if (i3 != this.mSelectedPosition) {
                    setSelectedPositionInt(i3);
                    setNextSelectedPositionInt(i3);
                    checkSelectionChanged();
                }
            }
        }
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAbsSpinner
    void k(int i, boolean z) {
        if (Ia()) {
            l(i, z);
            return;
        }
        int i2 = this.aKF + this.aJX.left;
        if (this.mDataChanged) {
            handleDataChanged();
        }
        if (this.mItemCount == 0) {
            resetList();
            return;
        }
        if (this.mNextSelectedPosition >= 0) {
            setSelectedPositionInt(this.mNextSelectedPosition);
        }
        HI();
        detachAllViewsFromParent();
        this.aKo = 0;
        this.aKn = 0;
        this.mFirstPosition = this.mSelectedPosition;
        View a2 = a(this.mFirstPosition, 0, 0, true);
        int i3 = this.Ot + i2;
        if (HZ()) {
            i3 = (((((getRight() - getLeft()) - this.aJX.left) - this.aJX.right) / 2) + i2) - (a2.getWidth() / 2);
        }
        a2.offsetLeftAndRight(i3);
        HS();
        HQ();
        this.aJZ.clear();
        invalidate();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        HY();
        this.aKK = getChildCount() < this.mItemCount;
    }

    void l(int i, boolean z) {
        if (this.mDataChanged) {
            handleDataChanged();
        }
        if (this.mItemCount == 0) {
            resetList();
            return;
        }
        if (this.mNextSelectedPosition >= 0) {
            setSelectedPositionInt(this.mNextSelectedPosition);
        }
        HP();
        boolean z2 = this.aKK;
        this.aKK = getChildCount() < this.mItemCount;
        if (z2 != this.aKK) {
            HP();
        }
        this.aJZ.clear();
        invalidate();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        HY();
    }

    private void HP() {
        int i = this.aKF + this.aJX.top;
        HI();
        detachAllViewsFromParent();
        this.aKo = 0;
        this.aKn = 0;
        this.mFirstPosition = this.mSelectedPosition;
        View b2 = b(this.mFirstPosition, 0, 0, true);
        int i2 = this.Ot + i;
        if (HZ()) {
            i2 = (((((getBottom() - getTop()) - this.aJX.top) - this.aJX.bottom) / 2) + i) - (b2.getHeight() / 2);
        }
        b2.offsetTopAndBottom(i2);
        HT();
        HR();
    }

    private void HQ() {
        int right;
        int i;
        if (Id()) {
            Ie();
            return;
        }
        int i2 = this.Ot;
        int paddingLeft = getPaddingLeft();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.mFirstPosition - 1;
            right = childAt.getLeft() - i2;
        } else {
            right = (getRight() - getLeft()) - getPaddingRight();
            this.aKu = true;
            i = 0;
        }
        while (right > paddingLeft && i >= 0) {
            View a2 = a(i, i - this.mSelectedPosition, right, false);
            this.mFirstPosition = i;
            right = a2.getLeft() - i2;
            i--;
        }
    }

    private void HR() {
        int bottom;
        int i;
        if (Id()) {
            If();
            return;
        }
        int i2 = this.Ot;
        int paddingTop = getPaddingTop();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.mFirstPosition - 1;
            bottom = childAt.getTop() - i2;
        } else {
            bottom = (getBottom() - getTop()) - getPaddingBottom();
            this.aKu = true;
            i = 0;
        }
        while (bottom > paddingTop && i >= 0) {
            View b2 = b(i, i - this.mSelectedPosition, bottom, false);
            this.mFirstPosition = i;
            bottom = b2.getTop() - i2;
            i--;
        }
    }

    private void HS() {
        int i;
        int paddingLeft;
        if (Id()) {
            Ig();
            return;
        }
        int i2 = this.Ot;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i3 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i = this.mFirstPosition + childCount;
            paddingLeft = childAt.getRight() + i2;
        } else {
            i = this.mItemCount - 1;
            this.mFirstPosition = i;
            paddingLeft = getPaddingLeft();
            this.aKu = true;
        }
        while (paddingLeft < right && i < i3) {
            paddingLeft = a(i, i - this.mSelectedPosition, paddingLeft, true).getRight() + i2;
            i++;
        }
    }

    private void HT() {
        int i;
        int paddingTop;
        if (Id()) {
            Ih();
            return;
        }
        int i2 = this.Ot;
        int bottom = (getBottom() - getTop()) - getPaddingRight();
        int childCount = getChildCount();
        int i3 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        if (childAt != null) {
            i = this.mFirstPosition + childCount;
            paddingTop = childAt.getBottom() + i2;
        } else {
            i = this.mItemCount - 1;
            this.mFirstPosition = i;
            paddingTop = getPaddingTop();
            this.aKu = true;
        }
        while (paddingTop < bottom && i < i3) {
            paddingTop = b(i, i - this.mSelectedPosition, paddingTop, true).getBottom() + i2;
            i++;
        }
    }

    private View a(int i, int i2, int i3, boolean z) {
        View cY;
        if (!this.mDataChanged && (cY = this.aJZ.cY(i)) != null) {
            int left = cY.getLeft();
            this.aKo = Math.max(this.aKo, cY.getMeasuredWidth() + left);
            this.aKn = Math.min(this.aKn, left);
            a(cY, i2, i3, z);
            return cY;
        }
        View view = this.mAdapter.getView(i, null, this);
        a(view, i2, i3, z);
        return view;
    }

    private View b(int i, int i2, int i3, boolean z) {
        View cY;
        if (!this.mDataChanged && (cY = this.aJZ.cY(i)) != null) {
            int top = cY.getTop();
            this.aKo = Math.max(this.aKo, cY.getMeasuredHeight() + top);
            this.aKn = Math.min(this.aKn, top);
            b(cY, i2, i3, z);
            return cY;
        }
        View view = this.mAdapter.getView(i, null, this);
        b(view, i2, i3, z);
        return view;
    }

    private void a(View view, int i, int i2, boolean z) {
        int i3;
        b bVar = (b) view.getLayoutParams();
        b bVar2 = bVar == null ? (b) generateDefaultLayoutParams() : bVar;
        addViewInLayout(view, z ? -1 : 0, bVar2);
        view.setSelected(i == 0);
        view.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.aJX.left + this.aJX.right, bVar2.width), ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.aJX.top + this.aJX.bottom, bVar2.height));
        int b2 = b(view, true);
        int measuredHeight = b2 + view.getMeasuredHeight();
        int measuredWidth = view.getMeasuredWidth();
        if (z) {
            int i4 = measuredWidth + i2;
            i3 = i2;
            i2 = i4;
        } else {
            i3 = i2 - measuredWidth;
        }
        view.layout(i3, b2, i2, measuredHeight);
    }

    private void b(View view, int i, int i2, boolean z) {
        int i3;
        b bVar = (b) view.getLayoutParams();
        b bVar2 = bVar == null ? (b) generateDefaultLayoutParams() : bVar;
        addViewInLayout(view, z ? -1 : 0, bVar2);
        view.setSelected(i == 0);
        view.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.aJX.left + this.aJX.right, bVar2.width), ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.aJX.top + this.aJX.bottom, bVar2.height));
        int c2 = c(view, true);
        int measuredWidth = c2 + view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (z) {
            int i4 = measuredHeight + i2;
            i3 = i2;
            i2 = i4;
        } else {
            i3 = i2 - measuredHeight;
        }
        view.layout(c2, i3, measuredWidth, i2);
    }

    private int b(View view, boolean z) {
        int measuredHeight = z ? getMeasuredHeight() : getHeight();
        int measuredHeight2 = z ? view.getMeasuredHeight() : view.getHeight();
        switch (this.mGravity) {
            case 16:
                return ((((measuredHeight - this.aJX.bottom) - this.aJX.top) - measuredHeight2) / 2) + this.aJX.top;
            case 48:
                return this.aJX.top;
            case 80:
                return (measuredHeight - this.aJX.bottom) - measuredHeight2;
            default:
                return 0;
        }
    }

    private int c(View view, boolean z) {
        int measuredWidth = z ? getMeasuredWidth() : getWidth();
        int measuredWidth2 = z ? view.getMeasuredWidth() : view.getWidth();
        switch (this.mGravity) {
            case 1:
                return ((((measuredWidth - this.aJX.right) - this.aJX.left) - measuredWidth2) / 2) + this.aJX.left;
            case 2:
            case 4:
            default:
                return 0;
            case 3:
                return this.aJX.left;
            case 5:
                return (measuredWidth - this.aJX.right) - measuredWidth2;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.mGestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            HU();
        } else if (action == 3) {
            onCancel();
        }
        return onTouchEvent;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.aKp >= 0) {
            if (Id()) {
                this.aKp %= getCount();
            }
            if (HZ()) {
                dd(this.aKp - this.mFirstPosition);
            }
            de(this.aKp);
            if (this.aKx || this.aKp == this.mSelectedPosition) {
                performItemClick(this.aKq, this.aKp, this.mAdapter.getItemId(this.aKp));
            }
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!Ic()) {
            if (!this.aKw) {
                removeCallbacks(this.aKt);
                if (!this.aKy) {
                    this.aKy = true;
                }
            }
            if (Ia()) {
                this.aKr.df((int) (-(getVelocityRatio() * f2)));
            } else {
                this.aKr.df((int) (-(getVelocityRatio() * f)));
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!Ic()) {
            this.aKE = true;
            getParent().requestDisallowInterceptTouchEvent(true);
            if (!this.aKw) {
                if (this.aKB) {
                    if (!this.aKy) {
                        this.aKy = true;
                    }
                    postDelayed(this.aKt, 250L);
                }
            } else if (this.aKy) {
                this.aKy = false;
            }
            if (Ia()) {
                db(((int) f2) * (-1));
            } else {
                int i = ((int) f) * (-1);
                if (bF(i < 0)) {
                    da(i);
                }
            }
            this.aKB = false;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.aKr.bI(false);
        this.aKp = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (this.aKp >= 0) {
            this.aKq = getChildAt(this.aKp - this.mFirstPosition);
            this.aKq.setPressed(true);
        }
        this.aKB = true;
        return true;
    }

    protected void HU() {
        if (this.aKr.mScroller.isFinished()) {
            HK();
        }
        HV();
    }

    void onCancel() {
        HU();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.aKp >= 0) {
            performHapticFeedback(0);
            b(this.aKq, this.aKp, getItemIdAtPosition(this.aKp));
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    private void ac(View view) {
        if (view != null) {
            view.setPressed(true);
        }
        setPressed(true);
    }

    protected void HV() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount).setPressed(false);
        }
        setPressed(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchSetSelected(boolean z) {
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchSetPressed(boolean z) {
        if (this.aKv != null) {
            this.aKv.setPressed(z);
        }
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.aKA;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView < 0) {
            return false;
        }
        return b(view, positionForView, this.mAdapter.getItemId(positionForView));
    }

    @Override // android.view.View
    public boolean showContextMenu() {
        if (!isPressed() || this.mSelectedPosition < 0) {
            return false;
        }
        return b(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mSelectedRowId);
    }

    private boolean b(View view, int i, long j) {
        boolean d = this.aKf != null ? this.aKf.d(this, this.aKq, this.aKp, j) : false;
        if (!d) {
            this.aKA = new BdAdapterView.a(view, i, j);
            d = super.showContextMenuForChild(this);
        }
        if (d) {
            performHapticFeedback(0);
        }
        return d;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return keyEvent.dispatch(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        switch (i) {
            case 21:
                if (HW()) {
                    playSoundEffect(1);
                    return true;
                }
                return true;
            case 22:
                if (HX()) {
                    playSoundEffect(3);
                    return true;
                }
                return true;
            case 23:
            case 66:
                this.aKz = true;
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        switch (i) {
            case 23:
            case 66:
                if (this.aKz && this.mItemCount > 0) {
                    ac(this.aKv);
                    postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.wheelview.BdGallery.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BdGallery.this.HV();
                        }
                    }, ViewConfiguration.getPressedStateDuration());
                    performItemClick(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mAdapter.getItemId(this.mSelectedPosition));
                }
                this.aKz = false;
                return true;
            default:
                return super.onKeyUp(i, keyEvent);
        }
    }

    boolean HW() {
        return this.mItemCount > 0 && this.mSelectedPosition > 0;
    }

    boolean HX() {
        return this.mItemCount > 0 && this.mSelectedPosition < this.mItemCount + (-1);
    }

    private boolean dd(int i) {
        View childAt = getChildAt(i);
        if (childAt != null) {
            this.aKr.dg(getCenterOfGallery() - ab(childAt));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public void setSelectedPositionInt(int i) {
        super.setSelectedPositionInt(i);
        HY();
    }

    private void HY() {
        View view = this.aKv;
        fW(" updateSelectedItemMetadata   mSelectedPosition =  " + this.mSelectedPosition + "   mFirstPosition = " + this.mFirstPosition);
        int i = this.mSelectedPosition - this.mFirstPosition;
        if (Id() && this.mFirstPosition > this.mSelectedPosition) {
            i = (this.mItemCount - this.mFirstPosition) + this.mSelectedPosition;
        }
        View childAt = getChildAt(i);
        this.aKv = childAt;
        if (childAt != null) {
            childAt.setSelected(true);
            childAt.setFocusable(true);
            if (hasFocus()) {
                childAt.requestFocus();
            }
            if (view != null) {
                view.setSelected(false);
                view.setFocusable(false);
            }
        }
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            this.mGravity = i;
            requestLayout();
        }
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        int i3 = this.mSelectedPosition - this.mFirstPosition;
        if (i3 >= 0) {
            if (i2 == i - 1) {
                return i3;
            }
            if (i2 >= i3) {
                return i2 + 1;
            }
            return i2;
        }
        return i2;
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (z && this.aKv != null) {
            this.aKv.requestFocus(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private int mLastFlingX;
        private int mLastFlingY;
        private Scroller mScroller;

        public a() {
            this.mScroller = new Scroller(BdGallery.this.getContext());
        }

        private void oR() {
            BdGallery.this.removeCallbacks(this);
        }

        public void df(int i) {
            if (i != 0) {
                oR();
                if (BdGallery.this.Ia()) {
                    int i2 = i < 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : 0;
                    this.mLastFlingY = i2;
                    this.mScroller.fling(0, i2, 0, i, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    BdGallery.this.post(this);
                    return;
                }
                int i3 = i < 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : 0;
                this.mLastFlingX = i3;
                this.mScroller.fling(i3, 0, i, 0, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                BdGallery.this.post(this);
            }
        }

        public void dg(int i) {
            if (i != 0) {
                if (BdGallery.this.Ia()) {
                    oR();
                    BdGallery.this.aKE = true;
                    this.mLastFlingY = 0;
                    this.mScroller.startScroll(0, 0, 0, -i, BdGallery.this.aKl);
                    BdGallery.this.post(this);
                    return;
                }
                oR();
                BdGallery.this.aKE = true;
                this.mLastFlingX = 0;
                this.mScroller.startScroll(0, 0, -i, 0, BdGallery.this.aKl);
                BdGallery.this.post(this);
            }
        }

        public void bI(boolean z) {
            BdGallery.this.removeCallbacks(this);
            bJ(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void bJ(boolean z) {
            BdGallery.this.aKE = false;
            this.mScroller.forceFinished(true);
            if (z) {
                BdGallery.this.HK();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            if (BdGallery.this.Ia()) {
                Ii();
            } else if (BdGallery.this.mItemCount != 0) {
                BdGallery.this.aKu = false;
                Scroller scroller = this.mScroller;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = this.mLastFlingX - currX;
                if (i > 0) {
                    BdGallery.this.aKp = BdGallery.this.mFirstPosition;
                    max = Math.min(((BdGallery.this.getWidth() - BdGallery.this.getPaddingLeft()) - BdGallery.this.getPaddingRight()) - 1, i);
                } else {
                    BdGallery.this.aKp = (BdGallery.this.getChildCount() - 1) + BdGallery.this.mFirstPosition;
                    max = Math.max(-(((BdGallery.this.getWidth() - BdGallery.this.getPaddingRight()) - BdGallery.this.getPaddingLeft()) - 1), i);
                }
                boolean z = max <= 0;
                if (max != 0 && !BdGallery.this.bF(z)) {
                    BdGallery.this.aKu = true;
                } else {
                    BdGallery.this.da(max);
                }
                if (computeScrollOffset && !BdGallery.this.aKu) {
                    this.mLastFlingX = currX;
                    BdGallery.this.post(this);
                    return;
                }
                bJ(true);
            } else {
                bJ(true);
            }
        }

        public void Ii() {
            int max;
            if (BdGallery.this.mItemCount != 0) {
                BdGallery.this.aKu = false;
                Scroller scroller = this.mScroller;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currY = scroller.getCurrY();
                int i = this.mLastFlingY - currY;
                if (i > 0) {
                    BdGallery.this.aKp = BdGallery.this.mFirstPosition;
                    max = Math.min(((BdGallery.this.getHeight() - BdGallery.this.getPaddingTop()) - BdGallery.this.getPaddingBottom()) - 1, i);
                } else {
                    BdGallery.this.aKp = (BdGallery.this.getChildCount() - 1) + BdGallery.this.mFirstPosition;
                    max = Math.max(-(((BdGallery.this.getHeight() - BdGallery.this.getPaddingBottom()) - BdGallery.this.getPaddingTop()) - 1), i);
                }
                BdGallery.this.db(max);
                if (computeScrollOffset && !BdGallery.this.aKu) {
                    this.mLastFlingY = currY;
                    BdGallery.this.post(this);
                    return;
                }
                bJ(true);
                return;
            }
            bJ(true);
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends ViewGroup.LayoutParams {
        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public b(int i, int i2) {
            super(i, i2);
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    private boolean de(int i) {
        if (i != this.mSelectedPosition) {
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            checkSelectionChanged();
            return true;
        }
        return false;
    }

    public void setFirstChildOffset(int i) {
        this.aKF = i;
    }

    public void setFirstPosition(int i) {
        this.mFirstPosition = i;
    }

    public void setSlotInCenter(boolean z) {
        this.aKL = z;
    }

    public boolean HZ() {
        return this.aKL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Ia() {
        return this.mOrientation == 2;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setOnEndFlingListener(c cVar) {
        this.aKM = cVar;
    }

    public void setDisableScroll(boolean z) {
        this.aKC = z;
    }

    public void setDisableScrollAnyway(boolean z) {
        this.aKD = z;
    }

    public void setScrollBarBottomMargin(int i) {
        this.aKG = i;
    }

    @Override // android.view.View
    public void setScrollBarSize(int i) {
        this.aKH = i;
    }

    public int getFirstPosition() {
        return this.mFirstPosition;
    }

    public int getSpacing() {
        return this.Ot;
    }

    protected void Ib() {
        if (this.aKM != null && !this.mInLayout && !this.mBlockLayoutRequests) {
            this.aKM.a(this);
        }
    }

    public float getVelocityRatio() {
        return this.aKI;
    }

    public void setVelocityRatio(float f) {
        this.aKI = f;
        if (this.aKI < 0.5f) {
            this.aKI = 0.5f;
        } else if (this.aKI > 1.5f) {
            this.aKI = 1.5f;
        }
    }

    protected boolean Ic() {
        if (this.aKD) {
            return true;
        }
        if (this.aKC && getChildCount() >= this.mItemCount) {
            View childAt = getChildAt(0);
            if (childAt == null || childAt.getLeft() >= getLeft()) {
                View childAt2 = getChildAt(getChildCount() - 1);
                return childAt2 == null || childAt2.getRight() <= getRight();
            }
            return false;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        if (1 != motionEvent.getAction() || this.aKp < 0) {
            return false;
        }
        if (this.aKx || this.aKp == this.mSelectedPosition) {
            a(this.aKq, this.aKp, this.mAdapter.getItemId(this.aKp));
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    public void setScrollCycle(boolean z) {
        this.aKJ = z;
    }

    public boolean Id() {
        return this.aKJ && this.aKK;
    }

    public void setMaxMoveOffset(int i) {
        this.aKs = i;
    }

    private long getMaxMoveOffset() {
        return this.aKs;
    }

    protected void fW(String str) {
    }

    private void Ie() {
        int right;
        int i;
        int i2 = this.Ot;
        int paddingLeft = getPaddingLeft();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.mFirstPosition - 1;
            right = childAt.getLeft() - i2;
        } else {
            right = (getRight() - getLeft()) - getPaddingRight();
            this.aKu = true;
            i = 0;
        }
        while (right > paddingLeft && i >= 0) {
            View a2 = a(i, i - this.mSelectedPosition, right, false);
            this.mFirstPosition = i;
            right = a2.getLeft() - i2;
            i--;
        }
        int i3 = this.mItemCount - 1;
        while (right > paddingLeft && getChildCount() < this.mItemCount) {
            View a3 = a(i3, i3 - this.mSelectedPosition, right, false);
            this.mFirstPosition = i3;
            right = a3.getLeft() - i2;
            i3--;
        }
    }

    private void If() {
        int bottom;
        int i;
        int i2 = this.Ot;
        int paddingTop = getPaddingTop();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.mFirstPosition - 1;
            bottom = childAt.getTop() - i2;
        } else {
            bottom = (getBottom() - getTop()) - getPaddingBottom();
            this.aKu = true;
            i = 0;
        }
        while (bottom > paddingTop && i >= 0) {
            View b2 = b(i, i - this.mSelectedPosition, bottom, false);
            this.mFirstPosition = i;
            bottom = b2.getTop() - i2;
            i--;
        }
        int i3 = this.mItemCount - 1;
        while (bottom > paddingTop && getChildCount() < this.mItemCount) {
            View b3 = b(i3, i3 - this.mSelectedPosition, bottom, false);
            this.mFirstPosition = i3;
            bottom = b3.getTop() - i2;
            i3--;
        }
    }

    private void Ig() {
        int i;
        int paddingLeft;
        int i2 = this.Ot;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i3 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        fW("  fillToGalleryRightCycle mFirstPosition = " + this.mFirstPosition);
        if (childAt != null) {
            i = this.mFirstPosition + childCount;
            paddingLeft = childAt.getRight() + i2;
        } else {
            i = this.mItemCount - 1;
            this.mFirstPosition = i;
            paddingLeft = getPaddingLeft();
            this.aKu = true;
        }
        while (paddingLeft < right && i < i3) {
            paddingLeft = a(i, i - this.mSelectedPosition, paddingLeft, true).getRight() + i2;
            i++;
        }
        int i4 = i % i3;
        while (paddingLeft <= right && getChildCount() < this.mItemCount) {
            paddingLeft = a(i4, i4 - this.mSelectedPosition, paddingLeft, true).getRight() + i2;
            i4++;
        }
    }

    private void Ih() {
        int i;
        int paddingTop;
        int i2 = this.Ot;
        int bottom = (getBottom() - getTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i3 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        fW("  fillToGalleryRightCycle mFirstPosition = " + this.mFirstPosition);
        if (childAt != null) {
            i = this.mFirstPosition + childCount;
            paddingTop = childAt.getBottom() + i2;
        } else {
            i = this.mItemCount - 1;
            this.mFirstPosition = i;
            paddingTop = getPaddingTop();
            this.aKu = true;
        }
        while (paddingTop < bottom && i < i3) {
            paddingTop = b(i, i - this.mSelectedPosition, paddingTop, true).getBottom() + i2;
            i++;
        }
        int i4 = i % i3;
        while (paddingTop <= bottom && getChildCount() < this.mItemCount) {
            paddingTop = b(i4, i4 - this.mSelectedPosition, paddingTop, true).getBottom() + i2;
            i4++;
        }
    }
}
