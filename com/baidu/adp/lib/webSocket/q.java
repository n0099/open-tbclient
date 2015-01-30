package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.util.BdLog;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Thread {
    final /* synthetic */ o pO;

    private q(o oVar) {
        this.pO = oVar;
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
        boolean fZ;
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
            o oVar = this.pO;
            str = this.pO.pD;
            i = this.pO.pE;
            oVar.pA = fVar.a(str, i, this.pO.pI, false);
            z = this.pO.pL;
            if (!z) {
                try {
                    if (this.pO.pA.isConnected()) {
                        this.pO.pM = System.currentTimeMillis() - currentTimeMillis;
                        this.pO.gf();
                        this.pO.ge();
                        str2 = this.pO.pD;
                        StringBuilder append = new StringBuilder(String.valueOf(str2)).append(":");
                        i2 = this.pO.pE;
                        u uVar = new u(append.append(i2).toString());
                        str3 = this.pO.pF;
                        uVar.mPath = str3;
                        str4 = this.pO.pG;
                        uVar.pQ = str4;
                        strArr = this.pO.pr;
                        uVar.pR = strArr;
                        list = this.pO.pq;
                        uVar.pS = list;
                        this.pO.pz.q(uVar);
                        z2 = this.pO.pL;
                        if (z2) {
                            this.pO.n(new v());
                        }
                    } else {
                        this.pO.n(new x(2, "cannot connect"));
                    }
                    return;
                } catch (Throwable th) {
                    fZ = this.pO.fZ();
                    if (fZ) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    this.pO.n(new y(new Exception(th)));
                    return;
                }
            }
            this.pO.n(new v());
        } catch (Throwable th2) {
            this.pO.n(new x(2, th2.getMessage()));
        }
    }
}
