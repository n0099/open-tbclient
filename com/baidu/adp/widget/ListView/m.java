package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView In;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.In = bdListView;
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
        com.baidu.adp.base.k A = com.baidu.adp.base.l.A(this.In.getContext());
        if (A != null) {
            if (i == 2) {
                BdListView bdListView = this.In;
                runnable5 = this.In.Ih;
                bdListView.removeCallbacks(runnable5);
                A.setIsScroll(true);
            } else if (A.isScroll()) {
                A.setIsScroll(false);
                BdListView bdListView2 = this.In;
                runnable3 = this.In.Ih;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.In;
                runnable4 = this.In.Ih;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.In;
                runnable = this.In.preLoadRunnable;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.In;
                runnable2 = this.In.preLoadRunnable;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.In.HU;
        if (onScrollListener != null) {
            onScrollListener2 = this.In.HU;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            eVar = this.In.Ia;
            if (eVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                eVar2 = this.In.Ia;
                eVar2.onScrollToBottom();
            }
            fVar = this.In.Ib;
            if (fVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                fVar2 = this.In.Ib;
                fVar2.s(this.In);
            }
            hVar = this.In.HY;
            if (hVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.In.HZ;
                if (firstVisiblePosition <= i2) {
                    hVar2 = this.In.HY;
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
        this.In.If = i;
        onScrollListener = this.In.HU;
        if (onScrollListener != null) {
            onScrollListener2 = this.In.HU;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        dVar = this.In.HV;
        if (dVar != null) {
            j = this.In.HX;
            if (j > 0) {
                Handler handler = this.In.getHandler();
                runnable = this.In.Ig;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.In.getHandler();
                runnable2 = this.In.Ig;
                j2 = this.In.HX;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
