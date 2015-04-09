package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView Id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(BdListView bdListView) {
        this.Id = bdListView;
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
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(this.Id.getContext());
        if (B != null) {
            if (i == 2) {
                BdListView bdListView = this.Id;
                runnable5 = this.Id.HX;
                bdListView.removeCallbacks(runnable5);
                B.setIsScroll(true);
            } else if (B.isScroll()) {
                B.setIsScroll(false);
                BdListView bdListView2 = this.Id;
                runnable3 = this.Id.HX;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.Id;
                runnable4 = this.Id.HX;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.Id;
                runnable = this.Id.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.Id;
                runnable2 = this.Id.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.Id.HK;
        if (onScrollListener != null) {
            onScrollListener2 = this.Id.HK;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            xVar = this.Id.HQ;
            if (xVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                xVar2 = this.Id.HQ;
                xVar2.onScrollToBottom();
            }
            yVar = this.Id.HR;
            if (yVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                yVar2 = this.Id.HR;
                yVar2.s(this.Id);
            }
            aaVar = this.Id.HO;
            if (aaVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.Id.HP;
                if (firstVisiblePosition <= i2) {
                    aaVar2 = this.Id.HO;
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
        this.Id.HV = i;
        onScrollListener = this.Id.HK;
        if (onScrollListener != null) {
            onScrollListener2 = this.Id.HK;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        wVar = this.Id.HL;
        if (wVar != null) {
            j = this.Id.HN;
            if (j > 0) {
                Handler handler = this.Id.getHandler();
                runnable = this.Id.HW;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.Id.getHandler();
                runnable2 = this.Id.HW;
                j2 = this.Id.HN;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
