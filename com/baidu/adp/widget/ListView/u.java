package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView xm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(BdListView bdListView) {
        this.xm = bdListView;
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
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(this.xm.getContext());
        if (B != null) {
            if (i == 2) {
                BdListView bdListView = this.xm;
                runnable5 = this.xm.xg;
                bdListView.removeCallbacks(runnable5);
                B.setIsScroll(true);
            } else if (B.isScroll()) {
                B.setIsScroll(false);
                BdListView bdListView2 = this.xm;
                runnable3 = this.xm.xg;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.xm;
                runnable4 = this.xm.xg;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.xm;
                runnable = this.xm.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.xm;
                runnable2 = this.xm.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.xm.wT;
        if (onScrollListener != null) {
            onScrollListener2 = this.xm.wT;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            abVar = this.xm.wZ;
            if (abVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                abVar2 = this.xm.wZ;
                abVar2.onScrollToBottom();
            }
            acVar = this.xm.xa;
            if (acVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                acVar2 = this.xm.xa;
                acVar2.s(this.xm);
            }
            aeVar = this.xm.wX;
            if (aeVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.xm.wY;
                if (firstVisiblePosition <= i2) {
                    aeVar2 = this.xm.wX;
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
        this.xm.xe = i;
        onScrollListener = this.xm.wT;
        if (onScrollListener != null) {
            onScrollListener2 = this.xm.wT;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        aaVar = this.xm.wU;
        if (aaVar != null) {
            j = this.xm.wW;
            if (j > 0) {
                Handler handler = this.xm.getHandler();
                runnable = this.xm.xf;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.xm.getHandler();
                runnable2 = this.xm.xf;
                j2 = this.xm.wW;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
