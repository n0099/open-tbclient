package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ BdListView If;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.If = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.If.setSelection(this.If.getCount() - 1);
    }
}
