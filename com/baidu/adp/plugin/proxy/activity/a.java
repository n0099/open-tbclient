package com.baidu.adp.plugin.proxy.activity;

import com.baidu.adp.plugin.Plugin;
import com.baidu.adp.plugin.PluginCenter;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.install.b {
    final /* synthetic */ LoadingActivity vO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LoadingActivity loadingActivity) {
        this.vO = loadingActivity;
    }

    @Override // com.baidu.adp.plugin.install.b
    public void B(String str, String str2) {
        this.vO.showToast(PluginCenter.getInstance().getCommonErrorShowText());
    }

    @Override // com.baidu.adp.plugin.install.b
    public void ba(String str) {
        Plugin plugin2 = PluginCenter.getInstance().getPlugin(str);
        if (plugin2 != null) {
            plugin2.asyncInit(str, new b(this, plugin2));
        }
    }
}
