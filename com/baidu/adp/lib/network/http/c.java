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
    private a uP;

    public c(e eVar) {
        this.oj = eVar;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        Exception e;
        boolean z3;
        int eZ = i3 <= 0 ? com.baidu.adp.framework.c.b.eV().eY().eZ() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eV().getRetryCount();
        }
        int eZ2 = i4 <= 0 ? com.baidu.adp.framework.c.b.eV().eW().eZ() : i4;
        boolean z4 = false;
        this.uP = new a(this.oj);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.uU = i5 + 1;
                z3 = this.uP.a(str, hVar, eZ, eZ2, z, dVar, z2);
                try {
                    a("downloadfile", dVar);
                    return z3;
                } catch (FileNotFoundException e2) {
                    this.oj.gZ().responseCode = -100;
                    i5++;
                    z4 = z3;
                } catch (Exception e3) {
                    e = e3;
                    this.oj.gZ().responseCode = -10;
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
    public void i(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eV().eY().eZ();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eV().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eV().eW().eZ();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oj.gZ().vi && z && i4 < i; i4++) {
            d dVar = new d();
            try {
                try {
                    try {
                        dVar.uU = i4 + 1;
                        this.uP = new a(this.oj);
                        this.uP.a(i2, i3, dVar);
                    } catch (Exception e) {
                        dVar.uX = String.valueOf(String.valueOf(this.oj.gZ().responseCode)) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.oj.gZ().responseCode = -10;
                        BdLog.e(e.getMessage());
                        this.oj.a(dVar);
                        dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                        this.oj.a(dVar);
                        return;
                    }
                } catch (SocketException e2) {
                    dVar.uX = String.valueOf(String.valueOf(this.oj.gZ().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.oj.gZ().responseCode = -12;
                    this.oj.a(dVar);
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                } catch (SocketTimeoutException e3) {
                    dVar.uX = String.valueOf(String.valueOf(this.oj.gZ().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.oj.gZ().responseCode = -13;
                    this.oj.a(dVar);
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                }
                if (this.oj.gZ().responseCode == 200) {
                    a(null, dVar);
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    return;
                }
                dVar.uX = String.valueOf(String.valueOf(this.oj.gZ().responseCode)) + "|retryCount:" + i4;
                z = Q(this.oj.gZ().responseCode);
                this.oj.a(dVar);
                dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                this.oj.a(dVar);
            } catch (Throwable th) {
                dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                this.oj.a(dVar);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [313=7, 314=7] */
    private void j(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eV().eY().eZ();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eV().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eV().eW().eZ();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oj.gZ().vi && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.uU = i4 + 1;
            try {
                try {
                    try {
                        this.uP = new a(this.oj);
                        this.uP.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        this.oj.gZ().responseCode = -14;
                        dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.oj.a(dVar);
                        dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                        this.oj.a(dVar);
                        z = false;
                    }
                } catch (SocketException e2) {
                    this.oj.gZ().responseCode = -12;
                    dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.oj.a(dVar);
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                } catch (SocketTimeoutException e3) {
                    this.oj.gZ().responseCode = -13;
                    dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oj.a(dVar);
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                }
                if (this.oj.gZ().responseCode == 200) {
                    a(null, dVar);
                    return;
                }
                dVar.uX = String.valueOf(String.valueOf(this.oj.gZ().responseCode)) + "|retryCount:" + i4;
                z = Q(this.oj.gZ().responseCode);
                this.oj.a(dVar);
            } finally {
                dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                this.oj.a(dVar);
            }
        }
    }

    private boolean Q(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void k(int i, int i2, int i3) {
        if (this.oj.gY().hb()) {
            j(i, i2, i3);
        } else {
            l(i, i2, i3);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [426=7, 427=7] */
    private void l(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.eV().eY().eZ();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.eV().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.eV().eW().eZ();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = true;
        for (int i4 = 0; !this.oj.gZ().vi && z && i4 < i; i4++) {
            d dVar = new d();
            dVar.uU = i4 + 1;
            try {
                try {
                    try {
                        this.uP = new a(this.oj);
                        this.uP.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        this.oj.gZ().responseCode = -14;
                        dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.oj.a(dVar);
                        dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                        this.oj.a(dVar);
                        z = false;
                    }
                } catch (SocketException e2) {
                    this.oj.gZ().responseCode = -12;
                    dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.oj.a(dVar);
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                } catch (SocketTimeoutException e3) {
                    this.oj.gZ().responseCode = -13;
                    dVar.uX = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oj.a(dVar);
                    dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                    this.oj.a(dVar);
                    z = true;
                }
                if (this.oj.gZ().responseCode == 200) {
                    a(null, dVar);
                    return;
                }
                dVar.uX = String.valueOf(String.valueOf(this.oj.gZ().responseCode)) + "|retryCount:" + i4;
                z = Q(this.oj.gZ().responseCode);
                this.oj.a(dVar);
            } finally {
                dVar.uV = System.currentTimeMillis() - currentTimeMillis;
                this.oj.a(dVar);
            }
        }
    }

    public void cancel() {
        if (this.uP != null) {
            this.uP.gS();
        }
    }

    public boolean gU() {
        if (this.oj == null) {
            return false;
        }
        return this.oj.gZ().vi;
    }

    public long gV() {
        if (this.uP == null) {
            return -1L;
        }
        return this.uP.gR();
    }

    public long gW() {
        if (this.uP == null) {
            return -1L;
        }
        return this.uP.gQ();
    }

    public long gX() {
        if (this.uP == null) {
            return -1L;
        }
        return this.uP.gP();
    }

    private void a(String str, d dVar) {
        if (com.baidu.adp.b.a.mq() != null && dVar != null && this.oj.gZ() != null) {
            com.baidu.adp.b.a.mq().b(str == null ? this.oj.gZ().contentType : str, dVar.uQ, dVar.uR);
        }
    }
}
