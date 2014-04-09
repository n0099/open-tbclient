package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements AbsListView.OnScrollListener {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener;
        t tVar;
        v vVar;
        int i2;
        v vVar2;
        t tVar2;
        AbsListView.OnScrollListener onScrollListener2;
        onScrollListener = this.a.g;
        if (onScrollListener != null) {
            onScrollListener2 = this.a.g;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            tVar = this.a.m;
            if (tVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                tVar2 = this.a.m;
                tVar2.b();
            }
            vVar = this.a.k;
            if (vVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.a.l;
                if (firstVisiblePosition <= i2) {
                    vVar2 = this.a.k;
                    vVar2.e_();
                }
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AbsListView.OnScrollListener onScrollListener;
        s sVar;
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
        sVar = this.a.h;
        if (sVar != null) {
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
