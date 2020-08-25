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
    private a WK;
    private int mCurrentPinnedPosition;
    private AbsListView.OnScrollListener mInnerOnScrollListener;
    private boolean mIsPulling;
    private int mLastPinnedPosition;
    private int mLastPreviousHeaderPosition;
    private final DataSetObserver mObserver;
    private int mPinnedHeaderHeight;
    private int mPinnedHeaderItemType;
    private int mPinnedHeaderOffsetY;
    private View mPinnedHeaderView;
    private int mPinnedHeaderWidth;
    private boolean mWillDrawPinnedHeader;

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
                PinnedHeaderListView.this.mCurrentPinnedPosition = -1;
                PinnedHeaderListView.this.requestLayout();
                PinnedHeaderListView.this.invalidate();
            }
        };
        this.mPinnedHeaderItemType = -1;
        this.mIsPulling = false;
        super.setOnScrollListener(this);
        Log.d("PinnedHeaderListView", "head count = " + getHeaderViewsCount());
        init();
    }

    private void init() {
        this.mLastPinnedPosition = this.mCurrentPinnedPosition;
        setOnScrollToPullListener(new BdListView.g() { // from class: com.baidu.adp.widget.PinnedHeaderListView.2
            @Override // com.baidu.adp.widget.ListView.BdListView.g
            public void onScrollToPull(boolean z) {
                PinnedHeaderListView.this.mIsPulling = z;
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
        this.WK = (a) listAdapter;
        this.mPinnedHeaderItemType = this.WK.getPinnedHeaderViewType();
        this.mPinnedHeaderView = this.WK.getPinnedHeaderView();
        if (this.mPinnedHeaderView != null) {
            if (this.mPinnedHeaderView.getLayoutParams() == null) {
                this.mPinnedHeaderView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            }
            setFadingEdgeLength(0);
        }
        this.WK.registerDataSetObserver(this.mObserver);
    }

    private void measurePinnedHeader(int i, int i2) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        if (this.mPinnedHeaderView != null) {
            ViewGroup.LayoutParams layoutParams = this.mPinnedHeaderView.getLayoutParams();
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
            this.mPinnedHeaderView.measure(makeMeasureSpec, makeMeasureSpec2);
            this.mPinnedHeaderWidth = this.mPinnedHeaderView.getMeasuredWidth();
            this.mPinnedHeaderHeight = this.mPinnedHeaderView.getMeasuredHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        computeHeaderView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mWillDrawPinnedHeader && !this.mIsPulling && this.mPinnedHeaderView.getVisibility() == 0) {
            long drawingTime = getDrawingTime();
            int save = canvas.save();
            canvas.translate(0.0f, -this.mPinnedHeaderOffsetY);
            drawChild(canvas, this.mPinnedHeaderView, drawingTime);
            if (save >= 1 && save <= canvas.getSaveCount()) {
                canvas.restoreToCount(save);
            }
        }
    }

    private void computeHeaderView() {
        if (this.mPinnedHeaderView != null) {
            a aVar = this.WK;
            int firstVisiblePosition = getFirstVisiblePosition();
            if (firstVisiblePosition > 0) {
                firstVisiblePosition--;
            }
            int i = firstVisiblePosition + 1;
            int itemViewType = aVar.getItemViewType(firstVisiblePosition);
            int itemViewType2 = aVar.getItemViewType(i);
            if (this.mWillDrawPinnedHeader) {
                if (itemViewType2 == this.mPinnedHeaderItemType) {
                    View childAt = getChildAt(1);
                    if (childAt != null) {
                        this.mPinnedHeaderOffsetY = Math.min(this.mPinnedHeaderHeight, Math.max(0, this.mPinnedHeaderHeight - childAt.getTop()));
                        invalidate(0, 0, this.mPinnedHeaderWidth, this.mPinnedHeaderHeight);
                    }
                } else if (itemViewType == this.mPinnedHeaderItemType && firstVisiblePosition != this.mCurrentPinnedPosition) {
                    aVar.updatePinnedHeaderView(this.mPinnedHeaderView, this, firstVisiblePosition);
                    measurePinnedHeader(getMeasuredWidth(), getMeasuredHeight());
                    this.mPinnedHeaderView.layout(0, 0, this.mPinnedHeaderWidth, this.mPinnedHeaderHeight);
                    invalidate(0, 0, this.mPinnedHeaderWidth, this.mPinnedHeaderHeight);
                    this.mCurrentPinnedPosition = firstVisiblePosition;
                    this.mLastPreviousHeaderPosition = this.mCurrentPinnedPosition;
                } else {
                    this.mPinnedHeaderOffsetY = 0;
                    invalidate(0, 0, this.mPinnedHeaderWidth, this.mPinnedHeaderHeight);
                }
                int previousHeaderPosition = getPreviousHeaderPosition(i);
                if (previousHeaderPosition == -1) {
                    this.mWillDrawPinnedHeader = false;
                    aVar.updatePinnedHeaderView(null, this, -1);
                } else if (previousHeaderPosition != this.mLastPreviousHeaderPosition || previousHeaderPosition == 0) {
                    aVar.updatePinnedHeaderView(this.mPinnedHeaderView, this, previousHeaderPosition);
                    measurePinnedHeader(getMeasuredWidth(), getMeasuredHeight());
                    this.mPinnedHeaderView.layout(0, 0, this.mPinnedHeaderWidth, this.mPinnedHeaderHeight);
                    invalidate(0, 0, this.mPinnedHeaderWidth, this.mPinnedHeaderHeight);
                    this.mLastPreviousHeaderPosition = previousHeaderPosition;
                    this.mCurrentPinnedPosition = this.mLastPinnedPosition;
                }
            } else if (itemViewType == this.mPinnedHeaderItemType) {
                this.mWillDrawPinnedHeader = true;
                this.mPinnedHeaderOffsetY = 0;
                aVar.updatePinnedHeaderView(this.mPinnedHeaderView, this, firstVisiblePosition);
                measurePinnedHeader(getMeasuredWidth(), getMeasuredHeight());
                this.mPinnedHeaderView.layout(0, 0, this.mPinnedHeaderWidth, this.mPinnedHeaderHeight);
                invalidate(0, 0, this.mPinnedHeaderWidth, this.mPinnedHeaderHeight);
                this.mCurrentPinnedPosition = firstVisiblePosition;
                this.mLastPinnedPosition = firstVisiblePosition;
            }
        }
    }

    private int getPreviousHeaderPosition(int i) {
        a aVar = this.WK;
        for (int i2 = i - 1; i2 >= 0; i2--) {
            if (aVar.getItemViewType(i2) == this.mPinnedHeaderItemType) {
                return i2;
            }
        }
        return -1;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView, android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mInnerOnScrollListener = onScrollListener;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.mInnerOnScrollListener != null) {
            this.mInnerOnScrollListener.onScrollStateChanged(absListView, i);
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        computeHeaderView();
        if (this.mInnerOnScrollListener != null) {
            this.mInnerOnScrollListener.onScroll(absListView, i, i2, i3);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.view.ViewGroup
    public AbsListView.LayoutParams generateDefaultLayoutParams() {
        return new AbsListView.LayoutParams(-1, -2);
    }

    /* loaded from: classes.dex */
    public static abstract class a implements ListAdapter {
        private final DataSetObservable mDataSetObservable = new DataSetObservable();

        public abstract View getPinnedHeaderView();

        public abstract int getPinnedHeaderViewType();

        public abstract void updatePinnedHeaderView(View view, AdapterView<?> adapterView, int i);

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            this.mDataSetObservable.registerObserver(dataSetObserver);
        }
    }
}
