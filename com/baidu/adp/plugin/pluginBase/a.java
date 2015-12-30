package com.baidu.adp.plugin.pluginBase;
/* loaded from: classes.dex */
class a implements Runnable {
    final /* synthetic */ PluginAdpBaseActivity Fd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(PluginAdpBaseActivity pluginAdpBaseActivity) {
        this.Fd = pluginAdpBaseActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Fd.onPreLoad(this.Fd.onGetPreLoadListView());
    }
}
