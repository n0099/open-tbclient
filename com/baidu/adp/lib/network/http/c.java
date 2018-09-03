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
    private e sN;
    private b zw;
    private int zx = 0;
    private long zn = 0;

    public c(e eVar) {
        this.sN = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [171=7, 172=4, 173=4, 174=4, 175=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int fS = i3 <= 0 ? com.baidu.adp.framework.c.b.fO().fR().fS() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fO().getRetryCount();
        }
        int fS2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fO().fP().fS() : i4;
        this.zw = new b(this.sN);
        for (int i5 = 0; i5 < i; i5++) {
            d dVar = new d();
            try {
                try {
                    dVar.zB = i5 + 1;
                    this.zx = i5;
                    ac(i5);
                    boolean a = this.zw.a(str, hVar, fS, fS2, z, dVar, z2);
                    com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                    this.sN.a(dVar);
                    a hG = a.hG();
                    if (hG != null) {
                        hG.a(this.sN);
                    }
                    return a;
                } catch (Exception e) {
                    this.sN.hX().responseCode = -10;
                    dVar.zE = String.valueOf(this.sN.hX().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.sN.a(dVar);
                    com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                    this.sN.a(dVar);
                    a hG2 = a.hG();
                    if (hG2 != null) {
                        hG2.a(this.sN);
                    }
                }
            } catch (FileNotFoundException e2) {
                try {
                    this.sN.hX().responseCode = -100;
                    dVar.zE = String.valueOf(this.sN.hX().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.sN.a(dVar);
                    com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                    this.sN.a(dVar);
                    a hG3 = a.hG();
                    if (hG3 != null) {
                        hG3.a(this.sN);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                    this.sN.a(dVar);
                    a hG4 = a.hG();
                    if (hG4 != null) {
                        hG4.a(this.sN);
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
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fO().fR().fS();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fO().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fO().fP().fS();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.sN.hX().zU && z && i4 < i; i4++) {
            d dVar = new d();
            this.sN.a(dVar);
            try {
                try {
                    try {
                        try {
                            this.zx = i4;
                            dVar.zB = i4 + 1;
                            dVar.zL = 1;
                            ac(i4);
                            this.zw = new b(this.sN);
                            this.zw.a(i2, i3, dVar);
                        } catch (IllegalStateException e) {
                            this.sN.hX().zV = -19;
                            dVar.zE = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            if (this.zn <= 0 && this.zw != null) {
                                this.zn = this.zw.hJ();
                            }
                            dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                            this.sN.b(dVar);
                            a hG = a.hG();
                            if (hG != null) {
                                hG.a(this.sN);
                            }
                        }
                    } catch (SocketException e2) {
                        dVar.zE = String.valueOf(this.sN.hX().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.sN.hX().zV = -12;
                        if (this.zn <= 0 && this.zw != null) {
                            this.zn = this.zw.hJ();
                        }
                        dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                        this.sN.b(dVar);
                        a hG2 = a.hG();
                        if (hG2 != null) {
                            hG2.a(this.sN);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e3) {
                    dVar.zE = String.valueOf(this.sN.hX().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.sN.hX().zV = -13;
                    if (this.zn <= 0 && this.zw != null) {
                        this.zn = this.zw.hJ();
                    }
                    dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                    this.sN.b(dVar);
                    a hG3 = a.hG();
                    if (hG3 != null) {
                        hG3.a(this.sN);
                    }
                    z = true;
                } catch (Exception e4) {
                    dVar.zE = String.valueOf(this.sN.hX().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.sN.hX().zV = -10;
                    BdLog.e(e4.getMessage());
                    if (this.zn <= 0 && this.zw != null) {
                        this.zn = this.zw.hJ();
                    }
                    dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                    this.sN.b(dVar);
                    a hG4 = a.hG();
                    if (hG4 != null) {
                        hG4.a(this.sN);
                        return;
                    }
                    return;
                }
                if (this.sN.hX().responseCode == 200) {
                    this.sN.b(dVar);
                    if (this.zn <= 0 && this.zw != null) {
                        this.zn = this.zw.hJ();
                    }
                    dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                    this.sN.b(dVar);
                    a hG5 = a.hG();
                    if (hG5 != null) {
                        hG5.a(this.sN);
                        return;
                    }
                    return;
                }
                dVar.zE = String.valueOf(this.sN.hX().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.sN.hX().responseCode);
                if (this.zn <= 0 && this.zw != null) {
                    this.zn = this.zw.hJ();
                }
                dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                this.sN.b(dVar);
                a hG6 = a.hG();
                if (hG6 != null) {
                    hG6.a(this.sN);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.zn <= 0 && this.zw != null) {
                    this.zn = this.zw.hJ();
                }
                dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                this.sN.b(dVar);
                a hG7 = a.hG();
                if (hG7 != null) {
                    hG7.a(this.sN);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [349=7, 350=7, 352=7, 353=14, 354=7, 355=7, 356=7, 357=7, 359=5] */
    private void e(int i, int i2, int i3) {
        boolean z;
        a hG;
        b bVar;
        boolean hM;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fO().fR().fS();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fO().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fO().fP().fS();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.sN.hX().zU && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.zB = i4 + 1;
            this.zx = i4;
            ac(i4);
            try {
                try {
                    try {
                        try {
                            this.zw = new b(this.sN);
                            this.zw.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.sN.hX().zV = -14;
                            dVar.zE = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.sN.a(dVar);
                            if (this.zn <= 0 && this.zw != null) {
                                this.zn = this.zw.hJ();
                            }
                            dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                            this.sN.a(dVar);
                            a hG2 = a.hG();
                            if (hG2 != null && this.zw != null && this.zw.hM()) {
                                hG2.a(this.sN);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.sN.hX().zV = -13;
                        z = true;
                        dVar.zE = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.sN.a(dVar);
                        if (this.zn <= 0 && this.zw != null) {
                            this.zn = this.zw.hJ();
                        }
                        dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                        this.sN.a(dVar);
                        a hG3 = a.hG();
                        if (hG3 != null && this.zw != null && this.zw.hM()) {
                            hG3.a(this.sN);
                        }
                    }
                } catch (SocketException e3) {
                    this.sN.hX().zV = -12;
                    z = true;
                    dVar.zE = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.sN.a(dVar);
                    if (this.zn <= 0 && this.zw != null) {
                        this.zn = this.zw.hJ();
                    }
                    dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                    this.sN.a(dVar);
                    a hG4 = a.hG();
                    if (hG4 != null && this.zw != null && this.zw.hM()) {
                        hG4.a(this.sN);
                    }
                }
                if (this.sN.hX().responseCode == 200) {
                    if (hG != null) {
                        if (bVar != null) {
                            if (hM) {
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    return;
                }
                dVar.zE = String.valueOf(this.sN.hX().responseCode) + "|retryCount:" + i4;
                z = ab(this.sN.hX().responseCode);
                this.sN.a(dVar);
                if (this.zn <= 0 && this.zw != null) {
                    this.zn = this.zw.hJ();
                }
                dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                this.sN.a(dVar);
                a hG5 = a.hG();
                if (hG5 != null && this.zw != null && this.zw.hM()) {
                    hG5.a(this.sN);
                }
                z2 = z;
            } finally {
                if (this.zn <= 0 && this.zw != null) {
                    this.zn = this.zw.hJ();
                }
                dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                this.sN.a(dVar);
                hG = a.hG();
                if (hG != null && this.zw != null && this.zw.hM()) {
                    hG.a(this.sN);
                }
            }
        }
    }

    private boolean ab(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void f(int i, int i2, int i3) {
        if (this.sN.hW().ia()) {
            e(i, i2, i3);
        } else {
            g(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [471=7, 472=7, 474=7, 475=14, 476=7, 477=7, 478=7, 479=7, 481=5] */
    private void g(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fO().fR().fS();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fO().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fO().fP().fS();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.sN.hX().zU && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.zx = i4;
            dVar.zB = i4 + 1;
            ac(i4);
            try {
                try {
                    try {
                        try {
                            this.zw = new b(this.sN);
                            this.zw.c(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.sN.hX().zV = -14;
                            dVar.zE = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.sN.a(dVar);
                            if (this.zn <= 0 && this.zw != null) {
                                this.zn = this.zw.hJ();
                            }
                            dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                            this.sN.a(dVar);
                            a hG = a.hG();
                            if (hG != null) {
                                hG.a(this.sN);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.sN.hX().zV = -13;
                        z = true;
                        dVar.zE = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.sN.a(dVar);
                        if (this.zn <= 0 && this.zw != null) {
                            this.zn = this.zw.hJ();
                        }
                        dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                        this.sN.a(dVar);
                        a hG2 = a.hG();
                        if (hG2 != null) {
                            hG2.a(this.sN);
                        }
                    }
                } catch (SocketException e3) {
                    this.sN.hX().zV = -12;
                    z = true;
                    dVar.zE = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.sN.a(dVar);
                    if (this.zn <= 0 && this.zw != null) {
                        this.zn = this.zw.hJ();
                    }
                    dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                    this.sN.a(dVar);
                    a hG3 = a.hG();
                    if (hG3 != null) {
                        hG3.a(this.sN);
                    }
                } catch (Throwable th) {
                    this.sN.hX().zV = -10;
                    z = false;
                    dVar.zE = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.sN.a(dVar);
                    if (this.zn <= 0 && this.zw != null) {
                        this.zn = this.zw.hJ();
                    }
                    dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                    this.sN.a(dVar);
                    a hG4 = a.hG();
                    if (hG4 != null) {
                        hG4.a(this.sN);
                    }
                }
                if (this.sN.hX().responseCode == 200) {
                    if (this.zn <= 0 && this.zw != null) {
                        this.zn = this.zw.hJ();
                    }
                    dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                    this.sN.a(dVar);
                    a hG5 = a.hG();
                    if (hG5 != null) {
                        hG5.a(this.sN);
                        return;
                    }
                    return;
                }
                dVar.zE = String.valueOf(this.sN.hX().responseCode) + "|retryCount:" + i4;
                z = ab(this.sN.hX().responseCode);
                this.sN.a(dVar);
                if (this.zn <= 0 && this.zw != null) {
                    this.zn = this.zw.hJ();
                }
                dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                this.sN.a(dVar);
                a hG6 = a.hG();
                if (hG6 != null) {
                    hG6.a(this.sN);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.zn <= 0 && this.zw != null) {
                    this.zn = this.zw.hJ();
                }
                dVar.zC = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.sN.hW().getUrl(), this.sN.hW().az("Host"), TextUtils.isEmpty(dVar.zE), dVar.zI != null);
                this.sN.a(dVar);
                a hG7 = a.hG();
                if (hG7 != null) {
                    hG7.a(this.sN);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.zw != null) {
            this.zw.hN();
        }
    }

    public boolean hP() {
        if (this.sN == null) {
            return false;
        }
        return this.sN.hX().zU;
    }

    public void hQ() {
        if (this.sN != null) {
            this.sN.hX().zU = true;
        }
    }

    public long hR() {
        if (this.zn > 0) {
            return this.zn;
        }
        if (this.zw == null) {
            return -1L;
        }
        return this.zw.hJ();
    }

    public long hS() {
        if (this.zw == null) {
            return -1L;
        }
        return this.zw.hK();
    }

    public long hL() {
        if (this.zw == null) {
            return -1L;
        }
        return this.zw.hL();
    }

    public long hT() {
        if (this.zw == null) {
            return -1L;
        }
        return this.zw.hI();
    }

    public long hU() {
        if (this.zw == null) {
            return -1L;
        }
        return this.zw.hH();
    }

    public int hV() {
        return this.zx;
    }

    private void ac(int i) {
        try {
            if (this.sN != null && i > 0) {
                this.sN.hW().p("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
