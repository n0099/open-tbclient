package com.baidu.adp.plugin.packageManager.pluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements m {
    private final /* synthetic */ m tA;
    final /* synthetic */ h tz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, m mVar) {
        this.tz = hVar;
        this.tA = mVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.m
    public void a(PluginSettings pluginSettings) {
        if (pluginSettings != null) {
            this.tz.tp = pluginSettings;
        }
        if (this.tA != null) {
            this.tA.a(pluginSettings);
        }
    }
}
