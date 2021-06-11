package com.baidu.ala.widget.multicolumn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.BdLog;
import com.huewu.pla.lib.MultiColumnListView;
import com.huewu.pla.lib.internal.PLA_AbsListView;
import com.huewu.pla.lib.internal.PLA_AdapterView;
import d.a.c.a.j;
import d.a.c.f.a.i;
import d.a.c.k.e.b;
import d.a.c.k.e.c;
import d.a.c.k.e.e;
import d.a.c.k.e.f;
import d.a.c.k.e.o;
import d.a.c.k.e.q;
import d.a.c.k.f.a;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdMultiColumnListView extends MultiColumnListView {
    public static final int REFRESH_DELAY = 100;
    public BdSimplePreLoadListAdapter mBdListAdpter;
    public Runnable mDelayedRunnable;
    public int mFirstVisibleItemIndex;
    public boolean mIsPreLoad;
    public int mLastAddPosition;
    public int mLastLoadCount;
    public b mNextPage;
    public View mNoDataView;
    public OnFooterClickListener mOnFooterClickListener;
    public OnHeaderClickListener mOnHeaderClickListener;
    public PLA_AdapterView.d mOnItemClickListener;
    public PLA_AdapterView.e mOnItemLongClickListener;
    public PLA_AdapterView.f mOnItemSelectedListener;
    public OnItemWillVisibleListener mOnItemWillVisibleListener;
    public PLA_AbsListView.e mOnScrollListener;
    public OnScrollStopDelayedListener mOnScrollStopDelayedListener;
    public long mOnScrollStopDelayedMillis;
    public OnScrollToBottomListener mOnScrollToBottomListener;
    public OnScrollToPullListener mOnScrollToPullListener;
    public OnScrollToTopListener mOnScrollToTopListener;
    public q mPreLoadListView;
    public int mPreLoadNum;
    public b mPrePage;
    public PullRefresh mPullRefresh;
    public int mScrollToTopNum;
    public Runnable preLoadRunnable;
    public Runnable refreshRunnable;

    /* loaded from: classes.dex */
    public interface OnFooterClickListener {
        void onClick(View view);
    }

    /* loaded from: classes.dex */
    public interface OnHeaderClickListener {
        void onClick(View view);
    }

    /* loaded from: classes.dex */
    public interface OnItemWillVisibleListener {
        void onItemWillVisible(int i2, boolean z);
    }

    /* loaded from: classes.dex */
    public interface OnScrollStopDelayedListener {
        void onScrollStop(int i2, int i3);
    }

    /* loaded from: classes.dex */
    public interface OnScrollToBottomListener {
        void onScrollToBottom();
    }

    /* loaded from: classes.dex */
    public interface OnScrollToPullListener {
        void onScrollToPull(boolean z);
    }

    /* loaded from: classes.dex */
    public interface OnScrollToTopListener {
        void onScrollToTop();
    }

    /* loaded from: classes.dex */
    public static class PullRefresh {
        public static final int DEFAULT_REFRESH_DURATION_TIME = 800;
        public static final int DONE = 3;
        public static final int PULL_TO_REFRESH = 1;
        public static final int REFRESHING = 2;
        public static final int RELEASE_TO_REFRESH = 0;
        public static float sRatio = 3.0f;
        public c mBdIListPullView;
        public BdMultiColumnListView mListView;
        public boolean mIsRecored = false;
        public int mStartY = 0;
        public int mState = 3;
        public Boolean mIsBack = Boolean.FALSE;
        public OnScrollToPullListener mOnScrollToPullListener = null;
        public int mAnimDurationTime = 800;

        public PullRefresh(BdMultiColumnListView bdMultiColumnListView, c cVar) {
            this.mBdIListPullView = null;
            this.mListView = null;
            if (cVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdMultiColumnListView != null) {
                this.mBdIListPullView = cVar;
                this.mListView = bdMultiColumnListView;
                View view = cVar.getView();
                view.setPadding(0, -this.mBdIListPullView.q(), 0, 0);
                view.invalidate();
                this.mListView.addPullRefreshView(view);
                return;
            }
            throw new InvalidParameterException("PullRefresh listView is null");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void animatePullView() {
            View view;
            c bdIListPullView = getBdIListPullView();
            if (bdIListPullView == null || (view = bdIListPullView.getView()) == null) {
                return;
            }
            f fVar = new f(view.getContext(), 0, -bdIListPullView.q(), this.mAnimDurationTime);
            fVar.d(new a() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.PullRefresh.1
                @Override // d.a.c.k.f.a
                public void onOver() {
                    PullRefresh.this.done();
                }
            });
            fVar.f(view);
        }

        public static boolean setRatio(float f2) {
            if (f2 > 0.0f) {
                sRatio = f2;
                return true;
            }
            return false;
        }

        public void done() {
            this.mState = 3;
            c cVar = this.mBdIListPullView;
            cVar.D(0, -cVar.q(), 0, 0);
            this.mBdIListPullView.o(true);
            OnScrollToPullListener onScrollToPullListener = this.mOnScrollToPullListener;
            if (onScrollToPullListener != null) {
                onScrollToPullListener.onScrollToPull(false);
            }
        }

        public c getBdIListPullView() {
            return this.mBdIListPullView;
        }

        public void onInterceptTouchEvent(MotionEvent motionEvent, int i2) {
            if (motionEvent.getAction() == 0 && getBdIListPullView().r()) {
                this.mIsRecored = false;
                this.mIsBack = Boolean.FALSE;
                if (i2 != 0 || 0 != 0 || this.mListView.getChildAt(0) == null || this.mListView.getChildAt(0).getTop() < 0) {
                    return;
                }
                this.mIsRecored = true;
                this.mStartY = (int) motionEvent.getY();
            }
        }

        public void onTouchEvent(MotionEvent motionEvent, int i2) {
            OnScrollToPullListener onScrollToPullListener;
            if (getBdIListPullView().r()) {
                int action = motionEvent.getAction();
                if (action != 1) {
                    if (action == 2) {
                        int y = (int) motionEvent.getY();
                        if (!this.mIsRecored && i2 == 0 && this.mListView.getChildAt(0) != null && this.mListView.getChildAt(0).getTop() >= 0) {
                            this.mIsRecored = true;
                            this.mStartY = y;
                        }
                        int i3 = this.mState;
                        if (i3 == 2 || !this.mIsRecored) {
                            return;
                        }
                        if (i3 == 0) {
                            this.mListView.setSelection(0);
                            if (((int) ((y - this.mStartY) / sRatio)) < this.mBdIListPullView.q() && y - this.mStartY > 0) {
                                this.mState = 1;
                                this.mBdIListPullView.x(this.mIsBack.booleanValue());
                                this.mIsBack = Boolean.FALSE;
                                OnScrollToPullListener onScrollToPullListener2 = this.mOnScrollToPullListener;
                                if (onScrollToPullListener2 != null) {
                                    onScrollToPullListener2.onScrollToPull(true);
                                }
                            } else if (y - this.mStartY <= 0) {
                                this.mState = 3;
                                c cVar = this.mBdIListPullView;
                                cVar.D(0, -cVar.q(), 0, 0);
                                this.mBdIListPullView.o(false);
                                OnScrollToPullListener onScrollToPullListener3 = this.mOnScrollToPullListener;
                                if (onScrollToPullListener3 != null) {
                                    onScrollToPullListener3.onScrollToPull(true);
                                }
                            }
                        } else if (i3 == 1) {
                            this.mListView.setSelection(0);
                            if (((int) ((y - this.mStartY) / sRatio)) >= this.mBdIListPullView.q()) {
                                this.mState = 0;
                                this.mIsBack = Boolean.TRUE;
                                this.mBdIListPullView.z();
                                OnScrollToPullListener onScrollToPullListener4 = this.mOnScrollToPullListener;
                                if (onScrollToPullListener4 != null) {
                                    onScrollToPullListener4.onScrollToPull(true);
                                }
                            } else if (y - this.mStartY <= 0) {
                                this.mState = 3;
                                c cVar2 = this.mBdIListPullView;
                                cVar2.D(0, -cVar2.q(), 0, 0);
                                this.mBdIListPullView.o(false);
                                OnScrollToPullListener onScrollToPullListener5 = this.mOnScrollToPullListener;
                                if (onScrollToPullListener5 != null) {
                                    onScrollToPullListener5.onScrollToPull(true);
                                }
                            }
                        } else if (i3 == 3) {
                            if (y - this.mStartY > 0) {
                                this.mState = 1;
                                this.mBdIListPullView.x(this.mIsBack.booleanValue());
                                this.mIsBack = Boolean.FALSE;
                                OnScrollToPullListener onScrollToPullListener6 = this.mOnScrollToPullListener;
                                if (onScrollToPullListener6 != null) {
                                    onScrollToPullListener6.onScrollToPull(true);
                                }
                            } else {
                                OnScrollToPullListener onScrollToPullListener7 = this.mOnScrollToPullListener;
                                if (onScrollToPullListener7 != null) {
                                    onScrollToPullListener7.onScrollToPull(false);
                                }
                            }
                        }
                        int i4 = this.mState;
                        if (i4 == 1 || i4 == 0) {
                            c cVar3 = this.mBdIListPullView;
                            cVar3.D(0, ((int) ((y - this.mStartY) / sRatio)) - cVar3.q(), 0, 0);
                            return;
                        }
                        return;
                    } else if (action != 3) {
                        return;
                    }
                }
                int i5 = this.mState;
                if (i5 != 2) {
                    if (i5 == 1) {
                        this.mState = 3;
                        c cVar4 = this.mBdIListPullView;
                        cVar4.D(0, -cVar4.q(), 0, 0);
                        this.mBdIListPullView.o(false);
                        OnScrollToPullListener onScrollToPullListener8 = this.mOnScrollToPullListener;
                        if (onScrollToPullListener8 != null) {
                            onScrollToPullListener8.onScrollToPull(true);
                        }
                    } else if (i5 != 0) {
                        if (i5 != 3 || (onScrollToPullListener = this.mOnScrollToPullListener) == null) {
                            return;
                        }
                        onScrollToPullListener.onScrollToPull(false);
                    } else {
                        startPullRefresh(false);
                        OnScrollToPullListener onScrollToPullListener9 = this.mOnScrollToPullListener;
                        if (onScrollToPullListener9 != null) {
                            onScrollToPullListener9.onScrollToPull(true);
                        }
                    }
                }
            }
        }

        public void setOnScrollToPullListener(OnScrollToPullListener onScrollToPullListener) {
            this.mOnScrollToPullListener = onScrollToPullListener;
        }

        public void startPullRefresh(boolean z) {
            this.mState = 2;
            this.mBdIListPullView.D(0, 0, 0, 0);
            this.mBdIListPullView.y();
            this.mBdIListPullView.v(z);
        }
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
                if (BdMultiColumnListView.this.mOnScrollStopDelayedListener != null) {
                    int firstVisiblePosition = BdMultiColumnListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdMultiColumnListView.this.getLastVisiblePosition();
                    int i2 = 0;
                    int i3 = -1;
                    if (BdMultiColumnListView.this.mAdapter instanceof d.i.a.a.b.a) {
                        int c2 = firstVisiblePosition - ((d.i.a.a.b.a) BdMultiColumnListView.this.mAdapter).c();
                        i3 = c2 < 0 ? 0 : c2;
                        int c3 = lastVisiblePosition - ((d.i.a.a.b.a) BdMultiColumnListView.this.mAdapter).c();
                        if (c3 >= BdMultiColumnListView.this.mAdapter.getCount()) {
                            c3 = BdMultiColumnListView.this.mAdapter.getCount() - 1;
                        }
                        if (c3 >= 0) {
                            i2 = c3;
                        }
                    } else {
                        i2 = -1;
                    }
                    BdMultiColumnListView.this.mOnScrollStopDelayedListener.onScrollStop(i3, i2);
                }
            }
        };
        this.mPreLoadListView = new q() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.2
            @Override // d.a.c.k.e.q
            public void cancelRefresh() {
                BdMultiColumnListView bdMultiColumnListView = BdMultiColumnListView.this;
                bdMultiColumnListView.removeCallbacks(bdMultiColumnListView.refreshRunnable);
            }

            @Override // d.a.c.k.e.q
            public o getAdapter() {
                return BdMultiColumnListView.this.mBdListAdpter;
            }

            @Override // d.a.c.k.e.q
            public int getFirstVisiblePosition() {
                return BdMultiColumnListView.this.getFirstVisiblePosition();
            }

            @Override // d.a.c.k.e.q
            public int getLastVisiblePosition() {
                return BdMultiColumnListView.this.getLastVisiblePosition();
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.3
            private void refreshImage(View view) {
                if (view == null) {
                    return;
                }
                if (view instanceof i) {
                    ((i) view).refresh();
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        refreshImage(viewGroup.getChildAt(i2));
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int childCount = BdMultiColumnListView.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    refreshImage(BdMultiColumnListView.this.getChildAt(i2));
                }
                d.a.c.a.i c2 = j.c(BdMultiColumnListView.this.getContext());
                if (c2 != null) {
                    c2.onPreLoad(BdMultiColumnListView.this.mPreLoadListView);
                }
            }
        };
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.4
            @Override // java.lang.Runnable
            public void run() {
                d.a.c.a.i c2 = j.c(BdMultiColumnListView.this.getContext());
                if (c2 != null) {
                    c2.onPreLoad(BdMultiColumnListView.this.mPreLoadListView);
                }
            }
        };
        this.mPullRefresh = null;
        initial();
    }

    private int getHeaderIndex() {
        if (this.mPrePage != null) {
            ListAdapter listAdapter = this.mAdapter;
            if (listAdapter instanceof d.i.a.a.b.a) {
                return ((d.i.a.a.b.a) listAdapter).c() - 1;
            }
            return -1;
        }
        return -1;
    }

    private void initial() {
        setFadingEdgeLength(0);
        BdSimplePreLoadListAdapter bdSimplePreLoadListAdapter = new BdSimplePreLoadListAdapter(getContext());
        this.mBdListAdpter = bdSimplePreLoadListAdapter;
        bdSimplePreLoadListAdapter.setListPreLoad(new e.b() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.5
            @Override // d.a.c.k.e.e.b
            public void onPreLoad() {
                BdMultiColumnListView bdMultiColumnListView = BdMultiColumnListView.this;
                bdMultiColumnListView.removeCallbacks(bdMultiColumnListView.preLoadRunnable);
                BdMultiColumnListView bdMultiColumnListView2 = BdMultiColumnListView.this;
                bdMultiColumnListView2.postDelayed(bdMultiColumnListView2.preLoadRunnable, 100L);
            }
        });
        super.setOnItemClickListener(new PLA_AdapterView.d() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.6
            @Override // com.huewu.pla.lib.internal.PLA_AdapterView.d
            public void onItemClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i2, long j) {
                int c2 = BdMultiColumnListView.this.mAdapter instanceof d.i.a.a.b.a ? ((d.i.a.a.b.a) BdMultiColumnListView.this.mAdapter).c() : 0;
                if (i2 < c2) {
                    if (BdMultiColumnListView.this.mPrePage == null || view != BdMultiColumnListView.this.mPrePage.b()) {
                        if (BdMultiColumnListView.this.mOnHeaderClickListener != null) {
                            BdMultiColumnListView.this.mOnHeaderClickListener.onClick(view);
                            return;
                        }
                        return;
                    }
                    BdMultiColumnListView.this.mPrePage.c();
                    return;
                }
                int i3 = i2 - c2;
                ListAdapter wrappedAdapter = BdMultiColumnListView.this.mAdapter instanceof d.i.a.a.b.a ? ((d.i.a.a.b.a) BdMultiColumnListView.this.mAdapter).getWrappedAdapter() : BdMultiColumnListView.this.mAdapter;
                if (wrappedAdapter == null || i3 >= wrappedAdapter.getCount()) {
                    if (BdMultiColumnListView.this.mNextPage == null || view != BdMultiColumnListView.this.mNextPage.b()) {
                        if (BdMultiColumnListView.this.mOnFooterClickListener != null) {
                            BdMultiColumnListView.this.mOnFooterClickListener.onClick(view);
                            return;
                        }
                        return;
                    }
                    BdMultiColumnListView.this.mNextPage.c();
                } else if (BdMultiColumnListView.this.mOnItemClickListener != null) {
                    BdMultiColumnListView.this.mOnItemClickListener.onItemClick(pLA_AdapterView, view, i3, j);
                }
            }
        });
        super.setOnScrollListener(new PLA_AbsListView.e() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.7
            @Override // com.huewu.pla.lib.internal.PLA_AbsListView.e
            public void onScroll(PLA_AbsListView pLA_AbsListView, int i2, int i3, int i4) {
                BdMultiColumnListView.this.mFirstVisibleItemIndex = i2;
                if (BdMultiColumnListView.this.mOnScrollListener != null) {
                    BdMultiColumnListView.this.mOnScrollListener.onScroll(pLA_AbsListView, i2, i3, i4);
                }
                if (BdMultiColumnListView.this.mOnScrollStopDelayedListener == null || BdMultiColumnListView.this.mOnScrollStopDelayedMillis <= 0 || BdMultiColumnListView.this.getHandler() == null) {
                    return;
                }
                BdMultiColumnListView.this.getHandler().removeCallbacks(BdMultiColumnListView.this.mDelayedRunnable);
                BdMultiColumnListView.this.getHandler().postDelayed(BdMultiColumnListView.this.mDelayedRunnable, BdMultiColumnListView.this.mOnScrollStopDelayedMillis);
            }

            @Override // com.huewu.pla.lib.internal.PLA_AbsListView.e
            public void onScrollStateChanged(PLA_AbsListView pLA_AbsListView, int i2) {
                d.a.c.a.i c2 = j.c(BdMultiColumnListView.this.getContext());
                if (c2 != null) {
                    if (i2 == 2) {
                        BdMultiColumnListView bdMultiColumnListView = BdMultiColumnListView.this;
                        bdMultiColumnListView.removeCallbacks(bdMultiColumnListView.refreshRunnable);
                        c2.setIsScroll(true);
                    } else if (c2.isScroll()) {
                        c2.setIsScroll(false);
                        BdMultiColumnListView bdMultiColumnListView2 = BdMultiColumnListView.this;
                        bdMultiColumnListView2.removeCallbacks(bdMultiColumnListView2.refreshRunnable);
                        BdMultiColumnListView bdMultiColumnListView3 = BdMultiColumnListView.this;
                        bdMultiColumnListView3.postDelayed(bdMultiColumnListView3.refreshRunnable, 100L);
                    } else if (i2 == 0) {
                        BdMultiColumnListView bdMultiColumnListView4 = BdMultiColumnListView.this;
                        bdMultiColumnListView4.removeCallbacks(bdMultiColumnListView4.preLoadRunnable);
                        BdMultiColumnListView bdMultiColumnListView5 = BdMultiColumnListView.this;
                        bdMultiColumnListView5.postDelayed(bdMultiColumnListView5.preLoadRunnable, 100L);
                    }
                }
                if (BdMultiColumnListView.this.mOnScrollListener != null) {
                    BdMultiColumnListView.this.mOnScrollListener.onScrollStateChanged(pLA_AbsListView, i2);
                }
                if (i2 == 0) {
                    if (BdMultiColumnListView.this.mOnScrollToBottomListener != null && pLA_AbsListView.getLastVisiblePosition() == pLA_AbsListView.getCount() - 1 && pLA_AbsListView.getFirstVisiblePosition() != 0) {
                        BdMultiColumnListView.this.mOnScrollToBottomListener.onScrollToBottom();
                    }
                    if (BdMultiColumnListView.this.mOnScrollToTopListener == null || pLA_AbsListView.getFirstVisiblePosition() > BdMultiColumnListView.this.mScrollToTopNum) {
                        return;
                    }
                    BdMultiColumnListView.this.mOnScrollToTopListener.onScrollToTop();
                }
            }
        });
    }

    public static boolean setPullRefreshRatio(float f2) {
        return PullRefresh.setRatio(f2);
    }

    public void addPullRefreshView(View view) {
        addHeaderView(view, null, false, 0);
    }

    public void completePullRefresh() {
        PullRefresh pullRefresh = this.mPullRefresh;
        if (pullRefresh != null) {
            if (pullRefresh.getBdIListPullView() != null) {
                this.mPullRefresh.mBdIListPullView.u();
            }
            this.mPullRefresh.animatePullView();
        }
    }

    public void completePullRefreshPostDelayed(long j) {
        PullRefresh pullRefresh = this.mPullRefresh;
        if (pullRefresh != null && pullRefresh.getBdIListPullView() != null) {
            this.mPullRefresh.mBdIListPullView.u();
        }
        d.a.c.e.m.e.a().postDelayed(new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.10
            @Override // java.lang.Runnable
            public void run() {
                if (BdMultiColumnListView.this.mPullRefresh != null) {
                    BdMultiColumnListView.this.mPullRefresh.animatePullView();
                }
            }
        }, j);
    }

    public q getPreLoadHandle() {
        return this.mPreLoadListView;
    }

    public boolean isRefreshDone() {
        PullRefresh pullRefresh = this.mPullRefresh;
        return pullRefresh == null || pullRefresh.mState == 3;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        PullRefresh pullRefresh = this.mPullRefresh;
        if (pullRefresh != null) {
            pullRefresh.onInterceptTouchEvent(motionEvent, this.mFirstVisibleItemIndex);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
        r0 = true;
     */
    @Override // com.huewu.pla.lib.MultiColumnListView, com.huewu.pla.lib.internal.PLA_ListView
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onItemAddedToList(int i2, boolean z) {
        super.onItemAddedToList(i2, z);
        if (this.mOnItemWillVisibleListener != null) {
            boolean z2 = z ? false : false;
            if (z2) {
                this.mOnItemWillVisibleListener.onItemWillVisible(i2 - getHeaderViewsCount(), z);
                this.mLastAddPosition = i2;
            }
        }
        if (this.mIsPreLoad && z) {
            boolean z3 = getCount() - i2 < this.mPreLoadNum;
            if (this.mOnScrollToBottomListener == null || getFirstVisiblePosition() == 0 || this.mLastLoadCount == getCount() || !z3) {
                return;
            }
            this.mOnScrollToBottomListener.onScrollToBottom();
            this.mLastLoadCount = getCount();
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView, com.huewu.pla.lib.internal.PLA_AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        PullRefresh pullRefresh = this.mPullRefresh;
        if (pullRefresh != null) {
            pullRefresh.onTouchEvent(motionEvent, this.mFirstVisibleItemIndex);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public void setNextPage(b bVar) {
        b bVar2 = this.mNextPage;
        if (bVar2 != null) {
            removeFooterView(bVar2.b());
            this.mNextPage = null;
        }
        if (bVar != null) {
            addFooterView(bVar.b(), null, true, 0);
            this.mNextPage = bVar;
        }
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

    public void setOnFooterClickListener(OnFooterClickListener onFooterClickListener) {
        this.mOnFooterClickListener = onFooterClickListener;
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        this.mOnHeaderClickListener = onHeaderClickListener;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setOnItemClickListener(PLA_AdapterView.d dVar) {
        this.mOnItemClickListener = dVar;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setOnItemLongClickListener(PLA_AdapterView.e eVar) {
        if (eVar == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.mOnItemLongClickListener = eVar;
        super.setOnItemLongClickListener(new PLA_AdapterView.e() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.8
            @Override // com.huewu.pla.lib.internal.PLA_AdapterView.e
            public boolean onItemLongClick(PLA_AdapterView<?> pLA_AdapterView, View view, int i2, long j) {
                int c2 = BdMultiColumnListView.this.mAdapter instanceof d.i.a.a.b.a ? ((d.i.a.a.b.a) BdMultiColumnListView.this.mAdapter).c() : 0;
                if (i2 < c2) {
                    return true;
                }
                int i3 = i2 - c2;
                ListAdapter listAdapter = BdMultiColumnListView.this.mAdapter;
                if (listAdapter == null || i3 >= listAdapter.getCount()) {
                    return true;
                }
                if (BdMultiColumnListView.this.mOnItemLongClickListener != null) {
                    return BdMultiColumnListView.this.mOnItemLongClickListener.onItemLongClick(pLA_AdapterView, view, i3, j);
                }
                return false;
            }
        });
    }

    @Override // com.huewu.pla.lib.internal.PLA_AdapterView
    public void setOnItemSelectedListener(PLA_AdapterView.f fVar) {
        if (fVar == null) {
            super.setOnItemSelectedListener(null);
            return;
        }
        this.mOnItemSelectedListener = fVar;
        super.setOnItemSelectedListener(new PLA_AdapterView.f() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.9
            @Override // com.huewu.pla.lib.internal.PLA_AdapterView.f
            public void onItemSelected(PLA_AdapterView<?> pLA_AdapterView, View view, int i2, long j) {
                int c2 = BdMultiColumnListView.this.mAdapter instanceof d.i.a.a.b.a ? ((d.i.a.a.b.a) BdMultiColumnListView.this.mAdapter).c() : 0;
                if (i2 < c2) {
                    return;
                }
                int i3 = i2 - c2;
                ListAdapter wrappedAdapter = BdMultiColumnListView.this.mBdListAdpter.getWrappedAdapter();
                if (wrappedAdapter == null || i3 >= wrappedAdapter.getCount() || BdMultiColumnListView.this.mOnItemSelectedListener == null) {
                    return;
                }
                BdMultiColumnListView.this.mOnItemSelectedListener.onItemSelected(pLA_AdapterView, view, i3, j);
            }

            @Override // com.huewu.pla.lib.internal.PLA_AdapterView.f
            public void onNothingSelected(PLA_AdapterView<?> pLA_AdapterView) {
                if (BdMultiColumnListView.this.mOnItemSelectedListener != null) {
                    BdMultiColumnListView.this.mOnItemSelectedListener.onNothingSelected(pLA_AdapterView);
                }
            }
        });
    }

    public void setOnItemWillVisileListener(OnItemWillVisibleListener onItemWillVisibleListener) {
        this.mOnItemWillVisibleListener = onItemWillVisibleListener;
    }

    @Override // com.huewu.pla.lib.internal.PLA_AbsListView
    public void setOnScrollListener(PLA_AbsListView.e eVar) {
        this.mOnScrollListener = eVar;
    }

    public void setOnScrollStopDelayedListener(OnScrollStopDelayedListener onScrollStopDelayedListener, long j) {
        this.mOnScrollStopDelayedListener = onScrollStopDelayedListener;
        this.mOnScrollStopDelayedMillis = j;
    }

    public void setOnScrollToPullListener(OnScrollToPullListener onScrollToPullListener) {
        this.mOnScrollToPullListener = onScrollToPullListener;
    }

    public void setOnSrollToBottomListener(OnScrollToBottomListener onScrollToBottomListener) {
        this.mOnScrollToBottomListener = onScrollToBottomListener;
    }

    public void setOnSrollToTopListener(OnScrollToTopListener onScrollToTopListener) {
        this.mOnScrollToTopListener = onScrollToTopListener;
    }

    public void setPreLoad(boolean z, int i2) {
        this.mIsPreLoad = z;
        this.mPreLoadNum = i2;
    }

    public void setPrePage(b bVar) {
        b bVar2 = this.mPrePage;
        if (bVar2 != null) {
            removeHeaderView(bVar2.b());
            this.mPrePage = null;
        }
        if (bVar != null) {
            addHeaderView(bVar.b());
            this.mPrePage = bVar;
        }
    }

    public void setPullRefresh(c cVar) {
        PullRefresh pullRefresh = this.mPullRefresh;
        if (pullRefresh != null) {
            removeHeaderView(pullRefresh.getBdIListPullView().getView());
        }
        this.mPullRefresh = null;
        if (cVar != null) {
            PullRefresh pullRefresh2 = new PullRefresh(this, cVar);
            this.mPullRefresh = pullRefresh2;
            pullRefresh2.setOnScrollToPullListener(this.mOnScrollToPullListener);
        }
    }

    @Override // com.huewu.pla.lib.internal.PLA_ListView
    public void setSelectionFromTop(int i2, int i3) {
        super.setSelectionFromTop(i2, i3);
    }

    public void startPullRefresh() {
        if (this.mPullRefresh != null) {
            setSelection(0);
            this.mPullRefresh.startPullRefresh(true);
        }
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

    public void setOnSrollToTopListener(OnScrollToTopListener onScrollToTopListener, int i2) {
        this.mOnScrollToTopListener = onScrollToTopListener;
        int i3 = i2 - 1;
        if (i3 < 0) {
            i3 = 0;
        }
        this.mScrollToTopNum = i3;
    }

    public void setNoData(View view) {
        View view2 = this.mNoDataView;
        if (view2 != null) {
            removeHeaderView(view2);
            this.mNoDataView = null;
        }
        if (view != null) {
            addHeaderView(view, null, false);
            this.mNoDataView = view;
        }
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
                if (BdMultiColumnListView.this.mOnScrollStopDelayedListener != null) {
                    int firstVisiblePosition = BdMultiColumnListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdMultiColumnListView.this.getLastVisiblePosition();
                    int i2 = 0;
                    int i3 = -1;
                    if (BdMultiColumnListView.this.mAdapter instanceof d.i.a.a.b.a) {
                        int c2 = firstVisiblePosition - ((d.i.a.a.b.a) BdMultiColumnListView.this.mAdapter).c();
                        i3 = c2 < 0 ? 0 : c2;
                        int c3 = lastVisiblePosition - ((d.i.a.a.b.a) BdMultiColumnListView.this.mAdapter).c();
                        if (c3 >= BdMultiColumnListView.this.mAdapter.getCount()) {
                            c3 = BdMultiColumnListView.this.mAdapter.getCount() - 1;
                        }
                        if (c3 >= 0) {
                            i2 = c3;
                        }
                    } else {
                        i2 = -1;
                    }
                    BdMultiColumnListView.this.mOnScrollStopDelayedListener.onScrollStop(i3, i2);
                }
            }
        };
        this.mPreLoadListView = new q() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.2
            @Override // d.a.c.k.e.q
            public void cancelRefresh() {
                BdMultiColumnListView bdMultiColumnListView = BdMultiColumnListView.this;
                bdMultiColumnListView.removeCallbacks(bdMultiColumnListView.refreshRunnable);
            }

            @Override // d.a.c.k.e.q
            public o getAdapter() {
                return BdMultiColumnListView.this.mBdListAdpter;
            }

            @Override // d.a.c.k.e.q
            public int getFirstVisiblePosition() {
                return BdMultiColumnListView.this.getFirstVisiblePosition();
            }

            @Override // d.a.c.k.e.q
            public int getLastVisiblePosition() {
                return BdMultiColumnListView.this.getLastVisiblePosition();
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.3
            private void refreshImage(View view) {
                if (view == null) {
                    return;
                }
                if (view instanceof i) {
                    ((i) view).refresh();
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        refreshImage(viewGroup.getChildAt(i2));
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int childCount = BdMultiColumnListView.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    refreshImage(BdMultiColumnListView.this.getChildAt(i2));
                }
                d.a.c.a.i c2 = j.c(BdMultiColumnListView.this.getContext());
                if (c2 != null) {
                    c2.onPreLoad(BdMultiColumnListView.this.mPreLoadListView);
                }
            }
        };
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.4
            @Override // java.lang.Runnable
            public void run() {
                d.a.c.a.i c2 = j.c(BdMultiColumnListView.this.getContext());
                if (c2 != null) {
                    c2.onPreLoad(BdMultiColumnListView.this.mPreLoadListView);
                }
            }
        };
        this.mPullRefresh = null;
        initial();
    }

    public BdMultiColumnListView(Context context, AttributeSet attributeSet, int i2) {
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
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.1
            @Override // java.lang.Runnable
            public void run() {
                if (BdMultiColumnListView.this.mOnScrollStopDelayedListener != null) {
                    int firstVisiblePosition = BdMultiColumnListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdMultiColumnListView.this.getLastVisiblePosition();
                    int i22 = 0;
                    int i3 = -1;
                    if (BdMultiColumnListView.this.mAdapter instanceof d.i.a.a.b.a) {
                        int c2 = firstVisiblePosition - ((d.i.a.a.b.a) BdMultiColumnListView.this.mAdapter).c();
                        i3 = c2 < 0 ? 0 : c2;
                        int c3 = lastVisiblePosition - ((d.i.a.a.b.a) BdMultiColumnListView.this.mAdapter).c();
                        if (c3 >= BdMultiColumnListView.this.mAdapter.getCount()) {
                            c3 = BdMultiColumnListView.this.mAdapter.getCount() - 1;
                        }
                        if (c3 >= 0) {
                            i22 = c3;
                        }
                    } else {
                        i22 = -1;
                    }
                    BdMultiColumnListView.this.mOnScrollStopDelayedListener.onScrollStop(i3, i22);
                }
            }
        };
        this.mPreLoadListView = new q() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.2
            @Override // d.a.c.k.e.q
            public void cancelRefresh() {
                BdMultiColumnListView bdMultiColumnListView = BdMultiColumnListView.this;
                bdMultiColumnListView.removeCallbacks(bdMultiColumnListView.refreshRunnable);
            }

            @Override // d.a.c.k.e.q
            public o getAdapter() {
                return BdMultiColumnListView.this.mBdListAdpter;
            }

            @Override // d.a.c.k.e.q
            public int getFirstVisiblePosition() {
                return BdMultiColumnListView.this.getFirstVisiblePosition();
            }

            @Override // d.a.c.k.e.q
            public int getLastVisiblePosition() {
                return BdMultiColumnListView.this.getLastVisiblePosition();
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.3
            private void refreshImage(View view) {
                if (view == null) {
                    return;
                }
                if (view instanceof i) {
                    ((i) view).refresh();
                }
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    int childCount = viewGroup.getChildCount();
                    for (int i22 = 0; i22 < childCount; i22++) {
                        refreshImage(viewGroup.getChildAt(i22));
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                int childCount = BdMultiColumnListView.this.getChildCount();
                for (int i22 = 0; i22 < childCount; i22++) {
                    refreshImage(BdMultiColumnListView.this.getChildAt(i22));
                }
                d.a.c.a.i c2 = j.c(BdMultiColumnListView.this.getContext());
                if (c2 != null) {
                    c2.onPreLoad(BdMultiColumnListView.this.mPreLoadListView);
                }
            }
        };
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.ala.widget.multicolumn.BdMultiColumnListView.4
            @Override // java.lang.Runnable
            public void run() {
                d.a.c.a.i c2 = j.c(BdMultiColumnListView.this.getContext());
                if (c2 != null) {
                    c2.onPreLoad(BdMultiColumnListView.this.mPreLoadListView);
                }
            }
        };
        this.mPullRefresh = null;
        initial();
    }
}
