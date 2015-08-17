package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
/* loaded from: classes.dex */
class k implements com.baidu.adp.plugin.install.b {
    final /* synthetic */ j DF;
    private final /* synthetic */ BdFileDownloadData DG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, BdFileDownloadData bdFileDownloadData) {
        this.DF = jVar;
        this.DG = bdFileDownloadData;
    }

    @Override // com.baidu.adp.plugin.install.b
    public void bd(String str) {
        PluginPackageManager pluginPackageManager;
        d dVar;
        PluginPackageManager pluginPackageManager2;
        d dVar2;
        pluginPackageManager = this.DF.this$0;
        dVar = pluginPackageManager.DA;
        if (dVar != null) {
            pluginPackageManager2 = this.DF.this$0;
            dVar2 = pluginPackageManager2.DA;
            dVar2.a(this.DG, 0, "");
        }
    }

    @Override // com.baidu.adp.plugin.install.b
    public void C(String str, String str2) {
        PluginPackageManager pluginPackageManager;
        d dVar;
        String str3;
        PluginPackageManager pluginPackageManager2;
        d dVar2;
        pluginPackageManager = this.DF.this$0;
        dVar = pluginPackageManager.DA;
        if (dVar != null) {
            if ("rom_size".equals(str2)) {
                str3 = BdBaseApplication.getInst().getString(R.string.rom_too_small);
            } else {
                str3 = "";
            }
            pluginPackageManager2 = this.DF.this$0;
            dVar2 = pluginPackageManager2.DA;
            dVar2.a(this.DG, -1, str3);
        }
    }
}
