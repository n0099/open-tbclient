package com.baidu.android.systemmonitor.b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ f f776a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar) {
        this.f776a = fVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        Handler handler;
        Context context;
        handler = this.f776a.t;
        if (handler == null) {
            return;
        }
        if (message.what == 1) {
            int unused = f.n = 2;
            context = this.f776a.b;
            com.baidu.android.systemmonitor.d.b.a(context.getApplicationContext(), 2);
            this.f776a.j();
        }
        super.handleMessage(message);
    }
}
