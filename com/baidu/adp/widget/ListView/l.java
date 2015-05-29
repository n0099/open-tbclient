package com.baidu.adp.widget.ListView;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ BdListView HT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.HT = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int childCount = this.HT.getChildCount();
        for (int i = 0; i < childCount; i++) {
            refreshImage(this.HT.getChildAt(i));
        }
        com.baidu.adp.base.m B = com.baidu.adp.base.n.B(this.HT.getContext());
        if (B != null) {
            B.onPreLoad(this.HT);
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
