package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener;
        r rVar;
        s sVar;
        s sVar2;
        r rVar2;
        AbsListView.OnScrollListener onScrollListener2;
        onScrollListener = this.a.g;
        if (onScrollListener != null) {
            onScrollListener2 = this.a.g;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            rVar = this.a.k;
            if (rVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                rVar2 = this.a.k;
                rVar2.a();
            }
            sVar = this.a.j;
            if (sVar != null && absListView.getFirstVisiblePosition() == 0) {
                sVar2 = this.a.j;
                sVar2.a();
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener;
        q qVar;
        long j;
        Runnable runnable;
        Runnable runnable2;
        long j2;
        AbsListView.OnScrollListener onScrollListener2;
        this.a.o = i;
        onScrollListener = this.a.g;
        if (onScrollListener != null) {
            onScrollListener2 = this.a.g;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        qVar = this.a.h;
        if (qVar != null) {
            j = this.a.i;
            if (j > 0) {
                Handler handler = this.a.getHandler();
                runnable = this.a.p;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.a.getHandler();
                runnable2 = this.a.p;
                j2 = this.a.i;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
