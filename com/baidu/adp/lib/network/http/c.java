package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
/* loaded from: classes.dex */
public class c {
    private b BR;
    private e vn;
    private int BS = 0;
    private long BI = 0;

    public c(e eVar) {
        this.vn = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [171=7, 172=4, 173=4, 174=4, 175=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int ha = i3 <= 0 ? com.baidu.adp.framework.c.b.gW().gZ().ha() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gW().getRetryCount();
        }
        int ha2 = i4 <= 0 ? com.baidu.adp.framework.c.b.gW().gX().ha() : i4;
        this.BR = new b(this.vn);
        for (int i5 = 0; i5 < i; i5++) {
            d dVar = new d();
            try {
                try {
                    dVar.BW = i5 + 1;
                    this.BS = i5;
                    ak(i5);
                    boolean a = this.BR.a(str, hVar, ha, ha2, z, dVar, z2);
                    com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                    this.vn.a(dVar);
                    a iM = a.iM();
                    if (iM != null) {
                        iM.a(this.vn);
                    }
                    return a;
                } catch (Exception e) {
                    this.vn.jd().responseCode = -10;
                    dVar.BZ = String.valueOf(this.vn.jd().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.vn.a(dVar);
                    com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                    this.vn.a(dVar);
                    a iM2 = a.iM();
                    if (iM2 != null) {
                        iM2.a(this.vn);
                    }
                }
            } catch (FileNotFoundException e2) {
                try {
                    this.vn.jd().responseCode = -100;
                    dVar.BZ = String.valueOf(this.vn.jd().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.vn.a(dVar);
                    com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                    this.vn.a(dVar);
                    a iM3 = a.iM();
                    if (iM3 != null) {
                        iM3.a(this.vn);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                    this.vn.a(dVar);
                    a iM4 = a.iM();
                    if (iM4 != null) {
                        iM4.a(this.vn);
                    }
                    throw th;
                }
            }
        }
        return false;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, boolean z) {
        return a(str, hVar, i, -1, i2, i3, false, z);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [269=7, 270=7, 272=7, 273=14, 274=7, 275=7, 276=7, 277=7] */
    public void e(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.gW().gZ().ha();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.gW().gX().ha();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.vn.jd().Cp && z && i4 < i; i4++) {
            d dVar = new d();
            this.vn.a(dVar);
            try {
                try {
                    try {
                        try {
                            this.BS = i4;
                            dVar.BW = i4 + 1;
                            dVar.Cg = 1;
                            ak(i4);
                            this.BR = new b(this.vn);
                            this.BR.a(i2, i3, dVar);
                        } catch (IllegalStateException e) {
                            this.vn.jd().Cq = -19;
                            dVar.BZ = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            if (this.BI <= 0 && this.BR != null) {
                                this.BI = this.BR.iP();
                            }
                            dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                            this.vn.b(dVar);
                            a iM = a.iM();
                            if (iM != null) {
                                iM.a(this.vn);
                            }
                        }
                    } catch (SocketException e2) {
                        dVar.BZ = String.valueOf(this.vn.jd().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.vn.jd().Cq = -12;
                        if (this.BI <= 0 && this.BR != null) {
                            this.BI = this.BR.iP();
                        }
                        dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                        this.vn.b(dVar);
                        a iM2 = a.iM();
                        if (iM2 != null) {
                            iM2.a(this.vn);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e3) {
                    dVar.BZ = String.valueOf(this.vn.jd().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.vn.jd().Cq = -13;
                    if (this.BI <= 0 && this.BR != null) {
                        this.BI = this.BR.iP();
                    }
                    dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                    this.vn.b(dVar);
                    a iM3 = a.iM();
                    if (iM3 != null) {
                        iM3.a(this.vn);
                    }
                    z = true;
                } catch (Exception e4) {
                    dVar.BZ = String.valueOf(this.vn.jd().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.vn.jd().Cq = -10;
                    BdLog.e(e4.getMessage());
                    if (this.BI <= 0 && this.BR != null) {
                        this.BI = this.BR.iP();
                    }
                    dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                    this.vn.b(dVar);
                    a iM4 = a.iM();
                    if (iM4 != null) {
                        iM4.a(this.vn);
                        return;
                    }
                    return;
                }
                if (this.vn.jd().responseCode == 200) {
                    this.vn.b(dVar);
                    if (this.BI <= 0 && this.BR != null) {
                        this.BI = this.BR.iP();
                    }
                    dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                    this.vn.b(dVar);
                    a iM5 = a.iM();
                    if (iM5 != null) {
                        iM5.a(this.vn);
                        return;
                    }
                    return;
                }
                dVar.BZ = String.valueOf(this.vn.jd().responseCode) + "|retryCount:" + i4;
                boolean aj = aj(this.vn.jd().responseCode);
                if (this.BI <= 0 && this.BR != null) {
                    this.BI = this.BR.iP();
                }
                dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                this.vn.b(dVar);
                a iM6 = a.iM();
                if (iM6 != null) {
                    iM6.a(this.vn);
                }
                z = aj;
            } catch (Throwable th) {
                if (this.BI <= 0 && this.BR != null) {
                    this.BI = this.BR.iP();
                }
                dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                this.vn.b(dVar);
                a iM7 = a.iM();
                if (iM7 != null) {
                    iM7.a(this.vn);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [349=7, 350=7, 352=7, 353=14, 354=7, 355=7, 356=7, 357=7, 359=5] */
    private void f(int i, int i2, int i3) {
        boolean z;
        a iM;
        b bVar;
        boolean iS;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.gW().gZ().ha();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.gW().gX().ha();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.vn.jd().Cp && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.BW = i4 + 1;
            this.BS = i4;
            ak(i4);
            try {
                try {
                    try {
                        try {
                            this.BR = new b(this.vn);
                            this.BR.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.vn.jd().Cq = -14;
                            dVar.BZ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.vn.a(dVar);
                            if (this.BI <= 0 && this.BR != null) {
                                this.BI = this.BR.iP();
                            }
                            dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                            this.vn.a(dVar);
                            a iM2 = a.iM();
                            if (iM2 != null && this.BR != null && this.BR.iS()) {
                                iM2.a(this.vn);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.vn.jd().Cq = -13;
                        z = true;
                        dVar.BZ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.vn.a(dVar);
                        if (this.BI <= 0 && this.BR != null) {
                            this.BI = this.BR.iP();
                        }
                        dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                        this.vn.a(dVar);
                        a iM3 = a.iM();
                        if (iM3 != null && this.BR != null && this.BR.iS()) {
                            iM3.a(this.vn);
                        }
                    }
                } catch (SocketException e3) {
                    this.vn.jd().Cq = -12;
                    z = true;
                    dVar.BZ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.vn.a(dVar);
                    if (this.BI <= 0 && this.BR != null) {
                        this.BI = this.BR.iP();
                    }
                    dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                    this.vn.a(dVar);
                    a iM4 = a.iM();
                    if (iM4 != null && this.BR != null && this.BR.iS()) {
                        iM4.a(this.vn);
                    }
                }
                if (this.vn.jd().responseCode == 200) {
                    if (iM != null) {
                        if (bVar != null) {
                            if (iS) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.BZ = String.valueOf(this.vn.jd().responseCode) + "|retryCount:" + i4;
                z = aj(this.vn.jd().responseCode);
                this.vn.a(dVar);
                if (this.BI <= 0 && this.BR != null) {
                    this.BI = this.BR.iP();
                }
                dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                this.vn.a(dVar);
                a iM5 = a.iM();
                if (iM5 != null && this.BR != null && this.BR.iS()) {
                    iM5.a(this.vn);
                }
                z2 = z;
            } finally {
                if (this.BI <= 0 && this.BR != null) {
                    this.BI = this.BR.iP();
                }
                dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                this.vn.a(dVar);
                iM = a.iM();
                if (iM != null && this.BR != null && this.BR.iS()) {
                    iM.a(this.vn);
                }
            }
        }
    }

    private boolean aj(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void g(int i, int i2, int i3) {
        if (this.vn.jc().jg()) {
            f(i, i2, i3);
        } else {
            h(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [471=7, 472=7, 474=7, 475=14, 476=7, 477=7, 478=7, 479=7, 481=5] */
    private void h(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.gW().gZ().ha();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.gW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.gW().gX().ha();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.vn.jd().Cp && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.BS = i4;
            dVar.BW = i4 + 1;
            ak(i4);
            try {
                try {
                    try {
                        try {
                            this.BR = new b(this.vn);
                            this.BR.c(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.vn.jd().Cq = -14;
                            dVar.BZ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.vn.a(dVar);
                            if (this.BI <= 0 && this.BR != null) {
                                this.BI = this.BR.iP();
                            }
                            dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                            this.vn.a(dVar);
                            a iM = a.iM();
                            if (iM != null) {
                                iM.a(this.vn);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.vn.jd().Cq = -13;
                        z = true;
                        dVar.BZ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.vn.a(dVar);
                        if (this.BI <= 0 && this.BR != null) {
                            this.BI = this.BR.iP();
                        }
                        dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                        this.vn.a(dVar);
                        a iM2 = a.iM();
                        if (iM2 != null) {
                            iM2.a(this.vn);
                        }
                    }
                } catch (SocketException e3) {
                    this.vn.jd().Cq = -12;
                    z = true;
                    dVar.BZ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.vn.a(dVar);
                    if (this.BI <= 0 && this.BR != null) {
                        this.BI = this.BR.iP();
                    }
                    dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                    this.vn.a(dVar);
                    a iM3 = a.iM();
                    if (iM3 != null) {
                        iM3.a(this.vn);
                    }
                } catch (Throwable th) {
                    this.vn.jd().Cq = -10;
                    z = false;
                    dVar.BZ = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.vn.a(dVar);
                    if (this.BI <= 0 && this.BR != null) {
                        this.BI = this.BR.iP();
                    }
                    dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                    this.vn.a(dVar);
                    a iM4 = a.iM();
                    if (iM4 != null) {
                        iM4.a(this.vn);
                    }
                }
                if (this.vn.jd().responseCode == 200) {
                    if (this.BI <= 0 && this.BR != null) {
                        this.BI = this.BR.iP();
                    }
                    dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                    this.vn.a(dVar);
                    a iM5 = a.iM();
                    if (iM5 != null) {
                        iM5.a(this.vn);
                        return;
                    }
                    return;
                }
                dVar.BZ = String.valueOf(this.vn.jd().responseCode) + "|retryCount:" + i4;
                z = aj(this.vn.jd().responseCode);
                this.vn.a(dVar);
                if (this.BI <= 0 && this.BR != null) {
                    this.BI = this.BR.iP();
                }
                dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                this.vn.a(dVar);
                a iM6 = a.iM();
                if (iM6 != null) {
                    iM6.a(this.vn);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.BI <= 0 && this.BR != null) {
                    this.BI = this.BR.iP();
                }
                dVar.BX = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.iq().a(this.vn.jc().getUrl(), this.vn.jc().aQ("Host"), TextUtils.isEmpty(dVar.BZ), dVar.Cd != null);
                this.vn.a(dVar);
                a iM7 = a.iM();
                if (iM7 != null) {
                    iM7.a(this.vn);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.BR != null) {
            this.BR.iT();
        }
    }

    public boolean iV() {
        if (this.vn == null) {
            return false;
        }
        return this.vn.jd().Cp;
    }

    public void iW() {
        if (this.vn != null) {
            this.vn.jd().Cp = true;
        }
    }

    public long iX() {
        if (this.BI > 0) {
            return this.BI;
        }
        if (this.BR == null) {
            return -1L;
        }
        return this.BR.iP();
    }

    public long iY() {
        if (this.BR == null) {
            return -1L;
        }
        return this.BR.iQ();
    }

    public long iR() {
        if (this.BR == null) {
            return -1L;
        }
        return this.BR.iR();
    }

    public long iZ() {
        if (this.BR == null) {
            return -1L;
        }
        return this.BR.iO();
    }

    public long ja() {
        if (this.BR == null) {
            return -1L;
        }
        return this.BR.iN();
    }

    public int jb() {
        return this.BS;
    }

    private void ak(int i) {
        try {
            if (this.vn != null && i > 0) {
                this.vn.jc().x("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
