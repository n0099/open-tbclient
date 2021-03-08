package com.baidu.adp.widget.ListView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.d;
/* loaded from: classes.dex */
public class BdRecyclerView extends RecyclerView implements p<BdRecyclerView> {
    private static final String LOG_TAG = BdRecyclerView.class.getSimpleName();
    private BdListView.b XW;
    private BdListView.a XX;
    private BdListView.d YA;
    private long YB;
    private boolean YC;
    private boolean YD;
    private BdListView.h Ya;
    private BdListView.e Yb;
    private com.baidu.adp.base.i Ye;
    private a Yv;
    private b Yw;
    private BdRecyclerAdapter Yz;
    private Runnable mDelayedRunnable;
    private com.baidu.adp.widget.ListView.b mNextPage;
    private View mNoDataView;
    private q mPreLoadListView;
    private com.baidu.adp.widget.ListView.b mPrePage;
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
        this.Ye = null;
        this.Yv = null;
        this.Yw = null;
        this.XW = null;
        this.XX = null;
        this.Yb = null;
        this.Ya = null;
        this.YA = null;
        this.YB = 100L;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.YC = true;
        this.YD = true;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2 = 0;
                if (BdRecyclerView.this.YA != null) {
                    int firstVisiblePosition = BdRecyclerView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdRecyclerView.this.getLastVisiblePosition();
                    if (BdRecyclerView.this.Yz == null || BdRecyclerView.this.Yz.getWrappedAdapter() == null || BdRecyclerView.this.Yz.getWrappedAdapter().getItemCount() <= 0) {
                        i2 = -1;
                        i = -1;
                    } else {
                        int headersCount = firstVisiblePosition - BdRecyclerView.this.Yz.getHeadersCount();
                        if (headersCount < 0) {
                            headersCount = 0;
                        }
                        int headersCount2 = lastVisiblePosition - BdRecyclerView.this.Yz.getHeadersCount();
                        if (headersCount2 >= BdRecyclerView.this.Yz.getWrappedAdapter().getItemCount()) {
                            headersCount2 = BdRecyclerView.this.Yz.getWrappedAdapter().getItemCount() - 1;
                        }
                        if (headersCount2 < 0) {
                            i = headersCount;
                        } else {
                            i2 = headersCount2;
                            i = headersCount;
                        }
                    }
                    BdRecyclerView.this.YA.onScrollStop(i, i2);
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
                com.baidu.adp.base.i H;
                if (BdRecyclerView.this.Ye != null) {
                    H = BdRecyclerView.this.Ye;
                } else {
                    H = com.baidu.adp.base.j.H(BdRecyclerView.this.getContext());
                }
                if (H != null) {
                    H.onPreLoad(BdRecyclerView.this.mPreLoadListView);
                }
            }
        };
        this.mPreLoadListView = new q() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.4
            @Override // com.baidu.adp.widget.ListView.q
            public o getAdapter() {
                return BdRecyclerView.this.Yz;
            }

            @Override // com.baidu.adp.widget.ListView.q
            public int getFirstVisiblePosition() {
                return BdRecyclerView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.q
            public int getLastVisiblePosition() {
                return BdRecyclerView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.q
            public void cancelRefresh() {
                BdRecyclerView.this.removeCallbacks(BdRecyclerView.this.refreshRunnable);
            }
        };
        initial();
    }

    public BdRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.Ye = null;
        this.Yv = null;
        this.Yw = null;
        this.XW = null;
        this.XX = null;
        this.Yb = null;
        this.Ya = null;
        this.YA = null;
        this.YB = 100L;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.YC = true;
        this.YD = true;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2 = 0;
                if (BdRecyclerView.this.YA != null) {
                    int firstVisiblePosition = BdRecyclerView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdRecyclerView.this.getLastVisiblePosition();
                    if (BdRecyclerView.this.Yz == null || BdRecyclerView.this.Yz.getWrappedAdapter() == null || BdRecyclerView.this.Yz.getWrappedAdapter().getItemCount() <= 0) {
                        i2 = -1;
                        i = -1;
                    } else {
                        int headersCount = firstVisiblePosition - BdRecyclerView.this.Yz.getHeadersCount();
                        if (headersCount < 0) {
                            headersCount = 0;
                        }
                        int headersCount2 = lastVisiblePosition - BdRecyclerView.this.Yz.getHeadersCount();
                        if (headersCount2 >= BdRecyclerView.this.Yz.getWrappedAdapter().getItemCount()) {
                            headersCount2 = BdRecyclerView.this.Yz.getWrappedAdapter().getItemCount() - 1;
                        }
                        if (headersCount2 < 0) {
                            i = headersCount;
                        } else {
                            i2 = headersCount2;
                            i = headersCount;
                        }
                    }
                    BdRecyclerView.this.YA.onScrollStop(i, i2);
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
                com.baidu.adp.base.i H;
                if (BdRecyclerView.this.Ye != null) {
                    H = BdRecyclerView.this.Ye;
                } else {
                    H = com.baidu.adp.base.j.H(BdRecyclerView.this.getContext());
                }
                if (H != null) {
                    H.onPreLoad(BdRecyclerView.this.mPreLoadListView);
                }
            }
        };
        this.mPreLoadListView = new q() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.4
            @Override // com.baidu.adp.widget.ListView.q
            public o getAdapter() {
                return BdRecyclerView.this.Yz;
            }

            @Override // com.baidu.adp.widget.ListView.q
            public int getFirstVisiblePosition() {
                return BdRecyclerView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.q
            public int getLastVisiblePosition() {
                return BdRecyclerView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.q
            public void cancelRefresh() {
                BdRecyclerView.this.removeCallbacks(BdRecyclerView.this.refreshRunnable);
            }
        };
        initial();
    }

    public BdRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.Ye = null;
        this.Yv = null;
        this.Yw = null;
        this.XW = null;
        this.XX = null;
        this.Yb = null;
        this.Ya = null;
        this.YA = null;
        this.YB = 100L;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.YC = true;
        this.YD = true;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.1
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int i22 = 0;
                if (BdRecyclerView.this.YA != null) {
                    int firstVisiblePosition = BdRecyclerView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdRecyclerView.this.getLastVisiblePosition();
                    if (BdRecyclerView.this.Yz == null || BdRecyclerView.this.Yz.getWrappedAdapter() == null || BdRecyclerView.this.Yz.getWrappedAdapter().getItemCount() <= 0) {
                        i22 = -1;
                        i2 = -1;
                    } else {
                        int headersCount = firstVisiblePosition - BdRecyclerView.this.Yz.getHeadersCount();
                        if (headersCount < 0) {
                            headersCount = 0;
                        }
                        int headersCount2 = lastVisiblePosition - BdRecyclerView.this.Yz.getHeadersCount();
                        if (headersCount2 >= BdRecyclerView.this.Yz.getWrappedAdapter().getItemCount()) {
                            headersCount2 = BdRecyclerView.this.Yz.getWrappedAdapter().getItemCount() - 1;
                        }
                        if (headersCount2 < 0) {
                            i2 = headersCount;
                        } else {
                            i22 = headersCount2;
                            i2 = headersCount;
                        }
                    }
                    BdRecyclerView.this.YA.onScrollStop(i2, i22);
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
                com.baidu.adp.base.i H;
                if (BdRecyclerView.this.Ye != null) {
                    H = BdRecyclerView.this.Ye;
                } else {
                    H = com.baidu.adp.base.j.H(BdRecyclerView.this.getContext());
                }
                if (H != null) {
                    H.onPreLoad(BdRecyclerView.this.mPreLoadListView);
                }
            }
        };
        this.mPreLoadListView = new q() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.4
            @Override // com.baidu.adp.widget.ListView.q
            public o getAdapter() {
                return BdRecyclerView.this.Yz;
            }

            @Override // com.baidu.adp.widget.ListView.q
            public int getFirstVisiblePosition() {
                return BdRecyclerView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.q
            public int getLastVisiblePosition() {
                return BdRecyclerView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.q
            public void cancelRefresh() {
                BdRecyclerView.this.removeCallbacks(BdRecyclerView.this.refreshRunnable);
            }
        };
        initial();
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.Yz = new BdRecyclerAdapter(getContext());
        this.Yz.a(new d.a() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.5
            @Override // com.baidu.adp.widget.ListView.d.a
            public void onPreLoad() {
                BdRecyclerView.this.removeCallbacks(BdRecyclerView.this.preLoadRunnable);
                BdRecyclerView.this.postDelayed(BdRecyclerView.this.preLoadRunnable, 100L);
            }
        });
        this.Yz.setOnItemClickListener(new a() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.6
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.a
            public void a(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                int headerViewsCount = BdRecyclerView.this.getHeaderViewsCount();
                if (i < headerViewsCount) {
                    if (BdRecyclerView.this.mPrePage == null || view != BdRecyclerView.this.mPrePage.getView()) {
                        if (BdRecyclerView.this.XW != null) {
                            BdRecyclerView.this.XW.onClick(view);
                            return;
                        }
                        return;
                    }
                    BdRecyclerView.this.mPrePage.onClick();
                    return;
                }
                int i2 = i - headerViewsCount;
                RecyclerView.Adapter wrappedAdapter = BdRecyclerView.this.Yz.getWrappedAdapter();
                if (wrappedAdapter == null || i2 >= wrappedAdapter.getItemCount()) {
                    if (BdRecyclerView.this.mNextPage == null || view != BdRecyclerView.this.mNextPage.getView()) {
                        if (BdRecyclerView.this.XX != null) {
                            BdRecyclerView.this.XX.onClick(view);
                            return;
                        }
                        return;
                    }
                    BdRecyclerView.this.mNextPage.onClick();
                } else if (BdRecyclerView.this.Yv != null) {
                    BdRecyclerView.this.Yv.a(viewGroup, view, obj, i2, j);
                }
            }
        });
        this.Yz.setOnItemLongClickListener(new b() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.7
            @Override // com.baidu.adp.widget.ListView.BdRecyclerView.b
            public boolean b(ViewGroup viewGroup, View view, Object obj, int i, long j) {
                int headerViewsCount = i - BdRecyclerView.this.getHeaderViewsCount();
                RecyclerView.Adapter wrappedAdapter = BdRecyclerView.this.Yz.getWrappedAdapter();
                if (wrappedAdapter == null || headerViewsCount >= wrappedAdapter.getItemCount() || BdRecyclerView.this.Yw == null) {
                    return false;
                }
                return BdRecyclerView.this.Yw.b(viewGroup, view, obj, headerViewsCount, j);
            }
        });
        addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.8
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrollStateChanged(RecyclerView recyclerView, int i) {
                com.baidu.adp.base.i H;
                if (BdRecyclerView.this.Ye != null) {
                    H = BdRecyclerView.this.Ye;
                } else {
                    H = com.baidu.adp.base.j.H(BdRecyclerView.this.getContext());
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

            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                boolean canScrollVertically = BdRecyclerView.this.canScrollVertically(1);
                boolean canScrollVertically2 = BdRecyclerView.this.canScrollVertically(-1);
                if (!canScrollVertically && canScrollVertically2 && Math.abs(i2) > 0) {
                    if (BdRecyclerView.this.Yb != null) {
                        recyclerView.post(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (BdRecyclerView.this.Yb != null) {
                                    BdRecyclerView.this.Yb.onScrollToBottom();
                                }
                            }
                        });
                    }
                } else if (!canScrollVertically2 && canScrollVertically && Math.abs(i2) > 0 && BdRecyclerView.this.Ya != null) {
                    recyclerView.post(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdRecyclerView.8.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (BdRecyclerView.this.Ya != null) {
                                BdRecyclerView.this.Ya.onScrollToTop();
                            }
                        }
                    });
                }
                if (BdRecyclerView.this.YA != null && BdRecyclerView.this.YB > 0) {
                    BdRecyclerView.this.getHandler().removeCallbacks(BdRecyclerView.this.mDelayedRunnable);
                    BdRecyclerView.this.getHandler().postDelayed(BdRecyclerView.this.mDelayedRunnable, BdRecyclerView.this.YB);
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(RecyclerView.Adapter adapter) {
        super.setAdapter(null);
        this.Yz.setAdapter(adapter);
        super.setAdapter(this.Yz);
    }

    public RecyclerView.Adapter getWrappedAdapter() {
        if (this.Yz != null) {
            return this.Yz.getWrappedAdapter();
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.p
    public BdRecyclerView getListView() {
        return this;
    }

    public o getListAdapter() {
        return (o) getAdapter();
    }

    @Override // com.baidu.adp.widget.ListView.p
    public int getHeaderViewsCount() {
        return this.Yz.getHeadersCount();
    }

    @Override // com.baidu.adp.widget.ListView.p
    public int getFooterViewsCount() {
        return this.Yz.getFootersCount();
    }

    @Override // com.baidu.adp.widget.ListView.p
    public int getContentViewsCount() {
        if (getWrappedAdapter() != null) {
            return getWrappedAdapter().getItemCount();
        }
        return 0;
    }

    public void setScrollable(com.baidu.adp.base.i iVar) {
        this.Ye = iVar;
    }

    public void setSelection(int i) {
        scrollToPosition(i);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.Yb = eVar;
    }

    public void setOnSrollToTopListener(BdListView.h hVar) {
        this.Ya = hVar;
    }

    public void setOnScrollStopDelayedListener(BdListView.d dVar, long j) {
        this.YA = dVar;
        this.YB = j;
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
            i = e(iArr);
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
            i = f(iArr);
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
            i = e(iArr);
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
            i = f(iArr);
        }
        return i;
    }

    @Override // com.baidu.adp.widget.ListView.p
    public boolean removeHeaderView(View view) {
        if (this.Yz == null) {
            return false;
        }
        return this.Yz.removeHeader(view);
    }

    public void addFooterView(View view) {
        if (this.Yz != null) {
            this.Yz.addFooterView(view);
        }
    }

    public boolean removeFooterView(View view) {
        if (this.Yz == null) {
            return false;
        }
        return this.Yz.removeFooter(view);
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        this.Yz.a(view, obj, z, true, -1);
    }

    public void addHeaderView(View view) {
        this.Yz.addHeaderView(view, -1);
    }

    public void addHeaderView(View view, int i) {
        this.Yz.addHeaderView(view, i);
    }

    public void setHeaderView(View view) {
        this.Yz.c(view, null, true, true, -1);
    }

    public void setHeaderView(View view, boolean z) {
        this.Yz.c(view, null, true, z, -1);
    }

    public void setFooterView(View view) {
        this.Yz.d(view, null, true, true, -1);
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
                this.Yz.addFooterView(bVar.getView(), null, true, 0);
                this.mNextPage = bVar;
            }
        }
    }

    public q getPreLoadHandle() {
        return this.mPreLoadListView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
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
        this.Yv = aVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setOnItemLongClickListener(b bVar) {
        this.Yw = bVar;
    }

    public void setOnHeaderClickListener(BdListView.b bVar) {
        this.XW = bVar;
    }

    public void setOnFooterClickListener(BdListView.a aVar) {
        this.XX = aVar;
    }

    private int e(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int i = iArr[0];
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = iArr[i2];
            if (i3 >= i) {
                i3 = i;
            }
            i2++;
            i = i3;
        }
        return i;
    }

    private int f(int[] iArr) {
        if (iArr == null) {
            return 0;
        }
        int i = iArr[0];
        int length = iArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3 = iArr[i2];
            if (i3 <= i) {
                i3 = i;
            }
            i2++;
            i = i3;
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2, int i3) {
        if (this.YD || i3 == 0) {
            return super.dispatchNestedPreScroll(i, i2, iArr, iArr2, i3);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, androidx.core.view.NestedScrollingChild2
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr, int i5) {
        if (this.YD || i5 == 0) {
            return super.dispatchNestedScroll(i, i2, i3, i4, iArr, i5);
        }
        return false;
    }

    public void setCanFling(boolean z) {
        this.YD = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.YC) {
            super.requestLayout();
        }
    }

    public void qt() {
        this.YC = false;
    }

    public void qu() {
        this.YC = true;
    }
}
