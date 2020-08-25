package com.baidu.ala.widget.multicolumn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.base.h;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.c;
import com.baidu.adp.widget.ListView.d;
import com.baidu.adp.widget.ListView.f;
import com.baidu.adp.widget.ListView.g;
import com.baidu.adp.widget.ListView.r;
import com.baidu.adp.widget.ListView.t;
import com.huewu.pla.lib.MultiColumnListView;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import com.huewu.pla.lib.internal.a;
import java.security.InvalidParameterException;
/* loaded from: classes7.dex */
public class BdMultiColumnListView extends MultiColumnListView {
    private static final int REFRESH_DELAY = 100;
    private BdSimplePreLoadListAdapter mBdListAdpter;
    private Runnable mDelayedRunnable;
    private int mFirstVisibleItemIndex;
    private boolean mIsPreLoad;
    private int mLastAddPosition;
    private int mLastLoadCount;
    private c mNextPage;
    private View mNoDataView;
    private OnFooterClickListener mOnFooterClickListener;
    private OnHeaderClickListener mOnHeaderClickListener;
    private PLA_AdapterView.c mOnItemClickListener;
    private PLA_AdapterView.d mOnItemLongClickListener;
    private PLA_AdapterView.e mOnItemSelectedListener;
    private OnItemWillVisibleListener mOnItemWillVisibleListener;
    private PLA_AbsListView.c mOnScrollListener;
    private OnScrollStopDelayedListener mOnScrollStopDelayedListener;
    private long mOnScrollStopDelayedMillis;
    private OnScrollToBottomListener mOnScrollToBottomListener;
    private OnScrollToPullListener mOnScrollToPullListener;
    private OnScrollToTopListener mOnScrollToTopListener;
    private t mPreLoadListView;
    private int mPreLoadNum;
    private c mPrePage;
    private PullRefresh mPullRefresh;
    private int mScrollToTopNum;
    private Runnable preLoadRunnable;
    private Runnable refreshRunnable;

    /* loaded from: classes7.dex */
    public interface OnFooterClickListener {
        void onClick(View view);
    }

    /* loaded from: classes7.dex */
    public interface OnHeaderClickListener {
        void onClick(View view);
    }

    /* loaded from: classes7.dex */
    public interface OnItemWillVisibleListener {
        void onItemWillVisible(int i, boolean z);
    }

    /* loaded from: classes7.dex */
    public interface OnScrollStopDelayedListener {
        void onScrollStop(int i, int i2);
    }

    /* loaded from: classes7.dex */
    public interface OnScrollToBottomListener {
        void onScrollToBottom();
    }

    /* loaded from: classes7.dex */
    public interface OnScrollToPullListener {
        void onScrollToPull(boolean z);
    }

    /* loaded from: classes7.dex */
    public interface OnScrollToTopListener {
        void onScrollToTop();
    }

