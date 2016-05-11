package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ PluginAdpBaseActivity vM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginAdpBaseActivity pluginAdpBaseActivity) {
        this.vM = pluginAdpBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.vM.onPreLoad(this.vM.onGetPreLoadListView());
    }
}
