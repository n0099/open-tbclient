package com.baidu.adp.widget.ListView;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        int childCount = this.a.getChildCount();
        for (int i = 0; i < childCount; i++) {
            a(this.a.getChildAt(i));
        }
        Context context = this.a.getContext();
        if (context != null) {
            ((com.baidu.adp.base.g) context).onPreLoad(this.a);
        }
    }

    private void a(View view) {
        if (view != null) {
            if (view instanceof com.baidu.adp.newwidget.a.g) {
                ((com.baidu.adp.newwidget.a.g) view).b();
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    a(viewGroup.getChildAt(i));
                }
            }
        }
    }
}
