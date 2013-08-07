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
    final /* synthetic */ e f579a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f579a = eVar;
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
        if (PushSocket.f584a) {
            e.f578a = PushSocket.createSocket(w.b, w.c);
            if (e.f578a == -1) {
                Log.e("PushConnection", "Create socket err, errno:" + PushSocket.getLastSocketError());
                Boolean unused = e.e = false;
                this.f579a.f();
                return;
            }
        } else {
            try {
                this.f579a.g = new Socket(w.b, w.c);
                e eVar = this.f579a;
                socket = this.f579a.g;
                eVar.h = socket.getInputStream();
                e eVar2 = this.f579a;
                socket2 = this.f579a.g;
                eVar2.i = socket2.getOutputStream();
            } catch (Throwable th) {
                Log.e("PushConnection", "Connecting exception: " + th);
                this.f579a.f();
            }
        }
        if (b.a()) {
            Log.i("PushConnection", "create Socket ok");
            com.baidu.android.pushservice.util.n.a("create Socket ok socketfd" + e.f578a);
        }
        if (PushSocket.f584a) {
            e eVar3 = this.f579a;
            context2 = this.f579a.o;
            eVar3.c = new com.baidu.android.pushservice.message.c(context2.getApplicationContext(), this.f579a);
        } else {
            e eVar4 = this.f579a;
            context = this.f579a.o;
            Context applicationContext = context.getApplicationContext();
            e eVar5 = this.f579a;
            inputStream = this.f579a.h;
            outputStream = this.f579a.i;
            eVar4.c = new com.baidu.android.pushservice.message.c(applicationContext, eVar5, inputStream, outputStream);
        }
        this.f579a.d = true;
        this.f579a.a(true);
        iVar = this.f579a.l;
        if (iVar != null) {
            iVar3 = this.f579a.l;
            iVar3.interrupt();
        }
        jVar = this.f579a.k;
        if (jVar != null) {
            jVar3 = this.f579a.k;
            jVar3.interrupt();
        }
        this.f579a.f = false;
        this.f579a.l = new i(this.f579a);
        iVar2 = this.f579a.l;
        iVar2.start();
        this.f579a.k = new j(this.f579a);
        jVar2 = this.f579a.k;
        jVar2.start();
        if (PushSocket.f584a) {
            this.f579a.c.a(e.f578a);
        } else {
            this.f579a.c.a();
        }
        Boolean unused2 = e.e = false;
    }
}
