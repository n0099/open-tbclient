package com.baidu.adp.lib.network.http;

import java.util.TimerTask;
/* loaded from: classes.dex */
class c extends TimerTask {
    final /* synthetic */ b vl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.vl = bVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.vl.fr();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