    public BdMultiColumnListView(Context context) {
        super(context);
        this.mBdListAdpter = null;
        this.mOnItemClickListener = null;
        this.mOnItemLongClickListener = null;
        this.mOnItemSelectedListener = null;
        this.mOnHeaderClickListener = null;
        this.mOnFooterClickListener = null;
        this.mOnScrollListener = null;
        this.mOnScrollStopDelayedListener = null;
        this.mOnScrollToPullListener = null;
        this.mOnScrollStopDelayedMillis = 100L;
        this.mOnScrollToTopListener = null;
        this.mScrollToTopNum = 0;
        this.mOnScrollToBottomListener = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2 = 0;
                if (BdMultiColumnListView.this.mOnScrollStopDelayedListener != null) {
                    int firstVisiblePosition = BdMultiColumnListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdMultiColumnListView.this.getLastVisiblePosition();
                    if (BdMultiColumnListView.this.mAdapter instanceof a) {
                        int headersCount = firstVisiblePosition - ((a) BdMultiColumnListView.this.mAdapter).getHeadersCount();
                        i = headersCount < 0 ? 0 : headersCount;
                        int headersCount2 = lastVisiblePosition - ((a) BdMultiColumnListView.this.mAdapter).getHeadersCount();
                        if (headersCount2 >= BdMultiColumnListView.this.mAdapter.getCount()) {
                            headersCount2 = BdMultiColumnListView.this.mAdapter.getCount() - 1;
                        }
                        if (headersCount2 >= 0) {
                            i2 = headersCount2;
                        }
                    } else {
                        i2 = -1;
                        i = -1;
                    }
                    BdMultiColumnListView.this.mOnScrollStopDelayedListener.onScrollStop(i, i2);
                }
            }
        };
        this.mPreLoadListView = new t() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.2
            @Override // com.baidu.adp.widget.ListView.t
            public r getAdapter() {
                return BdMultiColumnListView.this.mBdListAdpter;
            }

            @Override // com.baidu.adp.widget.ListView.t
            public int getFirstVisiblePosition() {
                return BdMultiColumnListView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.t
            public int getLastVisiblePosition() {
                return BdMultiColumnListView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.t
            public void cancelRefresh() {
                BdMultiColumnListView.this.removeCallbacks(BdMultiColumnListView.this.refreshRunnable);
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.3
            @Override // java.lang.Runnable
            public void run() {
                int childCount = BdMultiColumnListView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    refreshImage(BdMultiColumnListView.this.getChildAt(i));
                }
                h G = i.G(BdMultiColumnListView.this.getContext());
                if (G != null) {
                    G.onPreLoad(BdMultiColumnListView.this.mPreLoadListView);
                }
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
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.4
            @Override // java.lang.Runnable
            public void run() {
                h G = i.G(BdMultiColumnListView.this.getContext());
                if (G != null) {
                    G.onPreLoad(BdMultiColumnListView.this.mPreLoadListView);
                }
            }
        };
        this.mPullRefresh = null;
        initial();
    }

    public BdMultiColumnListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mBdListAdpter = null;
        this.mOnItemClickListener = null;
        this.mOnItemLongClickListener = null;
        this.mOnItemSelectedListener = null;
        this.mOnHeaderClickListener = null;
        this.mOnFooterClickListener = null;
        this.mOnScrollListener = null;
        this.mOnScrollStopDelayedListener = null;
        this.mOnScrollToPullListener = null;
        this.mOnScrollStopDelayedMillis = 100L;
        this.mOnScrollToTopListener = null;
        this.mScrollToTopNum = 0;
        this.mOnScrollToBottomListener = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2 = 0;
                if (BdMultiColumnListView.this.mOnScrollStopDelayedListener != null) {
                    int firstVisiblePosition = BdMultiColumnListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdMultiColumnListView.this.getLastVisiblePosition();
                    if (BdMultiColumnListView.this.mAdapter instanceof a) {
                        int headersCount = firstVisiblePosition - ((a) BdMultiColumnListView.this.mAdapter).getHeadersCount();
                        i = headersCount < 0 ? 0 : headersCount;
                        int headersCount2 = lastVisiblePosition - ((a) BdMultiColumnListView.this.mAdapter).getHeadersCount();
                        if (headersCount2 >= BdMultiColumnListView.this.mAdapter.getCount()) {
                            headersCount2 = BdMultiColumnListView.this.mAdapter.getCount() - 1;
                        }
                        if (headersCount2 >= 0) {
                            i2 = headersCount2;
                        }
                    } else {
                        i2 = -1;
                        i = -1;
                    }
                    BdMultiColumnListView.this.mOnScrollStopDelayedListener.onScrollStop(i, i2);
                }
            }
        };
        this.mPreLoadListView = new t() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.2
            @Override // com.baidu.adp.widget.ListView.t
            public r getAdapter() {
                return BdMultiColumnListView.this.mBdListAdpter;
            }

            @Override // com.baidu.adp.widget.ListView.t
            public int getFirstVisiblePosition() {
                return BdMultiColumnListView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.t
            public int getLastVisiblePosition() {
                return BdMultiColumnListView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.t
            public void cancelRefresh() {
                BdMultiColumnListView.this.removeCallbacks(BdMultiColumnListView.this.refreshRunnable);
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.3
            @Override // java.lang.Runnable
            public void run() {
                int childCount = BdMultiColumnListView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    refreshImage(BdMultiColumnListView.this.getChildAt(i));
                }
                h G = i.G(BdMultiColumnListView.this.getContext());
                if (G != null) {
                    G.onPreLoad(BdMultiColumnListView.this.mPreLoadListView);
                }
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
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.4
            @Override // java.lang.Runnable
            public void run() {
                h G = i.G(BdMultiColumnListView.this.getContext());
                if (G != null) {
                    G.onPreLoad(BdMultiColumnListView.this.mPreLoadListView);
                }
            }
        };
        this.mPullRefresh = null;
        initial();
    }

    public BdMultiColumnListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBdListAdpter = null;
        this.mOnItemClickListener = null;
        this.mOnItemLongClickListener = null;
        this.mOnItemSelectedListener = null;
        this.mOnHeaderClickListener = null;
        this.mOnFooterClickListener = null;
        this.mOnScrollListener = null;
        this.mOnScrollStopDelayedListener = null;
        this.mOnScrollToPullListener = null;
        this.mOnScrollStopDelayedMillis = 100L;
        this.mOnScrollToTopListener = null;
        this.mScrollToTopNum = 0;
        this.mOnScrollToBottomListener = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.1
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int i22 = 0;
                if (BdMultiColumnListView.this.mOnScrollStopDelayedListener != null) {
                    int firstVisiblePosition = BdMultiColumnListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdMultiColumnListView.this.getLastVisiblePosition();
                    if (BdMultiColumnListView.this.mAdapter instanceof a) {
                        int headersCount = firstVisiblePosition - ((a) BdMultiColumnListView.this.mAdapter).getHeadersCount();
                        i2 = headersCount < 0 ? 0 : headersCount;
                        int headersCount2 = lastVisiblePosition - ((a) BdMultiColumnListView.this.mAdapter).getHeadersCount();
                        if (headersCount2 >= BdMultiColumnListView.this.mAdapter.getCount()) {
                            headersCount2 = BdMultiColumnListView.this.mAdapter.getCount() - 1;
                        }
                        if (headersCount2 >= 0) {
                            i22 = headersCount2;
                        }
                    } else {
                        i22 = -1;
                        i2 = -1;
                    }
                    BdMultiColumnListView.this.mOnScrollStopDelayedListener.onScrollStop(i2, i22);
                }
            }
        };
        this.mPreLoadListView = new t() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.2
            @Override // com.baidu.adp.widget.ListView.t
            public r getAdapter() {
                return BdMultiColumnListView.this.mBdListAdpter;
            }

            @Override // com.baidu.adp.widget.ListView.t
            public int getFirstVisiblePosition() {
                return BdMultiColumnListView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.t
            public int getLastVisiblePosition() {
                return BdMultiColumnListView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.t
            public void cancelRefresh() {
                BdMultiColumnListView.this.removeCallbacks(BdMultiColumnListView.this.refreshRunnable);
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.3
            @Override // java.lang.Runnable
            public void run() {
                int childCount = BdMultiColumnListView.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    refreshImage(BdMultiColumnListView.this.getChildAt(i2));
                }
                h G = i.G(BdMultiColumnListView.this.getContext());
                if (G != null) {
                    G.onPreLoad(BdMultiColumnListView.this.mPreLoadListView);
                }
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
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.4
            @Override // java.lang.Runnable
            public void run() {
                h G = i.G(BdMultiColumnListView.this.getContext());
                if (G != null) {
                    G.onPreLoad(BdMultiColumnListView.this.mPreLoadListView);
                }
            }
        };
        this.mPullRefresh = null;
        initial();
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.mBdListAdpter = new BdSimplePreLoadListAdapter(getContext());
        this.mBdListAdpter.setListPreLoad(new f.a() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.5
            @Override // com.baidu.adp.widget.ListView.f.a
            public void onPreLoad() {
                BdMultiColumnListView.this.removeCallbacks(BdMultiColumnListView.this.preLoadRunnable);
                BdMultiColumnListView.this.postDelayed(BdMultiColumnListView.this.preLoadRunnable, 100L);
            }
        });
        super.setOnItemClickListener(new PLA_AdapterView.c() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.6
            @Override // com.huewu.pla.lib.internal.PLA_AdapterView.c
            public void onItemClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i, long j) {
                int i2 = 0;
                if (BdMultiColumnListView.this.mAdapter instanceof a) {
                    i2 = ((a) BdMultiColumnListView.this.mAdapter).getHeadersCount();
                }
                if (i < i2) {
                    if (BdMultiColumnListView.this.mPrePage == null || view != BdMultiColumnListView.this.mPrePage.getView()) {
                        if (BdMultiColumnListView.this.mOnHeaderClickListener != null) {
                            BdMultiColumnListView.this.mOnHeaderClickListener.onClick(view);
                            return;
                        }
                        return;
                    }
                    BdMultiColumnListView.this.mPrePage.onClick();
                    return;
                }
                int i3 = i - i2;
                ListAdapter wrappedAdapter = BdMultiColumnListView.this.mAdapter instanceof a ? ((a) BdMultiColumnListView.this.mAdapter).getWrappedAdapter() : BdMultiColumnListView.this.mAdapter;
                if (wrappedAdapter == null || i3 >= wrappedAdapter.getCount()) {
                    if (BdMultiColumnListView.this.mNextPage == null || view != BdMultiColumnListView.this.mNextPage.getView()) {
                        if (BdMultiColumnListView.this.mOnFooterClickListener != null) {
                            BdMultiColumnListView.this.mOnFooterClickListener.onClick(view);
                            return;
                        }
                        return;
                    }
                    BdMultiColumnListView.this.mNextPage.onClick();
                } else if (BdMultiColumnListView.this.mOnItemClickListener != null) {
                    BdMultiColumnListView.this.mOnItemClickListener.onItemClick(pLA_AdapterView, view, i3, j);
                }
            }
        });
        super.setOnScrollListener(new PLA_AbsListView.c() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.7
            @Override // com.huewu.pla.lib.internal.PLA_AbsListView.c
            public void onScrollStateChanged(PLA_AbsListView pLA_AbsListView, int i) {
                h G = i.G(BdMultiColumnListView.this.getContext());
                if (G != null) {
                    if (i == 2) {
                        BdMultiColumnListView.this.removeCallbacks(BdMultiColumnListView.this.refreshRunnable);
                        G.setIsScroll(true);
                    } else if (G.isScroll()) {
                        G.setIsScroll(false);
                        BdMultiColumnListView.this.removeCallbacks(BdMultiColumnListView.this.refreshRunnable);
                        BdMultiColumnListView.this.postDelayed(BdMultiColumnListView.this.refreshRunnable, 100L);
                    } else if (i == 0) {
                        BdMultiColumnListView.this.removeCallbacks(BdMultiColumnListView.this.preLoadRunnable);
                        BdMultiColumnListView.this.postDelayed(BdMultiColumnListView.this.preLoadRunnable, 100L);
                    }
                }
                if (BdMultiColumnListView.this.mOnScrollListener != null) {
                    BdMultiColumnListView.this.mOnScrollListener.onScrollStateChanged(pLA_AbsListView, i);
                }
                if (i == 0) {
                    if (BdMultiColumnListView.this.mOnScrollToBottomListener != null && pLA_AbsListView.getLastVisiblePosition() == pLA_AbsListView.getCount() - 1 && pLA_AbsListView.getFirstVisiblePosition() != 0) {
                        BdMultiColumnListView.this.mOnScrollToBottomListener.onScrollToBottom();
                    }
                    if (BdMultiColumnListView.this.mOnScrollToTopListener != null && pLA_AbsListView.getFirstVisiblePosition() <= BdMultiColumnListView.this.mScrollToTopNum) {
                        BdMultiColumnListView.this.mOnScrollToTopListener.onScrollToTop();
                    }
                }
            }

            @Override // com.huewu.pla.lib.internal.PLA_AbsListView.c
            public void onScroll(PLA_AbsListView pLA_AbsListView, int i, int i2, int i3) {
                BdMultiColumnListView.this.mFirstVisibleItemIndex = i;
                if (BdMultiColumnListView.this.mOnScrollListener != null) {
                    BdMultiColumnListView.this.mOnScrollListener.onScroll(pLA_AbsListView, i, i2, i3);
                }
                if (BdMultiColumnListView.this.mOnScrollStopDelayedListener != null && BdMultiColumnListView.this.mOnScrollStopDelayedMillis > 0 && BdMultiColumnListView.this.getHandler() != null) {
                    BdMultiColumnListView.this.getHandler().removeCallbacks(BdMultiColumnListView.this.mDelayedRunnable);
                    BdMultiColumnListView.this.getHandler().postDelayed(BdMultiColumnListView.this.mDelayedRunnable, BdMultiColumnListView.this.mOnScrollStopDelayedMillis);
                }
            }
        });
    }

    public t getPreLoadHandle() {
        return this.mPreLoadListView;
    }

    public void setOnScrollToPullListener(OnScrollToPullListener onScrollToPullListener) {
        this.mOnScrollToPullListener = onScrollToPullListener;
    }

    public void setOnSrollToTopListener(OnScrollToTopListener onScrollToTopListener) {
        this.mOnScrollToTopListener = onScrollToTopListener;
    }

    public void setOnSrollToTopListener(OnScrollToTopListener onScrollToTopListener, int i) {
        this.mOnScrollToTopListener = onScrollToTopListener;
        int i2 = i - 1;
        if (i2 < 0) {
            i2 = 0;
        }
        this.mScrollToTopNum = i2;
    }

    public void setOnSrollToBottomListener(OnScrollToBottomListener onScrollToBottomListener) {
        this.mOnScrollToBottomListener = onScrollToBottomListener;
    }

    public void setOnScrollStopDelayedListener(OnScrollStopDelayedListener onScrollStopDelayedListener, long j) {
        this.mOnScrollStopDelayedListener = onScrollStopDelayedListener;
        this.mOnScrollStopDelayedMillis = j;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setOnItemLongClickListener(PLA_AdapterView.d dVar) {
        if (dVar == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.mOnItemLongClickListener = dVar;
        super.setOnItemLongClickListener(new PLA_AdapterView.d() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.8
            @Override // com.huewu.pla.lib.internal.PLA_AdapterView.d
            public boolean onItemLongClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i, long j) {
                int headersCount = BdMultiColumnListView.this.mAdapter instanceof a ? ((a) BdMultiColumnListView.this.mAdapter).getHeadersCount() : 0;
                if (i < headersCount) {
                    return true;
                }
                int i2 = i - headersCount;
                ListAdapter listAdapter = BdMultiColumnListView.this.mAdapter;
                if (listAdapter == null || i2 >= listAdapter.getCount()) {
                    return true;
                }
                if (BdMultiColumnListView.this.mOnItemLongClickListener != null) {
                    return BdMultiColumnListView.this.mOnItemLongClickListener.onItemLongClick(pLA_AdapterView, view, i2, j);
                }
                return false;
            }
        });
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setOnItemSelectedListener(PLA_AdapterView.e eVar) {
        if (eVar == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.mOnItemSelectedListener = eVar;
        super.setOnItemSelectedListener(new PLA_AdapterView.e() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.9
            @Override // com.huewu.pla.lib.internal.PLA_AdapterView.e
            public void onItemSelected(PLA_AdapterView<?> pLA_AdapterView, View view, int i, long j) {
                int i2 = 0;
                if (BdMultiColumnListView.this.mAdapter instanceof a) {
                    i2 = ((a) BdMultiColumnListView.this.mAdapter).getHeadersCount();
                }
                if (i >= i2) {
                    int i3 = i - i2;
                    ListAdapter wrappedAdapter = BdMultiColumnListView.this.mBdListAdpter.getWrappedAdapter();
                    if (wrappedAdapter != null && i3 < wrappedAdapter.getCount() && BdMultiColumnListView.this.mOnItemSelectedListener != null) {
                        BdMultiColumnListView.this.mOnItemSelectedListener.onItemSelected(pLA_AdapterView, view, i3, j);
                    }
                }
            }

            @Override // com.huewu.pla.lib.internal.PLA_AdapterView.e
            public void onNothingSelected(PLA_AdapterView<?> pLA_AdapterView) {
                if (BdMultiColumnListView.this.mOnItemSelectedListener != null) {
                    BdMultiColumnListView.this.mOnItemSelectedListener.onNothingSelected(pLA_AdapterView);
                }
            }
        });
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void setOnScrollListener(PLA_AbsListView.c cVar) {
        this.mOnScrollListener = cVar;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setOnItemClickListener(PLA_AdapterView.c cVar) {
        this.mOnItemClickListener = cVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.huewu.pla.lib.internal.PLA_ListView, com.huewu.pla.lib.internal.PLA_AdapterView
    public ListAdapter getAdapter() {
        return this.mBdListAdpter;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.huewu.pla.lib.internal.PLA_ListView, com.huewu.pla.lib.internal.PLA_AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter(listAdapter);
        this.mBdListAdpter.setAdaper(this.mAdapter);
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        this.mOnHeaderClickListener = onHeaderClickListener;
    }

    public void setOnFooterClickListener(OnFooterClickListener onFooterClickListener) {
        this.mOnFooterClickListener = onFooterClickListener;
    }

    public void addPullRefreshView(View view) {
        addHeaderView(view, null, false, 0);
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
        if (this.mPrePage != null) {
            removeHeaderView(this.mPrePage.getView());
            this.mPrePage = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.getView());
            this.mPrePage = cVar;
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public void setSelectionFromTop(int i, int i2) {
        super.setSelectionFromTop(i, i2);
    }

    public void setNextPage(c cVar) {
        if (this.mNextPage != null) {
            removeFooterView(this.mNextPage.getView());
            this.mNextPage = null;
        }
        if (cVar != null) {
            addFooterView(cVar.getView(), null, true, 0);
            this.mNextPage = cVar;
        }
    }

    private int getHeaderIndex() {
        if (this.mPrePage == null || !(this.mAdapter instanceof a)) {
            return -1;
        }
        return ((a) this.mAdapter).getHeadersCount() - 1;
    }

    public void setPullRefresh(d dVar) {
        if (this.mPullRefresh != null) {
            removeHeaderView(this.mPullRefresh.getBdIListPullView().getView());
        }
        this.mPullRefresh = null;
        if (dVar != null) {
            this.mPullRefresh = new PullRefresh(this, dVar);
            this.mPullRefresh.setOnScrollToPullListener(this.mOnScrollToPullListener);
        }
    }

    public void setPreLoad(boolean z, int i) {
        this.mIsPreLoad = z;
        this.mPreLoadNum = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0024  */
    @Override // com.huewu.pla.lib.MultiColumnListView, com.huewu.pla.lib.internal.PLA_ListView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onItemAddedToList(int i, boolean z) {
        boolean z2;
        super.onItemAddedToList(i, z);
        if (this.mOnItemWillVisibleListener != null) {
            if (z) {
                if (getFirstVisiblePosition() != 0 && i - getHeaderViewsCount() == getLastVisiblePosition() && i > this.mLastAddPosition) {
                    z2 = true;
                    if (z2) {
                        this.mOnItemWillVisibleListener.onItemWillVisible(i - getHeaderViewsCount(), z);
                        this.mLastAddPosition = i;
                    }
                }
                z2 = false;
                if (z2) {
                }
            } else {
                if (i == getFirstVisiblePosition()) {
                    z2 = true;
                    if (z2) {
                    }
                }
                z2 = false;
                if (z2) {
                }
            }
        }
        if (this.mIsPreLoad && z) {
            boolean z3 = getCount() - i < this.mPreLoadNum;
            if (this.mOnScrollToBottomListener != null && getFirstVisiblePosition() != 0 && this.mLastLoadCount != getCount() && z3) {
                this.mOnScrollToBottomListener.onScrollToBottom();
                this.mLastLoadCount = getCount();
            }
        }
    }

    public void setOnItemWillVisileListener(OnItemWillVisibleListener onItemWillVisibleListener) {
        this.mOnItemWillVisibleListener = onItemWillVisibleListener;
    }

    public void completePullRefresh() {
        if (this.mPullRefresh != null) {
            if (this.mPullRefresh.getBdIListPullView() != null) {
                this.mPullRefresh.mBdIListPullView.onCompletePullRefresh();
            }
            this.mPullRefresh.animatePullView();
        }
    }

    public void completePullRefreshPostDelayed(long j) {
        if (this.mPullRefresh != null && this.mPullRefresh.getBdIListPullView() != null) {
            this.mPullRefresh.mBdIListPullView.onCompletePullRefresh();
        }
        e.mS().postDelayed(new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.10
            @Override // java.lang.Runnable
            public void run() {
                if (BdMultiColumnListView.this.mPullRefresh == null) {
                    return;
                }
                BdMultiColumnListView.this.mPullRefresh.animatePullView();
            }
        }, j);
    }

    public void startPullRefresh() {
        if (this.mPullRefresh != null) {
            setSelection(0);
            this.mPullRefresh.startPullRefresh(true);
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mPullRefresh != null) {
            this.mPullRefresh.onInterceptTouchEvent(motionEvent, this.mFirstVisibleItemIndex);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView, com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mPullRefresh != null) {
            this.mPullRefresh.onTouchEvent(motionEvent, this.mFirstVisibleItemIndex);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
            return false;
        }
    }

    public static boolean setPullRefreshRatio(float f) {
        return PullRefresh.setRatio(f);
    }

    public boolean isRefreshDone() {
        return this.mPullRefresh == null || this.mPullRefresh.mState == 3;
    }

    /* loaded from: classes7.dex */
    private static class PullRefresh {
        public static final int DEFAULT_REFRESH_DURATION_TIME = 800;
        private static final int DONE = 3;
        private static final int PULL_TO_REFRESH = 1;
        private static final int REFRESHING = 2;
        private static final int RELEASE_TO_REFRESH = 0;
        private static float sRatio = 3.0f;
        private d mBdIListPullView;
        private BdMultiColumnListView mListView;
        private boolean mIsRecored = false;
        private int mStartY = 0;
        protected int mState = 3;
        private Boolean mIsBack = false;
        private OnScrollToPullListener mOnScrollToPullListener = null;
        private int mAnimDurationTime = 800;

        public static boolean setRatio(float f) {
            if (f > 0.0f) {
                sRatio = f;
                return true;
            }
            return false;
        }

        public PullRefresh(BdMultiColumnListView bdMultiColumnListView, d dVar) {
            this.mBdIListPullView = null;
            this.mListView = null;
            if (dVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdMultiColumnListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.mBdIListPullView = dVar;
            this.mListView = bdMultiColumnListView;
            View view = this.mBdIListPullView.getView();
            view.setPadding(0, -this.mBdIListPullView.getHeadContentHeight(), 0, 0);
            view.invalidate();
            this.mListView.addPullRefreshView(view);
        }

        public d getBdIListPullView() {
            return this.mBdIListPullView;
        }

        public void done() {
            this.mState = 3;
            this.mBdIListPullView.setPadding(0, -this.mBdIListPullView.getHeadContentHeight(), 0, 0);
            this.mBdIListPullView.done(true);
            if (this.mOnScrollToPullListener != null) {
                this.mOnScrollToPullListener.onScrollToPull(false);
            }
        }

        public void startPullRefresh(boolean z) {
            this.mState = 2;
            this.mBdIListPullView.setPadding(0, 0, 0, 0);
            this.mBdIListPullView.refreshing();
            this.mBdIListPullView.onRefresh(z);
        }

        public void setOnScrollToPullListener(OnScrollToPullListener onScrollToPullListener) {
            this.mOnScrollToPullListener = onScrollToPullListener;
        }

        public void onInterceptTouchEvent(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && getBdIListPullView().isEnable()) {
                this.mIsRecored = false;
                this.mIsBack = false;
                if (i == 0 && !this.mIsRecored && this.mListView.getChildAt(0) != null && this.mListView.getChildAt(0).getTop() >= 0) {
                    this.mIsRecored = true;
                    this.mStartY = (int) motionEvent.getY();
                }
            }
        }

        public void onTouchEvent(MotionEvent motionEvent, int i) {
            if (getBdIListPullView().isEnable()) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.mState != 2) {
                            if (this.mState == 1) {
                                this.mState = 3;
                                this.mBdIListPullView.setPadding(0, -this.mBdIListPullView.getHeadContentHeight(), 0, 0);
                                this.mBdIListPullView.done(false);
                                if (this.mOnScrollToPullListener != null) {
                                    this.mOnScrollToPullListener.onScrollToPull(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                startPullRefresh(false);
                                if (this.mOnScrollToPullListener != null) {
                                    this.mOnScrollToPullListener.onScrollToPull(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.mOnScrollToPullListener != null) {
                                this.mOnScrollToPullListener.onScrollToPull(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.mIsRecored && i == 0 && this.mListView.getChildAt(0) != null && this.mListView.getChildAt(0).getTop() >= 0) {
                            this.mIsRecored = true;
                            this.mStartY = y;
                        }
                        if (this.mState != 2 && this.mIsRecored) {
                            if (this.mState == 0) {
                                this.mListView.setSelection(0);
                                if (((int) ((y - this.mStartY) / sRatio)) < this.mBdIListPullView.getHeadContentHeight() && y - this.mStartY > 0) {
                                    this.mState = 1;
                                    this.mBdIListPullView.pullToRefresh(this.mIsBack.booleanValue());
                                    this.mIsBack = false;
                                    if (this.mOnScrollToPullListener != null) {
                                        this.mOnScrollToPullListener.onScrollToPull(true);
                                    }
                                } else if (y - this.mStartY <= 0) {
                                    this.mState = 3;
                                    this.mBdIListPullView.setPadding(0, -this.mBdIListPullView.getHeadContentHeight(), 0, 0);
                                    this.mBdIListPullView.done(false);
                                    if (this.mOnScrollToPullListener != null) {
                                        this.mOnScrollToPullListener.onScrollToPull(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.mListView.setSelection(0);
                                if (((int) ((y - this.mStartY) / sRatio)) >= this.mBdIListPullView.getHeadContentHeight()) {
                                    this.mState = 0;
                                    this.mIsBack = true;
                                    this.mBdIListPullView.releaseToRefresh();
                                    if (this.mOnScrollToPullListener != null) {
                                        this.mOnScrollToPullListener.onScrollToPull(true);
                                    }
                                } else if (y - this.mStartY <= 0) {
                                    this.mState = 3;
                                    this.mBdIListPullView.setPadding(0, -this.mBdIListPullView.getHeadContentHeight(), 0, 0);
                                    this.mBdIListPullView.done(false);
                                    if (this.mOnScrollToPullListener != null) {
                                        this.mOnScrollToPullListener.onScrollToPull(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.mStartY > 0) {
                                    this.mState = 1;
                                    this.mBdIListPullView.pullToRefresh(this.mIsBack.booleanValue());
                                    this.mIsBack = false;
                                    if (this.mOnScrollToPullListener != null) {
                                        this.mOnScrollToPullListener.onScrollToPull(true);
                                    }
                                } else if (this.mOnScrollToPullListener != null) {
                                    this.mOnScrollToPullListener.onScrollToPull(false);
                                }
                            }
                            if (this.mState == 1 || this.mState == 0) {
                                this.mBdIListPullView.setPadding(0, ((int) ((y - this.mStartY) / sRatio)) - this.mBdIListPullView.getHeadContentHeight(), 0, 0);
                                return;
                            }
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void animatePullView() {
            View view;
            d bdIListPullView = getBdIListPullView();
            if (bdIListPullView != null && (view = bdIListPullView.getView()) != null) {
                g gVar = new g(view.getContext(), 0, -bdIListPullView.getHeadContentHeight(), this.mAnimDurationTime);
                gVar.a(new com.baidu.adp.widget.b.a() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.PullRefresh.1
                    @Override // com.baidu.adp.widget.b.a
                    public void onOver() {
                        PullRefresh.this.done();
                    }
                });
                gVar.startAnimation(view);
            }
        }
    }
}
