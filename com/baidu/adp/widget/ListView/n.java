package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView zp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.zp = bdListView;
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
        com.baidu.adp.base.k q = com.baidu.adp.base.l.q(this.zp.getContext());
        if (q != null) {
            if (i == 2) {
                BdListView bdListView = this.zp;
                runnable5 = this.zp.zj;
                bdListView.removeCallbacks(runnable5);
                q.setIsScroll(true);
            } else if (q.isScroll()) {
                q.setIsScroll(false);
                BdListView bdListView2 = this.zp;
                runnable3 = this.zp.zj;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.zp;
                runnable4 = this.zp.zj;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.zp;
                runnable = this.zp.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.zp;
                runnable2 = this.zp.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.zp.yW;
        if (onScrollListener != null) {
            onScrollListener2 = this.zp.yW;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.zp.zc;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.zp.zc;
                eVar2.jA();
            }
            fVar = this.zp.zd;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.zp.zd;
                fVar2.t(this.zp);
            }
            hVar = this.zp.za;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.zp.zb;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.zp.za;
                    hVar2.jB();
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
        this.zp.zh = i;
        onScrollListener = this.zp.yW;
        if (onScrollListener != null) {
            onScrollListener2 = this.zp.yW;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.zp.yX;
        if (dVar != null) {
            j = this.zp.yZ;
            if (j > 0) {
                Handler handler = this.zp.getHandler();
                runnable = this.zp.zi;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.zp.getHandler();
                runnable2 = this.zp.zi;
                j2 = this.zp.yZ;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
