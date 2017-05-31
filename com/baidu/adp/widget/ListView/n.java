package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView Ib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.Ib = bdListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.adp.base.j jVar;
        com.baidu.adp.base.j X;
        AbsListView.OnScrollListener onScrollListener;
        BdListView.e eVar;
        BdListView.f fVar;
        BdListView.h hVar;
        int i2;
        BdListView.h hVar2;
        BdListView.f fVar2;
        BdListView.e eVar2;
        AbsListView.OnScrollListener onScrollListener2;
        Runnable runnable;
        Runnable runnable2;
        Runnable runnable3;
        Runnable runnable4;
        Runnable runnable5;
        jVar = this.Ib.mScrollable;
        if (jVar != null) {
            X = this.Ib.mScrollable;
        } else {
            X = com.baidu.adp.base.k.X(this.Ib.getContext());
        }
        if (X != null) {
            if (i == 2) {
                BdListView bdListView = this.Ib;
                runnable5 = this.Ib.refreshRunnable;
                bdListView.removeCallbacks(runnable5);
                X.setIsScroll(true);
            } else if (X.isScroll()) {
                X.setIsScroll(false);
                BdListView bdListView2 = this.Ib;
                runnable3 = this.Ib.refreshRunnable;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.Ib;
                runnable4 = this.Ib.refreshRunnable;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.Ib;
                runnable = this.Ib.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.Ib;
                runnable2 = this.Ib.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.Ib.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener2 = this.Ib.mOnScrollListener;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.Ib.mOnScrollToBottomListener;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.Ib.mOnScrollToBottomListener;
                eVar2.onScrollToBottom();
            }
            fVar = this.Ib.mExScrollToBottomListener;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.Ib.mExScrollToBottomListener;
                fVar2.a(this.Ib);
            }
            hVar = this.Ib.mOnScrollToTopListener;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.Ib.mScrollToTopNum;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.Ib.mOnScrollToTopListener;
                    hVar2.onScrollToTop();
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener;
        BdListView.d dVar;
        long j;
        Runnable runnable;
        Runnable runnable2;
        long j2;
        AbsListView.OnScrollListener onScrollListener2;
        this.Ib.mFirstVisibleItemIndex = i;
        onScrollListener = this.Ib.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener2 = this.Ib.mOnScrollListener;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.Ib.mOnScrollStopDelayedListener;
        if (dVar != null) {
            j = this.Ib.mOnScrollStopDelayedMillis;
            if (j > 0) {
                Handler handler = this.Ib.getHandler();
                runnable = this.Ib.mDelayedRunnable;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.Ib.getHandler();
                runnable2 = this.Ib.mDelayedRunnable;
                j2 = this.Ib.mOnScrollStopDelayedMillis;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
