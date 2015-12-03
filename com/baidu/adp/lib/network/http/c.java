package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
public class c {
    private e oj;
    private a uP;

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
        this.uP = new a(this.oj);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.uU = i5 + 1;
                z3 = this.uP.a(str, hVar, eX, eX2, z, dVar, z2);
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [245=6, 246=6, 247=6] */
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
        for (int i4 = 0; !this.oj.gT().vj && z && i4 < i; i4++) {
            d dVar = new d();
            try {
                try {
                    try {
                        try {
                            dVar.uU = i4 + 1;
                            this.uP = new a(this.oj);
                            this.uP.a(i2, i3, dVar);
                        } catch (SocketException e) {
                            dVar.uX = String.valueOf(String.valueOf(this.oj.gT().responseCode)) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                            this.oj.gT().responseCode = -12;
                            this.oj.a(dVar);
                            dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                            this.oj.a(dVar);
                            z = true;
                        }
                    } catch (SocketTimeoutException e2) {
                        dVar.uX = String.valueOf(String.valueOf(this.oj.gT().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.oj.gT().responseCode = -13;
                        this.oj.a(dVar);
                        dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                        this.oj.a(dVar);
                        z = true;
                    }
                    if (this.oj.gT().responseCode == 200) {
                        a(null, dVar);
                        dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                        this.oj.a(dVar);
                        return;
                    }
                    dVar.uX = String.valueOf(String.valueOf(this.oj.gT().responseCode)) + "|retryCount:" + i4;
                    z = T(this.oj.gT().responseCode);
                    this.oj.a(dVar);
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                    this.oj.a(dVar);
                } catch (Exception e3) {
                    dVar.uX = String.valueOf(String.valueOf(this.oj.gT().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.oj.gT().responseCode = -10;
                    BdLog.e(e3.getMessage());
                    this.oj.a(dVar);
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                    this.oj.a(dVar);
                    return;
                }
            } catch (Throwable th) {
                dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                this.oj.a(dVar);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [317=7, 318=7, 319=7] */
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
        for (int i4 = 0; !this.oj.gT().vj && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.uU = i4 + 1;
            try {
                try {
                    try {
                        try {
                            this.uP = new a(this.oj);
                            this.uP.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            this.oj.gT().responseCode = -14;
                            dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.oj.a(dVar);
                            dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                            this.oj.a(dVar);
                            z = false;
                        }
                    } catch (SocketTimeoutException e2) {
                        this.oj.gT().responseCode = -13;
                        dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.oj.a(dVar);
                        dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                        this.oj.a(dVar);
                        z = true;
                    }
                } catch (SocketException e3) {
                    this.oj.gT().responseCode = -12;
                    dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oj.a(dVar);
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                    this.oj.a(dVar);
                    z = true;
                } catch (Throwable th) {
                    this.oj.gT().responseCode = -10;
                    dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.oj.a(dVar);
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                    this.oj.a(dVar);
                    z = false;
                }
                if (this.oj.gT().responseCode == 200) {
                    a(null, dVar);
                    return;
                }
                dVar.uX = String.valueOf(String.valueOf(this.oj.gT().responseCode)) + "|retryCount:" + i4;
                z = T(this.oj.gT().responseCode);
                this.oj.a(dVar);
            } finally {
                dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                this.oj.a(dVar);
            }
        }
    }

    private boolean T(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void g(int i, int i2, int i3) {
        if (this.oj.gS().gW()) {
            f(i, i2, i3);
        } else {
            h(i, i2, i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [431=7, 432=7, 433=7] */
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
        for (int i4 = 0; !this.oj.gT().vj && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.uU = i4 + 1;
            try {
                try {
                    try {
                        try {
                            this.uP = new a(this.oj);
                            this.uP.c(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            this.oj.gT().responseCode = -14;
                            dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.oj.a(dVar);
                            dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                            this.oj.a(dVar);
                            z = false;
                        }
                    } catch (SocketTimeoutException e2) {
                        this.oj.gT().responseCode = -13;
                        dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.oj.a(dVar);
                        dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                        this.oj.a(dVar);
                        z = true;
                    }
                } catch (SocketException e3) {
                    this.oj.gT().responseCode = -12;
                    dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oj.a(dVar);
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                    this.oj.a(dVar);
                    z = true;
                } catch (Throwable th) {
                    this.oj.gT().responseCode = -10;
                    dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.oj.a(dVar);
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                    this.oj.a(dVar);
                    z = false;
                }
                if (this.oj.gT().responseCode == 200) {
                    a(null, dVar);
                    return;
                }
                dVar.uX = String.valueOf(String.valueOf(this.oj.gT().responseCode)) + "|retryCount:" + i4;
                z = T(this.oj.gT().responseCode);
                this.oj.a(dVar);
            } finally {
                dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.gr().d(this.oj.gS().getUrl(), TextUtils.isEmpty(dVar.uX));
                this.oj.a(dVar);
            }
        }
    }

    public void cancel() {
        if (this.uP != null) {
            this.uP.gL();
        }
    }

    public boolean gN() {
        if (this.oj == null) {
            return false;
        }
        return this.oj.gT().vj;
    }

    public void gO() {
        if (this.oj != null) {
            this.oj.gT().vj = true;
        }
    }

    public long gP() {
        if (this.uP == null) {
            return -1L;
        }
        return this.uP.gK();
    }

    public long gQ() {
        if (this.uP == null) {
            return -1L;
        }
        return this.uP.gJ();
    }

    public long gR() {
        if (this.uP == null) {
            return -1L;
        }
        return this.uP.gI();
    }

    private void a(String str, d dVar) {
        if (com.baidu.adp.b.a.mD() != null && dVar != null && this.oj.gT() != null) {
            com.baidu.adp.b.a.mD().b(str == null ? this.oj.gT().contentType : str, dVar.uQ, dVar.uR);
        }
    }
}
