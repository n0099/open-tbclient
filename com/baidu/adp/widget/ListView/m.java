package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView HU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.HU = bdListView;
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
        com.baidu.adp.base.k A = com.baidu.adp.base.l.A(this.HU.getContext());
        if (A != null) {
            if (i == 2) {
                BdListView bdListView = this.HU;
                runnable5 = this.HU.HO;
                bdListView.removeCallbacks(runnable5);
                A.setIsScroll(true);
            } else if (A.isScroll()) {
                A.setIsScroll(false);
                BdListView bdListView2 = this.HU;
                runnable3 = this.HU.HO;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.HU;
                runnable4 = this.HU.HO;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.HU;
                runnable = this.HU.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.HU;
                runnable2 = this.HU.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.HU.HB;
        if (onScrollListener != null) {
            onScrollListener2 = this.HU.HB;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.HU.HH;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.HU.HH;
                eVar2.onScrollToBottom();
            }
            fVar = this.HU.HI;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.HU.HI;
                fVar2.s(this.HU);
            }
            hVar = this.HU.HF;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.HU.HG;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.HU.HF;
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
        this.HU.HM = i;
        onScrollListener = this.HU.HB;
        if (onScrollListener != null) {
            onScrollListener2 = this.HU.HB;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.HU.HC;
        if (dVar != null) {
            j = this.HU.HE;
            if (j > 0) {
                Handler handler = this.HU.getHandler();
                runnable = this.HU.HN;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.HU.getHandler();
                runnable2 = this.HU.HN;
                j2 = this.HU.HE;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
