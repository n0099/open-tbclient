package com.baidu.adp.lib.network.http;

import java.util.TimerTask;
/* loaded from: classes.dex */
class b extends TimerTask {
    final /* synthetic */ a kj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.kj = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.kj.dL();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
