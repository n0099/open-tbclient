package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.TimerTask;
/* loaded from: classes.dex */
class ap extends TimerTask {
    final /* synthetic */ NetWorkCoreByBdHttp a;

    private ap(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.a = netWorkCoreByBdHttp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ap(NetWorkCoreByBdHttp netWorkCoreByBdHttp, ap apVar) {
        this(netWorkCoreByBdHttp);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.a.b();
        } catch (Exception e) {
            BdLog.e(getClass().getName(), "initNetWorkCore", e.getMessage());
        }
    }
}
