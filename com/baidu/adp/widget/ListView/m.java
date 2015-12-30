package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView IE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.IE = bdListView;
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
        com.baidu.adp.base.k A = com.baidu.adp.base.l.A(this.IE.getContext());
        if (A != null) {
            if (i == 2) {
                BdListView bdListView = this.IE;
                runnable5 = this.IE.Ix;
                bdListView.removeCallbacks(runnable5);
                A.setIsScroll(true);
            } else if (A.isScroll()) {
                A.setIsScroll(false);
                BdListView bdListView2 = this.IE;
                runnable3 = this.IE.Ix;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.IE;
                runnable4 = this.IE.Ix;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.IE;
                runnable = this.IE.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.IE;
                runnable2 = this.IE.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.IE.Ik;
        if (onScrollListener != null) {
            onScrollListener2 = this.IE.Ik;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.IE.Iq;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.IE.Iq;
                eVar2.onScrollToBottom();
            }
            fVar = this.IE.Ir;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.IE.Ir;
                fVar2.s(this.IE);
            }
            hVar = this.IE.Io;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.IE.Ip;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.IE.Io;
                    hVar2.onScrollToTop();
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
        this.IE.Iv = i;
        onScrollListener = this.IE.Ik;
        if (onScrollListener != null) {
            onScrollListener2 = this.IE.Ik;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.IE.Il;
        if (dVar != null) {
            j = this.IE.In;
            if (j > 0) {
                Handler handler = this.IE.getHandler();
                runnable = this.IE.Iw;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.IE.getHandler();
                runnable2 = this.IE.Iw;
                j2 = this.IE.In;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
