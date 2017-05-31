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
public class d {
    private f ol;
    private b vs;
    private int vt = 0;
    private long vj = 0;

    public d(f fVar) {
        this.ol = fVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=8, 173=4, 174=4, 175=4, 176=4] */
    public boolean a(String str, i iVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int dw = i3 <= 0 ? com.baidu.adp.framework.c.b.ds().dv().dw() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.ds().getRetryCount();
        }
        int dw2 = i4 <= 0 ? com.baidu.adp.framework.c.b.ds().dt().dw() : i4;
        boolean z4 = false;
        this.vs = new b(this.ol);
        int i5 = 0;
        while (i5 < i) {
            e eVar = new e();
            try {
                eVar.vx = i5 + 1;
                this.vt = i5;
                z3 = this.vs.a(str, iVar, dw, dw2, z, eVar, z2);
            } catch (FileNotFoundException e) {
                e = e;
                z3 = z4;
            } catch (Exception e2) {
                e = e2;
                z3 = z4;
            }
            try {
                b("downloadfile", eVar);
                com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                this.ol.a(eVar);
                a fl = a.fl();
                if (fl != null) {
                    fl.a(this.ol);
                    return z3;
                }
                return z3;
            } catch (FileNotFoundException e3) {
                e = e3;
                this.ol.fC().responseCode = -100;
                eVar.vA = String.valueOf(String.valueOf(this.ol.fC().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.ol.a(eVar);
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.ol.fC().responseCode = -10;
                    eVar.vA = String.valueOf(String.valueOf(this.ol.fC().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.ol.a(eVar);
                    com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                    this.ol.a(eVar);
                    a fl2 = a.fl();
                    if (fl2 != null) {
                        fl2.a(this.ol);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                    this.ol.a(eVar);
                    a fl3 = a.fl();
                    if (fl3 != null) {
                        fl3.a(this.ol);
                    }
                }
            }
        }
        return z4;
    }

    public boolean a(String str, i iVar, int i, int i2, int i3, boolean z) {
        return a(str, iVar, i, -1, i2, i3, false, z);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [271=7, 272=7, 274=7, 275=14, 276=7, 277=7, 278=7, 279=7] */
    public void d(int i, int i2, int i3) {
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
        boolean z2 = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.ol.fC().vQ && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.ol.a(eVar);
            try {
                try {
                    try {
                        this.vt = i4;
                        eVar.vx = i4 + 1;
                        eVar.vH = 1;
                        this.vs = new b(this.ol);
                        this.vs.a(i2, i3, eVar);
                    } catch (IllegalStateException e) {
                        this.ol.fC().vR = -19;
                        eVar.vA = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (this.vj <= 0 && this.vs != null) {
                            this.vj = this.vs.fo();
                        }
                        eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                        this.ol.b(eVar);
                        a fl = a.fl();
                        if (fl != null) {
                            fl.a(this.ol);
                        }
                    } catch (SocketTimeoutException e2) {
                        eVar.vA = String.valueOf(String.valueOf(this.ol.fC().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.ol.fC().vR = -13;
                        z = true;
                        if (this.vj <= 0 && this.vs != null) {
                            this.vj = this.vs.fo();
                        }
                        eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                        this.ol.b(eVar);
                        a fl2 = a.fl();
                        if (fl2 != null) {
                            fl2.a(this.ol);
                            z2 = true;
                        }
                        z2 = z;
                    }
                } catch (SocketException e3) {
                    eVar.vA = String.valueOf(String.valueOf(this.ol.fC().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.ol.fC().vR = -12;
                    z = true;
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fo();
                    }
                    eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                    this.ol.b(eVar);
                    a fl3 = a.fl();
                    if (fl3 != null) {
                        fl3.a(this.ol);
                        z2 = true;
                    }
                    z2 = z;
                } catch (Exception e4) {
                    eVar.vA = String.valueOf(String.valueOf(this.ol.fC().responseCode)) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.ol.fC().vR = -10;
                    BdLog.e(e4.getMessage());
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fo();
                    }
                    eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                    this.ol.b(eVar);
                    a fl4 = a.fl();
                    if (fl4 != null) {
                        fl4.a(this.ol);
                        return;
                    }
                    return;
                }
                if (this.ol.fC().responseCode == 200) {
                    b(null, eVar);
                    this.ol.b(eVar);
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fo();
                    }
                    eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                    this.ol.b(eVar);
                    a fl5 = a.fl();
                    if (fl5 != null) {
                        fl5.a(this.ol);
                        return;
                    }
                    return;
                }
                eVar.vA = String.valueOf(String.valueOf(this.ol.fC().responseCode)) + "|retryCount:" + i4;
                boolean ah = ah(this.ol.fC().responseCode);
                if (this.vj <= 0 && this.vs != null) {
                    this.vj = this.vs.fo();
                }
                eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                this.ol.b(eVar);
                a fl6 = a.fl();
                if (fl6 != null) {
                    fl6.a(this.ol);
                    z2 = ah;
                } else {
                    z2 = ah;
                }
            } catch (Throwable th) {
                if (this.vj <= 0 && this.vs != null) {
                    this.vj = this.vs.fo();
                }
                eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                this.ol.b(eVar);
                a fl7 = a.fl();
                if (fl7 != null) {
                    fl7.a(this.ol);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [351=7, 352=7, 354=7, 355=14, 356=7, 357=7, 358=7, 359=7] */
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
        for (int i4 = 0; !this.ol.fC().vQ && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.vx = i4 + 1;
            this.vt = i4;
            try {
                try {
                    try {
                        try {
                            this.vs = new b(this.ol);
                            this.vs.b(i2, i3, eVar);
                        } catch (SocketTimeoutException e) {
                            this.ol.fC().vR = -13;
                            z = true;
                            eVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e.getMessage());
                            this.ol.a(eVar);
                            if (this.vj <= 0 && this.vs != null) {
                                this.vj = this.vs.fo();
                            }
                            eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                            this.ol.a(eVar);
                            a fl = a.fl();
                            if (fl != null && this.vs != null && this.vs.fr()) {
                                fl.a(this.ol);
                            }
                        }
                    } catch (SocketException e2) {
                        this.ol.fC().vR = -12;
                        z = true;
                        eVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.ol.a(eVar);
                        if (this.vj <= 0 && this.vs != null) {
                            this.vj = this.vs.fo();
                        }
                        eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                        this.ol.a(eVar);
                        a fl2 = a.fl();
                        if (fl2 != null && this.vs != null && this.vs.fr()) {
                            fl2.a(this.ol);
                        }
                    }
                } catch (UnsupportedOperationException e3) {
                    z = false;
                    this.ol.fC().vR = -14;
                    eVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.ol.a(eVar);
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fo();
                    }
                    eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                    this.ol.a(eVar);
                    a fl3 = a.fl();
                    if (fl3 != null && this.vs != null && this.vs.fr()) {
                        fl3.a(this.ol);
                    }
                } catch (Throwable th) {
                    this.ol.fC().vR = -10;
                    z = false;
                    eVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.ol.a(eVar);
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fo();
                    }
                    eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                    this.ol.a(eVar);
                    a fl4 = a.fl();
                    if (fl4 != null && this.vs != null && this.vs.fr()) {
                        fl4.a(this.ol);
                    }
                }
                if (this.ol.fC().responseCode == 200) {
                    b(null, eVar);
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fo();
                    }
                    eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                    this.ol.a(eVar);
                    a fl5 = a.fl();
                    if (fl5 == null || this.vs == null || !this.vs.fr()) {
                        return;
                    }
                    fl5.a(this.ol);
                    return;
                }
                eVar.vA = String.valueOf(String.valueOf(this.ol.fC().responseCode)) + "|retryCount:" + i4;
                z = ah(this.ol.fC().responseCode);
                this.ol.a(eVar);
                if (this.vj <= 0 && this.vs != null) {
                    this.vj = this.vs.fo();
                }
                eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                this.ol.a(eVar);
                a fl6 = a.fl();
                if (fl6 != null && this.vs != null && this.vs.fr()) {
                    fl6.a(this.ol);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.vj <= 0 && this.vs != null) {
                    this.vj = this.vs.fo();
                }
                eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                this.ol.a(eVar);
                a fl7 = a.fl();
                if (fl7 != null && this.vs != null && this.vs.fr()) {
                    fl7.a(this.ol);
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
        if (this.ol.fB().fF()) {
            e(i, i2, i3);
        } else {
            g(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [473=7, 474=7, 476=7, 477=14, 478=7, 479=7, 480=7, 481=7] */
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
        for (int i4 = 0; !this.ol.fC().vQ && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.vt = i4;
            eVar.vx = i4 + 1;
            try {
                try {
                    try {
                        try {
                            this.vs = new b(this.ol);
                            this.vs.c(i2, i3, eVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.ol.fC().vR = -14;
                            eVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.ol.a(eVar);
                            if (this.vj <= 0 && this.vs != null) {
                                this.vj = this.vs.fo();
                            }
                            eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                            this.ol.a(eVar);
                            a fl = a.fl();
                            if (fl != null) {
                                fl.a(this.ol);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.ol.fC().vR = -13;
                        z = true;
                        eVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.ol.a(eVar);
                        if (this.vj <= 0 && this.vs != null) {
                            this.vj = this.vs.fo();
                        }
                        eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                        this.ol.a(eVar);
                        a fl2 = a.fl();
                        if (fl2 != null) {
                            fl2.a(this.ol);
                        }
                    }
                } catch (SocketException e3) {
                    this.ol.fC().vR = -12;
                    z = true;
                    eVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ol.a(eVar);
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fo();
                    }
                    eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                    this.ol.a(eVar);
                    a fl3 = a.fl();
                    if (fl3 != null) {
                        fl3.a(this.ol);
                    }
                } catch (Throwable th) {
                    this.ol.fC().vR = -10;
                    z = false;
                    eVar.vA = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.ol.a(eVar);
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fo();
                    }
                    eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                    this.ol.a(eVar);
                    a fl4 = a.fl();
                    if (fl4 != null) {
                        fl4.a(this.ol);
                    }
                }
                if (this.ol.fC().responseCode == 200) {
                    b(null, eVar);
                    if (this.vj <= 0 && this.vs != null) {
                        this.vj = this.vs.fo();
                    }
                    eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                    this.ol.a(eVar);
                    a fl5 = a.fl();
                    if (fl5 != null) {
                        fl5.a(this.ol);
                        return;
                    }
                    return;
                }
                eVar.vA = String.valueOf(String.valueOf(this.ol.fC().responseCode)) + "|retryCount:" + i4;
                z = ah(this.ol.fC().responseCode);
                this.ol.a(eVar);
                if (this.vj <= 0 && this.vs != null) {
                    this.vj = this.vs.fo();
                }
                eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                this.ol.a(eVar);
                a fl6 = a.fl();
                if (fl6 != null) {
                    fl6.a(this.ol);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.vj <= 0 && this.vs != null) {
                    this.vj = this.vs.fo();
                }
                eVar.vy = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.ol.fB().getUrl(), this.ol.fB().aa("Host"), TextUtils.isEmpty(eVar.vA), eVar.vE != null);
                this.ol.a(eVar);
                a fl7 = a.fl();
                if (fl7 != null) {
                    fl7.a(this.ol);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.vs != null) {
            this.vs.fs();
        }
    }

    public boolean fu() {
        if (this.ol == null) {
            return false;
        }
        return this.ol.fC().vQ;
    }

    public void fv() {
        if (this.ol != null) {
            this.ol.fC().vQ = true;
        }
    }

    public long fw() {
        if (this.vj > 0) {
            return this.vj;
        }
        if (this.vs == null) {
            return -1L;
        }
        return this.vs.fo();
    }

    public long fx() {
        if (this.vs == null) {
            return -1L;
        }
        return this.vs.fp();
    }

    public long fq() {
        if (this.vs == null) {
            return -1L;
        }
        return this.vs.fq();
    }

    public long fy() {
        if (this.vs == null) {
            return -1L;
        }
        return this.vs.fn();
    }

    public long fz() {
        if (this.vs == null) {
            return -1L;
        }
        return this.vs.fm();
    }

    public int fA() {
        return this.vt;
    }

    private void b(String str, e eVar) {
        if (ITrafficStatsNativeManager.kn() != null && eVar != null && this.ol.fC() != null) {
            String str2 = str == null ? this.ol.fC().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + eVar.vu + "; downloadSize = " + eVar.vv + "; url=" + eVar.url);
            ITrafficStatsNativeManager.kn().a(str2, eVar.vu + 54, eVar.vv + 54, eVar.url);
        }
    }
}
