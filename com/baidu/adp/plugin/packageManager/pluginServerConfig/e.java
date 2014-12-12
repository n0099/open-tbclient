package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d te;
    private final /* synthetic */ a tf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.te = dVar;
        this.tf = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.te.tc = pluginNetConfigInfos;
        }
        if (this.tf != null) {
            a aVar = this.tf;
            pluginNetConfigInfos2 = this.te.tc;
            aVar.a(z, pluginNetConfigInfos2);
        }
    }
}
