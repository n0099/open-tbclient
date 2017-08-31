package com.baidu.adp.widget.ListView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.d;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdListView extends ListView implements com.baidu.adp.widget.ListView.g {
    public static final byte KEYBOARD_STATE_HIDE = -2;
    public static final byte KEYBOARD_STATE_INIT = -1;
    public static final byte KEYBOARD_STATE_SHOW = -3;
    public static final int OVER_SCROLL_NEVER = 2;
    private static final int REFRESH_DELAY = 100;
    private com.baidu.adp.widget.ListView.d mBdListAdpter;
    private Runnable mDelayedRunnable;
    private f mExScrollToBottomListener;
    private int mFirstVisibleItemIndex;
    private boolean mHasKeybord;
    private boolean mKeybordScrollBottom;
    private boolean mLayoutHasInit;
    private int mMaxHeight;
    private com.baidu.adp.widget.ListView.b mNextPage;
    private View mNoDataView;
    private a mOnFooterClickListener;
    private b mOnHeaderClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private AdapterView.OnItemLongClickListener mOnItemLongClickListener;
    private AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private c mOnKybdsChangeListener;
    private AbsListView.OnScrollListener mOnScrollListener;
    private d mOnScrollStopDelayedListener;
    private long mOnScrollStopDelayedMillis;
    private e mOnScrollToBottomListener;
    private g mOnScrollToPullListener;
    private h mOnScrollToTopListener;
    private int mPreHeight;
    private com.baidu.adp.widget.ListView.b mPrePage;
    private i mPullRefresh;
    private int mScrollToTopNum;
    private com.baidu.adp.base.h mScrollable;
    private Runnable mSelectRunnable;
    private int maxHeight;
    private Runnable preLoadRunnable;
    private Runnable refreshRunnable;

    /* loaded from: classes.dex */
    public interface a {
        void onClick(View view);
    }

    /* loaded from: classes.dex */
    public interface b {
        void onClick(View view);
    }

    /* loaded from: classes.dex */
    public interface c {
        void aJ(int i);
    }

    /* loaded from: classes.dex */
    public interface d {
        void onScrollStop(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void onScrollToBottom();
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(BdListView bdListView);
    }

    /* loaded from: classes.dex */
    public interface g {
        void onScrollToPull(boolean z);
    }

    /* loaded from: classes.dex */
    public interface h {
        void onScrollToTop();
    }

    public void setScrollable(com.baidu.adp.base.h hVar) {
        this.mScrollable = hVar;
    }

    public BdListView(Context context) {
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
        this.mExScrollToBottomListener = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.mScrollable = null;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.1
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 0;
                int i3 = -1;
                if (BdListView.this.mOnScrollStopDelayedListener != null) {
                    int firstVisiblePosition = BdListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdListView.this.getLastVisiblePosition();
                    if (BdListView.this.mBdListAdpter == null || BdListView.this.mBdListAdpter.getWrappedAdapter() == null || BdListView.this.mBdListAdpter.getWrappedCount() <= 0) {
                        i2 = -1;
                    } else {
                        i3 = firstVisiblePosition - BdListView.this.mBdListAdpter.getHeadersCount();
                        if (i3 < 0) {
                            i3 = 0;
                        }
                        int headersCount = lastVisiblePosition - BdListView.this.mBdListAdpter.getHeadersCount();
                        if (headersCount >= BdListView.this.mBdListAdpter.getWrappedCount()) {
                            headersCount = BdListView.this.mBdListAdpter.getWrappedCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i2 = headersCount;
                        }
                    }
                    BdListView.this.mOnScrollStopDelayedListener.onScrollStop(i3, i2);
                }
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h V;
                int childCount = BdListView.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    refreshImage(BdListView.this.getChildAt(i2));
                }
                if (BdListView.this.mScrollable != null) {
                    V = BdListView.this.mScrollable;
                } else {
                    V = com.baidu.adp.base.i.V(BdListView.this.getContext());
                }
                if (V != null) {
                    V.onPreLoad(BdListView.this);
                }
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
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h V;
                if (BdListView.this.mScrollable != null) {
                    V = BdListView.this.mScrollable;
                } else {
                    V = com.baidu.adp.base.i.V(BdListView.this.getContext());
                }
                if (V != null) {
                    V.onPreLoad(BdListView.this);
                }
            }
        };
        this.mLayoutHasInit = false;
        this.mHasKeybord = false;
        this.mKeybordScrollBottom = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.mOnKybdsChangeListener = null;
        this.mSelectRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.10
            @Override // java.lang.Runnable
            public void run() {
                BdListView.this.setSelection(BdListView.this.getCount() - 1);
            }
        };
        this.mPullRefresh = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
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
        this.mExScrollToBottomListener = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.mScrollable = null;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.1
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 0;
                int i3 = -1;
                if (BdListView.this.mOnScrollStopDelayedListener != null) {
                    int firstVisiblePosition = BdListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdListView.this.getLastVisiblePosition();
                    if (BdListView.this.mBdListAdpter == null || BdListView.this.mBdListAdpter.getWrappedAdapter() == null || BdListView.this.mBdListAdpter.getWrappedCount() <= 0) {
                        i2 = -1;
                    } else {
                        i3 = firstVisiblePosition - BdListView.this.mBdListAdpter.getHeadersCount();
                        if (i3 < 0) {
                            i3 = 0;
                        }
                        int headersCount = lastVisiblePosition - BdListView.this.mBdListAdpter.getHeadersCount();
                        if (headersCount >= BdListView.this.mBdListAdpter.getWrappedCount()) {
                            headersCount = BdListView.this.mBdListAdpter.getWrappedCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i2 = headersCount;
                        }
                    }
                    BdListView.this.mOnScrollStopDelayedListener.onScrollStop(i3, i2);
                }
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h V;
                int childCount = BdListView.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    refreshImage(BdListView.this.getChildAt(i2));
                }
                if (BdListView.this.mScrollable != null) {
                    V = BdListView.this.mScrollable;
                } else {
                    V = com.baidu.adp.base.i.V(BdListView.this.getContext());
                }
                if (V != null) {
                    V.onPreLoad(BdListView.this);
                }
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
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h V;
                if (BdListView.this.mScrollable != null) {
                    V = BdListView.this.mScrollable;
                } else {
                    V = com.baidu.adp.base.i.V(BdListView.this.getContext());
                }
                if (V != null) {
                    V.onPreLoad(BdListView.this);
                }
            }
        };
        this.mLayoutHasInit = false;
        this.mHasKeybord = false;
        this.mKeybordScrollBottom = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.mOnKybdsChangeListener = null;
        this.mSelectRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.10
            @Override // java.lang.Runnable
            public void run() {
                BdListView.this.setSelection(BdListView.this.getCount() - 1);
            }
        };
        this.mPullRefresh = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
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
        this.mExScrollToBottomListener = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.mScrollable = null;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.1
            @Override // java.lang.Runnable
            public void run() {
                int i22 = 0;
                int i3 = -1;
                if (BdListView.this.mOnScrollStopDelayedListener != null) {
                    int firstVisiblePosition = BdListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdListView.this.getLastVisiblePosition();
                    if (BdListView.this.mBdListAdpter == null || BdListView.this.mBdListAdpter.getWrappedAdapter() == null || BdListView.this.mBdListAdpter.getWrappedCount() <= 0) {
                        i22 = -1;
                    } else {
                        i3 = firstVisiblePosition - BdListView.this.mBdListAdpter.getHeadersCount();
                        if (i3 < 0) {
                            i3 = 0;
                        }
                        int headersCount = lastVisiblePosition - BdListView.this.mBdListAdpter.getHeadersCount();
                        if (headersCount >= BdListView.this.mBdListAdpter.getWrappedCount()) {
                            headersCount = BdListView.this.mBdListAdpter.getWrappedCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i22 = headersCount;
                        }
                    }
                    BdListView.this.mOnScrollStopDelayedListener.onScrollStop(i3, i22);
                }
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h V;
                int childCount = BdListView.this.getChildCount();
                for (int i22 = 0; i22 < childCount; i22++) {
                    refreshImage(BdListView.this.getChildAt(i22));
                }
                if (BdListView.this.mScrollable != null) {
                    V = BdListView.this.mScrollable;
                } else {
                    V = com.baidu.adp.base.i.V(BdListView.this.getContext());
                }
                if (V != null) {
                    V.onPreLoad(BdListView.this);
                }
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.b.a.i) {
                        ((com.baidu.adp.b.a.i) view).refresh();
                    }
                    if (view instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) view;
                        int childCount = viewGroup.getChildCount();
                        for (int i22 = 0; i22 < childCount; i22++) {
                            refreshImage(viewGroup.getChildAt(i22));
                        }
                    }
                }
            }
        };
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h V;
                if (BdListView.this.mScrollable != null) {
                    V = BdListView.this.mScrollable;
                } else {
                    V = com.baidu.adp.base.i.V(BdListView.this.getContext());
                }
                if (V != null) {
                    V.onPreLoad(BdListView.this);
                }
            }
        };
        this.mLayoutHasInit = false;
        this.mHasKeybord = false;
        this.mKeybordScrollBottom = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.mOnKybdsChangeListener = null;
        this.mSelectRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.10
            @Override // java.lang.Runnable
            public void run() {
                BdListView.this.setSelection(BdListView.this.getCount() - 1);
            }
        };
        this.mPullRefresh = null;
        initial();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        try {
            super.dispatchDraw(canvas);
        } catch (NullPointerException e2) {
            BdLog.detailException(e2);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        } catch (OutOfMemoryError e3) {
            BdBaseApplication.getInst().onAppMemoryLow();
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        try {
            super.layoutChildren();
        } catch (NullPointerException e2) {
            BdLog.detailException(e2);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void cancelRefresh() {
        removeCallbacks(this.refreshRunnable);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.mBdListAdpter = new com.baidu.adp.widget.ListView.d(getContext());
        this.mBdListAdpter.setListPreLoad(new d.a() { // from class: com.baidu.adp.widget.ListView.BdListView.5
            @Override // com.baidu.adp.widget.ListView.d.a
            public void onPreLoad() {
                BdListView.this.removeCallbacks(BdListView.this.preLoadRunnable);
                BdListView.this.postDelayed(BdListView.this.preLoadRunnable, 100L);
            }
        });
        super.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.adp.widget.ListView.BdListView.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                int headersCount = BdListView.this.mBdListAdpter.getHeadersCount();
                if (i2 < headersCount) {
                    if (BdListView.this.mPrePage == null || view != BdListView.this.mPrePage.getView()) {
                        if (BdListView.this.mOnHeaderClickListener != null) {
                            BdListView.this.mOnHeaderClickListener.onClick(view);
                            return;
                        }
                        return;
                    }
                    BdListView.this.mPrePage.onClick();
                    return;
                }
                int i3 = i2 - headersCount;
                ListAdapter wrappedAdapter = BdListView.this.mBdListAdpter.getWrappedAdapter();
                if (wrappedAdapter == null || i3 >= wrappedAdapter.getCount()) {
                    if (BdListView.this.mNextPage == null || view != BdListView.this.mNextPage.getView()) {
                        if (BdListView.this.mOnFooterClickListener != null) {
                            BdListView.this.mOnFooterClickListener.onClick(view);
                            return;
                        }
                        return;
                    }
                    BdListView.this.mNextPage.onClick();
                } else if (BdListView.this.mOnItemClickListener != null) {
                    BdListView.this.mOnItemClickListener.onItemClick(adapterView, view, i3, j);
                }
            }
        });
        super.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.adp.widget.ListView.BdListView.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                com.baidu.adp.base.h V;
                if (BdListView.this.mScrollable != null) {
                    V = BdListView.this.mScrollable;
                } else {
                    V = com.baidu.adp.base.i.V(BdListView.this.getContext());
                }
                if (V != null) {
                    if (i2 == 2) {
                        BdListView.this.removeCallbacks(BdListView.this.refreshRunnable);
                        V.setIsScroll(true);
                    } else if (V.isScroll()) {
                        V.setIsScroll(false);
                        BdListView.this.removeCallbacks(BdListView.this.refreshRunnable);
                        BdListView.this.postDelayed(BdListView.this.refreshRunnable, 100L);
                    } else if (i2 == 0) {
                        BdListView.this.removeCallbacks(BdListView.this.preLoadRunnable);
                        BdListView.this.postDelayed(BdListView.this.preLoadRunnable, 100L);
                    }
                }
                if (BdListView.this.mOnScrollListener != null) {
                    BdListView.this.mOnScrollListener.onScrollStateChanged(absListView, i2);
                }
                if (i2 == 0) {
                    if (BdListView.this.mOnScrollToBottomListener != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                        BdListView.this.mOnScrollToBottomListener.onScrollToBottom();
                    }
                    if (BdListView.this.mExScrollToBottomListener != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                        BdListView.this.mExScrollToBottomListener.a(BdListView.this);
                    }
                    if (BdListView.this.mOnScrollToTopListener != null && absListView.getFirstVisiblePosition() <= BdListView.this.mScrollToTopNum) {
                        BdListView.this.mOnScrollToTopListener.onScrollToTop();
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                BdListView.this.mFirstVisibleItemIndex = i2;
                if (BdListView.this.mOnScrollListener != null) {
                    BdListView.this.mOnScrollListener.onScroll(absListView, i2, i3, i4);
                }
                if (BdListView.this.mOnScrollStopDelayedListener != null && BdListView.this.mOnScrollStopDelayedMillis > 0) {
                    BdListView.this.getHandler().removeCallbacks(BdListView.this.mDelayedRunnable);
                    BdListView.this.getHandler().postDelayed(BdListView.this.mDelayedRunnable, BdListView.this.mOnScrollStopDelayedMillis);
                }
            }
        });
    }

    public void setOnScrollToPullListener(g gVar) {
        this.mOnScrollToPullListener = gVar;
    }

    public void setMaxHeight(int i2) {
        this.maxHeight = i2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.maxHeight <= 0) {
            super.onMeasure(i2, i3);
            return;
        }
        int size = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i3);
        if (size > this.maxHeight) {
            i3 = View.MeasureSpec.makeMeasureSpec(this.maxHeight, mode);
        }
        super.onMeasure(i2, i3);
    }

    public void setOnSrollToTopListener(h hVar) {
        this.mOnScrollToTopListener = hVar;
    }

    public void setOnSrollToTopListener(h hVar, int i2) {
        this.mOnScrollToTopListener = hVar;
        int i3 = i2 - 1;
        if (i3 < 0) {
            i3 = 0;
        }
        this.mScrollToTopNum = i3;
    }

    public void setOnSrollToBottomListener(e eVar) {
        this.mOnScrollToBottomListener = eVar;
    }

    public void setExOnSrollToBottomListener(f fVar) {
        this.mExScrollToBottomListener = fVar;
    }

    public void setOnScrollStopDelayedListener(d dVar, long j) {
        this.mOnScrollStopDelayedListener = dVar;
        this.mOnScrollStopDelayedMillis = j;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.mOnItemLongClickListener = onItemLongClickListener;
        super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.adp.widget.ListView.BdListView.8
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                int headersCount = BdListView.this.mBdListAdpter.getHeadersCount();
                if (i2 < headersCount) {
                    return true;
                }
                int i3 = i2 - headersCount;
                ListAdapter wrappedAdapter = BdListView.this.mBdListAdpter.getWrappedAdapter();
                if (wrappedAdapter == null || i3 >= wrappedAdapter.getCount()) {
                    return true;
                }
                if (BdListView.this.mOnItemLongClickListener != null) {
                    return BdListView.this.mOnItemLongClickListener.onItemLongClick(adapterView, view, i3, j);
                }
                return false;
            }
        });
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.mOnItemSelectedListener = onItemSelectedListener;
        super.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.baidu.adp.widget.ListView.BdListView.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                int headersCount = BdListView.this.mBdListAdpter.getHeadersCount();
                if (i2 >= headersCount) {
                    int i3 = i2 - headersCount;
                    ListAdapter wrappedAdapter = BdListView.this.mBdListAdpter.getWrappedAdapter();
                    if (wrappedAdapter != null && i3 < wrappedAdapter.getCount() && BdListView.this.mOnItemSelectedListener != null) {
                        BdListView.this.mOnItemSelectedListener.onItemSelected(adapterView, view, i3, j);
                    }
                }
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
                if (BdListView.this.mOnItemSelectedListener != null) {
                    BdListView.this.mOnItemSelectedListener.onNothingSelected(adapterView);
                }
            }
        });
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.ListView, android.widget.AdapterView, com.baidu.adp.widget.ListView.g
    public ListAdapter getAdapter() {
        return this.mBdListAdpter;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.mBdListAdpter instanceof com.baidu.adp.widget.ListView.d) {
            return this.mBdListAdpter.getWrappedAdapter();
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.mBdListAdpter.setAdaper(listAdapter);
        super.setAdapter((ListAdapter) this.mBdListAdpter);
    }

    public void setOnHeaderClickListener(b bVar) {
        this.mOnHeaderClickListener = bVar;
    }

    public void setOnFooterClickListener(a aVar) {
        this.mOnFooterClickListener = aVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.mBdListAdpter.addHeaderView(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.mBdListAdpter.addHeaderView(view, getHeaderIndex());
    }

    public void addHeaderView(View view, int i2) {
        this.mBdListAdpter.addHeaderView(view, i2);
    }

    @Override // android.widget.ListView
    public int getHeaderViewsCount() {
        return this.mBdListAdpter.getHeaderViewsCount();
    }

    @Override // android.widget.ListView
    public int getFooterViewsCount() {
        return this.mBdListAdpter.getFooterViewsCount();
    }

    public void addPullRefreshView(View view) {
        this.mBdListAdpter.addHeaderView(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.mBdListAdpter.addFooterView(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.mBdListAdpter.addFooterView(view);
    }

    @Override // android.widget.ListView
    public boolean removeHeaderView(View view) {
        return this.mBdListAdpter.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.mBdListAdpter.removeFooter(view);
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
        if (this.mPrePage != null) {
            removeHeaderView(this.mPrePage.getView());
            this.mPrePage = null;
        }
        if (bVar != null) {
            addHeaderView(bVar.getView());
            this.mPrePage = bVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void setNextPage(com.baidu.adp.widget.ListView.b bVar) {
        if (this.mNextPage != null) {
            removeFooterView(this.mNextPage.getView());
            this.mNextPage = null;
        }
        if (bVar != null) {
            this.mBdListAdpter.addFooterView(bVar.getView(), null, true, 0);
            this.mNextPage = bVar;
        }
    }

    private int getHeaderIndex() {
        if (this.mPrePage != null) {
            return this.mBdListAdpter.getHeadersCount() - 1;
        }
        return -1;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        try {
            super.onDetachedFromWindow();
            getHandler().removeCallbacks(this.mDelayedRunnable);
            getHandler().removeCallbacks(this.mSelectRunnable);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.mKeybordScrollBottom = z;
    }

    public void setOnkbdStateListener(c cVar) {
        this.mOnKybdsChangeListener = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i2, i3, i4, i5);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i5;
                if (this.mOnKybdsChangeListener != null) {
                    this.mOnKybdsChangeListener.aJ(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.mHasKeybord = true;
                if (this.mOnKybdsChangeListener != null) {
                    this.mOnKybdsChangeListener.aJ(-3);
                }
                if (this.mKeybordScrollBottom && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.mSelectRunnable, 1L);
                }
            }
            if (this.mLayoutHasInit && this.mHasKeybord && this.mMaxHeight == i5) {
                this.mHasKeybord = false;
                if (this.mOnKybdsChangeListener != null) {
                    this.mOnKybdsChangeListener.aJ(-2);
                }
            }
            this.mPreHeight = i5;
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    public void setPullRefresh(com.baidu.adp.widget.ListView.c cVar) {
        if (this.mPullRefresh != null) {
            removeHeaderView(this.mPullRefresh.getBdIListPullView().getView());
        }
        this.mPullRefresh = null;
        if (cVar != null) {
            this.mPullRefresh = new i(this, cVar);
            this.mPullRefresh.setOnScrollToPullListener(this.mOnScrollToPullListener);
        }
    }

    public void completePullRefresh() {
        if (this.mPullRefresh != null) {
            if (this.mPullRefresh.getBdIListPullView() != null) {
                this.mPullRefresh.mBdIListPullView.le();
            }
            this.mPullRefresh.animatePullView();
        }
    }

    public void completePullRefreshPostDelayed(long j) {
        if (this.mPullRefresh != null && this.mPullRefresh.getBdIListPullView() != null) {
            this.mPullRefresh.mBdIListPullView.le();
        }
        com.baidu.adp.lib.g.e.fQ().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.2
            @Override // java.lang.Runnable
            public void run() {
                if (BdListView.this.mPullRefresh == null) {
                    return;
                }
                BdListView.this.mPullRefresh.animatePullView();
            }
        }, j);
    }

    public void startPullRefresh() {
        if (this.mPullRefresh != null) {
            setSelection(0);
            this.mPullRefresh.startPullRefresh(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mPullRefresh != null) {
            this.mPullRefresh.onInterceptTouchEvent(motionEvent, this.mFirstVisibleItemIndex);
        }
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mPullRefresh != null) {
            this.mPullRefresh.onTouchEvent(motionEvent, this.mFirstVisibleItemIndex);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public static boolean setPullRefreshRatio(float f2) {
        return i.setRatio(f2);
    }

    public boolean isRefreshDone() {
        return this.mPullRefresh == null || this.mPullRefresh.mState == 3;
    }

    /* loaded from: classes.dex */
    private static class i {
        private static float sRatio = 3.0f;
        private BdListView Hw;
        private com.baidu.adp.widget.ListView.c mBdIListPullView;
        private boolean mIsRecored = false;
        private int mStartY = 0;
        protected int mState = 3;
        private Boolean mIsBack = false;
        private g mOnScrollToPullListener = null;
        private int mAnimDurationTime = 800;

        public static boolean setRatio(float f) {
            if (f > 0.0f) {
                sRatio = f;
                return true;
            }
            return false;
        }

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.c cVar) {
            this.mBdIListPullView = null;
            this.Hw = null;
            if (cVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.mBdIListPullView = cVar;
            this.Hw = bdListView;
            View view = this.mBdIListPullView.getView();
            view.setPadding(0, -this.mBdIListPullView.lg(), 0, 0);
            view.invalidate();
            this.Hw.addPullRefreshView(view);
        }

        public com.baidu.adp.widget.ListView.c getBdIListPullView() {
            return this.mBdIListPullView;
        }

        public void done() {
            this.mState = 3;
            this.mBdIListPullView.setPadding(0, -this.mBdIListPullView.lg(), 0, 0);
            this.mBdIListPullView.U(true);
            if (this.mOnScrollToPullListener != null) {
                this.mOnScrollToPullListener.onScrollToPull(false);
            }
        }

        public void startPullRefresh(boolean z) {
            this.mState = 2;
            this.mBdIListPullView.setPadding(0, 0, 0, 0);
            this.mBdIListPullView.ld();
            this.mBdIListPullView.V(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.mOnScrollToPullListener = gVar;
        }

        public void onInterceptTouchEvent(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && getBdIListPullView().lf()) {
                this.mIsRecored = false;
                this.mIsBack = false;
                if (i == 0 && !this.mIsRecored && this.Hw.getChildAt(0) != null && this.Hw.getChildAt(0).getTop() >= 0) {
                    this.mIsRecored = true;
                    this.mStartY = (int) motionEvent.getY();
                }
            }
        }

        public void onTouchEvent(MotionEvent motionEvent, int i) {
            if (getBdIListPullView().lf()) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.mState != 2) {
                            if (this.mState == 1) {
                                this.mState = 3;
                                this.mBdIListPullView.setPadding(0, -this.mBdIListPullView.lg(), 0, 0);
                                this.mBdIListPullView.U(false);
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
                        if (!this.mIsRecored && i == 0 && this.Hw.getChildAt(0) != null && this.Hw.getChildAt(0).getTop() >= 0) {
                            this.mIsRecored = true;
                            this.mStartY = y;
                        }
                        if (this.mState != 2 && this.mIsRecored) {
                            if (this.mState == 0) {
                                this.Hw.setSelection(0);
                                if (((int) ((y - this.mStartY) / sRatio)) < k.g(this.mBdIListPullView.getContext(), R.dimen.adp_list_view_pull_maxoffset) && y - this.mStartY > 0) {
                                    this.mState = 1;
                                    this.mBdIListPullView.T(this.mIsBack.booleanValue());
                                    this.mIsBack = false;
                                    if (this.mOnScrollToPullListener != null) {
                                        this.mOnScrollToPullListener.onScrollToPull(true);
                                    }
                                } else if (y - this.mStartY <= 0) {
                                    this.mState = 3;
                                    this.mBdIListPullView.setPadding(0, -this.mBdIListPullView.lg(), 0, 0);
                                    this.mBdIListPullView.U(false);
                                    if (this.mOnScrollToPullListener != null) {
                                        this.mOnScrollToPullListener.onScrollToPull(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.Hw.setSelection(0);
                                if (((int) ((y - this.mStartY) / sRatio)) >= k.g(this.mBdIListPullView.getContext(), R.dimen.adp_list_view_pull_maxoffset)) {
                                    this.mState = 0;
                                    this.mIsBack = true;
                                    this.mBdIListPullView.lc();
                                    if (this.mOnScrollToPullListener != null) {
                                        this.mOnScrollToPullListener.onScrollToPull(true);
                                    }
                                } else if (y - this.mStartY <= 0) {
                                    this.mState = 3;
                                    this.mBdIListPullView.setPadding(0, -this.mBdIListPullView.lg(), 0, 0);
                                    this.mBdIListPullView.U(false);
                                    if (this.mOnScrollToPullListener != null) {
                                        this.mOnScrollToPullListener.onScrollToPull(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.mStartY > 0) {
                                    this.mState = 1;
                                    this.mBdIListPullView.T(this.mIsBack.booleanValue());
                                    this.mIsBack = false;
                                    if (this.mOnScrollToPullListener != null) {
                                        this.mOnScrollToPullListener.onScrollToPull(true);
                                    }
                                } else if (this.mOnScrollToPullListener != null) {
                                    this.mOnScrollToPullListener.onScrollToPull(false);
                                }
                            }
                            if (this.mState == 1 || this.mState == 0) {
                                this.mBdIListPullView.setPadding(0, ((int) ((y - this.mStartY) / sRatio)) - this.mBdIListPullView.lg(), 0, 0);
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
            com.baidu.adp.widget.ListView.c bdIListPullView = getBdIListPullView();
            if (bdIListPullView != null && (view = bdIListPullView.getView()) != null) {
                com.baidu.adp.widget.ListView.e eVar = new com.baidu.adp.widget.ListView.e(view.getContext(), 0, -bdIListPullView.lg(), this.mAnimDurationTime);
                eVar.a(new com.baidu.adp.widget.b.a() { // from class: com.baidu.adp.widget.ListView.BdListView.i.1
                    @Override // com.baidu.adp.widget.b.a
                    public void onOver() {
                        i.this.done();
                    }
                });
                eVar.r(view);
            }
        }
    }
}
