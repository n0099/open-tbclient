package com.baidu.adp.plugin.packageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ m Ey;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.Ey = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PluginPackageManager pluginPackageManager;
        pluginPackageManager = this.Ey.this$0;
        pluginPackageManager.jD();
    }
}
