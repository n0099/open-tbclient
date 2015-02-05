package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
/* loaded from: classes.dex */
class k implements com.baidu.adp.plugin.install.b {
    final /* synthetic */ j sX;
    private final /* synthetic */ BdFileDownloadData sY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, BdFileDownloadData bdFileDownloadData) {
        this.sX = jVar;
        this.sY = bdFileDownloadData;
    }

    @Override // com.baidu.adp.plugin.install.b
    public void aS(String str) {
        PluginPackageManager pluginPackageManager;
        e eVar;
        PluginPackageManager pluginPackageManager2;
        e eVar2;
        pluginPackageManager = this.sX.this$0;
        eVar = pluginPackageManager.sS;
        if (eVar != null) {
            pluginPackageManager2 = this.sX.this$0;
            eVar2 = pluginPackageManager2.sS;
            eVar2.a(this.sY, 0, "");
        }
    }

    @Override // com.baidu.adp.plugin.install.b
    public void B(String str, String str2) {
        PluginPackageManager pluginPackageManager;
        e eVar;
        PluginPackageManager pluginPackageManager2;
        e eVar2;
        pluginPackageManager = this.sX.this$0;
        eVar = pluginPackageManager.sS;
        if (eVar != null) {
            pluginPackageManager2 = this.sX.this$0;
            eVar2 = pluginPackageManager2.sS;
            eVar2.a(this.sY, -1, str2);
        }
    }
}
