package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d vN;
    private final /* synthetic */ a vO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.vN = dVar;
        this.vO = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.vN.vL = pluginNetConfigInfos;
        }
        if (this.vO != null) {
            a aVar = this.vO;
            pluginNetConfigInfos2 = this.vN.vL;
            aVar.a(z, cVar, pluginNetConfigInfos2);
        }
    }
}
