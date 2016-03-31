package com.baidu.adp.lib.network.http;

import java.util.TimerTask;
/* loaded from: classes.dex */
class c extends TimerTask {
    final /* synthetic */ b vm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.vm = bVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        try {
            this.vm.gX();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
