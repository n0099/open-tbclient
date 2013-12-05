package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdListView f579a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.f579a = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f579a.setSelection(this.f579a.getCount() - 1);
    }
}
