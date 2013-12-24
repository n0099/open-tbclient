package com.baidu.adp.lib.webSocket;

import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Thread {
    final /* synthetic */ o a;

    private q(o oVar) {
        this.a = oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(o oVar, p pVar) {
        this(oVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        int i;
        boolean z;
        boolean k;
        String str2;
        int i2;
        String str3;
        String str4;
        String[] strArr;
        List<BasicNameValuePair> list;
        boolean z2;
        Thread.currentThread().setName("WebSocketConnector");
        try {
            f fVar = new f();
            o oVar = this.a;
            str = this.a.h;
            i = this.a.i;
            oVar.d = fVar.a(str, i, this.a.e, false);
            z = this.a.q;
            if (z) {
                this.a.b(new v());
            } else if (!this.a.d.b()) {
                this.a.b(new x());
            } else {
                try {
                    this.a.c();
                    this.a.b();
                    StringBuilder sb = new StringBuilder();
                    str2 = this.a.h;
                    StringBuilder append = sb.append(str2).append(":");
                    i2 = this.a.i;
                    u uVar = new u(append.append(i2).toString());
                    str3 = this.a.j;
                    uVar.b = str3;
                    str4 = this.a.k;
                    uVar.c = str4;
                    strArr = this.a.l;
                    uVar.e = strArr;
                    list = this.a.m;
                    uVar.f = list;
                    this.a.c.a((Object) uVar);
                    z2 = this.a.q;
                    if (z2) {
                        this.a.b(new v());
                    }
                } catch (Throwable th) {
                    k = this.a.k();
                    if (k) {
                        com.baidu.adp.lib.h.e.c("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    this.a.b(new y(new Exception(th)));
                }
            }
        } catch (Throwable th2) {
            this.a.b(new x());
        }
    }
}
