package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ PluginAdpBaseActivity FG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginAdpBaseActivity pluginAdpBaseActivity) {
        this.FG = pluginAdpBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.FG.onPreLoad(this.FG.onGetPreLoadListView());
    }
}
