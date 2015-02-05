package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
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
        e eVar;
        e eVar2;
        eVar = this.this$0.sS;
        if (eVar != null) {
            eVar2 = this.this$0.sS;
            eVar2.a(bdFileDownloadData);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public boolean f(BdFileDownloadData bdFileDownloadData) {
        return true;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public void g(BdFileDownloadData bdFileDownloadData) {
        e eVar;
        String id;
        PluginSetting findPluginSetting;
        e eVar2;
        Hashtable hashtable;
        e eVar3;
        e eVar4;
        e eVar5;
        eVar = this.this$0.sS;
        if (eVar != null) {
            eVar5 = this.this$0.sS;
            eVar5.b(bdFileDownloadData);
        }
        if (bdFileDownloadData != null && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().findPluginSetting((id = bdFileDownloadData.getId()))) != null) {
            com.baidu.adp.plugin.packageManager.pluginSettings.h.ir().k(id, com.baidu.adp.plugin.packageManager.pluginSettings.c.tn);
            com.baidu.adp.plugin.b.a.hN().H("plugin_download", bdFileDownloadData.getId());
            long iy = Util.iy();
            if (iy <= 0 || iy >= 31457280) {
                eVar2 = this.this$0.sS;
                if (eVar2 != null) {
                    m mVar = new m(this.this$0, null);
                    mVar.packageName = id;
                    mVar.timestamp = System.currentTimeMillis();
                    mVar.tb = new k(this, bdFileDownloadData);
                    hashtable = this.this$0.sL;
                    hashtable.put(id, mVar);
                }
                this.this$0.bb(Util.f(findPluginSetting));
                return;
            }
            com.baidu.adp.plugin.b.a.hN().g("plugin_install", "rom too small", findPluginSetting.packageName);
            eVar3 = this.this$0.sS;
            if (eVar3 != null) {
                eVar4 = this.this$0.sS;
                eVar4.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small));
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str, String str2) {
        e eVar;
        e eVar2;
        eVar = this.this$0.sS;
        if (eVar != null) {
            bdFileDownloadData.setStatusMsg(str);
            bdFileDownloadData.setStatus(2);
            bdFileDownloadData.setErrorCode(i);
            eVar2 = this.this$0.sS;
            eVar2.c(bdFileDownloadData);
        }
        if (bdFileDownloadData != null) {
            com.baidu.adp.plugin.b.a.hN().g("plugin_download", String.valueOf(i) + str2, bdFileDownloadData.getId());
        }
    }
}
