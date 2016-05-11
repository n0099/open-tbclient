package com.baidu.adp.plugin.packageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ m va;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.va = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PluginPackageManager pluginPackageManager;
        pluginPackageManager = this.va.this$0;
        pluginPackageManager.hL();
    }
}
