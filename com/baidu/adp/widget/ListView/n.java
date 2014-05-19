package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener;
        u uVar;
        w wVar;
        int i2;
        w wVar2;
        u uVar2;
        AbsListView.OnScrollListener onScrollListener2;
        Runnable runnable;
        Runnable runnable2;
        Runnable runnable3;
        Context context = this.a.getContext();
        if (context != null && (context instanceof com.baidu.adp.base.i)) {
            com.baidu.adp.base.i iVar = (com.baidu.adp.base.i) context;
            if (i == 2) {
                BdListView bdListView = this.a;
                runnable3 = this.a.t;
                bdListView.removeCallbacks(runnable3);
                iVar.setIsScroll(true);
            } else if (iVar.isScroll()) {
                iVar.setIsScroll(false);
                BdListView bdListView2 = this.a;
                runnable = this.a.t;
                bdListView2.removeCallbacks(runnable);
                BdListView bdListView3 = this.a;
                runnable2 = this.a.t;
                bdListView3.postDelayed(runnable2, 100L);
            }
        }
        onScrollListener = this.a.h;
        if (onScrollListener != null) {
            onScrollListener2 = this.a.h;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            uVar = this.a.n;
            if (uVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                uVar2 = this.a.n;
                uVar2.f_();
            }
            wVar = this.a.l;
            if (wVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.a.m;
                if (firstVisiblePosition <= i2) {
                    wVar2 = this.a.l;
                    wVar2.b();
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener;
        t tVar;
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
        tVar = this.a.i;
        if (tVar != null) {
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
