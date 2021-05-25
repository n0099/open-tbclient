package com.baidu.adp.widget;

import android.content.Context;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
/* loaded from: classes.dex */
public class PinnedHeaderListView extends BdListView implements AbsListView.OnScrollListener {
    public AbsListView.OnScrollListener K;
    public final DataSetObserver L;
    public View M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public int T;
    public boolean U;
    public boolean V;
    public c W;

    /* loaded from: classes.dex */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            PinnedHeaderListView.this.requestLayout();
            PinnedHeaderListView.this.invalidate();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            PinnedHeaderListView.this.R = -1;
            PinnedHeaderListView.this.requestLayout();
            PinnedHeaderListView.this.invalidate();
        }
    }

    /* loaded from: classes.dex */
    public class b implements BdListView.r {
        public b() {
        }

        @Override // com.baidu.adp.widget.ListView.BdListView.r
        public void onScrollToPull(boolean z) {
            PinnedHeaderListView.this.V = z;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c implements ListAdapter {

        /* renamed from: e  reason: collision with root package name */
        public final DataSetObservable f2391e = new DataSetObservable();

        public abstract View a();

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            return true;
        }

        public abstract int b();

        public abstract void c(View view, AdapterView<?> adapterView, int i2);

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i2) {
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.f2391e.registerObserver(dataSetObserver);
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            this.f2391e.unregisterObserver(dataSetObserver);
        }
    }

    public PinnedHeaderListView(Context context) {
        this(context, null, 0);
        L();
    }

    public final void I() {
        if (this.M == null) {
            return;
        }
        c cVar = this.W;
        int firstVisiblePosition = getFirstVisiblePosition();
        if (firstVisiblePosition > 0) {
            firstVisiblePosition--;
        }
        int i2 = firstVisiblePosition + 1;
        int itemViewType = cVar.getItemViewType(firstVisiblePosition);
        int itemViewType2 = cVar.getItemViewType(i2);
        if (this.U) {
            int i3 = this.N;
            if (itemViewType2 == i3) {
                View childAt = getChildAt(1);
                if (childAt != null) {
                    int i4 = this.P;
                    this.Q = Math.min(i4, Math.max(0, i4 - childAt.getTop()));
                    invalidate(0, 0, this.O, this.P);
                }
            } else if (itemViewType == i3 && firstVisiblePosition != this.R) {
                cVar.c(this.M, this, firstVisiblePosition);
                M(getMeasuredWidth(), getMeasuredHeight());
                this.M.layout(0, 0, this.O, this.P);
                invalidate(0, 0, this.O, this.P);
                this.R = firstVisiblePosition;
                this.T = firstVisiblePosition;
            } else {
                this.Q = 0;
                invalidate(0, 0, this.O, this.P);
            }
            int K = K(i2);
            if (K == -1) {
                this.U = false;
                cVar.c(null, this, -1);
            } else if (K != this.T || K == 0) {
                cVar.c(this.M, this, K);
                M(getMeasuredWidth(), getMeasuredHeight());
                this.M.layout(0, 0, this.O, this.P);
                invalidate(0, 0, this.O, this.P);
                this.T = K;
                this.R = this.S;
            }
        } else if (itemViewType == this.N) {
            this.U = true;
            this.Q = 0;
            cVar.c(this.M, this, firstVisiblePosition);
            M(getMeasuredWidth(), getMeasuredHeight());
            this.M.layout(0, 0, this.O, this.P);
            invalidate(0, 0, this.O, this.P);
            this.R = firstVisiblePosition;
            this.S = firstVisiblePosition;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: J */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }

    public final int K(int i2) {
        c cVar = this.W;
        for (int i3 = i2 - 1; i3 >= 0; i3--) {
            if (cVar.getItemViewType(i3) == this.N) {
                return i3;
            }
        }
        return -1;
    }

    public final void L() {
        this.S = this.R;
        setOnScrollToPullListener(new b());
    }

    public final void M(int i2, int i3) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        View view = this.M;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
            }
            int i4 = layoutParams.width;
            if (i4 == -2) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
            } else if (i4 != -1) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
            }
            int i5 = layoutParams.height;
            if (i5 == -2) {
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, Integer.MIN_VALUE);
            } else if (i5 != -1) {
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i5, 1073741824);
            } else {
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
            }
            this.M.measure(makeMeasureSpec, makeMeasureSpec2);
            this.O = this.M.getMeasuredWidth();
            this.P = this.M.getMeasuredHeight();
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.U && !this.V && this.M.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.Q);
            drawChild(canvas, this.M, drawingTime);
            if (save < 1 || save > canvas.getSaveCount()) {
                return;
            }
            canvas.restoreToCount(save);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        I();
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        I();
        AbsListView.OnScrollListener onScrollListener = this.K;
        if (onScrollListener != null) {
            onScrollListener.onScroll(absListView, i2, i3, i4);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i2) {
        AbsListView.OnScrollListener onScrollListener = this.K;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i2);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.K = onScrollListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof c) {
            super.setAdapter(listAdapter);
            c cVar = (c) listAdapter;
            this.W = cVar;
            this.N = cVar.b();
            View a2 = this.W.a();
            this.M = a2;
            if (a2 != null) {
                if (a2.getLayoutParams() == null) {
                    this.M.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                }
                setFadingEdgeLength(0);
            }
            this.W.registerDataSetObserver(this.L);
            return;
        }
        throw new RuntimeException("Adapter must extended from PinnedHeaderListAdapter");
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        L();
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.L = new a();
        this.N = -1;
        this.V = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        L();
    }
}
