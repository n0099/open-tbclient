package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.trafficStats.ITrafficStatsNativeManager;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
public class c {
    private e nG;
    private b uN;
    private int uO = 0;
    private long uE = 0;

    public c(e eVar) {
        this.nG = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=7, 173=4, 174=4, 175=4, 176=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int dw = i3 <= 0 ? com.baidu.adp.framework.c.b.ds().dv().dw() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ds().getRetryCount();
        }
        int dw2 = i4 <= 0 ? com.baidu.adp.framework.c.b.ds().dt().dw() : i4;
        boolean z4 = false;
        this.uN = new b(this.nG);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.uS = i5 + 1;
                this.uO = i5;
                z3 = this.uN.a(str, hVar, dw, dw2, z, dVar, z2);
            } catch (FileNotFoundException e) {
                e = e;
                z3 = z4;
            } catch (Exception e2) {
                e = e2;
                z3 = z4;
            }
            try {
                b("downloadfile", dVar);
                return z3;
            } catch (FileNotFoundException e3) {
                e = e3;
                this.nG.fA().responseCode = -100;
                dVar.uV = String.valueOf(this.nG.fA().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.nG.a(dVar);
                com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                this.nG.a(dVar);
                a fi = a.fi();
                if (fi != null) {
                    fi.a(this.nG);
                }
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.nG.fA().responseCode = -10;
                    dVar.uV = String.valueOf(this.nG.fA().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.nG.a(dVar);
                    com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                    this.nG.a(dVar);
                    a fi2 = a.fi();
                    if (fi2 != null) {
                        fi2.a(this.nG);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                    this.nG.a(dVar);
                    a fi3 = a.fi();
                    if (fi3 != null) {
                        fi3.a(this.nG);
                    }
                }
            }
        }
        return z4;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, boolean z) {
        return a(str, hVar, i, -1, i2, i3, false, z);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [271=7, 272=7, 274=7, 275=14, 276=7, 277=7, 278=7, 279=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.ds().dv().dw();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ds().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ds().dt().dw();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.nG.fA().vl && z && i4 < i; i4++) {
            d dVar = new d();
            this.nG.a(dVar);
            try {
                try {
                    try {
                        this.uO = i4;
                        dVar.uS = i4 + 1;
                        dVar.vc = 1;
                        this.uN = new b(this.nG);
                        this.uN.a(i2, i3, dVar);
                    } catch (SocketException e) {
                        dVar.uV = String.valueOf(this.nG.fA().responseCode) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.nG.fA().vm = -12;
                        if (this.uE <= 0 && this.uN != null) {
                            this.uE = this.uN.fl();
                        }
                        dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                        this.nG.b(dVar);
                        a fi = a.fi();
                        if (fi != null) {
                            fi.a(this.nG);
                        }
                        z = true;
                    } catch (SocketTimeoutException e2) {
                        dVar.uV = String.valueOf(this.nG.fA().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.nG.fA().vm = -13;
                        if (this.uE <= 0 && this.uN != null) {
                            this.uE = this.uN.fl();
                        }
                        dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                        this.nG.b(dVar);
                        a fi2 = a.fi();
                        if (fi2 != null) {
                            fi2.a(this.nG);
                        }
                        z = true;
                    }
                } catch (IllegalStateException e3) {
                    this.nG.fA().vm = -19;
                    dVar.uV = "errorCode:" + String.valueOf(-19) + "|" + e3.getClass() + "|" + e3.getMessage() + "|getcontent_illegal_error";
                    if (this.uE <= 0 && this.uN != null) {
                        this.uE = this.uN.fl();
                    }
                    dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                    this.nG.b(dVar);
                    a fi3 = a.fi();
                    if (fi3 != null) {
                        fi3.a(this.nG);
                    }
                } catch (Exception e4) {
                    dVar.uV = String.valueOf(this.nG.fA().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.nG.fA().vm = -10;
                    BdLog.e(e4.getMessage());
                    if (this.uE <= 0 && this.uN != null) {
                        this.uE = this.uN.fl();
                    }
                    dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                    this.nG.b(dVar);
                    a fi4 = a.fi();
                    if (fi4 != null) {
                        fi4.a(this.nG);
                        return;
                    }
                    return;
                }
                if (this.nG.fA().responseCode == 200) {
                    b(null, dVar);
                    this.nG.b(dVar);
                    if (this.uE <= 0 && this.uN != null) {
                        this.uE = this.uN.fl();
                    }
                    dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                    this.nG.b(dVar);
                    a fi5 = a.fi();
                    if (fi5 != null) {
                        fi5.a(this.nG);
                        return;
                    }
                    return;
                }
                dVar.uV = String.valueOf(this.nG.fA().responseCode) + "|retryCount:" + i4;
                boolean ah = ah(this.nG.fA().responseCode);
                if (this.uE <= 0 && this.uN != null) {
                    this.uE = this.uN.fl();
                }
                dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                this.nG.b(dVar);
                a fi6 = a.fi();
                if (fi6 != null) {
                    fi6.a(this.nG);
                }
                z = ah;
            } catch (Throwable th) {
                if (this.uE <= 0 && this.uN != null) {
                    this.uE = this.uN.fl();
                }
                dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                this.nG.b(dVar);
                a fi7 = a.fi();
                if (fi7 != null) {
                    fi7.a(this.nG);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [351=7, 352=7, 354=7, 355=14, 356=7, 357=7, 358=7, 359=7, 361=5] */
    private void e(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.ds().dv().dw();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ds().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ds().dt().dw();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.nG.fA().vl && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.uS = i4 + 1;
            this.uO = i4;
            try {
                try {
                    try {
                        try {
                            this.uN = new b(this.nG);
                            this.uN.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.nG.fA().vm = -14;
                            dVar.uV = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.nG.a(dVar);
                            if (this.uE <= 0 && this.uN != null) {
                                this.uE = this.uN.fl();
                            }
                            dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                            this.nG.a(dVar);
                            a fi = a.fi();
                            if (fi != null && this.uN != null && this.uN.fo()) {
                                fi.a(this.nG);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.nG.fA().vm = -13;
                        z = true;
                        dVar.uV = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.nG.a(dVar);
                        if (this.uE <= 0 && this.uN != null) {
                            this.uE = this.uN.fl();
                        }
                        dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                        this.nG.a(dVar);
                        a fi2 = a.fi();
                        if (fi2 != null && this.uN != null && this.uN.fo()) {
                            fi2.a(this.nG);
                        }
                    }
                } catch (SocketException e3) {
                    this.nG.fA().vm = -12;
                    z = true;
                    dVar.uV = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.nG.a(dVar);
                    if (this.uE <= 0 && this.uN != null) {
                        this.uE = this.uN.fl();
                    }
                    dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                    this.nG.a(dVar);
                    a fi3 = a.fi();
                    if (fi3 != null && this.uN != null && this.uN.fo()) {
                        fi3.a(this.nG);
                    }
                } catch (Throwable th) {
                    this.nG.fA().vm = -10;
                    z = false;
                    dVar.uV = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.nG.a(dVar);
                    if (this.uE <= 0 && this.uN != null) {
                        this.uE = this.uN.fl();
                    }
                    dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                    this.nG.a(dVar);
                    a fi4 = a.fi();
                    if (fi4 != null && this.uN != null && this.uN.fo()) {
                        fi4.a(this.nG);
                    }
                }
                if (this.nG.fA().responseCode == 200) {
                    b(null, dVar);
                    if (this.uE <= 0 && this.uN != null) {
                        this.uE = this.uN.fl();
                    }
                    dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                    this.nG.a(dVar);
                    a fi5 = a.fi();
                    if (fi5 == null || this.uN == null || !this.uN.fo()) {
                        return;
                    }
                    fi5.a(this.nG);
                    return;
                }
                dVar.uV = String.valueOf(this.nG.fA().responseCode) + "|retryCount:" + i4;
                z = ah(this.nG.fA().responseCode);
                this.nG.a(dVar);
                if (this.uE <= 0 && this.uN != null) {
                    this.uE = this.uN.fl();
                }
                dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                this.nG.a(dVar);
                a fi6 = a.fi();
                if (fi6 != null && this.uN != null && this.uN.fo()) {
                    fi6.a(this.nG);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.uE <= 0 && this.uN != null) {
                    this.uE = this.uN.fl();
                }
                dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                this.nG.a(dVar);
                a fi7 = a.fi();
                if (fi7 != null && this.uN != null && this.uN.fo()) {
                    fi7.a(this.nG);
                }
                throw th2;
            }
        }
    }

    private boolean ah(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.nG.fz().fD()) {
            e(i, i2, i3);
        } else {
            g(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [473=7, 474=7, 476=7, 477=14, 478=7, 479=7, 480=7, 481=7, 483=5] */
    private void g(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.ds().dv().dw();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ds().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.ds().dt().dw();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.nG.fA().vl && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.uO = i4;
            dVar.uS = i4 + 1;
            try {
                try {
                    try {
                        this.uN = new b(this.nG);
                        this.uN.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.nG.fA().vm = -14;
                        dVar.uV = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.nG.a(dVar);
                        if (this.uE <= 0 && this.uN != null) {
                            this.uE = this.uN.fl();
                        }
                        dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                        this.nG.a(dVar);
                        a fi = a.fi();
                        if (fi != null) {
                            fi.a(this.nG);
                        }
                    } catch (Throwable th) {
                        this.nG.fA().vm = -10;
                        z = false;
                        dVar.uV = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.nG.a(dVar);
                        if (this.uE <= 0 && this.uN != null) {
                            this.uE = this.uN.fl();
                        }
                        dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                        this.nG.a(dVar);
                        a fi2 = a.fi();
                        if (fi2 != null) {
                            fi2.a(this.nG);
                        }
                    }
                } catch (SocketException e2) {
                    this.nG.fA().vm = -12;
                    z = true;
                    dVar.uV = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.nG.a(dVar);
                    if (this.uE <= 0 && this.uN != null) {
                        this.uE = this.uN.fl();
                    }
                    dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                    this.nG.a(dVar);
                    a fi3 = a.fi();
                    if (fi3 != null) {
                        fi3.a(this.nG);
                    }
                } catch (SocketTimeoutException e3) {
                    this.nG.fA().vm = -13;
                    z = true;
                    dVar.uV = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.nG.a(dVar);
                    if (this.uE <= 0 && this.uN != null) {
                        this.uE = this.uN.fl();
                    }
                    dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                    this.nG.a(dVar);
                    a fi4 = a.fi();
                    if (fi4 != null) {
                        fi4.a(this.nG);
                    }
                }
                if (this.nG.fA().responseCode == 200) {
                    b(null, dVar);
                    if (this.uE <= 0 && this.uN != null) {
                        this.uE = this.uN.fl();
                    }
                    dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                    this.nG.a(dVar);
                    a fi5 = a.fi();
                    if (fi5 != null) {
                        fi5.a(this.nG);
                        return;
                    }
                    return;
                }
                dVar.uV = String.valueOf(this.nG.fA().responseCode) + "|retryCount:" + i4;
                z = ah(this.nG.fA().responseCode);
                this.nG.a(dVar);
                if (this.uE <= 0 && this.uN != null) {
                    this.uE = this.uN.fl();
                }
                dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                this.nG.a(dVar);
                a fi6 = a.fi();
                if (fi6 != null) {
                    fi6.a(this.nG);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.uE <= 0 && this.uN != null) {
                    this.uE = this.uN.fl();
                }
                dVar.uT = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eM().b(this.nG.fz().getUrl(), this.nG.fz().ah("Host"), TextUtils.isEmpty(dVar.uV), dVar.uZ != null);
                this.nG.a(dVar);
                a fi7 = a.fi();
                if (fi7 != null) {
                    fi7.a(this.nG);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.uN != null) {
            this.uN.fp();
        }
    }

    public boolean fs() {
        if (this.nG == null) {
            return false;
        }
        return this.nG.fA().vl;
    }

    public void ft() {
        if (this.nG != null) {
            this.nG.fA().vl = true;
        }
    }

    public long fu() {
        if (this.uE > 0) {
            return this.uE;
        }
        if (this.uN == null) {
            return -1L;
        }
        return this.uN.fl();
    }

    public long fv() {
        if (this.uN == null) {
            return -1L;
        }
        return this.uN.fm();
    }

    public long fn() {
        if (this.uN == null) {
            return -1L;
        }
        return this.uN.fn();
    }

    public long fw() {
        if (this.uN == null) {
            return -1L;
        }
        return this.uN.fk();
    }

    public long fx() {
        if (this.uN == null) {
            return -1L;
        }
        return this.uN.fj();
    }

    public int fy() {
        return this.uO;
    }

    private void b(String str, d dVar) {
        if (ITrafficStatsNativeManager.kl() != null && dVar != null && this.nG.fA() != null) {
            String str2 = str == null ? this.nG.fA().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + dVar.uP + "; downloadSize = " + dVar.uQ + "; url=" + dVar.url);
            ITrafficStatsNativeManager.kl().a(str2, dVar.uP + 54, 54 + dVar.uQ, dVar.url);
        }
    }
}
