package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
public class d {
    private f eh;
    private b le;
    private int lf = 0;
    private long kV = 0;

    public d(f fVar) {
        this.eh = fVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=8, 173=4, 174=4, 175=4, 176=4] */
    public boolean a(String str, i iVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int bu = i3 <= 0 ? com.baidu.adp.framework.c.b.bq().bt().bu() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.bq().getRetryCount();
        }
        int bu2 = i4 <= 0 ? com.baidu.adp.framework.c.b.bq().br().bu() : i4;
        boolean z4 = false;
        this.le = new b(this.eh);
        int i5 = 0;
        while (i5 < i) {
            e eVar = new e();
            try {
                eVar.lk = i5 + 1;
                this.lf = i5;
                z3 = this.le.a(str, iVar, bu, bu2, z, eVar, z2);
            } catch (FileNotFoundException e) {
                e = e;
                z3 = z4;
            } catch (Exception e2) {
                e = e2;
                z3 = z4;
            }
            try {
                b("downloadfile", eVar);
                com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                this.eh.a(eVar);
                a de = a.de();
                if (de != null) {
                    de.a(this.eh);
                    return z3;
                }
                return z3;
            } catch (FileNotFoundException e3) {
                e = e3;
                this.eh.dv().responseCode = -100;
                eVar.ln = String.valueOf(String.valueOf(this.eh.dv().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.eh.a(eVar);
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.eh.dv().responseCode = -10;
                    eVar.ln = String.valueOf(String.valueOf(this.eh.dv().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.eh.a(eVar);
                    com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                    this.eh.a(eVar);
                    a de2 = a.de();
                    if (de2 != null) {
                        de2.a(this.eh);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                    this.eh.a(eVar);
                    a de3 = a.de();
                    if (de3 != null) {
                        de3.a(this.eh);
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
            i2 = com.baidu.adp.framework.c.b.bq().bt().bu();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.bq().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.bq().br().bu();
        }
        boolean z2 = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.eh.dv().lD && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.eh.a(eVar);
            try {
                try {
                    try {
                        this.lf = i4;
                        eVar.lk = i4 + 1;
                        eVar.ls = 1;
                        this.le = new b(this.eh);
                        this.le.a(i2, i3, eVar);
                    } catch (IllegalStateException e) {
                        this.eh.dv().lE = -19;
                        eVar.ln = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (this.kV <= 0 && this.le != null) {
                            this.kV = this.le.dh();
                        }
                        eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                        this.eh.b(eVar);
                        a de = a.de();
                        if (de != null) {
                            de.a(this.eh);
                        }
                    } catch (SocketTimeoutException e2) {
                        eVar.ln = String.valueOf(String.valueOf(this.eh.dv().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.eh.dv().lE = -13;
                        z = true;
                        if (this.kV <= 0 && this.le != null) {
                            this.kV = this.le.dh();
                        }
                        eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                        this.eh.b(eVar);
                        a de2 = a.de();
                        if (de2 != null) {
                            de2.a(this.eh);
                            z2 = true;
                        }
                        z2 = z;
                    }
                } catch (SocketException e3) {
                    eVar.ln = String.valueOf(String.valueOf(this.eh.dv().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.eh.dv().lE = -12;
                    z = true;
                    if (this.kV <= 0 && this.le != null) {
                        this.kV = this.le.dh();
                    }
                    eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                    this.eh.b(eVar);
                    a de3 = a.de();
                    if (de3 != null) {
                        de3.a(this.eh);
                        z2 = true;
                    }
                    z2 = z;
                } catch (Exception e4) {
                    eVar.ln = String.valueOf(String.valueOf(this.eh.dv().responseCode)) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.eh.dv().lE = -10;
                    BdLog.e(e4.getMessage());
                    if (this.kV <= 0 && this.le != null) {
                        this.kV = this.le.dh();
                    }
                    eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                    this.eh.b(eVar);
                    a de4 = a.de();
                    if (de4 != null) {
                        de4.a(this.eh);
                        return;
                    }
                    return;
                }
                if (this.eh.dv().responseCode == 200) {
                    b(null, eVar);
                    this.eh.b(eVar);
                    if (this.kV <= 0 && this.le != null) {
                        this.kV = this.le.dh();
                    }
                    eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                    this.eh.b(eVar);
                    a de5 = a.de();
                    if (de5 != null) {
                        de5.a(this.eh);
                        return;
                    }
                    return;
                }
                eVar.ln = String.valueOf(String.valueOf(this.eh.dv().responseCode)) + "|retryCount:" + i4;
                boolean R = R(this.eh.dv().responseCode);
                if (this.kV <= 0 && this.le != null) {
                    this.kV = this.le.dh();
                }
                eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                this.eh.b(eVar);
                a de6 = a.de();
                if (de6 != null) {
                    de6.a(this.eh);
                    z2 = R;
                } else {
                    z2 = R;
                }
            } catch (Throwable th) {
                if (this.kV <= 0 && this.le != null) {
                    this.kV = this.le.dh();
                }
                eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                this.eh.b(eVar);
                a de7 = a.de();
                if (de7 != null) {
                    de7.a(this.eh);
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
            i2 = com.baidu.adp.framework.c.b.bq().bt().bu();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.bq().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.bq().br().bu();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.eh.dv().lD && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.lk = i4 + 1;
            this.lf = i4;
            try {
                try {
                    try {
                        try {
                            this.le = new b(this.eh);
                            this.le.b(i2, i3, eVar);
                        } catch (SocketTimeoutException e) {
                            this.eh.dv().lE = -13;
                            z = true;
                            eVar.ln = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e.getMessage());
                            this.eh.a(eVar);
                            if (this.kV <= 0 && this.le != null) {
                                this.kV = this.le.dh();
                            }
                            eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                            this.eh.a(eVar);
                            a de = a.de();
                            if (de != null && this.le != null && this.le.dk()) {
                                de.a(this.eh);
                            }
                        }
                    } catch (SocketException e2) {
                        this.eh.dv().lE = -12;
                        z = true;
                        eVar.ln = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.eh.a(eVar);
                        if (this.kV <= 0 && this.le != null) {
                            this.kV = this.le.dh();
                        }
                        eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                        this.eh.a(eVar);
                        a de2 = a.de();
                        if (de2 != null && this.le != null && this.le.dk()) {
                            de2.a(this.eh);
                        }
                    }
                } catch (UnsupportedOperationException e3) {
                    z = false;
                    this.eh.dv().lE = -14;
                    eVar.ln = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.eh.a(eVar);
                    if (this.kV <= 0 && this.le != null) {
                        this.kV = this.le.dh();
                    }
                    eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                    this.eh.a(eVar);
                    a de3 = a.de();
                    if (de3 != null && this.le != null && this.le.dk()) {
                        de3.a(this.eh);
                    }
                } catch (Throwable th) {
                    this.eh.dv().lE = -10;
                    z = false;
                    eVar.ln = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.eh.a(eVar);
                    if (this.kV <= 0 && this.le != null) {
                        this.kV = this.le.dh();
                    }
                    eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                    this.eh.a(eVar);
                    a de4 = a.de();
                    if (de4 != null && this.le != null && this.le.dk()) {
                        de4.a(this.eh);
                    }
                }
                if (this.eh.dv().responseCode == 200) {
                    b(null, eVar);
                    if (this.kV <= 0 && this.le != null) {
                        this.kV = this.le.dh();
                    }
                    eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                    this.eh.a(eVar);
                    a de5 = a.de();
                    if (de5 == null || this.le == null || !this.le.dk()) {
                        return;
                    }
                    de5.a(this.eh);
                    return;
                }
                eVar.ln = String.valueOf(String.valueOf(this.eh.dv().responseCode)) + "|retryCount:" + i4;
                z = R(this.eh.dv().responseCode);
                this.eh.a(eVar);
                if (this.kV <= 0 && this.le != null) {
                    this.kV = this.le.dh();
                }
                eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                this.eh.a(eVar);
                a de6 = a.de();
                if (de6 != null && this.le != null && this.le.dk()) {
                    de6.a(this.eh);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.kV <= 0 && this.le != null) {
                    this.kV = this.le.dh();
                }
                eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                this.eh.a(eVar);
                a de7 = a.de();
                if (de7 != null && this.le != null && this.le.dk()) {
                    de7.a(this.eh);
                }
                throw th2;
            }
        }
    }

    private boolean R(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.eh.du().dy()) {
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
            i2 = com.baidu.adp.framework.c.b.bq().bt().bu();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.bq().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.bq().br().bu();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.eh.dv().lD && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.lf = i4;
            eVar.lk = i4 + 1;
            try {
                try {
                    try {
                        try {
                            this.le = new b(this.eh);
                            this.le.c(i2, i3, eVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.eh.dv().lE = -14;
                            eVar.ln = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.eh.a(eVar);
                            if (this.kV <= 0 && this.le != null) {
                                this.kV = this.le.dh();
                            }
                            eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                            this.eh.a(eVar);
                            a de = a.de();
                            if (de != null) {
                                de.a(this.eh);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.eh.dv().lE = -13;
                        z = true;
                        eVar.ln = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.eh.a(eVar);
                        if (this.kV <= 0 && this.le != null) {
                            this.kV = this.le.dh();
                        }
                        eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                        this.eh.a(eVar);
                        a de2 = a.de();
                        if (de2 != null) {
                            de2.a(this.eh);
                        }
                    }
                } catch (SocketException e3) {
                    this.eh.dv().lE = -12;
                    z = true;
                    eVar.ln = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.eh.a(eVar);
                    if (this.kV <= 0 && this.le != null) {
                        this.kV = this.le.dh();
                    }
                    eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                    this.eh.a(eVar);
                    a de3 = a.de();
                    if (de3 != null) {
                        de3.a(this.eh);
                    }
                } catch (Throwable th) {
                    this.eh.dv().lE = -10;
                    z = false;
                    eVar.ln = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.eh.a(eVar);
                    if (this.kV <= 0 && this.le != null) {
                        this.kV = this.le.dh();
                    }
                    eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                    this.eh.a(eVar);
                    a de4 = a.de();
                    if (de4 != null) {
                        de4.a(this.eh);
                    }
                }
                if (this.eh.dv().responseCode == 200) {
                    b(null, eVar);
                    if (this.kV <= 0 && this.le != null) {
                        this.kV = this.le.dh();
                    }
                    eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                    this.eh.a(eVar);
                    a de5 = a.de();
                    if (de5 != null) {
                        de5.a(this.eh);
                        return;
                    }
                    return;
                }
                eVar.ln = String.valueOf(String.valueOf(this.eh.dv().responseCode)) + "|retryCount:" + i4;
                z = R(this.eh.dv().responseCode);
                this.eh.a(eVar);
                if (this.kV <= 0 && this.le != null) {
                    this.kV = this.le.dh();
                }
                eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                this.eh.a(eVar);
                a de6 = a.de();
                if (de6 != null) {
                    de6.a(this.eh);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.kV <= 0 && this.le != null) {
                    this.kV = this.le.dh();
                }
                eVar.ll = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cN().b(this.eh.du().getUrl(), this.eh.du().ab("Host"), TextUtils.isEmpty(eVar.ln), eVar.lr != null);
                this.eh.a(eVar);
                a de7 = a.de();
                if (de7 != null) {
                    de7.a(this.eh);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.le != null) {
            this.le.dl();
        }
    }

    public boolean dn() {
        if (this.eh == null) {
            return false;
        }
        return this.eh.dv().lD;
    }

    /* renamed from: do  reason: not valid java name */
    public void m5do() {
        if (this.eh != null) {
            this.eh.dv().lD = true;
        }
    }

    public long dp() {
        if (this.kV > 0) {
            return this.kV;
        }
        if (this.le == null) {
            return -1L;
        }
        return this.le.dh();
    }

    public long dq() {
        if (this.le == null) {
            return -1L;
        }
        return this.le.di();
    }

    public long dj() {
        if (this.le == null) {
            return -1L;
        }
        return this.le.dj();
    }

    public long dr() {
        if (this.le == null) {
            return -1L;
        }
        return this.le.dg();
    }

    public long ds() {
        if (this.le == null) {
            return -1L;
        }
        return this.le.df();
    }

    public int dt() {
        return this.lf;
    }

    private void b(String str, e eVar) {
        if (com.baidu.adp.b.a.iu() != null && eVar != null && this.eh.dv() != null) {
            String str2 = str == null ? this.eh.dv().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + eVar.lg + "; downloadSize = " + eVar.lh + "; url=" + eVar.url);
            com.baidu.adp.b.a.iu().a(str2, eVar.lg + 54, eVar.lh + 54, eVar.url);
        }
    }
}
