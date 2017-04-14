package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d EF;
    private final /* synthetic */ a EG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.EF = dVar;
        this.EG = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.EF.ED = pluginNetConfigInfos;
        }
        if (this.EG != null) {
            a aVar = this.EG;
            pluginNetConfigInfos2 = this.EF.ED;
            aVar.a(z, cVar, pluginNetConfigInfos2);
        }
    }
}
