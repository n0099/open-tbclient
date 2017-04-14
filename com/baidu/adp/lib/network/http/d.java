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
    private b vm;
    private int vn = 0;
    private long vd = 0;

    public d(f fVar) {
        this.oj = fVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=8, 173=4, 174=4, 175=4, 176=4] */
    public boolean a(String str, i iVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int dv = i3 <= 0 ? com.baidu.adp.framework.c.b.dr().du().dv() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.dr().getRetryCount();
        }
        int dv2 = i4 <= 0 ? com.baidu.adp.framework.c.b.dr().ds().dv() : i4;
        boolean z4 = false;
        this.vm = new b(this.oj);
        int i5 = 0;
        while (i5 < i) {
            e eVar = new e();
            try {
                eVar.vs = i5 + 1;
                this.vn = i5;
                z3 = this.vm.a(str, iVar, dv, dv2, z, eVar, z2);
            } catch (FileNotFoundException e) {
                e = e;
                z3 = z4;
            } catch (Exception e2) {
                e = e2;
                z3 = z4;
            }
            try {
                b("downloadfile", eVar);
                com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                this.oj.a(eVar);
                a fk = a.fk();
                if (fk != null) {
                    fk.a(this.oj);
                    return z3;
                }
                return z3;
            } catch (FileNotFoundException e3) {
                e = e3;
                this.oj.fB().responseCode = -100;
                eVar.vv = String.valueOf(String.valueOf(this.oj.fB().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.oj.a(eVar);
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.oj.fB().responseCode = -10;
                    eVar.vv = String.valueOf(String.valueOf(this.oj.fB().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.oj.a(eVar);
                    com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                    this.oj.a(eVar);
                    a fk2 = a.fk();
                    if (fk2 != null) {
                        fk2.a(this.oj);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                    this.oj.a(eVar);
                    a fk3 = a.fk();
                    if (fk3 != null) {
                        fk3.a(this.oj);
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
            i2 = com.baidu.adp.framework.c.b.dr().du().dv();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.dr().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.dr().ds().dv();
        }
        boolean z2 = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.oj.fB().vL && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.oj.a(eVar);
            try {
                try {
                    try {
                        this.vn = i4;
                        eVar.vs = i4 + 1;
                        eVar.vC = 1;
                        this.vm = new b(this.oj);
                        this.vm.a(i2, i3, eVar);
                    } catch (IllegalStateException e) {
                        this.oj.fB().vM = -19;
                        eVar.vv = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (this.vd <= 0 && this.vm != null) {
                            this.vd = this.vm.fn();
                        }
                        eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                        this.oj.b(eVar);
                        a fk = a.fk();
                        if (fk != null) {
                            fk.a(this.oj);
                        }
                    } catch (SocketTimeoutException e2) {
                        eVar.vv = String.valueOf(String.valueOf(this.oj.fB().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.oj.fB().vM = -13;
                        z = true;
                        if (this.vd <= 0 && this.vm != null) {
                            this.vd = this.vm.fn();
                        }
                        eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                        this.oj.b(eVar);
                        a fk2 = a.fk();
                        if (fk2 != null) {
                            fk2.a(this.oj);
                            z2 = true;
                        }
                        z2 = z;
                    }
                } catch (SocketException e3) {
                    eVar.vv = String.valueOf(String.valueOf(this.oj.fB().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.oj.fB().vM = -12;
                    z = true;
                    if (this.vd <= 0 && this.vm != null) {
                        this.vd = this.vm.fn();
                    }
                    eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                    this.oj.b(eVar);
                    a fk3 = a.fk();
                    if (fk3 != null) {
                        fk3.a(this.oj);
                        z2 = true;
                    }
                    z2 = z;
                } catch (Exception e4) {
                    eVar.vv = String.valueOf(String.valueOf(this.oj.fB().responseCode)) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.oj.fB().vM = -10;
                    BdLog.e(e4.getMessage());
                    if (this.vd <= 0 && this.vm != null) {
                        this.vd = this.vm.fn();
                    }
                    eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                    this.oj.b(eVar);
                    a fk4 = a.fk();
                    if (fk4 != null) {
                        fk4.a(this.oj);
                        return;
                    }
                    return;
                }
                if (this.oj.fB().responseCode == 200) {
                    b(null, eVar);
                    this.oj.b(eVar);
                    if (this.vd <= 0 && this.vm != null) {
                        this.vd = this.vm.fn();
                    }
                    eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                    this.oj.b(eVar);
                    a fk5 = a.fk();
                    if (fk5 != null) {
                        fk5.a(this.oj);
                        return;
                    }
                    return;
                }
                eVar.vv = String.valueOf(String.valueOf(this.oj.fB().responseCode)) + "|retryCount:" + i4;
                boolean ah = ah(this.oj.fB().responseCode);
                if (this.vd <= 0 && this.vm != null) {
                    this.vd = this.vm.fn();
                }
                eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                this.oj.b(eVar);
                a fk6 = a.fk();
                if (fk6 != null) {
                    fk6.a(this.oj);
                    z2 = ah;
                } else {
                    z2 = ah;
                }
            } catch (Throwable th) {
                if (this.vd <= 0 && this.vm != null) {
                    this.vd = this.vm.fn();
                }
                eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                this.oj.b(eVar);
                a fk7 = a.fk();
                if (fk7 != null) {
                    fk7.a(this.oj);
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
        for (int i4 = 0; !this.oj.fB().vL && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.vs = i4 + 1;
            this.vn = i4;
            try {
                try {
                    try {
                        try {
                            this.vm = new b(this.oj);
                            this.vm.b(i2, i3, eVar);
                        } catch (SocketTimeoutException e) {
                            this.oj.fB().vM = -13;
                            z = true;
                            eVar.vv = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e.getMessage());
                            this.oj.a(eVar);
                            if (this.vd <= 0 && this.vm != null) {
                                this.vd = this.vm.fn();
                            }
                            eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                            this.oj.a(eVar);
                            a fk = a.fk();
                            if (fk != null && this.vm != null && this.vm.fq()) {
                                fk.a(this.oj);
                            }
                        }
                    } catch (SocketException e2) {
                        this.oj.fB().vM = -12;
                        z = true;
                        eVar.vv = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.oj.a(eVar);
                        if (this.vd <= 0 && this.vm != null) {
                            this.vd = this.vm.fn();
                        }
                        eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                        this.oj.a(eVar);
                        a fk2 = a.fk();
                        if (fk2 != null && this.vm != null && this.vm.fq()) {
                            fk2.a(this.oj);
                        }
                    }
                } catch (UnsupportedOperationException e3) {
                    z = false;
                    this.oj.fB().vM = -14;
                    eVar.vv = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.oj.a(eVar);
                    if (this.vd <= 0 && this.vm != null) {
                        this.vd = this.vm.fn();
                    }
                    eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                    this.oj.a(eVar);
                    a fk3 = a.fk();
                    if (fk3 != null && this.vm != null && this.vm.fq()) {
                        fk3.a(this.oj);
                    }
                } catch (Throwable th) {
                    this.oj.fB().vM = -10;
                    z = false;
                    eVar.vv = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.oj.a(eVar);
                    if (this.vd <= 0 && this.vm != null) {
                        this.vd = this.vm.fn();
                    }
                    eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                    this.oj.a(eVar);
                    a fk4 = a.fk();
                    if (fk4 != null && this.vm != null && this.vm.fq()) {
                        fk4.a(this.oj);
                    }
                }
                if (this.oj.fB().responseCode == 200) {
                    b(null, eVar);
                    if (this.vd <= 0 && this.vm != null) {
                        this.vd = this.vm.fn();
                    }
                    eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                    this.oj.a(eVar);
                    a fk5 = a.fk();
                    if (fk5 == null || this.vm == null || !this.vm.fq()) {
                        return;
                    }
                    fk5.a(this.oj);
                    return;
                }
                eVar.vv = String.valueOf(String.valueOf(this.oj.fB().responseCode)) + "|retryCount:" + i4;
                z = ah(this.oj.fB().responseCode);
                this.oj.a(eVar);
                if (this.vd <= 0 && this.vm != null) {
                    this.vd = this.vm.fn();
                }
                eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                this.oj.a(eVar);
                a fk6 = a.fk();
                if (fk6 != null && this.vm != null && this.vm.fq()) {
                    fk6.a(this.oj);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.vd <= 0 && this.vm != null) {
                    this.vd = this.vm.fn();
                }
                eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                this.oj.a(eVar);
                a fk7 = a.fk();
                if (fk7 != null && this.vm != null && this.vm.fq()) {
                    fk7.a(this.oj);
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
        if (this.oj.fA().fE()) {
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
        for (int i4 = 0; !this.oj.fB().vL && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.vn = i4;
            eVar.vs = i4 + 1;
            try {
                try {
                    try {
                        try {
                            this.vm = new b(this.oj);
                            this.vm.c(i2, i3, eVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.oj.fB().vM = -14;
                            eVar.vv = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.oj.a(eVar);
                            if (this.vd <= 0 && this.vm != null) {
                                this.vd = this.vm.fn();
                            }
                            eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                            this.oj.a(eVar);
                            a fk = a.fk();
                            if (fk != null) {
                                fk.a(this.oj);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.oj.fB().vM = -13;
                        z = true;
                        eVar.vv = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.oj.a(eVar);
                        if (this.vd <= 0 && this.vm != null) {
                            this.vd = this.vm.fn();
                        }
                        eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                        this.oj.a(eVar);
                        a fk2 = a.fk();
                        if (fk2 != null) {
                            fk2.a(this.oj);
                        }
                    }
                } catch (SocketException e3) {
                    this.oj.fB().vM = -12;
                    z = true;
                    eVar.vv = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oj.a(eVar);
                    if (this.vd <= 0 && this.vm != null) {
                        this.vd = this.vm.fn();
                    }
                    eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                    this.oj.a(eVar);
                    a fk3 = a.fk();
                    if (fk3 != null) {
                        fk3.a(this.oj);
                    }
                } catch (Throwable th) {
                    this.oj.fB().vM = -10;
                    z = false;
                    eVar.vv = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.oj.a(eVar);
                    if (this.vd <= 0 && this.vm != null) {
                        this.vd = this.vm.fn();
                    }
                    eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                    this.oj.a(eVar);
                    a fk4 = a.fk();
                    if (fk4 != null) {
                        fk4.a(this.oj);
                    }
                }
                if (this.oj.fB().responseCode == 200) {
                    b(null, eVar);
                    if (this.vd <= 0 && this.vm != null) {
                        this.vd = this.vm.fn();
                    }
                    eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                    this.oj.a(eVar);
                    a fk5 = a.fk();
                    if (fk5 != null) {
                        fk5.a(this.oj);
                        return;
                    }
                    return;
                }
                eVar.vv = String.valueOf(String.valueOf(this.oj.fB().responseCode)) + "|retryCount:" + i4;
                z = ah(this.oj.fB().responseCode);
                this.oj.a(eVar);
                if (this.vd <= 0 && this.vm != null) {
                    this.vd = this.vm.fn();
                }
                eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                this.oj.a(eVar);
                a fk6 = a.fk();
                if (fk6 != null) {
                    fk6.a(this.oj);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.vd <= 0 && this.vm != null) {
                    this.vd = this.vm.fn();
                }
                eVar.vt = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eO().b(this.oj.fA().getUrl(), this.oj.fA().aa("Host"), TextUtils.isEmpty(eVar.vv), eVar.vz != null);
                this.oj.a(eVar);
                a fk7 = a.fk();
                if (fk7 != null) {
                    fk7.a(this.oj);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.vm != null) {
            this.vm.fr();
        }
    }

    public boolean ft() {
        if (this.oj == null) {
            return false;
        }
        return this.oj.fB().vL;
    }

    public void fu() {
        if (this.oj != null) {
            this.oj.fB().vL = true;
        }
    }

    public long fv() {
        if (this.vd > 0) {
            return this.vd;
        }
        if (this.vm == null) {
            return -1L;
        }
        return this.vm.fn();
    }

    public long fw() {
        if (this.vm == null) {
            return -1L;
        }
        return this.vm.fo();
    }

    public long fp() {
        if (this.vm == null) {
            return -1L;
        }
        return this.vm.fp();
    }

    public long fx() {
        if (this.vm == null) {
            return -1L;
        }
        return this.vm.fm();
    }

    public long fy() {
        if (this.vm == null) {
            return -1L;
        }
        return this.vm.fl();
    }

    public int fz() {
        return this.vn;
    }

    private void b(String str, e eVar) {
        if (ITrafficStatsNativeManager.kn() != null && eVar != null && this.oj.fB() != null) {
            String str2 = str == null ? this.oj.fB().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + eVar.vo + "; downloadSize = " + eVar.vp + "; url=" + eVar.url);
            ITrafficStatsNativeManager.kn().a(str2, eVar.vo + 54, eVar.vp + 54, eVar.url);
        }
    }
}
