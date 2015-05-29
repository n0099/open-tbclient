package com.baidu.adp.lib.h;

import android.os.Handler;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements com.baidu.adp.lib.stats.switchs.c {
    final /* synthetic */ a this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.this$0 = aVar;
    }

    @Override // com.baidu.adp.lib.stats.switchs.c
    public void is() {
        boolean z;
        Handler handler;
        Handler handler2;
        Handler handler3;
        this.this$0.xC = true;
        z = this.this$0.wu;
        if (z) {
            com.baidu.adp.lib.stats.b.i.iw().clearLogResource();
        }
        handler = a.mHandler;
        handler.removeMessages(2);
        handler2 = a.mHandler;
        handler3 = a.mHandler;
        handler2.sendMessageDelayed(handler3.obtainMessage(2), 15000L);
    }
}
