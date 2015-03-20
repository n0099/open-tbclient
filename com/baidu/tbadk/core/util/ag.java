package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.TimerTask;
/* loaded from: classes.dex */
class ag extends TimerTask {
    final /* synthetic */ ad Um;

    private ag(ad adVar) {
        this.Um = adVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ag(ad adVar, ag agVar) {
        this(adVar);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.Um.hh();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
