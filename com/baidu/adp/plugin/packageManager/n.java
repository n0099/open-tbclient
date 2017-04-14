package com.baidu.adp.plugin.packageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements Runnable {
    final /* synthetic */ m Ev;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.Ev = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PluginPackageManager pluginPackageManager;
        pluginPackageManager = this.Ev.this$0;
        pluginPackageManager.jD();
    }
}
