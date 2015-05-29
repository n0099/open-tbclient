package com.baidu.adp.plugin.packageManager.pluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements m {
    final /* synthetic */ h Er;
    private final /* synthetic */ m Es;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, m mVar) {
        this.Er = hVar;
        this.Es = mVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.m
    public void a(PluginSettings pluginSettings) {
        if (pluginSettings != null) {
            this.Er.Eg = pluginSettings;
        }
        if (this.Es != null) {
            this.Es.a(pluginSettings);
        }
    }
}
