package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d Ej;
    private final /* synthetic */ a Ek;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.Ej = dVar;
        this.Ek = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.Ej.Eh = pluginNetConfigInfos;
        }
        if (this.Ek != null) {
            a aVar = this.Ek;
            pluginNetConfigInfos2 = this.Ej.Eh;
            aVar.a(z, cVar, pluginNetConfigInfos2);
        }
    }
}
