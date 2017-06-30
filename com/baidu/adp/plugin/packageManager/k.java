package com.baidu.adp.plugin.packageManager;

import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.plugin.packageManager.PluginPackageManager;
import com.baidu.adp.plugin.packageManager.pluginFileDownload.BdFileDownloadData;
import com.baidu.adp.plugin.packageManager.pluginSettings.PluginSetting;
import com.baidu.adp.plugin.packageManager.pluginSettings.a;
import com.baidu.adp.plugin.util.Util;
import java.util.Hashtable;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements com.baidu.adp.plugin.packageManager.pluginFileDownload.a {
    final /* synthetic */ PluginPackageManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PluginPackageManager pluginPackageManager) {
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
        eVar = this.this$0.Er;
        if (eVar != null) {
            eVar2 = this.this$0.Er;
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
        eVar = this.this$0.Er;
        if (eVar != null) {
            eVar5 = this.this$0.Er;
            eVar5.b(bdFileDownloadData);
        }
        if (bdFileDownloadData != null && (findPluginSetting = com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().findPluginSetting((id = bdFileDownloadData.getId()))) != null) {
            com.baidu.adp.plugin.packageManager.pluginSettings.c.jY().n(id, a.b.EL);
            com.baidu.adp.plugin.b.a.jj().A("plugin_download", bdFileDownloadData.getId());
            if (Util.k(findPluginSetting.size)) {
                eVar2 = this.this$0.Er;
                if (eVar2 != null) {
                    PluginPackageManager.a aVar = new PluginPackageManager.a(this.this$0, null);
                    aVar.packageName = id;
                    aVar.timestamp = System.currentTimeMillis();
                    aVar.Ez = new l(this, bdFileDownloadData);
                    hashtable = this.this$0.Ei;
                    hashtable.put(id, aVar);
                }
                this.this$0.D(Util.f(findPluginSetting), findPluginSetting.packageName);
                return;
            }
            com.baidu.adp.plugin.install.l.d(bdFileDownloadData.getPath(), id, "rom_size", String.valueOf(Util.kk()));
            eVar3 = this.this$0.Er;
            if (eVar3 != null) {
                eVar4 = this.this$0.Er;
                eVar4.a(bdFileDownloadData, -1, BdBaseApplication.getInst().getString(R.string.rom_too_small));
            }
        }
    }

    @Override // com.baidu.adp.plugin.packageManager.pluginFileDownload.a
    public void a(BdFileDownloadData bdFileDownloadData, int i, String str, String str2) {
        e eVar;
        e eVar2;
        eVar = this.this$0.Er;
        if (eVar != null) {
            bdFileDownloadData.setStatusMsg(str);
            bdFileDownloadData.setStatus(2);
            bdFileDownloadData.setErrorCode(i);
            eVar2 = this.this$0.Er;
            eVar2.c(bdFileDownloadData);
        }
        if (bdFileDownloadData != null) {
            com.baidu.adp.plugin.b.a.jj().f("plugin_download", String.valueOf(i), bdFileDownloadData.getId(), str2);
        }
    }
}
