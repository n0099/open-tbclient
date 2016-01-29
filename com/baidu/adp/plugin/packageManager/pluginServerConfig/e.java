package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d EN;
    private final /* synthetic */ a EO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.EN = dVar;
        this.EO = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.EN.EK = pluginNetConfigInfos;
        }
        if (this.EO != null) {
            a aVar = this.EO;
            pluginNetConfigInfos2 = this.EN.EK;
            aVar.a(z, cVar, pluginNetConfigInfos2);
        }
    }
}
