package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a Eu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.Eu = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Eu.onPreLoad(this.Eu.onGetPreLoadListView());
    }
}
