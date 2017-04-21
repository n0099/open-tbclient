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
    private f oj;
    private b vr;
    private int vs = 0;
    private long vi = 0;

    public d(f fVar) {
        this.oj = fVar;
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
        this.vr = new b(this.oj);
        int i5 = 0;
        while (i5 < i) {
            e eVar = new e();
            try {
                eVar.vw = i5 + 1;
                this.vs = i5;
                z3 = this.vr.a(str, iVar, dw, dw2, z, eVar, z2);
            } catch (FileNotFoundException e) {
                e = e;
                z3 = z4;
            } catch (Exception e2) {
                e = e2;
                z3 = z4;
            }
            try {
                b("downloadfile", eVar);
                com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                this.oj.a(eVar);
                a fl = a.fl();
                if (fl != null) {
                    fl.a(this.oj);
                    return z3;
                }
                return z3;
            } catch (FileNotFoundException e3) {
                e = e3;
                this.oj.fC().responseCode = -100;
                eVar.vz = String.valueOf(String.valueOf(this.oj.fC().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.oj.a(eVar);
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.oj.fC().responseCode = -10;
                    eVar.vz = String.valueOf(String.valueOf(this.oj.fC().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.oj.a(eVar);
                    com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.oj.a(eVar);
                    a fl2 = a.fl();
                    if (fl2 != null) {
                        fl2.a(this.oj);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.oj.a(eVar);
                    a fl3 = a.fl();
                    if (fl3 != null) {
                        fl3.a(this.oj);
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
        for (int i4 = 0; !this.oj.fC().vP && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.oj.a(eVar);
            try {
                try {
                    try {
                        this.vs = i4;
                        eVar.vw = i4 + 1;
                        eVar.vG = 1;
                        this.vr = new b(this.oj);
                        this.vr.a(i2, i3, eVar);
                    } catch (IllegalStateException e) {
                        this.oj.fC().vQ = -19;
                        eVar.vz = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (this.vi <= 0 && this.vr != null) {
                            this.vi = this.vr.fo();
                        }
                        eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                        this.oj.b(eVar);
                        a fl = a.fl();
                        if (fl != null) {
                            fl.a(this.oj);
                        }
                    } catch (SocketTimeoutException e2) {
                        eVar.vz = String.valueOf(String.valueOf(this.oj.fC().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.oj.fC().vQ = -13;
                        z = true;
                        if (this.vi <= 0 && this.vr != null) {
                            this.vi = this.vr.fo();
                        }
                        eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                        this.oj.b(eVar);
                        a fl2 = a.fl();
                        if (fl2 != null) {
                            fl2.a(this.oj);
                            z2 = true;
                        }
                        z2 = z;
                    }
                } catch (SocketException e3) {
                    eVar.vz = String.valueOf(String.valueOf(this.oj.fC().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.oj.fC().vQ = -12;
                    z = true;
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fo();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.oj.b(eVar);
                    a fl3 = a.fl();
                    if (fl3 != null) {
                        fl3.a(this.oj);
                        z2 = true;
                    }
                    z2 = z;
                } catch (Exception e4) {
                    eVar.vz = String.valueOf(String.valueOf(this.oj.fC().responseCode)) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.oj.fC().vQ = -10;
                    BdLog.e(e4.getMessage());
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fo();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.oj.b(eVar);
                    a fl4 = a.fl();
                    if (fl4 != null) {
                        fl4.a(this.oj);
                        return;
                    }
                    return;
                }
                if (this.oj.fC().responseCode == 200) {
                    b(null, eVar);
                    this.oj.b(eVar);
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fo();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.oj.b(eVar);
                    a fl5 = a.fl();
                    if (fl5 != null) {
                        fl5.a(this.oj);
                        return;
                    }
                    return;
                }
                eVar.vz = String.valueOf(String.valueOf(this.oj.fC().responseCode)) + "|retryCount:" + i4;
                boolean ah = ah(this.oj.fC().responseCode);
                if (this.vi <= 0 && this.vr != null) {
                    this.vi = this.vr.fo();
                }
                eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                this.oj.b(eVar);
                a fl6 = a.fl();
                if (fl6 != null) {
                    fl6.a(this.oj);
                    z2 = ah;
                } else {
                    z2 = ah;
                }
            } catch (Throwable th) {
                if (this.vi <= 0 && this.vr != null) {
                    this.vi = this.vr.fo();
                }
                eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                this.oj.b(eVar);
                a fl7 = a.fl();
                if (fl7 != null) {
                    fl7.a(this.oj);
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
        for (int i4 = 0; !this.oj.fC().vP && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.vw = i4 + 1;
            this.vs = i4;
            try {
                try {
                    try {
                        try {
                            this.vr = new b(this.oj);
                            this.vr.b(i2, i3, eVar);
                        } catch (SocketTimeoutException e) {
                            this.oj.fC().vQ = -13;
                            z = true;
                            eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e.getMessage());
                            this.oj.a(eVar);
                            if (this.vi <= 0 && this.vr != null) {
                                this.vi = this.vr.fo();
                            }
                            eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                            this.oj.a(eVar);
                            a fl = a.fl();
                            if (fl != null && this.vr != null && this.vr.fr()) {
                                fl.a(this.oj);
                            }
                        }
                    } catch (SocketException e2) {
                        this.oj.fC().vQ = -12;
                        z = true;
                        eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.oj.a(eVar);
                        if (this.vi <= 0 && this.vr != null) {
                            this.vi = this.vr.fo();
                        }
                        eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                        this.oj.a(eVar);
                        a fl2 = a.fl();
                        if (fl2 != null && this.vr != null && this.vr.fr()) {
                            fl2.a(this.oj);
                        }
                    }
                } catch (UnsupportedOperationException e3) {
                    z = false;
                    this.oj.fC().vQ = -14;
                    eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.oj.a(eVar);
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fo();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.oj.a(eVar);
                    a fl3 = a.fl();
                    if (fl3 != null && this.vr != null && this.vr.fr()) {
                        fl3.a(this.oj);
                    }
                } catch (Throwable th) {
                    this.oj.fC().vQ = -10;
                    z = false;
                    eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.oj.a(eVar);
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fo();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.oj.a(eVar);
                    a fl4 = a.fl();
                    if (fl4 != null && this.vr != null && this.vr.fr()) {
                        fl4.a(this.oj);
                    }
                }
                if (this.oj.fC().responseCode == 200) {
                    b(null, eVar);
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fo();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.oj.a(eVar);
                    a fl5 = a.fl();
                    if (fl5 == null || this.vr == null || !this.vr.fr()) {
                        return;
                    }
                    fl5.a(this.oj);
                    return;
                }
                eVar.vz = String.valueOf(String.valueOf(this.oj.fC().responseCode)) + "|retryCount:" + i4;
                z = ah(this.oj.fC().responseCode);
                this.oj.a(eVar);
                if (this.vi <= 0 && this.vr != null) {
                    this.vi = this.vr.fo();
                }
                eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                this.oj.a(eVar);
                a fl6 = a.fl();
                if (fl6 != null && this.vr != null && this.vr.fr()) {
                    fl6.a(this.oj);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.vi <= 0 && this.vr != null) {
                    this.vi = this.vr.fo();
                }
                eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                this.oj.a(eVar);
                a fl7 = a.fl();
                if (fl7 != null && this.vr != null && this.vr.fr()) {
                    fl7.a(this.oj);
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
        if (this.oj.fB().fF()) {
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
        for (int i4 = 0; !this.oj.fC().vP && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.vs = i4;
            eVar.vw = i4 + 1;
            try {
                try {
                    try {
                        try {
                            this.vr = new b(this.oj);
                            this.vr.c(i2, i3, eVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.oj.fC().vQ = -14;
                            eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.oj.a(eVar);
                            if (this.vi <= 0 && this.vr != null) {
                                this.vi = this.vr.fo();
                            }
                            eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                            this.oj.a(eVar);
                            a fl = a.fl();
                            if (fl != null) {
                                fl.a(this.oj);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.oj.fC().vQ = -13;
                        z = true;
                        eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.oj.a(eVar);
                        if (this.vi <= 0 && this.vr != null) {
                            this.vi = this.vr.fo();
                        }
                        eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                        this.oj.a(eVar);
                        a fl2 = a.fl();
                        if (fl2 != null) {
                            fl2.a(this.oj);
                        }
                    }
                } catch (SocketException e3) {
                    this.oj.fC().vQ = -12;
                    z = true;
                    eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oj.a(eVar);
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fo();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.oj.a(eVar);
                    a fl3 = a.fl();
                    if (fl3 != null) {
                        fl3.a(this.oj);
                    }
                } catch (Throwable th) {
                    this.oj.fC().vQ = -10;
                    z = false;
                    eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.oj.a(eVar);
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fo();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.oj.a(eVar);
                    a fl4 = a.fl();
                    if (fl4 != null) {
                        fl4.a(this.oj);
                    }
                }
                if (this.oj.fC().responseCode == 200) {
                    b(null, eVar);
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fo();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.oj.a(eVar);
                    a fl5 = a.fl();
                    if (fl5 != null) {
                        fl5.a(this.oj);
                        return;
                    }
                    return;
                }
                eVar.vz = String.valueOf(String.valueOf(this.oj.fC().responseCode)) + "|retryCount:" + i4;
                z = ah(this.oj.fC().responseCode);
                this.oj.a(eVar);
                if (this.vi <= 0 && this.vr != null) {
                    this.vi = this.vr.fo();
                }
                eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                this.oj.a(eVar);
                a fl6 = a.fl();
                if (fl6 != null) {
                    fl6.a(this.oj);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.vi <= 0 && this.vr != null) {
                    this.vi = this.vr.fo();
                }
                eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.oj.fB().getUrl(), this.oj.fB().aa("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                this.oj.a(eVar);
                a fl7 = a.fl();
                if (fl7 != null) {
                    fl7.a(this.oj);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.vr != null) {
            this.vr.fs();
        }
    }

    public boolean fu() {
        if (this.oj == null) {
            return false;
        }
        return this.oj.fC().vP;
    }

    public void fv() {
        if (this.oj != null) {
            this.oj.fC().vP = true;
        }
    }

    public long fw() {
        if (this.vi > 0) {
            return this.vi;
        }
        if (this.vr == null) {
            return -1L;
        }
        return this.vr.fo();
    }

    public long fx() {
        if (this.vr == null) {
            return -1L;
        }
        return this.vr.fp();
    }

    public long fq() {
        if (this.vr == null) {
            return -1L;
        }
        return this.vr.fq();
    }

    public long fy() {
        if (this.vr == null) {
            return -1L;
        }
        return this.vr.fn();
    }

    public long fz() {
        if (this.vr == null) {
            return -1L;
        }
        return this.vr.fm();
    }

    public int fA() {
        return this.vs;
    }

    private void b(String str, e eVar) {
        if (ITrafficStatsNativeManager.ko() != null && eVar != null && this.oj.fC() != null) {
            String str2 = str == null ? this.oj.fC().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + eVar.vt + "; downloadSize = " + eVar.vu + "; url=" + eVar.url);
            ITrafficStatsNativeManager.ko().a(str2, eVar.vt + 54, eVar.vu + 54, eVar.url);
        }
    }
}
