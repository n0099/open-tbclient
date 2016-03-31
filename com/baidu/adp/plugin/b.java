package com.baidu.adp.plugin;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ PluginCenter CM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PluginCenter pluginCenter) {
        this.CM = pluginCenter;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.CM.retryLaunchPlugins();
    }
}
