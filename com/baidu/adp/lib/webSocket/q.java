package com.baidu.adp.lib.webSocket;

import com.baidu.adp.lib.util.BdLog;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q extends Thread {
    final /* synthetic */ o pJ;

    private q(o oVar) {
        this.pJ = oVar;
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
        boolean ga;
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
            o oVar = this.pJ;
            str = this.pJ.py;
            i = this.pJ.pz;
            oVar.pv = fVar.a(str, i, this.pJ.pD, false);
            z = this.pJ.pG;
            if (!z) {
                try {
                    if (this.pJ.pv.isConnected()) {
                        this.pJ.pH = System.currentTimeMillis() - currentTimeMillis;
                        this.pJ.gg();
                        this.pJ.gf();
                        str2 = this.pJ.py;
                        StringBuilder append = new StringBuilder(String.valueOf(str2)).append(":");
                        i2 = this.pJ.pz;
                        u uVar = new u(append.append(i2).toString());
                        str3 = this.pJ.pA;
                        uVar.mPath = str3;
                        str4 = this.pJ.pB;
                        uVar.pL = str4;
                        strArr = this.pJ.pj;
                        uVar.pM = strArr;
                        list = this.pJ.pi;
                        uVar.pN = list;
                        this.pJ.pu.q(uVar);
                        z2 = this.pJ.pG;
                        if (z2) {
                            this.pJ.n(new v());
                        }
                    } else {
                        this.pJ.n(new x(2, "cannot connect"));
                    }
                    return;
                } catch (Throwable th) {
                    ga = this.pJ.ga();
                    if (ga) {
                        BdLog.e("----WebSocketConnector error. e:" + th.getMessage());
                    }
                    this.pJ.n(new y(new Exception(th)));
                    return;
                }
            }
            this.pJ.n(new v());
        } catch (Throwable th2) {
            this.pJ.n(new x(2, th2.getMessage()));
        }
    }
}
