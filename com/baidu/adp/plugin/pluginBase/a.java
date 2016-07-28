package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ PluginAdpBaseActivity wp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginAdpBaseActivity pluginAdpBaseActivity) {
        this.wp = pluginAdpBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.wp.onPreLoad(this.wp.onGetPreLoadListView());
    }
}
