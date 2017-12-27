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
    int At;
    private b PH;
    OrientationHelper PI;
    private boolean PJ;
    private boolean PK;
    boolean PM;
    private boolean PN;
    int PO;
    int PP;
    private boolean PQ;
    SavedState PR;
    final a PT;
    private final LayoutChunkResult PU;
    private boolean mSmoothScrollbarEnabled;

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.PK = false;
        this.PM = false;
        this.PN = false;
        this.mSmoothScrollbarEnabled = true;
        this.PO = -1;
        this.PP = Integer.MIN_VALUE;
        this.PR = null;
        this.PT = new a();
        this.PU = new LayoutChunkResult();
        setOrientation(i);
        setReverseLayout(z);
        setAutoMeasureEnabled(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.PK = false;
        this.PM = false;
        this.PN = false;
        this.mSmoothScrollbarEnabled = true;
        this.PO = -1;
        this.PP = Integer.MIN_VALUE;
        this.PR = null;
        this.PT = new a();
        this.PU = new LayoutChunkResult();
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
        return this.PQ;
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.PQ = z;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.PQ) {
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
        if (this.PR != null) {
            return new SavedState(this.PR);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            gg();
            boolean z = this.PJ ^ this.PM;
            savedState.Qg = z;
            if (z) {
                View gl = gl();
                savedState.Qf = this.PI.getEndAfterPadding() - this.PI.getDecoratedEnd(gl);
                savedState.Qe = getPosition(gl);
                return savedState;
            }
            View gk = gk();
            savedState.Qe = getPosition(gk);
            savedState.Qf = this.PI.getDecoratedStart(gk) - this.PI.getStartAfterPadding();
            return savedState;
        }
        savedState.bH();
        return savedState;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.PR = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.At == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.At == 1;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.PN != z) {
            this.PN = z;
            requestLayout();
        }
    }

    public boolean getStackFromEnd() {
        return this.PN;
    }

    public int getOrientation() {
        return this.At;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.At) {
            this.At = i;
            this.PI = null;
            requestLayout();
        }
    }

    private void gf() {
        if (this.At == 1 || !isLayoutRTL()) {
            this.PM = this.PK;
        } else {
            this.PM = this.PK ? false : true;
        }
    }

    public boolean getReverseLayout() {
        return this.PK;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z != this.PK) {
            this.PK = z;
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
            return this.PI.getTotalSpace();
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
        int i2 = (i < getPosition(getChildAt(0))) != this.PM ? -1 : 1;
        if (this.At == 0) {
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
        if ((this.PR != null || this.PO != -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        if (this.PR != null && this.PR.gp()) {
            this.PO = this.PR.Qe;
        }
        gg();
        this.PH.Pn = false;
        gf();
        if (!this.PT.PX || this.PO != -1 || this.PR != null) {
            this.PT.reset();
            this.PT.PW = this.PM ^ this.PN;
            a(recycler, state, this.PT);
            this.PT.PX = true;
        }
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.PH.Qc >= 0) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        int startAfterPadding = i + this.PI.getStartAfterPadding();
        int endPadding = extraLayoutSpace + this.PI.getEndPadding();
        if (state.isPreLayout() && this.PO != -1 && this.PP != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(this.PO)) != null) {
            if (this.PM) {
                decoratedStart = (this.PI.getEndAfterPadding() - this.PI.getDecoratedEnd(findViewByPosition)) - this.PP;
            } else {
                decoratedStart = this.PP - (this.PI.getDecoratedStart(findViewByPosition) - this.PI.getStartAfterPadding());
            }
            if (decoratedStart > 0) {
                startAfterPadding += decoratedStart;
            } else {
                endPadding -= decoratedStart;
            }
        }
        if (this.PT.PW) {
            if (this.PM) {
                i5 = 1;
            }
        } else if (!this.PM) {
            i5 = 1;
        }
        a(recycler, state, this.PT, i5);
        detachAndScrapAttachedViews(recycler);
        this.PH.Pv = gi();
        this.PH.Qb = state.isPreLayout();
        if (this.PT.PW) {
            b(this.PT);
            this.PH.Qa = startAfterPadding;
            a(recycler, this.PH, state, false);
            int i6 = this.PH.mOffset;
            int i7 = this.PH.Pp;
            if (this.PH.Po > 0) {
                endPadding += this.PH.Po;
            }
            a(this.PT);
            this.PH.Qa = endPadding;
            this.PH.Pp += this.PH.Pq;
            a(recycler, this.PH, state, false);
            int i8 = this.PH.mOffset;
            if (this.PH.Po > 0) {
                int i9 = this.PH.Po;
                N(i7, i6);
                this.PH.Qa = i9;
                a(recycler, this.PH, state, false);
                i4 = this.PH.mOffset;
            } else {
                i4 = i6;
            }
            i3 = i4;
            i2 = i8;
        } else {
            a(this.PT);
            this.PH.Qa = endPadding;
            a(recycler, this.PH, state, false);
            i2 = this.PH.mOffset;
            int i10 = this.PH.Pp;
            if (this.PH.Po > 0) {
                startAfterPadding += this.PH.Po;
            }
            b(this.PT);
            this.PH.Qa = startAfterPadding;
            this.PH.Pp += this.PH.Pq;
            a(recycler, this.PH, state, false);
            i3 = this.PH.mOffset;
            if (this.PH.Po > 0) {
                int i11 = this.PH.Po;
                M(i10, i2);
                this.PH.Qa = i11;
                a(recycler, this.PH, state, false);
                i2 = this.PH.mOffset;
            }
        }
        if (getChildCount() > 0) {
            if (this.PM ^ this.PN) {
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
            this.PI.onLayoutComplete();
        } else {
            this.PT.reset();
        }
        this.PJ = this.PN;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.PR = null;
        this.PO = -1;
        this.PP = Integer.MIN_VALUE;
        this.PT.reset();
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
                    if (((viewHolder.getLayoutPosition() < position) != this.PM ? (char) 65535 : (char) 1) == 65535) {
                        i3 = this.PI.getDecoratedMeasurement(viewHolder.itemView) + i4;
                        decoratedMeasurement = i5;
                    } else {
                        decoratedMeasurement = this.PI.getDecoratedMeasurement(viewHolder.itemView) + i5;
                        i3 = i4;
                    }
                }
                i6++;
                i4 = i3;
                i5 = decoratedMeasurement;
            }
            this.PH.Qd = scrapList;
            if (i4 > 0) {
                N(getPosition(gk()), i);
                this.PH.Qa = i4;
                this.PH.Po = 0;
                this.PH.go();
                a(recycler, this.PH, state, false);
            }
            if (i5 > 0) {
                M(getPosition(gl()), i2);
                this.PH.Qa = i5;
                this.PH.Po = 0;
                this.PH.go();
                a(recycler, this.PH, state, false);
            }
            this.PH.Qd = null;
        }
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state, a aVar) {
        if (!a(state, aVar) && !b(recycler, state, aVar)) {
            aVar.gm();
            aVar.mPosition = this.PN ? state.getItemCount() - 1 : 0;
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
        } else if (this.PJ == this.PN) {
            if (aVar.PW) {
                b2 = a(recycler, state);
            } else {
                b2 = b(recycler, state);
            }
            if (b2 != null) {
                aVar.ak(b2);
                if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                    if (this.PI.getDecoratedStart(b2) >= this.PI.getEndAfterPadding() || this.PI.getDecoratedEnd(b2) < this.PI.getStartAfterPadding()) {
                        z = true;
                    }
                    if (z) {
                        if (aVar.PW) {
                            startAfterPadding = this.PI.getEndAfterPadding();
                        } else {
                            startAfterPadding = this.PI.getStartAfterPadding();
                        }
                        aVar.PV = startAfterPadding;
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
        if (state.isPreLayout() || this.PO == -1) {
            return false;
        }
        if (this.PO < 0 || this.PO >= state.getItemCount()) {
            this.PO = -1;
            this.PP = Integer.MIN_VALUE;
            return false;
        }
        aVar.mPosition = this.PO;
        if (this.PR != null && this.PR.gp()) {
            aVar.PW = this.PR.Qg;
            if (aVar.PW) {
                aVar.PV = this.PI.getEndAfterPadding() - this.PR.Qf;
                return true;
            }
            aVar.PV = this.PI.getStartAfterPadding() + this.PR.Qf;
            return true;
        } else if (this.PP == Integer.MIN_VALUE) {
            View findViewByPosition = findViewByPosition(this.PO);
            if (findViewByPosition != null) {
                if (this.PI.getDecoratedMeasurement(findViewByPosition) > this.PI.getTotalSpace()) {
                    aVar.gm();
                    return true;
                } else if (this.PI.getDecoratedStart(findViewByPosition) - this.PI.getStartAfterPadding() < 0) {
                    aVar.PV = this.PI.getStartAfterPadding();
                    aVar.PW = false;
                    return true;
                } else if (this.PI.getEndAfterPadding() - this.PI.getDecoratedEnd(findViewByPosition) < 0) {
                    aVar.PV = this.PI.getEndAfterPadding();
                    aVar.PW = true;
                    return true;
                } else {
                    if (aVar.PW) {
                        decoratedStart = this.PI.getDecoratedEnd(findViewByPosition) + this.PI.getTotalSpaceChange();
                    } else {
                        decoratedStart = this.PI.getDecoratedStart(findViewByPosition);
                    }
                    aVar.PV = decoratedStart;
                    return true;
                }
            }
            if (getChildCount() > 0) {
                aVar.PW = (this.PO < getPosition(getChildAt(0))) == this.PM;
            }
            aVar.gm();
            return true;
        } else {
            aVar.PW = this.PM;
            if (this.PM) {
                aVar.PV = this.PI.getEndAfterPadding() - this.PP;
                return true;
            }
            aVar.PV = this.PI.getStartAfterPadding() + this.PP;
            return true;
        }
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int endAfterPadding2 = this.PI.getEndAfterPadding() - i;
        if (endAfterPadding2 > 0) {
            int i2 = -a(-endAfterPadding2, recycler, state);
            int i3 = i + i2;
            if (z && (endAfterPadding = this.PI.getEndAfterPadding() - i3) > 0) {
                this.PI.offsetChildren(endAfterPadding);
                return i2 + endAfterPadding;
            }
            return i2;
        }
        return 0;
    }

    private int b(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int startAfterPadding2 = i - this.PI.getStartAfterPadding();
        if (startAfterPadding2 > 0) {
            int i2 = -a(startAfterPadding2, recycler, state);
            int i3 = i + i2;
            if (z && (startAfterPadding = i3 - this.PI.getStartAfterPadding()) > 0) {
                this.PI.offsetChildren(-startAfterPadding);
                return i2 - startAfterPadding;
            }
            return i2;
        }
        return 0;
    }

    private void a(a aVar) {
        M(aVar.mPosition, aVar.PV);
    }

    private void M(int i, int i2) {
        this.PH.Po = this.PI.getEndAfterPadding() - i2;
        this.PH.Pq = this.PM ? -1 : 1;
        this.PH.Pp = i;
        this.PH.Pr = 1;
        this.PH.mOffset = i2;
        this.PH.PZ = Integer.MIN_VALUE;
    }

    private void b(a aVar) {
        N(aVar.mPosition, aVar.PV);
    }

    private void N(int i, int i2) {
        this.PH.Po = i2 - this.PI.getStartAfterPadding();
        this.PH.Pp = i;
        this.PH.Pq = this.PM ? 1 : -1;
        this.PH.Pr = -1;
        this.PH.mOffset = i2;
        this.PH.PZ = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gg() {
        if (this.PH == null) {
            this.PH = gh();
        }
        if (this.PI == null) {
            this.PI = OrientationHelper.createOrientationHelper(this, this.At);
        }
    }

    b gh() {
        return new b();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.PO = i;
        this.PP = Integer.MIN_VALUE;
        if (this.PR != null) {
            this.PR.bH();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.PO = i;
        this.PP = i2;
        if (this.PR != null) {
            this.PR.bH();
        }
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.At == 1) {
            return 0;
        }
        return a(i, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.At == 0) {
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
        return q.a(state, this.PI, c(!this.mSmoothScrollbarEnabled, true), d(this.mSmoothScrollbarEnabled ? false : true, true), this, this.mSmoothScrollbarEnabled, this.PM);
    }

    private int c(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        gg();
        return q.a(state, this.PI, c(!this.mSmoothScrollbarEnabled, true), d(this.mSmoothScrollbarEnabled ? false : true, true), this, this.mSmoothScrollbarEnabled);
    }

    private int d(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        gg();
        return q.b(state, this.PI, c(!this.mSmoothScrollbarEnabled, true), d(this.mSmoothScrollbarEnabled ? false : true, true), this, this.mSmoothScrollbarEnabled);
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    private void a(int i, int i2, boolean z, RecyclerView.State state) {
        int startAfterPadding;
        this.PH.Pv = gi();
        this.PH.Qa = getExtraLayoutSpace(state);
        this.PH.Pr = i;
        if (i == 1) {
            this.PH.Qa += this.PI.getEndPadding();
            View gl = gl();
            this.PH.Pq = this.PM ? -1 : 1;
            this.PH.Pp = getPosition(gl) + this.PH.Pq;
            this.PH.mOffset = this.PI.getDecoratedEnd(gl);
            startAfterPadding = this.PI.getDecoratedEnd(gl) - this.PI.getEndAfterPadding();
        } else {
            View gk = gk();
            this.PH.Qa += this.PI.getStartAfterPadding();
            this.PH.Pq = this.PM ? 1 : -1;
            this.PH.Pp = getPosition(gk) + this.PH.Pq;
            this.PH.mOffset = this.PI.getDecoratedStart(gk);
            startAfterPadding = (-this.PI.getDecoratedStart(gk)) + this.PI.getStartAfterPadding();
        }
        this.PH.Po = i2;
        if (z) {
            this.PH.Po -= startAfterPadding;
        }
        this.PH.PZ = startAfterPadding;
    }

    boolean gi() {
        return this.PI.getMode() == 0 && this.PI.getEnd() == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    int ge() {
        return 1;
    }

    int a(RecyclerView.State state, b bVar, int[] iArr) {
        int i = bVar.Pp;
        if (i < 0 || i >= state.getItemCount()) {
            return 0;
        }
        iArr[0] = i;
        return 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    int a(int i, int i2, RecyclerView.State state, int[] iArr) {
        if (this.At != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        a(i > 0 ? 1 : -1, Math.abs(i), true, state);
        return a(state, this.PH, iArr);
    }

    int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.PH.Pn = true;
        gg();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, state);
        int a2 = this.PH.PZ + a(recycler, this.PH, state, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i = i2 * a2;
        }
        this.PI.offsetChildren(-i);
        this.PH.Qc = i;
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.PR == null) {
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
            if (this.PM) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    View childAt = getChildAt(i2);
                    if (this.PI.getDecoratedEnd(childAt) > i || this.PI.getTransformedEndWithDecoration(childAt) > i) {
                        a(recycler, childCount - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (this.PI.getDecoratedEnd(childAt2) > i || this.PI.getTransformedEndWithDecoration(childAt2) > i) {
                    a(recycler, 0, i3);
                    return;
                }
            }
        }
    }

    private void b(RecyclerView.Recycler recycler, int i) {
        int childCount = getChildCount();
        if (i >= 0) {
            int end = this.PI.getEnd() - i;
            if (this.PM) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if (this.PI.getDecoratedStart(childAt) < end || this.PI.getTransformedStartWithDecoration(childAt) < end) {
                        a(recycler, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt2 = getChildAt(i3);
                if (this.PI.getDecoratedStart(childAt2) < end || this.PI.getTransformedStartWithDecoration(childAt2) < end) {
                    a(recycler, childCount - 1, i3);
                    return;
                }
            }
        }
    }

    private void a(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.Pn && !bVar.Pv) {
            if (bVar.Pr == -1) {
                b(recycler, bVar.PZ);
            } else {
                a(recycler, bVar.PZ);
            }
        }
    }

    int a(RecyclerView.Recycler recycler, b bVar, RecyclerView.State state, boolean z) {
        int i = bVar.Po;
        if (bVar.PZ != Integer.MIN_VALUE) {
            if (bVar.Po < 0) {
                bVar.PZ += bVar.Po;
            }
            a(recycler, bVar);
        }
        int i2 = bVar.Po + bVar.Qa;
        LayoutChunkResult layoutChunkResult = this.PU;
        while (true) {
            if ((!bVar.Pv && i2 <= 0) || !bVar.a(state)) {
                break;
            }
            layoutChunkResult.resetInternal();
            a(recycler, state, bVar, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                bVar.mOffset += layoutChunkResult.mConsumed * bVar.Pr;
                if (!layoutChunkResult.mIgnoreConsumed || this.PH.Qd != null || !state.isPreLayout()) {
                    bVar.Po -= layoutChunkResult.mConsumed;
                    i2 -= layoutChunkResult.mConsumed;
                }
                if (bVar.PZ != Integer.MIN_VALUE) {
                    bVar.PZ += layoutChunkResult.mConsumed;
                    if (bVar.Po < 0) {
                        bVar.PZ += bVar.Po;
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
        return i - bVar.Po;
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
        if (bVar.Qd == null) {
            if (this.PM == (bVar.Pr == -1)) {
                addView(a2);
            } else {
                addView(a2, 0);
            }
        } else {
            if (this.PM == (bVar.Pr == -1)) {
                addDisappearingView(a2);
            } else {
                addDisappearingView(a2, 0);
            }
        }
        measureChildWithMargins(a2, 0, 0);
        layoutChunkResult.mConsumed = this.PI.getDecoratedMeasurement(a2);
        if (this.At == 1) {
            if (isLayoutRTL()) {
                decoratedMeasurementInOther2 = getWidth() - getPaddingRight();
                i = decoratedMeasurementInOther2 - this.PI.getDecoratedMeasurementInOther(a2);
            } else {
                i = getPaddingLeft();
                decoratedMeasurementInOther2 = this.PI.getDecoratedMeasurementInOther(a2) + i;
            }
            if (bVar.Pr == -1) {
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
            decoratedMeasurementInOther = paddingTop + this.PI.getDecoratedMeasurementInOther(a2);
            if (bVar.Pr == -1) {
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

    private View gk() {
        return getChildAt(this.PM ? getChildCount() - 1 : 0);
    }

    private View gl() {
        return getChildAt(this.PM ? 0 : getChildCount() - 1);
    }

    private View c(boolean z, boolean z2) {
        return this.PM ? b(getChildCount() - 1, -1, z, z2) : b(0, getChildCount(), z, z2);
    }

    private View d(boolean z, boolean z2) {
        return this.PM ? b(0, getChildCount(), z, z2) : b(getChildCount() - 1, -1, z, z2);
    }

    private View a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.PM ? c(recycler, state) : d(recycler, state);
    }

    private View b(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.PM ? d(recycler, state) : c(recycler, state);
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
        int startAfterPadding = this.PI.getStartAfterPadding();
        int endAfterPadding = this.PI.getEndAfterPadding();
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
                } else if (this.PI.getDecoratedStart(childAt) < endAfterPadding && this.PI.getDecoratedEnd(childAt) >= startAfterPadding) {
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
        View b2 = b(0, getChildCount(), false, true);
        if (b2 == null) {
            return -1;
        }
        return getPosition(b2);
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View b2 = b(0, getChildCount(), true, false);
        if (b2 == null) {
            return -1;
        }
        return getPosition(b2);
    }

    public int findLastVisibleItemPosition() {
        View b2 = b(getChildCount() - 1, -1, false, true);
        if (b2 == null) {
            return -1;
        }
        return getPosition(b2);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View b2 = b(getChildCount() - 1, -1, true, false);
        if (b2 == null) {
            return -1;
        }
        return getPosition(b2);
    }

    View b(int i, int i2, boolean z, boolean z2) {
        gg();
        int startAfterPadding = this.PI.getStartAfterPadding();
        int endAfterPadding = this.PI.getEndAfterPadding();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int decoratedStart = this.PI.getDecoratedStart(childAt);
            int decoratedEnd = this.PI.getDecoratedEnd(childAt);
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
            a(bo, (int) (0.33333334f * this.PI.getTotalSpace()), false, state);
            this.PH.PZ = Integer.MIN_VALUE;
            this.PH.Pn = false;
            a(recycler, this.PH, state, true);
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
        return this.PR == null && this.PJ == this.PN;
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
        if (this.PM) {
            if (z) {
                scrollToPositionWithOffset(position2, this.PI.getEndAfterPadding() - (this.PI.getDecoratedStart(view2) + this.PI.getDecoratedMeasurement(view)));
            } else {
                scrollToPositionWithOffset(position2, this.PI.getEndAfterPadding() - this.PI.getDecoratedEnd(view2));
            }
        } else if (z) {
            scrollToPositionWithOffset(position2, this.PI.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.PI.getDecoratedEnd(view2) - this.PI.getDecoratedMeasurement(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {
        int PZ;
        int Po;
        int Pp;
        int Pq;
        int Pr;
        boolean Pv;
        int Qc;
        int mOffset;
        boolean Pn = true;
        int Qa = 0;
        boolean Qb = false;
        List<RecyclerView.ViewHolder> Qd = null;

        b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(RecyclerView.State state) {
            return this.Pp >= 0 && this.Pp < state.getItemCount();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View a(RecyclerView.Recycler recycler) {
            if (this.Qd != null) {
                return gn();
            }
            View viewForPosition = recycler.getViewForPosition(this.Pp);
            this.Pp += this.Pq;
            return viewForPosition;
        }

        private View gn() {
            int size = this.Qd.size();
            for (int i = 0; i < size; i++) {
                View view = this.Qd.get(i).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.isItemRemoved() && this.Pp == layoutParams.getViewLayoutPosition()) {
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
                this.Pp = -1;
            } else {
                this.Pp = ((RecyclerView.LayoutParams) am.getLayoutParams()).getViewLayoutPosition();
            }
        }

        public View am(View view) {
            int i;
            View view2;
            int size = this.Qd.size();
            View view3 = null;
            int i2 = Integer.MAX_VALUE;
            int i3 = 0;
            while (i3 < size) {
                View view4 = this.Qd.get(i3).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view4.getLayoutParams();
                if (view4 != view) {
                    if (layoutParams.isItemRemoved()) {
                        i = i2;
                        view2 = view3;
                    } else {
                        i = (layoutParams.getViewLayoutPosition() - this.Pp) * this.Pq;
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
        int Qe;
        int Qf;
        boolean Qg;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.Qe = parcel.readInt();
            this.Qf = parcel.readInt();
            this.Qg = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.Qe = savedState.Qe;
            this.Qf = savedState.Qf;
            this.Qg = savedState.Qg;
        }

        boolean gp() {
            return this.Qe >= 0;
        }

        void bH() {
            this.Qe = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.Qe);
            parcel.writeInt(this.Qf);
            parcel.writeInt(this.Qg ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        int PV;
        boolean PW;
        boolean PX;
        int mPosition;

        a() {
            reset();
        }

        void reset() {
            this.mPosition = -1;
            this.PV = Integer.MIN_VALUE;
            this.PW = false;
            this.PX = false;
        }

        void gm() {
            int startAfterPadding;
            if (this.PW) {
                startAfterPadding = LinearLayoutManager.this.PI.getEndAfterPadding();
            } else {
                startAfterPadding = LinearLayoutManager.this.PI.getStartAfterPadding();
            }
            this.PV = startAfterPadding;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.PV + ", mLayoutFromEnd=" + this.PW + ", mValid=" + this.PX + '}';
        }

        boolean a(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < state.getItemCount();
        }

        public void aj(View view) {
            int totalSpaceChange = LinearLayoutManager.this.PI.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                ak(view);
                return;
            }
            this.mPosition = LinearLayoutManager.this.getPosition(view);
            if (this.PW) {
                int endAfterPadding = (LinearLayoutManager.this.PI.getEndAfterPadding() - totalSpaceChange) - LinearLayoutManager.this.PI.getDecoratedEnd(view);
                this.PV = LinearLayoutManager.this.PI.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    int decoratedMeasurement = this.PV - LinearLayoutManager.this.PI.getDecoratedMeasurement(view);
                    int startAfterPadding = LinearLayoutManager.this.PI.getStartAfterPadding();
                    int min = decoratedMeasurement - (startAfterPadding + Math.min(LinearLayoutManager.this.PI.getDecoratedStart(view) - startAfterPadding, 0));
                    if (min < 0) {
                        this.PV = Math.min(endAfterPadding, -min) + this.PV;
                        return;
                    }
                    return;
                }
                return;
            }
            int decoratedStart = LinearLayoutManager.this.PI.getDecoratedStart(view);
            int startAfterPadding2 = decoratedStart - LinearLayoutManager.this.PI.getStartAfterPadding();
            this.PV = decoratedStart;
            if (startAfterPadding2 > 0) {
                int endAfterPadding2 = (LinearLayoutManager.this.PI.getEndAfterPadding() - Math.min(0, (LinearLayoutManager.this.PI.getEndAfterPadding() - totalSpaceChange) - LinearLayoutManager.this.PI.getDecoratedEnd(view))) - (decoratedStart + LinearLayoutManager.this.PI.getDecoratedMeasurement(view));
                if (endAfterPadding2 < 0) {
                    this.PV -= Math.min(startAfterPadding2, -endAfterPadding2);
                }
            }
        }

        public void ak(View view) {
            if (this.PW) {
                this.PV = LinearLayoutManager.this.PI.getDecoratedEnd(view) + LinearLayoutManager.this.PI.getTotalSpaceChange();
            } else {
                this.PV = LinearLayoutManager.this.PI.getDecoratedStart(view);
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
