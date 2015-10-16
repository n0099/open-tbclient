package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView HV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.HV = bdListView;
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
        com.baidu.adp.base.k A = com.baidu.adp.base.l.A(this.HV.getContext());
        if (A != null) {
            if (i == 2) {
                BdListView bdListView = this.HV;
                runnable5 = this.HV.HP;
                bdListView.removeCallbacks(runnable5);
                A.setIsScroll(true);
            } else if (A.isScroll()) {
                A.setIsScroll(false);
                BdListView bdListView2 = this.HV;
                runnable3 = this.HV.HP;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.HV;
                runnable4 = this.HV.HP;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.HV;
                runnable = this.HV.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.HV;
                runnable2 = this.HV.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.HV.HC;
        if (onScrollListener != null) {
            onScrollListener2 = this.HV.HC;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.HV.HI;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.HV.HI;
                eVar2.onScrollToBottom();
            }
            fVar = this.HV.HJ;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.HV.HJ;
                fVar2.s(this.HV);
            }
            hVar = this.HV.HG;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.HV.HH;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.HV.HG;
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
        this.HV.HN = i;
        onScrollListener = this.HV.HC;
        if (onScrollListener != null) {
            onScrollListener2 = this.HV.HC;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.HV.HD;
        if (dVar != null) {
            j = this.HV.HF;
            if (j > 0) {
                Handler handler = this.HV.getHandler();
                runnable = this.HV.HO;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.HV.getHandler();
                runnable2 = this.HV.HO;
                j2 = this.HV.HF;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
