package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public static final int DEFAULT_SPAN_COUNT = -1;
    boolean Pb;
    int Pc;
    int[] Pd;
    View[] Pe;
    final SparseIntArray Pf;
    final SparseIntArray Pg;
    SpanSizeLookup Ph;
    final Rect Pi;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.Pb = false;
        this.Pc = -1;
        this.Pf = new SparseIntArray();
        this.Pg = new SparseIntArray();
        this.Ph = new DefaultSpanSizeLookup();
        this.Pi = new Rect();
        setSpanCount(getProperties(context, attributeSet, i, i2).spanCount);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.Pb = false;
        this.Pc = -1;
        this.Pf = new SparseIntArray();
        this.Pg = new SparseIntArray();
        this.Ph = new DefaultSpanSizeLookup();
        this.Pi = new Rect();
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z) {
        super(context, i2, z);
        this.Pb = false;
        this.Pc = -1;
        this.Pf = new SparseIntArray();
        this.Pg = new SparseIntArray();
        this.Ph = new DefaultSpanSizeLookup();
        this.Pi = new Rect();
        setSpanCount(i);
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getRowCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.At == 0) {
            return this.Pc;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return a(recycler, state, state.getItemCount() - 1) + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public int getColumnCountForAccessibility(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (this.At == 1) {
            return this.Pc;
        }
        if (state.getItemCount() < 1) {
            return 0;
        }
        return a(recycler, state, state.getItemCount() - 1) + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler recycler, RecyclerView.State state, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.a(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        int a = a(recycler, state, layoutParams2.getViewLayoutPosition());
        if (this.At == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), a, 1, this.Pc > 1 && layoutParams2.getSpanSize() == this.Pc, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(a, 1, layoutParams2.getSpanIndex(), layoutParams2.getSpanSize(), this.Pc > 1 && layoutParams2.getSpanSize() == this.Pc, false));
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (state.isPreLayout()) {
            ga();
        }
        super.onLayoutChildren(recycler, state);
        fZ();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.Pb = false;
    }

    private void fZ() {
        this.Pf.clear();
        this.Pg.clear();
    }

    private void ga() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i).getLayoutParams();
            int viewLayoutPosition = layoutParams.getViewLayoutPosition();
            this.Pf.put(viewLayoutPosition, layoutParams.getSpanSize());
            this.Pg.put(viewLayoutPosition, layoutParams.getSpanIndex());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.Ph.invalidateSpanIndexCache();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.Ph.invalidateSpanIndexCache();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.Ph.invalidateSpanIndexCache();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.Ph.invalidateSpanIndexCache();
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.Ph.invalidateSpanIndexCache();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
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

    public void setSpanSizeLookup(SpanSizeLookup spanSizeLookup) {
        this.Ph = spanSizeLookup;
    }

    public SpanSizeLookup getSpanSizeLookup() {
        return this.Ph;
    }

    private void gb() {
        int height;
        if (getOrientation() == 1) {
            height = (getWidth() - getPaddingRight()) - getPaddingLeft();
        } else {
            height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        }
        bl(height);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int chooseSize;
        int chooseSize2;
        if (this.Pd == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.At == 1) {
            chooseSize2 = chooseSize(i2, paddingTop + rect.height(), getMinimumHeight());
            chooseSize = chooseSize(i, paddingRight + this.Pd[this.Pd.length - 1], getMinimumWidth());
        } else {
            chooseSize = chooseSize(i, paddingRight + rect.width(), getMinimumWidth());
            chooseSize2 = chooseSize(i2, paddingTop + this.Pd[this.Pd.length - 1], getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    private void bl(int i) {
        this.Pd = b(this.Pd, this.Pc, i);
    }

    static int[] b(int[] iArr, int i, int i2) {
        int i3;
        int i4 = 0;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    int G(int i, int i2) {
        return (this.At == 1 && isLayoutRTL()) ? this.Pd[this.Pc - i] - this.Pd[(this.Pc - i) - i2] : this.Pd[i + i2] - this.Pd[i];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // android.support.v7.widget.LinearLayoutManager
    public void a(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.a aVar, int i) {
        super.a(recycler, state, aVar, i);
        gb();
        if (state.getItemCount() > 0 && !state.isPreLayout()) {
            b(recycler, state, aVar, i);
        }
        gd();
    }

    private void gd() {
        if (this.Pe == null || this.Pe.length != this.Pc) {
            this.Pe = new View[this.Pc];
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        gb();
        gd();
        return super.scrollHorizontallyBy(i, recycler, state);
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        gb();
        gd();
        return super.scrollVerticallyBy(i, recycler, state);
    }

    private void b(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.a aVar, int i) {
        boolean z = i == 1;
        int b = b(recycler, state, aVar.mPosition);
        if (z) {
            while (b > 0 && aVar.mPosition > 0) {
                aVar.mPosition--;
                b = b(recycler, state, aVar.mPosition);
            }
            return;
        }
        int itemCount = state.getItemCount() - 1;
        int i2 = aVar.mPosition;
        int i3 = b;
        while (i2 < itemCount) {
            int b2 = b(recycler, state, i2 + 1);
            if (b2 <= i3) {
                break;
            }
            i2++;
            i3 = b2;
        }
        aVar.mPosition = i2;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
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
                if (b(recycler, state, position) != 0) {
                    view = view2;
                    childAt = view3;
                } else if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
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

    private int a(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.Ph.getSpanGroupIndex(i, this.Pc);
        }
        int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
        if (convertPreLayoutPositionToPostLayout == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
            return 0;
        }
        return this.Ph.getSpanGroupIndex(convertPreLayoutPositionToPostLayout, this.Pc);
    }

    private int b(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.Ph.H(i, this.Pc);
        }
        int i2 = this.Pg.get(i, -1);
        if (i2 == -1) {
            int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
            if (convertPreLayoutPositionToPostLayout == -1) {
                Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
                return 0;
            }
            return this.Ph.H(convertPreLayoutPositionToPostLayout, this.Pc);
        }
        return i2;
    }

    private int c(RecyclerView.Recycler recycler, RecyclerView.State state, int i) {
        if (!state.isPreLayout()) {
            return this.Ph.getSpanSize(i);
        }
        int i2 = this.Pf.get(i, -1);
        if (i2 == -1) {
            int convertPreLayoutPositionToPostLayout = recycler.convertPreLayoutPositionToPostLayout(i);
            if (convertPreLayoutPositionToPostLayout == -1) {
                Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
                return 1;
            }
            return this.Ph.getSpanSize(convertPreLayoutPositionToPostLayout);
        }
        return i2;
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    int ge() {
        return this.Pc;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    int a(RecyclerView.State state, LinearLayoutManager.b bVar, int[] iArr) {
        int i = this.Pc;
        int i2 = 0;
        while (i2 < this.Pc && bVar.a(state) && i > 0) {
            int i3 = bVar.Pp;
            iArr[i2] = i3;
            i -= this.Ph.getSpanSize(i3);
            bVar.Pp += bVar.Pq;
            i2++;
        }
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00ae, code lost:
        r19.mFinished = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b3, code lost:
        return;
     */
    @Override // android.support.v7.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void a(RecyclerView.Recycler recycler, RecyclerView.State state, LinearLayoutManager.b bVar, LinearLayoutManager.LayoutChunkResult layoutChunkResult) {
        int i;
        int i2;
        int i3;
        int makeMeasureSpec;
        int childMeasureSpec;
        View a;
        int modeInOther = this.PI.getModeInOther();
        boolean z = modeInOther != 1073741824;
        int i4 = getChildCount() > 0 ? this.Pd[this.Pc] : 0;
        if (z) {
            gb();
        }
        boolean z2 = bVar.Pq == 1;
        int i5 = 0;
        int i6 = 0;
        int i7 = this.Pc;
        if (!z2) {
            i7 = b(recycler, state, bVar.Pp) + c(recycler, state, bVar.Pp);
        }
        while (i5 < this.Pc && bVar.a(state) && i7 > 0) {
            int i8 = bVar.Pp;
            int c = c(recycler, state, i8);
            if (c > this.Pc) {
                throw new IllegalArgumentException("Item at position " + i8 + " requires " + c + " spans but GridLayoutManager has only " + this.Pc + " spans.");
            }
            i7 -= c;
            if (i7 < 0 || (a = bVar.a(recycler)) == null) {
                break;
            }
            i6 += c;
            this.Pe[i5] = a;
            i5++;
        }
        a(recycler, state, i5, i6, z2);
        int i9 = 0;
        float f = 0.0f;
        int i10 = 0;
        while (i9 < i5) {
            View view = this.Pe[i9];
            if (bVar.Qd == null) {
                if (z2) {
                    addView(view);
                } else {
                    addView(view, 0);
                }
            } else if (z2) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, 0);
            }
            calculateItemDecorationsForChild(view, this.Pi);
            c(view, modeInOther, false);
            int decoratedMeasurement = this.PI.getDecoratedMeasurement(view);
            if (decoratedMeasurement > i10) {
                i10 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther = (this.PI.getDecoratedMeasurementInOther(view) * 1.0f) / ((LayoutParams) view.getLayoutParams()).Pk;
            if (decoratedMeasurementInOther <= f) {
                decoratedMeasurementInOther = f;
            }
            i9++;
            f = decoratedMeasurementInOther;
        }
        if (z) {
            b(f, i4);
            i10 = 0;
            int i11 = 0;
            while (i11 < i5) {
                View view2 = this.Pe[i11];
                c(view2, 1073741824, true);
                int decoratedMeasurement2 = this.PI.getDecoratedMeasurement(view2);
                if (decoratedMeasurement2 <= i10) {
                    decoratedMeasurement2 = i10;
                }
                i11++;
                i10 = decoratedMeasurement2;
            }
        }
        for (int i12 = 0; i12 < i5; i12++) {
            View view3 = this.Pe[i12];
            if (this.PI.getDecoratedMeasurement(view3) != i10) {
                LayoutParams layoutParams = (LayoutParams) view3.getLayoutParams();
                Rect rect = layoutParams.Pi;
                int i13 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
                int i14 = rect.right + rect.left + layoutParams.leftMargin + layoutParams.rightMargin;
                int G = G(layoutParams.Pj, layoutParams.Pk);
                if (this.At == 1) {
                    makeMeasureSpec = getChildMeasureSpec(G, 1073741824, i14, layoutParams.width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 - i13, 1073741824);
                } else {
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i10 - i14, 1073741824);
                    childMeasureSpec = getChildMeasureSpec(G, 1073741824, i13, layoutParams.height, false);
                }
                a(view3, makeMeasureSpec, childMeasureSpec, true);
            }
        }
        layoutChunkResult.mConsumed = i10;
        int i15 = 0;
        if (this.At == 1) {
            if (bVar.Pr == -1) {
                i15 = bVar.mOffset;
                i3 = i15 - i10;
                i2 = 0;
                i = 0;
            } else {
                int i16 = bVar.mOffset;
                i15 = i16 + i10;
                i3 = i16;
                i2 = 0;
                i = 0;
            }
        } else if (bVar.Pr == -1) {
            int i17 = bVar.mOffset;
            i2 = i17;
            i = i17 - i10;
            i3 = 0;
        } else {
            i = bVar.mOffset;
            i2 = i10 + i;
            i3 = 0;
        }
        int i18 = i15;
        int i19 = i3;
        int i20 = i2;
        int i21 = i;
        for (int i22 = 0; i22 < i5; i22++) {
            View view4 = this.Pe[i22];
            LayoutParams layoutParams2 = (LayoutParams) view4.getLayoutParams();
            if (this.At == 1) {
                if (isLayoutRTL()) {
                    i20 = getPaddingLeft() + this.Pd[this.Pc - layoutParams2.Pj];
                    i21 = i20 - this.PI.getDecoratedMeasurementInOther(view4);
                } else {
                    i21 = getPaddingLeft() + this.Pd[layoutParams2.Pj];
                    i20 = i21 + this.PI.getDecoratedMeasurementInOther(view4);
                }
            } else {
                i19 = getPaddingTop() + this.Pd[layoutParams2.Pj];
                i18 = i19 + this.PI.getDecoratedMeasurementInOther(view4);
            }
            layoutDecoratedWithMargins(view4, i21, i19, i20, i18);
            if (layoutParams2.isItemRemoved() || layoutParams2.isItemChanged()) {
                layoutChunkResult.mIgnoreConsumed = true;
            }
            layoutChunkResult.mFocusable |= view4.isFocusable();
        }
        Arrays.fill(this.Pe, (Object) null);
    }

    private void c(View view, int i, boolean z) {
        int childMeasureSpec;
        int i2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.Pi;
        int i3 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i4 = layoutParams.rightMargin + rect.right + rect.left + layoutParams.leftMargin;
        int G = G(layoutParams.Pj, layoutParams.Pk);
        if (this.At == 1) {
            childMeasureSpec = getChildMeasureSpec(G, i, i4, layoutParams.width, false);
            i2 = getChildMeasureSpec(this.PI.getTotalSpace(), getHeightMode(), i3, layoutParams.height, true);
        } else {
            int childMeasureSpec2 = getChildMeasureSpec(G, i, i3, layoutParams.height, false);
            childMeasureSpec = getChildMeasureSpec(this.PI.getTotalSpace(), getWidthMode(), i4, layoutParams.width, true);
            i2 = childMeasureSpec2;
        }
        a(view, childMeasureSpec, i2, z);
    }

    private void b(float f, int i) {
        bl(Math.max(Math.round(this.Pc * f), i));
    }

    private void a(View view, int i, int i2, boolean z) {
        boolean b;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            b = a(view, i, i2, layoutParams);
        } else {
            b = b(view, i, i2, layoutParams);
        }
        if (b) {
            view.measure(i, i2);
        }
    }

    private void a(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (z) {
            i4 = 1;
            i3 = 0;
        } else {
            int i5 = i - 1;
            i = -1;
            i3 = i5;
            i4 = -1;
        }
        int i6 = 0;
        for (int i7 = i3; i7 != i; i7 += i4) {
            View view = this.Pe[i7];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.Pk = c(recycler, state, getPosition(view));
            layoutParams.Pj = i6;
            i6 += layoutParams.Pk;
        }
    }

    public int getSpanCount() {
        return this.Pc;
    }

    public void setSpanCount(int i) {
        if (i != this.Pc) {
            this.Pb = true;
            if (i < 1) {
                throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
            }
            this.Pc = i;
            this.Ph.invalidateSpanIndexCache();
            requestLayout();
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class SpanSizeLookup {
        final SparseIntArray Pl = new SparseIntArray();
        private boolean Pm = false;

        public abstract int getSpanSize(int i);

        public void setSpanIndexCacheEnabled(boolean z) {
            this.Pm = z;
        }

        public void invalidateSpanIndexCache() {
            this.Pl.clear();
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.Pm;
        }

        int H(int i, int i2) {
            if (!this.Pm) {
                return getSpanIndex(i, i2);
            }
            int i3 = this.Pl.get(i, -1);
            if (i3 == -1) {
                int spanIndex = getSpanIndex(i, i2);
                this.Pl.put(i, spanIndex);
                return spanIndex;
            }
            return i3;
        }

        public int getSpanIndex(int i, int i2) {
            int i3;
            int i4;
            int bm;
            int spanSize = getSpanSize(i);
            if (spanSize == i2) {
                return 0;
            }
            if (!this.Pm || this.Pl.size() <= 0 || (bm = bm(i)) < 0) {
                i3 = 0;
                i4 = 0;
            } else {
                i4 = this.Pl.get(bm) + getSpanSize(bm);
                i3 = bm + 1;
            }
            int i5 = i3;
            while (i5 < i) {
                int spanSize2 = getSpanSize(i5);
                int i6 = i4 + spanSize2;
                if (i6 == i2) {
                    spanSize2 = 0;
                } else if (i6 <= i2) {
                    spanSize2 = i6;
                }
                i5++;
                i4 = spanSize2;
            }
            if (i4 + spanSize <= i2) {
                return i4;
            }
            return 0;
        }

        int bm(int i) {
            int i2 = 0;
            int size = this.Pl.size() - 1;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.Pl.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.Pl.size()) {
                return -1;
            }
            return this.Pl.keyAt(i4);
        }

        public int getSpanGroupIndex(int i, int i2) {
            int spanSize = getSpanSize(i);
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < i) {
                int spanSize2 = getSpanSize(i3);
                int i6 = i5 + spanSize2;
                if (i6 == i2) {
                    i4++;
                    spanSize2 = 0;
                } else if (i6 > i2) {
                    i4++;
                } else {
                    spanSize2 = i6;
                }
                i3++;
                i5 = spanSize2;
            }
            if (i5 + spanSize > i2) {
                return i4 + 1;
            }
            return i4;
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        int i3;
        int childCount;
        int i4;
        int i5;
        View view2;
        View findContainingItemView = findContainingItemView(view);
        if (findContainingItemView == null) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) findContainingItemView.getLayoutParams();
        int i6 = layoutParams.Pj;
        int i7 = layoutParams.Pj + layoutParams.Pk;
        if (super.onFocusSearchFailed(view, i, recycler, state) == null) {
            return null;
        }
        if ((bo(i) == 1) != this.PM) {
            i2 = getChildCount() - 1;
            i3 = -1;
            childCount = -1;
        } else {
            i2 = 0;
            i3 = 1;
            childCount = getChildCount();
        }
        boolean z = this.At == 1 && isLayoutRTL();
        View view3 = null;
        int i8 = -1;
        int i9 = 0;
        int i10 = i2;
        while (i10 != childCount) {
            View childAt = getChildAt(i10);
            if (childAt == findContainingItemView) {
                break;
            }
            if (childAt.isFocusable()) {
                LayoutParams layoutParams2 = (LayoutParams) childAt.getLayoutParams();
                int i11 = layoutParams2.Pj;
                int i12 = layoutParams2.Pj + layoutParams2.Pk;
                if (i11 != i6 || i12 != i7) {
                    boolean z2 = false;
                    if (view3 == null) {
                        z2 = true;
                    } else {
                        int min = Math.min(i12, i7) - Math.max(i11, i6);
                        if (min > i9) {
                            z2 = true;
                        } else if (min == i9) {
                            if (z == (i11 > i8)) {
                                z2 = true;
                            }
                        }
                    }
                    if (z2) {
                        i5 = layoutParams2.Pj;
                        i4 = Math.min(i12, i7) - Math.max(i11, i6);
                        view2 = childAt;
                    } else {
                        i4 = i9;
                        i5 = i8;
                        view2 = view3;
                    }
                } else {
                    return childAt;
                }
            } else {
                i4 = i9;
                i5 = i8;
                view2 = view3;
            }
            i10 += i3;
            view3 = view2;
            i8 = i5;
            i9 = i4;
        }
        return view3;
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.PR == null && !this.Pb;
    }

    /* loaded from: classes2.dex */
    public static final class DefaultSpanSizeLookup extends SpanSizeLookup {
        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int i) {
            return 1;
        }

        @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanIndex(int i, int i2) {
            return i % i2;
        }
    }

    /* loaded from: classes2.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams {
        public static final int INVALID_SPAN_ID = -1;
        int Pj;
        int Pk;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.Pj = -1;
            this.Pk = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.Pj = -1;
            this.Pk = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.Pj = -1;
            this.Pk = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.Pj = -1;
            this.Pk = 0;
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.Pj = -1;
            this.Pk = 0;
        }

        public int getSpanIndex() {
            return this.Pj;
        }

        public int getSpanSize() {
            return this.Pk;
        }
    }
}
