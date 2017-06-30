package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements Runnable {
    final /* synthetic */ BdListView Ia;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(BdListView bdListView) {
        this.Ia = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ia.setSelection(this.Ia.getCount() - 1);
    }
}
