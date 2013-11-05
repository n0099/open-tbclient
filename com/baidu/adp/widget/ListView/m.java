package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdListView f573a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(BdListView bdListView) {
        this.f573a = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f573a.setSelection(this.f573a.getCount() - 1);
    }
}
