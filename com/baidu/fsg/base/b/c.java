package com.baidu.fsg.base.b;

import java.util.TimerTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class c extends TimerTask {
    final /* synthetic */ a a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.a = aVar;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.a.a();
    }
}
