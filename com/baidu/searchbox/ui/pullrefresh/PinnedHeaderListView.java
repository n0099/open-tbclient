package com.baidu.searchbox.ui.pullrefresh;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
/* loaded from: classes4.dex */
public class PinnedHeaderListView extends ListView {
    public static final int MAX_ALPHA = 255;
    public PinnedHeaderAdapter mAdapter;
    public View mHeaderView;
    public int mHeaderViewHeight;
    public boolean mHeaderViewVisible;
    public int mHeaderViewWidth;
    public AbsListView.OnScrollListener mScrollListener;

    /* loaded from: classes4.dex */
    public interface PinnedHeaderAdapter {
        public static final int PINNED_HEADER_GONE = 0;
        public static final int PINNED_HEADER_PUSHED_UP = 2;
        public static final int PINNED_HEADER_VISIBLE = 1;

        void configurePinnedHeader(View view2, int i, int i2);

        int getPinnedHeaderState(int i);
    }

    public PinnedHeaderListView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        super.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.searchbox.ui.pullrefresh.PinnedHeaderListView.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                PinnedHeaderListView.this.configureHeaderView(i);
                if (PinnedHeaderListView.this.mScrollListener != null) {
                    PinnedHeaderListView.this.mScrollListener.onScroll(absListView, i, i2, i3);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (PinnedHeaderListView.this.mScrollListener != null) {
                    PinnedHeaderListView.this.mScrollListener.onScrollStateChanged(absListView, i);
                }
            }
        });
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.mHeaderViewVisible) {
            drawChild(canvas, this.mHeaderView, getDrawingTime());
        }
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mScrollListener = onScrollListener;
    }

    public void setPinnedHeaderView(View view2) {
        this.mHeaderView = view2;
        if (view2 != null) {
            setFadingEdgeLength(0);
        }
        requestLayout();
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View view2 = this.mHeaderView;
        if (view2 != null) {
            measureChild(view2, i, i2);
            this.mHeaderViewWidth = this.mHeaderView.getMeasuredWidth();
            this.mHeaderViewHeight = this.mHeaderView.getMeasuredHeight();
        }
    }

    public PinnedHeaderListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void configureHeaderView(int i) {
        PinnedHeaderAdapter pinnedHeaderAdapter;
        int i2;
        if (this.mHeaderView != null && (pinnedHeaderAdapter = this.mAdapter) != null) {
            int pinnedHeaderState = pinnedHeaderAdapter.getPinnedHeaderState(i);
            if (pinnedHeaderState != 0) {
                int i3 = 255;
                if (pinnedHeaderState != 1) {
                    if (pinnedHeaderState == 2) {
                        int bottom = getChildAt(0).getBottom();
                        int height = this.mHeaderView.getHeight();
                        if (bottom < height) {
                            i2 = bottom - height;
                            i3 = ((height + i2) * 255) / height;
                        } else {
                            i2 = 0;
                        }
                        this.mAdapter.configurePinnedHeader(this.mHeaderView, i, i3);
                        if (this.mHeaderView.getTop() != i2) {
                            this.mHeaderView.layout(0, i2, this.mHeaderViewWidth, this.mHeaderViewHeight + i2);
                        }
                        this.mHeaderViewVisible = true;
                        return;
                    }
                    return;
                }
                this.mAdapter.configurePinnedHeader(this.mHeaderView, i, 255);
                if (this.mHeaderView.getTop() != 0) {
                    this.mHeaderView.layout(0, 0, this.mHeaderViewWidth, this.mHeaderViewHeight);
                }
                this.mHeaderViewVisible = true;
                return;
            }
            this.mHeaderViewVisible = false;
        }
    }

    public View getPinnedHeaderView() {
        return this.mHeaderView;
    }

    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View view2 = this.mHeaderView;
        if (view2 != null) {
            view2.layout(0, 0, this.mHeaderViewWidth, this.mHeaderViewHeight);
            configureHeaderView(getFirstVisiblePosition());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        if (listAdapter instanceof PinnedHeaderAdapter) {
            this.mAdapter = (PinnedHeaderAdapter) listAdapter;
        }
    }
}
