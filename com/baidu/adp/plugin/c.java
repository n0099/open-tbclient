package com.baidu.adp.plugin;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements Runnable {
    final /* synthetic */ PluginCenter vV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(PluginCenter pluginCenter) {
        this.vV = pluginCenter;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.vV.retryLaunchAllPlugins();
    }
}
