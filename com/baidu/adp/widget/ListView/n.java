package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView Ce;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.Ce = bdListView;
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
        com.baidu.adp.base.k A = com.baidu.adp.base.l.A(this.Ce.getContext());
        if (A != null) {
            if (i == 2) {
                BdListView bdListView = this.Ce;
                runnable5 = this.Ce.BY;
                bdListView.removeCallbacks(runnable5);
                A.setIsScroll(true);
            } else if (A.isScroll()) {
                A.setIsScroll(false);
                BdListView bdListView2 = this.Ce;
                runnable3 = this.Ce.BY;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.Ce;
                runnable4 = this.Ce.BY;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.Ce;
                runnable = this.Ce.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.Ce;
                runnable2 = this.Ce.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.Ce.BL;
        if (onScrollListener != null) {
            onScrollListener2 = this.Ce.BL;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.Ce.BR;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.Ce.BR;
                eVar2.kx();
            }
            fVar = this.Ce.BS;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.Ce.BS;
                fVar2.t(this.Ce);
            }
            hVar = this.Ce.BP;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.Ce.BQ;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.Ce.BP;
                    hVar2.ky();
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
        this.Ce.BW = i;
        onScrollListener = this.Ce.BL;
        if (onScrollListener != null) {
            onScrollListener2 = this.Ce.BL;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.Ce.BM;
        if (dVar != null) {
            j = this.Ce.BO;
            if (j > 0) {
                Handler handler = this.Ce.getHandler();
                runnable = this.Ce.BX;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.Ce.getHandler();
                runnable2 = this.Ce.BX;
                j2 = this.Ce.BO;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
