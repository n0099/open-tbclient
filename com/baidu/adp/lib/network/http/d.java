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
    private f gT;
    private b nU;
    private int nV = 0;
    private long nL = 0;

    public d(f fVar) {
        this.gT = fVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=8, 173=4, 174=4, 175=4, 176=4] */
    public boolean a(String str, i iVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int cn = i3 <= 0 ? com.baidu.adp.framework.c.b.cj().cm().cn() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.cj().getRetryCount();
        }
        int cn2 = i4 <= 0 ? com.baidu.adp.framework.c.b.cj().ck().cn() : i4;
        boolean z4 = false;
        this.nU = new b(this.gT);
        int i5 = 0;
        while (i5 < i) {
            e eVar = new e();
            try {
                eVar.oa = i5 + 1;
                this.nV = i5;
                z3 = this.nU.a(str, iVar, cn, cn2, z, eVar, z2);
            } catch (FileNotFoundException e) {
                e = e;
                z3 = z4;
            } catch (Exception e2) {
                e = e2;
                z3 = z4;
            }
            try {
                b("downloadfile", eVar);
                com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                this.gT.a(eVar);
                a dX = a.dX();
                if (dX != null) {
                    dX.a(this.gT);
                    return z3;
                }
                return z3;
            } catch (FileNotFoundException e3) {
                e = e3;
                this.gT.eo().responseCode = -100;
                eVar.od = String.valueOf(String.valueOf(this.gT.eo().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.gT.a(eVar);
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.gT.eo().responseCode = -10;
                    eVar.od = String.valueOf(String.valueOf(this.gT.eo().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.gT.a(eVar);
                    com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                    this.gT.a(eVar);
                    a dX2 = a.dX();
                    if (dX2 != null) {
                        dX2.a(this.gT);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                    this.gT.a(eVar);
                    a dX3 = a.dX();
                    if (dX3 != null) {
                        dX3.a(this.gT);
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
            i2 = com.baidu.adp.framework.c.b.cj().cm().cn();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.cj().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.cj().ck().cn();
        }
        boolean z2 = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.gT.eo().ox && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.gT.a(eVar);
            try {
                try {
                    try {
                        this.nV = i4;
                        eVar.oa = i4 + 1;
                        eVar.ol = 1;
                        this.nU = new b(this.gT);
                        this.nU.a(i2, i3, eVar);
                    } catch (IllegalStateException e) {
                        this.gT.eo().oy = -19;
                        eVar.od = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (this.nL <= 0 && this.nU != null) {
                            this.nL = this.nU.ea();
                        }
                        eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                        this.gT.b(eVar);
                        a dX = a.dX();
                        if (dX != null) {
                            dX.a(this.gT);
                        }
                    } catch (SocketTimeoutException e2) {
                        eVar.od = String.valueOf(String.valueOf(this.gT.eo().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.gT.eo().oy = -13;
                        z = true;
                        if (this.nL <= 0 && this.nU != null) {
                            this.nL = this.nU.ea();
                        }
                        eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                        this.gT.b(eVar);
                        a dX2 = a.dX();
                        if (dX2 != null) {
                            dX2.a(this.gT);
                            z2 = true;
                        }
                        z2 = z;
                    }
                } catch (SocketException e3) {
                    eVar.od = String.valueOf(String.valueOf(this.gT.eo().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.gT.eo().oy = -12;
                    z = true;
                    if (this.nL <= 0 && this.nU != null) {
                        this.nL = this.nU.ea();
                    }
                    eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                    this.gT.b(eVar);
                    a dX3 = a.dX();
                    if (dX3 != null) {
                        dX3.a(this.gT);
                        z2 = true;
                    }
                    z2 = z;
                } catch (Exception e4) {
                    eVar.od = String.valueOf(String.valueOf(this.gT.eo().responseCode)) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.gT.eo().oy = -10;
                    BdLog.e(e4.getMessage());
                    if (this.nL <= 0 && this.nU != null) {
                        this.nL = this.nU.ea();
                    }
                    eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                    this.gT.b(eVar);
                    a dX4 = a.dX();
                    if (dX4 != null) {
                        dX4.a(this.gT);
                        return;
                    }
                    return;
                }
                if (this.gT.eo().responseCode == 200) {
                    b(null, eVar);
                    this.gT.b(eVar);
                    if (this.nL <= 0 && this.nU != null) {
                        this.nL = this.nU.ea();
                    }
                    eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                    this.gT.b(eVar);
                    a dX5 = a.dX();
                    if (dX5 != null) {
                        dX5.a(this.gT);
                        return;
                    }
                    return;
                }
                eVar.od = String.valueOf(String.valueOf(this.gT.eo().responseCode)) + "|retryCount:" + i4;
                boolean ai = ai(this.gT.eo().responseCode);
                if (this.nL <= 0 && this.nU != null) {
                    this.nL = this.nU.ea();
                }
                eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                this.gT.b(eVar);
                a dX6 = a.dX();
                if (dX6 != null) {
                    dX6.a(this.gT);
                    z2 = ai;
                } else {
                    z2 = ai;
                }
            } catch (Throwable th) {
                if (this.nL <= 0 && this.nU != null) {
                    this.nL = this.nU.ea();
                }
                eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                this.gT.b(eVar);
                a dX7 = a.dX();
                if (dX7 != null) {
                    dX7.a(this.gT);
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
            i2 = com.baidu.adp.framework.c.b.cj().cm().cn();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.cj().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.cj().ck().cn();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gT.eo().ox && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.oa = i4 + 1;
            this.nV = i4;
            try {
                try {
                    try {
                        try {
                            this.nU = new b(this.gT);
                            this.nU.b(i2, i3, eVar);
                        } catch (SocketTimeoutException e) {
                            this.gT.eo().oy = -13;
                            z = true;
                            eVar.od = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e.getMessage());
                            this.gT.a(eVar);
                            if (this.nL <= 0 && this.nU != null) {
                                this.nL = this.nU.ea();
                            }
                            eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                            this.gT.a(eVar);
                            a dX = a.dX();
                            if (dX != null && this.nU != null && this.nU.ed()) {
                                dX.a(this.gT);
                            }
                        }
                    } catch (SocketException e2) {
                        this.gT.eo().oy = -12;
                        z = true;
                        eVar.od = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.gT.a(eVar);
                        if (this.nL <= 0 && this.nU != null) {
                            this.nL = this.nU.ea();
                        }
                        eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                        this.gT.a(eVar);
                        a dX2 = a.dX();
                        if (dX2 != null && this.nU != null && this.nU.ed()) {
                            dX2.a(this.gT);
                        }
                    }
                } catch (UnsupportedOperationException e3) {
                    z = false;
                    this.gT.eo().oy = -14;
                    eVar.od = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.gT.a(eVar);
                    if (this.nL <= 0 && this.nU != null) {
                        this.nL = this.nU.ea();
                    }
                    eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                    this.gT.a(eVar);
                    a dX3 = a.dX();
                    if (dX3 != null && this.nU != null && this.nU.ed()) {
                        dX3.a(this.gT);
                    }
                } catch (Throwable th) {
                    this.gT.eo().oy = -10;
                    z = false;
                    eVar.od = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.gT.a(eVar);
                    if (this.nL <= 0 && this.nU != null) {
                        this.nL = this.nU.ea();
                    }
                    eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                    this.gT.a(eVar);
                    a dX4 = a.dX();
                    if (dX4 != null && this.nU != null && this.nU.ed()) {
                        dX4.a(this.gT);
                    }
                }
                if (this.gT.eo().responseCode == 200) {
                    b(null, eVar);
                    if (this.nL <= 0 && this.nU != null) {
                        this.nL = this.nU.ea();
                    }
                    eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                    this.gT.a(eVar);
                    a dX5 = a.dX();
                    if (dX5 == null || this.nU == null || !this.nU.ed()) {
                        return;
                    }
                    dX5.a(this.gT);
                    return;
                }
                eVar.od = String.valueOf(String.valueOf(this.gT.eo().responseCode)) + "|retryCount:" + i4;
                z = ai(this.gT.eo().responseCode);
                this.gT.a(eVar);
                if (this.nL <= 0 && this.nU != null) {
                    this.nL = this.nU.ea();
                }
                eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                this.gT.a(eVar);
                a dX6 = a.dX();
                if (dX6 != null && this.nU != null && this.nU.ed()) {
                    dX6.a(this.gT);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.nL <= 0 && this.nU != null) {
                    this.nL = this.nU.ea();
                }
                eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                this.gT.a(eVar);
                a dX7 = a.dX();
                if (dX7 != null && this.nU != null && this.nU.ed()) {
                    dX7.a(this.gT);
                }
                throw th2;
            }
        }
    }

    private boolean ai(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.gT.en().er()) {
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
            i2 = com.baidu.adp.framework.c.b.cj().cm().cn();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.cj().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.cj().ck().cn();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gT.eo().ox && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.nV = i4;
            eVar.oa = i4 + 1;
            try {
                try {
                    try {
                        try {
                            this.nU = new b(this.gT);
                            this.nU.c(i2, i3, eVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.gT.eo().oy = -14;
                            eVar.od = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.gT.a(eVar);
                            if (this.nL <= 0 && this.nU != null) {
                                this.nL = this.nU.ea();
                            }
                            eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                            this.gT.a(eVar);
                            a dX = a.dX();
                            if (dX != null) {
                                dX.a(this.gT);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.gT.eo().oy = -13;
                        z = true;
                        eVar.od = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.gT.a(eVar);
                        if (this.nL <= 0 && this.nU != null) {
                            this.nL = this.nU.ea();
                        }
                        eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                        this.gT.a(eVar);
                        a dX2 = a.dX();
                        if (dX2 != null) {
                            dX2.a(this.gT);
                        }
                    }
                } catch (SocketException e3) {
                    this.gT.eo().oy = -12;
                    z = true;
                    eVar.od = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gT.a(eVar);
                    if (this.nL <= 0 && this.nU != null) {
                        this.nL = this.nU.ea();
                    }
                    eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                    this.gT.a(eVar);
                    a dX3 = a.dX();
                    if (dX3 != null) {
                        dX3.a(this.gT);
                    }
                } catch (Throwable th) {
                    this.gT.eo().oy = -10;
                    z = false;
                    eVar.od = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.gT.a(eVar);
                    if (this.nL <= 0 && this.nU != null) {
                        this.nL = this.nU.ea();
                    }
                    eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                    this.gT.a(eVar);
                    a dX4 = a.dX();
                    if (dX4 != null) {
                        dX4.a(this.gT);
                    }
                }
                if (this.gT.eo().responseCode == 200) {
                    b(null, eVar);
                    if (this.nL <= 0 && this.nU != null) {
                        this.nL = this.nU.ea();
                    }
                    eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                    this.gT.a(eVar);
                    a dX5 = a.dX();
                    if (dX5 != null) {
                        dX5.a(this.gT);
                        return;
                    }
                    return;
                }
                eVar.od = String.valueOf(String.valueOf(this.gT.eo().responseCode)) + "|retryCount:" + i4;
                z = ai(this.gT.eo().responseCode);
                this.gT.a(eVar);
                if (this.nL <= 0 && this.nU != null) {
                    this.nL = this.nU.ea();
                }
                eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                this.gT.a(eVar);
                a dX6 = a.dX();
                if (dX6 != null) {
                    dX6.a(this.gT);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.nL <= 0 && this.nU != null) {
                    this.nL = this.nU.ea();
                }
                eVar.ob = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.dG().b(this.gT.en().getUrl(), this.gT.en().ae("Host"), TextUtils.isEmpty(eVar.od), eVar.oh != null);
                this.gT.a(eVar);
                a dX7 = a.dX();
                if (dX7 != null) {
                    dX7.a(this.gT);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.nU != null) {
            this.nU.ee();
        }
    }

    public boolean eg() {
        if (this.gT == null) {
            return false;
        }
        return this.gT.eo().ox;
    }

    public void eh() {
        if (this.gT != null) {
            this.gT.eo().ox = true;
        }
    }

    public long ei() {
        if (this.nL > 0) {
            return this.nL;
        }
        if (this.nU == null) {
            return -1L;
        }
        return this.nU.ea();
    }

    public long ej() {
        if (this.nU == null) {
            return -1L;
        }
        return this.nU.eb();
    }

    public long ec() {
        if (this.nU == null) {
            return -1L;
        }
        return this.nU.ec();
    }

    public long ek() {
        if (this.nU == null) {
            return -1L;
        }
        return this.nU.dZ();
    }

    public long el() {
        if (this.nU == null) {
            return -1L;
        }
        return this.nU.dY();
    }

    public int em() {
        return this.nV;
    }

    private void b(String str, e eVar) {
        if (ITrafficStatsNativeManager.jp() != null && eVar != null && this.gT.eo() != null) {
            String str2 = str == null ? this.gT.eo().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + eVar.nW + "; downloadSize = " + eVar.nX + "; url=" + eVar.url);
            ITrafficStatsNativeManager.jp().a(str2, eVar.nW + 54, eVar.nX + 54, eVar.url);
        }
    }
}
