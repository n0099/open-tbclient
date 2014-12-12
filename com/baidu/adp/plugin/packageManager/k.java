package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.plugin.packageManager.pluginSettings.m {
    private final /* synthetic */ String sQ;
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PluginPackageManager pluginPackageManager, String str) {
        this.this$0 = pluginPackageManager;
        this.sQ = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0010, code lost:
        if (r0 != false) goto L8;
     */
    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PluginSettings pluginSettings) {
        boolean F;
        if (pluginSettings != null) {
            if (pluginSettings != null) {
                F = this.this$0.F(this.sQ, pluginSettings.getContainerVersion());
            }
            this.this$0.ih();
            this.this$0.ij();
            return;
        }
        this.this$0.sJ = System.currentTimeMillis();
        this.this$0.ii();
        this.this$0.ie();
    }
}
