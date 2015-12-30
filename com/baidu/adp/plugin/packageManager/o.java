package com.baidu.adp.plugin.packageManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements Runnable {
    final /* synthetic */ n Er;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.Er = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        m mVar;
        PluginPackageManager pluginPackageManager;
        mVar = this.Er.Eq;
        pluginPackageManager = mVar.this$0;
        pluginPackageManager.lv();
    }
}
