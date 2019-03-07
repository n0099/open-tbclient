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
    private AbsListView.OnScrollListener QB;
    private View QC;
    private int QD;
    private int QE;
    private int QF;
    private int QG;
    private int QH;
    private int QI;
    private int QJ;
    private boolean QK;
    private boolean QL;
    private a QM;
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
                PinnedHeaderListView.this.QH = -1;
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }
        };
        this.QD = -1;
        this.QL = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        this.QI = this.QH;
        setOnScrollToPullListener(new BdListView.g() { // from class: com.baidu.adp.widget.PinnedHeaderListView.2
            @Override // com.baidu.adp.widget.ListView.BdListView.g
            public void onScrollToPull(boolean z) {
                PinnedHeaderListView.this.QL = z;
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
        this.QM = (a) listAdapter;
        this.QD = this.QM.pj();
        this.QC = this.QM.getPinnedHeaderView();
        if (this.QC != null) {
            if (this.QC.getLayoutParams() == null) {
                this.QC.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            setFadingEdgeLength(0);
        }
        this.QM.registerDataSetObserver(this.mObserver);
    }

    private void v(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.QC != null) {
            ViewGroup.LayoutParams layoutParams = this.QC.getLayoutParams();
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
            this.QC.measure(makeMeasureSpec, makeMeasureSpec2);
            this.QE = this.QC.getMeasuredWidth();
            this.QF = this.QC.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ph();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.QK && !this.QL && this.QC.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.QG);
            drawChild(canvas, this.QC, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void ph() {
        if (this.QC != null) {
            a aVar = this.QM;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = aVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = aVar.getItemViewType(i);
            if (this.QK) {
                if (itemViewType2 == this.QD) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.QG = Math.min(this.QF, Math.max(0, this.QF - childAt.getTop()));
                        invalidate(0, 0, this.QE, this.QF);
                    }
                } else if (itemViewType == this.QD && firstVisiblePosition != this.QH) {
                    aVar.a(this.QC, this, firstVisiblePosition);
                    v(getMeasuredWidth(), getMeasuredHeight());
                    this.QC.layout(0, 0, this.QE, this.QF);
                    invalidate(0, 0, this.QE, this.QF);
                    this.QH = firstVisiblePosition;
                    this.QJ = this.QH;
                } else {
                    this.QG = 0;
                    invalidate(0, 0, this.QE, this.QF);
                }
                int ba = ba(i);
                if (ba == -1) {
                    this.QK = false;
                    aVar.a(null, this, -1);
                } else if (ba != this.QJ || ba == 0) {
                    aVar.a(this.QC, this, ba);
                    v(getMeasuredWidth(), getMeasuredHeight());
                    this.QC.layout(0, 0, this.QE, this.QF);
                    invalidate(0, 0, this.QE, this.QF);
                    this.QJ = ba;
                    this.QH = this.QI;
                }
            } else if (itemViewType == this.QD) {
                this.QK = true;
                this.QG = 0;
                aVar.a(this.QC, this, firstVisiblePosition);
                v(getMeasuredWidth(), getMeasuredHeight());
                this.QC.layout(0, 0, this.QE, this.QF);
                invalidate(0, 0, this.QE, this.QF);
                this.QH = firstVisiblePosition;
                this.QI = firstVisiblePosition;
            }
        }
    }

    private int ba(int i) {
        a aVar = this.QM;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (aVar.getItemViewType(i2) == this.QD) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.QB = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.QB != null) {
            this.QB.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ph();
        if (this.QB != null) {
            this.QB.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: pi */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }

    /* loaded from: classes.dex */
    public static abstract class a implements ListAdapter {
        private final DataSetObservable QO = new DataSetObservable();

        public abstract void a(View view, AdapterView<?> adapterView, int i);

        public abstract View getPinnedHeaderView();

        public abstract int pj();

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.QO.registerObserver(dataSetObserver);
        }
    }
}
