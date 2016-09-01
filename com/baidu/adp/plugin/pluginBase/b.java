package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ PluginAdpBaseFragmentActivity yC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PluginAdpBaseFragmentActivity pluginAdpBaseFragmentActivity) {
        this.yC = pluginAdpBaseFragmentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.yC.onPreLoad(this.yC.onGetPreLoadListView());
    }
}
