package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d DR;
    private final /* synthetic */ a DS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.DR = dVar;
        this.DS = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.DR.DP = pluginNetConfigInfos;
        }
        if (this.DS != null) {
            a aVar = this.DS;
            pluginNetConfigInfos2 = this.DR.DP;
            aVar.a(z, pluginNetConfigInfos2);
        }
    }
}
