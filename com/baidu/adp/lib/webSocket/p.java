package com.baidu.adp.lib.webSocket;

import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ n f540a;

    private p(n nVar) {
        this.f540a = nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(n nVar, o oVar) {
        this(nVar);
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
            e eVar = new e();
            n nVar = this.f540a;
            str = this.f540a.h;
            i = this.f540a.i;
            nVar.d = eVar.a(str, i, this.f540a.e, false);
            z = this.f540a.q;
            if (z) {
                this.f540a.b(new u());
            } else if (!this.f540a.d.b()) {
                this.f540a.b(new w());
            } else {
                try {
                    this.f540a.c();
                    this.f540a.b();
                    StringBuilder sb = new StringBuilder();
                    str2 = this.f540a.h;
                    StringBuilder append = sb.append(str2).append(":");
                    i2 = this.f540a.i;
                    t tVar = new t(append.append(i2).toString());
                    str3 = this.f540a.j;
                    tVar.b = str3;
                    str4 = this.f540a.k;
                    tVar.c = str4;
                    strArr = this.f540a.l;
                    tVar.e = strArr;
                    list = this.f540a.m;
                    tVar.f = list;
                    this.f540a.c.a((Object) tVar);
                    z2 = this.f540a.q;
                    if (z2) {
                        this.f540a.b(new u());
                    }
                } catch (Throwable th) {
                    k = this.f540a.k();
                    if (k) {
                        com.baidu.adp.lib.h.d.c("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    this.f540a.b(new x(new Exception(th)));
                }
            }
        } catch (Throwable th2) {
            this.f540a.b(new w());
        }
    }
}
