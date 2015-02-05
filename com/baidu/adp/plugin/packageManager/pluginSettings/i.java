package com.baidu.adp.plugin.packageManager.pluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements m {
    final /* synthetic */ h tF;
    private final /* synthetic */ m tG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, m mVar) {
        this.tF = hVar;
        this.tG = mVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.m
    public void a(PluginSettings pluginSettings) {
        if (pluginSettings != null) {
            this.tF.tv = pluginSettings;
        }
        if (this.tG != null) {
            this.tG.a(pluginSettings);
        }
    }
}
