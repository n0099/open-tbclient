package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView HT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(BdListView bdListView) {
        this.HT = bdListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener;
        x xVar;
        y yVar;
        aa aaVar;
        int i2;
        aa aaVar2;
        y yVar2;
        x xVar2;
        AbsListView.OnScrollListener onScrollListener2;
        Runnable runnable;
        Runnable runnable2;
        Runnable runnable3;
        Runnable runnable4;
        Runnable runnable5;
        com.baidu.adp.base.m B = com.baidu.adp.base.n.B(this.HT.getContext());
        if (B != null) {
            if (i == 2) {
                BdListView bdListView = this.HT;
                runnable5 = this.HT.HN;
                bdListView.removeCallbacks(runnable5);
                B.setIsScroll(true);
            } else if (B.isScroll()) {
                B.setIsScroll(false);
                BdListView bdListView2 = this.HT;
                runnable3 = this.HT.HN;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.HT;
                runnable4 = this.HT.HN;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.HT;
                runnable = this.HT.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.HT;
                runnable2 = this.HT.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.HT.HA;
        if (onScrollListener != null) {
            onScrollListener2 = this.HT.HA;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            xVar = this.HT.HG;
            if (xVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                xVar2 = this.HT.HG;
                xVar2.onScrollToBottom();
            }
            yVar = this.HT.HH;
            if (yVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                yVar2 = this.HT.HH;
                yVar2.s(this.HT);
            }
            aaVar = this.HT.HE;
            if (aaVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.HT.HF;
                if (firstVisiblePosition <= i2) {
                    aaVar2 = this.HT.HE;
                    aaVar2.onScrollToTop();
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener;
        w wVar;
        long j;
        Runnable runnable;
        Runnable runnable2;
        long j2;
        AbsListView.OnScrollListener onScrollListener2;
        this.HT.HL = i;
        onScrollListener = this.HT.HA;
        if (onScrollListener != null) {
            onScrollListener2 = this.HT.HA;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        wVar = this.HT.HB;
        if (wVar != null) {
            j = this.HT.HD;
            if (j > 0) {
                Handler handler = this.HT.getHandler();
                runnable = this.HT.HM;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.HT.getHandler();
                runnable2 = this.HT.HM;
                j2 = this.HT.HD;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
