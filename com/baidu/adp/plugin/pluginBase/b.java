package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a Ev;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.Ev = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Ev.onPreLoad(this.Ev.onGetPreLoadListView());
    }
}
