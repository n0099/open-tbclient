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
    private AbsListView.OnScrollListener OA;
    private View OB;
    private int OC;
    private int OD;
    private int OE;
    private int OF;
    private int OG;
    private int OH;
    private int OI;
    private boolean OJ;
    private boolean OL;
    private a OM;
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
                PinnedHeaderListView.this.OG = -1;
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }
        };
        this.OC = -1;
        this.OL = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        this.OH = this.OG;
        setOnScrollToPullListener(new BdListView.g() { // from class: com.baidu.adp.widget.PinnedHeaderListView.2
            @Override // com.baidu.adp.widget.ListView.BdListView.g
            public void onScrollToPull(boolean z) {
                PinnedHeaderListView.this.OL = z;
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
        this.OM = (a) listAdapter;
        this.OC = this.OM.oz();
        this.OB = this.OM.getPinnedHeaderView();
        if (this.OB != null) {
            if (this.OB.getLayoutParams() == null) {
                this.OB.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            setFadingEdgeLength(0);
        }
        this.OM.registerDataSetObserver(this.mObserver);
    }

    private void w(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.OB != null) {
            ViewGroup.LayoutParams layoutParams = this.OB.getLayoutParams();
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
            this.OB.measure(makeMeasureSpec, makeMeasureSpec2);
            this.OD = this.OB.getMeasuredWidth();
            this.OE = this.OB.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ox();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.OJ && !this.OL && this.OB.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.OF);
            drawChild(canvas, this.OB, drawingTime);
            canvas.restoreToCount(save);
        }
    }

    private void ox() {
        if (this.OB != null) {
            a aVar = this.OM;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = aVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = aVar.getItemViewType(i);
            if (this.OJ) {
                if (itemViewType2 == this.OC) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.OF = Math.min(this.OE, Math.max(0, this.OE - childAt.getTop()));
                        invalidate(0, 0, this.OD, this.OE);
                    }
                } else if (itemViewType == this.OC && firstVisiblePosition != this.OG) {
                    aVar.a(this.OB, this, firstVisiblePosition);
                    w(getMeasuredWidth(), getMeasuredHeight());
                    this.OB.layout(0, 0, this.OD, this.OE);
                    invalidate(0, 0, this.OD, this.OE);
                    this.OG = firstVisiblePosition;
                    this.OI = this.OG;
                } else {
                    this.OF = 0;
                    invalidate(0, 0, this.OD, this.OE);
                }
                int aS = aS(i);
                if (aS == -1) {
                    this.OJ = false;
                    aVar.a(null, this, -1);
                } else if (aS != this.OI || aS == 0) {
                    aVar.a(this.OB, this, aS);
                    w(getMeasuredWidth(), getMeasuredHeight());
                    this.OB.layout(0, 0, this.OD, this.OE);
                    invalidate(0, 0, this.OD, this.OE);
                    this.OI = aS;
                    this.OG = this.OH;
                }
            } else if (itemViewType == this.OC) {
                this.OJ = true;
                this.OF = 0;
                aVar.a(this.OB, this, firstVisiblePosition);
                w(getMeasuredWidth(), getMeasuredHeight());
                this.OB.layout(0, 0, this.OD, this.OE);
                invalidate(0, 0, this.OD, this.OE);
                this.OG = firstVisiblePosition;
                this.OH = firstVisiblePosition;
            }
        }
    }

    private int aS(int i) {
        a aVar = this.OM;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (aVar.getItemViewType(i2) == this.OC) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.OA = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.OA != null) {
            this.OA.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ox();
        if (this.OA != null) {
            this.OA.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    /* renamed from: oy */
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }

    /* loaded from: classes.dex */
    public static abstract class a implements ListAdapter {
        private final DataSetObservable OP = new DataSetObservable();

        public abstract void a(View view, AdapterView<?> adapterView, int i);

        public abstract View getPinnedHeaderView();

        public abstract int oz();

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.OP.registerObserver(dataSetObserver);
        }
    }
}
