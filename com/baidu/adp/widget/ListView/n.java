package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView IF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.IF = bdListView;
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
        com.baidu.adp.base.j Y = com.baidu.adp.base.k.Y(this.IF.getContext());
        if (Y != null) {
            if (i == 2) {
                BdListView bdListView = this.IF;
                runnable5 = this.IF.refreshRunnable;
                bdListView.removeCallbacks(runnable5);
                Y.setIsScroll(true);
            } else if (Y.isScroll()) {
                Y.setIsScroll(false);
                BdListView bdListView2 = this.IF;
                runnable3 = this.IF.refreshRunnable;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.IF;
                runnable4 = this.IF.refreshRunnable;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.IF;
                runnable = this.IF.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.IF;
                runnable2 = this.IF.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.IF.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener2 = this.IF.mOnScrollListener;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.IF.mOnScrollToBottomListener;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.IF.mOnScrollToBottomListener;
                eVar2.lj();
            }
            fVar = this.IF.mExScrollToBottomListener;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.IF.mExScrollToBottomListener;
                fVar2.a(this.IF);
            }
            hVar = this.IF.mOnScrollToTopListener;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.IF.mScrollToTopNum;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.IF.mOnScrollToTopListener;
                    hVar2.lk();
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
        this.IF.mFirstVisibleItemIndex = i;
        onScrollListener = this.IF.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener2 = this.IF.mOnScrollListener;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.IF.mOnScrollStopDelayedListener;
        if (dVar != null) {
            j = this.IF.mOnScrollStopDelayedMillis;
            if (j > 0) {
                Handler handler = this.IF.getHandler();
                runnable = this.IF.mDelayedRunnable;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.IF.getHandler();
                runnable2 = this.IF.mDelayedRunnable;
                j2 = this.IF.mOnScrollStopDelayedMillis;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
