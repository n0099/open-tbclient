package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdListView f575a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.f575a = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f575a.setSelection(this.f575a.getCount() - 1);
    }
}
