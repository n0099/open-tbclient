package com.baidu.adp.plugin.packageManager.pluginSettings;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements f {
    final /* synthetic */ c vH;
    private final /* synthetic */ f vI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, f fVar) {
        this.vH = cVar;
        this.vI = fVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginSettings.f
    public void a(PluginSettings pluginSettings) {
        if (pluginSettings != null) {
            this.vH.vw = pluginSettings;
        }
        if (this.vI != null) {
            this.vI.a(pluginSettings);
        }
    }
}
