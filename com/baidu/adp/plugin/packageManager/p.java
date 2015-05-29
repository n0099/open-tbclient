package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
/* loaded from: classes.dex */
class p implements com.baidu.adp.plugin.install.b {
    final /* synthetic */ o DJ;
    private final /* synthetic */ BdFileDownloadData DK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, BdFileDownloadData bdFileDownloadData) {
        this.DJ = oVar;
        this.DK = bdFileDownloadData;
    }

    @Override // com.baidu.adp.plugin.install.b
    public void bk(String str) {
        PluginPackageManager pluginPackageManager;
        i iVar;
        PluginPackageManager pluginPackageManager2;
        i iVar2;
        pluginPackageManager = this.DJ.this$0;
        iVar = pluginPackageManager.DE;
        if (iVar != null) {
            pluginPackageManager2 = this.DJ.this$0;
            iVar2 = pluginPackageManager2.DE;
            iVar2.a(this.DK, 0, "");
        }
    }

    @Override // com.baidu.adp.plugin.install.b
    public void E(String str, String str2) {
        PluginPackageManager pluginPackageManager;
        i iVar;
        PluginPackageManager pluginPackageManager2;
        i iVar2;
        pluginPackageManager = this.DJ.this$0;
        iVar = pluginPackageManager.DE;
        if (iVar != null) {
            pluginPackageManager2 = this.DJ.this$0;
            iVar2 = pluginPackageManager2.DE;
            iVar2.a(this.DK, -1, str2);
        }
    }
}
