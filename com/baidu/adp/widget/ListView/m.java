package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView HW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.HW = bdListView;
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
        com.baidu.adp.base.k A = com.baidu.adp.base.l.A(this.HW.getContext());
        if (A != null) {
            if (i == 2) {
                BdListView bdListView = this.HW;
                runnable5 = this.HW.HQ;
                bdListView.removeCallbacks(runnable5);
                A.setIsScroll(true);
            } else if (A.isScroll()) {
                A.setIsScroll(false);
                BdListView bdListView2 = this.HW;
                runnable3 = this.HW.HQ;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.HW;
                runnable4 = this.HW.HQ;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.HW;
                runnable = this.HW.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.HW;
                runnable2 = this.HW.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.HW.HD;
        if (onScrollListener != null) {
            onScrollListener2 = this.HW.HD;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.HW.HJ;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.HW.HJ;
                eVar2.onScrollToBottom();
            }
            fVar = this.HW.HK;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.HW.HK;
                fVar2.s(this.HW);
            }
            hVar = this.HW.HH;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.HW.HI;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.HW.HH;
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
        this.HW.HO = i;
        onScrollListener = this.HW.HD;
        if (onScrollListener != null) {
            onScrollListener2 = this.HW.HD;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.HW.HE;
        if (dVar != null) {
            j = this.HW.HG;
            if (j > 0) {
                Handler handler = this.HW.getHandler();
                runnable = this.HW.HP;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.HW.getHandler();
                runnable2 = this.HW.HP;
                j2 = this.HW.HG;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
