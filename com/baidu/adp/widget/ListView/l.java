package com.baidu.adp.widget.ListView;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ BdListView Ib;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.Ib = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int childCount = this.Ib.getChildCount();
        for (int i = 0; i < childCount; i++) {
            refreshImage(this.Ib.getChildAt(i));
        }
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(this.Ib.getContext());
        if (B != null) {
            B.onPreLoad(this.Ib);
        }
    }

    private void refreshImage(View view) {
        if (view != null) {
            if (view instanceof com.baidu.adp.newwidget.a.i) {
                ((com.baidu.adp.newwidget.a.i) view).refresh();
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
