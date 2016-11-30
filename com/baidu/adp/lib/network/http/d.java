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
    private f gW;
    private b ob;
    private int oc = 0;
    private long nS = 0;

    public d(f fVar) {
        this.gW = fVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=8, 173=4, 174=4, 175=4, 176=4] */
    public boolean a(String str, i iVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int cp = i3 <= 0 ? com.baidu.adp.framework.c.b.cl().co().cp() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.cl().getRetryCount();
        }
        int cp2 = i4 <= 0 ? com.baidu.adp.framework.c.b.cl().cm().cp() : i4;
        boolean z4 = false;
        this.ob = new b(this.gW);
        int i5 = 0;
        while (i5 < i) {
            e eVar = new e();
            try {
                eVar.oh = i5 + 1;
                this.oc = i5;
                z3 = this.ob.a(str, iVar, cp, cp2, z, eVar, z2);
            } catch (FileNotFoundException e) {
                e = e;
                z3 = z4;
            } catch (Exception e2) {
                e = e2;
                z3 = z4;
            }
            try {
                b("downloadfile", eVar);
                com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                this.gW.a(eVar);
                a dZ = a.dZ();
                if (dZ != null) {
                    dZ.a(this.gW);
                    return z3;
                }
                return z3;
            } catch (FileNotFoundException e3) {
                e = e3;
                this.gW.eq().responseCode = -100;
                eVar.ol = String.valueOf(String.valueOf(this.gW.eq().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.gW.a(eVar);
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.gW.eq().responseCode = -10;
                    eVar.ol = String.valueOf(String.valueOf(this.gW.eq().responseCode)) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.gW.a(eVar);
                    com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                    this.gW.a(eVar);
                    a dZ2 = a.dZ();
                    if (dZ2 != null) {
                        dZ2.a(this.gW);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                    this.gW.a(eVar);
                    a dZ3 = a.dZ();
                    if (dZ3 != null) {
                        dZ3.a(this.gW);
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
            i2 = com.baidu.adp.framework.c.b.cl().co().cp();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.cl().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.cl().cm().cp();
        }
        boolean z2 = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.gW.eq().oE && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.gW.a(eVar);
            try {
                try {
                    try {
                        this.oc = i4;
                        eVar.oh = i4 + 1;
                        eVar.ov = 1;
                        this.ob = new b(this.gW);
                        this.ob.a(i2, i3, eVar);
                    } catch (IllegalStateException e) {
                        this.gW.eq().oF = -19;
                        eVar.ol = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                        if (this.nS <= 0 && this.ob != null) {
                            this.nS = this.ob.ec();
                        }
                        eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                        this.gW.b(eVar);
                        a dZ = a.dZ();
                        if (dZ != null) {
                            dZ.a(this.gW);
                        }
                    } catch (SocketTimeoutException e2) {
                        eVar.ol = String.valueOf(String.valueOf(this.gW.eq().responseCode)) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.gW.eq().oF = -13;
                        z = true;
                        if (this.nS <= 0 && this.ob != null) {
                            this.nS = this.ob.ec();
                        }
                        eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                        this.gW.b(eVar);
                        a dZ2 = a.dZ();
                        if (dZ2 != null) {
                            dZ2.a(this.gW);
                            z2 = true;
                        }
                        z2 = z;
                    }
                } catch (SocketException e3) {
                    eVar.ol = String.valueOf(String.valueOf(this.gW.eq().responseCode)) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.gW.eq().oF = -12;
                    z = true;
                    if (this.nS <= 0 && this.ob != null) {
                        this.nS = this.ob.ec();
                    }
                    eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                    this.gW.b(eVar);
                    a dZ3 = a.dZ();
                    if (dZ3 != null) {
                        dZ3.a(this.gW);
                        z2 = true;
                    }
                    z2 = z;
                } catch (Exception e4) {
                    eVar.ol = String.valueOf(String.valueOf(this.gW.eq().responseCode)) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.gW.eq().oF = -10;
                    BdLog.e(e4.getMessage());
                    if (this.nS <= 0 && this.ob != null) {
                        this.nS = this.ob.ec();
                    }
                    eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                    this.gW.b(eVar);
                    a dZ4 = a.dZ();
                    if (dZ4 != null) {
                        dZ4.a(this.gW);
                        return;
                    }
                    return;
                }
                if (this.gW.eq().responseCode == 200) {
                    b(null, eVar);
                    this.gW.b(eVar);
                    if (this.nS <= 0 && this.ob != null) {
                        this.nS = this.ob.ec();
                    }
                    eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                    this.gW.b(eVar);
                    a dZ5 = a.dZ();
                    if (dZ5 != null) {
                        dZ5.a(this.gW);
                        return;
                    }
                    return;
                }
                eVar.ol = String.valueOf(String.valueOf(this.gW.eq().responseCode)) + "|retryCount:" + i4;
                boolean ah = ah(this.gW.eq().responseCode);
                if (this.nS <= 0 && this.ob != null) {
                    this.nS = this.ob.ec();
                }
                eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                this.gW.b(eVar);
                a dZ6 = a.dZ();
                if (dZ6 != null) {
                    dZ6.a(this.gW);
                    z2 = ah;
                } else {
                    z2 = ah;
                }
            } catch (Throwable th) {
                if (this.nS <= 0 && this.ob != null) {
                    this.nS = this.ob.ec();
                }
                eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                this.gW.b(eVar);
                a dZ7 = a.dZ();
                if (dZ7 != null) {
                    dZ7.a(this.gW);
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
            i2 = com.baidu.adp.framework.c.b.cl().co().cp();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.cl().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.cl().cm().cp();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gW.eq().oE && z2 && i4 < i; i4++) {
            e eVar = new e();
            eVar.oh = i4 + 1;
            this.oc = i4;
            try {
                try {
                    try {
                        try {
                            this.ob = new b(this.gW);
                            this.ob.b(i2, i3, eVar);
                        } catch (SocketTimeoutException e) {
                            this.gW.eq().oF = -13;
                            z = true;
                            eVar.ol = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            BdLog.e(e.getMessage());
                            this.gW.a(eVar);
                            if (this.nS <= 0 && this.ob != null) {
                                this.nS = this.ob.ec();
                            }
                            eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                            this.gW.a(eVar);
                            a dZ = a.dZ();
                            if (dZ != null && this.ob != null && this.ob.ef()) {
                                dZ.a(this.gW);
                            }
                        }
                    } catch (SocketException e2) {
                        this.gW.eq().oF = -12;
                        z = true;
                        eVar.ol = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.gW.a(eVar);
                        if (this.nS <= 0 && this.ob != null) {
                            this.nS = this.ob.ec();
                        }
                        eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                        this.gW.a(eVar);
                        a dZ2 = a.dZ();
                        if (dZ2 != null && this.ob != null && this.ob.ef()) {
                            dZ2.a(this.gW);
                        }
                    }
                } catch (UnsupportedOperationException e3) {
                    z = false;
                    this.gW.eq().oF = -14;
                    eVar.ol = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.gW.a(eVar);
                    if (this.nS <= 0 && this.ob != null) {
                        this.nS = this.ob.ec();
                    }
                    eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                    this.gW.a(eVar);
                    a dZ3 = a.dZ();
                    if (dZ3 != null && this.ob != null && this.ob.ef()) {
                        dZ3.a(this.gW);
                    }
                } catch (Throwable th) {
                    this.gW.eq().oF = -10;
                    z = false;
                    eVar.ol = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.gW.a(eVar);
                    if (this.nS <= 0 && this.ob != null) {
                        this.nS = this.ob.ec();
                    }
                    eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                    this.gW.a(eVar);
                    a dZ4 = a.dZ();
                    if (dZ4 != null && this.ob != null && this.ob.ef()) {
                        dZ4.a(this.gW);
                    }
                }
                if (this.gW.eq().responseCode == 200) {
                    b(null, eVar);
                    if (this.nS <= 0 && this.ob != null) {
                        this.nS = this.ob.ec();
                    }
                    eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                    this.gW.a(eVar);
                    a dZ5 = a.dZ();
                    if (dZ5 == null || this.ob == null || !this.ob.ef()) {
                        return;
                    }
                    dZ5.a(this.gW);
                    return;
                }
                eVar.ol = String.valueOf(String.valueOf(this.gW.eq().responseCode)) + "|retryCount:" + i4;
                z = ah(this.gW.eq().responseCode);
                this.gW.a(eVar);
                if (this.nS <= 0 && this.ob != null) {
                    this.nS = this.ob.ec();
                }
                eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                this.gW.a(eVar);
                a dZ6 = a.dZ();
                if (dZ6 != null && this.ob != null && this.ob.ef()) {
                    dZ6.a(this.gW);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.nS <= 0 && this.ob != null) {
                    this.nS = this.ob.ec();
                }
                eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                this.gW.a(eVar);
                a dZ7 = a.dZ();
                if (dZ7 != null && this.ob != null && this.ob.ef()) {
                    dZ7.a(this.gW);
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

    public void g(int i, int i2, int i3) {
        if (this.gW.ep().et()) {
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
            i2 = com.baidu.adp.framework.c.b.cl().co().cp();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.cl().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.cl().cm().cp();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.gW.eq().oE && z2 && i4 < i; i4++) {
            e eVar = new e();
            this.oc = i4;
            eVar.oh = i4 + 1;
            try {
                try {
                    try {
                        try {
                            this.ob = new b(this.gW);
                            this.ob.c(i2, i3, eVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.gW.eq().oF = -14;
                            eVar.ol = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.gW.a(eVar);
                            if (this.nS <= 0 && this.ob != null) {
                                this.nS = this.ob.ec();
                            }
                            eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                            this.gW.a(eVar);
                            a dZ = a.dZ();
                            if (dZ != null) {
                                dZ.a(this.gW);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.gW.eq().oF = -13;
                        z = true;
                        eVar.ol = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.gW.a(eVar);
                        if (this.nS <= 0 && this.ob != null) {
                            this.nS = this.ob.ec();
                        }
                        eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                        this.gW.a(eVar);
                        a dZ2 = a.dZ();
                        if (dZ2 != null) {
                            dZ2.a(this.gW);
                        }
                    }
                } catch (SocketException e3) {
                    this.gW.eq().oF = -12;
                    z = true;
                    eVar.ol = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.gW.a(eVar);
                    if (this.nS <= 0 && this.ob != null) {
                        this.nS = this.ob.ec();
                    }
                    eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                    this.gW.a(eVar);
                    a dZ3 = a.dZ();
                    if (dZ3 != null) {
                        dZ3.a(this.gW);
                    }
                } catch (Throwable th) {
                    this.gW.eq().oF = -10;
                    z = false;
                    eVar.ol = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.gW.a(eVar);
                    if (this.nS <= 0 && this.ob != null) {
                        this.nS = this.ob.ec();
                    }
                    eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                    this.gW.a(eVar);
                    a dZ4 = a.dZ();
                    if (dZ4 != null) {
                        dZ4.a(this.gW);
                    }
                }
                if (this.gW.eq().responseCode == 200) {
                    b(null, eVar);
                    if (this.nS <= 0 && this.ob != null) {
                        this.nS = this.ob.ec();
                    }
                    eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                    this.gW.a(eVar);
                    a dZ5 = a.dZ();
                    if (dZ5 != null) {
                        dZ5.a(this.gW);
                        return;
                    }
                    return;
                }
                eVar.ol = String.valueOf(String.valueOf(this.gW.eq().responseCode)) + "|retryCount:" + i4;
                z = ah(this.gW.eq().responseCode);
                this.gW.a(eVar);
                if (this.nS <= 0 && this.ob != null) {
                    this.nS = this.ob.ec();
                }
                eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                this.gW.a(eVar);
                a dZ6 = a.dZ();
                if (dZ6 != null) {
                    dZ6.a(this.gW);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.nS <= 0 && this.ob != null) {
                    this.nS = this.ob.ec();
                }
                eVar.oi = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.b.a.dI().b(this.gW.ep().getUrl(), this.gW.ep().ae("Host"), TextUtils.isEmpty(eVar.ol), eVar.or != null);
                this.gW.a(eVar);
                a dZ7 = a.dZ();
                if (dZ7 != null) {
                    dZ7.a(this.gW);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.ob != null) {
            this.ob.eg();
        }
    }

    public boolean ei() {
        if (this.gW == null) {
            return false;
        }
        return this.gW.eq().oE;
    }

    public void ej() {
        if (this.gW != null) {
            this.gW.eq().oE = true;
        }
    }

    public long ek() {
        if (this.nS > 0) {
            return this.nS;
        }
        if (this.ob == null) {
            return -1L;
        }
        return this.ob.ec();
    }

    public long el() {
        if (this.ob == null) {
            return -1L;
        }
        return this.ob.ed();
    }

    public long ee() {
        if (this.ob == null) {
            return -1L;
        }
        return this.ob.ee();
    }

    public long em() {
        if (this.ob == null) {
            return -1L;
        }
        return this.ob.eb();
    }

    public long en() {
        if (this.ob == null) {
            return -1L;
        }
        return this.ob.ea();
    }

    public int eo() {
        return this.oc;
    }

    private void b(String str, e eVar) {
        if (com.baidu.adp.b.a.jr() != null && eVar != null && this.gW.eq() != null) {
            String str2 = str == null ? this.gW.eq().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + eVar.od + "; downloadSize = " + eVar.oe + "; url=" + eVar.url);
            com.baidu.adp.b.a.jr().a(str2, eVar.od + 54, eVar.oe + 54, eVar.url);
        }
    }
}
