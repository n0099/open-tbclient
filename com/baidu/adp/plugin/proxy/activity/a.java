package com.baidu.adp.plugin.proxy.activity;

import com.baidu.adp.plugin.PluginCenter;
/* loaded from: classes.dex */
class a implements com.baidu.adp.plugin.install.b {
    final /* synthetic */ LoadingActivity tT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LoadingActivity loadingActivity) {
        this.tT = loadingActivity;
    }

    @Override // com.baidu.adp.plugin.install.b
    public void B(String str, String str2) {
        this.tT.showToast(PluginCenter.gW().gX());
    }

    @Override // com.baidu.adp.plugin.install.b
    public void aV(String str) {
        com.baidu.adp.plugin.b aS = PluginCenter.gW().aS(str);
        if (aS != null) {
            aS.a(str, new b(this, aS));
        }
    }
}
