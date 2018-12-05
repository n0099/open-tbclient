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
    private AbsListView.OnScrollListener Pl;
    private View Pm;
    private int Pn;
    private int Po;
    private int Pp;
    private int Pq;
    private int Pr;
    private int Ps;
    private int Pt;
    private boolean Pu;
    private boolean Pv;
    private a Pw;
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
                PinnedHeaderListView.this.Pr = -1;
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }
        };
        this.Pn = -1;
        this.Pv = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        this.Ps = this.Pr;
        setOnScrollToPullListener(new BdListView.g() { // from class: com.baidu.adp.widget.PinnedHeaderListView.2
            @Override // com.baidu.adp.widget.ListView.BdListView.g
            public void onScrollToPull(boolean z) {
                PinnedHeaderListView.this.Pv = z;
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
        this.Pw = (a) listAdapter;
        this.Pn = this.Pw.oM();
        this.Pm = this.Pw.getPinnedHeaderView();
        if (this.Pm != null) {
            if (this.Pm.getLayoutParams() == null) {
                this.Pm.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            setFadingEdgeLength(0);
        }
        this.Pw.registerDataSetObserver(this.mObserver);
    }

    private void t(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.Pm != null) {
            ViewGroup.LayoutParams layoutParams = this.Pm.getLayoutParams();
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
            this.Pm.measure(makeMeasureSpec, makeMeasureSpec2);
            this.Po = this.Pm.getMeasuredWidth();
            this.Pp = this.Pm.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        oK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.Pu && !this.Pv && this.Pm.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.Pq);
            drawChild(canvas, this.Pm, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void oK() {
        if (this.Pm != null) {
            a aVar = this.Pw;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = aVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = aVar.getItemViewType(i);
            if (this.Pu) {
                if (itemViewType2 == this.Pn) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.Pq = Math.min(this.Pp, Math.max(0, this.Pp - childAt.getTop()));
                        invalidate(0, 0, this.Po, this.Pp);
                    }
                } else if (itemViewType == this.Pn && firstVisiblePosition != this.Pr) {
                    aVar.a(this.Pm, this, firstVisiblePosition);
                    t(getMeasuredWidth(), getMeasuredHeight());
                    this.Pm.layout(0, 0, this.Po, this.Pp);
                    invalidate(0, 0, this.Po, this.Pp);
                    this.Pr = firstVisiblePosition;
                    this.Pt = this.Pr;
                } else {
                    this.Pq = 0;
                    invalidate(0, 0, this.Po, this.Pp);
                }
                int bn = bn(i);
                if (bn == -1) {
                    this.Pu = false;
                    aVar.a(null, this, -1);
                } else if (bn != this.Pt || bn == 0) {
                    aVar.a(this.Pm, this, bn);
                    t(getMeasuredWidth(), getMeasuredHeight());
                    this.Pm.layout(0, 0, this.Po, this.Pp);
                    invalidate(0, 0, this.Po, this.Pp);
                    this.Pt = bn;
                    this.Pr = this.Ps;
                }
            } else if (itemViewType == this.Pn) {
                this.Pu = true;
                this.Pq = 0;
                aVar.a(this.Pm, this, firstVisiblePosition);
                t(getMeasuredWidth(), getMeasuredHeight());
                this.Pm.layout(0, 0, this.Po, this.Pp);
                invalidate(0, 0, this.Po, this.Pp);
                this.Pr = firstVisiblePosition;
                this.Ps = firstVisiblePosition;
            }
        }
    }

    private int bn(int i) {
        a aVar = this.Pw;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (aVar.getItemViewType(i2) == this.Pn) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Pl = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.Pl != null) {
            this.Pl.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        oK();
        if (this.Pl != null) {
            this.Pl.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: oL */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }

    /* loaded from: classes.dex */
    public static abstract class a implements ListAdapter {
        private final DataSetObservable Py = new DataSetObservable();

        public abstract void a(View view, AdapterView<?> adapterView, int i);

        public abstract View getPinnedHeaderView();

        public abstract int oM();

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.Py.registerObserver(dataSetObserver);
        }
    }
}
