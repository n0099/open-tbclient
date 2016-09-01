package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ PluginAdpBaseActivity yB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginAdpBaseActivity pluginAdpBaseActivity) {
        this.yB = pluginAdpBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.yB.onPreLoad(this.yB.onGetPreLoadListView());
    }
}
