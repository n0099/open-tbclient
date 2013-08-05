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
    final /* synthetic */ e f581a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f581a = eVar;
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
        if (PushSocket.f586a) {
            e.f580a = PushSocket.createSocket(w.b, w.c);
            if (e.f580a == -1) {
                Log.e("PushConnection", "Create socket err, errno:" + PushSocket.getLastSocketError());
                Boolean unused = e.e = false;
                this.f581a.f();
                return;
            }
        } else {
            try {
                this.f581a.g = new Socket(w.b, w.c);
                e eVar = this.f581a;
                socket = this.f581a.g;
                eVar.h = socket.getInputStream();
                e eVar2 = this.f581a;
                socket2 = this.f581a.g;
                eVar2.i = socket2.getOutputStream();
            } catch (Throwable th) {
                Log.e("PushConnection", "Connecting exception: " + th);
                this.f581a.f();
            }
        }
        if (b.a()) {
            Log.i("PushConnection", "create Socket ok");
            com.baidu.android.pushservice.util.n.a("create Socket ok socketfd" + e.f580a);
        }
        if (PushSocket.f586a) {
            e eVar3 = this.f581a;
            context2 = this.f581a.o;
            eVar3.c = new com.baidu.android.pushservice.message.c(context2.getApplicationContext(), this.f581a);
        } else {
            e eVar4 = this.f581a;
            context = this.f581a.o;
            Context applicationContext = context.getApplicationContext();
            e eVar5 = this.f581a;
            inputStream = this.f581a.h;
            outputStream = this.f581a.i;
            eVar4.c = new com.baidu.android.pushservice.message.c(applicationContext, eVar5, inputStream, outputStream);
        }
        this.f581a.d = true;
        this.f581a.a(true);
        iVar = this.f581a.l;
        if (iVar != null) {
            iVar3 = this.f581a.l;
            iVar3.interrupt();
        }
        jVar = this.f581a.k;
        if (jVar != null) {
            jVar3 = this.f581a.k;
            jVar3.interrupt();
        }
        this.f581a.f = false;
        this.f581a.l = new i(this.f581a);
        iVar2 = this.f581a.l;
        iVar2.start();
        this.f581a.k = new j(this.f581a);
        jVar2 = this.f581a.k;
        jVar2.start();
        if (PushSocket.f586a) {
            this.f581a.c.a(e.f580a);
        } else {
            this.f581a.c.a();
        }
        Boolean unused2 = e.e = false;
    }
}
