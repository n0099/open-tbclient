package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import java.util.Hashtable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.adp.plugin.packageManager.pluginFileDownload.a {
    private final /* synthetic */ e sR;
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PluginPackageManager pluginPackageManager, e eVar) {
        this.this$0 = pluginPackageManager;
        this.sR = eVar;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public boolean d(BdFileDownloadData bdFileDownloadData) {
        return true;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public void e(BdFileDownloadData bdFileDownloadData) {
        if (this.sR != null) {
            this.sR.a(bdFileDownloadData);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public boolean f(BdFileDownloadData bdFileDownloadData) {
        return true;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public void g(BdFileDownloadData bdFileDownloadData) {
        Hashtable hashtable;
        if (this.sR != null) {
            this.sR.b(bdFileDownloadData);
        }
        String id = bdFileDownloadData.getId();
        PluginSetting findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().findPluginSetting(id);
        if (findPluginSetting != null) {
            com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().k(id, com.baidu.adp.plugin.packageManager.pluginSettings.c.th);
            com.baidu.adp.plugin.b.a.hU().D("plugin_download", bdFileDownloadData.getId());
            n nVar = new n(this.this$0, null);
            nVar.packageName = id;
            nVar.timestamp = System.currentTimeMillis();
            nVar.sU = new m(this, this.sR, bdFileDownloadData);
            hashtable = this.this$0.sF;
            hashtable.put(id, nVar);
            this.this$0.be(Util.f(findPluginSetting));
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str, String str2) {
        if (this.sR != null) {
            this.sR.c(bdFileDownloadData);
        }
        com.baidu.adp.plugin.b.a.hU().g("plugin_download", String.valueOf(i) + str2, bdFileDownloadData.getId());
    }
}
