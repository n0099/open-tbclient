package com.baidu.adp.lib.network.http;

import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
public class c {
    private e aN;
    private a kj;

    public c(e eVar) {
        this.aN = eVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=6, 127=6] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.aV().aY().aZ();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.aV().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.aV().aW().aZ();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.aN.dR().kE && z && i4 < i; i4++) {
            d dVar = new d();
            try {
                try {
                    try {
                        dVar.retry = i4 + 1;
                        this.kj = new a(this.aN);
                        this.kj.a(i2, i3, dVar);
                    } catch (SocketException e) {
                        dVar.kr = String.valueOf(String.valueOf(this.aN.dR().responseCode)) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.aN.dR().responseCode = -12;
                        this.aN.a(dVar);
                        dVar.kp = System.currentTimeMillis() - currentTimeMillis;
                        this.aN.a(dVar);
                        z = true;
                    }
                } catch (SocketTimeoutException e2) {
                    dVar.kr = String.valueOf(String.valueOf(this.aN.dR().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.aN.dR().responseCode = -13;
                    this.aN.a(dVar);
                    dVar.kp = System.currentTimeMillis() - currentTimeMillis;
                    this.aN.a(dVar);
                    z = true;
                } catch (Exception e3) {
                    dVar.kr = String.valueOf(String.valueOf(this.aN.dR().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.aN.dR().responseCode = -10;
                    BdLog.e(e3.getMessage());
                    this.aN.a(dVar);
                    dVar.kp = System.currentTimeMillis() - currentTimeMillis;
                    this.aN.a(dVar);
                    return;
                }
                if (this.aN.dR().responseCode == 200) {
                    dVar.kp = System.currentTimeMillis() - currentTimeMillis;
                    this.aN.a(dVar);
                    return;
                }
                dVar.kr = String.valueOf(String.valueOf(this.aN.dR().responseCode)) + "|retryCount:" + i4;
                z = E(this.aN.dR().responseCode);
                this.aN.a(dVar);
                dVar.kp = System.currentTimeMillis() - currentTimeMillis;
                this.aN.a(dVar);
            } catch (Throwable th) {
                dVar.kp = System.currentTimeMillis() - currentTimeMillis;
                this.aN.a(dVar);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [197=7, 198=7] */
    private void e(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.aV().aY().aZ();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.aV().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.aV().aW().aZ();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.aN.dR().kE && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.kj = new a(this.aN);
                        this.kj.b(i2, i3, dVar);
                    } catch (SocketException e) {
                        this.aN.dR().responseCode = -12;
                        dVar.kr = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.aN.a(dVar);
                        dVar.kp = System.currentTimeMillis() - currentTimeMillis;
                        this.aN.a(dVar);
                        z = true;
                    }
                } catch (UnsupportedOperationException e2) {
                    this.aN.dR().responseCode = -14;
                    dVar.kr = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.aN.a(dVar);
                    dVar.kp = System.currentTimeMillis() - currentTimeMillis;
                    this.aN.a(dVar);
                    z = false;
                } catch (SocketTimeoutException e3) {
                    this.aN.dR().responseCode = -13;
                    dVar.kr = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.aN.a(dVar);
                    dVar.kp = System.currentTimeMillis() - currentTimeMillis;
                    this.aN.a(dVar);
                    z = true;
                }
                if (this.aN.dR().responseCode == 200) {
                    return;
                }
                dVar.kr = String.valueOf(String.valueOf(this.aN.dR().responseCode)) + "|retryCount:" + i4;
                z = E(this.aN.dR().responseCode);
                this.aN.a(dVar);
            } finally {
                dVar.kp = System.currentTimeMillis() - currentTimeMillis;
                this.aN.a(dVar);
            }
        }
    }

    private boolean E(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.aN.dQ().dT()) {
            e(i, i2, i3);
        } else {
            g(i, i2, i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [297=7, 298=7] */
    private void g(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.aV().aY().aZ();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.aV().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.aV().aW().aZ();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.aN.dR().kE && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.kj = new a(this.aN);
                        this.kj.c(i2, i3, dVar);
                    } catch (SocketException e) {
                        this.aN.dR().responseCode = -12;
                        dVar.kr = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.aN.a(dVar);
                        dVar.kp = System.currentTimeMillis() - currentTimeMillis;
                        this.aN.a(dVar);
                        z = true;
                    }
                } catch (UnsupportedOperationException e2) {
                    this.aN.dR().responseCode = -14;
                    dVar.kr = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.aN.a(dVar);
                    dVar.kp = System.currentTimeMillis() - currentTimeMillis;
                    this.aN.a(dVar);
                    z = false;
                } catch (SocketTimeoutException e3) {
                    this.aN.dR().responseCode = -13;
                    dVar.kr = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.aN.a(dVar);
                    dVar.kp = System.currentTimeMillis() - currentTimeMillis;
                    this.aN.a(dVar);
                    z = true;
                }
                if (this.aN.dR().responseCode == 200) {
                    return;
                }
                dVar.kr = String.valueOf(String.valueOf(this.aN.dR().responseCode)) + "|retryCount:" + i4;
                z = E(this.aN.dR().responseCode);
                this.aN.a(dVar);
            } finally {
                dVar.kp = System.currentTimeMillis() - currentTimeMillis;
                this.aN.a(dVar);
            }
        }
    }

    public void cancel() {
        if (this.kj != null) {
            this.kj.dM();
        }
    }

    public long dN() {
        if (this.kj == null) {
            return -1L;
        }
        return this.kj.dL();
    }

    public long dO() {
        if (this.kj == null) {
            return -1L;
        }
        return this.kj.dK();
    }

    public long dP() {
        if (this.kj == null) {
            return -1L;
        }
        return this.kj.dJ();
    }
}
