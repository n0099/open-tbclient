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
public class BdListView extends ListView implements o<BdListView> {
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
    private a xA;
    private d xB;
    private g xC;
    private h xD;
    private e xE;
    private f xF;
    private com.baidu.adp.base.h xG;
    private final p xH;
    private c xI;
    private i xJ;
    private com.baidu.adp.widget.ListView.e xy;
    private b xz;

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
        this.xG = hVar;
    }

    public p getPreLoadHandle() {
        return this.xH;
    }

    public BdListView(Context context) {
        super(context);
        this.xy = null;
        this.mOnItemClickListener = null;
        this.mOnItemLongClickListener = null;
        this.mOnItemSelectedListener = null;
        this.xz = null;
        this.xA = null;
        this.mOnScrollListener = null;
        this.xB = null;
        this.xC = null;
        this.mOnScrollStopDelayedMillis = 100L;
        this.xD = null;
        this.mScrollToTopNum = 0;
        this.xE = null;
        this.xF = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.xG = null;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.1
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 0;
                int i3 = -1;
                if (BdListView.this.xB != null) {
                    int firstVisiblePosition = BdListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdListView.this.getLastVisiblePosition();
                    if (BdListView.this.xy == null || BdListView.this.xy.getWrappedAdapter() == null || BdListView.this.xy.getWrappedCount() <= 0) {
                        i2 = -1;
                    } else {
                        i3 = firstVisiblePosition - BdListView.this.xy.getHeadersCount();
                        if (i3 < 0) {
                            i3 = 0;
                        }
                        int headersCount = lastVisiblePosition - BdListView.this.xy.getHeadersCount();
                        if (headersCount >= BdListView.this.xy.getWrappedCount()) {
                            headersCount = BdListView.this.xy.getWrappedCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i2 = headersCount;
                        }
                    }
                    BdListView.this.xB.onScrollStop(i3, i2);
                }
            }
        };
        this.xH = new p() { // from class: com.baidu.adp.widget.ListView.BdListView.4
            @Override // com.baidu.adp.widget.ListView.p
            public n getAdapter() {
                return BdListView.this.getAdapter2();
            }

            @Override // com.baidu.adp.widget.ListView.p
            public int getFirstVisiblePosition() {
                return BdListView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.p
            public int getLastVisiblePosition() {
                return BdListView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.p
            public void cancelRefresh() {
                BdListView.this.removeCallbacks(BdListView.this.refreshRunnable);
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h Z;
                int childCount = BdListView.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    refreshImage(BdListView.this.getChildAt(i2));
                }
                if (BdListView.this.xG != null) {
                    Z = BdListView.this.xG;
                } else {
                    Z = com.baidu.adp.base.i.Z(BdListView.this.getContext());
                }
                if (Z != null) {
                    Z.onPreLoad(BdListView.this.xH);
                }
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.newwidget.ImageView.h) {
                        ((com.baidu.adp.newwidget.ImageView.h) view).refresh();
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
                com.baidu.adp.base.h Z;
                if (BdListView.this.xG != null) {
                    Z = BdListView.this.xG;
                } else {
                    Z = com.baidu.adp.base.i.Z(BdListView.this.getContext());
                }
                if (Z != null) {
                    Z.onPreLoad(BdListView.this.xH);
                }
            }
        };
        this.mLayoutHasInit = false;
        this.mHasKeybord = false;
        this.mKeybordScrollBottom = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.xI = null;
        this.mSelectRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.2
            @Override // java.lang.Runnable
            public void run() {
                BdListView.this.setSelection(BdListView.this.getCount() - 1);
            }
        };
        this.xJ = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.xy = null;
        this.mOnItemClickListener = null;
        this.mOnItemLongClickListener = null;
        this.mOnItemSelectedListener = null;
        this.xz = null;
        this.xA = null;
        this.mOnScrollListener = null;
        this.xB = null;
        this.xC = null;
        this.mOnScrollStopDelayedMillis = 100L;
        this.xD = null;
        this.mScrollToTopNum = 0;
        this.xE = null;
        this.xF = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.xG = null;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.1
            @Override // java.lang.Runnable
            public void run() {
                int i2 = 0;
                int i3 = -1;
                if (BdListView.this.xB != null) {
                    int firstVisiblePosition = BdListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdListView.this.getLastVisiblePosition();
                    if (BdListView.this.xy == null || BdListView.this.xy.getWrappedAdapter() == null || BdListView.this.xy.getWrappedCount() <= 0) {
                        i2 = -1;
                    } else {
                        i3 = firstVisiblePosition - BdListView.this.xy.getHeadersCount();
                        if (i3 < 0) {
                            i3 = 0;
                        }
                        int headersCount = lastVisiblePosition - BdListView.this.xy.getHeadersCount();
                        if (headersCount >= BdListView.this.xy.getWrappedCount()) {
                            headersCount = BdListView.this.xy.getWrappedCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i2 = headersCount;
                        }
                    }
                    BdListView.this.xB.onScrollStop(i3, i2);
                }
            }
        };
        this.xH = new p() { // from class: com.baidu.adp.widget.ListView.BdListView.4
            @Override // com.baidu.adp.widget.ListView.p
            public n getAdapter() {
                return BdListView.this.getAdapter2();
            }

            @Override // com.baidu.adp.widget.ListView.p
            public int getFirstVisiblePosition() {
                return BdListView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.p
            public int getLastVisiblePosition() {
                return BdListView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.p
            public void cancelRefresh() {
                BdListView.this.removeCallbacks(BdListView.this.refreshRunnable);
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h Z;
                int childCount = BdListView.this.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    refreshImage(BdListView.this.getChildAt(i2));
                }
                if (BdListView.this.xG != null) {
                    Z = BdListView.this.xG;
                } else {
                    Z = com.baidu.adp.base.i.Z(BdListView.this.getContext());
                }
                if (Z != null) {
                    Z.onPreLoad(BdListView.this.xH);
                }
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.newwidget.ImageView.h) {
                        ((com.baidu.adp.newwidget.ImageView.h) view).refresh();
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
                com.baidu.adp.base.h Z;
                if (BdListView.this.xG != null) {
                    Z = BdListView.this.xG;
                } else {
                    Z = com.baidu.adp.base.i.Z(BdListView.this.getContext());
                }
                if (Z != null) {
                    Z.onPreLoad(BdListView.this.xH);
                }
            }
        };
        this.mLayoutHasInit = false;
        this.mHasKeybord = false;
        this.mKeybordScrollBottom = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.xI = null;
        this.mSelectRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.2
            @Override // java.lang.Runnable
            public void run() {
                BdListView.this.setSelection(BdListView.this.getCount() - 1);
            }
        };
        this.xJ = null;
        initial();
    }

    public BdListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.xy = null;
        this.mOnItemClickListener = null;
        this.mOnItemLongClickListener = null;
        this.mOnItemSelectedListener = null;
        this.xz = null;
        this.xA = null;
        this.mOnScrollListener = null;
        this.xB = null;
        this.xC = null;
        this.mOnScrollStopDelayedMillis = 100L;
        this.xD = null;
        this.mScrollToTopNum = 0;
        this.xE = null;
        this.xF = null;
        this.mPrePage = null;
        this.mNextPage = null;
        this.mNoDataView = null;
        this.mFirstVisibleItemIndex = 0;
        this.xG = null;
        this.mDelayedRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.1
            @Override // java.lang.Runnable
            public void run() {
                int i22 = 0;
                int i3 = -1;
                if (BdListView.this.xB != null) {
                    int firstVisiblePosition = BdListView.this.getFirstVisiblePosition();
                    int lastVisiblePosition = BdListView.this.getLastVisiblePosition();
                    if (BdListView.this.xy == null || BdListView.this.xy.getWrappedAdapter() == null || BdListView.this.xy.getWrappedCount() <= 0) {
                        i22 = -1;
                    } else {
                        i3 = firstVisiblePosition - BdListView.this.xy.getHeadersCount();
                        if (i3 < 0) {
                            i3 = 0;
                        }
                        int headersCount = lastVisiblePosition - BdListView.this.xy.getHeadersCount();
                        if (headersCount >= BdListView.this.xy.getWrappedCount()) {
                            headersCount = BdListView.this.xy.getWrappedCount() - 1;
                        }
                        if (headersCount >= 0) {
                            i22 = headersCount;
                        }
                    }
                    BdListView.this.xB.onScrollStop(i3, i22);
                }
            }
        };
        this.xH = new p() { // from class: com.baidu.adp.widget.ListView.BdListView.4
            @Override // com.baidu.adp.widget.ListView.p
            public n getAdapter() {
                return BdListView.this.getAdapter2();
            }

            @Override // com.baidu.adp.widget.ListView.p
            public int getFirstVisiblePosition() {
                return BdListView.this.getFirstVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.p
            public int getLastVisiblePosition() {
                return BdListView.this.getLastVisiblePosition();
            }

            @Override // com.baidu.adp.widget.ListView.p
            public void cancelRefresh() {
                BdListView.this.removeCallbacks(BdListView.this.refreshRunnable);
            }
        };
        this.refreshRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.adp.base.h Z;
                int childCount = BdListView.this.getChildCount();
                for (int i22 = 0; i22 < childCount; i22++) {
                    refreshImage(BdListView.this.getChildAt(i22));
                }
                if (BdListView.this.xG != null) {
                    Z = BdListView.this.xG;
                } else {
                    Z = com.baidu.adp.base.i.Z(BdListView.this.getContext());
                }
                if (Z != null) {
                    Z.onPreLoad(BdListView.this.xH);
                }
            }

            private void refreshImage(View view) {
                if (view != null) {
                    if (view instanceof com.baidu.adp.newwidget.ImageView.h) {
                        ((com.baidu.adp.newwidget.ImageView.h) view).refresh();
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
                com.baidu.adp.base.h Z;
                if (BdListView.this.xG != null) {
                    Z = BdListView.this.xG;
                } else {
                    Z = com.baidu.adp.base.i.Z(BdListView.this.getContext());
                }
                if (Z != null) {
                    Z.onPreLoad(BdListView.this.xH);
                }
            }
        };
        this.mLayoutHasInit = false;
        this.mHasKeybord = false;
        this.mKeybordScrollBottom = false;
        this.mMaxHeight = 0;
        this.mPreHeight = 0;
        this.xI = null;
        this.mSelectRunnable = new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.2
            @Override // java.lang.Runnable
            public void run() {
                BdListView.this.setSelection(BdListView.this.getCount() - 1);
            }
        };
        this.xJ = null;
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
        this.xy = new com.baidu.adp.widget.ListView.e(getContext());
        this.xy.setListPreLoad(new e.a() { // from class: com.baidu.adp.widget.ListView.BdListView.7
            @Override // com.baidu.adp.widget.ListView.e.a
            public void onPreLoad() {
                BdListView.this.removeCallbacks(BdListView.this.preLoadRunnable);
                BdListView.this.postDelayed(BdListView.this.preLoadRunnable, 100L);
            }
        });
        super.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.baidu.adp.widget.ListView.BdListView.8
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                int headersCount = BdListView.this.xy.getHeadersCount();
                if (i2 < headersCount) {
                    if (BdListView.this.mPrePage == null || view != BdListView.this.mPrePage.getView()) {
                        if (BdListView.this.xz != null) {
                            BdListView.this.xz.onClick(view);
                            return;
                        }
                        return;
                    }
                    BdListView.this.mPrePage.onClick();
                    return;
                }
                int i3 = i2 - headersCount;
                ListAdapter wrappedAdapter = BdListView.this.xy.getWrappedAdapter();
                if (wrappedAdapter == null || i3 >= wrappedAdapter.getCount()) {
                    if (BdListView.this.mNextPage == null || view != BdListView.this.mNextPage.getView()) {
                        if (BdListView.this.xA != null) {
                            BdListView.this.xA.onClick(view);
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
                com.baidu.adp.base.h Z;
                if (BdListView.this.xG != null) {
                    Z = BdListView.this.xG;
                } else {
                    Z = com.baidu.adp.base.i.Z(BdListView.this.getContext());
                }
                if (Z != null) {
                    if (i2 == 2) {
                        BdListView.this.removeCallbacks(BdListView.this.refreshRunnable);
                        Z.setIsScroll(true);
                    } else if (Z.isScroll()) {
                        Z.setIsScroll(false);
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
                    if (BdListView.this.xE != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                        BdListView.this.xE.onScrollToBottom();
                    }
                    if (BdListView.this.xF != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                        BdListView.this.xF.v(BdListView.this);
                    }
                    if (BdListView.this.xD != null && absListView.getFirstVisiblePosition() <= BdListView.this.mScrollToTopNum) {
                        BdListView.this.xD.onScrollToTop();
                    }
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
                BdListView.this.mFirstVisibleItemIndex = i2;
                if (BdListView.this.mOnScrollListener != null) {
                    BdListView.this.mOnScrollListener.onScroll(absListView, i2, i3, i4);
                }
                if (BdListView.this.xB != null && BdListView.this.mOnScrollStopDelayedMillis > 0) {
                    BdListView.this.getHandler().removeCallbacks(BdListView.this.mDelayedRunnable);
                    BdListView.this.getHandler().postDelayed(BdListView.this.mDelayedRunnable, BdListView.this.mOnScrollStopDelayedMillis);
                }
            }
        });
    }

    public void setOnScrollToPullListener(g gVar) {
        this.xC = gVar;
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
        this.xD = hVar;
    }

    public void setOnSrollToTopListener(h hVar, int i2) {
        this.xD = hVar;
        int i3 = i2 - 1;
        if (i3 < 0) {
            i3 = 0;
        }
        this.mScrollToTopNum = i3;
    }

    public void setOnSrollToBottomListener(e eVar) {
        this.xE = eVar;
    }

    public void setExOnSrollToBottomListener(f fVar) {
        this.xF = fVar;
    }

    public void setOnScrollStopDelayedListener(d dVar, long j) {
        this.xB = dVar;
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
                int headersCount = BdListView.this.xy.getHeadersCount();
                if (i2 < headersCount) {
                    return true;
                }
                int i3 = i2 - headersCount;
                ListAdapter wrappedAdapter = BdListView.this.xy.getWrappedAdapter();
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
                int headersCount = BdListView.this.xy.getHeadersCount();
                if (i2 >= headersCount) {
                    int i3 = i2 - headersCount;
                    ListAdapter wrappedAdapter = BdListView.this.xy.getWrappedAdapter();
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
        return this.xy;
    }

    public ListAdapter getWrappedAdapter() {
        if (this.xy instanceof com.baidu.adp.widget.ListView.e) {
            return this.xy.getWrappedAdapter();
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.widget.ListView.o
    public BdListView getListView() {
        return this;
    }

    public n getListAdapter() {
        return getAdapter2();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.AdapterView
    public void setAdapter(ListAdapter listAdapter) {
        super.setAdapter((ListAdapter) null);
        this.xy.setAdaper(listAdapter);
        super.setAdapter((ListAdapter) this.xy);
    }

    public void setOnHeaderClickListener(b bVar) {
        this.xz = bVar;
    }

    public void setOnFooterClickListener(a aVar) {
        this.xA = aVar;
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view, Object obj, boolean z) {
        this.xy.addHeaderView(view, obj, z, getHeaderIndex());
    }

    @Override // android.widget.ListView
    public void addHeaderView(View view) {
        this.xy.addHeaderView(view, getHeaderIndex());
    }

    public void addHeaderView(View view, int i2) {
        this.xy.addHeaderView(view, i2);
    }

    @Override // android.widget.ListView, com.baidu.adp.widget.ListView.o
    public int getHeaderViewsCount() {
        return this.xy.getHeaderViewsCount();
    }

    @Override // android.widget.ListView, com.baidu.adp.widget.ListView.o
    public int getFooterViewsCount() {
        return this.xy.getFooterViewsCount();
    }

    @Override // com.baidu.adp.widget.ListView.o
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
        this.xy.addHeaderView(view, null, false, 0);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view, Object obj, boolean z) {
        this.xy.addFooterView(view, obj, z, -1);
    }

    @Override // android.widget.ListView
    public void addFooterView(View view) {
        this.xy.addFooterView(view);
    }

    @Override // android.widget.ListView, com.baidu.adp.widget.ListView.o
    public boolean removeHeaderView(View view) {
        return this.xy.removeHeader(view);
    }

    @Override // android.widget.ListView
    public boolean removeFooterView(View view) {
        return this.xy.removeFooter(view);
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
            this.xy.addFooterView(bVar.getView(), null, true, 0);
            this.mNextPage = bVar;
        }
    }

    private int getHeaderIndex() {
        if (this.mPrePage != null) {
            return this.xy.getHeadersCount() - 1;
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
        this.xI = cVar;
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
                if (this.xI != null) {
                    this.xI.onKeyBoardStateChange(-1);
                }
            } else {
                this.mMaxHeight = this.mMaxHeight < i5 ? i5 : this.mMaxHeight;
            }
            if (this.mLayoutHasInit && this.mMaxHeight > i5 && i5 != this.mPreHeight) {
                this.mHasKeybord = true;
                if (this.xI != null) {
                    this.xI.onKeyBoardStateChange(-3);
                }
                if (this.mKeybordScrollBottom && lastVisiblePosition >= getCount() - 1) {
                    getHandler().postDelayed(this.mSelectRunnable, 1L);
                }
            }
            if (this.mLayoutHasInit && this.mHasKeybord && this.mMaxHeight == i5) {
                this.mHasKeybord = false;
                if (this.xI != null) {
                    this.xI.onKeyBoardStateChange(-2);
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
        if (this.xJ != null) {
            removeHeaderView(this.xJ.getBdIListPullView().getView());
        }
        this.xJ = null;
        if (cVar != null) {
            this.xJ = new i(this, cVar);
            this.xJ.setOnScrollToPullListener(this.xC);
        }
    }

    public void completePullRefresh() {
        if (this.xJ != null) {
            if (this.xJ.getBdIListPullView() != null) {
                this.xJ.mBdIListPullView.onCompletePullRefresh();
            }
            this.xJ.animatePullView();
        }
    }

    public void completePullRefreshPostDelayed(long j) {
        if (this.xJ != null && this.xJ.getBdIListPullView() != null) {
            this.xJ.mBdIListPullView.onCompletePullRefresh();
        }
        com.baidu.adp.lib.g.e.fZ().postDelayed(new Runnable() { // from class: com.baidu.adp.widget.ListView.BdListView.3
            @Override // java.lang.Runnable
            public void run() {
                if (BdListView.this.xJ == null) {
                    return;
                }
                BdListView.this.xJ.animatePullView();
            }
        }, j);
    }

    public void startPullRefresh() {
        if (this.xJ != null) {
            setSelection(0);
            this.xJ.startPullRefresh(true);
        }
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.xJ != null) {
            this.xJ.onInterceptTouchEvent(motionEvent, this.mFirstVisibleItemIndex);
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
        if (this.xJ != null) {
            this.xJ.onTouchEvent(motionEvent, this.mFirstVisibleItemIndex);
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
            return false;
        }
    }

    public boolean isRefreshDone() {
        return this.xJ == null || this.xJ.mState == 3;
    }

    /* loaded from: classes.dex */
    private static class i {
        private static float sRatio = 3.0f;
        private com.baidu.adp.widget.ListView.c mBdIListPullView;
        private BdListView xL;
        private boolean mIsRecored = false;
        private int mStartY = 0;
        protected int mState = 3;
        private Boolean mIsBack = false;
        private g xC = null;
        private int mAnimDurationTime = 800;

        public i(BdListView bdListView, com.baidu.adp.widget.ListView.c cVar) {
            this.mBdIListPullView = null;
            this.xL = null;
            if (cVar == null) {
                throw new InvalidParameterException("PullRefresh view is null");
            }
            if (bdListView == null) {
                throw new InvalidParameterException("PullRefresh listView is null");
            }
            this.mBdIListPullView = cVar;
            this.xL = bdListView;
            View view = this.mBdIListPullView.getView();
            view.setPadding(0, -this.mBdIListPullView.getHeadContentHeight(), 0, 0);
            view.invalidate();
            this.xL.addPullRefreshView(view);
        }

        public com.baidu.adp.widget.ListView.c getBdIListPullView() {
            return this.mBdIListPullView;
        }

        public void done() {
            this.mState = 3;
            this.mBdIListPullView.setPadding(0, -this.mBdIListPullView.getHeadContentHeight(), 0, 0);
            this.mBdIListPullView.done(true);
            if (this.xC != null) {
                this.xC.onScrollToPull(false);
            }
        }

        public void startPullRefresh(boolean z) {
            this.mState = 2;
            this.mBdIListPullView.setPadding(0, 0, 0, 0);
            this.mBdIListPullView.refreshing();
            this.mBdIListPullView.onRefresh(z);
        }

        public void setOnScrollToPullListener(g gVar) {
            this.xC = gVar;
        }

        public void onInterceptTouchEvent(MotionEvent motionEvent, int i) {
            if (motionEvent.getAction() == 0 && getBdIListPullView().isEnable()) {
                this.mIsRecored = false;
                this.mIsBack = false;
                if (i == 0 && !this.mIsRecored && this.xL.getChildAt(0) != null && this.xL.getChildAt(0).getTop() >= 0) {
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
                                if (this.xC != null) {
                                    this.xC.onScrollToPull(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 0) {
                                startPullRefresh(false);
                                if (this.xC != null) {
                                    this.xC.onScrollToPull(true);
                                    return;
                                }
                                return;
                            } else if (this.mState == 3 && this.xC != null) {
                                this.xC.onScrollToPull(false);
                                return;
                            } else {
                                return;
                            }
                        }
                        return;
                    case 2:
                        int y = (int) motionEvent.getY();
                        if (!this.mIsRecored && i == 0 && this.xL.getChildAt(0) != null && this.xL.getChildAt(0).getTop() >= 0) {
                            this.mIsRecored = true;
                            this.mStartY = y;
                        }
                        if (this.mState != 2 && this.mIsRecored) {
                            if (this.mState == 0) {
                                this.xL.setSelection(0);
                                if (((int) ((y - this.mStartY) / sRatio)) < com.baidu.adp.lib.util.l.getDimens(this.mBdIListPullView.getContext(), R.dimen.adp_list_view_pull_maxoffset) && y - this.mStartY > 0) {
                                    this.mState = 1;
                                    this.mBdIListPullView.pullToRefresh(this.mIsBack.booleanValue());
                                    this.mIsBack = false;
                                    if (this.xC != null) {
                                        this.xC.onScrollToPull(true);
                                    }
                                } else if (y - this.mStartY <= 0) {
                                    this.mState = 3;
                                    this.mBdIListPullView.setPadding(0, -this.mBdIListPullView.getHeadContentHeight(), 0, 0);
                                    this.mBdIListPullView.done(false);
                                    if (this.xC != null) {
                                        this.xC.onScrollToPull(true);
                                    }
                                }
                            } else if (this.mState == 1) {
                                this.xL.setSelection(0);
                                if (((int) ((y - this.mStartY) / sRatio)) >= com.baidu.adp.lib.util.l.getDimens(this.mBdIListPullView.getContext(), R.dimen.adp_list_view_pull_maxoffset)) {
                                    this.mState = 0;
                                    this.mIsBack = true;
                                    this.mBdIListPullView.releaseToRefresh();
                                    if (this.xC != null) {
                                        this.xC.onScrollToPull(true);
                                    }
                                } else if (y - this.mStartY <= 0) {
                                    this.mState = 3;
                                    this.mBdIListPullView.setPadding(0, -this.mBdIListPullView.getHeadContentHeight(), 0, 0);
                                    this.mBdIListPullView.done(false);
                                    if (this.xC != null) {
                                        this.xC.onScrollToPull(true);
                                    }
                                }
                            } else if (this.mState == 3) {
                                if (y - this.mStartY > 0) {
                                    this.mState = 1;
                                    this.mBdIListPullView.pullToRefresh(this.mIsBack.booleanValue());
                                    this.mIsBack = false;
                                    if (this.xC != null) {
                                        this.xC.onScrollToPull(true);
                                    }
                                } else if (this.xC != null) {
                                    this.xC.onScrollToPull(false);
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
                fVar.a(bdIListPullView.xs);
                fVar.startAnimation(view);
            }
        }
    }
}
