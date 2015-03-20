package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.util.BdLog;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p extends Thread {
    final /* synthetic */ n Ay;

    private p(n nVar) {
        this.Ay = nVar;
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
        boolean jw;
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
            n nVar = this.Ay;
            str = this.Ay.An;
            i = this.Ay.Ao;
            nVar.Ak = eVar.a(str, i, this.Ay.As, false);
            z = this.Ay.Av;
            if (!z) {
                try {
                    if (this.Ay.Ak.isConnected()) {
                        this.Ay.Aw = System.currentTimeMillis() - currentTimeMillis;
                        this.Ay.jB();
                        this.Ay.jA();
                        str2 = this.Ay.An;
                        StringBuilder append = new StringBuilder(String.valueOf(str2)).append(":");
                        i2 = this.Ay.Ao;
                        t tVar = new t(append.append(i2).toString());
                        str3 = this.Ay.Ap;
                        tVar.mPath = str3;
                        str4 = this.Ay.Aq;
                        tVar.AA = str4;
                        strArr = this.Ay.Aa;
                        tVar.AB = strArr;
                        list = this.Ay.zZ;
                        tVar.AC = list;
                        this.Ay.Aj.q(tVar);
                        z2 = this.Ay.Av;
                        if (z2) {
                            this.Ay.n(new u());
                        }
                    } else {
                        this.Ay.n(new w(2, "cannot connect"));
                    }
                    return;
                } catch (Throwable th) {
                    jw = this.Ay.jw();
                    if (jw) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    this.Ay.n(new x(new Exception(th)));
                    return;
                }
            }
            this.Ay.n(new u());
        } catch (Throwable th2) {
            this.Ay.n(new w(2, th2.getMessage()));
        }
    }
}
