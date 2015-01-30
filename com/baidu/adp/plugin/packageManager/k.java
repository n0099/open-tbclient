package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
/* loaded from: classes.dex */
class k implements com.baidu.adp.plugin.install.b {
    final /* synthetic */ j tb;
    private final /* synthetic */ BdFileDownloadData tc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, BdFileDownloadData bdFileDownloadData) {
        this.tb = jVar;
        this.tc = bdFileDownloadData;
    }

    @Override // com.baidu.adp.plugin.install.b
    public void aV(String str) {
        PluginPackageManager pluginPackageManager;
        e eVar;
        PluginPackageManager pluginPackageManager2;
        e eVar2;
        pluginPackageManager = this.tb.this$0;
        eVar = pluginPackageManager.sV;
        if (eVar != null) {
            pluginPackageManager2 = this.tb.this$0;
            eVar2 = pluginPackageManager2.sV;
            eVar2.a(this.tc, 0, "");
        }
    }

    @Override // com.baidu.adp.plugin.install.b
    public void B(String str, String str2) {
        PluginPackageManager pluginPackageManager;
        e eVar;
        PluginPackageManager pluginPackageManager2;
        e eVar2;
        pluginPackageManager = this.tb.this$0;
        eVar = pluginPackageManager.sV;
        if (eVar != null) {
            pluginPackageManager2 = this.tb.this$0;
            eVar2 = pluginPackageManager2.sV;
            eVar2.a(this.tc, -1, str2);
        }
    }
}
