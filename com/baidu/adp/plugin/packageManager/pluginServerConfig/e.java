package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d vm;
    private final /* synthetic */ a vn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.vm = dVar;
        this.vn = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, c cVar, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.vm.vk = pluginNetConfigInfos;
        }
        if (this.vn != null) {
            a aVar = this.vn;
            pluginNetConfigInfos2 = this.vm.vk;
            aVar.a(z, cVar, pluginNetConfigInfos2);
        }
    }
}
