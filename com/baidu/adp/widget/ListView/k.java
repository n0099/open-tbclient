package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ BdListView IF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.IF = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.IF.setSelection(this.IF.getCount() - 1);
    }
}
