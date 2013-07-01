package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.jni.PushSocket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f311a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f311a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        h hVar;
        i iVar;
        h hVar2;
        i iVar2;
        i iVar3;
        h hVar3;
        e.f310a = PushSocket.createSocket(b.f301a, b.b, b.c, w.b, w.c);
        if (e.f310a == -1) {
            Log.e("PushConnection", "Create socket err, errno:" + PushSocket.getLastSocketError());
            Boolean unused = e.e = false;
            this.f311a.e();
            return;
        }
        if (b.a()) {
            Log.i("PushConnection", "create Socket ok");
            com.baidu.android.pushservice.util.n.a("create Socket ok socketfd" + e.f310a);
        }
        e eVar = this.f311a;
        context = this.f311a.l;
        eVar.c = new com.baidu.android.pushservice.message.c(context.getApplicationContext(), this.f311a);
        this.f311a.d = true;
        this.f311a.a(true);
        hVar = this.f311a.i;
        if (hVar != null) {
            hVar3 = this.f311a.i;
            hVar3.interrupt();
        }
        iVar = this.f311a.h;
        if (iVar != null) {
            iVar3 = this.f311a.h;
            iVar3.interrupt();
        }
        this.f311a.f = false;
        this.f311a.i = new h(this.f311a);
        hVar2 = this.f311a.i;
        hVar2.start();
        this.f311a.h = new i(this.f311a);
        iVar2 = this.f311a.h;
        iVar2.start();
        this.f311a.c.a(e.f310a);
        Boolean unused2 = e.e = false;
    }
}
