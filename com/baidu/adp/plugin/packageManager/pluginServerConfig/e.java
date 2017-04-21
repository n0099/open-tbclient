package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d EI;
    private final /* synthetic */ a EJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.EI = dVar;
        this.EJ = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.EI.EG = pluginNetConfigInfos;
        }
        if (this.EJ != null) {
            a aVar = this.EJ;
            pluginNetConfigInfos2 = this.EI.EG;
            aVar.a(z, cVar, pluginNetConfigInfos2);
        }
    }
}
