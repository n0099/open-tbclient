package com.baidu.adp.plugin.proxy.activity;

import com.baidu.adp.plugin.PluginCenter;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.install.b {
    final /* synthetic */ LoadingActivity Fr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LoadingActivity loadingActivity) {
        this.Fr = loadingActivity;
    }

    @Override // com.baidu.adp.plugin.install.b
    public void D(String str, String str2) {
        this.Fr.showToast(PluginCenter.getInstance().getCommonErrorShowText());
    }

    @Override // com.baidu.adp.plugin.install.b
    public void bj(String str) {
        com.baidu.adp.plugin.a plugin2 = PluginCenter.getInstance().getPlugin(str);
        if (plugin2 != null) {
            plugin2.a(str, new b(this, plugin2));
        }
    }
}
