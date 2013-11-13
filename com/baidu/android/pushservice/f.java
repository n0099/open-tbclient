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
    final /* synthetic */ e f709a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f709a = eVar;
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
        if (PushSocket.f714a) {
            e.f708a = PushSocket.createSocket(w.b, w.c);
            if (e.f708a == -1) {
                Log.e("PushConnection", "Create socket err, errno:" + PushSocket.getLastSocketError());
                Boolean unused = e.e = false;
                this.f709a.g();
                return;
            }
        } else {
            try {
                this.f709a.g = new Socket(w.b, w.c);
                e eVar = this.f709a;
                socket = this.f709a.g;
                eVar.h = socket.getInputStream();
                e eVar2 = this.f709a;
                socket2 = this.f709a.g;
                eVar2.i = socket2.getOutputStream();
            } catch (Throwable th) {
                Log.e("PushConnection", "Connecting exception: " + th);
                Boolean unused2 = e.e = false;
                this.f709a.g();
                return;
            }
        }
        if (b.a()) {
            Log.i("PushConnection", "create Socket ok");
            com.baidu.android.pushservice.util.m.a("create Socket ok socketfd" + e.f708a);
        }
        if (PushSocket.f714a) {
            e eVar3 = this.f709a;
            context2 = this.f709a.o;
            eVar3.c = new com.baidu.android.pushservice.message.c(context2.getApplicationContext(), this.f709a);
        } else {
            e eVar4 = this.f709a;
            context = this.f709a.o;
            Context applicationContext = context.getApplicationContext();
            e eVar5 = this.f709a;
            inputStream = this.f709a.h;
            outputStream = this.f709a.i;
            eVar4.c = new com.baidu.android.pushservice.message.c(applicationContext, eVar5, inputStream, outputStream);
        }
        this.f709a.d = true;
        this.f709a.a(true);
        iVar = this.f709a.l;
        if (iVar != null) {
            iVar3 = this.f709a.l;
            iVar3.interrupt();
        }
        jVar = this.f709a.k;
        if (jVar != null) {
            jVar3 = this.f709a.k;
            jVar3.interrupt();
        }
        this.f709a.f = false;
        this.f709a.l = new i(this.f709a);
        iVar2 = this.f709a.l;
        iVar2.start();
        this.f709a.k = new j(this.f709a);
        jVar2 = this.f709a.k;
        jVar2.start();
        if (PushSocket.f714a) {
            this.f709a.c.a(e.f708a);
        } else {
            this.f709a.c.a();
        }
        Boolean unused3 = e.e = false;
    }
}
