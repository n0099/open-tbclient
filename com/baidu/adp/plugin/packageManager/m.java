package com.baidu.adp.plugin.packageManager;

import android.os.Looper;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.adp.plugin.packageManager.pluginSettings.f {
    private final /* synthetic */ String Eo;
    private final /* synthetic */ boolean Ep;
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PluginPackageManager pluginPackageManager, String str, boolean z) {
        this.this$0 = pluginPackageManager;
        this.Eo = str;
        this.Ep = z;
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
        boolean I;
        this.this$0.Ee = true;
        if (pluginSettings != null) {
            if (pluginSettings != null) {
                I = this.this$0.I(this.Eo, pluginSettings.getContainerVersion());
            }
            if ((com.baidu.adp.lib.a.a.a.c(Looper.myLooper(), "sThreadLocal") instanceof ThreadLocal) && this.Ep) {
                n nVar = new n(this);
                nVar.setPriority(4);
                nVar.execute(new Void[0]);
                return;
            }
            this.this$0.lv();
            return;
        }
        this.this$0.Ed = System.currentTimeMillis();
        if (PluginPackageManager.ls().hs()) {
            com.baidu.adp.plugin.b.a lf = com.baidu.adp.plugin.b.a.lf();
            str = this.this$0.Eb;
            lf.d("plugin_setting", "version_update", null, String.valueOf(str) + "-" + (pluginSettings == null ? "" : pluginSettings.getContainerVersion()));
        }
        this.this$0.ly();
        this.this$0.lu();
    }
}
