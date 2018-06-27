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
    private int MA;
    private int MC;
    private int MD;
    private int ME;
    private int MF;
    private boolean MG;
    private boolean MH;
    private a MI;
    private AbsListView.OnScrollListener Mw;
    private View Mx;
    private int My;
    private int Mz;
    private final DataSetObserver mObserver;

    public PinnedHeaderListView(Context context) {
        this(context, null, 0);
        init();
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        init();
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mObserver = new DataSetObserver() { // from class: com.baidu.adp.widget.PinnedHeaderListView.1
            @Override // android.database.DataSetObserver
            public void onChanged() {
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }

            @Override // android.database.DataSetObserver
            public void onInvalidated() {
                PinnedHeaderListView.this.MD = -1;
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }
        };
        this.My = -1;
        this.MH = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        this.ME = this.MD;
        setOnScrollToPullListener(new BdListView.g() { // from class: com.baidu.adp.widget.PinnedHeaderListView.2
            @Override // com.baidu.adp.widget.ListView.BdListView.g
            public void onScrollToPull(boolean z) {
                PinnedHeaderListView.this.MH = z;
            }
        });
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        if (!(listAdapter instanceof a)) {
            throw new RuntimeException("Adapter must extended from PinnedHeaderListAdapter");
        }
        super.setAdapter(listAdapter);
        this.MI = (a) listAdapter;
        this.My = this.MI.nA();
        this.Mx = this.MI.nB();
        if (this.Mx != null) {
            if (this.Mx.getLayoutParams() == null) {
                this.Mx.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            setFadingEdgeLength(0);
        }
        this.MI.registerDataSetObserver(this.mObserver);
    }

    private void r(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.Mx != null) {
            ViewGroup.LayoutParams layoutParams = this.Mx.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
            }
            switch (layoutParams.width) {
                case -2:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
                    break;
                default:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.width, 1073741824);
                    break;
            }
            switch (layoutParams.height) {
                case -2:
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, 1073741824);
                    break;
                default:
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
                    break;
            }
            this.Mx.measure(makeMeasureSpec, makeMeasureSpec2);
            this.Mz = this.Mx.getMeasuredWidth();
            this.MA = this.Mx.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ny();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.MG && !this.MH && this.Mx.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.MC);
            drawChild(canvas, this.Mx, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void ny() {
        if (this.Mx != null) {
            a aVar = this.MI;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = aVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = aVar.getItemViewType(i);
            if (this.MG) {
                if (itemViewType2 == this.My) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.MC = Math.min(this.MA, Math.max(0, this.MA - childAt.getTop()));
                        invalidate(0, 0, this.Mz, this.MA);
                    }
                } else if (itemViewType == this.My && firstVisiblePosition != this.MD) {
                    aVar.a(this.Mx, this, firstVisiblePosition);
                    r(getMeasuredWidth(), getMeasuredHeight());
                    this.Mx.layout(0, 0, this.Mz, this.MA);
                    invalidate(0, 0, this.Mz, this.MA);
                    this.MD = firstVisiblePosition;
                    this.MF = this.MD;
                } else {
                    this.MC = 0;
                    invalidate(0, 0, this.Mz, this.MA);
                }
                int aN = aN(i);
                if (aN == -1) {
                    this.MG = false;
                    aVar.a(null, this, -1);
                } else if (aN != this.MF || aN == 0) {
                    aVar.a(this.Mx, this, aN);
                    r(getMeasuredWidth(), getMeasuredHeight());
                    this.Mx.layout(0, 0, this.Mz, this.MA);
                    invalidate(0, 0, this.Mz, this.MA);
                    this.MF = aN;
                    this.MD = this.ME;
                }
            } else if (itemViewType == this.My) {
                this.MG = true;
                this.MC = 0;
                aVar.a(this.Mx, this, firstVisiblePosition);
                r(getMeasuredWidth(), getMeasuredHeight());
                this.Mx.layout(0, 0, this.Mz, this.MA);
                invalidate(0, 0, this.Mz, this.MA);
                this.MD = firstVisiblePosition;
                this.ME = firstVisiblePosition;
            }
        }
    }

    private int aN(int i) {
        a aVar = this.MI;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (aVar.getItemViewType(i2) == this.My) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Mw = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.Mw != null) {
            this.Mw.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ny();
        if (this.Mw != null) {
            this.Mw.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: nz */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }

    /* loaded from: classes.dex */
    public static abstract class a implements ListAdapter {
        private final DataSetObservable MK = new DataSetObservable();

        public abstract void a(View view, AdapterView<?> adapterView, int i);

        public abstract int nA();

        public abstract View nB();

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.MK.registerObserver(dataSetObserver);
        }
    }
}
