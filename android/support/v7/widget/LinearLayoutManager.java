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
    int An;
    private b PA;
    OrientationHelper PC;
    private boolean PD;
    private boolean PE;
    boolean PF;
    private boolean PG;
    int PH;
    int PI;
    private boolean PJ;
    SavedState PK;
    final a PM;
    private final LayoutChunkResult PN;
    private boolean mSmoothScrollbarEnabled;

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.PE = false;
        this.PF = false;
        this.PG = false;
        this.mSmoothScrollbarEnabled = true;
        this.PH = -1;
        this.PI = Integer.MIN_VALUE;
        this.PK = null;
        this.PM = new a();
        this.PN = new LayoutChunkResult();
        setOrientation(i);
        setReverseLayout(z);
        setAutoMeasureEnabled(true);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.PE = false;
        this.PF = false;
        this.PG = false;
        this.mSmoothScrollbarEnabled = true;
        this.PH = -1;
        this.PI = Integer.MIN_VALUE;
        this.PK = null;
        this.PM = new a();
        this.PN = new LayoutChunkResult();
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
        return this.PJ;
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.PJ = z;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.PJ) {
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
        if (this.PK != null) {
            return new SavedState(this.PK);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            gg();
            boolean z = this.PD ^ this.PF;
            savedState.Qa = z;
            if (z) {
                View gl = gl();
                savedState.PZ = this.PC.getEndAfterPadding() - this.PC.getDecoratedEnd(gl);
                savedState.PY = getPosition(gl);
                return savedState;
            }
            View gk = gk();
            savedState.PY = getPosition(gk);
            savedState.PZ = this.PC.getDecoratedStart(gk) - this.PC.getStartAfterPadding();
            return savedState;
        }
        savedState.bH();
        return savedState;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.PK = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.An == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.An == 1;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.PG != z) {
            this.PG = z;
            requestLayout();
        }
    }

    public boolean getStackFromEnd() {
        return this.PG;
    }

    public int getOrientation() {
        return this.An;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.An) {
            this.An = i;
            this.PC = null;
            requestLayout();
        }
    }

    private void gf() {
        if (this.An == 1 || !isLayoutRTL()) {
            this.PF = this.PE;
        } else {
            this.PF = this.PE ? false : true;
        }
    }

    public boolean getReverseLayout() {
        return this.PE;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z != this.PE) {
            this.PE = z;
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
            return this.PC.getTotalSpace();
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
        int i2 = (i < getPosition(getChildAt(0))) != this.PF ? -1 : 1;
        if (this.An == 0) {
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
        if ((this.PK != null || this.PH != -1) && state.getItemCount() == 0) {
            removeAndRecycleAllViews(recycler);
            return;
        }
        if (this.PK != null && this.PK.gp()) {
            this.PH = this.PK.PY;
        }
        gg();
        this.PA.Ph = false;
        gf();
        if (!this.PM.PQ || this.PH != -1 || this.PK != null) {
            this.PM.reset();
            this.PM.PP = this.PF ^ this.PG;
            a(recycler, state, this.PM);
            this.PM.PQ = true;
        }
        int extraLayoutSpace = getExtraLayoutSpace(state);
        if (this.PA.PW >= 0) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        int startAfterPadding = i + this.PC.getStartAfterPadding();
        int endPadding = extraLayoutSpace + this.PC.getEndPadding();
        if (state.isPreLayout() && this.PH != -1 && this.PI != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(this.PH)) != null) {
            if (this.PF) {
                decoratedStart = (this.PC.getEndAfterPadding() - this.PC.getDecoratedEnd(findViewByPosition)) - this.PI;
            } else {
                decoratedStart = this.PI - (this.PC.getDecoratedStart(findViewByPosition) - this.PC.getStartAfterPadding());
            }
            if (decoratedStart > 0) {
                startAfterPadding += decoratedStart;
            } else {
                endPadding -= decoratedStart;
            }
        }
        if (this.PM.PP) {
            if (this.PF) {
                i5 = 1;
            }
        } else if (!this.PF) {
            i5 = 1;
        }
        a(recycler, state, this.PM, i5);
        detachAndScrapAttachedViews(recycler);
        this.PA.Pp = gi();
        this.PA.PV = state.isPreLayout();
        if (this.PM.PP) {
            b(this.PM);
            this.PA.PU = startAfterPadding;
            a(recycler, this.PA, state, false);
            int i6 = this.PA.mOffset;
            int i7 = this.PA.Pj;
            if (this.PA.Pi > 0) {
                endPadding += this.PA.Pi;
            }
            a(this.PM);
            this.PA.PU = endPadding;
            this.PA.Pj += this.PA.Pk;
            a(recycler, this.PA, state, false);
            int i8 = this.PA.mOffset;
            if (this.PA.Pi > 0) {
                int i9 = this.PA.Pi;
                N(i7, i6);
                this.PA.PU = i9;
                a(recycler, this.PA, state, false);
                i4 = this.PA.mOffset;
            } else {
                i4 = i6;
            }
            i3 = i4;
            i2 = i8;
        } else {
            a(this.PM);
            this.PA.PU = endPadding;
            a(recycler, this.PA, state, false);
            i2 = this.PA.mOffset;
            int i10 = this.PA.Pj;
            if (this.PA.Pi > 0) {
                startAfterPadding += this.PA.Pi;
            }
            b(this.PM);
            this.PA.PU = startAfterPadding;
            this.PA.Pj += this.PA.Pk;
            a(recycler, this.PA, state, false);
            i3 = this.PA.mOffset;
            if (this.PA.Pi > 0) {
                int i11 = this.PA.Pi;
                M(i10, i2);
                this.PA.PU = i11;
                a(recycler, this.PA, state, false);
                i2 = this.PA.mOffset;
            }
        }
        if (getChildCount() > 0) {
            if (this.PF ^ this.PG) {
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
            this.PC.onLayoutComplete();
        } else {
            this.PM.reset();
        }
        this.PD = this.PG;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.PK = null;
        this.PH = -1;
        this.PI = Integer.MIN_VALUE;
        this.PM.reset();
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
                    if (((viewHolder.getLayoutPosition() < position) != this.PF ? (char) 65535 : (char) 1) == 65535) {
                        i3 = this.PC.getDecoratedMeasurement(viewHolder.itemView) + i4;
                        decoratedMeasurement = i5;
                    } else {
                        decoratedMeasurement = this.PC.getDecoratedMeasurement(viewHolder.itemView) + i5;
                        i3 = i4;
                    }
                }
                i6++;
                i4 = i3;
                i5 = decoratedMeasurement;
            }
            this.PA.PX = scrapList;
            if (i4 > 0) {
                N(getPosition(gk()), i);
                this.PA.PU = i4;
                this.PA.Pi = 0;
                this.PA.go();
                a(recycler, this.PA, state, false);
            }
            if (i5 > 0) {
                M(getPosition(gl()), i2);
                this.PA.PU = i5;
                this.PA.Pi = 0;
                this.PA.go();
                a(recycler, this.PA, state, false);
            }
            this.PA.PX = null;
        }
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state, a aVar) {
        if (!a(state, aVar) && !b(recycler, state, aVar)) {
            aVar.gm();
            aVar.mPosition = this.PG ? state.getItemCount() - 1 : 0;
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
        } else if (this.PD == this.PG) {
            if (aVar.PP) {
                b2 = a(recycler, state);
            } else {
                b2 = b(recycler, state);
            }
            if (b2 != null) {
                aVar.ak(b2);
                if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                    if (this.PC.getDecoratedStart(b2) >= this.PC.getEndAfterPadding() || this.PC.getDecoratedEnd(b2) < this.PC.getStartAfterPadding()) {
                        z = true;
                    }
                    if (z) {
                        if (aVar.PP) {
                            startAfterPadding = this.PC.getEndAfterPadding();
                        } else {
                            startAfterPadding = this.PC.getStartAfterPadding();
                        }
                        aVar.PO = startAfterPadding;
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
        if (state.isPreLayout() || this.PH == -1) {
            return false;
        }
        if (this.PH < 0 || this.PH >= state.getItemCount()) {
            this.PH = -1;
            this.PI = Integer.MIN_VALUE;
            return false;
        }
        aVar.mPosition = this.PH;
        if (this.PK != null && this.PK.gp()) {
            aVar.PP = this.PK.Qa;
            if (aVar.PP) {
                aVar.PO = this.PC.getEndAfterPadding() - this.PK.PZ;
                return true;
            }
            aVar.PO = this.PC.getStartAfterPadding() + this.PK.PZ;
            return true;
        } else if (this.PI == Integer.MIN_VALUE) {
            View findViewByPosition = findViewByPosition(this.PH);
            if (findViewByPosition != null) {
                if (this.PC.getDecoratedMeasurement(findViewByPosition) > this.PC.getTotalSpace()) {
                    aVar.gm();
                    return true;
                } else if (this.PC.getDecoratedStart(findViewByPosition) - this.PC.getStartAfterPadding() < 0) {
                    aVar.PO = this.PC.getStartAfterPadding();
                    aVar.PP = false;
                    return true;
                } else if (this.PC.getEndAfterPadding() - this.PC.getDecoratedEnd(findViewByPosition) < 0) {
                    aVar.PO = this.PC.getEndAfterPadding();
                    aVar.PP = true;
                    return true;
                } else {
                    if (aVar.PP) {
                        decoratedStart = this.PC.getDecoratedEnd(findViewByPosition) + this.PC.getTotalSpaceChange();
                    } else {
                        decoratedStart = this.PC.getDecoratedStart(findViewByPosition);
                    }
                    aVar.PO = decoratedStart;
                    return true;
                }
            }
            if (getChildCount() > 0) {
                aVar.PP = (this.PH < getPosition(getChildAt(0))) == this.PF;
            }
            aVar.gm();
            return true;
        } else {
            aVar.PP = this.PF;
            if (this.PF) {
                aVar.PO = this.PC.getEndAfterPadding() - this.PI;
                return true;
            }
            aVar.PO = this.PC.getStartAfterPadding() + this.PI;
            return true;
        }
    }

    private int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int endAfterPadding;
        int endAfterPadding2 = this.PC.getEndAfterPadding() - i;
        if (endAfterPadding2 > 0) {
            int i2 = -a(-endAfterPadding2, recycler, state);
            int i3 = i + i2;
            if (z && (endAfterPadding = this.PC.getEndAfterPadding() - i3) > 0) {
                this.PC.offsetChildren(endAfterPadding);
                return i2 + endAfterPadding;
            }
            return i2;
        }
        return 0;
    }

    private int b(int i, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int startAfterPadding;
        int startAfterPadding2 = i - this.PC.getStartAfterPadding();
        if (startAfterPadding2 > 0) {
            int i2 = -a(startAfterPadding2, recycler, state);
            int i3 = i + i2;
            if (z && (startAfterPadding = i3 - this.PC.getStartAfterPadding()) > 0) {
                this.PC.offsetChildren(-startAfterPadding);
                return i2 - startAfterPadding;
            }
            return i2;
        }
        return 0;
    }

    private void a(a aVar) {
        M(aVar.mPosition, aVar.PO);
    }

    private void M(int i, int i2) {
        this.PA.Pi = this.PC.getEndAfterPadding() - i2;
        this.PA.Pk = this.PF ? -1 : 1;
        this.PA.Pj = i;
        this.PA.Pl = 1;
        this.PA.mOffset = i2;
        this.PA.PT = Integer.MIN_VALUE;
    }

    private void b(a aVar) {
        N(aVar.mPosition, aVar.PO);
    }

    private void N(int i, int i2) {
        this.PA.Pi = i2 - this.PC.getStartAfterPadding();
        this.PA.Pj = i;
        this.PA.Pk = this.PF ? 1 : -1;
        this.PA.Pl = -1;
        this.PA.mOffset = i2;
        this.PA.PT = Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void gg() {
        if (this.PA == null) {
            this.PA = gh();
        }
        if (this.PC == null) {
            this.PC = OrientationHelper.createOrientationHelper(this, this.An);
        }
    }

    b gh() {
        return new b();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i) {
        this.PH = i;
        this.PI = Integer.MIN_VALUE;
        if (this.PK != null) {
            this.PK.bH();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.PH = i;
        this.PI = i2;
        if (this.PK != null) {
            this.PK.bH();
        }
        requestLayout();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.An == 1) {
            return 0;
        }
        return a(i, recycler, state);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.An == 0) {
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
        return q.a(state, this.PC, c(!this.mSmoothScrollbarEnabled, true), d(this.mSmoothScrollbarEnabled ? false : true, true), this, this.mSmoothScrollbarEnabled, this.PF);
    }

    private int c(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        gg();
        return q.a(state, this.PC, c(!this.mSmoothScrollbarEnabled, true), d(this.mSmoothScrollbarEnabled ? false : true, true), this, this.mSmoothScrollbarEnabled);
    }

    private int d(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        gg();
        return q.b(state, this.PC, c(!this.mSmoothScrollbarEnabled, true), d(this.mSmoothScrollbarEnabled ? false : true, true), this, this.mSmoothScrollbarEnabled);
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    private void a(int i, int i2, boolean z, RecyclerView.State state) {
        int startAfterPadding;
        this.PA.Pp = gi();
        this.PA.PU = getExtraLayoutSpace(state);
        this.PA.Pl = i;
        if (i == 1) {
            this.PA.PU += this.PC.getEndPadding();
            View gl = gl();
            this.PA.Pk = this.PF ? -1 : 1;
            this.PA.Pj = getPosition(gl) + this.PA.Pk;
            this.PA.mOffset = this.PC.getDecoratedEnd(gl);
            startAfterPadding = this.PC.getDecoratedEnd(gl) - this.PC.getEndAfterPadding();
        } else {
            View gk = gk();
            this.PA.PU += this.PC.getStartAfterPadding();
            this.PA.Pk = this.PF ? 1 : -1;
            this.PA.Pj = getPosition(gk) + this.PA.Pk;
            this.PA.mOffset = this.PC.getDecoratedStart(gk);
            startAfterPadding = (-this.PC.getDecoratedStart(gk)) + this.PC.getStartAfterPadding();
        }
        this.PA.Pi = i2;
        if (z) {
            this.PA.Pi -= startAfterPadding;
        }
        this.PA.PT = startAfterPadding;
    }

    boolean gi() {
        return this.PC.getMode() == 0 && this.PC.getEnd() == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    int ge() {
        return 1;
    }

    int a(RecyclerView.State state, b bVar, int[] iArr) {
        int i = bVar.Pj;
        if (i < 0 || i >= state.getItemCount()) {
            return 0;
        }
        iArr[0] = i;
        return 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    int a(int i, int i2, RecyclerView.State state, int[] iArr) {
        if (this.An != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        a(i > 0 ? 1 : -1, Math.abs(i), true, state);
        return a(state, this.PA, iArr);
    }

    int a(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        this.PA.Ph = true;
        gg();
        int i2 = i > 0 ? 1 : -1;
        int abs = Math.abs(i);
        a(i2, abs, true, state);
        int a2 = this.PA.PT + a(recycler, this.PA, state, false);
        if (a2 < 0) {
            return 0;
        }
        if (abs > a2) {
            i = i2 * a2;
        }
        this.PC.offsetChildren(-i);
        this.PA.PW = i;
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.PK == null) {
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
            if (this.PF) {
                for (int i2 = childCount - 1; i2 >= 0; i2--) {
                    View childAt = getChildAt(i2);
                    if (this.PC.getDecoratedEnd(childAt) > i || this.PC.getTransformedEndWithDecoration(childAt) > i) {
                        a(recycler, childCount - 1, i2);
                        return;
                    }
                }
                return;
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt2 = getChildAt(i3);
                if (this.PC.getDecoratedEnd(childAt2) > i || this.PC.getTransformedEndWithDecoration(childAt2) > i) {
                    a(recycler, 0, i3);
                    return;
                }
            }
        }
    }

    private void b(RecyclerView.Recycler recycler, int i) {
        int childCount = getChildCount();
        if (i >= 0) {
            int end = this.PC.getEnd() - i;
            if (this.PF) {
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    if (this.PC.getDecoratedStart(childAt) < end || this.PC.getTransformedStartWithDecoration(childAt) < end) {
                        a(recycler, 0, i2);
                        return;
                    }
                }
                return;
            }
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt2 = getChildAt(i3);
                if (this.PC.getDecoratedStart(childAt2) < end || this.PC.getTransformedStartWithDecoration(childAt2) < end) {
                    a(recycler, childCount - 1, i3);
                    return;
                }
            }
        }
    }

    private void a(RecyclerView.Recycler recycler, b bVar) {
        if (bVar.Ph && !bVar.Pp) {
            if (bVar.Pl == -1) {
                b(recycler, bVar.PT);
            } else {
                a(recycler, bVar.PT);
            }
        }
    }

    int a(RecyclerView.Recycler recycler, b bVar, RecyclerView.State state, boolean z) {
        int i = bVar.Pi;
        if (bVar.PT != Integer.MIN_VALUE) {
            if (bVar.Pi < 0) {
                bVar.PT += bVar.Pi;
            }
            a(recycler, bVar);
        }
        int i2 = bVar.Pi + bVar.PU;
        LayoutChunkResult layoutChunkResult = this.PN;
        while (true) {
            if ((!bVar.Pp && i2 <= 0) || !bVar.a(state)) {
                break;
            }
            layoutChunkResult.resetInternal();
            a(recycler, state, bVar, layoutChunkResult);
            if (!layoutChunkResult.mFinished) {
                bVar.mOffset += layoutChunkResult.mConsumed * bVar.Pl;
                if (!layoutChunkResult.mIgnoreConsumed || this.PA.PX != null || !state.isPreLayout()) {
                    bVar.Pi -= layoutChunkResult.mConsumed;
                    i2 -= layoutChunkResult.mConsumed;
                }
                if (bVar.PT != Integer.MIN_VALUE) {
                    bVar.PT += layoutChunkResult.mConsumed;
                    if (bVar.Pi < 0) {
                        bVar.PT += bVar.Pi;
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
        return i - bVar.Pi;
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
        if (bVar.PX == null) {
            if (this.PF == (bVar.Pl == -1)) {
                addView(a2);
            } else {
                addView(a2, 0);
            }
        } else {
            if (this.PF == (bVar.Pl == -1)) {
                addDisappearingView(a2);
            } else {
                addDisappearingView(a2, 0);
            }
        }
        measureChildWithMargins(a2, 0, 0);
        layoutChunkResult.mConsumed = this.PC.getDecoratedMeasurement(a2);
        if (this.An == 1) {
            if (isLayoutRTL()) {
                decoratedMeasurementInOther2 = getWidth() - getPaddingRight();
                i = decoratedMeasurementInOther2 - this.PC.getDecoratedMeasurementInOther(a2);
            } else {
                i = getPaddingLeft();
                decoratedMeasurementInOther2 = this.PC.getDecoratedMeasurementInOther(a2) + i;
            }
            if (bVar.Pl == -1) {
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
            decoratedMeasurementInOther = paddingTop + this.PC.getDecoratedMeasurementInOther(a2);
            if (bVar.Pl == -1) {
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
                return (this.An == 1 || !isLayoutRTL()) ? -1 : 1;
            case 2:
                return (this.An != 1 && isLayoutRTL()) ? -1 : 1;
            case 17:
                return this.An != 0 ? Integer.MIN_VALUE : -1;
            case 33:
                return this.An != 1 ? Integer.MIN_VALUE : -1;
            case 66:
                return this.An != 0 ? Integer.MIN_VALUE : 1;
            case TransportMediator.KEYCODE_MEDIA_RECORD /* 130 */:
                return this.An == 1 ? 1 : Integer.MIN_VALUE;
            default:
                return Integer.MIN_VALUE;
        }
    }

    private View gk() {
        return getChildAt(this.PF ? getChildCount() - 1 : 0);
    }

    private View gl() {
        return getChildAt(this.PF ? 0 : getChildCount() - 1);
    }

    private View c(boolean z, boolean z2) {
        return this.PF ? c(getChildCount() - 1, -1, z, z2) : c(0, getChildCount(), z, z2);
    }

    private View d(boolean z, boolean z2) {
        return this.PF ? c(0, getChildCount(), z, z2) : c(getChildCount() - 1, -1, z, z2);
    }

    private View a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.PF ? c(recycler, state) : d(recycler, state);
    }

    private View b(RecyclerView.Recycler recycler, RecyclerView.State state) {
        return this.PF ? d(recycler, state) : c(recycler, state);
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
        int startAfterPadding = this.PC.getStartAfterPadding();
        int endAfterPadding = this.PC.getEndAfterPadding();
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
                } else if (this.PC.getDecoratedStart(childAt) < endAfterPadding && this.PC.getDecoratedEnd(childAt) >= startAfterPadding) {
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
        int startAfterPadding = this.PC.getStartAfterPadding();
        int endAfterPadding = this.PC.getEndAfterPadding();
        int i3 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View childAt = getChildAt(i);
            int decoratedStart = this.PC.getDecoratedStart(childAt);
            int decoratedEnd = this.PC.getDecoratedEnd(childAt);
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
            a(bo, (int) (0.33333334f * this.PC.getTotalSpace()), false, state);
            this.PA.PT = Integer.MIN_VALUE;
            this.PA.Ph = false;
            a(recycler, this.PA, state, true);
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
        return this.PK == null && this.PD == this.PG;
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
        if (this.PF) {
            if (z) {
                scrollToPositionWithOffset(position2, this.PC.getEndAfterPadding() - (this.PC.getDecoratedStart(view2) + this.PC.getDecoratedMeasurement(view)));
            } else {
                scrollToPositionWithOffset(position2, this.PC.getEndAfterPadding() - this.PC.getDecoratedEnd(view2));
            }
        } else if (z) {
            scrollToPositionWithOffset(position2, this.PC.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.PC.getDecoratedEnd(view2) - this.PC.getDecoratedMeasurement(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {
        int PT;
        int PW;
        int Pi;
        int Pj;
        int Pk;
        int Pl;
        boolean Pp;
        int mOffset;
        boolean Ph = true;
        int PU = 0;
        boolean PV = false;
        List<RecyclerView.ViewHolder> PX = null;

        b() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(RecyclerView.State state) {
            return this.Pj >= 0 && this.Pj < state.getItemCount();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View a(RecyclerView.Recycler recycler) {
            if (this.PX != null) {
                return gn();
            }
            View viewForPosition = recycler.getViewForPosition(this.Pj);
            this.Pj += this.Pk;
            return viewForPosition;
        }

        private View gn() {
            int size = this.PX.size();
            for (int i = 0; i < size; i++) {
                View view = this.PX.get(i).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.isItemRemoved() && this.Pj == layoutParams.getViewLayoutPosition()) {
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
                this.Pj = -1;
            } else {
                this.Pj = ((RecyclerView.LayoutParams) am.getLayoutParams()).getViewLayoutPosition();
            }
        }

        public View am(View view) {
            int i;
            View view2;
            int size = this.PX.size();
            View view3 = null;
            int i2 = Integer.MAX_VALUE;
            int i3 = 0;
            while (i3 < size) {
                View view4 = this.PX.get(i3).itemView;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view4.getLayoutParams();
                if (view4 != view) {
                    if (layoutParams.isItemRemoved()) {
                        i = i2;
                        view2 = view3;
                    } else {
                        i = (layoutParams.getViewLayoutPosition() - this.Pj) * this.Pk;
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
        int PY;
        int PZ;
        boolean Qa;

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.PY = parcel.readInt();
            this.PZ = parcel.readInt();
            this.Qa = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.PY = savedState.PY;
            this.PZ = savedState.PZ;
            this.Qa = savedState.Qa;
        }

        boolean gp() {
            return this.PY >= 0;
        }

        void bH() {
            this.PY = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.PY);
            parcel.writeInt(this.PZ);
            parcel.writeInt(this.Qa ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a {
        int PO;
        boolean PP;
        boolean PQ;
        int mPosition;

        a() {
            reset();
        }

        void reset() {
            this.mPosition = -1;
            this.PO = Integer.MIN_VALUE;
            this.PP = false;
            this.PQ = false;
        }

        void gm() {
            int startAfterPadding;
            if (this.PP) {
                startAfterPadding = LinearLayoutManager.this.PC.getEndAfterPadding();
            } else {
                startAfterPadding = LinearLayoutManager.this.PC.getStartAfterPadding();
            }
            this.PO = startAfterPadding;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.mPosition + ", mCoordinate=" + this.PO + ", mLayoutFromEnd=" + this.PP + ", mValid=" + this.PQ + '}';
        }

        boolean a(View view, RecyclerView.State state) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.isItemRemoved() && layoutParams.getViewLayoutPosition() >= 0 && layoutParams.getViewLayoutPosition() < state.getItemCount();
        }

        public void aj(View view) {
            int totalSpaceChange = LinearLayoutManager.this.PC.getTotalSpaceChange();
            if (totalSpaceChange >= 0) {
                ak(view);
                return;
            }
            this.mPosition = LinearLayoutManager.this.getPosition(view);
            if (this.PP) {
                int endAfterPadding = (LinearLayoutManager.this.PC.getEndAfterPadding() - totalSpaceChange) - LinearLayoutManager.this.PC.getDecoratedEnd(view);
                this.PO = LinearLayoutManager.this.PC.getEndAfterPadding() - endAfterPadding;
                if (endAfterPadding > 0) {
                    int decoratedMeasurement = this.PO - LinearLayoutManager.this.PC.getDecoratedMeasurement(view);
                    int startAfterPadding = LinearLayoutManager.this.PC.getStartAfterPadding();
                    int min = decoratedMeasurement - (startAfterPadding + Math.min(LinearLayoutManager.this.PC.getDecoratedStart(view) - startAfterPadding, 0));
                    if (min < 0) {
                        this.PO = Math.min(endAfterPadding, -min) + this.PO;
                        return;
                    }
                    return;
                }
                return;
            }
            int decoratedStart = LinearLayoutManager.this.PC.getDecoratedStart(view);
            int startAfterPadding2 = decoratedStart - LinearLayoutManager.this.PC.getStartAfterPadding();
            this.PO = decoratedStart;
            if (startAfterPadding2 > 0) {
                int endAfterPadding2 = (LinearLayoutManager.this.PC.getEndAfterPadding() - Math.min(0, (LinearLayoutManager.this.PC.getEndAfterPadding() - totalSpaceChange) - LinearLayoutManager.this.PC.getDecoratedEnd(view))) - (decoratedStart + LinearLayoutManager.this.PC.getDecoratedMeasurement(view));
                if (endAfterPadding2 < 0) {
                    this.PO -= Math.min(startAfterPadding2, -endAfterPadding2);
                }
            }
        }

        public void ak(View view) {
            if (this.PP) {
                this.PO = LinearLayoutManager.this.PC.getDecoratedEnd(view) + LinearLayoutManager.this.PC.getTotalSpaceChange();
            } else {
                this.PO = LinearLayoutManager.this.PC.getDecoratedStart(view);
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
