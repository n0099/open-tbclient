package com.baidu.adp.widget.ListView;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ BdListView vg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(BdListView bdListView) {
        this.vg = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context = this.vg.getContext();
        if (context != null) {
            ((com.baidu.adp.base.i) context).onPreLoad(this.vg);
        }
    }
}
