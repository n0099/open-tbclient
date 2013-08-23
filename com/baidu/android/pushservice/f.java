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
    final /* synthetic */ e f602a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f602a = eVar;
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
        if (PushSocket.f607a) {
            e.f601a = PushSocket.createSocket(w.b, w.c);
            if (e.f601a == -1) {
                Log.e("PushConnection", "Create socket err, errno:" + PushSocket.getLastSocketError());
                Boolean unused = e.e = false;
                this.f602a.f();
                return;
            }
        } else {
            try {
                this.f602a.g = new Socket(w.b, w.c);
                e eVar = this.f602a;
                socket = this.f602a.g;
                eVar.h = socket.getInputStream();
                e eVar2 = this.f602a;
                socket2 = this.f602a.g;
                eVar2.i = socket2.getOutputStream();
            } catch (Throwable th) {
                Log.e("PushConnection", "Connecting exception: " + th);
                this.f602a.f();
            }
        }
        if (b.a()) {
            Log.i("PushConnection", "create Socket ok");
            com.baidu.android.pushservice.util.n.a("create Socket ok socketfd" + e.f601a);
        }
        if (PushSocket.f607a) {
            e eVar3 = this.f602a;
            context2 = this.f602a.o;
            eVar3.c = new com.baidu.android.pushservice.message.c(context2.getApplicationContext(), this.f602a);
        } else {
            e eVar4 = this.f602a;
            context = this.f602a.o;
            Context applicationContext = context.getApplicationContext();
            e eVar5 = this.f602a;
            inputStream = this.f602a.h;
            outputStream = this.f602a.i;
            eVar4.c = new com.baidu.android.pushservice.message.c(applicationContext, eVar5, inputStream, outputStream);
        }
        this.f602a.d = true;
        this.f602a.a(true);
        iVar = this.f602a.l;
        if (iVar != null) {
            iVar3 = this.f602a.l;
            iVar3.interrupt();
        }
        jVar = this.f602a.k;
        if (jVar != null) {
            jVar3 = this.f602a.k;
            jVar3.interrupt();
        }
        this.f602a.f = false;
        this.f602a.l = new i(this.f602a);
        iVar2 = this.f602a.l;
        iVar2.start();
        this.f602a.k = new j(this.f602a);
        jVar2 = this.f602a.k;
        jVar2.start();
        if (PushSocket.f607a) {
            this.f602a.c.a(e.f601a);
        } else {
            this.f602a.c.a();
        }
        Boolean unused2 = e.e = false;
    }
}
