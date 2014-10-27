package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.util.BdLog;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Thread {
    final /* synthetic */ o pL;

    private q(o oVar) {
        this.pL = oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(o oVar, q qVar) {
        this(oVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        int i;
        boolean z;
        boolean fY;
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
            f fVar = new f();
            o oVar = this.pL;
            str = this.pL.pA;
            i = this.pL.pB;
            oVar.px = fVar.a(str, i, this.pL.pF, false);
            z = this.pL.pI;
            if (!z) {
                try {
                    if (this.pL.px.isConnected()) {
                        this.pL.pJ = System.currentTimeMillis() - currentTimeMillis;
                        this.pL.gf();
                        this.pL.ge();
                        str2 = this.pL.pA;
                        StringBuilder append = new StringBuilder(String.valueOf(str2)).append(":");
                        i2 = this.pL.pB;
                        u uVar = new u(append.append(i2).toString());
                        str3 = this.pL.pC;
                        uVar.dM = str3;
                        str4 = this.pL.pD;
                        uVar.pO = str4;
                        strArr = this.pL.po;
                        uVar.pQ = strArr;
                        list = this.pL.pl;
                        uVar.pR = list;
                        this.pL.pw.o(uVar);
                        z2 = this.pL.pI;
                        if (z2) {
                            this.pL.l(new v());
                        }
                    } else {
                        this.pL.l(new x(2, "cannot connect"));
                    }
                    return;
                } catch (Throwable th) {
                    fY = this.pL.fY();
                    if (fY) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    this.pL.l(new y(new Exception(th)));
                    return;
                }
            }
            this.pL.l(new v());
        } catch (Throwable th2) {
            this.pL.l(new x(2, th2.getMessage()));
        }
    }
}
