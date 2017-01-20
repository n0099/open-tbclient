package com.baidu.adp.lib.network.http;

import java.util.TimerTask;
/* loaded from: classes.dex */
class c extends TimerTask {
    final /* synthetic */ b nT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.nT = bVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.nT.ee();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
