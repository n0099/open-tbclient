package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ BdListView IS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdListView bdListView) {
        this.IS = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.IS.setSelection(this.IS.getCount() - 1);
    }
}
