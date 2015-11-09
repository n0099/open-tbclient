package com.baidu.adp.plugin.packageManager.pluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f {
    final /* synthetic */ c Eq;
    private final /* synthetic */ f Er;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, f fVar) {
        this.Eq = cVar;
        this.Er = fVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.f
    public void a(PluginSettings pluginSettings) {
        if (pluginSettings != null) {
            this.Eq.Ef = pluginSettings;
        }
        if (this.Er != null) {
            this.Er.a(pluginSettings);
        }
    }
}
