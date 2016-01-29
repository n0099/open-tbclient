package com.baidu.adp.plugin.packageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ m EC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.EC = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PluginPackageManager pluginPackageManager;
        pluginPackageManager = this.EC.this$0;
        pluginPackageManager.lI();
    }
}
