package com.baidu.adp.plugin.packageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ m vD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.vD = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PluginPackageManager pluginPackageManager;
        pluginPackageManager = this.vD.this$0;
        pluginPackageManager.hM();
    }
}
