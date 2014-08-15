package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener;
        x xVar;
        z zVar;
        int i2;
        z zVar2;
        x xVar2;
        AbsListView.OnScrollListener onScrollListener2;
        Runnable runnable;
        Runnable runnable2;
        Runnable runnable3;
        Runnable runnable4;
        Runnable runnable5;
        Context context = this.a.getContext();
        if (context != null && (context instanceof com.baidu.adp.base.i)) {
            com.baidu.adp.base.i iVar = (com.baidu.adp.base.i) context;
            if (i == 2) {
                BdListView bdListView = this.a;
                runnable5 = this.a.t;
                bdListView.removeCallbacks(runnable5);
                iVar.setIsScroll(true);
            } else if (iVar.isScroll()) {
                iVar.setIsScroll(false);
                BdListView bdListView2 = this.a;
                runnable3 = this.a.t;
                bdListView2.removeCallbacks(runnable3);
                BdListView bdListView3 = this.a;
                runnable4 = this.a.t;
                bdListView3.postDelayed(runnable4, 100L);
            } else if (i == 0) {
                BdListView bdListView4 = this.a;
                runnable = this.a.u;
                bdListView4.removeCallbacks(runnable);
                BdListView bdListView5 = this.a;
                runnable2 = this.a.u;
                bdListView5.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.a.h;
        if (onScrollListener != null) {
            onScrollListener2 = this.a.h;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            xVar = this.a.n;
            if (xVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                xVar2 = this.a.n;
                xVar2.g_();
            }
            zVar = this.a.l;
            if (zVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.a.m;
                if (firstVisiblePosition <= i2) {
                    zVar2 = this.a.l;
                    zVar2.b();
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener;
        w wVar;
        long j;
        Runnable runnable;
        Runnable runnable2;
        long j2;
        AbsListView.OnScrollListener onScrollListener2;
        this.a.r = i;
        onScrollListener = this.a.h;
        if (onScrollListener != null) {
            onScrollListener2 = this.a.h;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        wVar = this.a.i;
        if (wVar != null) {
            j = this.a.k;
            if (j > 0) {
                Handler handler = this.a.getHandler();
                runnable = this.a.s;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.a.getHandler();
                runnable2 = this.a.s;
                j2 = this.a.k;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
