package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView zo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.zo = bdListView;
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
        com.baidu.adp.base.k q = com.baidu.adp.base.l.q(this.zo.getContext());
        if (q != null) {
            if (i == 2) {
                BdListView bdListView = this.zo;
                runnable5 = this.zo.zi;
                bdListView.removeCallbacks(runnable5);
                q.setIsScroll(true);
            } else if (q.isScroll()) {
                q.setIsScroll(false);
                BdListView bdListView2 = this.zo;
                runnable3 = this.zo.zi;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.zo;
                runnable4 = this.zo.zi;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.zo;
                runnable = this.zo.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.zo;
                runnable2 = this.zo.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.zo.yV;
        if (onScrollListener != null) {
            onScrollListener2 = this.zo.yV;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.zo.zb;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.zo.zb;
                eVar2.jD();
            }
            fVar = this.zo.zc;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.zo.zc;
                fVar2.t(this.zo);
            }
            hVar = this.zo.yZ;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.zo.za;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.zo.yZ;
                    hVar2.jE();
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
        this.zo.zg = i;
        onScrollListener = this.zo.yV;
        if (onScrollListener != null) {
            onScrollListener2 = this.zo.yV;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.zo.yW;
        if (dVar != null) {
            j = this.zo.yY;
            if (j > 0) {
                Handler handler = this.zo.getHandler();
                runnable = this.zo.zh;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.zo.getHandler();
                runnable2 = this.zo.zh;
                j2 = this.zo.yY;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
