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
    private AbsListView.OnScrollListener Gm;
    private View Gn;
    private int Go;
    private int Gp;
    private int Gq;
    private int Gr;
    private int Gs;
    private int Gt;
    private int Gu;
    private boolean Gv;
    private boolean Gw;
    private a Gx;
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
                PinnedHeaderListView.this.Gs = -1;
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }
        };
        this.Go = -1;
        this.Gw = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        this.Gt = this.Gs;
        setOnScrollToPullListener(new BdListView.g() { // from class: com.baidu.adp.widget.PinnedHeaderListView.2
            @Override // com.baidu.adp.widget.ListView.BdListView.g
            public void onScrollToPull(boolean z) {
                PinnedHeaderListView.this.Gw = z;
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
        this.Gx = (a) listAdapter;
        this.Go = this.Gx.kM();
        this.Gn = this.Gx.kN();
        if (this.Gn != null) {
            if (this.Gn.getLayoutParams() == null) {
                this.Gn.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            setFadingEdgeLength(0);
        }
        this.Gx.registerDataSetObserver(this.mObserver);
    }

    private void r(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.Gn != null) {
            ViewGroup.LayoutParams layoutParams = this.Gn.getLayoutParams();
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
            this.Gn.measure(makeMeasureSpec, makeMeasureSpec2);
            this.Gp = this.Gn.getMeasuredWidth();
            this.Gq = this.Gn.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        kK();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.Gv && !this.Gw && this.Gn.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.Gr);
            drawChild(canvas, this.Gn, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void kK() {
        if (this.Gn != null) {
            a aVar = this.Gx;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = aVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = aVar.getItemViewType(i);
            if (this.Gv) {
                if (itemViewType2 == this.Go) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.Gr = Math.min(this.Gq, Math.max(0, this.Gq - childAt.getTop()));
                        invalidate(0, 0, this.Gp, this.Gq);
                    }
                } else if (itemViewType == this.Go && firstVisiblePosition != this.Gs) {
                    aVar.a(this.Gn, this, firstVisiblePosition);
                    r(getMeasuredWidth(), getMeasuredHeight());
                    this.Gn.layout(0, 0, this.Gp, this.Gq);
                    invalidate(0, 0, this.Gp, this.Gq);
                    this.Gs = firstVisiblePosition;
                    this.Gu = this.Gs;
                } else {
                    this.Gr = 0;
                    invalidate(0, 0, this.Gp, this.Gq);
                }
                int aM = aM(i);
                if (aM == -1) {
                    this.Gv = false;
                    aVar.a(null, this, -1);
                } else if (aM != this.Gu || aM == 0) {
                    aVar.a(this.Gn, this, aM);
                    r(getMeasuredWidth(), getMeasuredHeight());
                    this.Gn.layout(0, 0, this.Gp, this.Gq);
                    invalidate(0, 0, this.Gp, this.Gq);
                    this.Gu = aM;
                    this.Gs = this.Gt;
                }
            } else if (itemViewType == this.Go) {
                this.Gv = true;
                this.Gr = 0;
                aVar.a(this.Gn, this, firstVisiblePosition);
                r(getMeasuredWidth(), getMeasuredHeight());
                this.Gn.layout(0, 0, this.Gp, this.Gq);
                invalidate(0, 0, this.Gp, this.Gq);
                this.Gs = firstVisiblePosition;
                this.Gt = firstVisiblePosition;
            }
        }
    }

    private int aM(int i) {
        a aVar = this.Gx;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (aVar.getItemViewType(i2) == this.Go) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Gm = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.Gm != null) {
            this.Gm.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        kK();
        if (this.Gm != null) {
            this.Gm.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: kL */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }

    /* loaded from: classes.dex */
    public static abstract class a implements ListAdapter {
        private final DataSetObservable Gz = new DataSetObservable();

        public abstract void a(View view2, AdapterView<?> adapterView, int i);

        public abstract int kM();

        public abstract View kN();

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.Gz.registerObserver(dataSetObserver);
        }
    }
}
