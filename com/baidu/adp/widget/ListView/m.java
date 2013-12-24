package com.baidu.adp.widget.ListView;
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
        this.a.setSelection(this.a.getCount() - 1);
    }
}
