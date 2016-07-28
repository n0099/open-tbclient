package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView zP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.zP = bdListView;
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
        com.baidu.adp.base.k q = com.baidu.adp.base.l.q(this.zP.getContext());
        if (q != null) {
            if (i == 2) {
                BdListView bdListView = this.zP;
                runnable5 = this.zP.zJ;
                bdListView.removeCallbacks(runnable5);
                q.setIsScroll(true);
            } else if (q.isScroll()) {
                q.setIsScroll(false);
                BdListView bdListView2 = this.zP;
                runnable3 = this.zP.zJ;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.zP;
                runnable4 = this.zP.zJ;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.zP;
                runnable = this.zP.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.zP;
                runnable2 = this.zP.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.zP.zw;
        if (onScrollListener != null) {
            onScrollListener2 = this.zP.zw;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.zP.zC;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.zP.zC;
                eVar2.jC();
            }
            fVar = this.zP.zD;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.zP.zD;
                fVar2.t(this.zP);
            }
            hVar = this.zP.zA;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.zP.zB;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.zP.zA;
                    hVar2.jD();
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
        this.zP.zH = i;
        onScrollListener = this.zP.zw;
        if (onScrollListener != null) {
            onScrollListener2 = this.zP.zw;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.zP.zx;
        if (dVar != null) {
            j = this.zP.zz;
            if (j > 0) {
                Handler handler = this.zP.getHandler();
                runnable = this.zP.zI;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.zP.getHandler();
                runnable2 = this.zP.zI;
                j2 = this.zP.zz;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
