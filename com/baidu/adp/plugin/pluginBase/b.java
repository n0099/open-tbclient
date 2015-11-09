package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a Ex;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.Ex = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ex.onPreLoad(this.Ex.onGetPreLoadListView());
    }
}
