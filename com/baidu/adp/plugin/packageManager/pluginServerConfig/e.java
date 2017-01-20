package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d xQ;
    private final /* synthetic */ a xR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.xQ = dVar;
        this.xR = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.xQ.xO = pluginNetConfigInfos;
        }
        if (this.xR != null) {
            a aVar = this.xR;
            pluginNetConfigInfos2 = this.xQ.xO;
            aVar.a(z, cVar, pluginNetConfigInfos2);
        }
    }
}
