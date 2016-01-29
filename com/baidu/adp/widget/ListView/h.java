package com.baidu.adp.widget.ListView;

import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ BdListView IS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(BdListView bdListView) {
        this.IS = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int childCount = this.IS.getChildCount();
        for (int i = 0; i < childCount; i++) {
            refreshImage(this.IS.getChildAt(i));
        }
        com.baidu.adp.base.k A = com.baidu.adp.base.l.A(this.IS.getContext());
        if (A != null) {
            A.onPreLoad(this.IS);
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
