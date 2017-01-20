package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView Br;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.Br = bdListView;
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
        com.baidu.adp.base.j A = com.baidu.adp.base.k.A(this.Br.getContext());
        if (A != null) {
            if (i == 2) {
                BdListView bdListView = this.Br;
                runnable5 = this.Br.refreshRunnable;
                bdListView.removeCallbacks(runnable5);
                A.setIsScroll(true);
            } else if (A.isScroll()) {
                A.setIsScroll(false);
                BdListView bdListView2 = this.Br;
                runnable3 = this.Br.refreshRunnable;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.Br;
                runnable4 = this.Br.refreshRunnable;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.Br;
                runnable = this.Br.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.Br;
                runnable2 = this.Br.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.Br.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener2 = this.Br.mOnScrollListener;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.Br.mOnScrollToBottomListener;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.Br.mOnScrollToBottomListener;
                eVar2.kp();
            }
            fVar = this.Br.mExScrollToBottomListener;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.Br.mExScrollToBottomListener;
                fVar2.a(this.Br);
            }
            hVar = this.Br.mOnScrollToTopListener;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.Br.mScrollToTopNum;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.Br.mOnScrollToTopListener;
                    hVar2.kq();
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
        this.Br.mFirstVisibleItemIndex = i;
        onScrollListener = this.Br.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener2 = this.Br.mOnScrollListener;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.Br.mOnScrollStopDelayedListener;
        if (dVar != null) {
            j = this.Br.mOnScrollStopDelayedMillis;
            if (j > 0) {
                Handler handler = this.Br.getHandler();
                runnable = this.Br.mDelayedRunnable;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.Br.getHandler();
                runnable2 = this.Br.mDelayedRunnable;
                j2 = this.Br.mOnScrollStopDelayedMillis;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
