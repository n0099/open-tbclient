package com.baidu.adp.widget.ListView;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdListView extends ListView {
    public static final byte KEYBOARD_STATE_HIDE = -2;
    public static final byte KEYBOARD_STATE_INIT = -1;
    public static final byte KEYBOARD_STATE_SHOW = -3;
    public static final int OVER_SCROLL_NEVER = 2;
    private static final int REFRESH_DELAY = 100;
    private com.baidu.adp.widget.ListView.e mBdListAdpter;
    private Runnable mDelayedRunnable;
    private f mExScrollToBottomListener;
    private int mFirstVisibleItemIndex;
    private boolean mHasKeybord;
    private boolean mKeybordScrollBottom;
    private boolean mLayoutHasInit;
    private int mMaxHeight;
    private com.baidu.adp.widget.ListView.c mNextPage;
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
    private com.baidu.adp.widget.ListView.c mPrePage;
    private i mPullRefresh;
    private int mScrollToTopNum;
    private Runnable mSelectRunnable;
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
        void aK(int i);
    }

    /* loaded from: classes.dex */
    public interface d {
        void k(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface e {
        void kp();
    }

    /* loaded from: classes.dex */
    public interface f {
        void a(BdListView bdListView);
    }

    /* loaded from: classes.dex */
    public interface g {
        void V(boolean z);
    }

    /* loaded from: classes.dex */
    public interface h {
        void kq();
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
        this.mDelayedRunnable = new com.baidu.adp.widget.ListView.g(this);
        this.refreshRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.mHasKeybord = false;
        this.mKeybordScrollBottom = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.mOnKybdsChangeListener = null;
        this.mSelectRunnable = new k(this);
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
        this.mDelayedRunnable = new com.baidu.adp.widget.ListView.g(this);
        this.refreshRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.mHasKeybord = false;
        this.mKeybordScrollBottom = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.mOnKybdsChangeListener = null;
        this.mSelectRunnable = new k(this);
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
        this.mDelayedRunnable = new com.baidu.adp.widget.ListView.g(this);
        this.refreshRunnable = new com.baidu.adp.widget.ListView.i(this);
        this.preLoadRunnable = new j(this);
        this.mLayoutHasInit = false;
        this.mHasKeybord = false;
        this.mKeybordScrollBottom = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.mOnKybdsChangeListener = null;
        this.mSelectRunnable = new k(this);
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

    public void cancelRefresh() {
        removeCallbacks(this.refreshRunnable);
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.mBdListAdpter = new com.baidu.adp.widget.ListView.e(getContext());
        this.mBdListAdpter.a(new l(this));
        super.setOnItemClickListener(new m(this));
        super.setOnScrollListener(new n(this));
    }

    public void setOnScrollToPullListener(g gVar) {
        this.mOnScrollToPullListener = gVar;
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
        super.setOnItemLongClickListener(new o(this));
    }

    @Override // android.widget.AdapterView
    public void setOnItemSelectedListener(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        if (onItemSelectedListener == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.mOnItemSelectedListener = onItemSelectedListener;
        super.setOnItemSelectedListener(new p(this));
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.mOnScrollListener = onScrollListener;
    }

    @Override // android.widget.AdapterView
    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override // android.widget.ListView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return this.mBdListAdpter;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.mBdListAdpter instanceof com.baidu.adp.widget.ListView.e) {
            return this.mBdListAdpter.getWrappedAdapter();
        }
        return null;
    }

    @Override // android.widget.ListView, android.widget.AbsListView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.mBdListAdpter.a(listAdapter);
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
        this.mBdListAdpter.a(view, obj, z, getHeaderIndex());
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
        this.mBdListAdpter.a(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.mBdListAdpter.b(view, obj, z, -1);
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

    public void setPrePage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.mPrePage != null) {
            removeHeaderView(this.mPrePage.getView());
            this.mPrePage = null;
        }
        if (cVar != null) {
            addHeaderView(cVar.getView());
            this.mPrePage = cVar;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void setNextPage(com.baidu.adp.widget.ListView.c cVar) {
        if (this.mNextPage != null) {
            removeFooterView(this.mNextPage.getView());
            this.mNextPage = null;
        }
        if (cVar != null) {
            this.mBdListAdpter.b(cVar.getView(), null, true, 0);
            this.mNextPage = cVar;
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
                    this.mOnKybdsChangeListener.aK(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.mHasKeybord = true;
                if (this.mOnKybdsChangeListener != null) {
                    this.mOnKybdsChangeListener.aK(-3);
                }
                if (this.mKeybordScrollBottom && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.mSelectRunnable, 1L);
                }
            }
            if (this.mLayoutHasInit && this.mHasKeybord && this.mMaxHeight == i5) {
                this.mHasKeybord = false;
                if (this.mOnKybdsChangeListener != null) {
                    this.mOnKybdsChangeListener.aK(-2);
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

    public void setPullRefresh(com.baidu.adp.widget.ListView.d dVar) {
        if (this.mPullRefresh != null) {
            removeHeaderView(this.mPullRefresh.kr().getView());
        }
        this.mPullRefresh = null;
        if (dVar != null) {
            this.mPullRefresh = new i(this, dVar);
            this.mPullRefresh.setOnScrollToPullListener(this.mOnScrollToPullListener);
        }
    }

    public void completePullRefresh() {
        if (this.mPullRefresh != null) {
            if (this.mPullRefresh.kr() != null) {
                this.mPullRefresh.Bt.kj();
            }
            this.mPullRefresh.ks();
        }
    }

    public void completePullRefreshPostDelayed(long j) {
        if (this.mPullRefresh != null && this.mPullRefresh.kr() != null) {
            this.mPullRefresh.Bt.kj();
        }
        com.baidu.adp.lib.g.h.eE().postDelayed(new com.baidu.adp.widget.ListView.h(this), j);
    }

    public void startPullRefresh() {
        if (this.mPullRefresh != null) {
            setSelection(0);
            this.mPullRefresh.W(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.mPullRefresh != null) {
            this.mPullRefresh.a(motionEvent, this.mFirstVisibleItemIndex);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mPullRefresh != null) {
            this.mPullRefresh.b(motionEvent, this.mFirstVisibleItemIndex);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public static boolean setPullRefreshRatio(float f2) {
        return i.I(f2);
    }

    public boolean isRefreshDone() {
        return this.mPullRefresh == null || this.mPullRefresh.mState == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class i {
        private static float Bs = 3.0f;
        private com.baidu.adp.widget.ListView.d Bt;
        private BdListView Bw;
        private boolean Bu = false;
        private int Bv = 0;
        protected int mState = 3;
        private Boolean Bx = false;
        private g mOnScrollToPullListener = null;
        private int By = 800;

        public static boolean I(float f) {
            if (f > 0.0f) {
                Bs = f;
                return true;
            }
            return false;
        }

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.d dVar) {
            this.Bt = null;
            this.Bw = null;
            if (dVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.Bt = dVar;
            this.Bw = bdListView;
            View view = this.Bt.getView();
            view.setPadding(0, -this.Bt.kl(), 0, 0);
            view.invalidate();
            this.Bw.addPullRefreshView(view);
        }

        public com.baidu.adp.widget.ListView.d kr() {
            return this.Bt;
        }

        public void done() {
            this.mState = 3;
            this.Bt.setPadding(0, -this.Bt.kl(), 0, 0);
            this.Bt.S(true);
            if (this.mOnScrollToPullListener != null) {
                this.mOnScrollToPullListener.V(false);
            }
        }

        public void W(boolean z) {
            this.mState = 2;
            this.Bt.setPadding(0, 0, 0, 0);
            this.Bt.ki();
            this.Bt.T(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.mOnScrollToPullListener = gVar;
        }

        public void a(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && kr().kk()) {
                this.Bu = false;
                this.Bx = false;
                if (i == 0 && !this.Bu && this.Bw.getChildAt(0) != null && this.Bw.getChildAt(0).getTop() >= 0) {
                    this.Bu = true;
                    this.Bv = (int) motionEvent.getY();
                }
            }
        }

        public void b(MotionEvent motionEvent, int i) {
            if (kr().kk()) {
                switch (motionEvent.getAction()) {
                    case 1:
                    case 3:
                        if (this.mState != 2) {
                            if (this.mState == 1) {
                                this.mState = 3;
                                this.Bt.setPadding(0, -this.Bt.kl(), 0, 0);
                                this.Bt.S(false);
                                if (this.mOnScrollToPullListener != null) {
                                    this.mOnScrollToPullListener.V(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                W(false);
                                if (this.mOnScrollToPullListener != null) {
                                    this.mOnScrollToPullListener.V(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.mOnScrollToPullListener != null) {
                                this.mOnScrollToPullListener.V(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.Bu && i == 0 && this.Bw.getChildAt(0) != null && this.Bw.getChildAt(0).getTop() >= 0) {
                            this.Bu = true;
                            this.Bv = y;
                        }
                        if (this.mState != 2 && this.Bu) {
                            if (this.mState == 0) {
                                this.Bw.setSelection(0);
                                if (((int) ((y - this.Bv) / Bs)) < this.Bt.kl() && y - this.Bv > 0) {
                                    this.mState = 1;
                                    this.Bt.R(this.Bx.booleanValue());
                                    this.Bx = false;
                                    if (this.mOnScrollToPullListener != null) {
                                        this.mOnScrollToPullListener.V(true);
                                    }
                                } else if (y - this.Bv <= 0) {
                                    this.mState = 3;
                                    this.Bt.setPadding(0, -this.Bt.kl(), 0, 0);
                                    this.Bt.S(false);
                                    if (this.mOnScrollToPullListener != null) {
                                        this.mOnScrollToPullListener.V(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.Bw.setSelection(0);
                                if (((int) ((y - this.Bv) / Bs)) >= this.Bt.kl()) {
                                    this.mState = 0;
                                    this.Bx = true;
                                    this.Bt.kh();
                                    if (this.mOnScrollToPullListener != null) {
                                        this.mOnScrollToPullListener.V(true);
                                    }
                                } else if (y - this.Bv <= 0) {
                                    this.mState = 3;
                                    this.Bt.setPadding(0, -this.Bt.kl(), 0, 0);
                                    this.Bt.S(false);
                                    if (this.mOnScrollToPullListener != null) {
                                        this.mOnScrollToPullListener.V(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.Bv > 0) {
                                    this.mState = 1;
                                    this.Bt.R(this.Bx.booleanValue());
                                    this.Bx = false;
                                    if (this.mOnScrollToPullListener != null) {
                                        this.mOnScrollToPullListener.V(true);
                                    }
                                } else if (this.mOnScrollToPullListener != null) {
                                    this.mOnScrollToPullListener.V(false);
                                }
                            }
                            if (this.mState == 1 || this.mState == 0) {
                                this.Bt.setPadding(0, ((int) ((y - this.Bv) / Bs)) - this.Bt.kl(), 0, 0);
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
        public void ks() {
            View view;
            com.baidu.adp.widget.ListView.d kr = kr();
            if (kr != null && (view = kr.getView()) != null) {
                r rVar = new r(view.getContext(), 0, -kr.kl(), this.By);
                rVar.a(new q(this));
                rVar.r(view);
            }
        }
    }
}
