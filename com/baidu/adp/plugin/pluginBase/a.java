package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ PluginAdpBaseActivity Fp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginAdpBaseActivity pluginAdpBaseActivity) {
        this.Fp = pluginAdpBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Fp.onPreLoad(this.Fp.onGetPreLoadListView());
    }
}
