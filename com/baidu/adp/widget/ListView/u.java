package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView xj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(BdListView bdListView) {
        this.xj = bdListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener;
        ab abVar;
        ac acVar;
        ae aeVar;
        int i2;
        ae aeVar2;
        ac acVar2;
        ab abVar2;
        AbsListView.OnScrollListener onScrollListener2;
        Runnable runnable;
        Runnable runnable2;
        Runnable runnable3;
        Runnable runnable4;
        Runnable runnable5;
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(this.xj.getContext());
        if (B != null) {
            if (i == 2) {
                BdListView bdListView = this.xj;
                runnable5 = this.xj.xd;
                bdListView.removeCallbacks(runnable5);
                B.setIsScroll(true);
            } else if (B.isScroll()) {
                B.setIsScroll(false);
                BdListView bdListView2 = this.xj;
                runnable3 = this.xj.xd;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.xj;
                runnable4 = this.xj.xd;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.xj;
                runnable = this.xj.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.xj;
                runnable2 = this.xj.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.xj.wQ;
        if (onScrollListener != null) {
            onScrollListener2 = this.xj.wQ;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            abVar = this.xj.wW;
            if (abVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                abVar2 = this.xj.wW;
                abVar2.onScrollToBottom();
            }
            acVar = this.xj.wX;
            if (acVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                acVar2 = this.xj.wX;
                acVar2.s(this.xj);
            }
            aeVar = this.xj.wU;
            if (aeVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.xj.wV;
                if (firstVisiblePosition <= i2) {
                    aeVar2 = this.xj.wU;
                    aeVar2.onScrollToTop();
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener;
        aa aaVar;
        long j;
        Runnable runnable;
        Runnable runnable2;
        long j2;
        AbsListView.OnScrollListener onScrollListener2;
        this.xj.xb = i;
        onScrollListener = this.xj.wQ;
        if (onScrollListener != null) {
            onScrollListener2 = this.xj.wQ;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        aaVar = this.xj.wR;
        if (aaVar != null) {
            j = this.xj.wT;
            if (j > 0) {
                Handler handler = this.xj.getHandler();
                runnable = this.xj.xc;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.xj.getHandler();
                runnable2 = this.xj.xc;
                j2 = this.xj.wT;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
