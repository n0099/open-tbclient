package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.adp.plugin.packageManager.pluginFileDownload.a {
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PluginPackageManager pluginPackageManager) {
        this.this$0 = pluginPackageManager;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public boolean d(BdFileDownloadData bdFileDownloadData) {
        return true;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public void e(BdFileDownloadData bdFileDownloadData) {
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public boolean f(BdFileDownloadData bdFileDownloadData) {
        return true;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public void g(BdFileDownloadData bdFileDownloadData) {
        String id;
        PluginSetting findPluginSetting;
        if (bdFileDownloadData != null && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().findPluginSetting((id = bdFileDownloadData.getId()))) != null) {
            com.baidu.adp.plugin.packageManager.pluginSettings.h.iy().k(id, com.baidu.adp.plugin.packageManager.pluginSettings.c.th);
            com.baidu.adp.plugin.b.a.hU().D("plugin_download", bdFileDownloadData.getId());
            this.this$0.be(Util.f(findPluginSetting));
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str, String str2) {
        if (bdFileDownloadData != null) {
            com.baidu.adp.plugin.b.a.hU().g("plugin_download", String.valueOf(i) + str2, bdFileDownloadData.getId());
        }
    }
}
