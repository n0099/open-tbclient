package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.util.BdLog;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends Thread {
    final /* synthetic */ n An;

    private p(n nVar) {
        this.An = nVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(n nVar, p pVar) {
        this(nVar);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str;
        int i;
        boolean z;
        boolean jN;
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
            e eVar = new e();
            n nVar = this.An;
            str = this.An.Ab;
            i = this.An.Ac;
            nVar.zY = eVar.a(str, i, this.An.Ah, false);
            z = this.An.Ak;
            if (!z) {
                try {
                    if (this.An.zY.isConnected()) {
                        this.An.Al = System.currentTimeMillis() - currentTimeMillis;
                        this.An.jS();
                        this.An.jR();
                        str2 = this.An.Ab;
                        StringBuilder append = new StringBuilder(String.valueOf(str2)).append(":");
                        i2 = this.An.Ac;
                        t tVar = new t(append.append(i2).toString());
                        str3 = this.An.Ae;
                        tVar.mPath = str3;
                        str4 = this.An.Af;
                        tVar.Ap = str4;
                        strArr = this.An.zP;
                        tVar.Aq = strArr;
                        list = this.An.zO;
                        tVar.Ar = list;
                        this.An.zX.q(tVar);
                        z2 = this.An.Ak;
                        if (z2) {
                            this.An.n(new u());
                        }
                    } else {
                        this.An.n(new w(2, "cannot connect"));
                    }
                    return;
                } catch (Throwable th) {
                    jN = this.An.jN();
                    if (jN) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    this.An.n(new x(new Exception(th)));
                    return;
                }
            }
            this.An.n(new u());
        } catch (Throwable th2) {
            this.An.n(new w(2, th2.getMessage()));
        }
    }
}
