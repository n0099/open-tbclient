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
    private b vr;
    private int vs = 0;
    private long vi = 0;

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
        this.vr = new b(this.ol);
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
                com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                this.ol.a(eVar);
                a fk = a.fk();
                if (fk != null) {
                    fk.a(this.ol);
                    return z3;
                }
                return z3;
            } catch (FileNotFoundException e3) {
                e = e3;
                this.ol.fB().responseCode = -100;
                eVar.vz = String.valueOf(String.valueOf(this.ol.fB().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.ol.a(eVar);
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.ol.fB().responseCode = -10;
                    eVar.vz = String.valueOf(String.valueOf(this.ol.fB().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.ol.a(eVar);
                    com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.ol.a(eVar);
                    a fk2 = a.fk();
                    if (fk2 != null) {
                        fk2.a(this.ol);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.ol.a(eVar);
                    a fk3 = a.fk();
                    if (fk3 != null) {
                        fk3.a(this.ol);
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
        for (int i4 = 0; !this.ol.fB().vP && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.ol.a(eVar);
            try {
                try {
                    try {
                        this.vs = i4;
                        eVar.vw = i4 + 1;
                        eVar.vG = 1;
                        this.vr = new b(this.ol);
                        this.vr.a(i2, i3, eVar);
                    } catch (IllegalStateException e) {
                        this.ol.fB().vQ = -19;
                        eVar.vz = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (this.vi <= 0 && this.vr != null) {
                            this.vi = this.vr.fn();
                        }
                        eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                        this.ol.b(eVar);
                        a fk = a.fk();
                        if (fk != null) {
                            fk.a(this.ol);
                        }
                    } catch (SocketTimeoutException e2) {
                        eVar.vz = String.valueOf(String.valueOf(this.ol.fB().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.ol.fB().vQ = -13;
                        z = true;
                        if (this.vi <= 0 && this.vr != null) {
                            this.vi = this.vr.fn();
                        }
                        eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                        this.ol.b(eVar);
                        a fk2 = a.fk();
                        if (fk2 != null) {
                            fk2.a(this.ol);
                            z2 = true;
                        }
                        z2 = z;
                    }
                } catch (SocketException e3) {
                    eVar.vz = String.valueOf(String.valueOf(this.ol.fB().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.ol.fB().vQ = -12;
                    z = true;
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fn();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.ol.b(eVar);
                    a fk3 = a.fk();
                    if (fk3 != null) {
                        fk3.a(this.ol);
                        z2 = true;
                    }
                    z2 = z;
                } catch (Exception e4) {
                    eVar.vz = String.valueOf(String.valueOf(this.ol.fB().responseCode)) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.ol.fB().vQ = -10;
                    BdLog.e(e4.getMessage());
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fn();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.ol.b(eVar);
                    a fk4 = a.fk();
                    if (fk4 != null) {
                        fk4.a(this.ol);
                        return;
                    }
                    return;
                }
                if (this.ol.fB().responseCode == 200) {
                    b(null, eVar);
                    this.ol.b(eVar);
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fn();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.ol.b(eVar);
                    a fk5 = a.fk();
                    if (fk5 != null) {
                        fk5.a(this.ol);
                        return;
                    }
                    return;
                }
                eVar.vz = String.valueOf(String.valueOf(this.ol.fB().responseCode)) + "|retryCount:" + i4;
                boolean ah = ah(this.ol.fB().responseCode);
                if (this.vi <= 0 && this.vr != null) {
                    this.vi = this.vr.fn();
                }
                eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                this.ol.b(eVar);
                a fk6 = a.fk();
                if (fk6 != null) {
                    fk6.a(this.ol);
                    z2 = ah;
                } else {
                    z2 = ah;
                }
            } catch (Throwable th) {
                if (this.vi <= 0 && this.vr != null) {
                    this.vi = this.vr.fn();
                }
                eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                this.ol.b(eVar);
                a fk7 = a.fk();
                if (fk7 != null) {
                    fk7.a(this.ol);
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
        for (int i4 = 0; !this.ol.fB().vP && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.vw = i4 + 1;
            this.vs = i4;
            try {
                try {
                    try {
                        try {
                            this.vr = new b(this.ol);
                            this.vr.b(i2, i3, eVar);
                        } catch (SocketTimeoutException e) {
                            this.ol.fB().vQ = -13;
                            z = true;
                            eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e.getMessage());
                            this.ol.a(eVar);
                            if (this.vi <= 0 && this.vr != null) {
                                this.vi = this.vr.fn();
                            }
                            eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                            this.ol.a(eVar);
                            a fk = a.fk();
                            if (fk != null && this.vr != null && this.vr.fq()) {
                                fk.a(this.ol);
                            }
                        }
                    } catch (SocketException e2) {
                        this.ol.fB().vQ = -12;
                        z = true;
                        eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.ol.a(eVar);
                        if (this.vi <= 0 && this.vr != null) {
                            this.vi = this.vr.fn();
                        }
                        eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                        this.ol.a(eVar);
                        a fk2 = a.fk();
                        if (fk2 != null && this.vr != null && this.vr.fq()) {
                            fk2.a(this.ol);
                        }
                    }
                } catch (UnsupportedOperationException e3) {
                    z = false;
                    this.ol.fB().vQ = -14;
                    eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.ol.a(eVar);
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fn();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.ol.a(eVar);
                    a fk3 = a.fk();
                    if (fk3 != null && this.vr != null && this.vr.fq()) {
                        fk3.a(this.ol);
                    }
                } catch (Throwable th) {
                    this.ol.fB().vQ = -10;
                    z = false;
                    eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.ol.a(eVar);
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fn();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.ol.a(eVar);
                    a fk4 = a.fk();
                    if (fk4 != null && this.vr != null && this.vr.fq()) {
                        fk4.a(this.ol);
                    }
                }
                if (this.ol.fB().responseCode == 200) {
                    b(null, eVar);
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fn();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.ol.a(eVar);
                    a fk5 = a.fk();
                    if (fk5 == null || this.vr == null || !this.vr.fq()) {
                        return;
                    }
                    fk5.a(this.ol);
                    return;
                }
                eVar.vz = String.valueOf(String.valueOf(this.ol.fB().responseCode)) + "|retryCount:" + i4;
                z = ah(this.ol.fB().responseCode);
                this.ol.a(eVar);
                if (this.vi <= 0 && this.vr != null) {
                    this.vi = this.vr.fn();
                }
                eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                this.ol.a(eVar);
                a fk6 = a.fk();
                if (fk6 != null && this.vr != null && this.vr.fq()) {
                    fk6.a(this.ol);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.vi <= 0 && this.vr != null) {
                    this.vi = this.vr.fn();
                }
                eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                this.ol.a(eVar);
                a fk7 = a.fk();
                if (fk7 != null && this.vr != null && this.vr.fq()) {
                    fk7.a(this.ol);
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
        if (this.ol.fA().fE()) {
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
        for (int i4 = 0; !this.ol.fB().vP && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.vs = i4;
            eVar.vw = i4 + 1;
            try {
                try {
                    try {
                        try {
                            this.vr = new b(this.ol);
                            this.vr.c(i2, i3, eVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.ol.fB().vQ = -14;
                            eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.ol.a(eVar);
                            if (this.vi <= 0 && this.vr != null) {
                                this.vi = this.vr.fn();
                            }
                            eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                            this.ol.a(eVar);
                            a fk = a.fk();
                            if (fk != null) {
                                fk.a(this.ol);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.ol.fB().vQ = -13;
                        z = true;
                        eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.ol.a(eVar);
                        if (this.vi <= 0 && this.vr != null) {
                            this.vi = this.vr.fn();
                        }
                        eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                        this.ol.a(eVar);
                        a fk2 = a.fk();
                        if (fk2 != null) {
                            fk2.a(this.ol);
                        }
                    }
                } catch (SocketException e3) {
                    this.ol.fB().vQ = -12;
                    z = true;
                    eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.ol.a(eVar);
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fn();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.ol.a(eVar);
                    a fk3 = a.fk();
                    if (fk3 != null) {
                        fk3.a(this.ol);
                    }
                } catch (Throwable th) {
                    this.ol.fB().vQ = -10;
                    z = false;
                    eVar.vz = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.ol.a(eVar);
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fn();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.ol.a(eVar);
                    a fk4 = a.fk();
                    if (fk4 != null) {
                        fk4.a(this.ol);
                    }
                }
                if (this.ol.fB().responseCode == 200) {
                    b(null, eVar);
                    if (this.vi <= 0 && this.vr != null) {
                        this.vi = this.vr.fn();
                    }
                    eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                    this.ol.a(eVar);
                    a fk5 = a.fk();
                    if (fk5 != null) {
                        fk5.a(this.ol);
                        return;
                    }
                    return;
                }
                eVar.vz = String.valueOf(String.valueOf(this.ol.fB().responseCode)) + "|retryCount:" + i4;
                z = ah(this.ol.fB().responseCode);
                this.ol.a(eVar);
                if (this.vi <= 0 && this.vr != null) {
                    this.vi = this.vr.fn();
                }
                eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                this.ol.a(eVar);
                a fk6 = a.fk();
                if (fk6 != null) {
                    fk6.a(this.ol);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.vi <= 0 && this.vr != null) {
                    this.vi = this.vr.fn();
                }
                eVar.vx = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eO().b(this.ol.fA().getUrl(), this.ol.fA().af("Host"), TextUtils.isEmpty(eVar.vz), eVar.vD != null);
                this.ol.a(eVar);
                a fk7 = a.fk();
                if (fk7 != null) {
                    fk7.a(this.ol);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.vr != null) {
            this.vr.fr();
        }
    }

    public boolean ft() {
        if (this.ol == null) {
            return false;
        }
        return this.ol.fB().vP;
    }

    public void fu() {
        if (this.ol != null) {
            this.ol.fB().vP = true;
        }
    }

    public long fv() {
        if (this.vi > 0) {
            return this.vi;
        }
        if (this.vr == null) {
            return -1L;
        }
        return this.vr.fn();
    }

    public long fw() {
        if (this.vr == null) {
            return -1L;
        }
        return this.vr.fo();
    }

    public long fp() {
        if (this.vr == null) {
            return -1L;
        }
        return this.vr.fp();
    }

    public long fx() {
        if (this.vr == null) {
            return -1L;
        }
        return this.vr.fm();
    }

    public long fy() {
        if (this.vr == null) {
            return -1L;
        }
        return this.vr.fl();
    }

    public int fz() {
        return this.vs;
    }

    private void b(String str, e eVar) {
        if (ITrafficStatsNativeManager.kl() != null && eVar != null && this.ol.fB() != null) {
            String str2 = str == null ? this.ol.fB().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + eVar.vt + "; downloadSize = " + eVar.vu + "; url=" + eVar.url);
            ITrafficStatsNativeManager.kl().a(str2, eVar.vt + 54, eVar.vu + 54, eVar.url);
        }
    }
}
