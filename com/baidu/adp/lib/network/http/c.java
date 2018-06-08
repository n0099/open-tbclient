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
    private e sW;
    private b zC;
    private int zD = 0;
    private long zt = 0;

    public c(e eVar) {
        this.sW = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int fT = i3 <= 0 ? com.baidu.adp.framework.c.b.fP().fS().fT() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.fP().getRetryCount();
        }
        int fT2 = i4 <= 0 ? com.baidu.adp.framework.c.b.fP().fQ().fT() : i4;
        this.zC = new b(this.sW);
        for (int i5 = 0; i5 < i; i5++) {
            d dVar = new d();
            try {
                dVar.zH = i5 + 1;
                this.zD = i5;
                boolean a = this.zC.a(str, hVar, fT, fT2, z, dVar, z2);
                com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                this.sW.a(dVar);
                a hG = a.hG();
                if (hG != null) {
                    hG.a(this.sW);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.sW.hW().responseCode = -100;
                    dVar.zK = String.valueOf(this.sW.hW().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.sW.a(dVar);
                    com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                    this.sW.a(dVar);
                    a hG2 = a.hG();
                    if (hG2 != null) {
                        hG2.a(this.sW);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                    this.sW.a(dVar);
                    a hG3 = a.hG();
                    if (hG3 != null) {
                        hG3.a(this.sW);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.sW.hW().responseCode = -10;
                dVar.zK = String.valueOf(this.sW.hW().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.sW.a(dVar);
                com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                this.sW.a(dVar);
                a hG4 = a.hG();
                if (hG4 != null) {
                    hG4.a(this.sW);
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
        for (int i4 = 0; !this.sW.hW().Aa && z && i4 < i; i4++) {
            d dVar = new d();
            this.sW.a(dVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.zD = i4;
                                dVar.zH = i4 + 1;
                                dVar.zR = 1;
                                this.zC = new b(this.sW);
                                this.zC.a(i2, i3, dVar);
                            } catch (IllegalStateException e) {
                                this.sW.hW().Ab = -19;
                                dVar.zK = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.zt <= 0 && this.zC != null) {
                                    this.zt = this.zC.hJ();
                                }
                                dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                                this.sW.b(dVar);
                                a hG = a.hG();
                                if (hG != null) {
                                    hG.a(this.sW);
                                }
                            }
                        } catch (Exception e2) {
                            dVar.zK = String.valueOf(this.sW.hW().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.sW.hW().Ab = -10;
                            BdLog.e(e2.getMessage());
                            if (this.zt <= 0 && this.zC != null) {
                                this.zt = this.zC.hJ();
                            }
                            dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                            this.sW.b(dVar);
                            a hG2 = a.hG();
                            if (hG2 != null) {
                                hG2.a(this.sW);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        dVar.zK = String.valueOf(this.sW.hW().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.sW.hW().Ab = -13;
                        if (this.zt <= 0 && this.zC != null) {
                            this.zt = this.zC.hJ();
                        }
                        dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                        this.sW.b(dVar);
                        a hG3 = a.hG();
                        if (hG3 != null) {
                            hG3.a(this.sW);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    dVar.zK = String.valueOf(this.sW.hW().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.sW.hW().Ab = -12;
                    if (this.zt <= 0 && this.zC != null) {
                        this.zt = this.zC.hJ();
                    }
                    dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                    this.sW.b(dVar);
                    a hG4 = a.hG();
                    if (hG4 != null) {
                        hG4.a(this.sW);
                    }
                    z = true;
                }
                if (this.sW.hW().responseCode == 200) {
                    this.sW.b(dVar);
                    if (this.zt <= 0 && this.zC != null) {
                        this.zt = this.zC.hJ();
                    }
                    dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                    this.sW.b(dVar);
                    a hG5 = a.hG();
                    if (hG5 != null) {
                        hG5.a(this.sW);
                        return;
                    }
                    return;
                }
                dVar.zK = String.valueOf(this.sW.hW().responseCode) + "|retryCount:" + i4;
                boolean ab = ab(this.sW.hW().responseCode);
                if (this.zt <= 0 && this.zC != null) {
                    this.zt = this.zC.hJ();
                }
                dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                this.sW.b(dVar);
                a hG6 = a.hG();
                if (hG6 != null) {
                    hG6.a(this.sW);
                }
                z = ab;
            } catch (Throwable th) {
                if (this.zt <= 0 && this.zC != null) {
                    this.zt = this.zC.hJ();
                }
                dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                this.sW.b(dVar);
                a hG7 = a.hG();
                if (hG7 != null) {
                    hG7.a(this.sW);
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
        for (int i4 = 0; !this.sW.hW().Aa && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.zH = i4 + 1;
            this.zD = i4;
            try {
                try {
                    try {
                        this.zC = new b(this.sW);
                        this.zC.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.sW.hW().Ab = -14;
                        dVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.sW.a(dVar);
                        if (this.zt <= 0 && this.zC != null) {
                            this.zt = this.zC.hJ();
                        }
                        dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                        this.sW.a(dVar);
                        a hG = a.hG();
                        if (hG != null && this.zC != null && this.zC.hM()) {
                            hG.a(this.sW);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.sW.hW().Ab = -13;
                        z = true;
                        dVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.sW.a(dVar);
                        if (this.zt <= 0 && this.zC != null) {
                            this.zt = this.zC.hJ();
                        }
                        dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                        this.sW.a(dVar);
                        a hG2 = a.hG();
                        if (hG2 != null && this.zC != null && this.zC.hM()) {
                            hG2.a(this.sW);
                        }
                    }
                } catch (SocketException e3) {
                    this.sW.hW().Ab = -12;
                    z = true;
                    dVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.sW.a(dVar);
                    if (this.zt <= 0 && this.zC != null) {
                        this.zt = this.zC.hJ();
                    }
                    dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                    this.sW.a(dVar);
                    a hG3 = a.hG();
                    if (hG3 != null && this.zC != null && this.zC.hM()) {
                        hG3.a(this.sW);
                    }
                } catch (Throwable th) {
                    this.sW.hW().Ab = -10;
                    z = false;
                    dVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.sW.a(dVar);
                    if (this.zt <= 0 && this.zC != null) {
                        this.zt = this.zC.hJ();
                    }
                    dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                    this.sW.a(dVar);
                    a hG4 = a.hG();
                    if (hG4 != null && this.zC != null && this.zC.hM()) {
                        hG4.a(this.sW);
                    }
                }
                if (this.sW.hW().responseCode == 200) {
                    if (this.zt <= 0 && this.zC != null) {
                        this.zt = this.zC.hJ();
                    }
                    dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                    this.sW.a(dVar);
                    a hG5 = a.hG();
                    if (hG5 == null || this.zC == null || !this.zC.hM()) {
                        return;
                    }
                    hG5.a(this.sW);
                    return;
                }
                dVar.zK = String.valueOf(this.sW.hW().responseCode) + "|retryCount:" + i4;
                z = ab(this.sW.hW().responseCode);
                this.sW.a(dVar);
                if (this.zt <= 0 && this.zC != null) {
                    this.zt = this.zC.hJ();
                }
                dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                this.sW.a(dVar);
                a hG6 = a.hG();
                if (hG6 != null && this.zC != null && this.zC.hM()) {
                    hG6.a(this.sW);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.zt <= 0 && this.zC != null) {
                    this.zt = this.zC.hJ();
                }
                dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                this.sW.a(dVar);
                a hG7 = a.hG();
                if (hG7 != null && this.zC != null && this.zC.hM()) {
                    hG7.a(this.sW);
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
        if (this.sW.hV().hZ()) {
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
        for (int i4 = 0; !this.sW.hW().Aa && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.zD = i4;
            dVar.zH = i4 + 1;
            try {
                try {
                    try {
                        this.zC = new b(this.sW);
                        this.zC.c(i2, i3, dVar);
                    } catch (SocketTimeoutException e) {
                        this.sW.hW().Ab = -13;
                        z = true;
                        dVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.sW.a(dVar);
                        if (this.zt <= 0 && this.zC != null) {
                            this.zt = this.zC.hJ();
                        }
                        dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                        this.sW.a(dVar);
                        a hG = a.hG();
                        if (hG != null) {
                            hG.a(this.sW);
                        }
                    } catch (Throwable th) {
                        this.sW.hW().Ab = -10;
                        z = false;
                        dVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.sW.a(dVar);
                        if (this.zt <= 0 && this.zC != null) {
                            this.zt = this.zC.hJ();
                        }
                        dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                        this.sW.a(dVar);
                        a hG2 = a.hG();
                        if (hG2 != null) {
                            hG2.a(this.sW);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.sW.hW().Ab = -14;
                    dVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.sW.a(dVar);
                    if (this.zt <= 0 && this.zC != null) {
                        this.zt = this.zC.hJ();
                    }
                    dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                    this.sW.a(dVar);
                    a hG3 = a.hG();
                    if (hG3 != null) {
                        hG3.a(this.sW);
                    }
                } catch (SocketException e3) {
                    this.sW.hW().Ab = -12;
                    z = true;
                    dVar.zK = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.sW.a(dVar);
                    if (this.zt <= 0 && this.zC != null) {
                        this.zt = this.zC.hJ();
                    }
                    dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                    this.sW.a(dVar);
                    a hG4 = a.hG();
                    if (hG4 != null) {
                        hG4.a(this.sW);
                    }
                }
                if (this.sW.hW().responseCode == 200) {
                    if (this.zt <= 0 && this.zC != null) {
                        this.zt = this.zC.hJ();
                    }
                    dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                    this.sW.a(dVar);
                    a hG5 = a.hG();
                    if (hG5 != null) {
                        hG5.a(this.sW);
                        return;
                    }
                    return;
                }
                dVar.zK = String.valueOf(this.sW.hW().responseCode) + "|retryCount:" + i4;
                z = ab(this.sW.hW().responseCode);
                this.sW.a(dVar);
                if (this.zt <= 0 && this.zC != null) {
                    this.zt = this.zC.hJ();
                }
                dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                this.sW.a(dVar);
                a hG6 = a.hG();
                if (hG6 != null) {
                    hG6.a(this.sW);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.zt <= 0 && this.zC != null) {
                    this.zt = this.zC.hJ();
                }
                dVar.zI = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.hl().a(this.sW.hV().getUrl(), this.sW.hV().ay("Host"), TextUtils.isEmpty(dVar.zK), dVar.zO != null);
                this.sW.a(dVar);
                a hG7 = a.hG();
                if (hG7 != null) {
                    hG7.a(this.sW);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.zC != null) {
            this.zC.hN();
        }
    }

    public boolean isCancel() {
        if (this.sW == null) {
            return false;
        }
        return this.sW.hW().Aa;
    }

    public void hP() {
        if (this.sW != null) {
            this.sW.hW().Aa = true;
        }
    }

    public long hQ() {
        if (this.zt > 0) {
            return this.zt;
        }
        if (this.zC == null) {
            return -1L;
        }
        return this.zC.hJ();
    }

    public long hR() {
        if (this.zC == null) {
            return -1L;
        }
        return this.zC.hK();
    }

    public long hL() {
        if (this.zC == null) {
            return -1L;
        }
        return this.zC.hL();
    }

    public long hS() {
        if (this.zC == null) {
            return -1L;
        }
        return this.zC.hI();
    }

    public long hT() {
        if (this.zC == null) {
            return -1L;
        }
        return this.zC.hH();
    }

    public int hU() {
        return this.zD;
    }
}
