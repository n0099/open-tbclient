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
    private f eg;
    private b lc;
    private int ld = 0;
    private long kT = 0;

    public d(f fVar) {
        this.eg = fVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=8, 173=4, 174=4, 175=4, 176=4] */
    public boolean a(String str, i iVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int bv = i3 <= 0 ? com.baidu.adp.framework.c.b.br().bu().bv() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.br().getRetryCount();
        }
        int bv2 = i4 <= 0 ? com.baidu.adp.framework.c.b.br().bs().bv() : i4;
        boolean z4 = false;
        this.lc = new b(this.eg);
        int i5 = 0;
        while (i5 < i) {
            e eVar = new e();
            try {
                eVar.li = i5 + 1;
                this.ld = i5;
                z3 = this.lc.a(str, iVar, bv, bv2, z, eVar, z2);
            } catch (FileNotFoundException e) {
                e = e;
                z3 = z4;
            } catch (Exception e2) {
                e = e2;
                z3 = z4;
            }
            try {
                b("downloadfile", eVar);
                com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                this.eg.a(eVar);
                a df = a.df();
                if (df != null) {
                    df.a(this.eg);
                    return z3;
                }
                return z3;
            } catch (FileNotFoundException e3) {
                e = e3;
                this.eg.dw().responseCode = -100;
                eVar.ll = String.valueOf(String.valueOf(this.eg.dw().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.eg.a(eVar);
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.eg.dw().responseCode = -10;
                    eVar.ll = String.valueOf(String.valueOf(this.eg.dw().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.eg.a(eVar);
                    com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                    this.eg.a(eVar);
                    a df2 = a.df();
                    if (df2 != null) {
                        df2.a(this.eg);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                    this.eg.a(eVar);
                    a df3 = a.df();
                    if (df3 != null) {
                        df3.a(this.eg);
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
            i2 = com.baidu.adp.framework.c.b.br().bu().bv();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.br().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.br().bs().bv();
        }
        boolean z2 = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.eg.dw().lD && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.eg.a(eVar);
            try {
                try {
                    try {
                        this.ld = i4;
                        eVar.li = i4 + 1;
                        eVar.ls = 1;
                        this.lc = new b(this.eg);
                        this.lc.a(i2, i3, eVar);
                    } catch (IllegalStateException e) {
                        this.eg.dw().lE = -19;
                        eVar.ll = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (this.kT <= 0 && this.lc != null) {
                            this.kT = this.lc.di();
                        }
                        eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                        this.eg.b(eVar);
                        a df = a.df();
                        if (df != null) {
                            df.a(this.eg);
                        }
                    } catch (SocketTimeoutException e2) {
                        eVar.ll = String.valueOf(String.valueOf(this.eg.dw().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.eg.dw().lE = -13;
                        z = true;
                        if (this.kT <= 0 && this.lc != null) {
                            this.kT = this.lc.di();
                        }
                        eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                        this.eg.b(eVar);
                        a df2 = a.df();
                        if (df2 != null) {
                            df2.a(this.eg);
                            z2 = true;
                        }
                        z2 = z;
                    }
                } catch (SocketException e3) {
                    eVar.ll = String.valueOf(String.valueOf(this.eg.dw().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.eg.dw().lE = -12;
                    z = true;
                    if (this.kT <= 0 && this.lc != null) {
                        this.kT = this.lc.di();
                    }
                    eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                    this.eg.b(eVar);
                    a df3 = a.df();
                    if (df3 != null) {
                        df3.a(this.eg);
                        z2 = true;
                    }
                    z2 = z;
                } catch (Exception e4) {
                    eVar.ll = String.valueOf(String.valueOf(this.eg.dw().responseCode)) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.eg.dw().lE = -10;
                    BdLog.e(e4.getMessage());
                    if (this.kT <= 0 && this.lc != null) {
                        this.kT = this.lc.di();
                    }
                    eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                    this.eg.b(eVar);
                    a df4 = a.df();
                    if (df4 != null) {
                        df4.a(this.eg);
                        return;
                    }
                    return;
                }
                if (this.eg.dw().responseCode == 200) {
                    b(null, eVar);
                    this.eg.b(eVar);
                    if (this.kT <= 0 && this.lc != null) {
                        this.kT = this.lc.di();
                    }
                    eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                    this.eg.b(eVar);
                    a df5 = a.df();
                    if (df5 != null) {
                        df5.a(this.eg);
                        return;
                    }
                    return;
                }
                eVar.ll = String.valueOf(String.valueOf(this.eg.dw().responseCode)) + "|retryCount:" + i4;
                boolean R = R(this.eg.dw().responseCode);
                if (this.kT <= 0 && this.lc != null) {
                    this.kT = this.lc.di();
                }
                eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                this.eg.b(eVar);
                a df6 = a.df();
                if (df6 != null) {
                    df6.a(this.eg);
                    z2 = R;
                } else {
                    z2 = R;
                }
            } catch (Throwable th) {
                if (this.kT <= 0 && this.lc != null) {
                    this.kT = this.lc.di();
                }
                eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                this.eg.b(eVar);
                a df7 = a.df();
                if (df7 != null) {
                    df7.a(this.eg);
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
            i2 = com.baidu.adp.framework.c.b.br().bu().bv();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.br().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.br().bs().bv();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.eg.dw().lD && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.li = i4 + 1;
            this.ld = i4;
            try {
                try {
                    try {
                        try {
                            this.lc = new b(this.eg);
                            this.lc.b(i2, i3, eVar);
                        } catch (SocketTimeoutException e) {
                            this.eg.dw().lE = -13;
                            z = true;
                            eVar.ll = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e.getMessage());
                            this.eg.a(eVar);
                            if (this.kT <= 0 && this.lc != null) {
                                this.kT = this.lc.di();
                            }
                            eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                            this.eg.a(eVar);
                            a df = a.df();
                            if (df != null && this.lc != null && this.lc.dl()) {
                                df.a(this.eg);
                            }
                        }
                    } catch (SocketException e2) {
                        this.eg.dw().lE = -12;
                        z = true;
                        eVar.ll = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.eg.a(eVar);
                        if (this.kT <= 0 && this.lc != null) {
                            this.kT = this.lc.di();
                        }
                        eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                        this.eg.a(eVar);
                        a df2 = a.df();
                        if (df2 != null && this.lc != null && this.lc.dl()) {
                            df2.a(this.eg);
                        }
                    }
                } catch (UnsupportedOperationException e3) {
                    z = false;
                    this.eg.dw().lE = -14;
                    eVar.ll = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.eg.a(eVar);
                    if (this.kT <= 0 && this.lc != null) {
                        this.kT = this.lc.di();
                    }
                    eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                    this.eg.a(eVar);
                    a df3 = a.df();
                    if (df3 != null && this.lc != null && this.lc.dl()) {
                        df3.a(this.eg);
                    }
                } catch (Throwable th) {
                    this.eg.dw().lE = -10;
                    z = false;
                    eVar.ll = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.eg.a(eVar);
                    if (this.kT <= 0 && this.lc != null) {
                        this.kT = this.lc.di();
                    }
                    eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                    this.eg.a(eVar);
                    a df4 = a.df();
                    if (df4 != null && this.lc != null && this.lc.dl()) {
                        df4.a(this.eg);
                    }
                }
                if (this.eg.dw().responseCode == 200) {
                    b(null, eVar);
                    if (this.kT <= 0 && this.lc != null) {
                        this.kT = this.lc.di();
                    }
                    eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                    this.eg.a(eVar);
                    a df5 = a.df();
                    if (df5 == null || this.lc == null || !this.lc.dl()) {
                        return;
                    }
                    df5.a(this.eg);
                    return;
                }
                eVar.ll = String.valueOf(String.valueOf(this.eg.dw().responseCode)) + "|retryCount:" + i4;
                z = R(this.eg.dw().responseCode);
                this.eg.a(eVar);
                if (this.kT <= 0 && this.lc != null) {
                    this.kT = this.lc.di();
                }
                eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                this.eg.a(eVar);
                a df6 = a.df();
                if (df6 != null && this.lc != null && this.lc.dl()) {
                    df6.a(this.eg);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.kT <= 0 && this.lc != null) {
                    this.kT = this.lc.di();
                }
                eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                this.eg.a(eVar);
                a df7 = a.df();
                if (df7 != null && this.lc != null && this.lc.dl()) {
                    df7.a(this.eg);
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
        if (this.eg.dv().dz()) {
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
            i2 = com.baidu.adp.framework.c.b.br().bu().bv();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.br().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.br().bs().bv();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.eg.dw().lD && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.ld = i4;
            eVar.li = i4 + 1;
            try {
                try {
                    try {
                        try {
                            this.lc = new b(this.eg);
                            this.lc.c(i2, i3, eVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.eg.dw().lE = -14;
                            eVar.ll = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.eg.a(eVar);
                            if (this.kT <= 0 && this.lc != null) {
                                this.kT = this.lc.di();
                            }
                            eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                            this.eg.a(eVar);
                            a df = a.df();
                            if (df != null) {
                                df.a(this.eg);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.eg.dw().lE = -13;
                        z = true;
                        eVar.ll = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.eg.a(eVar);
                        if (this.kT <= 0 && this.lc != null) {
                            this.kT = this.lc.di();
                        }
                        eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                        this.eg.a(eVar);
                        a df2 = a.df();
                        if (df2 != null) {
                            df2.a(this.eg);
                        }
                    }
                } catch (SocketException e3) {
                    this.eg.dw().lE = -12;
                    z = true;
                    eVar.ll = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.eg.a(eVar);
                    if (this.kT <= 0 && this.lc != null) {
                        this.kT = this.lc.di();
                    }
                    eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                    this.eg.a(eVar);
                    a df3 = a.df();
                    if (df3 != null) {
                        df3.a(this.eg);
                    }
                } catch (Throwable th) {
                    this.eg.dw().lE = -10;
                    z = false;
                    eVar.ll = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.eg.a(eVar);
                    if (this.kT <= 0 && this.lc != null) {
                        this.kT = this.lc.di();
                    }
                    eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                    this.eg.a(eVar);
                    a df4 = a.df();
                    if (df4 != null) {
                        df4.a(this.eg);
                    }
                }
                if (this.eg.dw().responseCode == 200) {
                    b(null, eVar);
                    if (this.kT <= 0 && this.lc != null) {
                        this.kT = this.lc.di();
                    }
                    eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                    this.eg.a(eVar);
                    a df5 = a.df();
                    if (df5 != null) {
                        df5.a(this.eg);
                        return;
                    }
                    return;
                }
                eVar.ll = String.valueOf(String.valueOf(this.eg.dw().responseCode)) + "|retryCount:" + i4;
                z = R(this.eg.dw().responseCode);
                this.eg.a(eVar);
                if (this.kT <= 0 && this.lc != null) {
                    this.kT = this.lc.di();
                }
                eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                this.eg.a(eVar);
                a df6 = a.df();
                if (df6 != null) {
                    df6.a(this.eg);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.kT <= 0 && this.lc != null) {
                    this.kT = this.lc.di();
                }
                eVar.lj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cO().b(this.eg.dv().getUrl(), this.eg.dv().ab("Host"), TextUtils.isEmpty(eVar.ll), eVar.lp != null);
                this.eg.a(eVar);
                a df7 = a.df();
                if (df7 != null) {
                    df7.a(this.eg);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.lc != null) {
            this.lc.dm();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public boolean m4do() {
        if (this.eg == null) {
            return false;
        }
        return this.eg.dw().lD;
    }

    public void dp() {
        if (this.eg != null) {
            this.eg.dw().lD = true;
        }
    }

    public long dq() {
        if (this.kT > 0) {
            return this.kT;
        }
        if (this.lc == null) {
            return -1L;
        }
        return this.lc.di();
    }

    public long dr() {
        if (this.lc == null) {
            return -1L;
        }
        return this.lc.dj();
    }

    public long dk() {
        if (this.lc == null) {
            return -1L;
        }
        return this.lc.dk();
    }

    public long ds() {
        if (this.lc == null) {
            return -1L;
        }
        return this.lc.dh();
    }

    public long dt() {
        if (this.lc == null) {
            return -1L;
        }
        return this.lc.dg();
    }

    public int du() {
        return this.ld;
    }

    private void b(String str, e eVar) {
        if (com.baidu.adp.b.a.ix() != null && eVar != null && this.eg.dw() != null) {
            String str2 = str == null ? this.eg.dw().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + eVar.le + "; downloadSize = " + eVar.lf + "; url=" + eVar.url);
            com.baidu.adp.b.a.ix().a(str2, eVar.le + 54, eVar.lf + 54, eVar.url);
        }
    }
}
