package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ BdListView Br;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.Br = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Br.setSelection(this.Br.getCount() - 1);
    }
}
