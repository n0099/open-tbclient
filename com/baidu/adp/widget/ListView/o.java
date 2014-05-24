package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements i {
    final /* synthetic */ BdListView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(BdListView bdListView) {
        this.a = bdListView;
    }

    @Override // com.baidu.adp.widget.ListView.i
    public void a() {
        Runnable runnable;
        Runnable runnable2;
        BdListView bdListView = this.a;
        runnable = this.a.u;
        bdListView.removeCallbacks(runnable);
        BdListView bdListView2 = this.a;
        runnable2 = this.a.u;
        bdListView2.postDelayed(runnable2, 100L);
    }
}
