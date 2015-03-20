package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
/* loaded from: classes.dex */
class p implements com.baidu.adp.plugin.install.b {
    final /* synthetic */ o DS;
    private final /* synthetic */ BdFileDownloadData DU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, BdFileDownloadData bdFileDownloadData) {
        this.DS = oVar;
        this.DU = bdFileDownloadData;
    }

    @Override // com.baidu.adp.plugin.install.b
    public void ba(String str) {
        PluginPackageManager pluginPackageManager;
        i iVar;
        PluginPackageManager pluginPackageManager2;
        i iVar2;
        pluginPackageManager = this.DS.this$0;
        iVar = pluginPackageManager.DN;
        if (iVar != null) {
            pluginPackageManager2 = this.DS.this$0;
            iVar2 = pluginPackageManager2.DN;
            iVar2.a(this.DU, 0, "");
        }
    }

    @Override // com.baidu.adp.plugin.install.b
    public void C(String str, String str2) {
        PluginPackageManager pluginPackageManager;
        i iVar;
        PluginPackageManager pluginPackageManager2;
        i iVar2;
        pluginPackageManager = this.DS.this$0;
        iVar = pluginPackageManager.DN;
        if (iVar != null) {
            pluginPackageManager2 = this.DS.this$0;
            iVar2 = pluginPackageManager2.DN;
            iVar2.a(this.DU, -1, str2);
        }
    }
}
