package com.baidu.adp.widget.ListView;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdListView f480a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.f480a = bdListView;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        AbsListView.OnScrollListener onScrollListener;
        r rVar;
        s sVar;
        int i2;
        s sVar2;
        r rVar2;
        AbsListView.OnScrollListener onScrollListener2;
        onScrollListener = this.f480a.g;
        if (onScrollListener != null) {
            onScrollListener2 = this.f480a.g;
            onScrollListener2.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            rVar = this.f480a.l;
            if (rVar != null && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && absListView.getFirstVisiblePosition() != 0) {
                rVar2 = this.f480a.l;
                rVar2.a();
            }
            sVar = this.f480a.j;
            if (sVar != null) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                i2 = this.f480a.k;
                if (firstVisiblePosition <= i2) {
                    sVar2 = this.f480a.j;
                    sVar2.a();
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
        this.f480a.p = i;
        onScrollListener = this.f480a.g;
        if (onScrollListener != null) {
            onScrollListener2 = this.f480a.g;
            onScrollListener2.onScroll(absListView, i, i2, i3);
        }
        qVar = this.f480a.h;
        if (qVar != null) {
            j = this.f480a.i;
            if (j > 0) {
                Handler handler = this.f480a.getHandler();
                runnable = this.f480a.q;
                handler.removeCallbacks(runnable);
                Handler handler2 = this.f480a.getHandler();
                runnable2 = this.f480a.q;
                j2 = this.f480a.i;
                handler2.postDelayed(runnable2, j2);
            }
        }
    }
}
