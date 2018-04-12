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
    private boolean GA;
    private a GC;
    private AbsListView.OnScrollListener Gq;
    private View Gr;
    private int Gs;
    private int Gt;
    private int Gu;
    private int Gv;
    private int Gw;
    private int Gx;
    private int Gy;
    private boolean Gz;
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
                PinnedHeaderListView.this.Gw = -1;
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }
        };
        this.Gs = -1;
        this.GA = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        this.Gx = this.Gw;
        setOnScrollToPullListener(new BdListView.g() { // from class: com.baidu.adp.widget.PinnedHeaderListView.2
            @Override // com.baidu.adp.widget.ListView.BdListView.g
            public void onScrollToPull(boolean z) {
                PinnedHeaderListView.this.GA = z;
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
        this.GC = (a) listAdapter;
        this.Gs = this.GC.kN();
        this.Gr = this.GC.kO();
        if (this.Gr != null) {
            if (this.Gr.getLayoutParams() == null) {
                this.Gr.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            setFadingEdgeLength(0);
        }
        this.GC.registerDataSetObserver(this.mObserver);
    }

    private void r(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.Gr != null) {
            ViewGroup.LayoutParams layoutParams = this.Gr.getLayoutParams();
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
            this.Gr.measure(makeMeasureSpec, makeMeasureSpec2);
            this.Gt = this.Gr.getMeasuredWidth();
            this.Gu = this.Gr.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        kL();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.Gz && !this.GA && this.Gr.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.Gv);
            drawChild(canvas, this.Gr, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void kL() {
        if (this.Gr != null) {
            a aVar = this.GC;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = aVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = aVar.getItemViewType(i);
            if (this.Gz) {
                if (itemViewType2 == this.Gs) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.Gv = Math.min(this.Gu, Math.max(0, this.Gu - childAt.getTop()));
                        invalidate(0, 0, this.Gt, this.Gu);
                    }
                } else if (itemViewType == this.Gs && firstVisiblePosition != this.Gw) {
                    aVar.a(this.Gr, this, firstVisiblePosition);
                    r(getMeasuredWidth(), getMeasuredHeight());
                    this.Gr.layout(0, 0, this.Gt, this.Gu);
                    invalidate(0, 0, this.Gt, this.Gu);
                    this.Gw = firstVisiblePosition;
                    this.Gy = this.Gw;
                } else {
                    this.Gv = 0;
                    invalidate(0, 0, this.Gt, this.Gu);
                }
                int aM = aM(i);
                if (aM == -1) {
                    this.Gz = false;
                    aVar.a(null, this, -1);
                } else if (aM != this.Gy || aM == 0) {
                    aVar.a(this.Gr, this, aM);
                    r(getMeasuredWidth(), getMeasuredHeight());
                    this.Gr.layout(0, 0, this.Gt, this.Gu);
                    invalidate(0, 0, this.Gt, this.Gu);
                    this.Gy = aM;
                    this.Gw = this.Gx;
                }
            } else if (itemViewType == this.Gs) {
                this.Gz = true;
                this.Gv = 0;
                aVar.a(this.Gr, this, firstVisiblePosition);
                r(getMeasuredWidth(), getMeasuredHeight());
                this.Gr.layout(0, 0, this.Gt, this.Gu);
                invalidate(0, 0, this.Gt, this.Gu);
                this.Gw = firstVisiblePosition;
                this.Gx = firstVisiblePosition;
            }
        }
    }

    private int aM(int i) {
        a aVar = this.GC;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (aVar.getItemViewType(i2) == this.Gs) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Gq = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.Gq != null) {
            this.Gq.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        kL();
        if (this.Gq != null) {
            this.Gq.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: kM */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }

    /* loaded from: classes.dex */
    public static abstract class a implements ListAdapter {
        private final DataSetObservable GE = new DataSetObservable();

        public abstract void a(View view2, AdapterView<?> adapterView, int i);

        public abstract int kN();

        public abstract View kO();

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.GE.registerObserver(dataSetObserver);
        }
    }
}
