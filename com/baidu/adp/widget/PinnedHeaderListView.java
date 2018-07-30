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
    private boolean MB;
    private boolean MC;
    private a MD;
    private AbsListView.OnScrollListener Ms;
    private View Mt;
    private int Mu;
    private int Mv;
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
                PinnedHeaderListView.this.My = -1;
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }
        };
        this.Mu = -1;
        this.MC = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        this.Mz = this.My;
        setOnScrollToPullListener(new BdListView.g() { // from class: com.baidu.adp.widget.PinnedHeaderListView.2
            @Override // com.baidu.adp.widget.ListView.BdListView.g
            public void onScrollToPull(boolean z) {
                PinnedHeaderListView.this.MC = z;
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
        this.MD = (a) listAdapter;
        this.Mu = this.MD.nC();
        this.Mt = this.MD.nD();
        if (this.Mt != null) {
            if (this.Mt.getLayoutParams() == null) {
                this.Mt.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            setFadingEdgeLength(0);
        }
        this.MD.registerDataSetObserver(this.mObserver);
    }

    private void r(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.Mt != null) {
            ViewGroup.LayoutParams layoutParams = this.Mt.getLayoutParams();
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
            this.Mt.measure(makeMeasureSpec, makeMeasureSpec2);
            this.Mv = this.Mt.getMeasuredWidth();
            this.Mw = this.Mt.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        nA();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.MB && !this.MC && this.Mt.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.Mx);
            drawChild(canvas, this.Mt, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void nA() {
        if (this.Mt != null) {
            a aVar = this.MD;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = aVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = aVar.getItemViewType(i);
            if (this.MB) {
                if (itemViewType2 == this.Mu) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.Mx = Math.min(this.Mw, Math.max(0, this.Mw - childAt.getTop()));
                        invalidate(0, 0, this.Mv, this.Mw);
                    }
                } else if (itemViewType == this.Mu && firstVisiblePosition != this.My) {
                    aVar.a(this.Mt, this, firstVisiblePosition);
                    r(getMeasuredWidth(), getMeasuredHeight());
                    this.Mt.layout(0, 0, this.Mv, this.Mw);
                    invalidate(0, 0, this.Mv, this.Mw);
                    this.My = firstVisiblePosition;
                    this.MA = this.My;
                } else {
                    this.Mx = 0;
                    invalidate(0, 0, this.Mv, this.Mw);
                }
                int aO = aO(i);
                if (aO == -1) {
                    this.MB = false;
                    aVar.a(null, this, -1);
                } else if (aO != this.MA || aO == 0) {
                    aVar.a(this.Mt, this, aO);
                    r(getMeasuredWidth(), getMeasuredHeight());
                    this.Mt.layout(0, 0, this.Mv, this.Mw);
                    invalidate(0, 0, this.Mv, this.Mw);
                    this.MA = aO;
                    this.My = this.Mz;
                }
            } else if (itemViewType == this.Mu) {
                this.MB = true;
                this.Mx = 0;
                aVar.a(this.Mt, this, firstVisiblePosition);
                r(getMeasuredWidth(), getMeasuredHeight());
                this.Mt.layout(0, 0, this.Mv, this.Mw);
                invalidate(0, 0, this.Mv, this.Mw);
                this.My = firstVisiblePosition;
                this.Mz = firstVisiblePosition;
            }
        }
    }

    private int aO(int i) {
        a aVar = this.MD;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (aVar.getItemViewType(i2) == this.Mu) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Ms = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.Ms != null) {
            this.Ms.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        nA();
        if (this.Ms != null) {
            this.Ms.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: nB */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }

    /* loaded from: classes.dex */
    public static abstract class a implements ListAdapter {
        private final DataSetObservable MF = new DataSetObservable();

        public abstract void a(View view, AdapterView<?> adapterView, int i);

        public abstract int nC();

        public abstract View nD();

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.MF.registerObserver(dataSetObserver);
        }
    }
}
