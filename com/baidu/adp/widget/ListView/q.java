package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView Ib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(BdListView bdListView) {
        this.Ib = bdListView;
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
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(this.Ib.getContext());
        if (B != null) {
            if (i == 2) {
                BdListView bdListView = this.Ib;
                runnable5 = this.Ib.HV;
                bdListView.removeCallbacks(runnable5);
                B.setIsScroll(true);
            } else if (B.isScroll()) {
                B.setIsScroll(false);
                BdListView bdListView2 = this.Ib;
                runnable3 = this.Ib.HV;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.Ib;
                runnable4 = this.Ib.HV;
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
        onScrollListener = this.Ib.HI;
        if (onScrollListener != null) {
            onScrollListener2 = this.Ib.HI;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            xVar = this.Ib.HO;
            if (xVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                xVar2 = this.Ib.HO;
                xVar2.onScrollToBottom();
            }
            yVar = this.Ib.HP;
            if (yVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                yVar2 = this.Ib.HP;
                yVar2.s(this.Ib);
            }
            aaVar = this.Ib.HM;
            if (aaVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.Ib.HN;
                if (firstVisiblePosition <= i2) {
                    aaVar2 = this.Ib.HM;
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
        this.Ib.HT = i;
        onScrollListener = this.Ib.HI;
        if (onScrollListener != null) {
            onScrollListener2 = this.Ib.HI;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        wVar = this.Ib.HJ;
        if (wVar != null) {
            j = this.Ib.HL;
            if (j > 0) {
                Handler handler = this.Ib.getHandler();
                runnable = this.Ib.HU;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.Ib.getHandler();
                runnable2 = this.Ib.HU;
                j2 = this.Ib.HL;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
