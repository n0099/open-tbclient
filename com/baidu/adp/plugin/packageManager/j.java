package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.plugin.install.m;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.a;
import com.baidu.adp.plugin.util.Util;
import java.util.Hashtable;
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
        d dVar;
        d dVar2;
        dVar = this.this$0.DB;
        if (dVar != null) {
            dVar2 = this.this$0.DB;
            dVar2.a(bdFileDownloadData);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public boolean f(BdFileDownloadData bdFileDownloadData) {
        return true;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public void g(BdFileDownloadData bdFileDownloadData) {
        d dVar;
        String id;
        PluginSetting findPluginSetting;
        d dVar2;
        Hashtable hashtable;
        d dVar3;
        d dVar4;
        d dVar5;
        dVar = this.this$0.DB;
        if (dVar != null) {
            dVar5 = this.this$0.DB;
            dVar5.b(bdFileDownloadData);
        }
        if (bdFileDownloadData != null && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().findPluginSetting((id = bdFileDownloadData.getId()))) != null) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.mn().l(id, a.b.DW);
            com.baidu.adp.plugin.b.a.lF().H("plugin_download", bdFileDownloadData.getId());
            if (Util.l(findPluginSetting.size)) {
                dVar2 = this.this$0.DB;
                if (dVar2 != null) {
                    PluginPackageManager.a aVar = new PluginPackageManager.a(this.this$0, null);
                    aVar.packageName = id;
                    aVar.timestamp = System.currentTimeMillis();
                    aVar.DJ = new k(this, bdFileDownloadData);
                    hashtable = this.this$0.Dt;
                    hashtable.put(id, aVar);
                }
                this.this$0.K(Util.f(findPluginSetting), findPluginSetting.packageName);
                return;
            }
            m.c(bdFileDownloadData.getPath(), id, "rom_size", String.valueOf(Util.mx()));
            dVar3 = this.this$0.DB;
            if (dVar3 != null) {
                dVar4 = this.this$0.DB;
                dVar4.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small));
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str, String str2) {
        d dVar;
        d dVar2;
        dVar = this.this$0.DB;
        if (dVar != null) {
            bdFileDownloadData.setStatusMsg(str);
            bdFileDownloadData.setStatus(2);
            bdFileDownloadData.setErrorCode(i);
            dVar2 = this.this$0.DB;
            dVar2.c(bdFileDownloadData);
        }
        if (bdFileDownloadData != null) {
            com.baidu.adp.plugin.b.a.lF().g("plugin_download", String.valueOf(i) + str2, bdFileDownloadData.getId());
        }
    }
}
