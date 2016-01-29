package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView IS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.IS = bdListView;
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
        com.baidu.adp.base.k A = com.baidu.adp.base.l.A(this.IS.getContext());
        if (A != null) {
            if (i == 2) {
                BdListView bdListView = this.IS;
                runnable5 = this.IS.IM;
                bdListView.removeCallbacks(runnable5);
                A.setIsScroll(true);
            } else if (A.isScroll()) {
                A.setIsScroll(false);
                BdListView bdListView2 = this.IS;
                runnable3 = this.IS.IM;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.IS;
                runnable4 = this.IS.IM;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.IS;
                runnable = this.IS.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.IS;
                runnable2 = this.IS.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.IS.Ix;
        if (onScrollListener != null) {
            onScrollListener2 = this.IS.Ix;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.IS.IE;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.IS.IE;
                eVar2.nv();
            }
            fVar = this.IS.IG;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.IS.IG;
                fVar2.s(this.IS);
            }
            hVar = this.IS.IB;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.IS.IC;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.IS.IB;
                    hVar2.nw();
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
        this.IS.IK = i;
        onScrollListener = this.IS.Ix;
        if (onScrollListener != null) {
            onScrollListener2 = this.IS.Ix;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.IS.Iy;
        if (dVar != null) {
            j = this.IS.IA;
            if (j > 0) {
                Handler handler = this.IS.getHandler();
                runnable = this.IS.IL;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.IS.getHandler();
                runnable2 = this.IS.IL;
                j2 = this.IS.IA;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
