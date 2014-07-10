package com.baidu.android.systemmonitor.freqstatistic;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(c cVar) {
        this.a = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Context context;
        handler = this.a.t;
        if (handler == null) {
            return;
        }
        if (message.what == 1) {
            int unused = c.n = 2;
            context = this.a.b;
            com.baidu.android.systemmonitor.c.b.a(context.getApplicationContext(), 2);
            this.a.j();
        }
        super.handleMessage(message);
    }
}
