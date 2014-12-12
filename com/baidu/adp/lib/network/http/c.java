package com.baidu.adp.lib.network.http;

import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
public class c {
    private e cT;
    private a kk;

    public c(e eVar) {
        this.cT = eVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=6, 127=6] */
    public void i(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.bw().bz().bA();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.bw().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.bw().bx().bA();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.cT.dQ().kF && z && i4 < i; i4++) {
            d dVar = new d();
            try {
                try {
                    try {
                        dVar.retry = i4 + 1;
                        this.kk = new a(this.cT);
                        this.kk.a(i2, i3, dVar);
                    } catch (SocketException e) {
                        dVar.ks = String.valueOf(String.valueOf(this.cT.dQ().responseCode)) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.cT.dQ().responseCode = -12;
                        this.cT.a(dVar);
                        dVar.kq = System.currentTimeMillis() - currentTimeMillis;
                        this.cT.a(dVar);
                        z = true;
                    }
                } catch (SocketTimeoutException e2) {
                    dVar.ks = String.valueOf(String.valueOf(this.cT.dQ().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.cT.dQ().responseCode = -13;
                    this.cT.a(dVar);
                    dVar.kq = System.currentTimeMillis() - currentTimeMillis;
                    this.cT.a(dVar);
                    z = true;
                } catch (Exception e3) {
                    dVar.ks = String.valueOf(String.valueOf(this.cT.dQ().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.cT.dQ().responseCode = -10;
                    BdLog.e(e3.getMessage());
                    this.cT.a(dVar);
                    dVar.kq = System.currentTimeMillis() - currentTimeMillis;
                    this.cT.a(dVar);
                    return;
                }
                if (this.cT.dQ().responseCode == 200) {
                    dVar.kq = System.currentTimeMillis() - currentTimeMillis;
                    this.cT.a(dVar);
                    return;
                }
                dVar.ks = String.valueOf(String.valueOf(this.cT.dQ().responseCode)) + "|retryCount:" + i4;
                z = M(this.cT.dQ().responseCode);
                this.cT.a(dVar);
                dVar.kq = System.currentTimeMillis() - currentTimeMillis;
                this.cT.a(dVar);
            } catch (Throwable th) {
                dVar.kq = System.currentTimeMillis() - currentTimeMillis;
                this.cT.a(dVar);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [197=7, 198=7] */
    private void j(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.bw().bz().bA();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.bw().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.bw().bx().bA();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.cT.dQ().kF && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.kk = new a(this.cT);
                        this.kk.b(i2, i3, dVar);
                    } catch (SocketException e) {
                        this.cT.dQ().responseCode = -12;
                        dVar.ks = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.cT.a(dVar);
                        dVar.kq = System.currentTimeMillis() - currentTimeMillis;
                        this.cT.a(dVar);
                        z = true;
                    }
                } catch (UnsupportedOperationException e2) {
                    this.cT.dQ().responseCode = -14;
                    dVar.ks = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.cT.a(dVar);
                    dVar.kq = System.currentTimeMillis() - currentTimeMillis;
                    this.cT.a(dVar);
                    z = false;
                } catch (SocketTimeoutException e3) {
                    this.cT.dQ().responseCode = -13;
                    dVar.ks = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.cT.a(dVar);
                    dVar.kq = System.currentTimeMillis() - currentTimeMillis;
                    this.cT.a(dVar);
                    z = true;
                }
                if (this.cT.dQ().responseCode == 200) {
                    return;
                }
                dVar.ks = String.valueOf(String.valueOf(this.cT.dQ().responseCode)) + "|retryCount:" + i4;
                z = M(this.cT.dQ().responseCode);
                this.cT.a(dVar);
            } finally {
                dVar.kq = System.currentTimeMillis() - currentTimeMillis;
                this.cT.a(dVar);
            }
        }
    }

    private boolean M(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void k(int i, int i2, int i3) {
        if (this.cT.dP().dS()) {
            j(i, i2, i3);
        } else {
            l(i, i2, i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [297=7, 298=7] */
    private void l(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.bw().bz().bA();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.bw().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.bw().bx().bA();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.cT.dQ().kF && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.kk = new a(this.cT);
                        this.kk.c(i2, i3, dVar);
                    } catch (SocketException e) {
                        this.cT.dQ().responseCode = -12;
                        dVar.ks = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.cT.a(dVar);
                        dVar.kq = System.currentTimeMillis() - currentTimeMillis;
                        this.cT.a(dVar);
                        z = true;
                    }
                } catch (UnsupportedOperationException e2) {
                    this.cT.dQ().responseCode = -14;
                    dVar.ks = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.cT.a(dVar);
                    dVar.kq = System.currentTimeMillis() - currentTimeMillis;
                    this.cT.a(dVar);
                    z = false;
                } catch (SocketTimeoutException e3) {
                    this.cT.dQ().responseCode = -13;
                    dVar.ks = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.cT.a(dVar);
                    dVar.kq = System.currentTimeMillis() - currentTimeMillis;
                    this.cT.a(dVar);
                    z = true;
                }
                if (this.cT.dQ().responseCode == 200) {
                    return;
                }
                dVar.ks = String.valueOf(String.valueOf(this.cT.dQ().responseCode)) + "|retryCount:" + i4;
                z = M(this.cT.dQ().responseCode);
                this.cT.a(dVar);
            } finally {
                dVar.kq = System.currentTimeMillis() - currentTimeMillis;
                this.cT.a(dVar);
            }
        }
    }

    public void cancel() {
        if (this.kk != null) {
            this.kk.dL();
        }
    }

    public long dM() {
        if (this.kk == null) {
            return -1L;
        }
        return this.kk.dK();
    }

    public long dN() {
        if (this.kk == null) {
            return -1L;
        }
        return this.kk.dJ();
    }

    public long dO() {
        if (this.kk == null) {
            return -1L;
        }
        return this.kk.dI();
    }
}
