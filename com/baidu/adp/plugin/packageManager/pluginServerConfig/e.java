package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d DS;
    private final /* synthetic */ a DU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.DS = dVar;
        this.DU = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.DS.DQ = pluginNetConfigInfos;
        }
        if (this.DU != null) {
            a aVar = this.DU;
            pluginNetConfigInfos2 = this.DS.DQ;
            aVar.a(z, pluginNetConfigInfos2);
        }
    }
}
