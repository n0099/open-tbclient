package com.baidu.adp.widget.ListView;
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ BdListView f207a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(BdListView bdListView) {
        this.f207a = bdListView;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f207a.setSelection(this.f207a.getCount() - 1);
    }
}
