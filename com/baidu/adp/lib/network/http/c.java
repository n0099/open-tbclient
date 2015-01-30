package com.baidu.adp.lib.network.http;

import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
public class c {
    private e cU;
    private a ko;

    public c(e eVar) {
        this.cU = eVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [128=6, 127=6] */
    public void i(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.bu().bx().by();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.bu().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.bu().bv().by();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.cU.dO().kI && z && i4 < i; i4++) {
            d dVar = new d();
            try {
                try {
                    try {
                        dVar.retry = i4 + 1;
                        this.ko = new a(this.cU);
                        this.ko.a(i2, i3, dVar);
                    } catch (SocketException e) {
                        dVar.kv = String.valueOf(String.valueOf(this.cU.dO().responseCode)) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.cU.dO().responseCode = -12;
                        this.cU.a(dVar);
                        dVar.kt = System.currentTimeMillis() - currentTimeMillis;
                        this.cU.a(dVar);
                        z = true;
                    }
                } catch (SocketTimeoutException e2) {
                    dVar.kv = String.valueOf(String.valueOf(this.cU.dO().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.cU.dO().responseCode = -13;
                    this.cU.a(dVar);
                    dVar.kt = System.currentTimeMillis() - currentTimeMillis;
                    this.cU.a(dVar);
                    z = true;
                } catch (Exception e3) {
                    dVar.kv = String.valueOf(String.valueOf(this.cU.dO().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.cU.dO().responseCode = -10;
                    BdLog.e(e3.getMessage());
                    this.cU.a(dVar);
                    dVar.kt = System.currentTimeMillis() - currentTimeMillis;
                    this.cU.a(dVar);
                    return;
                }
                if (this.cU.dO().responseCode == 200) {
                    dVar.kt = System.currentTimeMillis() - currentTimeMillis;
                    this.cU.a(dVar);
                    return;
                }
                dVar.kv = String.valueOf(String.valueOf(this.cU.dO().responseCode)) + "|retryCount:" + i4;
                z = R(this.cU.dO().responseCode);
                this.cU.a(dVar);
                dVar.kt = System.currentTimeMillis() - currentTimeMillis;
                this.cU.a(dVar);
            } catch (Throwable th) {
                dVar.kt = System.currentTimeMillis() - currentTimeMillis;
                this.cU.a(dVar);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [197=7, 198=7] */
    private void j(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.bu().bx().by();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.bu().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.bu().bv().by();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.cU.dO().kI && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.ko = new a(this.cU);
                        this.ko.b(i2, i3, dVar);
                    } catch (SocketException e) {
                        this.cU.dO().responseCode = -12;
                        dVar.kv = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.cU.a(dVar);
                        dVar.kt = System.currentTimeMillis() - currentTimeMillis;
                        this.cU.a(dVar);
                        z = true;
                    }
                } catch (UnsupportedOperationException e2) {
                    this.cU.dO().responseCode = -14;
                    dVar.kv = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.cU.a(dVar);
                    dVar.kt = System.currentTimeMillis() - currentTimeMillis;
                    this.cU.a(dVar);
                    z = false;
                } catch (SocketTimeoutException e3) {
                    this.cU.dO().responseCode = -13;
                    dVar.kv = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.cU.a(dVar);
                    dVar.kt = System.currentTimeMillis() - currentTimeMillis;
                    this.cU.a(dVar);
                    z = true;
                }
                if (this.cU.dO().responseCode == 200) {
                    return;
                }
                dVar.kv = String.valueOf(String.valueOf(this.cU.dO().responseCode)) + "|retryCount:" + i4;
                z = R(this.cU.dO().responseCode);
                this.cU.a(dVar);
            } finally {
                dVar.kt = System.currentTimeMillis() - currentTimeMillis;
                this.cU.a(dVar);
            }
        }
    }

    private boolean R(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void k(int i, int i2, int i3) {
        if (this.cU.dN().dQ()) {
            j(i, i2, i3);
        } else {
            l(i, i2, i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [297=7, 298=7] */
    private void l(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.bu().bx().by();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.bu().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.bu().bv().by();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.cU.dO().kI && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.retry = i4 + 1;
            try {
                try {
                    try {
                        this.ko = new a(this.cU);
                        this.ko.c(i2, i3, dVar);
                    } catch (SocketException e) {
                        this.cU.dO().responseCode = -12;
                        dVar.kv = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.cU.a(dVar);
                        dVar.kt = System.currentTimeMillis() - currentTimeMillis;
                        this.cU.a(dVar);
                        z = true;
                    }
                } catch (UnsupportedOperationException e2) {
                    this.cU.dO().responseCode = -14;
                    dVar.kv = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.cU.a(dVar);
                    dVar.kt = System.currentTimeMillis() - currentTimeMillis;
                    this.cU.a(dVar);
                    z = false;
                } catch (SocketTimeoutException e3) {
                    this.cU.dO().responseCode = -13;
                    dVar.kv = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.cU.a(dVar);
                    dVar.kt = System.currentTimeMillis() - currentTimeMillis;
                    this.cU.a(dVar);
                    z = true;
                }
                if (this.cU.dO().responseCode == 200) {
                    return;
                }
                dVar.kv = String.valueOf(String.valueOf(this.cU.dO().responseCode)) + "|retryCount:" + i4;
                z = R(this.cU.dO().responseCode);
                this.cU.a(dVar);
            } finally {
                dVar.kt = System.currentTimeMillis() - currentTimeMillis;
                this.cU.a(dVar);
            }
        }
    }

    public void cancel() {
        if (this.ko != null) {
            this.ko.dJ();
        }
    }

    public long dK() {
        if (this.ko == null) {
            return -1L;
        }
        return this.ko.dI();
    }

    public long dL() {
        if (this.ko == null) {
            return -1L;
        }
        return this.ko.dH();
    }

    public long dM() {
        if (this.ko == null) {
            return -1L;
        }
        return this.ko.dG();
    }
}
