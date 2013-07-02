package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.setSelection(this.a.getCount() - 1);
    }
}
