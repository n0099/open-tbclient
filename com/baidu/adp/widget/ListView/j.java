package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener;
        r rVar;
        t tVar;
        int i2;
        t tVar2;
        r rVar2;
        AbsListView.OnScrollListener onScrollListener2;
        onScrollListener = this.a.g;
        if (onScrollListener != null) {
            onScrollListener2 = this.a.g;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            rVar = this.a.m;
            if (rVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                rVar2 = this.a.m;
                rVar2.a();
            }
            tVar = this.a.k;
            if (tVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.a.l;
                if (firstVisiblePosition <= i2) {
                    tVar2 = this.a.k;
                    tVar2.b();
                }
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
        this.a.q = i;
        onScrollListener = this.a.g;
        if (onScrollListener != null) {
            onScrollListener2 = this.a.g;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        qVar = this.a.h;
        if (qVar != null) {
            j = this.a.j;
            if (j > 0) {
                Handler handler = this.a.getHandler();
                runnable = this.a.r;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.a.getHandler();
                runnable2 = this.a.r;
                j2 = this.a.j;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
