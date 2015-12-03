package com.baidu.adp.plugin;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ PluginCenter Cs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(PluginCenter pluginCenter) {
        this.Cs = pluginCenter;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Cs.retryLaunchPlugins();
    }
}
