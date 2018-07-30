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
    private e sM;
    private b zv;
    private int zw = 0;
    private long zm = 0;

    public c(e eVar) {
        this.sM = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [171=7, 172=4, 173=4, 174=4, 175=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int fS = i3 <= 0 ? com.baidu.adp.framework.c.b.fO().fR().fS() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fO().getRetryCount();
        }
        int fS2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fO().fP().fS() : i4;
        this.zv = new b(this.sM);
        for (int i5 = 0; i5 < i; i5++) {
            d dVar = new d();
            try {
                try {
                    dVar.zA = i5 + 1;
                    this.zw = i5;
                    ac(i5);
                    boolean a = this.zv.a(str, hVar, fS, fS2, z, dVar, z2);
                    com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                    this.sM.a(dVar);
                    a hG = a.hG();
                    if (hG != null) {
                        hG.a(this.sM);
                    }
                    return a;
                } catch (Exception e) {
                    this.sM.hX().responseCode = -10;
                    dVar.zD = String.valueOf(this.sM.hX().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.sM.a(dVar);
                    com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                    this.sM.a(dVar);
                    a hG2 = a.hG();
                    if (hG2 != null) {
                        hG2.a(this.sM);
                    }
                }
            } catch (FileNotFoundException e2) {
                try {
                    this.sM.hX().responseCode = -100;
                    dVar.zD = String.valueOf(this.sM.hX().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                    this.sM.a(dVar);
                    com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                    this.sM.a(dVar);
                    a hG3 = a.hG();
                    if (hG3 != null) {
                        hG3.a(this.sM);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                    this.sM.a(dVar);
                    a hG4 = a.hG();
                    if (hG4 != null) {
                        hG4.a(this.sM);
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
        for (int i4 = 0; !this.sM.hX().zT && z && i4 < i; i4++) {
            d dVar = new d();
            this.sM.a(dVar);
            try {
                try {
                    try {
                        try {
                            this.zw = i4;
                            dVar.zA = i4 + 1;
                            dVar.zK = 1;
                            ac(i4);
                            this.zv = new b(this.sM);
                            this.zv.a(i2, i3, dVar);
                        } catch (IllegalStateException e) {
                            this.sM.hX().zU = -19;
                            dVar.zD = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                            if (this.zm <= 0 && this.zv != null) {
                                this.zm = this.zv.hJ();
                            }
                            dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                            this.sM.b(dVar);
                            a hG = a.hG();
                            if (hG != null) {
                                hG.a(this.sM);
                            }
                        }
                    } catch (SocketException e2) {
                        dVar.zD = String.valueOf(this.sM.hX().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.sM.hX().zU = -12;
                        if (this.zm <= 0 && this.zv != null) {
                            this.zm = this.zv.hJ();
                        }
                        dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                        this.sM.b(dVar);
                        a hG2 = a.hG();
                        if (hG2 != null) {
                            hG2.a(this.sM);
                        }
                        z = true;
                    }
                } catch (SocketTimeoutException e3) {
                    dVar.zD = String.valueOf(this.sM.hX().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                    this.sM.hX().zU = -13;
                    if (this.zm <= 0 && this.zv != null) {
                        this.zm = this.zv.hJ();
                    }
                    dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                    this.sM.b(dVar);
                    a hG3 = a.hG();
                    if (hG3 != null) {
                        hG3.a(this.sM);
                    }
                    z = true;
                } catch (Exception e4) {
                    dVar.zD = String.valueOf(this.sM.hX().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.sM.hX().zU = -10;
                    BdLog.e(e4.getMessage());
                    if (this.zm <= 0 && this.zv != null) {
                        this.zm = this.zv.hJ();
                    }
                    dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                    this.sM.b(dVar);
                    a hG4 = a.hG();
                    if (hG4 != null) {
                        hG4.a(this.sM);
                        return;
                    }
                    return;
                }
                if (this.sM.hX().responseCode == 200) {
                    this.sM.b(dVar);
                    if (this.zm <= 0 && this.zv != null) {
                        this.zm = this.zv.hJ();
                    }
                    dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                    this.sM.b(dVar);
                    a hG5 = a.hG();
                    if (hG5 != null) {
                        hG5.a(this.sM);
                        return;
                    }
                    return;
                }
                dVar.zD = String.valueOf(this.sM.hX().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.sM.hX().responseCode);
                if (this.zm <= 0 && this.zv != null) {
                    this.zm = this.zv.hJ();
                }
                dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                this.sM.b(dVar);
                a hG6 = a.hG();
                if (hG6 != null) {
                    hG6.a(this.sM);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.zm <= 0 && this.zv != null) {
                    this.zm = this.zv.hJ();
                }
                dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                this.sM.b(dVar);
                a hG7 = a.hG();
                if (hG7 != null) {
                    hG7.a(this.sM);
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
        for (int i4 = 0; !this.sM.hX().zT && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.zA = i4 + 1;
            this.zw = i4;
            ac(i4);
            try {
                try {
                    try {
                        try {
                            this.zv = new b(this.sM);
                            this.zv.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.sM.hX().zU = -14;
                            dVar.zD = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.sM.a(dVar);
                            if (this.zm <= 0 && this.zv != null) {
                                this.zm = this.zv.hJ();
                            }
                            dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                            this.sM.a(dVar);
                            a hG2 = a.hG();
                            if (hG2 != null && this.zv != null && this.zv.hM()) {
                                hG2.a(this.sM);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.sM.hX().zU = -13;
                        z = true;
                        dVar.zD = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.sM.a(dVar);
                        if (this.zm <= 0 && this.zv != null) {
                            this.zm = this.zv.hJ();
                        }
                        dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                        this.sM.a(dVar);
                        a hG3 = a.hG();
                        if (hG3 != null && this.zv != null && this.zv.hM()) {
                            hG3.a(this.sM);
                        }
                    }
                } catch (SocketException e3) {
                    this.sM.hX().zU = -12;
                    z = true;
                    dVar.zD = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.sM.a(dVar);
                    if (this.zm <= 0 && this.zv != null) {
                        this.zm = this.zv.hJ();
                    }
                    dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                    this.sM.a(dVar);
                    a hG4 = a.hG();
                    if (hG4 != null && this.zv != null && this.zv.hM()) {
                        hG4.a(this.sM);
                    }
                }
                if (this.sM.hX().responseCode == 200) {
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
                dVar.zD = String.valueOf(this.sM.hX().responseCode) + "|retryCount:" + i4;
                z = ab(this.sM.hX().responseCode);
                this.sM.a(dVar);
                if (this.zm <= 0 && this.zv != null) {
                    this.zm = this.zv.hJ();
                }
                dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                this.sM.a(dVar);
                a hG5 = a.hG();
                if (hG5 != null && this.zv != null && this.zv.hM()) {
                    hG5.a(this.sM);
                }
                z2 = z;
            } finally {
                if (this.zm <= 0 && this.zv != null) {
                    this.zm = this.zv.hJ();
                }
                dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                this.sM.a(dVar);
                hG = a.hG();
                if (hG != null && this.zv != null && this.zv.hM()) {
                    hG.a(this.sM);
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
        if (this.sM.hW().ia()) {
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
        for (int i4 = 0; !this.sM.hX().zT && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.zw = i4;
            dVar.zA = i4 + 1;
            ac(i4);
            try {
                try {
                    try {
                        try {
                            this.zv = new b(this.sM);
                            this.zv.c(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.sM.hX().zU = -14;
                            dVar.zD = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.sM.a(dVar);
                            if (this.zm <= 0 && this.zv != null) {
                                this.zm = this.zv.hJ();
                            }
                            dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                            this.sM.a(dVar);
                            a hG = a.hG();
                            if (hG != null) {
                                hG.a(this.sM);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.sM.hX().zU = -13;
                        z = true;
                        dVar.zD = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.sM.a(dVar);
                        if (this.zm <= 0 && this.zv != null) {
                            this.zm = this.zv.hJ();
                        }
                        dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                        this.sM.a(dVar);
                        a hG2 = a.hG();
                        if (hG2 != null) {
                            hG2.a(this.sM);
                        }
                    }
                } catch (SocketException e3) {
                    this.sM.hX().zU = -12;
                    z = true;
                    dVar.zD = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.sM.a(dVar);
                    if (this.zm <= 0 && this.zv != null) {
                        this.zm = this.zv.hJ();
                    }
                    dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                    this.sM.a(dVar);
                    a hG3 = a.hG();
                    if (hG3 != null) {
                        hG3.a(this.sM);
                    }
                } catch (Throwable th) {
                    this.sM.hX().zU = -10;
                    z = false;
                    dVar.zD = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.sM.a(dVar);
                    if (this.zm <= 0 && this.zv != null) {
                        this.zm = this.zv.hJ();
                    }
                    dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                    this.sM.a(dVar);
                    a hG4 = a.hG();
                    if (hG4 != null) {
                        hG4.a(this.sM);
                    }
                }
                if (this.sM.hX().responseCode == 200) {
                    if (this.zm <= 0 && this.zv != null) {
                        this.zm = this.zv.hJ();
                    }
                    dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                    this.sM.a(dVar);
                    a hG5 = a.hG();
                    if (hG5 != null) {
                        hG5.a(this.sM);
                        return;
                    }
                    return;
                }
                dVar.zD = String.valueOf(this.sM.hX().responseCode) + "|retryCount:" + i4;
                z = ab(this.sM.hX().responseCode);
                this.sM.a(dVar);
                if (this.zm <= 0 && this.zv != null) {
                    this.zm = this.zv.hJ();
                }
                dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                this.sM.a(dVar);
                a hG6 = a.hG();
                if (hG6 != null) {
                    hG6.a(this.sM);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.zm <= 0 && this.zv != null) {
                    this.zm = this.zv.hJ();
                }
                dVar.zB = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hk().a(this.sM.hW().getUrl(), this.sM.hW().az("Host"), TextUtils.isEmpty(dVar.zD), dVar.zH != null);
                this.sM.a(dVar);
                a hG7 = a.hG();
                if (hG7 != null) {
                    hG7.a(this.sM);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.zv != null) {
            this.zv.hN();
        }
    }

    public boolean hP() {
        if (this.sM == null) {
            return false;
        }
        return this.sM.hX().zT;
    }

    public void hQ() {
        if (this.sM != null) {
            this.sM.hX().zT = true;
        }
    }

    public long hR() {
        if (this.zm > 0) {
            return this.zm;
        }
        if (this.zv == null) {
            return -1L;
        }
        return this.zv.hJ();
    }

    public long hS() {
        if (this.zv == null) {
            return -1L;
        }
        return this.zv.hK();
    }

    public long hL() {
        if (this.zv == null) {
            return -1L;
        }
        return this.zv.hL();
    }

    public long hT() {
        if (this.zv == null) {
            return -1L;
        }
        return this.zv.hI();
    }

    public long hU() {
        if (this.zv == null) {
            return -1L;
        }
        return this.zv.hH();
    }

    public int hV() {
        return this.zw;
    }

    private void ac(int i) {
        try {
            if (this.sM != null && i > 0) {
                this.sM.hW().p("Retry-Count", String.valueOf(i));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }
}
