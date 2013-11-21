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
    final /* synthetic */ e f710a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f710a = eVar;
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
        if (PushSocket.f715a) {
            e.f709a = PushSocket.createSocket(w.b, w.c);
            if (e.f709a == -1) {
                Log.e("PushConnection", "Create socket err, errno:" + PushSocket.getLastSocketError());
                Boolean unused = e.e = false;
                this.f710a.g();
                return;
            }
        } else {
            try {
                this.f710a.g = new Socket(w.b, w.c);
                e eVar = this.f710a;
                socket = this.f710a.g;
                eVar.h = socket.getInputStream();
                e eVar2 = this.f710a;
                socket2 = this.f710a.g;
                eVar2.i = socket2.getOutputStream();
            } catch (Throwable th) {
                Log.e("PushConnection", "Connecting exception: " + th);
                Boolean unused2 = e.e = false;
                this.f710a.g();
                return;
            }
        }
        if (b.a()) {
            Log.i("PushConnection", "create Socket ok");
            com.baidu.android.pushservice.util.m.a("create Socket ok socketfd" + e.f709a);
        }
        if (PushSocket.f715a) {
            e eVar3 = this.f710a;
            context2 = this.f710a.o;
            eVar3.c = new com.baidu.android.pushservice.message.c(context2.getApplicationContext(), this.f710a);
        } else {
            e eVar4 = this.f710a;
            context = this.f710a.o;
            Context applicationContext = context.getApplicationContext();
            e eVar5 = this.f710a;
            inputStream = this.f710a.h;
            outputStream = this.f710a.i;
            eVar4.c = new com.baidu.android.pushservice.message.c(applicationContext, eVar5, inputStream, outputStream);
        }
        this.f710a.d = true;
        this.f710a.a(true);
        iVar = this.f710a.l;
        if (iVar != null) {
            iVar3 = this.f710a.l;
            iVar3.interrupt();
        }
        jVar = this.f710a.k;
        if (jVar != null) {
            jVar3 = this.f710a.k;
            jVar3.interrupt();
        }
        this.f710a.f = false;
        this.f710a.l = new i(this.f710a);
        iVar2 = this.f710a.l;
        iVar2.start();
        this.f710a.k = new j(this.f710a);
        jVar2 = this.f710a.k;
        jVar2.start();
        if (PushSocket.f715a) {
            this.f710a.c.a(e.f709a);
        } else {
            this.f710a.c.a();
        }
        Boolean unused3 = e.e = false;
    }
}
