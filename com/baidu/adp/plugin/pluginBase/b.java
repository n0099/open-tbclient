package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ PluginAdpBaseFragmentActivity vN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PluginAdpBaseFragmentActivity pluginAdpBaseFragmentActivity) {
        this.vN = pluginAdpBaseFragmentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.vN.onPreLoad(this.vN.onGetPreLoadListView());
    }
}
