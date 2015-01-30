package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.adp.plugin.packageManager.pluginSettings.m {
    private final /* synthetic */ String td;
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PluginPackageManager pluginPackageManager, String str) {
        this.this$0 = pluginPackageManager;
        this.td = str;
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
                J = this.this$0.J(this.td, pluginSettings.getContainerVersion());
            }
            this.this$0.ih();
            this.this$0.ij();
            return;
        }
        this.this$0.sS = System.currentTimeMillis();
        this.this$0.ii();
        this.this$0.ie();
    }
}
