package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a tK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.tK = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tK.onPreLoad(this.tK.onGetPreLoadListView());
    }
}
