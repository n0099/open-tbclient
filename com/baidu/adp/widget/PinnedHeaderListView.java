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
    private int PA;
    private int PD;
    private int PE;
    private boolean PF;
    private boolean PG;
    private a PH;
    private AbsListView.OnScrollListener Pu;
    private View Pv;
    private int Pw;
    private int Px;
    private int Py;
    private int Pz;
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
                PinnedHeaderListView.this.PA = -1;
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }
        };
        this.Pw = -1;
        this.PG = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        this.PD = this.PA;
        setOnScrollToPullListener(new BdListView.g() { // from class: com.baidu.adp.widget.PinnedHeaderListView.2
            @Override // com.baidu.adp.widget.ListView.BdListView.g
            public void onScrollToPull(boolean z) {
                PinnedHeaderListView.this.PG = z;
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
        this.PH = (a) listAdapter;
        this.Pw = this.PH.oQ();
        this.Pv = this.PH.getPinnedHeaderView();
        if (this.Pv != null) {
            if (this.Pv.getLayoutParams() == null) {
                this.Pv.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            setFadingEdgeLength(0);
        }
        this.PH.registerDataSetObserver(this.mObserver);
    }

    private void t(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.Pv != null) {
            ViewGroup.LayoutParams layoutParams = this.Pv.getLayoutParams();
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
            this.Pv.measure(makeMeasureSpec, makeMeasureSpec2);
            this.Px = this.Pv.getMeasuredWidth();
            this.Py = this.Pv.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        oO();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.PF && !this.PG && this.Pv.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.Pz);
            drawChild(canvas, this.Pv, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void oO() {
        if (this.Pv != null) {
            a aVar = this.PH;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = aVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = aVar.getItemViewType(i);
            if (this.PF) {
                if (itemViewType2 == this.Pw) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.Pz = Math.min(this.Py, Math.max(0, this.Py - childAt.getTop()));
                        invalidate(0, 0, this.Px, this.Py);
                    }
                } else if (itemViewType == this.Pw && firstVisiblePosition != this.PA) {
                    aVar.a(this.Pv, this, firstVisiblePosition);
                    t(getMeasuredWidth(), getMeasuredHeight());
                    this.Pv.layout(0, 0, this.Px, this.Py);
                    invalidate(0, 0, this.Px, this.Py);
                    this.PA = firstVisiblePosition;
                    this.PE = this.PA;
                } else {
                    this.Pz = 0;
                    invalidate(0, 0, this.Px, this.Py);
                }
                int bn = bn(i);
                if (bn == -1) {
                    this.PF = false;
                    aVar.a(null, this, -1);
                } else if (bn != this.PE || bn == 0) {
                    aVar.a(this.Pv, this, bn);
                    t(getMeasuredWidth(), getMeasuredHeight());
                    this.Pv.layout(0, 0, this.Px, this.Py);
                    invalidate(0, 0, this.Px, this.Py);
                    this.PE = bn;
                    this.PA = this.PD;
                }
            } else if (itemViewType == this.Pw) {
                this.PF = true;
                this.Pz = 0;
                aVar.a(this.Pv, this, firstVisiblePosition);
                t(getMeasuredWidth(), getMeasuredHeight());
                this.Pv.layout(0, 0, this.Px, this.Py);
                invalidate(0, 0, this.Px, this.Py);
                this.PA = firstVisiblePosition;
                this.PD = firstVisiblePosition;
            }
        }
    }

    private int bn(int i) {
        a aVar = this.PH;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (aVar.getItemViewType(i2) == this.Pw) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Pu = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.Pu != null) {
            this.Pu.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        oO();
        if (this.Pu != null) {
            this.Pu.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: oP */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }

    /* loaded from: classes.dex */
    public static abstract class a implements ListAdapter {
        private final DataSetObservable PJ = new DataSetObservable();

        public abstract void a(View view, AdapterView<?> adapterView, int i);

        public abstract View getPinnedHeaderView();

        public abstract int oQ();

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.PJ.registerObserver(dataSetObserver);
        }
    }
}
