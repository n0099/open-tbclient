package com.baidu.live.adp.widget.listview;

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
import com.baidu.live.adp.R;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.base.IScrollable;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.lib.safe.SafeHandler;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.newwidget.imageview.IRefresh;
import com.baidu.live.adp.widget.listview.BdListAdpter;
import com.baidu.live.adp.widget.scrollview.BdOnAnimationOverListener;
import java.security.InvalidParameterException;
/* loaded from: classes11.dex */
public class BdListView extends ListView implements IListView<BdListView> {
    public static final byte KEYBOARD_STATE_HIDE = -2;
    public static final byte KEYBOARD_STATE_INIT = -1;
    public static final byte KEYBOARD_STATE_SHOW = -3;
    public static final int OVER_SCROLL_NEVER = 2;
    private static final int REFRESH_DELAY = 100;
    private BdListAdpter mBdListAdpter;
    private Runnable mDelayedRunnable;
    private OnScrollToBottomListenerEx mExScrollToBottomListener;
    private int mFirstVisibleItemIndex;
    private boolean mHasKeybord;
    private boolean mKeybordScrollBottom;
    private boolean mLayoutHasInit;
    private int mMaxHeight;
    private BdIListPage mNextPage;
    private View mNoDataView;
    private OnFooterClickListener mOnFooterClickListener;
    private OnHeaderClickListener mOnHeaderClickListener;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private AdapterView.OnItemLongClickListener mOnItemLongClickListener;
    private AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private OnKybdsChangeListener mOnKybdsChangeListener;
    private AbsListView.OnScrollListener mOnScrollListener;
    private OnScrollStopDelayedListener mOnScrollStopDelayedListener;
    private long mOnScrollStopDelayedMillis;
    private OnScrollToBottomListener mOnScrollToBottomListener;
    private OnScrollToPullListener mOnScrollToPullListener;
    private OnScrollToTopListener mOnScrollToTopListener;
    private int mPreHeight;
    private BdIListPage mPrePage;
    private final IPreLoadListView mPreloadListView;
    private PullRefresh mPullRefresh;
    private int mScrollToTopNum;
    private IScrollable mScrollable;
    private Runnable mSelectRunnable;
    private int maxHeight;
    private Runnable preLoadRunnable;
    private Runnable refreshRunnable;

    /* loaded from: classes11.dex */
    public interface OnFooterClickListener {
        void onClick(View view);
    }

    /* loaded from: classes11.dex */
    public interface OnHeaderClickListener {
        void onClick(View view);
    }

    /* loaded from: classes11.dex */
    public interface OnKybdsChangeListener {
        void onKeyBoardStateChange(int i);
    }

    /* loaded from: classes11.dex */
    public interface OnScrollStopDelayedListener {
        void onScrollStop(int i, int i2);
    }

    /* loaded from: classes11.dex */
    public interface OnScrollToBottomListener {
        void onScrollToBottom();
    }

    /* loaded from: classes11.dex */
    public interface OnScrollToBottomListenerEx {
        void onScrollToBottom(BdListView bdListView);
    }

    /* loaded from: classes11.dex */
    public interface OnScrollToPullListener {
        void onScrollToPull(boolean z);
    }

    /* loaded from: classes11.dex */
    public interface OnScrollToTopListener {
        void onScrollToTop();
    }

    @Override // com.baidu.live.adp.widget.listview.IListView
    public void setScrollable(IScrollable iScrollable) {
        this.mScrollable = iScrollable;
    }

