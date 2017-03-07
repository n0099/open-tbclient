package com.baidu.adp.plugin.packageManager.pluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f {
    private final /* synthetic */ f FA;
    final /* synthetic */ c Fz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, f fVar) {
        this.Fz = cVar;
        this.FA = fVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.f
    public void a(PluginSettings pluginSettings) {
        if (pluginSettings != null) {
            this.Fz.Fo = pluginSettings;
        }
        if (this.FA != null) {
            this.FA.a(pluginSettings);
        }
    }
}
