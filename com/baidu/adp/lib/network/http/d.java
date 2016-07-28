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
    private f eJ;
    private b lH;
    private int lI = 0;
    private long lx = 0;

    public d(f fVar) {
        this.eJ = fVar;
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
        this.lH = new b(this.eJ);
        int i5 = 0;
        while (i5 < i) {
            e eVar = new e();
            try {
                eVar.lN = i5 + 1;
                this.lI = i5;
                z3 = this.lH.a(str, iVar, bu, bu2, z, eVar, z2);
            } catch (FileNotFoundException e) {
                e = e;
                z3 = z4;
            } catch (Exception e2) {
                e = e2;
                z3 = z4;
            }
            try {
                b("downloadfile", eVar);
                com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                this.eJ.a(eVar);
                a de = a.de();
                if (de != null) {
                    de.a(this.eJ);
                    return z3;
                }
                return z3;
            } catch (FileNotFoundException e3) {
                e = e3;
                this.eJ.dv().responseCode = -100;
                eVar.lQ = String.valueOf(String.valueOf(this.eJ.dv().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.eJ.a(eVar);
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.eJ.dv().responseCode = -10;
                    eVar.lQ = String.valueOf(String.valueOf(this.eJ.dv().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.eJ.a(eVar);
                    com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                    this.eJ.a(eVar);
                    a de2 = a.de();
                    if (de2 != null) {
                        de2.a(this.eJ);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                    this.eJ.a(eVar);
                    a de3 = a.de();
                    if (de3 != null) {
                        de3.a(this.eJ);
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
    public void e(int i, int i2, int i3) {
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
        for (int i4 = 0; !this.eJ.dv().mh && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.eJ.a(eVar);
            try {
                try {
                    try {
                        this.lI = i4;
                        eVar.lN = i4 + 1;
                        eVar.lX = 1;
                        this.lH = new b(this.eJ);
                        this.lH.a(i2, i3, eVar);
                    } catch (IllegalStateException e) {
                        this.eJ.dv().mi = -19;
                        eVar.lQ = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (this.lx <= 0 && this.lH != null) {
                            this.lx = this.lH.dh();
                        }
                        eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                        this.eJ.b(eVar);
                        a de = a.de();
                        if (de != null) {
                            de.a(this.eJ);
                        }
                    } catch (SocketTimeoutException e2) {
                        eVar.lQ = String.valueOf(String.valueOf(this.eJ.dv().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.eJ.dv().mi = -13;
                        z = true;
                        if (this.lx <= 0 && this.lH != null) {
                            this.lx = this.lH.dh();
                        }
                        eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                        this.eJ.b(eVar);
                        a de2 = a.de();
                        if (de2 != null) {
                            de2.a(this.eJ);
                            z2 = true;
                        }
                        z2 = z;
                    }
                } catch (SocketException e3) {
                    eVar.lQ = String.valueOf(String.valueOf(this.eJ.dv().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.eJ.dv().mi = -12;
                    z = true;
                    if (this.lx <= 0 && this.lH != null) {
                        this.lx = this.lH.dh();
                    }
                    eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                    this.eJ.b(eVar);
                    a de3 = a.de();
                    if (de3 != null) {
                        de3.a(this.eJ);
                        z2 = true;
                    }
                    z2 = z;
                } catch (Exception e4) {
                    eVar.lQ = String.valueOf(String.valueOf(this.eJ.dv().responseCode)) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.eJ.dv().mi = -10;
                    BdLog.e(e4.getMessage());
                    if (this.lx <= 0 && this.lH != null) {
                        this.lx = this.lH.dh();
                    }
                    eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                    this.eJ.b(eVar);
                    a de4 = a.de();
                    if (de4 != null) {
                        de4.a(this.eJ);
                        return;
                    }
                    return;
                }
                if (this.eJ.dv().responseCode == 200) {
                    b(null, eVar);
                    this.eJ.b(eVar);
                    if (this.lx <= 0 && this.lH != null) {
                        this.lx = this.lH.dh();
                    }
                    eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                    this.eJ.b(eVar);
                    a de5 = a.de();
                    if (de5 != null) {
                        de5.a(this.eJ);
                        return;
                    }
                    return;
                }
                eVar.lQ = String.valueOf(String.valueOf(this.eJ.dv().responseCode)) + "|retryCount:" + i4;
                boolean U = U(this.eJ.dv().responseCode);
                if (this.lx <= 0 && this.lH != null) {
                    this.lx = this.lH.dh();
                }
                eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                this.eJ.b(eVar);
                a de6 = a.de();
                if (de6 != null) {
                    de6.a(this.eJ);
                    z2 = U;
                } else {
                    z2 = U;
                }
            } catch (Throwable th) {
                if (this.lx <= 0 && this.lH != null) {
                    this.lx = this.lH.dh();
                }
                eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                this.eJ.b(eVar);
                a de7 = a.de();
                if (de7 != null) {
                    de7.a(this.eJ);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [351=7, 352=7, 354=7, 355=14, 356=7, 357=7, 358=7, 359=7] */
    private void f(int i, int i2, int i3) {
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
        for (int i4 = 0; !this.eJ.dv().mh && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.lN = i4 + 1;
            this.lI = i4;
            try {
                try {
                    try {
                        try {
                            this.lH = new b(this.eJ);
                            this.lH.b(i2, i3, eVar);
                        } catch (SocketTimeoutException e) {
                            this.eJ.dv().mi = -13;
                            z = true;
                            eVar.lQ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e.getMessage());
                            this.eJ.a(eVar);
                            if (this.lx <= 0 && this.lH != null) {
                                this.lx = this.lH.dh();
                            }
                            eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                            this.eJ.a(eVar);
                            a de = a.de();
                            if (de != null && this.lH != null && this.lH.dk()) {
                                de.a(this.eJ);
                            }
                        }
                    } catch (SocketException e2) {
                        this.eJ.dv().mi = -12;
                        z = true;
                        eVar.lQ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.eJ.a(eVar);
                        if (this.lx <= 0 && this.lH != null) {
                            this.lx = this.lH.dh();
                        }
                        eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                        this.eJ.a(eVar);
                        a de2 = a.de();
                        if (de2 != null && this.lH != null && this.lH.dk()) {
                            de2.a(this.eJ);
                        }
                    }
                } catch (UnsupportedOperationException e3) {
                    z = false;
                    this.eJ.dv().mi = -14;
                    eVar.lQ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.eJ.a(eVar);
                    if (this.lx <= 0 && this.lH != null) {
                        this.lx = this.lH.dh();
                    }
                    eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                    this.eJ.a(eVar);
                    a de3 = a.de();
                    if (de3 != null && this.lH != null && this.lH.dk()) {
                        de3.a(this.eJ);
                    }
                } catch (Throwable th) {
                    this.eJ.dv().mi = -10;
                    z = false;
                    eVar.lQ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.eJ.a(eVar);
                    if (this.lx <= 0 && this.lH != null) {
                        this.lx = this.lH.dh();
                    }
                    eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                    this.eJ.a(eVar);
                    a de4 = a.de();
                    if (de4 != null && this.lH != null && this.lH.dk()) {
                        de4.a(this.eJ);
                    }
                }
                if (this.eJ.dv().responseCode == 200) {
                    b(null, eVar);
                    if (this.lx <= 0 && this.lH != null) {
                        this.lx = this.lH.dh();
                    }
                    eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                    this.eJ.a(eVar);
                    a de5 = a.de();
                    if (de5 == null || this.lH == null || !this.lH.dk()) {
                        return;
                    }
                    de5.a(this.eJ);
                    return;
                }
                eVar.lQ = String.valueOf(String.valueOf(this.eJ.dv().responseCode)) + "|retryCount:" + i4;
                z = U(this.eJ.dv().responseCode);
                this.eJ.a(eVar);
                if (this.lx <= 0 && this.lH != null) {
                    this.lx = this.lH.dh();
                }
                eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                this.eJ.a(eVar);
                a de6 = a.de();
                if (de6 != null && this.lH != null && this.lH.dk()) {
                    de6.a(this.eJ);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.lx <= 0 && this.lH != null) {
                    this.lx = this.lH.dh();
                }
                eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                this.eJ.a(eVar);
                a de7 = a.de();
                if (de7 != null && this.lH != null && this.lH.dk()) {
                    de7.a(this.eJ);
                }
                throw th2;
            }
        }
    }

    private boolean U(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void g(int i, int i2, int i3) {
        if (this.eJ.du().dy()) {
            f(i, i2, i3);
        } else {
            h(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [473=7, 474=7, 476=7, 477=14, 478=7, 479=7, 480=7, 481=7] */
    private void h(int i, int i2, int i3) {
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
        for (int i4 = 0; !this.eJ.dv().mh && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.lI = i4;
            eVar.lN = i4 + 1;
            try {
                try {
                    try {
                        try {
                            this.lH = new b(this.eJ);
                            this.lH.c(i2, i3, eVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.eJ.dv().mi = -14;
                            eVar.lQ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.eJ.a(eVar);
                            if (this.lx <= 0 && this.lH != null) {
                                this.lx = this.lH.dh();
                            }
                            eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                            this.eJ.a(eVar);
                            a de = a.de();
                            if (de != null) {
                                de.a(this.eJ);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.eJ.dv().mi = -13;
                        z = true;
                        eVar.lQ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.eJ.a(eVar);
                        if (this.lx <= 0 && this.lH != null) {
                            this.lx = this.lH.dh();
                        }
                        eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                        this.eJ.a(eVar);
                        a de2 = a.de();
                        if (de2 != null) {
                            de2.a(this.eJ);
                        }
                    }
                } catch (SocketException e3) {
                    this.eJ.dv().mi = -12;
                    z = true;
                    eVar.lQ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.eJ.a(eVar);
                    if (this.lx <= 0 && this.lH != null) {
                        this.lx = this.lH.dh();
                    }
                    eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                    this.eJ.a(eVar);
                    a de3 = a.de();
                    if (de3 != null) {
                        de3.a(this.eJ);
                    }
                } catch (Throwable th) {
                    this.eJ.dv().mi = -10;
                    z = false;
                    eVar.lQ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.eJ.a(eVar);
                    if (this.lx <= 0 && this.lH != null) {
                        this.lx = this.lH.dh();
                    }
                    eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                    this.eJ.a(eVar);
                    a de4 = a.de();
                    if (de4 != null) {
                        de4.a(this.eJ);
                    }
                }
                if (this.eJ.dv().responseCode == 200) {
                    b(null, eVar);
                    if (this.lx <= 0 && this.lH != null) {
                        this.lx = this.lH.dh();
                    }
                    eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                    this.eJ.a(eVar);
                    a de5 = a.de();
                    if (de5 != null) {
                        de5.a(this.eJ);
                        return;
                    }
                    return;
                }
                eVar.lQ = String.valueOf(String.valueOf(this.eJ.dv().responseCode)) + "|retryCount:" + i4;
                z = U(this.eJ.dv().responseCode);
                this.eJ.a(eVar);
                if (this.lx <= 0 && this.lH != null) {
                    this.lx = this.lH.dh();
                }
                eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                this.eJ.a(eVar);
                a de6 = a.de();
                if (de6 != null) {
                    de6.a(this.eJ);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.lx <= 0 && this.lH != null) {
                    this.lx = this.lH.dh();
                }
                eVar.lO = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.cN().b(this.eJ.du().getUrl(), this.eJ.du().ad("Host"), TextUtils.isEmpty(eVar.lQ), eVar.lU != null);
                this.eJ.a(eVar);
                a de7 = a.de();
                if (de7 != null) {
                    de7.a(this.eJ);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.lH != null) {
            this.lH.dl();
        }
    }

    public boolean dn() {
        if (this.eJ == null) {
            return false;
        }
        return this.eJ.dv().mh;
    }

    /* renamed from: do  reason: not valid java name */
    public void m5do() {
        if (this.eJ != null) {
            this.eJ.dv().mh = true;
        }
    }

    public long dp() {
        if (this.lx > 0) {
            return this.lx;
        }
        if (this.lH == null) {
            return -1L;
        }
        return this.lH.dh();
    }

    public long dq() {
        if (this.lH == null) {
            return -1L;
        }
        return this.lH.di();
    }

    public long dj() {
        if (this.lH == null) {
            return -1L;
        }
        return this.lH.dj();
    }

    public long dr() {
        if (this.lH == null) {
            return -1L;
        }
        return this.lH.dg();
    }

    public long ds() {
        if (this.lH == null) {
            return -1L;
        }
        return this.lH.df();
    }

    public int dt() {
        return this.lI;
    }

    private void b(String str, e eVar) {
        if (com.baidu.adp.b.a.iw() != null && eVar != null && this.eJ.dv() != null) {
            String str2 = str == null ? this.eJ.dv().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + eVar.lJ + "; downloadSize = " + eVar.lK + "; url=" + eVar.url);
            com.baidu.adp.b.a.iw().a(str2, eVar.lJ + 54, eVar.lK + 54, eVar.url);
        }
    }
}
