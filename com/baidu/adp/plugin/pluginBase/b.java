package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a Et;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.Et = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Et.onPreLoad(this.Et.onGetPreLoadListView());
    }
}
