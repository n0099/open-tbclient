package com.baidu.adp.plugin.packageManager.pluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements m {
    final /* synthetic */ h EB;
    private final /* synthetic */ m EC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, m mVar) {
        this.EB = hVar;
        this.EC = mVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.m
    public void a(PluginSettings pluginSettings) {
        if (pluginSettings != null) {
            this.EB.Ep = pluginSettings;
        }
        if (this.EC != null) {
            this.EC.a(pluginSettings);
        }
    }
}
