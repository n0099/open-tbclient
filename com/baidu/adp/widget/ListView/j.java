package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements Runnable {
    final /* synthetic */ BdListView HV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(BdListView bdListView) {
        this.HV = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.HV.setSelection(this.HV.getCount() - 1);
    }
}
