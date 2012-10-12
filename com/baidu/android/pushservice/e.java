package com.baidu.android.pushservice;

import android.content.Context;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {
    final /* synthetic */ d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.a = dVar;
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
        h hVar;
        h hVar2;
        i iVar;
        OutputStream outputStream2;
        i iVar2;
        i iVar3;
        h hVar3;
        try {
            d dVar = this.a;
            str = this.a.c;
            i = this.a.d;
            dVar.i = new Socket(str, i);
            d dVar2 = this.a;
            socket = this.a.i;
            dVar2.j = socket.getInputStream();
            d dVar3 = this.a;
            socket2 = this.a.i;
            dVar3.k = socket2.getOutputStream();
            d dVar4 = this.a;
            pushService = this.a.p;
            Context applicationContext = pushService.getApplicationContext();
            d dVar5 = this.a;
            inputStream = this.a.j;
            outputStream = this.a.k;
            dVar4.b = new com.baidu.android.pushservice.message.c(applicationContext, dVar5, inputStream, outputStream);
            hVar = this.a.n;
            if (hVar != null) {
                hVar3 = this.a.n;
                hVar3.interrupt();
            }
            this.a.n = new h(this.a);
            hVar2 = this.a.n;
            hVar2.start();
            iVar = this.a.m;
            if (iVar != null) {
                iVar3 = this.a.m;
                iVar3.interrupt();
            }
            d dVar6 = this.a;
            d dVar7 = this.a;
            outputStream2 = this.a.k;
            dVar6.m = new i(dVar7, outputStream2);
            iVar2 = this.a.m;
            iVar2.start();
            this.a.e = true;
            this.a.b.b();
        } catch (Throwable th) {
            this.a.f();
        }
        this.a.f = false;
    }
}
