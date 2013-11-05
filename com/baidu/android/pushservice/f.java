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
    final /* synthetic */ e f693a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f693a = eVar;
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
        if (PushSocket.f698a) {
            e.f692a = PushSocket.createSocket(w.b, w.c);
            if (e.f692a == -1) {
                Log.e("PushConnection", "Create socket err, errno:" + PushSocket.getLastSocketError());
                Boolean unused = e.e = false;
                this.f693a.f();
                return;
            }
        } else {
            try {
                this.f693a.g = new Socket(w.b, w.c);
                e eVar = this.f693a;
                socket = this.f693a.g;
                eVar.h = socket.getInputStream();
                e eVar2 = this.f693a;
                socket2 = this.f693a.g;
                eVar2.i = socket2.getOutputStream();
            } catch (Throwable th) {
                Log.e("PushConnection", "Connecting exception: " + th);
                this.f693a.f();
            }
        }
        if (b.a()) {
            Log.i("PushConnection", "create Socket ok");
            com.baidu.android.pushservice.util.n.a("create Socket ok socketfd" + e.f692a);
        }
        if (PushSocket.f698a) {
            e eVar3 = this.f693a;
            context2 = this.f693a.o;
            eVar3.c = new com.baidu.android.pushservice.message.c(context2.getApplicationContext(), this.f693a);
        } else {
            e eVar4 = this.f693a;
            context = this.f693a.o;
            Context applicationContext = context.getApplicationContext();
            e eVar5 = this.f693a;
            inputStream = this.f693a.h;
            outputStream = this.f693a.i;
            eVar4.c = new com.baidu.android.pushservice.message.c(applicationContext, eVar5, inputStream, outputStream);
        }
        this.f693a.d = true;
        this.f693a.a(true);
        iVar = this.f693a.l;
        if (iVar != null) {
            iVar3 = this.f693a.l;
            iVar3.interrupt();
        }
        jVar = this.f693a.k;
        if (jVar != null) {
            jVar3 = this.f693a.k;
            jVar3.interrupt();
        }
        this.f693a.f = false;
        this.f693a.l = new i(this.f693a);
        iVar2 = this.f693a.l;
        iVar2.start();
        this.f693a.k = new j(this.f693a);
        jVar2 = this.f693a.k;
        jVar2.start();
        if (PushSocket.f698a) {
            this.f693a.c.a(e.f692a);
        } else {
            this.f693a.c.a();
        }
        Boolean unused2 = e.e = false;
    }
}
