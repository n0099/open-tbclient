package com.baidu.adp.lib.webSocket;

import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p extends Thread {
    final /* synthetic */ n a;

    private p(n nVar) {
        this.a = nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(n nVar, byte b) {
        this(nVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        String str;
        int i;
        boolean z;
        boolean d;
        String str2;
        int i2;
        String str3;
        String str4;
        String[] strArr;
        List<BasicNameValuePair> list;
        boolean z2;
        Thread.currentThread().setName("WebSocketConnector");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            new f();
            n nVar = this.a;
            str = this.a.h;
            i = this.a.i;
            nVar.d = new h(str, i, this.a.e);
            z = this.a.q;
            if (!z) {
                if (this.a.d.b()) {
                    this.a.r = System.currentTimeMillis() - currentTimeMillis;
                    try {
                        this.a.b();
                        this.a.a();
                        str2 = this.a.h;
                        StringBuilder append = new StringBuilder(String.valueOf(str2)).append(":");
                        i2 = this.a.i;
                        t tVar = new t(append.append(i2).toString());
                        str3 = this.a.j;
                        tVar.b = str3;
                        str4 = this.a.k;
                        tVar.c = str4;
                        strArr = this.a.l;
                        tVar.e = strArr;
                        list = this.a.m;
                        tVar.f = list;
                        this.a.c.a(tVar);
                        z2 = this.a.q;
                        if (!z2) {
                            return;
                        }
                        this.a.a(new u());
                        return;
                    } catch (Throwable th) {
                        n nVar2 = this.a;
                        d = com.baidu.adp.a.b.a().d();
                        if (d) {
                            com.baidu.adp.lib.util.f.d("----WebSocketConnector error. e:" + th.getMessage());
                        }
                        this.a.a(new x(new Exception(th)));
                        return;
                    }
                }
                this.a.a(new w());
                return;
            }
            this.a.a(new u());
        } catch (Throwable th2) {
            this.a.a(new w());
        }
    }
}
