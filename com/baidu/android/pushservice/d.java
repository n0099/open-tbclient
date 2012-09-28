package com.baidu.android.pushservice;

import android.content.Context;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ c a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i;
        Socket socket;
        Socket socket2;
        PushService pushService;
        InputStream inputStream;
        OutputStream outputStream;
        g gVar;
        g gVar2;
        h hVar;
        OutputStream outputStream2;
        h hVar2;
        h hVar3;
        g gVar3;
        try {
            c cVar = this.a;
            str = this.a.c;
            i = this.a.d;
            cVar.i = new Socket(str, i);
            c cVar2 = this.a;
            socket = this.a.i;
            cVar2.j = socket.getInputStream();
            c cVar3 = this.a;
            socket2 = this.a.i;
            cVar3.k = socket2.getOutputStream();
            c cVar4 = this.a;
            pushService = this.a.p;
            Context applicationContext = pushService.getApplicationContext();
            c cVar5 = this.a;
            inputStream = this.a.j;
            outputStream = this.a.k;
            cVar4.b = new com.baidu.android.pushservice.message.c(applicationContext, cVar5, inputStream, outputStream);
            gVar = this.a.n;
            if (gVar != null) {
                gVar3 = this.a.n;
                gVar3.interrupt();
            }
            this.a.n = new g(this.a);
            gVar2 = this.a.n;
            gVar2.start();
            hVar = this.a.m;
            if (hVar != null) {
                hVar3 = this.a.m;
                hVar3.interrupt();
            }
            c cVar6 = this.a;
            c cVar7 = this.a;
            outputStream2 = this.a.k;
            cVar6.m = new h(cVar7, outputStream2);
            hVar2 = this.a.m;
            hVar2.start();
            this.a.e = true;
            this.a.b.b();
        } catch (Throwable th) {
            this.a.f();
        }
        this.a.f = false;
    }
}
