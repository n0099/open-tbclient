package com.baidu.adp.widget.ListView;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ BdListView zP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdListView bdListView) {
        this.zP = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int childCount = this.zP.getChildCount();
        for (int i = 0; i < childCount; i++) {
            refreshImage(this.zP.getChildAt(i));
        }
        com.baidu.adp.base.k q = com.baidu.adp.base.l.q(this.zP.getContext());
        if (q != null) {
            q.onPreLoad(this.zP);
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
