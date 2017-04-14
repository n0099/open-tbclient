package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ PluginAdpBaseActivity Fh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginAdpBaseActivity pluginAdpBaseActivity) {
        this.Fh = pluginAdpBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Fh.onPreLoad(this.Fh.onGetPreLoadListView());
    }
}
