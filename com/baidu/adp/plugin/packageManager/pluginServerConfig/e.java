package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d Ef;
    private final /* synthetic */ a Eg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.Ef = dVar;
        this.Eg = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.Ef.Ed = pluginNetConfigInfos;
        }
        if (this.Eg != null) {
            a aVar = this.Eg;
            pluginNetConfigInfos2 = this.Ef.Ed;
            aVar.a(z, pluginNetConfigInfos2);
        }
    }
}
