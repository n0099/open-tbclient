package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d DV;
    private final /* synthetic */ a DW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.DV = dVar;
        this.DW = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.DV.DS = pluginNetConfigInfos;
        }
        if (this.DW != null) {
            a aVar = this.DW;
            pluginNetConfigInfos2 = this.DV.DS;
            aVar.a(z, pluginNetConfigInfos2);
        }
    }
}
