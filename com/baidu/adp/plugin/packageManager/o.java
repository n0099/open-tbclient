package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.util.Util;
import java.util.Hashtable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements com.baidu.adp.plugin.packageManager.pluginFileDownload.a {
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PluginPackageManager pluginPackageManager) {
        this.this$0 = pluginPackageManager;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public boolean d(BdFileDownloadData bdFileDownloadData) {
        return true;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public void e(BdFileDownloadData bdFileDownloadData) {
        i iVar;
        i iVar2;
        iVar = this.this$0.DE;
        if (iVar != null) {
            iVar2 = this.this$0.DE;
            iVar2.a(bdFileDownloadData);
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public boolean f(BdFileDownloadData bdFileDownloadData) {
        return true;
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public void g(BdFileDownloadData bdFileDownloadData) {
        i iVar;
        String id;
        PluginSetting findPluginSetting;
        i iVar2;
        Hashtable hashtable;
        i iVar3;
        i iVar4;
        i iVar5;
        iVar = this.this$0.DE;
        if (iVar != null) {
            iVar5 = this.this$0.DE;
            iVar5.b(bdFileDownloadData);
        }
        if (bdFileDownloadData != null && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().findPluginSetting((id = bdFileDownloadData.getId()))) != null) {
            com.baidu.adp.plugin.packageManager.pluginSettings.h.mi().j(id, com.baidu.adp.plugin.packageManager.pluginSettings.c.DZ);
            com.baidu.adp.plugin.b.a.lB().K("plugin_download", bdFileDownloadData.getId());
            long mp = Util.mp();
            if (mp <= 0 || mp >= 31457280) {
                iVar2 = this.this$0.DE;
                if (iVar2 != null) {
                    r rVar = new r(this.this$0, null);
                    rVar.packageName = id;
                    rVar.timestamp = System.currentTimeMillis();
                    rVar.DM = new p(this, bdFileDownloadData);
                    hashtable = this.this$0.Dw;
                    hashtable.put(id, rVar);
                }
                this.this$0.M(Util.f(findPluginSetting), findPluginSetting.packageName);
                return;
            }
            com.baidu.adp.plugin.b.a.lB().g("plugin_install", "rom too small", findPluginSetting.packageName);
            iVar3 = this.this$0.DE;
            if (iVar3 != null) {
                iVar4 = this.this$0.DE;
                iVar4.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small));
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str, String str2) {
        i iVar;
        i iVar2;
        iVar = this.this$0.DE;
        if (iVar != null) {
            bdFileDownloadData.setStatusMsg(str);
            bdFileDownloadData.setStatus(2);
            bdFileDownloadData.setErrorCode(i);
            iVar2 = this.this$0.DE;
            iVar2.c(bdFileDownloadData);
        }
        if (bdFileDownloadData != null) {
            com.baidu.adp.plugin.b.a.lB().g("plugin_download", String.valueOf(i) + str2, bdFileDownloadData.getId());
        }
    }
}
