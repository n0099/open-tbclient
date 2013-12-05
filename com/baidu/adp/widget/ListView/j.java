package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdListView f576a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdListView bdListView) {
        this.f576a = bdListView;
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
        onScrollListener = this.f576a.g;
        if (onScrollListener != null) {
            onScrollListener2 = this.f576a.g;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            rVar = this.f576a.m;
            if (rVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                rVar2 = this.f576a.m;
                rVar2.a();
            }
            tVar = this.f576a.k;
            if (tVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.f576a.l;
                if (firstVisiblePosition <= i2) {
                    tVar2 = this.f576a.k;
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
        this.f576a.q = i;
        onScrollListener = this.f576a.g;
        if (onScrollListener != null) {
            onScrollListener2 = this.f576a.g;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        qVar = this.f576a.h;
        if (qVar != null) {
            j = this.f576a.j;
            if (j > 0) {
                Handler handler = this.f576a.getHandler();
                runnable = this.f576a.r;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.f576a.getHandler();
                runnable2 = this.f576a.r;
                j2 = this.f576a.j;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
