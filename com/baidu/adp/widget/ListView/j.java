package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ BdListView IE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdListView bdListView) {
        this.IE = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.IE.setSelection(this.IE.getCount() - 1);
    }
}
