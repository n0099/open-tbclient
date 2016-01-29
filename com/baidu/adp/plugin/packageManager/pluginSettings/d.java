package com.baidu.adp.plugin.packageManager.pluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f {
    final /* synthetic */ c Fi;
    private final /* synthetic */ f Fj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, f fVar) {
        this.Fi = cVar;
        this.Fj = fVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.f
    public void a(PluginSettings pluginSettings) {
        if (pluginSettings != null) {
            this.Fi.EX = pluginSettings;
        }
        if (this.Fj != null) {
            this.Fj.a(pluginSettings);
        }
    }
}
