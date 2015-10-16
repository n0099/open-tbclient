package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d DU;
    private final /* synthetic */ a DV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.DU = dVar;
        this.DV = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.DU.DR = pluginNetConfigInfos;
        }
        if (this.DV != null) {
            a aVar = this.DV;
            pluginNetConfigInfos2 = this.DU.DR;
            aVar.a(z, pluginNetConfigInfos2);
        }
    }
}
