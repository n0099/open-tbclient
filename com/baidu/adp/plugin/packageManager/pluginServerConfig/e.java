package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d Fe;
    private final /* synthetic */ a Ff;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.Fe = dVar;
        this.Ff = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.Fe.Fc = pluginNetConfigInfos;
        }
        if (this.Ff != null) {
            a aVar = this.Ff;
            pluginNetConfigInfos2 = this.Fe.Fc;
            aVar.a(z, cVar, pluginNetConfigInfos2);
        }
    }
}
