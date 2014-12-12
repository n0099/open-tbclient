package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a tB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.tB = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tB.onPreLoad(this.tB.onGetPreLoadListView());
    }
}
