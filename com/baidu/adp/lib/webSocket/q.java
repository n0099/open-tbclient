package com.baidu.adp.lib.webSocket;

import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Thread {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ o f544a;

    private q(o oVar) {
        this.f544a = oVar;
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
            o oVar = this.f544a;
            str = this.f544a.h;
            i = this.f544a.i;
            oVar.d = fVar.a(str, i, this.f544a.e, false);
            z = this.f544a.q;
            if (z) {
                this.f544a.b(new v());
            } else if (!this.f544a.d.b()) {
                this.f544a.b(new x());
            } else {
                try {
                    this.f544a.c();
                    this.f544a.b();
                    StringBuilder sb = new StringBuilder();
                    str2 = this.f544a.h;
                    StringBuilder append = sb.append(str2).append(":");
                    i2 = this.f544a.i;
                    u uVar = new u(append.append(i2).toString());
                    str3 = this.f544a.j;
                    uVar.b = str3;
                    str4 = this.f544a.k;
                    uVar.c = str4;
                    strArr = this.f544a.l;
                    uVar.e = strArr;
                    list = this.f544a.m;
                    uVar.f = list;
                    this.f544a.c.a((Object) uVar);
                    z2 = this.f544a.q;
                    if (z2) {
                        this.f544a.b(new v());
                    }
                } catch (Throwable th) {
                    k = this.f544a.k();
                    if (k) {
                        com.baidu.adp.lib.h.e.c("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    this.f544a.b(new y(new Exception(th)));
                }
            }
        } catch (Throwable th2) {
            this.f544a.b(new x());
        }
    }
}
