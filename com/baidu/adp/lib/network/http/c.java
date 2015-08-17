package com.baidu.adp.lib.network.http;

import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
public class c {
    private e oj;
    private a uL;

    public c(e eVar) {
        this.oj = eVar;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Exception e;
        boolean z3;
        int fa = i3 <= 0 ? com.baidu.adp.framework.c.b.eW().eZ().fa() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eW().getRetryCount();
        }
        int fa2 = i4 <= 0 ? com.baidu.adp.framework.c.b.eW().eX().fa() : i4;
        boolean z4 = false;
        this.uL = new a(this.oj);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.uQ = i5 + 1;
                z3 = this.uL.a(str, hVar, fa, fa2, z, dVar, z2);
                try {
                    a("downloadfile", dVar);
                    return z3;
                } catch (FileNotFoundException e2) {
                    this.oj.gT().responseCode = -100;
                    i5++;
                    z4 = z3;
                } catch (Exception e3) {
                    e = e3;
                    this.oj.gT().responseCode = -10;
                    BdLog.e(e.getMessage());
                    i5++;
                    z4 = z3;
                }
            } catch (FileNotFoundException e4) {
                z3 = z4;
            } catch (Exception e5) {
                e = e5;
                z3 = z4;
            }
        }
        return z4;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, boolean z) {
        return a(str, hVar, i, -1, i2, i3, false, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [242=6, 243=6] */
    public void f(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eW().eZ().fa();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eW().eX().fa();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oj.gT().ve && z && i4 < i; i4++) {
            d dVar = new d();
            try {
                try {
                    try {
                        dVar.uQ = i4 + 1;
                        this.uL = new a(this.oj);
                        this.uL.a(i2, i3, dVar);
                    } catch (Exception e) {
                        dVar.uT = String.valueOf(String.valueOf(this.oj.gT().responseCode)) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.oj.gT().responseCode = -10;
                        BdLog.e(e.getMessage());
                        this.oj.a(dVar);
                        dVar.uR = System.currentTimeMillis() - currentTimeMillis;
                        this.oj.a(dVar);
                        return;
                    }
                } catch (SocketException e2) {
                    dVar.uT = String.valueOf(String.valueOf(this.oj.gT().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.oj.gT().responseCode = -12;
                    this.oj.a(dVar);
                    dVar.uR = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                } catch (SocketTimeoutException e3) {
                    dVar.uT = String.valueOf(String.valueOf(this.oj.gT().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.oj.gT().responseCode = -13;
                    this.oj.a(dVar);
                    dVar.uR = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                }
                if (this.oj.gT().responseCode == 200) {
                    a(null, dVar);
                    dVar.uR = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    return;
                }
                dVar.uT = String.valueOf(String.valueOf(this.oj.gT().responseCode)) + "|retryCount:" + i4;
                z = S(this.oj.gT().responseCode);
                this.oj.a(dVar);
                dVar.uR = System.currentTimeMillis() - currentTimeMillis;
                this.oj.a(dVar);
            } catch (Throwable th) {
                dVar.uR = System.currentTimeMillis() - currentTimeMillis;
                this.oj.a(dVar);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [313=7, 314=7] */
    private void g(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eW().eZ().fa();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eW().eX().fa();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oj.gT().ve && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.uQ = i4 + 1;
            try {
                try {
                    try {
                        this.uL = new a(this.oj);
                        this.uL.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        this.oj.gT().responseCode = -14;
                        dVar.uT = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.oj.a(dVar);
                        dVar.uR = System.currentTimeMillis() - currentTimeMillis;
                        this.oj.a(dVar);
                        z = false;
                    }
                } catch (SocketException e2) {
                    this.oj.gT().responseCode = -12;
                    dVar.uT = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.oj.a(dVar);
                    dVar.uR = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                } catch (SocketTimeoutException e3) {
                    this.oj.gT().responseCode = -13;
                    dVar.uT = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oj.a(dVar);
                    dVar.uR = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                }
                if (this.oj.gT().responseCode == 200) {
                    a(null, dVar);
                    return;
                }
                dVar.uT = String.valueOf(String.valueOf(this.oj.gT().responseCode)) + "|retryCount:" + i4;
                z = S(this.oj.gT().responseCode);
                this.oj.a(dVar);
            } finally {
                dVar.uR = System.currentTimeMillis() - currentTimeMillis;
                this.oj.a(dVar);
            }
        }
    }

    private boolean S(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void h(int i, int i2, int i3) {
        if (this.oj.gS().gV()) {
            g(i, i2, i3);
        } else {
            i(i, i2, i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [426=7, 427=7] */
    private void i(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eW().eZ().fa();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eW().eX().fa();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oj.gT().ve && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.uQ = i4 + 1;
            try {
                try {
                    try {
                        this.uL = new a(this.oj);
                        this.uL.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        this.oj.gT().responseCode = -14;
                        dVar.uT = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.oj.a(dVar);
                        dVar.uR = System.currentTimeMillis() - currentTimeMillis;
                        this.oj.a(dVar);
                        z = false;
                    }
                } catch (SocketException e2) {
                    this.oj.gT().responseCode = -12;
                    dVar.uT = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.oj.a(dVar);
                    dVar.uR = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                } catch (SocketTimeoutException e3) {
                    this.oj.gT().responseCode = -13;
                    dVar.uT = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oj.a(dVar);
                    dVar.uR = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                }
                if (this.oj.gT().responseCode == 200) {
                    a(null, dVar);
                    return;
                }
                dVar.uT = String.valueOf(String.valueOf(this.oj.gT().responseCode)) + "|retryCount:" + i4;
                z = S(this.oj.gT().responseCode);
                this.oj.a(dVar);
            } finally {
                dVar.uR = System.currentTimeMillis() - currentTimeMillis;
                this.oj.a(dVar);
            }
        }
    }

    public void cancel() {
        if (this.uL != null) {
            this.uL.gM();
        }
    }

    public boolean gO() {
        if (this.oj == null) {
            return false;
        }
        return this.oj.gT().ve;
    }

    public long gP() {
        if (this.uL == null) {
            return -1L;
        }
        return this.uL.gL();
    }

    public long gQ() {
        if (this.uL == null) {
            return -1L;
        }
        return this.uL.gK();
    }

    public long gR() {
        if (this.uL == null) {
            return -1L;
        }
        return this.uL.gJ();
    }

    private void a(String str, d dVar) {
        if (com.baidu.adp.b.a.mA() != null && dVar != null && this.oj.gT() != null) {
            com.baidu.adp.b.a.mA().b(str == null ? this.oj.gT().contentType : str, dVar.uM, dVar.uN);
        }
    }
}
