package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView IZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.IZ = bdListView;
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
        com.baidu.adp.base.k q = com.baidu.adp.base.l.q(this.IZ.getContext());
        if (q != null) {
            if (i == 2) {
                BdListView bdListView = this.IZ;
                runnable5 = this.IZ.IS;
                bdListView.removeCallbacks(runnable5);
                q.setIsScroll(true);
            } else if (q.isScroll()) {
                q.setIsScroll(false);
                BdListView bdListView2 = this.IZ;
                runnable3 = this.IZ.IS;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.IZ;
                runnable4 = this.IZ.IS;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.IZ;
                runnable = this.IZ.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.IZ;
                runnable2 = this.IZ.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.IZ.IE;
        if (onScrollListener != null) {
            onScrollListener2 = this.IZ.IE;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.IZ.IL;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.IZ.IL;
                eVar2.nm();
            }
            fVar = this.IZ.IM;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.IZ.IM;
                fVar2.s(this.IZ);
            }
            hVar = this.IZ.IJ;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.IZ.IK;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.IZ.IJ;
                    hVar2.nn();
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
        this.IZ.IQ = i;
        onScrollListener = this.IZ.IE;
        if (onScrollListener != null) {
            onScrollListener2 = this.IZ.IE;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.IZ.IG;
        if (dVar != null) {
            j = this.IZ.II;
            if (j > 0) {
                Handler handler = this.IZ.getHandler();
                runnable = this.IZ.IR;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.IZ.getHandler();
                runnable2 = this.IZ.IR;
                j2 = this.IZ.II;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
