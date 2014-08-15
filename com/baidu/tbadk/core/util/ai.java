package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.TimerTask;
/* loaded from: classes.dex */
class ai extends TimerTask {
    final /* synthetic */ NetWorkCoreByBdHttp a;

    private ai(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.a = netWorkCoreByBdHttp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ai(NetWorkCoreByBdHttp netWorkCoreByBdHttp, ai aiVar) {
        this(netWorkCoreByBdHttp);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.a.b();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
