package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ PluginAdpBaseActivity ys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginAdpBaseActivity pluginAdpBaseActivity) {
        this.ys = pluginAdpBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ys.onPreLoad(this.ys.onGetPreLoadListView());
    }
}
