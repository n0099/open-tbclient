package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView Cf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.Cf = bdListView;
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
        com.baidu.adp.base.k A = com.baidu.adp.base.l.A(this.Cf.getContext());
        if (A != null) {
            if (i == 2) {
                BdListView bdListView = this.Cf;
                runnable5 = this.Cf.BZ;
                bdListView.removeCallbacks(runnable5);
                A.setIsScroll(true);
            } else if (A.isScroll()) {
                A.setIsScroll(false);
                BdListView bdListView2 = this.Cf;
                runnable3 = this.Cf.BZ;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.Cf;
                runnable4 = this.Cf.BZ;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.Cf;
                runnable = this.Cf.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.Cf;
                runnable2 = this.Cf.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.Cf.BM;
        if (onScrollListener != null) {
            onScrollListener2 = this.Cf.BM;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.Cf.BS;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.Cf.BS;
                eVar2.kx();
            }
            fVar = this.Cf.BT;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.Cf.BT;
                fVar2.t(this.Cf);
            }
            hVar = this.Cf.BQ;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.Cf.BR;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.Cf.BQ;
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
        this.Cf.BX = i;
        onScrollListener = this.Cf.BM;
        if (onScrollListener != null) {
            onScrollListener2 = this.Cf.BM;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.Cf.BN;
        if (dVar != null) {
            j = this.Cf.BP;
            if (j > 0) {
                Handler handler = this.Cf.getHandler();
                runnable = this.Cf.BY;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.Cf.getHandler();
                runnable2 = this.Cf.BY;
                j2 = this.Cf.BP;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
