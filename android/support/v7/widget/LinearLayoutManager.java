package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.RestrictTo;
import android.support.v4.media.TransportMediator;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;
/* loaded from: classes2.dex */
public class LinearLayoutManager extends RecyclerView.LayoutManager implements RecyclerView.SmoothScroller.ScrollVectorProvider, ItemTouchHelper.ViewDropHandler {
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;
    int As;
    private b PG;
    OrientationHelper PH;
    private boolean PI;
    private boolean PJ;
    boolean PK;
    private boolean PM;
    int PN;
    int PO;
    private boolean PP;
    SavedState PQ;
    final a PR;
    private final LayoutChunkResult PT;
    private boolean mSmoothScrollbarEnabled;

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.PJ = false;
        this.PK = false;
        this.PM = false;
        this.mSmoothScrollbarEnabled = true;
        this.PN = -1;
        this.PO = Integer.MIN_VALUE;
        this.PQ = null;
        this.PR = new a();
        this.PT = new LayoutChunkResult();
        setOrientation(i);
        setReverseLayout(z);
        setAutoMeasureEnabled(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.PJ = false;
        this.PK = false;
        this.PM = false;
        this.mSmoothScrollbarEnabled = true;
        this.PN = -1;
        this.PO = Integer.MIN_VALUE;
        this.PQ = null;
        this.PR = new a();
        this.PT = new LayoutChunkResult();
        RecyclerView.LayoutManager.Properties properties = getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
        setAutoMeasureEnabled(true);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.PP;
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.PP = z;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.PP) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            AccessibilityRecordCompat asRecord = AccessibilityEventCompat.asRecord(accessibilityEvent);
            asRecord.setFromIndex(findFirstVisibleItemPosition());
            asRecord.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.PQ != null) {
            return new SavedState(this.PQ);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            gg();
            boolean z = this.PI ^ this.PK;
            savedState.Qf = z;
            if (z) {
                View gl = gl();
                savedState.Qe = this.PH.getEndAfterPadding() - this.PH.getDecoratedEnd(gl);
                savedState.Qd = getPosition(gl);
                return savedState;
            }
            View gk = gk();
            savedState.Qd = getPosition(gk);
            savedState.Qe = this.PH.getDecoratedStart(gk) - this.PH.getStartAfterPadding();
            return savedState;
        }
        savedState.bH();
        return savedState;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.PQ = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.As == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.As == 1;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.PM != z) {
            this.PM = z;
            requestLayout();
        }
    }

    public boolean getStackFromEnd() {
        return this.PM;
    }

    public int getOrientation() {
        return this.As;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.As) {
            this.As = i;
            this.PH = null;
            requestLayout();
        }
    }

    private void gf() {
        if (this.As == 1 || !isLayoutRTL()) {
            this.PK = this.PJ;
        } else {
            this.PK = this.PJ ? false : true;
        }
    }

    public boolean getReverseLayout() {
        return this.PJ;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z != this.PJ) {
            this.PJ = z;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    protected int getExtraLayoutSpace(RecyclerView.State state) {
        if (state.hasTargetScrollPosition()) {
            return this.PH.getTotalSpace();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // android.support.v7.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = (i < getPosition(getChildAt(0))) != this.PK ? -1 : 1;
        if (this.As == 0) {
            return new PointF(i2, 0.0f);
        }
        return new PointF(0.0f, i2);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        int i3;
        int i4;
        View findViewByPosition;
        int decoratedStart;
        int i5 = -1;
        if ((this.PQ != null || this.PN != -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        if (this.PQ != null && this.PQ.gp()) {
            this.PN = this.PQ.Qd;
        }
        gg();
        this.PG.Pm = false;
        gf();
        if (!this.PR.PW || this.PN != -1 || this.PQ != null) {
            this.PR.reset();
            this.PR.PV = this.PK ^ this.PM;
            a(recycler, state, this.PR);
            this.PR.PW = true;
        }
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.PG.Qb >= 0) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        int startAfterPadding = i + this.PH.getStartAfterPadding();
        int endPadding = extraLayoutSpace + this.PH.getEndPadding();
        if (state.isPreLayout() && this.PN != -1 && this.PO != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(this.PN)) != null) {
            if (this.PK) {
                decoratedStart = (this.PH.getEndAfterPadding() - this.PH.getDecoratedEnd(findViewByPosition)) - this.PO;
            } else {
                decoratedStart = this.PO - (this.PH.getDecoratedStart(findViewByPosition) - this.PH.getStartAfterPadding());
            }
            if (decoratedStart > 0) {
                startAfterPadding += decoratedStart;
            } else {
                endPadding -= decoratedStart;
            }
        }
        if (this.PR.PV) {
            if (this.PK) {
                i5 = 1;
            }
        } else if (!this.PK) {
            i5 = 1;
        }
        a(recycler, state, this.PR, i5);
        detachAndScrapAttachedViews(recycler);
        this.PG.Pu = gi();
        this.PG.Qa = state.isPreLayout();
        if (this.PR.PV) {
            b(this.PR);
            this.PG.PZ = startAfterPadding;
            a(recycler, this.PG, state, false);
            int i6 = this.PG.mOffset;
            int i7 = this.PG.Po;
            if (this.PG.Pn > 0) {
                endPadding += this.PG.Pn;
            }
            a(this.PR);
            this.PG.PZ = endPadding;
            this.PG.Po += this.PG.Pp;
            a(recycler, this.PG, state, false);
            int i8 = this.PG.mOffset;
            if (this.PG.Pn > 0) {
                int i9 = this.PG.Pn;
                N(i7, i6);
                this.PG.PZ = i9;
                a(recycler, this.PG, state, false);
                i4 = this.PG.mOffset;
            } else {
                i4 = i6;
            }
            i3 = i4;
            i2 = i8;
        } else {
            a(this.PR);
            this.PG.PZ = endPadding;
            a(recycler, this.PG, state, false);
            i2 = this.PG.mOffset;
            int i10 = this.PG.Po;
            if (this.PG.Pn > 0) {
                startAfterPadding += this.PG.Pn;
            }
            b(this.PR);
            this.PG.PZ = startAfterPadding;
            this.PG.Po += this.PG.Pp;
            a(recycler, this.PG, state, false);
            i3 = this.PG.mOffset;
            if (this.PG.Pn > 0) {
                int i11 = this.PG.Pn;
                M(i10, i2);
                this.PG.PZ = i11;
                a(recycler, this.PG, state, false);
                i2 = this.PG.mOffset;
            }
        }
        if (getChildCount() > 0) {
            if (this.PK ^ this.PM) {
                int a2 = a(i2, recycler, state, true);
                int i12 = i3 + a2;
                int b2 = b(i12, recycler, state, false);
                i3 = i12 + b2;
                i2 = i2 + a2 + b2;
            } else {
                int b3 = b(i3, recycler, state, true);
                int i13 = i2 + b3;
                int a3 = a(i13, recycler, state, false);
                i3 = i3 + b3 + a3;
                i2 = i13 + a3;
            }
        }
        a(recycler, state, i3, i2);
        if (!state.isPreLayout()) {
            this.PH.onLayoutComplete();
        } else {
            this.PR.reset();
        }
        this.PI = this.PM;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.PQ = null;
        this.PN = -1;
        this.PO = Integer.MIN_VALUE;
        this.PR.reset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.Recycler recycler, RecyclerView.State state, a aVar, int i) {
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
        int decoratedMeasurement;
        int i3;
        if (state.willRunPredictiveAnimations() && getChildCount() != 0 && !state.isPreLayout() && supportsPredictiveItemAnimations()) {
            int i4 = 0;
            int i5 = 0;
            List<RecyclerView.ViewHolder> scrapList = recycler.getScrapList();
            int size = scrapList.size();
            int position = getPosition(getChildAt(0));
            int i6 = 0;
            while (i6 < size) {
                RecyclerView.ViewHolder viewHolder = scrapList.get(i6);
                if (viewHolder.isRemoved()) {
                    decoratedMeasurement = i5;
                    i3 = i4;
                } else {
                    if (((viewHolder.getLayoutPosition() < position) != this.PK ? (char) 65535 : (char) 1) == 65535) {
                        i3 = this.PH.getDecoratedMeasurement(viewHolder.itemView) + i4;
                        decoratedMeasurement = i5;
                    } else {
                        decoratedMeasurement = this.PH.getDecoratedMeasurement(viewHolder.itemView) + i5;
                        i3 = i4;
                    }
                }
                i6++;
                i4 = i3;
                i5 = decoratedMeasurement;
            }
            this.PG.Qc = scrapList;
            if (i4 > 0) {
                N(getPosition(gk()), i);
                this.PG.PZ = i4;
                this.PG.Pn = 0;
                this.PG.go();
                a(recycler, this.PG, state, false);
            }
            if (i5 > 0) {
                M(getPosition(gl()), i2);
                this.PG.PZ = i5;
                this.PG.Pn = 0;
                this.PG.go();
                a(recycler, this.PG, state, false);
            }
            this.PG.Qc = null;
        }
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state, a aVar) {
        if (!a(state, aVar) && !b(recycler, state, aVar)) {
            aVar.gm();
            aVar.mPosition = this.PM ? state.getItemCount() - 1 : 0;
        }
    }

    private boolean b(RecyclerView.Recycler recycler, RecyclerView.State state, a aVar) {
        View b2;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.a(focusedChild, state)) {
            aVar.aj(focusedChild);
            return true;
        } else if (this.PI == this.PM) {
            if (aVar.PV) {
                b2 = a(recycler, state);
            } else {
                b2 = b(recycler, state);
            }
            if (b2 != null) {
                aVar.ak(b2);
                if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                    if (this.PH.getDecoratedStart(b2) >= this.PH.getEndAfterPadding() || this.PH.getDecoratedEnd(b2) < this.PH.getStartAfterPadding()) {
                        z = true;
                    }
                    if (z) {
                        if (aVar.PV) {
                            startAfterPadding = this.PH.getEndAfterPadding();
                        } else {
                            startAfterPadding = this.PH.getStartAfterPadding();
                        }
                        aVar.PU = startAfterPadding;
                    }
                }
                return true;
            }
            return false;
        } else {
            return false;
        }
    }

    private boolean a(RecyclerView.State state, a aVar) {
        int decoratedStart;
        if (state.isPreLayout() || this.PN == -1) {
            return false;
        }
        if (this.PN < 0 || this.PN >= state.getItemCount()) {
            this.PN = -1;
            this.PO = Integer.MIN_VALUE;
            return false;
        }
        aVar.mPosition = this.PN;
        if (this.PQ != null && this.PQ.gp()) {
            aVar.PV = this.PQ.Qf;
            if (aVar.PV) {
                aVar.PU = this.PH.getEndAfterPadding() - this.PQ.Qe;
                return true;
            }
            aVar.PU = this.PH.getStartAfterPadding() + this.PQ.Qe;
            return true;
        } else if (this.PO == Integer.MIN_VALUE) {
            View findViewByPosition = findViewByPosition(this.PN);
            if (findViewByPosition != null) {
                if (this.PH.getDecoratedMeasurement(findViewByPosition) > this.PH.getTotalSpace()) {
                    aVar.gm();
                    return true;
                } else if (this.PH.getDecoratedStart(findViewByPosition) - this.PH.getStartAfterPadding() < 0) {
                    aVar.PU = this.PH.getStartAfterPadding();
                    aVar.PV = false;
                    return true;
                } else if (this.PH.getEndAfterPadding() - this.PH.getDecoratedEnd(findViewByPosition) < 0) {
                    aVar.PU = this.PH.getEndAfterPadding();
                    aVar.PV = true;
                    return true;
                } else {
                    if (aVar.PV) {
                        decoratedStart = this.PH.getDecoratedEnd(findViewByPosition) + this.PH.getTotalSpaceChange();
                    } else {
                        decoratedStart = this.PH.getDecoratedStart(findViewByPosition);
                    }
                    aVar.PU = decoratedStart;
                    return true;
                }
            }
            if (getChildCount() > 0) {
                aVar.PV = (this.PN < getPosition(getChildAt(0))) == this.PK;
            }
            aVar.gm();
            return true;
        } else {
            aVar.PV = this.PK;
            if (this.PK) {
                aVar.PU = this.PH.getEndAfterPadding() - this.PO;
                return true;
            }
            aVar.PU = this.PH.getStartAfterPadding() + this.PO;
            return true;
        }
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int endAfterPadding2 = this.PH.getEndAfterPadding() - i;
        if (endAfterPadding2 > 0) {
            int i2 = -a(-endAfterPadding2, recycler, state);
            int i3 = i + i2;
            if (z && (endAfterPadding = this.PH.getEndAfterPadding() - i3) > 0) {
                this.PH.offsetChildren(endAfterPadding);
                return i2 + endAfterPadding;
            }
            return i2;
        }
        return 0;
    }

    private int b(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int startAfterPadding2 = i - this.PH.getStartAfterPadding();
        if (startAfterPadding2 > 0) {
            int i2 = -a(startAfterPadding2, recycler, state);
            int i3 = i + i2;
            if (z && (startAfterPadding = i3 - this.PH.getStartAfterPadding()) > 0) {
                this.PH.offsetChildren(-startAfterPadding);
                return i2 - startAfterPadding;
            }
            return i2;
        }
        return 0;
    }

    private void a(a aVar) {
        M(aVar.mPosition, aVar.PU);
    }

    private void M(int i, int i2) {
        this.PG.Pn = this.PH.getEndAfterPadding() - i2;
        this.PG.Pp = this.PK ? -1 : 1;
        this.PG.Po = i;
        this.PG.Pq = 1;
        this.PG.mOffset = i2;
        this.PG.PY = Integer.MIN_VALUE;
    }

    private void b(a aVar) {
        N(aVar.mPosition, aVar.PU);
    }

    private void N(int i, int i2) {
        this.PG.Pn = i2 - this.PH.getStartAfterPadding();
        this.PG.Po = i;
        this.PG.Pp = this.PK ? 1 : -1;
        this.PG.Pq = -1;
        this.PG.mOffset = i2;
        this.PG.PY = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gg() {
        if (this.PG == null) {
            this.PG = gh();
        }
        if (this.PH == null) {
            this.PH = OrientationHelper.createOrientationHelper(this, this.As);
        }
    }

    b gh() {
        return new b();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.PN = i;
        this.PO = Integer.MIN_VALUE;
        if (this.PQ != null) {
            this.PQ.bH();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.PN = i;
        this.PO = i2;
        if (this.PQ != null) {
            this.PQ.bH();
        }
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.As == 1) {
            return 0;
        }
        return a(i, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.As == 0) {
            return 0;
        }
        return a(i, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return b(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return b(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return c(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return c(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return d(state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return d(state);
    }

    private int b(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        gg();
        return q.a(state, this.PH, c(!this.mSmoothScrollbarEnabled, true), d(this.mSmoothScrollbarEnabled ? false : true, true), this, this.mSmoothScrollbarEnabled, this.PK);
    }

    private int c(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        gg();
        return q.a(state, this.PH, c(!this.mSmoothScrollbarEnabled, true), d(this.mSmoothScrollbarEnabled ? false : true, true), this, this.mSmoothScrollbarEnabled);
    }

    private int d(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        gg();
        return q.b(state, this.PH, c(!this.mSmoothScrollbarEnabled, true), d(this.mSmoothScrollbarEnabled ? false : true, true), this, this.mSmoothScrollbarEnabled);
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    private void a(int i, int i2, boolean z, RecyclerView.State state) {
        int startAfterPadding;
        this.PG.Pu = gi();
        this.PG.PZ = getExtraLayoutSpace(state);
        this.PG.Pq = i;
        if (i == 1) {
            this.PG.PZ += this.PH.getEndPadding();
            View gl = gl();
            this.PG.Pp = this.PK ? -1 : 1;
            this.PG.Po = getPosition(gl) + this.PG.Pp;
            this.PG.mOffset = this.PH.getDecoratedEnd(gl);
            startAfterPadding = this.PH.getDecoratedEnd(gl) - this.PH.getEndAfterPadding();
        } else {
            View gk = gk();
            this.PG.PZ += this.PH.getStartAfterPadding();
            this.PG.Pp = this.PK ? 1 : -1;
            this.PG.Po = getPosition(gk) + this.PG.Pp;
            this.PG.mOffset = this.PH.getDecoratedStart(gk);
            startAfterPadding = (-this.PH.getDecoratedStart(gk)) + this.PH.getStartAfterPadding();
        }
        this.PG.Pn = i2;
        if (z) {
            this.PG.Pn -= startAfterPadding;
        }
        this.PG.PY = startAfterPadding;
    }

    boolean gi() {
        return this.PH.getMode() == 0 && this.PH.getEnd() == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    int ge() {
        return 1;
    }

    int a(RecyclerView.State state, b bVar, int[] iArr) {
        int i = bVar.Po;
        if (i < 0 || i >= state.getItemCount()) {
            return 0;
        }
        iArr[0] = i;
        return 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    int a(int i, int i2, RecyclerView.State state, int[] iArr) {
        if (this.As != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        a(i > 0 ? 1 : -1, Math.abs(i), true, state);
        return a(state, this.PG, iArr);
    }

    int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.PG.Pm = true;
        gg();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, state);
        int a2 = this.PG.PY + a(recycler, this.PG, state, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i = i2 * a2;
        }
        this.PH.offsetChildren(-i);
        this.PG.Qb = i;
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.PQ == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    private void a(RecyclerView.Recycler recycler, int i, int i2) {
        if (i != i2) {
            if (i2 > i) {
                for (int i3 = i2 - 1; i3 >= i; i3--) {
                    removeAndRecycleViewAt(i3, recycler);
                }
                return;
            }
            while (i > i2) {
                removeAndRecycleViewAt(i, recycler);
                i--;
            }
        }
    }

    private void a(RecyclerView.Recycler recycler, int i) {
        if (i >= 0) {
            int childCount = getChildCount();
            if (this.PK) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    View childAt = getChildAt(i2);
                    if (this.PH.getDecoratedEnd(childAt) > i || this.PH.getTransformedEndWithDecoration(childAt) > i) {
                        a(recycler, childCount - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (this.PH.getDecoratedEnd(childAt2) > i || this.PH.getTransformedEndWithDecoration(childAt2) > i) {
                    a(recycler, 0, i3);
                    return;
                }
            }
        }
    }

    private void b(RecyclerView.Recycler recycler, int i) {
        int childCount = getChildCount();
        if (i >= 0) {
            int end = this.PH.getEnd() - i;
            if (this.PK) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if (this.PH.getDecoratedStart(childAt) < end || this.PH.getTransformedStartWithDecoration(childAt) < end) {
                        a(recycler, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt2 = getChildAt(i3);
                if (this.PH.getDecoratedStart(childAt2) < end || this.PH.getTransformedStartWithDecoration(childAt2) < end) {
                    a(recycler, childCount - 1, i3);
                    return;
                }
            }
        }
    }

    private void a(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.Pm && !bVar.Pu) {
            if (bVar.Pq == -1) {
                b(recycler, bVar.PY);
            } else {
                a(recycler, bVar.PY);
            }
        }
    }

    int a(RecyclerView.Recycler recycler, b bVar, RecyclerView.State state, boolean z) {
        int i = bVar.Pn;
        if (bVar.PY != Integer.MIN_VALUE) {
            if (bVar.Pn < 0) {
                bVar.PY += bVar.Pn;
            }
            a(recycler, bVar);
        }
        int i2 = bVar.Pn + bVar.PZ;
        LayoutChunkResult layoutChunkResult = this.PT;
        while (true) {
            if ((!bVar.Pu && i2 <= 0) || !bVar.a(state)) {
                break;
            }
            layoutChunkResult.resetInternal();
            a(recycler, state, bVar, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                bVar.mOffset += layoutChunkResult.mConsumed * bVar.Pq;
                if (!layoutChunkResult.mIgnoreConsumed || this.PG.Qc != null || !state.isPreLayout()) {
                    bVar.Pn -= layoutChunkResult.mConsumed;
                    i2 -= layoutChunkResult.mConsumed;
                }
                if (bVar.PY != Integer.MIN_VALUE) {
                    bVar.PY += layoutChunkResult.mConsumed;
                    if (bVar.Pn < 0) {
                        bVar.PY += bVar.Pn;
                    }
                    a(recycler, bVar);
                }
                if (z && layoutChunkResult.mFocusable) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - bVar.Pn;
    }

    void a(RecyclerView.Recycler recycler, RecyclerView.State state, b bVar, LayoutChunkResult layoutChunkResult) {
        int paddingTop;
        int decoratedMeasurementInOther;
        int i;
        int i2;
        int decoratedMeasurementInOther2;
        View a2 = bVar.a(recycler);
        if (a2 == null) {
            layoutChunkResult.mFinished = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) a2.getLayoutParams();
        if (bVar.Qc == null) {
            if (this.PK == (bVar.Pq == -1)) {
                addView(a2);
            } else {
                addView(a2, 0);
            }
        } else {
            if (this.PK == (bVar.Pq == -1)) {
                addDisappearingView(a2);
            } else {
                addDisappearingView(a2, 0);
            }
        }
        measureChildWithMargins(a2, 0, 0);
        layoutChunkResult.mConsumed = this.PH.getDecoratedMeasurement(a2);
        if (this.As == 1) {
            if (isLayoutRTL()) {
                decoratedMeasurementInOther2 = getWidth() - getPaddingRight();
                i = decoratedMeasurementInOther2 - this.PH.getDecoratedMeasurementInOther(a2);
            } else {
                i = getPaddingLeft();
                decoratedMeasurementInOther2 = this.PH.getDecoratedMeasurementInOther(a2) + i;
            }
            if (bVar.Pq == -1) {
                decoratedMeasurementInOther = bVar.mOffset;
                paddingTop = bVar.mOffset - layoutChunkResult.mConsumed;
                i2 = decoratedMeasurementInOther2;
            } else {
                paddingTop = bVar.mOffset;
                decoratedMeasurementInOther = layoutChunkResult.mConsumed + bVar.mOffset;
                i2 = decoratedMeasurementInOther2;
            }
        } else {
            paddingTop = getPaddingTop();
            decoratedMeasurementInOther = paddingTop + this.PH.getDecoratedMeasurementInOther(a2);
            if (bVar.Pq == -1) {
                int i3 = bVar.mOffset;
                i = bVar.mOffset - layoutChunkResult.mConsumed;
                i2 = i3;
            } else {
                i = bVar.mOffset;
                i2 = bVar.mOffset + layoutChunkResult.mConsumed;
            }
        }
        layoutDecoratedWithMargins(a2, i, paddingTop, i2, decoratedMeasurementInOther);
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            layoutChunkResult.mIgnoreConsumed = true;
        }
        layoutChunkResult.mFocusable = a2.isFocusable();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    boolean gj() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hf()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bo(int i) {
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

    private View gk() {
        return getChildAt(this.PK ? getChildCount() - 1 : 0);
    }

    private View gl() {
        return getChildAt(this.PK ? 0 : getChildCount() - 1);
    }

    private View c(boolean z, boolean z2) {
        return this.PK ? c(getChildCount() - 1, -1, z, z2) : c(0, getChildCount(), z, z2);
    }

    private View d(boolean z, boolean z2) {
        return this.PK ? c(0, getChildCount(), z, z2) : c(getChildCount() - 1, -1, z, z2);
    }

    private View a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.PK ? c(recycler, state) : d(recycler, state);
    }

    private View b(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.PK ? d(recycler, state) : c(recycler, state);
    }

    private View c(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return a(recycler, state, 0, getChildCount(), state.getItemCount());
    }

    private View d(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return a(recycler, state, getChildCount() - 1, -1, state.getItemCount());
    }

    View a(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, int i3) {
        View view;
        View view2 = null;
        gg();
        int startAfterPadding = this.PH.getStartAfterPadding();
        int endAfterPadding = this.PH.getEndAfterPadding();
        int i4 = i2 > i ? 1 : -1;
        View view3 = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int position = getPosition(childAt);
            if (position >= 0 && position < i3) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view3 == null) {
                        view = view2;
                    }
                } else if (this.PH.getDecoratedStart(childAt) < endAfterPadding && this.PH.getDecoratedEnd(childAt) >= startAfterPadding) {
                    return childAt;
                } else {
                    if (view2 == null) {
                        view = childAt;
                        childAt = view3;
                    }
                }
                i += i4;
                view2 = view;
                view3 = childAt;
            }
            view = view2;
            childAt = view3;
            i += i4;
            view2 = view;
            view3 = childAt;
        }
        if (view2 == null) {
            view2 = view3;
        }
        return view2;
    }

    public int findFirstVisibleItemPosition() {
        View c = c(0, getChildCount(), false, true);
        if (c == null) {
            return -1;
        }
        return getPosition(c);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View c = c(0, getChildCount(), true, false);
        if (c == null) {
            return -1;
        }
        return getPosition(c);
    }

    public int findLastVisibleItemPosition() {
        View c = c(getChildCount() - 1, -1, false, true);
        if (c == null) {
            return -1;
        }
        return getPosition(c);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View c = c(getChildCount() - 1, -1, true, false);
        if (c == null) {
            return -1;
        }
        return getPosition(c);
    }

    View c(int i, int i2, boolean z, boolean z2) {
        gg();
        int startAfterPadding = this.PH.getStartAfterPadding();
        int endAfterPadding = this.PH.getEndAfterPadding();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int decoratedStart = this.PH.getDecoratedStart(childAt);
            int decoratedEnd = this.PH.getDecoratedEnd(childAt);
            if (decoratedStart < endAfterPadding && decoratedEnd > startAfterPadding) {
                if (z) {
                    if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                        if (z2 && view == null) {
                            i += i3;
                            view = childAt;
                        }
                    } else {
                        return childAt;
                    }
                } else {
                    return childAt;
                }
            }
            childAt = view;
            i += i3;
            view = childAt;
        }
        return view;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int bo;
        View a2;
        View gl;
        gf();
        if (getChildCount() == 0 || (bo = bo(i)) == Integer.MIN_VALUE) {
            return null;
        }
        gg();
        if (bo == -1) {
            a2 = b(recycler, state);
        } else {
            a2 = a(recycler, state);
        }
        if (a2 != null) {
            gg();
            a(bo, (int) (0.33333334f * this.PH.getTotalSpace()), false, state);
            this.PG.PY = Integer.MIN_VALUE;
            this.PG.Pm = false;
            a(recycler, this.PG, state, true);
            if (bo == -1) {
                gl = gk();
            } else {
                gl = gl();
            }
            if (gl == a2 || !gl.isFocusable()) {
                return null;
            }
            return gl;
        }
        return null;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.PQ == null && this.PI == this.PM;
    }

    @Override // android.support.v7.widget.helper.ItemTouchHelper.ViewDropHandler
    @RestrictTo
    public void prepareForDrop(View view, View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        gg();
        gf();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        boolean z = position < position2 ? true : true;
        if (this.PK) {
            if (z) {
                scrollToPositionWithOffset(position2, this.PH.getEndAfterPadding() - (this.PH.getDecoratedStart(view2) + this.PH.getDecoratedMeasurement(view)));
            } else {
                scrollToPositionWithOffset(position2, this.PH.getEndAfterPadding() - this.PH.getDecoratedEnd(view2));
            }
        } else if (z) {
            scrollToPositionWithOffset(position2, this.PH.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.PH.getDecoratedEnd(view2) - this.PH.getDecoratedMeasurement(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {
        int PY;
        int Pn;
        int Po;
        int Pp;
        int Pq;
        boolean Pu;
        int Qb;
        int mOffset;
        boolean Pm = true;
        int PZ = 0;
        boolean Qa = false;
        List<RecyclerView.ViewHolder> Qc = null;

        b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(RecyclerView.State state) {
            return this.Po >= 0 && this.Po < state.getItemCount();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View a(RecyclerView.Recycler recycler) {
            if (this.Qc != null) {
                return gn();
            }
            View viewForPosition = recycler.getViewForPosition(this.Po);
            this.Po += this.Pp;
            return viewForPosition;
        }

        private View gn() {
            int size = this.Qc.size();
            for (int i = 0; i < size; i++) {
                View view = this.Qc.get(i).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.isItemRemoved() && this.Po == layoutParams.getViewLayoutPosition()) {
                    al(view);
                    return view;
                }
            }
            return null;
        }

        public void go() {
            al(null);
        }

        public void al(View view) {
            View am = am(view);
            if (am == null) {
                this.Po = -1;
            } else {
                this.Po = ((RecyclerView.LayoutParams) am.getLayoutParams()).getViewLayoutPosition();
            }
        }

        public View am(View view) {
            int i;
            View view2;
            int size = this.Qc.size();
            View view3 = null;
            int i2 = Integer.MAX_VALUE;
            int i3 = 0;
            while (i3 < size) {
                View view4 = this.Qc.get(i3).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view4.getLayoutParams();
                if (view4 != view) {
                    if (layoutParams.isItemRemoved()) {
                        i = i2;
                        view2 = view3;
                    } else {
                        i = (layoutParams.getViewLayoutPosition() - this.Po) * this.Pp;
                        if (i < 0) {
                            i = i2;
                            view2 = view3;
                        } else if (i < i2) {
                            if (i == 0) {
                                return view4;
                            }
                            view2 = view4;
                        }
                    }
                    i3++;
                    view3 = view2;
                    i2 = i;
                }
                i = i2;
                view2 = view3;
                i3++;
                view3 = view2;
                i2 = i;
            }
            return view3;
        }
    }

    @RestrictTo
    /* loaded from: classes2.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.LinearLayoutManager.SavedState.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: p */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // android.os.Parcelable.Creator
            /* renamed from: bp */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        int Qd;
        int Qe;
        boolean Qf;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.Qd = parcel.readInt();
            this.Qe = parcel.readInt();
            this.Qf = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.Qd = savedState.Qd;
            this.Qe = savedState.Qe;
            this.Qf = savedState.Qf;
        }

        boolean gp() {
            return this.Qd >= 0;
        }

        void bH() {
            this.Qd = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.Qd);
            parcel.writeInt(this.Qe);
            parcel.writeInt(this.Qf ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        int PU;
        boolean PV;
        boolean PW;
        int mPosition;

        a() {
            reset();
        }

        void reset() {
            this.mPosition = -1;
            this.PU = Integer.MIN_VALUE;
            this.PV = false;
            this.PW = false;
        }

        void gm() {
            int startAfterPadding;
            if (this.PV) {
                startAfterPadding = LinearLayoutManager.this.PH.getEndAfterPadding();
            } else {
                startAfterPadding = LinearLayoutManager.this.PH.getStartAfterPadding();
            }
            this.PU = startAfterPadding;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.PU + ", mLayoutFromEnd=" + this.PV + ", mValid=" + this.PW + '}';
        }

        boolean a(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < state.getItemCount();
        }

        public void aj(View view) {
            int totalSpaceChange = LinearLayoutManager.this.PH.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                ak(view);
                return;
            }
            this.mPosition = LinearLayoutManager.this.getPosition(view);
            if (this.PV) {
                int endAfterPadding = (LinearLayoutManager.this.PH.getEndAfterPadding() - totalSpaceChange) - LinearLayoutManager.this.PH.getDecoratedEnd(view);
                this.PU = LinearLayoutManager.this.PH.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    int decoratedMeasurement = this.PU - LinearLayoutManager.this.PH.getDecoratedMeasurement(view);
                    int startAfterPadding = LinearLayoutManager.this.PH.getStartAfterPadding();
                    int min = decoratedMeasurement - (startAfterPadding + Math.min(LinearLayoutManager.this.PH.getDecoratedStart(view) - startAfterPadding, 0));
                    if (min < 0) {
                        this.PU = Math.min(endAfterPadding, -min) + this.PU;
                        return;
                    }
                    return;
                }
                return;
            }
            int decoratedStart = LinearLayoutManager.this.PH.getDecoratedStart(view);
            int startAfterPadding2 = decoratedStart - LinearLayoutManager.this.PH.getStartAfterPadding();
            this.PU = decoratedStart;
            if (startAfterPadding2 > 0) {
                int endAfterPadding2 = (LinearLayoutManager.this.PH.getEndAfterPadding() - Math.min(0, (LinearLayoutManager.this.PH.getEndAfterPadding() - totalSpaceChange) - LinearLayoutManager.this.PH.getDecoratedEnd(view))) - (decoratedStart + LinearLayoutManager.this.PH.getDecoratedMeasurement(view));
                if (endAfterPadding2 < 0) {
                    this.PU -= Math.min(startAfterPadding2, -endAfterPadding2);
                }
            }
        }

        public void ak(View view) {
            if (this.PV) {
                this.PU = LinearLayoutManager.this.PH.getDecoratedEnd(view) + LinearLayoutManager.this.PH.getTotalSpaceChange();
            } else {
                this.PU = LinearLayoutManager.this.PH.getDecoratedStart(view);
            }
            this.mPosition = LinearLayoutManager.this.getPosition(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class LayoutChunkResult {
        public int mConsumed;
        public boolean mFinished;
        public boolean mFocusable;
        public boolean mIgnoreConsumed;

        protected LayoutChunkResult() {
        }

        void resetInternal() {
            this.mConsumed = 0;
            this.mFinished = false;
            this.mIgnoreConsumed = false;
            this.mFocusable = false;
        }
    }
}
