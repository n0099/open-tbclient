package com.baidu.adp.lib.stats.b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends Handler {
    final /* synthetic */ i this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(i iVar, Looper looper) {
        super(looper);
        this.this$0 = iVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        ConcurrentHashMap concurrentHashMap;
        switch (message.what) {
            case 6:
                concurrentHashMap = this.this$0.xE;
                for (Map.Entry entry : concurrentHashMap.entrySet()) {
                    com.baidu.adp.lib.stats.base.a aVar = (com.baidu.adp.lib.stats.base.a) entry.getValue();
                    if (aVar.hU() > 0) {
                        this.this$0.a(aVar, true, true);
                    }
                    if (aVar.hT() > 0) {
                        c.c(aVar, true, true, true);
                    }
                }
                return;
            default:
                return;
        }
    }
}
