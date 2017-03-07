package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ PluginAdpBaseFragmentActivity FH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PluginAdpBaseFragmentActivity pluginAdpBaseFragmentActivity) {
        this.FH = pluginAdpBaseFragmentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.FH.onPreLoad(this.FH.onGetPreLoadListView());
    }
}
