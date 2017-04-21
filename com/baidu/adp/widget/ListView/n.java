package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView Ih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.Ih = bdListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
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
        com.baidu.adp.base.j X = com.baidu.adp.base.k.X(this.Ih.getContext());
        if (X != null) {
            if (i == 2) {
                BdListView bdListView = this.Ih;
                runnable5 = this.Ih.refreshRunnable;
                bdListView.removeCallbacks(runnable5);
                X.setIsScroll(true);
            } else if (X.isScroll()) {
                X.setIsScroll(false);
                BdListView bdListView2 = this.Ih;
                runnable3 = this.Ih.refreshRunnable;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.Ih;
                runnable4 = this.Ih.refreshRunnable;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.Ih;
                runnable = this.Ih.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.Ih;
                runnable2 = this.Ih.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.Ih.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener2 = this.Ih.mOnScrollListener;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.Ih.mOnScrollToBottomListener;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.Ih.mOnScrollToBottomListener;
                eVar2.lo();
            }
            fVar = this.Ih.mExScrollToBottomListener;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.Ih.mExScrollToBottomListener;
                fVar2.a(this.Ih);
            }
            hVar = this.Ih.mOnScrollToTopListener;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.Ih.mScrollToTopNum;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.Ih.mOnScrollToTopListener;
                    hVar2.lp();
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
        this.Ih.mFirstVisibleItemIndex = i;
        onScrollListener = this.Ih.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener2 = this.Ih.mOnScrollListener;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.Ih.mOnScrollStopDelayedListener;
        if (dVar != null) {
            j = this.Ih.mOnScrollStopDelayedMillis;
            if (j > 0) {
                Handler handler = this.Ih.getHandler();
                runnable = this.Ih.mDelayedRunnable;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.Ih.getHandler();
                runnable2 = this.Ih.mDelayedRunnable;
                j2 = this.Ih.mOnScrollStopDelayedMillis;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
