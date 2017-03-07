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
    private f oO;
    private b vJ;
    private int vK = 0;
    private long vA = 0;

    public d(f fVar) {
        this.oO = fVar;
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
        this.vJ = new b(this.oO);
        int i5 = 0;
        while (i5 < i) {
            e eVar = new e();
            try {
                eVar.vP = i5 + 1;
                this.vK = i5;
                z3 = this.vJ.a(str, iVar, dw, dw2, z, eVar, z2);
            } catch (FileNotFoundException e) {
                e = e;
                z3 = z4;
            } catch (Exception e2) {
                e = e2;
                z3 = z4;
            }
            try {
                b("downloadfile", eVar);
                com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                this.oO.a(eVar);
                a ff = a.ff();
                if (ff != null) {
                    ff.a(this.oO);
                    return z3;
                }
                return z3;
            } catch (FileNotFoundException e3) {
                e = e3;
                this.oO.fw().responseCode = -100;
                eVar.vS = String.valueOf(String.valueOf(this.oO.fw().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.oO.a(eVar);
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.oO.fw().responseCode = -10;
                    eVar.vS = String.valueOf(String.valueOf(this.oO.fw().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.oO.a(eVar);
                    com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                    this.oO.a(eVar);
                    a ff2 = a.ff();
                    if (ff2 != null) {
                        ff2.a(this.oO);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                    this.oO.a(eVar);
                    a ff3 = a.ff();
                    if (ff3 != null) {
                        ff3.a(this.oO);
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
        for (int i4 = 0; !this.oO.fw().wi && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.oO.a(eVar);
            try {
                try {
                    try {
                        this.vK = i4;
                        eVar.vP = i4 + 1;
                        eVar.vZ = 1;
                        this.vJ = new b(this.oO);
                        this.vJ.a(i2, i3, eVar);
                    } catch (IllegalStateException e) {
                        this.oO.fw().wj = -19;
                        eVar.vS = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (this.vA <= 0 && this.vJ != null) {
                            this.vA = this.vJ.fi();
                        }
                        eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                        this.oO.b(eVar);
                        a ff = a.ff();
                        if (ff != null) {
                            ff.a(this.oO);
                        }
                    } catch (SocketTimeoutException e2) {
                        eVar.vS = String.valueOf(String.valueOf(this.oO.fw().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.oO.fw().wj = -13;
                        z = true;
                        if (this.vA <= 0 && this.vJ != null) {
                            this.vA = this.vJ.fi();
                        }
                        eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                        this.oO.b(eVar);
                        a ff2 = a.ff();
                        if (ff2 != null) {
                            ff2.a(this.oO);
                            z2 = true;
                        }
                        z2 = z;
                    }
                } catch (SocketException e3) {
                    eVar.vS = String.valueOf(String.valueOf(this.oO.fw().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.oO.fw().wj = -12;
                    z = true;
                    if (this.vA <= 0 && this.vJ != null) {
                        this.vA = this.vJ.fi();
                    }
                    eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                    this.oO.b(eVar);
                    a ff3 = a.ff();
                    if (ff3 != null) {
                        ff3.a(this.oO);
                        z2 = true;
                    }
                    z2 = z;
                } catch (Exception e4) {
                    eVar.vS = String.valueOf(String.valueOf(this.oO.fw().responseCode)) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.oO.fw().wj = -10;
                    BdLog.e(e4.getMessage());
                    if (this.vA <= 0 && this.vJ != null) {
                        this.vA = this.vJ.fi();
                    }
                    eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                    this.oO.b(eVar);
                    a ff4 = a.ff();
                    if (ff4 != null) {
                        ff4.a(this.oO);
                        return;
                    }
                    return;
                }
                if (this.oO.fw().responseCode == 200) {
                    b(null, eVar);
                    this.oO.b(eVar);
                    if (this.vA <= 0 && this.vJ != null) {
                        this.vA = this.vJ.fi();
                    }
                    eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                    this.oO.b(eVar);
                    a ff5 = a.ff();
                    if (ff5 != null) {
                        ff5.a(this.oO);
                        return;
                    }
                    return;
                }
                eVar.vS = String.valueOf(String.valueOf(this.oO.fw().responseCode)) + "|retryCount:" + i4;
                boolean ai = ai(this.oO.fw().responseCode);
                if (this.vA <= 0 && this.vJ != null) {
                    this.vA = this.vJ.fi();
                }
                eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                this.oO.b(eVar);
                a ff6 = a.ff();
                if (ff6 != null) {
                    ff6.a(this.oO);
                    z2 = ai;
                } else {
                    z2 = ai;
                }
            } catch (Throwable th) {
                if (this.vA <= 0 && this.vJ != null) {
                    this.vA = this.vJ.fi();
                }
                eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                this.oO.b(eVar);
                a ff7 = a.ff();
                if (ff7 != null) {
                    ff7.a(this.oO);
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
        for (int i4 = 0; !this.oO.fw().wi && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.vP = i4 + 1;
            this.vK = i4;
            try {
                try {
                    try {
                        try {
                            this.vJ = new b(this.oO);
                            this.vJ.b(i2, i3, eVar);
                        } catch (SocketTimeoutException e) {
                            this.oO.fw().wj = -13;
                            z = true;
                            eVar.vS = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e.getMessage());
                            this.oO.a(eVar);
                            if (this.vA <= 0 && this.vJ != null) {
                                this.vA = this.vJ.fi();
                            }
                            eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                            this.oO.a(eVar);
                            a ff = a.ff();
                            if (ff != null && this.vJ != null && this.vJ.fl()) {
                                ff.a(this.oO);
                            }
                        }
                    } catch (SocketException e2) {
                        this.oO.fw().wj = -12;
                        z = true;
                        eVar.vS = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.oO.a(eVar);
                        if (this.vA <= 0 && this.vJ != null) {
                            this.vA = this.vJ.fi();
                        }
                        eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                        this.oO.a(eVar);
                        a ff2 = a.ff();
                        if (ff2 != null && this.vJ != null && this.vJ.fl()) {
                            ff2.a(this.oO);
                        }
                    }
                } catch (UnsupportedOperationException e3) {
                    z = false;
                    this.oO.fw().wj = -14;
                    eVar.vS = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.oO.a(eVar);
                    if (this.vA <= 0 && this.vJ != null) {
                        this.vA = this.vJ.fi();
                    }
                    eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                    this.oO.a(eVar);
                    a ff3 = a.ff();
                    if (ff3 != null && this.vJ != null && this.vJ.fl()) {
                        ff3.a(this.oO);
                    }
                } catch (Throwable th) {
                    this.oO.fw().wj = -10;
                    z = false;
                    eVar.vS = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.oO.a(eVar);
                    if (this.vA <= 0 && this.vJ != null) {
                        this.vA = this.vJ.fi();
                    }
                    eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                    this.oO.a(eVar);
                    a ff4 = a.ff();
                    if (ff4 != null && this.vJ != null && this.vJ.fl()) {
                        ff4.a(this.oO);
                    }
                }
                if (this.oO.fw().responseCode == 200) {
                    b(null, eVar);
                    if (this.vA <= 0 && this.vJ != null) {
                        this.vA = this.vJ.fi();
                    }
                    eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                    this.oO.a(eVar);
                    a ff5 = a.ff();
                    if (ff5 == null || this.vJ == null || !this.vJ.fl()) {
                        return;
                    }
                    ff5.a(this.oO);
                    return;
                }
                eVar.vS = String.valueOf(String.valueOf(this.oO.fw().responseCode)) + "|retryCount:" + i4;
                z = ai(this.oO.fw().responseCode);
                this.oO.a(eVar);
                if (this.vA <= 0 && this.vJ != null) {
                    this.vA = this.vJ.fi();
                }
                eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                this.oO.a(eVar);
                a ff6 = a.ff();
                if (ff6 != null && this.vJ != null && this.vJ.fl()) {
                    ff6.a(this.oO);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.vA <= 0 && this.vJ != null) {
                    this.vA = this.vJ.fi();
                }
                eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                this.oO.a(eVar);
                a ff7 = a.ff();
                if (ff7 != null && this.vJ != null && this.vJ.fl()) {
                    ff7.a(this.oO);
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
        if (this.oO.fv().fz()) {
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
        for (int i4 = 0; !this.oO.fw().wi && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.vK = i4;
            eVar.vP = i4 + 1;
            try {
                try {
                    try {
                        try {
                            this.vJ = new b(this.oO);
                            this.vJ.c(i2, i3, eVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.oO.fw().wj = -14;
                            eVar.vS = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.oO.a(eVar);
                            if (this.vA <= 0 && this.vJ != null) {
                                this.vA = this.vJ.fi();
                            }
                            eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                            this.oO.a(eVar);
                            a ff = a.ff();
                            if (ff != null) {
                                ff.a(this.oO);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.oO.fw().wj = -13;
                        z = true;
                        eVar.vS = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.oO.a(eVar);
                        if (this.vA <= 0 && this.vJ != null) {
                            this.vA = this.vJ.fi();
                        }
                        eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                        this.oO.a(eVar);
                        a ff2 = a.ff();
                        if (ff2 != null) {
                            ff2.a(this.oO);
                        }
                    }
                } catch (SocketException e3) {
                    this.oO.fw().wj = -12;
                    z = true;
                    eVar.vS = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.oO.a(eVar);
                    if (this.vA <= 0 && this.vJ != null) {
                        this.vA = this.vJ.fi();
                    }
                    eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                    this.oO.a(eVar);
                    a ff3 = a.ff();
                    if (ff3 != null) {
                        ff3.a(this.oO);
                    }
                } catch (Throwable th) {
                    this.oO.fw().wj = -10;
                    z = false;
                    eVar.vS = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.oO.a(eVar);
                    if (this.vA <= 0 && this.vJ != null) {
                        this.vA = this.vJ.fi();
                    }
                    eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                    this.oO.a(eVar);
                    a ff4 = a.ff();
                    if (ff4 != null) {
                        ff4.a(this.oO);
                    }
                }
                if (this.oO.fw().responseCode == 200) {
                    b(null, eVar);
                    if (this.vA <= 0 && this.vJ != null) {
                        this.vA = this.vJ.fi();
                    }
                    eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                    this.oO.a(eVar);
                    a ff5 = a.ff();
                    if (ff5 != null) {
                        ff5.a(this.oO);
                        return;
                    }
                    return;
                }
                eVar.vS = String.valueOf(String.valueOf(this.oO.fw().responseCode)) + "|retryCount:" + i4;
                z = ai(this.oO.fw().responseCode);
                this.oO.a(eVar);
                if (this.vA <= 0 && this.vJ != null) {
                    this.vA = this.vJ.fi();
                }
                eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                this.oO.a(eVar);
                a ff6 = a.ff();
                if (ff6 != null) {
                    ff6.a(this.oO);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.vA <= 0 && this.vJ != null) {
                    this.vA = this.vJ.fi();
                }
                eVar.vQ = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.eP().b(this.oO.fv().getUrl(), this.oO.fv().ad("Host"), TextUtils.isEmpty(eVar.vS), eVar.vW != null);
                this.oO.a(eVar);
                a ff7 = a.ff();
                if (ff7 != null) {
                    ff7.a(this.oO);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.vJ != null) {
            this.vJ.fm();
        }
    }

    public boolean fo() {
        if (this.oO == null) {
            return false;
        }
        return this.oO.fw().wi;
    }

    public void fp() {
        if (this.oO != null) {
            this.oO.fw().wi = true;
        }
    }

    public long fq() {
        if (this.vA > 0) {
            return this.vA;
        }
        if (this.vJ == null) {
            return -1L;
        }
        return this.vJ.fi();
    }

    public long fr() {
        if (this.vJ == null) {
            return -1L;
        }
        return this.vJ.fj();
    }

    public long fk() {
        if (this.vJ == null) {
            return -1L;
        }
        return this.vJ.fk();
    }

    public long fs() {
        if (this.vJ == null) {
            return -1L;
        }
        return this.vJ.fh();
    }

    public long ft() {
        if (this.vJ == null) {
            return -1L;
        }
        return this.vJ.fg();
    }

    public int fu() {
        return this.vK;
    }

    private void b(String str, e eVar) {
        if (ITrafficStatsNativeManager.kj() != null && eVar != null && this.oO.fw() != null) {
            String str2 = str == null ? this.oO.fw().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + eVar.vL + "; downloadSize = " + eVar.vM + "; url=" + eVar.url);
            ITrafficStatsNativeManager.kj().a(str2, eVar.vL + 54, eVar.vM + 54, eVar.url);
        }
    }
}
