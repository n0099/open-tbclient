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
    final /* synthetic */ e f614a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f614a = eVar;
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
        if (PushSocket.f619a) {
            e.f613a = PushSocket.createSocket(w.b, w.c);
            if (e.f613a == -1) {
                Log.e("PushConnection", "Create socket err, errno:" + PushSocket.getLastSocketError());
                Boolean unused = e.e = false;
                this.f614a.f();
                return;
            }
        } else {
            try {
                this.f614a.g = new Socket(w.b, w.c);
                e eVar = this.f614a;
                socket = this.f614a.g;
                eVar.h = socket.getInputStream();
                e eVar2 = this.f614a;
                socket2 = this.f614a.g;
                eVar2.i = socket2.getOutputStream();
            } catch (Throwable th) {
                Log.e("PushConnection", "Connecting exception: " + th);
                this.f614a.f();
            }
        }
        if (b.a()) {
            Log.i("PushConnection", "create Socket ok");
            com.baidu.android.pushservice.util.n.a("create Socket ok socketfd" + e.f613a);
        }
        if (PushSocket.f619a) {
            e eVar3 = this.f614a;
            context2 = this.f614a.o;
            eVar3.c = new com.baidu.android.pushservice.message.c(context2.getApplicationContext(), this.f614a);
        } else {
            e eVar4 = this.f614a;
            context = this.f614a.o;
            Context applicationContext = context.getApplicationContext();
            e eVar5 = this.f614a;
            inputStream = this.f614a.h;
            outputStream = this.f614a.i;
            eVar4.c = new com.baidu.android.pushservice.message.c(applicationContext, eVar5, inputStream, outputStream);
        }
        this.f614a.d = true;
        this.f614a.a(true);
        iVar = this.f614a.l;
        if (iVar != null) {
            iVar3 = this.f614a.l;
            iVar3.interrupt();
        }
        jVar = this.f614a.k;
        if (jVar != null) {
            jVar3 = this.f614a.k;
            jVar3.interrupt();
        }
        this.f614a.f = false;
        this.f614a.l = new i(this.f614a);
        iVar2 = this.f614a.l;
        iVar2.start();
        this.f614a.k = new j(this.f614a);
        jVar2 = this.f614a.k;
        jVar2.start();
        if (PushSocket.f619a) {
            this.f614a.c.a(e.f613a);
        } else {
            this.f614a.c.a();
        }
        Boolean unused2 = e.e = false;
    }
}
