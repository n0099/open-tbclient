package com.baidu.searchbox.ui.stickylistheader;

import android.content.Context;
import android.graphics.Canvas;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;
import com.baidu.searchbox.ui.common.IndexScroller;
import com.baidu.searchbox.ui.pullrefresh.FooterLoadingLayout;
import com.baidu.searchbox.ui.pullrefresh.ILoadingLayout;
import com.baidu.searchbox.ui.pullrefresh.LoadingLayout;
/* loaded from: classes4.dex */
public class IndexWrapperListView extends WrapperViewList {
    public static final boolean DEBUG = false;
    public static final int SCROLL_DURATION = 150;
    public static final String TAG = "IndexWrapperListView";
    public GestureDetector mGestureDetector;
    public boolean mIsFastScrollEnabled;
    public LoadingLayout mLoadMoreFooterLayout;
    public ILoadingLayout.State mLoadMoreState;
    public OnRefreshListener mRefreshListener;
    public boolean mScrollLoadEnabled;
    public IndexScroller mScroller;

    /* loaded from: classes4.dex */
    public interface OnRefreshListener {
        void onLoadMoreData();
    }

    public long getSmoothScrollDuration() {
        return 150L;
    }

    public IndexWrapperListView(Context context) {
        super(context);
        this.mIsFastScrollEnabled = false;
        this.mScroller = null;
        this.mGestureDetector = null;
        this.mScrollLoadEnabled = false;
        this.mLoadMoreState = ILoadingLayout.State.NONE;
    }

    @Override // com.baidu.searchbox.ui.stickylistheader.WrapperViewList, android.widget.ListView
    public /* bridge */ /* synthetic */ void addFooterView(View view2) {
        super.addFooterView(view2);
    }

