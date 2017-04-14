package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView If;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.If = bdListView;
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
        com.baidu.adp.base.j X = com.baidu.adp.base.k.X(this.If.getContext());
        if (X != null) {
            if (i == 2) {
                BdListView bdListView = this.If;
                runnable5 = this.If.refreshRunnable;
                bdListView.removeCallbacks(runnable5);
                X.setIsScroll(true);
            } else if (X.isScroll()) {
                X.setIsScroll(false);
                BdListView bdListView2 = this.If;
                runnable3 = this.If.refreshRunnable;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.If;
                runnable4 = this.If.refreshRunnable;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.If;
                runnable = this.If.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.If;
                runnable2 = this.If.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.If.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener2 = this.If.mOnScrollListener;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.If.mOnScrollToBottomListener;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.If.mOnScrollToBottomListener;
                eVar2.ln();
            }
            fVar = this.If.mExScrollToBottomListener;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.If.mExScrollToBottomListener;
                fVar2.a(this.If);
            }
            hVar = this.If.mOnScrollToTopListener;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.If.mScrollToTopNum;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.If.mOnScrollToTopListener;
                    hVar2.lo();
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
        this.If.mFirstVisibleItemIndex = i;
        onScrollListener = this.If.mOnScrollListener;
        if (onScrollListener != null) {
            onScrollListener2 = this.If.mOnScrollListener;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.If.mOnScrollStopDelayedListener;
        if (dVar != null) {
            j = this.If.mOnScrollStopDelayedMillis;
            if (j > 0) {
                Handler handler = this.If.getHandler();
                runnable = this.If.mDelayedRunnable;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.If.getHandler();
                runnable2 = this.If.mDelayedRunnable;
                j2 = this.If.mOnScrollStopDelayedMillis;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
