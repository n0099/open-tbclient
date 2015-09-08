package com.baidu.adp.plugin.packageManager;

import android.os.Build;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.adp.plugin.packageManager.pluginSettings.f {
    private final /* synthetic */ String DH;
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PluginPackageManager pluginPackageManager, String str) {
        this.this$0 = pluginPackageManager;
        this.DH = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
        if (r0 != false) goto L12;
     */
    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PluginSettings pluginSettings) {
        boolean M;
        this.this$0.Dx = true;
        if (pluginSettings != null) {
            if (pluginSettings != null) {
                M = this.this$0.M(this.DH, pluginSettings.getContainerVersion());
            }
            this.this$0.lU();
            if (Build.VERSION.SDK_INT > 10) {
                this.this$0.lW();
                return;
            }
            return;
        }
        this.this$0.Dw = System.currentTimeMillis();
        this.this$0.lV();
        this.this$0.lS();
    }
}
