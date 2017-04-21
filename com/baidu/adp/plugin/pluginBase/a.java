package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ PluginAdpBaseActivity Fk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginAdpBaseActivity pluginAdpBaseActivity) {
        this.Fk = pluginAdpBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Fk.onPreLoad(this.Fk.onGetPreLoadListView());
    }
}
