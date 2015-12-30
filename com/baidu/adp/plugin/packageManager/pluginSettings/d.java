package com.baidu.adp.plugin.packageManager.pluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f {
    final /* synthetic */ c EW;
    private final /* synthetic */ f EX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, f fVar) {
        this.EW = cVar;
        this.EX = fVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.f
    public void a(PluginSettings pluginSettings) {
        if (pluginSettings != null) {
            this.EW.EL = pluginSettings;
        }
        if (this.EX != null) {
            this.EX.a(pluginSettings);
        }
    }
}
