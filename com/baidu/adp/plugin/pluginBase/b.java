package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ PluginAdpBaseFragmentActivity vP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PluginAdpBaseFragmentActivity pluginAdpBaseFragmentActivity) {
        this.vP = pluginAdpBaseFragmentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.vP.onPreLoad(this.vP.onGetPreLoadListView());
    }
}
