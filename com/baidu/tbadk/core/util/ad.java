package com.baidu.tbadk.core.util;

import com.baidu.adp.lib.util.BdLog;
import java.util.TimerTask;
/* loaded from: classes.dex */
class ad extends TimerTask {
    final /* synthetic */ ab UX;

    private ad(ab abVar) {
        this.UX = abVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ad(ab abVar, ad adVar) {
        this(abVar);
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.UX.gS();
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
