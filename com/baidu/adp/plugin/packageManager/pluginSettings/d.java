package com.baidu.adp.plugin.packageManager.pluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f {
    final /* synthetic */ c Fn;
    private final /* synthetic */ f Fo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, f fVar) {
        this.Fn = cVar;
        this.Fo = fVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.f
    public void a(PluginSettings pluginSettings) {
        if (pluginSettings != null) {
            this.Fn.Fc = pluginSettings;
        }
        if (this.Fo != null) {
            this.Fo.a(pluginSettings);
        }
    }
}
