package com.baidu.android.systemmonitor.d;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ c f403a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(c cVar) {
        this.f403a = cVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Context context;
        handler = this.f403a.t;
        if (handler == null) {
            return;
        }
        if (message.what == 1) {
            int unused = c.n = 2;
            context = this.f403a.b;
            com.baidu.android.systemmonitor.a.b.a(context.getApplicationContext(), 2);
            this.f403a.j();
        }
        super.handleMessage(message);
    }
}
