package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d vk;
    private final /* synthetic */ a vl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.vk = dVar;
        this.vl = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.vk.vi = pluginNetConfigInfos;
        }
        if (this.vl != null) {
            a aVar = this.vl;
            pluginNetConfigInfos2 = this.vk.vi;
            aVar.a(z, cVar, pluginNetConfigInfos2);
        }
    }
}
