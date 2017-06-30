package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView Ia;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.Ia = bdListView;
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
        jVar = this.Ia.mScrollable;
        if (jVar != null) {
            X = this.Ia.mScrollable;
        } else {
            X = com.baidu.adp.base.k.X(this.Ia.getContext());
        }
        if (X != null) {
            if (i == 2) {
                BdListView bdListView = this.Ia;
                runnable5 = this.Ia.refreshRunnable;
                bdListView.removeCallbacks(runnable5);
                X.setIsScroll(true);
            } else if (X.isScroll()) {
                X.setIsScroll(false);
                BdListView bdListView2 = this.Ia;
                runnable3 = this.Ia.refreshRunnable;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.Ia;
                runnable4 = this.Ia.refreshRunnable;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.Ia;
                runnable = this.Ia.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.Ia;
                runnable2 = this.Ia.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.Ia.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener2 = this.Ia.mOnScrollListener;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.Ia.mOnScrollToBottomListener;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.Ia.mOnScrollToBottomListener;
                eVar2.onScrollToBottom();
            }
            fVar = this.Ia.mExScrollToBottomListener;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.Ia.mExScrollToBottomListener;
                fVar2.a(this.Ia);
            }
            hVar = this.Ia.mOnScrollToTopListener;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.Ia.mScrollToTopNum;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.Ia.mOnScrollToTopListener;
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
        this.Ia.mFirstVisibleItemIndex = i;
        onScrollListener = this.Ia.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener2 = this.Ia.mOnScrollListener;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.Ia.mOnScrollStopDelayedListener;
        if (dVar != null) {
            j = this.Ia.mOnScrollStopDelayedMillis;
            if (j > 0) {
                Handler handler = this.Ia.getHandler();
                runnable = this.Ia.mDelayedRunnable;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.Ia.getHandler();
                runnable2 = this.Ia.mDelayedRunnable;
                j2 = this.Ia.mOnScrollStopDelayedMillis;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
