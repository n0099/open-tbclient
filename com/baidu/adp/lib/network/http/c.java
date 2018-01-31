package com.baidu.adp.lib.network.http;

import android.text.TextUtils;
import com.baidu.adp.R;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.trafficStats.ITrafficStatsNativeManager;
import java.io.FileNotFoundException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import org.apache.http.protocol.HTTP;
/* loaded from: classes.dex */
public class c {
    private e act;
    private b aje;
    private int ajf = 0;
    private long aiV = 0;

    public c(e eVar) {
        this.act = eVar;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET]}, finally: {[INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [172=7, 173=4, 174=4, 175=4, 176=4] */
    public boolean a(String str, h hVar, int i, int i2, int i3, int i4, boolean z, boolean z2) {
        boolean z3;
        int la = i3 <= 0 ? com.baidu.adp.framework.c.b.kW().kZ().la() : i3;
        if (i <= 0) {
            i = com.baidu.adp.framework.c.b.kW().getRetryCount();
        }
        int la2 = i4 <= 0 ? com.baidu.adp.framework.c.b.kW().kX().la() : i4;
        boolean z4 = false;
        this.aje = new b(this.act);
        int i5 = 0;
        while (i5 < i) {
            d dVar = new d();
            try {
                dVar.ajj = i5 + 1;
                this.ajf = i5;
                z3 = this.aje.a(str, hVar, la, la2, z, dVar, z2);
            } catch (FileNotFoundException e) {
                e = e;
                z3 = z4;
            } catch (Exception e2) {
                e = e2;
                z3 = z4;
            }
            try {
                b("downloadfile", dVar);
                return z3;
            } catch (FileNotFoundException e3) {
                e = e3;
                this.act.nc().responseCode = -100;
                dVar.ajm = String.valueOf(this.act.nc().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                this.act.a(dVar);
                com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                this.act.a(dVar);
                a mL = a.mL();
                if (mL != null) {
                    mL.a(this.act);
                }
                i5++;
                z4 = z3;
            } catch (Exception e4) {
                e = e4;
                try {
                    this.act.nc().responseCode = -10;
                    dVar.ajm = String.valueOf(this.act.nc().responseCode) + "|retryCount:" + i5 + "|" + e.getClass() + "|" + e.getMessage();
                    this.act.a(dVar);
                    com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                    this.act.a(dVar);
                    a mL2 = a.mL();
                    if (mL2 != null) {
                        mL2.a(this.act);
                    }
                    i5++;
                    z4 = z3;
                } finally {
                    com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                    this.act.a(dVar);
                    a mL3 = a.mL();
                    if (mL3 != null) {
                        mL3.a(this.act);
                    }
                }
            }
        }
        return z4;
    }

    public boolean a(String str, h hVar, int i, int i2, int i3, boolean z) {
        return a(str, hVar, i, -1, i2, i3, false, z);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [271=7, 272=7, 274=7, 275=14, 276=7, 277=7, 278=7, 279=7] */
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
        for (int i4 = 0; !this.act.nc().ajC && z && i4 < i; i4++) {
            d dVar = new d();
            this.act.a(dVar);
            try {
                try {
                    try {
                        this.ajf = i4;
                        dVar.ajj = i4 + 1;
                        dVar.ajt = 1;
                        this.aje = new b(this.act);
                        this.aje.a(i2, i3, dVar);
                    } catch (SocketException e) {
                        dVar.ajm = String.valueOf(this.act.nc().responseCode) + "|retryCount:" + i4 + "|" + e.getClass() + "|" + e.getMessage();
                        this.act.nc().ajD = -12;
                        if (this.aiV <= 0 && this.aje != null) {
                            this.aiV = this.aje.mO();
                        }
                        dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                        this.act.b(dVar);
                        a mL = a.mL();
                        if (mL != null) {
                            mL.a(this.act);
                        }
                        z = true;
                    } catch (SocketTimeoutException e2) {
                        dVar.ajm = String.valueOf(this.act.nc().responseCode) + "|retryCount:" + i4 + "|" + e2.getClass() + "|" + e2.getMessage();
                        this.act.nc().ajD = -13;
                        if (this.aiV <= 0 && this.aje != null) {
                            this.aiV = this.aje.mO();
                        }
                        dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                        this.act.b(dVar);
                        a mL2 = a.mL();
                        if (mL2 != null) {
                            mL2.a(this.act);
                        }
                        z = true;
                    }
                } catch (IllegalStateException e3) {
                    this.act.nc().ajD = -19;
                    dVar.ajm = "errorCode:" + String.valueOf(-19) + "|" + e3.getClass() + "|" + e3.getMessage() + "|getcontent_illegal_error";
                    if (this.aiV <= 0 && this.aje != null) {
                        this.aiV = this.aje.mO();
                    }
                    dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                    this.act.b(dVar);
                    a mL3 = a.mL();
                    if (mL3 != null) {
                        mL3.a(this.act);
                    }
                } catch (Exception e4) {
                    dVar.ajm = String.valueOf(this.act.nc().responseCode) + "|retryCount:" + i4 + "|" + e4.getClass() + "|" + e4.getMessage();
                    this.act.nc().ajD = -10;
                    BdLog.e(e4.getMessage());
                    if (this.aiV <= 0 && this.aje != null) {
                        this.aiV = this.aje.mO();
                    }
                    dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                    this.act.b(dVar);
                    a mL4 = a.mL();
                    if (mL4 != null) {
                        mL4.a(this.act);
                        return;
                    }
                    return;
                }
                if (this.act.nc().responseCode == 200) {
                    b(null, dVar);
                    this.act.b(dVar);
                    if (this.aiV <= 0 && this.aje != null) {
                        this.aiV = this.aje.mO();
                    }
                    dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                    this.act.b(dVar);
                    a mL5 = a.mL();
                    if (mL5 != null) {
                        mL5.a(this.act);
                        return;
                    }
                    return;
                }
                dVar.ajm = String.valueOf(this.act.nc().responseCode) + "|retryCount:" + i4;
                boolean da = da(this.act.nc().responseCode);
                if (this.aiV <= 0 && this.aje != null) {
                    this.aiV = this.aje.mO();
                }
                dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                this.act.b(dVar);
                a mL6 = a.mL();
                if (mL6 != null) {
                    mL6.a(this.act);
                }
                z = da;
            } catch (Throwable th) {
                if (this.aiV <= 0 && this.aje != null) {
                    this.aiV = this.aje.mO();
                }
                dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                this.act.b(dVar);
                a mL7 = a.mL();
                if (mL7 != null) {
                    mL7.a(this.act);
                }
                throw th;
            }
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, IGET, INVOKE, IF, IGET, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [351=7, 352=7, 354=7, 355=14, 356=7, 357=7, 358=7, 359=7, 361=5] */
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
        for (int i4 = 0; !this.act.nc().ajC && z2 && i4 < i; i4++) {
            d dVar = new d();
            dVar.ajj = i4 + 1;
            this.ajf = i4;
            try {
                try {
                    try {
                        try {
                            this.aje = new b(this.act);
                            this.aje.b(i2, i3, dVar);
                        } catch (UnsupportedOperationException e) {
                            z = false;
                            this.act.nc().ajD = -14;
                            dVar.ajm = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                            this.act.a(dVar);
                            if (this.aiV <= 0 && this.aje != null) {
                                this.aiV = this.aje.mO();
                            }
                            dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                            com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                            this.act.a(dVar);
                            a mL = a.mL();
                            if (mL != null && this.aje != null && this.aje.mR()) {
                                mL.a(this.act);
                            }
                        }
                    } catch (SocketTimeoutException e2) {
                        this.act.nc().ajD = -13;
                        z = true;
                        dVar.ajm = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(e2.getMessage());
                        this.act.a(dVar);
                        if (this.aiV <= 0 && this.aje != null) {
                            this.aiV = this.aje.mO();
                        }
                        dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                        this.act.a(dVar);
                        a mL2 = a.mL();
                        if (mL2 != null && this.aje != null && this.aje.mR()) {
                            mL2.a(this.act);
                        }
                    }
                } catch (SocketException e3) {
                    this.act.nc().ajD = -12;
                    z = true;
                    dVar.ajm = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.act.a(dVar);
                    if (this.aiV <= 0 && this.aje != null) {
                        this.aiV = this.aje.mO();
                    }
                    dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                    this.act.a(dVar);
                    a mL3 = a.mL();
                    if (mL3 != null && this.aje != null && this.aje.mR()) {
                        mL3.a(this.act);
                    }
                } catch (Throwable th) {
                    this.act.nc().ajD = -10;
                    z = false;
                    dVar.ajm = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(th.getMessage());
                    this.act.a(dVar);
                    if (this.aiV <= 0 && this.aje != null) {
                        this.aiV = this.aje.mO();
                    }
                    dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                    this.act.a(dVar);
                    a mL4 = a.mL();
                    if (mL4 != null && this.aje != null && this.aje.mR()) {
                        mL4.a(this.act);
                    }
                }
                if (this.act.nc().responseCode == 200) {
                    b(null, dVar);
                    if (this.aiV <= 0 && this.aje != null) {
                        this.aiV = this.aje.mO();
                    }
                    dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                    this.act.a(dVar);
                    a mL5 = a.mL();
                    if (mL5 == null || this.aje == null || !this.aje.mR()) {
                        return;
                    }
                    mL5.a(this.act);
                    return;
                }
                dVar.ajm = String.valueOf(this.act.nc().responseCode) + "|retryCount:" + i4;
                z = da(this.act.nc().responseCode);
                this.act.a(dVar);
                if (this.aiV <= 0 && this.aje != null) {
                    this.aiV = this.aje.mO();
                }
                dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                this.act.a(dVar);
                a mL6 = a.mL();
                if (mL6 != null && this.aje != null && this.aje.mR()) {
                    mL6.a(this.act);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.aiV <= 0 && this.aje != null) {
                    this.aiV = this.aje.mO();
                }
                dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                this.act.a(dVar);
                a mL7 = a.mL();
                if (mL7 != null && this.aje != null && this.aje.mR()) {
                    mL7.a(this.act);
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
        if (this.act.nb().nf()) {
            n(i, i2, i3);
        } else {
            p(i, i2, i3);
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET, CONST, CMP_L]}, finally: {[IGET, CONST, CMP_L, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IGET, INVOKE, IPUT, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF, IGET, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IGET, INVOKE, IF, INVOKE, IGET, INVOKE, INVOKE, CONST, IF, INVOKE, ARITH, IPUT, INVOKE, IGET, INVOKE, INVOKE, IGET, INVOKE, CONST_STR, INVOKE, IGET, INVOKE, IGET, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [473=7, 474=7, 476=7, 477=14, 478=7, 479=7, 480=7, 481=7, 483=5] */
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
        for (int i4 = 0; !this.act.nc().ajC && z2 && i4 < i; i4++) {
            d dVar = new d();
            this.ajf = i4;
            dVar.ajj = i4 + 1;
            try {
                try {
                    try {
                        this.aje = new b(this.act);
                        this.aje.c(i2, i3, dVar);
                    } catch (UnsupportedOperationException e) {
                        z = false;
                        this.act.nc().ajD = -14;
                        dVar.ajm = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        this.act.a(dVar);
                        if (this.aiV <= 0 && this.aje != null) {
                            this.aiV = this.aje.mO();
                        }
                        dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                        this.act.a(dVar);
                        a mL = a.mL();
                        if (mL != null) {
                            mL.a(this.act);
                        }
                    } catch (Throwable th) {
                        this.act.nc().ajD = -10;
                        z = false;
                        dVar.ajm = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                        BdLog.e(th.getMessage());
                        this.act.a(dVar);
                        if (this.aiV <= 0 && this.aje != null) {
                            this.aiV = this.aje.mO();
                        }
                        dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                        com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                        this.act.a(dVar);
                        a mL2 = a.mL();
                        if (mL2 != null) {
                            mL2.a(this.act);
                        }
                    }
                } catch (SocketException e2) {
                    this.act.nc().ajD = -12;
                    z = true;
                    dVar.ajm = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e2.getMessage());
                    this.act.a(dVar);
                    if (this.aiV <= 0 && this.aje != null) {
                        this.aiV = this.aje.mO();
                    }
                    dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                    this.act.a(dVar);
                    a mL3 = a.mL();
                    if (mL3 != null) {
                        mL3.a(this.act);
                    }
                } catch (SocketTimeoutException e3) {
                    this.act.nc().ajD = -13;
                    z = true;
                    dVar.ajm = BdBaseApplication.getInst().getApp().getApplicationContext().getResources().getString(R.string.neterror);
                    BdLog.e(e3.getMessage());
                    this.act.a(dVar);
                    if (this.aiV <= 0 && this.aje != null) {
                        this.aiV = this.aje.mO();
                    }
                    dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                    this.act.a(dVar);
                    a mL4 = a.mL();
                    if (mL4 != null) {
                        mL4.a(this.act);
                    }
                }
                if (this.act.nc().responseCode == 200) {
                    b(null, dVar);
                    if (this.aiV <= 0 && this.aje != null) {
                        this.aiV = this.aje.mO();
                    }
                    dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                    com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                    this.act.a(dVar);
                    a mL5 = a.mL();
                    if (mL5 != null) {
                        mL5.a(this.act);
                        return;
                    }
                    return;
                }
                dVar.ajm = String.valueOf(this.act.nc().responseCode) + "|retryCount:" + i4;
                z = da(this.act.nc().responseCode);
                this.act.a(dVar);
                if (this.aiV <= 0 && this.aje != null) {
                    this.aiV = this.aje.mO();
                }
                dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                this.act.a(dVar);
                a mL6 = a.mL();
                if (mL6 != null) {
                    mL6.a(this.act);
                }
                z2 = z;
            } catch (Throwable th2) {
                if (this.aiV <= 0 && this.aje != null) {
                    this.aiV = this.aje.mO();
                }
                dVar.ajk = System.currentTimeMillis() - currentTimeMillis;
                com.baidu.adp.lib.a.a.mq().a(this.act.nb().getUrl(), this.act.nb().ap(HTTP.TARGET_HOST), TextUtils.isEmpty(dVar.ajm), dVar.ajq != null);
                this.act.a(dVar);
                a mL7 = a.mL();
                if (mL7 != null) {
                    mL7.a(this.act);
                }
                throw th2;
            }
        }
    }

    public void cancel() {
        if (this.aje != null) {
            this.aje.mS();
        }
    }

    public boolean mU() {
        if (this.act == null) {
            return false;
        }
        return this.act.nc().ajC;
    }

    public void mV() {
        if (this.act != null) {
            this.act.nc().ajC = true;
        }
    }

    public long mW() {
        if (this.aiV > 0) {
            return this.aiV;
        }
        if (this.aje == null) {
            return -1L;
        }
        return this.aje.mO();
    }

    public long mX() {
        if (this.aje == null) {
            return -1L;
        }
        return this.aje.mP();
    }

    public long mQ() {
        if (this.aje == null) {
            return -1L;
        }
        return this.aje.mQ();
    }

    public long mY() {
        if (this.aje == null) {
            return -1L;
        }
        return this.aje.mN();
    }

    public long mZ() {
        if (this.aje == null) {
            return -1L;
        }
        return this.aje.mM();
    }

    public int na() {
        return this.ajf;
    }

    private void b(String str, d dVar) {
        if (ITrafficStatsNativeManager.rH() != null && dVar != null && this.act.nc() != null) {
            String str2 = str == null ? this.act.nc().contentType : str;
            BdLog.i("BdHttpManager2 contentType = " + str2 + "; uploadSize = " + dVar.ajg + "; downloadSize = " + dVar.ajh + "; url=" + dVar.url);
            ITrafficStatsNativeManager.rH().a(str2, dVar.ajg + 54, 54 + dVar.ajh, dVar.url);
        }
    }
}
