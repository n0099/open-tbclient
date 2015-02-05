package com.baidu.adp.plugin.packageManager.pluginServerConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements a {
    final /* synthetic */ d tk;
    private final /* synthetic */ a tl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, a aVar) {
        this.tk = dVar;
        this.tl = aVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginServerConfig.a
    public void a(boolean z, PluginNetConfigInfos pluginNetConfigInfos) {
        PluginNetConfigInfos pluginNetConfigInfos2;
        if (z) {
            this.tk.ti = pluginNetConfigInfos;
        }
        if (this.tl != null) {
            a aVar = this.tl;
            pluginNetConfigInfos2 = this.tk.ti;
            aVar.a(z, pluginNetConfigInfos2);
        }
    }
}
