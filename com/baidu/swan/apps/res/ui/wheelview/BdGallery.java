package com.baidu.swan.apps.res.ui.wheelview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
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
    private int bgA;
    private int bgB;
    private float bgC;
    private boolean bgD;
    private boolean bgE;
    private boolean bgF;
    private c bgG;
    private int bge;
    private float bgf;
    private int bgg;
    private int bgh;
    private int bgi;
    private View bgj;
    private a bgk;
    private long bgl;
    private Runnable bgm;
    private boolean bgn;
    private View bgo;
    private boolean bgp;
    private boolean bgq;
    private boolean bgr;
    private boolean bgt;
    private BdAdapterView.a bgu;
    private boolean bgv;
    private boolean bgw;
    private boolean bgx;
    private boolean bgy;
    private int bgz;
    private GestureDetector mGestureDetector;
    private int mGravity;
    private int mOrientation;
    private int mSpacing;

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
        this.mSpacing = 0;
        this.bge = 400;
        this.bgk = new a();
        this.bgl = 2147483646L;
        this.bgm = new Runnable() { // from class: com.baidu.swan.apps.res.ui.wheelview.BdGallery.1
            @Override // java.lang.Runnable
            public void run() {
                BdGallery.this.bgr = false;
                BdGallery.this.selectionChanged();
            }
        };
        this.bgp = true;
        this.bgq = true;
        this.bgw = false;
        this.bgx = false;
        this.bgy = false;
        this.bgz = 0;
        this.bgA = 0;
        this.bgB = 5;
        this.bgC = 1.0f;
        this.bgD = false;
        this.bgE = true;
        this.bgF = false;
        this.mOrientation = 1;
        this.bgG = null;
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
        this.bgB = ViewConfiguration.get(context).getScaledScrollBarSize();
        if (PZ()) {
            this.mGravity = 1;
        } else {
            this.mGravity = 16;
        }
    }

    public void setCallbackDuringFling(boolean z) {
        this.bgp = z;
    }

    public void setCallbackOnUnselectedItemClick(boolean z) {
        this.bgq = z;
    }

    public void setAnimationDuration(int i) {
        this.bge = i;
    }

    public void setSpacing(int i) {
        this.mSpacing = i;
    }

    public void setUnselectedAlpha(float f) {
        this.bgf = f;
    }

    @Override // android.view.ViewGroup
    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        transformation.clear();
        transformation.setAlpha(view == this.bgo ? 1.0f : this.bgf);
        hb(" getChildStaticTransformation   mSelectedPosition =  " + this.mSelectedPosition + "   mFirstPosition = " + this.mFirstPosition + "     mSelectedChild = " + this.bgo);
        return true;
    }

    @Override // android.view.View
    public void invalidate(int i, int i2, int i3, int i4) {
        super.invalidate(i, i2 - (this.bgB + this.bgA), i3, i4);
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
        q(0, false);
        this.mInLayout = false;
    }

    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAbsSpinner
    int ah(View view) {
        return view.getMeasuredHeight();
    }

    void ed(int i) {
        int i2 = 0;
        if (getChildCount() != 0) {
            boolean z = i < 0;
            if (PY()) {
                if ((!Qc() || getChildCount() >= this.mItemCount) && c(z, i) != i) {
                    this.bgk.cm(false);
                    PL();
                }
                if (ci(z)) {
                    offsetChildrenLeftAndRight(i);
                    cj(z);
                    if (z) {
                        PR();
                    } else {
                        PP();
                    }
                    this.bfU.clear();
                    PM();
                    invalidate();
                    return;
                }
                return;
            }
            if (z) {
                View childAt = getChildAt(getChildCount() - 1);
                if (childAt != null && childAt.getRight() < getStopFlingPosition()) {
                    if (this.bgk != null) {
                        this.bgk.cl(false);
                    }
                }
                i2 = i;
            } else {
                View childAt2 = getChildAt(0);
                if (childAt2 != null && childAt2.getLeft() > getWidth() - getStopFlingPosition()) {
                    if (this.bgk != null) {
                        this.bgk.cl(false);
                    }
                }
                i2 = i;
            }
            offsetChildrenLeftAndRight(i2);
            cj(z);
            if (z) {
                PR();
            } else {
                PP();
            }
            this.bfU.clear();
            PM();
            awakenScrollBars();
            invalidate();
        }
    }

    void ee(int i) {
        int i2 = 0;
        if (getChildCount() != 0) {
            boolean z = i < 0;
            if (PY()) {
                if ((!Qc() || getChildCount() >= this.mItemCount) && c(z, i) != i) {
                    this.bgk.cm(false);
                    PL();
                }
                ef(i);
                ck(z);
                if (z) {
                    PS();
                } else {
                    PQ();
                }
                this.bfU.clear();
                PN();
                invalidate();
                return;
            }
            if (z) {
                View childAt = getChildAt(getChildCount() - 1);
                if (childAt != null && childAt.getRight() < getStopFlingPosition()) {
                    if (this.bgk != null) {
                        this.bgk.cl(false);
                    }
                }
                i2 = i;
            } else {
                View childAt2 = getChildAt(0);
                if (childAt2 != null && childAt2.getLeft() > getWidth() - getStopFlingPosition()) {
                    if (this.bgk != null) {
                        this.bgk.cl(false);
                    }
                }
                i2 = i;
            }
            ef(i2);
            ck(z);
            if (z) {
                PS();
            } else {
                PQ();
            }
            this.bfU.clear();
            PM();
            awakenScrollBars();
            invalidate();
        }
    }

    int c(boolean z, int i) {
        View childAt = getChildAt((z ? this.mItemCount - 1 : 0) - this.mFirstPosition);
        if (childAt == null) {
            return i;
        }
        int aj = aj(childAt);
        int centerOfGallery = getCenterOfGallery();
        if (z) {
            if (aj <= centerOfGallery) {
                return 0;
            }
        } else if (aj >= centerOfGallery) {
            return 0;
        }
        int i2 = centerOfGallery - aj;
        return z ? Math.max(i2, i) : Math.min(i2, i);
    }

    boolean ci(boolean z) {
        View childAt = getChildAt((z ? this.mItemCount - 1 : 0) - this.mFirstPosition);
        if (childAt == null) {
            return true;
        }
        int aj = aj(childAt);
        int centerOfGallery = getCenterOfGallery();
        if (PY()) {
            if (z) {
                if (aj < centerOfGallery - getMaxMoveOffset()) {
                    return false;
                }
            } else if (aj > centerOfGallery + getMaxMoveOffset()) {
                return false;
            }
        } else if (z) {
            if (aj < ((getRight() - getLeft()) - getPaddingRight()) - getMaxMoveOffset()) {
                return false;
            }
        } else if (aj > getPaddingLeft() + getMaxMoveOffset()) {
            return false;
        }
        return true;
    }

    private void offsetChildrenLeftAndRight(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount).offsetLeftAndRight(i);
        }
    }

    private void ef(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            getChildAt(childCount).offsetTopAndBottom(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getCenterOfGallery() {
        return PZ() ? (((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2) + getPaddingTop() : (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2) + getPaddingLeft();
    }

    private float getStopFlingPosition() {
        return PZ() ? (((getHeight() - getPaddingTop()) - getPaddingBottom()) * PI()) + getPaddingTop() : (((getWidth() - getPaddingLeft()) - getPaddingRight()) * PI()) + getPaddingLeft();
    }

    protected float PI() {
        return 0.0f;
    }

    private int aj(View view) {
        return PZ() ? view.getTop() + (view.getHeight() / 2) : view.getLeft() + (view.getWidth() / 2);
    }

    private void cj(boolean z) {
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
                this.bfU.d(i3 + i4, childAt);
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
                this.bfU.d(i3 + i5, childAt2);
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
            if (Qc()) {
                this.mFirstPosition %= this.mItemCount;
            }
        }
    }

    private void ck(boolean z) {
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
                this.bfU.d(i3 + i4, childAt);
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
                this.bfU.d(i3 + i5, childAt2);
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
            if (Qc()) {
                this.mFirstPosition %= this.mItemCount;
            }
        }
    }

    public void PJ() {
        int i = 0;
        if (PZ()) {
            PK();
        } else if (PY()) {
            if (getChildCount() != 0 && this.bgo != null) {
                int centerOfGallery = getCenterOfGallery() - aj(this.bgo);
                if (centerOfGallery != 0) {
                    this.bgk.ej(centerOfGallery);
                } else {
                    PL();
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
                        i = getPaddingLeft() - this.bgz;
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
                this.bgk.ej(i);
            } else {
                PL();
            }
        }
    }

    private void PK() {
        int i = 0;
        if (PY()) {
            if (getChildCount() != 0 && this.bgo != null) {
                int centerOfGallery = getCenterOfGallery() - aj(this.bgo);
                if (centerOfGallery != 0) {
                    this.bgk.ej(centerOfGallery);
                } else {
                    PL();
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
                        i = getPaddingLeft() - this.bgz;
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
                this.bgk.ej(i);
            } else {
                PL();
            }
        }
    }

    private void PL() {
        if (this.bgr) {
            this.bgr = false;
        }
        super.selectionChanged();
        invalidate();
        Qa();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public void selectionChanged() {
        if (!this.bgr) {
            super.selectionChanged();
        }
    }

    private void PM() {
        View view = this.bgo;
        if (this.bgo != null) {
            int centerOfGallery = getCenterOfGallery();
            if (view.getLeft() > centerOfGallery || view.getRight() < centerOfGallery) {
                int i = Integer.MAX_VALUE;
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
                if (Qc()) {
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

    private void PN() {
        View view = this.bgo;
        if (this.bgo != null) {
            int centerOfGallery = getCenterOfGallery();
            if (view == null || view.getTop() > centerOfGallery || view.getBottom() < centerOfGallery) {
                int i = Integer.MAX_VALUE;
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
                if (Qc()) {
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
    void q(int i, boolean z) {
        if (PZ()) {
            r(i, z);
            return;
        }
        int i2 = this.bgz + this.bfS.left;
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
        PH();
        detachAllViewsFromParent();
        this.bgh = 0;
        this.bgg = 0;
        this.mFirstPosition = this.mSelectedPosition;
        View a2 = a(this.mFirstPosition, 0, 0, true);
        int i3 = this.mSpacing + i2;
        if (PY()) {
            i3 = (((((getRight() - getLeft()) - this.bfS.left) - this.bfS.right) / 2) + i2) - (a2.getWidth() / 2);
        }
        a2.offsetLeftAndRight(i3);
        PR();
        PP();
        this.bfU.clear();
        invalidate();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        PX();
        this.bgE = getChildCount() < this.mItemCount;
    }

    void r(int i, boolean z) {
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
        PO();
        boolean z2 = this.bgE;
        this.bgE = getChildCount() < this.mItemCount;
        if (z2 != this.bgE) {
            PO();
        }
        this.bfU.clear();
        invalidate();
        this.mDataChanged = false;
        this.mNeedSync = false;
        setNextSelectedPositionInt(this.mSelectedPosition);
        PX();
    }

    private void PO() {
        int i = this.bgz + this.bfS.top;
        PH();
        detachAllViewsFromParent();
        this.bgh = 0;
        this.bgg = 0;
        this.mFirstPosition = this.mSelectedPosition;
        View b2 = b(this.mFirstPosition, 0, 0, true);
        int i2 = this.mSpacing + i;
        if (PY()) {
            i2 = (((((getBottom() - getTop()) - this.bfS.top) - this.bfS.bottom) / 2) + i) - (b2.getHeight() / 2);
        }
        b2.offsetTopAndBottom(i2);
        PS();
        PQ();
    }

    private void PP() {
        int right;
        int i;
        if (Qc()) {
            Qd();
            return;
        }
        int i2 = this.mSpacing;
        int paddingLeft = getPaddingLeft();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.mFirstPosition - 1;
            right = childAt.getLeft() - i2;
        } else {
            right = (getRight() - getLeft()) - getPaddingRight();
            this.bgn = true;
            i = 0;
        }
        while (right > paddingLeft && i >= 0) {
            View a2 = a(i, i - this.mSelectedPosition, right, false);
            this.mFirstPosition = i;
            right = a2.getLeft() - i2;
            i--;
        }
    }

    private void PQ() {
        int bottom;
        int i;
        if (Qc()) {
            Qe();
            return;
        }
        int i2 = this.mSpacing;
        int paddingTop = getPaddingTop();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.mFirstPosition - 1;
            bottom = childAt.getTop() - i2;
        } else {
            bottom = (getBottom() - getTop()) - getPaddingBottom();
            this.bgn = true;
            i = 0;
        }
        while (bottom > paddingTop && i >= 0) {
            View b2 = b(i, i - this.mSelectedPosition, bottom, false);
            this.mFirstPosition = i;
            bottom = b2.getTop() - i2;
            i--;
        }
    }

    private void PR() {
        int i;
        int paddingLeft;
        if (Qc()) {
            Qf();
            return;
        }
        int i2 = this.mSpacing;
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
            this.bgn = true;
        }
        while (paddingLeft < right && i < i3) {
            paddingLeft = a(i, i - this.mSelectedPosition, paddingLeft, true).getRight() + i2;
            i++;
        }
    }

    private void PS() {
        int i;
        int paddingTop;
        if (Qc()) {
            Qg();
            return;
        }
        int i2 = this.mSpacing;
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
            this.bgn = true;
        }
        while (paddingTop < bottom && i < i3) {
            paddingTop = b(i, i - this.mSelectedPosition, paddingTop, true).getBottom() + i2;
            i++;
        }
    }

    private View a(int i, int i2, int i3, boolean z) {
        View eb;
        if (!this.mDataChanged && (eb = this.bfU.eb(i)) != null) {
            int left = eb.getLeft();
            this.bgh = Math.max(this.bgh, eb.getMeasuredWidth() + left);
            this.bgg = Math.min(this.bgg, left);
            a(eb, i2, i3, z);
            return eb;
        }
        View view = this.mAdapter.getView(i, null, this);
        a(view, i2, i3, z);
        return view;
    }

    private View b(int i, int i2, int i3, boolean z) {
        View eb;
        if (!this.mDataChanged && (eb = this.bfU.eb(i)) != null) {
            int top = eb.getTop();
            this.bgh = Math.max(this.bgh, eb.getMeasuredHeight() + top);
            this.bgg = Math.min(this.bgg, top);
            b(eb, i2, i3, z);
            return eb;
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
        view.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.bfS.left + this.bfS.right, bVar2.width), ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.bfS.top + this.bfS.bottom, bVar2.height));
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
        view.measure(ViewGroup.getChildMeasureSpec(this.mWidthMeasureSpec, this.bfS.left + this.bfS.right, bVar2.width), ViewGroup.getChildMeasureSpec(this.mHeightMeasureSpec, this.bfS.top + this.bfS.bottom, bVar2.height));
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
                return ((((measuredHeight - this.bfS.bottom) - this.bfS.top) - measuredHeight2) / 2) + this.bfS.top;
            case 48:
                return this.bfS.top;
            case 80:
                return (measuredHeight - this.bfS.bottom) - measuredHeight2;
            default:
                return 0;
        }
    }

    private int c(View view, boolean z) {
        int measuredWidth = z ? getMeasuredWidth() : getWidth();
        int measuredWidth2 = z ? view.getMeasuredWidth() : view.getWidth();
        switch (this.mGravity) {
            case 1:
                return ((((measuredWidth - this.bfS.right) - this.bfS.left) - measuredWidth2) / 2) + this.bfS.left;
            case 2:
            case 4:
            default:
                return 0;
            case 3:
                return this.bfS.left;
            case 5:
                return (measuredWidth - this.bfS.right) - measuredWidth2;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = this.mGestureDetector.onTouchEvent(motionEvent);
        int action = motionEvent.getAction();
        if (action == 1) {
            PT();
        } else if (action == 3) {
            onCancel();
        }
        return onTouchEvent;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        if (this.bgi >= 0) {
            if (Qc()) {
                this.bgi %= getCount();
            }
            if (PY()) {
                eg(this.bgi - this.mFirstPosition);
            }
            eh(this.bgi);
            if (this.bgq || this.bgi == this.mSelectedPosition) {
                performItemClick(this.bgj, this.bgi, this.mAdapter.getItemId(this.bgi));
            }
            return true;
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!Qb()) {
            if (!this.bgp) {
                removeCallbacks(this.bgm);
                if (!this.bgr) {
                    this.bgr = true;
                }
            }
            if (PZ()) {
                this.bgk.ei((int) (-(getVelocityRatio() * f2)));
            } else {
                this.bgk.ei((int) (-(getVelocityRatio() * f)));
            }
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (!Qb()) {
            this.bgy = true;
            getParent().requestDisallowInterceptTouchEvent(true);
            if (!this.bgp) {
                if (this.bgv) {
                    if (!this.bgr) {
                        this.bgr = true;
                    }
                    postDelayed(this.bgm, 250L);
                }
            } else if (this.bgr) {
                this.bgr = false;
            }
            if (PZ()) {
                ee(((int) f2) * (-1));
            } else {
                int i = ((int) f) * (-1);
                if (ci(i < 0)) {
                    ed(i);
                }
            }
            this.bgv = false;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.bgk.cl(false);
        this.bgi = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        if (this.bgi >= 0) {
            this.bgj = getChildAt(this.bgi - this.mFirstPosition);
            this.bgj.setPressed(true);
        }
        this.bgv = true;
        return true;
    }

    protected void PT() {
        if (this.bgk.mScroller.isFinished()) {
            PJ();
        }
        PU();
    }

    void onCancel() {
        PT();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        if (this.bgi >= 0) {
            performHapticFeedback(0);
            c(this.bgj, this.bgi, getItemIdAtPosition(this.bgi));
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    private void ak(View view) {
        if (view != null) {
            view.setPressed(true);
        }
        setPressed(true);
    }

    protected void PU() {
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
        if (this.bgo != null) {
            this.bgo.setPressed(z);
        }
    }

    @Override // android.view.View
    protected ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.bgu;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean showContextMenuForChild(View view) {
        int positionForView = getPositionForView(view);
        if (positionForView < 0) {
            return false;
        }
        return c(view, positionForView, this.mAdapter.getItemId(positionForView));
    }

    @Override // android.view.View
    public boolean showContextMenu() {
        if (!isPressed() || this.mSelectedPosition < 0) {
            return false;
        }
        return c(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mSelectedRowId);
    }

    private boolean c(View view, int i, long j) {
        boolean d = this.bfZ != null ? this.bfZ.d(this, this.bgj, this.bgi, j) : false;
        if (!d) {
            this.bgu = new BdAdapterView.a(view, i, j);
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
                if (PV()) {
                    playSoundEffect(1);
                    return true;
                }
                return true;
            case 22:
                if (PW()) {
                    playSoundEffect(3);
                    return true;
                }
                return true;
            case 23:
            case 66:
                this.bgt = true;
                break;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        switch (i) {
            case 23:
            case 66:
                if (this.bgt && this.mItemCount > 0) {
                    ak(this.bgo);
                    postDelayed(new Runnable() { // from class: com.baidu.swan.apps.res.ui.wheelview.BdGallery.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BdGallery.this.PU();
                        }
                    }, ViewConfiguration.getPressedStateDuration());
                    performItemClick(getChildAt(this.mSelectedPosition - this.mFirstPosition), this.mSelectedPosition, this.mAdapter.getItemId(this.mSelectedPosition));
                }
                this.bgt = false;
                return true;
            default:
                return super.onKeyUp(i, keyEvent);
        }
    }

    boolean PV() {
        return this.mItemCount > 0 && this.mSelectedPosition > 0;
    }

    boolean PW() {
        return this.mItemCount > 0 && this.mSelectedPosition < this.mItemCount + (-1);
    }

    private boolean eg(int i) {
        View childAt = getChildAt(i);
        if (childAt != null) {
            this.bgk.ej(getCenterOfGallery() - aj(childAt));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.res.ui.wheelview.BdAdapterView
    public void setSelectedPositionInt(int i) {
        super.setSelectedPositionInt(i);
        PX();
    }

    private void PX() {
        View view = this.bgo;
        hb(" updateSelectedItemMetadata   mSelectedPosition =  " + this.mSelectedPosition + "   mFirstPosition = " + this.mFirstPosition);
        int i = this.mSelectedPosition - this.mFirstPosition;
        if (Qc() && this.mFirstPosition > this.mSelectedPosition) {
            i = (this.mItemCount - this.mFirstPosition) + this.mSelectedPosition;
        }
        View childAt = getChildAt(i);
        this.bgo = childAt;
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
        if (z && this.bgo != null) {
            this.bgo.requestFocus(i);
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

        private void startCommon() {
            BdGallery.this.removeCallbacks(this);
        }

        public void ei(int i) {
            if (i != 0) {
                startCommon();
                if (BdGallery.this.PZ()) {
                    int i2 = i < 0 ? Integer.MAX_VALUE : 0;
                    this.mLastFlingY = i2;
                    this.mScroller.fling(0, i2, 0, i, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                    BdGallery.this.post(this);
                    return;
                }
                int i3 = i < 0 ? Integer.MAX_VALUE : 0;
                this.mLastFlingX = i3;
                this.mScroller.fling(i3, 0, i, 0, 0, Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
                BdGallery.this.post(this);
            }
        }

        public void ej(int i) {
            if (i != 0) {
                if (BdGallery.this.PZ()) {
                    startCommon();
                    BdGallery.this.bgy = true;
                    this.mLastFlingY = 0;
                    this.mScroller.startScroll(0, 0, 0, -i, BdGallery.this.bge);
                    BdGallery.this.post(this);
                    return;
                }
                startCommon();
                BdGallery.this.bgy = true;
                this.mLastFlingX = 0;
                this.mScroller.startScroll(0, 0, -i, 0, BdGallery.this.bge);
                BdGallery.this.post(this);
            }
        }

        public void cl(boolean z) {
            BdGallery.this.removeCallbacks(this);
            cm(z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void cm(boolean z) {
            BdGallery.this.bgy = false;
            this.mScroller.forceFinished(true);
            if (z) {
                BdGallery.this.PJ();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            int max;
            if (BdGallery.this.PZ()) {
                Qh();
            } else if (BdGallery.this.mItemCount != 0) {
                BdGallery.this.bgn = false;
                Scroller scroller = this.mScroller;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currX = scroller.getCurrX();
                int i = this.mLastFlingX - currX;
                if (i > 0) {
                    BdGallery.this.bgi = BdGallery.this.mFirstPosition;
                    max = Math.min(((BdGallery.this.getWidth() - BdGallery.this.getPaddingLeft()) - BdGallery.this.getPaddingRight()) - 1, i);
                } else {
                    BdGallery.this.bgi = (BdGallery.this.getChildCount() - 1) + BdGallery.this.mFirstPosition;
                    max = Math.max(-(((BdGallery.this.getWidth() - BdGallery.this.getPaddingRight()) - BdGallery.this.getPaddingLeft()) - 1), i);
                }
                boolean z = max <= 0;
                if (max != 0 && !BdGallery.this.ci(z)) {
                    BdGallery.this.bgn = true;
                } else {
                    BdGallery.this.ed(max);
                }
                if (computeScrollOffset && !BdGallery.this.bgn) {
                    this.mLastFlingX = currX;
                    BdGallery.this.post(this);
                    return;
                }
                cm(true);
            } else {
                cm(true);
            }
        }

        public void Qh() {
            int max;
            if (BdGallery.this.mItemCount != 0) {
                BdGallery.this.bgn = false;
                Scroller scroller = this.mScroller;
                boolean computeScrollOffset = scroller.computeScrollOffset();
                int currY = scroller.getCurrY();
                int i = this.mLastFlingY - currY;
                if (i > 0) {
                    BdGallery.this.bgi = BdGallery.this.mFirstPosition;
                    max = Math.min(((BdGallery.this.getHeight() - BdGallery.this.getPaddingTop()) - BdGallery.this.getPaddingBottom()) - 1, i);
                } else {
                    BdGallery.this.bgi = (BdGallery.this.getChildCount() - 1) + BdGallery.this.mFirstPosition;
                    max = Math.max(-(((BdGallery.this.getHeight() - BdGallery.this.getPaddingBottom()) - BdGallery.this.getPaddingTop()) - 1), i);
                }
                BdGallery.this.ee(max);
                if (computeScrollOffset && !BdGallery.this.bgn) {
                    this.mLastFlingY = currY;
                    BdGallery.this.post(this);
                    return;
                }
                cm(true);
                return;
            }
            cm(true);
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

    private boolean eh(int i) {
        if (i != this.mSelectedPosition) {
            setSelectedPositionInt(i);
            setNextSelectedPositionInt(i);
            checkSelectionChanged();
            return true;
        }
        return false;
    }

    public void setFirstChildOffset(int i) {
        this.bgz = i;
    }

    public void setFirstPosition(int i) {
        this.mFirstPosition = i;
    }

    public void setSlotInCenter(boolean z) {
        this.bgF = z;
    }

    public boolean PY() {
        return this.bgF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean PZ() {
        return this.mOrientation == 2;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setOnEndFlingListener(c cVar) {
        this.bgG = cVar;
    }

    public void setDisableScroll(boolean z) {
        this.bgw = z;
    }

    public void setDisableScrollAnyway(boolean z) {
        this.bgx = z;
    }

    public void setScrollBarBottomMargin(int i) {
        this.bgA = i;
    }

    @Override // android.view.View
    public void setScrollBarSize(int i) {
        this.bgB = i;
    }

    public int getFirstPosition() {
        return this.mFirstPosition;
    }

    public int getSpacing() {
        return this.mSpacing;
    }

    protected void Qa() {
        if (this.bgG != null && !this.mInLayout && !this.mBlockLayoutRequests) {
            this.bgG.a(this);
        }
    }

    public float getVelocityRatio() {
        return this.bgC;
    }

    public void setVelocityRatio(float f) {
        this.bgC = f;
        if (this.bgC < 0.5f) {
            this.bgC = 0.5f;
        } else if (this.bgC > 1.5f) {
            this.bgC = 1.5f;
        }
    }

    protected boolean Qb() {
        if (this.bgx) {
            return true;
        }
        if (this.bgw && getChildCount() >= this.mItemCount) {
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
        if (1 != motionEvent.getAction() || this.bgi < 0) {
            return false;
        }
        if (this.bgq || this.bgi == this.mSelectedPosition) {
            b(this.bgj, this.bgi, this.mAdapter.getItemId(this.bgi));
            return true;
        }
        return true;
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    public void setScrollCycle(boolean z) {
        this.bgD = z;
    }

    public boolean Qc() {
        return this.bgD && this.bgE;
    }

    public void setMaxMoveOffset(int i) {
        this.bgl = i;
    }

    private long getMaxMoveOffset() {
        return this.bgl;
    }

    protected void hb(String str) {
    }

    private void Qd() {
        int right;
        int i;
        int i2 = this.mSpacing;
        int paddingLeft = getPaddingLeft();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.mFirstPosition - 1;
            right = childAt.getLeft() - i2;
        } else {
            right = (getRight() - getLeft()) - getPaddingRight();
            this.bgn = true;
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

    private void Qe() {
        int bottom;
        int i;
        int i2 = this.mSpacing;
        int paddingTop = getPaddingTop();
        View childAt = getChildAt(0);
        if (childAt != null) {
            i = this.mFirstPosition - 1;
            bottom = childAt.getTop() - i2;
        } else {
            bottom = (getBottom() - getTop()) - getPaddingBottom();
            this.bgn = true;
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

    private void Qf() {
        int i;
        int paddingLeft;
        int i2 = this.mSpacing;
        int right = (getRight() - getLeft()) - getPaddingRight();
        int childCount = getChildCount();
        int i3 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        hb("  fillToGalleryRightCycle mFirstPosition = " + this.mFirstPosition);
        if (childAt != null) {
            i = this.mFirstPosition + childCount;
            paddingLeft = childAt.getRight() + i2;
        } else {
            i = this.mItemCount - 1;
            this.mFirstPosition = i;
            paddingLeft = getPaddingLeft();
            this.bgn = true;
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

    private void Qg() {
        int i;
        int paddingTop;
        int i2 = this.mSpacing;
        int bottom = (getBottom() - getTop()) - getPaddingBottom();
        int childCount = getChildCount();
        int i3 = this.mItemCount;
        View childAt = getChildAt(childCount - 1);
        hb("  fillToGalleryRightCycle mFirstPosition = " + this.mFirstPosition);
        if (childAt != null) {
            i = this.mFirstPosition + childCount;
            paddingTop = childAt.getBottom() + i2;
        } else {
            i = this.mItemCount - 1;
            this.mFirstPosition = i;
            paddingTop = getPaddingTop();
            this.bgn = true;
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
