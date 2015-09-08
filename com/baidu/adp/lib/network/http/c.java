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
    private a uJ;

    public c(e eVar) {
        this.oj = eVar;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Exception e;
        boolean z3;
        int eX = i3 <= 0 ? com.baidu.adp.framework.c.b.eT().eW().eX() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eT().getRetryCount();
        }
        int eX2 = i4 <= 0 ? com.baidu.adp.framework.c.b.eT().eU().eX() : i4;
        boolean z4 = false;
        this.uJ = new a(this.oj);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.uO = i5 + 1;
                z3 = this.uJ.a(str, hVar, eX, eX2, z, dVar, z2);
                try {
                    a("downloadfile", dVar);
                    return z3;
                } catch (FileNotFoundException e2) {
                    this.oj.gQ().responseCode = -100;
                    i5++;
                    z4 = z3;
                } catch (Exception e3) {
                    e = e3;
                    this.oj.gQ().responseCode = -10;
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
    public void e(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eT().eW().eX();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eT().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eT().eU().eX();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oj.gQ().vc && z && i4 < i; i4++) {
            d dVar = new d();
            try {
                try {
                    try {
                        dVar.uO = i4 + 1;
                        this.uJ = new a(this.oj);
                        this.uJ.a(i2, i3, dVar);
                    } catch (Exception e) {
                        dVar.uR = String.valueOf(String.valueOf(this.oj.gQ().responseCode)) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.oj.gQ().responseCode = -10;
                        BdLog.e(e.getMessage());
                        this.oj.a(dVar);
                        dVar.uP = System.currentTimeMillis() - currentTimeMillis;
                        this.oj.a(dVar);
                        return;
                    }
                } catch (SocketException e2) {
                    dVar.uR = String.valueOf(String.valueOf(this.oj.gQ().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.oj.gQ().responseCode = -12;
                    this.oj.a(dVar);
                    dVar.uP = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                } catch (SocketTimeoutException e3) {
                    dVar.uR = String.valueOf(String.valueOf(this.oj.gQ().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.oj.gQ().responseCode = -13;
                    this.oj.a(dVar);
                    dVar.uP = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                }
                if (this.oj.gQ().responseCode == 200) {
                    a(null, dVar);
                    dVar.uP = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    return;
                }
                dVar.uR = String.valueOf(String.valueOf(this.oj.gQ().responseCode)) + "|retryCount:" + i4;
                z = S(this.oj.gQ().responseCode);
                this.oj.a(dVar);
                dVar.uP = System.currentTimeMillis() - currentTimeMillis;
                this.oj.a(dVar);
            } catch (Throwable th) {
                dVar.uP = System.currentTimeMillis() - currentTimeMillis;
                this.oj.a(dVar);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [313=7, 314=7] */
    private void f(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eT().eW().eX();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eT().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eT().eU().eX();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oj.gQ().vc && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.uO = i4 + 1;
            try {
                try {
                    try {
                        this.uJ = new a(this.oj);
                        this.uJ.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        this.oj.gQ().responseCode = -14;
                        dVar.uR = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.oj.a(dVar);
                        dVar.uP = System.currentTimeMillis() - currentTimeMillis;
                        this.oj.a(dVar);
                        z = false;
                    }
                } catch (SocketException e2) {
                    this.oj.gQ().responseCode = -12;
                    dVar.uR = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.oj.a(dVar);
                    dVar.uP = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                } catch (SocketTimeoutException e3) {
                    this.oj.gQ().responseCode = -13;
                    dVar.uR = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oj.a(dVar);
                    dVar.uP = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                }
                if (this.oj.gQ().responseCode == 200) {
                    a(null, dVar);
                    return;
                }
                dVar.uR = String.valueOf(String.valueOf(this.oj.gQ().responseCode)) + "|retryCount:" + i4;
                z = S(this.oj.gQ().responseCode);
                this.oj.a(dVar);
            } finally {
                dVar.uP = System.currentTimeMillis() - currentTimeMillis;
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

    public void g(int i, int i2, int i3) {
        if (this.oj.gP().gS()) {
            f(i, i2, i3);
        } else {
            h(i, i2, i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [426=7, 427=7] */
    private void h(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eT().eW().eX();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eT().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eT().eU().eX();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oj.gQ().vc && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.uO = i4 + 1;
            try {
                try {
                    try {
                        this.uJ = new a(this.oj);
                        this.uJ.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        this.oj.gQ().responseCode = -14;
                        dVar.uR = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.oj.a(dVar);
                        dVar.uP = System.currentTimeMillis() - currentTimeMillis;
                        this.oj.a(dVar);
                        z = false;
                    }
                } catch (SocketException e2) {
                    this.oj.gQ().responseCode = -12;
                    dVar.uR = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.oj.a(dVar);
                    dVar.uP = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                } catch (SocketTimeoutException e3) {
                    this.oj.gQ().responseCode = -13;
                    dVar.uR = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oj.a(dVar);
                    dVar.uP = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                }
                if (this.oj.gQ().responseCode == 200) {
                    a(null, dVar);
                    return;
                }
                dVar.uR = String.valueOf(String.valueOf(this.oj.gQ().responseCode)) + "|retryCount:" + i4;
                z = S(this.oj.gQ().responseCode);
                this.oj.a(dVar);
            } finally {
                dVar.uP = System.currentTimeMillis() - currentTimeMillis;
                this.oj.a(dVar);
            }
        }
    }

    public void cancel() {
        if (this.uJ != null) {
            this.uJ.gJ();
        }
    }

    public boolean gL() {
        if (this.oj == null) {
            return false;
        }
        return this.oj.gQ().vc;
    }

    public long gM() {
        if (this.uJ == null) {
            return -1L;
        }
        return this.uJ.gI();
    }

    public long gN() {
        if (this.uJ == null) {
            return -1L;
        }
        return this.uJ.gH();
    }

    public long gO() {
        if (this.uJ == null) {
            return -1L;
        }
        return this.uJ.gG();
    }

    private void a(String str, d dVar) {
        if (com.baidu.adp.b.a.mx() != null && dVar != null && this.oj.gQ() != null) {
            com.baidu.adp.b.a.mx().b(str == null ? this.oj.gQ().contentType : str, dVar.uK, dVar.uL);
        }
    }
}
