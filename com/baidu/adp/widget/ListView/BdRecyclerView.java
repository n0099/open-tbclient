package com.baidu.adp.widget.ListView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
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
import com.baidu.adp.widget.ListView.e;
/* loaded from: classes.dex */
public class BdRecyclerView extends RecyclerView implements s<BdRecyclerView> {
    private static final String LOG_TAG = BdRecyclerView.class.getSimpleName();
    private BdListView.b WL;
    private BdListView.a WM;
    private BdListView.h WP;
    private BdListView.e WQ;
    private com.baidu.adp.base.h WS;
    private a Xk;
    private b Xl;
    private h Xo;
    private BdListView.d Xp;
    private long Xq;
    private boolean Xr;
    private boolean Xs;
    private Runnable mDelayedRunnable;
    private c mNextPage;
    private View mNoDataView;
    private t mPreLoadListView;
    private c mPrePage;
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

    public BdRecyclerView(Context context) {
        super(context);
        this.WS = null;
        this.Xk = null;
        this.Xl = null;
        this.WL = null;
        this.WM = null;
        this.WQ = null;
        this.WP = null;
        this.Xp = null;
        this.Xq = 100L;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.Xr = true;
        this.Xs = true;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                int i2 = -1;
                if (BdRecyclerView.this.Xp != null) {
                    int firstVisiblePosition = BdRecyclerView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdRecyclerView.this.getLastVisiblePosition();
                    if (BdRecyclerView.this.Xo == null || BdRecyclerView.this.Xo.getWrappedAdapter() == null || BdRecyclerView.this.Xo.getWrappedAdapter().getItemCount() <= 0) {
                        i = -1;
                    } else {
                        i2 = firstVisiblePosition - BdRecyclerView.this.Xo.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        int headersCount = lastVisiblePosition - BdRecyclerView.this.Xo.getHeadersCount();
                        if (headersCount >= BdRecyclerView.this.Xo.getWrappedAdapter().getItemCount()) {
                            headersCount = BdRecyclerView.this.Xo.getWrappedAdapter().getItemCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                    }
                    BdRecyclerView.this.Xp.onScrollStop(i2, i);
                }
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                int childCount = BdRecyclerView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    refreshImage(BdRecyclerView.this.getChildAt(i));
                }
                BdRecyclerView.this.preLoadRunnable.run();
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.newwidget.ImageView.i) {
                        ((com.baidu.adp.newwidget.ImageView.i) view).refresh();
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
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h H;
                if (BdRecyclerView.this.WS != null) {
                    H = BdRecyclerView.this.WS;
                } else {
                    H = com.baidu.adp.base.i.H(BdRecyclerView.this.getContext());
                }
                if (H != null) {
                    H.onPreLoad(BdRecyclerView.this.mPreLoadListView);
                }
            }
        };
        this.mPreLoadListView = new t() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.4
            @Override // com.baidu.adp.widget.ListView.t
            public r getAdapter() {
                return BdRecyclerView.this.Xo;
            }

            @Override // com.baidu.adp.widget.ListView.t
            public int getFirstVisiblePosition() {
                return BdRecyclerView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.t
            public int getLastVisiblePosition() {
                return BdRecyclerView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.t
            public void cancelRefresh() {
                BdRecyclerView.this.removeCallbacks(BdRecyclerView.this.refreshRunnable);
            }
        };
        initial();
    }

    public BdRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.WS = null;
        this.Xk = null;
        this.Xl = null;
        this.WL = null;
        this.WM = null;
        this.WQ = null;
        this.WP = null;
        this.Xp = null;
        this.Xq = 100L;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.Xr = true;
        this.Xs = true;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                int i = 0;
                int i2 = -1;
                if (BdRecyclerView.this.Xp != null) {
                    int firstVisiblePosition = BdRecyclerView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdRecyclerView.this.getLastVisiblePosition();
                    if (BdRecyclerView.this.Xo == null || BdRecyclerView.this.Xo.getWrappedAdapter() == null || BdRecyclerView.this.Xo.getWrappedAdapter().getItemCount() <= 0) {
                        i = -1;
                    } else {
                        i2 = firstVisiblePosition - BdRecyclerView.this.Xo.getHeadersCount();
                        if (i2 < 0) {
                            i2 = 0;
                        }
                        int headersCount = lastVisiblePosition - BdRecyclerView.this.Xo.getHeadersCount();
                        if (headersCount >= BdRecyclerView.this.Xo.getWrappedAdapter().getItemCount()) {
                            headersCount = BdRecyclerView.this.Xo.getWrappedAdapter().getItemCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i = headersCount;
                        }
                    }
                    BdRecyclerView.this.Xp.onScrollStop(i2, i);
                }
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                int childCount = BdRecyclerView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    refreshImage(BdRecyclerView.this.getChildAt(i));
                }
                BdRecyclerView.this.preLoadRunnable.run();
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.newwidget.ImageView.i) {
                        ((com.baidu.adp.newwidget.ImageView.i) view).refresh();
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
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h H;
                if (BdRecyclerView.this.WS != null) {
                    H = BdRecyclerView.this.WS;
                } else {
                    H = com.baidu.adp.base.i.H(BdRecyclerView.this.getContext());
                }
                if (H != null) {
                    H.onPreLoad(BdRecyclerView.this.mPreLoadListView);
                }
            }
        };
        this.mPreLoadListView = new t() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.4
            @Override // com.baidu.adp.widget.ListView.t
            public r getAdapter() {
                return BdRecyclerView.this.Xo;
            }

            @Override // com.baidu.adp.widget.ListView.t
            public int getFirstVisiblePosition() {
                return BdRecyclerView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.t
            public int getLastVisiblePosition() {
                return BdRecyclerView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.t
            public void cancelRefresh() {
                BdRecyclerView.this.removeCallbacks(BdRecyclerView.this.refreshRunnable);
            }
        };
        initial();
    }

    public BdRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.WS = null;
        this.Xk = null;
        this.Xl = null;
        this.WL = null;
        this.WM = null;
        this.WQ = null;
        this.WP = null;
        this.Xp = null;
        this.Xq = 100L;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.Xr = true;
        this.Xs = true;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 0;
                int i22 = -1;
                if (BdRecyclerView.this.Xp != null) {
                    int firstVisiblePosition = BdRecyclerView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdRecyclerView.this.getLastVisiblePosition();
                    if (BdRecyclerView.this.Xo == null || BdRecyclerView.this.Xo.getWrappedAdapter() == null || BdRecyclerView.this.Xo.getWrappedAdapter().getItemCount() <= 0) {
                        i2 = -1;
                    } else {
                        i22 = firstVisiblePosition - BdRecyclerView.this.Xo.getHeadersCount();
                        if (i22 < 0) {
                            i22 = 0;
                        }
                        int headersCount = lastVisiblePosition - BdRecyclerView.this.Xo.getHeadersCount();
                        if (headersCount >= BdRecyclerView.this.Xo.getWrappedAdapter().getItemCount()) {
                            headersCount = BdRecyclerView.this.Xo.getWrappedAdapter().getItemCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i2 = headersCount;
                        }
                    }
                    BdRecyclerView.this.Xp.onScrollStop(i22, i2);
                }
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.2
            @Override // java.lang.Runnable
            public void run() {
                int childCount = BdRecyclerView.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    refreshImage(BdRecyclerView.this.getChildAt(i2));
                }
                BdRecyclerView.this.preLoadRunnable.run();
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.newwidget.ImageView.i) {
                        ((com.baidu.adp.newwidget.ImageView.i) view).refresh();
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
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h H;
                if (BdRecyclerView.this.WS != null) {
                    H = BdRecyclerView.this.WS;
                } else {
                    H = com.baidu.adp.base.i.H(BdRecyclerView.this.getContext());
                }
                if (H != null) {
                    H.onPreLoad(BdRecyclerView.this.mPreLoadListView);
                }
            }
        };
        this.mPreLoadListView = new t() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.4
            @Override // com.baidu.adp.widget.ListView.t
            public r getAdapter() {
                return BdRecyclerView.this.Xo;
            }

            @Override // com.baidu.adp.widget.ListView.t
            public int getFirstVisiblePosition() {
                return BdRecyclerView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.t
            public int getLastVisiblePosition() {
                return BdRecyclerView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.t
            public void cancelRefresh() {
                BdRecyclerView.this.removeCallbacks(BdRecyclerView.this.refreshRunnable);
            }
        };
        initial();
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.Xo = new h(getContext());
        this.Xo.a(new e.a() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.5
            @Override // com.baidu.adp.widget.ListView.e.a
            public void onPreLoad() {
                BdRecyclerView.this.removeCallbacks(BdRecyclerView.this.preLoadRunnable);
                BdRecyclerView.this.postDelayed(BdRecyclerView.this.preLoadRunnable, 100L);
            }
        });
        this.Xo.setOnItemClickListener(new a() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.6
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
            public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                int headerViewsCount = BdRecyclerView.this.getHeaderViewsCount();
                if (i < headerViewsCount) {
                    if (BdRecyclerView.this.mPrePage == null || view != BdRecyclerView.this.mPrePage.getView()) {
                        if (BdRecyclerView.this.WL != null) {
                            BdRecyclerView.this.WL.onClick(view);
                            return;
                        }
                        return;
                    }
                    BdRecyclerView.this.mPrePage.onClick();
                    return;
                }
                int i2 = i - headerViewsCount;
                RecyclerView.Adapter wrappedAdapter = BdRecyclerView.this.Xo.getWrappedAdapter();
                if (wrappedAdapter == null || i2 >= wrappedAdapter.getItemCount()) {
                    if (BdRecyclerView.this.mNextPage == null || view != BdRecyclerView.this.mNextPage.getView()) {
                        if (BdRecyclerView.this.WM != null) {
                            BdRecyclerView.this.WM.onClick(view);
                            return;
                        }
                        return;
                    }
                    BdRecyclerView.this.mNextPage.onClick();
                } else if (BdRecyclerView.this.Xk != null) {
                    BdRecyclerView.this.Xk.a(viewGroup, view, obj, i2, j);
                }
            }
        });
        this.Xo.setOnItemLongClickListener(new b() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.7
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.b
            public boolean b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                int headerViewsCount = i - BdRecyclerView.this.getHeaderViewsCount();
                RecyclerView.Adapter wrappedAdapter = BdRecyclerView.this.Xo.getWrappedAdapter();
                if (wrappedAdapter == null || headerViewsCount >= wrappedAdapter.getItemCount() || BdRecyclerView.this.Xl == null) {
                    return false;
                }
                return BdRecyclerView.this.Xl.b(viewGroup, view, obj, headerViewsCount, j);
            }
        });
        addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.8
            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                com.baidu.adp.base.h H;
                if (BdRecyclerView.this.WS != null) {
                    H = BdRecyclerView.this.WS;
                } else {
                    H = com.baidu.adp.base.i.H(BdRecyclerView.this.getContext());
                }
                if (H != null) {
                    if (i == 2) {
                        BdRecyclerView.this.removeCallbacks(BdRecyclerView.this.refreshRunnable);
                        H.setIsScroll(true);
                    } else if (H.isScroll()) {
                        H.setIsScroll(false);
                        BdRecyclerView.this.removeCallbacks(BdRecyclerView.this.refreshRunnable);
                        BdRecyclerView.this.postDelayed(BdRecyclerView.this.refreshRunnable, 100L);
                    } else if (i == 0) {
                        BdRecyclerView.this.removeCallbacks(BdRecyclerView.this.preLoadRunnable);
                        BdRecyclerView.this.postDelayed(BdRecyclerView.this.preLoadRunnable, 100L);
                    }
                }
            }

            @Override // android.support.v7.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                boolean canScrollVertically = BdRecyclerView.this.canScrollVertically(1);
                boolean canScrollVertically2 = BdRecyclerView.this.canScrollVertically(-1);
                if (!canScrollVertically && canScrollVertically2 && Math.abs(i2) > 0) {
                    if (BdRecyclerView.this.WQ != null) {
                        recyclerView.post(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (BdRecyclerView.this.WQ != null) {
                                    BdRecyclerView.this.WQ.onScrollToBottom();
                                }
                            }
                        });
                    }
                } else if (!canScrollVertically2 && canScrollVertically && Math.abs(i2) > 0 && BdRecyclerView.this.WP != null) {
                    recyclerView.post(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.8.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (BdRecyclerView.this.WP != null) {
                                BdRecyclerView.this.WP.onScrollToTop();
                            }
                        }
                    });
                }
                if (BdRecyclerView.this.Xp != null && BdRecyclerView.this.Xq > 0) {
                    BdRecyclerView.this.getHandler().removeCallbacks(BdRecyclerView.this.mDelayedRunnable);
                    BdRecyclerView.this.getHandler().postDelayed(BdRecyclerView.this.mDelayedRunnable, BdRecyclerView.this.Xq);
                }
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(null);
        this.Xo.setAdapter(adapter);
        super.setAdapter(this.Xo);
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        if (this.Xo != null) {
            return this.Xo.getWrappedAdapter();
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.s
    public BdRecyclerView getListView() {
        return this;
    }

    public r getListAdapter() {
        return (r) getAdapter();
    }

    @Override // com.baidu.adp.widget.ListView.s
    public int getHeaderViewsCount() {
        return this.Xo.getHeadersCount();
    }

    @Override // com.baidu.adp.widget.ListView.s
    public int getFooterViewsCount() {
        return this.Xo.getFootersCount();
    }

    @Override // com.baidu.adp.widget.ListView.s
    public int getContentViewsCount() {
        if (getWrappedAdapter() != null) {
            return getWrappedAdapter().getItemCount();
        }
        return 0;
    }

    public void setScrollable(com.baidu.adp.base.h hVar) {
        this.WS = hVar;
    }

    public void setSelection(int i) {
        scrollToPosition(i);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.WQ = eVar;
    }

    public void setOnSrollToTopListener(BdListView.h hVar) {
        this.WP = hVar;
    }

    public void setOnScrollStopDelayedListener(BdListView.d dVar, long j) {
        this.Xp = dVar;
        this.Xq = j;
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
            i = d(iArr);
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
            i = e(iArr);
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
            i = d(iArr);
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
            i = e(iArr);
        }
        return i;
    }

    @Override // com.baidu.adp.widget.ListView.s
    public boolean removeHeaderView(View view) {
        if (this.Xo == null) {
            return false;
        }
        return this.Xo.removeHeader(view);
    }

    public void addFooterView(View view) {
        if (this.Xo != null) {
            this.Xo.addFooterView(view);
        }
    }

    public boolean removeFooterView(View view) {
        if (this.Xo == null) {
            return false;
        }
        return this.Xo.removeFooter(view);
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        this.Xo.a(view, obj, z, true, -1);
    }

    public void addHeaderView(View view) {
        this.Xo.addHeaderView(view, -1);
    }

    public void addHeaderView(View view, int i) {
        this.Xo.addHeaderView(view, i);
    }

    public void setHeaderView(View view) {
        this.Xo.c(view, null, true, true, -1);
    }

    public void setHeaderView(View view, boolean z) {
        this.Xo.c(view, null, true, z, -1);
    }

    public void setFooterView(View view) {
        this.Xo.d(view, null, true, true, -1);
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

    public void setPrePage(c cVar) {
        if (this.mPrePage == null || this.mPrePage != cVar) {
            if (this.mPrePage != null) {
                removeHeaderView(this.mPrePage.getView());
                this.mPrePage = null;
            }
            if (cVar != null) {
                addHeaderView(cVar.getView());
                this.mPrePage = cVar;
            }
        }
    }

    public void setNextPage(c cVar) {
        if (this.mNextPage == null || this.mNextPage != cVar) {
            if (this.mNextPage != null && this.mNextPage != cVar) {
                removeFooterView(this.mNextPage.getView());
                this.mNextPage = null;
            }
            if (cVar != null) {
                this.Xo.addFooterView(cVar.getView(), null, true, 0);
                this.mNextPage = cVar;
            }
        }
    }

    public t getPreLoadHandle() {
        return this.mPreLoadListView;
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
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
        this.Xk = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemLongClickListener(b bVar) {
        this.Xl = bVar;
    }

    public void setOnHeaderClickListener(BdListView.b bVar) {
        this.WL = bVar;
    }

    public void setOnFooterClickListener(BdListView.a aVar) {
        this.WM = aVar;
    }

    private int d(int[] iArr) {
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

    private int e(int[] iArr) {
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

    @Override // android.support.v7.widget.RecyclerView, android.support.v4.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        if (this.Xs || i3 == 0) {
            return super.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
        }
        return false;
    }

    @Override // android.support.v7.widget.RecyclerView, android.support.v4.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        if (this.Xs || i5 == 0) {
            return super.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        }
        return false;
    }

    public void setCanFling(boolean z) {
        this.Xs = z;
    }

    @Override // android.support.v7.widget.RecyclerView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.Xr) {
            super.requestLayout();
        }
    }

    public void qT() {
        this.Xr = false;
    }

    public void qU() {
        this.Xr = true;
    }
}
