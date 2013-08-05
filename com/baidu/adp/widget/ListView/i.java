package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdListView f460a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdListView bdListView) {
        this.f460a = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f460a.setSelection(this.f460a.getCount() - 1);
    }
}
