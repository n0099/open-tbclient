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
    private AbsListView.OnScrollListener Ok;
    private View Ol;
    private int Om;
    private int On;
    private int Oo;
    private int Op;
    private int Oq;
    private int Or;
    private int Os;
    private boolean Ot;
    private boolean Ou;
    private a Ov;
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
                PinnedHeaderListView.this.Oq = -1;
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }
        };
        this.Om = -1;
        this.Ou = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        this.Or = this.Oq;
        setOnScrollToPullListener(new BdListView.g() { // from class: com.baidu.adp.widget.PinnedHeaderListView.2
            @Override // com.baidu.adp.widget.ListView.BdListView.g
            public void onScrollToPull(boolean z) {
                PinnedHeaderListView.this.Ou = z;
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
        this.Ov = (a) listAdapter;
        this.Om = this.Ov.od();
        this.Ol = this.Ov.getPinnedHeaderView();
        if (this.Ol != null) {
            if (this.Ol.getLayoutParams() == null) {
                this.Ol.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            setFadingEdgeLength(0);
        }
        this.Ov.registerDataSetObserver(this.mObserver);
    }

    private void t(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.Ol != null) {
            ViewGroup.LayoutParams layoutParams = this.Ol.getLayoutParams();
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
            this.Ol.measure(makeMeasureSpec, makeMeasureSpec2);
            this.On = this.Ol.getMeasuredWidth();
            this.Oo = this.Ol.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ob();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.Ot && !this.Ou && this.Ol.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.Op);
            drawChild(canvas, this.Ol, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void ob() {
        if (this.Ol != null) {
            a aVar = this.Ov;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = aVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = aVar.getItemViewType(i);
            if (this.Ot) {
                if (itemViewType2 == this.Om) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.Op = Math.min(this.Oo, Math.max(0, this.Oo - childAt.getTop()));
                        invalidate(0, 0, this.On, this.Oo);
                    }
                } else if (itemViewType == this.Om && firstVisiblePosition != this.Oq) {
                    aVar.a(this.Ol, this, firstVisiblePosition);
                    t(getMeasuredWidth(), getMeasuredHeight());
                    this.Ol.layout(0, 0, this.On, this.Oo);
                    invalidate(0, 0, this.On, this.Oo);
                    this.Oq = firstVisiblePosition;
                    this.Os = this.Oq;
                } else {
                    this.Op = 0;
                    invalidate(0, 0, this.On, this.Oo);
                }
                int aS = aS(i);
                if (aS == -1) {
                    this.Ot = false;
                    aVar.a(null, this, -1);
                } else if (aS != this.Os || aS == 0) {
                    aVar.a(this.Ol, this, aS);
                    t(getMeasuredWidth(), getMeasuredHeight());
                    this.Ol.layout(0, 0, this.On, this.Oo);
                    invalidate(0, 0, this.On, this.Oo);
                    this.Os = aS;
                    this.Oq = this.Or;
                }
            } else if (itemViewType == this.Om) {
                this.Ot = true;
                this.Op = 0;
                aVar.a(this.Ol, this, firstVisiblePosition);
                t(getMeasuredWidth(), getMeasuredHeight());
                this.Ol.layout(0, 0, this.On, this.Oo);
                invalidate(0, 0, this.On, this.Oo);
                this.Oq = firstVisiblePosition;
                this.Or = firstVisiblePosition;
            }
        }
    }

    private int aS(int i) {
        a aVar = this.Ov;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (aVar.getItemViewType(i2) == this.Om) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Ok = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.Ok != null) {
            this.Ok.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ob();
        if (this.Ok != null) {
            this.Ok.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: oc */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }

    /* loaded from: classes.dex */
    public static abstract class a implements ListAdapter {
        private final DataSetObservable Ox = new DataSetObservable();

        public abstract void a(View view, AdapterView<?> adapterView, int i);

        public abstract View getPinnedHeaderView();

        public abstract int od();

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.Ox.registerObserver(dataSetObserver);
        }
    }
}
