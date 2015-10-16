package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a Ew;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.Ew = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ew.onPreLoad(this.Ew.onGetPreLoadListView());
    }
}
