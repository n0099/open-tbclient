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
    private e sU;
    private b zA;
    private int zB = 0;
    private long zr = 0;

    public c(e eVar) {
        this.sU = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int fT = i3 <= 0 ? com.baidu.adp.framework.c.b.fP().fS().fT() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fP().getRetryCount();
        }
        int fT2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fP().fQ().fT() : i4;
        this.zA = new b(this.sU);
        for (int i5 = 0; i5 < i; i5++) {
            d dVar = new d();
            try {
                dVar.zF = i5 + 1;
                this.zB = i5;
                boolean a = this.zA.a(str, hVar, fT, fT2, z, dVar, z2);
                com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                this.sU.a(dVar);
                a hG = a.hG();
                if (hG != null) {
                    hG.a(this.sU);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.sU.hW().responseCode = -100;
                    dVar.zI = String.valueOf(this.sU.hW().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.sU.a(dVar);
                    com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                    this.sU.a(dVar);
                    a hG2 = a.hG();
                    if (hG2 != null) {
                        hG2.a(this.sU);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                    this.sU.a(dVar);
                    a hG3 = a.hG();
                    if (hG3 != null) {
                        hG3.a(this.sU);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.sU.hW().responseCode = -10;
                dVar.zI = String.valueOf(this.sU.hW().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.sU.a(dVar);
                com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                this.sU.a(dVar);
                a hG4 = a.hG();
                if (hG4 != null) {
                    hG4.a(this.sU);
                }
            }
        }
        return false;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, boolean z) {
        return a(str, hVar, i, -1, i2, i3, false, z);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [267=7, 268=7, 270=7, 271=14, 272=7, 273=7, 274=7, 275=7] */
    public void d(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fP().fS().fT();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fP().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fP().fQ().fT();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.sU.hW().zY && z && i4 < i; i4++) {
            d dVar = new d();
            this.sU.a(dVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.zB = i4;
                                dVar.zF = i4 + 1;
                                dVar.zP = 1;
                                this.zA = new b(this.sU);
                                this.zA.a(i2, i3, dVar);
                            } catch (IllegalStateException e) {
                                this.sU.hW().zZ = -19;
                                dVar.zI = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.zr <= 0 && this.zA != null) {
                                    this.zr = this.zA.hJ();
                                }
                                dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                                this.sU.b(dVar);
                                a hG = a.hG();
                                if (hG != null) {
                                    hG.a(this.sU);
                                }
                            }
                        } catch (Exception e2) {
                            dVar.zI = String.valueOf(this.sU.hW().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.sU.hW().zZ = -10;
                            BdLog.e(e2.getMessage());
                            if (this.zr <= 0 && this.zA != null) {
                                this.zr = this.zA.hJ();
                            }
                            dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                            this.sU.b(dVar);
                            a hG2 = a.hG();
                            if (hG2 != null) {
                                hG2.a(this.sU);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        dVar.zI = String.valueOf(this.sU.hW().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.sU.hW().zZ = -13;
                        if (this.zr <= 0 && this.zA != null) {
                            this.zr = this.zA.hJ();
                        }
                        dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                        this.sU.b(dVar);
                        a hG3 = a.hG();
                        if (hG3 != null) {
                            hG3.a(this.sU);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    dVar.zI = String.valueOf(this.sU.hW().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.sU.hW().zZ = -12;
                    if (this.zr <= 0 && this.zA != null) {
                        this.zr = this.zA.hJ();
                    }
                    dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                    this.sU.b(dVar);
                    a hG4 = a.hG();
                    if (hG4 != null) {
                        hG4.a(this.sU);
                    }
                    z = true;
                }
                if (this.sU.hW().responseCode == 200) {
                    this.sU.b(dVar);
                    if (this.zr <= 0 && this.zA != null) {
                        this.zr = this.zA.hJ();
                    }
                    dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                    this.sU.b(dVar);
                    a hG5 = a.hG();
                    if (hG5 != null) {
                        hG5.a(this.sU);
                        return;
                    }
                    return;
                }
                dVar.zI = String.valueOf(this.sU.hW().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.sU.hW().responseCode);
                if (this.zr <= 0 && this.zA != null) {
                    this.zr = this.zA.hJ();
                }
                dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                this.sU.b(dVar);
                a hG6 = a.hG();
                if (hG6 != null) {
                    hG6.a(this.sU);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.zr <= 0 && this.zA != null) {
                    this.zr = this.zA.hJ();
                }
                dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                this.sU.b(dVar);
                a hG7 = a.hG();
                if (hG7 != null) {
                    hG7.a(this.sU);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [346=7, 347=7, 349=7, 350=14, 351=7, 352=7, 353=7, 354=7, 356=5] */
    private void e(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fP().fS().fT();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fP().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fP().fQ().fT();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.sU.hW().zY && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.zF = i4 + 1;
            this.zB = i4;
            try {
                try {
                    try {
                        this.zA = new b(this.sU);
                        this.zA.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.sU.hW().zZ = -14;
                        dVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.sU.a(dVar);
                        if (this.zr <= 0 && this.zA != null) {
                            this.zr = this.zA.hJ();
                        }
                        dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                        this.sU.a(dVar);
                        a hG = a.hG();
                        if (hG != null && this.zA != null && this.zA.hM()) {
                            hG.a(this.sU);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.sU.hW().zZ = -13;
                        z = true;
                        dVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.sU.a(dVar);
                        if (this.zr <= 0 && this.zA != null) {
                            this.zr = this.zA.hJ();
                        }
                        dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                        this.sU.a(dVar);
                        a hG2 = a.hG();
                        if (hG2 != null && this.zA != null && this.zA.hM()) {
                            hG2.a(this.sU);
                        }
                    }
                } catch (SocketException e3) {
                    this.sU.hW().zZ = -12;
                    z = true;
                    dVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.sU.a(dVar);
                    if (this.zr <= 0 && this.zA != null) {
                        this.zr = this.zA.hJ();
                    }
                    dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                    this.sU.a(dVar);
                    a hG3 = a.hG();
                    if (hG3 != null && this.zA != null && this.zA.hM()) {
                        hG3.a(this.sU);
                    }
                } catch (Throwable th) {
                    this.sU.hW().zZ = -10;
                    z = false;
                    dVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.sU.a(dVar);
                    if (this.zr <= 0 && this.zA != null) {
                        this.zr = this.zA.hJ();
                    }
                    dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                    this.sU.a(dVar);
                    a hG4 = a.hG();
                    if (hG4 != null && this.zA != null && this.zA.hM()) {
                        hG4.a(this.sU);
                    }
                }
                if (this.sU.hW().responseCode == 200) {
                    if (this.zr <= 0 && this.zA != null) {
                        this.zr = this.zA.hJ();
                    }
                    dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                    this.sU.a(dVar);
                    a hG5 = a.hG();
                    if (hG5 == null || this.zA == null || !this.zA.hM()) {
                        return;
                    }
                    hG5.a(this.sU);
                    return;
                }
                dVar.zI = String.valueOf(this.sU.hW().responseCode) + "|retryCount:" + i4;
                z = ab(this.sU.hW().responseCode);
                this.sU.a(dVar);
                if (this.zr <= 0 && this.zA != null) {
                    this.zr = this.zA.hJ();
                }
                dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                this.sU.a(dVar);
                a hG6 = a.hG();
                if (hG6 != null && this.zA != null && this.zA.hM()) {
                    hG6.a(this.sU);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.zr <= 0 && this.zA != null) {
                    this.zr = this.zA.hJ();
                }
                dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                this.sU.a(dVar);
                a hG7 = a.hG();
                if (hG7 != null && this.zA != null && this.zA.hM()) {
                    hG7.a(this.sU);
                }
                throw th2;
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
        if (this.sU.hV().hZ()) {
            e(i, i2, i3);
        } else {
            g(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [467=7, 468=7, 470=7, 471=14, 472=7, 473=7, 474=7, 475=7, 477=5] */
    private void g(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.fP().fS().fT();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fP().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.fP().fQ().fT();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.sU.hW().zY && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.zB = i4;
            dVar.zF = i4 + 1;
            try {
                try {
                    try {
                        this.zA = new b(this.sU);
                        this.zA.c(i2, i3, dVar);
                    } catch (SocketTimeoutException e) {
                        this.sU.hW().zZ = -13;
                        z = true;
                        dVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.sU.a(dVar);
                        if (this.zr <= 0 && this.zA != null) {
                            this.zr = this.zA.hJ();
                        }
                        dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                        this.sU.a(dVar);
                        a hG = a.hG();
                        if (hG != null) {
                            hG.a(this.sU);
                        }
                    } catch (Throwable th) {
                        this.sU.hW().zZ = -10;
                        z = false;
                        dVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.sU.a(dVar);
                        if (this.zr <= 0 && this.zA != null) {
                            this.zr = this.zA.hJ();
                        }
                        dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                        this.sU.a(dVar);
                        a hG2 = a.hG();
                        if (hG2 != null) {
                            hG2.a(this.sU);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.sU.hW().zZ = -14;
                    dVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.sU.a(dVar);
                    if (this.zr <= 0 && this.zA != null) {
                        this.zr = this.zA.hJ();
                    }
                    dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                    this.sU.a(dVar);
                    a hG3 = a.hG();
                    if (hG3 != null) {
                        hG3.a(this.sU);
                    }
                } catch (SocketException e3) {
                    this.sU.hW().zZ = -12;
                    z = true;
                    dVar.zI = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.sU.a(dVar);
                    if (this.zr <= 0 && this.zA != null) {
                        this.zr = this.zA.hJ();
                    }
                    dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                    this.sU.a(dVar);
                    a hG4 = a.hG();
                    if (hG4 != null) {
                        hG4.a(this.sU);
                    }
                }
                if (this.sU.hW().responseCode == 200) {
                    if (this.zr <= 0 && this.zA != null) {
                        this.zr = this.zA.hJ();
                    }
                    dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                    this.sU.a(dVar);
                    a hG5 = a.hG();
                    if (hG5 != null) {
                        hG5.a(this.sU);
                        return;
                    }
                    return;
                }
                dVar.zI = String.valueOf(this.sU.hW().responseCode) + "|retryCount:" + i4;
                z = ab(this.sU.hW().responseCode);
                this.sU.a(dVar);
                if (this.zr <= 0 && this.zA != null) {
                    this.zr = this.zA.hJ();
                }
                dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                this.sU.a(dVar);
                a hG6 = a.hG();
                if (hG6 != null) {
                    hG6.a(this.sU);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.zr <= 0 && this.zA != null) {
                    this.zr = this.zA.hJ();
                }
                dVar.zG = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.sU.hV().getUrl(), this.sU.hV().ay("Host"), TextUtils.isEmpty(dVar.zI), dVar.zM != null);
                this.sU.a(dVar);
                a hG7 = a.hG();
                if (hG7 != null) {
                    hG7.a(this.sU);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.zA != null) {
            this.zA.hN();
        }
    }

    public boolean isCancel() {
        if (this.sU == null) {
            return false;
        }
        return this.sU.hW().zY;
    }

    public void hP() {
        if (this.sU != null) {
            this.sU.hW().zY = true;
        }
    }

    public long hQ() {
        if (this.zr > 0) {
            return this.zr;
        }
        if (this.zA == null) {
            return -1L;
        }
        return this.zA.hJ();
    }

    public long hR() {
        if (this.zA == null) {
            return -1L;
        }
        return this.zA.hK();
    }

    public long hL() {
        if (this.zA == null) {
            return -1L;
        }
        return this.zA.hL();
    }

    public long hS() {
        if (this.zA == null) {
            return -1L;
        }
        return this.zA.hI();
    }

    public long hT() {
        if (this.zA == null) {
            return -1L;
        }
        return this.zA.hH();
    }

    public int hU() {
        return this.zB;
    }
}
