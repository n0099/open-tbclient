package com.baidu.adp.plugin;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ PluginCenter vV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PluginCenter pluginCenter) {
        this.vV = pluginCenter;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.vV.retryLaunchPlugins();
    }
}