    @Override // android.widget.AbsListView, android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        IndexScroller indexScroller = this.mScroller;
        if (indexScroller != null) {
            indexScroller.draw(canvas);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IndexScroller indexScroller = this.mScroller;
        if (indexScroller != null && indexScroller.contains(motionEvent.getX(), motionEvent.getY())) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        IndexScroller indexScroller = this.mScroller;
        if (indexScroller != null && indexScroller.onTouchEvent(motionEvent)) {
            return true;
        }
        if (this.mGestureDetector == null) {
            this.mGestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.baidu.searchbox.ui.stickylistheader.IndexWrapperListView.2
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent2, MotionEvent motionEvent3, float f, float f2) {
                    if (IndexWrapperListView.this.mScroller != null) {
                        IndexWrapperListView.this.mScroller.show();
                    }
                    return super.onFling(motionEvent2, motionEvent3, f, f2);
                }
            });
        }
        this.mGestureDetector.onTouchEvent(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.baidu.searchbox.ui.stickylistheader.WrapperViewList, android.widget.ListView
    public /* bridge */ /* synthetic */ boolean removeFooterView(View view2) {
        return super.removeFooterView(view2);
    }

    @Override // com.baidu.searchbox.ui.stickylistheader.WrapperViewList
    public /* bridge */ /* synthetic */ void setBlockLayoutChildren(boolean z) {
        super.setBlockLayoutChildren(z);
    }

    @Override // com.baidu.searchbox.ui.stickylistheader.WrapperViewList, android.view.ViewGroup
    public /* bridge */ /* synthetic */ void setClipToPadding(boolean z) {
        super.setClipToPadding(z);
    }

    @Override // android.widget.AbsListView
    public void setFastScrollEnabled(boolean z) {
        this.mIsFastScrollEnabled = z;
        if (z) {
            if (this.mScroller == null) {
                this.mScroller = new IndexScroller(this);
                return;
            }
            return;
        }
        IndexScroller indexScroller = this.mScroller;
        if (indexScroller != null) {
            indexScroller.hide();
            this.mScroller = null;
        }
    }

    public void setHasMoreData(boolean z) {
        ILoadingLayout.State state;
        LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
        if (loadingLayout != null) {
            if (z) {
                state = ILoadingLayout.State.RESET;
            } else {
                state = ILoadingLayout.State.NO_MORE_DATA;
            }
            loadingLayout.setState(state);
        }
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mRefreshListener = onRefreshListener;
    }

    public void setScrollLoadEnabled(boolean z) {
        if (isScrollLoadEnabled() == z) {
            return;
        }
        this.mScrollLoadEnabled = z;
        if (z) {
            if (this.mLoadMoreFooterLayout == null) {
                FooterLoadingLayout footerLoadingLayout = new FooterLoadingLayout(getContext());
                this.mLoadMoreFooterLayout = footerLoadingLayout;
                addFooterView(footerLoadingLayout, null, false);
            }
            this.mLoadMoreFooterLayout.show(true);
            return;
        }
        LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
        if (loadingLayout != null) {
            loadingLayout.show(false);
        }
    }

    private boolean hasMoreData() {
        LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
        if (loadingLayout != null && loadingLayout.getState() == ILoadingLayout.State.NO_MORE_DATA) {
            return false;
        }
        return true;
    }

    @Override // android.widget.AbsListView
    public boolean isFastScrollEnabled() {
        return this.mIsFastScrollEnabled;
    }

    public boolean isPullLoading() {
        if (this.mLoadMoreState == ILoadingLayout.State.REFRESHING) {
            return true;
        }
        return false;
    }

    public boolean isReadyForPullUp() {
        return isLastItemVisible();
    }

    public boolean isScrollLoadEnabled() {
        return this.mScrollLoadEnabled;
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() { // from class: com.baidu.searchbox.ui.stickylistheader.IndexWrapperListView.3
            @Override // com.baidu.searchbox.skin.callback.NightModeChangeListener
            public void onNightModeChanged(boolean z) {
                if (IndexWrapperListView.this.mScroller != null) {
                    IndexWrapperListView.this.mScroller.onNightModeChanged(z);
                }
            }
        });
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IndexScroller indexScroller = this.mScroller;
        if (indexScroller != null) {
            indexScroller.onDetachedFromWindow();
        }
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
    }

    public void onLoadMoreComplete() {
        LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout.State.RESET);
            this.mLoadMoreState = ILoadingLayout.State.RESET;
        }
    }

    public void startLoading() {
        LoadingLayout loadingLayout = this.mLoadMoreFooterLayout;
        if (loadingLayout != null) {
            loadingLayout.setState(ILoadingLayout.State.REFRESHING);
        }
        if (isPullLoading()) {
            return;
        }
        this.mLoadMoreState = ILoadingLayout.State.REFRESHING;
        if (this.mRefreshListener != null) {
            postDelayed(new Runnable() { // from class: com.baidu.searchbox.ui.stickylistheader.IndexWrapperListView.1
                @Override // java.lang.Runnable
                public void run() {
                    IndexWrapperListView.this.mRefreshListener.onLoadMoreData();
                }
            }, getSmoothScrollDuration());
        }
    }

    public void updateIndexer() {
        IndexScroller indexScroller = this.mScroller;
        if (indexScroller != null) {
            indexScroller.setAdapter(getAdapter());
            this.mScroller.onSizeChanged(getWidth(), getHeight(), getWidth(), getHeight());
            invalidateViews();
        }
    }

    private boolean isLastItemVisible() {
        View childAt;
        ListAdapter adapter = getAdapter();
        if (adapter == null || adapter.isEmpty()) {
            return true;
        }
        int lastVisiblePosition = getLastVisiblePosition();
        if (lastVisiblePosition >= (adapter.getCount() - 1) - 1 && (childAt = getChildAt(Math.min(lastVisiblePosition - getFirstVisiblePosition(), getChildCount() - 1))) != null && childAt.getBottom() <= getBottom()) {
            return true;
        }
        return false;
    }

    @Override // com.baidu.searchbox.ui.stickylistheader.WrapperViewList, android.widget.ListView
    public /* bridge */ /* synthetic */ void addFooterView(View view2, Object obj, boolean z) {
        super.addFooterView(view2, obj, z);
    }

    @Override // com.baidu.searchbox.ui.stickylistheader.WrapperViewList, android.widget.AbsListView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ boolean performItemClick(View view2, int i, long j) {
        return super.performItemClick(view2, i, j);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (isScrollLoadEnabled() && hasMoreData()) {
            if ((i == 0 || i == 2) && isReadyForPullUp()) {
                startLoading();
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        IndexScroller indexScroller = this.mScroller;
        if (indexScroller != null) {
            indexScroller.onSizeChanged(i, i2, i3, i4);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        IndexScroller indexScroller = this.mScroller;
        if (indexScroller != null) {
            indexScroller.setAdapter(listAdapter);
        }
    }
}
