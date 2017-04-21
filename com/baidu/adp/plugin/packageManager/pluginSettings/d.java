package com.baidu.adp.plugin.packageManager.pluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f {
    final /* synthetic */ c Fd;
    private final /* synthetic */ f Fe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, f fVar) {
        this.Fd = cVar;
        this.Fe = fVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.f
    public void a(PluginSettings pluginSettings) {
        if (pluginSettings != null) {
            this.Fd.ES = pluginSettings;
        }
        if (this.Fe != null) {
            this.Fe.a(pluginSettings);
        }
    }
}
