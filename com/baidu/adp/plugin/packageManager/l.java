package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
/* loaded from: classes.dex */
class l implements com.baidu.adp.plugin.install.b {
    final /* synthetic */ k EF;
    private final /* synthetic */ BdFileDownloadData EG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, BdFileDownloadData bdFileDownloadData) {
        this.EF = kVar;
        this.EG = bdFileDownloadData;
    }

    @Override // com.baidu.adp.plugin.install.b
    public void bh(String str) {
        PluginPackageManager pluginPackageManager;
        e eVar;
        PluginPackageManager pluginPackageManager2;
        e eVar2;
        pluginPackageManager = this.EF.this$0;
        eVar = pluginPackageManager.EA;
        if (eVar != null) {
            pluginPackageManager2 = this.EF.this$0;
            eVar2 = pluginPackageManager2.EA;
            eVar2.a(this.EG, 0, "");
        }
    }

    @Override // com.baidu.adp.plugin.install.b
    public void C(String str, String str2) {
        PluginPackageManager pluginPackageManager;
        e eVar;
        String str3;
        PluginPackageManager pluginPackageManager2;
        e eVar2;
        pluginPackageManager = this.EF.this$0;
        eVar = pluginPackageManager.EA;
        if (eVar != null) {
            if ("rom_size".equals(str2)) {
                str3 = BdBaseApplication.getInst().getString(R.string.rom_too_small);
            } else {
                str3 = "";
            }
            pluginPackageManager2 = this.EF.this$0;
            eVar2 = pluginPackageManager2.EA;
            eVar2.a(this.EG, -1, str3);
        }
    }
}
