package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.TimerTask;
/* loaded from: classes.dex */
class ar extends TimerTask {
    final /* synthetic */ NetWorkCoreByBdHttp a;

    private ar(NetWorkCoreByBdHttp netWorkCoreByBdHttp) {
        this.a = netWorkCoreByBdHttp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ar(NetWorkCoreByBdHttp netWorkCoreByBdHttp, ar arVar) {
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
