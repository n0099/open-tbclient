package com.baidu.adp.widget.ListView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.d;
/* loaded from: classes.dex */
public class h extends RecyclerView implements k<h> {
    private static final String LOG_TAG = h.class.getSimpleName();
    private g avC;
    private BdListView.d avD;
    private long avE;
    private a avx;
    private b avy;
    private Runnable mDelayedRunnable;
    private com.baidu.adp.widget.ListView.b mNextPage;
    private View mNoDataView;
    private BdListView.a mOnFooterClickListener;
    private BdListView.b mOnHeaderClickListener;
    private BdListView.e mOnScrollToBottomListener;
    private BdListView.h mOnScrollToTopListener;
    private l mPreLoadListView;
    private com.baidu.adp.widget.ListView.b mPrePage;
    private com.baidu.adp.base.h mScrollable;
    private Runnable preLoadRunnable;
    private Runnable refreshRunnable;

    /* loaded from: classes.dex */
    public interface a<T> {
        void a(ViewGroup viewGroup, View view, T t, int i, long j);
    }

    /* loaded from: classes.dex */
    public interface b<T> {
        boolean b(ViewGroup viewGroup, View view, T t, int i, long j);
    }

    public h(Context context) {
        super(context);
        this.mScrollable = null;
        this.avx = null;
        this.avy = null;
        this.mOnHeaderClickListener = null;
        this.mOnFooterClickListener = null;
        this.mOnScrollToBottomListener = null;
        this.mOnScrollToTopListener = null;
        this.avD = null;
        this.avE = 100L;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.h.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                int i2 = -1;
                if (h.this.avD != null) {
                    int firstVisiblePosition = h.this.getFirstVisiblePosition();
                    int lastVisiblePosition = h.this.getLastVisiblePosition();
                    if (h.this.avC == null || h.this.avC.getWrappedAdapter() == null || h.this.avC.getWrappedAdapter().getItemCount() <= 0) {
                        i = -1;
                    } else {
                        i2 = firstVisiblePosition - h.this.avC.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        int headersCount = lastVisiblePosition - h.this.avC.getHeadersCount();
                        if (headersCount >= h.this.avC.getWrappedAdapter().getItemCount()) {
                            headersCount = h.this.avC.getWrappedAdapter().getItemCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                    }
                    h.this.avD.onScrollStop(i2, i);
                }
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.h.2
            @Override // java.lang.Runnable
            public void run() {
                int childCount = h.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    refreshImage(h.this.getChildAt(i));
                }
                h.this.preLoadRunnable.run();
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.b.a.i) {
                        ((com.baidu.adp.b.a.i) view).refresh();
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        int childCount = viewGroup.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            refreshImage(viewGroup.getChildAt(i));
                        }
                    }
                }
            }
        };
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.h.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h ai;
                if (h.this.mScrollable != null) {
                    ai = h.this.mScrollable;
                } else {
                    ai = com.baidu.adp.base.i.ai(h.this.getContext());
                }
                if (ai != null) {
                    ai.onPreLoad(h.this.mPreLoadListView);
                }
            }
        };
        this.mPreLoadListView = new l() { // from class: com.baidu.adp.widget.ListView.h.4
            @Override // com.baidu.adp.widget.ListView.l
            public j getAdapter() {
                return h.this.avC;
            }

            @Override // com.baidu.adp.widget.ListView.l
            public int getFirstVisiblePosition() {
                return h.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.l
            public int getLastVisiblePosition() {
                return h.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.l
            public void cancelRefresh() {
                h.this.removeCallbacks(h.this.refreshRunnable);
            }
        };
        initial();
    }

    public h(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollable = null;
        this.avx = null;
        this.avy = null;
        this.mOnHeaderClickListener = null;
        this.mOnFooterClickListener = null;
        this.mOnScrollToBottomListener = null;
        this.mOnScrollToTopListener = null;
        this.avD = null;
        this.avE = 100L;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.h.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                int i2 = -1;
                if (h.this.avD != null) {
                    int firstVisiblePosition = h.this.getFirstVisiblePosition();
                    int lastVisiblePosition = h.this.getLastVisiblePosition();
                    if (h.this.avC == null || h.this.avC.getWrappedAdapter() == null || h.this.avC.getWrappedAdapter().getItemCount() <= 0) {
                        i = -1;
                    } else {
                        i2 = firstVisiblePosition - h.this.avC.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        int headersCount = lastVisiblePosition - h.this.avC.getHeadersCount();
                        if (headersCount >= h.this.avC.getWrappedAdapter().getItemCount()) {
                            headersCount = h.this.avC.getWrappedAdapter().getItemCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                    }
                    h.this.avD.onScrollStop(i2, i);
                }
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.h.2
            @Override // java.lang.Runnable
            public void run() {
                int childCount = h.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    refreshImage(h.this.getChildAt(i));
                }
                h.this.preLoadRunnable.run();
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.b.a.i) {
                        ((com.baidu.adp.b.a.i) view).refresh();
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        int childCount = viewGroup.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            refreshImage(viewGroup.getChildAt(i));
                        }
                    }
                }
            }
        };
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.h.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h ai;
                if (h.this.mScrollable != null) {
                    ai = h.this.mScrollable;
                } else {
                    ai = com.baidu.adp.base.i.ai(h.this.getContext());
                }
                if (ai != null) {
                    ai.onPreLoad(h.this.mPreLoadListView);
                }
            }
        };
        this.mPreLoadListView = new l() { // from class: com.baidu.adp.widget.ListView.h.4
            @Override // com.baidu.adp.widget.ListView.l
            public j getAdapter() {
                return h.this.avC;
            }

            @Override // com.baidu.adp.widget.ListView.l
            public int getFirstVisiblePosition() {
                return h.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.l
            public int getLastVisiblePosition() {
                return h.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.l
            public void cancelRefresh() {
                h.this.removeCallbacks(h.this.refreshRunnable);
            }
        };
        initial();
    }

    public h(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mScrollable = null;
        this.avx = null;
        this.avy = null;
        this.mOnHeaderClickListener = null;
        this.mOnFooterClickListener = null;
        this.mOnScrollToBottomListener = null;
        this.mOnScrollToTopListener = null;
        this.avD = null;
        this.avE = 100L;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.h.1
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 0;
                int i22 = -1;
                if (h.this.avD != null) {
                    int firstVisiblePosition = h.this.getFirstVisiblePosition();
                    int lastVisiblePosition = h.this.getLastVisiblePosition();
                    if (h.this.avC == null || h.this.avC.getWrappedAdapter() == null || h.this.avC.getWrappedAdapter().getItemCount() <= 0) {
                        i2 = -1;
                    } else {
                        i22 = firstVisiblePosition - h.this.avC.getHeadersCount();
                        if (i22 < 0) {
                            i22 = 0;
                        }
                        int headersCount = lastVisiblePosition - h.this.avC.getHeadersCount();
                        if (headersCount >= h.this.avC.getWrappedAdapter().getItemCount()) {
                            headersCount = h.this.avC.getWrappedAdapter().getItemCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i2 = headersCount;
                        }
                    }
                    h.this.avD.onScrollStop(i22, i2);
                }
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.h.2
            @Override // java.lang.Runnable
            public void run() {
                int childCount = h.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    refreshImage(h.this.getChildAt(i2));
                }
                h.this.preLoadRunnable.run();
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.b.a.i) {
                        ((com.baidu.adp.b.a.i) view).refresh();
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        int childCount = viewGroup.getChildCount();
                        for (int i2 = 0; i2 < childCount; i2++) {
                            refreshImage(viewGroup.getChildAt(i2));
                        }
                    }
                }
            }
        };
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.h.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h ai;
                if (h.this.mScrollable != null) {
                    ai = h.this.mScrollable;
                } else {
                    ai = com.baidu.adp.base.i.ai(h.this.getContext());
                }
                if (ai != null) {
                    ai.onPreLoad(h.this.mPreLoadListView);
                }
            }
        };
        this.mPreLoadListView = new l() { // from class: com.baidu.adp.widget.ListView.h.4
            @Override // com.baidu.adp.widget.ListView.l
            public j getAdapter() {
                return h.this.avC;
            }

            @Override // com.baidu.adp.widget.ListView.l
            public int getFirstVisiblePosition() {
                return h.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.l
            public int getLastVisiblePosition() {
                return h.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.l
            public void cancelRefresh() {
                h.this.removeCallbacks(h.this.refreshRunnable);
            }
        };
        initial();
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.avC = new g(getContext());
        this.avC.a(new d.a() { // from class: com.baidu.adp.widget.ListView.h.5
            @Override // com.baidu.adp.widget.ListView.d.a
            public void onPreLoad() {
                h.this.removeCallbacks(h.this.preLoadRunnable);
                h.this.postDelayed(h.this.preLoadRunnable, 100L);
            }
        });
        this.avC.setOnItemClickListener(new a() { // from class: com.baidu.adp.widget.ListView.h.6
            @Override // com.baidu.adp.widget.ListView.h.a
            public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                int headerViewsCount = h.this.getHeaderViewsCount();
                if (i < headerViewsCount) {
                    if (h.this.mPrePage == null || view != h.this.mPrePage.getView()) {
                        if (h.this.mOnHeaderClickListener != null) {
                            h.this.mOnHeaderClickListener.onClick(view);
                            return;
                        }
                        return;
                    }
                    h.this.mPrePage.onClick();
                    return;
                }
                int i2 = i - headerViewsCount;
                RecyclerView.Adapter wrappedAdapter = h.this.avC.getWrappedAdapter();
                if (wrappedAdapter == null || i2 >= wrappedAdapter.getItemCount()) {
                    if (h.this.mNextPage == null || view != h.this.mNextPage.getView()) {
                        if (h.this.mOnFooterClickListener != null) {
                            h.this.mOnFooterClickListener.onClick(view);
                            return;
                        }
                        return;
                    }
                    h.this.mNextPage.onClick();
                } else if (h.this.avx != null) {
                    h.this.avx.a(viewGroup, view, obj, i2, j);
                }
            }
        });
        this.avC.setOnItemLongClickListener(new b() { // from class: com.baidu.adp.widget.ListView.h.7
            @Override // com.baidu.adp.widget.ListView.h.b
            public boolean b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                int headerViewsCount = i - h.this.getHeaderViewsCount();
                RecyclerView.Adapter wrappedAdapter = h.this.avC.getWrappedAdapter();
                if (wrappedAdapter == null || headerViewsCount >= wrappedAdapter.getItemCount() || h.this.avy == null) {
                    return false;
                }
                return h.this.avy.b(viewGroup, view, obj, i, j);
            }
        });
        addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.adp.widget.ListView.h.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                com.baidu.adp.base.h ai;
                if (h.this.mScrollable != null) {
                    ai = h.this.mScrollable;
                } else {
                    ai = com.baidu.adp.base.i.ai(h.this.getContext());
                }
                if (ai != null) {
                    if (i == 2) {
                        h.this.removeCallbacks(h.this.refreshRunnable);
                        ai.setIsScroll(true);
                    } else if (ai.isScroll()) {
                        ai.setIsScroll(false);
                        h.this.removeCallbacks(h.this.refreshRunnable);
                        h.this.postDelayed(h.this.refreshRunnable, 100L);
                    } else if (i == 0) {
                        h.this.removeCallbacks(h.this.preLoadRunnable);
                        h.this.postDelayed(h.this.preLoadRunnable, 100L);
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                boolean canScrollVertically = h.this.canScrollVertically(1);
                boolean canScrollVertically2 = h.this.canScrollVertically(-1);
                if (!canScrollVertically && canScrollVertically2 && Math.abs(i2) > 0) {
                    if (h.this.mOnScrollToBottomListener != null) {
                        recyclerView.post(new Runnable() { // from class: com.baidu.adp.widget.ListView.h.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (h.this.mOnScrollToBottomListener != null) {
                                    h.this.mOnScrollToBottomListener.onScrollToBottom();
                                }
                            }
                        });
                    }
                } else if (!canScrollVertically2 && canScrollVertically && Math.abs(i2) > 0 && h.this.mOnScrollToTopListener != null) {
                    recyclerView.post(new Runnable() { // from class: com.baidu.adp.widget.ListView.h.8.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (h.this.mOnScrollToTopListener != null) {
                                h.this.mOnScrollToTopListener.onScrollToTop();
                            }
                        }
                    });
                }
                if (h.this.avD != null && h.this.avE > 0) {
                    h.this.getHandler().removeCallbacks(h.this.mDelayedRunnable);
                    h.this.getHandler().postDelayed(h.this.mDelayedRunnable, h.this.avE);
                }
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(null);
        this.avC.setAdapter(adapter);
        super.setAdapter(this.avC);
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        if (this.avC != null) {
            return this.avC.getWrappedAdapter();
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.k
    public h getListView() {
        return this;
    }

    public j getListAdapter() {
        return (j) getAdapter();
    }

    @Override // com.baidu.adp.widget.ListView.k
    public int getHeaderViewsCount() {
        return this.avC.getHeadersCount();
    }

    @Override // com.baidu.adp.widget.ListView.k
    public int getFooterViewsCount() {
        return this.avC.getFootersCount();
    }

    @Override // com.baidu.adp.widget.ListView.k
    public int getContentViewsCount() {
        if (getWrappedAdapter() != null) {
            return getWrappedAdapter().getItemCount();
        }
        return 0;
    }

    public void setScrollable(com.baidu.adp.base.h hVar) {
        this.mScrollable = hVar;
    }

    public void setSelection(int i) {
        scrollToPosition(i);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.mOnScrollToBottomListener = eVar;
    }

    public void setOnSrollToTopListener(BdListView.h hVar) {
        this.mOnScrollToTopListener = hVar;
    }

    public int getFirstVisiblePosition() {
        int i;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return 0;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            i = ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
        } else if (layoutManager instanceof GridLayoutManager) {
            i = ((GridLayoutManager) layoutManager).findFirstVisibleItemPosition();
        } else if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            i = 0;
        } else {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
            staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
            i = h(iArr);
        }
        return i;
    }

    public int getLastVisiblePosition() {
        int i;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return 0;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            i = ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
        } else if (layoutManager instanceof GridLayoutManager) {
            i = ((GridLayoutManager) layoutManager).findLastVisibleItemPosition();
        } else if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            i = 0;
        } else {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
            staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
            i = i(iArr);
        }
        return i;
    }

    public int getFirstCompletelyVisiblePosition() {
        int i;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return 0;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            i = ((LinearLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        } else if (layoutManager instanceof GridLayoutManager) {
            i = ((GridLayoutManager) layoutManager).findFirstCompletelyVisibleItemPosition();
        } else if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            i = 0;
        } else {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
            staggeredGridLayoutManager.findFirstCompletelyVisibleItemPositions(iArr);
            i = h(iArr);
        }
        return i;
    }

    public int getLastCompletelyVisiblePosition() {
        int i;
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        if (layoutManager == null) {
            return 0;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            i = ((LinearLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        } else if (layoutManager instanceof GridLayoutManager) {
            i = ((GridLayoutManager) layoutManager).findLastCompletelyVisibleItemPosition();
        } else if (!(layoutManager instanceof StaggeredGridLayoutManager)) {
            i = 0;
        } else {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
            staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(iArr);
            i = i(iArr);
        }
        return i;
    }

    @Override // com.baidu.adp.widget.ListView.k
    public boolean removeHeaderView(View view) {
        if (this.avC == null) {
            return false;
        }
        return this.avC.removeHeader(view);
    }

    public boolean removeFooterView(View view) {
        if (this.avC == null) {
            return false;
        }
        return this.avC.removeFooter(view);
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        this.avC.addHeaderView(view, obj, z, -1);
    }

    public void addHeaderView(View view) {
        this.avC.addHeaderView(view, -1);
    }

    public void addHeaderView(View view, int i) {
        this.avC.addHeaderView(view, i);
    }

    public void setNoData(String str) {
        if (str != null) {
            TextView textView = new TextView(getContext());
            textView.setText(str);
            textView.setTextSize(16.0f);
            textView.setGravity(17);
            setNoData(textView);
        }
    }

    public void setNoData(View view) {
        if (this.mNoDataView != null) {
            removeHeaderView(this.mNoDataView);
            this.mNoDataView = null;
        }
        if (view != null) {
            addHeaderView(view, null, false);
            this.mNoDataView = view;
        }
    }

    public void setPrePage(com.baidu.adp.widget.ListView.b bVar) {
        if (this.mPrePage == null || this.mPrePage != bVar) {
            if (this.mPrePage != null) {
                removeHeaderView(this.mPrePage.getView());
                this.mPrePage = null;
            }
            if (bVar != null) {
                addHeaderView(bVar.getView());
                this.mPrePage = bVar;
            }
        }
    }

    public void setNextPage(com.baidu.adp.widget.ListView.b bVar) {
        if (this.mNextPage == null || this.mNextPage != bVar) {
            if (this.mNextPage != null && this.mNextPage != bVar) {
                removeFooterView(this.mNextPage.getView());
                this.mNextPage = null;
            }
            if (bVar != null) {
                this.avC.addFooterView(bVar.getView(), null, true, 0);
                this.mNextPage = bVar;
            }
        }
    }

    public l getPreLoadHandle() {
        return this.mPreLoadListView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.mDelayedRunnable);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (NullPointerException e) {
            BdLog.detailException(e);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        } catch (OutOfMemoryError e2) {
            BdBaseApplication.getInst().onAppMemoryLow();
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    public void setOnItemClickListener(a aVar) {
        this.avx = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemLongClickListener(b bVar) {
        this.avy = bVar;
    }

    public void setOnHeaderClickListener(BdListView.b bVar) {
        this.mOnHeaderClickListener = bVar;
    }

    public void setOnFooterClickListener(BdListView.a aVar) {
        this.mOnFooterClickListener = aVar;
    }

    private int h(int[] iArr) {
        int i = 0;
        if (iArr != null) {
            int i2 = iArr[0];
            int length = iArr.length;
            int i3 = 0;
            i = i2;
            while (i3 < length) {
                int i4 = iArr[i3];
                if (i4 >= i) {
                    i4 = i;
                }
                i3++;
                i = i4;
            }
        }
        return i;
    }

    private int i(int[] iArr) {
        int i = 0;
        if (iArr != null) {
            int i2 = iArr[0];
            int length = iArr.length;
            int i3 = 0;
            i = i2;
            while (i3 < length) {
                int i4 = iArr[i3];
                if (i4 <= i) {
                    i4 = i;
                }
                i3++;
                i = i4;
            }
        }
        return i;
    }
}
