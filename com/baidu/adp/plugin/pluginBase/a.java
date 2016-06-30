package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ PluginAdpBaseActivity vO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginAdpBaseActivity pluginAdpBaseActivity) {
        this.vO = pluginAdpBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.vO.onPreLoad(this.vO.onGetPreLoadListView());
    }
}
