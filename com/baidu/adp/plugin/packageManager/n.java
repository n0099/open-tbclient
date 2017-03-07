package com.baidu.adp.plugin.packageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ m EU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.EU = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PluginPackageManager pluginPackageManager;
        pluginPackageManager = this.EU.this$0;
        pluginPackageManager.jz();
    }
}
