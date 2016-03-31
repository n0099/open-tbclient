package com.baidu.adp.widget.ListView;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ BdListView IZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BdListView bdListView) {
        this.IZ = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int childCount = this.IZ.getChildCount();
        for (int i = 0; i < childCount; i++) {
            refreshImage(this.IZ.getChildAt(i));
        }
        com.baidu.adp.base.k q = com.baidu.adp.base.l.q(this.IZ.getContext());
        if (q != null) {
            q.onPreLoad(this.IZ);
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
