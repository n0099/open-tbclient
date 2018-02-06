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
    private e acr;
    private b ajd;
    private int aje = 0;
    private long aiU = 0;

    public c(e eVar) {
        this.acr = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [170=7, 171=4, 172=4, 173=4, 174=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        int la = i3 <= 0 ? com.baidu.adp.framework.c.b.kW().kZ().la() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.kW().getRetryCount();
        }
        int la2 = i4 <= 0 ? com.baidu.adp.framework.c.b.kW().kX().la() : i4;
        this.ajd = new b(this.acr);
        for (int i5 = 0; i5 < i; i5++) {
            d dVar = new d();
            try {
                dVar.aji = i5 + 1;
                this.aje = i5;
                boolean a = this.ajd.a(str, hVar, la, la2, z, dVar, z2);
                com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                this.acr.a(dVar);
                a mL = a.mL();
                if (mL != null) {
                    mL.a(this.acr);
                }
                return a;
            } catch (FileNotFoundException e) {
                try {
                    this.acr.nc().responseCode = -100;
                    dVar.ajl = String.valueOf(this.acr.nc().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.acr.a(dVar);
                    com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                    this.acr.a(dVar);
                    a mL2 = a.mL();
                    if (mL2 != null) {
                        mL2.a(this.acr);
                    }
                } catch (Throwable th) {
                    com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                    this.acr.a(dVar);
                    a mL3 = a.mL();
                    if (mL3 != null) {
                        mL3.a(this.acr);
                    }
                    throw th;
                }
            } catch (Exception e2) {
                this.acr.nc().responseCode = -10;
                dVar.ajl = String.valueOf(this.acr.nc().responseCode) + "|retryCount:" + i5 + "|" + e2.getClass() + "|" + e2.getMessage();
                this.acr.a(dVar);
                com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                this.acr.a(dVar);
                a mL4 = a.mL();
                if (mL4 != null) {
                    mL4.a(this.acr);
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
    public void m(int i, int i2, int i3) {
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.kW().kZ().la();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.kW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.kW().kX().la();
        }
        boolean z = true;
        long currentTimeMillis = System.currentTimeMillis();
        for (int i4 = 0; !this.acr.nc().ajB && z && i4 < i; i4++) {
            d dVar = new d();
            this.acr.a(dVar);
            try {
                try {
                    try {
                        try {
                            try {
                                this.aje = i4;
                                dVar.aji = i4 + 1;
                                dVar.ajs = 1;
                                this.ajd = new b(this.acr);
                                this.ajd.a(i2, i3, dVar);
                            } catch (IllegalStateException e) {
                                this.acr.nc().ajC = -19;
                                dVar.ajl = "errorCode:" + String.valueOf(-19) + "|" + e.getClass() + "|" + e.getMessage() + "|getcontent_illegal_error";
                                if (this.aiU <= 0 && this.ajd != null) {
                                    this.aiU = this.ajd.mO();
                                }
                                dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                                com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                                this.acr.b(dVar);
                                a mL = a.mL();
                                if (mL != null) {
                                    mL.a(this.acr);
                                }
                            }
                        } catch (Exception e2) {
                            dVar.ajl = String.valueOf(this.acr.nc().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                            this.acr.nc().ajC = -10;
                            BdLog.e(e2.getMessage());
                            if (this.aiU <= 0 && this.ajd != null) {
                                this.aiU = this.ajd.mO();
                            }
                            dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                            this.acr.b(dVar);
                            a mL2 = a.mL();
                            if (mL2 != null) {
                                mL2.a(this.acr);
                                return;
                            }
                            return;
                        }
                    } catch (SocketTimeoutException e3) {
                        dVar.ajl = String.valueOf(this.acr.nc().responseCode) + "|retryCount:" + i4 + "|" + e3.getClass() + "|" + e3.getMessage();
                        this.acr.nc().ajC = -13;
                        if (this.aiU <= 0 && this.ajd != null) {
                            this.aiU = this.ajd.mO();
                        }
                        dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                        this.acr.b(dVar);
                        a mL3 = a.mL();
                        if (mL3 != null) {
                            mL3.a(this.acr);
                        }
                        z = true;
                    }
                } catch (SocketException e4) {
                    dVar.ajl = String.valueOf(this.acr.nc().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.acr.nc().ajC = -12;
                    if (this.aiU <= 0 && this.ajd != null) {
                        this.aiU = this.ajd.mO();
                    }
                    dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                    this.acr.b(dVar);
                    a mL4 = a.mL();
                    if (mL4 != null) {
                        mL4.a(this.acr);
                    }
                    z = true;
                }
                if (this.acr.nc().responseCode == 200) {
                    this.acr.b(dVar);
                    if (this.aiU <= 0 && this.ajd != null) {
                        this.aiU = this.ajd.mO();
                    }
                    dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                    this.acr.b(dVar);
                    a mL5 = a.mL();
                    if (mL5 != null) {
                        mL5.a(this.acr);
                        return;
                    }
                    return;
                }
                dVar.ajl = String.valueOf(this.acr.nc().responseCode) + "|retryCount:" + i4;
                boolean da = da(this.acr.nc().responseCode);
                if (this.aiU <= 0 && this.ajd != null) {
                    this.aiU = this.ajd.mO();
                }
                dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                this.acr.b(dVar);
                a mL6 = a.mL();
                if (mL6 != null) {
                    mL6.a(this.acr);
                }
                z = da;
            } catch (Throwable th) {
                if (this.aiU <= 0 && this.ajd != null) {
                    this.aiU = this.ajd.mO();
                }
                dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                this.acr.b(dVar);
                a mL7 = a.mL();
                if (mL7 != null) {
                    mL7.a(this.acr);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [346=7, 347=7, 349=7, 350=14, 351=7, 352=7, 353=7, 354=7, 356=5] */
    private void n(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.kW().kZ().la();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.kW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.kW().kX().la();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.acr.nc().ajB && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.aji = i4 + 1;
            this.aje = i4;
            try {
                try {
                    try {
                        this.ajd = new b(this.acr);
                        this.ajd.b(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.acr.nc().ajC = -14;
                        dVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.acr.a(dVar);
                        if (this.aiU <= 0 && this.ajd != null) {
                            this.aiU = this.ajd.mO();
                        }
                        dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                        this.acr.a(dVar);
                        a mL = a.mL();
                        if (mL != null && this.ajd != null && this.ajd.mR()) {
                            mL.a(this.acr);
                        }
                    } catch (SocketTimeoutException e2) {
                        this.acr.nc().ajC = -13;
                        z = true;
                        dVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.acr.a(dVar);
                        if (this.aiU <= 0 && this.ajd != null) {
                            this.aiU = this.ajd.mO();
                        }
                        dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                        this.acr.a(dVar);
                        a mL2 = a.mL();
                        if (mL2 != null && this.ajd != null && this.ajd.mR()) {
                            mL2.a(this.acr);
                        }
                    }
                } catch (SocketException e3) {
                    this.acr.nc().ajC = -12;
                    z = true;
                    dVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.acr.a(dVar);
                    if (this.aiU <= 0 && this.ajd != null) {
                        this.aiU = this.ajd.mO();
                    }
                    dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                    this.acr.a(dVar);
                    a mL3 = a.mL();
                    if (mL3 != null && this.ajd != null && this.ajd.mR()) {
                        mL3.a(this.acr);
                    }
                } catch (Throwable th) {
                    this.acr.nc().ajC = -10;
                    z = false;
                    dVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.acr.a(dVar);
                    if (this.aiU <= 0 && this.ajd != null) {
                        this.aiU = this.ajd.mO();
                    }
                    dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                    this.acr.a(dVar);
                    a mL4 = a.mL();
                    if (mL4 != null && this.ajd != null && this.ajd.mR()) {
                        mL4.a(this.acr);
                    }
                }
                if (this.acr.nc().responseCode == 200) {
                    if (this.aiU <= 0 && this.ajd != null) {
                        this.aiU = this.ajd.mO();
                    }
                    dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                    this.acr.a(dVar);
                    a mL5 = a.mL();
                    if (mL5 == null || this.ajd == null || !this.ajd.mR()) {
                        return;
                    }
                    mL5.a(this.acr);
                    return;
                }
                dVar.ajl = String.valueOf(this.acr.nc().responseCode) + "|retryCount:" + i4;
                z = da(this.acr.nc().responseCode);
                this.acr.a(dVar);
                if (this.aiU <= 0 && this.ajd != null) {
                    this.aiU = this.ajd.mO();
                }
                dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                this.acr.a(dVar);
                a mL6 = a.mL();
                if (mL6 != null && this.ajd != null && this.ajd.mR()) {
                    mL6.a(this.acr);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.aiU <= 0 && this.ajd != null) {
                    this.aiU = this.ajd.mO();
                }
                dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                this.acr.a(dVar);
                a mL7 = a.mL();
                if (mL7 != null && this.ajd != null && this.ajd.mR()) {
                    mL7.a(this.acr);
                }
                throw th2;
            }
        }
    }

    private boolean da(int i) {
        if (i == 202 || i == 201 || i == 205 || i == 304 || i == 305 || i == 408) {
            return true;
        }
        return (i == 502 || i == 503 || i == 504 || i == 404) ? false : true;
    }

    public void o(int i, int i2, int i3) {
        if (this.acr.nb().nf()) {
            n(i, i2, i3);
        } else {
            p(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [467=7, 468=7, 470=7, 471=14, 472=7, 473=7, 474=7, 475=7, 477=5] */
    private void p(int i, int i2, int i3) {
        boolean z;
        if (i2 <= 0) {
            i2 = com.baidu.adp.framework.c.b.kW().kZ().la();
        }
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.kW().getRetryCount();
        }
        if (i3 <= 0) {
            i3 = com.baidu.adp.framework.c.b.kW().kX().la();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = true;
        for (int i4 = 0; !this.acr.nc().ajB && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.aje = i4;
            dVar.aji = i4 + 1;
            try {
                try {
                    try {
                        this.ajd = new b(this.acr);
                        this.ajd.c(i2, i3, dVar);
                    } catch (SocketTimeoutException e) {
                        this.acr.nc().ajC = -13;
                        z = true;
                        dVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e.getMessage());
                        this.acr.a(dVar);
                        if (this.aiU <= 0 && this.ajd != null) {
                            this.aiU = this.ajd.mO();
                        }
                        dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                        this.acr.a(dVar);
                        a mL = a.mL();
                        if (mL != null) {
                            mL.a(this.acr);
                        }
                    } catch (Throwable th) {
                        this.acr.nc().ajC = -10;
                        z = false;
                        dVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.acr.a(dVar);
                        if (this.aiU <= 0 && this.ajd != null) {
                            this.aiU = this.ajd.mO();
                        }
                        dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                        this.acr.a(dVar);
                        a mL2 = a.mL();
                        if (mL2 != null) {
                            mL2.a(this.acr);
                        }
                    }
                } catch (UnsupportedOperationException e2) {
                    z = false;
                    this.acr.nc().ajC = -14;
                    dVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    this.acr.a(dVar);
                    if (this.aiU <= 0 && this.ajd != null) {
                        this.aiU = this.ajd.mO();
                    }
                    dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                    this.acr.a(dVar);
                    a mL3 = a.mL();
                    if (mL3 != null) {
                        mL3.a(this.acr);
                    }
                } catch (SocketException e3) {
                    this.acr.nc().ajC = -12;
                    z = true;
                    dVar.ajl = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.acr.a(dVar);
                    if (this.aiU <= 0 && this.ajd != null) {
                        this.aiU = this.ajd.mO();
                    }
                    dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                    this.acr.a(dVar);
                    a mL4 = a.mL();
                    if (mL4 != null) {
                        mL4.a(this.acr);
                    }
                }
                if (this.acr.nc().responseCode == 200) {
                    if (this.aiU <= 0 && this.ajd != null) {
                        this.aiU = this.ajd.mO();
                    }
                    dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                    this.acr.a(dVar);
                    a mL5 = a.mL();
                    if (mL5 != null) {
                        mL5.a(this.acr);
                        return;
                    }
                    return;
                }
                dVar.ajl = String.valueOf(this.acr.nc().responseCode) + "|retryCount:" + i4;
                z = da(this.acr.nc().responseCode);
                this.acr.a(dVar);
                if (this.aiU <= 0 && this.ajd != null) {
                    this.aiU = this.ajd.mO();
                }
                dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                this.acr.a(dVar);
                a mL6 = a.mL();
                if (mL6 != null) {
                    mL6.a(this.acr);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.aiU <= 0 && this.ajd != null) {
                    this.aiU = this.ajd.mO();
                }
                dVar.ajj = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.acr.nb().getUrl(), this.acr.nb().ap("Host"), TextUtils.isEmpty(dVar.ajl), dVar.ajp != null);
                this.acr.a(dVar);
                a mL7 = a.mL();
                if (mL7 != null) {
                    mL7.a(this.acr);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.ajd != null) {
            this.ajd.mS();
        }
    }

    public boolean mU() {
        if (this.acr == null) {
            return false;
        }
        return this.acr.nc().ajB;
    }

    public void mV() {
        if (this.acr != null) {
            this.acr.nc().ajB = true;
        }
    }

    public long mW() {
        if (this.aiU > 0) {
            return this.aiU;
        }
        if (this.ajd == null) {
            return -1L;
        }
        return this.ajd.mO();
    }

    public long mX() {
        if (this.ajd == null) {
            return -1L;
        }
        return this.ajd.mP();
    }

    public long mQ() {
        if (this.ajd == null) {
            return -1L;
        }
        return this.ajd.mQ();
    }

    public long mY() {
        if (this.ajd == null) {
            return -1L;
        }
        return this.ajd.mN();
    }

    public long mZ() {
        if (this.ajd == null) {
            return -1L;
        }
        return this.ajd.mM();
    }

    public int na() {
        return this.aje;
    }
}
