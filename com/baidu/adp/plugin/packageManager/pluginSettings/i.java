package com.baidu.adp.plugin.packageManager.pluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements m {
    final /* synthetic */ h tI;
    private final /* synthetic */ m tJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, m mVar) {
        this.tI = hVar;
        this.tJ = mVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.m
    public void a(PluginSettings pluginSettings) {
        if (pluginSettings != null) {
            this.tI.ty = pluginSettings;
        }
        if (this.tJ != null) {
            this.tJ.a(pluginSettings);
        }
    }
}
