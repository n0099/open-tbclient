package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d EB;
    private final /* synthetic */ a EC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.EB = dVar;
        this.EC = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.EB.Ez = pluginNetConfigInfos;
        }
        if (this.EC != null) {
            a aVar = this.EC;
            pluginNetConfigInfos2 = this.EB.Ez;
            aVar.a(z, cVar, pluginNetConfigInfos2);
        }
    }
}
