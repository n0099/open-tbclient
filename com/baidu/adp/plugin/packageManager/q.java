package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.adp.plugin.packageManager.pluginSettings.m {
    private final /* synthetic */ String DL;
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PluginPackageManager pluginPackageManager, String str) {
        this.this$0 = pluginPackageManager;
        this.DL = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
        if (r0 != false) goto L9;
     */
    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PluginSettings pluginSettings) {
        boolean O;
        this.this$0.isInit = true;
        if (pluginSettings != null) {
            if (pluginSettings != null) {
                O = this.this$0.O(this.DL, pluginSettings.getContainerVersion());
            }
            this.this$0.lQ();
            this.this$0.lS();
            return;
        }
        this.this$0.DA = System.currentTimeMillis();
        this.this$0.lR();
        this.this$0.lO();
    }
}
