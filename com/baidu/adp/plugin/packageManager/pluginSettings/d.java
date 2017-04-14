package com.baidu.adp.plugin.packageManager.pluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f {
    final /* synthetic */ c Fa;
    private final /* synthetic */ f Fb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, f fVar) {
        this.Fa = cVar;
        this.Fb = fVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.f
    public void a(PluginSettings pluginSettings) {
        if (pluginSettings != null) {
            this.Fa.EP = pluginSettings;
        }
        if (this.Fb != null) {
            this.Fb.a(pluginSettings);
        }
    }
}
