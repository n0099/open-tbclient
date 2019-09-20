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
    private View OA;
    private int OB;
    private int OC;
    private int OD;
    private int OE;
    private int OF;
    private int OG;
    private int OH;
    private boolean OI;
    private boolean OJ;
    private a OL;
    private AbsListView.OnScrollListener Oz;
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
                PinnedHeaderListView.this.OF = -1;
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }
        };
        this.OB = -1;
        this.OJ = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        this.OG = this.OF;
        setOnScrollToPullListener(new BdListView.g() { // from class: com.baidu.adp.widget.PinnedHeaderListView.2
            @Override // com.baidu.adp.widget.ListView.BdListView.g
            public void onScrollToPull(boolean z) {
                PinnedHeaderListView.this.OJ = z;
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
        this.OL = (a) listAdapter;
        this.OB = this.OL.oA();
        this.OA = this.OL.getPinnedHeaderView();
        if (this.OA != null) {
            if (this.OA.getLayoutParams() == null) {
                this.OA.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            setFadingEdgeLength(0);
        }
        this.OL.registerDataSetObserver(this.mObserver);
    }

    private void w(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.OA != null) {
            ViewGroup.LayoutParams layoutParams = this.OA.getLayoutParams();
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
            this.OA.measure(makeMeasureSpec, makeMeasureSpec2);
            this.OC = this.OA.getMeasuredWidth();
            this.OD = this.OA.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        oy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.OI && !this.OJ && this.OA.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.OE);
            drawChild(canvas, this.OA, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void oy() {
        if (this.OA != null) {
            a aVar = this.OL;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = aVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = aVar.getItemViewType(i);
            if (this.OI) {
                if (itemViewType2 == this.OB) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.OE = Math.min(this.OD, Math.max(0, this.OD - childAt.getTop()));
                        invalidate(0, 0, this.OC, this.OD);
                    }
                } else if (itemViewType == this.OB && firstVisiblePosition != this.OF) {
                    aVar.a(this.OA, this, firstVisiblePosition);
                    w(getMeasuredWidth(), getMeasuredHeight());
                    this.OA.layout(0, 0, this.OC, this.OD);
                    invalidate(0, 0, this.OC, this.OD);
                    this.OF = firstVisiblePosition;
                    this.OH = this.OF;
                } else {
                    this.OE = 0;
                    invalidate(0, 0, this.OC, this.OD);
                }
                int aS = aS(i);
                if (aS == -1) {
                    this.OI = false;
                    aVar.a(null, this, -1);
                } else if (aS != this.OH || aS == 0) {
                    aVar.a(this.OA, this, aS);
                    w(getMeasuredWidth(), getMeasuredHeight());
                    this.OA.layout(0, 0, this.OC, this.OD);
                    invalidate(0, 0, this.OC, this.OD);
                    this.OH = aS;
                    this.OF = this.OG;
                }
            } else if (itemViewType == this.OB) {
                this.OI = true;
                this.OE = 0;
                aVar.a(this.OA, this, firstVisiblePosition);
                w(getMeasuredWidth(), getMeasuredHeight());
                this.OA.layout(0, 0, this.OC, this.OD);
                invalidate(0, 0, this.OC, this.OD);
                this.OF = firstVisiblePosition;
                this.OG = firstVisiblePosition;
            }
        }
    }

    private int aS(int i) {
        a aVar = this.OL;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (aVar.getItemViewType(i2) == this.OB) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.Oz = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.Oz != null) {
            this.Oz.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        oy();
        if (this.Oz != null) {
            this.Oz.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: oz */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }

    /* loaded from: classes.dex */
    public static abstract class a implements ListAdapter {
        private final DataSetObservable OO = new DataSetObservable();

        public abstract void a(View view, AdapterView<?> adapterView, int i);

        public abstract View getPinnedHeaderView();

        public abstract int oA();

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.OO.registerObserver(dataSetObserver);
        }
    }
}
