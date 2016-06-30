package com.baidu.adp.plugin;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ PluginCenter te;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PluginCenter pluginCenter) {
        this.te = pluginCenter;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.te.retryLaunchPlugins();
    }
}
