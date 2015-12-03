package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a EL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.EL = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.EL.onPreLoad(this.EL.onGetPreLoadListView());
    }
}
