package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.TimerTask;
/* loaded from: classes.dex */
class ai extends TimerTask {
    final /* synthetic */ af Eq;

    private ai(af afVar) {
        this.Eq = afVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ai(af afVar, ai aiVar) {
        this(afVar);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.Eq.dM();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
