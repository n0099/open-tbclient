package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a ED;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.ED = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ED.onPreLoad(this.ED.onGetPreLoadListView());
    }
}
