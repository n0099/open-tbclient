package com.baidu.sapi2.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class t extends Handler {
    final /* synthetic */ ThreadPoolService a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(ThreadPoolService threadPoolService, Looper looper) {
        super(looper);
        this.a = threadPoolService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            ((TPRunnable) message.obj).run();
        } else if (i == 1) {
            this.a.poolService.submit(((TPRunnable) message.obj).runable);
        }
    }
}
