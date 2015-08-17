package com.baidu.adp.lib.network.http;

import java.util.TimerTask;
/* loaded from: classes.dex */
class b extends TimerTask {
    final /* synthetic */ a uK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.uK = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.uK.gM();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
