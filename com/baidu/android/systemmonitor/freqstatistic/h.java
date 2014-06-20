package com.baidu.android.systemmonitor.freqstatistic;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar) {
        this.a = bVar;
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
            int unused = b.n = 2;
            context = this.a.b;
            com.baidu.android.systemmonitor.util.e.a(context.getApplicationContext(), 2);
            this.a.i();
        }
        super.handleMessage(message);
    }
}
