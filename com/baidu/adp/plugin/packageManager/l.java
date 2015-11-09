package com.baidu.adp.plugin.packageManager;

import android.os.Build;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.adp.plugin.packageManager.pluginSettings.f {
    private final /* synthetic */ String DK;
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PluginPackageManager pluginPackageManager, String str) {
        this.this$0 = pluginPackageManager;
        this.DK = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
        if (r0 != false) goto L12;
     */
    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PluginSettings pluginSettings) {
        String str;
        boolean M;
        this.this$0.DA = true;
        if (pluginSettings != null) {
            if (pluginSettings != null) {
                M = this.this$0.M(this.DK, pluginSettings.getContainerVersion());
            }
            this.this$0.lW();
            if (Build.VERSION.SDK_INT > 10) {
                this.this$0.lY();
                return;
            }
            return;
        }
        this.this$0.Dz = System.currentTimeMillis();
        if (PluginPackageManager.lS().hq()) {
            com.baidu.adp.plugin.b.a lG = com.baidu.adp.plugin.b.a.lG();
            str = this.this$0.Dx;
            lG.d("plugin_setting", "version_update", null, String.valueOf(str) + "-" + (pluginSettings == null ? "" : pluginSettings.getContainerVersion()));
        }
        this.this$0.lX();
        this.this$0.lU();
    }
}
