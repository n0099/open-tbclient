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
    private e ol;
    private b vs;
    private int vt = 0;
    private long vj = 0;

    public c(e eVar) {
        this.ol = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=7, 173=4, 174=4, 175=4, 176=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int dv = i3 <= 0 ? com.baidu.adp.framework.c.b.dr().du().dv() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.dr().getRetryCount();
        }
        int dv2 = i4 <= 0 ? com.baidu.adp.framework.c.b.dr().ds().dv() : i4;
        boolean z4 = false;
        this.vs = new b(this.ol);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.vx = i5 + 1;
                this.vt = i5;
                z3 = this.vs.a(str, hVar, dv, dv2, z, dVar, z2);
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
                this.ol.fz().responseCode = -100;
                dVar.vA = String.valueOf(this.ol.fz().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.ol.a(dVar);
                com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                this.ol.a(dVar);
                a fi = a.fi();
                if (fi != null) {
                    fi.a(this.ol);
                }
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.ol.fz().responseCode = -10;
                    dVar.vA = String.valueOf(this.ol.fz().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.ol.a(dVar);
                    com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                    this.ol.a(dVar);
                    a fi2 = a.fi();
                    if (fi2 != null) {
                        fi2.a(this.ol);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                    this.ol.a(dVar);
                    a fi3 = a.fi();
                    if (fi3 != null) {
                        fi3.a(this.ol);
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
            i2 = com.baidu.adp.framework.c.b.dr().du().dv();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.dr().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.dr().ds().dv();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.ol.fz().vQ && z && i4 < i; i4++) {
            d dVar = new d();
            this.ol.a(dVar);
            try {
                try {
                    try {
                        this.vt = i4;
                        dVar.vx = i4 + 1;
                        dVar.vH = 1;
                        this.vs = new b(this.ol);
                        this.vs.a(i2, i3, dVar);
                    } catch (SocketException e) {
                        dVar.vA = String.valueOf(this.ol.fz().responseCode) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.ol.fz().vR = -12;
                        if (this.vj <= 0 && this.vs != null) {
                            this.vj = this.vs.fl();
                        }
                        dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                        this.ol.b(dVar);
                        a fi = a.fi();
                        if (fi != null) {
                            fi.a(this.ol);
                        }
                        z = true;
                    } catch (SocketTimeoutException e2) {
                        dVar.vA = String.valueOf(this.ol.fz().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.ol.fz().vR = -13;
                        if (this.vj <= 0 && this.vs != null) {
                            this.vj = this.vs.fl();
                        }
                        dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                        this.ol.b(dVar);
                        a fi2 = a.fi();
                        if (fi2 != null) {
                            fi2.a(this.ol);
                        }
                        z = true;
                    }
                } catch (IllegalStateException e3) {
                    this.ol.fz().vR = -19;
                    dVar.vA = "errorCode:" + String.valueOf(-19) + "|" + e3.getClass() + "|" + e3.getMessage() + "|getcontent_illegal_error";
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fl();
                    }
                    dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                    this.ol.b(dVar);
                    a fi3 = a.fi();
                    if (fi3 != null) {
                        fi3.a(this.ol);
                    }
                } catch (Exception e4) {
                    dVar.vA = String.valueOf(this.ol.fz().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.ol.fz().vR = -10;
                    BdLog.e(e4.getMessage());
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fl();
                    }
                    dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                    this.ol.b(dVar);
                    a fi4 = a.fi();
                    if (fi4 != null) {
                        fi4.a(this.ol);
                        return;
                    }
                    return;
                }
                if (this.ol.fz().responseCode == 200) {
                    b(null, dVar);
                    this.ol.b(dVar);
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fl();
                    }
                    dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                    this.ol.b(dVar);
                    a fi5 = a.fi();
                    if (fi5 != null) {
                        fi5.a(this.ol);
                        return;
                    }
                    return;
                }
                dVar.vA = String.valueOf(this.ol.fz().responseCode) + "|retryCount:" + i4;
                boolean ah = ah(this.ol.fz().responseCode);
                if (this.vj <= 0 && this.vs != null) {
                    this.vj = this.vs.fl();
                }
                dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                this.ol.b(dVar);
                a fi6 = a.fi();
                if (fi6 != null) {
                    fi6.a(this.ol);
                }
                z = ah;
            } catch (Throwable th) {
                if (this.vj <= 0 && this.vs != null) {
                    this.vj = this.vs.fl();
                }
                dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                this.ol.b(dVar);
                a fi7 = a.fi();
                if (fi7 != null) {
                    fi7.a(this.ol);
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
            i2 = com.baidu.adp.framework.c.b.dr().du().dv();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.dr().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.dr().ds().dv();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.ol.fz().vQ && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.vx = i4 + 1;
            this.vt = i4;
            try {
                try {
                    try {
                        try {
                            this.vs = new b(this.ol);
                            this.vs.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.ol.fz().vR = -14;
                            dVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.ol.a(dVar);
                            if (this.vj <= 0 && this.vs != null) {
                                this.vj = this.vs.fl();
                            }
                            dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                            this.ol.a(dVar);
                            a fi = a.fi();
                            if (fi != null && this.vs != null && this.vs.fo()) {
                                fi.a(this.ol);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.ol.fz().vR = -13;
                        z = true;
                        dVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.ol.a(dVar);
                        if (this.vj <= 0 && this.vs != null) {
                            this.vj = this.vs.fl();
                        }
                        dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                        this.ol.a(dVar);
                        a fi2 = a.fi();
                        if (fi2 != null && this.vs != null && this.vs.fo()) {
                            fi2.a(this.ol);
                        }
                    }
                } catch (SocketException e3) {
                    this.ol.fz().vR = -12;
                    z = true;
                    dVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ol.a(dVar);
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fl();
                    }
                    dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                    this.ol.a(dVar);
                    a fi3 = a.fi();
                    if (fi3 != null && this.vs != null && this.vs.fo()) {
                        fi3.a(this.ol);
                    }
                } catch (Throwable th) {
                    this.ol.fz().vR = -10;
                    z = false;
                    dVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.ol.a(dVar);
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fl();
                    }
                    dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                    this.ol.a(dVar);
                    a fi4 = a.fi();
                    if (fi4 != null && this.vs != null && this.vs.fo()) {
                        fi4.a(this.ol);
                    }
                }
                if (this.ol.fz().responseCode == 200) {
                    b(null, dVar);
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fl();
                    }
                    dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                    this.ol.a(dVar);
                    a fi5 = a.fi();
                    if (fi5 == null || this.vs == null || !this.vs.fo()) {
                        return;
                    }
                    fi5.a(this.ol);
                    return;
                }
                dVar.vA = String.valueOf(this.ol.fz().responseCode) + "|retryCount:" + i4;
                z = ah(this.ol.fz().responseCode);
                this.ol.a(dVar);
                if (this.vj <= 0 && this.vs != null) {
                    this.vj = this.vs.fl();
                }
                dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                this.ol.a(dVar);
                a fi6 = a.fi();
                if (fi6 != null && this.vs != null && this.vs.fo()) {
                    fi6.a(this.ol);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.vj <= 0 && this.vs != null) {
                    this.vj = this.vs.fl();
                }
                dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                this.ol.a(dVar);
                a fi7 = a.fi();
                if (fi7 != null && this.vs != null && this.vs.fo()) {
                    fi7.a(this.ol);
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
        if (this.ol.fy().fC()) {
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
            i2 = com.baidu.adp.framework.c.b.dr().du().dv();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.dr().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.dr().ds().dv();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.ol.fz().vQ && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.vt = i4;
            dVar.vx = i4 + 1;
            try {
                try {
                    try {
                        this.vs = new b(this.ol);
                        this.vs.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.ol.fz().vR = -14;
                        dVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.ol.a(dVar);
                        if (this.vj <= 0 && this.vs != null) {
                            this.vj = this.vs.fl();
                        }
                        dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                        this.ol.a(dVar);
                        a fi = a.fi();
                        if (fi != null) {
                            fi.a(this.ol);
                        }
                    } catch (Throwable th) {
                        this.ol.fz().vR = -10;
                        z = false;
                        dVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.ol.a(dVar);
                        if (this.vj <= 0 && this.vs != null) {
                            this.vj = this.vs.fl();
                        }
                        dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                        this.ol.a(dVar);
                        a fi2 = a.fi();
                        if (fi2 != null) {
                            fi2.a(this.ol);
                        }
                    }
                } catch (SocketException e2) {
                    this.ol.fz().vR = -12;
                    z = true;
                    dVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.ol.a(dVar);
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fl();
                    }
                    dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                    this.ol.a(dVar);
                    a fi3 = a.fi();
                    if (fi3 != null) {
                        fi3.a(this.ol);
                    }
                } catch (SocketTimeoutException e3) {
                    this.ol.fz().vR = -13;
                    z = true;
                    dVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ol.a(dVar);
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fl();
                    }
                    dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                    this.ol.a(dVar);
                    a fi4 = a.fi();
                    if (fi4 != null) {
                        fi4.a(this.ol);
                    }
                }
                if (this.ol.fz().responseCode == 200) {
                    b(null, dVar);
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fl();
                    }
                    dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                    this.ol.a(dVar);
                    a fi5 = a.fi();
                    if (fi5 != null) {
                        fi5.a(this.ol);
                        return;
                    }
                    return;
                }
                dVar.vA = String.valueOf(this.ol.fz().responseCode) + "|retryCount:" + i4;
                z = ah(this.ol.fz().responseCode);
                this.ol.a(dVar);
                if (this.vj <= 0 && this.vs != null) {
                    this.vj = this.vs.fl();
                }
                dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                this.ol.a(dVar);
                a fi6 = a.fi();
                if (fi6 != null) {
                    fi6.a(this.ol);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.vj <= 0 && this.vs != null) {
                    this.vj = this.vs.fl();
                }
                dVar.vy = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eM().b(this.ol.fy().getUrl(), this.ol.fy().ah("Host"), TextUtils.isEmpty(dVar.vA), dVar.vE != null);
                this.ol.a(dVar);
                a fi7 = a.fi();
                if (fi7 != null) {
                    fi7.a(this.ol);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.vs != null) {
            this.vs.fp();
        }
    }

    public boolean fr() {
        if (this.ol == null) {
            return false;
        }
        return this.ol.fz().vQ;
    }

    public void fs() {
        if (this.ol != null) {
            this.ol.fz().vQ = true;
        }
    }

    public long ft() {
        if (this.vj > 0) {
            return this.vj;
        }
        if (this.vs == null) {
            return -1L;
        }
        return this.vs.fl();
    }

    public long fu() {
        if (this.vs == null) {
            return -1L;
        }
        return this.vs.fm();
    }

    public long fn() {
        if (this.vs == null) {
            return -1L;
        }
        return this.vs.fn();
    }

    public long fv() {
        if (this.vs == null) {
            return -1L;
        }
        return this.vs.fk();
    }

    public long fw() {
        if (this.vs == null) {
            return -1L;
        }
        return this.vs.fj();
    }

    public int fx() {
        return this.vt;
    }

    private void b(String str, d dVar) {
        if (ITrafficStatsNativeManager.kk() != null && dVar != null && this.ol.fz() != null) {
            String str2 = str == null ? this.ol.fz().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + dVar.vu + "; downloadSize = " + dVar.vv + "; url=" + dVar.url);
            ITrafficStatsNativeManager.kk().a(str2, dVar.vu + 54, 54 + dVar.vv, dVar.url);
        }
    }
}