    public IPreLoadListView getPreLoadHandle() {
        return this.mPreloadListView;
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
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdListView.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2 = 0;
                if (BdListView.this.mOnScrollStopDelayedListener != null) {
                    int firstVisiblePosition = BdListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdListView.this.getLastVisiblePosition();
                    if (BdListView.this.mBdListAdpter == null || BdListView.this.mBdListAdpter.getWrappedAdapter() == null || BdListView.this.mBdListAdpter.getWrappedCount() <= 0) {
                        i2 = -1;
                        i = -1;
                    } else {
                        int headersCount = firstVisiblePosition - BdListView.this.mBdListAdpter.getHeadersCount();
                        if (headersCount < 0) {
                            headersCount = 0;
                        }
                        int headersCount2 = lastVisiblePosition - BdListView.this.mBdListAdpter.getHeadersCount();
                        if (headersCount2 >= BdListView.this.mBdListAdpter.getWrappedCount()) {
                            headersCount2 = BdListView.this.mBdListAdpter.getWrappedCount() - 1;
                        }
                        if (headersCount2 < 0) {
                            i = headersCount;
                        } else {
                            i2 = headersCount2;
                            i = headersCount;
                        }
                    }
                    BdListView.this.mOnScrollStopDelayedListener.onScrollStop(i, i2);
                }
            }
        };
        this.mPreloadListView = new IPreLoadListView() { // from class: com.baidu.live.adp.widget.listview.BdListView.2
            @Override // com.baidu.live.adp.widget.listview.IPreLoadListView
            public IListAdapter getAdapter() {
                return BdListView.this.getAdapter2();
            }

            @Override // com.baidu.live.adp.widget.listview.IPreLoadListView
            public int getFirstVisiblePosition() {
                return BdListView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.live.adp.widget.listview.IPreLoadListView
            public int getLastVisiblePosition() {
                return BdListView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.live.adp.widget.listview.IPreLoadListView
            public void cancelRefresh() {
                BdListView.this.removeCallbacks(BdListView.this.refreshRunnable);
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdListView.3
            @Override // java.lang.Runnable
            public void run() {
                IScrollable iScrollable;
                int childCount = BdListView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    refreshImage(BdListView.this.getChildAt(i));
                }
                if (BdListView.this.mScrollable != null) {
                    iScrollable = BdListView.this.mScrollable;
                } else {
                    iScrollable = IScrollableHelper.getIScrollable(BdListView.this.getContext());
                }
                if (iScrollable != null) {
                    iScrollable.onPreLoad(BdListView.this.mPreloadListView);
                }
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof IRefresh) {
                        ((IRefresh) view).refresh();
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
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdListView.4
            @Override // java.lang.Runnable
            public void run() {
                IScrollable iScrollable;
                if (BdListView.this.mScrollable != null) {
                    iScrollable = BdListView.this.mScrollable;
                } else {
                    iScrollable = IScrollableHelper.getIScrollable(BdListView.this.getContext());
                }
                if (iScrollable != null) {
                    iScrollable.onPreLoad(BdListView.this.mPreloadListView);
                }
            }
        };
        this.mLayoutHasInit = false;
        this.mHasKeybord = false;
        this.mKeybordScrollBottom = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.mOnKybdsChangeListener = null;
        this.mSelectRunnable = new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdListView.10
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
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdListView.1
            @Override // java.lang.Runnable
            public void run() {
                int i;
                int i2 = 0;
                if (BdListView.this.mOnScrollStopDelayedListener != null) {
                    int firstVisiblePosition = BdListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdListView.this.getLastVisiblePosition();
                    if (BdListView.this.mBdListAdpter == null || BdListView.this.mBdListAdpter.getWrappedAdapter() == null || BdListView.this.mBdListAdpter.getWrappedCount() <= 0) {
                        i2 = -1;
                        i = -1;
                    } else {
                        int headersCount = firstVisiblePosition - BdListView.this.mBdListAdpter.getHeadersCount();
                        if (headersCount < 0) {
                            headersCount = 0;
                        }
                        int headersCount2 = lastVisiblePosition - BdListView.this.mBdListAdpter.getHeadersCount();
                        if (headersCount2 >= BdListView.this.mBdListAdpter.getWrappedCount()) {
                            headersCount2 = BdListView.this.mBdListAdpter.getWrappedCount() - 1;
                        }
                        if (headersCount2 < 0) {
                            i = headersCount;
                        } else {
                            i2 = headersCount2;
                            i = headersCount;
                        }
                    }
                    BdListView.this.mOnScrollStopDelayedListener.onScrollStop(i, i2);
                }
            }
        };
        this.mPreloadListView = new IPreLoadListView() { // from class: com.baidu.live.adp.widget.listview.BdListView.2
            @Override // com.baidu.live.adp.widget.listview.IPreLoadListView
            public IListAdapter getAdapter() {
                return BdListView.this.getAdapter2();
            }

            @Override // com.baidu.live.adp.widget.listview.IPreLoadListView
            public int getFirstVisiblePosition() {
                return BdListView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.live.adp.widget.listview.IPreLoadListView
            public int getLastVisiblePosition() {
                return BdListView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.live.adp.widget.listview.IPreLoadListView
            public void cancelRefresh() {
                BdListView.this.removeCallbacks(BdListView.this.refreshRunnable);
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdListView.3
            @Override // java.lang.Runnable
            public void run() {
                IScrollable iScrollable;
                int childCount = BdListView.this.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    refreshImage(BdListView.this.getChildAt(i));
                }
                if (BdListView.this.mScrollable != null) {
                    iScrollable = BdListView.this.mScrollable;
                } else {
                    iScrollable = IScrollableHelper.getIScrollable(BdListView.this.getContext());
                }
                if (iScrollable != null) {
                    iScrollable.onPreLoad(BdListView.this.mPreloadListView);
                }
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof IRefresh) {
                        ((IRefresh) view).refresh();
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
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdListView.4
            @Override // java.lang.Runnable
            public void run() {
                IScrollable iScrollable;
                if (BdListView.this.mScrollable != null) {
                    iScrollable = BdListView.this.mScrollable;
                } else {
                    iScrollable = IScrollableHelper.getIScrollable(BdListView.this.getContext());
                }
                if (iScrollable != null) {
                    iScrollable.onPreLoad(BdListView.this.mPreloadListView);
                }
            }
        };
        this.mLayoutHasInit = false;
        this.mHasKeybord = false;
        this.mKeybordScrollBottom = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.mOnKybdsChangeListener = null;
        this.mSelectRunnable = new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdListView.10
            @Override // java.lang.Runnable
            public void run() {
                BdListView.this.setSelection(BdListView.this.getCount() - 1);
            }
        };
        this.mPullRefresh = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i) {
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
        this.mExScrollToBottomListener = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.mScrollable = null;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdListView.1
            @Override // java.lang.Runnable
            public void run() {
                int i2;
                int i22 = 0;
                if (BdListView.this.mOnScrollStopDelayedListener != null) {
                    int firstVisiblePosition = BdListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdListView.this.getLastVisiblePosition();
                    if (BdListView.this.mBdListAdpter == null || BdListView.this.mBdListAdpter.getWrappedAdapter() == null || BdListView.this.mBdListAdpter.getWrappedCount() <= 0) {
                        i22 = -1;
                        i2 = -1;
                    } else {
                        int headersCount = firstVisiblePosition - BdListView.this.mBdListAdpter.getHeadersCount();
                        if (headersCount < 0) {
                            headersCount = 0;
                        }
                        int headersCount2 = lastVisiblePosition - BdListView.this.mBdListAdpter.getHeadersCount();
                        if (headersCount2 >= BdListView.this.mBdListAdpter.getWrappedCount()) {
                            headersCount2 = BdListView.this.mBdListAdpter.getWrappedCount() - 1;
                        }
                        if (headersCount2 < 0) {
                            i2 = headersCount;
                        } else {
                            i22 = headersCount2;
                            i2 = headersCount;
                        }
                    }
                    BdListView.this.mOnScrollStopDelayedListener.onScrollStop(i2, i22);
                }
            }
        };
        this.mPreloadListView = new IPreLoadListView() { // from class: com.baidu.live.adp.widget.listview.BdListView.2
            @Override // com.baidu.live.adp.widget.listview.IPreLoadListView
            public IListAdapter getAdapter() {
                return BdListView.this.getAdapter2();
            }

            @Override // com.baidu.live.adp.widget.listview.IPreLoadListView
            public int getFirstVisiblePosition() {
                return BdListView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.live.adp.widget.listview.IPreLoadListView
            public int getLastVisiblePosition() {
                return BdListView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.live.adp.widget.listview.IPreLoadListView
            public void cancelRefresh() {
                BdListView.this.removeCallbacks(BdListView.this.refreshRunnable);
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdListView.3
            @Override // java.lang.Runnable
            public void run() {
                IScrollable iScrollable;
                int childCount = BdListView.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    refreshImage(BdListView.this.getChildAt(i2));
                }
                if (BdListView.this.mScrollable != null) {
                    iScrollable = BdListView.this.mScrollable;
                } else {
                    iScrollable = IScrollableHelper.getIScrollable(BdListView.this.getContext());
                }
                if (iScrollable != null) {
                    iScrollable.onPreLoad(BdListView.this.mPreloadListView);
                }
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof IRefresh) {
                        ((IRefresh) view).refresh();
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
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdListView.4
            @Override // java.lang.Runnable
            public void run() {
                IScrollable iScrollable;
                if (BdListView.this.mScrollable != null) {
                    iScrollable = BdListView.this.mScrollable;
                } else {
                    iScrollable = IScrollableHelper.getIScrollable(BdListView.this.getContext());
                }
                if (iScrollable != null) {
                    iScrollable.onPreLoad(BdListView.this.mPreloadListView);
                }
            }
        };
        this.mLayoutHasInit = false;
        this.mHasKeybord = false;
        this.mKeybordScrollBottom = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.mOnKybdsChangeListener = null;
        this.mSelectRunnable = new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdListView.10
            @Override // java.lang.Runnable
            public void run() {
                BdListView.this.setSelection(BdListView.this.getCount() - 1);
            }
        };
        this.mPullRefresh = null;
        initial();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
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

    @Override // android.widget.ListView, android.widget.AbsListView
    protected void layoutChildren() {
        try {
            super.layoutChildren();
        } catch (NullPointerException e) {
            BdLog.detailException(e);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        } catch (Exception e2) {
            BdLog.detailException(e2);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.mBdListAdpter = new BdListAdpter(getContext());
        this.mBdListAdpter.setListPreLoad(new BdListAdpter.BdListPreLoad() { // from class: com.baidu.live.adp.widget.listview.BdListView.5
            @Override // com.baidu.live.adp.widget.listview.BdListAdpter.BdListPreLoad
            public void onPreLoad() {
                BdListView.this.removeCallbacks(BdListView.this.preLoadRunnable);
                BdListView.this.postDelayed(BdListView.this.preLoadRunnable, 100L);
            }
        });
        super.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.live.adp.widget.listview.BdListView.6
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int headersCount = BdListView.this.mBdListAdpter.getHeadersCount();
                if (i < headersCount) {
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
                int i2 = i - headersCount;
                ListAdapter wrappedAdapter = BdListView.this.mBdListAdpter.getWrappedAdapter();
                if (wrappedAdapter == null || i2 >= wrappedAdapter.getCount()) {
                    if (BdListView.this.mNextPage == null || view != BdListView.this.mNextPage.getView()) {
                        if (BdListView.this.mOnFooterClickListener != null) {
                            BdListView.this.mOnFooterClickListener.onClick(view);
                            return;
                        }
                        return;
                    }
                    BdListView.this.mNextPage.onClick();
                } else if (BdListView.this.mOnItemClickListener != null) {
                    BdListView.this.mOnItemClickListener.onItemClick(adapterView, view, i2, j);
                }
            }
        });
        super.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.live.adp.widget.listview.BdListView.7
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                IScrollable iScrollable;
                if (BdListView.this.mScrollable != null) {
                    iScrollable = BdListView.this.mScrollable;
                } else {
                    iScrollable = IScrollableHelper.getIScrollable(BdListView.this.getContext());
                }
                if (iScrollable != null) {
                    if (i == 2) {
                        BdListView.this.removeCallbacks(BdListView.this.refreshRunnable);
                        iScrollable.setIsScroll(true);
                    } else if (iScrollable.isScroll()) {
                        iScrollable.setIsScroll(false);
                        BdListView.this.removeCallbacks(BdListView.this.refreshRunnable);
                        BdListView.this.postDelayed(BdListView.this.refreshRunnable, 100L);
                    } else if (i == 0) {
                        BdListView.this.removeCallbacks(BdListView.this.preLoadRunnable);
                        BdListView.this.postDelayed(BdListView.this.preLoadRunnable, 100L);
                    }
                }
                if (BdListView.this.mOnScrollListener != null) {
                    BdListView.this.mOnScrollListener.onScrollStateChanged(absListView, i);
                }
                if (i == 0) {
                    if (BdListView.this.mOnScrollToBottomListener != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                        BdListView.this.mOnScrollToBottomListener.onScrollToBottom();
                    }
                    if (BdListView.this.mExScrollToBottomListener != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                        BdListView.this.mExScrollToBottomListener.onScrollToBottom(BdListView.this);
                    }
                    if (BdListView.this.mOnScrollToTopListener != null && absListView.getFirstVisiblePosition() <= BdListView.this.mScrollToTopNum) {
                        BdListView.this.mOnScrollToTopListener.onScrollToTop();
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                BdListView.this.mFirstVisibleItemIndex = i;
                if (BdListView.this.mOnScrollListener != null) {
                    BdListView.this.mOnScrollListener.onScroll(absListView, i, i2, i3);
                }
                if (BdListView.this.mOnScrollStopDelayedListener != null && BdListView.this.mOnScrollStopDelayedMillis > 0) {
                    BdListView.this.getHandler().removeCallbacks(BdListView.this.mDelayedRunnable);
                    BdListView.this.getHandler().postDelayed(BdListView.this.mDelayedRunnable, BdListView.this.mOnScrollStopDelayedMillis);
                }
            }
        });
    }

    public void setOnScrollToPullListener(OnScrollToPullListener onScrollToPullListener) {
        this.mOnScrollToPullListener = onScrollToPullListener;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.maxHeight <= 0) {
            super.onMeasure(i, i2);
            return;
        }
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (size > this.maxHeight) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.maxHeight, mode);
        }
        super.onMeasure(i, i2);
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

    public void setExOnSrollToBottomListener(OnScrollToBottomListenerEx onScrollToBottomListenerEx) {
        this.mExScrollToBottomListener = onScrollToBottomListenerEx;
    }

    @Override // com.baidu.live.adp.widget.listview.IListView
    public void setOnScrollStopDelayedListener(OnScrollStopDelayedListener onScrollStopDelayedListener, long j) {
        this.mOnScrollStopDelayedListener = onScrollStopDelayedListener;
        this.mOnScrollStopDelayedMillis = j;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.mOnItemLongClickListener = onItemLongClickListener;
        super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.live.adp.widget.listview.BdListView.8
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                int headersCount = BdListView.this.mBdListAdpter.getHeadersCount();
                if (i < headersCount) {
                    return true;
                }
                int i2 = i - headersCount;
                ListAdapter wrappedAdapter = BdListView.this.mBdListAdpter.getWrappedAdapter();
                if (wrappedAdapter == null || i2 >= wrappedAdapter.getCount()) {
                    return true;
                }
                if (BdListView.this.mOnItemLongClickListener != null) {
                    return BdListView.this.mOnItemLongClickListener.onItemLongClick(adapterView, view, i2, j);
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
        super.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.baidu.live.adp.widget.listview.BdListView.9
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                int headersCount = BdListView.this.mBdListAdpter.getHeadersCount();
                if (i >= headersCount) {
                    int i2 = i - headersCount;
                    ListAdapter wrappedAdapter = BdListView.this.mBdListAdpter.getWrappedAdapter();
                    if (wrappedAdapter != null && i2 < wrappedAdapter.getCount() && BdListView.this.mOnItemSelectedListener != null) {
                        BdListView.this.mOnItemSelectedListener.onItemSelected(adapterView, view, i2, j);
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
    /* JADX DEBUG: Return type fixed from 'com.baidu.live.adp.widget.listview.BdListAdpter' to match base method */
    @Override // android.widget.ListView, android.widget.AdapterView
    /* renamed from: getAdapter */
    public ListAdapter getAdapter2() {
        return this.mBdListAdpter;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.mBdListAdpter instanceof BdListAdpter) {
            return this.mBdListAdpter.getWrappedAdapter();
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.adp.widget.listview.IListView
    public BdListView getListView() {
        return this;
    }

    @Override // com.baidu.live.adp.widget.listview.IListView
    public IListAdapter getListAdapter() {
        return getAdapter2();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.mBdListAdpter.setAdaper(listAdapter);
        super.setAdapter((ListAdapter) this.mBdListAdpter);
    }

    public void setOnHeaderClickListener(OnHeaderClickListener onHeaderClickListener) {
        this.mOnHeaderClickListener = onHeaderClickListener;
    }

    public void setOnFooterClickListener(OnFooterClickListener onFooterClickListener) {
        this.mOnFooterClickListener = onFooterClickListener;
    }

    @Override // android.widget.ListView, com.baidu.live.adp.widget.listview.IListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.mBdListAdpter.addHeaderView(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView, com.baidu.live.adp.widget.listview.IListView
    public void addHeaderView(View view) {
        this.mBdListAdpter.addHeaderView(view, getHeaderIndex());
    }

    @Override // com.baidu.live.adp.widget.listview.IListView
    public void addHeaderView(View view, int i) {
        this.mBdListAdpter.addHeaderView(view, i);
    }

    @Override // android.widget.ListView, com.baidu.live.adp.widget.listview.IListView
    public int getHeaderViewsCount() {
        return this.mBdListAdpter.getHeaderViewsCount();
    }

    @Override // android.widget.ListView, com.baidu.live.adp.widget.listview.IListView
    public int getFooterViewsCount() {
        return this.mBdListAdpter.getFooterViewsCount();
    }

    @Override // com.baidu.live.adp.widget.listview.IListView
    public int getContentViewsCount() {
        if (getWrappedAdapter() != null) {
            return getWrappedAdapter().getCount();
        }
        return 0;
    }

    @Override // com.baidu.live.adp.widget.listview.IListView
    public void smoothScrollToPosition(int i, int i2, int i3) {
        smoothScrollToPositionFromTop(i, i2, i3);
    }

    public void addPullRefreshView(View view) {
        this.mBdListAdpter.addHeaderView(view, null, false, 0);
    }

    @Override // android.widget.ListView, com.baidu.live.adp.widget.listview.IListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.mBdListAdpter.addFooterView(view, obj, z, -1);
    }

    @Override // android.widget.ListView, com.baidu.live.adp.widget.listview.IListView
    public void addFooterView(View view) {
        this.mBdListAdpter.addFooterView(view);
    }

    @Override // android.widget.ListView, com.baidu.live.adp.widget.listview.IListView
    public boolean removeHeaderView(View view) {
        return this.mBdListAdpter.removeHeader(view);
    }

    @Override // android.widget.ListView, com.baidu.live.adp.widget.listview.IListView
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

    public void setPrePage(BdIListPage bdIListPage) {
        if (this.mPrePage != null) {
            removeHeaderView(this.mPrePage.getView());
            this.mPrePage = null;
        }
        if (bdIListPage != null) {
            addHeaderView(bdIListPage.getView());
            this.mPrePage = bdIListPage;
        }
    }

    @Override // android.widget.AbsListView
    public void setSelectionFromTop(int i, int i2) {
        super.setSelectionFromTop(i, i2);
    }

    public void setNextPage(BdIListPage bdIListPage) {
        if (this.mNextPage != null) {
            removeFooterView(this.mNextPage.getView());
            this.mNextPage = null;
        }
        if (bdIListPage != null) {
            this.mBdListAdpter.addFooterView(bdIListPage.getView(), null, true, 0);
            this.mNextPage = bdIListPage;
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
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public void setKybdsScrollBottom(boolean z) {
        this.mKeybordScrollBottom = z;
    }

    public void setOnkbdStateListener(OnKybdsChangeListener onKybdsChangeListener) {
        this.mOnKybdsChangeListener = onKybdsChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int lastVisiblePosition = getLastVisiblePosition();
        try {
            super.onLayout(z, i, i2, i3, i4);
            if (!this.mLayoutHasInit) {
                this.mLayoutHasInit = true;
                this.mMaxHeight = i4;
                if (this.mOnKybdsChangeListener != null) {
                    this.mOnKybdsChangeListener.onKeyBoardStateChange(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i4 ? i4 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i4 && i4 != this.mPreHeight) {
                this.mHasKeybord = true;
                if (this.mOnKybdsChangeListener != null) {
                    this.mOnKybdsChangeListener.onKeyBoardStateChange(-3);
                }
                if (this.mKeybordScrollBottom && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.mSelectRunnable, 1L);
                }
            }
            if (this.mLayoutHasInit && this.mHasKeybord && this.mMaxHeight == i4) {
                this.mHasKeybord = false;
                if (this.mOnKybdsChangeListener != null) {
                    this.mOnKybdsChangeListener.onKeyBoardStateChange(-2);
                }
            }
            this.mPreHeight = i4;
        } catch (Throwable th) {
            BdLog.e(th.getMessage());
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    public void setPullRefresh(BdIListPullView bdIListPullView) {
        if (this.mPullRefresh != null) {
            removeHeaderView(this.mPullRefresh.getBdIListPullView().getView());
        }
        this.mPullRefresh = null;
        if (bdIListPullView != null) {
            this.mPullRefresh = new PullRefresh(this, bdIListPullView);
            this.mPullRefresh.setOnScrollToPullListener(this.mOnScrollToPullListener);
        }
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
        SafeHandler.getInst().postDelayed(new Runnable() { // from class: com.baidu.live.adp.widget.listview.BdListView.11
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
        } catch (Exception e) {
            BdLog.e(e.getMessage());
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

    /* loaded from: classes11.dex */
    private static class PullRefresh {
        public static final int DEFAULT_REFRESH_DURATION_TIME = 800;
        private static final int DONE = 3;
        private static final int PULL_TO_REFRESH = 1;
        private static final int REFRESHING = 2;
        private static final int RELEASE_TO_REFRESH = 0;
        private static float sRatio = 3.0f;
        private BdIListPullView mBdIListPullView;
        private BdListView mListView;
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

        public PullRefresh(BdListView bdListView, BdIListPullView bdIListPullView) {
            this.mBdIListPullView = null;
            this.mListView = null;
            if (bdIListPullView == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.mBdIListPullView = bdIListPullView;
            this.mListView = bdListView;
            View view = this.mBdIListPullView.getView();
            view.setPadding(0, -this.mBdIListPullView.getHeadContentHeight(), 0, 0);
            view.invalidate();
            this.mListView.addPullRefreshView(view);
        }

        public BdIListPullView getBdIListPullView() {
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
                                if (((int) ((y - this.mStartY) / sRatio)) < BdUtilHelper.getDimens(this.mBdIListPullView.getContext(), R.dimen.sdk_adp_list_view_pull_maxoffset) && y - this.mStartY > 0) {
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
                                if (((int) ((y - this.mStartY) / sRatio)) >= BdUtilHelper.getDimens(this.mBdIListPullView.getContext(), R.dimen.sdk_adp_list_view_pull_maxoffset)) {
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
            BdIListPullView bdIListPullView = getBdIListPullView();
            if (bdIListPullView != null && (view = bdIListPullView.getView()) != null) {
                BdPaddingAnimation4ListView bdPaddingAnimation4ListView = new BdPaddingAnimation4ListView(view.getContext(), 0, -bdIListPullView.getHeadContentHeight(), this.mAnimDurationTime);
                bdPaddingAnimation4ListView.setOnAnimationOverListener(new BdOnAnimationOverListener() { // from class: com.baidu.live.adp.widget.listview.BdListView.PullRefresh.1
                    @Override // com.baidu.live.adp.widget.scrollview.BdOnAnimationOverListener
                    public void onOver() {
                        PullRefresh.this.done();
                    }
                });
                bdPaddingAnimation4ListView.startAnimation(view);
            }
        }
    }
}
