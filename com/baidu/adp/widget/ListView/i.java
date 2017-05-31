package com.baidu.adp.widget.ListView;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ BdListView Ib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdListView bdListView) {
        this.Ib = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.base.j jVar;
        com.baidu.adp.base.j X;
        int childCount = this.Ib.getChildCount();
        for (int i = 0; i < childCount; i++) {
            refreshImage(this.Ib.getChildAt(i));
        }
        jVar = this.Ib.mScrollable;
        if (jVar != null) {
            X = this.Ib.mScrollable;
        } else {
            X = com.baidu.adp.base.k.X(this.Ib.getContext());
        }
        if (X != null) {
            X.onPreLoad(this.Ib);
        }
    }

    private void refreshImage(View view) {
        if (view != null) {
            if (view instanceof com.baidu.adp.b.a.i) {
                ((com.baidu.adp.b.a.i) view).refresh();
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    refreshImage(viewGroup.getChildAt(i));
                }
            }
        }
    }
}
