package com.baidu.adp.lib.network.http;

import java.util.TimerTask;
/* loaded from: classes.dex */
class b extends TimerTask {
    final /* synthetic */ a km;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.km = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.km.dJ();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
