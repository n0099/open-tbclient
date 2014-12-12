package com.baidu.adp.plugin.install;

import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
class e implements Runnable {
    private final /* synthetic */ String so;
    final /* synthetic */ c this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar, String str) {
        this.this$0 = cVar;
        this.so = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.adp.lib.stats.f.es().eventStat(BdBaseApplication.getInst().getApp(), "plugin_install_timeout", null, 1, new Object[0]);
        com.baidu.adp.plugin.b.a.hU().g("plugin_install", "timeout", this.so);
    }
}
