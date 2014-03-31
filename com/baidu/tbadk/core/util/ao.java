package com.baidu.tbadk.core.util;

import java.util.TimerTask;
/* loaded from: classes.dex */
final class ao extends TimerTask {
    final /* synthetic */ NetWorkCoreByBdHttp a;

    private ao(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.a = netWorkCoreByBdHttp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ao(NetWorkCoreByBdHttp netWorkCoreByBdHttp, byte b) {
        this(netWorkCoreByBdHttp);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        try {
            this.a.b();
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}
