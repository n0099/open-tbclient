package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.common.logging.Log;
import com.baidu.android.pushservice.jni.PushSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f715a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f715a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Socket socket;
        Socket socket2;
        Context context;
        InputStream inputStream;
        OutputStream outputStream;
        i iVar;
        j jVar;
        i iVar2;
        j jVar2;
        j jVar3;
        i iVar3;
        Context context2;
        if (PushSocket.f720a) {
            e.f714a = PushSocket.createSocket(w.b, w.c);
            if (e.f714a == -1) {
                Log.e("PushConnection", "Create socket err, errno:" + PushSocket.getLastSocketError());
                Boolean unused = e.e = false;
                this.f715a.g();
                return;
            }
        } else {
            try {
                this.f715a.g = new Socket(w.b, w.c);
                e eVar = this.f715a;
                socket = this.f715a.g;
                eVar.h = socket.getInputStream();
                e eVar2 = this.f715a;
                socket2 = this.f715a.g;
                eVar2.i = socket2.getOutputStream();
            } catch (Throwable th) {
                Log.e("PushConnection", "Connecting exception: " + th);
                Boolean unused2 = e.e = false;
                this.f715a.g();
                return;
            }
        }
        if (b.a()) {
            Log.i("PushConnection", "create Socket ok");
            com.baidu.android.pushservice.util.m.a("create Socket ok socketfd" + e.f714a);
        }
        if (PushSocket.f720a) {
            e eVar3 = this.f715a;
            context2 = this.f715a.o;
            eVar3.c = new com.baidu.android.pushservice.message.c(context2.getApplicationContext(), this.f715a);
        } else {
            e eVar4 = this.f715a;
            context = this.f715a.o;
            Context applicationContext = context.getApplicationContext();
            e eVar5 = this.f715a;
            inputStream = this.f715a.h;
            outputStream = this.f715a.i;
            eVar4.c = new com.baidu.android.pushservice.message.c(applicationContext, eVar5, inputStream, outputStream);
        }
        this.f715a.d = true;
        this.f715a.a(true);
        iVar = this.f715a.l;
        if (iVar != null) {
            iVar3 = this.f715a.l;
            iVar3.interrupt();
        }
        jVar = this.f715a.k;
        if (jVar != null) {
            jVar3 = this.f715a.k;
            jVar3.interrupt();
        }
        this.f715a.f = false;
        this.f715a.l = new i(this.f715a);
        iVar2 = this.f715a.l;
        iVar2.start();
        this.f715a.k = new j(this.f715a);
        jVar2 = this.f715a.k;
        jVar2.start();
        if (PushSocket.f720a) {
            this.f715a.c.a(e.f714a);
        } else {
            this.f715a.c.a();
        }
        Boolean unused3 = e.e = false;
    }
}
