package com.baidu.adp.plugin.packageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ n DZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.DZ = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar;
        PluginPackageManager pluginPackageManager;
        mVar = this.DZ.DY;
        pluginPackageManager = mVar.this$0;
        pluginPackageManager.lX();
    }
}
