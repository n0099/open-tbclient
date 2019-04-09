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
    private AbsListView.OnScrollListener QD;
    private View QE;
    private int QF;
    private int QG;
    private int QH;
    private int QI;
    private int QJ;
    private int QK;
    private int QL;
    private boolean QM;
    private boolean QN;
    private a QO;
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
                PinnedHeaderListView.this.QJ = -1;
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }
        };
        this.QF = -1;
        this.QN = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        this.QK = this.QJ;
        setOnScrollToPullListener(new BdListView.g() { // from class: com.baidu.adp.widget.PinnedHeaderListView.2
            @Override // com.baidu.adp.widget.ListView.BdListView.g
            public void onScrollToPull(boolean z) {
                PinnedHeaderListView.this.QN = z;
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
        this.QO = (a) listAdapter;
        this.QF = this.QO.pj();
        this.QE = this.QO.getPinnedHeaderView();
        if (this.QE != null) {
            if (this.QE.getLayoutParams() == null) {
                this.QE.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            setFadingEdgeLength(0);
        }
        this.QO.registerDataSetObserver(this.mObserver);
    }

    private void v(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.QE != null) {
            ViewGroup.LayoutParams layoutParams = this.QE.getLayoutParams();
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
            this.QE.measure(makeMeasureSpec, makeMeasureSpec2);
            this.QG = this.QE.getMeasuredWidth();
            this.QH = this.QE.getMeasuredHeight();
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
        if (this.QM && !this.QN && this.QE.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.QI);
            drawChild(canvas, this.QE, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void ph() {
        if (this.QE != null) {
            a aVar = this.QO;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = aVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = aVar.getItemViewType(i);
            if (this.QM) {
                if (itemViewType2 == this.QF) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.QI = Math.min(this.QH, Math.max(0, this.QH - childAt.getTop()));
                        invalidate(0, 0, this.QG, this.QH);
                    }
                } else if (itemViewType == this.QF && firstVisiblePosition != this.QJ) {
                    aVar.a(this.QE, this, firstVisiblePosition);
                    v(getMeasuredWidth(), getMeasuredHeight());
                    this.QE.layout(0, 0, this.QG, this.QH);
                    invalidate(0, 0, this.QG, this.QH);
                    this.QJ = firstVisiblePosition;
                    this.QL = this.QJ;
                } else {
                    this.QI = 0;
                    invalidate(0, 0, this.QG, this.QH);
                }
                int aZ = aZ(i);
                if (aZ == -1) {
                    this.QM = false;
                    aVar.a(null, this, -1);
                } else if (aZ != this.QL || aZ == 0) {
                    aVar.a(this.QE, this, aZ);
                    v(getMeasuredWidth(), getMeasuredHeight());
                    this.QE.layout(0, 0, this.QG, this.QH);
                    invalidate(0, 0, this.QG, this.QH);
                    this.QL = aZ;
                    this.QJ = this.QK;
                }
            } else if (itemViewType == this.QF) {
                this.QM = true;
                this.QI = 0;
                aVar.a(this.QE, this, firstVisiblePosition);
                v(getMeasuredWidth(), getMeasuredHeight());
                this.QE.layout(0, 0, this.QG, this.QH);
                invalidate(0, 0, this.QG, this.QH);
                this.QJ = firstVisiblePosition;
                this.QK = firstVisiblePosition;
            }
        }
    }

    private int aZ(int i) {
        a aVar = this.QO;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (aVar.getItemViewType(i2) == this.QF) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.QD = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.QD != null) {
            this.QD.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ph();
        if (this.QD != null) {
            this.QD.onScroll(absListView, i, i2, i3);
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
        private final DataSetObservable QR = new DataSetObservable();

        public abstract void a(View view, AdapterView<?> adapterView, int i);

        public abstract View getPinnedHeaderView();

        public abstract int pj();

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.QR.registerObserver(dataSetObserver);
        }
    }
}
