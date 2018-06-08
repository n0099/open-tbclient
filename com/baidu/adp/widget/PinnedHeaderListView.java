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
    private boolean ME;
    private boolean MF;
    private a MG;
    private AbsListView.OnScrollListener Mu;
    private View Mv;
    private int Mw;
    private int Mx;
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
                PinnedHeaderListView.this.MA = -1;
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }
        };
        this.Mw = -1;
        this.MF = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        this.MC = this.MA;
        setOnScrollToPullListener(new BdListView.g() { // from class: com.baidu.adp.widget.PinnedHeaderListView.2
            @Override // com.baidu.adp.widget.ListView.BdListView.g
            public void onScrollToPull(boolean z) {
                PinnedHeaderListView.this.MF = z;
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
        this.MG = (a) listAdapter;
        this.Mw = this.MG.nA();
        this.Mv = this.MG.nB();
        if (this.Mv != null) {
            if (this.Mv.getLayoutParams() == null) {
                this.Mv.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            setFadingEdgeLength(0);
        }
        this.MG.registerDataSetObserver(this.mObserver);
    }

    private void r(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.Mv != null) {
            ViewGroup.LayoutParams layoutParams = this.Mv.getLayoutParams();
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
            this.Mv.measure(makeMeasureSpec, makeMeasureSpec2);
            this.Mx = this.Mv.getMeasuredWidth();
            this.My = this.Mv.getMeasuredHeight();
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
        if (this.ME && !this.MF && this.Mv.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.Mz);
            drawChild(canvas, this.Mv, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void ny() {
        if (this.Mv != null) {
            a aVar = this.MG;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = aVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = aVar.getItemViewType(i);
            if (this.ME) {
                if (itemViewType2 == this.Mw) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.Mz = Math.min(this.My, Math.max(0, this.My - childAt.getTop()));
                        invalidate(0, 0, this.Mx, this.My);
                    }
                } else if (itemViewType == this.Mw && firstVisiblePosition != this.MA) {
                    aVar.a(this.Mv, this, firstVisiblePosition);
                    r(getMeasuredWidth(), getMeasuredHeight());
                    this.Mv.layout(0, 0, this.Mx, this.My);
                    invalidate(0, 0, this.Mx, this.My);
                    this.MA = firstVisiblePosition;
                    this.MD = this.MA;
                } else {
                    this.Mz = 0;
                    invalidate(0, 0, this.Mx, this.My);
                }
                int aN = aN(i);
                if (aN == -1) {
                    this.ME = false;
                    aVar.a(null, this, -1);
                } else if (aN != this.MD || aN == 0) {
                    aVar.a(this.Mv, this, aN);
                    r(getMeasuredWidth(), getMeasuredHeight());
                    this.Mv.layout(0, 0, this.Mx, this.My);
                    invalidate(0, 0, this.Mx, this.My);
                    this.MD = aN;
                    this.MA = this.MC;
                }
            } else if (itemViewType == this.Mw) {
                this.ME = true;
                this.Mz = 0;
                aVar.a(this.Mv, this, firstVisiblePosition);
                r(getMeasuredWidth(), getMeasuredHeight());
                this.Mv.layout(0, 0, this.Mx, this.My);
                invalidate(0, 0, this.Mx, this.My);
                this.MA = firstVisiblePosition;
                this.MC = firstVisiblePosition;
            }
        }
    }

    private int aN(int i) {
        a aVar = this.MG;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (aVar.getItemViewType(i2) == this.Mw) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Mu = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.Mu != null) {
            this.Mu.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ny();
        if (this.Mu != null) {
            this.Mu.onScroll(absListView, i, i2, i3);
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
        private final DataSetObservable MI = new DataSetObservable();

        public abstract void a(View view, AdapterView<?> adapterView, int i);

        public abstract int nA();

        public abstract View nB();

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.MI.registerObserver(dataSetObserver);
        }
    }
}
