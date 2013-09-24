package com.baidu.adp.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdListView f489a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdListView bdListView) {
        this.f489a = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f489a.setSelection(this.f489a.getCount() - 1);
    }
}
