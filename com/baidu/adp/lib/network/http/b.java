package com.baidu.adp.lib.network.http;

import java.util.TimerTask;
/* loaded from: classes.dex */
class b extends TimerTask {
    final /* synthetic */ a uQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.uQ = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.uQ.gL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
