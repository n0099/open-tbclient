package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
/* loaded from: classes2.dex */
public class StaggeredGridLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider {
    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    private int As;
    private boolean VC;
    private boolean VD;
    private SavedState VE;
    private int VF;
    b[] Vu;
    OrientationHelper Vv;
    OrientationHelper Vw;
    private int Vx;
    private final m Vy;
    private BitSet Vz;
    private int Pb = -1;
    boolean PJ = false;
    boolean PK = false;
    int PN = -1;
    int PO = Integer.MIN_VALUE;
    LazySpanLookup VA = new LazySpanLookup();
    private int VB = 2;
    private final Rect mTmpRect = new Rect();
    private final a VG = new a();
    private boolean VH = false;
    private boolean mSmoothScrollbarEnabled = true;
    private final Runnable VI = new Runnable() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.hU();
        }
    };

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        setAutoMeasureEnabled(this.VB != 0);
        this.Vy = new m();
        hT();
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.As = i2;
        setSpanCount(i);
        setAutoMeasureEnabled(this.VB != 0);
        this.Vy = new m();
        hT();
    }

    private void hT() {
        this.Vv = OrientationHelper.createOrientationHelper(this, this.As);
        this.Vw = OrientationHelper.createOrientationHelper(this, 1 - this.As);
    }

    boolean hU() {
        int ib;
        int ia;
        if (getChildCount() == 0 || this.VB == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.PK) {
            ib = ia();
            ia = ib();
        } else {
            ib = ib();
            ia = ia();
        }
        if (ib == 0 && hV() != null) {
            this.VA.clear();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (this.VH) {
            int i = this.PK ? -1 : 1;
            LazySpanLookup.FullSpanItem c = this.VA.c(ib, ia + 1, i, true);
            if (c == null) {
                this.VH = false;
                this.VA.bQ(ia + 1);
                return false;
            }
            LazySpanLookup.FullSpanItem c2 = this.VA.c(ib, c.mPosition, i * (-1), true);
            if (c2 == null) {
                this.VA.bQ(c.mPosition);
            } else {
                this.VA.bQ(c2.mPosition + 1);
            }
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else {
            return false;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            hU();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        removeCallbacks(this.VI);
        for (int i = 0; i < this.Pb; i++) {
            this.Vu[i].clear();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x005d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    View hV() {
        int i;
        boolean z;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.Pb);
        bitSet.set(0, this.Pb, true);
        char c = (this.As == 1 && isLayoutRTL()) ? (char) 1 : (char) 65535;
        if (this.PK) {
            i = -1;
        } else {
            i = childCount + 1;
            childCount = 0;
        }
        int i2 = childCount < i ? 1 : -1;
        for (int i3 = childCount; i3 != i; i3 += i2) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.VM.mIndex)) {
                if (a(layoutParams.VM)) {
                    return childAt;
                }
                bitSet.clear(layoutParams.VM.mIndex);
            }
            if (!layoutParams.VN && i3 + i2 != i) {
                View childAt2 = getChildAt(i3 + i2);
                if (this.PK) {
                    int decoratedEnd = this.Vv.getDecoratedEnd(childAt);
                    int decoratedEnd2 = this.Vv.getDecoratedEnd(childAt2);
                    if (decoratedEnd < decoratedEnd2) {
                        return childAt;
                    }
                    if (decoratedEnd == decoratedEnd2) {
                        z = true;
                        if (z) {
                            if ((layoutParams.VM.mIndex - ((LayoutParams) childAt2.getLayoutParams()).VM.mIndex < 0) != (c < 0)) {
                                return childAt;
                            }
                        } else {
                            continue;
                        }
                    }
                    z = false;
                    if (z) {
                    }
                } else {
                    int decoratedStart = this.Vv.getDecoratedStart(childAt);
                    int decoratedStart2 = this.Vv.getDecoratedStart(childAt2);
                    if (decoratedStart > decoratedStart2) {
                        return childAt;
                    }
                    if (decoratedStart == decoratedStart2) {
                        z = true;
                        if (z) {
                        }
                    }
                    z = false;
                    if (z) {
                    }
                }
            }
        }
        return null;
    }

    private boolean a(b bVar) {
        if (this.PK) {
            if (bVar.ih() < this.Vv.getEndAfterPadding()) {
                return !bVar.aA(bVar.VX.get(bVar.VX.size() + (-1))).VN;
            }
        } else if (bVar.m5if() > this.Vv.getStartAfterPadding()) {
            return bVar.aA(bVar.VX.get(0)).VN ? false : true;
        }
        return false;
    }

    public void setSpanCount(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.Pb) {
            invalidateSpanAssignments();
            this.Pb = i;
            this.Vz = new BitSet(this.Pb);
            this.Vu = new b[this.Pb];
            for (int i2 = 0; i2 < this.Pb; i2++) {
                this.Vu[i2] = new b(i2);
            }
            requestLayout();
        }
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.As) {
            this.As = i;
            OrientationHelper orientationHelper = this.Vv;
            this.Vv = this.Vw;
            this.Vw = orientationHelper;
            requestLayout();
        }
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.VE != null && this.VE.PJ != z) {
            this.VE.PJ = z;
        }
        this.PJ = z;
        requestLayout();
    }

    public int getGapStrategy() {
        return this.VB;
    }

    public void setGapStrategy(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.VB) {
            if (i != 0 && i != 2) {
                throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
            }
            this.VB = i;
            setAutoMeasureEnabled(this.VB != 0);
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.VE == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public int getSpanCount() {
        return this.Pb;
    }

    public void invalidateSpanAssignments() {
        this.VA.clear();
        requestLayout();
    }

    private void gf() {
        if (this.As == 1 || !isLayoutRTL()) {
            this.PK = this.PJ;
        } else {
            this.PK = this.PJ ? false : true;
        }
    }

    boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean getReverseLayout() {
        return this.PJ;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.As == 1) {
            chooseSize2 = chooseSize(i2, paddingTop + rect.height(), getMinimumHeight());
            chooseSize = chooseSize(i, paddingRight + (this.Vx * this.Pb), getMinimumWidth());
        } else {
            chooseSize = chooseSize(i, paddingRight + rect.width(), getMinimumWidth());
            chooseSize2 = chooseSize(i2, paddingTop + (this.Vx * this.Pb), getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        a(recycler, state, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        boolean z2;
        a aVar = this.VG;
        if ((this.VE != null || this.PN != -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            aVar.reset();
            return;
        }
        boolean z3 = (aVar.PW && this.PN == -1 && this.VE == null) ? false : true;
        if (z3) {
            aVar.reset();
            if (this.VE != null) {
                a(aVar);
            } else {
                gf();
                aVar.PV = this.PK;
            }
            a(state, aVar);
            aVar.PW = true;
        }
        if (this.VE == null && this.PN == -1 && (aVar.PV != this.VC || isLayoutRTL() != this.VD)) {
            this.VA.clear();
            aVar.VK = true;
        }
        if (getChildCount() > 0 && (this.VE == null || this.VE.VT < 1)) {
            if (aVar.VK) {
                for (int i = 0; i < this.Pb; i++) {
                    this.Vu[i].clear();
                    if (aVar.mOffset != Integer.MIN_VALUE) {
                        this.Vu[i].cc(aVar.mOffset);
                    }
                }
            } else if (z3 || this.VG.VL == null) {
                for (int i2 = 0; i2 < this.Pb; i2++) {
                    this.Vu[i2].c(this.PK, aVar.mOffset);
                }
                this.VG.a(this.Vu);
            } else {
                for (int i3 = 0; i3 < this.Pb; i3++) {
                    b bVar = this.Vu[i3];
                    bVar.clear();
                    bVar.cc(this.VG.VL[i3]);
                }
            }
        }
        detachAndScrapAttachedViews(recycler);
        this.Vy.Pm = false;
        this.VH = false;
        bD(this.Vw.getTotalSpace());
        a(aVar.mPosition, state);
        if (aVar.PV) {
            bE(-1);
            a(recycler, this.Vy, state);
            bE(1);
            this.Vy.Po = aVar.mPosition + this.Vy.Pp;
            a(recycler, this.Vy, state);
        } else {
            bE(1);
            a(recycler, this.Vy, state);
            bE(-1);
            this.Vy.Po = aVar.mPosition + this.Vy.Pp;
            a(recycler, this.Vy, state);
        }
        hW();
        if (getChildCount() > 0) {
            if (this.PK) {
                b(recycler, state, true);
                c(recycler, state, false);
            } else {
                c(recycler, state, true);
                b(recycler, state, false);
            }
        }
        if (z && !state.isPreLayout()) {
            if (this.VB != 0 && getChildCount() > 0 && (this.VH || hV() != null)) {
                removeCallbacks(this.VI);
                if (hU()) {
                    z2 = true;
                    if (state.isPreLayout()) {
                        this.VG.reset();
                    }
                    this.VC = aVar.PV;
                    this.VD = isLayoutRTL();
                    if (!z2) {
                        this.VG.reset();
                        a(recycler, state, false);
                        return;
                    }
                    return;
                }
            }
        }
        z2 = false;
        if (state.isPreLayout()) {
        }
        this.VC = aVar.PV;
        this.VD = isLayoutRTL();
        if (!z2) {
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.PN = -1;
        this.PO = Integer.MIN_VALUE;
        this.VE = null;
        this.VG.reset();
    }

    private void hW() {
        float max;
        if (this.Vw.getMode() != 1073741824) {
            float f = 0.0f;
            int childCount = getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = getChildAt(i);
                float decoratedMeasurement = this.Vw.getDecoratedMeasurement(childAt);
                if (decoratedMeasurement < f) {
                    max = f;
                } else {
                    max = Math.max(f, ((LayoutParams) childAt.getLayoutParams()).isFullSpan() ? (1.0f * decoratedMeasurement) / this.Pb : decoratedMeasurement);
                }
                i++;
                f = max;
            }
            int i2 = this.Vx;
            int round = Math.round(this.Pb * f);
            if (this.Vw.getMode() == Integer.MIN_VALUE) {
                round = Math.min(round, this.Vw.getTotalSpace());
            }
            bD(round);
            if (this.Vx != i2) {
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = getChildAt(i3);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (!layoutParams.VN) {
                        if (isLayoutRTL() && this.As == 1) {
                            childAt2.offsetLeftAndRight(((-((this.Pb - 1) - layoutParams.VM.mIndex)) * this.Vx) - ((-((this.Pb - 1) - layoutParams.VM.mIndex)) * i2));
                        } else {
                            int i4 = layoutParams.VM.mIndex * this.Vx;
                            int i5 = layoutParams.VM.mIndex * i2;
                            if (this.As == 1) {
                                childAt2.offsetLeftAndRight(i4 - i5);
                            } else {
                                childAt2.offsetTopAndBottom(i4 - i5);
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(a aVar) {
        if (this.VE.VT > 0) {
            if (this.VE.VT == this.Pb) {
                for (int i = 0; i < this.Pb; i++) {
                    this.Vu[i].clear();
                    int i2 = this.VE.VU[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.VE.Qf) {
                            i2 += this.Vv.getEndAfterPadding();
                        } else {
                            i2 += this.Vv.getStartAfterPadding();
                        }
                    }
                    this.Vu[i].cc(i2);
                }
            } else {
                this.VE.ic();
                this.VE.Qd = this.VE.VS;
            }
        }
        this.VD = this.VE.VD;
        setReverseLayout(this.VE.PJ);
        gf();
        if (this.VE.Qd != -1) {
            this.PN = this.VE.Qd;
            aVar.PV = this.VE.Qf;
        } else {
            aVar.PV = this.PK;
        }
        if (this.VE.VV > 1) {
            this.VA.mData = this.VE.VW;
            this.VA.VO = this.VE.VO;
        }
    }

    void a(RecyclerView.State state, a aVar) {
        if (!c(state, aVar) && !b(state, aVar)) {
            aVar.gm();
            aVar.mPosition = 0;
        }
    }

    private boolean b(RecyclerView.State state, a aVar) {
        int bN;
        if (this.VC) {
            bN = bO(state.getItemCount());
        } else {
            bN = bN(state.getItemCount());
        }
        aVar.mPosition = bN;
        aVar.mOffset = Integer.MIN_VALUE;
        return true;
    }

    boolean c(RecyclerView.State state, a aVar) {
        int startAfterPadding;
        if (state.isPreLayout() || this.PN == -1) {
            return false;
        }
        if (this.PN < 0 || this.PN >= state.getItemCount()) {
            this.PN = -1;
            this.PO = Integer.MIN_VALUE;
            return false;
        } else if (this.VE == null || this.VE.Qd == -1 || this.VE.VT < 1) {
            View findViewByPosition = findViewByPosition(this.PN);
            if (findViewByPosition != null) {
                aVar.mPosition = this.PK ? ia() : ib();
                if (this.PO != Integer.MIN_VALUE) {
                    if (aVar.PV) {
                        aVar.mOffset = (this.Vv.getEndAfterPadding() - this.PO) - this.Vv.getDecoratedEnd(findViewByPosition);
                        return true;
                    }
                    aVar.mOffset = (this.Vv.getStartAfterPadding() + this.PO) - this.Vv.getDecoratedStart(findViewByPosition);
                    return true;
                } else if (this.Vv.getDecoratedMeasurement(findViewByPosition) > this.Vv.getTotalSpace()) {
                    if (aVar.PV) {
                        startAfterPadding = this.Vv.getEndAfterPadding();
                    } else {
                        startAfterPadding = this.Vv.getStartAfterPadding();
                    }
                    aVar.mOffset = startAfterPadding;
                    return true;
                } else {
                    int decoratedStart = this.Vv.getDecoratedStart(findViewByPosition) - this.Vv.getStartAfterPadding();
                    if (decoratedStart < 0) {
                        aVar.mOffset = -decoratedStart;
                        return true;
                    }
                    int endAfterPadding = this.Vv.getEndAfterPadding() - this.Vv.getDecoratedEnd(findViewByPosition);
                    if (endAfterPadding < 0) {
                        aVar.mOffset = endAfterPadding;
                        return true;
                    }
                    aVar.mOffset = Integer.MIN_VALUE;
                    return true;
                }
            }
            aVar.mPosition = this.PN;
            if (this.PO == Integer.MIN_VALUE) {
                aVar.PV = bM(aVar.mPosition) == 1;
                aVar.gm();
            } else {
                aVar.bP(this.PO);
            }
            aVar.VK = true;
            return true;
        } else {
            aVar.mOffset = Integer.MIN_VALUE;
            aVar.mPosition = this.PN;
            return true;
        }
    }

    void bD(int i) {
        this.Vx = i / this.Pb;
        this.VF = View.MeasureSpec.makeMeasureSpec(i, this.Vw.getMode());
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.VE == null;
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.Pb];
        } else if (iArr.length < this.Pb) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.Pb + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.Pb; i++) {
            iArr[i] = this.Vu[i].findFirstVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.Pb];
        } else if (iArr.length < this.Pb) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.Pb + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.Pb; i++) {
            iArr[i] = this.Vu[i].findFirstCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.Pb];
        } else if (iArr.length < this.Pb) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.Pb + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.Pb; i++) {
            iArr[i] = this.Vu[i].findLastVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.Pb];
        } else if (iArr.length < this.Pb) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.Pb + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.Pb; i++) {
            iArr[i] = this.Vu[i].findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return b(state);
    }

    private int b(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return q.a(state, this.Vv, O(!this.mSmoothScrollbarEnabled), P(this.mSmoothScrollbarEnabled ? false : true), this, this.mSmoothScrollbarEnabled, this.PK);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return b(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return c(state);
    }

    private int c(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return q.a(state, this.Vv, O(!this.mSmoothScrollbarEnabled), P(this.mSmoothScrollbarEnabled ? false : true), this, this.mSmoothScrollbarEnabled);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return c(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return d(state);
    }

    private int d(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        return q.b(state, this.Vv, O(!this.mSmoothScrollbarEnabled), P(this.mSmoothScrollbarEnabled ? false : true), this, this.mSmoothScrollbarEnabled);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return d(state);
    }

    private void a(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.VN) {
            if (this.As == 1) {
                a(view, this.VF, getChildMeasureSpec(getHeight(), getHeightMode(), 0, layoutParams.height, true), z);
            } else {
                a(view, getChildMeasureSpec(getWidth(), getWidthMode(), 0, layoutParams.width, true), this.VF, z);
            }
        } else if (this.As == 1) {
            a(view, getChildMeasureSpec(this.Vx, getWidthMode(), 0, layoutParams.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), 0, layoutParams.height, true), z);
        } else {
            a(view, getChildMeasureSpec(getWidth(), getWidthMode(), 0, layoutParams.width, true), getChildMeasureSpec(this.Vx, getHeightMode(), 0, layoutParams.height, false), z);
        }
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean b2;
        calculateItemDecorationsForChild(view, this.mTmpRect);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int j = j(i, layoutParams.leftMargin + this.mTmpRect.left, layoutParams.rightMargin + this.mTmpRect.right);
        int j2 = j(i2, layoutParams.topMargin + this.mTmpRect.top, layoutParams.bottomMargin + this.mTmpRect.bottom);
        if (z) {
            b2 = a(view, j, j2, layoutParams);
        } else {
            b2 = b(view, j, j2, layoutParams);
        }
        if (b2) {
            view.measure(j, j2);
        }
    }

    private int j(int i, int i2, int i3) {
        if (i2 != 0 || i3 != 0) {
            int mode = View.MeasureSpec.getMode(i);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                return View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode);
            }
            return i;
        }
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.VE = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        int ca;
        if (this.VE != null) {
            return new SavedState(this.VE);
        }
        SavedState savedState = new SavedState();
        savedState.PJ = this.PJ;
        savedState.Qf = this.VC;
        savedState.VD = this.VD;
        if (this.VA != null && this.VA.mData != null) {
            savedState.VW = this.VA.mData;
            savedState.VV = savedState.VW.length;
            savedState.VO = this.VA.VO;
        } else {
            savedState.VV = 0;
        }
        if (getChildCount() > 0) {
            savedState.Qd = this.VC ? ia() : ib();
            savedState.VS = hX();
            savedState.VT = this.Pb;
            savedState.VU = new int[this.Pb];
            for (int i = 0; i < this.Pb; i++) {
                if (this.VC) {
                    ca = this.Vu[i].cb(Integer.MIN_VALUE);
                    if (ca != Integer.MIN_VALUE) {
                        ca -= this.Vv.getEndAfterPadding();
                    }
                } else {
                    ca = this.Vu[i].ca(Integer.MIN_VALUE);
                    if (ca != Integer.MIN_VALUE) {
                        ca -= this.Vv.getStartAfterPadding();
                    }
                }
                savedState.VU[i] = ca;
            }
        } else {
            savedState.Qd = -1;
            savedState.VS = -1;
            savedState.VT = 0;
        }
        return savedState;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.a(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.As == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.VN ? this.Pb : 1, -1, -1, layoutParams2.VN, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, layoutParams2.getSpanIndex(), layoutParams2.VN ? this.Pb : 1, layoutParams2.VN, false));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            View O = O(false);
            View P = P(false);
            if (O != null && P != null) {
                int position = getPosition(O);
                int position2 = getPosition(P);
                if (position < position2) {
                    asRecord.setFromIndex(position);
                    asRecord.setToIndex(position2);
                    return;
                }
                asRecord.setFromIndex(position2);
                asRecord.setToIndex(position);
            }
        }
    }

    int hX() {
        View P = this.PK ? P(true) : O(true);
        if (P == null) {
            return -1;
        }
        return getPosition(P);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.As == 0 ? this.Pb : super.getRowCountForAccessibility(recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.As == 1 ? this.Pb : super.getColumnCountForAccessibility(recycler, state);
    }

    View O(boolean z) {
        int startAfterPadding = this.Vv.getStartAfterPadding();
        int endAfterPadding = this.Vv.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int decoratedStart = this.Vv.getDecoratedStart(childAt);
            if (this.Vv.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart < startAfterPadding && z) {
                    if (view == null) {
                        view = childAt;
                    }
                } else {
                    return childAt;
                }
            }
        }
        return view;
    }

    View P(boolean z) {
        int startAfterPadding = this.Vv.getStartAfterPadding();
        int endAfterPadding = this.Vv.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.Vv.getDecoratedStart(childAt);
            int decoratedEnd = this.Vv.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd > endAfterPadding && z) {
                    if (view == null) {
                        view = childAt;
                    }
                } else {
                    return childAt;
                }
            }
        }
        return view;
    }

    private void b(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int bJ = bJ(Integer.MIN_VALUE);
        if (bJ != Integer.MIN_VALUE && (endAfterPadding = this.Vv.getEndAfterPadding() - bJ) > 0) {
            int i = endAfterPadding - (-a(-endAfterPadding, recycler, state));
            if (z && i > 0) {
                this.Vv.offsetChildren(i);
            }
        }
    }

    private void c(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int bI = bI(Integer.MAX_VALUE);
        if (bI != Integer.MAX_VALUE && (startAfterPadding = bI - this.Vv.getStartAfterPadding()) > 0) {
            int a2 = startAfterPadding - a(startAfterPadding, recycler, state);
            if (z && a2 > 0) {
                this.Vv.offsetChildren(-a2);
            }
        }
    }

    private void a(int i, RecyclerView.State state) {
        int i2;
        int i3;
        int targetScrollPosition;
        boolean z = false;
        this.Vy.Pn = 0;
        this.Vy.Po = i;
        if (!isSmoothScrolling() || (targetScrollPosition = state.getTargetScrollPosition()) == -1) {
            i2 = 0;
            i3 = 0;
        } else {
            if (this.PK == (targetScrollPosition < i)) {
                i2 = this.Vv.getTotalSpace();
                i3 = 0;
            } else {
                i3 = this.Vv.getTotalSpace();
                i2 = 0;
            }
        }
        if (getClipToPadding()) {
            this.Vy.Pr = this.Vv.getStartAfterPadding() - i3;
            this.Vy.Ps = i2 + this.Vv.getEndAfterPadding();
        } else {
            this.Vy.Ps = i2 + this.Vv.getEnd();
            this.Vy.Pr = -i3;
        }
        this.Vy.Pt = false;
        this.Vy.Pm = true;
        m mVar = this.Vy;
        if (this.Vv.getMode() == 0 && this.Vv.getEnd() == 0) {
            z = true;
        }
        mVar.Pu = z;
    }

    private void bE(int i) {
        this.Vy.Pq = i;
        this.Vy.Pp = this.PK != (i == -1) ? -1 : 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.Pb; i2++) {
            this.Vu[i2].cd(i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.Pb; i2++) {
            this.Vu[i2].cd(i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        k(i, i2, 2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        k(i, i2, 1);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.VA.clear();
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        k(i, i2, 8);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        k(i, i2, 4);
    }

    private void k(int i, int i2, int i3) {
        int i4;
        int i5;
        int ia = this.PK ? ia() : ib();
        if (i3 == 8) {
            if (i < i2) {
                i4 = i2 + 1;
                i5 = i;
            } else {
                i4 = i + 1;
                i5 = i2;
            }
        } else {
            i4 = i + i2;
            i5 = i;
        }
        this.VA.bR(i5);
        switch (i3) {
            case 1:
                this.VA.ah(i, i2);
                break;
            case 2:
                this.VA.af(i, i2);
                break;
            case 8:
                this.VA.af(i, 1);
                this.VA.ah(i2, 1);
                break;
        }
        if (i4 > ia) {
            if (i5 <= (this.PK ? ib() : ia())) {
                requestLayout();
            }
        }
    }

    private int a(RecyclerView.Recycler recycler, m mVar, RecyclerView.State state) {
        int i;
        int startAfterPadding;
        int bJ;
        b bVar;
        int decoratedMeasurement;
        int i2;
        int decoratedMeasurement2;
        int i3;
        boolean z;
        this.Vz.set(0, this.Pb, true);
        if (this.Vy.Pu) {
            if (mVar.Pq == 1) {
                i = Integer.MAX_VALUE;
            } else {
                i = Integer.MIN_VALUE;
            }
        } else if (mVar.Pq == 1) {
            i = mVar.Ps + mVar.Pn;
        } else {
            i = mVar.Pr - mVar.Pn;
        }
        ae(mVar.Pq, i);
        if (this.PK) {
            startAfterPadding = this.Vv.getEndAfterPadding();
        } else {
            startAfterPadding = this.Vv.getStartAfterPadding();
        }
        boolean z2 = false;
        while (mVar.a(state) && (this.Vy.Pu || !this.Vz.isEmpty())) {
            View a2 = mVar.a(recycler);
            LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int bS = this.VA.bS(viewLayoutPosition);
            boolean z3 = bS == -1;
            if (z3) {
                b a3 = layoutParams.VN ? this.Vu[0] : a(mVar);
                this.VA.a(viewLayoutPosition, a3);
                bVar = a3;
            } else {
                bVar = this.Vu[bS];
            }
            layoutParams.VM = bVar;
            if (mVar.Pq == 1) {
                addView(a2);
            } else {
                addView(a2, 0);
            }
            a(a2, layoutParams, false);
            if (mVar.Pq == 1) {
                int bJ2 = layoutParams.VN ? bJ(startAfterPadding) : bVar.cb(startAfterPadding);
                i2 = bJ2 + this.Vv.getDecoratedMeasurement(a2);
                if (z3 && layoutParams.VN) {
                    LazySpanLookup.FullSpanItem bF = bF(bJ2);
                    bF.VP = -1;
                    bF.mPosition = viewLayoutPosition;
                    this.VA.a(bF);
                    decoratedMeasurement = bJ2;
                } else {
                    decoratedMeasurement = bJ2;
                }
            } else {
                int bI = layoutParams.VN ? bI(startAfterPadding) : bVar.ca(startAfterPadding);
                decoratedMeasurement = bI - this.Vv.getDecoratedMeasurement(a2);
                if (z3 && layoutParams.VN) {
                    LazySpanLookup.FullSpanItem bG = bG(bI);
                    bG.VP = 1;
                    bG.mPosition = viewLayoutPosition;
                    this.VA.a(bG);
                }
                i2 = bI;
            }
            if (layoutParams.VN && mVar.Pp == -1) {
                if (z3) {
                    this.VH = true;
                } else {
                    if (mVar.Pq == 1) {
                        z = !hY();
                    } else {
                        z = !hZ();
                    }
                    if (z) {
                        LazySpanLookup.FullSpanItem bW = this.VA.bW(viewLayoutPosition);
                        if (bW != null) {
                            bW.VR = true;
                        }
                        this.VH = true;
                    }
                }
            }
            a(a2, layoutParams, mVar);
            if (isLayoutRTL() && this.As == 1) {
                int endAfterPadding = layoutParams.VN ? this.Vw.getEndAfterPadding() : this.Vw.getEndAfterPadding() - (((this.Pb - 1) - bVar.mIndex) * this.Vx);
                i3 = endAfterPadding - this.Vw.getDecoratedMeasurement(a2);
                decoratedMeasurement2 = endAfterPadding;
            } else {
                int startAfterPadding2 = layoutParams.VN ? this.Vw.getStartAfterPadding() : (bVar.mIndex * this.Vx) + this.Vw.getStartAfterPadding();
                decoratedMeasurement2 = startAfterPadding2 + this.Vw.getDecoratedMeasurement(a2);
                i3 = startAfterPadding2;
            }
            if (this.As == 1) {
                layoutDecoratedWithMargins(a2, i3, decoratedMeasurement, decoratedMeasurement2, i2);
            } else {
                layoutDecoratedWithMargins(a2, decoratedMeasurement, i3, i2, decoratedMeasurement2);
            }
            if (layoutParams.VN) {
                ae(this.Vy.Pq, i);
            } else {
                a(bVar, this.Vy.Pq, i);
            }
            a(recycler, this.Vy);
            if (this.Vy.Pt && a2.isFocusable()) {
                if (layoutParams.VN) {
                    this.Vz.clear();
                } else {
                    this.Vz.set(bVar.mIndex, false);
                }
            }
            z2 = true;
        }
        if (!z2) {
            a(recycler, this.Vy);
        }
        if (this.Vy.Pq == -1) {
            bJ = this.Vv.getStartAfterPadding() - bI(this.Vv.getStartAfterPadding());
        } else {
            bJ = bJ(this.Vv.getEndAfterPadding()) - this.Vv.getEndAfterPadding();
        }
        if (bJ > 0) {
            return Math.min(mVar.Pn, bJ);
        }
        return 0;
    }

    private LazySpanLookup.FullSpanItem bF(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.VQ = new int[this.Pb];
        for (int i2 = 0; i2 < this.Pb; i2++) {
            fullSpanItem.VQ[i2] = i - this.Vu[i2].cb(i);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem bG(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.VQ = new int[this.Pb];
        for (int i2 = 0; i2 < this.Pb; i2++) {
            fullSpanItem.VQ[i2] = this.Vu[i2].ca(i) - i;
        }
        return fullSpanItem;
    }

    private void a(View view, LayoutParams layoutParams, m mVar) {
        if (mVar.Pq == 1) {
            if (layoutParams.VN) {
                aw(view);
            } else {
                layoutParams.VM.az(view);
            }
        } else if (layoutParams.VN) {
            ax(view);
        } else {
            layoutParams.VM.ay(view);
        }
    }

    private void a(RecyclerView.Recycler recycler, m mVar) {
        int min;
        int min2;
        if (mVar.Pm && !mVar.Pu) {
            if (mVar.Pn == 0) {
                if (mVar.Pq == -1) {
                    d(recycler, mVar.Ps);
                } else {
                    c(recycler, mVar.Pr);
                }
            } else if (mVar.Pq == -1) {
                int bH = mVar.Pr - bH(mVar.Pr);
                if (bH < 0) {
                    min2 = mVar.Ps;
                } else {
                    min2 = mVar.Ps - Math.min(bH, mVar.Pn);
                }
                d(recycler, min2);
            } else {
                int bK = bK(mVar.Ps) - mVar.Ps;
                if (bK < 0) {
                    min = mVar.Pr;
                } else {
                    min = Math.min(bK, mVar.Pn) + mVar.Pr;
                }
                c(recycler, min);
            }
        }
    }

    private void aw(View view) {
        for (int i = this.Pb - 1; i >= 0; i--) {
            this.Vu[i].az(view);
        }
    }

    private void ax(View view) {
        for (int i = this.Pb - 1; i >= 0; i--) {
            this.Vu[i].ay(view);
        }
    }

    private void ae(int i, int i2) {
        for (int i3 = 0; i3 < this.Pb; i3++) {
            if (!this.Vu[i3].VX.isEmpty()) {
                a(this.Vu[i3], i, i2);
            }
        }
    }

    private void a(b bVar, int i, int i2) {
        int il = bVar.il();
        if (i == -1) {
            if (il + bVar.m5if() <= i2) {
                this.Vz.set(bVar.mIndex, false);
            }
        } else if (bVar.ih() - il >= i2) {
            this.Vz.set(bVar.mIndex, false);
        }
    }

    private int bH(int i) {
        int ca = this.Vu[0].ca(i);
        for (int i2 = 1; i2 < this.Pb; i2++) {
            int ca2 = this.Vu[i2].ca(i);
            if (ca2 > ca) {
                ca = ca2;
            }
        }
        return ca;
    }

    private int bI(int i) {
        int ca = this.Vu[0].ca(i);
        for (int i2 = 1; i2 < this.Pb; i2++) {
            int ca2 = this.Vu[i2].ca(i);
            if (ca2 < ca) {
                ca = ca2;
            }
        }
        return ca;
    }

    boolean hY() {
        int cb = this.Vu[0].cb(Integer.MIN_VALUE);
        for (int i = 1; i < this.Pb; i++) {
            if (this.Vu[i].cb(Integer.MIN_VALUE) != cb) {
                return false;
            }
        }
        return true;
    }

    boolean hZ() {
        int ca = this.Vu[0].ca(Integer.MIN_VALUE);
        for (int i = 1; i < this.Pb; i++) {
            if (this.Vu[i].ca(Integer.MIN_VALUE) != ca) {
                return false;
            }
        }
        return true;
    }

    private int bJ(int i) {
        int cb = this.Vu[0].cb(i);
        for (int i2 = 1; i2 < this.Pb; i2++) {
            int cb2 = this.Vu[i2].cb(i);
            if (cb2 > cb) {
                cb = cb2;
            }
        }
        return cb;
    }

    private int bK(int i) {
        int cb = this.Vu[0].cb(i);
        for (int i2 = 1; i2 < this.Pb; i2++) {
            int cb2 = this.Vu[i2].cb(i);
            if (cb2 < cb) {
                cb = cb2;
            }
        }
        return cb;
    }

    private void c(RecyclerView.Recycler recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.Vv.getDecoratedEnd(childAt) <= i && this.Vv.getTransformedEndWithDecoration(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.VN) {
                    for (int i2 = 0; i2 < this.Pb; i2++) {
                        if (this.Vu[i2].VX.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.Pb; i3++) {
                        this.Vu[i3].ik();
                    }
                } else if (layoutParams.VM.VX.size() != 1) {
                    layoutParams.VM.ik();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    private void d(RecyclerView.Recycler recycler, int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.Vv.getDecoratedStart(childAt) >= i && this.Vv.getTransformedStartWithDecoration(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.VN) {
                    for (int i2 = 0; i2 < this.Pb; i2++) {
                        if (this.Vu[i2].VX.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.Pb; i3++) {
                        this.Vu[i3].ij();
                    }
                } else if (layoutParams.VM.VX.size() != 1) {
                    layoutParams.VM.ij();
                } else {
                    return;
                }
                removeAndRecycleView(childAt, recycler);
            } else {
                return;
            }
        }
    }

    private boolean bL(int i) {
        if (this.As == 0) {
            return (i == -1) != this.PK;
        }
        return ((i == -1) == this.PK) == isLayoutRTL();
    }

    private b a(m mVar) {
        int i;
        int i2;
        b bVar;
        b bVar2;
        b bVar3 = null;
        int i3 = -1;
        if (bL(mVar.Pq)) {
            i = this.Pb - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.Pb;
            i3 = 1;
        }
        if (mVar.Pq == 1) {
            int startAfterPadding = this.Vv.getStartAfterPadding();
            int i4 = i;
            int i5 = Integer.MAX_VALUE;
            while (i4 != i2) {
                b bVar4 = this.Vu[i4];
                int cb = bVar4.cb(startAfterPadding);
                if (cb < i5) {
                    bVar2 = bVar4;
                } else {
                    cb = i5;
                    bVar2 = bVar3;
                }
                i4 += i3;
                bVar3 = bVar2;
                i5 = cb;
            }
        } else {
            int endAfterPadding = this.Vv.getEndAfterPadding();
            int i6 = i;
            int i7 = Integer.MIN_VALUE;
            while (i6 != i2) {
                b bVar5 = this.Vu[i6];
                int ca = bVar5.ca(endAfterPadding);
                if (ca > i7) {
                    bVar = bVar5;
                } else {
                    ca = i7;
                    bVar = bVar3;
                }
                i6 += i3;
                bVar3 = bVar;
                i7 = ca;
            }
        }
        return bVar3;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.As == 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.As == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return a(i, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        return a(i, recycler, state);
    }

    private int bM(int i) {
        if (getChildCount() == 0) {
            return this.PK ? 1 : -1;
        }
        return (i < ib()) == this.PK ? 1 : -1;
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        int bM = bM(i);
        PointF pointF = new PointF();
        if (bM == 0) {
            return null;
        }
        if (this.As == 0) {
            pointF.x = bM;
            pointF.y = 0.0f;
            return pointF;
        }
        pointF.x = 0.0f;
        pointF.y = bM;
        return pointF;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        if (this.VE != null && this.VE.Qd != i) {
            this.VE.id();
        }
        this.PN = i;
        this.PO = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.VE != null) {
            this.VE.id();
        }
        this.PN = i;
        this.PO = i2;
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    int ge() {
        return this.Pb;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    int a(int i, int i2, RecyclerView.State state, int[] iArr) {
        int i3 = 0;
        if (this.As != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            b(i, state);
            int i4 = this.Pb;
            while (i3 < this.Pb && this.Vy.a(state) && i4 > 0) {
                iArr[i3] = this.Vy.Po;
                i4--;
                this.Vy.Po += this.Vy.Pp;
                i3++;
            }
        }
        return i3;
    }

    void b(int i, RecyclerView.State state) {
        int i2;
        int ib;
        if (i > 0) {
            ib = ia();
            i2 = 1;
        } else {
            i2 = -1;
            ib = ib();
        }
        this.Vy.Pm = true;
        a(ib, state);
        bE(i2);
        this.Vy.Po = this.Vy.Pp + ib;
        this.Vy.Pn = Math.abs(i);
    }

    int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        b(i, state);
        int a2 = a(recycler, this.Vy, state);
        if (this.Vy.Pn >= a2) {
            i = i < 0 ? -a2 : a2;
        }
        this.Vv.offsetChildren(-i);
        this.VC = this.PK;
        this.Vy.Pn = 0;
        a(recycler, this.Vy);
        return i;
    }

    private int ia() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    private int ib() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    private int bN(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    private int bO(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return this.As == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public int getOrientation() {
        return this.As;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        View findContainingItemView;
        int ib;
        View aj;
        if (getChildCount() != 0 && (findContainingItemView = findContainingItemView(view)) != null) {
            gf();
            int bo = bo(i);
            if (bo == Integer.MIN_VALUE) {
                return null;
            }
            LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
            boolean z = layoutParams.VN;
            b bVar = layoutParams.VM;
            if (bo == 1) {
                ib = ia();
            } else {
                ib = ib();
            }
            a(ib, state);
            bE(bo);
            this.Vy.Po = this.Vy.Pp + ib;
            this.Vy.Pn = (int) (0.33333334f * this.Vv.getTotalSpace());
            this.Vy.Pt = true;
            this.Vy.Pm = false;
            a(recycler, this.Vy, state);
            this.VC = this.PK;
            if (z || (aj = bVar.aj(ib, bo)) == null || aj == findContainingItemView) {
                if (bL(bo)) {
                    for (int i2 = this.Pb - 1; i2 >= 0; i2--) {
                        View aj2 = this.Vu[i2].aj(ib, bo);
                        if (aj2 != null && aj2 != findContainingItemView) {
                            return aj2;
                        }
                    }
                } else {
                    for (int i3 = 0; i3 < this.Pb; i3++) {
                        View aj3 = this.Vu[i3].aj(ib, bo);
                        if (aj3 != null && aj3 != findContainingItemView) {
                            return aj3;
                        }
                    }
                }
                return null;
            }
            return aj;
        }
        return null;
    }

    private int bo(int i) {
        switch (i) {
            case 1:
                return (this.As == 1 || !isLayoutRTL()) ? -1 : 1;
            case 2:
                return (this.As != 1 && isLayoutRTL()) ? -1 : 1;
            case 17:
                return this.As != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.As != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                return this.As != 0 ? Integer.MIN_VALUE : 1;
            case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                return this.As == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        b VM;
        boolean VN;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public void setFullSpan(boolean z) {
            this.VN = z;
        }

        public boolean isFullSpan() {
            return this.VN;
        }

        public final int getSpanIndex() {
            if (this.VM == null) {
                return -1;
            }
            return this.VM.mIndex;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b {
        ArrayList<View> VX = new ArrayList<>();
        int VY = Integer.MIN_VALUE;
        int VZ = Integer.MIN_VALUE;
        int Wa = 0;
        final int mIndex;

        b(int i) {
            this.mIndex = i;
        }

        int ca(int i) {
            if (this.VY != Integer.MIN_VALUE) {
                return this.VY;
            }
            if (this.VX.size() != 0) {
                ie();
                return this.VY;
            }
            return i;
        }

        void ie() {
            LazySpanLookup.FullSpanItem bW;
            View view = this.VX.get(0);
            LayoutParams aA = aA(view);
            this.VY = StaggeredGridLayoutManager.this.Vv.getDecoratedStart(view);
            if (aA.VN && (bW = StaggeredGridLayoutManager.this.VA.bW(aA.getViewLayoutPosition())) != null && bW.VP == -1) {
                this.VY -= bW.bX(this.mIndex);
            }
        }

        /* renamed from: if  reason: not valid java name */
        int m5if() {
            if (this.VY != Integer.MIN_VALUE) {
                return this.VY;
            }
            ie();
            return this.VY;
        }

        int cb(int i) {
            if (this.VZ != Integer.MIN_VALUE) {
                return this.VZ;
            }
            if (this.VX.size() != 0) {
                ig();
                return this.VZ;
            }
            return i;
        }

        void ig() {
            LazySpanLookup.FullSpanItem bW;
            View view = this.VX.get(this.VX.size() - 1);
            LayoutParams aA = aA(view);
            this.VZ = StaggeredGridLayoutManager.this.Vv.getDecoratedEnd(view);
            if (!aA.VN || (bW = StaggeredGridLayoutManager.this.VA.bW(aA.getViewLayoutPosition())) == null || bW.VP != 1) {
                return;
            }
            this.VZ = bW.bX(this.mIndex) + this.VZ;
        }

        int ih() {
            if (this.VZ != Integer.MIN_VALUE) {
                return this.VZ;
            }
            ig();
            return this.VZ;
        }

        void ay(View view) {
            LayoutParams aA = aA(view);
            aA.VM = this;
            this.VX.add(0, view);
            this.VY = Integer.MIN_VALUE;
            if (this.VX.size() == 1) {
                this.VZ = Integer.MIN_VALUE;
            }
            if (aA.isItemRemoved() || aA.isItemChanged()) {
                this.Wa += StaggeredGridLayoutManager.this.Vv.getDecoratedMeasurement(view);
            }
        }

        void az(View view) {
            LayoutParams aA = aA(view);
            aA.VM = this;
            this.VX.add(view);
            this.VZ = Integer.MIN_VALUE;
            if (this.VX.size() == 1) {
                this.VY = Integer.MIN_VALUE;
            }
            if (aA.isItemRemoved() || aA.isItemChanged()) {
                this.Wa += StaggeredGridLayoutManager.this.Vv.getDecoratedMeasurement(view);
            }
        }

        void c(boolean z, int i) {
            int ca;
            if (z) {
                ca = cb(Integer.MIN_VALUE);
            } else {
                ca = ca(Integer.MIN_VALUE);
            }
            clear();
            if (ca != Integer.MIN_VALUE) {
                if (!z || ca >= StaggeredGridLayoutManager.this.Vv.getEndAfterPadding()) {
                    if (z || ca <= StaggeredGridLayoutManager.this.Vv.getStartAfterPadding()) {
                        if (i != Integer.MIN_VALUE) {
                            ca += i;
                        }
                        this.VZ = ca;
                        this.VY = ca;
                    }
                }
            }
        }

        void clear() {
            this.VX.clear();
            ii();
            this.Wa = 0;
        }

        void ii() {
            this.VY = Integer.MIN_VALUE;
            this.VZ = Integer.MIN_VALUE;
        }

        void cc(int i) {
            this.VY = i;
            this.VZ = i;
        }

        void ij() {
            int size = this.VX.size();
            View remove = this.VX.remove(size - 1);
            LayoutParams aA = aA(remove);
            aA.VM = null;
            if (aA.isItemRemoved() || aA.isItemChanged()) {
                this.Wa -= StaggeredGridLayoutManager.this.Vv.getDecoratedMeasurement(remove);
            }
            if (size == 1) {
                this.VY = Integer.MIN_VALUE;
            }
            this.VZ = Integer.MIN_VALUE;
        }

        void ik() {
            View remove = this.VX.remove(0);
            LayoutParams aA = aA(remove);
            aA.VM = null;
            if (this.VX.size() == 0) {
                this.VZ = Integer.MIN_VALUE;
            }
            if (aA.isItemRemoved() || aA.isItemChanged()) {
                this.Wa -= StaggeredGridLayoutManager.this.Vv.getDecoratedMeasurement(remove);
            }
            this.VY = Integer.MIN_VALUE;
        }

        public int il() {
            return this.Wa;
        }

        LayoutParams aA(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        void cd(int i) {
            if (this.VY != Integer.MIN_VALUE) {
                this.VY += i;
            }
            if (this.VZ != Integer.MIN_VALUE) {
                this.VZ += i;
            }
        }

        public int findFirstVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.PJ) {
                return d(this.VX.size() - 1, -1, false);
            }
            return d(0, this.VX.size(), false);
        }

        public int findFirstCompletelyVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.PJ ? d(this.VX.size() - 1, -1, true) : d(0, this.VX.size(), true);
        }

        public int findLastVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.PJ) {
                return d(0, this.VX.size(), false);
            }
            return d(this.VX.size() - 1, -1, false);
        }

        public int findLastCompletelyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.PJ) {
                return d(0, this.VX.size(), true);
            }
            return d(this.VX.size() - 1, -1, true);
        }

        int d(int i, int i2, boolean z) {
            int startAfterPadding = StaggeredGridLayoutManager.this.Vv.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.Vv.getEndAfterPadding();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.VX.get(i);
                int decoratedStart = StaggeredGridLayoutManager.this.Vv.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.Vv.getDecoratedEnd(view);
                if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                    if (z) {
                        if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                            return StaggeredGridLayoutManager.this.getPosition(view);
                        }
                    } else {
                        return StaggeredGridLayoutManager.this.getPosition(view);
                    }
                }
                i += i3;
            }
            return -1;
        }

        public View aj(int i, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.VX.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.VX.get(i3);
                    if (!view2.isFocusable()) {
                        break;
                    }
                    if ((StaggeredGridLayoutManager.this.getPosition(view2) > i) != StaggeredGridLayoutManager.this.PJ) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
                return view;
            }
            int size2 = this.VX.size() - 1;
            while (size2 >= 0) {
                View view3 = this.VX.get(size2);
                if (!view3.isFocusable()) {
                    break;
                }
                if ((StaggeredGridLayoutManager.this.getPosition(view3) > i) != (!StaggeredGridLayoutManager.this.PJ)) {
                    break;
                }
                size2--;
                view = view3;
            }
            return view;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class LazySpanLookup {
        List<FullSpanItem> VO;
        int[] mData;

        LazySpanLookup() {
        }

        int bQ(int i) {
            if (this.VO != null) {
                for (int size = this.VO.size() - 1; size >= 0; size--) {
                    if (this.VO.get(size).mPosition >= i) {
                        this.VO.remove(size);
                    }
                }
            }
            return bR(i);
        }

        int bR(int i) {
            if (this.mData != null && i < this.mData.length) {
                int bV = bV(i);
                if (bV == -1) {
                    Arrays.fill(this.mData, i, this.mData.length, -1);
                    return this.mData.length;
                }
                Arrays.fill(this.mData, i, bV + 1, -1);
                return bV + 1;
            }
            return -1;
        }

        int bS(int i) {
            if (this.mData == null || i >= this.mData.length) {
                return -1;
            }
            return this.mData[i];
        }

        void a(int i, b bVar) {
            bU(i);
            this.mData[i] = bVar.mIndex;
        }

        int bT(int i) {
            int length = this.mData.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void bU(int i) {
            if (this.mData == null) {
                this.mData = new int[Math.max(i, 10) + 1];
                Arrays.fill(this.mData, -1);
            } else if (i >= this.mData.length) {
                int[] iArr = this.mData;
                this.mData = new int[bT(i)];
                System.arraycopy(iArr, 0, this.mData, 0, iArr.length);
                Arrays.fill(this.mData, iArr.length, this.mData.length, -1);
            }
        }

        void clear() {
            if (this.mData != null) {
                Arrays.fill(this.mData, -1);
            }
            this.VO = null;
        }

        void af(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                bU(i + i2);
                System.arraycopy(this.mData, i + i2, this.mData, i, (this.mData.length - i) - i2);
                Arrays.fill(this.mData, this.mData.length - i2, this.mData.length, -1);
                ag(i, i2);
            }
        }

        private void ag(int i, int i2) {
            if (this.VO != null) {
                int i3 = i + i2;
                for (int size = this.VO.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.VO.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        if (fullSpanItem.mPosition < i3) {
                            this.VO.remove(size);
                        } else {
                            fullSpanItem.mPosition -= i2;
                        }
                    }
                }
            }
        }

        void ah(int i, int i2) {
            if (this.mData != null && i < this.mData.length) {
                bU(i + i2);
                System.arraycopy(this.mData, i, this.mData, i + i2, (this.mData.length - i) - i2);
                Arrays.fill(this.mData, i, i + i2, -1);
                ai(i, i2);
            }
        }

        private void ai(int i, int i2) {
            if (this.VO != null) {
                for (int size = this.VO.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.VO.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        fullSpanItem.mPosition += i2;
                    }
                }
            }
        }

        private int bV(int i) {
            if (this.VO == null) {
                return -1;
            }
            FullSpanItem bW = bW(i);
            if (bW != null) {
                this.VO.remove(bW);
            }
            int size = this.VO.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.VO.get(i2).mPosition >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                this.VO.remove(i2);
                return this.VO.get(i2).mPosition;
            }
            return -1;
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.VO == null) {
                this.VO = new ArrayList();
            }
            int size = this.VO.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.VO.get(i);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.VO.remove(i);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.VO.add(i, fullSpanItem);
                    return;
                }
            }
            this.VO.add(fullSpanItem);
        }

        public FullSpanItem bW(int i) {
            if (this.VO == null) {
                return null;
            }
            for (int size = this.VO.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.VO.get(size);
                if (fullSpanItem.mPosition == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem c(int i, int i2, int i3, boolean z) {
            if (this.VO == null) {
                return null;
            }
            int size = this.VO.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.VO.get(i4);
                if (fullSpanItem.mPosition >= i2) {
                    return null;
                }
                if (fullSpanItem.mPosition >= i) {
                    if (i3 == 0 || fullSpanItem.VP == i3) {
                        return fullSpanItem;
                    }
                    if (z && fullSpanItem.VR) {
                        return fullSpanItem;
                    }
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                /* renamed from: q */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.Parcelable.Creator
                /* renamed from: bY */
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };
            int VP;
            int[] VQ;
            boolean VR;
            int mPosition;

            public FullSpanItem(Parcel parcel) {
                this.mPosition = parcel.readInt();
                this.VP = parcel.readInt();
                this.VR = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.VQ = new int[readInt];
                    parcel.readIntArray(this.VQ);
                }
            }

            public FullSpanItem() {
            }

            int bX(int i) {
                if (this.VQ == null) {
                    return 0;
                }
                return this.VQ[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.VP);
                parcel.writeInt(this.VR ? 1 : 0);
                if (this.VQ != null && this.VQ.length > 0) {
                    parcel.writeInt(this.VQ.length);
                    parcel.writeIntArray(this.VQ);
                    return;
                }
                parcel.writeInt(0);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.VP + ", mHasUnwantedGapAfter=" + this.VR + ", mGapPerSpan=" + Arrays.toString(this.VQ) + '}';
            }
        }
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: r */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: bZ */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        boolean PJ;
        int Qd;
        boolean Qf;
        boolean VD;
        List<LazySpanLookup.FullSpanItem> VO;
        int VS;
        int VT;
        int[] VU;
        int VV;
        int[] VW;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.Qd = parcel.readInt();
            this.VS = parcel.readInt();
            this.VT = parcel.readInt();
            if (this.VT > 0) {
                this.VU = new int[this.VT];
                parcel.readIntArray(this.VU);
            }
            this.VV = parcel.readInt();
            if (this.VV > 0) {
                this.VW = new int[this.VV];
                parcel.readIntArray(this.VW);
            }
            this.PJ = parcel.readInt() == 1;
            this.Qf = parcel.readInt() == 1;
            this.VD = parcel.readInt() == 1;
            this.VO = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.VT = savedState.VT;
            this.Qd = savedState.Qd;
            this.VS = savedState.VS;
            this.VU = savedState.VU;
            this.VV = savedState.VV;
            this.VW = savedState.VW;
            this.PJ = savedState.PJ;
            this.Qf = savedState.Qf;
            this.VD = savedState.VD;
            this.VO = savedState.VO;
        }

        void ic() {
            this.VU = null;
            this.VT = 0;
            this.VV = 0;
            this.VW = null;
            this.VO = null;
        }

        void id() {
            this.VU = null;
            this.VT = 0;
            this.Qd = -1;
            this.VS = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.Qd);
            parcel.writeInt(this.VS);
            parcel.writeInt(this.VT);
            if (this.VT > 0) {
                parcel.writeIntArray(this.VU);
            }
            parcel.writeInt(this.VV);
            if (this.VV > 0) {
                parcel.writeIntArray(this.VW);
            }
            parcel.writeInt(this.PJ ? 1 : 0);
            parcel.writeInt(this.Qf ? 1 : 0);
            parcel.writeInt(this.VD ? 1 : 0);
            parcel.writeList(this.VO);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        boolean PV;
        boolean PW;
        boolean VK;
        int[] VL;
        int mOffset;
        int mPosition;

        public a() {
            reset();
        }

        void reset() {
            this.mPosition = -1;
            this.mOffset = Integer.MIN_VALUE;
            this.PV = false;
            this.VK = false;
            this.PW = false;
            if (this.VL != null) {
                Arrays.fill(this.VL, -1);
            }
        }

        void a(b[] bVarArr) {
            int length = bVarArr.length;
            if (this.VL == null || this.VL.length < length) {
                this.VL = new int[StaggeredGridLayoutManager.this.Vu.length];
            }
            for (int i = 0; i < length; i++) {
                this.VL[i] = bVarArr[i].ca(Integer.MIN_VALUE);
            }
        }

        void gm() {
            this.mOffset = this.PV ? StaggeredGridLayoutManager.this.Vv.getEndAfterPadding() : StaggeredGridLayoutManager.this.Vv.getStartAfterPadding();
        }

        void bP(int i) {
            if (this.PV) {
                this.mOffset = StaggeredGridLayoutManager.this.Vv.getEndAfterPadding() - i;
            } else {
                this.mOffset = StaggeredGridLayoutManager.this.Vv.getStartAfterPadding() + i;
            }
        }
    }
}
