package com.baidu.adp.plugin.packageManager;

import android.os.Looper;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.adp.plugin.packageManager.pluginSettings.f {
    private final /* synthetic */ String DW;
    private final /* synthetic */ boolean DX;
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PluginPackageManager pluginPackageManager, String str, boolean z) {
        this.this$0 = pluginPackageManager;
        this.DW = str;
        this.DX = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
        if (r0 != false) goto L15;
     */
    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(PluginSettings pluginSettings) {
        String str;
        boolean J;
        this.this$0.DL = true;
        if (pluginSettings != null) {
            if (pluginSettings != null) {
                J = this.this$0.J(this.DW, pluginSettings.getContainerVersion());
            }
            if ((com.baidu.adp.lib.a.a.a.c(Looper.myLooper(), "sThreadLocal") instanceof ThreadLocal) && this.DX) {
                n nVar = new n(this);
                nVar.setPriority(4);
                nVar.execute(new Void[0]);
                return;
            }
            this.this$0.lX();
            return;
        }
        this.this$0.DK = System.currentTimeMillis();
        if (PluginPackageManager.lU().hs()) {
            com.baidu.adp.plugin.b.a lI = com.baidu.adp.plugin.b.a.lI();
            str = this.this$0.DI;
            lI.d("plugin_setting", "version_update", null, String.valueOf(str) + "-" + (pluginSettings == null ? "" : pluginSettings.getContainerVersion()));
        }
        this.this$0.ma();
        this.this$0.lW();
    }
}
