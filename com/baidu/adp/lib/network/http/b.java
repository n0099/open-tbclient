package com.baidu.adp.lib.network.http;

import java.util.TimerTask;
/* loaded from: classes.dex */
class b extends TimerTask {
    final /* synthetic */ a uI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.uI = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.uI.gJ();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
