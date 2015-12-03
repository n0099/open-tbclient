package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ BdListView In;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdListView bdListView) {
        this.In = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.In.setSelection(this.In.getCount() - 1);
    }
}
