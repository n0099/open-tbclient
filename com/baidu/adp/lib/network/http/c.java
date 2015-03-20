package com.baidu.adp.lib.network.http;

import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
public class c {
    private e oe;
    private a vD;

    public c(e eVar) {
        this.oe = eVar;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3) {
        boolean z = false;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eR().eU().eV();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eR().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eR().eS().eV();
        }
        a aVar = new a(this.oe);
        for (int i4 = 0; i4 < i; i4++) {
            try {
                z = aVar.a(str, hVar, i2, i3);
                break;
            } catch (FileNotFoundException e) {
                this.oe.hn().responseCode = -100;
            } catch (Exception e2) {
                this.oe.hn().responseCode = -10;
                BdLog.e(e2.getMessage());
            }
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [125=6, 126=6] */
    public void i(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eR().eU().eV();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eR().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eR().eS().eV();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oe.hn().vW && z && i4 < i; i4++) {
            d dVar = new d();
            try {
                try {
                    try {
                        dVar.vI = i4 + 1;
                        this.vD = new a(this.oe);
                        this.vD.a(i2, i3, dVar);
                    } catch (SocketException e) {
                        dVar.vL = String.valueOf(String.valueOf(this.oe.hn().responseCode)) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.oe.hn().responseCode = -12;
                        this.oe.a(dVar);
                        dVar.vJ = System.currentTimeMillis() - currentTimeMillis;
                        this.oe.a(dVar);
                        z = true;
                    }
                } catch (SocketTimeoutException e2) {
                    dVar.vL = String.valueOf(String.valueOf(this.oe.hn().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.oe.hn().responseCode = -13;
                    this.oe.a(dVar);
                    dVar.vJ = System.currentTimeMillis() - currentTimeMillis;
                    this.oe.a(dVar);
                    z = true;
                } catch (Exception e3) {
                    dVar.vL = String.valueOf(String.valueOf(this.oe.hn().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.oe.hn().responseCode = -10;
                    BdLog.e(e3.getMessage());
                    this.oe.a(dVar);
                    dVar.vJ = System.currentTimeMillis() - currentTimeMillis;
                    this.oe.a(dVar);
                    return;
                }
                if (this.oe.hn().responseCode == 200) {
                    dVar.vJ = System.currentTimeMillis() - currentTimeMillis;
                    this.oe.a(dVar);
                    return;
                }
                dVar.vL = String.valueOf(String.valueOf(this.oe.hn().responseCode)) + "|retryCount:" + i4;
                z = S(this.oe.hn().responseCode);
                this.oe.a(dVar);
                dVar.vJ = System.currentTimeMillis() - currentTimeMillis;
                this.oe.a(dVar);
            } catch (Throwable th) {
                dVar.vJ = System.currentTimeMillis() - currentTimeMillis;
                this.oe.a(dVar);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [195=7, 196=7] */
    private void j(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eR().eU().eV();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eR().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eR().eS().eV();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oe.hn().vW && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.vI = i4 + 1;
            try {
                try {
                    try {
                        this.vD = new a(this.oe);
                        this.vD.b(i2, i3, dVar);
                    } catch (SocketException e) {
                        this.oe.hn().responseCode = -12;
                        dVar.vL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.oe.a(dVar);
                        dVar.vJ = System.currentTimeMillis() - currentTimeMillis;
                        this.oe.a(dVar);
                        z = true;
                    }
                } catch (UnsupportedOperationException e2) {
                    this.oe.hn().responseCode = -14;
                    dVar.vL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.oe.a(dVar);
                    dVar.vJ = System.currentTimeMillis() - currentTimeMillis;
                    this.oe.a(dVar);
                    z = false;
                } catch (SocketTimeoutException e3) {
                    this.oe.hn().responseCode = -13;
                    dVar.vL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oe.a(dVar);
                    dVar.vJ = System.currentTimeMillis() - currentTimeMillis;
                    this.oe.a(dVar);
                    z = true;
                }
                if (this.oe.hn().responseCode == 200) {
                    return;
                }
                dVar.vL = String.valueOf(String.valueOf(this.oe.hn().responseCode)) + "|retryCount:" + i4;
                z = S(this.oe.hn().responseCode);
                this.oe.a(dVar);
            } finally {
                dVar.vJ = System.currentTimeMillis() - currentTimeMillis;
                this.oe.a(dVar);
            }
        }
    }

    private boolean S(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void k(int i, int i2, int i3) {
        if (this.oe.hm().hp()) {
            j(i, i2, i3);
        } else {
            l(i, i2, i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [295=7, 296=7] */
    private void l(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eR().eU().eV();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eR().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eR().eS().eV();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oe.hn().vW && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.vI = i4 + 1;
            try {
                try {
                    try {
                        this.vD = new a(this.oe);
                        this.vD.c(i2, i3, dVar);
                    } catch (SocketException e) {
                        this.oe.hn().responseCode = -12;
                        dVar.vL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.oe.a(dVar);
                        dVar.vJ = System.currentTimeMillis() - currentTimeMillis;
                        this.oe.a(dVar);
                        z = true;
                    }
                } catch (UnsupportedOperationException e2) {
                    this.oe.hn().responseCode = -14;
                    dVar.vL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.oe.a(dVar);
                    dVar.vJ = System.currentTimeMillis() - currentTimeMillis;
                    this.oe.a(dVar);
                    z = false;
                } catch (SocketTimeoutException e3) {
                    this.oe.hn().responseCode = -13;
                    dVar.vL = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oe.a(dVar);
                    dVar.vJ = System.currentTimeMillis() - currentTimeMillis;
                    this.oe.a(dVar);
                    z = true;
                }
                if (this.oe.hn().responseCode == 200) {
                    return;
                }
                dVar.vL = String.valueOf(String.valueOf(this.oe.hn().responseCode)) + "|retryCount:" + i4;
                z = S(this.oe.hn().responseCode);
                this.oe.a(dVar);
            } finally {
                dVar.vJ = System.currentTimeMillis() - currentTimeMillis;
                this.oe.a(dVar);
            }
        }
    }

    public void cancel() {
        if (this.vD != null) {
            this.vD.hh();
        }
    }

    public long hj() {
        if (this.vD == null) {
            return -1L;
        }
        return this.vD.hg();
    }

    public long hk() {
        if (this.vD == null) {
            return -1L;
        }
        return this.vD.hf();
    }

    public long hl() {
        if (this.vD == null) {
            return -1L;
        }
        return this.vD.he();
    }
}
