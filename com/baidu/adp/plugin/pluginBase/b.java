package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a tH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.tH = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.tH.onPreLoad(this.tH.onGetPreLoadListView());
    }
}
