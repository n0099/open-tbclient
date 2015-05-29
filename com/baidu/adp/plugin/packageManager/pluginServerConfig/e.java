package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d DW;
    private final /* synthetic */ a DX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.DW = dVar;
        this.DX = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.DW.DU = pluginNetConfigInfos;
        }
        if (this.DX != null) {
            a aVar = this.DX;
            pluginNetConfigInfos2 = this.DW.DU;
            aVar.a(z, pluginNetConfigInfos2);
        }
    }
}
