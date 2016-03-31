package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d ES;
    private final /* synthetic */ a ET;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.ES = dVar;
        this.ET = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.ES.EQ = pluginNetConfigInfos;
        }
        if (this.ET != null) {
            a aVar = this.ET;
            pluginNetConfigInfos2 = this.ES.EQ;
            aVar.a(z, cVar, pluginNetConfigInfos2);
        }
    }
}
