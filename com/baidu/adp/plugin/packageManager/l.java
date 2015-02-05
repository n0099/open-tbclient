package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.adp.plugin.packageManager.pluginSettings.m {
    private final /* synthetic */ String sZ;
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PluginPackageManager pluginPackageManager, String str) {
        this.this$0 = pluginPackageManager;
        this.sZ = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
        if (r0 != false) goto L8;
     */
    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PluginSettings pluginSettings) {
        boolean J;
        if (pluginSettings != null) {
            if (pluginSettings != null) {
                J = this.this$0.J(this.sZ, pluginSettings.getContainerVersion());
            }
            this.this$0.hZ();
            this.this$0.ib();
            return;
        }
        this.this$0.sP = System.currentTimeMillis();
        this.this$0.ia();
        this.this$0.hX();
    }
}
