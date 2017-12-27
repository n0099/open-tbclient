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
    private int At;
    private BitSet VA;
    private boolean VD;
    private boolean VE;
    private SavedState VF;
    private int VG;
    b[] Vv;
    OrientationHelper Vw;
    OrientationHelper Vx;
    private int Vy;
    private final m Vz;
    private int Pc = -1;
    boolean PK = false;
    boolean PM = false;
    int PO = -1;
    int PP = Integer.MIN_VALUE;
    LazySpanLookup VB = new LazySpanLookup();
    private int VC = 2;
    private final Rect mTmpRect = new Rect();
    private final a VH = new a();
    private boolean VI = false;
    private boolean mSmoothScrollbarEnabled = true;
    private final Runnable VJ = new Runnable() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.1
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
        setAutoMeasureEnabled(this.VC != 0);
        this.Vz = new m();
        hT();
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.At = i2;
        setSpanCount(i);
        setAutoMeasureEnabled(this.VC != 0);
        this.Vz = new m();
        hT();
    }

    private void hT() {
        this.Vw = OrientationHelper.createOrientationHelper(this, this.At);
        this.Vx = OrientationHelper.createOrientationHelper(this, 1 - this.At);
    }

    boolean hU() {
        int ib;
        int ia;
        if (getChildCount() == 0 || this.VC == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.PM) {
            ib = ia();
            ia = ib();
        } else {
            ib = ib();
            ia = ia();
        }
        if (ib == 0 && hV() != null) {
            this.VB.clear();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        } else if (this.VI) {
            int i = this.PM ? -1 : 1;
            LazySpanLookup.FullSpanItem c = this.VB.c(ib, ia + 1, i, true);
            if (c == null) {
                this.VI = false;
                this.VB.bQ(ia + 1);
                return false;
            }
            LazySpanLookup.FullSpanItem c2 = this.VB.c(ib, c.mPosition, i * (-1), true);
            if (c2 == null) {
                this.VB.bQ(c.mPosition);
            } else {
                this.VB.bQ(c2.mPosition + 1);
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
        removeCallbacks(this.VJ);
        for (int i = 0; i < this.Pc; i++) {
            this.Vv[i].clear();
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
        BitSet bitSet = new BitSet(this.Pc);
        bitSet.set(0, this.Pc, true);
        char c = (this.At == 1 && isLayoutRTL()) ? (char) 1 : (char) 65535;
        if (this.PM) {
            i = -1;
        } else {
            i = childCount + 1;
            childCount = 0;
        }
        int i2 = childCount < i ? 1 : -1;
        for (int i3 = childCount; i3 != i; i3 += i2) {
            View childAt = getChildAt(i3);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(layoutParams.VN.mIndex)) {
                if (a(layoutParams.VN)) {
                    return childAt;
                }
                bitSet.clear(layoutParams.VN.mIndex);
            }
            if (!layoutParams.VO && i3 + i2 != i) {
                View childAt2 = getChildAt(i3 + i2);
                if (this.PM) {
                    int decoratedEnd = this.Vw.getDecoratedEnd(childAt);
                    int decoratedEnd2 = this.Vw.getDecoratedEnd(childAt2);
                    if (decoratedEnd < decoratedEnd2) {
                        return childAt;
                    }
                    if (decoratedEnd == decoratedEnd2) {
                        z = true;
                        if (z) {
                            if ((layoutParams.VN.mIndex - ((LayoutParams) childAt2.getLayoutParams()).VN.mIndex < 0) != (c < 0)) {
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
                    int decoratedStart = this.Vw.getDecoratedStart(childAt);
                    int decoratedStart2 = this.Vw.getDecoratedStart(childAt2);
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
        if (this.PM) {
            if (bVar.ih() < this.Vw.getEndAfterPadding()) {
                return !bVar.aA(bVar.VY.get(bVar.VY.size() + (-1))).VO;
            }
        } else if (bVar.m5if() > this.Vw.getStartAfterPadding()) {
            return bVar.aA(bVar.VY.get(0)).VO ? false : true;
        }
        return false;
    }

    public void setSpanCount(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.Pc) {
            invalidateSpanAssignments();
            this.Pc = i;
            this.VA = new BitSet(this.Pc);
            this.Vv = new b[this.Pc];
            for (int i2 = 0; i2 < this.Pc; i2++) {
                this.Vv[i2] = new b(i2);
            }
            requestLayout();
        }
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.At) {
            this.At = i;
            OrientationHelper orientationHelper = this.Vw;
            this.Vw = this.Vx;
            this.Vx = orientationHelper;
            requestLayout();
        }
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.VF != null && this.VF.PK != z) {
            this.VF.PK = z;
        }
        this.PK = z;
        requestLayout();
    }

    public int getGapStrategy() {
        return this.VC;
    }

    public void setGapStrategy(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.VC) {
            if (i != 0 && i != 2) {
                throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
            }
            this.VC = i;
            setAutoMeasureEnabled(this.VC != 0);
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.VF == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public int getSpanCount() {
        return this.Pc;
    }

    public void invalidateSpanAssignments() {
        this.VB.clear();
        requestLayout();
    }

    private void gf() {
        if (this.At == 1 || !isLayoutRTL()) {
            this.PM = this.PK;
        } else {
            this.PM = this.PK ? false : true;
        }
    }

    boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean getReverseLayout() {
        return this.PK;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.At == 1) {
            chooseSize2 = chooseSize(i2, paddingTop + rect.height(), getMinimumHeight());
            chooseSize = chooseSize(i, paddingRight + (this.Vy * this.Pc), getMinimumWidth());
        } else {
            chooseSize = chooseSize(i, paddingRight + rect.width(), getMinimumWidth());
            chooseSize2 = chooseSize(i2, paddingTop + (this.Vy * this.Pc), getMinimumHeight());
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
        a aVar = this.VH;
        if ((this.VF != null || this.PO != -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            aVar.reset();
            return;
        }
        boolean z3 = (aVar.PX && this.PO == -1 && this.VF == null) ? false : true;
        if (z3) {
            aVar.reset();
            if (this.VF != null) {
                a(aVar);
            } else {
                gf();
                aVar.PW = this.PM;
            }
            a(state, aVar);
            aVar.PX = true;
        }
        if (this.VF == null && this.PO == -1 && (aVar.PW != this.VD || isLayoutRTL() != this.VE)) {
            this.VB.clear();
            aVar.VL = true;
        }
        if (getChildCount() > 0 && (this.VF == null || this.VF.VU < 1)) {
            if (aVar.VL) {
                for (int i = 0; i < this.Pc; i++) {
                    this.Vv[i].clear();
                    if (aVar.mOffset != Integer.MIN_VALUE) {
                        this.Vv[i].cc(aVar.mOffset);
                    }
                }
            } else if (z3 || this.VH.VM == null) {
                for (int i2 = 0; i2 < this.Pc; i2++) {
                    this.Vv[i2].c(this.PM, aVar.mOffset);
                }
                this.VH.a(this.Vv);
            } else {
                for (int i3 = 0; i3 < this.Pc; i3++) {
                    b bVar = this.Vv[i3];
                    bVar.clear();
                    bVar.cc(this.VH.VM[i3]);
                }
            }
        }
        detachAndScrapAttachedViews(recycler);
        this.Vz.Pn = false;
        this.VI = false;
        bD(this.Vx.getTotalSpace());
        a(aVar.mPosition, state);
        if (aVar.PW) {
            bE(-1);
            a(recycler, this.Vz, state);
            bE(1);
            this.Vz.Pp = aVar.mPosition + this.Vz.Pq;
            a(recycler, this.Vz, state);
        } else {
            bE(1);
            a(recycler, this.Vz, state);
            bE(-1);
            this.Vz.Pp = aVar.mPosition + this.Vz.Pq;
            a(recycler, this.Vz, state);
        }
        hW();
        if (getChildCount() > 0) {
            if (this.PM) {
                b(recycler, state, true);
                c(recycler, state, false);
            } else {
                c(recycler, state, true);
                b(recycler, state, false);
            }
        }
        if (z && !state.isPreLayout()) {
            if (this.VC != 0 && getChildCount() > 0 && (this.VI || hV() != null)) {
                removeCallbacks(this.VJ);
                if (hU()) {
                    z2 = true;
                    if (state.isPreLayout()) {
                        this.VH.reset();
                    }
                    this.VD = aVar.PW;
                    this.VE = isLayoutRTL();
                    if (!z2) {
                        this.VH.reset();
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
        this.VD = aVar.PW;
        this.VE = isLayoutRTL();
        if (!z2) {
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.PO = -1;
        this.PP = Integer.MIN_VALUE;
        this.VF = null;
        this.VH.reset();
    }

    private void hW() {
        float max;
        if (this.Vx.getMode() != 1073741824) {
            float f = 0.0f;
            int childCount = getChildCount();
            int i = 0;
            while (i < childCount) {
                View childAt = getChildAt(i);
                float decoratedMeasurement = this.Vx.getDecoratedMeasurement(childAt);
                if (decoratedMeasurement < f) {
                    max = f;
                } else {
                    max = Math.max(f, ((LayoutParams) childAt.getLayoutParams()).isFullSpan() ? (1.0f * decoratedMeasurement) / this.Pc : decoratedMeasurement);
                }
                i++;
                f = max;
            }
            int i2 = this.Vy;
            int round = Math.round(this.Pc * f);
            if (this.Vx.getMode() == Integer.MIN_VALUE) {
                round = Math.min(round, this.Vx.getTotalSpace());
            }
            bD(round);
            if (this.Vy != i2) {
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt2 = getChildAt(i3);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (!layoutParams.VO) {
                        if (isLayoutRTL() && this.At == 1) {
                            childAt2.offsetLeftAndRight(((-((this.Pc - 1) - layoutParams.VN.mIndex)) * this.Vy) - ((-((this.Pc - 1) - layoutParams.VN.mIndex)) * i2));
                        } else {
                            int i4 = layoutParams.VN.mIndex * this.Vy;
                            int i5 = layoutParams.VN.mIndex * i2;
                            if (this.At == 1) {
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
        if (this.VF.VU > 0) {
            if (this.VF.VU == this.Pc) {
                for (int i = 0; i < this.Pc; i++) {
                    this.Vv[i].clear();
                    int i2 = this.VF.VV[i];
                    if (i2 != Integer.MIN_VALUE) {
                        if (this.VF.Qg) {
                            i2 += this.Vw.getEndAfterPadding();
                        } else {
                            i2 += this.Vw.getStartAfterPadding();
                        }
                    }
                    this.Vv[i].cc(i2);
                }
            } else {
                this.VF.ic();
                this.VF.Qe = this.VF.VT;
            }
        }
        this.VE = this.VF.VE;
        setReverseLayout(this.VF.PK);
        gf();
        if (this.VF.Qe != -1) {
            this.PO = this.VF.Qe;
            aVar.PW = this.VF.Qg;
        } else {
            aVar.PW = this.PM;
        }
        if (this.VF.VW > 1) {
            this.VB.mData = this.VF.VX;
            this.VB.VP = this.VF.VP;
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
        if (this.VD) {
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
        if (state.isPreLayout() || this.PO == -1) {
            return false;
        }
        if (this.PO < 0 || this.PO >= state.getItemCount()) {
            this.PO = -1;
            this.PP = Integer.MIN_VALUE;
            return false;
        } else if (this.VF == null || this.VF.Qe == -1 || this.VF.VU < 1) {
            View findViewByPosition = findViewByPosition(this.PO);
            if (findViewByPosition != null) {
                aVar.mPosition = this.PM ? ia() : ib();
                if (this.PP != Integer.MIN_VALUE) {
                    if (aVar.PW) {
                        aVar.mOffset = (this.Vw.getEndAfterPadding() - this.PP) - this.Vw.getDecoratedEnd(findViewByPosition);
                        return true;
                    }
                    aVar.mOffset = (this.Vw.getStartAfterPadding() + this.PP) - this.Vw.getDecoratedStart(findViewByPosition);
                    return true;
                } else if (this.Vw.getDecoratedMeasurement(findViewByPosition) > this.Vw.getTotalSpace()) {
                    if (aVar.PW) {
                        startAfterPadding = this.Vw.getEndAfterPadding();
                    } else {
                        startAfterPadding = this.Vw.getStartAfterPadding();
                    }
                    aVar.mOffset = startAfterPadding;
                    return true;
                } else {
                    int decoratedStart = this.Vw.getDecoratedStart(findViewByPosition) - this.Vw.getStartAfterPadding();
                    if (decoratedStart < 0) {
                        aVar.mOffset = -decoratedStart;
                        return true;
                    }
                    int endAfterPadding = this.Vw.getEndAfterPadding() - this.Vw.getDecoratedEnd(findViewByPosition);
                    if (endAfterPadding < 0) {
                        aVar.mOffset = endAfterPadding;
                        return true;
                    }
                    aVar.mOffset = Integer.MIN_VALUE;
                    return true;
                }
            }
            aVar.mPosition = this.PO;
            if (this.PP == Integer.MIN_VALUE) {
                aVar.PW = bM(aVar.mPosition) == 1;
                aVar.gm();
            } else {
                aVar.bP(this.PP);
            }
            aVar.VL = true;
            return true;
        } else {
            aVar.mOffset = Integer.MIN_VALUE;
            aVar.mPosition = this.PO;
            return true;
        }
    }

    void bD(int i) {
        this.Vy = i / this.Pc;
        this.VG = View.MeasureSpec.makeMeasureSpec(i, this.Vx.getMode());
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.VF == null;
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.Pc];
        } else if (iArr.length < this.Pc) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.Pc + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.Pc; i++) {
            iArr[i] = this.Vv[i].findFirstVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.Pc];
        } else if (iArr.length < this.Pc) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.Pc + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.Pc; i++) {
            iArr[i] = this.Vv[i].findFirstCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.Pc];
        } else if (iArr.length < this.Pc) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.Pc + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.Pc; i++) {
            iArr[i] = this.Vv[i].findLastVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.Pc];
        } else if (iArr.length < this.Pc) {
            throw new IllegalArgumentException("Provided int[]'s size must be more than or equal to span count. Expected:" + this.Pc + ", array size:" + iArr.length);
        }
        for (int i = 0; i < this.Pc; i++) {
            iArr[i] = this.Vv[i].findLastCompletelyVisibleItemPosition();
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
        return q.a(state, this.Vw, M(!this.mSmoothScrollbarEnabled), N(this.mSmoothScrollbarEnabled ? false : true), this, this.mSmoothScrollbarEnabled, this.PM);
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
        return q.a(state, this.Vw, M(!this.mSmoothScrollbarEnabled), N(this.mSmoothScrollbarEnabled ? false : true), this, this.mSmoothScrollbarEnabled);
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
        return q.b(state, this.Vw, M(!this.mSmoothScrollbarEnabled), N(this.mSmoothScrollbarEnabled ? false : true), this, this.mSmoothScrollbarEnabled);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return d(state);
    }

    private void a(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.VO) {
            if (this.At == 1) {
                a(view, this.VG, getChildMeasureSpec(getHeight(), getHeightMode(), 0, layoutParams.height, true), z);
            } else {
                a(view, getChildMeasureSpec(getWidth(), getWidthMode(), 0, layoutParams.width, true), this.VG, z);
            }
        } else if (this.At == 1) {
            a(view, getChildMeasureSpec(this.Vy, getWidthMode(), 0, layoutParams.width, false), getChildMeasureSpec(getHeight(), getHeightMode(), 0, layoutParams.height, true), z);
        } else {
            a(view, getChildMeasureSpec(getWidth(), getWidthMode(), 0, layoutParams.width, true), getChildMeasureSpec(this.Vy, getHeightMode(), 0, layoutParams.height, false), z);
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
            this.VF = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        int ca;
        if (this.VF != null) {
            return new SavedState(this.VF);
        }
        SavedState savedState = new SavedState();
        savedState.PK = this.PK;
        savedState.Qg = this.VD;
        savedState.VE = this.VE;
        if (this.VB != null && this.VB.mData != null) {
            savedState.VX = this.VB.mData;
            savedState.VW = savedState.VX.length;
            savedState.VP = this.VB.VP;
        } else {
            savedState.VW = 0;
        }
        if (getChildCount() > 0) {
            savedState.Qe = this.VD ? ia() : ib();
            savedState.VT = hX();
            savedState.VU = this.Pc;
            savedState.VV = new int[this.Pc];
            for (int i = 0; i < this.Pc; i++) {
                if (this.VD) {
                    ca = this.Vv[i].cb(Integer.MIN_VALUE);
                    if (ca != Integer.MIN_VALUE) {
                        ca -= this.Vw.getEndAfterPadding();
                    }
                } else {
                    ca = this.Vv[i].ca(Integer.MIN_VALUE);
                    if (ca != Integer.MIN_VALUE) {
                        ca -= this.Vw.getStartAfterPadding();
                    }
                }
                savedState.VV[i] = ca;
            }
        } else {
            savedState.Qe = -1;
            savedState.VT = -1;
            savedState.VU = 0;
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
        if (this.At == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.VO ? this.Pc : 1, -1, -1, layoutParams2.VO, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, layoutParams2.getSpanIndex(), layoutParams2.VO ? this.Pc : 1, layoutParams2.VO, false));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            View M = M(false);
            View N = N(false);
            if (M != null && N != null) {
                int position = getPosition(M);
                int position2 = getPosition(N);
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
        View N = this.PM ? N(true) : M(true);
        if (N == null) {
            return -1;
        }
        return getPosition(N);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.At == 0 ? this.Pc : super.getRowCountForAccessibility(recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.At == 1 ? this.Pc : super.getColumnCountForAccessibility(recycler, state);
    }

    View M(boolean z) {
        int startAfterPadding = this.Vw.getStartAfterPadding();
        int endAfterPadding = this.Vw.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int decoratedStart = this.Vw.getDecoratedStart(childAt);
            if (this.Vw.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
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

    View N(boolean z) {
        int startAfterPadding = this.Vw.getStartAfterPadding();
        int endAfterPadding = this.Vw.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.Vw.getDecoratedStart(childAt);
            int decoratedEnd = this.Vw.getDecoratedEnd(childAt);
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
        if (bJ != Integer.MIN_VALUE && (endAfterPadding = this.Vw.getEndAfterPadding() - bJ) > 0) {
            int i = endAfterPadding - (-a(-endAfterPadding, recycler, state));
            if (z && i > 0) {
                this.Vw.offsetChildren(i);
            }
        }
    }

    private void c(RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int bI = bI(Integer.MAX_VALUE);
        if (bI != Integer.MAX_VALUE && (startAfterPadding = bI - this.Vw.getStartAfterPadding()) > 0) {
            int a2 = startAfterPadding - a(startAfterPadding, recycler, state);
            if (z && a2 > 0) {
                this.Vw.offsetChildren(-a2);
            }
        }
    }

    private void a(int i, RecyclerView.State state) {
        int i2;
        int i3;
        int targetScrollPosition;
        boolean z = false;
        this.Vz.Po = 0;
        this.Vz.Pp = i;
        if (!isSmoothScrolling() || (targetScrollPosition = state.getTargetScrollPosition()) == -1) {
            i2 = 0;
            i3 = 0;
        } else {
            if (this.PM == (targetScrollPosition < i)) {
                i2 = this.Vw.getTotalSpace();
                i3 = 0;
            } else {
                i3 = this.Vw.getTotalSpace();
                i2 = 0;
            }
        }
        if (getClipToPadding()) {
            this.Vz.Ps = this.Vw.getStartAfterPadding() - i3;
            this.Vz.Pt = i2 + this.Vw.getEndAfterPadding();
        } else {
            this.Vz.Pt = i2 + this.Vw.getEnd();
            this.Vz.Ps = -i3;
        }
        this.Vz.Pu = false;
        this.Vz.Pn = true;
        m mVar = this.Vz;
        if (this.Vw.getMode() == 0 && this.Vw.getEnd() == 0) {
            z = true;
        }
        mVar.Pv = z;
    }

    private void bE(int i) {
        this.Vz.Pr = i;
        this.Vz.Pq = this.PM != (i == -1) ? -1 : 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.Pc; i2++) {
            this.Vv[i2].cd(i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.Pc; i2++) {
            this.Vv[i2].cd(i);
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
        this.VB.clear();
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
        int ia = this.PM ? ia() : ib();
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
        this.VB.bR(i5);
        switch (i3) {
            case 1:
                this.VB.ah(i, i2);
                break;
            case 2:
                this.VB.af(i, i2);
                break;
            case 8:
                this.VB.af(i, 1);
                this.VB.ah(i2, 1);
                break;
        }
        if (i4 > ia) {
            if (i5 <= (this.PM ? ib() : ia())) {
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
        this.VA.set(0, this.Pc, true);
        if (this.Vz.Pv) {
            if (mVar.Pr == 1) {
                i = Integer.MAX_VALUE;
            } else {
                i = Integer.MIN_VALUE;
            }
        } else if (mVar.Pr == 1) {
            i = mVar.Pt + mVar.Po;
        } else {
            i = mVar.Ps - mVar.Po;
        }
        ae(mVar.Pr, i);
        if (this.PM) {
            startAfterPadding = this.Vw.getEndAfterPadding();
        } else {
            startAfterPadding = this.Vw.getStartAfterPadding();
        }
        boolean z2 = false;
        while (mVar.a(state) && (this.Vz.Pv || !this.VA.isEmpty())) {
            View a2 = mVar.a(recycler);
            LayoutParams layoutParams = (LayoutParams) a2.getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            int bS = this.VB.bS(viewLayoutPosition);
            boolean z3 = bS == -1;
            if (z3) {
                b a3 = layoutParams.VO ? this.Vv[0] : a(mVar);
                this.VB.a(viewLayoutPosition, a3);
                bVar = a3;
            } else {
                bVar = this.Vv[bS];
            }
            layoutParams.VN = bVar;
            if (mVar.Pr == 1) {
                addView(a2);
            } else {
                addView(a2, 0);
            }
            a(a2, layoutParams, false);
            if (mVar.Pr == 1) {
                int bJ2 = layoutParams.VO ? bJ(startAfterPadding) : bVar.cb(startAfterPadding);
                i2 = bJ2 + this.Vw.getDecoratedMeasurement(a2);
                if (z3 && layoutParams.VO) {
                    LazySpanLookup.FullSpanItem bF = bF(bJ2);
                    bF.VQ = -1;
                    bF.mPosition = viewLayoutPosition;
                    this.VB.a(bF);
                    decoratedMeasurement = bJ2;
                } else {
                    decoratedMeasurement = bJ2;
                }
            } else {
                int bI = layoutParams.VO ? bI(startAfterPadding) : bVar.ca(startAfterPadding);
                decoratedMeasurement = bI - this.Vw.getDecoratedMeasurement(a2);
                if (z3 && layoutParams.VO) {
                    LazySpanLookup.FullSpanItem bG = bG(bI);
                    bG.VQ = 1;
                    bG.mPosition = viewLayoutPosition;
                    this.VB.a(bG);
                }
                i2 = bI;
            }
            if (layoutParams.VO && mVar.Pq == -1) {
                if (z3) {
                    this.VI = true;
                } else {
                    if (mVar.Pr == 1) {
                        z = !hY();
                    } else {
                        z = !hZ();
                    }
                    if (z) {
                        LazySpanLookup.FullSpanItem bW = this.VB.bW(viewLayoutPosition);
                        if (bW != null) {
                            bW.VS = true;
                        }
                        this.VI = true;
                    }
                }
            }
            a(a2, layoutParams, mVar);
            if (isLayoutRTL() && this.At == 1) {
                int endAfterPadding = layoutParams.VO ? this.Vx.getEndAfterPadding() : this.Vx.getEndAfterPadding() - (((this.Pc - 1) - bVar.mIndex) * this.Vy);
                i3 = endAfterPadding - this.Vx.getDecoratedMeasurement(a2);
                decoratedMeasurement2 = endAfterPadding;
            } else {
                int startAfterPadding2 = layoutParams.VO ? this.Vx.getStartAfterPadding() : (bVar.mIndex * this.Vy) + this.Vx.getStartAfterPadding();
                decoratedMeasurement2 = startAfterPadding2 + this.Vx.getDecoratedMeasurement(a2);
                i3 = startAfterPadding2;
            }
            if (this.At == 1) {
                layoutDecoratedWithMargins(a2, i3, decoratedMeasurement, decoratedMeasurement2, i2);
            } else {
                layoutDecoratedWithMargins(a2, decoratedMeasurement, i3, i2, decoratedMeasurement2);
            }
            if (layoutParams.VO) {
                ae(this.Vz.Pr, i);
            } else {
                a(bVar, this.Vz.Pr, i);
            }
            a(recycler, this.Vz);
            if (this.Vz.Pu && a2.isFocusable()) {
                if (layoutParams.VO) {
                    this.VA.clear();
                } else {
                    this.VA.set(bVar.mIndex, false);
                }
            }
            z2 = true;
        }
        if (!z2) {
            a(recycler, this.Vz);
        }
        if (this.Vz.Pr == -1) {
            bJ = this.Vw.getStartAfterPadding() - bI(this.Vw.getStartAfterPadding());
        } else {
            bJ = bJ(this.Vw.getEndAfterPadding()) - this.Vw.getEndAfterPadding();
        }
        if (bJ > 0) {
            return Math.min(mVar.Po, bJ);
        }
        return 0;
    }

    private LazySpanLookup.FullSpanItem bF(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.VR = new int[this.Pc];
        for (int i2 = 0; i2 < this.Pc; i2++) {
            fullSpanItem.VR[i2] = i - this.Vv[i2].cb(i);
        }
        return fullSpanItem;
    }

    private LazySpanLookup.FullSpanItem bG(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.VR = new int[this.Pc];
        for (int i2 = 0; i2 < this.Pc; i2++) {
            fullSpanItem.VR[i2] = this.Vv[i2].ca(i) - i;
        }
        return fullSpanItem;
    }

    private void a(View view, LayoutParams layoutParams, m mVar) {
        if (mVar.Pr == 1) {
            if (layoutParams.VO) {
                aw(view);
            } else {
                layoutParams.VN.az(view);
            }
        } else if (layoutParams.VO) {
            ax(view);
        } else {
            layoutParams.VN.ay(view);
        }
    }

    private void a(RecyclerView.Recycler recycler, m mVar) {
        int min;
        int min2;
        if (mVar.Pn && !mVar.Pv) {
            if (mVar.Po == 0) {
                if (mVar.Pr == -1) {
                    d(recycler, mVar.Pt);
                } else {
                    c(recycler, mVar.Ps);
                }
            } else if (mVar.Pr == -1) {
                int bH = mVar.Ps - bH(mVar.Ps);
                if (bH < 0) {
                    min2 = mVar.Pt;
                } else {
                    min2 = mVar.Pt - Math.min(bH, mVar.Po);
                }
                d(recycler, min2);
            } else {
                int bK = bK(mVar.Pt) - mVar.Pt;
                if (bK < 0) {
                    min = mVar.Ps;
                } else {
                    min = Math.min(bK, mVar.Po) + mVar.Ps;
                }
                c(recycler, min);
            }
        }
    }

    private void aw(View view) {
        for (int i = this.Pc - 1; i >= 0; i--) {
            this.Vv[i].az(view);
        }
    }

    private void ax(View view) {
        for (int i = this.Pc - 1; i >= 0; i--) {
            this.Vv[i].ay(view);
        }
    }

    private void ae(int i, int i2) {
        for (int i3 = 0; i3 < this.Pc; i3++) {
            if (!this.Vv[i3].VY.isEmpty()) {
                a(this.Vv[i3], i, i2);
            }
        }
    }

    private void a(b bVar, int i, int i2) {
        int il = bVar.il();
        if (i == -1) {
            if (il + bVar.m5if() <= i2) {
                this.VA.set(bVar.mIndex, false);
            }
        } else if (bVar.ih() - il >= i2) {
            this.VA.set(bVar.mIndex, false);
        }
    }

    private int bH(int i) {
        int ca = this.Vv[0].ca(i);
        for (int i2 = 1; i2 < this.Pc; i2++) {
            int ca2 = this.Vv[i2].ca(i);
            if (ca2 > ca) {
                ca = ca2;
            }
        }
        return ca;
    }

    private int bI(int i) {
        int ca = this.Vv[0].ca(i);
        for (int i2 = 1; i2 < this.Pc; i2++) {
            int ca2 = this.Vv[i2].ca(i);
            if (ca2 < ca) {
                ca = ca2;
            }
        }
        return ca;
    }

    boolean hY() {
        int cb = this.Vv[0].cb(Integer.MIN_VALUE);
        for (int i = 1; i < this.Pc; i++) {
            if (this.Vv[i].cb(Integer.MIN_VALUE) != cb) {
                return false;
            }
        }
        return true;
    }

    boolean hZ() {
        int ca = this.Vv[0].ca(Integer.MIN_VALUE);
        for (int i = 1; i < this.Pc; i++) {
            if (this.Vv[i].ca(Integer.MIN_VALUE) != ca) {
                return false;
            }
        }
        return true;
    }

    private int bJ(int i) {
        int cb = this.Vv[0].cb(i);
        for (int i2 = 1; i2 < this.Pc; i2++) {
            int cb2 = this.Vv[i2].cb(i);
            if (cb2 > cb) {
                cb = cb2;
            }
        }
        return cb;
    }

    private int bK(int i) {
        int cb = this.Vv[0].cb(i);
        for (int i2 = 1; i2 < this.Pc; i2++) {
            int cb2 = this.Vv[i2].cb(i);
            if (cb2 < cb) {
                cb = cb2;
            }
        }
        return cb;
    }

    private void c(RecyclerView.Recycler recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.Vw.getDecoratedEnd(childAt) <= i && this.Vw.getTransformedEndWithDecoration(childAt) <= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.VO) {
                    for (int i2 = 0; i2 < this.Pc; i2++) {
                        if (this.Vv[i2].VY.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.Pc; i3++) {
                        this.Vv[i3].ik();
                    }
                } else if (layoutParams.VN.VY.size() != 1) {
                    layoutParams.VN.ik();
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
            if (this.Vw.getDecoratedStart(childAt) >= i && this.Vw.getTransformedStartWithDecoration(childAt) >= i) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.VO) {
                    for (int i2 = 0; i2 < this.Pc; i2++) {
                        if (this.Vv[i2].VY.size() == 1) {
                            return;
                        }
                    }
                    for (int i3 = 0; i3 < this.Pc; i3++) {
                        this.Vv[i3].ij();
                    }
                } else if (layoutParams.VN.VY.size() != 1) {
                    layoutParams.VN.ij();
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
        if (this.At == 0) {
            return (i == -1) != this.PM;
        }
        return ((i == -1) == this.PM) == isLayoutRTL();
    }

    private b a(m mVar) {
        int i;
        int i2;
        b bVar;
        b bVar2;
        b bVar3 = null;
        int i3 = -1;
        if (bL(mVar.Pr)) {
            i = this.Pc - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.Pc;
            i3 = 1;
        }
        if (mVar.Pr == 1) {
            int startAfterPadding = this.Vw.getStartAfterPadding();
            int i4 = i;
            int i5 = Integer.MAX_VALUE;
            while (i4 != i2) {
                b bVar4 = this.Vv[i4];
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
            int endAfterPadding = this.Vw.getEndAfterPadding();
            int i6 = i;
            int i7 = Integer.MIN_VALUE;
            while (i6 != i2) {
                b bVar5 = this.Vv[i6];
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
        return this.At == 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.At == 0;
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
            return this.PM ? 1 : -1;
        }
        return (i < ib()) == this.PM ? 1 : -1;
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        int bM = bM(i);
        PointF pointF = new PointF();
        if (bM == 0) {
            return null;
        }
        if (this.At == 0) {
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
        if (this.VF != null && this.VF.Qe != i) {
            this.VF.id();
        }
        this.PO = i;
        this.PP = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.VF != null) {
            this.VF.id();
        }
        this.PO = i;
        this.PP = i2;
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    int ge() {
        return this.Pc;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    int a(int i, int i2, RecyclerView.State state, int[] iArr) {
        int i3 = 0;
        if (this.At != 0) {
            i = i2;
        }
        if (getChildCount() != 0 && i != 0) {
            b(i, state);
            int i4 = this.Pc;
            while (i3 < this.Pc && this.Vz.a(state) && i4 > 0) {
                iArr[i3] = this.Vz.Pp;
                i4--;
                this.Vz.Pp += this.Vz.Pq;
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
        this.Vz.Pn = true;
        a(ib, state);
        bE(i2);
        this.Vz.Pp = this.Vz.Pq + ib;
        this.Vz.Po = Math.abs(i);
    }

    int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        b(i, state);
        int a2 = a(recycler, this.Vz, state);
        if (this.Vz.Po >= a2) {
            i = i < 0 ? -a2 : a2;
        }
        this.Vw.offsetChildren(-i);
        this.VD = this.PM;
        this.Vz.Po = 0;
        a(recycler, this.Vz);
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
        return this.At == 0 ? new LayoutParams(-2, -1) : new LayoutParams(-1, -2);
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
        return this.At;
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
            boolean z = layoutParams.VO;
            b bVar = layoutParams.VN;
            if (bo == 1) {
                ib = ia();
            } else {
                ib = ib();
            }
            a(ib, state);
            bE(bo);
            this.Vz.Pp = this.Vz.Pq + ib;
            this.Vz.Po = (int) (0.33333334f * this.Vw.getTotalSpace());
            this.Vz.Pu = true;
            this.Vz.Pn = false;
            a(recycler, this.Vz, state);
            this.VD = this.PM;
            if (z || (aj = bVar.aj(ib, bo)) == null || aj == findContainingItemView) {
                if (bL(bo)) {
                    for (int i2 = this.Pc - 1; i2 >= 0; i2--) {
                        View aj2 = this.Vv[i2].aj(ib, bo);
                        if (aj2 != null && aj2 != findContainingItemView) {
                            return aj2;
                        }
                    }
                } else {
                    for (int i3 = 0; i3 < this.Pc; i3++) {
                        View aj3 = this.Vv[i3].aj(ib, bo);
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
                return (this.At == 1 || !isLayoutRTL()) ? -1 : 1;
            case 2:
                return (this.At != 1 && isLayoutRTL()) ? -1 : 1;
            case 17:
                return this.At != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.At != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                return this.At != 0 ? Integer.MIN_VALUE : 1;
            case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                return this.At == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        b VN;
        boolean VO;

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
            this.VO = z;
        }

        public boolean isFullSpan() {
            return this.VO;
        }

        public final int getSpanIndex() {
            if (this.VN == null) {
                return -1;
            }
            return this.VN.mIndex;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b {
        ArrayList<View> VY = new ArrayList<>();
        int VZ = Integer.MIN_VALUE;
        int Wa = Integer.MIN_VALUE;
        int Wb = 0;
        final int mIndex;

        b(int i) {
            this.mIndex = i;
        }

        int ca(int i) {
            if (this.VZ != Integer.MIN_VALUE) {
                return this.VZ;
            }
            if (this.VY.size() != 0) {
                ie();
                return this.VZ;
            }
            return i;
        }

        void ie() {
            LazySpanLookup.FullSpanItem bW;
            View view = this.VY.get(0);
            LayoutParams aA = aA(view);
            this.VZ = StaggeredGridLayoutManager.this.Vw.getDecoratedStart(view);
            if (aA.VO && (bW = StaggeredGridLayoutManager.this.VB.bW(aA.getViewLayoutPosition())) != null && bW.VQ == -1) {
                this.VZ -= bW.bX(this.mIndex);
            }
        }

        /* renamed from: if  reason: not valid java name */
        int m5if() {
            if (this.VZ != Integer.MIN_VALUE) {
                return this.VZ;
            }
            ie();
            return this.VZ;
        }

        int cb(int i) {
            if (this.Wa != Integer.MIN_VALUE) {
                return this.Wa;
            }
            if (this.VY.size() != 0) {
                ig();
                return this.Wa;
            }
            return i;
        }

        void ig() {
            LazySpanLookup.FullSpanItem bW;
            View view = this.VY.get(this.VY.size() - 1);
            LayoutParams aA = aA(view);
            this.Wa = StaggeredGridLayoutManager.this.Vw.getDecoratedEnd(view);
            if (!aA.VO || (bW = StaggeredGridLayoutManager.this.VB.bW(aA.getViewLayoutPosition())) == null || bW.VQ != 1) {
                return;
            }
            this.Wa = bW.bX(this.mIndex) + this.Wa;
        }

        int ih() {
            if (this.Wa != Integer.MIN_VALUE) {
                return this.Wa;
            }
            ig();
            return this.Wa;
        }

        void ay(View view) {
            LayoutParams aA = aA(view);
            aA.VN = this;
            this.VY.add(0, view);
            this.VZ = Integer.MIN_VALUE;
            if (this.VY.size() == 1) {
                this.Wa = Integer.MIN_VALUE;
            }
            if (aA.isItemRemoved() || aA.isItemChanged()) {
                this.Wb += StaggeredGridLayoutManager.this.Vw.getDecoratedMeasurement(view);
            }
        }

        void az(View view) {
            LayoutParams aA = aA(view);
            aA.VN = this;
            this.VY.add(view);
            this.Wa = Integer.MIN_VALUE;
            if (this.VY.size() == 1) {
                this.VZ = Integer.MIN_VALUE;
            }
            if (aA.isItemRemoved() || aA.isItemChanged()) {
                this.Wb += StaggeredGridLayoutManager.this.Vw.getDecoratedMeasurement(view);
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
                if (!z || ca >= StaggeredGridLayoutManager.this.Vw.getEndAfterPadding()) {
                    if (z || ca <= StaggeredGridLayoutManager.this.Vw.getStartAfterPadding()) {
                        if (i != Integer.MIN_VALUE) {
                            ca += i;
                        }
                        this.Wa = ca;
                        this.VZ = ca;
                    }
                }
            }
        }

        void clear() {
            this.VY.clear();
            ii();
            this.Wb = 0;
        }

        void ii() {
            this.VZ = Integer.MIN_VALUE;
            this.Wa = Integer.MIN_VALUE;
        }

        void cc(int i) {
            this.VZ = i;
            this.Wa = i;
        }

        void ij() {
            int size = this.VY.size();
            View remove = this.VY.remove(size - 1);
            LayoutParams aA = aA(remove);
            aA.VN = null;
            if (aA.isItemRemoved() || aA.isItemChanged()) {
                this.Wb -= StaggeredGridLayoutManager.this.Vw.getDecoratedMeasurement(remove);
            }
            if (size == 1) {
                this.VZ = Integer.MIN_VALUE;
            }
            this.Wa = Integer.MIN_VALUE;
        }

        void ik() {
            View remove = this.VY.remove(0);
            LayoutParams aA = aA(remove);
            aA.VN = null;
            if (this.VY.size() == 0) {
                this.Wa = Integer.MIN_VALUE;
            }
            if (aA.isItemRemoved() || aA.isItemChanged()) {
                this.Wb -= StaggeredGridLayoutManager.this.Vw.getDecoratedMeasurement(remove);
            }
            this.VZ = Integer.MIN_VALUE;
        }

        public int il() {
            return this.Wb;
        }

        LayoutParams aA(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        void cd(int i) {
            if (this.VZ != Integer.MIN_VALUE) {
                this.VZ += i;
            }
            if (this.Wa != Integer.MIN_VALUE) {
                this.Wa += i;
            }
        }

        public int findFirstVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.PK) {
                return d(this.VY.size() - 1, -1, false);
            }
            return d(0, this.VY.size(), false);
        }

        public int findFirstCompletelyVisibleItemPosition() {
            return StaggeredGridLayoutManager.this.PK ? d(this.VY.size() - 1, -1, true) : d(0, this.VY.size(), true);
        }

        public int findLastVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.PK) {
                return d(0, this.VY.size(), false);
            }
            return d(this.VY.size() - 1, -1, false);
        }

        public int findLastCompletelyVisibleItemPosition() {
            if (StaggeredGridLayoutManager.this.PK) {
                return d(0, this.VY.size(), true);
            }
            return d(this.VY.size() - 1, -1, true);
        }

        int d(int i, int i2, boolean z) {
            int startAfterPadding = StaggeredGridLayoutManager.this.Vw.getStartAfterPadding();
            int endAfterPadding = StaggeredGridLayoutManager.this.Vw.getEndAfterPadding();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.VY.get(i);
                int decoratedStart = StaggeredGridLayoutManager.this.Vw.getDecoratedStart(view);
                int decoratedEnd = StaggeredGridLayoutManager.this.Vw.getDecoratedEnd(view);
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
                int size = this.VY.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.VY.get(i3);
                    if (!view2.isFocusable()) {
                        break;
                    }
                    if ((StaggeredGridLayoutManager.this.getPosition(view2) > i) != StaggeredGridLayoutManager.this.PK) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
                return view;
            }
            int size2 = this.VY.size() - 1;
            while (size2 >= 0) {
                View view3 = this.VY.get(size2);
                if (!view3.isFocusable()) {
                    break;
                }
                if ((StaggeredGridLayoutManager.this.getPosition(view3) > i) != (!StaggeredGridLayoutManager.this.PK)) {
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
        List<FullSpanItem> VP;
        int[] mData;

        LazySpanLookup() {
        }

        int bQ(int i) {
            if (this.VP != null) {
                for (int size = this.VP.size() - 1; size >= 0; size--) {
                    if (this.VP.get(size).mPosition >= i) {
                        this.VP.remove(size);
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
            this.VP = null;
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
            if (this.VP != null) {
                int i3 = i + i2;
                for (int size = this.VP.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.VP.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        if (fullSpanItem.mPosition < i3) {
                            this.VP.remove(size);
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
            if (this.VP != null) {
                for (int size = this.VP.size() - 1; size >= 0; size--) {
                    FullSpanItem fullSpanItem = this.VP.get(size);
                    if (fullSpanItem.mPosition >= i) {
                        fullSpanItem.mPosition += i2;
                    }
                }
            }
        }

        private int bV(int i) {
            if (this.VP == null) {
                return -1;
            }
            FullSpanItem bW = bW(i);
            if (bW != null) {
                this.VP.remove(bW);
            }
            int size = this.VP.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (this.VP.get(i2).mPosition >= i) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                this.VP.remove(i2);
                return this.VP.get(i2).mPosition;
            }
            return -1;
        }

        public void a(FullSpanItem fullSpanItem) {
            if (this.VP == null) {
                this.VP = new ArrayList();
            }
            int size = this.VP.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.VP.get(i);
                if (fullSpanItem2.mPosition == fullSpanItem.mPosition) {
                    this.VP.remove(i);
                }
                if (fullSpanItem2.mPosition >= fullSpanItem.mPosition) {
                    this.VP.add(i, fullSpanItem);
                    return;
                }
            }
            this.VP.add(fullSpanItem);
        }

        public FullSpanItem bW(int i) {
            if (this.VP == null) {
                return null;
            }
            for (int size = this.VP.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.VP.get(size);
                if (fullSpanItem.mPosition == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        public FullSpanItem c(int i, int i2, int i3, boolean z) {
            if (this.VP == null) {
                return null;
            }
            int size = this.VP.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.VP.get(i4);
                if (fullSpanItem.mPosition >= i2) {
                    return null;
                }
                if (fullSpanItem.mPosition >= i) {
                    if (i3 == 0 || fullSpanItem.VQ == i3) {
                        return fullSpanItem;
                    }
                    if (z && fullSpanItem.VS) {
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
            int VQ;
            int[] VR;
            boolean VS;
            int mPosition;

            public FullSpanItem(Parcel parcel) {
                this.mPosition = parcel.readInt();
                this.VQ = parcel.readInt();
                this.VS = parcel.readInt() == 1;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.VR = new int[readInt];
                    parcel.readIntArray(this.VR);
                }
            }

            public FullSpanItem() {
            }

            int bX(int i) {
                if (this.VR == null) {
                    return 0;
                }
                return this.VR[i];
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.mPosition);
                parcel.writeInt(this.VQ);
                parcel.writeInt(this.VS ? 1 : 0);
                if (this.VR != null && this.VR.length > 0) {
                    parcel.writeInt(this.VR.length);
                    parcel.writeIntArray(this.VR);
                    return;
                }
                parcel.writeInt(0);
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.mPosition + ", mGapDir=" + this.VQ + ", mHasUnwantedGapAfter=" + this.VS + ", mGapPerSpan=" + Arrays.toString(this.VR) + '}';
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
        boolean PK;
        int Qe;
        boolean Qg;
        boolean VE;
        List<LazySpanLookup.FullSpanItem> VP;
        int VT;
        int VU;
        int[] VV;
        int VW;
        int[] VX;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.Qe = parcel.readInt();
            this.VT = parcel.readInt();
            this.VU = parcel.readInt();
            if (this.VU > 0) {
                this.VV = new int[this.VU];
                parcel.readIntArray(this.VV);
            }
            this.VW = parcel.readInt();
            if (this.VW > 0) {
                this.VX = new int[this.VW];
                parcel.readIntArray(this.VX);
            }
            this.PK = parcel.readInt() == 1;
            this.Qg = parcel.readInt() == 1;
            this.VE = parcel.readInt() == 1;
            this.VP = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.VU = savedState.VU;
            this.Qe = savedState.Qe;
            this.VT = savedState.VT;
            this.VV = savedState.VV;
            this.VW = savedState.VW;
            this.VX = savedState.VX;
            this.PK = savedState.PK;
            this.Qg = savedState.Qg;
            this.VE = savedState.VE;
            this.VP = savedState.VP;
        }

        void ic() {
            this.VV = null;
            this.VU = 0;
            this.VW = 0;
            this.VX = null;
            this.VP = null;
        }

        void id() {
            this.VV = null;
            this.VU = 0;
            this.Qe = -1;
            this.VT = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.Qe);
            parcel.writeInt(this.VT);
            parcel.writeInt(this.VU);
            if (this.VU > 0) {
                parcel.writeIntArray(this.VV);
            }
            parcel.writeInt(this.VW);
            if (this.VW > 0) {
                parcel.writeIntArray(this.VX);
            }
            parcel.writeInt(this.PK ? 1 : 0);
            parcel.writeInt(this.Qg ? 1 : 0);
            parcel.writeInt(this.VE ? 1 : 0);
            parcel.writeList(this.VP);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        boolean PW;
        boolean PX;
        boolean VL;
        int[] VM;
        int mOffset;
        int mPosition;

        public a() {
            reset();
        }

        void reset() {
            this.mPosition = -1;
            this.mOffset = Integer.MIN_VALUE;
            this.PW = false;
            this.VL = false;
            this.PX = false;
            if (this.VM != null) {
                Arrays.fill(this.VM, -1);
            }
        }

        void a(b[] bVarArr) {
            int length = bVarArr.length;
            if (this.VM == null || this.VM.length < length) {
                this.VM = new int[StaggeredGridLayoutManager.this.Vv.length];
            }
            for (int i = 0; i < length; i++) {
                this.VM[i] = bVarArr[i].ca(Integer.MIN_VALUE);
            }
        }

        void gm() {
            this.mOffset = this.PW ? StaggeredGridLayoutManager.this.Vw.getEndAfterPadding() : StaggeredGridLayoutManager.this.Vw.getStartAfterPadding();
        }

        void bP(int i) {
            if (this.PW) {
                this.mOffset = StaggeredGridLayoutManager.this.Vw.getEndAfterPadding() - i;
            } else {
                this.mOffset = StaggeredGridLayoutManager.this.Vw.getStartAfterPadding() + i;
            }
        }
    }
}
