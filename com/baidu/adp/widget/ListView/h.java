package com.baidu.adp.widget.ListView;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ BdListView IE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BdListView bdListView) {
        this.IE = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int childCount = this.IE.getChildCount();
        for (int i = 0; i < childCount; i++) {
            refreshImage(this.IE.getChildAt(i));
        }
        com.baidu.adp.base.k A = com.baidu.adp.base.l.A(this.IE.getContext());
        if (A != null) {
            A.onPreLoad(this.IE);
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
