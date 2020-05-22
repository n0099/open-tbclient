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
import com.baidu.adp.widget.ListView.e;
import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class BdListView extends ListView implements q<BdListView> {
    private com.baidu.adp.widget.ListView.e TY;
    private b TZ;
    private a Ua;
    private d Ub;
    private g Uc;
    private h Ue;
    private e Uf;
    private f Ug;
    private com.baidu.adp.base.h Uh;
    private final r Ui;
    private c Uj;
    private i Uk;
    private Runnable mDelayedRunnable;
    private int mFirstVisibleItemIndex;
    private boolean mHasKeybord;
    private boolean mKeybordScrollBottom;
    private boolean mLayoutHasInit;
    private int mMaxHeight;
    private com.baidu.adp.widget.ListView.b mNextPage;
    private View mNoDataView;
    private AdapterView.OnItemClickListener mOnItemClickListener;
    private AdapterView.OnItemLongClickListener mOnItemLongClickListener;
    private AdapterView.OnItemSelectedListener mOnItemSelectedListener;
    private AbsListView.OnScrollListener mOnScrollListener;
    private long mOnScrollStopDelayedMillis;
    private int mPreHeight;
    private com.baidu.adp.widget.ListView.b mPrePage;
    private int mScrollToTopNum;
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
        void onKeyBoardStateChange(int i);
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
        void v(BdListView bdListView);
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
        this.Uh = hVar;
    }

    public r getPreLoadHandle() {
        return this.Ui;
    }

    public BdListView(Context context) {
        super(context);
        this.TY = null;
        this.mOnItemClickListener = null;
        this.mOnItemLongClickListener = null;
        this.mOnItemSelectedListener = null;
        this.TZ = null;
        this.Ua = null;
        this.mOnScrollListener = null;
        this.Ub = null;
        this.Uc = null;
        this.mOnScrollStopDelayedMillis = 100L;
        this.Ue = null;
        this.mScrollToTopNum = 0;
        this.Uf = null;
        this.Ug = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.Uh = null;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.1
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 0;
                int i3 = -1;
                if (BdListView.this.Ub != null) {
                    int firstVisiblePosition = BdListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdListView.this.getLastVisiblePosition();
                    if (BdListView.this.TY == null || BdListView.this.TY.getWrappedAdapter() == null || BdListView.this.TY.getWrappedCount() <= 0) {
                        i2 = -1;
                    } else {
                        i3 = firstVisiblePosition - BdListView.this.TY.getHeadersCount();
                        if (i3 < 0) {
                            i3 = 0;
                        }
                        int headersCount = lastVisiblePosition - BdListView.this.TY.getHeadersCount();
                        if (headersCount >= BdListView.this.TY.getWrappedCount()) {
                            headersCount = BdListView.this.TY.getWrappedCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i2 = headersCount;
                        }
                    }
                    BdListView.this.Ub.onScrollStop(i3, i2);
                }
            }
        };
        this.Ui = new r() { // from class: com.baidu.adp.widget.ListView.BdListView.4
            @Override // com.baidu.adp.widget.ListView.r
            public p getAdapter() {
                return BdListView.this.getAdapter2();
            }

            @Override // com.baidu.adp.widget.ListView.r
            public int getFirstVisiblePosition() {
                return BdListView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.r
            public int getLastVisiblePosition() {
                return BdListView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.r
            public void cancelRefresh() {
                BdListView.this.removeCallbacks(BdListView.this.refreshRunnable);
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h E;
                int childCount = BdListView.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    refreshImage(BdListView.this.getChildAt(i2));
                }
                if (BdListView.this.Uh != null) {
                    E = BdListView.this.Uh;
                } else {
                    E = com.baidu.adp.base.i.E(BdListView.this.getContext());
                }
                if (E != null) {
                    E.onPreLoad(BdListView.this.Ui);
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
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.6
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h E;
                if (BdListView.this.Uh != null) {
                    E = BdListView.this.Uh;
                } else {
                    E = com.baidu.adp.base.i.E(BdListView.this.getContext());
                }
                if (E != null) {
                    E.onPreLoad(BdListView.this.Ui);
                }
            }
        };
        this.mLayoutHasInit = false;
        this.mHasKeybord = false;
        this.mKeybordScrollBottom = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.Uj = null;
        this.mSelectRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.2
            @Override // java.lang.Runnable
            public void run() {
                BdListView.this.setSelection(BdListView.this.getCount() - 1);
            }
        };
        this.Uk = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TY = null;
        this.mOnItemClickListener = null;
        this.mOnItemLongClickListener = null;
        this.mOnItemSelectedListener = null;
        this.TZ = null;
        this.Ua = null;
        this.mOnScrollListener = null;
        this.Ub = null;
        this.Uc = null;
        this.mOnScrollStopDelayedMillis = 100L;
        this.Ue = null;
        this.mScrollToTopNum = 0;
        this.Uf = null;
        this.Ug = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.Uh = null;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.1
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 0;
                int i3 = -1;
                if (BdListView.this.Ub != null) {
                    int firstVisiblePosition = BdListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdListView.this.getLastVisiblePosition();
                    if (BdListView.this.TY == null || BdListView.this.TY.getWrappedAdapter() == null || BdListView.this.TY.getWrappedCount() <= 0) {
                        i2 = -1;
                    } else {
                        i3 = firstVisiblePosition - BdListView.this.TY.getHeadersCount();
                        if (i3 < 0) {
                            i3 = 0;
                        }
                        int headersCount = lastVisiblePosition - BdListView.this.TY.getHeadersCount();
                        if (headersCount >= BdListView.this.TY.getWrappedCount()) {
                            headersCount = BdListView.this.TY.getWrappedCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i2 = headersCount;
                        }
                    }
                    BdListView.this.Ub.onScrollStop(i3, i2);
                }
            }
        };
        this.Ui = new r() { // from class: com.baidu.adp.widget.ListView.BdListView.4
            @Override // com.baidu.adp.widget.ListView.r
            public p getAdapter() {
                return BdListView.this.getAdapter2();
            }

            @Override // com.baidu.adp.widget.ListView.r
            public int getFirstVisiblePosition() {
                return BdListView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.r
            public int getLastVisiblePosition() {
                return BdListView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.r
            public void cancelRefresh() {
                BdListView.this.removeCallbacks(BdListView.this.refreshRunnable);
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h E;
                int childCount = BdListView.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    refreshImage(BdListView.this.getChildAt(i2));
                }
                if (BdListView.this.Uh != null) {
                    E = BdListView.this.Uh;
                } else {
                    E = com.baidu.adp.base.i.E(BdListView.this.getContext());
                }
                if (E != null) {
                    E.onPreLoad(BdListView.this.Ui);
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
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.6
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h E;
                if (BdListView.this.Uh != null) {
                    E = BdListView.this.Uh;
                } else {
                    E = com.baidu.adp.base.i.E(BdListView.this.getContext());
                }
                if (E != null) {
                    E.onPreLoad(BdListView.this.Ui);
                }
            }
        };
        this.mLayoutHasInit = false;
        this.mHasKeybord = false;
        this.mKeybordScrollBottom = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.Uj = null;
        this.mSelectRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.2
            @Override // java.lang.Runnable
            public void run() {
                BdListView.this.setSelection(BdListView.this.getCount() - 1);
            }
        };
        this.Uk = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.TY = null;
        this.mOnItemClickListener = null;
        this.mOnItemLongClickListener = null;
        this.mOnItemSelectedListener = null;
        this.TZ = null;
        this.Ua = null;
        this.mOnScrollListener = null;
        this.Ub = null;
        this.Uc = null;
        this.mOnScrollStopDelayedMillis = 100L;
        this.Ue = null;
        this.mScrollToTopNum = 0;
        this.Uf = null;
        this.Ug = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.Uh = null;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.1
            @Override // java.lang.Runnable
            public void run() {
                int i22 = 0;
                int i3 = -1;
                if (BdListView.this.Ub != null) {
                    int firstVisiblePosition = BdListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdListView.this.getLastVisiblePosition();
                    if (BdListView.this.TY == null || BdListView.this.TY.getWrappedAdapter() == null || BdListView.this.TY.getWrappedCount() <= 0) {
                        i22 = -1;
                    } else {
                        i3 = firstVisiblePosition - BdListView.this.TY.getHeadersCount();
                        if (i3 < 0) {
                            i3 = 0;
                        }
                        int headersCount = lastVisiblePosition - BdListView.this.TY.getHeadersCount();
                        if (headersCount >= BdListView.this.TY.getWrappedCount()) {
                            headersCount = BdListView.this.TY.getWrappedCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i22 = headersCount;
                        }
                    }
                    BdListView.this.Ub.onScrollStop(i3, i22);
                }
            }
        };
        this.Ui = new r() { // from class: com.baidu.adp.widget.ListView.BdListView.4
            @Override // com.baidu.adp.widget.ListView.r
            public p getAdapter() {
                return BdListView.this.getAdapter2();
            }

            @Override // com.baidu.adp.widget.ListView.r
            public int getFirstVisiblePosition() {
                return BdListView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.r
            public int getLastVisiblePosition() {
                return BdListView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.r
            public void cancelRefresh() {
                BdListView.this.removeCallbacks(BdListView.this.refreshRunnable);
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h E;
                int childCount = BdListView.this.getChildCount();
                for (int i22 = 0; i22 < childCount; i22++) {
                    refreshImage(BdListView.this.getChildAt(i22));
                }
                if (BdListView.this.Uh != null) {
                    E = BdListView.this.Uh;
                } else {
                    E = com.baidu.adp.base.i.E(BdListView.this.getContext());
                }
                if (E != null) {
                    E.onPreLoad(BdListView.this.Ui);
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
                        for (int i22 = 0; i22 < childCount; i22++) {
                            refreshImage(viewGroup.getChildAt(i22));
                        }
                    }
                }
            }
        };
        this.preLoadRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.6
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h E;
                if (BdListView.this.Uh != null) {
                    E = BdListView.this.Uh;
                } else {
                    E = com.baidu.adp.base.i.E(BdListView.this.getContext());
                }
                if (E != null) {
                    E.onPreLoad(BdListView.this.Ui);
                }
            }
        };
        this.mLayoutHasInit = false;
        this.mHasKeybord = false;
        this.mKeybordScrollBottom = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.Uj = null;
        this.mSelectRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.2
            @Override // java.lang.Runnable
            public void run() {
                BdListView.this.setSelection(BdListView.this.getCount() - 1);
            }
        };
        this.Uk = null;
        initial();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.ListView, android.widget.AbsListView
    public void layoutChildren() {
        try {
            super.layoutChildren();
        } catch (NullPointerException e2) {
            BdLog.detailException(e2);
            if (getContext() instanceof Activity) {
                ((Activity) getContext()).finish();
            }
        }
    }

    private void initial() {
        setFadingEdgeLength(0);
        this.TY = new com.baidu.adp.widget.ListView.e(getContext());
        this.TY.setListPreLoad(new e.a() { // from class: com.baidu.adp.widget.ListView.BdListView.7
            @Override // com.baidu.adp.widget.ListView.e.a
            public void onPreLoad() {
                BdListView.this.removeCallbacks(BdListView.this.preLoadRunnable);
                BdListView.this.postDelayed(BdListView.this.preLoadRunnable, 100L);
            }
        });
        super.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.adp.widget.ListView.BdListView.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                int headersCount = BdListView.this.TY.getHeadersCount();
                if (i2 < headersCount) {
                    if (BdListView.this.mPrePage == null || view != BdListView.this.mPrePage.getView()) {
                        if (BdListView.this.TZ != null) {
                            BdListView.this.TZ.onClick(view);
                            return;
                        }
                        return;
                    }
                    BdListView.this.mPrePage.onClick();
                    return;
                }
                int i3 = i2 - headersCount;
                ListAdapter wrappedAdapter = BdListView.this.TY.getWrappedAdapter();
                if (wrappedAdapter == null || i3 >= wrappedAdapter.getCount()) {
                    if (BdListView.this.mNextPage == null || view != BdListView.this.mNextPage.getView()) {
                        if (BdListView.this.Ua != null) {
                            BdListView.this.Ua.onClick(view);
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
        super.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.baidu.adp.widget.ListView.BdListView.9
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i2) {
                com.baidu.adp.base.h E;
                if (BdListView.this.Uh != null) {
                    E = BdListView.this.Uh;
                } else {
                    E = com.baidu.adp.base.i.E(BdListView.this.getContext());
                }
                if (E != null) {
                    if (i2 == 2) {
                        BdListView.this.removeCallbacks(BdListView.this.refreshRunnable);
                        E.setIsScroll(true);
                    } else if (E.isScroll()) {
                        E.setIsScroll(false);
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
                    if (BdListView.this.Uf != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                        BdListView.this.Uf.onScrollToBottom();
                    }
                    if (BdListView.this.Ug != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                        BdListView.this.Ug.v(BdListView.this);
                    }
                    if (BdListView.this.Ue != null && absListView.getFirstVisiblePosition() <= BdListView.this.mScrollToTopNum) {
                        BdListView.this.Ue.onScrollToTop();
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                BdListView.this.mFirstVisibleItemIndex = i2;
                if (BdListView.this.mOnScrollListener != null) {
                    BdListView.this.mOnScrollListener.onScroll(absListView, i2, i3, i4);
                }
                if (BdListView.this.Ub != null && BdListView.this.mOnScrollStopDelayedMillis > 0) {
                    BdListView.this.getHandler().removeCallbacks(BdListView.this.mDelayedRunnable);
                    BdListView.this.getHandler().postDelayed(BdListView.this.mDelayedRunnable, BdListView.this.mOnScrollStopDelayedMillis);
                }
            }
        });
    }

    public void setOnScrollToPullListener(g gVar) {
        this.Uc = gVar;
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
        this.Ue = hVar;
    }

    public void setOnSrollToTopListener(h hVar, int i2) {
        this.Ue = hVar;
        int i3 = i2 - 1;
        if (i3 < 0) {
            i3 = 0;
        }
        this.mScrollToTopNum = i3;
    }

    public void setOnSrollToBottomListener(e eVar) {
        this.Uf = eVar;
    }

    public void setExOnSrollToBottomListener(f fVar) {
        this.Ug = fVar;
    }

    public void setOnScrollStopDelayedListener(d dVar, long j) {
        this.Ub = dVar;
        this.mOnScrollStopDelayedMillis = j;
    }

    @Override // android.widget.AdapterView
    public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener onItemLongClickListener) {
        if (onItemLongClickListener == null) {
            super.setOnItemLongClickListener(null);
            return;
        }
        this.mOnItemLongClickListener = onItemLongClickListener;
        super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.baidu.adp.widget.ListView.BdListView.10
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j) {
                int headersCount = BdListView.this.TY.getHeadersCount();
                if (i2 < headersCount) {
                    return true;
                }
                int i3 = i2 - headersCount;
                ListAdapter wrappedAdapter = BdListView.this.TY.getWrappedAdapter();
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
        super.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.baidu.adp.widget.ListView.BdListView.11
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j) {
                int headersCount = BdListView.this.TY.getHeadersCount();
                if (i2 >= headersCount) {
                    int i3 = i2 - headersCount;
                    ListAdapter wrappedAdapter = BdListView.this.TY.getWrappedAdapter();
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
    /* JADX DEBUG: Return type fixed from 'com.baidu.adp.widget.ListView.e' to match base method */
    @Override // android.widget.ListView, android.widget.AdapterView
    /* renamed from: getAdapter */
    public ListAdapter getAdapter2() {
        return this.TY;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.TY instanceof com.baidu.adp.widget.ListView.e) {
            return this.TY.getWrappedAdapter();
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.q
    public BdListView getListView() {
        return this;
    }

    public p getListAdapter() {
        return getAdapter2();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.TY.setAdaper(listAdapter);
        super.setAdapter((ListAdapter) this.TY);
    }

    public void setOnHeaderClickListener(b bVar) {
        this.TZ = bVar;
    }

    public void setOnFooterClickListener(a aVar) {
        this.Ua = aVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.TY.addHeaderView(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.TY.addHeaderView(view, getHeaderIndex());
    }

    public void addHeaderView(View view, int i2) {
        this.TY.addHeaderView(view, i2);
    }

    @Override // android.widget.ListView, com.baidu.adp.widget.ListView.q
    public int getHeaderViewsCount() {
        return this.TY.getHeaderViewsCount();
    }

    @Override // android.widget.ListView, com.baidu.adp.widget.ListView.q
    public int getFooterViewsCount() {
        return this.TY.getFooterViewsCount();
    }

    @Override // com.baidu.adp.widget.ListView.q
    public int getContentViewsCount() {
        if (getWrappedAdapter() != null) {
            return getWrappedAdapter().getCount();
        }
        return 0;
    }

    public void smoothScrollToPosition(int i2, int i3, int i4) {
        smoothScrollToPositionFromTop(i2, i3, i4);
    }

    public void addPullRefreshView(View view) {
        this.TY.addHeaderView(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.TY.addFooterView(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.TY.addFooterView(view);
    }

    @Override // android.widget.ListView, com.baidu.adp.widget.ListView.q
    public boolean removeHeaderView(View view) {
        return this.TY.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.TY.removeFooter(view);
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
            this.TY.addFooterView(bVar.getView(), null, true, 0);
            this.mNextPage = bVar;
        }
    }

    private int getHeaderIndex() {
        if (this.mPrePage != null) {
            return this.TY.getHeadersCount() - 1;
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
        this.Uj = cVar;
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
                if (this.Uj != null) {
                    this.Uj.onKeyBoardStateChange(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.mHasKeybord = true;
                if (this.Uj != null) {
                    this.Uj.onKeyBoardStateChange(-3);
                }
                if (this.mKeybordScrollBottom && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.mSelectRunnable, 1L);
                }
            }
            if (this.mLayoutHasInit && this.mHasKeybord && this.mMaxHeight == i5) {
                this.mHasKeybord = false;
                if (this.Uj != null) {
                    this.Uj.onKeyBoardStateChange(-2);
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
        if (this.Uk != null) {
            removeHeaderView(this.Uk.getBdIListPullView().getView());
        }
        this.Uk = null;
        if (cVar != null) {
            this.Uk = new i(this, cVar);
            this.Uk.setOnScrollToPullListener(this.Uc);
        }
    }

    public void completePullRefresh() {
        if (this.Uk != null) {
            if (this.Uk.getBdIListPullView() != null) {
                this.Uk.mBdIListPullView.onCompletePullRefresh();
            }
            this.Uk.animatePullView();
        }
    }

    public void completePullRefreshPostDelayed(long j) {
        if (this.Uk != null && this.Uk.getBdIListPullView() != null) {
            this.Uk.mBdIListPullView.onCompletePullRefresh();
        }
        com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (BdListView.this.Uk == null) {
                    return;
                }
                BdListView.this.Uk.animatePullView();
            }
        }, j);
    }

    public void startPullRefresh() {
        if (this.Uk != null) {
            setSelection(0);
            this.Uk.startPullRefresh(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.Uk != null) {
            this.Uk.onInterceptTouchEvent(motionEvent, this.mFirstVisibleItemIndex);
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
        if (this.Uk != null) {
            this.Uk.onTouchEvent(motionEvent, this.mFirstVisibleItemIndex);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean isRefreshDone() {
        return this.Uk == null || this.Uk.mState == 3;
    }

    /* loaded from: classes.dex */
    private static class i {
        private static float sRatio = 3.0f;
        private BdListView Um;
        private com.baidu.adp.widget.ListView.c mBdIListPullView;
        private boolean mIsRecored = false;
        private int mStartY = 0;
        protected int mState = 3;
        private Boolean mIsBack = false;
        private g Uc = null;
        private int mAnimDurationTime = 800;

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.c cVar) {
            this.mBdIListPullView = null;
            this.Um = null;
            if (cVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.mBdIListPullView = cVar;
            this.Um = bdListView;
            View view = this.mBdIListPullView.getView();
            view.setPadding(0, -this.mBdIListPullView.getHeadContentHeight(), 0, 0);
            view.invalidate();
            this.Um.addPullRefreshView(view);
        }

        public com.baidu.adp.widget.ListView.c getBdIListPullView() {
            return this.mBdIListPullView;
        }

        public void done() {
            this.mState = 3;
            this.mBdIListPullView.setPadding(0, -this.mBdIListPullView.getHeadContentHeight(), 0, 0);
            this.mBdIListPullView.done(true);
            if (this.Uc != null) {
                this.Uc.onScrollToPull(false);
            }
        }

        public void startPullRefresh(boolean z) {
            this.mState = 2;
            this.mBdIListPullView.setPadding(0, 0, 0, 0);
            this.mBdIListPullView.refreshing();
            this.mBdIListPullView.onRefresh(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.Uc = gVar;
        }

        public void onInterceptTouchEvent(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && getBdIListPullView().isEnable()) {
                this.mIsRecored = false;
                this.mIsBack = false;
                if (i == 0 && !this.mIsRecored && this.Um.getChildAt(0) != null && this.Um.getChildAt(0).getTop() >= 0) {
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
                                if (this.Uc != null) {
                                    this.Uc.onScrollToPull(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                startPullRefresh(false);
                                if (this.Uc != null) {
                                    this.Uc.onScrollToPull(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.Uc != null) {
                                this.Uc.onScrollToPull(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.mIsRecored && i == 0 && this.Um.getChildAt(0) != null && this.Um.getChildAt(0).getTop() >= 0) {
                            this.mIsRecored = true;
                            this.mStartY = y;
                        }
                        if (this.mState != 2 && this.mIsRecored) {
                            if (this.mState == 0) {
                                this.Um.setSelection(0);
                                if (((int) ((y - this.mStartY) / sRatio)) < com.baidu.adp.lib.util.l.getDimens(this.mBdIListPullView.getContext(), R.dimen.adp_list_view_pull_maxoffset) && y - this.mStartY > 0) {
                                    this.mState = 1;
                                    this.mBdIListPullView.pullToRefresh(this.mIsBack.booleanValue());
                                    this.mIsBack = false;
                                    if (this.Uc != null) {
                                        this.Uc.onScrollToPull(true);
                                    }
                                } else if (y - this.mStartY <= 0) {
                                    this.mState = 3;
                                    this.mBdIListPullView.setPadding(0, -this.mBdIListPullView.getHeadContentHeight(), 0, 0);
                                    this.mBdIListPullView.done(false);
                                    if (this.Uc != null) {
                                        this.Uc.onScrollToPull(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.Um.setSelection(0);
                                if (((int) ((y - this.mStartY) / sRatio)) >= com.baidu.adp.lib.util.l.getDimens(this.mBdIListPullView.getContext(), R.dimen.adp_list_view_pull_maxoffset)) {
                                    this.mState = 0;
                                    this.mIsBack = true;
                                    this.mBdIListPullView.releaseToRefresh();
                                    if (this.Uc != null) {
                                        this.Uc.onScrollToPull(true);
                                    }
                                } else if (y - this.mStartY <= 0) {
                                    this.mState = 3;
                                    this.mBdIListPullView.setPadding(0, -this.mBdIListPullView.getHeadContentHeight(), 0, 0);
                                    this.mBdIListPullView.done(false);
                                    if (this.Uc != null) {
                                        this.Uc.onScrollToPull(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.mStartY > 0) {
                                    this.mState = 1;
                                    this.mBdIListPullView.pullToRefresh(this.mIsBack.booleanValue());
                                    this.mIsBack = false;
                                    if (this.Uc != null) {
                                        this.Uc.onScrollToPull(true);
                                    }
                                } else if (this.Uc != null) {
                                    this.Uc.onScrollToPull(false);
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
            com.baidu.adp.widget.ListView.c bdIListPullView = getBdIListPullView();
            if (bdIListPullView != null && (view = bdIListPullView.getView()) != null) {
                com.baidu.adp.widget.ListView.f fVar = new com.baidu.adp.widget.ListView.f(view.getContext(), 0, -bdIListPullView.getHeadContentHeight(), this.mAnimDurationTime);
                fVar.a(new com.baidu.adp.widget.b.a() { // from class: com.baidu.adp.widget.ListView.BdListView.i.1
                    @Override // com.baidu.adp.widget.b.a
                    public void onOver() {
                        i.this.done();
                    }
                });
                fVar.a(bdIListPullView.TS);
                fVar.startAnimation(view);
            }
        }
    }
}
