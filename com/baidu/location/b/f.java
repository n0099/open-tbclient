package com.baidu.location.b;

import com.baidu.location.b.d;
import java.util.Timer;
import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f extends TimerTask {
    final /* synthetic */ Timer a;
    final /* synthetic */ d.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d.b bVar, Timer timer) {
        this.b = bVar;
        this.a = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        if (!this.b.d) {
            this.b.c();
        }
        this.a.cancel();
        this.a.purge();
    }
}
