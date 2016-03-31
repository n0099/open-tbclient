package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ PluginAdpBaseActivity Fu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginAdpBaseActivity pluginAdpBaseActivity) {
        this.Fu = pluginAdpBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Fu.onPreLoad(this.Fu.onGetPreLoadListView());
    }
}
