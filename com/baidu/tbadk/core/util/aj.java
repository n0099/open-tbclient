package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.TimerTask;
/* loaded from: classes.dex */
class aj extends TimerTask {
    final /* synthetic */ ag IM;

    private aj(ag agVar) {
        this.IM = agVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ aj(ag agVar, aj ajVar) {
        this(agVar);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.IM.dJ();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
