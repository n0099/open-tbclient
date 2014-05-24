package com.baidu.adp.widget.ListView;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context = this.a.getContext();
        if (context != null) {
            ((com.baidu.adp.base.g) context).onPreLoad(this.a);
        }
    }
}
