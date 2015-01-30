package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d tn;
    private final /* synthetic */ a tp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.tn = dVar;
        this.tp = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.tn.tl = pluginNetConfigInfos;
        }
        if (this.tp != null) {
            a aVar = this.tp;
            pluginNetConfigInfos2 = this.tn.tl;
            aVar.a(z, pluginNetConfigInfos2);
        }
    }
}
