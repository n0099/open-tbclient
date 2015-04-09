package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ BdListView Id;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(BdListView bdListView) {
        this.Id = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Id.setSelection(this.Id.getCount() - 1);
    }
}
