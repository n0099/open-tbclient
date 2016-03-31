package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ PluginAdpBaseFragmentActivity Fv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PluginAdpBaseFragmentActivity pluginAdpBaseFragmentActivity) {
        this.Fv = pluginAdpBaseFragmentActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Fv.onPreLoad(this.Fv.onGetPreLoadListView());
    }
}
