package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d xZ;
    private final /* synthetic */ a ya;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.xZ = dVar;
        this.ya = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.xZ.xX = pluginNetConfigInfos;
        }
        if (this.ya != null) {
            a aVar = this.ya;
            pluginNetConfigInfos2 = this.xZ.xX;
            aVar.a(z, cVar, pluginNetConfigInfos2);
        }
    }
}
