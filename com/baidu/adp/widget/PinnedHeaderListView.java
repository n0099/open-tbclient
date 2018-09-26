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
    private AbsListView.OnScrollListener OV;
    private View OW;
    private int OX;
    private int OY;
    private int OZ;
    private int Pa;
    private int Pb;
    private int Pc;
    private int Pd;
    private boolean Pe;
    private boolean Pf;
    private a Pg;
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
                PinnedHeaderListView.this.Pb = -1;
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }
        };
        this.OX = -1;
        this.Pf = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        this.Pc = this.Pb;
        setOnScrollToPullListener(new BdListView.g() { // from class: com.baidu.adp.widget.PinnedHeaderListView.2
            @Override // com.baidu.adp.widget.ListView.BdListView.g
            public void onScrollToPull(boolean z) {
                PinnedHeaderListView.this.Pf = z;
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
        this.Pg = (a) listAdapter;
        this.OX = this.Pg.oG();
        this.OW = this.Pg.oH();
        if (this.OW != null) {
            if (this.OW.getLayoutParams() == null) {
                this.OW.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            setFadingEdgeLength(0);
        }
        this.Pg.registerDataSetObserver(this.mObserver);
    }

    private void t(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.OW != null) {
            ViewGroup.LayoutParams layoutParams = this.OW.getLayoutParams();
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
            this.OW.measure(makeMeasureSpec, makeMeasureSpec2);
            this.OY = this.OW.getMeasuredWidth();
            this.OZ = this.OW.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        oE();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.Pe && !this.Pf && this.OW.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.Pa);
            drawChild(canvas, this.OW, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void oE() {
        if (this.OW != null) {
            a aVar = this.Pg;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = aVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = aVar.getItemViewType(i);
            if (this.Pe) {
                if (itemViewType2 == this.OX) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.Pa = Math.min(this.OZ, Math.max(0, this.OZ - childAt.getTop()));
                        invalidate(0, 0, this.OY, this.OZ);
                    }
                } else if (itemViewType == this.OX && firstVisiblePosition != this.Pb) {
                    aVar.a(this.OW, this, firstVisiblePosition);
                    t(getMeasuredWidth(), getMeasuredHeight());
                    this.OW.layout(0, 0, this.OY, this.OZ);
                    invalidate(0, 0, this.OY, this.OZ);
                    this.Pb = firstVisiblePosition;
                    this.Pd = this.Pb;
                } else {
                    this.Pa = 0;
                    invalidate(0, 0, this.OY, this.OZ);
                }
                int aY = aY(i);
                if (aY == -1) {
                    this.Pe = false;
                    aVar.a(null, this, -1);
                } else if (aY != this.Pd || aY == 0) {
                    aVar.a(this.OW, this, aY);
                    t(getMeasuredWidth(), getMeasuredHeight());
                    this.OW.layout(0, 0, this.OY, this.OZ);
                    invalidate(0, 0, this.OY, this.OZ);
                    this.Pd = aY;
                    this.Pb = this.Pc;
                }
            } else if (itemViewType == this.OX) {
                this.Pe = true;
                this.Pa = 0;
                aVar.a(this.OW, this, firstVisiblePosition);
                t(getMeasuredWidth(), getMeasuredHeight());
                this.OW.layout(0, 0, this.OY, this.OZ);
                invalidate(0, 0, this.OY, this.OZ);
                this.Pb = firstVisiblePosition;
                this.Pc = firstVisiblePosition;
            }
        }
    }

    private int aY(int i) {
        a aVar = this.Pg;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (aVar.getItemViewType(i2) == this.OX) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.OV = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.OV != null) {
            this.OV.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        oE();
        if (this.OV != null) {
            this.OV.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: oF */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }

    /* loaded from: classes.dex */
    public static abstract class a implements ListAdapter {
        private final DataSetObservable Pi = new DataSetObservable();

        public abstract void a(View view, AdapterView<?> adapterView, int i);

        public abstract int oG();

        public abstract View oH();

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.Pi.registerObserver(dataSetObserver);
        }
    }
}
