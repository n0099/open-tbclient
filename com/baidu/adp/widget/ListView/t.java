package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView vg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(BdListView bdListView) {
        this.vg = bdListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener;
        aa aaVar;
        ab abVar;
        ad adVar;
        int i2;
        ad adVar2;
        ab abVar2;
        aa aaVar2;
        AbsListView.OnScrollListener onScrollListener2;
        Runnable runnable;
        Runnable runnable2;
        Runnable runnable3;
        Runnable runnable4;
        Runnable runnable5;
        Context context = this.vg.getContext();
        if (context != null && (context instanceof com.baidu.adp.base.i)) {
            com.baidu.adp.base.i iVar = (com.baidu.adp.base.i) context;
            if (i == 2) {
                BdListView bdListView = this.vg;
                runnable5 = this.vg.va;
                bdListView.removeCallbacks(runnable5);
                iVar.setIsScroll(true);
            } else if (iVar.isScroll()) {
                iVar.setIsScroll(false);
                BdListView bdListView2 = this.vg;
                runnable3 = this.vg.va;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.vg;
                runnable4 = this.vg.va;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.vg;
                runnable = this.vg.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.vg;
                runnable2 = this.vg.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.vg.uN;
        if (onScrollListener != null) {
            onScrollListener2 = this.vg.uN;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            aaVar = this.vg.uT;
            if (aaVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                aaVar2 = this.vg.uT;
                aaVar2.hQ();
            }
            abVar = this.vg.uU;
            if (abVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                abVar2 = this.vg.uU;
                abVar2.s(this.vg);
            }
            adVar = this.vg.uR;
            if (adVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.vg.uS;
                if (firstVisiblePosition <= i2) {
                    adVar2 = this.vg.uR;
                    adVar2.hR();
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener;
        z zVar;
        long j;
        Runnable runnable;
        Runnable runnable2;
        long j2;
        AbsListView.OnScrollListener onScrollListener2;
        this.vg.uY = i;
        onScrollListener = this.vg.uN;
        if (onScrollListener != null) {
            onScrollListener2 = this.vg.uN;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        zVar = this.vg.uO;
        if (zVar != null) {
            j = this.vg.uQ;
            if (j > 0) {
                Handler handler = this.vg.getHandler();
                runnable = this.vg.uZ;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.vg.getHandler();
                runnable2 = this.vg.uZ;
                j2 = this.vg.uQ;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
