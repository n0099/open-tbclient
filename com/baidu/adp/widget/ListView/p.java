package com.baidu.adp.widget.ListView;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ BdListView xj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(BdListView bdListView) {
        this.xj = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int childCount = this.xj.getChildCount();
        for (int i = 0; i < childCount; i++) {
            refreshImage(this.xj.getChildAt(i));
        }
        com.baidu.adp.base.l B = com.baidu.adp.base.m.B(this.xj.getContext());
        if (B != null) {
            B.onPreLoad(this.xj);
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
