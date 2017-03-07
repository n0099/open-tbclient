package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
/* loaded from: classes.dex */
class l implements com.baidu.adp.plugin.install.b {
    final /* synthetic */ k ES;
    private final /* synthetic */ BdFileDownloadData ET;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, BdFileDownloadData bdFileDownloadData) {
        this.ES = kVar;
        this.ET = bdFileDownloadData;
    }

    @Override // com.baidu.adp.plugin.install.b
    public void aV(String str) {
        PluginPackageManager pluginPackageManager;
        e eVar;
        PluginPackageManager pluginPackageManager2;
        e eVar2;
        pluginPackageManager = this.ES.this$0;
        eVar = pluginPackageManager.EN;
        if (eVar != null) {
            pluginPackageManager2 = this.ES.this$0;
            eVar2 = pluginPackageManager2.EN;
            eVar2.a(this.ET, 0, "");
        }
    }

    @Override // com.baidu.adp.plugin.install.b
    public void z(String str, String str2) {
        PluginPackageManager pluginPackageManager;
        e eVar;
        String str3;
        PluginPackageManager pluginPackageManager2;
        e eVar2;
        pluginPackageManager = this.ES.this$0;
        eVar = pluginPackageManager.EN;
        if (eVar != null) {
            if ("rom_size".equals(str2)) {
                str3 = BdBaseApplication.getInst().getString(R.string.rom_too_small);
            } else {
                str3 = "";
            }
            pluginPackageManager2 = this.ES.this$0;
            eVar2 = pluginPackageManager2.EN;
            eVar2.a(this.ET, -1, str3);
        }
    }
}
