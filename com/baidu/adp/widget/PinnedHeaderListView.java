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
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
/* loaded from: classes.dex */
public class PinnedHeaderListView extends BdListView implements AbsListView.OnScrollListener {
    private AbsListView.OnScrollListener Pk;
    private View Pl;
    private int Pm;
    private int Pn;
    private int Po;
    private int Pp;
    private int Pq;
    private int Pr;
    private int Ps;
    private boolean Pt;
    private boolean Pu;
    private a Pv;
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
                PinnedHeaderListView.this.Pq = -1;
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }
        };
        this.Pm = -1;
        this.Pu = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        this.Pr = this.Pq;
        setOnScrollToPullListener(new BdListView.g() { // from class: com.baidu.adp.widget.PinnedHeaderListView.2
            @Override // com.baidu.adp.widget.ListView.BdListView.g
            public void onScrollToPull(boolean z) {
                PinnedHeaderListView.this.Pu = z;
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
        this.Pv = (a) listAdapter;
        this.Pm = this.Pv.oP();
        this.Pl = this.Pv.getPinnedHeaderView();
        if (this.Pl != null) {
            if (this.Pl.getLayoutParams() == null) {
                this.Pl.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            setFadingEdgeLength(0);
        }
        this.Pv.registerDataSetObserver(this.mObserver);
    }

    private void t(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.Pl != null) {
            ViewGroup.LayoutParams layoutParams = this.Pl.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
            }
            switch (layoutParams.width) {
                case -2:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i, AiAppsFileUtils.GB);
                    break;
                default:
                    makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(layoutParams.width, AiAppsFileUtils.GB);
                    break;
            }
            switch (layoutParams.height) {
                case -2:
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
                    break;
                case -1:
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i2, AiAppsFileUtils.GB);
                    break;
                default:
                    makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(layoutParams.height, AiAppsFileUtils.GB);
                    break;
            }
            this.Pl.measure(makeMeasureSpec, makeMeasureSpec2);
            this.Pn = this.Pl.getMeasuredWidth();
            this.Po = this.Pl.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        oN();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.Pt && !this.Pu && this.Pl.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.Pp);
            drawChild(canvas, this.Pl, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void oN() {
        if (this.Pl != null) {
            a aVar = this.Pv;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = aVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = aVar.getItemViewType(i);
            if (this.Pt) {
                if (itemViewType2 == this.Pm) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.Pp = Math.min(this.Po, Math.max(0, this.Po - childAt.getTop()));
                        invalidate(0, 0, this.Pn, this.Po);
                    }
                } else if (itemViewType == this.Pm && firstVisiblePosition != this.Pq) {
                    aVar.a(this.Pl, this, firstVisiblePosition);
                    t(getMeasuredWidth(), getMeasuredHeight());
                    this.Pl.layout(0, 0, this.Pn, this.Po);
                    invalidate(0, 0, this.Pn, this.Po);
                    this.Pq = firstVisiblePosition;
                    this.Ps = this.Pq;
                } else {
                    this.Pp = 0;
                    invalidate(0, 0, this.Pn, this.Po);
                }
                int aY = aY(i);
                if (aY == -1) {
                    this.Pt = false;
                    aVar.a(null, this, -1);
                } else if (aY != this.Ps || aY == 0) {
                    aVar.a(this.Pl, this, aY);
                    t(getMeasuredWidth(), getMeasuredHeight());
                    this.Pl.layout(0, 0, this.Pn, this.Po);
                    invalidate(0, 0, this.Pn, this.Po);
                    this.Ps = aY;
                    this.Pq = this.Pr;
                }
            } else if (itemViewType == this.Pm) {
                this.Pt = true;
                this.Pp = 0;
                aVar.a(this.Pl, this, firstVisiblePosition);
                t(getMeasuredWidth(), getMeasuredHeight());
                this.Pl.layout(0, 0, this.Pn, this.Po);
                invalidate(0, 0, this.Pn, this.Po);
                this.Pq = firstVisiblePosition;
                this.Pr = firstVisiblePosition;
            }
        }
    }

    private int aY(int i) {
        a aVar = this.Pv;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (aVar.getItemViewType(i2) == this.Pm) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Pk = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.Pk != null) {
            this.Pk.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        oN();
        if (this.Pk != null) {
            this.Pk.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: oO */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }

    /* loaded from: classes.dex */
    public static abstract class a implements ListAdapter {
        private final DataSetObservable Px = new DataSetObservable();

        public abstract void a(View view, AdapterView<?> adapterView, int i);

        public abstract View getPinnedHeaderView();

        public abstract int oP();

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.Px.registerObserver(dataSetObserver);
        }
    }
}
