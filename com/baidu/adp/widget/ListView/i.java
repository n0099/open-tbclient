package com.baidu.adp.widget.ListView;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {
    final /* synthetic */ BdListView Ih;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdListView bdListView) {
        this.Ih = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int childCount = this.Ih.getChildCount();
        for (int i = 0; i < childCount; i++) {
            refreshImage(this.Ih.getChildAt(i));
        }
        com.baidu.adp.base.j X = com.baidu.adp.base.k.X(this.Ih.getContext());
        if (X != null) {
            X.onPreLoad(this.Ih);
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
